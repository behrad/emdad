
package com.objectj.emdad.ejb;

import java.util.ArrayList;


public class BazaryabList extends com.objectj.emdad.ejb.BazaryabModel{

    private java.lang.String id;
    private java.lang.Integer bazaryabId;
    private java.lang.String noeBazaryabId;
    private java.lang.String noeBazaryabOnvan;
    private java.lang.String bazaryabKey;
    private java.lang.String bazaryabName;

    private static ArrayList theList;

    public BazaryabList() {
    }

    /*============================================================*/
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /*============================================================*/
    public java.lang.Integer getBazaryabId() {
        return this.bazaryabId;
    }
    public void setBazaryabId(java.lang.Integer bazaryabId) {
        this.bazaryabId = bazaryabId;
    }

    /*============================================================*/
    public String getNoeBazaryabId() {
        return this.noeBazaryabId;
    }
    public void setNoeBazaryabId(String noeBazaryabId) {
        this.noeBazaryabId = noeBazaryabId;
    }

    /*============================================================*/
    public String getNoeBazaryabOnvan() {
        return this.noeBazaryabOnvan;
    }
    public void setNoeBazaryabOnvan(String noeBazaryabOnvan) {
        this.noeBazaryabOnvan = noeBazaryabOnvan;
    }

    /*============================================================*/
    public String getBazaryabKey() {
        return this.bazaryabKey;
    }
    public void setBazaryabKey(String noeBazaryabKey) {
        this.bazaryabKey = noeBazaryabKey;
    }

    /*============================================================*/
    public String getBazaryabName() {
        return bazaryabName;
    }

    public void setBazaryabName(String bazaryabName) {
        this.bazaryabName = bazaryabName;
    }

}
