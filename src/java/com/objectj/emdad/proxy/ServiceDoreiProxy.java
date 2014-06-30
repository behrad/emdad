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
import com.objectj.emdad.ejb.*;

public interface ServiceDoreiProxy extends EntityProxy {
    public ValueObject create(ValueObject valueObject, String moshtarakId, String namayandegiId) throws ProxyException;
    public ValueObject create(ValueObject valueObject, MoshtarakLocal moshtarakObject, NamayandegiLocal namayandegiObject) throws ProxyException ;
    public void update(ValueObject valueObject, String moshtarakId, String namayandegiId) throws ProxyException;
    public void update(ValueObject valueObject, MoshtarakLocal moshtarakObject, NamayandegiLocal namayandegiObject) throws ProxyException ;
    public void update(ServiceDoreiLocal serviceLocal, MoshtarakLocal moshtarakObject, NamayandegiLocal namayandegiObject) throws ProxyException ;
}
