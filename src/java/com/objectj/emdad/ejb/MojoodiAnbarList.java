package com.objectj.emdad.ejb;


public class MojoodiAnbarList extends com.objectj.emdad.ejb.MojoodiAnbarModel{

    private String shomareFanni;
    private String qateId;
    private String qateName;
    private Integer mojoodi;
    private java.lang.String id;

    public String getQateId() {
        return qateId;
    }

    public void setQateId(String qateId) {
        this.qateId = qateId;
    }

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

    public Integer getMojoodi() {
        return mojoodi;
    }

    public void setMojoodi(Integer mojoodi) {
        this.mojoodi = mojoodi;
    }

    /*============================================================*/
    public String getQateName() {
        return qateName;
    }
    public void setQateName(String qateName) {
        this.qateName = qateName;
    }

}
