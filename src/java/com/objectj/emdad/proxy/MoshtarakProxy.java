
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface MoshtarakProxy extends EntityProxy {
    public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId, String bazaryabId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId, String bazaryabId) throws ProxyException;

}
