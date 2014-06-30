package com.objectj.emdad.ejb;


public class ServiceDoreiList
       extends  ServiceDoreiModel
 {

    private java.lang.String id;
    private java.lang.Integer kilometerKarkard;
    private java.sql.Date tarikh;
    private java.lang.String noeServiceDorei;
    private java.lang.Integer hazineh;
    private Integer namayandegiId;
    private Integer taeedHesabdar;
    private Integer taeedNamayandeh;
    private String namayandegiName;

    private String eshterakId;
    private String moshtarakId;
    private String moshtarakName;
    private String noeServiceDoreiName;
    private Integer noeServiceDoreiId;
    private String shomareShasi;
    private String tarikhHejri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getKilometerKarkard() {
        return kilometerKarkard;
    }

    public void setKilometerKarkard(Integer kilometerKarkard) {
        this.kilometerKarkard = kilometerKarkard;
    }

    public java.sql.Date getTarikh() {
        return tarikh;
    }

    public void setTarikh(java.sql.Date tarikh) {
        this.tarikh = tarikh;
    }

    public String getNoeServiceDoreiName() {
        return noeServiceDoreiName;
    }

    public void setNoeServiceDoreiName(String noeServiceDoreiName) {
        this.noeServiceDoreiName = noeServiceDoreiName;
    }

    public Integer getNoeServiceDoreiId() {
        return noeServiceDoreiId;
    }

    public void setNoeServiceDoreiId(Integer noeServiceDoreiId) {
        this.noeServiceDoreiId = noeServiceDoreiId;
    }

    public String getNoeServiceDorei() {
        return noeServiceDorei;
    }

    public void setNoeServiceDorei(String noeServiceDorei) {
        this.noeServiceDorei = noeServiceDorei;
    }

    public Integer getHazineh() {
        return hazineh;
    }

    public void setHazineh(Integer hazineh) {
        this.hazineh = hazineh;
    }

    public String getTarikhHejri() {
        return tarikhHejri;
    }

    public void setTarikhHejri(String tarikhHejri) {
        this.tarikhHejri = tarikhHejri;
    }

    public String getEshterakId() {
        return eshterakId;
    }

    public void setEshterakId(String eshterakId) {
        this.eshterakId = eshterakId;
    }

    /*============================================================*/
    public Integer getNamayandegiId() {
        return namayandegiId;
    }
    public void setNamayandegiId(Integer namayandegiId) {
        this.namayandegiId = namayandegiId;
    }

    /*============================================================*/
    public String getNamayandegiName() {
        return namayandegiName;
    }
    public void setNamayandegiName(String namayandegiName) {
        this.namayandegiName = namayandegiName;
    }

    /*============================================================*/
    public String getMoshtarakId() {
        return moshtarakId;
    }
    public void setMoshtarakId(String moshtarakId) {
        this.moshtarakId = moshtarakId;
    }

    /*============================================================*/
    public String getMoshtarakName() {
        return moshtarakName;
    }
    public void setMoshtarakName(String moshtarakName) {
        this.moshtarakName = moshtarakName;
    }

    public Integer getTaeedHesabdar() {
        return taeedHesabdar;
    }
    public void setTaeedHesabdar(Integer taeedHesabdar) {
        this.taeedHesabdar = taeedHesabdar;
    }

    public Integer getTaeedNamayandeh() {
        return taeedNamayandeh;
    }
    public void setTaeedNamayandeh(Integer taeedNamayandeh) {
        this.taeedNamayandeh = taeedNamayandeh;
    }

    public String getShomareShasi() {
        return shomareShasi;
    }
    public void setShomarehShasi(String shomareShasi) {
        this.shomareShasi = shomareShasi;
    }
}
