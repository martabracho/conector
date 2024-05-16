package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Registro {
    private BoyaChicaRegistro[] boyaChicaRegistro;

    public Registro(BoyaChicaRegistro[] boyaChicaRegistro) {
        this.boyaChicaRegistro = boyaChicaRegistro;
    }

    public BoyaChicaRegistro[] getBoyaChicaRegistro() {
        return boyaChicaRegistro;
    }

    public void setBoyaChicaRegistro(BoyaChicaRegistro[] boyaChicaRegistro) {
        this.boyaChicaRegistro = boyaChicaRegistro;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "boyaChicaRegistro=" + Arrays.toString(boyaChicaRegistro) +
                '}';
    }
}
