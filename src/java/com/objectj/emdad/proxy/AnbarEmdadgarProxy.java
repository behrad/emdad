package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface AnbarEmdadgarProxy extends EntityProxy {
	public ValueObject create(ValueObject valueObject, String emdadgarId, String qateId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String emdadgarId, String qateId) throws ProxyException;
    public ValueObject update(String emdadgarId, String qateId, Integer mojoodi) throws ProxyException;
}
