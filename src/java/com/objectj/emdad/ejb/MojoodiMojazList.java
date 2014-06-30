package com.objectj.emdad.ejb;


public class MojoodiMojazList extends com.objectj.emdad.ejb.MojoodiMojazModel{

    private String noeEmdadgarId;
    private String noeEmdadgarOnvan;

    private java.lang.Integer tedad;

    private String qateId;
    private String qateName;
    private String shomarehFanni;

    public String getShomarehFanni() {
        return shomarehFanni;
    }

    public void setShomarehFanni(String shomarehFanni) {
        this.shomarehFanni = shomarehFanni;
    }

    /*============================================================*/
    public String getNoeEmdadgarId() {
        return noeEmdadgarId;
    }
    public void setNoeEmdadgarId(String noeEmdadgarId) {
        this.noeEmdadgarId = noeEmdadgarId;
    }

    /*============================================================*/
    public String getNoeEmdadgarOnvan() {
        return noeEmdadgarOnvan;
    }
    public void setNoeEmdadgarOnvan(String noeEmdadgarOnvan) {
        this.noeEmdadgarOnvan = noeEmdadgarOnvan;
    }

    /*============================================================*/
    public String getQateId() {
        return qateId;
    }
    public void setQateId(String qateId) {
        this.qateId = qateId;
    }

    /*============================================================*/
    public String getQateName() {
        return qateName;
    }
    public void setQateName(String qateName) {
        this.qateName = qateName;
    }

    public Integer getTedad() {
        return tedad;
    }

    public void setTedad(Integer tedad) {
        this.tedad = tedad;
    }
}
