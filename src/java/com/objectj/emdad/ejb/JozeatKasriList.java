package com.objectj.emdad.ejb;


public class JozeatKasriList extends com.objectj.emdad.ejb.JozeatKasriModel{

    private String id;
    private String emdadgarId;
    private String emdadgarName;
    private java.sql.Date tarikh;
    private String tarikhHejri;
    private String shomareFanni;
    private String qateName;
    private java.lang.Integer kasriId;
    private java.lang.Integer tedadEmdadgar;
    private java.lang.Integer tedadKasri;
    private java.lang.Integer tedadAnbar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShomareFanni() {
        return shomareFanni;
    }

    public void setShomareFanni(String shomareFanni) {
        this.shomareFanni = shomareFanni;
    }

    public String getQateName() {
        return qateName;
    }

    public void setQateName(String qateName) {
        this.qateName = qateName;
    }

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

    public Integer getTedadEmdadgar() {
        return tedadEmdadgar;
    }

    public void setTedadEmdadgar(Integer tedadEmdadgar) {
        this.tedadEmdadgar = tedadEmdadgar;
    }

    public Integer getTedadKasri() {
        return tedadKasri;
    }

    public void setTedadKasri(Integer tedadKasri) {
        this.tedadKasri = tedadKasri;
    }

    public Integer getTedadAnbar() {
        return tedadAnbar;
    }

    public void setTedadAnbar(Integer tedadAnbar) {
        this.tedadAnbar = tedadAnbar;
    }
}
