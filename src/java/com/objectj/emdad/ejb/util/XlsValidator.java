package com.objectj.emdad.ejb.util;

import com.objectj.emdad.ejb.UserAccessEntity;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Nov 30, 2003
 * Time: 9:23:55 PM
 * To change this template use Options | File Templates.
 */
public class XlsValidator {

    private final static String ErrorMessage = "<img src=\"/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif\" height=\"16\" width=\"16\" />";

    private String fileName = "";

    private XlsColumn[][] sheet;

    private int rows = 0;

    private int cols = 0;

    private XlsColumn item = null;

    private String[] header;

    public XlsValidator( String path ) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "";
        this.fileName = path;
        try {
            Class.forName("org.aarboard.jdbc.xls.XlsDriver").newInstance();
            String dir = path.substring( 0, path.lastIndexOf( File.separator ) );
		    String fileName = path.substring( path.lastIndexOf( File.separator ) + 1, path.lastIndexOf( "." ) );
			con = DriverManager.getConnection("jdbc:aarboard:xls:" + dir );
            stmt = con.createStatement();
            query = "SELECT * FROM " + fileName;
            rs = stmt.executeQuery( query );
            cols = rs.getMetaData().getColumnCount();
            header = new String[ cols ];
            for( int i = 0; i < cols; i++ )
                header[i] = rs.getMetaData().getColumnName( i + 1 );
            rows = 0;
            while ( rs.next() ) {
                if ( rs.getString( 1 ).length() == 0 )
                	break;
                rows++;
			}
            sheet = new XlsColumn[rows][cols];
            rs = stmt.executeQuery( query );
            int cur_row = 0;
            while( rs.next() && cur_row < rows ) {
                for( int cur_col = 0; cur_col < cols; cur_col++ ) {
                    sheet[ cur_row ][ cur_col ] = new XlsColumn( rs.getString( cur_col ) );
                }
                cur_row++;
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
				if ( rs != null )
                	rs.close();
				if ( stmt != null )
                	stmt.close();
				if ( con != null )
                	con.close();
            } catch ( Exception e ) {
                e.printStackTrace();
                return;
            }
        }
    }

    public int rowSize() {
        return sheet.length;
    }

    public int colSize() {
        return header.length;
    }

    public String printCell( int row, int col ) {
        item = sheet[row][col];
        if ( item.getError() == null )
            return item.getString();
        return item.getError() + " " + item.getString();
    }

    public String getHeader( int i ) {
        return header[ i ];
    }

    private XlsColumn getEmdad( int row ) {
        return sheet[row ][2];
    }

    private XlsColumn getIrad( int row ) {
        return sheet[row ][4];
    }

    private XlsColumn getOjrat( int row ) {
        return sheet[row ][5];
    }

    private XlsColumn getQate( int row ) {
        return sheet[row ][6];
    }

    private XlsColumn getTedadQate( int row ) {
        return sheet[row ][7];
    }

    private XlsColumn getFactor( int row ) {
        return sheet[row ][3];
    }

    public void validateCell( int row, int col ) {
        switch ( col ) {
            case 1 :
                validateNamayandegi( row );
                break;
            case 2 :
                validateEmdad( row );
                break;
            case 3 :
                validateFactor( row );
                break;
            case 4 :
                validateIrad( row );
                break;
            case 5 :
                validateOjrat( row );
                break;
            case 6 :
                validateQate( row );
                break;
        }
    }

    private void validateNamayandegi( int row ) {
       item = sheet[row][1];
       if( row == 0 ) {
		   if( !idExists( "namayandegi", "namayandegiId", item.getString() ) )
			   item.setError( ErrorMessage );
	   } else if( !item.getString().equals( sheet[0][1].getString() ) )
		   item.setError( ErrorMessage );

    }

    private void validateEmdad( int row ) {
       item = getEmdad( row );
       if( !idExists( "emdad", "emdadId", item.getString() ) )
           item.setError( ErrorMessage );
       for( int i = 0; i < row; i++ ) {
		   if( !( sheet[ i ][2].getString().equals( item.getString() ) &&
		   	   sheet[ i ][3].getString().equals( sheet[ row ][3].getString() ) ) ) {

			   sheet[ i ][2].setError( ErrorMessage );
			   item.setError( ErrorMessage );
			   sheet[ i ][3].setError( ErrorMessage );
			   sheet[ row ][3].setError( ErrorMessage );
		   }
	   }

    }

    private void validateFactor( int row ) {
       item = sheet[row][3];
    }

    private void validateIrad( int row ) {
       item = sheet[row][4];
       if( item.getString().length() != 0 ) {
		   if( !idExists( "irad", "iradId", item.getString() ) )
				item.setError( ErrorMessage );
		   if( sheet[row][5].getString().length() == 0 ) {
		   		item.setError( ErrorMessage );
		   		sheet[row][5].setError( ErrorMessage );
		   }
	   } else {
		   if( sheet[row][5].getString().length() != 0 ) {
		   		item.setError( ErrorMessage );
		   		sheet[row][5].setError( ErrorMessage );
		   }
	   }
    }

    private void validateOjrat( int row ) {
       item = sheet[row][5];
       if( item.getString().length() != 0 ) {
		   if( !idExists( "ojrat", "ojratId", item.getString() ) )
				item.setError( ErrorMessage );
	   }
    }

    private void validateQate( int row ) {
        item = sheet[row][6];
		if( item.getString().length() != 0 ) {
			if( !idExists( "qate", "shomareFanni", item.getString() ) )
				item.setError( ErrorMessage );
			if( sheet[row][7].getString().length() == 0 )
				item.setError( ErrorMessage );
			try {
				if( Integer.parseInt( sheet[row][7].getString() ) == 0 )
					sheet[row][7].setError( ErrorMessage );
			} catch( Exception e ) {
				sheet[row][7].setError( ErrorMessage );
			}
		}
    }

    private boolean idExists( String table, String col, String id ) {
        String ID = UserAccessEntity.stringQuery("SELECT id FROM "+ table +" WHERE " + col + "= '"+ id +"'", "id" );
        if ( ID.length() == 0 )
            return false;
        return true;
    }
}
