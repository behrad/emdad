package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.HejriUtil;

import java.sql.*;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Dec 6, 2003
 * Time: 5:19:07 PM
 * To change this template use Options | File Templates.
 */
public class ServiceDoreiXls extends XlsValidator {

    private static final String INVALID_HAZINEH = "import.xls.service.hazineh.invalid";

    private static final String INVALID_KARKARD = "import.xls.service.karkard.invalid";

    private static final String INVALID_MOSHTARAK = "import.xls.service.moshtarak.invalid";

    private static final String NAMAYANDEGI_NOT_EXISTS = "import.xls.tasvieh.namayandegi.notfound";

    private static final String MOSHTARAK_NOT_EXISTS = "errors.eshterakId.doesnt.exists";

    private static final String NO_ESHTERAK = "import.xls.service.eshterak.expired";

    private static final String SHASI_NOT_MATCHES = "import.xls.service.shasi.invalid";

    private static final String INVALID_TARIKH = "import.xls.service.tarikh.invalid";

    private static final String INVALID_NOESERVICE = "import.xls.service.noe.invalid";

    private static final Date TARIKHE_MOTOR_JADID = HejriUtil.hejriToChris( "1382/3/17" );


    public ServiceDoreiXls( String path ) {
        super( path );
    }

    public XlsColumn getNamayandegi( int row ) {
        return sheet[ row ][1];
    }

    public XlsColumn getTarikh( int row ) {
        return sheet[ row ][2];
    }

    public XlsColumn getMoshtarak( int row ) {
	    return sheet[ row ][3];
    }

    public XlsColumn getShasi( int row ) {
        return sheet[ row ][4];
    }

    public XlsColumn getKarkard( int row ) {
	    return sheet[ row ][5];
    }

    public XlsColumn getNoeService( int row ) {
        return sheet[ row ][6];
    }

    public XlsColumn getHazineh( int row ) {
        return sheet[ row ][7];
    }

    protected boolean isValidRow( ResultSet rs ) {
        try {
            return ( rs.getString( 1 ).length() != 0 && rs.getString( 2 ).length() != 0 && rs.getString( 3 ).length() != 0 && rs.getString( 4 ).length() != 0 );
        } catch( Exception e ) {
            e.printStackTrace();
            importablity = false;
        }
        return false;
    }

    public void validateCell( int row, int col ) {
        switch ( col ) {
            case 1 :
                validateNamayandegi( row );
                break;
            case 2 :
                validateTarikh( row );
                break;
            case 3 :
                validateMoshtarak( row );
                break;
            case 4 :
                validateShasi( row );
                break;
            case 5 :
                validateKarkard( row );
                break;
            case 6 :
                validateNoeService( row );
                break;
            case 7 :
                validateHazineh( row );
                break;
        }
    }

    private void validateNamayandegi( int row ){
        item = getNamayandegi( row );
        if( isValidNumber( item ) ) {
            if( !idExists( item, "namayandegi", "namayandegiId" ) ){
                item.setError( NAMAYANDEGI_NOT_EXISTS );
                importablity = false;
            }
        }
    }

    private void validateMoshtarak( int row ){
        item = getMoshtarak( row );
        if( isValidNumber( item ) ) {
            if( !idExists( item, "moshtarak", "eshterakId" ) ) {
                item.setError( MOSHTARAK_NOT_EXISTS );
                importablity = false;
                return;
            }
            String yana = UserAccessEntity.stringQuery( "select moshtarakYaNa from moshtarak where eshterakId='" + item.getString() + "'", "moshtarakYaNa" );
            String vijeh = UserAccessEntity.stringQuery( "select noeService from moshtarak where eshterakId='" + item.getString() + "'", "noeService" );
            if( !(Integer.parseInt(yana) == 1 && Integer.parseInt(vijeh) == 1) ) {
                item.setError( NO_ESHTERAK );
                importablity = false;
                return;
            }
        }
    }

    private void validateKarkard( int row ){
        item = getKarkard( row );
        if( isValidNumber( item ) ) {
            try {
            int karkard = Integer.parseInt( item.getString() );
            String noeService = checkNoeService( getNoeService( row ).getString() );
            String az = UserAccessEntity.stringQuery( "select azKilometer from noeServiceDorei where noeServiceDorei='" + noeService + "'", "azKilometer" );
            String ta = UserAccessEntity.stringQuery( "select taKilometer from noeServiceDorei where noeServiceDorei='" + noeService + "'", "taKilometer" );
            if ( !( Integer.parseInt( az ) <= karkard && karkard <= Integer.parseInt( ta ) ) ) {
                item.setError( INVALID_KARKARD );
            }
            } catch( Exception e ){
                e.printStackTrace();
                item.setError( "" );
            }
        }
    }

