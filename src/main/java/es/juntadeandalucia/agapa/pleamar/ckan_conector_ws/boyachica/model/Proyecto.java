package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Proyecto {

  private BoyaChicaItem [] boyaChicaItem;

    public Proyecto(){}

    public Proyecto(BoyaChicaItem[] boyaChicaItem) {
        this.boyaChicaItem = boyaChicaItem;
    }

    public BoyaChicaItem[] getBoyaChicaItem() {
        return boyaChicaItem;
    }

    public void setBoyaChicaItem(BoyaChicaItem[] boyaChicaItem) {
        this.boyaChicaItem = boyaChicaItem;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "boyaChicaItem=" + Arrays.toString(boyaChicaItem) +
                '}';
    }
}
