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
 * @ejb.bean name="Qate"
 * type="CMP"
 * primkey-field="id"
 * view-type="both"
 * jndi-name="ejb/emdad/Qate"
 * local-jndi-name="ejb/emdad/QateLocal"
 * schema="Qate"
 * cmp-version="2.x"
 * @ejb.util generate="physical"
 * @ejb.value-object name="Qate"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="*"
 * @ejb.value-object name="QateLight"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="light"
 * @ejb.pk class="String"
 * @ejb:finder signature="java.util.Collection findAll()"
 * @jboss.load-group load-group-name="list"
 * field-name="qateId"
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
 * @ejb.finder signature="java.util.Collection findByEntityId(java.lang.Integer qateId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Qate AS o WHERE o.qateId = ?1"
 */

public abstract class QateEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate( QateModel qateModel ) throws CreateException {
        try {
            if ( ( qateModel.getId() == null ) || ( qateModel.getId().length() == 0 ) ) {
                qateModel.setId( com.objectj.emdad.ejb.util.Util.generateGUID( this ) );
            }
            setId( qateModel.getId() );

            // copy from model
            setShomareFanni( qateModel.getShomareFanni() );
            setName( qateModel.getName() );
            setQateId( qateModel.getQateId() );
            setVahedShomaresh( qateModel.getVahedShomaresh() );
            setGheimat( qateModel.getGheimat() );
            setSatheMaharat( qateModel.getSatheMaharat() );
            setSaghfeTedadi( qateModel.getSaghfeTedadi() );

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

    /**
     * Holds value of property userId.
     */
    private java.lang.String shomareFanni;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomareFanni();

    public abstract void setShomareFanni( java.lang.String shomareFanni );

    /**
     * Holds value of property userId.
     */
    private java.lang.String name;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getName();

    public abstract void setName( java.lang.String name );

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer qateId;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getQateId();

    public abstract void setQateId( java.lang.Integer qateId );

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer vahedShomaresh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getVahedShomaresh();

    public abstract void setVahedShomaresh( java.lang.Integer vahedShomaresh );

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer gheimat;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getGheimat();

    public abstract void setGheimat( java.lang.Integer gheimat );

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer satheMaharat;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSatheMaharat();

    public abstract void setSatheMaharat( java.lang.Integer satheMaharat );

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer saghfeTedadi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSaghfeTedadi();

    public abstract void setSaghfeTedadi( java.lang.Integer saghfeTedadi );

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="NoeKhodro-Qate-Relation"
     * role-name="Qate-has-NoeKhodro"
     * target-ejb = "NoeKhodro"
     * target-role-name = "NoeKhodro-might-have-some-Qate"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="noeKhodroId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract NoeKhodroLocal getNoeKhodro();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setNoeKhodro( NoeKhodroLocal noeKhodro );

    protected String getTable() {
        return "Qate";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract QateModel getQateModel();

    /**
     * @ejb.interface-method
     */
    public abstract void setQateModel( QateModel model );

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
            QateLocalHome myHome = (QateLocalHome) ctx.getEJBLocalHome();
            mycollection = myHome.findGeneric( query, args );
            return mycollection;
        } catch ( Exception exception ) {
            log.error( exception );
        }
        return null;

    }

}
