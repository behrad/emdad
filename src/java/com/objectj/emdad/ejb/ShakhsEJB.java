package com.objectj.emdad.ejb;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Mehdi Amoui
 * @ejb.bean name="Shakhs"
 * type="CMP"
 * primkey-field="id"
 * view-type="both"
 * jndi-name="ejb/emdad/Shakhs"
 * local-jndi-name="ejb/emdad/ShakhsLocal"
 * schema="Shakhs"
 * cmp-version="2.x"
 * @ejb.util generate="physical"
 * @ejb.value-object name="Shakhs"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="*"
 * @ejb.value-object name="ShakhsLight"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="light"
 * @ejb.pk class="String"
 * @ejb:finder signature="java.util.Collection findAll()"
 * @jboss.load-group load-group-name="list"
 * field-name="shakhsId"
 * field-name="name"
 * @jboss.read-ahead strategy = "on-find"
 * page-size = "20"
 * @jboss.method-attributes pattern = "get*"
 * read-only = "true"
 * @ejb.finder signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 * query = ""
 * @jboss.query signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 * dynamic = "true"
 * eager-load-group = "list"
 * @ejb.finder signature="java.util.Collection findByEntityId(java.lang.Integer shakhsId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Shakhs AS o WHERE o.shakhsId = ?1"
 */

public abstract class ShakhsEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate( ShakhsModel shakhsModel ) throws CreateException {
        try {
            if ( ( shakhsModel.getId() == null ) || ( shakhsModel.getId().length() == 0 ) ) {
                shakhsModel.setId( com.objectj.emdad.ejb.util.Util.generateGUID( this ) );
            }
            setId( shakhsModel.getId() );


            // copy from model
            setName( shakhsModel.getName() );
//        setShakhsId(shakhsModel.getShakhsId());
            setUsername( shakhsModel.getUsername() );
            setPassword( shakhsModel.getPassword() );
//        setDaftarOstaniId(shakhsModel.getDaftarOstaniId());
            setNaghshId( shakhsModel.getNaghshId() );
            setEnable( shakhsModel.getEnable() );
        } catch ( Exception exception ) {
            log.error( exception );
            throw new EJBException( exception.toString() );
        }
        // EJB 2.0 spec says return null for CMP ejbCreate methods
        return null;
    }

    /**
     * Holds value of property userId.
     */
    private String id;


    /**
     * Getter for property id.
     *
     * @return Value of property id.
     * @ejb.pk-field
     * @ejb.value-object match="light"
     * @ejb.persistence
     * @ejb.interface-method
     */
    public abstract String getId();

    public abstract void setId( String id );


    /*********************************   DaftarOstani Relationships *************************************/

    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="DaftarOstani-Shakhs-Relation"
     * role-name="shakhs-has-daftarOstani"
     * target-ejb = "DaftarOstani"
     * target-role-name="daftarOstani-might-have-some-shakhs"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation-mapping style="foreign-key"
     * @jboss.relation fk-constraint="true"
     * fk-column="daftarOstaniId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract DaftarOstaniLocal getDaftarOstani();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setDaftarOstani( DaftarOstaniLocal daftarOstaniLocal );

    // end of relationship declaration
    //////////////////////////////////


    private java.lang.String entityId;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getEntityId();

    public abstract void setEntityId( java.lang.String entityId );

    private java.lang.String enable;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getEnable();

    public abstract void setEnable( java.lang.String enable );


    /**
     * Holds value of property userId.
     */
    private java.lang.String username;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getUsername();

    public abstract void setUsername( java.lang.String username );

    private java.lang.String password;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getPassword();

    public abstract void setPassword( java.lang.String password );

    private java.lang.String name;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getName();

    public abstract void setName( java.lang.String name );


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer shakhsId;

    /**
     * @ejb.persistent-field
     * @jboss.persistence read-only = "true"
     */
    public abstract java.lang.Integer getShakhsId();

    public abstract void setShakhsId( java.lang.Integer shakhsId );


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer naghshId;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNaghshId();

    public abstract void setNaghshId( java.lang.Integer naghshId );


    /**
     * @ejb.value-object match="light"
     */
    public String getDaftarOstaniName() {
        if ( getDaftarOstani() != null ) {
            return getDaftarOstani().getDaftarOstaniModel().getName();
        }

        return null;
    }

    public void setDaftarOstaniName( String daftarOstaniName ) {
    }


    protected String getTable() {
        return "Shakhs";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract ShakhsModel getShakhsModel();

    /**
     * @ejb.interface-method
     */
    public abstract void setShakhsModel( ShakhsModel model );

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

    public void setEntityContext( EntityContext entityContext ) throws EJBException, RemoteException {
        this.ctx = entityContext;
    }

    public void unsetEntityContext() throws EJBException, RemoteException {
        this.ctx = null;
    }


    /**
     * @ejb.interface-method
     */
    public void myRemove() throws SQLException, ProxyReferenceException {
        String Id = getId();
        super.myRemove( Id );
    }


    /**
     * @ejb.home-method
     */
    public ResultSet ejbHomeAdvanceRead( Connection connection, QueryObject queryObject ) throws FinderException {
        return super.ejbHomeAdvanceRead( connection, queryObject );
    }


    protected java.util.Collection dynaQuery( String query ) {
        Object[] args = {};
        Collection mycollection;

        try {
            ShakhsLocalHome myHome = (ShakhsLocalHome) ctx.getEJBLocalHome();
            mycollection = myHome.findGeneric( query, args );
            return mycollection;
        } catch ( Exception exception ) {
            log.error( exception );
        }
        return null;

    }

    protected String getJoinStatement() {
        return "shakhs.daftarOstaniId = daftarOstani.Id AND shakhs.naghshId = admin_roles.Id";
    }

}
