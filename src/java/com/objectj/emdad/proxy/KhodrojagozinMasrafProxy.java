/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jul 26, 2003
 * Time: 3:54:15 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface KhodrojagozinMasrafProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject,String emdadId,String khodrojagozinId) throws ProxyException;
    public void update(ValueObject valueObject,String emdadId,String khodrojagozinId) throws ProxyException;
}
