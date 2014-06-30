
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import org.apache.log4j.Logger;
import com.objectj.emdad.ejb.NoeEmdadgarLocal;
import com.objectj.emdad.ejb.NoeEmdadgarModel;
import com.objectj.emdad.ejb.NoeEmdadgarUtil;
import com.objectj.emdad.ejb.QateLocal;
import com.objectj.emdad.ejb.QateModel;
import com.objectj.emdad.ejb.QateUtil;
import com.objectj.emdad.ejb.MojoodiMojazList;
import com.objectj.emdad.ejb.MojoodiMojazLocal;
import com.objectj.emdad.ejb.MojoodiMojazLocalHome;
import com.objectj.emdad.ejb.MojoodiMojazModel;
import com.objectj.emdad.ejb.MojoodiMojazUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="MojoodiMojazSession"
 *    jndi-name="ejb/emdad/MojoodiMojazSession"
 *    local-jndi-name="ejb/emdad/MojoodiMojazSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.MojoodiMojazProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class MojoodiMojazSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return MojoodiMojazModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public ValueObject create(ValueObject valueObject, String noeEmdadgarId, String qateId) throws ProxyException {
        try {
            NoeEmdadgarLocal noeemdadgarObject = NoeEmdadgarUtil.getLocalHome().findByPrimaryKey(noeEmdadgarId);
            QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

            MojoodiMojazLocalHome mojoodiMojazLocalHome = MojoodiMojazUtil.getLocalHome();
            MojoodiMojazLocal mojoodiMojazLocal = mojoodiMojazLocalHome.create((MojoodiMojazModel)valueObject);
            mojoodiMojazLocal.setNoeEmdadgar(noeemdadgarObject);
            mojoodiMojazLocal.setQate(qateObject);
            MojoodiMojazModel mojoodiMojazModel = mojoodiMojazLocal.getMojoodiMojazModel();

            return mojoodiMojazModel;

        } catch (Exception exception) {
//            exception.printStackTrace();
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject, String noeEmdadgarId, String qateId) throws ProxyException {
        try {

            NoeEmdadgarLocal noeemdadgarObject = NoeEmdadgarUtil.getLocalHome().findByPrimaryKey(noeEmdadgarId);
            QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

            MojoodiMojazLocalHome mojoodiMojazLocalHome = MojoodiMojazUtil.getLocalHome();
            MojoodiMojazLocal mojoodiMojazLocal = mojoodiMojazLocalHome.findByPrimaryKey(valueObject.getId());

            mojoodiMojazLocal.setNoeEmdadgar(noeemdadgarObject);
            mojoodiMojazLocal.setQate(qateObject);
            mojoodiMojazLocal.setMojoodiMojazModel((MojoodiMojazModel)valueObject);
            return;
        } catch (Exception exception) {
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

    public ValueObject modelToList(Object o) {

        MojoodiMojazLocal mojoodiMojazLocal = (MojoodiMojazLocal)o;
        MojoodiMojazList mojoodiMojazList = new MojoodiMojazList();
        MojoodiMojazModel mojoodiMojazModel = mojoodiMojazLocal.getMojoodiMojazModel();

        mojoodiMojazList.setTedad(mojoodiMojazModel.getTedad());
        mojoodiMojazList.setId(mojoodiMojazModel.getId());

        NoeEmdadgarLocal noeEmdadgarLocal = mojoodiMojazLocal.getNoeEmdadgar();
        if (noeEmdadgarLocal != null) {
            NoeEmdadgarModel noeEmdadgarModel = noeEmdadgarLocal.getNoeEmdadgarModel();
            mojoodiMojazList.setNoeEmdadgarId(noeEmdadgarModel.getId());
            mojoodiMojazList.setNoeEmdadgarOnvan(noeEmdadgarModel.getOnvan());
        }

        QateLocal qateLocal = mojoodiMojazLocal.getQate();
        // check for a valid relationship reference
        if (qateLocal != null) {
            QateModel qateModel = qateLocal.getQateModel();
            mojoodiMojazList.setQateId(qateModel.getId());
            mojoodiMojazList.setQateName(qateModel.getName());
            mojoodiMojazList.setShomarehFanni(qateModel.getShomareFanni());
        }

        return mojoodiMojazList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            MojoodiMojazList mojoodiMojazList = new MojoodiMojazList();

            mojoodiMojazList.setId(resultSet.getString("id"));
//            mojoodiMojazList.setNoeEmdadgarId(resultSet.getString("noeEmdadgarId"));
            mojoodiMojazList.setNoeEmdadgarOnvan(resultSet.getString("noeEmdadgarOnvan"));
//            mojoodiMojazList.setQateId(resultSet.getString("qateId"));
            mojoodiMojazList.setShomarehFanni(resultSet.getString("shomarehFanni"));
            mojoodiMojazList.setQateName(resultSet.getString("qateName"));
            mojoodiMojazList.setTedad(new Integer(resultSet.getInt("tedad")));

            return mojoodiMojazList;
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
        setAsView(queryObject, "mojoodiMojaz", "view_mojoodiMojaz");
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
        setAsView(queryObject, "mojoodiMojaz", "view_mojoodiMojaz");
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
