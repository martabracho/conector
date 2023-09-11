package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller.boyachica.ProyectoController;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.*;
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
}
