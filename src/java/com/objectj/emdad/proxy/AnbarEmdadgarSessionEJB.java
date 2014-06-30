package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="AnbarEmdadgarSession"
 *    jndi-name="ejb/emdad/AnbarEmdadgarSession"
 *    local-jndi-name="ejb/emdad/AnbarEmdadgarSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.AnbarEmdadgarProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class AnbarEmdadgarSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
	protected Class getValueObjectClass() {
		return AnbarEmdadgarModel.class;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String emdadgarId, String qateId) throws ProxyException {
		try {
            AnbarEmdadgarLocal anbarEmdadgarLocal = AnbarEmdadgarUtil.getLocalHome().create((AnbarEmdadgarModel)valueObject);
            valueObject = anbarEmdadgarLocal.getAnbarEmdadgarModel();
            updateRela(valueObject.getId(), new String[] {emdadgarId, qateId});
            if (1==1)
                return valueObject;

			EmdadgarLocal emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(emdadgarId);
			QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

			AnbarEmdadgarLocalHome anbarEmdadgarLocalHome = AnbarEmdadgarUtil.getLocalHome();
			anbarEmdadgarLocal = anbarEmdadgarLocalHome.create((AnbarEmdadgarModel)valueObject);
			anbarEmdadgarLocal.setEmdadgar(emdadgarObject);
			anbarEmdadgarLocal.setQate(qateObject);
			AnbarEmdadgarModel anbarEmdadgarModel = anbarEmdadgarLocal.getAnbarEmdadgarModel();
			return anbarEmdadgarModel;
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
	public void update(ValueObject valueObject, String emdadgarId, String qateId) throws ProxyException {
		try {

            AnbarEmdadgarLocal anbarEmdadgarLocal = AnbarEmdadgarUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            anbarEmdadgarLocal.setAnbarEmdadgarModel((AnbarEmdadgarModel)valueObject);
            updateRela(valueObject.getId(), new String[] {emdadgarId, qateId});
            if (1==1)
                return ;

			EmdadgarLocal emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(emdadgarId);
			QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);

			AnbarEmdadgarLocalHome anbarEmdadgarLocalHome = AnbarEmdadgarUtil.getLocalHome();
			anbarEmdadgarLocal = anbarEmdadgarLocalHome.findByPrimaryKey(valueObject.getId());
			anbarEmdadgarLocal.setEmdadgar(emdadgarObject);
			anbarEmdadgarLocal.setQate(qateObject);
			anbarEmdadgarLocal.setAnbarEmdadgarModel((AnbarEmdadgarModel)valueObject);
			return;
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
	public void update(String emdadgarId, String qateId, Integer mojoodi) throws ProxyException {
		try {
            QueryObject qo = new QueryObject("anbarEmdadgar","","",false);
            qo.setWhere(" emdadgarId = '" + emdadgarId + "' AND qateId = '" + qateId + "' ");
            ArrayList al = readModel(qo).getResult();
            AnbarEmdadgarModel vo = null;
            AnbarEmdadgarLocalHome anbarEmdadgarLocalHome = AnbarEmdadgarUtil.getLocalHome();
            if (al.isEmpty()) {
                if (mojoodi.intValue()<0) {
                    throw new ProxyException(new Exception("Mojoodi Manfi , mojoodi="+mojoodi));
                }
                vo = new AnbarEmdadgarModel();
                vo.setMojoodi(mojoodi);
                create(vo, emdadgarId, qateId);
            } else {
                vo = (AnbarEmdadgarModel) al.get(0);
                vo.setMojoodi(new Integer(mojoodi.intValue() + vo.getMojoodi().intValue()));
                if (vo.getMojoodi().intValue()<0) {
                    throw new ProxyException(new Exception("Mojoodi Manfi , mojoodi="+vo.getMojoodi().intValue()));
                }
                AnbarEmdadgarLocal anbarEmdadgarLocal = anbarEmdadgarLocalHome.findByPrimaryKey(vo.getId());
                anbarEmdadgarLocal.setAnbarEmdadgarModel(vo);
            }
            if (1==1)
                return;

			qo = new QueryObject();
			qo.setTables("anbarEmdadgar");
			qo.setJoined(false);
			qo.setWhere(" emdadgarId = '" + emdadgarId + "' AND qateId = '" + qateId + "' ");
            Connection c = com.objectj.emdad.ejb.util.Util.getConnection();

			ResultSet rs = AnbarEmdadgarUtil.getLocalHome().advanceRead(c, qo);// readModel(qo).getResult();
            if (rs.next()){
                anbarEmdadgarLocalHome = AnbarEmdadgarUtil.getLocalHome();
                AnbarEmdadgarLocal anbarEmdadgarLocal = anbarEmdadgarLocalHome.findByPrimaryKey(rs.getString("id"));
                AnbarEmdadgarModel valueObject = anbarEmdadgarLocal.getAnbarEmdadgarModel();
                valueObject.setMojoodi(new Integer(mojoodi.intValue() + valueObject.getMojoodi().intValue()));
                anbarEmdadgarLocal.setAnbarEmdadgarModel(valueObject);
            }
            c.close();
			return;
		} catch (Exception exception) {
			exception.printStackTrace(System.out);
			throw new ProxyException(exception);
		}
	}

    protected String getUpdateRelaStatement() {
        if(isDatabaseSQL())
            return "execute dbo.UpdateAnbarEmdadgar ?, ?,? " ;
        else
            return "execute UpdateAnbarEmdadgar( ?, ?,? )" ;
    }

	public ValueObject modelToList(Object o) {
		AnbarEmdadgarLocal anbarEmdadgarLocal = (AnbarEmdadgarLocal)o;

		AnbarEmdadgarList anbarEmdadgarList = new AnbarEmdadgarList();
		AnbarEmdadgarModel anbarEmdadgarModel = anbarEmdadgarLocal.getAnbarEmdadgarModel();

		anbarEmdadgarList.setId(anbarEmdadgarModel.getId());
		anbarEmdadgarList.setMojoodi(anbarEmdadgarModel.getMojoodi());
        String[] rls = UserAccessEntity.stringQuerys("select * from view_anbarEmdadgar where id='"+anbarEmdadgarModel.getId()+"'","emdadgarId,emdadgarName,daftarOstaniName,qateIdO,qateName,shomareFanni");
        anbarEmdadgarList.setEmdadgarId(rls[0]);
        anbarEmdadgarList.setEmdadgarName(rls[1]);
        anbarEmdadgarList.setDaftarOstaniName(rls[2]);
        anbarEmdadgarList.setQateId(rls[3]);
        anbarEmdadgarList.setQateName(rls[4]);
        anbarEmdadgarList.setShomareFanni(rls[5]);

//		EmdadgarLocal emdadgarLocal = anbarEmdadgarLocal.getEmdadgar();
//		// check for a valid relationship reference
//		if (emdadgarLocal != null) {
//			EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
//			anbarEmdadgarList.setEmdadgarId(emdadgarModel.getId());
//			anbarEmdadgarList.setEmdadgarName(emdadgarModel.getName());
//			DaftarOstaniModel dm = emdadgarLocal.getDaftarOstani().getDaftarOstaniModel();
//			anbarEmdadgarList.setDaftarOstaniName(dm.getName());
//		}
//
//		QateLocal qateLocal = anbarEmdadgarLocal.getQate();
//		// check for a valid relationship reference
//		if (qateLocal != null) {
//			QateModel qateModel = qateLocal.getQateModel();
//			anbarEmdadgarList.setQateId(qateModel.getId());
//			anbarEmdadgarList.setQateName(qateModel.getName());
//            anbarEmdadgarList.setShomareFanni(qateModel.getShomareFanni());
//		}
		return anbarEmdadgarList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			AnbarEmdadgarList anbarEmdadgarList = new AnbarEmdadgarList();

			anbarEmdadgarList.setId(resultSet.getString("id"));
			anbarEmdadgarList.setMojoodi(new Integer(resultSet.getInt("mojoodi")));
			anbarEmdadgarList.setEmdadgarName(resultSet.getString("emdadgarName"));
//			EmdadgarLocal el = EmdadgarUtil.getLocalHome().findByPrimaryKey(resultSet.getString("emdadgarId"));
//			DaftarOstaniModel dm = el.getDaftarOstani().getDaftarOstaniModel();
//			String daftarOstaniName = dm.getName();
			anbarEmdadgarList.setDaftarOstaniName(resultSet.getString("daftarOstaniName"));
			// TODO change column names with their coulumn number
			anbarEmdadgarList.setQateName(resultSet.getString("qateName"));
			anbarEmdadgarList.setShomareFanni(resultSet.getString("shomareFanni"));
			return anbarEmdadgarList;
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
        setAsView(queryObject, "anbarEmdadgar", "view_anbarEmdadgar");
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
        setAsView(queryObject, "anbarEmdadgar", "view_anbarEmdadgar");
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
