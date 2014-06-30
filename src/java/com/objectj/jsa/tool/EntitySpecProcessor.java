package com.objectj.jsa.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Salar Mesdaghinia
 * Date: Apr 21, 2003
 * Time: 5:07:59 PM
 * To change this template use Options | File Templates.
 */

public class EntitySpecProcessor
{
    public static final int NOT_SPECIFIED = -1;
    public static final String ENTITY_SPEC_EXTENSION = ".entity.spec";

    private FileReader fileReader;
    private StreamTokenizer stTokenizer;
    String entityName;
    String EntityName;
    String farsiTitle;
    String description;
    int businessProcessCode;
    ArrayList attributeList = new ArrayList ();
    int detailsIndex = NOT_SPECIFIED;
    //int numOfAttributes = 0;
    int nextAttributeIndex = 0;
    int requiredWordsNum = 4;

    //-------------------------------------------------

    EntitySpecProcessor (String specFileName) throws FileNotFoundException, EntitySpecException
    {
        try
        {
            fileReader = new FileReader(specFileName);
            stTokenizer = new StreamTokenizer(new BufferedReader(fileReader));
            String extentionRemoved = specFileName.substring(0, specFileName.lastIndexOf(ENTITY_SPEC_EXTENSION));
            entityName = extentionRemoved.substring(extentionRemoved.lastIndexOf('/') + 1);
            entityName = entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
            EntityName = entityName.substring(0, 1).toUpperCase() + entityName.substring(1);

            System.out.println ("#### specFileName = " + specFileName);

            ////=-= //=-= //=-= System.out.println(entityName);

            stTokenizer.eolIsSignificant(true);
            stTokenizer.wordChars('_', '_');
            stTokenizer.wordChars('@', '@');
            stTokenizer.wordChars(':', ':');
            stTokenizer.quoteChar('"');
            //stTokenizer.ordinaryChar('*');
            //stTokenizer.ordinaryChar('#');

            ////=-= //=-= //=-= System.out.println("entityName = " + entityName);
            //if (entityName.equals("daftarOstani") || entityName.equals("khodrosaz") || entityName.equals("bazaryab") || entityName.equals("dalileToolKeshidaneEmdad") || entityName.equals("darkhastTagheer") || entityName.equals("darkhastEshterak") || entityName.equals("emdadgar") || entityName.equals("emdad"))
            //{
                ////=-= //=-= //=-= System.out.println("oomad too readHeader");
            readHeader();
                ////=-= //=-= //=-= System.out.println("farsiTitle = " + farsiTitle);
                ////=-= //=-= //=-= System.out.println("description = " + description);
                ////=-= //=-= //=-= System.out.println("businessProcessCode = " + businessProcessCode);
            //}

            Attribute attribute;
            while ((attribute = readNextAttribute ()) != null)
            {
                attributeList.add (attribute);
                //numOfAttributes++;
            }
        }

        catch (FileNotFoundException e)
        {
            System.err.println("Could not open " + specFileName);
            throw e;
        }
    }

    //-------------------------------------------------

    void cleanup()
    {
        try
        {
            fileReader.close();
        }

        catch (IOException e)
        {
            System.err.println("close() unsuccessful");
        }
    }

    //-------------------------------------------------

