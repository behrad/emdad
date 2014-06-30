package com.objectj.jsa.tool;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Salar Mesdaghinia
 * Date: Apr 22, 2003
 * Time: 2:30:28 PM
 * To change this template use Options | File Templates.
 */
public class Attribute
{
    String  name = "",
            type = "",
            size = "",
            //placeHolder = "",
            label = "",
            refEntityName = "",
            displayAttrName = "",
            description = "";

    boolean required = false,
            numeric = false,
            listable = false,
            sortable = false,
            farsi = false,
            foreignKey = false;

    //----------------------------------

    Attribute (String name, String type, String size, String farsiLabel, String refEntityName, String displayAttrName, String description, boolean required, boolean numeric, boolean listable, boolean sortable, boolean farsi, boolean foreignKey)
    {
        this.name = name;
        this.type = type;
        this.size = size;
        //this.placeHolder = placeHolder;
        this.label = farsiLabel;
        this.refEntityName = refEntityName;
        this.displayAttrName = displayAttrName;
        this.description = description;

        this.required = required;
        this.numeric = numeric;
        this.listable = listable;
        this.sortable = sortable;
        this.farsi = farsi;
        this.foreignKey = foreignKey;
    }

    //----------------------------------

    public void setName (String name)
    {
        this.name = name;
    }

    //----------------------------------

    public String getName ()
    {
        return name;
    }

    //----------------------------------

    public void setType (String type)
    {
        this.type = type;
    }

    //----------------------------------

    public String getType ()
    {
        return type;
    }

    //----------------------------------

    public String getSimpleType ()
    {
        return type.substring(type.lastIndexOf('.') + 1);
    }

    //----------------------------------

    public void setSize (String size)
    {
        this.size = size;
    }

    //----------------------------------

    public String getSize ()
    {
        return size;
    }

    //----------------------------------

    public void setRefEntityName (String refEntityName)
    {
        this.refEntityName = refEntityName;
    }

    //----------------------------------

    public String getRefEntityName ()
    {
        return refEntityName;
    }

    //----------------------------------

    public void setDisplayAttrName (String displayAttrName)
    {
        this.displayAttrName = displayAttrName;
    }

    //----------------------------------

    public String getDisplayAttrName ()
    {
        return displayAttrName;
    }

    //----------------------------------

    public void setDescription(String description)
    {
        this.description = description;
    }

    //----------------------------------

    public String getDescription()
    {
        return description;
    }

    //----------------------------------
/*
    public void setPlaceHolder (String placeHolder)
    {
        this.placeHolder = placeHolder;
    }

    //----------------------------------

    public String getPlaceHolder ()
    {
        return placeHolder;
    }
*/
    //----------------------------------

    public void setLabel (String farsiLabel)
    {
        this.label = farsiLabel;
    }

    //----------------------------------

    public String getLabel ()
    {
        return label;
    }

    //----------------------------------

    public void setRequired (boolean required)
    {
        this.required = required;
    }

    //----------------------------------

    public boolean isRequired ()
    {
        return required;
    }

    //----------------------------------

    public void setNumeric (boolean numeric)
    {
        this.numeric = numeric;
    }

    //----------------------------------

    public boolean isNumeric ()
    {
        return numeric;
    }

    //----------------------------------

    public void setListable (boolean listable)
    {
        this.listable = listable;
    }

    //----------------------------------

    public boolean isListable ()
    {
        return listable;
    }

    //----------------------------------

    public void setSortable (boolean sortable)
    {
        this.sortable = sortable;
    }

    //----------------------------------

    public boolean isSortable ()
    {
        return sortable;
    }

    //----------------------------------

    public void setFarsi (boolean farsi)
    {
        this.farsi = farsi;
    }

    //----------------------------------

    public boolean isFarsi ()
    {
        return farsi;
    }

    //----------------------------------

    public void setForeignKey (boolean foreignKey)
    {
        this.foreignKey = foreignKey;
    }

    //----------------------------------

    public boolean isForeignKey ()
    {
        return foreignKey;
    }

    //----------------------------------

    public void display (PrintWriter out) throws IOException
    {
        out.println("-------------------------------------------------------");

        out.println("Attribute name: " + name);
        out.println("Attribute type: " + type);
        out.println("Attribute size: " + size);
        //out.write("Place holder: " + placeHolder);
        out.println("Label: " + label);
        out.println("Description: " + description);
        if (required)
            out.println("Required");
        if (numeric)
            out.println("Must be numeric");
        if (listable)
            out.println("Listable");
        if (sortable)
            out.println("Sortable");
        if (farsi)
            out.println("Farsi");
        if (foreignKey)
        {
            out.println("Foreign Key:   reference entity = " + refEntityName + "    display attribute name = " + displayAttrName);
        }
    }
}
