package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.TokenRequest;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
@Repository
public class BoyaGrandeRepository {

    @Value("${boyasgrandes.api.url}")
    private String url;
    @Value("${boyasgrandes.api.pathBase}")
    private String pathBase;
    @Value("${boyasgrandes.api.usuario}")
    private String usuario;
    @Value("${boyasgrandes.api.password}")
    private String password;

    public String getToken() throws JsonProcessingException {

        TokenRequest tokenRequest = new TokenRequest(usuario,password);
        WebClient client = WebClient.create(url);
        TokenResponse tokenResponse = client.post().uri( uriBuilder -> uriBuilder.path(pathBase).path("/auth/login")
                .build()
        ).contentType(MediaType.APPLICATION_JSON).bodyValue(tokenRequest).retrieve().bodyToMono(TokenResponse.class).block();

        return tokenResponse.getToken();
    }

    public String getUsuarios(String token) {


        WebClient client = WebClient.create(url);
        String jsonUsuarios = client.get().uri(uriBuilder -> uriBuilder.path(pathBase).path("/tracks/device/").path("2")
                .build()
        ).header(HttpHeaders.AUTHORIZATION, "Bearer " + token).retrieve().bodyToMono(String.class).block();
        return jsonUsuarios;
    }
}
