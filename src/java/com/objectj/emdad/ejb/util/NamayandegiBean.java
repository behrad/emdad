/**
 * Created by IntelliJ IDEA.
 * User  : Mahmood Mortazavi
 * Email : mahmoud@objectj.com
 * Date  : Dec 19, 2003
 * Time  : 5:08:22 AM
 */
package com.objectj.emdad.ejb.util;

public class NamayandegiBean implements com.objectj.jsa.model.ValueObject{
    private String id;

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