    private void validateNoeService( int row ){
        item = getNoeService( row );
        if( isValidNumber( item ) ) {
            String noeService = checkNoeService( item.getString() );
            String noeServiceId = UserAccessEntity.stringQuery( "select id from noeServiceDorei where noeServiceDorei='" + noeService + "'", "id" );
            if( noeServiceId.length() == 0 ) {
                item.setError( INVALID_NOESERVICE );
                importablity = false;
                return;
            }
            System.out.println( getMoshtarak(row).getId() );
            String serviceId = UserAccessEntity.stringQuery( "select id from serviceDorei where moshtarakId='" + getMoshtarak( row ).getId() + "' AND noeServiceDorei='" + noeService + "'", "id" );
            if( serviceId.length() != 0 ) {
                item.setError( INVALID_MOSHTARAK );
                importablity = false;
                return;
            }
        }
    }

    private void validateHazineh( int row ){
        item = getHazineh( row );
        if( isValidNumber( item ) ) {
            String hazineh = "hazineh";
            Date t = UserAccessEntity.dateQuery( "select tarikhTahvil from moshtarak where eshterakId='" + getMoshtarak(row).getString() + "'", "tarikhTahvil" );
            Date tahvil = t;
            if( tahvil != null ) {
                if ( tahvil.after( TARIKHE_MOTOR_JADID )) {
                    hazineh = "hazineh2";
                }
            }
            String noeService = checkNoeService( getNoeService( row ).getString() );
            String hazinehDef = UserAccessEntity.stringQuery( "select " + hazineh + " from noeServiceDorei where noeServiceDorei='" + noeService + "'", "hazineh" );
            if ( !hazinehDef.equals( item.getString() ) )
                item.setError( INVALID_HAZINEH );
        }
    }

    private void validateTarikh( int row ) {
        item = getTarikh( row );
        if( isValidDate( item ) ) {
            System.out.println( getMoshtarak(row).getId() );
            String eshterakId = UserAccessEntity.stringQuery( "select id from moshtarak where eshterakId='" + getMoshtarak( row ).getString() + "'", "id" );
            Date tarikh = UserAccessEntity.dateQuery( "SELECT MAX(tarikh) AS tarikh FROM ServiceDorei WHERE moshtarakId ='" + eshterakId + "'", "tarikh" );
            if ( !HejriUtil.isValidDate( item.getString() ) ) {
                item.setError( "" );
                return;
            }
            Date now = HejriUtil.hejriToChris( item.getString() );
            Date before = null;
            if ( tarikh != null ) {
                before = tarikh;
                if ( !now.after( before ) ) {
                    item.setError( INVALID_TARIKH );
                    importablity = false;
                    return;
                }
            }
            for( int i = 0; i < row; i++ ) {
                if ( getMoshtarak( i ).getString().equals( getMoshtarak(row).getString() ) ) {
                    if( getNoeService( i ).getString().compareTo( getNoeService(row).getString() ) > 1 ) {
                        now = HejriUtil.hejriToChris( getTarikh(i).getString() );
                        before = HejriUtil.hejriToChris( getTarikh(row).getString() );
                        if( !now.after( before ) ) {
                           item.setError( INVALID_TARIKH );
                           importablity = false;
                           return;
                        }
                    }
                }
            }
        }
    }

    private void validateShasi( int row ) {
        item = getShasi( row );
        if( isValidNumber( item ) ) {
            String eshterakId = UserAccessEntity.stringQuery( "select eshterakId from moshtarak where shomareShasi='" + item.getString() + "'", "eshterakId" );
            if ( !eshterakId.equals( getMoshtarak(row).getString() ) ) {
                item.setError( SHASI_NOT_MATCHES );
                importablity = false;
            }
        }
    }

    private String checkNoeService( String noeService ) {
        if ( noeService.indexOf( "000" ) > 0 ) {
		            noeService = noeService.substring( 0, noeService.lastIndexOf("000")  );
        }
        return noeService;
    }

}