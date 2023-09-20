package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChicaItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChicaRegistro;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository.ProyectoRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Component
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    private final BoyaChicaService boyaChicaService;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, BoyaChicaService boyaChicaService) {
        this.proyectoRepository = proyectoRepository;
        this.boyaChicaService = boyaChicaService;
    }

    public List<ProyectoItem> getProyectosItem() throws JsonProcessingException {
        return this.proyectoRepository.getProyectosItem();
    }

    public Proyecto getProyecto(String codigoProyecto) throws JsonProcessingException {
        return this.proyectoRepository.getProyecto(codigoProyecto);
    }


    public String obtenerKmlBoyasChicas() throws JsonProcessingException {
        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        List<ProyectoItem> proyectosItem = this.getProyectosItem();

        for (ProyectoItem proyectoItem : proyectosItem) {
            Proyecto proyecto = this.getProyecto(proyectoItem.getName());
            for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                BoyaChica boyaChica = this.boyaChicaService.getBoya(proyectoItem.getName(),boyaChicaItem.getId());
                kml.append("<Placemark>\n");
                kml.append("<name>").append(boyaChicaItem.getName()).append("</name>");
                if (boyaChica.getData().length>0) {
                    kml.append("<description>");
                    BoyaChicaRegistro registro = boyaChica.getData()[0];
                    kml.append(" Hm0:");
                    kml.append(registro.getHm0());
                    kml.append(" time: ");
                    kml.append(registro.getTime());
                    kml.append("</description>");
                }
                kml.append("<Point>\n");
                kml.append("<coordinates>" + boyaChicaItem.getLongitude() + "," + boyaChicaItem.getLatitude() + "</coordinates>\n");
                kml.append("</Point>\n");
                kml.append("</Placemark>");
            }
        }
        kml.append("</Document>\n");
        kml.append("</kml>\n");
        return kml.toString();
    }

    public StringWriter obtenerCsvBoyasChicas() throws JsonProcessingException {

        StringWriter sw = new StringWriter();
        String[] HEADERS = {"Latitud", "Longitud"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();

        List<ProyectoItem> proyectosItem = this.getProyectosItem();

        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            for (ProyectoItem proyectoItem : proyectosItem) {
                Proyecto proyecto = this.getProyecto(proyectoItem.getName());
                for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                        printer.printRecord(boyaChicaItem.getLatitude(), boyaChicaItem.getLongitude());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sw;
    }
}
