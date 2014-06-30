/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jul 2, 2003
 * Time: 5:04:11 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

import java.util.ArrayList;

public class MenuModel {
    private String bpName;
    private String bpTitle;
    private String bpDescr;
    private ArrayList usecases;

    public MenuModel() {
        bpName = "";
        bpTitle = "";
        bpDescr = "";
        usecases = new ArrayList();
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

    public ArrayList getUsecases() {
        return usecases;
    }

    public void setUsecases(ArrayList usecases) {
        this.usecases = usecases;
    }

    public void addUseCase(UseCaseModel uc) {
        usecases.add(uc);
    }

}
