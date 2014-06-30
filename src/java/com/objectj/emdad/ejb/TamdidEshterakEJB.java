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
 *      name="TamdidEshterak"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/TamdidEshterak"
 *      local-jndi-name="ejb/emdad/TamdidEshterakLocal"
 *      schema="TamdidEshterak"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="TamdidEshterak"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="TamdidEshterakLight"
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
 * 	    field-name="tamdidEshterakId"
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
 */

public abstract class TamdidEshterakEJB extends BaseEJB implements EntityBean {

	protected EntityContext ctx;
	private final String tabel = "TamdidEshterak";

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		return super.ejbCreate();
	}

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate(TamdidEshterakModel tamdidEshterakModel) throws CreateException {
		try {
			if ((tamdidEshterakModel.getId() == null) || (tamdidEshterakModel.getId().length() == 0)) {
				tamdidEshterakModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(tamdidEshterakModel.getId());

			// copy from model
			setTarikhAkharinTamdid(tamdidEshterakModel.getTarikhAkharinTamdid());
			setIsLast(tamdidEshterakModel.getIsLast());
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

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Moshtarak-TamdidEshterak-Relation"
	 *    role-name="tamdidEshterak-has-moshtarak"
	 *    target-ejb = "Moshtarak"
	 *	  target-role-name="moshtarak-might-have-some-tamdidEshterak"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="moshtarakId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */

	public abstract MoshtarakLocal getMoshtarak();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setMoshtarak(MoshtarakLocal moshtarakLocal);

	// end of relationship declaration
	//////////////////////////////////

	/** Holds value of property userId. */
	private java.sql.Date tarikhAkharinTamdid;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhAkharinTamdid();
	public abstract void setTarikhAkharinTamdid(java.sql.Date tarikhAkharinTamdid);


	/** Holds value of property userId. */
	private Integer isLast;

	/**
	 * @ejb.persistent-field
	 */
	public abstract Integer getIsLast();
	public abstract void setIsLast(Integer isLast);

	protected String getTable() {
		return "TamdidEshterak";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract TamdidEshterakModel getTamdidEshterakModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setTamdidEshterakModel(TamdidEshterakModel model);

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

	protected String getJoinStatement() {
		return "tamdidEshterak.moshtarakId = moshtarak.Id";
	}

}
