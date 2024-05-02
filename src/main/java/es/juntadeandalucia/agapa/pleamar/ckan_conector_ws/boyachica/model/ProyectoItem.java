package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProyectoItem {

    private String name;
    private String timezone;

    public String getName() {
        return name;
    }

    public String getTimezone() {
        return timezone;
    }


}
