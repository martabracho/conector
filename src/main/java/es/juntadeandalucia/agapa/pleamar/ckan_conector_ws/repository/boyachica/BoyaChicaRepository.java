package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BoyaChicaRepository {

    public List<BoyaChica> getBoyaChica(String project, int id) throws JsonProcessingException {
        List<BoyaChica> boyaChica = null;
        WebClient client = WebClient.create("https://obscape.com");
        String jsonBoyaChica = client.get().uri( uriBuilder -> uriBuilder.path("/portal/api/v3/api")
                                                    .queryParam("username", "reolaagapa")
                                                    .queryParam("key", "uxLiHTj1cC3WdAtjXIE5NJA62Y8WOd6iKQAsJTtWwwSK8m456H")
                                                    .queryParam("project",project)
                        .build()

                                                ).retrieve().bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();
        BoyaChica []  boyaChicas = objectMapper.readValue(jsonBoyaChica,BoyaChica[].class );
        List<BoyaChica> listaBoyasChicas = Arrays.asList(boyaChicas);
        return listaBoyasChicas;
    }
}
