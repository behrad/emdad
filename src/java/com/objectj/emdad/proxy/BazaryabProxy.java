/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: May 11, 2003
 * Time: 7:31:55 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface BazaryabProxy extends EntityProxy {
    public ValueObject create(ValueObject valueObject, String noeBazaryabId) throws ProxyException;
	public ValueObject update(ValueObject valueObject, String noeBazaryabId) throws ProxyException;
}
