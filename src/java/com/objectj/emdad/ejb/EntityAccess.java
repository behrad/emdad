/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: May 5, 2003
 * Time: 3:03:37 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class EntityAccess {
    public EntityAccess() {
    }

    public EntityAccess(String access) {
        if (access==null)
            return;
        access = access.toUpperCase();
        setCreateAccess(access.indexOf('C')!=-1);
        setReadAccess(access.indexOf('R')!=-1);
        setUpdateAccess(access.indexOf('U')!=-1);
        setDeleteAccess(access.indexOf('D')!=-1);
        setListAccess(access.indexOf('L')!=-1);
        setSpecificAccess(access.indexOf('S')!=-1);
        setPrintAccess(access.indexOf('P')!=-1);
        setAllAccess(access.indexOf('A')!=-1);
    }

    public boolean getCreateAccess() {
        return createAccess;
    }

    public void setCreateAccess(boolean createAccess) {
        this.createAccess = createAccess;
    }

    public boolean getReadAccess() {
        return readAccess;
    }

    public void setReadAccess(boolean readAccess) {
        this.readAccess = readAccess;
    }

    public boolean getUpdateAccess() {
        return updateAccess;
    }

    public void setUpdateAccess(boolean updateAccess) {
        this.updateAccess = updateAccess;
    }

    public boolean getDeleteAccess() {
        return deleteAccess;
    }

    public void setDeleteAccess(boolean deleteAccess) {
        this.deleteAccess = deleteAccess;
    }

    public boolean getListAccess() {
        return listAccess;
    }

    public void setListAccess(boolean listAccess) {
        this.listAccess = listAccess;
    }

    public boolean isSpecificAccess() {
        return specificAccess;
    }

    public void setSpecificAccess(boolean specificAccess) {
        this.specificAccess = specificAccess;
    }

    public boolean isPrintAccess() {
        return printAccess;
    }

    public void setPrintAccess(boolean printAccess) {
        this.printAccess = printAccess;
    }

    public boolean getAllAccess() {
        return allAccess;
    }

    public void setAllAccess(boolean allAccess) {
        this.allAccess = allAccess;
    }

    private boolean createAccess = false;
    private boolean readAccess = false;
    private boolean updateAccess = false;
    private boolean deleteAccess = false;
    private boolean listAccess = false;
    private boolean specificAccess = false;
    private boolean printAccess = false;
    private boolean allAccess = false;
}
