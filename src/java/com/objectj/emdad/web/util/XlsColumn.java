package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.UserAccessEntity;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Nov 30, 2003
 * Time: 9:28:25 PM
 * To change this template use Options | File Templates.
 */
public class XlsColumn {

    private String id = "";

    private String string = null;

    private String error = null;

    private boolean hasError = false;

    public XlsColumn( String string ) {
        this.string = string;
    }

    public String getId(){
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public String getError() {
        return error;
    }

    public void setError( String error ){
        this.error = error;
        hasError = true;
    }

    public boolean hasError() {
        return hasError;
    }
}
