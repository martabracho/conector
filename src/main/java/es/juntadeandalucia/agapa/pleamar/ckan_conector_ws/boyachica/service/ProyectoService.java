package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProyectoService {

    public static final String AGAPA_MANCADIZ = "AgapaMancadiz";
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
        Proyecto proyecto = this.getProyecto(AGAPA_MANCADIZ);

            Flux fluxBoyaChica = Flux.fromIterable(Arrays.stream(proyecto.getBoyaChicaItem()).toList())
                    .flatMap(boyaChicaItemFlux -> {
                            return this.boyaChicaService.getBoyaMono(AGAPA_MANCADIZ,boyaChicaItemFlux.getId(),boyaChicaItemFlux.getName());
                        });
        Mono listaCollect = fluxBoyaChica.collectList();
        List<String> listaMono = (List<String>) listaCollect.block();
        ObjectMapper mapper = JsonMapper.builder().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).build();
        for (String jsonBoyaChica : listaMono) {
            //metodo a paralelizarBoyaChica boyaChica = this.boyaChicaService.getBoya(AGAPA_MANCADIZ,boyaChicaItem.getId(),boyaChicaItem.getName());
            BoyaChica boyaChica = mapper.readValue(jsonBoyaChica, BoyaChica.class);
            if (boyaChica.getData().length>0) {
                kml.append("<Placemark>\n");
                kml.append("<name>").append(boyaChica.getName()).append("</name>");

                kml.append(boyaChica.getData()[0].toStringFormatoKML());

                kml.append("<Point>\n");
                kml.append("<coordinates>" + boyaChica.getData()[0].getLon() + "," + boyaChica.getData()[0].getLat() + "</coordinates>\n");
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

    public List<BoyaChica> obtenerJsonBoyasChicas() throws JsonProcessingException {

        List<BoyaChica> listaBoyaChica = new ArrayList<>();
        for (ProyectoItem proyectoItem : this.getProyectosItem()) {
            Proyecto proyecto = this.getProyecto(proyectoItem.getName());
            for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                listaBoyaChica.add(this.boyaChicaService.getBoya(proyectoItem.getName(),boyaChicaItem.getId(), boyaChicaItem.getName()));
            }
        }
        return listaBoyaChica;
    }

    public List<BoyaChica> obtenerJsonBoyasChicas(String codigoProyecto) throws JsonProcessingException {
        List<BoyaChica> listaBoyaChica = new ArrayList<>();
        Proyecto proyecto = this.getProyecto(codigoProyecto);
            for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                listaBoyaChica.add(this.boyaChicaService.getBoya(codigoProyecto,boyaChicaItem.getId(), boyaChicaItem.getName()));
            }
        return listaBoyaChica;
    }
}
