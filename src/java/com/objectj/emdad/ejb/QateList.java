/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jun 23, 2003
 * Time: 5:04:50 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class QateList extends com.objectj.emdad.ejb.QateModel {

    private String id;

    private Integer qateId;

    private String shomareFanni;

    private String name;

    private Integer vahedShomaresh;

    private Integer gheimat;

    private Integer satheMaharat;

    private String vahedShomareshName;

    private String noeKhodroId;

    public String getNoeKhodroId() {
        return noeKhodroId;
    }

    public void setNoeKhodroId( String noeKhodroId ) {
        this.noeKhodroId = noeKhodroId;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public Integer getQateId() {
        return qateId;
    }

    public void setQateId( Integer qateId ) {
        this.qateId = qateId;
    }

    public String getShomareFanni() {
        return shomareFanni;
    }

    public void setShomareFanni( String shomareFanni ) {
        this.shomareFanni = shomareFanni;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Integer getVahedShomaresh() {
        return vahedShomaresh;
    }

    public void setVahedShomaresh( Integer vahedShomaresh ) {
        this.vahedShomaresh = vahedShomaresh;
    }

    public Integer getGheimat() {
        return gheimat;
    }

    public void setGheimat( Integer gheimat ) {
        this.gheimat = gheimat;
    }

    public Integer getSatheMaharat() {
        return satheMaharat;
    }

    public void setSatheMaharat( Integer satheMaharat ) {
        this.satheMaharat = satheMaharat;
    }

    public String getVahedShomareshName() {
        return vahedShomareshName;
    }

    public void setVahedShomareshName( String vahedShomareshName ) {
        this.vahedShomareshName = vahedShomareshName;
    }


}
