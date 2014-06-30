package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.Util;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Jan 5, 2004
 * Time: 5:08:56 PM
 * To change this template use Options | File Templates.
 */
public class NamayandegiXls extends EmdadXls {
    public NamayandegiXls( String path ) {
        super( path );
    }

    public XlsColumn getNamayandegi( int row ) {
        return sheet[ row ][1];
    }

    public void validateCell( int row, int col ) {
        switch ( col ) {
            case 1 :
                validateNamayandegi( row );
                break;
            case 2 :
                validateEmdad( row );
                break;
            default :
                super.validateCell( row, col );
        }
    }

    private void validateNamayandegi( int row ) {
       item = getNamayandegi(row);
       if( isValidNumber( item ) ) {
           if( row == 0 ) {
               if( !idExists( item, "namayandegi", "namayandegiId" ) ) {
                   item.setError( ErrorMessage + NAMAYANDEGI_NOT_EXISTS );
                   importablity = false;
                   return;
               }
           } else if( !item.getString().equals( getNamayandegi( 0 ).getString() ) ) {
               item.setError( WRONG_NAMAYANDEGI );
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
           String namayandegiId = UserAccessEntity.stringQuery( "select namayandegiId from emdad where emdadId='" + item.getString()  + "'", "namayandegiId" );
           String namayandegi = UserAccessEntity.stringQuery( "select namayandegiId from namayandegi where id='" + namayandegiId + "'" , "namayandegiId" );
           if( !getNamayandegi( row ).getString().equals( namayandegi ) ){
               item.setError( WRONG_EMDAD );
               importablity = false;
           }
       }
    }
}