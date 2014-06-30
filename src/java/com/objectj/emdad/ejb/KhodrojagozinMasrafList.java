/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jul 26, 2003
 * Time: 3:41:09 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class KhodrojagozinMasrafList extends com.objectj.emdad.ejb.KhodrojagozinMasrafModel{
    private java.lang.String emdadId;
    private java.lang.String khodrojagozinId;
    private java.lang.String khodrojagozinPelak;

    private java.lang.String emdadEmdadId;
    private java.sql.Timestamp tarikhTahvilBeMoshtari;
    private java.lang.String tarikhTahvilBeMoshtariHejri;
    private java.sql.Timestamp tarikhTahvilAzMoshtari;
    private java.lang.String tarikhTahvilAzMoshtariHejri;
    private java.lang.String id;

    public String getKhodrojagozinPelak() {
        return khodrojagozinPelak;
    }

    public void setKhodrojagozinPelak(String khodrojagozinPelak) {
        this.khodrojagozinPelak = khodrojagozinPelak;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmdadId() {
        return emdadId;
    }

    public void setEmdadId(String emdadId) {
        this.emdadId = emdadId;
    }

    public String getKhodrojagozinId() {
        return khodrojagozinId;
    }

    public void setKhodrojagozinId(String khodrojagozinId) {
        this.khodrojagozinId = khodrojagozinId;
    }

    public String getEmdadEmdadId() {
        return emdadEmdadId;
    }

    public void setEmdadEmdadId(String emdadEmdadId) {
        this.emdadEmdadId = emdadEmdadId;
    }

    public java.sql.Timestamp getTarikhTahvilBeMoshtari() {
        return tarikhTahvilBeMoshtari;
    }

    public void setTarikhTahvilBeMoshtari(java.sql.Timestamp tarikhTahvilBeMoshtari) {
        this.tarikhTahvilBeMoshtari = tarikhTahvilBeMoshtari;
    }

    public String getTarikhTahvilBeMoshtariHejri() {
        return tarikhTahvilBeMoshtariHejri;
    }

    public void setTarikhTahvilBeMoshtariHejri(String tarikhTahvilBeMoshtariHejri) {
        this.tarikhTahvilBeMoshtariHejri = tarikhTahvilBeMoshtariHejri;
    }

    public java.sql.Timestamp getTarikhTahvilAzMoshtari() {
        return tarikhTahvilAzMoshtari;
    }

    public void setTarikhTahvilAzMoshtari(java.sql.Timestamp tarikhTahvilAzMoshtari) {
        this.tarikhTahvilAzMoshtari = tarikhTahvilAzMoshtari;
    }

    public String getTarikhTahvilAzMoshtariHejri() {
        return tarikhTahvilAzMoshtariHejri;
    }

    public void setTarikhTahvilAzMoshtariHejri(String tarikhTahvilAzMoshtariHejri) {
        this.tarikhTahvilAzMoshtariHejri = tarikhTahvilAzMoshtariHejri;
    }

}
