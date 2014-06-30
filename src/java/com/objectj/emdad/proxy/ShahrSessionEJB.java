package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.objectj.emdad.ejb.*;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="ShahrSession"
 *    jndi-name="ejb/emdad/ShahrSession"
 *    local-jndi-name="ejb/emdad/ShahrSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.ShahrProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class ShahrSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

	protected static Logger log = Logger.getLogger(ShahrSessionEJB.class.getName());

	protected Class getValueObjectClass() {
		return ShahrModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String ostanId) throws ProxyException {
		try {
			OstanLocal ostanObject = OstanUtil.getLocalHome().findByPrimaryKey(ostanId);

			ShahrLocalHome shahrLocalHome = ShahrUtil.getLocalHome();
			ShahrLocal shahrLocal = shahrLocalHome.create((ShahrModel)valueObject);
			shahrLocal.setOstan(ostanObject);
			ShahrModel shahrModel = shahrLocal.getShahrModel();
			return shahrModel;
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
	public void update(ValueObject valueObject, String ostanId) throws ProxyException {
		try {

			OstanLocal ostanObject = OstanUtil.getLocalHome().findByPrimaryKey(ostanId);

			ShahrLocalHome shahrLocalHome = ShahrUtil.getLocalHome();
			ShahrLocal shahrLocal = shahrLocalHome.findByPrimaryKey(valueObject.getId());
			shahrLocal.setOstan(ostanObject);
			shahrLocal.setShahrModel((ShahrModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		ShahrLocal shahrLocal = (ShahrLocal)o;

		ShahrList shahrList = new ShahrList();
		ShahrModel shahrModel = shahrLocal.getShahrModel();

		shahrList.setShahrId(shahrModel.getShahrId());
		shahrList.setShahrName(shahrModel.getShahrName());
        shahrList.setCodeShahrKhodrosaz(shahrModel.getCodeShahrKhodrosaz());
		shahrList.setId(shahrModel.getId());

        if (shahrModel.getAzArz() != null) {
            Integer hr = new Integer(shahrModel.getAzArz().intValue() / 3600);
            Integer min = new Integer((shahrModel.getAzArz().intValue() % 3600) / 60);
            Integer sec = new Integer((shahrModel.getAzArz().intValue() % 3600) % 60);
            shahrList.setAzArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            shahrList.setAzArze("   :  :  ");

        if (shahrModel.getTaArz() != null) {
            Integer hr = new Integer(shahrModel.getTaArz().intValue() / 3600);
            Integer min = new Integer((shahrModel.getTaArz().intValue() % 3600) / 60);
            Integer sec = new Integer((shahrModel.getTaArz().intValue() % 3600) % 60);
            shahrList.setTaArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            shahrList.setTaArze("   :  :  ");

        if (shahrModel.getAzTool() != null) {
            Integer hr = new Integer(shahrModel.getAzTool().intValue() / 3600);
            Integer min = new Integer((shahrModel.getAzTool().intValue() % 3600) / 60);
            Integer sec = new Integer((shahrModel.getAzTool().intValue() % 3600) % 60);
            shahrList.setAzToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            shahrList.setAzToole("   :  :  ");

        if (shahrModel.getTaTool() != null) {
            Integer hr = new Integer(shahrModel.getTaTool().intValue() / 3600);
            Integer min = new Integer((shahrModel.getTaTool().intValue() % 3600) / 60);
            Integer sec = new Integer((shahrModel.getTaTool().intValue() % 3600) % 60);
            shahrList.setTaToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            shahrList.setTaToole("   :  :  ");

        shahrList.setAzArz(shahrModel.getAzArz());
        shahrList.setAzTool(shahrModel.getAzTool());
        shahrList.setTaArz(shahrModel.getTaArz());
        shahrList.setTaTool(shahrModel.getTaTool());

		OstanLocal ostanLocal = shahrLocal.getOstan();
		// check for a valid relationship reference 
		if (ostanLocal != null) {
			OstanModel ostanModel = ostanLocal.getOstanModel();
			shahrList.setOstanId(ostanModel.getId());
			shahrList.setOstanName(ostanModel.getName());
		}
		return shahrList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			ShahrList shahrList = new ShahrList();
            shahrList.setAzArze("0:0:0");
            shahrList.setTaArze("0:0:0");
            shahrList.setAzToole("0:0:0");
            shahrList.setTaToole("0:0:0");
            shahrList.setAzArz(new Integer(0));
            shahrList.setAzTool(new Integer(0));
            shahrList.setTaTool(new Integer(0));
            shahrList.setTaArz(new Integer(0));

            Integer hr = new Integer(resultSet.getInt("azArz") / 3600);
            Integer min = new Integer((resultSet.getInt("azArz") % 3600) / 60);
            Integer sec = new Integer((resultSet.getInt("azArz") % 3600) % 60);
            shahrList.setAzArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taArz") / 3600);
            min = new Integer((resultSet.getInt("taArz") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taArz") % 3600) % 60);
            shahrList.setTaArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("azTool") / 3600);
            min = new Integer((resultSet.getInt("azTool") % 3600) / 60);
            sec = new Integer((resultSet.getInt("azTool") % 3600) % 60);
            shahrList.setAzToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taTool") / 3600);
            min = new Integer((resultSet.getInt("taTool") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taTool") % 3600) % 60);
            shahrList.setTaToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            shahrList.setAzArz(new Integer(resultSet.getInt("azArz")));
            shahrList.setAzTool(new Integer(resultSet.getInt("azTool")));
            shahrList.setTaTool(new Integer(resultSet.getInt("taTool")));
            shahrList.setTaArz(new Integer(resultSet.getInt("taArz")));

			shahrList.setShahrId(new Integer(resultSet.getInt("shahrId")));
			shahrList.setShahrName(resultSet.getString("shahrName"));
            shahrList.setCodeShahrKhodrosaz(resultSet.getString("codeShahrKhodrosaz"));
			shahrList.setId(resultSet.getString("id"));
			shahrList.setOstanName(resultSet.getString("name"));
			return shahrList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject resultSetToBean(ResultSet resultSet) {
		try {
			ShahrModel shahrModel = new ShahrModel();
			shahrModel.setId(resultSet.getString("id"));
			shahrModel.setShahrName(resultSet.getString("shahrName"));
            shahrModel.setCodeShahrKhodrosaz(resultSet.getString("codeShahrKhodrosaz"));
			shahrModel.setShahrId(new Integer(resultSet.getInt("shahrId")));
			return shahrModel;
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
        setAsView(queryObject, "shahr", "view_shahr");
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
        setAsView(queryObject, "shahr", "view_shahr");
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
