package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.controller.boyachica.ProyectoController;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChica;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.BoyaChicaItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica.BoyaChicaRepository;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
@Component
public class BoyaChicaService {

    private ProyectoService proyectoService;
    private BoyaChicaRepository boyaChicaRepository;



    @Autowired
    public BoyaChicaService (BoyaChicaRepository boyaChicaRepository, ProyectoService proyectoService ){
        this.boyaChicaRepository = boyaChicaRepository;
        this.proyectoService = proyectoService;
    }


    public BoyaChica getBoya(String codigoProyecto, int idBoya) throws JsonProcessingException {
        return this.boyaChicaRepository.getBoyaChica(codigoProyecto,idBoya);
    }


}
