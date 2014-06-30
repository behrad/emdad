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
 *      name="DaftarOstani"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/DaftarOstani"
 *      local-jndi-name="ejb/emdad/DaftarOstaniLocal"
 *      schema="DaftarOstani"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="DaftarOstani"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="DaftarOstaniLight"
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
 * 	    field-name="daftarOstaniId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer daftarOstaniId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM DaftarOstani AS o WHERE o.daftarOstaniId = ?1"
 *
 *
 */

public abstract class DaftarOstaniEJB extends BaseEJB implements EntityBean, BazaryabTemplate {

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
	public String ejbCreate(DaftarOstaniModel daftarOstaniModel) throws CreateException {
		try {
			if ((daftarOstaniModel.getId() == null) || (daftarOstaniModel.getId().length() == 0)) {
				daftarOstaniModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
//                String iid = com.objectj.emdad.ejb.util.Util.generateGUID(this);
//                System.out.println("iid=["+iid+"]");
//				daftarOstaniModel.setId(iid);
			}
			setId(daftarOstaniModel.getId());

			// copy from model
			setAddress(daftarOstaniModel.getAddress());
			setMobile(daftarOstaniModel.getMobile());
			setTel(daftarOstaniModel.getTel());
			setName(daftarOstaniModel.getName());
			setMasool(daftarOstaniModel.getMasool());
			setDaftarOstaniId(daftarOstaniModel.getDaftarOstaniId());
            setMahdodeh(daftarOstaniModel.getMahdodeh());
        //} catch (UIDDispenserException exception) {
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
	private java.lang.String address;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getAddress();
	public abstract void setAddress(java.lang.String address);

    /** Holds value of property userId. */
        private java.lang.String mahdodeh;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.String getMahdodeh();
        public abstract void setMahdodeh(java.lang.String mahdodeh);


	/** Holds value of property userId. */
	private java.lang.String mobile;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMobile();
	public abstract void setMobile(java.lang.String mobile);

	/** Holds value of property userId. */
	private java.lang.String tel;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTel();
	public abstract void setTel(java.lang.String tel);

	/** Holds value of property userId. */
	private java.lang.String name;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getName();
	public abstract void setName(java.lang.String name);

	/** Holds value of property userId. */
	private java.lang.String masool;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMasool();
	public abstract void setMasool(java.lang.String masool);

	/** Holds value of property userId. */
	private java.lang.Integer daftarOstaniId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getDaftarOstaniId();
	public abstract void setDaftarOstaniId(java.lang.Integer daftarOstaniId);

	protected String getTable() {
		return "DaftarOstani";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract DaftarOstaniModel getDaftarOstaniModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setDaftarOstaniModel(DaftarOstaniModel model);

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
