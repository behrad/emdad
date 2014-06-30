
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface TamdidEshterakProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String moshtarakId) throws ProxyException;
	public ValueObject update(ValueObject valueObject, String moshtarakId) throws ProxyException;

}
