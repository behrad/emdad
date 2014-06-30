
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
 * @author  Hamid Abbasi
 *
 * @ejb.bean
 *      name="ServiceDorei"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/ServiceDorei"
 *      local-jndi-name="ejb/emdad/ServiceDoreiLocal"
 *      schema="ServiceDorei"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="ServiceDorei"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="ServiceDoreiLight"
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
 * 	    field-name="serviceDoreiId"
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
 *
 * @jboss.query
 *     signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 *     dynamic = "true"
 * 	   eager-load-group = "list"
 *
 */

public abstract class ServiceDoreiEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate(ServiceDoreiModel serviceDoreiModel) throws CreateException {
           try {
           if ((serviceDoreiModel.getId() == null) || (serviceDoreiModel.getId().length() == 0)) {
                serviceDoreiModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(serviceDoreiModel.getId());


        // copy from model
        setKilometerKarkard(serviceDoreiModel.getKilometerKarkard());
        setTarikh(serviceDoreiModel.getTarikh());
        setNoeServiceDorei(serviceDoreiModel.getNoeServiceDorei());
        setHazineh(serviceDoreiModel.getHazineh());
        setTaeedHesabdar(serviceDoreiModel.getTaeedHesabdar() );
        setTaeedNamayandeh(serviceDoreiModel.getTaeedNamayandeh() );
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


    /*********************************   Moshtarak Relationships *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Moshtarak-serviceDorei-Relation"
     *    role-name="serviceDorei-has-moshtarak"
     *    target-ejb = "Moshtarak"
     *	  target-role-name="moshtarak-might-have-some-serviceDorei"
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


    /*********************************   Namayandegi Relationships *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Namayandegi-ServiceDorei-Relation"
     *    role-name="serviceDorei-has-namayandegi"
     *    target-ejb = "Namayandegi"
     *	  target-role-name="namayandegi-might-have-some-serviceDorei"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="namayandegiId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract NamayandegiLocal getNamayandegi();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setNamayandegi(NamayandegiLocal namayandegiLocal);

    // end of relationship declaration
    //////////////////////////////////



    /** Holds value of property userId. */
    private java.lang.Integer kilometerKarkard;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKilometerKarkard();
    public abstract void setKilometerKarkard(java.lang.Integer kilometerKarkard);



    /** Holds value of property userId. */
    private java.sql.Date tarikh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikh();
    public abstract void setTarikh(java.sql.Date tarikh);



    /** Holds value of property userId. */
    private java.lang.String noeServiceDorei;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNoeServiceDorei();
    public abstract void setNoeServiceDorei(java.lang.String noeServiceDorei);



    /** Holds value of property userId. */
    private java.lang.Integer hazineh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHazineh();
    public abstract void setHazineh(java.lang.Integer hazineh);

    private Integer taeedHesabdar;
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedHesabdar();
    public abstract void setTaeedHesabdar(java.lang.Integer taeedHesabdar);

    private Integer taeedNamayandeh;
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedNamayandeh();
    public abstract void setTaeedNamayandeh(Integer taeedNamayandeh);

    protected String getTable(){
        return "ServiceDorei";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract ServiceDoreiModel getServiceDoreiModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setServiceDoreiModel(ServiceDoreiModel model);

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


	protected java.util.Collection dynaQuery(String query) {
		Object[] args = {};
		Collection mycollection;

		try {
			ServiceDoreiLocalHome myHome = (ServiceDoreiLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

}
