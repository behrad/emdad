
package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 *      name="MojoodiAnbar"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/MojoodiAnbar"
 *      local-jndi-name="ejb/emdad/MojoodiAnbarLocal"
 *      schema="MojoodiAnbar"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="MojoodiAnbar"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="MojoodiAnbarLight"
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
 * 	    field-name="mojoodiAnbarId"
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

public abstract class MojoodiAnbarEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(MojoodiAnbarModel mojoodiAnbarModel) throws CreateException {
           try {
           if ((mojoodiAnbarModel.getId() == null) || (mojoodiAnbarModel.getId().length() == 0)) {
                mojoodiAnbarModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(mojoodiAnbarModel.getId());


        // copy from model
        setAnbarId(mojoodiAnbarModel.getAnbarId());
        setMojoodi(mojoodiAnbarModel.getMojoodi());
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
    private java.lang.Integer anbarId;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAnbarId();
    public abstract void setAnbarId(java.lang.Integer anbarId);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer mojoodi;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMojoodi();
    public abstract void setMojoodi(java.lang.Integer mojoodi);
    

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Qate-mojoodiAnbar-Relation"
	 *    role-name="mojoodiAnbar-has-Qate"
	 *    target-ejb = "Qate"	
	 *	  target-role-name="Qate-might-have-some-mojoodiAnbar"
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
	 * 	  strategy = "on-find"
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
	   

    protected String getTable(){
        return "MojoodiAnbar";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract MojoodiAnbarModel getMojoodiAnbarModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setMojoodiAnbarModel(MojoodiAnbarModel model);
    
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
			MojoodiAnbarLocalHome myHome = (MojoodiAnbarLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}
	
	protected String getJoinStatement() {
		return "mojoodiAnbar.qateId = Qate.id";
	}

}
