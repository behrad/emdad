
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.HejriUtil;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="KasriEmdadSession"
 *    jndi-name="ejb/emdad/KasriEmdadSession"
 *    local-jndi-name="ejb/emdad/KasriEmdadSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.KasriEmdadProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class KasriEmdadSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return KasriEmdadModel.class;
    }

    protected String getUpdateRelaStatement() {
        if(isDatabaseSQL())
            return "execute dbo.UpdateRelationKasriEmdad ?, ?" ;
        else
            return "execute UpdateRelationKasriEmdad( ?, ?)" ;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void updateRela(String id, String[] relaIds) throws ProxyException {
        super.updateRela(id, relaIds);
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
	public ValueObject create(ValueObject valueObject, String emdadgarId) throws ProxyException {
        try {
            KasriEmdadLocal kasriEmdadLocal = KasriEmdadUtil.getLocalHome().create((KasriEmdadModel)valueObject);
            ValueObject vo  =  kasriEmdadLocal.getKasriEmdadModel();
            updateRela( vo.getId(), new String[] { emdadgarId } );
    		return vo;
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
    public void update(ValueObject valueObject, String emdadgarId) throws ProxyException {
        try {
            KasriEmdadLocal kasriEmdadLocal = KasriEmdadUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            kasriEmdadLocal.setKasriEmdadModel((KasriEmdadModel)valueObject);
            updateRela(valueObject.getId(), new String[] { emdadgarId });
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

    public ValueObject modelToList(Object o) {
        KasriEmdadLocal kasriEmdadLocal = (KasriEmdadLocal)o;
        KasriEmdadList kasriEmdadList = new KasriEmdadList();
        KasriEmdadModel kasriEmdadModel = kasriEmdadLocal.getKasriEmdadModel();

        kasriEmdadList.setId(kasriEmdadModel.getId());
        kasriEmdadList.setTahvilshod(kasriEmdadModel.getTahvilshod());
        kasriEmdadList.setTahvilshodName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTahvilshod())).getName());
        kasriEmdadList.setTaeedAnbardar(kasriEmdadModel.getTaeedAnbardar()) ;
        kasriEmdadList.setTaeedAnbardarName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTaeedAnbardar())).getName());
        kasriEmdadList.setTaeedEmdadgar(kasriEmdadModel.getTaeedEmdadgar()) ;
        kasriEmdadList.setTaeedEmdadgarName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTaeedEmdadgar())).getName());
        kasriEmdadList.setKasriId(kasriEmdadModel.getKasriId());
        kasriEmdadList.setTarikh(kasriEmdadModel.getTarikh());
        if (kasriEmdadModel.getTarikh() != null)
            kasriEmdadList.setTarikhHejri(HejriUtil.chrisToHejri(kasriEmdadModel.getTarikh()));
        else
            kasriEmdadList.setTarikhHejri("");

        EmdadgarLocal emdadgarLocal = kasriEmdadLocal.getEmdadgar();
        if (emdadgarLocal != null) {
            EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
            kasriEmdadList.setEmdadgarId(emdadgarModel.getId());
            kasriEmdadList.setEmdadgarName(emdadgarModel.getName());
        }

        return kasriEmdadList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            KasriEmdadList kasriEmdadList = new KasriEmdadList();

            kasriEmdadList.setId(resultSet.getString("id"));
            kasriEmdadList.setKasriId(new Integer(resultSet.getInt("kasriId")));
            kasriEmdadList.setTarikhHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikh")));
            kasriEmdadList.setTahvilshod(new Integer(resultSet.getInt("tahvilShod")));
//            if (kasriEmdadList.getTahvilshod()!=null)
                kasriEmdadList.setTahvilshodName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTahvilshod())).getName());
            kasriEmdadList.setTaeedAnbardar(new Integer(resultSet.getInt("taeedAnbardar")));
//            if (kasriEmdadList.getTaeedAnbardar()!=null)
                kasriEmdadList.setTaeedAnbardarName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTaeedAnbardar())).getName());
            kasriEmdadList.setTaeedEmdadgar(new Integer(resultSet.getInt("taeedEmdadgar")));
//            if (kasriEmdadList.getTaeedEmdadgar()!=null)
                kasriEmdadList.setTaeedEmdadgarName(((ComboObject)Util.getFromArrayList("yesNo", kasriEmdadList.getTaeedEmdadgar())).getName());
            kasriEmdadList.setEmdadgarName(resultSet.getString("name"));
            return kasriEmdadList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        setAsView(queryObject, "kasriEmdad", "view_kasriEmdad");
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
        setAsView(queryObject, "kasriEmdad", "view_kasriEmdad");
		return super.report(queryObject, connection);
	}


}
