package com.objectj.emdad.web.util;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Mar 6, 2004
 * Time: 3:47:16 PM
 * To change this template use Options | File Templates.
 */
public class ImageMap {
    private Set keys;
    private ArrayList keys_col;
    private ArrayList values;

    public ImageMap(){
        keys = new HashSet();
        keys_col = new ArrayList();
        values = new ArrayList();
    }

    public ArrayList get( Integer index ) {
        ArrayList list = new ArrayList();
        for(int i= 0; i < values.size(); i++ ) {
            if ( keys_col.get(i).equals(index) ) {
                list.add( values.get(i) );
            }
        }
        return list;
    }

    public void put( Img img ) {
        keys.add( new Integer( img.getLevel() ) );
        keys_col.add( new Integer( img.getLevel() ) );
        values.add( img );
    }

    public Set keySet() {
        return keys;
    }
}
