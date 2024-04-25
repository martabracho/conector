package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model.*;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class ProyectoService {

    public static final String AGAPA_MANCADIZ = "AgapaMancadiz";
    private final ProyectoRepository proyectoRepository;

    private final BoyaChicaService boyaChicaService;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, BoyaChicaService boyaChicaService) {
        this.proyectoRepository = proyectoRepository;
        this.boyaChicaService = boyaChicaService;
    }

    public List<ProyectoItem> getProyectosItem() throws JsonProcessingException {
        return this.proyectoRepository.getProyectosItem();
    }

    public Proyecto getProyecto(String codigoProyecto) throws JsonProcessingException {
        return this.proyectoRepository.getProyecto(codigoProyecto);
    }

    public BoyaChicaGenerales[] getProyectoDetalle(String codigoProyecto) throws  JsonProcessingException{
        return this.proyectoRepository.getProyectoDetalle(codigoProyecto);
    }


    public String obtenerKmlBoyasChicas() throws JsonProcessingException {
        StringBuilder kml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n");
        kml.append("<Document>\n");
        Proyecto proyecto = this.getProyecto(AGAPA_MANCADIZ);

        List<BoyaChica> listaBoyas = Arrays.stream(proyecto.getBoyaChicaItem()).parallel().map( boyaChicaItem -> {
            BoyaChica boyaChica;
            try {
                boyaChica =  this.boyaChicaService.getBoya(AGAPA_MANCADIZ,boyaChicaItem.getId(),boyaChicaItem.getName());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return boyaChica;
        }  ).toList();

        for (BoyaChica boyaChica : listaBoyas ){
            if (boyaChica.getData().length>0) {
                kml.append("<Placemark>\n");
                kml.append("<name>").append(boyaChica.getName()).append("</name>");
                int pos = boyaChica.getData().length-1;
                kml.append(boyaChica.getData()[pos].toStringFormatoKML());
                kml.append("<Point>\n");
                kml.append("<coordinates>" + boyaChica.getData()[pos].getLon() + "," + boyaChica.getData()[pos].getLat() + "</coordinates>\n");
                kml.append("</Point>\n");
                kml.append("</Placemark>");
            }
        }

        kml.append("</Document>\n");
        kml.append("</kml>\n");
        return kml.toString();
    }


    public List<BoyaChica> obtenerJsonBoyasChicas() throws JsonProcessingException {

        List<BoyaChica> listaBoyaChica = new ArrayList<>();
        for (ProyectoItem proyectoItem : this.getProyectosItem()) {
            Proyecto proyecto = this.getProyecto(proyectoItem.getName());
            for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                listaBoyaChica.add(this.boyaChicaService.getBoya(proyectoItem.getName(),boyaChicaItem.getId(), boyaChicaItem.getName()));
            }
        }
        return listaBoyaChica;
    }

    public List<BoyaChica> obtenerJsonBoyasChicas(String codigoProyecto) throws JsonProcessingException {
        List<BoyaChica> listaBoyaChica = new ArrayList<>();
        Proyecto proyecto = this.getProyecto(codigoProyecto);
            for (BoyaChicaItem boyaChicaItem : proyecto.getBoyaChicaItem()) {
                listaBoyaChica.add(this.boyaChicaService.getBoya(codigoProyecto,boyaChicaItem.getId(), boyaChicaItem.getName()));
            }
        return listaBoyaChica;
    }
}
