package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller.boyachica;


import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.BoyaChicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

@RestController
@RequestMapping("/apiboyachica")
public class BoyaChicaController {

    private BoyaChicaService boyaChicaService;

    @Autowired
    public BoyaChicaController(BoyaChicaService boyaChicaService ){
        this.boyaChicaService = boyaChicaService;
    }


    @GetMapping("/boyachica/kml")
    public ResponseEntity<String> boyasChicasKml() throws JsonProcessingException {
        return new ResponseEntity<>(this.boyaChicaService.obtenerKmlBoyasChicas(), HttpStatus.OK);
    }

    @GetMapping("/boyachica/csv")
    public ResponseEntity<String> boyasChicasCSV() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boyasChicas.csv" );
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(
                this.boyaChicaService.obtenerCsvBoyasChicas().toString().trim(),
                headers,
                HttpStatus.OK
        );
    }


}
