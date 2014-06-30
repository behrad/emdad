/**
 * Created by IntelliJ IDEA.
 * User: hamid
 * Date: Jun 28, 2003
 * Time: 1:03:18 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.emdad.ejb.EmdadModel;

import java.sql.PreparedStatement;

public interface EmdadProxy extends EntityProxy{
    public ValueObject create(ValueObject valueObject,String rokhdadId,String vazeatKhedmatId,String emdadgarId, String ezamgarId, String dalileToolKeshidaneEmdadId, String namayandegiId) throws ProxyException;
    public ValueObject create(ValueObject valueObject,  com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                       com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException ;
    public ValueObject create(ValueObject rovalueObject,ValueObject emvalueObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                       com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject,
                       com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject,com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject) throws ProxyException ;
    public ValueObject create(ValueObject rovalueObject,ValueObject emvalueObject, String vazeatId, String emdadgarId,
                       String ezamgarId,   String dalilId,        String namayandegiId,
                       String moshtarakId, String daftarOstaniId, String shahrId) throws ProxyException;
    public void update(ValueObject valueObject,String rokhdadId,String vazeatKhedmatId,String emdadgarId, String ezamgarId, String dalileToolKeshidaneEmdadId, String namayandegiId) throws ProxyException;
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                       com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException ;
    public void update(com.objectj.emdad.ejb.EmdadLocal emdadLocal, com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                       com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException ;
    public void payan(PreparedStatement prepStmt) throws ProxyException;
    public void payan(com.objectj.emdad.ejb.EmdadModel vo, String akharinTagheerDahandeh, String dalileToolKeshidaneEmdadId, String emdadgarId, String namayandegiId) throws ProxyException ;
}
