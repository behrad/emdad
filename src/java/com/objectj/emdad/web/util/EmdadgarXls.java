package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Jan 5, 2004
 * Time: 5:08:56 PM
 * To change this template use Options | File Templates.
 */
public class EmdadgarXls extends EmdadXls {

    protected final static String EMDADGAR_NOT_EXISTS = "import.xls.tasvieh.emdadgar.notfound";

    protected final static String WRONG_EMDADGAR = "import.xls.tasvieh.invalid.emdadgar";

    public EmdadgarXls( String path ) {
        super( path );
    }

    public XlsColumn getEmdadgar( int row ) {
        return sheet[ row ][1];
    }

    public void validateCell( int row, int col ) {
        switch ( col ) {
            case 1 :
                validateEmdadgar( row );
                break;
            case 2 :
                validateEmdad( row );
                break;
            default :
                super.validateCell( row, col );
        }
    }

    private void validateEmdadgar( int row ) {
       item = getEmdadgar(row);
       if( isValidNumber( item ) ) {
           if( row == 0 ) {
               if( !idExists( item, "emdadgar", "emdadgarId" ) ) {
                   item.setError( ErrorMessage + EMDADGAR_NOT_EXISTS );
                   importablity = false;
                   return;
               }
           } else if( !item.getString().equals( getEmdadgar( 0 ).getString() ) ) {
               item.setError( WRONG_EMDADGAR );
               importablity = false;
           }
       }
    }

    protected void validateEmdad( int row ) {
       super.validateEmdad( row );
       item = getEmdad( row );
       if( isValidNumber( item ) && importablity ) {
           if( !idExists( item, "emdad", "emdadId" ) ) {
               item.setError( EMDAD_NOT_EXISTS );
               importablity = false;
               return;
           }
           String emdadgarId = UserAccessEntity.stringQuery( "select emdadgarId from emdad where emdadId='" + item.getString()  + "'", "emdadgarId" );
           String emdadgar = UserAccessEntity.stringQuery( "select emdadgarId from emdadgar where id='" + emdadgarId + "'" , "emdadgarId" );
           if( !getEmdadgar( row ).getString().equals( emdadgar ) ){
               item.setError( WRONG_EMDAD );
               importablity = false;
           }
       }
    }
}
