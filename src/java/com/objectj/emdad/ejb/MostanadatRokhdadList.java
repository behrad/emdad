/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jun 26, 2003
 * Time: 1:04:43 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class MostanadatRokhdadList extends com.objectj.emdad.ejb.MostanadatRokhdadModel{
    private String id;
    private Integer mostanadatRokhdadId;
    private String shomarehSanad;
    private java.sql.Date tarikhSanad;
    private String tarikhSanadHejri;
    private java.sql.Date tarikhSabt;
    private String tarikhSabtHejri;
    private String sharh;
    private String nameParvande;
    private String rokhdadId;
    private Integer rokhdadRokhdadId;
    private String daftarOstaniName;
    private String daftarOstaniId;

    public String getNameSanad() {
        return nameSanad;
    }

    public void setNameSanad(String nameSanad) {
        this.nameSanad = nameSanad;
    }

    private String nameSanad;

    public String getDaftarOstaniName() {
        return daftarOstaniName;
    }

    public void setDaftarOstaniName(String daftarOstaniName) {
        this.daftarOstaniName = daftarOstaniName;
    }

    public String getDaftarOstaniId() {
        return daftarOstaniId;
    }

    public void setDaftarOstaniId(String daftarOstaniId) {
        this.daftarOstaniId = daftarOstaniId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMostanadatRokhdadId() {
        return mostanadatRokhdadId;
    }

    public void setMostanadatRokhdadId(Integer mostanadatRokhdadId) {
        this.mostanadatRokhdadId = mostanadatRokhdadId;
    }

    public String getShomarehSanad() {
        return shomarehSanad;
    }

    public void setShomarehSanad(String shomarehSanad) {
        this.shomarehSanad = shomarehSanad;
    }

    public java.sql.Date getTarikhSanad() {
        return tarikhSanad;
    }

    public void setTarikhSanad(java.sql.Date tarikhSanad) {
        this.tarikhSanad = tarikhSanad;
    }

    public java.sql.Date getTarikhSabt() {
        return tarikhSabt;
    }

    public void setTarikhSabt(java.sql.Date tarikhSabt) {
        this.tarikhSabt = tarikhSabt;
    }

    public String getSharh() {
        return sharh;
    }

    public void setSharh(String sharh) {
        this.sharh = sharh;
    }

    public String getNameParvande() {
        return nameParvande;
    }

    public void setNameParvande(String nameParvande) {
        this.nameParvande = nameParvande;
    }

    public String getRokhdadId() {
        return rokhdadId;
    }

    public void setRokhdadId(String rokhdadId) {
        this.rokhdadId = rokhdadId;
    }

    public Integer getRokhdadRokhdadId() {
        return rokhdadRokhdadId;
    }

    public void setRokhdadRokhdadId(Integer rokhdadRokhdadId) {
        this.rokhdadRokhdadId = rokhdadRokhdadId;
    }

    public java.lang.String getTarikhSanadHejri() {
		return tarikhSanadHejri;
	}

	public void setTarikhSanadHejri(java.lang.String tarikhSanad) {
		tarikhSanadHejri = tarikhSanad;
	}

    public java.lang.String getTarikhSabtHejri() {
		return tarikhSabtHejri;
	}

	public void setTarikhSabtHejri(java.lang.String tarikhSabt) {
		tarikhSabtHejri = tarikhSabt;
	}


}

