
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
 *      name="KasriEmdad"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/KasriEmdad"
 *      local-jndi-name="ejb/emdad/KasriEmdadLocal"
 *      schema="KasriEmdad"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="KasriEmdad"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="KasriEmdadLight"
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
 * 	    field-name="kasriId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer kasriId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM KasriEmdad AS o WHERE o.kasriId = ?1"
 *
 *
 */

public abstract class KasriEmdadEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(KasriEmdadModel kasriEmdadModel) throws CreateException {
           try {
           if ((kasriEmdadModel.getId() == null) || (kasriEmdadModel.getId().length() == 0)) {
               kasriEmdadModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(kasriEmdadModel.getId());


        // copy from model
        setTarikh(kasriEmdadModel.getTarikh());
//        setKasriId(kasriEmdadModel.getKasriId());
        setTahvilshod(kasriEmdadModel.getTahvilshod());
        setTaeedAnbardar(kasriEmdadModel.getTaeedAnbardar());
        setTaeedEmdadgar(kasriEmdadModel.getTaeedEmdadgar());
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
    private java.sql.Date tarikh;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikh();
    public abstract void setTarikh(java.sql.Date tarikh);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer kasriId;
           
    /**
     * @ejb.persistent-field
     *
     * @jboss.persistence
     * read-only = "true"
     *
     */
    public abstract java.lang.Integer getKasriId();
    public abstract void setKasriId(java.lang.Integer kasriId);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer tahvilshod;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTahvilshod();
    public abstract void setTahvilshod(java.lang.Integer tahvilshod);
    
    /** Holds value of property userId. */
    private java.lang.Integer taeedAnbardar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedAnbardar();
    public abstract void setTaeedAnbardar(java.lang.Integer taeedAnbardar);

    /** Holds value of property userId. */
    private java.lang.Integer taeedEmdadgar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedEmdadgar();
    public abstract void setTaeedEmdadgar(java.lang.Integer taeedEmdadgar);

    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Emdadgar-kasriEmdad-Relation"
     *    role-name="kasriEmdad-has-emdadgar"
     *    target-ejb = "Emdadgar"
     *	  target-role-name="emdadgar-might-have-some-kasriEmdad"
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



    protected String getTable(){
        return "KasriEmdad";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract KasriEmdadModel getKasriEmdadModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setKasriEmdadModel(KasriEmdadModel model);
    
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

    protected String getJoinStatement() {
        return "KasriEmdad.emdadgarId = Emdadgar.Id";
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
			KasriEmdadLocalHome myHome = (KasriEmdadLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

}
