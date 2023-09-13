package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChicaRegistro;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.*;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository.BoyaChicaRepository;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.csv.CSVFormat;
@Component
public class BoyaChicaService {

    private ProyectoService proyectoService;
    private BoyaChicaRepository boyaChicaRepository;



    @Autowired
    public BoyaChicaService (BoyaChicaRepository boyaChicaRepository, ProyectoService proyectoService ){
        this.boyaChicaRepository = boyaChicaRepository;
        this.proyectoService = proyectoService;
    }


    public BoyaChica getBoya(String codigoProyecto, int idBoya) throws JsonProcessingException {
        return this.boyaChicaRepository.getBoyaChica(codigoProyecto,idBoya);
    }


    public StringWriter obtenerCsvBoyaChica(String codigoProyecto, int idBoya) throws IOException {
        BoyaChica boyaChica = this.boyaChicaRepository.getBoyaChica(codigoProyecto,idBoya);
        StringWriter sw = new StringWriter();
        String[] HEADERS = { "Hm0", "Time"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();


        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            for (BoyaChicaRegistro boyaChicaRegistro : boyaChica.getData()) {

                    try {
                        printer.printRecord(boyaChicaRegistro.getHm0(),boyaChicaRegistro.getTime());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sw;

    }

    public String obtenerKmlBoyasChicas(String codigoProyecto, int idBoya) throws JsonProcessingException {

        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        kml.append("<Placemark>\n");

        kml.append("<Point>\n");
        kml.append("<coordinates>-6.42484,36.68705,0</coordinates>\n");
        kml.append("</Point>\n");


        kml.append("</Placemark>");

        kml.append("</Document>\n");
        kml.append("</kml>\n");
        return kml.toString();


                //     kml.append("<description> Significant wave height (m): " + hm0
                //             + "<br/> Sea surface temperature (deg C): " + sst + "<br/> Time: " + tstr + "</description>\n");


        }



}
