
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
 * @author  Ramtin Khosravi
 *
 * @ejb.bean
 *      name="KhodrojagozinMasraf"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/KhodrojagozinMasraf"
 *      local-jndi-name="ejb/emdad/KhodrojagozinMasrafLocal"
 *      schema="KhodrojagozinMasraf"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="KhodrojagozinMasraf"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="KhodrojagozinMasrafLight"
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
 * 	    field-name="khodrojagozinMasrafId"
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

public abstract class KhodrojagozinMasrafEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(KhodrojagozinMasrafModel khodrojagozinMasrafModel) throws CreateException {
           try {
           if ((khodrojagozinMasrafModel.getId() == null) || (khodrojagozinMasrafModel.getId().length() == 0)) {
                khodrojagozinMasrafModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(khodrojagozinMasrafModel.getId());


        // copy from model
        setTarikhTahvilAzMoshtari(khodrojagozinMasrafModel.getTarikhTahvilAzMoshtari());
        setTarikhTahvilBeMoshtari(khodrojagozinMasrafModel.getTarikhTahvilBeMoshtari());
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



    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Emdad-KhodrojagozinMasraf-Relation"
     *    role-name="khodrojagozinMasraf-has-emdad"
     *    target-ejb = "Emdad"
     * 	  target-role-name = "emdad-might-have-some-khodrojagozinMasraf"
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


    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Khodrojagozin-KhodrojagozinMasraf-Relation"
     *    role-name="khodrojagozinMasraf-has-khodrojagozin"
     *    target-ejb = "Khodrojagozin"
     * 	  target-role-name = "khodrojagozin-might-have-some-khodrojagozinMasraf"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="khodrojagozinId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract KhodrojagozinLocal getKhodrojagozin();
    /**
    * @ejb.interface-method view-type="local"
    */
    public abstract void setKhodrojagozin(KhodrojagozinLocal khodrojagozinLocal);
    // end of relationship declaration
    //////////////////////////////////

     
    


    
    /** Holds value of property userId. */
    private java.sql.Timestamp tarikhTahvilAzMoshtari;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getTarikhTahvilAzMoshtari();
    public abstract void setTarikhTahvilAzMoshtari(java.sql.Timestamp tarikhTahvilAzMoshtari);
    
     
    
    /** Holds value of property userId. */
    private java.sql.Timestamp tarikhTahvilBeMoshtari;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getTarikhTahvilBeMoshtari();
    public abstract void setTarikhTahvilBeMoshtari(java.sql.Timestamp tarikhTahvilBeMoshtari);
    
     

    protected String getTable(){
        return "KhodrojagozinMasraf";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract KhodrojagozinMasrafModel getKhodrojagozinMasrafModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setKhodrojagozinMasrafModel(KhodrojagozinMasrafModel model);
    
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
			KhodrojagozinMasrafLocalHome myHome = (KhodrojagozinMasrafLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

    protected String getJoinStatement() {
        return " khodrojagozinMasraf.emdadId = emdad.Id AND khodrojagozinMasraf.khodrojagozinId = khodrojagozin.Id AND khodrojagozin.daftarOstaniId = daftarOstani.Id ";
    }

}
