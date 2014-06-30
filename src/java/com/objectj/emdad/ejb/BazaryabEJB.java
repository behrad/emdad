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
 * @author  Mehdi Amoui
 *
 * @ejb.bean
 *      name="Bazaryab"
 *      type="CMP"
 *      reentrant = "true"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Bazaryab"
 *      local-jndi-name="ejb/emdad/BazaryabLocal"
 *      schema="Bazaryab"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Bazaryab"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="BazaryabLight"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="light"
 *
 * @ejb.pk
 *      class="String"
 *
 * @ jboss.container-configuration
 *      container-name = "Standard CMP 2.x EntityBean"
 *      commit-option = "D"
 *
 * @ejb:finder signature="java.util.Collection findAll()"
 *
 *
 *  @jboss.load-group
 *    load-group-name="list"
 * 	    field-name="bazaryabId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer bazaryabId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Bazaryab AS o WHERE o.bazaryabId = ?1"
 *
 *
 */

public abstract class BazaryabEJB extends BaseEJB implements EntityBean {

	protected EntityContext ctx;

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		try {
			// JSA recommend you to have attribute String id as the primary key for code reuse
//            String iid = com.objectj.emdad.ejb.util.Util.generateGUID(this);
            this.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
//			this.setId(UIDDispenser.getDispenser().getNextId());
		} catch (Exception exception) {
			log.error(exception);
			throw new EJBException(exception.toString());
		}

		// EJB 2.0 spec says return null for CMP ejbCreate methods
		return null;
	}

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate(BazaryabModel bazaryabModel) throws CreateException {
		try {
			if ((bazaryabModel.getId() == null) || (bazaryabModel.getId().length() == 0)) {
//				bazaryabModel.setId(UIDDispenser.getDispenser().getNextId());
                String iid = com.objectj.emdad.ejb.util.Util.generateGUID(this);
                bazaryabModel.setId(iid );
			}
			setId(bazaryabModel.getId());

			// copy from model
			setBazaryabKey(bazaryabModel.getBazaryabKey());
			//setNoeBazaryabId(bazaryabModel.getNoeBazaryabId());
			setBazaryabId(bazaryabModel.getBazaryabId());
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
	 *    name="NoeBazaryab-Bazaryab-Relation"
	 *    role-name="bazaryab-has-noeBazaryab"
		 *    target-ejb = "NoeBazaryab"	
	 *	  target-role-name="NoeBazaryab-might-have-some-namayandegi"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="noeBazaryabId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract NoeBazaryabLocal getNoeBazaryab();
	/**
	* @ejb.interface-method view-type="local"
	*/
	public abstract void setNoeBazaryab(NoeBazaryabLocal noeBazaryabLocal);

	// end of relationship declaration
	//////////////////////////////////

	/**
	* @ejb.interface-method
	*/
	public abstract BazaryabList getBazaryabList(String id);

	/** Holds value of property userId. */
	private java.lang.String bazaryabKey;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getBazaryabKey();
	public abstract void setBazaryabKey(java.lang.String bazaryabKey);

	/** Holds value of property userId. */
	private java.lang.Integer bazaryabId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getBazaryabId();
	public abstract void setBazaryabId(java.lang.Integer bazaryabId);

	protected String getTable() {
		return "Bazaryab";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract BazaryabModel getBazaryabModel();

	/**
	 * @ejb.interface-method
	 */
	public abstract void setBazaryabModel(BazaryabModel model);

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

//	protected String getJoinStatement() {
//		return "bazaryab.noeBazaryabId = noeBazaryab.Id";
//	}

}
