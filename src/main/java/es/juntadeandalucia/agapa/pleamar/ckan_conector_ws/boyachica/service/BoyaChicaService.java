package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository.BoyaChicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BoyaChicaService {

    private final BoyaChicaRepository boyaChicaRepository;

    @Autowired
    public BoyaChicaService(BoyaChicaRepository boyaChicaRepository) {
        this.boyaChicaRepository = boyaChicaRepository;
    }


    public BoyaChica getBoya(String codigoProyecto, int idBoya, String name) throws JsonProcessingException {
        BoyaChica boyaChica = this.boyaChicaRepository.getBoyaChica(codigoProyecto, idBoya);
        boyaChica.setName(name);
        return boyaChica;
    }

    public Mono<String> getBoyaMono(String codigoProyecto, int idBoya)  {

            return this.boyaChicaRepository.getBoyaChicaMono(codigoProyecto, idBoya);
    }

}
