
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
 *    name="JozeatKasriSession"
 *    jndi-name="ejb/emdad/JozeatKasriSession"
 *    local-jndi-name="ejb/emdad/JozeatKasriSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.JozeatKasriProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class JozeatKasriSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return JozeatKasriModel.class;
    }

    protected String getUpdateRelaStatement() {
        if(isDatabaseSQL())
            return "execute dbo.UpdateRelationJozeatKasri ?, ?,?" ;
        else
            return "execute UpdateRelationJozeatKasri( ?, ?,?)" ;
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
    public ValueObject create(ValueObject valueObject, String kasriEmdadId, String qateId) throws ProxyException {
        try {
            JozeatKasriLocal jozeatKasriLocal = JozeatKasriUtil.getLocalHome().create((JozeatKasriModel)valueObject);
            ValueObject vo  =  jozeatKasriLocal.getJozeatKasriModel();
            updateRela( vo.getId(), new String[] { kasriEmdadId, qateId } );
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
    public void update(ValueObject valueObject, String kasriEmdadId, String qateId) throws ProxyException {
        try {
            JozeatKasriLocal jozeatKasriLocal = JozeatKasriUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            jozeatKasriLocal.setJozeatKasriModel((JozeatKasriModel)valueObject);
            updateRela( valueObject.getId(), new String[] { kasriEmdadId, qateId } );
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

    public ValueObject modelToList(Object o) {
        JozeatKasriLocal jozeatKasriLocal = (JozeatKasriLocal)o;
        JozeatKasriList entityList = new JozeatKasriList();
        JozeatKasriModel entityModel = jozeatKasriLocal.getJozeatKasriModel();

        entityList.setId(entityModel.getId());
        entityList.setTedadAnbar(entityModel.getTedadAnbar());
        entityList.setTedadEmdadgar(entityModel.getTedadEmdadgar());
        entityList.setTedadKasri(entityModel.getTedadKasri());

        String[] rls = UserAccessEntity.stringQuerys("select kasriId,tarikh,emdadgarId,emdadgarName from view_jozeatKasri where id='"+entityModel.getId()+"'","kasriId,tarikh,emdadgarId,emdadgarName");
        entityList.setKasriId(Integer.valueOf(rls[0]));
        log.info("rls[1]="+rls[1]);
        entityList.setTarikhHejri(HejriUtil.chrisToHejri(rls[1]));
        entityList.setEmdadgarId(rls[2]);
        entityList.setEmdadgarName(rls[3]);

        return entityList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            JozeatKasriList entityList = new JozeatKasriList();

            entityList.setId(resultSet.getString("id"));
            entityList.setKasriId(new Integer(resultSet.getInt("kasriId")));
            entityList.setTarikhHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikh")));
            entityList.setTedadAnbar(new Integer(resultSet.getInt("tedadAnbar")));
            entityList.setTedadEmdadgar(new Integer(resultSet.getInt("tedadEmdadgar")));
            entityList.setTedadKasri(new Integer(resultSet.getInt("tedadKasri")));
            entityList.setShomareFanni(resultSet.getString("shomareFanni"));
            entityList.setQateName(resultSet.getString("qateName"));
            entityList.setEmdadgarName(resultSet.getString("emdadgarName"));
            return entityList;
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
        setAsView(queryObject, "jozeatKasri", "view_jozeatKasri");
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
        setAsView(queryObject, "jozeatKasri", "view_jozeatKasri");
		return super.report(queryObject, connection);
	}

}
