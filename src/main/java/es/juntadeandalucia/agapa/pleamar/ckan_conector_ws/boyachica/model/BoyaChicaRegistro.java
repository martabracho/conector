package es.juntadeandalucia.agapa.pleamar.ckan_conector_ws.boyachica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoyaChicaRegistro {
    private String time;
    private String Hm0;
    private String Hmax;
    private String Hsw;
    private String Tp;
    private String Tsw;
    private String Tm01;
    private String Tm02;
    private String Tm10;
    private String Tavg;
    private String Tmax;
    private String Dirp;
    private String Dirm;
    private String Dirsw;
    private String Sigp;
    private String Sigm;
    private String lat;

    private String lon;
    private String sst;
    private String VBAT;
    private String VSOL;
    private String TEMP;
    private String HUM;
    private String PRES;
    private String CSQ;
    private String RAT;
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
        return Hm0;
    }

    public void setHm0(String hm0) {
        Hm0 = hm0;
    }

    public String getHmax() {
        return Hmax;
    }

    public void setHmax(String hmax) {
        Hmax = hmax;
    }

    public String getHsw() {
        return Hsw;
    }

    public void setHsw(String hsw) {
        Hsw = hsw;
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    public String getTsw() {
        return Tsw;
    }

    public void setTsw(String tsw) {
        Tsw = tsw;
    }

    public String getTm01() {
        return Tm01;
    }

    public void setTm01(String tm01) {
        Tm01 = tm01;
    }

    public String getTm02() {
        return Tm02;
    }

    public void setTm02(String tm02) {
        Tm02 = tm02;
    }

    public String getTm10() {
        return Tm10;
    }

    public void setTm10(String tm10) {
        Tm10 = tm10;
    }

    public String getTavg() {
        return Tavg;
    }

    public void setTavg(String tavg) {
        Tavg = tavg;
    }

    public String getTmax() {
        return Tmax;
    }

    public void setTmax(String tmax) {
        Tmax = tmax;
    }

    public String getDirp() {
        return Dirp;
    }

    public void setDirp(String dirp) {
        Dirp = dirp;
    }

    public String getDirm() {
        return Dirm;
    }

    public void setDirm(String dirm) {
        Dirm = dirm;
    }

    public String getDirsw() {
        return Dirsw;
    }

    public void setDirsw(String dirsw) {
        Dirsw = dirsw;
    }

    public String getSigp() {
        return Sigp;
    }

    public void setSigp(String sigp) {
        Sigp = sigp;
    }

    public String getSigm() {
        return Sigm;
    }

    public void setSigm(String sigm) {
        Sigm = sigm;
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

    public String getVBAT() {
        return VBAT;
    }

    public void setVBAT(String VBAT) {
        this.VBAT = VBAT;
    }

    public String getVSOL() {
        return VSOL;
    }

    public void setVSOL(String VSOL) {
        this.VSOL = VSOL;
    }

    public String getTEMP() {
        return TEMP;
    }

    public void setTEMP(String TEMP) {
        this.TEMP = TEMP;
    }

    public String getHUM() {
        return HUM;
    }

    public void setHUM(String HUM) {
        this.HUM = HUM;
    }

    public String getPRES() {
        return PRES;
    }

    public void setPRES(String PRES) {
        this.PRES = PRES;
    }

    public String getCSQ() {
        return CSQ;
    }

    public void setCSQ(String CSQ) {
        this.CSQ = CSQ;
    }

    public String getRAT() {
        return RAT;
    }

    public void setRAT(String RAT) {
        this.RAT = RAT;
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
                ", Hm0='" + Hm0 + '\'' +
                ", Hmax='" + Hmax + '\'' +
                ", Hsw='" + Hsw + '\'' +
                ", Tp='" + Tp + '\'' +
                ", Tsw='" + Tsw + '\'' +
                ", Tm01='" + Tm01 + '\'' +
                ", Tm02='" + Tm02 + '\'' +
                ", Tm10='" + Tm10 + '\'' +
                ", Tavg='" + Tavg + '\'' +
                ", Tmax='" + Tmax + '\'' +
                ", Dirp='" + Dirp + '\'' +
                ", Dirm='" + Dirm + '\'' +
                ", Dirsw='" + Dirsw + '\'' +
                ", Sigp='" + Sigp + '\'' +
                ", Sigm='" + Sigm + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", sst='" + sst + '\'' +
                ", VBAT='" + VBAT + '\'' +
                ", VSOL='" + VSOL + '\'' +
                ", TEMP='" + TEMP + '\'' +
                ", HUM='" + HUM + '\'' +
                ", PRES='" + PRES + '\'' +
                ", CSQ='" + CSQ + '\'' +
                ", RAT='" + RAT + '\'' +
                ", oper='" + oper + '\'' +
                ", source='" + source + '\'' +
                ", invalid='" + invalid + '\'' +
                ", tstr='" + tstr + '\'' +
                '}';
    }

    public String toStringFormatoKML() {
        StringBuilder kml = new StringBuilder("<description>");
        kml.append("Altura de ola significativa (m)='").append(Hm0).append('\'' );
        kml.append(", Altura máxima de ola (m)='").append(Hmax).append('\'' );
        kml.append(", Periodo pico de onda (s)='").append(Tp).append('\'' );
        kml.append(", Período promedio de ola (s)='").append(Tavg).append('\'' );
        kml.append(", Dirección de onda máxima (grados N)='").append(Dirp).append('\'' );
        kml.append(", Dirección media de la onda (grados N)='").append(Dirm).append('\'' );
        kml.append(", Dispersión direccional máxima (grados)='").append(Sigp).append('\'' );
        kml.append(", Difusión direccional media (grados)='").append(Sigm).append('\'' );
        kml.append(", Latitud (grados N)='").append(lat).append('\'' );
        kml.append(", Longitud (grados E)='").append(lon).append('\'' );
        kml.append(", Temperatura de la superficie del mar (grados C)='").append(sst).append('\'' );
        kml.append(", Voltaje de la batería (V)='").append(VBAT).append('\'' );
        kml.append(", Fecha ='").append(tstr).append('\'' );
        kml.append("</description>");
        return kml.toString();
    }
}
