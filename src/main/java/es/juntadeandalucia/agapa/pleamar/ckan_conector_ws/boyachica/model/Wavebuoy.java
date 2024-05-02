package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wavebuoy {

    private String serial;
    private String online;

    private String charged;

    private String inposition;

    private String inrange;

    private Settings settings;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getCharged() {
        return charged;
    }

    public void setCharged(String charged) {
        this.charged = charged;
    }

    public String getInposition() {
        return inposition;
    }

    public void setInposition(String inposition) {
        this.inposition = inposition;
    }

    public String getInrange() {
        return inrange;
    }

    public void setInrange(String inrange) {
        this.inrange = inrange;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
