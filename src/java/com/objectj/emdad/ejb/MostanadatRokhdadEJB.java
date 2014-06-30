
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
 *      name="MostanadatRokhdad"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/MostanadatRokhdad"
 *      local-jndi-name="ejb/emdad/MostanadatRokhdadLocal"
 *      schema="MostanadatRokhdad"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="MostanadatRokhdad"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="MostanadatRokhdadLight"
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
 * 	    field-name="mostanadatRokhdadId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer mostanadatRokhdadId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM MostanadatRokhdad AS o WHERE o.mostanadatRokhdadId = ?1"
 *
 *
 */

public abstract class MostanadatRokhdadEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(MostanadatRokhdadModel mostanadatRokhdadModel) throws CreateException {
           try {
           if ((mostanadatRokhdadModel.getId() == null) || (mostanadatRokhdadModel.getId().length() == 0)) {
                mostanadatRokhdadModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(mostanadatRokhdadModel.getId());


        // copy from model
        setTarikhSanad(mostanadatRokhdadModel.getTarikhSanad());
        setTarikhSabt(mostanadatRokhdadModel.getTarikhSabt());
        setNameParvande(mostanadatRokhdadModel.getNameParvande());
        setSharh(mostanadatRokhdadModel.getSharh());
       // setMostanadatRokhdadId(mostanadatRokhdadModel.getMostanadatRokhdadId());
        setShomarehSanad(mostanadatRokhdadModel.getShomarehSanad());
        setNameSanad(mostanadatRokhdadModel.getNameSanad());
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

    /*********************************   rokhdad Relationships *************************************/

   /////////////////////////////
   // Relationships starts here

   /**
    *
    * @ejb.interface-method view-type="local"
    *
    * @ejb.relation
    *    name="Rokhdad-MostanadatRokhdad-Relation"
    *    role-name="mostanadatRokhdad-has-rokhdad"
    *    target-ejb = "Rokhdad"
    *	  target-role-name="rokhdad-might-have-some-mostanadatRokhdad"
    *    target-multiple = "yes"
    * 	  multiple = "no"
    *
    * @jboss.relation-mapping style="foreign-key"
    *
    * @jboss.relation
    *    fk-constraint="true"
    *    fk-column="rokhdadId"
    *    related-pk-field="id"
    *
    * @jboss.relation-read-ahead
    *    strategy = "on-find"
    * 	  page-size = "20"
    * 	  eager-load-group = "*"
    */
   public abstract RokhdadLocal getRokhdad();

   /**
    * @ejb.interface-method view-type="local"
    */
   public abstract void setRokhdad(RokhdadLocal rokhdadLocal);

   // end of relationship declaration
   //////////////////////////////////

     
    
    /** Holds value of property userId. */
    private java.sql.Date tarikhSanad;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhSanad();
    public abstract void setTarikhSanad(java.sql.Date tarikhSanad);
    
     
    
    /** Holds value of property userId. */
    private java.sql.Date tarikhSabt;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhSabt();
    public abstract void setTarikhSabt(java.sql.Date tarikhSabt);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String nameParvande;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNameParvande();
    public abstract void setNameParvande(java.lang.String nameParvande);


    private java.lang.String nameSanad;
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNameSanad();
    public abstract void setNameSanad(java.lang.String nameSanad);
    
    /** Holds value of property userId. */
    private java.lang.String sharh;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getSharh();
    public abstract void setSharh(java.lang.String sharh);
    

    /** Holds value of property userId. */
    private java.lang.Integer mostanadatRokhdadId;
           
    /**
     * @ejb.persistent-field
     *
     * @jboss.persistence
     * read-only = "true"
     */
    public abstract java.lang.Integer getMostanadatRokhdadId();
    public abstract void setMostanadatRokhdadId(java.lang.Integer mostanadatRokhdadId);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String shomarehSanad;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehSanad();
    public abstract void setShomarehSanad(java.lang.String shomarehSanad);


/**
     * @ejb.value-object match="light"
     */
        public Integer getRokhdadRokhdadId() {
            if (getRokhdad() != null)
                return getRokhdad().getRokhdadModel().getRokhdadId();

            return null;
        }

        public void setRokhdadRokhdadId(Integer rokhdadId){
        }

    protected String getTable(){
        return "MostanadatRokhdad";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract MostanadatRokhdadModel getMostanadatRokhdadModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setMostanadatRokhdadModel(MostanadatRokhdadModel model);
  /**
     * @ejb.interface-method
     */
    public void setMostanadatRokhdadModel1( com.objectj.emdad.ejb.MostanadatRokhdadModel valueHolder )
    {
       try
       {
          setTarikhSanad(valueHolder.getTarikhSanad());
          setTarikhSabt(valueHolder.getTarikhSabt());
          setNameParvande(valueHolder.getNameParvande());
          setSharh(valueHolder.getSharh());
         // setMostanadatRokhdadId(mostanadatRokhdadModel.getMostanadatRokhdadId());
          setShomarehSanad(valueHolder.getShomarehSanad());
          setNameSanad(valueHolder.getNameSanad());
       }
       catch (Exception e)
       {
          throw new javax.ejb.EJBException(e);
       }
    }
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
			MostanadatRokhdadLocalHome myHome = (MostanadatRokhdadLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}
    protected String getJoinStatement() {
            return "mostanadatRokhdad.rokhdadId = rokhdad.Id";
    }

}
