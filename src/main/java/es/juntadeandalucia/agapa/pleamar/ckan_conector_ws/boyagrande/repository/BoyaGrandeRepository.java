package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.BoyaGrande;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.TokenRequest;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class BoyaGrandeRepository {

    Logger logger = LoggerFactory.getLogger(BoyaGrandeRepository.class);

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

    public BoyaGrande getBoya(String token, long idBoya) {

        WebClient clienteJson = WebClient.create(url);
        String jsonDevice = clienteJson.get().uri(uriBuilder -> uriBuilder.path(pathBase).path("/tracks/device/").path(String.valueOf(idBoya))
                .build()
        ).header(HttpHeaders.AUTHORIZATION, "Bearer " + token).retrieve().bodyToMono(String.class).block();
        this.logger.info("info de la boya:{}",jsonDevice);
        WebClient client = WebClient.create(url);
        return client.get().uri(uriBuilder -> uriBuilder.path(pathBase).path("/tracks/device/").path(String.valueOf(idBoya))
                .build()
        ).header(HttpHeaders.AUTHORIZATION, "Bearer " + token).retrieve().bodyToMono(BoyaGrande.class).block();

    }
}
