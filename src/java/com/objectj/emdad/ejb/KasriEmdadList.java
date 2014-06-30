package com.objectj.emdad.ejb;


public class KasriEmdadList extends com.objectj.emdad.ejb.KasriEmdadModel{

    private String emdadgarId;
    private String emdadgarName;
    private java.sql.Date tarikh;
    private String tarikhHejri;
    private java.lang.Integer kasriId;
    private java.lang.Integer tahvilshod;
    private java.lang.String tahvilshodName;
    private java.lang.Integer taeedAnbardar;
    private java.lang.String taeedAnbardarName;
    private java.lang.Integer taeedEmdadgar;
    private java.lang.String taeedEmdadgarName;

    public Integer getKasriId() {
        return kasriId;
    }

    public void setKasriId(Integer kasriId) {
        this.kasriId = kasriId;
    }

    /*============================================================*/
    public String getEmdadgarId() {
        return emdadgarId;
    }
    public void setEmdadgarId(String emdadgarId) {
        this.emdadgarId = emdadgarId;
    }

    /*============================================================*/
    public String getEmdadgarName() {
        return emdadgarName;
    }
    public void setEmdadgarName(String emdadgarName) {
        this.emdadgarName = emdadgarName;
    }

    public java.sql.Date getTarikh() {
        return tarikh;
    }

    public void setTarikh(java.sql.Date tarikh) {
        this.tarikh = tarikh;
    }

    public String getTarikhHejri() {
        return tarikhHejri;
    }

    public void setTarikhHejri(String tarikhHejri) {
        this.tarikhHejri = tarikhHejri;
    }
    /*============================================================*/
    public Integer getTahvilshod() {
        return tahvilshod;
    }

    public void setTahvilshod(Integer tahvilshod) {
        this.tahvilshod = tahvilshod;
    }

    /*============================================================*/
    public String getTahvilshodName() {
        return tahvilshodName;
    }

    public void setTahvilshodName(String tahvilshodName) {
        this.tahvilshodName = tahvilshodName;
    }

    /*============================================================*/
    public Integer getTaeedAnbardar() {
        return taeedAnbardar;
    }

    public void setTaeedAnbardar(Integer taeedAnbardar) {
        this.taeedAnbardar = taeedAnbardar;
    }

    /*============================================================*/
    public String getTaeedAnbardarName() {
        return taeedAnbardarName;
    }

    public void setTaeedAnbardarName(String taeedAnbardarName) {
        this.taeedAnbardarName = taeedAnbardarName;
    }

    /*============================================================*/
    public Integer getTaeedEmdadgar() {
        return taeedEmdadgar;
    }

    public void setTaeedEmdadgar(Integer taeedEmdadgar) {
        this.taeedEmdadgar = taeedEmdadgar;
    }

    /*============================================================*/
    public String getTaeedEmdadgarName() {
        return taeedEmdadgarName;
    }

    public void setTaeedEmdadgarName(String taeedEmdadgarName) {
        this.taeedEmdadgarName = taeedEmdadgarName;
    }
}
