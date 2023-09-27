package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.controller;


import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service.BoyaChicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/apiboyachica")
public class BoyaChicaController {

    private final BoyaChicaService boyaChicaService;

    @Autowired
    public BoyaChicaController(BoyaChicaService boyaChicaService) {
        this.boyaChicaService = boyaChicaService;
    }

    @GetMapping("/proyecto/{codigoProyecto}/boyachica/{idBoya}")
    public ResponseEntity<BoyaChica> boyasChicasCSV(@PathVariable String codigoProyecto, @PathVariable int idBoya) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>(this.boyaChicaService.getBoya(codigoProyecto, idBoya, String.valueOf(idBoya)), headers, HttpStatus.OK);
    }

}
