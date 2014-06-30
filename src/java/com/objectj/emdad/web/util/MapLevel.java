package com.objectj.emdad.web.util;

import java.util.Collection;
import java.util.ArrayList;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad Zari
 * Date: Mar 6, 2004
 * Time: 1:45:12 PM
 * To change this template use Options | File Templates.
 */
public class MapLevel {

    private int level = 1;
    private String name = "";
    private ArrayList imgs = new ArrayList();
    private ArrayList subLevels = new ArrayList();
    private boolean hasChild = false;

    public MapLevel() {
    }

    public MapLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasImage() {
        return imgs.size() > 0;
    }

    public void setImgs(ArrayList imgs) {
        for( int i = 0; i < imgs.size(); i++ ) {
            addImage( (Img)imgs.get( i ) );
        }
    }

    public ArrayList getImgs() {
        return imgs;
    }

    public void addImage( Img image ) {
        imgs.add( image );
        String dir = name + File.separator + image.getName().substring( 0, image.getName().indexOf(".") );
        System.out.println( "New virtual Level: " + dir + ", " + level );
        subLevels.add( new MapLevel( level+1, dir ) );
    }

    public ArrayList getSubLevels() {
        return subLevels;
    }

    public boolean hasChild() {
        return hasChild;
    }

    public boolean createSubLevel( Img image ) {
        int index = findRelatedImage( image );
        if ( index < 0 )
            return false;
        ((MapLevel)subLevels.get( index )).addImage( image );
        hasChild = true;
        return true;
    }

    private int findRelatedImage( Img image ) {
        for( int i = 0; i < imgs.size(); i++ )
            if( ((Img)imgs.get(i)).isRelatedWith(image) )
                return i;
        return -1;
    }

    public Img[][] toTableImgs() {
        int minTool=0, maxTool=0, minArz=0, maxArz=0, cellArz=0, cellTool=0, rowCount=0;
        Img naghsheModel = null;
        ArrayList naghsheArray = imgs;
        Img[][] imgList = null;
        if (!naghsheArray.isEmpty()) {
            naghsheModel = (Img) naghsheArray.get(0);
            minTool = naghsheModel.getAzX();
            maxTool = naghsheModel.getTaX();
            minArz = naghsheModel.getAzY();
            maxArz = naghsheModel.getTaY();
            cellTool = maxTool - minTool;
            cellArz = maxArz - minArz;
            for (int i = 1; i < naghsheArray.size(); i++) {
                naghsheModel = (Img) naghsheArray.get(i);
                if( minTool > naghsheModel.getAzX() )
                    minTool = naghsheModel.getAzX();
                if( maxTool < naghsheModel.getTaX() )
                    maxTool = naghsheModel.getTaX();
                if( minArz > naghsheModel.getAzY() )
                    minArz = naghsheModel.getAzY();
                if( maxArz < naghsheModel.getTaX() )
                    maxArz = naghsheModel.getTaX();
            }
            imgList = new Img[(maxArz-minArz)/cellArz][(maxTool-minTool)/cellTool];
            rowCount=(maxArz-minArz)/cellArz;
            for (int i = 0; i < naghsheArray.size(); i++) {
                naghsheModel = (Img) naghsheArray.get(i);
                imgList[rowCount-((naghsheModel.getAzY()-minArz)/cellArz)-1][(naghsheModel.getAzX()-minTool)/cellTool] = naghsheModel;
            }
        }
        return imgList;
    }

    public String getLinkFor( String imgName ) {
        String def = "index.html";
        for( int i = 0; i < imgs.size(); i++ ) {
            Img img = (Img)imgs.get(i);
            if( imgName.equals( img.getName() ) ) {
                MapLevel level = (MapLevel)subLevels.get(i);
                return level.hasImage() ? imgName.substring( 0, imgName.indexOf( "." ) ) + "/" + def : def ;
            }
        }
        return def;
    }

}
