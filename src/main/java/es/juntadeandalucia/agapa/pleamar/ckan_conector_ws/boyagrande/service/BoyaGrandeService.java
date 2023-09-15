package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrande;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.repository.BoyaGrandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoyaGrandeService {

    private BoyaGrandeRepository boyaGrandeRepository;

    @Autowired
    public BoyaGrandeService(BoyaGrandeRepository boyaGrandeRepository){this.boyaGrandeRepository = boyaGrandeRepository;}
    public String getToken() throws JsonProcessingException {
        return this.boyaGrandeRepository.getToken();
    }


    public BoyaGrande getBoya(long idBoya) throws JsonProcessingException {
        String token = this.boyaGrandeRepository.getToken();
        return this.boyaGrandeRepository.getBoya(token,idBoya);
    }
}
