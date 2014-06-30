package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @ejb.bean type="Stateless"
 * name="ShakhsSession"
 * jndi-name="ejb/emdad/ShakhsSession"
 * local-jndi-name="ejb/emdad/ShakhsSessionLocal"
 * view-type="both"
 * cmp-version="2.x"
 * local-business-interface="com.objectj.emdad.proxy.ShakhsProxy"
 * transaction-type="Container"
 * @ejb.util generate="physical"
 */

public abstract class ShakhsSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

    protected Class getValueObjectClass() {
        return ShakhsModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject valueObject, String daftarOstaniId ) throws ProxyException {
        try {
            //=-= System.out.println("valueObject = " + ((ShakhsModel)valueObject).getUsername());
            ShakhsLocal shakhsLocal = ShakhsUtil.getLocalHome().create( (ShakhsModel) valueObject );

            DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey( daftarOstaniId );

            shakhsLocal.setDaftarOstani( daftarOstaniObject );

            return shakhsLocal.getShakhsModel();

        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    public ValueObject resultSetToList( ResultSet resultSet ) {
        try {

            //ArrayList shoghlList = new ArrayList();
//			shoghlList = Util.getArrayList("shoghl");

            ShakhsList shakhsList = new ShakhsList();

            shakhsList.setId( resultSet.getString( "id" ) );
            shakhsList.setName( resultSet.getString( "name" ) );
            shakhsList.setShakhsId( new Integer( resultSet.getInt( "shakhsId" ) ) );
            shakhsList.setNaghshId( new Integer( resultSet.getInt( "naghshId" ) ) );
            shakhsList.setNaghshName( resultSet.getString( "roleTitle" ) );

            shakhsList.setUsername( resultSet.getString( "username" ) );
            shakhsList.setPassword( resultSet.getString( "password" ) );
            shakhsList.setEnable( resultSet.getString( "enable" ) );

            String daftarOstaniId = resultSet.getString( "daftarOstaniId" );
            shakhsList.setDaftarOstaniId( daftarOstaniId );
            DaftarOstaniLocal daftarOstaniLocal = DaftarOstaniUtil.getLocalHome().findByPrimaryKey( resultSet.getString( "daftarOstaniId" ) );
            if ( daftarOstaniLocal != null ) {
                DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
                shakhsList.setDaftarOstaniName( daftarOstaniModel.getName() );
            }

            int naghshId = shakhsList.getNaghshId().intValue();
            String entityId = resultSet.getString( "entityId" );
            shakhsList.setEntityId( entityId );

            if ( naghshId == Constants.getNamayandegiShoghlId() ) {
                NamayandegiLocal namayandegiLocal = NamayandegiUtil.getLocalHome().findByPrimaryKey( entityId );
                if ( namayandegiLocal != null ) {
                    NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
                    shakhsList.setEntityName( namayandegiModel.getName() );
                }
            } else if ( naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId() ) {
                EmdadgarLocal emdadgarLocal = EmdadgarUtil.getLocalHome().findByPrimaryKey( entityId );
                if ( emdadgarLocal != null ) {
                    EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
                    shakhsList.setEntityName( emdadgarModel.getName() );
                }
            }

            return shakhsList;

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject, String daftarOstaniId ) throws ProxyException {
        try {

            ShakhsLocal shakhsLocal = ShakhsUtil.getLocalHome().findByPrimaryKey( valueObject.getId() );

            if ( daftarOstaniId != null ) {
                DaftarOstaniLocal daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey( daftarOstaniId );
                shakhsLocal.setDaftarOstani( daftarOstaniObject );

            }
            shakhsLocal.setShakhsModel( (ShakhsModel) valueObject );
            return;
        } catch ( Exception exception ) {
            log.error( exception );
            throw new ProxyException( exception );
        }
    }

    public ValueObject modelToList( Object o ) {
        ShakhsLocal shakhsLocal = (ShakhsLocal) o;

        ShakhsList shakhsList = new ShakhsList();
        ShakhsModel shakhsModel = shakhsLocal.getShakhsModel();

        shakhsList.setId( shakhsModel.getId() );
        shakhsList.setName( shakhsModel.getName() );
        shakhsList.setShakhsId( shakhsModel.getShakhsId() );
        shakhsList.setNaghshId( shakhsModel.getNaghshId() );

        String naghshName = UserAccessEntity.stringQuery( "SELECT roleTitle FROM admin_roles WHERE id = '" + shakhsModel.getNaghshId() + "'", "roleTitle" );
        log.info( "~~~~~~~~~~~~~~~~~~~ naghshName: " + naghshName );
        shakhsList.setNaghshName( naghshName );

        shakhsList.setUsername( shakhsModel.getUsername() );
        shakhsList.setPassword( shakhsModel.getPassword() );

        DaftarOstaniLocal daftarOstaniLocal = shakhsLocal.getDaftarOstani();
        if ( daftarOstaniLocal != null ) {
            DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
            shakhsList.setDaftarOstaniId( daftarOstaniModel.getId() );
            shakhsList.setDaftarOstaniName( daftarOstaniModel.getName() );
        }

        int naghshId = shakhsList.getNaghshId().intValue();
        String entityId = shakhsModel.getEntityId();
        shakhsList.setEntityId( entityId );
        try {
            if ( naghshId == Constants.getNamayandegiShoghlId() ) {
                NamayandegiLocal namayandegiLocal = NamayandegiUtil.getLocalHome().findByPrimaryKey( entityId );
                if ( namayandegiLocal != null ) {
                    NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
                    shakhsList.setEntityName( namayandegiModel.getName() );
                }
            } else if ( naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId() ) {
                EmdadgarLocal emdadgarLocal = EmdadgarUtil.getLocalHome().findByPrimaryKey( entityId );
                if ( emdadgarLocal != null ) {
                    EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
                    shakhsList.setEntityName( emdadgarModel.getName() );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }


        return shakhsList;
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
    public ValueObject create( ValueObject valueObject ) throws ProxyException {
        return super.create( valueObject );
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
        setAsView( queryObject, "shakhs", "view_shakhs" );
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
        setAsView( queryObject, "shakhs", "view_shakhs" );
        return super.report( queryObject, connection );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject ) throws ProxyException {
        super.update( valueObject );
    }

}
