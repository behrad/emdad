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
 *      name="Role"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Role"
 *      local-jndi-name="ejb/emdad/RoleLocal"
 *      schema="Role"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Role"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="RoleLight"
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
 * 	    field-name="roleId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer roleId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Role AS o WHERE o.roleId = ?1"
 *
 *
 */

public abstract class RoleEJB extends BaseEJB implements EntityBean {

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
	public String ejbCreate(RoleModel roleModel) throws CreateException {
		try {
			if ((roleModel.getId() == null) || (roleModel.getId().length() == 0)) {
				roleModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(roleModel.getId());

			// copy from model
			setAccess(roleModel.getAccess());
			setEntity(roleModel.getEntity());
			setRoleId(roleModel.getRoleId());
			setRole(roleModel.getRole());
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
	private java.lang.String access;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getAccess();
	public abstract void setAccess(java.lang.String access);

	/** Holds value of property userId. */
	private java.lang.String entity;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEntity();
	public abstract void setEntity(java.lang.String entity);

	/** Holds value of property userId. */
	private java.lang.Integer roleId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getRoleId();
	public abstract void setRoleId(java.lang.Integer roleId);

	/** Holds value of property userId. */
	private java.lang.String role;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getRole();
	public abstract void setRole(java.lang.String role);

	protected String getTable() {
		return "Role";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract RoleModel getRoleModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setRoleModel(RoleModel model);

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
