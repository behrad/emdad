package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 *
 * @author  Ramtin Khosravi
 *
 * @ejb.bean
 *      name="NoeBazaryab"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/NoeBazaryab"
 *      local-jndi-name="ejb/emdad/NoeBazaryabLocal"
 *      schema="NoeBazaryab"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="NoeBazaryab"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="NoeBazaryabLight"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="light"
 *
 * @ejb.pk
 *      class="String"
 *
 * @ejb:finder signature="java.util.Collection findAll()"
 *
 *
 *  @jboss.load-group
 *    load-group-name="list"
 * 	    field-name="noeBazaryabId"
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
 * @ejb.finder
 * signature="java.util.Collection findByEntityId(java.lang.Integer noeBazaryabId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM NoeBazaryab AS o WHERE o.noeBazaryabId = ?1"
 *
 */

public abstract class NoeBazaryabEJB extends BaseEJB implements EntityBean {

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
	public String ejbCreate(NoeBazaryabModel noeBazaryabModel) throws CreateException {
		try {
			if ((noeBazaryabModel.getId() == null) || (noeBazaryabModel.getId().length() == 0)) {
				noeBazaryabModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(noeBazaryabModel.getId());

			// copy from model
			setOnvan(noeBazaryabModel.getOnvan());
			setEntity(noeBazaryabModel.getEntity());
			setNoeBazaryabId(noeBazaryabModel.getNoeBazaryabId());
		} catch (Exception exception) {
			log.error(exception);
			throw new EJBException(exception.toString());
		}
		// EJB 2.0 spec says return null for CMP ejbCreate methods
		return null;
	}

	/** Holds value of property userId. */
	private String id;

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
	private java.lang.String onvan;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getOnvan();
	public abstract void setOnvan(java.lang.String onvan);

	private java.lang.Integer entity;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getEntity();
	public abstract void setEntity(java.lang.Integer entity);

	/** Holds value of property userId. */
	private java.lang.Integer noeBazaryabId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeBazaryabId();
	public abstract void setNoeBazaryabId(java.lang.Integer noeBazaryabId);

	protected String getTable() {
		return "NoeBazaryab";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract NoeBazaryabModel getNoeBazaryabModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setNoeBazaryabModel(NoeBazaryabModel model);

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
