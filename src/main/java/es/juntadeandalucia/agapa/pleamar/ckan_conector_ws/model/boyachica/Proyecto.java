package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Proyecto {

  private BoyaChicaItem [] boyaChicaItem;

    public Proyecto(BoyaChicaItem[] boyaChicaItem) {
        this.boyaChicaItem = boyaChicaItem;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "boyaChicaItem=" + Arrays.toString(boyaChicaItem) +
                '}';
    }
}
