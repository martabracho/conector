package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller.boyachica;


import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.BoyaChicaService;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    private ProyectoService proyectoService;
    private BoyaChicaService boyaChicaService;

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
    public ResponseEntity<BoyaChica> getProyecto(@PathVariable String codigoProyecto,@PathVariable int idBoya) throws JsonProcessingException {
        return new ResponseEntity<>(this.boyaChicaService.getBoya(codigoProyecto,idBoya), HttpStatus.OK);
    }
}
