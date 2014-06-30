/**
 * Created by IntelliJ IDEA.
 * User: hamid Abbasi
 * Date: Nov 12, 2003
 * Time: 5:58:45 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class Savabegh
        extends com.objectj.jsa.model.BaseValueObject
        implements java.io.Serializable {
    private java.lang.String id;
    private java.lang.Integer emdadId;
    private java.lang.Integer noeEmdad;
    private java.lang.String rahAndazi;
    private java.lang.String irad;
    private java.lang.String pazireshgarName;
    private java.lang.String ezamgarName;
    private java.lang.String emdadgarName;
    private java.lang.String namayandegiName;
    private java.lang.Integer namayandegiId;
    private java.lang.Integer rokhdadId;

    private java.sql.Timestamp zamanEzam;
    private java.lang.String zamanEzamHejri;

    private java.sql.Timestamp zamanShoro;
    private java.lang.String zamanShoroHejri;

    private java.sql.Timestamp zamanPayan;
    private java.lang.String zamanPayanHejri;

    private java.sql.Timestamp zamanTamas;
    private java.lang.String zamanTamasHejri;
    private java.lang.String tel;
    private java.lang.Integer kilometerKarkard;

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    private java.lang.String address;

    public Integer getNamayandegiId() {
        return namayandegiId;
    }

    public void setNamayandegiId( Integer namayandegiId ) {
        this.namayandegiId = namayandegiId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel( String tel ) {
        this.tel = tel;
    }

    public Integer getEmdadId() {
        return emdadId;
    }

    public void setEmdadId( Integer emdadId ) {
        this.emdadId = emdadId;
    }

    public Integer getNoeEmdad() {
        return noeEmdad;
    }

    public void setNoeEmdad( Integer emdad ) {
        this.noeEmdad = emdad;
    }

    public String getRahAndazi() {
        return rahAndazi;
    }

    public void setRahAndazi( String rahAndazi ) {
        this.rahAndazi = rahAndazi;
    }

    public String getIrad() {
        return irad;
    }

    public void setIrad( String irad ) {
        this.irad = irad;
    }

    public String getPazireshgarName() {
        return pazireshgarName;
    }

    public void setPazireshgarName( String pazireshgarName ) {
        this.pazireshgarName = pazireshgarName;
    }

    public String getEzamgarName() {
        return ezamgarName;
    }

    public void setEzamgarName( String ezamgarName ) {
        this.ezamgarName = ezamgarName;
    }

    public String getEmdadgarName() {
        return emdadgarName;
    }

    public void setEmdadgarName( String emdadgarName ) {
        this.emdadgarName = emdadgarName;
    }

    public String getNamayandegiName() {
        return namayandegiName;
    }

    public void setNamayandegiName( String namayandegiName ) {
        this.namayandegiName = namayandegiName;
    }

    public Integer getRokhdadId() {
        return rokhdadId;
    }

    public void setRokhdadId( Integer rokhdadId ) {
        this.rokhdadId = rokhdadId;
    }

    public java.sql.Timestamp getZamanEzam() {
        return zamanEzam;
    }

    public void setZamanEzam( java.sql.Timestamp zamanEzam ) {
        this.zamanEzam = zamanEzam;
    }

    public String getZamanEzamHejri() {
        return zamanEzamHejri;
    }

    public void setZamanEzamHejri( String zamanEzamHejri ) {
        this.zamanEzamHejri = zamanEzamHejri;
    }

    public java.sql.Timestamp getZamanShoro() {
        return zamanShoro;
    }

    public void setZamanShoro( java.sql.Timestamp zamanShoro ) {
        this.zamanShoro = zamanShoro;
    }

    public String getZamanShoroHejri() {
        return zamanShoroHejri;
    }

    public void setZamanShoroHejri( String zamanShoroHejri ) {
        this.zamanShoroHejri = zamanShoroHejri;
    }

    public java.sql.Timestamp getZamanPayan() {
        return zamanPayan;
    }

    public void setZamanPayan( java.sql.Timestamp zamanPayan ) {
        this.zamanPayan = zamanPayan;
    }

    public String getZamanPayanHejri() {
        return zamanPayanHejri;
    }

    public void setZamanPayanHejri( String zamanPayanHejri ) {
        this.zamanPayanHejri = zamanPayanHejri;
    }

    public java.sql.Timestamp getZamanTamas() {
        return zamanTamas;
    }

    public void setZamanTamas( java.sql.Timestamp zamanTamas ) {
        this.zamanTamas = zamanTamas;
    }

    public String getZamanTamasHejri() {
        return zamanTamasHejri;
    }

    public void setZamanTamasHejri( String zamanTamasHejri ) {
        this.zamanTamasHejri = zamanTamasHejri;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public Integer getKilometerKarkard() {
        return kilometerKarkard;
    }

    public void setKilometerKarkard( Integer kilometerKarkard ) {
        this.kilometerKarkard = kilometerKarkard;
    }
}
