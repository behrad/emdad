/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jul 12, 2003
 * Time: 3:35:54 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface PeigiriEzamgarProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String emdadId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String emdadId) throws ProxyException;

}
