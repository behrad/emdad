package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ejb.bean type="Stateless"
 * name="QateSession"
 * jndi-name="ejb/emdad/QateSession"
 * local-jndi-name="ejb/emdad/QateSessionLocal"
 * view-type="both"
 * cmp-version="2.x"
 * local-business-interface="com.objectj.emdad.proxy.QateProxy"
 * transaction-type="Container"
 * @ejb.util generate="physical"
 */

public abstract class QateSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

    protected Class getValueObjectClass() {
        return QateModel.class;
    }

    public ValueObject modelToList( Object o ) {
        QateLocal qateLocal = (QateLocal) o;
        QateList qateList = new QateList();
        QateModel qateModel = qateLocal.getQateModel();

        qateList.setGheimat( qateModel.getGheimat() );
        qateList.setId( qateModel.getId() );
        qateList.setName( qateModel.getName() );
        qateList.setQateId( qateModel.getQateId() );
        qateList.setSatheMaharat( qateModel.getSatheMaharat() );
        qateList.setShomareFanni( qateModel.getShomareFanni() );
        qateList.setVahedShomaresh( qateModel.getVahedShomaresh() );
        qateList.setSaghfeTedadi( qateModel.getSaghfeTedadi() );

        qateList.setNoeKhodroId( qateLocal.getNoeKhodro().getId() );
        return qateList;
    }

    public ValueObject resultSetToList( ResultSet resultSet ) {
        try {

            ArrayList vahedShomareshList = new ArrayList();
            vahedShomareshList = Util.getArrayList( "vahedShomaresh" );

            QateList qateList = new QateList();

            qateList.setGheimat( new Integer( resultSet.getInt( "gheimat" ) ) );
            qateList.setName( resultSet.getString( "name" ) );
            qateList.setId( resultSet.getString( "id" ) );
            qateList.setQateId( new Integer( resultSet.getInt( "qateId" ) ) );
            qateList.setShomareFanni( resultSet.getString( "shomareFanni" ) );
            qateList.setVahedShomareshName( ( (ComboObject) Util.getFromArrayList( "vahedShomaresh", resultSet.getInt( "vahedShomaresh" ) ) ).getName() );
            qateList.setSaghfeTedadi( new Integer( resultSet.getInt( "saghfeTedadi" ) ) );
            qateList.setNoeKhodroId( new String( resultSet.getString( "noeKhodroId" ) ) );

            return qateList;
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create() throws ProxyException {
        return super.create();
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject valueObject, String noeKhodroId ) throws ProxyException {
        try {
            NoeKhodroLocal noekhodroLocal = null;
            if ( Util.isNotEmptyId( noeKhodroId ) ) {
                noekhodroLocal = NoeKhodroUtil.getLocalHome().findByPrimaryKey( noeKhodroId );
            }
            return create( valueObject, noekhodroLocal );
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject valueObject, NoeKhodroLocal noeKhodroLocal ) throws ProxyException {
        try {
            QateLocal qateLocal = QateUtil.getLocalHome().create( (QateModel) valueObject );
            if ( noeKhodroLocal != null ) {
                qateLocal.setNoeKhodro( noeKhodroLocal );
            }
            return qateLocal.getQateModel();
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public ValueObject read( String id ) throws ProxyException {
        return super.read( id );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult read( String[] ids ) throws ProxyException {
        return super.read( ids );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult read( ValueObject valueObject ) throws ProxyException {
        return super.read( valueObject );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readByEntityId( Integer entityId ) throws ProxyException {
        return super.readByEntityId( entityId );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readCombo( String table, String field, String filter ) throws ProxyException {
        return super.readCombo( table, field, filter );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readCombo( String table, String field ) throws ProxyException {
        return super.readCombo( table, field );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readList( QueryObject queryObject ) throws ProxyException {
        return super.readList( queryObject );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readModel( QueryObject queryObject ) throws ProxyException {
        return super.readModel( queryObject );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void remove( String id ) throws ProxyException, ProxyReferenceException {
        super.remove( id );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void remove( String[] ids ) throws ProxyException, ProxyReferenceException {
        super.remove( ids );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void remove( ValueObject valueObject ) throws ProxyException, ProxyReferenceException {
        super.remove( valueObject );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public ResultSet report( QueryObject queryObject, Connection connection ) throws ProxyException {
        return super.report( queryObject, connection );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject, String noeKhodroId ) throws ProxyException {
        try {
            NoeKhodroLocal noekhodroLocal = null;
            if ( Util.isNotEmptyId( noeKhodroId ) ) {
                noekhodroLocal = NoeKhodroUtil.getLocalHome().findByPrimaryKey( noeKhodroId );
            }

            update( valueObject, noekhodroLocal );
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject, NoeKhodroLocal noeKhodroLocal ) throws ProxyException {
        try {
            QateLocal qateLocal = QateUtil.getLocalHome().findByPrimaryKey( ( (QateModel) valueObject ).getId() );
            qateLocal.setQateModel( (QateModel) valueObject );
            update( qateLocal, noeKhodroLocal );
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( QateLocal qateLocal, NoeKhodroLocal noeKhodroLocal ) throws ProxyException {
        try {
            if ( noeKhodroLocal != null ) {
                qateLocal.setNoeKhodro( noeKhodroLocal );
            }
            return;
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

}
