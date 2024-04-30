package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaChicaRegistro {
    private String time;
    private String hm0;
    private String hmax;
    private String hsw;
    private String tp;
    private String tsw;
    private String tm01;
    private String tm02;
    private String tm10;
    private String tavg;
    private String tmax;
    private String dirp;
    private String dirm;
    private String dirsw;
    private String sigp;
    private String sigm;
    private String lat;

    private String lon;
    private String sst;
    private String vbat;
    private String vsol;
    private String temp;
    private String hum;
    private String pres;
    private String csq;
    private String rat;
    private String oper;
    private String source;
    private String invalid;
    private String tstr;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHm0() {
        return hm0;
    }

    public void setHm0(String hm0) {
        this.hm0 = hm0;
    }

    public String getHmax() {
        return hmax;
    }

    public void setHmax(String hmax) {
        this.hmax = hmax;
    }

    public String getHsw() {
        return hsw;
    }

    public void setHsw(String hsw) {
        this.hsw = hsw;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTsw() {
        return tsw;
    }

    public void setTsw(String tsw) {
        this.tsw = tsw;
    }

    public String getTm01() {
        return tm01;
    }

    public void setTm01(String tm01) {
        this.tm01 = tm01;
    }

    public String getTm02() {
        return tm02;
    }

    public void setTm02(String tm02) {
        this.tm02 = tm02;
    }

    public String getTm10() {
        return tm10;
    }

    public void setTm10(String tm10) {
        this.tm10 = tm10;
    }

    public String getTavg() {
        return tavg;
    }

    public void setTavg(String tavg) {
        this.tavg = tavg;
    }

    public String getTmax() {
        return tmax;
    }

    public void setTmax(String tmax) {
        this.tmax = tmax;
    }

    public String getDirp() {
        return dirp;
    }

    public void setDirp(String dirp) {
        this.dirp = dirp;
    }

    public String getDirm() {
        return dirm;
    }

    public void setDirm(String dirm) {
        this.dirm = dirm;
    }

    public String getDirsw() {
        return dirsw;
    }

    public void setDirsw(String dirsw) {
        this.dirsw = dirsw;
    }

    public String getSigp() {
        return sigp;
    }

    public void setSigp(String sigp) {
        this.sigp = sigp;
    }

    public String getSigm() {
        return sigm;
    }

    public void setSigm(String sigm) {
        this.sigm = sigm;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSst() {
        return sst;
    }

    public void setSst(String sst) {
        this.sst = sst;
    }

    public String getVbat() {
        return vbat;
    }

    public void setVbat(String vbat) {
        this.vbat = vbat;
    }

    public String getVsol() {
        return vsol;
    }

    public void setVsol(String vsol) {
        this.vsol = vsol;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getCsq() {
        return csq;
    }

    public void setCsq(String csq) {
        this.csq = csq;
    }

    public String getRat() {
        return rat;
    }

    public void setRat(String rat) {
        this.rat = rat;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public String getTstr() {
        return tstr;
    }

    public void setTstr(String tstr) {
        this.tstr = tstr;
    }


    @Override
    public String toString() {
        return "BoyaChicaRegistro{" +
                "time='" + time + '\'' +
                ", hm0='" + hm0 + '\'' +
                ", hmax='" + hmax + '\'' +
                ", hsw='" + hsw + '\'' +
                ", tp='" + tp + '\'' +
                ", tsw='" + tsw + '\'' +
                ", tm01='" + tm01 + '\'' +
                ", tm02='" + tm02 + '\'' +
                ", tm10='" + tm10 + '\'' +
                ", tavg='" + tavg + '\'' +
                ", tmax='" + tmax + '\'' +
                ", dirp='" + dirp + '\'' +
                ", dirm='" + dirm + '\'' +
                ", dirsw='" + dirsw + '\'' +
                ", sigp='" + sigp + '\'' +
                ", sigm='" + sigm + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", sst='" + sst + '\'' +
                ", vbat='" + vbat + '\'' +
                ", vsol='" + vsol + '\'' +
                ", temp='" + temp + '\'' +
                ", hum='" + hum + '\'' +
                ", pres='" + pres + '\'' +
                ", csq='" + csq + '\'' +
                ", rat='" + rat + '\'' +
                ", oper='" + oper + '\'' +
                ", source='" + source + '\'' +
                ", invalid='" + invalid + '\'' +
                ", tstr='" + tstr + '\'' +
                '}';
    }

    public String toStringFormatoKML() {
        StringBuilder kml = new StringBuilder("<description>");
        kml.append("Altura de ola significativa (m)='").append(hm0).append('\'' );
        kml.append(", Altura máxima de ola (m)='").append(hmax).append('\'' );
        kml.append(", Periodo pico de onda (s)='").append(tp).append('\'' );
        kml.append(", Período promedio de ola (s)='").append(tavg).append('\'' );
        kml.append(", Dirección de onda máxima (grados N)='").append(dirp).append('\'' );
        kml.append(", Dirección media de la onda (grados N)='").append(dirm).append('\'' );
        kml.append(", Dispersión direccional máxima (grados)='").append(sigp).append('\'' );
        kml.append(", Dispersión direccional media (grados)='").append(sigm).append('\'' );
        kml.append(", Latitud (grados N)='").append(lat).append('\'' );
        kml.append(", Longitud (grados E)='").append(lon).append('\'' );
        kml.append(", Temperatura de la superficie del mar (grados C)='").append(sst).append('\'' );
        kml.append(", Voltaje de la batería (V)='").append(vbat).append('\'' );
        kml.append(", Fecha ='").append(tstr).append('\'' );
        kml.append("</description>");
        return kml.toString();
    }
}
