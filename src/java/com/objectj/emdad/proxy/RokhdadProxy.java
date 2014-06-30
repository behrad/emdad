
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.emdad.ejb.*;

public interface RokhdadProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject, String moshtarakId, String namayandegiId, String daftarOstaniId, String shahrId) throws ProxyException;
    public ValueObject create(ValueObject valueObject, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject, com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject) throws ProxyException ;
    public void create2(ValueObject valueObject, String moshtarakId, String namayandegiId, String daftarOstaniId, String shahrId) throws ProxyException ;
    public void update(ValueObject valueObject, String moshtarakId, String namayandegiId, String daftarOstaniId, String shahrId) throws ProxyException;
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject, com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject) throws ProxyException ;
    public void update(com.objectj.emdad.ejb.RokhdadLocal rokhdadLocal, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject, com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject) throws ProxyException ;
}
