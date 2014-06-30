package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

import javax.ejb.*;
import org.apache.log4j.Logger;
import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;

/**
 *
 * @author  Mehdi Amoui
 *
 * @ejb.bean
 *      name="Shahr"
 *      type="CMP"
 *      reentrant = "true"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Shahr"
 *      local-jndi-name="ejb/emdad/ShahrLocal"
 *      schema="Shahr"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *      generate="physical"
 *
 * @ejb.value-object
 *      name="Shahr"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="ShahrLight"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="light"
 *
 * @ejb.pk
 *      class = "String"
 *
 *
 * @ejb:finder
 *     signature = "java.util.Collection findAll()"
 *
 *  @jboss.read-ahead
 * 		strategy = "on-find"
 * 		page-size = "20"
 *
 *  @jboss.load-group
 *    load-group-name="list"
 * 	    field-name="shahrName"
 *      field-name="shahrId"
 *      field-name="ostanId"
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
 *	   strategy = "on-find"
 * 	   page-size = "20"
 *
 *
 * @ejb.finder
 *     signature = "java.util.Collection findByEntityId(java.lang.Integer shahrId)"
 *     query = "SELECT OBJECT(o) FROM Shahr AS o WHERE o.shahrId = ?1"
 *
 */

public abstract class ShahrEJB extends BaseEJB implements EntityBean {

	private final String tabel = "Shahr";

	protected static Logger log = Logger.getLogger(ShahrEJB.class.getName());

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		// here you should generate the primary key

		try {
			// JSA recommend you to have attribute String id as the primary key for code reuse
			this.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
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
	public String ejbCreate(ShahrModel shahrModel) throws CreateException {
		try {
			if ((shahrModel.getId() == null) || (shahrModel.getId().length() == 0)) {
				shahrModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(shahrModel.getId());

			setShahrName(shahrModel.getShahrName());
            setCodeShahrKhodrosaz(shahrModel.getCodeShahrKhodrosaz());
			setShahrId(shahrModel.getShahrId());
            setTaArz(shahrModel.getTaArz());
            setTaTool(shahrModel.getTaTool());
            setAzArz(shahrModel.getAzArz());
            setAzTool(shahrModel.getAzTool());
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
	 *    name="Ostan-Shahr-Relation"
	 *    role-name="shahr-has-ostan"
	 *    target-ejb = "Ostan"	
	 *	  target-role-name="ostan-might-have-some-shahr"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="ostanId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 * 	  strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract OstanLocal getOstan();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setOstan(OstanLocal ostanLocal);

	// end of relationship declaration
	//////////////////////////////////

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
		 *   name="list"
		 *
	 */

	/** Holds value of property userId. */
	//	private java.lang.String ostanId;

	/** Holds value of property userId. */
	private java.lang.String shahrName;

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
		 *   name="list"
		 *
	 */

	public abstract java.lang.String getShahrName();
	public abstract void setShahrName(java.lang.String shahrName);

    /** Holds value of property userId. */
    private java.lang.String codeShahrKhodrosaz;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */

    public abstract java.lang.String getCodeShahrKhodrosaz();
    public abstract void setCodeShahrKhodrosaz(java.lang.String codeShahrKhodrosaz);


	/** Holds value of property userId. */
	private java.lang.Integer shahrId;

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
		 *   name="list"
		 *
	 */
	public abstract java.lang.Integer getShahrId();
	public abstract void setShahrId(java.lang.Integer shahrId);

    /** Holds value of property userId. */
    private java.lang.Integer taArz;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaArz();
    public abstract void setTaArz(java.lang.Integer taArz);



    /** Holds value of property userId. */
    private java.lang.Integer taTool;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaTool();
    public abstract void setTaTool(java.lang.Integer taTool);



    /** Holds value of property userId. */
    private java.lang.Integer azArz;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzArz();
    public abstract void setAzArz(java.lang.Integer azArz);


    /** Holds value of property userId. */
    private java.lang.Integer azTool;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzTool();
    public abstract void setAzTool(java.lang.Integer azTool);

	protected String getTable() {
		return "Shahr";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract ShahrModel getShahrModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setShahrModel(ShahrModel model);

	public void ejbActivate() throws EJBException, RemoteException {}

	public void ejbLoad() throws EJBException, RemoteException {}

	public void ejbPassivate() throws EJBException, RemoteException {}

	public void ejbRemove() throws RemoveException, EJBException, RemoteException {}

	public void ejbStore() throws EJBException, RemoteException {}

	protected EntityContext ctx;

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
		return "shahr.ostanId = Ostan.id";
	}

}
