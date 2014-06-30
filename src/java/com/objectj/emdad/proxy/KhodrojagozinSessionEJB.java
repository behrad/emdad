package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.KhodrojagozinList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="KhodrojagozinSession"
 *    jndi-name="ejb/emdad/KhodrojagozinSession"
 *    local-jndi-name="ejb/emdad/KhodrojagozinSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.KhodrojagozinProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class KhodrojagozinSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return KhodrojagozinModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String rangeKhodroId, String noeKhodroId, String daftarOstaniId) throws ProxyException {
		try {
			log.info("Sale Sakht : " + ((KhodrojagozinModel) (valueObject)).getSalesakht());
			NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
            DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);

			KhodrojagozinLocalHome khodrojagozinLocalHome = KhodrojagozinUtil.getLocalHome();
			log.info("valueObject=" + valueObject);
			KhodrojagozinLocal khodrojagozinLocal = khodrojagozinLocalHome.create((KhodrojagozinModel)valueObject);
			khodrojagozinLocal.setNoeKhodro(noeKhodroObject);
			khodrojagozinLocal.setRangeKhodro(rangeKhodroObject);
            khodrojagozinLocal.setDaftarOstani(daftarOstaniObject);
			KhodrojagozinModel khodrojagozinModel = khodrojagozinLocal.getKhodrojagozinModel();
			return khodrojagozinModel;

		} catch (Exception exception) {
			log.error(exception);
			exception.printStackTrace();
			throw new ProxyException(exception);
		}
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject, String rangeKhodroId, String noeKhodroId, String daftarOstaniId) throws ProxyException {
		try {
			NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
            DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);

			KhodrojagozinLocalHome khodrojagozinLocalHome = KhodrojagozinUtil.getLocalHome();
			KhodrojagozinLocal khodrojagozinLocal = khodrojagozinLocalHome.findByPrimaryKey(((KhodrojagozinModel)valueObject).getId());
			khodrojagozinLocal.setNoeKhodro(noeKhodroObject);
			khodrojagozinLocal.setRangeKhodro(rangeKhodroObject);
            khodrojagozinLocal.setDaftarOstani(daftarOstaniObject);
			khodrojagozinLocal.setKhodrojagozinModel((KhodrojagozinModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {

		ArrayList faalList = new ArrayList();
		faalList = Util.getArrayList("yesNo");

		KhodrojagozinLocal khodrojagozinLocal = (KhodrojagozinLocal)o;

		KhodrojagozinList khodrojagozinList = new KhodrojagozinList();
		KhodrojagozinModel khodrojagozinModel = khodrojagozinLocal.getKhodrojagozinModel();

		khodrojagozinList.setId(khodrojagozinModel.getId());
		khodrojagozinList.setKhodrojagozinId(khodrojagozinModel.getKhodrojagozinId());

		RangeKhodroLocal rangeKhodroLocal = khodrojagozinLocal.getRangeKhodro();
		if (rangeKhodroLocal != null) {
			RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
			khodrojagozinList.setRangeKhodroId(rangeKhodroModel.getId());
			khodrojagozinList.setRangeKhodroOnvan(rangeKhodroModel.getOnvan());
		}

		NoeKhodroLocal noeKhodroLocal = khodrojagozinLocal.getNoeKhodro();
		if (noeKhodroLocal != null) {
			NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
			khodrojagozinList.setNoeKhodroId(noeKhodroModel.getId());
			khodrojagozinList.setNoeKhodroOnvan(noeKhodroModel.getOnvan());
		}

        DaftarOstaniLocal daftarOstaniLocal = khodrojagozinLocal.getDaftarOstani();
        if (daftarOstaniLocal != null) {
            DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
            khodrojagozinList.setDaftarOstaniId(daftarOstaniModel.getId());
            khodrojagozinList.setDaftarOstaniName(daftarOstaniModel.getName());
        }

		khodrojagozinList.setSalesakht(khodrojagozinModel.getSalesakht());
		khodrojagozinList.setShomarehPelak(khodrojagozinModel.getShomarehPelak());
		khodrojagozinList.setShomarehMotor(khodrojagozinModel.getShomarehMotor());
		khodrojagozinList.setShomarehShasi(khodrojagozinModel.getShomarehShasi());
		khodrojagozinList.setShomarehVIN(khodrojagozinModel.getShomarehVIN());
		khodrojagozinList.setTozihat(khodrojagozinModel.getTozihat());
		khodrojagozinList.setFaal(khodrojagozinModel.getFaal());
		khodrojagozinList.setFaalName(((ComboObject)Util.getFromArrayList("yesNo", khodrojagozinModel.getFaal().intValue())).getName());
		return khodrojagozinList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			ArrayList noeServiceList = new ArrayList();
			noeServiceList = Util.getArrayList("noeService");

			KhodrojagozinList khodrojagozinList = new KhodrojagozinList();
//			//=-= System.out.println(" khodrojagozinList = " + khodrojagozinList);

			khodrojagozinList.setId(resultSet.getString("id"));
                khodrojagozinList.setKhodrojagozinId(new Integer(resultSet.getInt("khodrojagozinId")));

			String rangeKhodroId = resultSet.getString("rangeKhodroId");
			khodrojagozinList.setRangeKhodroId(rangeKhodroId);
			RangeKhodroLocal rangeKhodroLocal = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
			if (rangeKhodroLocal != null) {
				RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
				khodrojagozinList.setRangeKhodroOnvan(rangeKhodroModel.getOnvan());
			}

			String noeKhodroId = resultSet.getString("noeKhodroId");
			khodrojagozinList.setNoeKhodroId(noeKhodroId);
			NoeKhodroLocal noeKhodroLocal = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			if (noeKhodroLocal != null) {
				NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
				khodrojagozinList.setNoeKhodroOnvan(noeKhodroModel.getOnvan());
			}

            String daftarOstaniId = resultSet.getString("daftarOstaniId");
            khodrojagozinList.setDaftarOstaniId(daftarOstaniId);
            DaftarOstaniLocal daftarOstaniLocal = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);
            if (daftarOstaniLocal != null) {
                DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
                khodrojagozinList.setDaftarOstaniName(daftarOstaniModel.getName());
            }

			khodrojagozinList.setSalesakht(new Integer(resultSet.getInt("salesakht")));
			khodrojagozinList.setShomarehPelak(resultSet.getString("shomarehPelak"));
			khodrojagozinList.setShomarehMotor(resultSet.getString("shomarehMotor"));
			khodrojagozinList.setShomarehShasi(resultSet.getString("shomarehShasi"));
			khodrojagozinList.setShomarehVIN(resultSet.getString("shomarehVIN"));
			khodrojagozinList.setTozihat(resultSet.getString("tozihat"));
			//khodrojagozinList.setFaal(new Integer(resultSet.getInt("faal")));

			khodrojagozinList.setFaalName(((ComboObject)Util.getFromArrayList("yesNo", resultSet.getInt("faal"))).getName());

			return khodrojagozinList;
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
        setAsView(queryObject, "khodrojagozin", "view_khodrojagozin");
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
        setAsView(queryObject, "khodrojagozin", "view_khodrojagozin");
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
