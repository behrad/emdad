
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
 *      name="PeigiriEzamgar"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/PeigiriEzamgar"
 *      local-jndi-name="ejb/emdad/PeigiriEzamgarLocal"
 *      schema="PeigiriEzamgar"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="PeigiriEzamgar"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="PeigiriEzamgarLight"
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
 * 	    field-name="peigiriEzamgarId"
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

public abstract class PeigiriEzamgarEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(PeigiriEzamgarModel peigiriEzamgarModel) throws CreateException {
           try {
           if ((peigiriEzamgarModel.getId() == null) || (peigiriEzamgarModel.getId().length() == 0)) {
                peigiriEzamgarModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(peigiriEzamgarModel.getId());


        // copy from model
        setZamanPeigiri(peigiriEzamgarModel.getZamanPeigiri());
        setNatije(peigiriEzamgarModel.getNatije());
        } catch(Exception exception) {
            log.error(exception);
            throw new EJBException(exception.toString());
        }    
        // EJB 2.0 spec says return null for CMP ejbCreate methods
        return null;
    }

/**
     * @ejb.value-object match="light"
     */
        public Integer getEmdadEmdadId() {
            if (getEmdad() != null)
                return getEmdad().getEmdadModel().getEmdadId();

            return null;
        }

        public void setEmdadEmdadId(Integer emdadId){
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
    private java.sql.Timestamp zamanPeigiri;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanPeigiri();
    public abstract void setZamanPeigiri(java.sql.Timestamp zamanPeigiri);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String natije;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNatije();
    public abstract void setNatije(java.lang.String natije);
    
     

    protected String getTable(){
        return "PeigiriEzamgar";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Emdad-PeigiriEzamgar-Relation"
     *    role-name="peigiriEzamgar-has-emdad"
     *    target-ejb = "Emdad"
     * 	  target-role-name = "emdad-might-have-some-peigiriEzamger"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="emdadId"
     *    related-pk-field="id"
     *
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
    /**
     * @ejb.interface-method
     */
    public abstract PeigiriEzamgarModel getPeigiriEzamgarModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setPeigiriEzamgarModel(PeigiriEzamgarModel model);
    
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
			PeigiriEzamgarLocalHome myHome = (PeigiriEzamgarLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}
     protected String getJoinStatement() {
            return "peigiriEzamgar.emdadId = emdad.Id";
    }

}