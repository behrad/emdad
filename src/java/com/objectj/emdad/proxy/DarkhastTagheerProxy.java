package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface DarkhastTagheerProxy extends EntityProxy{
	public ValueObject create(ValueObject valueObject, String moshtarakId, String shahrId, String rangeKhodroId) throws ProxyException;
	public ValueObject update(ValueObject valueObject, String moshtarakId, String shahrId, String rangeKhodroId) throws ProxyException;

}
