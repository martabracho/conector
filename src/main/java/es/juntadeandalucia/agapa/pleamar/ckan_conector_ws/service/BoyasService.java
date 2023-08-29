package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BoyasService {

    public String getHolaMundo(){
        WebClient client = WebClient.create("http://localhost:8080");
        return client.get().uri("/boyas/holaMundo").retrieve().bodyToMono(String.class).block();
    }
}
