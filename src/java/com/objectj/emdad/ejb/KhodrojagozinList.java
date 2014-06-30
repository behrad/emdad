package com.objectj.emdad.ejb;


public class KhodrojagozinList extends com.objectj.emdad.ejb.KhodrojagozinModel{

    private String rangeKhodroId;
    private String rangeKhodroOnvan;

    private String noeKhodroId;
    private String noeKhodroOnvan;

    private String faalName;

    private String daftarOstaniId;
    private String daftarOstaniName;

    /*============================================================*/
    public void setFaalName(String faalName) {
        this.faalName = faalName;
    }
    public String getFaalName() {
        return faalName;
    }

    /*============================================================*/
    public String getRangeKhodroId() {
        return rangeKhodroId;
    }
    public void setRangeKhodroId(String rangeKhodroId) {
        this.rangeKhodroId = rangeKhodroId;
    }

    /*============================================================*/
    public String getRangeKhodroOnvan() {
        return rangeKhodroOnvan;
    }
    public void setRangeKhodroOnvan(String rangeKhodroOnvan) {
        this.rangeKhodroOnvan = rangeKhodroOnvan;
    }

    /*============================================================*/
    public String getNoeKhodroId() {
        return noeKhodroId;
    }
    public void setNoeKhodroId(String noeKhodroId) {
        this.noeKhodroId = noeKhodroId;
    }

    /*============================================================*/
    public String getNoeKhodroOnvan() {
        return noeKhodroOnvan;
    }
    public void setNoeKhodroOnvan(String noeKhodroOnvan) {
        this.noeKhodroOnvan = noeKhodroOnvan;
    }
    /*============================================================*/

    public String getDaftarOstaniId() {
        return daftarOstaniId;
    }

    public void setDaftarOstaniId(String daftarOstaniId) {
        this.daftarOstaniId = daftarOstaniId;
    }
    /*============================================================*/

    public String getDaftarOstaniName() {
        return daftarOstaniName;
    }

    public void setDaftarOstaniName(String daftarOstaniName) {
        this.daftarOstaniName = daftarOstaniName;
    }
}
