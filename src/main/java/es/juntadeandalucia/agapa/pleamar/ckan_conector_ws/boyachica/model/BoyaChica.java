package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaChica {


    private BoyaChicaRegistro[] data;

    public BoyaChica() {
    }

    public BoyaChica(BoyaChicaRegistro[] data) {
        this.data = data;
    }

    public BoyaChicaRegistro[] getData() {
        return data;
    }

    public void setData(BoyaChicaRegistro[] data) {
        this.data = data;
    }

}
