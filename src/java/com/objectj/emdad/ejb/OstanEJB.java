package com.objectj.emdad.ejb;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 *
 * @author  Mehdi Amoui
 *
 * @ejb.bean
 *      name="Ostan"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Ostan"
 *      local-jndi-name="ejb/emdad/OstanLocal"
 *      schema="Ostan"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Ostan"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="OstanLight"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="light"
 *
 * @ejb.pk
 *      class="String"
 *
 * @ejb:finder signature="java.util.Collection findAll()"
 *
 *
 *
 *  @jboss.load-group
 *    load-group-name="list"
 * 	    field-name="ostanId"
 *      field-name="name"
 *
 *
 *  @jboss.read-ahead
 * 		strategy = "on-find"
 * 		page-size = "20"
 *
 * @jboss.method-attributes
 * 		pattern = "get*"
 * 		read-only = "true"
 *
 * @ejb.finder
 *     signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 *     query = ""
 * @jboss.query
 *     signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 *     dynamic = "true"
 * 	   eager-load-group = "list"
 *
 *
 * @ejb.finder
 * signature="java.util.Collection findByEntityId(java.lang.Integer ostanId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Ostan AS o WHERE o.ostanId = ?1"
 *
 */

public abstract class OstanEJB extends BaseEJB implements EntityBean {

	protected EntityContext ctx;

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		return super.ejbCreate();
	}

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate(OstanModel ostanModel) throws CreateException {
		try {
			if ((ostanModel.getId() == null) || (ostanModel.getId().length() == 0)) {
				ostanModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(ostanModel.getId());

			// copy from model
			setOstanId(ostanModel.getOstanId());
			setName(ostanModel.getName());
		} catch (Exception exception) {
			log.error(exception);
			throw new EJBException(exception.toString());
		}
		// EJB 2.0 spec says return null for CMP ejbCreate methods
		return null;
	}

	/** Holds value of property userId. */
	private String id;

	protected String getTable() {
		return "Ostan";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/** Getter for property id.
	 * @return Value of property id.
	 *
	 * @ejb.pk-field
	 * @ejb.value-object match="light"
	 * @ejb.persistence
	 * @ejb.interface-method
	 */
	public abstract String getId();
	public abstract void setId(String id);

	/** Holds value of property userId. */
	private java.lang.Integer ostanId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getOstanId();
	public abstract void setOstanId(java.lang.Integer ostanId);

	/** Holds value of property userId. */
	private java.lang.String name;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getName();
	public abstract void setName(java.lang.String name);

	/**
	 * @ejb.interface-method
	 */
	public abstract OstanModel getOstanModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setOstanModel(OstanModel model);

	public void ejbActivate() throws EJBException, RemoteException {}

	public void ejbLoad() throws EJBException, RemoteException {}

	public void ejbPassivate() throws EJBException, RemoteException {}

	public void ejbRemove() throws RemoveException, EJBException, RemoteException {}

	public void ejbStore() throws EJBException, RemoteException {}

	public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {
		this.ctx = entityContext;
	}

	public void unsetEntityContext() throws EJBException, RemoteException {
		this.ctx = null;
	}

	/**
	 * @ejb.interface-method
	 */
	public void myRemove() throws SQLException, ProxyReferenceException {
		String Id = getId();
		super.myRemove(Id);
	}

	/**
	 * @ejb.home-method
	 */
	public ResultSet ejbHomeAdvanceRead(Connection connection, QueryObject queryObject) throws FinderException {
		return super.ejbHomeAdvanceRead(connection, queryObject);
	}

}
