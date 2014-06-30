
package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Collection;

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
 *      name="Khodrojagozin"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Khodrojagozin"
 *      local-jndi-name="ejb/emdad/KhodrojagozinLocal"
 *      schema="Khodrojagozin"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Khodrojagozin"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="KhodrojagozinLight"
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
 * 	    field-name="khodrojagozinId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer khodrojagozinId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Khodrojagozin AS o WHERE o.khodrojagozinId = ?1"
 *
 *
 */

public abstract class KhodrojagozinEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate(KhodrojagozinModel khodrojagozinModel) throws CreateException {
           try {
           if ((khodrojagozinModel.getId() == null) || (khodrojagozinModel.getId().length() == 0)) {
                khodrojagozinModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(khodrojagozinModel.getId());


        // copy from model
        setTozihat(khodrojagozinModel.getTozihat());
        setShomarehVIN(khodrojagozinModel.getShomarehVIN());
        setShomarehPelak(khodrojagozinModel.getShomarehPelak());
        setKhodrojagozinId(khodrojagozinModel.getKhodrojagozinId());
        setShomarehShasi(khodrojagozinModel.getShomarehShasi());
        setFaal(khodrojagozinModel.getFaal());
        setSalesakht(khodrojagozinModel.getSalesakht());
        setShomarehMotor(khodrojagozinModel.getShomarehMotor());
        } catch(Exception exception) {
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
    private java.lang.String tozihat;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getTozihat();
    public abstract void setTozihat(java.lang.String tozihat);



    /** Holds value of property userId. */
    private java.lang.String shomarehVIN;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehVIN();
    public abstract void setShomarehVIN(java.lang.String shomarehVIN);



    /** Holds value of property userId. */
    private java.lang.String shomarehPelak;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehPelak();
    public abstract void setShomarehPelak(java.lang.String shomarehPelak);



    /** Holds value of property userId. */
    private java.lang.Integer khodrojagozinId;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKhodrojagozinId();
    public abstract void setKhodrojagozinId(java.lang.Integer khodrojagozinId);



    /** Holds value of property userId. */
    private java.lang.String shomarehShasi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehShasi();
    public abstract void setShomarehShasi(java.lang.String shomarehShasi);



    /** Holds value of property userId. */
    private java.lang.Integer faal;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getFaal();
    public abstract void setFaal(java.lang.Integer faal);



    /** Holds value of property userId. */
    private java.lang.Integer salesakht;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSalesakht();
    public abstract void setSalesakht(java.lang.Integer salesakht);



    /** Holds value of property userId. */
    private java.lang.String shomarehMotor;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehMotor();
    public abstract void setShomarehMotor(java.lang.String shomarehMotor);



    protected String getTable(){
        return "Khodrojagozin";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract KhodrojagozinModel getKhodrojagozinModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setKhodrojagozinModel(KhodrojagozinModel model);

    public void ejbActivate() throws EJBException, RemoteException {
    }

    public void ejbLoad() throws EJBException, RemoteException {
    }

    public void ejbPassivate() throws EJBException, RemoteException {
    }

    public void ejbRemove() throws RemoveException, EJBException, RemoteException {
    }

    public void ejbStore() throws EJBException, RemoteException {
    }

    public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {
	this.ctx = entityContext;
    }

    public void unsetEntityContext() throws EJBException, RemoteException {
	this.ctx = null;
    }


    /**
     * @ejb.interface-method
     */
    public void myRemove() throws SQLException, ProxyReferenceException{
        String Id = getId();
        super.myRemove(Id);
    }


	/**
	 * @ejb.home-method
	 */
	public ResultSet ejbHomeAdvanceRead(Connection connection, QueryObject queryObject) throws FinderException {
		return super.ejbHomeAdvanceRead(connection, queryObject);
	}


    /*********************************   noeKhodro Relationship *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="NoeKhodro-Khodrojagozin-Relation"
     *    role-name="khodrojagozin-has-noekhodro"
     *    target-ejb = "NoeKhodro"
     *	  target-role-name="NoeKhodro-might-have-some-Khodrojagozin"
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


    /*********************************   rangeKhodro Relationship *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="RangeKhodro-Khodrojagozin-Relation"
     *    role-name="Khodrojagozin-has-rangeKhodoro"
     *    target-ejb = "RangeKhodro"
     *	  target-role-name="RangeKhodro-might-have-some-Khodrojagozin"
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



    /*********************************   daftarOstani Relationship *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="DaftarOstani-Khodrojagozin-Relation"
     *    role-name="Khodrojagozin-has-rangeKhodoro"
     *    target-ejb = "DaftarOstani"
     *	  target-role-name="DaftarOstani-might-have-some-Khodrojagozin"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="daftarOstaniId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     * 	  strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */

    public abstract DaftarOstaniLocal getDaftarOstani();
    /**
    * @ejb.interface-method view-type="local"
    *
    */
    public abstract void setDaftarOstani(DaftarOstaniLocal daftarOstaniLocal);

    // end of relationship declaration
    //////////////////////////////////



	protected java.util.Collection dynaQuery(String query) {
		Object[] args = {};
		Collection mycollection;

		try {
			KhodrojagozinLocalHome myHome = (KhodrojagozinLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

//    protected String getJoinStatement() {
//        return "khodrojagozin.noekhodroId = noeKhodro.Id AND khodrojagozin.rangeKhodroId = rangeKhodro.Id AND khodrojagozin.daftarOstaniId = daftarOstani.Id";
//    }

}
