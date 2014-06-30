package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="PeigiriEzamgarSession"
 *    jndi-name="ejb/emdad/PeigiriEzamgarSession"
 *    local-jndi-name="ejb/emdad/PeigiriEzamgarSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.PeigiriEzamgarProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class PeigiriEzamgarSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return PeigiriEzamgarModel.class;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			PeigiriEzamgarList peigiriEzamgarList = new PeigiriEzamgarList();

			peigiriEzamgarList.setId(resultSet.getString("id"));
			peigiriEzamgarList.setNatije(resultSet.getString("natije"));

            peigiriEzamgarList.setEmdadEmdadId(new Integer(resultSet.getInt("emdadId")));
			String emdadId = resultSet.getString("emdadIdO");
			peigiriEzamgarList.setEmdadId(emdadId);
			EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
			if (emdadLocal != null) {
				peigiriEzamgarList.setEmdadEmdadId(emdadLocal.getEmdadModel().getEmdadId());
				peigiriEzamgarList.setEmdadVazeatKonuni(emdadLocal.getEmdadModel().getVazeatKonuni());
			}

            if (resultSet.getDate("zamanPeigiri") != null)
				peigiriEzamgarList.setZamanPeigiriHejri(HejriUtil.getDateTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("zamanPeigiri").getTime())));
//                peigiriEzamgarList.setZamanPeigiriHejri(HejriUtil.getTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("zamanEzam").getTime())) + " - " + HejriUtil.chrisToHejri(resultSet.getDate("zamanEzam")));
            else
                peigiriEzamgarList.setZamanPeigiriHejri("");

			if (resultSet.getTimestamp("zamanPeigiri") != null)
				peigiriEzamgarList.setZamanPeigiri2(HejriUtil.getTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("zamanPeigiri").getTime())));
			return peigiriEzamgarList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject modelToList(Object o) {
		PeigiriEzamgarLocal peigiriEzamgarLocal = (PeigiriEzamgarLocal)o;
		PeigiriEzamgarList peigiriEzamgarList = new PeigiriEzamgarList();
		PeigiriEzamgarModel peigiriEzamgarModel = peigiriEzamgarLocal.getPeigiriEzamgarModel();

		peigiriEzamgarList.setId(peigiriEzamgarModel.getId());
		peigiriEzamgarList.setNatije(peigiriEzamgarModel.getNatije());
		peigiriEzamgarList.setZamanPeigiri(peigiriEzamgarModel.getZamanPeigiri());

		EmdadLocal emdadLocal = peigiriEzamgarLocal.getEmdad();
		if (emdadLocal != null) {
			EmdadModel emdadModel = emdadLocal.getEmdadModel();
			peigiriEzamgarList.setEmdadId(emdadModel.getId());
			peigiriEzamgarList.setEmdadEmdadId(emdadModel.getEmdadId());
			peigiriEzamgarList.setEmdadVazeatKonuni(emdadModel.getVazeatKonuni());
		}
		return peigiriEzamgarList;
	}

	/**
		* @ejb.interface-method 
		* @ejb.transaction
		* 	 type = "Required"
		*/
	public ValueObject create(ValueObject valueObject, String emdadId) throws ProxyException {
		try {
			PeigiriEzamgarLocal peigiriEzamgarLocal = PeigiriEzamgarUtil.getLocalHome().create((PeigiriEzamgarModel)valueObject);
			EmdadLocal emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
			peigiriEzamgarLocal.setEmdad(emdadObject);
			return peigiriEzamgarLocal.getPeigiriEzamgarModel();
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
	public void update(ValueObject valueObject, String emdadId) throws ProxyException {
		try {
			PeigiriEzamgarLocal peigiriEzamgarLocal = PeigiriEzamgarUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
			if (emdadId != null) {
				EmdadLocal emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
				peigiriEzamgarLocal.setEmdad(emdadObject);
			}
			peigiriEzamgarLocal.setPeigiriEzamgarModel((PeigiriEzamgarModel)valueObject);
			return;
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
        setAsView(queryObject, "peigiriEzamgar", "view_PeigiriEzamgar");
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
        setAsView(queryObject, "peigiriEzamgar", "view_PeigiriEzamgar");
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
