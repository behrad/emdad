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
 *      name="DarkhastTagheer"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/DarkhastTagheer"
 *      local-jndi-name="ejb/emdad/DarkhastTagheerLocal"
 *      schema="DarkhastTagheer"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="DarkhastTagheer"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="DarkhastTagheerLight"
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
 * 	    field-name="darkhastTagheerId"
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
 */

public abstract class DarkhastTagheerEJB extends BaseEJB implements EntityBean {

	protected EntityContext ctx;
	private final String tabel = "DarkhastTagheer";

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		return super.ejbCreate();
	}

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate(DarkhastTagheerModel darkhastTagheerModel) throws CreateException {
		try {
			if ((darkhastTagheerModel.getId() == null) || (darkhastTagheerModel.getId().length() == 0)) {
				darkhastTagheerModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(darkhastTagheerModel.getId());

			// copy from model
			setMobile(darkhastTagheerModel.getMobile());
			setName(darkhastTagheerModel.getName());
			setNameKhanevadegi(darkhastTagheerModel.getNameKhanevadegi());
			setTel(darkhastTagheerModel.getTel());
			setTarikhTavalod(darkhastTagheerModel.getTarikhTavalod());
			setNoeService(darkhastTagheerModel.getNoeService());
			setShomarePelak(darkhastTagheerModel.getShomarePelak());
			setEmail(darkhastTagheerModel.getEmail());
			setIjadKonandeh(darkhastTagheerModel.getIjadKonandeh());
			setEshterakId(darkhastTagheerModel.getEshterakId());
			setAddress(darkhastTagheerModel.getAddress());
			setPostCode(darkhastTagheerModel.getPostCode());
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

	/*********************************   Shahr Relationships  *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Shahr-DarkhastTagheer-Relation"
	 *    role-name="DarkhastTagheer-has-shahr"
	 *    target-ejb = "Shahr"
	 *	  target-role-name="shahr-might-have-some-DarkhastTagheer"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="shahrId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract ShahrLocal getShahr();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setShahr(ShahrLocal shahrLocal);

	// end of relationship declaration
	//////////////////////////////////

	/*********************************   RangeKhodro  Relationships *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="RangeKhodro-DarkhastTagheer-Relation"
	 *    role-name="DarkhastTagheer-has-rangeKhodro"
	 *    target-ejb = "RangeKhodro"
	 *	  target-role-name="rangeKhodro-might-have-some-DarkhastTagheer"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="rangeKhodroId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract RangeKhodroLocal getRangeKhodro();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setRangeKhodro(RangeKhodroLocal rangeKhodroLocal);

	// end of relationship declaration
	//////////////////////////////////

	/*********************************   Moshtarak  Relationships *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Moshtarak-DarkhastTagheer-Relation"
	 *    role-name="darkhastTagheer-has-moshtarak"
	 *    target-ejb = "Moshtarak"
	 *	  target-role-name="moshtarak-might-have-some-darkhastTagheer"
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
	private java.lang.String mobile;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMobile();
	public abstract void setMobile(java.lang.String mobile);

	/** Holds value of property userId. */
	private java.lang.String name;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getName();
	public abstract void setName(java.lang.String name);

	/** Holds value of property userId. */
	private java.lang.String nameKhanevadegi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNameKhanevadegi();
	public abstract void setNameKhanevadegi(java.lang.String nameKhanevadegi);

	/** Holds value of property userId. */
	private java.lang.String tel;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTel();
	public abstract void setTel(java.lang.String tel);

	/** Holds value of property userId. */
	private java.lang.String tarikhTavalod;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTarikhTavalod();
	public abstract void setTarikhTavalod(java.lang.String tarikhTavalod);

	/** Holds value of property userId. */
	private java.lang.Integer noeService;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeService();
	public abstract void setNoeService(java.lang.Integer noeService);

	/** Holds value of property userId. */
	private java.lang.String shomarePelak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomarePelak();
	public abstract void setShomarePelak(java.lang.String shomarePelak);

	/** Holds value of property userId. */
	private java.lang.String email;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEmail();
	public abstract void setEmail(java.lang.String email);

	/** Holds value of property userId. */
	private java.lang.String ijadKonandeh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getIjadKonandeh();
	public abstract void setIjadKonandeh(java.lang.String ijadKonandeh);

	/** Holds value of property userId. */
	private java.lang.String eshterakId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEshterakId();
	public abstract void setEshterakId(java.lang.String eshterakId);

	/** Holds value of property userId. */
	private java.lang.String address;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getAddress();
	public abstract void setAddress(java.lang.String address);

	/** Holds value of property userId. */
	private java.lang.String postCode;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getPostCode();
	public abstract void setPostCode(java.lang.String postCode);

	protected String getTable() {
		return "DarkhastTagheer";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract DarkhastTagheerModel getDarkhastTagheerModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setDarkhastTagheerModel(DarkhastTagheerModel model);

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
//		return "darkhastTagheer.moshtarakId = moshtarak.Id";
//	}

}
