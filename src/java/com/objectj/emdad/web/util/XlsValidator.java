package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.HejriUtil;

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

    protected final static String ErrorMessage = "<img src=\"/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif\" height=\"16\" width=\"16\" />";

    protected final static String INVALID_NUMBER = "import.xls.tasvieh.invalid.number";

    protected final static String INVALID_DATE = "import.xls.tasvieh.invalid.date";

    private String fileName = "";

    protected boolean importablity = true;

    protected XlsColumn[][] sheet;

    private int rows = 0;

    private int cols = 0;

    protected XlsColumn item = null;

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
                if ( !isValidRow( rs ) )
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
        String error = item.getError();
        try{
            if ( error.length() > 0 )
                error = Util.getProperty( error );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return  item.getString() + "<br><font color='FF0000'>" + ErrorMessage + error + "</font>";
    }

    public String getHeader( int i ) {
        return header[ i ];
    }

    public void validateCell( int row, int col ) {
        return;
    }

    public boolean isImportable() {
        return importablity;
    }

    protected boolean isValidRow( ResultSet rs ) {
        return true;
    }

    protected boolean idExists( XlsColumn column, String table, String col ) {
        String ID = UserAccessEntity.stringQuery("SELECT id FROM "+ table +" WHERE " + col + "= '"+ column.getString() +"'", "id" );
        if ( ID.length() == 0 )
            return false;
        column.setId( ID );
        return true;
    }

    protected boolean isValidNumber( XlsColumn column ) {
       try {
           new Integer( column.getString() );
       } catch ( Exception e ) {
           column.setError( INVALID_NUMBER );
           return false;
       }
        return true;
    }

    protected boolean isValidDate( XlsColumn column ) {
        if ( !HejriUtil.isValidDate( column.getString() ) ){
            column.setError( INVALID_DATE );
            return false;
        }
        return true;
    }
}