    private void readHeader()  throws EntitySpecException
    {
        String [] word = new String[3];
        int i = 0;

        try {
            int next = stTokenizer.nextToken();
            while ( (next != StreamTokenizer.TT_EOL) && (next != StreamTokenizer.TT_EOF))
            {
                if (i >= word.length) {
                    next = stTokenizer.nextToken();
                    continue;
                }
                //System.out.println (i+","+stTokenizer.sval);
                switch (stTokenizer.ttype)
                {
                    case StreamTokenizer.TT_NUMBER:
                        word[i] = Integer.toString((int) stTokenizer.nval);
                        i++;
                    break;

                    case StreamTokenizer.TT_WORD:
                    case '"':
                        String unicodeChars = "" + (char)0xEF +(char)0xBB + (char)0xBF;
                        if (stTokenizer.sval.substring(0,3).equals(unicodeChars))
                        {
                            word[i] = stTokenizer.sval.substring(3);
                            ////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   3 charactero mikosham  @@@@@@@@@@@@@@@@@@@@@@@@");
                            ////=-= //=-= //=-= System.out.println (word[i]);
                            ////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        }

                        else
                            word[i] = stTokenizer.sval;

                        if (!word[i].equals(""))
                            i++;
                        break;

                    default:
                        throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"0\"!");
                }

                /*if (i > 0) {
                    int j = i-1;
                    //=-= //=-= //=-= System.out.println ("word[" + j + "] : " + word[j]);
                } */
                next = stTokenizer.nextToken();
            }

            if (false && i > word.length)
            {
                throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\" has too many words!");
                ////=-= //=-= //=-= System.out.println ("Error in " + entityName + ENTITY_SPEC_EXTENSION  + ": line " + (attributeList.size() + 1) + " has too many words!");
                //return null;
            }

            farsiTitle = word[0];
            description = word[1];
            try {
            businessProcessCode = Integer.parseInt(word[2]);
            } catch (Exception e) {}
        }

