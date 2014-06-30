package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface MojoodiMojazProxy extends EntityProxy {
	public ValueObject create(ValueObject valueObject, String noeEmdadgarId, String qateId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String noeEmdadgarId, String qateId) throws ProxyException;
}
