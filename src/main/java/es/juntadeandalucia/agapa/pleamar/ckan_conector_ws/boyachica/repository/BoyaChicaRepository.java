package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class    BoyaChicaRepository {

    @Value("${boyaschicas.api.url}")
    private String url;
    @Value("${boyaschicas.api.pathBase}")
    private String pathBase;
    @Value("${boyaschicas.api.usuario}")
    private String usuario;
    @Value("${boyaschicas.api.password}")
    private String password;

    public BoyaChica    getBoyaChica(String project, int idBoya) throws JsonProcessingException {
        WebClient client = WebClient.create(url);
        String jsonBoyaChica = client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario)
                .queryParam("key", password)
                .queryParam("project", project)
                .queryParam("station",idBoya)
                .queryParam("dataOnly")
                .build()
        ).retrieve().bodyToMono(String.class).block();
        ObjectMapper mapper = JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .build();
        return mapper.readValue(jsonBoyaChica, BoyaChica.class);
    }


}
