package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.DataInput;
import java.io.IOException;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;

@Repository
public class BoyaChicaRepository {

    @Value("${boyaschicas.api.url}")
    private String url;
    @Value("${boyaschicas.api.pathBase}")
    private String pathBase;
    @Value("${boyaschicas.api.usuario}")
    private String usuario;
    @Value("${boyaschicas.api.password}")
    private String password;

    public BoyaChica getBoyaChica(String project, int idBoya) throws JsonProcessingException {
        WebClient client = WebClient.create(url);
        String jsonBoyaChica = client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario).queryParam("key", password)
                .queryParam("project", project).queryParam("station", idBoya)
                .queryParam("dataOnly").queryParam("tz","local").build()).retrieve().bodyToMono(String.class).block();
        ObjectMapper mapper = JsonMapper.builder().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).build();
        return mapper.readValue(jsonBoyaChica, BoyaChica.class);
    }

    public Mono<String> getBoyaChicaMono(String project, int idBoya)  {
        WebClient client = WebClient.create(url);
        return client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario).queryParam("key", password)
                .queryParam("project", project).queryParam("station", idBoya)
                .queryParam("dataOnly").queryParam("tz", "local").build()).retrieve().bodyToMono(String.class);
    }

    public Registro getBoyaChicaFilteredData(String project, int idBoya, String fecha_inicio, String fecha_fin) throws JsonProcessingException {
        WebClient client = WebClient.create(url);
        String initDate = fecha_inicio+"T00:00:00";
        String endDate = fecha_fin+"T00:00:00";
        String jsonProyecto = client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario)
                .queryParam("key", password)
                .queryParam("project", project)
                .queryParam("station", idBoya)
                .queryParam("dataonly")
                .queryParam("from", initDate)
                .queryParam("to", endDate)
                .queryParam("tz", "local")
                .build()
        ).retrieve().bodyToMono(String.class).block();
        //ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapper = JsonMapper.builder().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).build();
        BoyaChicaRegistro[] listaRegistros = objectMapper.readValue(jsonProyecto, BoyaChicaRegistro[].class);
        return new Registro(listaRegistros);

      //return null;
    }

}
