package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.Util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Dec 6, 2003
 * Time: 5:19:07 PM
 * To change this template use Options | File Templates.
 */
public class EmdadXls extends XlsValidator {

    protected static final String OJRAT_NOT_EXISTS = "import.xls.tasvieh.ojrat.notfound";

    protected static final String IRAD_NOT_EXISTS = "import.xls.tasvieh.irad.notfound";

    protected static final String QATE_NOT_EXISTS = "import.xls.tasvieh.qate.notfound";

    protected static final String EMPTY_OJRAT = "import.xls.tasvieh.ojrat.empty";

    protected static final String EMPTY_IRAD = "import.xls.tasvieh.irad.empty";

    protected static final String EMPTY_QATE = "import.xls.tasvieh.qate.empty";

    protected static final String OJRAT_OR_QATE = "import.xls.tasvieh.ojrat.qate.empty";

    protected static final String EMPTY_TEDADQATE = "import.xls.tasvieh.tedadqate.wrong";

    protected static final String WRONG_NAMAYANDEGI = "import.xls.tasvieh.namayandegi.wrong";

    protected static final String NAMAYANDEGI_NOT_EXISTS = "import.xls.tasvieh.namayandegi.notfound";

    protected static final String EMDAD_NOT_EXISTS = "import.xls.tasvieh.emdad.notfound";

    protected static final String WRONG_EMDAD = "import.xls.tasvieh.emdad.wrong";

    protected static final String WRONG_FACTOR = "import.xls.tasvieh.qate.wrong";

    protected static final String EMDAD_ALREADY_TAEEDED = "import.xls.tasvieh.emdad.taeeded";

    protected static final String EMDAD_KHATEMEH_NAYAFTEH = "import.xls.tasvieh.emdad.napayan";

    public EmdadXls( String path ) {
        super( path );
    }

//    public XlsColumn getNamayandegi( int row ) {
//        return sheet[ row ][1];
//    }

    public XlsColumn getEmdad( int row ) {
        return sheet[ row ][2];
    }

    public XlsColumn getIrad( int row ) {
        return sheet[ row ][5];
    }

    public XlsColumn getOjrat( int row ) {
        return sheet[ row ][6];
    }

    public XlsColumn getQate( int row ) {
        return sheet[ row ][7];
    }

    public XlsColumn getTedadQate( int row ) {
        return sheet[ row ][8];
    }

    public XlsColumn getGuarantee( int row ) {
        return sheet[ row][9];
    }

    public XlsColumn getBazar( int row ) {
        return sheet[ row][10];
    }

    public XlsColumn getNaghdi( int row ) {
        return sheet[ row][11];
    }

    public XlsColumn getHazineh( int row ) {
        return sheet[ row][12];
    }

    public XlsColumn getFactor( int row ) {
        return sheet[ row ][3];
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
            case 3 :
                validateFactor( row );
                break;
            case 5 :
                validateIrad( row );
                break;
            case 6 :
                validateOjrat( row );
                break;
            case 7 :
                validateQate( row );
                break;
        }
    }

    protected void validateEmdad( int row ) {
        item = getEmdad( row );
        if ( isValidNumber( item ) ) {
           String taeed = UserAccessEntity.stringQuery( "select taeedHesabdar from emdad where emdadId='" + item.getString() + "'", "taeedHesabdar" );
           int taeeded = ( Util.isEmpty( taeed ) ? 2 : Integer.parseInt( taeed ) );
           if( taeeded == 1 ) {
               item.setError( EMDAD_ALREADY_TAEEDED );
               importablity = false;
               return;
           }
           String vaze = UserAccessEntity.stringQuery( "select vazeatKonuni from emdad where emdadId='" + item.getString() + "'", "vazeatKonuni" );
           int payan = ( Util.isEmpty( vaze ) ? 0 : Integer.parseInt( vaze ) );
           if( payan != 2 ) {
               item.setError( EMDAD_KHATEMEH_NAYAFTEH );
               importablity = false;
               return;
           }
        }
    }

    private void validateFactor( int row ) {
       item = getFactor( row );
       if( isValidNumber( item ) ) {
           for( int i = 0; i < row; i++ ) {
               if( ( getEmdad(i).getString().equals( getEmdad(row).getString() ) &&
                      !getFactor(i).getString().equals( item.getString() ) ) ) {
                   item.setError( WRONG_FACTOR );
                   getFactor(i).setError( WRONG_FACTOR );
               }
           }
       }
    }

    private void validateIrad( int row ) {
       item = getIrad( row );
           if( item.getString().length() != 0 ) {
               if( !idExists( item, "irad", "iradId" ) )
                    item.setError( IRAD_NOT_EXISTS );
               if( getOjrat(row).getString().length() == 0 ) {
                    getOjrat(row).setError( EMPTY_OJRAT );
               }
           } else {
               if( getOjrat(row).getString().length() != 0 ) {
                    item.setError( EMPTY_IRAD );
               }
           }
    }

    private void validateOjrat( int row ) {
       item = getOjrat(row);
           if( item.getString().length() != 0 ) {
               if( !idExists( item, "ojrat", "ojratId" ) )
                    item.setError( OJRAT_NOT_EXISTS );
           }
    }

    private void validateQate( int row ) {
        item = getQate(row);
            if( item.getString().length() != 0 ) {
                if( !idExists( item, "qate", "shomareFanni" ) ) {
                    item.setError( QATE_NOT_EXISTS );
                    return;
                }
                if( getTedadQate(row).getString().length() > 0 ) {
                    try {
                        if( Integer.parseInt( getTedadQate(row).getString() ) == 0 )
                            getTedadQate(row).setError( EMPTY_TEDADQATE );
                    } catch( Exception e ) {
                        getTedadQate(row).setError( EMPTY_TEDADQATE );
                    }
                }
            }
    }

}