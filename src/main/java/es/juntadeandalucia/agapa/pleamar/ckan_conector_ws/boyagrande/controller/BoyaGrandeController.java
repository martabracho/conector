package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.controller;


import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrande;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrandeTracks;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.service.BoyaGrandeService;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.exception.CkanConectorWsErrorException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.exception.CkanConectorWsValidacionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/apiboyagrande")
public class BoyaGrandeController {

    Logger logger = LoggerFactory.getLogger(BoyaGrandeController.class);

    private final BoyaGrandeService boyaGrandeService;

    @Autowired
    public BoyaGrandeController(BoyaGrandeService boyaGrandeService) {
        this.boyaGrandeService = boyaGrandeService;
    }


    @GetMapping("/boya/{idBoya}/ultimoTrack")
    public ResponseEntity<BoyaGrande> getBoyaUltimoTrack(@PathVariable long idBoya) {
        return new ResponseEntity<>(this.boyaGrandeService.getBoyaUltimoTrack(idBoya), HttpStatus.OK);
    }

    @GetMapping("/ultimoTrack")
    public ResponseEntity<List<BoyaGrande>> getUltimoTrack() {
        return new ResponseEntity<>(this.boyaGrandeService.getUltimoTrack(), HttpStatus.OK);
    }

    @GetMapping("/boya/{idBoya}/tracks")
    public ResponseEntity<BoyaGrandeTracks> getBoyaTracks(@PathVariable long idBoya) {
        return new ResponseEntity<>(this.boyaGrandeService.getBoyaTracks(idBoya), HttpStatus.OK);
    }

    @GetMapping("/boya/{idBoya}/tracks/{fechaInicio}/{fechaFin}")
    public ResponseEntity<BoyaGrandeTracks> getBoyaFilterDates(@PathVariable long idBoya, @PathVariable String fechaInicio, @PathVariable String fechaFin){
        fechaInicio = fechaInicio.replace("%20", " ");
        fechaFin = fechaFin.replace("%20", " ");
        return new ResponseEntity<>(this.boyaGrandeService.getBoyaFilterDates(idBoya,fechaInicio,fechaFin), HttpStatus.OK);
    }

    @GetMapping("/kml")
    public ResponseEntity<String> getKml() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=estacionOceanografica.kml");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/vnd.google-earth.kml+xml");
        return new ResponseEntity<>(this.boyaGrandeService.getKml(), headers, HttpStatus.OK);
    }

    @GetMapping("/hola")
    public ResponseEntity<String> getHola() {
        Set<String> mensajesValidacion = new HashSet();
        mensajesValidacion.add("mensaje validacion uno");
        mensajesValidacion.add("mensaje validacion dos");
       throw new CkanConectorWsValidacionException(mensajesValidacion);
       //throw new CkanConectorWsErrorException("Creada la excepcion de tipo error");
        //throw new RuntimeException("Creada la excepcion de tipo runtime");
    }


}
