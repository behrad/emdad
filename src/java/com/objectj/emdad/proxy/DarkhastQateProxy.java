/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Aug 4, 2003
 * Time: 3:53:33 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface DarkhastQateProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject,String qateId,String emdadgarId) throws ProxyException;
    public void update(ValueObject valueObject,String qateId,String emdadgarId) throws ProxyException;
}
