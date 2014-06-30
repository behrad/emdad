/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: May 10, 2003
 * Time: 8:36:22 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class AccessToEntity {
    public AccessToEntity(String entity, String access) {
        this.entity = entity;
        this.access = access;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void appendAccess(String s) {
        if (access.indexOf(s) == -1)
            this.access = this.access + s;
    }

    private String entity;
    private String access;
}
