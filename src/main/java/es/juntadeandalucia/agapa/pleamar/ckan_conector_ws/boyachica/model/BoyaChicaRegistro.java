package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaChicaRegistro {
    private String time;
    private String Hm0;

    public BoyaChicaRegistro() {
    }

    public BoyaChicaRegistro(String time, String Hm0) {
        this.time = time;
        this.Hm0 = Hm0;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHm0() {
        return Hm0;
    }

    public void setHm0(String hm0) {
        Hm0 = hm0;
    }
}
