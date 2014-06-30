
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
 *      name="Naghshe"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Naghshe"
 *      local-jndi-name="ejb/emdad/NaghsheLocal"
 *      schema="Naghshe"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Naghshe"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="NaghsheLight"
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
 * 	    field-name="naghsheId"
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
 */

public abstract class NaghsheEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(NaghsheModel naghsheModel) throws CreateException {
           try {
           if ((naghsheModel.getId() == null) || (naghsheModel.getId().length() == 0)) {
                naghsheModel.setId( com.objectj.emdad.ejb.util.Util.generateGUID(this) );
            }
            setId(naghsheModel.getId());


        // copy from model
        setTaArzeGoegraphy(naghsheModel.getTaArzeGoegraphy());
        setTaTooleGoegraphy(naghsheModel.getTaTooleGoegraphy());
        setAzArzeGoegraphy(naghsheModel.getAzArzeGoegraphy());
        setMantagheId(naghsheModel.getMantagheId());
        setAzTooleGoegraphy(naghsheModel.getAzTooleGoegraphy());
        setMapLevel(naghsheModel.getMapLevel());
        setFileName(naghsheModel.getFileName());
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
    private java.lang.Integer taArzeGoegraphy;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaArzeGoegraphy();
    public abstract void setTaArzeGoegraphy(java.lang.Integer taArzeGoegraphy);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer taTooleGoegraphy;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaTooleGoegraphy();
    public abstract void setTaTooleGoegraphy(java.lang.Integer taTooleGoegraphy);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer azArzeGoegraphy;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzArzeGoegraphy();
    public abstract void setAzArzeGoegraphy(java.lang.Integer azArzeGoegraphy);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer mantagheId;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMantagheId();
    public abstract void setMantagheId(java.lang.Integer mantagheId);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer azTooleGoegraphy;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzTooleGoegraphy();
    public abstract void setAzTooleGoegraphy(java.lang.Integer azTooleGoegraphy);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer mapLevel;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMapLevel();
    public abstract void setMapLevel(java.lang.Integer mapLevel);
    
     
    /** Holds value of property userId. */
    private java.lang.String fileName;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getFileName();
    public abstract void setFileName(java.lang.String fileName);

    protected String getTable(){
        return "Naghshe";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract NaghsheModel getNaghsheModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setNaghsheModel(NaghsheModel model);
    
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
			NaghsheLocalHome myHome = (NaghsheLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

}
