
package com.objectj.emdad.ejb;

public class ShakhsList extends com.objectj.emdad.ejb.ShakhsModel{
    private String id;
    private Integer shakhsId;
    private String name;
    private Integer naghshId;
    private String daftarOstaniId;
    private String daftarOstaniName;
    private String naghshName;
    private String entityId;
    private String entityName;
    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNaghshName() {
        return naghshName;
    }

    public void setNaghshName(String naghshName) {
        this.naghshName = naghshName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getShakhsId() {
        return shakhsId;
    }

    public void setShakhsId(Integer shakhsId) {
        this.shakhsId = shakhsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNaghshId() {
        return naghshId;
    }

    public void setNaghshId(Integer naghshId) {
        this.naghshId = naghshId;
    }

    public String getDaftarOstaniId() {
        return daftarOstaniId;
    }

    public void setDaftarOstaniId(String daftarOstaniId) {
        this.daftarOstaniId = daftarOstaniId;
    }

    public String getDaftarOstaniName() {
        return daftarOstaniName;
    }

    public void setDaftarOstaniName(String daftarOstaniName) {
        this.daftarOstaniName = daftarOstaniName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
