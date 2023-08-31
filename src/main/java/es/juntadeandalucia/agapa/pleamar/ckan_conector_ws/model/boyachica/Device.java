package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    private String[] wavebuoy;

    public String[] getWavebuoy() {
        return wavebuoy;
    }

    public void setWavebuoy(String[] wavebuoy) {
        this.wavebuoy = wavebuoy;
    }
}
