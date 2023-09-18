package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaGrandeTracks {
    private String code;
    private BoyaGrandeTrack [] datas;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BoyaGrandeTrack[] getDatas() {
        return datas;
    }

    public void setDatas(BoyaGrandeTrack[] datas) {
        this.datas = datas;
    }

}
