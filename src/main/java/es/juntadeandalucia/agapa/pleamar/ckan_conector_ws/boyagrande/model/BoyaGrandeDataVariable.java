package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaGrandeDataVariable {
    private String code;
    private String name;
    private String unit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "BoyaGrandeDataVariable{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String toStringFormatoKML() {
        StringBuilder kml = new StringBuilder("");
        kml.append(this.name).append("(").append(this.unit).append(")='");
        return kml.toString();

    }
}
