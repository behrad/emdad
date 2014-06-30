package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import java.sql.*;

import javax.ejb.*;
import org.apache.log4j.Logger;
import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;

import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 *
 * @author  Mehdi Amoui
 *
 * @ejb.bean
 *      name="NoeKhodro"
 *      type="CMP"
 *      reentrant = "true"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/NoeKhodro"
 *      local-jndi-name="ejb/emdad/NoeKhodroLocal"
 *      schema="NoeKhodro"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *      generate="physical"
 *
 * @ejb.value-object
 *      name="NoeKhodro"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="NoeKhodroLight"
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
 * 	    field-name="onvan"
 *      field-name="noeKhodroId"
 *      field-name="guarantee"
 *      field-name="khodroCode"
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
 * @jboss.method-attributes
 * 		pattern = "get*"
 * 		read-only = "true"
 *
 * @ejb.finder
 *     signature = "java.util.Collection findByEntityId(java.lang.Integer noeKhodroId)"
 *     query = "SELECT OBJECT(o) FROM NoeKhodro AS o WHERE o.noeKhodroId = ?1"
 *
 */

public abstract class NoeKhodroEJB extends BaseEJB implements EntityBean {

	private final String tabel = "NoeKhodro";

	protected static Logger log = Logger.getLogger(NoeKhodroEJB.class.getName());

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
	public String ejbCreate(NoeKhodroModel noeKhodroModel) throws CreateException {
		try {
			if ((noeKhodroModel.getId() == null) || (noeKhodroModel.getId().length() == 0)) {
				noeKhodroModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(noeKhodroModel.getId());

			// copy from model
			setGuarantee(noeKhodroModel.getGuarantee());
			setGuaranteeDistance(noeKhodroModel.getGuaranteeDistance());
			//	setKhodrosazId(noeKhodroModel.getKhodrosazId());
			setOnvan(noeKhodroModel.getOnvan());
			setKhodroCode(noeKhodroModel.getKhodroCode());
            setNoeKhodroCode(noeKhodroModel.getNoeKhodroCode());
			setNoeKhodroId(noeKhodroModel.getNoeKhodroId());
            setVijeh(noeKhodroModel.getVijeh());
            setHazinehSaat(noeKhodroModel.getHazinehSaat());
            setHazinehEshterakAdi(noeKhodroModel.getHazinehEshterakAdi());
            setHazinehEshterakVijeh(noeKhodroModel.getHazinehEshterakVijeh());
            setNoeService(noeKhodroModel.getNoeService());
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
	 *    name="Khodrosaz-NoeKhodro-Relation"
	 *    role-name="noeKhodro-has-khodrosaz"
	 *    target-ejb = "Khodrosaz"
	 * 	  target-role-name = "khodrosaz-might-have-some-noeKhodro"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="khodrosazId"
	 *    related-pk-field="id"
	 *
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract KhodrosazLocal getKhodrosaz();
	/**
	* @ejb.interface-method view-type="local"
	*/
	public abstract void setKhodrosaz(KhodrosazLocal khodrosazLocal);

	// end of relationship declaration
	//////////////////////////////////

	/** Holds value of property userId. */
	private java.lang.Integer guarantee;

	/**
	 * @ejb.persistent-field
	 *
	 * @jboss.load-group
	 *    name="list"
	 *
	 */
	public abstract java.lang.Integer getGuarantee();
	public abstract void setGuarantee(java.lang.Integer guarantee);

	private java.lang.Integer guaranteeDistance;

	/**
	 * @ejb.persistent-field
	 *
	 * @jboss.load-group
	 *    name="list"
	 *
	 */
	public abstract java.lang.Integer getGuaranteeDistance();
	public abstract void setGuaranteeDistance(java.lang.Integer guaranteeDistance);

	/** Holds value of property userId. */
	//	private java.lang.String khodrosazId;

	/** Holds value of property userId. */
	private java.lang.String onvan;

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
		 *   name="list"
		 *
	 */
	public abstract java.lang.String getOnvan();
	public abstract void setOnvan(java.lang.String onvan);


    private java.lang.Integer vijeh;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */
    public abstract java.lang.Integer getVijeh();
    public abstract void setVijeh(java.lang.Integer vijeh);


    /** Holds value of property userId. */
    private java.lang.Integer hazinehSaat;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */
    public abstract java.lang.Integer getHazinehSaat();
    public abstract void setHazinehSaat(java.lang.Integer hazinehSaat);


    /** Holds value of property userId. */
    private java.lang.Integer hazinehEshterakAdi;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */
    public abstract java.lang.Integer getHazinehEshterakAdi();
    public abstract void setHazinehEshterakAdi(java.lang.Integer hazinehEshterakAdi);


    /** Holds value of property userId. */
    private java.lang.Integer hazinehEshterakVijeh;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */
    public abstract java.lang.Integer getHazinehEshterakVijeh();
    public abstract void setHazinehEshterakVijeh(java.lang.Integer hazinehEshterakViheh);



	/** Holds value of property userId. */
	private java.lang.String khodroCode;

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
	     *   name="list"
	     *
	 */
	public abstract java.lang.String getKhodroCode();
	public abstract void setKhodroCode(java.lang.String khodroCode);



    /** Holds value of property userId. */
    private java.lang.String noeKhodroCode;

    /**
     * @ejb.persistent-field
     *
     *  @jboss.load-group
         *   name="list"
         *
     */
    public abstract java.lang.String getNoeKhodroCode();
    public abstract void setNoeKhodroCode(java.lang.String noeKhodroCode);

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeService();
    public abstract void setNoeService(java.lang.Integer noeService);

	/** Holds value of property userId. */
	private java.lang.Integer noeKhodroId;

	/**
	 * @ejb.persistent-field
	 *
	 *  @jboss.load-group
		 *   name="list"
		 *
	 */
	public abstract java.lang.Integer getNoeKhodroId();
	public abstract void setNoeKhodroId(java.lang.Integer noeKhodroId);

	/**
	 * @ejb.interface-method
	 */
	public abstract NoeKhodroModel getNoeKhodroModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setNoeKhodroModel(NoeKhodroModel model);

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

	protected String getTable() {
		return "Noekhodro";
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
//		return "noekhodro.khodrosazId = khodrosaz.Id";
//	}

}
