package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller.boyachica.ProyectoController;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChicaItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica.BoyaChicaRepository;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
@Component
public class BoyaChicaService {

    private ProyectoService proyectoService;
    private BoyaChicaRepository boyaChicaRepository;

    private KmlService kmlService;

    @Autowired
    public BoyaChicaService (BoyaChicaRepository boyaChicaRepository, KmlService kmlService, ProyectoService proyectoService ){
        this.boyaChicaRepository = boyaChicaRepository;
        this.kmlService = kmlService;
        this.proyectoService = proyectoService;
    }
    public String obtenerKmlBoyaChica(String project, int id) throws JsonProcessingException {
        //List<Proyecto> boyasChicas = boyaChicaRepository.getBoyaChica(project,id);
        return this.kmlService.convertirGenerarKML(null);
    }


    public BoyaChica getBoya(String codigoProyecto, int idBoya) throws JsonProcessingException {
        return this.boyaChicaRepository.getBoyaChica(codigoProyecto,idBoya);
    }

    public String obtenerKmlBoyasChicas() throws JsonProcessingException {
        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        List<ProyectoItem> proyectosItem = this.proyectoService.getProyectosItem();

            for (ProyectoItem proyectoItem: proyectosItem){
                Proyecto proyecto  = this.proyectoService.getProyecto(proyectoItem.getName());
                for(BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()){
                    kml.append("<Placemark>\n");
                    //     kml.append("<description> Significant wave height (m): " + hm0
                    //             + "<br/> Sea surface temperature (deg C): " + sst + "<br/> Time: " + tstr + "</description>\n");
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
        String[] HEADERS = { "Latitud", "Longitud"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();

        List<ProyectoItem> proyectosItem = this.proyectoService.getProyectosItem();

        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            for (ProyectoItem proyectoItem : proyectosItem) {
                Proyecto proyecto = this.proyectoService.getProyecto(proyectoItem.getName());
                for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {

                    try {
                        printer.printRecord(boyaChicaItem.getLatitude(), boyaChicaItem.getLongitude());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sw;

    }
}
