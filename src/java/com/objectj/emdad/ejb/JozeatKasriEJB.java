
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
 *      name="JozeatKasri"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/JozeatKasri"
 *      local-jndi-name="ejb/emdad/JozeatKasriLocal"
 *      schema="JozeatKasri"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="JozeatKasri"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="JozeatKasriLight"
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
 * 	    field-name="jozeatKasriId"
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

public abstract class JozeatKasriEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate(JozeatKasriModel jozeatKasriModel) throws CreateException {
           try {
           if ((jozeatKasriModel.getId() == null) || (jozeatKasriModel.getId().length() == 0)) {
               jozeatKasriModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(jozeatKasriModel.getId());


        // copy from model
        setTedadEmdadgar(jozeatKasriModel.getTedadEmdadgar());
        setTedadKasri(jozeatKasriModel.getTedadKasri());
        setTedadAnbar(jozeatKasriModel.getTedadAnbar());
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
     *    name="KasriEmdad-JozeatKasri-Relation"
     *    role-name="kasriEmdad-has-jozeatKasri"
     *    target-ejb = "KasriEmdad"
     * 	  target-role-name = "kasriEmdad-might-have-some-jozeatKasri"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="kasriEmdadId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract KasriEmdadLocal getKasriEmdad();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setKasriEmdad(KasriEmdadLocal kasriEmdadLocal);

    // end of relationship declaration
    //////////////////////////////////



    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="JozeatKasri-Qate-Relation"
     *    role-name="jozeatKasri-has-Qate"
     *    target-ejb = "Qate"
     *	  target-role-name="jozeatKasri-might-have-some-qate"
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

    /** Holds value of property userId. */
    private java.lang.Integer tedadEmdadgar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadEmdadgar();
    public abstract void setTedadEmdadgar(java.lang.Integer tedadEmdadgar);



    /** Holds value of property userId. */
    private java.lang.Integer tedadKasri;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadKasri();
    public abstract void setTedadKasri(java.lang.Integer tedadKasri);



    /** Holds value of property userId. */
    private java.lang.Integer tedadAnbar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadAnbar();
    public abstract void setTedadAnbar(java.lang.Integer tedadAnbar);



    protected String getTable(){
        return "JozeatKasri";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract JozeatKasriModel getJozeatKasriModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setJozeatKasriModel(JozeatKasriModel model);

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
			JozeatKasriLocalHome myHome = (JozeatKasriLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

}
