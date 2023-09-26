package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChicaItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.ProyectoItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProyectoRepository {

    @Value("${boyaschicas.api.url}")
    private String url;
    @Value("${boyaschicas.api.pathBase}")
    private String pathBase;
    @Value("${boyaschicas.api.usuario}")
    private String usuario;
    @Value("${boyaschicas.api.password}")
    private String password;

    public List<ProyectoItem> getProyectosItem() throws JsonProcessingException {

        WebClient client = WebClient.create(url);
        String jsonProyectosItem = client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario)
                .queryParam("key", password)
                .build()
        ).retrieve().bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();
        ProyectoItem[] proyectosItem = objectMapper.readValue(jsonProyectosItem, ProyectoItem[].class);
        return Arrays.asList(proyectosItem);
    }


    public Proyecto getProyecto(String codigoProyecto) throws JsonProcessingException {
        WebClient client = WebClient.create(url);
        String jsonProyecto = client.get().uri(uriBuilder -> uriBuilder.path(pathBase)
                .queryParam("username", usuario)
                .queryParam("key", password)
                .queryParam("project", codigoProyecto)
                .build()
        ).retrieve().bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();
        BoyaChicaItem[] listaBoyasChicas = objectMapper.readValue(jsonProyecto, BoyaChicaItem[].class);
        return new Proyecto(listaBoyasChicas);
    }
}
