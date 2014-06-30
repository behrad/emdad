/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jun 26, 2003
 * Time: 10:52:14 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface MostanadatRokhdadProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String rokhdadId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String rokhdadId) throws ProxyException;

}
