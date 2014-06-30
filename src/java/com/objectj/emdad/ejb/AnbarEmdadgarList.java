package com.objectj.emdad.ejb;


public class AnbarEmdadgarList extends com.objectj.emdad.ejb.AnbarEmdadgarModel{

    private java.lang.String id;
    private java.lang.Integer mojoodi;
    private String emdadgarId;
    private String emdadgarName;

    private String daftarOstaniId;
    private String daftarOstaniName;
    private String qateId;
    private String qateName;
    private String shomareFanni;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDaftarOstaniId() {
        return daftarOstaniId;
    }

    public void setDaftarOstaniId(String daftarOstaniId) {
        this.daftarOstaniId = daftarOstaniId;
    }

    public Integer getMojoodi() {
        return mojoodi;
    }

    public void setMojoodi(Integer mojoodi) {
        this.mojoodi = mojoodi;
    }

    public String getDaftarOstaniName() {
        return daftarOstaniName;
    }

    public void setDaftarOstaniName(String daftarOstaniName) {
        this.daftarOstaniName = daftarOstaniName;
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

    public String getShomareFanni() {
        return shomareFanni;
    }

    public void setShomareFanni(String shomareFanni) {
        this.shomareFanni = shomareFanni;
    }
}
