
package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.MojoodiAnbarList;
import com.objectj.emdad.ejb.MojoodiAnbarLocal;
import com.objectj.emdad.ejb.MojoodiAnbarLocalHome;
import com.objectj.emdad.ejb.MojoodiAnbarModel;
import com.objectj.emdad.ejb.MojoodiAnbarUtil;
import com.objectj.emdad.ejb.QateLocal;
import com.objectj.emdad.ejb.QateModel;
import com.objectj.emdad.ejb.QateUtil;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="MojoodiAnbarSession"
 *    jndi-name="ejb/emdad/MojoodiAnbarSession"
 *    local-jndi-name="ejb/emdad/MojoodiAnbarSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.MojoodiAnbarProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class MojoodiAnbarSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return MojoodiAnbarModel.class;
    }

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String qateId) throws ProxyException {
		try {
			QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

			MojoodiAnbarLocalHome mojoodiAnbarLocalHome = MojoodiAnbarUtil.getLocalHome();
			MojoodiAnbarLocal mojoodiAnbarLocal = mojoodiAnbarLocalHome.create((MojoodiAnbarModel)valueObject);
			mojoodiAnbarLocal.setQate(qateObject);
			MojoodiAnbarModel mojoodiAnbarModel = mojoodiAnbarLocal.getMojoodiAnbarModel();
			return mojoodiAnbarModel;
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
	public void update(ValueObject valueObject,String qateId) throws ProxyException {
		try {
			QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

			MojoodiAnbarLocalHome mojoodiAnbarLocalHome = MojoodiAnbarUtil.getLocalHome();
			MojoodiAnbarLocal mojoodiAnbarLocal = mojoodiAnbarLocalHome.findByPrimaryKey(valueObject.getId());
			mojoodiAnbarLocal.setQate(qateObject);
			mojoodiAnbarLocal.setMojoodiAnbarModel((MojoodiAnbarModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}


	public ValueObject modelToList(Object o) {
		MojoodiAnbarLocal mojoodiAnbarLocal = (MojoodiAnbarLocal)o;

		MojoodiAnbarList mojoodiAnbarList = new MojoodiAnbarList();
		MojoodiAnbarModel mojoodiAnbarModel = mojoodiAnbarLocal.getMojoodiAnbarModel();

		mojoodiAnbarList.setId(mojoodiAnbarModel.getId());
        mojoodiAnbarList.setMojoodi(mojoodiAnbarModel.getMojoodi());
        mojoodiAnbarList.setAnbarId(mojoodiAnbarModel.getAnbarId());

		QateLocal qateLocal = mojoodiAnbarLocal.getQate();
		// check for a valid relationship reference 
		if (qateLocal != null) {
			QateModel qateModel = qateLocal.getQateModel();
			mojoodiAnbarList.setShomareFanni(qateModel.getShomareFanni());
			mojoodiAnbarList.setQateName(qateModel.getName());
            mojoodiAnbarList.setQateId(qateModel.getId());
		}
		return mojoodiAnbarList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			MojoodiAnbarList mojoodiAnbarList = new MojoodiAnbarList();

			mojoodiAnbarList.setId(resultSet.getString("id"));
			mojoodiAnbarList.setMojoodi(new Integer(resultSet.getInt("mojoodi")));
            mojoodiAnbarList.setShomareFanni(resultSet.getString("shomareFanni"));
			mojoodiAnbarList.setQateName(resultSet.getString("qateName"));
			return mojoodiAnbarList;
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
        setAsView(queryObject, "mojoodiAnbar", "view_mojoodiAnbar");
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
        setAsView(queryObject, "mojoodiAnbar", "view_mojoodiAnbar");
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
