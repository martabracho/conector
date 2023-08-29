package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BoyasService {

    public String getHolaMundo(){
        WebClient client = WebClient.create("https://obscape.com");
        return client.get().uri("/portal/api/v3/api?username=reolaagapa&key=uxLiHTj1cC3WdAtjXIE5NJA62Y8WOd6iKQAsJTtWwwSK8m456H").retrieve().bodyToMono(String.class).block();
    }
}
