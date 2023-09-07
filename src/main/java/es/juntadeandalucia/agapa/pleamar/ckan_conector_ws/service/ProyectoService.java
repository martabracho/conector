
package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.Proyecto;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica.ProyectoItem;
import es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.repository.boyachica.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProyectoService {

    private ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<ProyectoItem> getProyectosItem() throws JsonProcessingException {
        return this.proyectoRepository.getProyectosItem();
    }

    public Proyecto getProyecto(String codigoProyecto) throws JsonProcessingException {
        return this.proyectoRepository.getProyecto(codigoProyecto);
    }

}
