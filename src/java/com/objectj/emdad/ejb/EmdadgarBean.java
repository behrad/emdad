package com.objectj.emdad.ejb;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad
 * Date: Nov 16, 2003
 * Time: 6:50:23 PM
 * To change this template use Options | File Templates.
 */

public class EmdadgarBean implements com.objectj.jsa.model.ValueObject {

    private String id;

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private String name;

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String noeEmdadgarId;

    public void setNoeEmdadgarId( String noeId ) {
        noeEmdadgarId = noeId;
    }

    public String getNoeEmdadgarId() {
        return noeEmdadgarId;
    }

}
