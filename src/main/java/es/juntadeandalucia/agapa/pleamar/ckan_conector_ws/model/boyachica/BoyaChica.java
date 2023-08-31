package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.model.boyachica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaChica {

    private String name;
    private int id;
    private String latitude;
    private String longitude;


    private Device devices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Device getDevices() {
        return devices;
    }

    public void setDevices(Device devices) {
        this.devices = devices;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "BoyaChica{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
