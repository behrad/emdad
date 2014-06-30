
package com.objectj.emdad.ejb;

import java.util.ArrayList;


public class NamayandegiList extends com.objectj.emdad.ejb.NamayandegiModel{


   private java.lang.String id;
   private java.lang.Integer namayandegiId;
   private java.lang.String name;
   private java.lang.String namayandegiTel;
   private java.lang.String namayandegiMobile;
   private java.lang.String namayandegiFax;
   private java.lang.String namayandegiAddress;
   private java.lang.String emdadgar;
   private java.sql.Date tarikhTahvil;
   private java.lang.Integer sabegheNoroozi;
   private java.lang.Integer sabegheFaaliat;
   private java.sql.Date tarikhGharardad;
   private java.lang.String tahtePooshesh;
   private java.lang.Integer nazarIsaco;
   private java.lang.Integer vazGharardad;
   private java.lang.Integer olaviat;
    private java.lang.Integer saghfeRiali;
    private java.lang.Integer hadaksarKar;
    private java.lang.Integer karDarDast;
    private java.lang.Integer hadaksarKar2;
    private java.lang.Integer karDarDast2;
   private java.lang.String shomarehGharardad;
    private java.sql.Date tarikhAkharinEstelam;
    private java.lang.String tarikhAkharinEstelamHejri;
    private java.lang.String dastgahEybyab;
    private java.lang.String telZaroori;
    private java.lang.String email;

   private java.lang.String daftarOstaniId;
   private java.lang.String daftarOstaniName;
   private java.lang.String shahrId;
   private java.lang.String shahrName;
   private java.lang.String noeKhodroId;
   private java.lang.String noeKhodroOnvan;
   private java.lang.Integer noeNamayandegi;
    private java.lang.String noeNamayandegiName;
    private java.lang.Integer codeMantaghe;

    public Integer getHadaksarKar2() {
        return hadaksarKar2;
    }

    public void setHadaksarKar2(Integer hadaksarKar2) {
        this.hadaksarKar2 = hadaksarKar2;
    }

    public Integer getKarDarDast2() {
        return karDarDast2;
    }

    public void setKarDarDast2(Integer karDarDast2) {
        this.karDarDast2 = karDarDast2;
    }

    public Integer getCodeMantaghe() {
        return codeMantaghe;
    }

    public void setCodeMantaghe(Integer codeMantaghe) {
        this.codeMantaghe = codeMantaghe;
    }


    public String getNoeNamayandegiName() {
        return noeNamayandegiName;
    }

    public void setNoeNamayandegiName(String noeNamayandegiName) {
        this.noeNamayandegiName = noeNamayandegiName;
    }

    public Integer getNoeNamayandegi() {
        return noeNamayandegi;
    }

    public void setNoeNamayandegi(Integer noeNamayandegi) {
        this.noeNamayandegi = noeNamayandegi;
    }

    public String getTarikhAkharinEstelamHejri() {
        return tarikhAkharinEstelamHejri;
    }

    public void setTarikhAkharinEstelamHejri(String tarikhAkharinEstelamHejri) {
        this.tarikhAkharinEstelamHejri = tarikhAkharinEstelamHejri;
    }

 public java.sql.Date getTarikhAkharinEstelam() {
        return tarikhAkharinEstelam;
    }

    public void setTarikhAkharinEstelam(java.sql.Date tarikhAkharinEstelam) {
        this.tarikhAkharinEstelam = tarikhAkharinEstelam;
    }

    public String getDastgahEybyab() {
        return dastgahEybyab;
    }

    public void setDastgahEybyab(String dastgahEybyab) {
        this.dastgahEybyab = dastgahEybyab;
    }

    public String getTelZaroori() {
        return telZaroori;
    }

