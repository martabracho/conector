package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    private Wavebuoy wavebuoy;

    public Wavebuoy getWavebuoy() {
        return wavebuoy;
    }

    public void setWavebuoy(Wavebuoy wavebuoy) {
        this.wavebuoy = wavebuoy;
    }

}
