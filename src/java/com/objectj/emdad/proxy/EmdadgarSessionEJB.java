
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboPool;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="EmdadgarSession"
 *    jndi-name="ejb/emdad/EmdadgarSession"
 *    local-jndi-name="ejb/emdad/EmdadgarSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.EmdadgarProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class EmdadgarSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return EmdadgarModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String noeEmdadgarId, String daftarOstaniId, String namayandegiId) throws ProxyException {
		try {
			NoeEmdadgarLocal noeEmdadgarObject = NoeEmdadgarUtil.getLocalHome().findByPrimaryKey(noeEmdadgarId);
			DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);
			NamayandegiLocal namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(namayandegiId);

			EmdadgarLocalHome emdadgarLocalHome = EmdadgarUtil.getLocalHome();
			EmdadgarLocal emdadgarLocal = emdadgarLocalHome.create((EmdadgarModel)valueObject);
			emdadgarLocal.setNoeEmdadgar(noeEmdadgarObject);
			emdadgarLocal.setDaftarOstani(daftarOstaniObject);
			emdadgarLocal.setNamayandegi(namayandegiObject);
			EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();

			return emdadgarModel;

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
	public void update(ValueObject valueObject, String noeEmdadgarId, String daftarOstaniId, String namayandegiId) throws ProxyException {
		try {

			NoeEmdadgarLocal noeEmdadgarObject = NoeEmdadgarUtil.getLocalHome().findByPrimaryKey(noeEmdadgarId);
			DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);
			NamayandegiLocal namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(namayandegiId);

			EmdadgarLocalHome emdadgarLocalHome = EmdadgarUtil.getLocalHome();
			EmdadgarLocal emdadgarLocal = emdadgarLocalHome.findByPrimaryKey(valueObject.getId());
			emdadgarLocal.setNoeEmdadgar(noeEmdadgarObject);
			emdadgarLocal.setDaftarOstani(daftarOstaniObject);
			emdadgarLocal.setNamayandegi(namayandegiObject);
			emdadgarLocal.setEmdadgarModel1((EmdadgarModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {

		EmdadgarLocal emdadgarLocal = (EmdadgarLocal)o;
		EmdadgarList emdadgarList = new EmdadgarList();
		EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();

		emdadgarList.setId(emdadgarModel.getId());
		emdadgarList.setEmdadgarId(emdadgarModel.getEmdadgarId());
		emdadgarList.setName(emdadgarModel.getName());
		emdadgarList.setTel(emdadgarModel.getTel());
		emdadgarList.setMobile(emdadgarModel.getMobile());
		emdadgarList.setAddress(emdadgarModel.getAddress());
		emdadgarList.setSatheMaharat(emdadgarModel.getSatheMaharat());
		emdadgarList.setSaghfeMojoodi(emdadgarModel.getSaghfeMojoodi());
		emdadgarList.setVazeat(emdadgarModel.getVazeat());
        emdadgarList.setHadaksarKar(emdadgarModel.getHadaksarKar());
        emdadgarList.setKarDarDast(emdadgarModel.getKarDarDast());

        if (emdadgarModel.getAzArz() != null) {
            Integer hr = new Integer(emdadgarModel.getAzArz().intValue() / 3600);
            Integer min = new Integer((emdadgarModel.getAzArz().intValue() % 3600) / 60);
            Integer sec = new Integer((emdadgarModel.getAzArz().intValue() % 3600) % 60);
            emdadgarList.setAzArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            emdadgarList.setAzArze("   :  :  ");

        if (emdadgarModel.getTaArz() != null) {
            Integer hr = new Integer(emdadgarModel.getTaArz().intValue() / 3600);
            Integer min = new Integer((emdadgarModel.getTaArz().intValue() % 3600) / 60);
            Integer sec = new Integer((emdadgarModel.getTaArz().intValue() % 3600) % 60);
            emdadgarList.setTaArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            emdadgarList.setTaArze("   :  :  ");

        if (emdadgarModel.getAzTool() != null) {
            Integer hr = new Integer(emdadgarModel.getAzTool().intValue() / 3600);
            Integer min = new Integer((emdadgarModel.getAzTool().intValue() % 3600) / 60);
            Integer sec = new Integer((emdadgarModel.getAzTool().intValue() % 3600) % 60);
            emdadgarList.setAzToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            emdadgarList.setAzToole("   :  :  ");

        if (emdadgarModel.getTaTool() != null) {
            Integer hr = new Integer(emdadgarModel.getTaTool().intValue() / 3600);
            Integer min = new Integer((emdadgarModel.getTaTool().intValue() % 3600) / 60);
            Integer sec = new Integer((emdadgarModel.getTaTool().intValue() % 3600) % 60);
            emdadgarList.setTaToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());
        }else
            emdadgarList.setTaToole("   :  :  ");

        emdadgarList.setAzArz(emdadgarModel.getAzArz());
        emdadgarList.setAzTool(emdadgarModel.getAzTool());
        emdadgarList.setTaArz(emdadgarModel.getTaArz());
        emdadgarList.setTaTool(emdadgarModel.getTaTool());

//		NoeEmdadgarLocal noeEmdadgarLocal = emdadgarLocal.getNoeEmdadgar();
//		DaftarOstaniLocal daftarOstaniLocal = emdadgarLocal.getDaftarOstani();
//		NamayandegiLocal namayandegiLocal = emdadgarLocal.getNamayandegi();
        String[] rls = UserAccessEntity.stringQuerys("select noeEmdadgarId,daftarOstaniId,namayandegiId from emdadgar where id='"+emdadgarModel.getId()+"'","noeEmdadgarId,daftarOstaniId,namayandegiId");

		// check for a valid relationship reference
		if (Util.isNotEmpty(rls[0])) {
//			NoeEmdadgarModel noeEmdadgarModel = noeEmdadgarLocal.getNoeEmdadgarModel();
			emdadgarList.setNoeEmdadgarId(rls[0]);
			emdadgarList.setNoeEmdadgarOnvan(ComboPool.findInCombo("noeEmdadgar", rls[0]));
		}

		if (Util.isNotEmpty(rls[1])) {
//			DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
			emdadgarList.setDaftarOstaniId(rls[1]);
			emdadgarList.setDaftarOstaniName(ComboPool.findInCombo("daftarOstani", rls[1]));
		}

		if (Util.isNotEmpty(rls[2])) {
//			NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
			emdadgarList.setNamayandegiId(rls[2]);
			emdadgarList.setNamayandegiName(ComboPool.findInCombo("namayandegi_amelyat", rls[2]));
		}
		return emdadgarList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			EmdadgarList emdadgarList = new EmdadgarList();

            Integer hr = new Integer(resultSet.getInt("azArz") / 3600);
            Integer min = new Integer((resultSet.getInt("azArz") % 3600) / 60);
            Integer sec = new Integer((resultSet.getInt("azArz") % 3600) % 60);
            emdadgarList.setAzArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taArz") / 3600);
            min = new Integer((resultSet.getInt("taArz") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taArz") % 3600) % 60);
            emdadgarList.setTaArze(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("azTool") / 3600);
            min = new Integer((resultSet.getInt("azTool") % 3600) / 60);
            sec = new Integer((resultSet.getInt("azTool") % 3600) % 60);
            emdadgarList.setAzToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            hr = new Integer(resultSet.getInt("taTool") / 3600);
            min = new Integer((resultSet.getInt("taTool") % 3600) / 60);
            sec = new Integer((resultSet.getInt("taTool") % 3600) % 60);
            emdadgarList.setTaToole(hr.toString() + ":" + min.toString() + ":" + sec.toString());

            emdadgarList.setAzArz(new Integer(resultSet.getInt("azArz")));
            emdadgarList.setAzTool(new Integer(resultSet.getInt("azTool")));
            emdadgarList.setTaTool(new Integer(resultSet.getInt("taTool")));
            emdadgarList.setTaArz(new Integer(resultSet.getInt("taArz")));
			emdadgarList.setId(resultSet.getString("id"));
			emdadgarList.setEmdadgarId(new Integer(resultSet.getInt("emdadgarId")));
			emdadgarList.setName(resultSet.getString("name"));
			emdadgarList.setTel(resultSet.getString("tel"));
			emdadgarList.setMobile(resultSet.getString("mobile"));
			emdadgarList.setAddress(resultSet.getString("address"));
			emdadgarList.setSatheMaharat(new Integer(resultSet.getInt("satheMaharat")));
			emdadgarList.setSaghfeMojoodi(new Integer(resultSet.getInt("saghfeMojoodi")));
			emdadgarList.setVazeat(new Integer(resultSet.getInt("vazeat")));
            emdadgarList.setHadaksarKar(new Integer(resultSet.getInt("hadaksarKar")));
            emdadgarList.setKarDarDast(new Integer(resultSet.getInt("karDarDast")));

			NoeEmdadgarLocal noeEmdadgarLocal = NoeEmdadgarUtil.getLocalHome().findByPrimaryKey(resultSet.getString("noeEmdadgarId"));
			if (noeEmdadgarLocal != null) {
				NoeEmdadgarModel noeEmdadgarModel = noeEmdadgarLocal.getNoeEmdadgarModel();
				emdadgarList.setNoeEmdadgarId(noeEmdadgarModel.getId());
				emdadgarList.setNoeEmdadgarOnvan(noeEmdadgarModel.getOnvan());
			}

			DaftarOstaniLocal daftarOstaniLocal = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(resultSet.getString("daftarOstaniId"));
			if (daftarOstaniLocal != null) {
				DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
				emdadgarList.setDaftarOstaniId(daftarOstaniModel.getId());
				emdadgarList.setDaftarOstaniName(daftarOstaniModel.getName());
			}

			NamayandegiLocal namayandegiLocal = NamayandegiUtil.getLocalHome().findByPrimaryKey(resultSet.getString("namayandegiId"));
			if (namayandegiLocal != null) {
				NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
				emdadgarList.setNamayandegiId(namayandegiModel.getId());
				emdadgarList.setNamayandegiName(namayandegiModel.getName());
			}

			return emdadgarList;
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
        setAsView(queryObject, "emdadgar", "view_emdadgar");
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
        setAsView(queryObject, "emdadgar", "view_emdadgar");
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
