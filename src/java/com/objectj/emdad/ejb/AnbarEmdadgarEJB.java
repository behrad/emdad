
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
 *      name="AnbarEmdadgar"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/AnbarEmdadgar"
 *      local-jndi-name="ejb/emdad/AnbarEmdadgarLocal"
 *      schema="AnbarEmdadgar"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="AnbarEmdadgar"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="AnbarEmdadgarLight"
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
 * 	    field-name="anbarEmdadgarId"
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

public abstract class  AnbarEmdadgarEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(AnbarEmdadgarModel anbarEmdadgarModel) throws CreateException {
           try {
           if ((anbarEmdadgarModel.getId() == null) || (anbarEmdadgarModel.getId().length() == 0)) {
//               anbarEmdadgarModel.setId( UIDDispenser.getDispenser().getNextId() );
//               String iid = com.objectj.emdad.ejb.util.Util.generateGUID(this);
                anbarEmdadgarModel.setId( com.objectj.emdad.ejb.util.Util.generateGUID(this) );
            }
            setId(anbarEmdadgarModel.getId());


        // copy from model
        setMojoodi(anbarEmdadgarModel.getMojoodi());
           //} catch(UIDDispenserException exception) {
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
	 *    name="Emdadgar-anbarEmdadgar-Relation"
	 *    role-name="anbarEmdadgar-has-Emdadgar"
	 *    target-ejb = "Emdadgar"	
	 *	  target-role-name="Emdadgar-might-have-some-anbarEmdadgar"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="emdadgarId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 * 	  strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract EmdadgarLocal getEmdadgar();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setEmdadgar(EmdadgarLocal emdadgarLocal);

	// end of relationship declaration
	//////////////////////////////////
	
	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Qate-anbarEmdadgar-Relation"
	 *    role-name="anbarEmdadgar-has-Qate"
	 *    target-ejb = "Qate"	
	 *	  target-role-name="Qate-might-have-some-anbarEmdadgar"
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
	*
	*/
	public abstract void setQate(QateLocal qateLocal);

	// end of relationship declaration
	//////////////////////////////////
	
		    

    protected String getTable(){
        return "AnbarEmdadgar";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract AnbarEmdadgarModel getAnbarEmdadgarModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setAnbarEmdadgarModel(AnbarEmdadgarModel model);
    
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
			AnbarEmdadgarLocalHome myHome = (AnbarEmdadgarLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}
	
//	protected String getJoinStatement() {
//		return "anbarEmdadgar.emdadgarId = Emdadgar.id AND anbarEmdadgar.qateId = Qate.id";
//	}
}
