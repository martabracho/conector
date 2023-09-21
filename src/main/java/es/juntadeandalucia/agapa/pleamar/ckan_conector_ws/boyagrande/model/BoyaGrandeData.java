package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaGrandeData {
    private String id;
    private BoyaGrandeDataVariable variable;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BoyaGrandeDataVariable getVariable() {
        return variable;
    }

    public void setVariable(BoyaGrandeDataVariable variable) {
        this.variable = variable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BoyaGrandeData{" +
                "id='" + id + '\'' +
                ", variable=" + variable +
                ", value='" + value + '\'' +
                '}';
    }
}
