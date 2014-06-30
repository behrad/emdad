package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ejb.bean type="Stateless"
 * name="EmdadSession"
 * jndi-name="ejb/emdad/EmdadSession"
 * local-jndi-name="ejb/emdad/EmdadSessionLocal"
 * view-type="both"
 * cmp-version="2.x"
 * local-business-interface="com.objectj.emdad.proxy.EmdadProxy"
 * transaction-type="Container"
 * @ejb.util generate="physical"
 */

public abstract class EmdadSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

    private final static int EGHDAM_SHODEH_BALI = 1;

    protected Class getValueObjectClass() {
        return EmdadModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject valueObject, String rokhdadId, String vazeatKhedmatId, String emdadgarId, String ezamgarId, String dalileToolKeshidaneEmdadId, String namayandegiId ) throws ProxyException {
        try {
            long t1 = ( new java.util.Date() ).getTime();
            RokhdadLocal rokhdadObject = RokhdadUtil.getLocalHome().findByPrimaryKey( rokhdadId );
//MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().create((MoshtarakModel) valueObject);
            ValueObject vo = create( valueObject, rokhdadObject, null, null, null, null, null );
            long t2 = ( new java.util.Date() ).getTime() - t1;
            updateRela( vo.getId(), new String[]{rokhdadId, vazeatKhedmatId, emdadgarId, ezamgarId, dalileToolKeshidaneEmdadId, namayandegiId} );
            log.info( "-- create time Emdad end=" + t2 + "," + ( ( new java.util.Date() ).getTime() - t1 ) );
            if ( true ) {
                return vo;
            }

            VazeatKhedmatLocal vazeatObject = null;
            ShakhsLocal ezamgarObject = null;
            EmdadgarLocal emdadgarObject = null;
            NamayandegiLocal namayandegiObject = null;
            if ( !isDatabaseSQL() ) {
                if ( Util.isNotEmptyId( emdadgarId ) ) {
                    emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey( emdadgarId );
                    namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey( (String) com.objectj.emdad.ejb.util.Util.get( "nullKey" ) );
                } else {
                    emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey( (String) com.objectj.emdad.ejb.util.Util.get( "nullKey" ) );
                    if ( Util.isNotEmptyId( namayandegiId ) ) {
                        namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey( namayandegiId );
                    } else {
                        namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey( (String) com.objectj.emdad.ejb.util.Util.get( "nullKey" ) );
                    }
                }

                if ( Util.isNotEmptyId( ezamgarId ) ) {
                    ezamgarObject = ShakhsUtil.getLocalHome().findByPrimaryKey( ezamgarId );
                } else {
                    ezamgarObject = ShakhsUtil.getLocalHome().findByPrimaryKey( (String) com.objectj.emdad.ejb.util.Util.get( "nullKey" ) );
                }
                if ( Util.isNotEmptyId( vazeatKhedmatId ) ) {
                    vazeatObject = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey( vazeatKhedmatId );
                } else {
                    vazeatObject = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey( (String) com.objectj.emdad.ejb.util.Util.get( "nullKey" ) );
                }
            } else {
                if ( emdadgarId != null && emdadgarId.length() != 0 ) {
                    emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey( emdadgarId );
                } else if ( namayandegiId != null && namayandegiId.length() != 0 ) {
                    namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey( namayandegiId );
                }

                if ( ezamgarId != null && ezamgarId.length() != 0 ) {
                    ezamgarObject = ShakhsUtil.getLocalHome().findByPrimaryKey( ezamgarId );
                }
                if ( vazeatKhedmatId != null && vazeatKhedmatId.length() != 0 ) {
                    vazeatObject = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey( vazeatKhedmatId );
                }
            }

            DalileToolKeshidaneEmdadLocal dalilObject = null;
            if ( dalileToolKeshidaneEmdadId != null && dalileToolKeshidaneEmdadId.length() != 0 ) {
                dalilObject = DalileToolKeshidaneEmdadUtil.getLocalHome().findByPrimaryKey( dalileToolKeshidaneEmdadId );
            }

            return create( valueObject, rokhdadObject, vazeatObject, emdadgarObject, ezamgarObject, dalilObject, namayandegiObject );

        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject valueObject, com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                               com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject ) throws ProxyException {

        try {

//            computeAyyabZahab((EmdadModel)valueObject);

            RokhdadModel rokhdadModel = rokhdadObject.getRokhdadModel();
            ( (EmdadModel) valueObject ).setKilometerKarkard( rokhdadModel.getKilometerKarkard() );
            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().create( (EmdadModel) valueObject );
            //update(emdadLocal, rokhdadObject, vazeatObject, emdadgarObject, ezamgarObject, dalilObject, namayandegiObject);

            rokhdadModel.setEghdamShodeh( new Integer( EGHDAM_SHODEH_BALI ) );
            rokhdadModel.setDastorkarGhabli( new Integer( 0 ) );
            rokhdadObject.setRokhdadModel1( rokhdadModel );
            if ( ( (EmdadModel) valueObject ).getKilometerKarkard() != null && ( (EmdadModel) valueObject ).getKilometerKarkard().intValue() != 0 ) {
                MoshtarakLocal moshtarakLocal = rokhdadObject.getMoshtarak();
                if ( moshtarakLocal != null ) {
                    NoeKhodroLocal noeKhodroLocal = moshtarakLocal.getNoeKhodro();
                    NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
                    if ( ( (EmdadModel) valueObject ).getKilometerKarkard().intValue() > noeKhodroModel.getGuaranteeDistance().intValue() ) {
                        MoshtarakLocal ml = rokhdadObject.getMoshtarak();
                        MoshtarakModel mm = rokhdadObject.getMoshtarak().getMoshtarakModel();
                        mm.setGuarantee( new Integer( 2 ) );
                        ml.setMoshtarakModel( mm );
                    }
                }
            }

            return emdadLocal.getEmdadModel();
        } catch ( Exception exception ) {
            exception.printStackTrace( System.out );
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( com.objectj.emdad.ejb.RokhdadLocal rokhdadLocal, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject, com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject ) throws ProxyException {
        try {

            if ( moshtarakObject != null ) {
                rokhdadLocal.setMoshtarak( moshtarakObject );
            }

            rokhdadLocal.setNamayandegi( namayandegiObject );

            if ( daftarOstaniObject != null ) {
                rokhdadLocal.setDaftarOstani( daftarOstaniObject );
            }

            if ( shahrObject != null ) {
                rokhdadLocal.setShahr( shahrObject );
            }
            return;
        } catch ( Exception exception ) {
            log.error( exception );
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject rovalueObject, ValueObject emvalueObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                               com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject,
                               com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.DaftarOstaniLocal daftarOstaniObject, com.objectj.emdad.ejb.ShahrLocal shahrObject ) throws ProxyException {

        try {
            RokhdadLocalHome rokhdadLocalHome = RokhdadUtil.getLocalHome();
            RokhdadLocal rokhdadObject = rokhdadLocalHome.create( (RokhdadModel) rovalueObject );

            ( RokhdadSessionUtil.getLocalHome().create() ).update( rokhdadObject, moshtarakObject, namayandegiObject, daftarOstaniObject, shahrObject );

//            computeAyyabZahab((EmdadModel)emvalueObject);

            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().create( (EmdadModel) emvalueObject );
            update( emdadLocal, rokhdadObject, vazeatObject, emdadgarObject, ezamgarObject, dalilObject, namayandegiObject );

            return emdadLocal.getEmdadModel();
        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public ValueObject create( ValueObject rovalueObject, ValueObject emvalueObject, String vazeatId, String emdadgarId,
                               String ezamgarId, String dalilId, String namayandegiId,
                               String moshtarakId, String daftarOstaniId, String shahrId ) throws ProxyException {

        try {
//            RokhdadLocalHome rokhdadLocalHome = RokhdadUtil.getLocalHome();
//            RokhdadLocal rokhdadObject = rokhdadLocalHome.create((RokhdadModel) rovalueObject);
//            (RokhdadSessionUtil.getLocalHome().create()).update(rokhdadObject,moshtarakObject,namayandegiObject,daftarOstaniObject,shahrObject);
            long t1 = ( new java.util.Date() ).getTime();
//            computeAyyabZahab((EmdadModel)emvalueObject);
            RokhdadSessionUtil.getLocalHome().create().create2( rovalueObject, moshtarakId, namayandegiId, daftarOstaniId, shahrId );
            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().create( (EmdadModel) emvalueObject );
            updateRela( emvalueObject.getId(), new String[]{rovalueObject.getId(), vazeatId, emdadgarId, ezamgarId, dalilId, namayandegiId} );
            EmdadModel em = emdadLocal.getEmdadModel();
            log.info( "-- create time Emdad2 end=" + ( ( new java.util.Date() ).getTime() - t1 ) );
//            vo = create(emvalueObject, vo.getId(), vazeatId, emdadgarId, ezamgarId, dalilId, namayandegiId);

            return em;
        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject, String rokhdadId, String vazeatKhedmatId, String emdadgarId, String ezamgarId, String dalileToolKeshidaneEmdadId, String namayandegiId ) throws ProxyException {
        try {
            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey( valueObject.getId() );
            emdadLocal.setEmdadModel1( (EmdadModel) valueObject );
            updateRela( valueObject.getId(), new String[]{rokhdadId, vazeatKhedmatId, emdadgarId, ezamgarId, dalileToolKeshidaneEmdadId, namayandegiId} );
            if ( true ) {
                return;
            }

            RokhdadLocal rokhdadObject = null;
            if ( Util.isNotEmpty( rokhdadId ) ) {
                rokhdadObject = RokhdadUtil.getLocalHome().findByPrimaryKey( rokhdadId );
            }

            NamayandegiLocal namayandegiObject = null;
            EmdadgarLocal emdadgarObject = null;
            if ( Util.isNotEmpty( namayandegiId ) ) {
                namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey( namayandegiId );
            } else {
                if ( Util.isNotEmpty( emdadgarId ) ) {
                    emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey( emdadgarId );
                }
            }

            ShakhsLocal ezamgarObject = null;
            if ( Util.isNotEmpty( ezamgarId ) ) {
                ezamgarObject = ShakhsUtil.getLocalHome().findByPrimaryKey( ezamgarId );
            }
            VazeatKhedmatLocal vazeatObject = null;
            if ( Util.isNotEmpty( vazeatKhedmatId ) ) {
                vazeatObject = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey( vazeatKhedmatId );
            }
            DalileToolKeshidaneEmdadLocal dalilObject = null;
            if ( Util.isNotEmpty( dalileToolKeshidaneEmdadId ) ) {
                dalilObject = DalileToolKeshidaneEmdadUtil.getLocalHome().findByPrimaryKey( dalileToolKeshidaneEmdadId );
            }

            update( valueObject, rokhdadObject, vazeatObject, emdadgarObject, ezamgarObject, dalilObject, namayandegiObject );
            return;
        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject, com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                        com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject ) throws ProxyException {
        try {
            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey( valueObject.getId() );
            emdadLocal.setEmdadModel1( (EmdadModel) valueObject );
            update( emdadLocal, rokhdadObject, vazeatObject, emdadgarObject, ezamgarObject, dalilObject, namayandegiObject );
            return;

        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void update( com.objectj.emdad.ejb.EmdadLocal emdadLocal, com.objectj.emdad.ejb.RokhdadLocal rokhdadObject, com.objectj.emdad.ejb.VazeatKhedmatLocal vazeatObject, com.objectj.emdad.ejb.EmdadgarLocal emdadgarObject,
                        com.objectj.emdad.ejb.ShakhsLocal ezamgarObject, com.objectj.emdad.ejb.DalileToolKeshidaneEmdadLocal dalilObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject ) throws ProxyException {
        try {
            emdadLocal.setRokhdad( rokhdadObject );
            if ( namayandegiObject != null ) {
                emdadLocal.setNamayandegi( namayandegiObject );
                emdadLocal.setEmdadgar( null );
            } else {
                if ( emdadgarObject != null ) {
                    emdadLocal.setEmdadgar( emdadgarObject );
                    emdadLocal.setNamayandegi( null );
                }
            }

            if ( ezamgarObject != null ) {
                emdadLocal.setEzamgar( ezamgarObject );
            }
            if ( vazeatObject != null ) {
                emdadLocal.setVazeatKhedmat( vazeatObject );
            }
            if ( dalilObject != null ) {
                emdadLocal.setDalileToolKeshidaneEmdad( dalilObject );
            }
            return;

        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    protected void computeAyyabZahab( EmdadModel valueObject ) {
        int x = valueObject.getFaseleAzNamayandegi().intValue();
        if ( x < 20 ) {
            valueObject.setHazinehAyyabZahab( new Integer( 20000 ) );
        } else {
            valueObject.setHazinehAyyabZahab( new Integer( ( x - 20 ) * 2 * 250 + 20000 ) );
        }
    }

    protected String getUpdateRelaStatement() {
        if ( isDatabaseSQL() ) {
            return "execute dbo.UpdateRelationEmdad2 ?, ?,?, ?,?, ?,? ";
        } else {
            return "execute UpdateRelationEmdad2(?, ?,?, ?,?, ?,?) ";
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void updateRela( String id, String[] relaIds ) throws ProxyException {
/*        if(!isDatabaseSQL()){
            if(Util.isEmptyId(relaIds[2]))
                relaIds[2] = (String) com.objectj.emdad.ejb.util.Util.get("nullKey");
            else if(Util.isEmptyId(relaIds[5]))
                relaIds[5] = (String) com.objectj.emdad.ejb.util.Util.get("nullKey");
            if(Util.isEmptyId(relaIds[1]))
                relaIds[1] = (String) com.objectj.emdad.ejb.util.Util.get("nullKey");
        }*/
        super.updateRela( id, relaIds );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public void payan( com.objectj.emdad.ejb.EmdadModel vo, String akharinTagheerDahandeh, String dalileToolKeshidaneEmdadId, String emdadgarId, String namayandegiId ) throws ProxyException {
        try {
            long t1 = ( new java.util.Date() ).getTime();
            int i = 1;
            computeAyyabZahab( vo );
            Connection c = Util.getConnection();
            if ( !isDatabaseSQL() ) {
                CallableStatement cstmt = c.prepareCall( "{CALL PayanEmdad3( ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?)}" );
                cstmt.setString( i++, vo.getId() );
                cstmt.setObject( i++, akharinTagheerDahandeh );
                cstmt.setInt( i++, vo.getFaseleAzNamayandegi() != null ? vo.getFaseleAzNamayandegi().intValue() : 0 );
                cstmt.setTimestamp( i++, vo.getZamanPayan() );
                cstmt.setTimestamp( i++, vo.getZamanVagheiPayan() );
                cstmt.setInt( i++, vo.getKilometerKarkard() != null ? vo.getKilometerKarkard().intValue() : 0 );
                cstmt.setInt( i++, vo.getMablaghPardakhtShodeh() != null ? vo.getMablaghPardakhtShodeh().intValue() : 0 );
                cstmt.setInt( i++, vo.getHazinehAyyabZahab().intValue() );
                cstmt.setString( i++, vo.getRahAndazi() );
                cstmt.setString( i++, vo.getTozihat() );
                cstmt.setString( i++, vo.getElateService() );
                cstmt.setString( i++, dalileToolKeshidaneEmdadId );
                cstmt.setString( i++, emdadgarId );
                cstmt.setString( i++, namayandegiId );
                cstmt.executeUpdate();
                cstmt.close();
            } else {
                String selectStatement = "execute dbo.PayanEmdad3 ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?";
                PreparedStatement prepStmt = c.prepareStatement( selectStatement ); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                prepStmt.setString( i++, vo.getId() );
                prepStmt.setObject( i++, akharinTagheerDahandeh );
                prepStmt.setInt( i++, vo.getFaseleAzNamayandegi() != null ? vo.getFaseleAzNamayandegi().intValue() : 0 );
                prepStmt.setTimestamp( i++, vo.getZamanPayan() );
                prepStmt.setTimestamp( i++, vo.getZamanVagheiPayan() );
                prepStmt.setInt( i++, vo.getKilometerKarkard() != null ? vo.getKilometerKarkard().intValue() : 0 );
                prepStmt.setInt( i++, vo.getMablaghPardakhtShodeh() != null ? vo.getMablaghPardakhtShodeh().intValue() : 0 );
                prepStmt.setInt( i++, vo.getHazinehAyyabZahab().intValue() );
                prepStmt.setString( i++, vo.getRahAndazi() );
                prepStmt.setString( i++, vo.getTozihat() );
                prepStmt.setString( i++, vo.getElateService() );
                prepStmt.setString( i++, dalileToolKeshidaneEmdadId );
                prepStmt.setString( i++, emdadgarId );
                prepStmt.setString( i++, namayandegiId );
                payan( prepStmt );
                prepStmt.close();
            }
            c.close();
            log.info( "-- doPayan Done time=" + ( ( new java.util.Date() ).getTime() - t1 ) );
        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Required"
     */
    public void payan( PreparedStatement prepStmt ) throws ProxyException {
        try {
            prepStmt.executeUpdate();
        } catch ( Exception exception ) {
            exception.printStackTrace();
            throw new ProxyException( exception );
        }
    }

    public ValueObject modelToList( Object o ) {
        EmdadLocal EmdadLocal = (EmdadLocal) o;

        EmdadList emdadList = new EmdadList();
        EmdadModel emdadModel = EmdadLocal.getEmdadModel();

        emdadList.setId( emdadModel.getId() );
        emdadList.setAkharinTagheerDahandeh( emdadModel.getAkharinTagheerDahandeh() );
        emdadList.setEmdadId( emdadModel.getEmdadId() );
        emdadList.setFaseleAzNamayandegi( emdadModel.getFaseleAzNamayandegi() );
        emdadList.setHododeHazinehKol( emdadModel.getHododeHazinehKol() );
        emdadList.setKilometerKarkard( emdadModel.getKilometerKarkard() );
        emdadList.setMablaghPardakhtShodeh( emdadModel.getMablaghPardakhtShodeh() );
        emdadList.setZamanEzam( emdadModel.getZamanEzam() );
        emdadList.setZamanShoro( emdadModel.getZamanShoro() );
        emdadList.setZamanVagheiEzam( emdadModel.getZamanVagheiEzam() );
        emdadList.setZamanVagheiPayan( emdadModel.getZamanVagheiPayan() );
        emdadList.setZamanVagheiShoro( emdadModel.getZamanVagheiShoro() );
        emdadList.setZamanPayan( emdadModel.getZamanPayan() );
        emdadList.setElateService( emdadModel.getElateService() );
        emdadList.setVazeatKonuni( emdadModel.getVazeatKonuni() );
        emdadList.setModatTamir( emdadModel.getModatTamir() );
        emdadList.setTozihat( emdadModel.getTozihat() );
        emdadList.setHazinehAyyabZahab( emdadModel.getHazinehAyyabZahab() );
        emdadList.setHazinehBoxel( emdadModel.getHazinehBoxel() );
        emdadList.setHazinehJarsaghil( emdadModel.getHazinehJarsaghil() );
        emdadList.setDastoorKarGhabli( emdadModel.getDastoorKarGhabli() );
        emdadList.setMaliDone( emdadModel.getMaliDone() );
        emdadList.setVazeatDakheli( emdadModel.getVazeatDakheli() );
        emdadList.setRahAndazi( "" );
///////////////////////////////////////////////////////////
        emdadList.setShomarehFactor( emdadModel.getShomarehFactor() );
        emdadList.setHazinehAyyabZahab( emdadModel.getHazinehAyyabZahab() );
        emdadList.setHazinehBoxel( emdadModel.getHazinehBoxel() );
        emdadList.setEllateBargashteGuarantee( emdadModel.getEllateBargashteGuarantee() );
        emdadList.setKoliyehMadarek( emdadModel.getKoliyehMadarek() );
        emdadList.setTaeedGuarantee( emdadModel.getTaeedGuarantee() );
        emdadList.setTaeedHesabdar( emdadModel.getTaeedHesabdar() );
        emdadList.setTaeedNamayandegi( emdadModel.getTaeedNamayandegi() );
        emdadList.setNoeEmdadgarId( emdadModel.getNoeEmdadgarId() );
///////////////////////////////////////////////////////////
        emdadList.setEllateBargashteGuarantee( emdadModel.getEllateBargashteGuarantee() );
        if ( emdadModel.getNoeKhedmateVije() != null ) {
            emdadList.setNoeKhedmateVije( emdadModel.getNoeKhedmateVije() );
            emdadList.setNoeKhedmateVijeName( Util.getNameFromArrayList( "emdad", emdadModel.getNoeKhedmateVije() ) );
        }
/*        else{
            emdadList.setNoeKhedmateVije(new Integer(0));
            emdadList.setNoeKhedmateVijeName("");
        }*/
        if ( emdadModel.getKoliyehMadarek() != null ) {
            emdadList.setKoliyehMadarek( emdadModel.getKoliyehMadarek() );
            emdadList.setKoliyehMadarekName( Util.getNameFromArrayList( "yesNo", emdadModel.getKoliyehMadarek() ) );
        }
/*        else{
            emdadList.setKoliyehMadarek(new Integer(0));
            emdadList.setKoliyehMadarekName("");
        }*/
        emdadList.setNoeEmdad( emdadModel.getNoeEmdad() );
        emdadList.setNoeEmdadName( Util.getNameFromArrayList( "noeEmdadName", emdadModel.getNoeEmdad() ) );
//		if (emdadModel.getNoeEmdad().intValue() <= 4) {
//			Object combo = Util.getFromArrayList("noeEmdadName", emdadModel.getNoeEmdad());
//            if( combo != null )
//                emdadList.setNoeEmdadName( ((ComboObject)combo).getName() );
//        }
        Integer vazeatKonuni = emdadModel.getVazeatKonuni();

        if ( emdadModel.getZamanEzam() != null ) {
            emdadList.setZamanEzamHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanEzam().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanEzam() ) );
        } else {
            emdadList.setZamanEzamHejri( "" );
        }

        if ( emdadModel.getZamanVagheiEzam() != null ) {
            emdadList.setZamanVagheiEzamHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanVagheiEzam().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanVagheiEzam() ) );
        } else {
            emdadList.setZamanVagheiEzamHejri( "" );
        }

        if ( vazeatKonuni != null && vazeatKonuni.intValue() != 0 ) {
            if ( emdadModel.getZamanShoro() != null ) {
                emdadList.setZamanShoroHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanShoro().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanShoro() ) );
            } else {
                emdadList.setZamanShoroHejri( "" );
            }

            if ( emdadModel.getZamanVagheiShoro() != null ) {
                emdadList.setZamanVagheiShoroHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanVagheiShoro().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanVagheiShoro() ) );
            } else {
                emdadList.setZamanVagheiShoroHejri( "" );
            }
        } else {
            emdadList.setZamanShoroHejri( "" );
            emdadList.setZamanVagheiShoroHejri( "" );
        }

        if ( vazeatKonuni != null && vazeatKonuni.intValue() == 2 ) {
            if ( emdadModel.getZamanPayan() != null ) {
                emdadList.setZamanPayanHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanPayan().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanPayan() ) );
            } else {
                emdadList.setZamanPayanHejri( "" );
            }

            if ( emdadModel.getZamanVagheiPayan() != null ) {
                emdadList.setZamanVagheiPayanHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( emdadModel.getZamanVagheiPayan().getTime() ) ) + " - " + HejriUtil.chrisToHejri( emdadModel.getZamanVagheiPayan() ) );
            } else {
                emdadList.setZamanVagheiPayanHejri( "" );
            }
            emdadList.setRahAndazi( emdadModel.getRahAndazi() );
        } else {
            emdadList.setZamanPayanHejri( "" );
            emdadList.setZamanVagheiPayanHejri( "" );
        }

        String[] rls = UserAccessEntity.stringQuerys( "select rokhdadId,emdadgarId,namayandegiId,ezamgarId,vazeatKhedmatId,dalileToolKeshidaneEmdadId from emdad where id='" + emdadModel.getId() + "'", "rokhdadId,emdadgarId,namayandegiId,ezamgarId,vazeatKhedmatId,dalileToolKeshidaneEmdadId" );
//		RokhdadLocal rokhdadLocal = EmdadLocal.getRokhdad();
        // check for a valid relationship reference
        if ( Util.isNotEmpty( rls[ 0 ] ) ) {
//            String str[] = UserAccessEntity.stringQuerys("select rokhdadIdO,rokhdadId , eshterakId,moshtarakId,nameDaftarOstani,daftarOstaniId, from rokhdad where ","") emdadModel.getId()
//			RokhdadModel rokhdadModel = rokhdadLocal.getRokhdadModel();
            String[] rls2 = UserAccessEntity.stringQuerys( "select rokhdadId,moshtarakId,daftarostaniId,kilometerKarkardGhabli from rokhdad where id='" + rls[ 0 ] + "'", "rokhdadId,moshtarakId,daftarostaniId,kilometerKarkardGhabli" );
            emdadList.setRokhdadId( rls[ 0 ] );
            emdadList.setRokhdadRokhdadId( new Integer( rls2[ 0 ] ) );
            if ( rls2[ 3 ] == null ) {
                rls2[ 3 ] = "0";
            }
            emdadList.setKilometerKarkardGhabli( new Integer( rls2[ 3 ] ) );
            try {
//				MoshtarakLocal moshtarakLocal = rokhdadLocal.getMoshtarak();
//				MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();
                String[] rls3 = UserAccessEntity.stringQuerys( "select name,nameKhanevadegi,eshterakId from moshtarak where id='" + rls2[ 1 ] + "'", "name,nameKhanevadegi,eshterakId" );
                emdadList.setNameKhanevadegi( rls3[ 1 ] );
                emdadList.setName( rls3[ 0 ] );
                emdadList.setMoshtarakId( rls3[ 2 ] );
                emdadList.setEshterakId( rls2[ 1 ] );
//				DaftarOstaniLocal daftarOstaniLocal = rokhdadLocal.getDaftarOstani();
                if ( Util.isNotEmpty( rls2[ 2 ] ) ) {
//					DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
                    emdadList.setDaftarOstaniId( rls2[ 2 ] );
                    emdadList.setDaftarOstaniName( ComboPool.findInCombo( "daftarOstani", rls2[ 2 ] ) );
                }

            } catch ( Exception e ) {
                e.printStackTrace( System.out );
            }
        }

//		EmdadgarLocal emdadgarLocal = EmdadLocal.getEmdadgar();
        // check for a valid relationship reference
        if ( Util.isNotEmpty( rls[ 1 ] ) ) {
//			EmdadgarModel emdadgarModel = emdadgarLocal.getEmdadgarModel();
            emdadList.setEmdadgarId( rls[ 1 ] );
            emdadList.setEmdadgar( ComboPool.findInCombo( "emdadgar", rls[ 1 ] ) );
            //emdadList.setAmeliyatMojaz(emdadgarModel.getId());
        } else {
            emdadList.setEmdadgarId( null );
            emdadList.setEmdadgar( "" );
        }

//		NamayandegiLocal namayandegiLocal = EmdadLocal.getNamayandegi();
        // check for a valid relationship reference
        if ( Util.isNotEmpty( rls[ 2 ] ) ) {
//			NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
            emdadList.setNamayandegiId( rls[ 2 ] );
            emdadList.setNamayandegiName( ComboPool.findInCombo( "namayandegi_amelyat", rls[ 2 ] ) );
            //emdadList.setAmeliyatMojaz(null);
        } else {
            emdadList.setNamayandegiId( null );
            emdadList.setNamayandegiName( "" );
        }

//		ShakhsLocal shakhsLocal = EmdadLocal.getEzamgar();
        // check for a valid relationship reference
        if ( Util.isNotEmpty( rls[ 3 ] ) ) {
//			ShakhsModel shakhsModel = shakhsLocal.getShakhsModel();
            emdadList.setEzamgarId( rls[ 3 ] );
            emdadList.setEzamgar( UserAccessEntity.stringQuery( "select name from shakhs where id='" + rls[ 3 ] + "'", "name" ) );
        }

//		VazeatKhedmatLocal vazeatLocal = EmdadLocal.getVazeatKhedmat();
        // check for a valid relationship reference
        if ( Util.isNotEmpty( rls[ 4 ] ) ) {
//			VazeatKhedmatModel vazeatModel = vazeatLocal.getVazeatKhedmatModel();
            emdadList.setVazeatKhedmatId( rls[ 4 ] );
            emdadList.setVazeatKhedmatOnvan( ComboPool.findInCombo( "vazeatKhedmat", rls[ 4 ] ) );
        }

//		DalileToolKeshidaneEmdadLocal dalilLocal = EmdadLocal.getDalileToolKeshidaneEmdad();
        if ( Util.isNotEmpty( rls[ 5 ] ) ) {
//			DalileToolKeshidaneEmdadModel dalilModel = dalilLocal.getDalileToolKeshidaneEmdadModel();
            emdadList.setDalileToolKeshidaneEmdadId( rls[ 5 ] );
            emdadList.setDalileToolKeshidanOnvan( ComboPool.findInCombo( "dalileToolKeshidaneEmdad", rls[ 5 ] ) );
        }
        emdadList.setAkharinTagheerDahandeh( UserAccessEntity.stringQuery( "Select name FROM Shakhs WHERE Shakhs.id = '" + emdadModel.getAkharinTagheerDahandeh() + "'", "name" ) );
        return emdadList;
    }

    public ValueObject resultSetToList( ResultSet resultSet ) {
        try {

            EmdadList emdadList = new EmdadList();

            emdadList.setId( resultSet.getString( "id" ) );
            emdadList.setEmdadId( new Integer( resultSet.getInt( "emdadId" ) ) );
            emdadList.setDastoorKarGhabli( new Integer( resultSet.getInt( "dastoorKarGhabli" ) ) );
            emdadList.setMaliDone( new Integer( resultSet.getInt( "maliDone" ) ) );
            emdadList.setVazeatDakheli( new Integer( resultSet.getInt( "vazeatDakheli" ) ) );

            emdadList.setRokhdadId( resultSet.getString( "rokhdadIdO" ) );
            emdadList.setRokhdadRokhdadId( new Integer( resultSet.getInt( "rokhdadId" ) ) );

            emdadList.setEshterakId( resultSet.getString( "eshterakId" ) );

            emdadList.setDaftarOstaniId( resultSet.getString( "daftarOstaniId" ) );
            emdadList.setDaftarOstaniName( resultSet.getString( "nameDaftarOstani" ) );

            emdadList.setVazeatKhedmatId( resultSet.getString( "vazeatKhedmatId" ) );
            emdadList.setVazeatKhedmatOnvan( resultSet.getString( "onvan" ) );

            emdadList.setShomarehFactor( resultSet.getString( "shomarehFactor" ) );
            emdadList.setHazinehAyyabZahab( new Integer( resultSet.getInt( "hazinehAyyabZahab" ) ) );
            emdadList.setHazinehBoxel( new Integer( resultSet.getInt( "hazinehBoxel" ) ) );
            emdadList.setEllateBargashteGuarantee( resultSet.getString( "ellateBargashteGuarantee" ) );
            emdadList.setEmdadgarId( resultSet.getString( "emdadgarId" ) );
            emdadList.setAddress( resultSet.getString( "address" ) );
            emdadList.setKoliyehMadarek( new Integer( resultSet.getInt( "koliyehMadarek" ) ) );
            emdadList.setIrad( resultSet.getString( "irad" ) );

/////////////////////////////////////////////////////////////////////////
//            emdadList.setShomarehFactor(resultSet.getString("shomarehFactor"));
//            emdadList.setTaeedHesabdar(new Integer(resultSet.getInt("taeedHesabdar")));
//			emdadList.setTaeedGuarantee(new Integer(resultSet.getInt("taeedGuarantee")));
//			emdadList.setTaeedNamayandegi(new Integer(resultSet.getInt("taeedNamayandegi")));
////////////////////////////////////////////////////////////////////////////////
            emdadList.setTaeedHesabdar( new Integer( resultSet.getInt( "taeedHesabdar" ) ) );
            emdadList.setTaeedGuarantee( new Integer( resultSet.getInt( "taeedGuarantee" ) ) );
            emdadList.setTaeedNamayandegi( new Integer( resultSet.getInt( "taeedNamayandegi" ) ) );


            if ( Util.isNotEmpty( resultSet.getString( "emdadgarId" ) ) ) {
                if ( Util.isEmpty( resultSet.getString( "mobile" ) ) ) {
                    emdadList.setEmdadgar( resultSet.getString( "nameEmdadgar" ) );
                } else {
                    emdadList.setEmdadgar( resultSet.getString( "nameEmdadgar" ) + "," + resultSet.getString( "mobile" ) );
                }
            } else {
                emdadList.setEmdadgar( "" );
            }

            emdadList.setNamayandegiId( resultSet.getString( "namayandegiIdO" ) );
            if ( Util.isNotEmpty( resultSet.getString( "namayandegiIdO" ) ) ) {
                emdadList.setNamayandegiName( resultSet.getInt( "namayandegiId" ) + "-" + resultSet.getString( "nameNamayandegi" ) );
            } else {
                emdadList.setNamayandegiName( "" );
            }

            emdadList.setEzamgarId( resultSet.getString( "ezamgarId" ) );
            emdadList.setEzamgar( resultSet.getString( "nameShakhs" ) );

            if ( resultSet.getDate( "zamanEzam" ) != null ) {
                emdadList.setZamanEzamHejri( HejriUtil.getTimeFromDate( new java.sql.Timestamp( resultSet.getTimestamp( "zamanEzam" ).getTime() ) ) + " - " + HejriUtil.chrisToHejri( resultSet.getDate( "zamanEzam" ) ) );
            } else {
                emdadList.setZamanEzamHejri( "" );
            }

            emdadList.setVazeatKonuni( new Integer( resultSet.getInt( "vazeatKonuni" ) ) );
            emdadList.setRahAndazi( resultSet.getString( "rahAndazi" ) );
            emdadList.setElateService( resultSet.getString( "elateService" ) );

            int noeEmdad = resultSet.getInt( "noeEmdad" );
            if ( noeEmdad <= 3 ) {
                emdadList.setNoeEmdadName( Util.getNameFromArrayList( "noeEmdadName", noeEmdad ) );
            }
            if ( resultSet.getString( "shomarePelak" ) != null ) {
                emdadList.setShomarePelak( resultSet.getString( "shomarePelak" ) );
            } else {
                emdadList.setShomarePelak( "" );
            }

            return emdadList;

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    //	public ValueObject resultSetToList(ResultSet resultSet) {
    //		try {
    //
    //			EmdadList emdadList = new EmdadList();
    //
    //			emdadList.setId(resultSet.getString("id"));
    //			emdadList.setEmdadId(new Integer(resultSet.getString("emdadId")));
    //			emdadList.setDastoorKarGhabli(new Integer(resultSet.getInt("dastoorKarGhabli")));
    //			emdadList.setVazeatDakheli(new Integer(resultSet.getInt("vazeatDakheli")));
    //
    //			try {
    //				RokhdadLocal rokhdadLocal = RokhdadUtil.getLocalHome().findByPrimaryKey(resultSet.getString("rokhdadId"));
    //				if (rokhdadLocal != null) {
    //					RokhdadModel rokhdadModel = rokhdadLocal.getRokhdadModel();
    //					emdadList.setRokhdadId(rokhdadModel.getId());
    //					emdadList.setRokhdadRokhdadId(rokhdadModel.getRokhdadId());
    //				}
    //				emdadList.setEshterakId(rokhdadLocal.getMoshtarak().getMoshtarakModel().getEshterakId());
    //
    //				if (rokhdadLocal.getDaftarOstani() != null) {
    //					DaftarOstaniLocal daftarOstaniLocal = rokhdadLocal.getDaftarOstani();
    //					if (daftarOstaniLocal != null) {
    //						DaftarOstaniModel daftarOstaniModel = daftarOstaniLocal.getDaftarOstaniModel();
    //						emdadList.setDaftarOstaniId(daftarOstaniModel.getId());
    //						emdadList.setDaftarOstaniName(daftarOstaniModel.getName());
    //					}
    //				}
    //
    //			} catch (Exception e) {
    //				e.printStackTrace();
    //			}
    //
    //			try {
    //				VazeatKhedmatLocal vazeatLocal = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey(resultSet.getString("vazeatKhedmatId"));
    //				if (vazeatLocal != null) {
    //					VazeatKhedmatModel model = vazeatLocal.getVazeatKhedmatModel();
    //					emdadList.setVazeatKhedmatId(model.getId());
    //					emdadList.setVazeatKhedmatOnvan(model.getOnvan());
    //				}
    //			} catch (Exception e) {
    //				e.printStackTrace();
    //			}
    //
    //			if (resultSet.getString("emdadgarId") != null) {
    //				EmdadgarLocal emdadgarLocal = EmdadgarUtil.getLocalHome().findByPrimaryKey(resultSet.getString("emdadgarId"));
    //				if (emdadgarLocal != null) {
    //					EmdadgarModel model = emdadgarLocal.getEmdadgarModel();
    //					emdadList.setEmdadgarId(model.getId());
    //					emdadList.setEmdadgar(model.getName());
    //				}
    //			}
    //
    //			if (resultSet.getString("ezamgarId") != null) {
    //				ShakhsLocal shakhsLocal = ShakhsUtil.getLocalHome().findByPrimaryKey(resultSet.getString("ezamgarId"));
    //				if (shakhsLocal != null) {
    //					ShakhsModel model = shakhsLocal.getShakhsModel();
    //					emdadList.setEzamgarId(model.getId());
    //					emdadList.setEzamgar(model.getName());
    //				}
    //			}
    //
    //			if (resultSet.getDate("zamanEzam") != null)
    //				emdadList.setZamanEzamHejri(HejriUtil.getTimeFromDate(new java.sql.Timestamp(resultSet.getTimestamp("zamanEzam").getTime())) + " - " + HejriUtil.chrisToHejri(resultSet.getDate("zamanEzam")));
    //			else
    //				emdadList.setZamanEzamHejri("");
    //
    //			emdadList.setVazeatKonuni(new Integer(resultSet.getInt("vazeatKonuni")));
    //
    //			int noeEmdad = resultSet.getInt("noeEmdad");
    //			if (noeEmdad <= 3)
    //				emdadList.setNoeEmdadName(((ComboObject)Util.getFromArrayList("noeEmdad", noeEmdad)).getName());
    //			return emdadList;
    //
    //		} catch (Exception e) {
    //			e.printStackTrace();
    //		}
    //		return null;
    //	}

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public QueryResult readList( QueryObject queryObject ) throws ProxyException {
        //if (queryObject.getTables() == null || queryObject.getTables().length() == 0)
//		queryObject.setTables(
//			"emdad LEFT OUTER JOIN namayandegi ON emdad.namayandegiId = namayandegi.Id LEFT OUTER JOIN emdadgar ON  emdad.emdadgarId = emdadgar.Id LEFT OUTER JOIN shakhs ON emdad.ezamgarId = shakhs.id LEFT OUTER JOIN rokhdad ON emdad.rokhdadId = Rokhdad.id LEFT OUTER JOIN vazeatKhedmat ON emdad.vazeatKhedmatId = vazeatKhedmat.id");
        setAsView( queryObject, "emdad", "emdadList" );
//		queryObject.setTables("emdadList");
//		queryObject.setJoined(false);
//		queryObject.setOrderTable("");
//		queryObject.setView(true);

        if ( queryObject.getWhere() != null && queryObject.getWhere().length() != 0 ) {
            queryObject.setWhere( queryObject.getWhere()
                    .replaceAll( "emdad\\p{Punct}", "emdadList." )
                    .replaceAll( "rokhdad\\p{Punct}", "emdadList." )
                    .replaceAll( "vazeatKhedmat\\p{Punct}", "emdadList." )
                    .replaceAll( "shakhs\\p{Punct}", "emdadList." )
                    .replaceAll( "emdadgar\\p{Punct}", "emdadList." ) );
        }


        return super.readList( queryObject );
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction type = "Supports"
     */
    public ResultSet report( QueryObject queryObject, Connection connection ) throws ProxyException {
//		try {
//			EmdadLocalHome emdadLocalHome = EmdadUtil.getLocalHome();
//			queryObject.setTables(
//				"emdad LEFT OUTER JOIN namayandegi ON emdad.namayandegiId = namayandegi.Id LEFT OUTER JOIN emdadgar ON  emdad.emdadgarId = emdadgar.Id LEFT OUTER JOIN shakhs ON emdad.ezamgarId = shakhs.id LEFT OUTER JOIN rokhdad ON emdad.rokhdadId = Rokhdad.id LEFT OUTER JOIN vazeatKhedmat ON emdad.vazeatKhedmatId = vazeatKhedmat.id");
//			Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
//			ResultSet rs = emdadLocalHome.advanceRead(c, queryObject);
//			return rs;
//		} catch (Exception exception) {
//			exception.printStackTrace(System.out);
//			throw new ProxyException(exception);
//		}
        setAsView( queryObject, "emdad", "emdadList" );

//		queryObject.setTables("EmdadReport");
//		queryObject.setJoined(false);
//		queryObject.setOrderTable("");
//		queryObject.setView(true);

//		if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0)
//			queryObject.setWhere(queryObject.getWhere().replaceAll("emdad\\p{Punct}", "emdadList."));

        return super.report( queryObject, connection );


    }

    public ValueObject resultSetToBean( ResultSet resultSet ) {
        try {
            EmdadModel emdadModel = new EmdadModel();
            emdadModel.setId( resultSet.getString( "id" ) );
            emdadModel.setEmdadId( new Integer( resultSet.getString( "emdadId" ) ) );
            return emdadModel;
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
     * @ejb.transaction type = "Required"
     */
    public void update( ValueObject valueObject ) throws ProxyException {
        super.update( valueObject );
    }

}
