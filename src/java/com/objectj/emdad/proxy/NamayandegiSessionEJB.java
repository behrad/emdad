package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="NamayandegiSession"
 *    jndi-name="ejb/emdad/NamayandegiSession"
 *    local-jndi-name="ejb/emdad/NamayandegiSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.NamayandegiProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class NamayandegiSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected static Logger log = Logger.getLogger(NamayandegiSessionEJB.class.getName());

	protected Class getValueObjectClass() {
		return NamayandegiModel.class;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String daftarOstaniId) throws ProxyException {
		try {
			ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
            NoeKhodroLocal noeKhodroObject =  null;
/*            if(!isDatabaseSQL()){
                if (Util.isNotEmptyId(noeKhodroId))
			        noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
                else
                    noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
            } else*/
            if (noeKhodroId != null && noeKhodroId.length() != 0)
			    noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);

			DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);

			NamayandegiLocalHome namayandegiLocalHome = NamayandegiUtil.getLocalHome();
			NamayandegiLocal namayandegiLocal = namayandegiLocalHome.create((NamayandegiModel)valueObject);
			namayandegiLocal.setShahr(shahrObject);
            namayandegiLocal.setNoeKhodro(noeKhodroObject);
			namayandegiLocal.setDaftarOstani(daftarOstaniObject);
			NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
			return namayandegiModel;

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
	public void update(ValueObject valueObject, String shahrId, String noeKhodroId, String daftarOstaniId) throws ProxyException {
		try {
			ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
            NoeKhodroLocal noeKhodroObject =  null;
/*            if(!isDatabaseSQL()){
                if (Util.isNotEmptyId(noeKhodroId))
			        noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
                else
                    noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
            } else*/
            if (noeKhodroId != null && noeKhodroId.length() != 0)
			    noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
			DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);

			NamayandegiLocalHome namayandegiLocalHome = NamayandegiUtil.getLocalHome();
			NamayandegiLocal namayandegiLocal = namayandegiLocalHome.findByPrimaryKey(valueObject.getId());
			namayandegiLocal.setShahr(shahrObject);
			namayandegiLocal.setNoeKhodro(noeKhodroObject);
			namayandegiLocal.setDaftarOstani(daftarOstaniObject);
			namayandegiLocal.setNamayandegiModel((NamayandegiModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		NamayandegiList namayandegiList = new NamayandegiList();
		NamayandegiLocal namayandegiLocal = (NamayandegiLocal)o;
		NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();

		namayandegiList.setNamayandegiId(namayandegiModel.getNamayandegiId());
		namayandegiList.setName(namayandegiModel.getName());
		namayandegiList.setId(namayandegiModel.getId());
		namayandegiList.setEmdadgar(namayandegiModel.getEmdadgar());
		namayandegiList.setNamayandegiAddress(namayandegiModel.getNamayandegiAddress());
		namayandegiList.setNamayandegiFax(namayandegiModel.getNamayandegiFax());
		namayandegiList.setNamayandegiMobile(namayandegiModel.getNamayandegiMobile());
		namayandegiList.setNamayandegiTel(namayandegiModel.getNamayandegiTel());
		namayandegiList.setNazarIsaco(namayandegiModel.getNazarIsaco());
        namayandegiList.setOlaviat(namayandegiModel.getOlaviat());
        namayandegiList.setSaghfeRiali(namayandegiModel.getSaghfeRiali());
        namayandegiList.setHadaksarKar(namayandegiModel.getHadaksarKar());
        namayandegiList.setKarDarDast(namayandegiModel.getKarDarDast());
        namayandegiList.setHadaksarKar2(namayandegiModel.getHadaksarKar2());
        namayandegiList.setKarDarDast2(namayandegiModel.getKarDarDast2());
		namayandegiList.setSabegheFaaliat(namayandegiModel.getSabegheFaaliat());
		namayandegiList.setSabegheNoroozi(namayandegiModel.getSabegheNoroozi());
		namayandegiList.setShomarehGharardad(namayandegiModel.getShomarehGharardad());
		namayandegiList.setTahtePooshesh(namayandegiModel.getTahtePooshesh());
		namayandegiList.setTarikhGharardad(namayandegiModel.getTarikhGharardad());
		namayandegiList.setTarikhTahvil(namayandegiModel.getTarikhTahvil());
		namayandegiList.setVazGharardad(namayandegiModel.getVazGharardad());
		namayandegiList.setPrimaryKey(namayandegiModel.getPrimaryKey());
        namayandegiList.setTelZaroori(namayandegiModel.getTelZaroori());
        namayandegiList.setEmail(namayandegiModel.getEmail());
        namayandegiList.setDastgahEybyab(namayandegiModel.getDastgahEybyab());
        namayandegiList.setTarikhAkharinEstelam(namayandegiModel.getTarikhAkharinEstelam());
        namayandegiList.setNoeNamayandegi(namayandegiModel.getNoeNamayandegi());
        namayandegiList.setCodeMantaghe(namayandegiModel.getCodeMantaghe());
        if (namayandegiModel.getNoeNamayandegi().intValue() > 0)
            namayandegiList.setNoeNamayandegiName(((ComboObject)Util.getFromArrayList("noeNamayandegi", namayandegiModel.getNoeNamayandegi())).getName()) ;
        else
            namayandegiList.setNoeNamayandegiName("");

        if (namayandegiModel.getTarikhAkharinEstelam() != null)
            namayandegiList.setTarikhAkharinEstelamHejri(HejriUtil.chrisToHejri(namayandegiModel.getTarikhAkharinEstelam())) ;
        else
            namayandegiList.setTarikhAkharinEstelamHejri("");


//		ShahrLocal shahrLocal = namayandegiLocal.getShahr();
        String[] rls = UserAccessEntity.stringQuerys("select shahrId,noeKhodroId,daftarOstaniId from namayandegi where id='"+namayandegiModel.getId()+"'","shahrId,noeKhodroId,daftarOstaniId");
		// check for a valid relationship reference
		if (Util.isNotEmpty(rls[0])) {
//			ShahrModel shahrModel = shahrLocal.getShahrModel();
			namayandegiList.setShahrId(rls[0]);
			namayandegiList.setShahrName(ComboPool.findInCombo("shahr", rls[0]));
		}

//		NoeKhodroLocal noeKhodroLocal = namayandegiLocal.getNoeKhodro();
		// check for a valid relationship reference
		if (Util.isNotEmpty(rls[1])) {
//			NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
			namayandegiList.setNoeKhodroId(rls[1]);
			namayandegiList.setNoeKhodroOnvan(ComboPool.findInCombo("noeKhodro", rls[1]));
		}

//		DaftarOstaniLocal daftarOstaniLocal = namayandegiLocal.getDaftarOstani();
		// check for a valid relationship reference
		if (Util.isNotEmpty(rls[2])) {
//			DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
			namayandegiList.setDaftarOstaniId(rls[2]);
			namayandegiList.setDaftarOstaniName(ComboPool.findInCombo("daftarOstani", rls[2]));
		}
		return namayandegiList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			NamayandegiList namayandegiList = new NamayandegiList();

			namayandegiList.setNamayandegiId(new Integer(resultSet.getInt("namayandegiId")));
			namayandegiList.setName(resultSet.getString("name"));
			namayandegiList.setId(resultSet.getString("id"));
			namayandegiList.setEmdadgar(resultSet.getString("emdadgar"));
			namayandegiList.setNamayandegiAddress(resultSet.getString("namayandegiAddress"));
			namayandegiList.setNamayandegiFax(resultSet.getString("namayandegiFax"));
			namayandegiList.setNamayandegiMobile(resultSet.getString("namayandegiMobile"));
			namayandegiList.setNamayandegiTel(resultSet.getString("namayandegiTel"));
			namayandegiList.setNazarIsaco(new Integer(resultSet.getInt("nazarIsaco")));
            namayandegiList.setOlaviat(new Integer(resultSet.getInt("olaviat")));
			namayandegiList.setSaghfeRiali(new Integer(resultSet.getInt("saghfeRiali")));
            namayandegiList.setHadaksarKar(new Integer(resultSet.getInt("hadaksarKar")));
            namayandegiList.setKarDarDast(new Integer(resultSet.getInt("karDarDast")));
            namayandegiList.setHadaksarKar2(new Integer(resultSet.getInt("hadaksarKar2")));
            namayandegiList.setKarDarDast2(new Integer(resultSet.getInt("karDarDast2")));
			namayandegiList.setSabegheFaaliat(new Integer(resultSet.getInt("sabegheFaaliat")));
			namayandegiList.setSabegheNoroozi(new Integer(resultSet.getInt("sabegheNoroozi")));
			namayandegiList.setShomarehGharardad(resultSet.getString("shomarehGharardad"));
			namayandegiList.setTahtePooshesh(resultSet.getString("tahtePooshesh"));
			namayandegiList.setTarikhGharardad(resultSet.getDate("tarikhGharardad"));
			namayandegiList.setTarikhTahvil(resultSet.getDate("tarikhTahvil"));
			namayandegiList.setVazGharardad(new Integer(resultSet.getInt("vazGharardad")));
            namayandegiList.setTelZaroori(resultSet.getString("telZaroori"));
            namayandegiList.setDastgahEybyab(resultSet.getString("dastgahEybyab")) ;
            namayandegiList.setEmail(resultSet.getString("email"));
            namayandegiList.setTarikhAkharinEstelam(resultSet.getDate("tarikhAkharinEstelam")) ;
            namayandegiList.setCodeMantaghe(new Integer(resultSet.getInt("codeMantaghe")));
            if (resultSet.getDate("tarikhAkharinEstelam") != null)
                namayandegiList.setTarikhAkharinEstelamHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhAkharinEstelam"))) ;
            else
                namayandegiList.setTarikhAkharinEstelamHejri("") ;
			//	namayandegiList.setPrimaryKey(resultSet.getString("primaryKey"));

			if (resultSet.getString("daftarOstaniId") != null && resultSet.getString("daftarOstaniId").length() != 0) {
				DaftarOstaniLocal daftarOstaniLocal = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(resultSet.getString("daftarOstaniId"));
				if (daftarOstaniLocal != null) {
					DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
					namayandegiList.setDaftarOstaniName(daftarOstaniModel.getName());
				}
			}
			namayandegiList.setShahrName(resultSet.getString("shahrName"));
			namayandegiList.setNoeKhodroOnvan(resultSet.getString("onvan"));

			return namayandegiList;
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
        setAsView(queryObject, "namayandegi", "view_namayandegi");
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
        setAsView(queryObject, "namayandegi", "view_namayandegi");
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
