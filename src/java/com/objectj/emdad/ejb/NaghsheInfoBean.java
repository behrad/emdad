/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Feb 28, 2004
 * Time: 1:21:16 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class NaghsheInfoBean implements com.objectj.jsa.model.ValueObject {
    private String id;

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private String ostanName;

    public void setOstanName( String ostanName ) {
        this.ostanName = ostanName;
    }

    public String getOstanName() {
        return ostanName;
    }

    private String shahrName;

    public void setShahrName( String shahrName ) {
        this.shahrName = shahrName;
    }

    public String getShahrName() {
        return shahrName;
    }

    private String namayandegiName;

    public void setNamayandegiName( String namayandegiName ) {
        this.namayandegiName = namayandegiName;
    }

    public String getNamayandegiName() {
        return namayandegiName;
    }

    private String emdadgarName;

    public void setEmdadgarName( String emdadgarName ) {
        this.emdadgarName = emdadgarName;
    }

    public String getEmdadgarName() {
        return emdadgarName;
    }
}
