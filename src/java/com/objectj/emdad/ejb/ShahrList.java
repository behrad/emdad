
package com.objectj.emdad.ejb;

import java.util.ArrayList;


public class ShahrList extends com.objectj.emdad.ejb.ShahrModel{

    private java.lang.String id;
    private java.lang.String ostanId;
    private java.lang.Integer shahrId;
    private java.lang.String shahrName;
    private java.lang.String ostanName;
    private java.lang.String codeShahrKhodrosaz;
    private java.lang.String taArze;
    private java.lang.String taToole;
    private java.lang.String azArze;
    private java.lang.String azToole;
    private java.lang.Integer taArz;
    private java.lang.Integer taTool;
    private java.lang.Integer azArz;
    private java.lang.Integer azTool;

    /*============================================================*/
    public String getShahrName() {
        return this.shahrName;
    }
    public void setShahrName(String shahrName) {
        this.shahrName = shahrName;
    }
    /*============================================================*/
    public String getOstanName() {
        return this.ostanName;
    }
    public void setOstanName(String ostanName) {
        this.ostanName = ostanName;
    }
    /*============================================================*/
    public java.lang.Integer getShahrId() {
        return this.shahrId;
    }
    public void setShahrId(java.lang.Integer shahrId) {
        this.shahrId = shahrId;
    }
    /*============================================================*/
    public String getOstanId() {
        return this.ostanId;
    }
    public void setOstanId(String ostanId) {
        this.ostanId = ostanId;
    }
    /*============================================================*/
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /*============================================================*/

    public String getCodeShahrKhodrosaz() {
        return codeShahrKhodrosaz;
    }

    public void setCodeShahrKhodrosaz(String codeShahrKhodrosaz) {
        this.codeShahrKhodrosaz = codeShahrKhodrosaz;
    }

    public String getTaArze() {
        return taArze;
    }

    public void setTaArze(String taArze) {
        this.taArze = taArze;
    }

    public String getTaToole() {
        return taToole;
    }

    public void setTaToole(String taToole) {
        this.taToole = taToole;
    }

    public String getAzArze() {
        return azArze;
    }

    public void setAzArze(String azArze) {
        this.azArze = azArze;
    }

    public String getAzToole() {
        return azToole;
    }

    public void setAzToole(String azToole) {
        this.azToole = azToole;
    }
///////////////////////////////////////////////////////////////////////

    public Integer getTaArz() {
        return taArz;
    }

    public void setTaArz(Integer taArz) {
        this.taArz = taArz;
    }

    public Integer getTaTool() {
        return taTool;
    }

    public void setTaTool(Integer taTool) {
        this.taTool = taTool;
    }

    public Integer getAzArz() {
        return azArz;
    }

    public void setAzArz(Integer azArz) {
        this.azArz = azArz;
    }

    public Integer getAzTool() {
        return azTool;
    }

    public void setAzTool(Integer azTool) {
        this.azTool = azTool;
    }

}
