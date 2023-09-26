package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.repository;

import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class BoyaGrandeRepository {

    public static final int SIZE_BUFFER_STREAM = 10 * 1024 * 1024;
    public static final String BEARER = "Bearer ";

    @Value("${boyasgrandes.api.url}")
    private String url;
    @Value("${boyasgrandes.api.pathBase}")
    private String pathBase;
    @Value("${boyasgrandes.api.usuario}")
    private String usuario;
    @Value("${boyasgrandes.api.password}")
    private String password;

    public String getToken() {

        TokenRequest tokenRequest = new TokenRequest(usuario, password);
        WebClient client = WebClient.create(url);
        TokenResponse tokenResponse = client.post().uri(uriBuilder -> uriBuilder.path(pathBase).path("/auth/login").build()).contentType(MediaType.APPLICATION_JSON).bodyValue(tokenRequest).retrieve().bodyToMono(TokenResponse.class).block();
        return tokenResponse.getToken();
    }

    public BoyaGrande getBoyaUltimoTrack(String token, long idBoya) {
        WebClient client = WebClient.create(url);
        return client.get().uri(uriBuilder -> uriBuilder.path(pathBase).path("/tracks/device/").path(String.valueOf(idBoya)).build()).header(HttpHeaders.AUTHORIZATION, BEARER + token).retrieve().bodyToMono(BoyaGrande.class).block();
    }

    public BoyaGrandeTracks getBoyaTracks(String token, long idBoya) {
        final ExchangeStrategies strategies = ExchangeStrategies.builder().codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(SIZE_BUFFER_STREAM)).build();
        WebClient client = WebClient.builder().exchangeStrategies(strategies).baseUrl(url).build();
        BoyaGrandeTrackRequest boyaGrandeTrackRequest = new BoyaGrandeTrackRequest();
        boyaGrandeTrackRequest.setId(String.valueOf(idBoya));
        return client.post().uri(uriBuilder -> uriBuilder.path(pathBase).path("/viewdata").build()).header(HttpHeaders.AUTHORIZATION, BEARER + token).contentType(MediaType.APPLICATION_JSON).bodyValue(boyaGrandeTrackRequest).retrieve().bodyToMono(BoyaGrandeTracks.class).block();
    }

    public Mono<BoyaGrande> getBoyaUltimoTrackMono(String token, Integer idBoya) {
        WebClient client = WebClient.create(url);
        return client.get().uri(uriBuilder -> uriBuilder.path(pathBase).path("/tracks/device/").path(String.valueOf(idBoya)).build()).header(HttpHeaders.AUTHORIZATION, BEARER + token).retrieve().bodyToMono(BoyaGrande.class);
    }
}

