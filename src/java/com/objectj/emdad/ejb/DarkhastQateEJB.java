
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
 *      name="DarkhastQate"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/DarkhastQate"
 *      local-jndi-name="ejb/emdad/DarkhastQateLocal"
 *      schema="DarkhastQate"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="DarkhastQate"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="DarkhastQateLight"
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
 * 	    field-name="darkhastQateId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer darkhastQateId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM DarkhastQate AS o WHERE o.darkhastQateId = ?1"
 *
 *
 */

public abstract class DarkhastQateEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate(DarkhastQateModel darkhastQateModel) throws CreateException {
           try {
           if ((darkhastQateModel.getId() == null) || (darkhastQateModel.getId().length() == 0)) {
                darkhastQateModel.setId( com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(darkhastQateModel.getId());


        // copy from model
        setTedadSarparast(darkhastQateModel.getTedadSarparast());
        setSabtkonandeh(darkhastQateModel.getSabtkonandeh());
        setManba(darkhastQateModel.getManba());
        setTedadAnbar(darkhastQateModel.getTedadAnbar());
        setTaeedShodehSarparast(darkhastQateModel.getTaeedShodehSarparast());
        setTarikhDarkhast(darkhastQateModel.getTarikhDarkhast());
        setTaeedShodeAnbar(darkhastQateModel.getTaeedShodeAnbar());
        setTedadDarkhasti(darkhastQateModel.getTedadDarkhasti());
        } catch(Exception exception) {
            log.error(exception);
            throw new EJBException(exception.toString());
        }
        // EJB 2.0 spec says return null for CMP ejbCreate methods
        return null;
    }




    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Emdadgar-darkhastQate-Relation"
     *    role-name="darkhastQate-has-Emdadgar"
     *    target-ejb = "Emdadgar"
     *	  target-role-name="Emdadgar-might-have-some-darkhastQate"
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
     *    name="Qate-darkhastQate-Relation"
     *    role-name="darkhastQate-has-Qate"
     *    target-ejb = "Qate"
     *	  target-role-name="Qate-might-have-some-darkhastQate"
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
    private java.lang.Integer darkhastQateId;

    /**
     * @ejb.persistent-field
     *
     * @jboss.persistence
     * read-only = "true"
     *
     */
    public abstract java.lang.Integer getDarkhastQateId();
    public abstract void setDarkhastQateId(java.lang.Integer darkhastQateId);



    /** Holds value of property userId. */
    private java.lang.Integer tedadSarparast;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadSarparast();
    public abstract void setTedadSarparast(java.lang.Integer tedadSarparast);



    /** Holds value of property userId. */
    private java.lang.String sabtkonandeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getSabtkonandeh();
    public abstract void setSabtkonandeh(java.lang.String sabtkonandeh);



    /** Holds value of property userId. */
    private java.lang.Integer manba;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getManba();
    public abstract void setManba(java.lang.Integer manba);



    /** Holds value of property userId. */
    private java.lang.Integer tedadAnbar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadAnbar();
    public abstract void setTedadAnbar(java.lang.Integer tedadAnbar);



    /** Holds value of property userId. */
    private java.lang.Integer taeedShodehSarparast;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedShodehSarparast();
    public abstract void setTaeedShodehSarparast(java.lang.Integer taeedShodehSarparast);



    /** Holds value of property userId. */
    private java.sql.Date tarikhDarkhast;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhDarkhast();
    public abstract void setTarikhDarkhast(java.sql.Date tarikhDarkhast);



    /** Holds value of property userId. */
    private java.lang.Integer taeedShodeAnbar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedShodeAnbar();
    public abstract void setTaeedShodeAnbar(java.lang.Integer taeedShodeAnbar);



    /** Holds value of property userId. */
    private java.lang.Integer tedadDarkhasti;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTedadDarkhasti();
    public abstract void setTedadDarkhasti(java.lang.Integer tedadDarkhasti);



    protected String getTable(){
        return "DarkhastQate";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }


    /**
     * @ejb.interface-method
     */
    public void setDarkhastQateModel1( com.objectj.emdad.ejb.DarkhastQateModel valueHolder )
    {
       try
       {
           setTedadSarparast(valueHolder.getTedadSarparast());
           setSabtkonandeh(valueHolder.getSabtkonandeh());
           setManba(valueHolder.getManba());
           setTedadAnbar(valueHolder.getTedadAnbar());
           setTaeedShodehSarparast(valueHolder.getTaeedShodehSarparast());
           setTarikhDarkhast(valueHolder.getTarikhDarkhast());
           setTaeedShodeAnbar(valueHolder.getTaeedShodeAnbar());
           setTedadDarkhasti(valueHolder.getTedadDarkhasti());
       }
       catch (Exception e)
       {
          throw new javax.ejb.EJBException(e);
       }
    }



    /**
     * @ejb.interface-method
     */
    public abstract DarkhastQateModel getDarkhastQateModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setDarkhastQateModel(DarkhastQateModel model);

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
			DarkhastQateLocalHome myHome = (DarkhastQateLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

//    protected String getJoinStatement() {
//        return " darkhastqate.qateId = qate.id  AND  darkhastqate.emdadgarId = emdadgar.id ";
//    }

}
