
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
 *      name="BazaryabMotefareghe"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/BazaryabMotefareghe"
 *      local-jndi-name="ejb/emdad/BazaryabMotefaregheLocal"
 *      schema="BazaryabMotefareghe"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="BazaryabMotefareghe"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="BazaryabMotefaregheLight"
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
 * 	    field-name="bazaryabMotefaregheId"
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
 */

public abstract class BazaryabMotefaregheEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(BazaryabMotefaregheModel bazaryabMotefaregheModel) throws CreateException {
           try {
           if ((bazaryabMotefaregheModel.getId() == null) || (bazaryabMotefaregheModel.getId().length() == 0)) {
//               bazaryabMotefaregheModel.setId( UIDDispenser.getDispenser().getNextId() );
               String iid = com.objectj.emdad.ejb.util.Util.generateGUID(this);
               System.out.println("iid=["+iid+"]");
                bazaryabMotefaregheModel.setId(iid );
            }
            setId(bazaryabMotefaregheModel.getId());


        // copy from model
        setAddress(bazaryabMotefaregheModel.getAddress());
        setMobile(bazaryabMotefaregheModel.getMobile());
        setTel(bazaryabMotefaregheModel.getTel());
        setName(bazaryabMotefaregheModel.getName());
        setShShenasname(bazaryabMotefaregheModel.getShShenasname());
        setNamePedar(bazaryabMotefaregheModel.getNamePedar());
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
    private java.lang.String address;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getAddress();
    public abstract void setAddress(java.lang.String address);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String mobile;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getMobile();
    public abstract void setMobile(java.lang.String mobile);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String tel;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getTel();
    public abstract void setTel(java.lang.String tel);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String name;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getName();
    public abstract void setName(java.lang.String name);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String shShenasname;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShShenasname();
    public abstract void setShShenasname(java.lang.String shShenasname);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String namePedar;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNamePedar();
    public abstract void setNamePedar(java.lang.String namePedar);
    
     

    protected String getTable(){
        return "BazaryabMotefareghe";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract BazaryabMotefaregheModel getBazaryabMotefaregheModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setBazaryabMotefaregheModel(BazaryabMotefaregheModel model);
    
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

}