        catch (IOException e)
        {
            System.err.println("st.nextToken() unsuccessful");
        }

    }

    //-------------------------------------------------

    private Attribute readNextAttribute () throws EntitySpecException
    {
        String [] word = new String [requiredWordsNum + 1];

        String refEntityName = "",
               displayAttrName = "",
               description = "";

        boolean required = false,
                numeric = false,
                listable = false,
                sortable = false,
                farsi = false,
                foreignKey = false;

        try
        {
            int next,
                i = 0;

            next = stTokenizer.nextToken();
            if (next == StreamTokenizer.TT_EOF)
                return null;

            while ((next != StreamTokenizer.TT_EOL) && (next != StreamTokenizer.TT_EOF))
            {
                switch (stTokenizer.ttype)
                {
                    case StreamTokenizer.TT_NUMBER:
                        word[i] = Integer.toString((int) stTokenizer.nval);
                        i++;
                    break;

                    //*******************************

                    case StreamTokenizer.TT_WORD:
                    case '"':
                        ////=-= //=-= //=-= System.out.println (stTokenizer.sval.substring(0,3));
                        String unicodeChars = "" + (char)0xEF +(char)0xBB + (char)0xBF;
                        if (stTokenizer.sval.substring(0,3).equals(unicodeChars))
                        {
                            word[i] = stTokenizer.sval.substring(3);
                            ////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   3 charactero mikosham  @@@@@@@@@@@@@@@@@@@@@@@@");
                            ////=-= //=-= //=-= System.out.println (word[i]);
                            ////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        }

                        else
                            word[i] = stTokenizer.sval;


                        if (word[i].charAt(0) == '@')
                        {
                            word[i] = word[i].substring(1);

                            //********************** Foreign Key **************************
                            if (word[i].substring(0,2).toUpperCase().equals ("FK"))
                            {
                                int refEntityNameIndex = word[i].indexOf(":", 0) + 1;
                                if (refEntityNameIndex == 0)
                                    throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\": 2 \":\" are needed in \"FK\" phrase!");

                                ////=-= //=-= //=-= System.out.println (refEntityNameIndex);
                                int displayNameIndex = word[i].indexOf(":", refEntityNameIndex) + 1;
                                if (displayNameIndex == 0)
                                    throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\": 2 \":\" are needed in \"FK\" phrase!");

                                ////=-= //=-= //=-= System.out.println (displayNameIndex);

                                foreignKey = true;
                                refEntityName = word[i].substring(refEntityNameIndex, displayNameIndex - 1);
                                displayAttrName = word[i].substring(displayNameIndex);

                                ////=-= //=-= //=-= System.out.println (refEntityName);
                                ////=-= //=-= //=-= System.out.println (displayAttrName);
                            }

                            //********************** Description ***************************
                            else if (word[i].substring(0,4).toUpperCase().equals ("DESC"))
                            {
                                int descIndex = word[i].indexOf(":", 0) + 1;
                                if (descIndex == 0)
                                    throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\": \":\" needed in \"desc\" phrase!");

                                ////=-= //=-= //=-= System.out.println (descIndex);
                                description = word[i].substring(descIndex);
                            }

                            //********************** List ***************************
                            else if (word[i].toLowerCase().equalsIgnoreCase("list"))
                                listable = true;

                            //********************** Sort ***************************
                            else if (word[i].toLowerCase().equalsIgnoreCase("sort"))
                                sortable = true;

                            //********************** Farsi ***************************
                            else if (word[i].toLowerCase().equalsIgnoreCase("farsi"))
                                farsi = true;

                            //********************** Details ***************************
                            else if (word[i].toLowerCase().equalsIgnoreCase("details"))
                            {
                                if (detailsIndex == NOT_SPECIFIED)
                                    detailsIndex = attributeList.size();  //stTokenizer.lineno();

                                else
                                    throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\": redundant \"details\" attribute!");
                            }
                        }

                        else
                            i++;

                    break;


                    //******************* Required *******************
                    case '*':
                        required = true;
                    break;

                    //******************* Numeric *******************
                    case '#':
                        numeric = true;
                    break;
/*
                    //*******************************

                    case '@':
                        listable = true;
                    break;

                    //*******************************

                    case '!':
                        sortable = true;
                    break;
*/
                }


                if (i >= word.length)
                {
                    throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\" has too many words!");
                    ////=-= //=-= //=-= System.out.println ("Error in " + entityName + ENTITY_SPEC_EXTENSION  + ": line " + (attributeList.size() + 1) + " has too many words!");
                    //return null;
                }
                ////=-= //=-= //=-= System.out.println (word[i]);
                next = stTokenizer.nextToken();
            }

            if (i < requiredWordsNum)
            {
                ////=-= //=-= //=-= System.out.println ("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line " + (attributeList.size() + 1) + " has too few words!");
                throw new EntitySpecException("Error in " + entityName + ENTITY_SPEC_EXTENSION + ": line \"" + (attributeList.size() + 1) + "\" has too few words!");
                //return null;
            }

        }

        catch (IOException e)
        {
            System.err.println("st.nextToken() unsuccessful");
        }

        Attribute attribute = new Attribute (word[0], word[1], word[2], word[3], refEntityName, displayAttrName, description, required, numeric, listable, sortable, farsi, foreignKey);
        //attribute.display();
        return attribute;
    }


    //-------------------------------------------------

    public void generateEntityBeanProperties (String path)
    {
        if ((new File (path + "/" + entityName + ".entitybean.properties")).exists())
        {
            ////=-= //=-= //=-= System.out.println (path + "/" + entityName + ".entitybean.properties already exists!");
            return;
        }

        else
        {
            ////=-= //=-= //=-= System.out.println ("Generating " + path + "/" + entityName + ".entitybean.properties");
        }

        try
        {
            FileWriter fileWriter = new FileWriter (path + "/" + entityName + ".entitybean.properties");
            PrintWriter out = new PrintWriter(fileWriter);

            Attribute attribute;
            for (int i = 0; i < attributeList.size(); i++)
            {
                attribute = (Attribute) attributeList.get(i);
                if (!attribute.isForeignKey())
                    out.println(attribute.getName() + " = " + attribute.getType());
            }

            out.close();
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: " + entityName + ".entitybean.properties");
        }
    }


    //-------------------------------------------------

    public void generateActionProperties (String path)
    {
        if ((new File (path + "/" + entityName + ".action.properties")).exists())
        {
            ////=-= //=-= //=-= System.out.println (path + "/" + entityName +  ".action.properties already exists!");
            return;
        }

        else
        {
            ////=-= //=-= //=-= System.out.println ("Generating " + path + "/" + entityName + ".action.properties");
        }

        try
        {
            FileWriter fileWriter = new FileWriter (path + "/" + entityName + ".action.properties");
            PrintWriter out = new PrintWriter(fileWriter);
            out.close();
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: " + entityName + ".action.properties");
        }
    }

    //-------------------------------------------------

    public void generateKeyProperties ()
    {
        try
        {
            FileWriter fileWriter = new FileWriter ("key.properties");
            PrintWriter out = new PrintWriter(fileWriter);

            Attribute attribute;
            for (int i = 0; i < attributeList.size(); i++)
            {
                attribute = (Attribute) attributeList.get(i);
                out.println (entityName + "_" + attribute.getName() + "=<bean:write property=\"" + attribute.getName() + "\" name=\"value_object\"/>");
            }

            attribute = (Attribute) attributeList.get(0);
            out.println ("&id\\=" + attribute.getName() + "\"=\" paramId=\"id\" paramName=\"value_object\"  paramProperty=\"id\"");
            out.close();
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: key.properties");
        }
    }

    //-------------------------------------------------

    public void generateFormValidationXML (String path)
    {
        ////=-= //=-= //=-= System.out.println ("Generating " + path + "/" + entityName + ".form.validation.xml");

        try
        {
            File formValidationFile = new File (path + "/" + entityName + ".form.validation.xml");
            FileWriter formValidationFileWriter = new FileWriter (formValidationFile);
            PrintWriter out = new PrintWriter(formValidationFileWriter);

            out.println ("\t<formset>");
            out.println ("\t\t<form name=\"" + entityName + "Form\">");

            Attribute attribute;
            for (int i = 0; i < attributeList.size(); i++)
            {
                attribute = (Attribute) attributeList.get(i);
                if (attribute.isRequired() && attribute.isNumeric())
                {
			        out.println ("\t\t\t<field property=\"" + attribute.getName() + "\" depends=\"required,mask\">");
				    out.println ("\t\t\t\t<arg0 key=\"" + attribute.getLabel() + "\" resource=\"false\"/>");
				    out.println ("\t\t\t\t<var>");
					out.println ("\t\t\t\t\t<var-name>mask</var-name>");
					out.println ("\t\t\t\t\t<var-value>^[0-9]*$</var-value>");
				    out.println ("\t\t\t\t</var>");
			        out.println ("\t\t\t</field>");
                    out.println ();
                }

                else if (attribute.isRequired() && attribute.getType().equals("java.sql.Date"))
                {
			        out.println ("\t\t\t<field property=\"" + attribute.getName() + "\" depends=\"required,date\">");
				    out.println ("\t\t\t\t<arg0 key=\"" + attribute.getLabel() + "\" resource=\"false\"/>");
				    out.println ("\t\t\t\t<var>");
					out.println ("\t\t\t\t\t<var-name>datePatternStrict</var-name>");
					out.println ("\t\t\t\t\t<var-value>yyyy/MM/dd</var-value>");
				    out.println ("\t\t\t\t</var>");
			        out.println ("\t\t\t</field>");
                    out.println ();
                }

                else if (attribute.isRequired())
                {
			        out.println ("\t\t\t<field property=\"" + attribute.getName() + "\" depends=\"required\">");
                    out.println ("\t\t\t\t<arg0 key=\"" + attribute.getLabel() + "\" resource=\"false\"/>");
                    out.println ("\t\t\t</field>");
                    out.println ();
                }

                else if (attribute.isNumeric())
                {
			        out.println ("\t\t\t<field property=\"" + attribute.getName() + "\" depends=\"mask\">");
				    out.println ("\t\t\t\t<arg0 key=\"" + attribute.getLabel() + "\" resource=\"false\"/>");
				    out.println ("\t\t\t\t<var>");
					out.println ("\t\t\t\t\t<var-name>mask</var-name>");
					out.println ("\t\t\t\t\t<var-value>^[0-9]*$</var-value>");
				    out.println ("\t\t\t\t</var>");
			        out.println ("\t\t\t</field>");
                    out.println ();
                }
            }

            out.println ("\t\t</form>");
            out.println ("\t</formset>");

            out.close();
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: " + path + entityName + ".form.validation.xml");
            e.printStackTrace();
        }
    }

    //-------------------------------------------------

    public void generateFarsiHTML (String path)
    {
        try
        {
            File dir = new File (path);
            if (!dir.exists())
                return;

            File farsiHtml = new File (path + "/" + entityName + ".farsi.html");
            File miscJava = new File (path + "/" + entityName + ".java");

            if (!farsiHtml.exists())
            {
                FileWriter fileWriter = new FileWriter (farsiHtml);
                PrintWriter out = new PrintWriter(fileWriter);

                out.println ("<html>");
                out.println ("<head>");
                out.println ("\t<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\">");
                out.println ("\t<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">");
                out.println ("\t<title>Ostan</title>");
                out.println ("</head>");
                out.println ("<body>");

                out.println (entityName.toUpperCase().substring(0,1) + entityName.substring(1));

                Attribute attribute;
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    out.println (attribute.getName() + "=" + attribute.getLabel());
                }
                out.println ("<\body>");

                out.close();
            }

            if (!miscJava.exists())
            {
                FileWriter fileWriter = new FileWriter (miscJava);
                PrintWriter out = new PrintWriter(fileWriter);

                Attribute attribute;
/*
                // EntityEJB.java
                out.println("\n\n------------ EJB.Java---------------");
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    String AttributeName = attribute.getName().toUpperCase().substring(0,1) + attribute.getName().substring(1);
                    String refEntityName = "";
                    String RefEntityName = "";
                    String displayAttrName = "";
                    String DisplayAttrName = "";

                    if (attribute.isForeignKey())
                    {
                        refEntityName = attribute.getRefEntityName();
                        RefEntityName = refEntityName.toUpperCase().substring(0,1) + refEntityName.substring(1);
                        displayAttrName = attribute.getDisplayAttrName();
                        DisplayAttrName = displayAttrName.toUpperCase().substring(0,1) + displayAttrName.substring(1);
                    }

                    out.println("private " + attribute.getType() + " " + attribute.getName() + ";");
                    if (attribute.isForeignKey())
                        out.println("private java.lang.String " + refEntityName + DisplayAttrName + ";");
                }
*/

                // EntityList.java
                out.println("\n\n------------ List.Java---------------");
                out.println("private java.lang.String id;");
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    String AttributeName = attribute.getName().toUpperCase().substring(0,1) + attribute.getName().substring(1);
                    String refEntityName = "";
                    String RefEntityName = "";
                    String displayAttrName = "";
                    String DisplayAttrName = "";

                    if (attribute.isForeignKey())
                    {
                        refEntityName = attribute.getRefEntityName();
                        RefEntityName = refEntityName.toUpperCase().substring(0,1) + refEntityName.substring(1);
                        displayAttrName = attribute.getDisplayAttrName();
                        DisplayAttrName = displayAttrName.toUpperCase().substring(0,1) + displayAttrName.substring(1);
                    }

                    out.println("private " + attribute.getType() + " " + attribute.getName() + ";");
                    if (attribute.isForeignKey())
                        out.println("private java.lang.String " + refEntityName + DisplayAttrName + ";");
                }

                //EntitySessionEJB.Java
                out.println("\n\n------------ SessionEJB.Java: modelToList---------------");
                out.println(entityName + "List.setId(" + entityName + "Model.getId());");
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    String AttributeName = attribute.getName().toUpperCase().substring(0,1) + attribute.getName().substring(1);
                    String refEntityName = "";
                    String RefEntityName = "";
                    String displayAttrName = "";
                    String DisplayAttrName = "";

                    if (attribute.isForeignKey())
                    {
                        refEntityName = attribute.getRefEntityName();
                        RefEntityName = refEntityName.toUpperCase().substring(0,1) + refEntityName.substring(1);
                        displayAttrName = attribute.getDisplayAttrName();
                        DisplayAttrName = displayAttrName.toUpperCase().substring(0,1) + displayAttrName.substring(1);
                    }

                    if (!attribute.isForeignKey())
                        out.println(entityName + "List.set" + AttributeName  + "(" + entityName + "Model.get" + AttributeName  + "());");
                    else
                    {
                        out.println("\n");
                        out.println(RefEntityName + "Local " + refEntityName + "Local = " + entityName + "Local.get" + RefEntityName + "();");
                        out.println("if (" + RefEntityName + "Local != null) {");
                        out.println("\t" + RefEntityName + "Model " + refEntityName + "Model = " + refEntityName + "Local.get" + RefEntityName + "Model();");
                        out.println("\t" + entityName + "List.set" + AttributeName  + "(" + refEntityName + "Model.getId());");
                        out.println("\t" + entityName + "List.set" + RefEntityName + DisplayAttrName  + "(" + refEntityName + "Model.get" + DisplayAttrName + "());");
                        out.println("}");
                    }

                }

                out.println("\n\n------------ SessionEJB.Java: resultSetToList---------------");
                out.println(entityName + "List.setId(resultSet.getString(\"id\"));");
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    String AttributeName = attribute.getName().toUpperCase().substring(0,1) + attribute.getName().substring(1);
                    String refEntityName = "";
                    String RefEntityName = "";
                    String displayAttrName = "";
                    String DisplayAttrName = "";

                    if (attribute.isForeignKey())
                    {
                        refEntityName = attribute.getRefEntityName();
                        RefEntityName = refEntityName.toUpperCase().substring(0,1) + refEntityName.substring(1);
                        displayAttrName = attribute.getDisplayAttrName();
                        DisplayAttrName = displayAttrName.toUpperCase().substring(0,1) + displayAttrName.substring(1);
                    }

                    if (!attribute.isForeignKey())
                    {
                        if (attribute.getType().equals("java.lang.String"))
                            out.println(entityName + "List.set" + AttributeName + "(resultSet.getString(\"" + attribute.getName() + "\"));");
                        else if (attribute.getType().equals("java.lang.Integer"))
                            out.println(entityName + "List.set" + AttributeName + "(new Integer(resultSet.getInt(\"" + attribute.getName() + "\")));");
                        else if (attribute.getType().equals("java.sql.Date"))
                            out.println(entityName + "List.set" + AttributeName + "(resultSet.getDate(\"" + attribute.getName() + "\"));");
                    }

                    else
                    {
                        out.println("\n");
                        out.println("String " + attribute.getName() + " = resultSet.getString(\"" + attribute.getName() + "\");");
                        out.println(entityName + "List.set" + RefEntityName + "Id(" + attribute.getName() + ");");
                        out.println(RefEntityName + "Local " + refEntityName + "Local = " + RefEntityName + "Util.getLocalHome().findByPrimaryKey(" + attribute.getName() + ");");
                        out.println("if (" + refEntityName + "Local != null) {");
                        out.println("\t" + RefEntityName + "Model " + refEntityName + "Model = " + refEntityName + "Local.get" + RefEntityName + "Model();");
                        out.println("\t" + entityName + "List.set" + RefEntityName + AttributeName + "(" + refEntityName + "Model.get" + DisplayAttrName + "());");
                        out.println("}");
                    }

                }

                out.close();
            }
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: key.properties");
        }
    }

    //-------------------------------------------------

    Properties createSimpleProperties ()
    {
        Properties lookupProperties = new Properties();
        lookupProperties.put("xxx", entityName);
        lookupProperties.put("Xxx", EntityName);
        return lookupProperties;
    }

    //-------------------------------------------------

    Properties createProperties (Attribute attribute)
    {
        Properties lookupProperties = new Properties();
        //lookupProperties.put("xxx", entityName);
        //lookupProperties.put("Xxx", EntityName);

        String attributeName = attribute.getName();
        String AttributeName = attribute.getName().toUpperCase().substring(0,1) + attribute.getName().substring(1);
        String attributeType = attribute.getType();
        String simpleAttributeType = attribute.getSimpleType();
        String refEntityName = "";
        String RefEntityName = "";
        String displayAttrName = "";
        String DisplayAttrName = "";

        if (attribute.isForeignKey())
        {
            refEntityName = attribute.getRefEntityName();
            RefEntityName = refEntityName.toUpperCase().substring(0,1) + refEntityName.substring(1);
            displayAttrName = attribute.getDisplayAttrName();
            DisplayAttrName = displayAttrName.toUpperCase().substring(0,1) + displayAttrName.substring(1);
        }

        lookupProperties.put("@attribute@", attributeName);
        lookupProperties.put("@Attribute@", AttributeName);
        lookupProperties.put("@label@", attribute.getLabel());
        lookupProperties.put("@type@", attributeType);
        lookupProperties.put("@simpleType@", simpleAttributeType);
        lookupProperties.put("@size@", attribute.getSize());
        lookupProperties.put("@refEntity@", refEntityName);
        lookupProperties.put("@RefEntity@", RefEntityName);
        lookupProperties.put("@displayAttribute@", displayAttrName);
        lookupProperties.put("@DisplayAttribute@", DisplayAttrName);

        return lookupProperties;
    }

    //-------------------------------------------------

    public void generateListJava (String path, String templatePath)
    {
        try
        {
            File dir = new File (path);
            if (!dir.exists())
            {
                //=-= //=-= //=-= System.out.println ("Warning folder " + dir + "does not exist!");
                return;
            }

            String listJavaFileName = path + "/" + EntityName + "List.java";
            File listJavaFile = new File (listJavaFileName);

            if (!listJavaFile.exists())
            {
                //FileWriter fileWriter = new FileWriter (listJavaFile);
                //PrintWriter out = new PrintWriter(fileWriter);
                String propertiesFileName = path + "/properties.tmp";
                //String propertyFileName = path + "/properties.tmp";
                String methodsFileName = path + "/methods.tmp";
                //String methodFileName = path + "/method.tmp";
                //BufferedWriter propertiesWriter = new BufferedWriter(new FileWriter(propertiesFileName));
                //BufferedWriter settersAndGettersWriter = new BufferedWriter(new FileWriter(settersAndGettersFileName));

                Properties lookupProperties;
                FileUtil.copyFile(templatePath + "/Head.XxxList.xava", listJavaFileName, false);

                Attribute attribute;
                for (int i = 0; i < attributeList.size(); i++)
                {
                    attribute = (Attribute) attributeList.get(i);
                    if (attribute.isForeignKey())
                    {
                        lookupProperties = createProperties(attribute);

                        FileUtil.copyFile(templatePath + "/Property.XxxList.xava", propertiesFileName, true);
                        FileUtil.replaceFromProperties(propertiesFileName, lookupProperties);

                        FileUtil.copyFile(templatePath + "/SetterGetter.XxxList.xava", methodsFileName, true);
                        FileUtil.replaceFromProperties(methodsFileName, lookupProperties);
                    }
                }

                FileUtil.copyFile(propertiesFileName, listJavaFileName, true);
                FileUtil.copyFile(methodsFileName, listJavaFileName, true);
                FileUtil.copyFile(templatePath + "/Tail.XxxList.xava", listJavaFileName, true);
                lookupProperties = createSimpleProperties();
                FileUtil.replaceFromProperties(listJavaFileName, lookupProperties);

                //*************************** Cleanup *****************************
                (new File(propertiesFileName)).delete();
                (new File(methodsFileName)).delete();

            }
        }

        catch (IOException e)
        {
            //=-= //=-= //=-= System.out.println ("Cannot create: " + EntityName + "List.Java");
        }
    }

    //-------------------------------------------------

    public boolean hasAnyForeignKey() {
        Attribute attribute;
        for (int i = 0; i < attributeList.size(); i++)
        {
            attribute = (Attribute) attributeList.get(i);
            if (attribute.isForeignKey())
                return true;
        }

        return false;
    }
    //-------------------------------------------------

    public String getEntityName ()
    {
        return entityName;
    }

    //-------------------------------------------------

    public String getEntityNameCapital ()
    {
        return EntityName;
    }

    //-------------------------------------------------

    public String getFarsiTitle() {
        return farsiTitle;
    }

    //-------------------------------------------------

    public String getDescription() {
        return description;
    }

    //-------------------------------------------------

    public int getBusinessProcessCode() {
        return businessProcessCode;
    }

    //-------------------------------------------------

    public void initIterator ()
    {
        nextAttributeIndex = 0;
    }

    //-------------------------------------------------

    public Attribute getNextAttribute ()
    {
        if (nextAttributeIndex < attributeList.size())
        {
            Attribute attribute = (Attribute) attributeList.get(nextAttributeIndex);
            nextAttributeIndex++;
            return attribute;
        }

        else
            return null;
    }

    //-------------------------------------------------

    public boolean hasNextAttribute ()
    {
        if (nextAttributeIndex < attributeList.size())
            return true;
        else
            return false;
    }

    //-------------------------------------------------

    public Attribute getCurAttribute ()
    {
        if (nextAttributeIndex < attributeList.size())
        {
            Attribute attribute = (Attribute) attributeList.get(nextAttributeIndex);
            return attribute;
        }

        else
            return null;
    }
    //-------------------------------------------------

    public int getNextAttributeIndex ()
    {
        return nextAttributeIndex;
    }

    //-------------------------------------------------

    public int getDetailsIndex ()
    {
        return detailsIndex;
    }

    //-------------------------------------------------

    public static void main (String [] args) throws FileNotFoundException, EntitySpecException
    {

        ////=-= //=-= //=-= System.out.println ("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  SPEC   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        String specPath = args[0];
        File specDir = new File (specPath);
        String [] specFile = specDir.list();
        //String srcDir = (String) FileUtil.createLookupProperties().get("@src.dir@");
        String templateFolder = specPath + "/../../jsa/model";

        if (!specDir.exists() || !specDir.isDirectory() || specFile.length == 0)
        {
            ////=-= //=-= //=-= System.out.println (specDir + " doesn't exist or is not a directory or is empty");
            return;
        }

        for (int i = 0; i < specFile.length; i++)
        {
            if(specFile[i].endsWith(ENTITY_SPEC_EXTENSION))
            {
                ////=-= //=-= //=-= System.out.println ("Processing specification file: " + specFile[i]);
                EntitySpecProcessor esp = new EntitySpecProcessor (specPath + "/" + specFile[i]);
/*
                //************************  Output for test  *******************************
                try
                {
                    FileWriter out = new FileWriter (new File (specPath.substring(0, specPath.lastIndexOf('/')) + "/farsi/" + esp.getEntityNameCapital() + ".txt"));
                    PrintWriter output = new PrintWriter (out);

                    output.println(esp.getEntityName() + "\t\t" + esp.getFarsiTitle() + "\t\t" + esp.getDescription() + "\t\t" + esp.getBusinessProcessCode());
                    Attribute attrib;
                    esp.initIterator();
                    while ((attrib = esp.getNextAttribute()) != null)
                    {
                        attrib.display(output);
                        if (esp.getDetailsIndex() == esp.getNextAttributeIndex() - 1)
                        output.println ("Details");

                    }

                    //esp.generateEntityBeanProperties ("");
                    //esp.generateKeyProperties ();
                    //esp.generateFormValidationXML("");
                    esp.cleanup();
                    output.close();
                }
                catch (IOException e)
                {
                    //e.printStackTrace();  //To change body of catch statement use Options | File Templates.
                }
                //**************************************************************************
*/
                // Generating entitybean.properties
                esp.generateEntityBeanProperties(specPath.substring(0, specPath.lastIndexOf('/')) + "/ejb");

                // Generating ListJava
                if (esp.hasAnyForeignKey())
                    esp.generateListJava(specPath.substring(0, specPath.lastIndexOf('/')) + "/ejb" , templateFolder + "/list");

                // Generating action.properties
                esp.generateActionProperties(specPath.substring(0, specPath.lastIndexOf('/')) + "/web/action");

                // Generating farsi.html
                esp.generateFarsiHTML (specPath.substring(0, specPath.lastIndexOf('/')) + "/farsi");

                esp.cleanup ();
            }
        }
    }
}
