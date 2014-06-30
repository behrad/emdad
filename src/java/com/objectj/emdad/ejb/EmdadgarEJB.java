
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
 *      name="Emdadgar"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Emdadgar"
 *      local-jndi-name="ejb/emdad/EmdadgarLocal"
 *      schema="Emdadgar"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Emdadgar"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="EmdadgarLight"
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
 * 	    field-name="emdadgarId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer emdadgarId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Emdadgar AS o WHERE o.emdadgarId = ?1"
 *
 *
 */

public abstract class EmdadgarEJB extends BaseEJB implements EntityBean {
    
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
    public String ejbCreate(EmdadgarModel emdadgarModel) throws CreateException {
           try {
           if ((emdadgarModel.getId() == null) || (emdadgarModel.getId().length() == 0)) {
                emdadgarModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(emdadgarModel.getId());


        // copy from model
        setSatheMaharat(emdadgarModel.getSatheMaharat());
        setAddress(emdadgarModel.getAddress());
        setSaghfeMojoodi(emdadgarModel.getSaghfeMojoodi());
        setMobile(emdadgarModel.getMobile());
        setTel(emdadgarModel.getTel());
        setName(emdadgarModel.getName());
        setVazeat(emdadgarModel.getVazeat());
        setHadaksarKar(emdadgarModel.getHadaksarKar());
        setKarDarDast(emdadgarModel.getKarDarDast());
       setTaArz(emdadgarModel.getTaArz());
       setTaTool(emdadgarModel.getTaTool());
       setAzArz(emdadgarModel.getAzArz());
       setAzTool(emdadgarModel.getAzTool());
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
     *    name="NoeEmdadgar-Emdadgar-Relation"
     *    role-name="emdadgar-has-noeEmdadgar"
     *    target-ejb = "NoeEmdadgar"
     * 	  target-role-name = "noeEmdadgar-might-have-some-emdadgar"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="noeEmdadgarId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract NoeEmdadgarLocal getNoeEmdadgar();
    /**
    * @ejb.interface-method view-type="local"
    */
    public abstract void setNoeEmdadgar(NoeEmdadgarLocal noeEmdadgarLocal);

    // end of relationship declaration
    //////////////////////////////////


    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="DaftarOstani-Emdadgar-Relation"
     *    role-name="emdadgar-has-daftarOstani"
     *    target-ejb = "DaftarOstani"
     * 	  target-role-name = "daftarOstani-might-have-some-emdadgar"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="daftarOstaniId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract DaftarOstaniLocal getDaftarOstani();
    /**
    * @ejb.interface-method view-type="local"
    */
    public abstract void setDaftarOstani(DaftarOstaniLocal daftarOstaniLocal);

    // end of relationship declaration
    //////////////////////////////////


    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Namayandegi-Emdadgar-Relation"
     *    role-name="emdadgar-has-namayandegi"
     *    target-ejb = "Namayandegi"
     * 	  target-role-name = "namayandegi-might-have-some-emdadgar"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="namayandegiId"
     *    related-pk-field="id"
     *
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract NamayandegiLocal getNamayandegi();
    /**
    * @ejb.interface-method view-type="local"
    */
    public abstract void setNamayandegi(NamayandegiLocal namayandegiLocal);

    // end of relationship declaration
    //////////////////////////////////


    /** Holds value of property userId. */
    private java.lang.Integer satheMaharat;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSatheMaharat();
    public abstract void setSatheMaharat(java.lang.Integer satheMaharat);
    
     
    
    /** Holds value of property userId. */
    private java.lang.String address;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getAddress();
    public abstract void setAddress(java.lang.String address);
    
     
    
    /** Holds value of property userId. */
    private java.lang.Integer saghfeMojoodi;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSaghfeMojoodi();
    public abstract void setSaghfeMojoodi(java.lang.Integer saghfeMojoodi);
    
     
    
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
    private java.lang.Integer vazeat;
           
    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getVazeat();
    public abstract void setVazeat(java.lang.Integer vazeat);
    
    /** Holds value of property userId. */
    private java.lang.Integer hadaksarKar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHadaksarKar();
    public abstract void setHadaksarKar(java.lang.Integer hadaksarKar);

    /** Holds value of property userId. */
    private java.lang.Integer karDarDast;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKarDarDast();
    public abstract void setKarDarDast(java.lang.Integer karDarDast);


    /** Holds value of property userId. */
    private java.lang.Integer emdadgarId;
           
    /**
     * @ejb.persistent-field
     *
     * @jboss.persistence
     * read-only = "true"
     *
     */
    public abstract java.lang.Integer getEmdadgarId();
    public abstract void setEmdadgarId(java.lang.Integer emdadgarId);
    
    /** Holds value of property userId. */
    private java.lang.Integer taArz;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaArz();
    public abstract void setTaArz(java.lang.Integer taArz);



    /** Holds value of property userId. */
    private java.lang.Integer taTool;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaTool();
    public abstract void setTaTool(java.lang.Integer taTool);



    /** Holds value of property userId. */
    private java.lang.Integer azArz;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzArz();
    public abstract void setAzArz(java.lang.Integer azArz);


    /** Holds value of property userId. */
    private java.lang.Integer azTool;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getAzTool();
    public abstract void setAzTool(java.lang.Integer azTool);


    protected String getTable(){
        return "Emdadgar";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }
    
    /**
     * @ejb.interface-method
     */
    public abstract EmdadgarModel getEmdadgarModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setEmdadgarModel(EmdadgarModel model);

    /**
     * @ejb.interface-method
     */
    public void setEmdadgarModel1(com.objectj.emdad.ejb.EmdadgarModel valueHolder) {
        try {
             setSatheMaharat(valueHolder.getSatheMaharat());
             setAddress(valueHolder.getAddress());
             setSaghfeMojoodi(valueHolder.getSaghfeMojoodi());
             setMobile(valueHolder.getMobile());
             setTel(valueHolder.getTel());
             setName(valueHolder.getName());
             setVazeat(valueHolder.getVazeat());
             setHadaksarKar(valueHolder.getHadaksarKar());
             setKarDarDast(valueHolder.getKarDarDast());
            setTaArz(valueHolder.getTaArz());
            setTaTool(valueHolder.getTaTool());
            setAzArz(valueHolder.getAzArz());
            setAzTool(valueHolder.getAzTool());
        } catch (Exception e) {
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
			EmdadgarLocalHome myHome = (EmdadgarLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

    protected String getJoinStatement() {
        return "emdadgar.noeEmdadgarId = noeEmdadgar.Id AND " +
               "emdadgar.daftarOstaniId = daftarOstani.Id AND " +
               "emdadgar.namayandegiId = namayandegi.Id";
    }
}
