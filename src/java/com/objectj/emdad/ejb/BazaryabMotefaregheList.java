/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Sep 6, 2003
 * Time: 4:10:09 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class BazaryabMotefaregheList extends com.objectj.emdad.ejb.BazaryabMotefaregheModel {
    private String id;
    private String name;
    private String address;
    private String tel;
    private String mobile;
    private String namePedar;
    private String shShenasname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNamePedar() {
        return namePedar;
    }

    public void setNamePedar(String namePedar) {
        this.namePedar = namePedar;
    }

    public String getShShenasname() {
        return shShenasname;
    }

    public void setShShenasname(String shShenasname) {
        this.shShenasname = shShenasname;
    }
}
