
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
 *      name="VazeatKhedmat"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/VazeatKhedmat"
 *      local-jndi-name="ejb/emdad/VazeatKhedmatLocal"
 *      schema="VazeatKhedmat"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="VazeatKhedmat"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="VazeatKhedmatLight"
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
 * 	    field-name="vazeatKhedmatId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer vazeatKhedmatId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM VazeatKhedmat AS o WHERE o.vazeatKhedmatId = ?1"
 *
 *
 */

public abstract class VazeatKhedmatEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(VazeatKhedmatModel vazeatKhedmatModel) throws CreateException {
           try {
           if ((vazeatKhedmatModel.getId() == null) || (vazeatKhedmatModel.getId().length() == 0)) {
                vazeatKhedmatModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(vazeatKhedmatModel.getId());


        // copy from model
        setOnvan(vazeatKhedmatModel.getOnvan());
        setVazeatKhedmatId(vazeatKhedmatModel.getVazeatKhedmatId());
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
    private java.lang.String onvan;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getOnvan();
    public abstract void setOnvan(java.lang.String onvan);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer vazeatKhedmatId;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getVazeatKhedmatId();
    public abstract void setVazeatKhedmatId(java.lang.Integer vazeatKhedmatId);
    
     

    protected String getTable(){
        return "VazeatKhedmat";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract VazeatKhedmatModel getVazeatKhedmatModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setVazeatKhedmatModel(VazeatKhedmatModel model);
    
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
			VazeatKhedmatLocalHome myHome = (VazeatKhedmatLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

}
