/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jun 24, 2003
 * Time: 1:49:26 PM
 * To change this template use Options | File Templates.
 */

package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;

public interface ShakhsProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String daftarOstaniId) throws ProxyException;
    public ValueObject update(ValueObject valueObject, String daftarOstaniId) throws ProxyException;

}







