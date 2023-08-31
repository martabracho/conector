package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Repository
public class BoyaChicaRepository {

    public Optional<BoyaChica> getBoyaChica(String project, int id) throws JsonProcessingException {
        Optional<BoyaChica> boyaChica = null;
        WebClient client = WebClient.create("https://obscape.com");
        String jsonBoyaChica = client.get().uri("https://obscape.com/portal/api/v3/api?username=reolaagapa&key=uxLiHTj1cC3WdAtjXIE5NJA62Y8WOd6iKQAsJTtWwwSK8m456H&project=AgapaAguadulce&id=4854").retrieve().bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();
        BoyaChica []  boyaChicas = objectMapper.readValue(jsonBoyaChica,BoyaChica[].class );
        if (boyaChicas!= null && boyaChicas.length>1){
            throw new RuntimeException("obscape ha devuelto más de una boya chica");
        }else if (boyaChicas == null){
            boyaChica = Optional.empty();
        }else{
            boyaChica = Optional.of(boyaChicas[0]);
        }
        return boyaChica;
    }
}
