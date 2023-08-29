package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller;

import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.BoyasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boyas")
public class BoyasController {
    BoyasService boyasService;

    @Autowired
    public BoyasController(BoyasService boyasService) {
        this.boyasService = boyasService;
    }

    @GetMapping("/holaMundo")
    public ResponseEntity<String> holaMundo( ){
        return new ResponseEntity<>("holaMundo", HttpStatus.OK);
    }

    @GetMapping("/holaMundoClienteWebFlux")
    public ResponseEntity<String> holaMundoClienteWebFlux( ){
        return new ResponseEntity<>( this.boyasService.getHolaMundo()+"cliente web flux", HttpStatus.OK);
    }
}
