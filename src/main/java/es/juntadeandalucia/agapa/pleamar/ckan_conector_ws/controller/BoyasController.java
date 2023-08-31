package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.BoyaChicaService;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.BoyasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boyas")
public class BoyasController {
    BoyasService boyasService;

    BoyaChicaService boyaChicaService;

    @Value("${prueba}")
    private String pruebaConfiguracion;
    @Autowired
    public BoyasController(BoyasService boyasService,BoyaChicaService boyaChicaService) {
        this.boyasService = boyasService;
        this.boyaChicaService = boyaChicaService;
    }

    @GetMapping("/holaMundo")
    public ResponseEntity<String> holaMundo( ) throws JsonProcessingException {
        return new ResponseEntity<>("holaMundo"+ this.pruebaConfiguracion, HttpStatus.OK);
    }

    @GetMapping("/holaMundoClienteWebFlux")
    public ResponseEntity<String> holaMundoClienteWebFlux( ){
        return new ResponseEntity<>( this.boyasService.getHolaMundo()+"cliente web flux", HttpStatus.OK);
    }
}
