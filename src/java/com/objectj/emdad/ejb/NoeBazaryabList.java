
package com.objectj.emdad.ejb;



public class NoeBazaryabList extends com.objectj.emdad.ejb.NoeBazaryabModel{

    private java.lang.String id;
    private java.lang.Integer noeBazaryabId;
    private java.lang.String onvan;
    private java.lang.Integer entity;
    private java.lang.String entityName;

    public NoeBazaryabList() {
    }

    /*============================================================*/
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /*============================================================*/
    public Integer getNoeBazaryabId() {
        return this.noeBazaryabId;
    }
    public void setNoeBazaryabId(Integer noeBazaryabId) {
        this.noeBazaryabId = noeBazaryabId;
    }

    /*============================================================*/
    public String getOnvan() {
        return this.onvan;
    }
    public void setOnvan(String onvan) {
        this.onvan = onvan;
    }

    /*============================================================*/
    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    /*============================================================*/
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
