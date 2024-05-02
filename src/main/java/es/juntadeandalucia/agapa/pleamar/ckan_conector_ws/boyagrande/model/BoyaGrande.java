package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaGrande {
    private String id;
    private String position_date_time;
    private String latitude;
    private String longitude;
    private BoyaGrandeData[] data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getPosition_date_time(){return position_date_time;}

    public void setPosition_date_time(String receptionDateTime){this.position_date_time = receptionDateTime;}

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

    public BoyaGrandeData[] getData() {
        return data;
    }

    public void setData(BoyaGrandeData[] data) {
        this.data = data;
    }
}
