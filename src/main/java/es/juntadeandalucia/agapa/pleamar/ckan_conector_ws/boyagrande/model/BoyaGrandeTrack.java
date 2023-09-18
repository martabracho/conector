package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaGrandeTrack {

    private String abreviation;
    private String calculation_abreviation;
    private String name;
    private String position_date_time;
    private String section;
    private String unit;
    private String value;

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getCalculation_abreviation() {
        return calculation_abreviation;
    }

    public void setCalculation_abreviation(String calculation_abreviation) {
        this.calculation_abreviation = calculation_abreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition_date_time() {
        return position_date_time;
    }

    public void setPosition_date_time(String position_date_time) {
        this.position_date_time = position_date_time;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
