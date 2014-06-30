package com.objectj.emdad.proxy;

/**
 * Created by IntelliJ IDEA.
 * User: hassan
 * Date: Jun 28, 2003
 * Time: 1:03:18 PM
 * To change this template use Options | File Templates.
 */

import com.objectj.emdad.ejb.NoeKhodroLocal;
import com.objectj.emdad.ejb.QateLocal;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface QateProxy extends EntityProxy {

    public ValueObject create( ValueObject valueObject, String noeKhodroId ) throws ProxyException;

    public ValueObject create( ValueObject valueObject, NoeKhodroLocal noeKhodroLocal ) throws ProxyException;


    public void update( ValueObject valueObject, String noeKhodroId ) throws ProxyException;

    public void update( ValueObject valueObject, NoeKhodroLocal noeKhodroLocal ) throws ProxyException;

    public void update( QateLocal qateLocal, NoeKhodroLocal noeKhodroLocal ) throws ProxyException;
}