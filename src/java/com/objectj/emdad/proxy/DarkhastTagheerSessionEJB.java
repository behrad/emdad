package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
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
 *    name="DarkhastTagheerSession"
 *    jndi-name="ejb/emdad/DarkhastTagheerSession"
 *    local-jndi-name="ejb/emdad/DarkhastTagheerSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.DarkhastTagheerProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class DarkhastTagheerSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return DarkhastTagheerModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String moshtarakId, String shahrId, String rangeKhodroId) throws ProxyException {
		try {
			DarkhastTagheerLocalHome darkhastTagheerLocalHome = DarkhastTagheerUtil.getLocalHome();
			DarkhastTagheerLocal darkhastTagheerLocal = darkhastTagheerLocalHome.create((DarkhastTagheerModel)valueObject);

			if (shahrId != null && shahrId.length() != 0) {
				ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
				darkhastTagheerLocal.setShahr(shahrObject);
			}

			if (moshtarakId != null && moshtarakId.length() != 0) {
				MoshtarakLocal moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
				darkhastTagheerLocal.setMoshtarak(moshtarakObject);
			}

			if (rangeKhodroId != null && rangeKhodroId.length() != 0) {
				RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
				darkhastTagheerLocal.setRangeKhodro(rangeKhodroObject);
			}

			DarkhastTagheerModel darkhastTagheerModel = darkhastTagheerLocal.getDarkhastTagheerModel();

			return darkhastTagheerModel;

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
	public void update(ValueObject valueObject, String moshtarakId, String shahrId, String rangeKhodroId) throws ProxyException {
		try {
			DarkhastTagheerLocalHome darkhastTagheerLocalHome = DarkhastTagheerUtil.getLocalHome();
			DarkhastTagheerLocal darkhastTagheerLocal = darkhastTagheerLocalHome.findByPrimaryKey(valueObject.getId());

			if (shahrId != null && shahrId.length() != 0) {
				ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
				darkhastTagheerLocal.setShahr(shahrObject);
			}

			if (moshtarakId != null && moshtarakId.length() != 0) {
				MoshtarakLocal moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
				darkhastTagheerLocal.setMoshtarak(moshtarakObject);
			}

			if (rangeKhodroId != null && rangeKhodroId.length() != 0) {
				RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
				darkhastTagheerLocal.setRangeKhodro(rangeKhodroObject);
			}

			darkhastTagheerLocal.setDarkhastTagheerModel((DarkhastTagheerModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		DarkhastTagheerLocal darkhastTagheerLocal = (DarkhastTagheerLocal)o;

		DarkhastTagheerList darkhastTagheerList = new DarkhastTagheerList();
		DarkhastTagheerModel darkhastTagheerModel = darkhastTagheerLocal.getDarkhastTagheerModel();

		darkhastTagheerList.setId(darkhastTagheerModel.getId());
		darkhastTagheerList.setEshterakId(darkhastTagheerModel.getEshterakId());
		darkhastTagheerList.setNoeService(darkhastTagheerModel.getNoeService());
		darkhastTagheerList.setNameKhanevadegi(darkhastTagheerModel.getNameKhanevadegi());
		darkhastTagheerList.setName(darkhastTagheerModel.getName());
		darkhastTagheerList.setTarikhTavalod(darkhastTagheerModel.getTarikhTavalod());
		darkhastTagheerList.setAddress(darkhastTagheerModel.getAddress());
		darkhastTagheerList.setPostCode(darkhastTagheerModel.getPostCode());
		darkhastTagheerList.setEmail(darkhastTagheerModel.getEmail());
		darkhastTagheerList.setTel(darkhastTagheerModel.getTel());
		darkhastTagheerList.setMobile(darkhastTagheerModel.getMobile());
		darkhastTagheerList.setShomarePelak(darkhastTagheerModel.getShomarePelak());
		darkhastTagheerList.setIjadKonandeh(darkhastTagheerModel.getIjadKonandeh());

		ShahrLocal shahrLocal = darkhastTagheerLocal.getShahr();
		// check for a valid relationship reference
		if (shahrLocal != null) {
			ShahrModel shahrModel = shahrLocal.getShahrModel();
			darkhastTagheerList.setShahrId(shahrModel.getId());
			darkhastTagheerList.setShahrName(shahrModel.getShahrName());
		}

		MoshtarakLocal moshtarakLocal = darkhastTagheerLocal.getMoshtarak();
		// check for a valid relationship reference
		if (moshtarakLocal != null) {
			MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();
			darkhastTagheerList.setMoshtarakId(moshtarakModel.getId());
			darkhastTagheerList.setEshterakId(moshtarakModel.getEshterakId());
			darkhastTagheerList.setNoeService_old(moshtarakModel.getNoeService());
			darkhastTagheerList.setNameKhanevadegi_old(moshtarakModel.getNameKhanevadegi());
			darkhastTagheerList.setName_old(moshtarakModel.getName());
			darkhastTagheerList.setTarikhTavalod_old(moshtarakModel.getTarikhTavalod());
			darkhastTagheerList.setAddress_old(moshtarakModel.getAddress());
			darkhastTagheerList.setPostCode_old(moshtarakModel.getPostCode());
			darkhastTagheerList.setEmail_old(moshtarakModel.getEmail());
			darkhastTagheerList.setTel_old(moshtarakModel.getTel());
			darkhastTagheerList.setMobile_old(moshtarakModel.getMobile());
			darkhastTagheerList.setShomarePelak_old(moshtarakModel.getShomarePelak());

		}

		RangeKhodroLocal rangeKhodroLocal = darkhastTagheerLocal.getRangeKhodro();
		// check for a valid relationship reference
		if (rangeKhodroLocal != null) {
			RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
			darkhastTagheerList.setRangeKhodroId(rangeKhodroModel.getId());
			darkhastTagheerList.setRangeKhodroOnvan(rangeKhodroModel.getOnvan());
		}

		return darkhastTagheerList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			DarkhastTagheerList darkhastTagheerList = new DarkhastTagheerList();

			darkhastTagheerList.setId(resultSet.getString("id"));
			//darkhastTagheerList.setEshterakId(resultSet.getString("eshterakId"));
			darkhastTagheerList.setNoeService(new Integer(resultSet.getInt("noeService")));
			darkhastTagheerList.setNameKhanevadegi(resultSet.getString("nameKhanevadegi"));
			darkhastTagheerList.setName(resultSet.getString("name"));
			darkhastTagheerList.setTel(resultSet.getString("tel"));
			darkhastTagheerList.setMobile(resultSet.getString("mobile"));
			darkhastTagheerList.setIjadKonandeh(resultSet.getString("ijadKonandeh"));
			//darkhastTagheerList.setEmail(resultSet.getString("email"));
			//darkhastTagheerList.setShomarePelak(resultSet.getString("shomarePelak"));
            darkhastTagheerList.setMoshtarakId(resultSet.getString("moshtarakId"));
            darkhastTagheerList.setEshterakId(resultSet.getString("eshterakId"));
            darkhastTagheerList.setNoeService_old(new Integer(resultSet.getInt("oldNoeService")));
            darkhastTagheerList.setNoeServiceName_old(((ComboObject)Util.getFromArrayList("noeService", new Integer(resultSet.getInt("oldNoeService")))).getName());
            darkhastTagheerList.setNameKhanevadegi_old(resultSet.getString("oldNameKhanevadegi"));
            darkhastTagheerList.setName_old(resultSet.getString("oldName"));
            darkhastTagheerList.setTel_old(resultSet.getString("oldTel"));
            darkhastTagheerList.setMobile_old(resultSet.getString("oldMobile"));

			int noeService = resultSet.getInt("noeService");
			darkhastTagheerList.setNoeServiceName(((ComboObject)Util.getFromArrayList("noeService", noeService)).getName());

			return darkhastTagheerList;
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
        setAsView(queryObject, "darkhasttagheer", "view_darkhasttagheer");
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
