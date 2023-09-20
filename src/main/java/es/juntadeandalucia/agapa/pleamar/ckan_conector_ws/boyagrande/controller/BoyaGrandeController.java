package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.controller;


import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrande;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrandeTracks;
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

    private final BoyaGrandeService boyaGrandeService;

    @Autowired
    public BoyaGrandeController(BoyaGrandeService boyaGrandeService) {
        this.boyaGrandeService = boyaGrandeService;
    }


    @GetMapping("/boya/{idBoya}/ultimoTrack")
    public ResponseEntity<BoyaGrande> getBoyaUltimoTrack(@PathVariable long idBoya) throws IOException {
        return new ResponseEntity<>(this.boyaGrandeService.getBoyaUltimoTrack(idBoya), HttpStatus.OK);
    }

    @GetMapping("/boya/{idBoya}/tracks")
    public ResponseEntity<BoyaGrandeTracks> getBoyaTracks(@PathVariable long idBoya) throws IOException {
        return new ResponseEntity<>(this.boyaGrandeService.getBoyaTracks(idBoya), HttpStatus.OK);
    }

    @GetMapping("/kml")
    public ResponseEntity<String> getKml() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=estacionOceanografica.kml");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/vnd.google-earth.kml+xml");
        return new ResponseEntity<>(this.boyaGrandeService.getKml(), headers, HttpStatus.OK);
    }


}
