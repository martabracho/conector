package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service.BoyaChicaService;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.service.BoyaGrandeService;
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
    @RequestMapping("/apiboyagrande")
public class BoyaGrandeController {

    private BoyaGrandeService boyaGrandeService;

    @Autowired
    public BoyaGrandeController(BoyaGrandeService boyaGrandeService ){
        this.boyaGrandeService = boyaGrandeService;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() throws IOException {
        return new ResponseEntity<>(this.boyaGrandeService.getToken().toString(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsuarios() throws IOException {
        return new ResponseEntity<>(this.boyaGrandeService.getUsuarios().toString(), HttpStatus.OK);
    }

}