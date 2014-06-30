/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 26, 2003
 * Time: 1:01:07 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

public class UseCaseModel {
    private int id;
    private String ucName;
    private String ucTitle;
    private String ucDescr;
    private String ucURL;
    private String ucOperation;

    public int showInMenu() {
        if (ucOperation.equalsIgnoreCase("l")) //|| ucOperation.equalsIgnoreCase("c"))
            return 1;
        else
            return 0;
    }
    public UseCaseModel() {
        ucName = "";
        ucTitle = "";
        ucDescr = "";
        ucURL = "";
        ucOperation = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUcName() {
        return ucName;
    }

    public void setUcName(String ucName) {
        this.ucName = ucName;
    }

    public String getUcTitle() {
        return ucTitle;
    }

    public void setUcTitle(String ucTitle) {
        this.ucTitle = ucTitle;
    }

    public String getUcDescr() {
        return ucDescr;
    }

    public void setUcDescr(String ucDescr) {
        this.ucDescr = ucDescr;
    }

    public String getUcURL() {
        return ucURL;
    }

    public void setUcURL(String ucURL) {
        this.ucURL = ucURL;
    }

    public String getUcOperation() {
        return ucOperation;
    }

    public void setUcOperation(String ucOperation) {
        this.ucOperation = ucOperation;
    }

}
