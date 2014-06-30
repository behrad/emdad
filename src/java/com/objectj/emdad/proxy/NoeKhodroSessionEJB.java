package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.objectj.emdad.ejb.KhodrosazLocal;
import com.objectj.emdad.ejb.KhodrosazModel;
import com.objectj.emdad.ejb.KhodrosazUtil;
import com.objectj.emdad.ejb.NoeKhodroList;
import com.objectj.emdad.ejb.NoeKhodroLocal;
import com.objectj.emdad.ejb.NoeKhodroLocalHome;
import com.objectj.emdad.ejb.NoeKhodroModel;
import com.objectj.emdad.ejb.NoeKhodroUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="NoeKhodroSession"
 *    jndi-name="ejb/emdad/NoeKhodroSession"
 *    local-jndi-name="ejb/emdad/NoeKhodroSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.NoeKhodroProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */
public abstract class NoeKhodroSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

	protected static Logger log = Logger.getLogger(NoeKhodroSessionEJB.class.getName());

	protected Class getValueObjectClass() {
		return NoeKhodroModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String khodrosazId) throws ProxyException {
		try {
			KhodrosazLocal khodrosazObject = KhodrosazUtil.getLocalHome().findByPrimaryKey(khodrosazId);

			NoeKhodroLocalHome noeKhodroLocalHome = NoeKhodroUtil.getLocalHome();
			NoeKhodroLocal noeKhodroLocal = noeKhodroLocalHome.create((NoeKhodroModel)valueObject);
			noeKhodroLocal.setKhodrosaz(khodrosazObject);
			NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();

			return noeKhodroModel;

		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject, String khodrosazId) throws ProxyException {
		try {

			KhodrosazLocal khodrosazObject = KhodrosazUtil.getLocalHome().findByPrimaryKey(khodrosazId);

			NoeKhodroLocalHome noeKhodroLocalHome = NoeKhodroUtil.getLocalHome();
			NoeKhodroLocal noeKhodroLocal = noeKhodroLocalHome.findByPrimaryKey(valueObject.getId());
			noeKhodroLocal.setKhodrosaz(khodrosazObject);
			noeKhodroLocal.setNoeKhodroModel((NoeKhodroModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {

		NoeKhodroLocal noeKhodroLocal = (NoeKhodroLocal)o;
		NoeKhodroList noeKhodroList = new NoeKhodroList();
		NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();

		noeKhodroList.setNoeKhodroId(noeKhodroModel.getNoeKhodroId());
		noeKhodroList.setOnvan(noeKhodroModel.getOnvan());
		noeKhodroList.setGuarantee(noeKhodroModel.getGuarantee());
		noeKhodroList.setGuaranteeDistance(noeKhodroModel.getGuaranteeDistance());
		noeKhodroList.setKhodroCode(noeKhodroModel.getKhodroCode());
		noeKhodroList.setNoeKhodroCode(noeKhodroModel.getNoeKhodroCode());
		noeKhodroList.setId(noeKhodroModel.getId());

        noeKhodroList.setVijeh(noeKhodroModel.getVijeh());
        noeKhodroList.setVijehName(((ComboObject)Util.getFromArrayList("yesNo", noeKhodroModel.getVijeh())).getName());

        noeKhodroList.setHazinehSaat(noeKhodroModel.getHazinehSaat());
        noeKhodroList.setHazinehEshterakAdi(noeKhodroModel.getHazinehEshterakAdi()) ;
        noeKhodroList.setHazinehEshterakVijeh(noeKhodroModel.getHazinehEshterakVijeh()) ;
        noeKhodroList.setNoeService(noeKhodroModel.getNoeService());

		KhodrosazLocal khodrosazLocal = noeKhodroLocal.getKhodrosaz();
		// check for a valid relationship reference 
		if (khodrosazLocal != null) {
			KhodrosazModel khodrosazModel = khodrosazLocal.getKhodrosazModel();
			noeKhodroList.setKhodrosazId(khodrosazModel.getId());
			noeKhodroList.setKhodrosazName(khodrosazModel.getName());
		}

		return noeKhodroList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			NoeKhodroList noeKhodroList = new NoeKhodroList();

			noeKhodroList.setId(resultSet.getString("id"));
			noeKhodroList.setNoeKhodroId(new Integer(resultSet.getInt("noeKhodroId")));
			noeKhodroList.setOnvan(resultSet.getString("onvan"));
			noeKhodroList.setGuarantee(new Integer(resultSet.getInt("guarantee")));
			noeKhodroList.setGuaranteeDistance(new Integer(resultSet.getInt("guaranteeDistance")));
			noeKhodroList.setKhodroCode(resultSet.getString("khodroCode"));
			noeKhodroList.setNoeKhodroCode(resultSet.getString("noeKhodroCode"));
            noeKhodroList.setVijeh(new Integer(resultSet.getInt("vijeh")));
            noeKhodroList.setVijehName(((ComboObject)Util.getFromArrayList("yesNo", resultSet.getInt("vijeh"))).getName());
            noeKhodroList.setHazinehSaat(new Integer(resultSet.getInt("hazinehSaat")));
            noeKhodroList.setHazinehEshterakAdi(new Integer(resultSet.getInt("hazinehEshterakAdi")));
            noeKhodroList.setHazinehEshterakVijeh(new Integer(resultSet.getInt("hazinehEshterakVijeh")));
			//	noeKhodroList.setKhodrosazId(resultSet.getString("khodrosaz.id"));
			noeKhodroList.setKhodrosazName(resultSet.getString("name"));
            int nsId = resultSet.getInt("noeService");
            noeKhodroList.setNoeServiceName(((ComboObject)Util.getFromArrayList("noeService", nsId)).getName());

			return noeKhodroList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject resultSetToBean(ResultSet resultSet) {
		try {
			NoeKhodroModel noeKhodroModel = new NoeKhodroModel();
			noeKhodroModel.setId(resultSet.getString("id"));
			noeKhodroModel.setOnvan(resultSet.getString("onvan"));
			noeKhodroModel.setNoeKhodroId(new Integer(resultSet.getInt("noeKhodroId")));
			noeKhodroModel.setGuarantee(new Integer(resultSet.getInt("guarantee")));
			noeKhodroModel.setKhodroCode(resultSet.getString("khodrocode"));
            noeKhodroModel.setVijeh(new Integer(resultSet.getInt("vijeh")));
            noeKhodroModel.setHazinehSaat(new Integer(resultSet.getInt("hazinehSaat")));
            noeKhodroModel.setHazinehEshterakAdi(new Integer(resultSet.getInt("hazinehEshterakAdi")));
            noeKhodroModel.setHazinehEshterakVijeh(new Integer(resultSet.getInt("hazinehEshterakVijeh")));

			return noeKhodroModel;
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
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
        setAsView(queryObject, "noeKhodro", "view_noeKhodro");
		return super.readList(queryObject);
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
	 * 	 type = "Supports"
	 */
	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
        setAsView(queryObject, "noeKhodro", "view_noeKhodro");
		return super.report(queryObject, connection);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject) throws ProxyException {
		super.update(valueObject);
	}

}
