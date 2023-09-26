package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service.BoyaChicaService;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiboyachica/proyecto")
public class ProyectoController {

    private final ProyectoService proyectoService;
    private final BoyaChicaService boyaChicaService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService, BoyaChicaService boyaChicaService) {
        this.proyectoService = proyectoService;
        this.boyaChicaService = boyaChicaService;
    }

    @GetMapping("/item")
    public ResponseEntity<List<ProyectoItem>> getProyectos() throws JsonProcessingException {
        return new ResponseEntity<>(this.proyectoService.getProyectosItem(), HttpStatus.OK);
    }

    @GetMapping("/{codigoProyecto}")
    public ResponseEntity<String> getProyecto(@PathVariable String codigoProyecto) throws JsonProcessingException {
        return new ResponseEntity<>(this.proyectoService.getProyecto(codigoProyecto).toString(), HttpStatus.OK);
    }

    @GetMapping("/{codigoProyecto}/{idBoya}")
    public ResponseEntity<BoyaChica> getProyecto(@PathVariable String codigoProyecto, @PathVariable int idBoya) throws JsonProcessingException {
        return new ResponseEntity<>(this.boyaChicaService.getBoya(codigoProyecto, idBoya,""), HttpStatus.OK);
    }

    @GetMapping("/kml")
    public ResponseEntity<String> boyasChicasKml() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boyas.kml");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/vnd.google-earth.kml+xml");
        return new ResponseEntity<>(this.proyectoService.obtenerKmlBoyasChicas(), headers, HttpStatus.OK);
    }

    @GetMapping("/json")
    public ResponseEntity<List<BoyaChica>> boyasChicasJSON() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>(this.proyectoService.obtenerJsonBoyasChicas(), headers, HttpStatus.OK);
    }
    @GetMapping("/{codigoProyecto}/json")
    public ResponseEntity<List<BoyaChica>> boyasChicasProyectoJSON(@PathVariable String codigoProyecto) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>(this.proyectoService.obtenerJsonBoyasChicas(codigoProyecto), headers, HttpStatus.OK);
    }

}
