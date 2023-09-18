package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

public class BoyaGrandeTrackRequest {

    private String id = "2";
    private String startRange = "2023-09-17 23:00:00";
    private String endRange;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartRange() {
        return startRange;
    }

    public void setStartRange(String startRange) {
        this.startRange = startRange;
    }

    public String getEndRange() {
        return endRange;
    }

    public void setEndRange(String endRange) {
        this.endRange = endRange;
    }
}
