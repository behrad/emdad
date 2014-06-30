
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="DarkhastQateSession"
 *    jndi-name="ejb/emdad/DarkhastQateSession"
 *    local-jndi-name="ejb/emdad/DarkhastQateSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.DarkhastQateProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class DarkhastQateSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return DarkhastQateModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */

    public ValueObject create(ValueObject valueObject, String qateId, String emdadgarId) throws ProxyException {
        try {

            DarkhastQateLocal dqLocal = DarkhastQateUtil.getLocalHome().create((DarkhastQateModel)valueObject);

            if (qateId != null && qateId.length() != 0) {
                QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                dqLocal.setQate(qateObject);
            }

            if (emdadgarId != null && emdadgarId.length() != 0) {
                EmdadgarLocal emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(emdadgarId);
                dqLocal.setEmdadgar(emdadgarObject);
            }

            DarkhastQateModel dqModel = dqLocal.getDarkhastQateModel();
            return dqModel;

        } catch (Exception exception) {
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        }
    }


    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject, String qateId, String emdadgarId) throws ProxyException {
        try {
            DarkhastQateLocal dqLocal = DarkhastQateUtil.getLocalHome().findByPrimaryKey(valueObject.getId());

            if (qateId != null && qateId.length() != 0) {
                QateLocal qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                dqLocal.setQate(qateObject);
            }

            if (emdadgarId != null && emdadgarId.length() != 0) {
                EmdadgarLocal emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(emdadgarId);
                dqLocal.setEmdadgar(emdadgarObject);
            }

            dqLocal.setDarkhastQateModel1((DarkhastQateModel)valueObject);
            return;

        } catch (Exception exception) {
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        }
    }



    public ValueObject modelToList(Object o) {
        DarkhastQateLocal dqLocal = (DarkhastQateLocal)o;

        DarkhastQateList dqList = new DarkhastQateList();
        DarkhastQateModel dqModel = dqLocal.getDarkhastQateModel();
        dqList.setId(dqModel.getId());
        dqList.setManba(dqModel.getManba());
        if (dqModel.getManba() != null)
            dqList.setManbaName(((ComboObject)Util.getFromArrayList("bazarAnbar", dqModel.getManba())).getName());


        dqList.setDarkhastQateId(dqModel.getDarkhastQateId());
        dqList.setTaeedShodeAnbar(dqModel.getTaeedShodeAnbar());
        dqList.setTaeedShodehSarparast(dqModel.getTaeedShodehSarparast());

        if (dqModel.getTaeedShodeAnbar() != null)
            dqList.setTaeedShodeAnbarName(((ComboObject)Util.getFromArrayList("yesNo", dqModel.getTaeedShodeAnbar())).getName());
        if (dqModel.getTaeedShodehSarparast() != null)
            dqList.setTaeedShodehSarparastName(((ComboObject)Util.getFromArrayList("yesNo", dqModel.getTaeedShodehSarparast())).getName());

        dqList.setTedadAnbar(dqModel.getTedadAnbar());
        dqList.setTedadDarkhasti(dqModel.getTedadDarkhasti());
        dqList.setTedadSarparast(dqModel.getTedadSarparast());
        dqList.setTarikhDarkhast(dqModel.getTarikhDarkhast());
        if (dqModel.getTarikhDarkhast() != null)
            dqList.setTarikhDarkhastHejri(HejriUtil.chrisToHejri(dqModel.getTarikhDarkhast()));
        else
            dqList.setTarikhDarkhastHejri("");

        EmdadgarLocal emdadgarLocal = dqLocal.getEmdadgar();
        if (emdadgarLocal != null) {
            EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
            dqList.setEmdadgarId(emdadgarModel.getId());
            dqList.setEmdadgarName(emdadgarModel.getName());
        }

        //=-= System.out.println("AAAAAAAAAAAAAAAAAAdqModel.getSabtkonandeh() = " + dqModel.getSabtkonandeh());
        try{
   			if (dqModel.getSabtkonandeh() != null && dqModel.getSabtkonandeh().length() != 0){
   				ShakhsModel shakhsModel = ShakhsUtil.getLocalHome().findByPrimaryKey(dqModel.getSabtkonandeh()).getShakhsModel();
            	dqList.setSabtkonandeh(shakhsModel.getId());
            	dqList.setSabtkonandehName(shakhsModel.getName());
			}else{
            	dqList.setSabtkonandeh(null);
	         	dqList.setSabtkonandehName("");
			}

        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        QateLocal qateLocal = dqLocal.getQate();
        if (qateLocal != null) {
            QateModel qateModel = qateLocal.getQateModel();
            dqList.setQateId(qateModel.getId());
            dqList.setQateName(qateModel.getName());
            dqList.setQateIdCode(qateModel.getQateId());
        }
        return dqList;
    }


    public ValueObject resultSetToList(ResultSet resultSet) {
        try {

            DarkhastQateList dqList = new DarkhastQateList();

            dqList.setId(resultSet.getString("id"));
            dqList.setDarkhastQateId(new Integer(resultSet.getString("darkhastQateId")));
            dqList.setTedadDarkhasti(new Integer(resultSet.getInt("tedadDarkhasti")));
            dqList.setTaeedShodeAnbar(new Integer(resultSet.getInt("taeedShodeAnbar")));
            dqList.setTaeedShodehSarparast(new Integer(resultSet.getInt("taeedShodehSarparast")));

            if (resultSet.getString("emdadgarId") != null) {
                EmdadgarLocal emdadgarLocal = EmdadgarUtil.getLocalHome().findByPrimaryKey(resultSet.getString("emdadgarId"));
                if (emdadgarLocal != null) {
                    EmdadgarModel model = emdadgarLocal.getEmdadgarModel();
                    dqList.setEmdadgarId(model.getId());
                    dqList.setEmdadgarName(model.getName());
                }
            }

            if (resultSet.getString("qateId") != null) {
                QateLocal qateLocal = QateUtil.getLocalHome().findByPrimaryKey(resultSet.getString("qateId"));
                if (qateLocal != null) {
                    QateModel model = qateLocal.getQateModel();
                    dqList.setQateId(model.getId());
                    dqList.setQateName(model.getName());
                }
            }

            if (resultSet.getDate("tarikhDarkhast") != null)
                dqList.setTarikhDarkhastHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhDarkhast")));
            else
                dqList.setTarikhDarkhastHejri("");

            return dqList;

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
