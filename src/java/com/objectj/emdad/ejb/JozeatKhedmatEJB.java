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
 * @author  Hamid Abbasi
 *
 * @ejb.bean
 *      name="JozeatKhedmat"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/JozeatKhedmat"
 *      local-jndi-name="ejb/emdad/JozeatKhedmatLocal"
 *      schema="JozeatKhedmat"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="JozeatKhedmat"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="JozeatKhedmatLight"
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
 * 	    field-name="jozeatKhedmatId"
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

public abstract class JozeatKhedmatEJB extends BaseEJB implements EntityBean {

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
	public String ejbCreate(JozeatKhedmatModel jozeatKhedmatModel) throws CreateException {
		try {
			if ((jozeatKhedmatModel.getId() == null) || (jozeatKhedmatModel.getId().length() == 0)) {
				jozeatKhedmatModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(jozeatKhedmatModel.getId());

			// copy from model
			setGuarantee(jozeatKhedmatModel.getGuarantee());
			setTedadQate(jozeatKhedmatModel.getTedadQate());
//			setKhedmatId(jozeatKhedmatModel.getKhedmatId());
			setHazineh(jozeatKhedmatModel.getHazineh());
			setNoeKhedmat(jozeatKhedmatModel.getNoeKhedmat());
			setHazinehDefault(jozeatKhedmatModel.getHazinehDefault());
			setTaeedHesabdar(jozeatKhedmatModel.getTaeedHesabdar());
			setTaeedGuarantee(jozeatKhedmatModel.getTaeedGuarantee());
			setTaeedNamayandegi(jozeatKhedmatModel.getTaeedNamayandegi());
			setIjadKonandeh(jozeatKhedmatModel.getIjadKonandeh());
            setManbaeTahiyeh(jozeatKhedmatModel.getManbaeTahiyeh());
            setNahveyePardakht(jozeatKhedmatModel.getNahveyePardakht());

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
	 *    name="Ojrat-JozeatKhedmat-Relation"
	 *    role-name="jozeatKhedmat-has-ojrat"
	 *    target-ejb = "Ojrat"
	 *	  target-role-name="ojrat-might-have-some-jozeatKhedmat"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="ojratId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract OjratLocal getOjrat();
	/**
	* @ejb.interface-method view-type="local"
	*/
	public abstract void setOjrat(OjratLocal ojratLocal);

	// end of relationship declaration
	//////////////////////////////////


    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Emdad-JozeatKhedmat-Relation"
     *    role-name="jozeatKhedmat-has-Emdad"
     *    target-ejb = "Emdad"
     *	  target-role-name="emdad-might-have-some-jozeatKhedmat"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="khedmatId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract EmdadLocal getEmdad();
    /**
    * @ejb.interface-method view-type="local"
    */
    public abstract void setEmdad(EmdadLocal emdadLocal);

    // end of relationship declaration
    //////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Qate-JozeatKhedmat-Relation"
	 *    role-name="jozeatKhedmat-has-qate"
	 *    target-ejb = "Qate"
	 *	  target-role-name="qate-might-have-some-jozeatKhedmat"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="qateId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract QateLocal getQate();
	/**
	* @ejb.interface-method view-type="local"
	*/
	public abstract void setQate(QateLocal qateLocal);

	// end of relationship declaration
	//////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Irad-JozeatKhedmat-Relation"
	 *    role-name="jozeatKhedmat-has-irad"
	 *    target-ejb = "Irad"
	 *	  target-role-name="irad-might-have-some-jozeatKhedmat"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="iradId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract IradLocal getIrad();
	/**
	* @ejb.interface-method view-type="local"
	*/
	public abstract void setIrad(IradLocal iradLocal);

	// end of relationship declaration
	//////////////////////////////////


	/** Holds value of property userId. */
	private java.lang.Integer guarantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getGuarantee();
	public abstract void setGuarantee(java.lang.Integer guarantee);

	/** Holds value of property userId. */
	private java.lang.Integer tedadQate;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getTedadQate();
	public abstract void setTedadQate(java.lang.Integer tedadQate);

	/** Holds value of property userId. */
	private java.lang.Integer hazineh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getHazineh();
	public abstract void setHazineh(java.lang.Integer hazineh);

	/** Holds value of property userId. */
	private java.lang.Integer hazinehDefault;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getHazinehDefault();
	public abstract void setHazinehDefault(java.lang.Integer hazinehDefault);

	/** Holds value of property userId. */
	private java.lang.Integer noeKhedmat;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeKhedmat();
	public abstract void setNoeKhedmat(java.lang.Integer noeKhedmat);

	/** Holds value of property userId. */
	private java.lang.Integer taeedHesabdar;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getTaeedHesabdar();
	public abstract void setTaeedHesabdar(java.lang.Integer taeedHesabdar);


	/** Holds value of property userId. */
	private java.lang.Integer taeedGuarantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getTaeedGuarantee();
	public abstract void setTaeedGuarantee(java.lang.Integer taeedGuarantee);

	/** Holds value of property userId. */
	private java.lang.Integer taeedNamayandegi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getTaeedNamayandegi();
	public abstract void setTaeedNamayandegi(java.lang.Integer taeedNamayandegi);

	/** Holds value of property userId. */
	private java.lang.String ijadKonandeh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getIjadKonandeh();
	public abstract void setIjadKonandeh(java.lang.String ijadKonandeh);


    /** Holds value of property userId. */
        private java.lang.Integer manbaeTahiyeh;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getManbaeTahiyeh();
        public abstract void setManbaeTahiyeh(java.lang.Integer manbaeTahiyeh);

    /** Holds value of property userId. */
        private java.lang.Integer nahveyePardakht;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getNahveyePardakht();
        public abstract void setNahveyePardakht(java.lang.Integer nahveyePardakht);


	protected String getTable() {
		return "JozeatKhedmat";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract JozeatKhedmatModel getJozeatKhedmatModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setJozeatKhedmatModel(JozeatKhedmatModel model);

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


	// note : see jozeatKhedmatSessionEJB for our join constraint

//	protected String getJoinStatement() {
//		return "jozeatKhedmat.ojratId = ojrat.Id AND jozeatKhedmat.qateId = qate.Id";
//	}
//

    protected String getJoinTables() {
        return
                "jozeatKhedmat LEFT OUTER JOIN ojrat ON jozeatKhedmat.ojratId = ojrat.Id " +
                 "LEFT OUTER JOIN qate ON jozeatKhedmat.qateId = qate.Id " +
                "LEFT OUTER JOIN irad ON jozeatKhedmat.iradId = irad.Id " +
                "LEFT OUTER JOIN emdad ON jozeatKhedmat.khedmatId = emdad.Id " ;
    }


}
