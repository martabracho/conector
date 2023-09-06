package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica.BoyaChicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BoyaChicaService {

    private BoyaChicaRepository boyaChicaRepository;

    private KmlService kmlService;

    @Autowired
    public BoyaChicaService (BoyaChicaRepository boyaChicaRepository, KmlService kmlService){
        this.boyaChicaRepository = boyaChicaRepository;
        this.kmlService = kmlService;
    }
    public String obtenerKmlBoyaChica(String project, int id) throws JsonProcessingException {
        List<BoyaChica> boyasChicas = boyaChicaRepository.getBoyaChica(project,id);
        return this.kmlService.convertirGenerarKML(boyasChicas);
    }
}