package com.objectj.emdad.ejb;

public class NoeKhodroList extends com.objectj.emdad.ejb.NoeKhodroModel{

    private java.lang.String id;
    private java.lang.Integer guarantee;
    private java.lang.Integer guaranteeDistance;
    private java.lang.String khodrosazId;
    private java.lang.String onvan;
    private java.lang.String khodroCode;
    private java.lang.String noeKhodroCode;
    private java.lang.Integer noeKhodroId;
    private java.lang.String khodrosazName;
    private java.lang.String vijehName;
    private java.lang.Integer vijeh;
    private java.lang.Integer hazinehSaat;
    private java.lang.Integer hazinehEshterakAdi;
    private java.lang.Integer hazinehEshterakVijeh;
    private java.lang.Integer noeService;
    private java.lang.String noeServiceName;

    public Integer getHazinehEshterakAdi() {
        return hazinehEshterakAdi;
    }

    public void setHazinehEshterakAdi(Integer hazinehEshterakAdi) {
        this.hazinehEshterakAdi = hazinehEshterakAdi;
    }

    public Integer getHazinehEshterakVijeh() {
        return hazinehEshterakVijeh;
    }

    public void setHazinehEshterakVijeh(Integer hazinehEshterakVijeh) {
        this.hazinehEshterakVijeh = hazinehEshterakVijeh;
    }

    public String getVijehName() {
        return vijehName;
    }

    public void setVijehName(String vijehName) {
        this.vijehName = vijehName;
    }

    public Integer getVijeh() {
        return vijeh;
    }

    public void setVijeh(Integer vijeh) {
        this.vijeh = vijeh;
    }

    public NoeKhodroList() {
    }

    /*============================================================*/
    public String getNoeKhodroCode() {
        return noeKhodroCode;
    }

    public void setNoeKhodroCode(String noeKhodroCode) {
        this.noeKhodroCode = noeKhodroCode;
    }
    /*============================================================*/
    public String getKhodrosazName() {
        return this.khodrosazName;
    }
    public void setKhodrosazName(String khodrosazName) {
        this.khodrosazName = khodrosazName;
    }
    /*============================================================*/
    public Integer getGuaranteeDistance() {
        return guaranteeDistance;
    }

    public void setGuaranteeDistance(Integer guaranteeDistance) {
        this.guaranteeDistance = guaranteeDistance;
    }
    /*============================================================*/
    public java.lang.Integer getNoeKhodroId() {
        return this.noeKhodroId;
    }
    public void setNoeKhodroId(java.lang.Integer noeKhodroId) {
        this.noeKhodroId = noeKhodroId;
    }
    /*============================================================*/
    public String getOnvan() {
        return this.onvan;
    }
    public void setOnvan(String onvan) {
        this.onvan = onvan;
    }
    /*============================================================*/
    public String getKhodrosazId() {
        return this.khodrosazId;
    }
    public void setKhodrosazId(String khodrosazId) {
        this.khodrosazId = khodrosazId;
    }
    /*============================================================*/
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /*============================================================*/
    public java.lang.Integer getGuarantee() {
        return this.guarantee;
    }
    public void setGuarantee(java.lang.Integer guarantee) {
        this.guarantee = guarantee;
    }

    /*============================================================*/
    public String getKhodroCode() {
        return khodroCode;
    }

    public void setKhodroCode(String khodroCode) {
        this.khodroCode = khodroCode;
    }

    /*============================================================*/
    public Integer getHazinehSaat() {
        return hazinehSaat;
    }

    public void setHazinehSaat(Integer hazinehSaat) {
        this.hazinehSaat = hazinehSaat;
    }

    public String getNoeServiceName() {
        return noeServiceName;
    }

    public void setNoeServiceName(String noeServiceName) {
        this.noeServiceName = noeServiceName;
    }
    /*============================================================*/
    public Integer getNoeService(){
        return this.noeService;
    }
    public void setNoeService(Integer noeService){
        this.noeService = noeService;
    }
}
