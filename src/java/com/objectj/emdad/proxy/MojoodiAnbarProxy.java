package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface MojoodiAnbarProxy extends EntityProxy {
	public ValueObject create(ValueObject valueObject, String qateId) throws ProxyException;
	public ValueObject update(ValueObject valueObject, String qateId) throws ProxyException;
}
