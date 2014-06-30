package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboPool;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="TamdidEshterakSession"
 *    jndi-name="ejb/emdad/TamdidEshterakSession"
 *    local-jndi-name="ejb/emdad/TamdidEshterakSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.TamdidEshterakProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class TamdidEshterakSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

	protected Class getValueObjectClass() {
		return TamdidEshterakModel.class;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String moshtarakId) throws ProxyException {
		try {
			TamdidEshterakLocalHome tamdidEshterakLocalHome = TamdidEshterakUtil.getLocalHome();
			TamdidEshterakLocal tamdidEshterakLocal = tamdidEshterakLocalHome.create((TamdidEshterakModel)valueObject);

			MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
			tamdidEshterakLocal.setMoshtarak(moshtarakLocal);
			TamdidEshterakModel tamdidEshterakModel = tamdidEshterakLocal.getTamdidEshterakModel();
			return tamdidEshterakModel;

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
	public void update(ValueObject valueObject, String moshtarakId) throws ProxyException {
		try {
			MoshtarakLocal moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
			TamdidEshterakLocalHome tamdidEshterakLocalHome = TamdidEshterakUtil.getLocalHome();
			TamdidEshterakLocal tamdidEshterakLocal = tamdidEshterakLocalHome.findByPrimaryKey(valueObject.getId());
			tamdidEshterakLocal.setMoshtarak(moshtarakObject);
			tamdidEshterakLocal.setTamdidEshterakModel((TamdidEshterakModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		TamdidEshterakLocal tamdidEshterakLocal = (TamdidEshterakLocal)o;

		TamdidEshterakList tamdidEshterakList = new TamdidEshterakList();
		TamdidEshterakModel tamdidEshterakModel = tamdidEshterakLocal.getTamdidEshterakModel();
		tamdidEshterakList.setId(tamdidEshterakModel.getId());
		tamdidEshterakList.setTarikhAkharinTamdid(tamdidEshterakModel.getTarikhAkharinTamdid());
        if (tamdidEshterakModel.getTarikhAkharinTamdid()!=null)
            tamdidEshterakList.setTarikhAkharinTamdidHejri(HejriUtil.chrisToHejri(tamdidEshterakModel.getTarikhAkharinTamdid()));
		tamdidEshterakList.setIsLast(tamdidEshterakModel.getIsLast());
        String ids[] = UserAccessEntity.stringQuerys("select bazaryabId, name, nameKhanevadegi, eshterakId, NoeService FROM view_tamdidEshterak WHERE id = '"+tamdidEshterakModel.getId()+"'", "bazaryabId, name, nameKhanevadegi, eshterakId, NoeService");
        tamdidEshterakList.setBazaryabId(ids[0]);
        tamdidEshterakList.setBazaryabName(ComboPool.findInCombo("bazaryab", ids[0]));
        tamdidEshterakList.setName(ids[1]);
        tamdidEshterakList.setNameKhanevadegi(ids[2]);
        tamdidEshterakList.setEshterakId(ids[3]);
        tamdidEshterakList.setNoeService(Integer.getInteger(ids[4]));
        tamdidEshterakList.setNoeServiceName(((ComboObject) Util.getFromArrayList("noeService", tamdidEshterakList.getNoeService())).getName());

//		MoshtarakLocal moshtarakLocal = tamdidEshterakLocal.getMoshtarak();
//		// check for a valid relationship reference
//		if (moshtarakLocal != null) {
//			MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();
//			tamdidEshterakList.setEshterakId(moshtarakModel.getEshterakId());
//			tamdidEshterakList.setName(moshtarakModel.getName());
//			tamdidEshterakList.setNameKhanevadegi(moshtarakModel.getNameKhanevadegi());
//            tamdidEshterakList.setNoeService(moshtarakModel.getNoeService());
//		}
		return tamdidEshterakList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			TamdidEshterakList tamdidEshterakList = new TamdidEshterakList();

			tamdidEshterakList.setId(resultSet.getString("id"));
			if (resultSet.getDate("tarikhAkharinTamdid") != null)
				tamdidEshterakList.setTarikhAkharinTamdidHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhAkharinTamdid")));
			else
				tamdidEshterakList.setTarikhAkharinTamdidHejri("");

			tamdidEshterakList.setIsLast(new Integer(resultSet.getInt("isLast")));
			tamdidEshterakList.setEshterakId(resultSet.getString("eshterakId"));
			tamdidEshterakList.setName(resultSet.getString("name"));
			tamdidEshterakList.setNameKhanevadegi(resultSet.getString("nameKhanevadegi"));
            tamdidEshterakList.setNoeService(new Integer(resultSet.getInt("noeService")));

			return tamdidEshterakList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject resultSetToBean(ResultSet resultSet) {
		try {
			TamdidEshterakModel tamdidEshterakModel = new TamdidEshterakModel();
			tamdidEshterakModel.setId(resultSet.getString("id"));

			return tamdidEshterakModel;
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
		setAsView(queryObject, "tamdidEshterak", "view_tamdidEshterak");
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
		setAsView(queryObject, "tamdidEshterak", "view_tamdidEshterak");
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
