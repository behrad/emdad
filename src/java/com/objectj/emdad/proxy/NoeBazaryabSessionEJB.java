package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboObject;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="NoeBazaryabSession"
 *    jndi-name="ejb/emdad/NoeBazaryabSession"
 *    local-jndi-name="ejb/emdad/NoeBazaryabSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.EntityProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class NoeBazaryabSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return NoeBazaryabModel.class;
	}

	public ValueObject modelToList(Object o) {
		NoeBazaryabLocal noeBazaryabLocal = (NoeBazaryabLocal)o;

		NoeBazaryabList noeBazaryabList = new NoeBazaryabList();
		NoeBazaryabModel noeBazaryabModel = noeBazaryabLocal.getNoeBazaryabModel();

		noeBazaryabList.setId(noeBazaryabModel.getId());
		noeBazaryabList.setNoeBazaryabId(noeBazaryabModel.getNoeBazaryabId());
		noeBazaryabList.setOnvan(noeBazaryabModel.getOnvan());
		noeBazaryabList.setEntity(noeBazaryabModel.getEntity());
		noeBazaryabList.setEntityName(((ComboObject)Util.getFromArrayList("entityList", noeBazaryabModel.getEntity().intValue())).getName());

		return noeBazaryabList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			NoeBazaryabList noeBazaryabList = new NoeBazaryabList();
			noeBazaryabList.setId(resultSet.getString("id"));
			noeBazaryabList.setNoeBazaryabId(new Integer(resultSet.getInt("noeBazaryabId")));
			noeBazaryabList.setOnvan(resultSet.getString("onvan"));
			noeBazaryabList.setEntity(new Integer(resultSet.getInt("entity")));
			noeBazaryabList.setEntityName(((ComboObject)Util.getFromArrayList("entityList", resultSet.getInt("entity"))).getName());

			return noeBazaryabList;
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
