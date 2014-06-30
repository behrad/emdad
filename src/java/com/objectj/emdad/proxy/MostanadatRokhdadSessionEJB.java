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
 *    name="MostanadatRokhdadSession"
 *    jndi-name="ejb/emdad/MostanadatRokhdadSession"
 *    local-jndi-name="ejb/emdad/MostanadatRokhdadSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.MostanadatRokhdadProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class MostanadatRokhdadSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return MostanadatRokhdadModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String rokhdadId) throws ProxyException {
		try {
			MostanadatRokhdadLocal mostanadatRokhdadLocal = MostanadatRokhdadUtil.getLocalHome().create((MostanadatRokhdadModel)valueObject);
			RokhdadLocal rokhdadObject = RokhdadUtil.getLocalHome().findByPrimaryKey(rokhdadId);

			mostanadatRokhdadLocal.setRokhdad(rokhdadObject);

			return mostanadatRokhdadLocal.getMostanadatRokhdadModel();

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
	public void update(ValueObject valueObject, String rokhdadId) throws ProxyException {
		try {
			MostanadatRokhdadLocal mostanadatRokhdadLocal = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(valueObject.getId());

			if (rokhdadId != null) {
				RokhdadLocal rokhdadObject = RokhdadUtil.getLocalHome().findByPrimaryKey(rokhdadId);
				mostanadatRokhdadLocal.setRokhdad(rokhdadObject);
			}
			mostanadatRokhdadLocal.setMostanadatRokhdadModel1((MostanadatRokhdadModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			MostanadatRokhdadList mostanadatRokhdadList = new MostanadatRokhdadList();

			mostanadatRokhdadList.setId(resultSet.getString("id"));
			mostanadatRokhdadList.setMostanadatRokhdadId(new Integer(resultSet.getInt("mostanadatRokhdadId")));
			mostanadatRokhdadList.setNameParvande(resultSet.getString("nameParvande"));
			////=-= System.out.println("mostanadatRokhdadList = " + mostanadatRokhdadList.getNameParvande());
			mostanadatRokhdadList.setSharh(resultSet.getString("sharh"));
			mostanadatRokhdadList.setShomarehSanad(resultSet.getString("shomarehSanad"));
			mostanadatRokhdadList.setNameSanad(resultSet.getString("nameSanad"));

			mostanadatRokhdadList.setRokhdadId(resultSet.getString("rokhdadIdO"));
            mostanadatRokhdadList.setDaftarOstaniId(resultSet.getString("daftarOstaniId"));
            mostanadatRokhdadList.setDaftarOstaniName(resultSet.getString("daftarOstaniName"));
            mostanadatRokhdadList.setRokhdadRokhdadId(new Integer(resultSet.getInt("rokhdadId")));

			if (resultSet.getDate("tarikhSanad") != null)
				mostanadatRokhdadList.setTarikhSanadHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhSanad")));
			else
				mostanadatRokhdadList.setTarikhSanadHejri("");

			if (resultSet.getDate("tarikhSanad") != null)
				mostanadatRokhdadList.setTarikhSabtHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhSabt")));
			else
				mostanadatRokhdadList.setTarikhSabtHejri("");

			return mostanadatRokhdadList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject modelToList(Object o) {
		MostanadatRokhdadLocal mostanadatRokhdadLocal = (MostanadatRokhdadLocal)o;
		MostanadatRokhdadList mostanadatRokhdadList = new MostanadatRokhdadList();
		MostanadatRokhdadModel mostanadatRokhdadModel = mostanadatRokhdadLocal.getMostanadatRokhdadModel();

		mostanadatRokhdadList.setId(mostanadatRokhdadModel.getId());
		mostanadatRokhdadList.setMostanadatRokhdadId(mostanadatRokhdadModel.getMostanadatRokhdadId());
		mostanadatRokhdadList.setNameParvande(mostanadatRokhdadModel.getNameParvande());
		mostanadatRokhdadList.setSharh(mostanadatRokhdadModel.getSharh());
		mostanadatRokhdadList.setShomarehSanad(mostanadatRokhdadModel.getShomarehSanad());
		mostanadatRokhdadList.setTarikhSanad(mostanadatRokhdadModel.getTarikhSanad());
		mostanadatRokhdadList.setTarikhSabt(mostanadatRokhdadModel.getTarikhSabt());
		mostanadatRokhdadList.setNameSanad(mostanadatRokhdadModel.getNameSanad());

		RokhdadLocal rokhdadLocal = mostanadatRokhdadLocal.getRokhdad();
		if (rokhdadLocal != null) {
			RokhdadModel rokhdadModel = rokhdadLocal.getRokhdadModel();
			mostanadatRokhdadList.setRokhdadId(rokhdadModel.getId());
			mostanadatRokhdadList.setRokhdadRokhdadId(rokhdadModel.getRokhdadId());
			DaftarOstaniLocal daftarOstaniLocal = rokhdadLocal.getDaftarOstani();
			if (daftarOstaniLocal != null) {
				DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
				mostanadatRokhdadList.setDaftarOstaniId(daftarOstaniModel.getId());
				mostanadatRokhdadList.setDaftarOstaniName(daftarOstaniModel.getName());
			}
		}
		return mostanadatRokhdadList;
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
        setAsView(queryObject, "mostanadatRokhdad", "view_mostanadatRokhdad");
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
        setAsView(queryObject, "mostanadatRokhdad", "view_mostanadatRokhdad");
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
