/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jul 7, 2003
 * Time: 1:29:53 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

public class BPModel {
    private int id;
    private String bpName;
    private String bpTitle;
    private String bpDescr;
    private int bpCode;

    public BPModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBpName() {
        return bpName;
    }

    public void setBpName(String bpName) {
        this.bpName = bpName;
    }

    public String getBpTitle() {
        return bpTitle;
    }

    public void setBpTitle(String bpTitle) {
        this.bpTitle = bpTitle;
    }

    public String getBpDescr() {
        return bpDescr;
    }

    public void setBpDescr(String bpDescr) {
        this.bpDescr = bpDescr;
    }

    public int getBpCode() {
        return bpCode;
    }

    public void setBpCode(int bpCode) {
        this.bpCode = bpCode;
    }
}
