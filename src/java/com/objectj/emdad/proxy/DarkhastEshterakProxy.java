/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: May 31, 2003
 * Time: 12:01:13 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface DarkhastEshterakProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId) throws ProxyException;

}
