package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="DarkhastEshterakSession"
 *    jndi-name="ejb/emdad/DarkhastEshterakSession"
 *    local-jndi-name="ejb/emdad/DarkhastEshterakSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.DarkhastEshterakProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class DarkhastEshterakSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return DarkhastEshterakModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId) throws ProxyException {
		try {
			ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
			NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);

			DarkhastEshterakLocalHome darkhastEshterakLocalHome = DarkhastEshterakUtil.getLocalHome();
			log.info("valueObject=" + valueObject);
			DarkhastEshterakLocal darkhastEshterakLocal = darkhastEshterakLocalHome.create((DarkhastEshterakModel)valueObject);
			darkhastEshterakLocal.setShahr(shahrObject);
			darkhastEshterakLocal.setNoeKhodro(noeKhodroObject);
			darkhastEshterakLocal.setRangeKhodro(rangeKhodroObject);
			DarkhastEshterakModel darkhastEshterakModel = darkhastEshterakLocal.getDarkhastEshterakModel();
			return darkhastEshterakModel;

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
	public void update(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId) throws ProxyException {
		try {
			ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
			NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);

			DarkhastEshterakLocalHome darkhastEshterakLocalHome = DarkhastEshterakUtil.getLocalHome();
			DarkhastEshterakLocal darkhastEshterakLocal = darkhastEshterakLocalHome.findByPrimaryKey(((DarkhastEshterakModel)valueObject).getId());
			darkhastEshterakLocal.setShahr(shahrObject);
			darkhastEshterakLocal.setNoeKhodro(noeKhodroObject);
			darkhastEshterakLocal.setRangeKhodro(rangeKhodroObject);
			darkhastEshterakLocal.setDarkhastEshterakModel((DarkhastEshterakModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		DarkhastEshterakLocal darkhastEshterakLocal = (DarkhastEshterakLocal)o;

		DarkhastEshterakList darkhastEshterakList = new DarkhastEshterakList();
		DarkhastEshterakModel darkhastEshterakModel = darkhastEshterakLocal.getDarkhastEshterakModel();

		darkhastEshterakList.setSaleSakht(darkhastEshterakModel.getSaleSakht());
		darkhastEshterakList.setShomareFish(darkhastEshterakModel.getShomareFish());
		darkhastEshterakList.setId(darkhastEshterakModel.getId());
		darkhastEshterakList.setAddressMoshtarak(darkhastEshterakModel.getAddressMoshtarak());
		darkhastEshterakList.setNameShobe(darkhastEshterakModel.getNameShobe());
		darkhastEshterakList.setCodePost(darkhastEshterakModel.getCodePost());
		darkhastEshterakList.setEmailMoshtarak(darkhastEshterakModel.getEmailMoshtarak());
		darkhastEshterakList.setGarantee(darkhastEshterakModel.getGarantee());
		darkhastEshterakList.setHazineh(darkhastEshterakModel.getHazineh());
		darkhastEshterakList.setMobileMoshtarak(darkhastEshterakModel.getMobileMoshtarak());
		darkhastEshterakList.setNahvePardakht(darkhastEshterakModel.getNahvePardakht());
		darkhastEshterakList.setNameKhanevadegi(darkhastEshterakModel.getNameKhanevadegi());
		darkhastEshterakList.setNoeService(darkhastEshterakModel.getNoeService());
		darkhastEshterakList.setNameMoshtarak(darkhastEshterakModel.getNameMoshtarak());
		darkhastEshterakList.setShomareMotor(darkhastEshterakModel.getShomareMotor());
		darkhastEshterakList.setShomarePelak(darkhastEshterakModel.getShomarePelak());
		darkhastEshterakList.setShomareShasi(darkhastEshterakModel.getShomareShasi());
		darkhastEshterakList.setTarikhEnghezaGarantee(darkhastEshterakModel.getTarikhEnghezaGarantee());
		darkhastEshterakList.setTarikhFish(darkhastEshterakModel.getTarikhFish());
		darkhastEshterakList.setTarikhTavalod(darkhastEshterakModel.getTarikhTavalod());
		darkhastEshterakList.setTelMoshtarak(darkhastEshterakModel.getTelMoshtarak());
		darkhastEshterakList.setPrimaryKey(darkhastEshterakModel.getPrimaryKey());

		ShahrLocal shahrLocal = darkhastEshterakLocal.getShahr();
		// check for a valid relationship reference
		if (shahrLocal != null) {
			ShahrModel shahrModel = shahrLocal.getShahrModel();
			darkhastEshterakList.setShahrId(shahrModel.getId());
			darkhastEshterakList.setShahrName(shahrModel.getShahrName());
		}

		RangeKhodroLocal rangeKhodroLocal = darkhastEshterakLocal.getRangeKhodro();
		// check for a valid relationship reference
		if (rangeKhodroLocal != null) {
			RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
			darkhastEshterakList.setRangeKhodroId(rangeKhodroModel.getId());
			darkhastEshterakList.setRangeKhodroOnvan(rangeKhodroModel.getOnvan());
		}

		NoeKhodroLocal noeKhodroLocal = darkhastEshterakLocal.getNoeKhodro();
		// check for a valid relationship reference
		if (noeKhodroLocal != null) {
			NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
			darkhastEshterakList.setNoeKhodroId(noeKhodroModel.getId());
			darkhastEshterakList.setNoeKhodroOnvan(noeKhodroModel.getOnvan());
		}

		return darkhastEshterakList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			ArrayList noeServiceList = new ArrayList();
			noeServiceList = Util.getArrayList("noeService");

			DarkhastEshterakList darkhastEshterakList = new DarkhastEshterakList();
			//=-= System.out.println(" darkhastEshterakList = " + darkhastEshterakList);

			darkhastEshterakList.setSaleSakht(new Integer(resultSet.getInt("saleSakht")));
			darkhastEshterakList.setShomareFish(resultSet.getString("shomareFish"));
			darkhastEshterakList.setId(resultSet.getString("id"));
			darkhastEshterakList.setAddressMoshtarak(resultSet.getString("addressMoshtarak"));
			darkhastEshterakList.setNameShobe(resultSet.getString("nameShobe"));
			darkhastEshterakList.setCodePost(resultSet.getString("codePost"));
			darkhastEshterakList.setEmailMoshtarak(resultSet.getString("emailMoshtarak"));
			darkhastEshterakList.setGarantee(new Integer(resultSet.getInt("garantee")));
			darkhastEshterakList.setHazineh(new Integer(resultSet.getInt("hazineh")));
			darkhastEshterakList.setMobileMoshtarak(resultSet.getString("mobileMoshtarak"));
			darkhastEshterakList.setNahvePardakht(new Integer(resultSet.getInt("nahvePardakht")));
			darkhastEshterakList.setNameKhanevadegi(resultSet.getString("nameKhanevadegi"));
			darkhastEshterakList.setNameMoshtarak(resultSet.getString("nameMoshtarak"));
			darkhastEshterakList.setShomareMotor(resultSet.getString("shomareMotor"));
			darkhastEshterakList.setShomarePelak(resultSet.getString("shomarePelak"));
			darkhastEshterakList.setShomareShasi(resultSet.getString("shomareShasi"));
			darkhastEshterakList.setTarikhEnghezaGarantee(resultSet.getDate("tarikhEnghezaGarantee"));
			darkhastEshterakList.setTarikhFish(resultSet.getDate("tarikhFish"));
			darkhastEshterakList.setTarikhTavalod(resultSet.getDate("tarikhTavalod"));
			darkhastEshterakList.setTelMoshtarak(resultSet.getString("telMoshtarak"));
			darkhastEshterakList.setShahrName(resultSet.getString("shahrName"));
			darkhastEshterakList.setNoeKhodroOnvan(resultSet.getString("onvan"));
			int nsId = resultSet.getInt("noeService");
			//=-= System.out.println("noeService = " + Util.getFromArrayList("noeService", nsId));
			darkhastEshterakList.setNoeServiceName(((ComboObject)Util.getFromArrayList("noeService", nsId)).getName());
			return darkhastEshterakList;
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
        setAsView(queryObject, "darkhastEshterak", "view_darkhastEshterak");
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
        setAsView(queryObject, "darkhastEshterak", "view_darkhastEshterak");
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
