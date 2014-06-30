
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="NaghsheSession"
 *    jndi-name="ejb/emdad/NaghsheSession"
 *    local-jndi-name="ejb/emdad/NaghsheSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.EntityProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class NaghsheSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return NaghsheModel.class;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            NaghsheList naghsheList = new NaghsheList();
            naghsheList.setId(resultSet.getString("id"));
            Integer hr = new Integer(resultSet.getInt("azArzeGoegraphy") / 3600);
            Integer min = new Integer((resultSet.getInt("azArzeGoegraphy") % 3600) / 60);
            Integer sec = new Integer((resultSet.getInt("azArzeGoegraphy") % 3600) % 60);
            naghsheList.setAzArz(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taArzeGoegraphy") / 3600);
            min = new Integer((resultSet.getInt("taArzeGoegraphy") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taArzeGoegraphy") % 3600) % 60);
            naghsheList.setTaArz(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("azTooleGoegraphy") / 3600);
            min = new Integer((resultSet.getInt("azTooleGoegraphy") % 3600) / 60);
            sec = new Integer((resultSet.getInt("azTooleGoegraphy") % 3600) % 60);
            naghsheList.setAzTool(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taTooleGoegraphy") / 3600);
            min = new Integer((resultSet.getInt("taTooleGoegraphy") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taTooleGoegraphy") % 3600) % 60);
            naghsheList.setTaTool(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            naghsheList.setAzArzeGoegraphy(new Integer(resultSet.getInt("azArzeGoegraphy")));
            naghsheList.setAzTooleGoegraphy(new Integer(resultSet.getInt("azTooleGoegraphy")));
            naghsheList.setTaTooleGoegraphy(new Integer(resultSet.getInt("taTooleGoegraphy")));
            naghsheList.setTaArzeGoegraphy(new Integer(resultSet.getInt("taArzeGoegraphy")));
            naghsheList.setMapLevel(new Integer(resultSet.getInt("mapLevel")));
            naghsheList.setMantagheId(new Integer(resultSet.getInt("mantagheId")));
            naghsheList.setFileName(resultSet.getString("fileName"));
            return naghsheList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ValueObject modelToList(Object o) {
        NaghsheLocal naghsheLocal = (NaghsheLocal)o;
        NaghsheList naghsheList = new NaghsheList();
        NaghsheModel naghsheModel = naghsheLocal.getNaghsheModel();

        naghsheList.setId(naghsheModel.getId());

        if (naghsheModel.getAzArzeGoegraphy() != null) {
            Integer hr = new Integer(naghsheModel.getAzArzeGoegraphy().intValue() / 3600);
            Integer min = new Integer((naghsheModel.getAzArzeGoegraphy().intValue() % 3600) / 60);
            Integer sec = new Integer((naghsheModel.getAzArzeGoegraphy().intValue() % 3600) % 60);
            naghsheList.setAzArz(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            naghsheList.setAzArz("   :  :  ");

        if (naghsheModel.getTaArzeGoegraphy() != null) {
            Integer hr = new Integer(naghsheModel.getAzArzeGoegraphy().intValue() / 3600);
            Integer min = new Integer((naghsheModel.getAzArzeGoegraphy().intValue() % 3600) / 60);
            Integer sec = new Integer((naghsheModel.getAzArzeGoegraphy().intValue() % 3600) % 60);
            naghsheList.setTaArz(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            naghsheList.setTaArz("   :  :  ");

        if (naghsheModel.getAzTooleGoegraphy() != null) {
            Integer hr = new Integer(naghsheModel.getAzTooleGoegraphy().intValue() / 3600);
            Integer min = new Integer((naghsheModel.getAzTooleGoegraphy().intValue() % 3600) / 60);
            Integer sec = new Integer((naghsheModel.getAzTooleGoegraphy().intValue() % 3600) % 60);
            naghsheList.setAzTool(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            naghsheList.setAzTool("   :  :  ");

        if (naghsheModel.getTaTooleGoegraphy() != null) {
            Integer hr = new Integer(naghsheModel.getTaTooleGoegraphy().intValue() / 3600);
            Integer min = new Integer((naghsheModel.getTaTooleGoegraphy().intValue() % 3600) / 60);
            Integer sec = new Integer((naghsheModel.getTaTooleGoegraphy().intValue() % 3600) % 60);
            naghsheList.setTaTool(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            naghsheList.setTaTool("   :  :  ");

        naghsheList.setAzArzeGoegraphy(naghsheModel.getAzArzeGoegraphy());
        naghsheList.setAzTooleGoegraphy(naghsheModel.getAzTooleGoegraphy());
        naghsheList.setFileName(naghsheModel.getFileName());
        naghsheList.setMantagheId(naghsheModel.getMantagheId());
        naghsheList.setMapLevel(naghsheModel.getMapLevel());
        naghsheList.setTaArzeGoegraphy(naghsheModel.getTaArzeGoegraphy());
        naghsheList.setTaTooleGoegraphy(naghsheModel.getTaTooleGoegraphy());
        return naghsheList;
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
	 * 	 type = "NotSupported"
	 */
	public ValueObject read(String id) throws ProxyException {
		return super.read(id);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult read(String[] ids) throws ProxyException {
		return super.read(ids);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult read(ValueObject valueObject) throws ProxyException {
		return super.read(valueObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readByEntityId(Integer entityId) throws ProxyException {
		return super.readByEntityId(entityId);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readCombo(String table, String field, String filter) throws ProxyException {
		return super.readCombo(table, field, filter);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readCombo(String table, String field) throws ProxyException {
		return super.readCombo(table, field);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
		return super.readList(queryObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "NotSupported"
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
	 * 	 type = "NotSupported"
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
