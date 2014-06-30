package com.objectj.emdad.ejb;


public class PeigiriEzamgarList extends com.objectj.emdad.ejb.PeigiriEzamgarModel{

    private String id;
    private String emdadId;
    private Integer emdadEmdadId;
    private String natije;
    private java.sql.Timestamp   zamanPeigiri;
    private Integer emdadVazeatKonuni;
     private java.lang.String    ZamanPeigiriHejri;
    private java.lang.String ZamanPeigiri2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEmdadVazeatKonuni() {
        return emdadVazeatKonuni;
    }

    public void setEmdadVazeatKonuni(Integer emdadVazeatKonuni) {
        this.emdadVazeatKonuni = emdadVazeatKonuni;
    }

    public String getZamanPeigiriHejri() {
        return ZamanPeigiriHejri;
    }

    public void setZamanPeigiriHejri(String zamanPeigiriHejri) {
        ZamanPeigiriHejri = zamanPeigiriHejri;
    }

    public String getZamanPeigiri2() {
        return ZamanPeigiri2;
    }

    public void setZamanPeigiri2(String zamanPeigiri2) {
        ZamanPeigiri2 = zamanPeigiri2;
    }



    public String getNatije() {
        return natije;
    }

    public void setNatije(String natije) {
        this.natije = natije;
    }

    public java.sql.Timestamp getZamanPeigiri() {
        return zamanPeigiri;
    }

    public void setZamanPeigiri(java.sql.Timestamp zamanPeigiri) {
        this.zamanPeigiri = zamanPeigiri;
    }



    /*============================================================*/
    public String getEmdadId() {
        return emdadId;
    }
    public void setEmdadId(String emdadId) {
        this.emdadId = emdadId;
    }

    /*============================================================*/
    public Integer getEmdadEmdadId() {
        return emdadEmdadId;
    }
    public void setEmdadEmdadId(Integer emdadEmdadId) {
        this.emdadEmdadId = emdadEmdadId;
    }

}
