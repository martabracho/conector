package com.agapa.pleamar.boyasChicas.controllers;

import com.agapa.pleamar.boyasChicas.model.Buoy;
import com.agapa.pleamar.boyasChicas.services.BuoyService;

import java.util.List;

@Controller
public class BoyaControler {

    @Autowired
    BuoyService service;

    @RequestMapping("lista")
    public String lista (final Buoy buoy){

        List<Buoy> lista = service.getAllUser().collectList().block();


        return "lista";

    }
}
