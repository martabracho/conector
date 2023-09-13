package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service.BoyaChicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
    @RequestMapping("/apiboyachica")
public class BoyaChicaController {

    private BoyaChicaService boyaChicaService;

    @Autowired
    public BoyaChicaController(BoyaChicaService boyaChicaService ){
        this.boyaChicaService = boyaChicaService;
    }

    @GetMapping("/proyecto/{codigoProyecto}/boyachica/{idBoya}/csv")
    public ResponseEntity<String> boyasChicasCSV(@PathVariable String codigoProyecto,@PathVariable int idBoya) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boyachica.csv" );
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(
                this.boyaChicaService.obtenerCsvBoyaChica(codigoProyecto,idBoya).toString().trim(),
                headers,
                HttpStatus.OK
        );
    }

    @GetMapping("/proyecto/{codigoProyecto}/boyachica/{idBoya}/kml")
    public ResponseEntity<String> boyasChicasKml(@PathVariable String codigoProyecto,@PathVariable int idBoya) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boyas.kml" );
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "application/vnd.google-earth.kml+xml");

        return new ResponseEntity<>(
                this.boyaChicaService.obtenerKmlBoyasChicas(codigoProyecto,idBoya),
                headers,
                HttpStatus.OK);
    }

}
