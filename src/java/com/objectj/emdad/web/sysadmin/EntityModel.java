/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 28, 2003
 * Time: 5:33:25 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

import java.util.ArrayList;

public class EntityModel {
    private int id;
    private String entityName;
    private String entityTitle;
    private String entityDescr;
    private ArrayList useCases;

    public EntityModel() {
        entityName = "";
        entityTitle = "";
        entityDescr = "";
        useCases = new ArrayList();
    }

    public void addUC(UseCaseModel uc) {
        useCases.add(uc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntityTitle() {
        return entityTitle;
    }

    public void setEntityTitle(String entityTitle) {
        this.entityTitle = entityTitle;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public ArrayList getUseCases() {
        return useCases;
    }

    public void setUseCases(ArrayList useCases) {
        this.useCases = useCases;
    }

    public String getEntityDescr() {
        return entityDescr;
    }

    public void setEntityDescr(String entityDescr) {
        this.entityDescr = entityDescr;
    }
}
