
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.BazaryabMotefaregheModel;
import com.objectj.emdad.ejb.BazaryabMotefaregheLocal;
import com.objectj.emdad.ejb.BazaryabMotefaregheList;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="BazaryabMotefaregheSession"
 *    jndi-name="ejb/emdad/BazaryabMotefaregheSession"
 *    local-jndi-name="ejb/emdad/BazaryabMotefaregheSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.EntityProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class BazaryabMotefaregheSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return BazaryabMotefaregheModel.class;
    }

    public ValueObject modelToList(Object o) {
        BazaryabMotefaregheLocal bazaryabLocal = (BazaryabMotefaregheLocal)o;

        BazaryabMotefaregheList bazaryabList = new BazaryabMotefaregheList();
        BazaryabMotefaregheModel  bazaryabModel = bazaryabLocal.getBazaryabMotefaregheModel();

        bazaryabList.setId(bazaryabModel.getId());
        bazaryabList.setAddress(bazaryabModel.getAddress());
        bazaryabList.setMobile(bazaryabModel.getMobile() );
        bazaryabList.setName(bazaryabModel.getName() );
        bazaryabList.setNamePedar(bazaryabModel.getNamePedar() );
        bazaryabList.setShShenasname(bazaryabModel.getShShenasname() );
        bazaryabList.setTel(bazaryabModel.getTel() );

        return bazaryabList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            BazaryabMotefaregheList bazaryabList = new BazaryabMotefaregheList();


            bazaryabList.setId(resultSet.getString("id"));
            bazaryabList.setTel(resultSet.getString("tel"));
            bazaryabList.setAddress(resultSet.getString("address"));
            bazaryabList.setMobile(resultSet.getString("mobile")) ;
            bazaryabList.setName(resultSet.getString("name")) ;
            bazaryabList.setNamePedar(resultSet.getString("namePedar"));
            bazaryabList.setShShenasname(resultSet.getString("shShenasname"));

            return bazaryabList;
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
