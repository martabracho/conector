package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica.BoyaChicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoyaChicaService {

    private BoyaChicaRepository boyaChicaRepository;

    @Autowired
    public BoyaChicaService (BoyaChicaRepository boyaChicaRepository){
        this.boyaChicaRepository = boyaChicaRepository;
    }
    public String obtenerKmlBoyaChica(String project, int id) throws JsonProcessingException {
        return boyaChicaRepository.getBoyaChica(project,id).get().toString();
    }
}
