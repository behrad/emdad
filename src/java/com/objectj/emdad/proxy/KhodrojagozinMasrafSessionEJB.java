/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: May 11, 2003
 * Time: 6:17:35 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Util;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="KhodrojagozinMasrafSession"
 *    jndi-name="ejb/emdad/KhodrojagozinMasrafSession"
 *    local-jndi-name="ejb/emdad/KhodrojagozinMasrafSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.KhodrojagozinMasrafProxy"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class KhodrojagozinMasrafSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    private final static int FAAL_BALI= 1;

    protected Class getValueObjectClass() {
        return KhodrojagozinMasrafModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public ValueObject create(ValueObject valueObject,String emdadId,String khodrojagozinId) throws ProxyException{
        try {

            KhodrojagozinMasrafLocal local = KhodrojagozinMasrafUtil.getLocalHome().create((KhodrojagozinMasrafModel)valueObject);
            EmdadLocal emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);

            KhodrojagozinLocal kjObject = KhodrojagozinUtil.getLocalHome().findByPrimaryKey(khodrojagozinId);
            KhodrojagozinModel kjModel = kjObject.getKhodrojagozinModel();
            kjModel.setFaal(new Integer(FAAL_BALI));
            kjObject.setKhodrojagozinModel(kjModel);

            EmdadModel emdadModel = emdadObject.getEmdadModel();
            emdadModel.setVazeatKonuni(new Integer(0));
            emdadObject.setEmdadModel1(emdadModel);
            local.setEmdad(emdadObject);
            local.setKhodrojagozin(kjObject);
            KhodrojagozinMasrafModel model =  local.getKhodrojagozinMasrafModel();

            return model;

        } catch (Exception exception) {
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        }

    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject,String emdadId,String khodrojagozinId) throws ProxyException{
        try{
            KhodrojagozinMasrafLocal local = KhodrojagozinMasrafUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            EmdadLocal emdadObject = null;
            try {
                emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
            } catch (javax.ejb.FinderException fe) {

            }

            KhodrojagozinLocal kjObject = KhodrojagozinUtil.getLocalHome().findByPrimaryKey(khodrojagozinId);
            local.setEmdad(emdadObject);
            local.setKhodrojagozin(kjObject);
            if (((KhodrojagozinMasrafModel)valueObject).getTarikhTahvilAzMoshtari() != null){
                EmdadModel emdadModel =  emdadObject.getEmdadModel();
                emdadModel.setVazeatKonuni(new Integer(2));
                emdadObject.setEmdadModel1(emdadModel);
            }
            local.setKhodrojagozinMasrafModel((KhodrojagozinMasrafModel)valueObject);
            return;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }

    public ValueObject modelToList(Object o) {
        KhodrojagozinMasrafLocal local = (KhodrojagozinMasrafLocal)o;
        KhodrojagozinMasrafList list = new KhodrojagozinMasrafList();
        KhodrojagozinMasrafModel model = local.getKhodrojagozinMasrafModel();

        list.setId(model.getId());
        list.setTarikhTahvilAzMoshtari(model.getTarikhTahvilAzMoshtari());
        list.setTarikhTahvilBeMoshtari(model.getTarikhTahvilBeMoshtari());

        if (model.getTarikhTahvilAzMoshtari() != null)
            list.setTarikhTahvilAzMoshtariHejri(HejriUtil.chrisToHejri(model.getTarikhTahvilAzMoshtari())  + "  " + HejriUtil.getTimeFromDate(new java.sql.Timestamp(model.getTarikhTahvilAzMoshtari().getTime())));
        else
            list.setTarikhTahvilAzMoshtariHejri("");

        if (model.getTarikhTahvilBeMoshtari() != null)
            list.setTarikhTahvilBeMoshtariHejri(HejriUtil.chrisToHejri(model.getTarikhTahvilBeMoshtari())  + "  " + HejriUtil.getTimeFromDate(new java.sql.Timestamp(model.getTarikhTahvilBeMoshtari().getTime())));
        else
            list.setTarikhTahvilBeMoshtariHejri("");

        EmdadLocal emdadLocal = local.getEmdad();
        if (emdadLocal != null) {
            EmdadModel emdadModel = emdadLocal.getEmdadModel();
            list.setEmdadId(emdadModel.getId());
            list.setEmdadEmdadId(emdadModel.getEmdadId().toString());
        }


        KhodrojagozinLocal khodroLocal = local.getKhodrojagozin();
        if (khodroLocal != null) {
            KhodrojagozinModel khodroModel = khodroLocal.getKhodrojagozinModel();
            list.setKhodrojagozinId(khodroModel.getId());
            list.setKhodrojagozinPelak(khodroModel.getShomarehPelak());
        }
        return list;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {

            KhodrojagozinMasrafList list = new KhodrojagozinMasrafList();

            list.setId(resultSet.getString("id"));
            list.setEmdadId(resultSet.getString("emdadIdO"));
            list.setEmdadEmdadId(resultSet.getString("emdadId"));
            list.setKhodrojagozinId(resultSet.getString("khodrojagozinId"));
            list.setKhodrojagozinPelak(resultSet.getString("shomarehPelak"));

//            try{
//                EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey(resultSet.getString("emdadId")) ;
//                if (emdadLocal != null) {
//                    EmdadModel emdadModel = emdadLocal.getEmdadModel();
//                    list.setEmdadId(emdadModel.getId());
//                    list.setEmdadEmdadId(emdadModel.getEmdadId().toString());
//                }

//                KhodrojagozinLocal khodroLocal = KhodrojagozinUtil.getLocalHome().findByPrimaryKey(resultSet.getString("khodrojagozinId")) ;
//                if (khodroLocal != null) {
//                    KhodrojagozinModel khodroModel = khodroLocal.getKhodrojagozinModel();
//                    list.setKhodrojagozinId(khodroModel.getId());
//                    list.setKhodrojagozinPelak(khodroModel.getShomarehPelak());
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }


            if (resultSet.getDate("tarikhTahvilBeMoshtari") != null)
                list.setTarikhTahvilBeMoshtariHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhTahvilBeMoshtari"))+"  "+HejriUtil.getTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("tarikhTahvilBeMoshtari").getTime())));
            else
                list.setTarikhTahvilBeMoshtariHejri("");

            if (resultSet.getDate("tarikhTahvilAzMoshtari") != null)
                list.setTarikhTahvilAzMoshtariHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhTahvilAzMoshtari"))+"  "+HejriUtil.getTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("tarikhTahvilAzMoshtari").getTime())));
            else
                list.setTarikhTahvilAzMoshtariHejri("");

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public ValueObject create() throws ProxyException {
        return super.create();
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public ValueObject create(ValueObject valueObject) throws ProxyException {
        return super.create(valueObject);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public ValueObject read(String id) throws ProxyException {
        return super.read(id);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult read(String[] ids) throws ProxyException {
        return super.read(ids);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult read(ValueObject valueObject) throws ProxyException {
        return super.read(valueObject);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult readByEntityId(Integer entityId) throws ProxyException {
        return super.readByEntityId(entityId);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult readCombo(String table, String field, String filter) throws ProxyException {
        return super.readCombo(table, field, filter);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult readCombo(String table, String field) throws ProxyException {
        return super.readCombo(table, field);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult readModel(QueryObject queryObject) throws ProxyException {
        return super.readModel(queryObject);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void remove(String id) throws ProxyException, ProxyReferenceException {
        super.remove(id);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void remove(String[] ids) throws ProxyException, ProxyReferenceException {
        super.remove(ids);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void remove(ValueObject valueObject) throws ProxyException, ProxyReferenceException {
        super.remove(valueObject);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject) throws ProxyException {
        super.update(valueObject);
    }


	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
        setAsView(queryObject, "khodrojagozinMasraf", "view_khodrojagozinMasraf");
		return super.readList(queryObject);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
        setAsView(queryObject, "khodrojagozinMasraf", "view_khodrojagozinMasraf");
		return super.report(queryObject, connection);
	}

}

