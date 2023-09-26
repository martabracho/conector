package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyagrande.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BoyaGrandeTrackRequest {

    private String id;
    private String endRange;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartRange()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -24);
        return simpleDateFormat.format(calendar.getTime());
    }



    public String getEndRange() {
        return endRange;
    }

    public void setEndRange(String endRange) {
        this.endRange = endRange;
    }
}
