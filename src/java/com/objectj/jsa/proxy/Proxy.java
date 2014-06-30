/*
 * Proxy.java
 *
 * Created on March 9, 2003, 1:04 PM
 */

package com.objectj.jsa.proxy;

import com.objectj.jsa.model.ValueObject;

import java.util.Collection;

/**
 *
 * @author  hossein
 */
public interface Proxy {

    public ValueObject create(Class modelClass) throws ProxyException;
    public ValueObject read(Class modelClass, String id) throws ProxyException;
    public void remove(Class modelClass, String id) throws ProxyException , ProxyReferenceException ;
    public void remove(Class modelClass, String[] ids) throws ProxyException,ProxyReferenceException;
    public Collection read(Class modelClass, String[] ids) throws ProxyException;
    public Collection read(ValueObject valueObject) throws ProxyException;
    public Collection readAll(Class modelClass) throws ProxyException;
    public void update(ValueObject valueObject) throws ProxyException;
    public void remove(ValueObject valueObject) throws ProxyException;
    public ValueObject create(ValueObject valueObject) throws ProxyException;
    public Collection readByEntityId(Class aClass, java.lang.Integer entityId) throws ProxyException;
    public ValueObject createNoeKhodro(Class modelClass,ValueObject valueObject) throws ProxyException ;
    public Collection readAllNoeKhodro() throws ProxyException ;
    public ValueObject readNoeKhodroList(String id) throws ProxyException;
    public Collection readAllNoeKhodroList() throws ProxyException;
//    public com.objectj.emdad.proxy.ProxySessionRemote getProxySession() throws ProxyException ;
}