    public void setTelZaroori(String telZaroori) {
        this.telZaroori = telZaroori;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    /*============================================================*/
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*============================================================*/
    public Integer getNamayandegiId() {
        return this.namayandegiId;
    }
    public void setNamayandegiId(Integer namayandegiId) {
        this.namayandegiId = namayandegiId;
    }
    /*============================================================*/
    public String getNamayandegiTel() {
        return this.namayandegiTel;
    }
    public void setNamayandegiTel(String namayandegiTel) {
        this.namayandegiTel = namayandegiTel;
    }
    /*============================================================*/
    public String getNamayandegiMobile() {
        return this.namayandegiMobile;
    }
    public void setNamayandegiMobile(String namayandegiMobile) {
        this.namayandegiMobile = namayandegiMobile;
    }
    /*============================================================*/
    public String getNamayandegiFax() {
        return this.namayandegiFax;
    }
    public void setNamayandegiFax(String namayandegiFax) {
        this.namayandegiFax = namayandegiFax;
    }
    /*============================================================*/

    public String getNamayandegiAddress() {
        return this.namayandegiAddress;
    }
    public void setNamayandegiAddress(String namayandegiAddress) {
        this.namayandegiAddress = namayandegiAddress;
    }
    /*============================================================*/

    public String getTahtePooshesh() {
        return this.tahtePooshesh;
    }
    public void setTahtePooshesh(String tahtePooshesh) {
        this.tahtePooshesh = tahtePooshesh;
    }
    /*============================================================*/
    public String getEmdadgar() {
        return this.emdadgar;
    }
    public void setEmdadgar(String emdadgar) {
        this.emdadgar = emdadgar;
    }
    /*============================================================*/
    public String getNoeKhodroOnvan() {
        return this.noeKhodroOnvan;
    }
    public void setNoeKhodroOnvan(String noeKhodroId) {
        this.noeKhodroOnvan = noeKhodroId;
    }
    /*============================================================*/
    public String getShahrName() {
        return this.shahrName;
    }
    public void setShahrName(String shahrId) {
        this.shahrName = shahrId;
    }
    /*============================================================*/
    public java.sql.Date getTarikhTahvil() {
        return this.tarikhTahvil;
    }
    public void setTarikhTahvil(java.sql.Date tarikhTahvil) {
        this.tarikhTahvil = tarikhTahvil;
    }

    /*============================================================*/
    public java.sql.Date getTarikhGharardad() {
        return this.tarikhGharardad;
    }
    public void setTarikhGharardad(java.sql.Date tarikhGharardad) {
        this.tarikhGharardad = tarikhGharardad;
    }
    /*============================================================*/
    public Integer getOlaviat() {
        return this.olaviat;
    }
    public void setOlaviat(Integer olaviat) {
        this.olaviat = olaviat;
    }

    /*============================================================*/
    public Integer getVazGharardad() {
        return this.vazGharardad;
    }
    public void setVazGharardad(Integer vazGharardad) {
        this.vazGharardad = vazGharardad;
    }

    /*============================================================*/
    public Integer getNazarIsaco() {
        return this.nazarIsaco;
    }
    public void setNazarIsaco(Integer nazarIsaco) {
        this.nazarIsaco = nazarIsaco;
    }
    /*============================================================*/
    public Integer getSabegheFaaliat() {
        return this.sabegheFaaliat;
    }
    public void setSabegheFaaliat(Integer sabegheFaaliat) {
        this.sabegheFaaliat = sabegheFaaliat;
    }
    /*============================================================*/
    public Integer getSabegheNoroozi() {
        return this.sabegheNoroozi;
    }
    public void setSabegheNoroozi(Integer sabegheNoroozi) {
        this.sabegheNoroozi = sabegheNoroozi;
    }

    /**
     * @return
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * @return
     */
    public java.lang.String getNoeKhodroId() {
        return noeKhodroId;
    }

    /**
     * @return
     */
    public java.lang.String getShahrId() {
        return shahrId;
    }

    /**
     * @param string
     */
    public void setId(java.lang.String string) {
        id = string;
    }

    /**
     * @param string
     */
    public void setNoeKhodroId(java.lang.String string) {
        noeKhodroId = string;
    }

    /**
     * @param string
     */
    public void setShahrId(java.lang.String string) {
        shahrId = string;
    }

    /**
     * @return
     */
    public java.lang.String getShomarehGharardad() {
        return shomarehGharardad;
    }

    /**
     * @param string
     */
    public void setShomarehGharardad(java.lang.String string) {
        shomarehGharardad = string;
    }

    public Integer getSaghfeRiali() {
        return saghfeRiali;
    }

    public void setSaghfeRiali(Integer saghfeRiali) {
        this.saghfeRiali = saghfeRiali;
    }

    public Integer getHadaksarKar() {
        return hadaksarKar;
    }

    public void setHadaksarKar(Integer hadaksarKar) {
        this.hadaksarKar = hadaksarKar;
    }

    public Integer getKarDarDast() {
        return karDarDast;
    }

    public void setKarDarDast(Integer karDarDast) {
        this.karDarDast = karDarDast;
    }
}
