package com.agapa.pleamar.boyasChicas.services;
@Service
public class BuoyService {


    @GetMapping
    public Flux<Buoy> getAllUser(){
        WebClient client = WebClient.create("https://obscape.com");
        Flux<Buoy> buoy = client.get()
                .uri("/portal/api/v3/api?username=reolaagapa&key=uxLiHTj1cC3WdAtjXIE5NJA62Y8WOd6iKQAsJTtWwwSK8m456H")
                .accept(MediaType.APPLICATION_JSON)

                .retrieve()
                .bodyToFlux(Buoy.class);
        buoy.subscribe(System.out::println);
        return buoy;

    }
}
