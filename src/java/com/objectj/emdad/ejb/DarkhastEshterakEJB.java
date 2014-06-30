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
 *      name="DarkhastEshterak"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/DarkhastEshterak"
 *      local-jndi-name="ejb/emdad/DarkhastEshterakLocal"
 *      schema="DarkhastEshterak"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="DarkhastEshterak"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="DarkhastEshterakLight"
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
 * 	    field-name="darkhastEshterakId"
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
 *
 *
 */

public abstract class DarkhastEshterakEJB extends BaseEJB implements EntityBean {

	private final String tabel = "DarkhastEshterak";
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
	public String ejbCreate(DarkhastEshterakModel darkhastEshterakModel) throws CreateException {
		try {
			if ((darkhastEshterakModel.getId() == null) || (darkhastEshterakModel.getId().length() == 0)) {
				darkhastEshterakModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(darkhastEshterakModel.getId());

			// copy from model
			setShomareMotor(darkhastEshterakModel.getShomareMotor());
			setNameKhanevadegi(darkhastEshterakModel.getNameKhanevadegi());
			setTarikhEnghezaGarantee(darkhastEshterakModel.getTarikhEnghezaGarantee());
			setMobileMoshtarak(darkhastEshterakModel.getMobileMoshtarak());
			setGarantee(darkhastEshterakModel.getGarantee());
			setCodePost(darkhastEshterakModel.getCodePost());
			setShomarePelak(darkhastEshterakModel.getShomarePelak());
			setAddressMoshtarak(darkhastEshterakModel.getAddressMoshtarak());
			setTarikhFish(darkhastEshterakModel.getTarikhFish());
			setHazineh(darkhastEshterakModel.getHazineh());
			setNahvePardakht(darkhastEshterakModel.getNahvePardakht());
			setTarikhTavalod(darkhastEshterakModel.getTarikhTavalod());
			setNameMoshtarak(darkhastEshterakModel.getNameMoshtarak());
			setTelMoshtarak(darkhastEshterakModel.getTelMoshtarak());
			setEmailMoshtarak(darkhastEshterakModel.getEmailMoshtarak());
			setShomareShasi(darkhastEshterakModel.getShomareShasi());
			setNoeService(darkhastEshterakModel.getNoeService());
			setShomareFish(darkhastEshterakModel.getShomareFish());
			setSaleSakht(darkhastEshterakModel.getSaleSakht());
			setNameShobe(darkhastEshterakModel.getNameShobe());
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
	 *    name="Shahr-DarkhastEshterak-Relation"
	 *    role-name="darkhasteshterak-has-shahr"
	 *    target-ejb = "Shahr"	
	 *	  target-role-name="Shahr-might-have-some-DarkhastEshterak"
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
	 * 		strategy = "on-find"
	     * 		page-size = "20"
	     * 		eager-load-group = "*"
	 */

	public abstract ShahrLocal getShahr();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setShahr(ShahrLocal shahrLocal);

	// end of relationship declaration
	//////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="NoeKhodro-DarkhastEshterak-Relation"
	 *    role-name="darkhasteshterak-has-noekhodro"
	 *    target-ejb = "NoeKhodro"	
	 *	  target-role-name="NoeKhodro-might-have-some-DarkhastEshterak"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="noeKhodroId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 * 	  strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */

	public abstract NoeKhodroLocal getNoeKhodro();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setNoeKhodro(NoeKhodroLocal noeKhodroLocal);

	// end of relationship declaration
	//////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="RangeKhodro-DarkhastEshterak-Relation"
	 *    role-name="darkhasteshterak-has-rangeKhodoro"
	 *    target-ejb = "RangeKhodro"	
	 *	  target-role-name="RangeKhodro-might-have-some-DarkhastEshterak"
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
	 *
	 * @jboss.relation-read-ahead
	 * 	  strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */

	public abstract RangeKhodroLocal getRangeKhodro();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setRangeKhodro(RangeKhodroLocal rangeKhodroLocal);

	// end of relationship declaration
	//////////////////////////////////

	/** Holds value of property userId. */
	private java.lang.String shomareMotor;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareMotor();
	public abstract void setShomareMotor(java.lang.String shomareMotor);

	/** Holds value of property userId. */
	private java.lang.String nameKhanevadegi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNameKhanevadegi();
	public abstract void setNameKhanevadegi(java.lang.String nameKhanevadegi);

	/** Holds value of property userId. */
	private java.sql.Date tarikhEnghezaGarantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhEnghezaGarantee();
	public abstract void setTarikhEnghezaGarantee(java.sql.Date tarikhEnghezaGarantee);

	/** Holds value of property userId. */
	private java.lang.String mobileMoshtarak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMobileMoshtarak();
	public abstract void setMobileMoshtarak(java.lang.String mobileMoshtarak);

	/** Holds value of property userId. */
	private java.lang.Integer garantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getGarantee();
	public abstract void setGarantee(java.lang.Integer garantee);

	/** Holds value of property userId. */
	private java.lang.String codePost;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getCodePost();
	public abstract void setCodePost(java.lang.String codePost);

	/** Holds value of property userId. */
	private java.lang.String shomarePelak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomarePelak();
	public abstract void setShomarePelak(java.lang.String shomarePelak);

	/** Holds value of property userId. */
	private java.lang.String addressMoshtarak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getAddressMoshtarak();
	public abstract void setAddressMoshtarak(java.lang.String addressMoshtarak);

	/** Holds value of property userId. */
	private java.sql.Date tarikhFish;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhFish();
	public abstract void setTarikhFish(java.sql.Date tarikhFish);

	/** Holds value of property userId. */
	private java.lang.Integer hazineh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getHazineh();
	public abstract void setHazineh(java.lang.Integer hazineh);

	/** Holds value of property userId. */
	private java.lang.Integer nahvePardakht;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNahvePardakht();
	public abstract void setNahvePardakht(java.lang.Integer nahvePardakht);

	/** Holds value of property userId. */
	private java.sql.Date tarikhTavalod;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhTavalod();
	public abstract void setTarikhTavalod(java.sql.Date tarikhTavalod);

	/** Holds value of property userId. */
	private java.lang.String nameMoshtarak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNameMoshtarak();
	public abstract void setNameMoshtarak(java.lang.String nameMoshtarak);

	/** Holds value of property userId. */
	private java.lang.String telMoshtarak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTelMoshtarak();
	public abstract void setTelMoshtarak(java.lang.String telMoshtarak);

	/** Holds value of property userId. */
	private java.lang.String emailMoshtarak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEmailMoshtarak();
	public abstract void setEmailMoshtarak(java.lang.String emailMoshtarak);

	/** Holds value of property userId. */
	private java.lang.String shomareShasi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareShasi();
	public abstract void setShomareShasi(java.lang.String shomareShasi);

	/** Holds value of property userId. */
	private java.lang.Integer noeService;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeService();
	public abstract void setNoeService(java.lang.Integer noeService);

	/** Holds value of property userId. */
	private java.lang.String shomareFish;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareFish();
	public abstract void setShomareFish(java.lang.String shomareFish);

	/** Holds value of property userId. */
	private java.lang.Integer saleSakht;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getSaleSakht();
	public abstract void setSaleSakht(java.lang.Integer saleSakht);

	/** Holds value of property userId. */
	private java.lang.String nameShobe;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNameShobe();
	public abstract void setNameShobe(java.lang.String nameShobe);

	protected String getTable() {
		return "DarkhastEshterak";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract DarkhastEshterakModel getDarkhastEshterakModel();
	/**
	 * @ejb.interface-method
	 */
	public abstract void setDarkhastEshterakModel(DarkhastEshterakModel model);

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
//		return "DarkhastEshterak.noekhodroId = noeKhodro.Id AND DarkhastEshterak.shahrId = shahr.Id AND DarkhastEshterak.rangeKhodroId = rangeKhodro.Id";
//	}

}
