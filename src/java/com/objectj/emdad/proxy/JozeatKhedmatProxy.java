package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.emdad.ejb.EmdadLocal;
import com.objectj.emdad.ejb.OjratLocal;
import com.objectj.emdad.ejb.QateLocal;
import com.objectj.emdad.ejb.IradLocal;

public interface JozeatKhedmatProxy extends EntityProxy {
	public ValueObject create(ValueObject valueObject, String emdadId, String ojratId, String qateId, String iradId) throws ProxyException;
	public ValueObject update(ValueObject valueObject, String emdadId, String ojratId, String qateId, String iradId) throws ProxyException;
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.EmdadLocal emdadObject, com.objectj.emdad.ejb.OjratLocal ojratObject, com.objectj.emdad.ejb.QateLocal qateObject, com.objectj.emdad.ejb.IradLocal iradObject) throws ProxyException ;
	public Integer sumHazineh(String khedmatId) throws ProxyException;
}
