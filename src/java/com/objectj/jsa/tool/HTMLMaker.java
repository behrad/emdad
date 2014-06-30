package com.objectj.jsa.tool;

import java.io.*;
//import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 *
 * @author Hossein Akhlaghpour
 */

public class HTMLMaker {

    //*******************************************************************

    protected static Logger log = Logger.getLogger(HTMLMaker.class.getName());

    public static final String LIGHT_EXTENSION = " - light";
    public static final String PK_EXTENSION = " - primaryKey";
    public static final String IDENTIFIER = ".entitybean.properties";
    public static final String ENTITY_SPEC = ".entity.spec";

    private Properties lookupPropertie;


    //*******************************************************************


    public static void main(String[] args) throws Exception, EntitySpecException  {
        FileUtil.checkForRightNumberOfArgs(args, "FormBeanMaker propertiesFileName", log);
        (new HTMLMaker()).makeHTML(args[0]);
        log.debug("done");
    }


    //*******************************************************************


    public Properties getLookupProperties() {
        if (lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }


    //*******************************************************************


    public void makeHTML(String topPropFolderName) throws Exception, EntitySpecException  {
        String[] files;
        File topPropFolder = new File(topPropFolderName);
        if (!topPropFolder.exists() || !topPropFolder.isDirectory() || (files = topPropFolder.list()).length == 0) {
            log.warn(topPropFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        for (int index = 0; index != files.length; index++) {
            File file = new File(topPropFolder, files[index]);
            log.debug("file " + file + " isDir " + file.isDirectory());
            if (file.isDirectory()) {
                log.debug("Checking folder " + files[index]);
                makeHTML(file.toString());
            } else {
                String fileName = file.toString();
                if (fileName.endsWith(IDENTIFIER)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), fileName, IDENTIFIER);
                    makeHTMLNow(file);
                }
            }
        }
    }


    //*******************************************************************


    public void makeHTMLNow(File propsFile) throws IOException, EntitySpecException  {

        if (!propsFile.exists()) {
            log.warn(propsFile + " doesn't exist");
            return;
        }
        log.debug("loading properties file " + propsFile);
        Properties propsFromFile = new Properties();
        propsFromFile.load(new FileInputStream(propsFile));
        StringBuffer keyProps = new StringBuffer("#---------------\n");

        String topPath = (String) getLookupProperties().get("@top.path@");
        String srcDir = (String) getLookupProperties().get("@src.dir@");
        String beanName = (String) getLookupProperties().get("Xxx");
        beanName = beanName.toLowerCase().substring(0, 1) + beanName.substring(1);
        getLookupProperties().put("xxx", beanName);
        String parent = srcDir + "/" + topPath + "/html";
        String templatePackage = "com/objectj/jsa/model/html";

        //************************** Reading entity specifications file ************************
        String specFileName = srcDir + "/" + topPath + "/spec/" + beanName + ENTITY_SPEC;
        EntitySpecProcessor specProcessor = new EntitySpecProcessor (specFileName);


        //************************** Defining HTML files ************************
        String htmlEditFileName = parent + "/" + beanName + ".edit.htm";
        File htmlEditFile = new File(htmlEditFileName);

        String htmlAdvncdFilterFileName = parent + "/" + beanName + ".filter.htm";
        //File htmlAdvncdFilterFile = new File(htmlAdvncdFilterFileName);

        String htmlReadFileName = parent + "/" + beanName + ".read.htm";
        File htmlReadFile = new File(htmlReadFileName);

        String htmlListFileName = parent + "/" + beanName + ".list.htm";
        String htmlReportFileName = parent + "/" + beanName + ".report.htm";
        //File htmlListFile = new File(htmlListFileName);
        //***********************************************************************


        if (htmlEditFile.exists())
        {
            log.debug(htmlEditFile + " exists, ignoring html generation totally!");
            return;
        }

        else if (new File(htmlAdvncdFilterFileName).exists())
        {
            log.debug(htmlAdvncdFilterFileName + " exists, ignoring html generation totally!");
            return;
        }

        else if (htmlReadFile.exists())
        {
            log.debug(htmlReadFileName + " exists, ignoring html generation totally!");
            return;
        }

        else if (new File(htmlListFileName).exists())
        {
            log.debug(htmlListFileName + " exists, ignoring html generation totally!");
            return;
        }

        else if (new File(htmlReportFileName).exists())
        {
            log.debug(htmlReportFileName + " exists, ignoring html generation totally!");
            return;
        }

        else
        {
            //log.info("Generating html files of " + beanName + " entity from " + specFileName);
        }


        //**********************************  Temporary Files **********************************
        String editFieldFileName = parent + "/tmp-edit.xtml";
        String advncdFilterFieldsFileName = parent + "/tmp-filter.xtml";
        BufferedWriter advncdFilterFieldsWriter = new BufferedWriter (new FileWriter (advncdFilterFieldsFileName));
        String readFieldFileName = parent + "/tmp-read.xtml";

        String listFilterFileName = parent + "/list-filter.xtml";
        String listRow1FileName = parent + "/list-row1.xtml";
        String listRow2FileName = parent + "/list-row2.xtml";
        BufferedWriter listFilterWriter = new BufferedWriter(new FileWriter(listFilterFileName));
        BufferedWriter listRow1Writer = new BufferedWriter(new FileWriter(listRow1FileName));
        BufferedWriter listRow2Writer = new BufferedWriter(new FileWriter(listRow2FileName));

        String reportRow1FileName = parent + "/report-row1.xtml";
        BufferedWriter reportRow1Writer = new BufferedWriter(new FileWriter(reportRow1FileName));
        reportRow1Writer.write("\t\trequest.setAttribute(\"titles\", new String[] {");
        String reportRow2FileName = parent + "/report-row2.xtml";
        BufferedWriter reportRow2Writer = new BufferedWriter(new FileWriter(reportRow2FileName));
        reportRow2Writer.write("\t\trequest.setAttribute(\"fields\", new String[] {");
        //**************************************************************************************


        //**********************************  Writing Headers **********************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/edit_head.xtml", htmlEditFileName, false);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/filter_head.xtml", htmlAdvncdFilterFileName, false);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/read_head.xtml", htmlReadFileName, false);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/list_head.xtml", htmlListFileName, false);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/report_head.xtml", htmlReportFileName, false);
        //**************************************************************************************

        //******************************   Writing Middle Parts   ******************************
        Attribute attribute;
        specProcessor.initIterator();
        while ((attribute = specProcessor.getNextAttribute()) != null)
        {
            String attributeName = attribute.getName();
            String AttributeName = attribute.getName().toUpperCase().substring(0, 1) + attribute.getName().substring(1);
            String attributeType = attribute.getType();
            String simpleAttributeType = attribute.getSimpleType();
            String refEntityName = attribute.getRefEntityName();
            String displayAttrName = attribute.getDisplayAttrName();
            String DisplayAttrName = "";
            if (displayAttrName.length() >= 1)
                DisplayAttrName = attribute.getDisplayAttrName().toUpperCase().substring(0, 1) + attribute.getDisplayAttrName().substring(1);
            String description = attribute.getDescription();

            String valueObjectPropertyName;
            if (! attribute.isForeignKey())
                valueObjectPropertyName = attributeName;
            else
                valueObjectPropertyName = refEntityName + DisplayAttrName;

            String placeHolder, fkPlaceHolder;

            //**************** Place Holder for Key Peroperties ************************
            if (! attribute.isForeignKey())
            {
                placeHolder = beanName + "_" + attributeName; //+ (int) (Math.random() * 100);
                keyProps.append(placeHolder + "=<bean:write property=\"" + attributeName + "\" name=\"value_object\"/>\n");
            }

            else
            {
                fkPlaceHolder = beanName + "_" + refEntityName + AttributeName; //+ (int) (Math.random() * 100);
                keyProps.append(fkPlaceHolder + "=<bean:write property=\"" + refEntityName + AttributeName + "\" name=\"value_object\"/>\n");
                placeHolder = beanName + "_" + refEntityName + DisplayAttrName; //+ (int) (Math.random() * 100);
                keyProps.append(placeHolder + "=<bean:write property=\"" + refEntityName + DisplayAttrName + "\" name=\"value_object\"/>\n");
            }
            //**************************************************************************

            getLookupProperties().put("@attributeName@", attributeName);
            getLookupProperties().put("@AttributeName@", AttributeName);
            getLookupProperties().put("@label@", attribute.getLabel());
            getLookupProperties().put("@type@", attributeType);
            getLookupProperties().put("@simpleType@", simpleAttributeType);
            getLookupProperties().put("@size@", attribute.getSize());
            getLookupProperties().put("@refEntityName@", refEntityName);
            getLookupProperties().put("@displayAttrName@", displayAttrName);

            if (!description.equals(""))
                getLookupProperties().put("@description@", "<span class=\"fieldDescription\">&nbsp;" + description + "</span>");
            else
                getLookupProperties().put("@description@", " ");

            if (attribute.isRequired())
                getLookupProperties().put("@star@", "*");
            else
                getLookupProperties().put("@star@", " ");

            if (attribute.isFarsi())
                getLookupProperties().put("@farsi@", " onkeypress=\"return submitenter(this,event)\" ");
            else
                getLookupProperties().put("@farsi@", " ");

            getLookupProperties().put("@placeHolder@", placeHolder);
            getLookupProperties().put("@editRowClass@", "editRow" + (specProcessor.getNextAttributeIndex() - 1) % 2);
            getLookupProperties().put("@filterRowClass@", "filterRow" + (specProcessor.getNextAttributeIndex() - 1) % 2);
            getLookupProperties().put("@readRowClass@", "readRow" + (specProcessor.getNextAttributeIndex() - 1) % 2);

            //************************ Edit Middle *************************
            if (! attribute.isForeignKey())
                FileUtil.copyFile(srcDir + "/" + templatePackage + "/edit_field.xtml", editFieldFileName, false);
            else
                FileUtil.copyFile(srcDir + "/" + templatePackage + "/edit_fk_field.xtml", editFieldFileName, false);

            FileUtil.replaceFromProperties(editFieldFileName, getLookupProperties());
            FileUtil.copyUtf8File(editFieldFileName, htmlEditFileName, true);

            //************************ Read Middle *************************
            FileUtil.copyFile(srcDir + "/" + templatePackage + "/read_field.xtml", readFieldFileName, false);
            FileUtil.replaceFromProperties(readFieldFileName, getLookupProperties());
            FileUtil.copyUtf8File(readFieldFileName, htmlReadFileName, true);

            //********************* Advanced Filter Middle *****************
            if (!attribute.isForeignKey())
                if (attribute.isFarsi())
                    advncdFilterFieldsWriter.write ("\t\t\t\t\t\t<option  value=\"" + beanName + "." + attributeName + "\" id=\"" + simpleAttributeType + "\" onkeypress=\"return submitenter(this,event)\">" + attribute.getLabel() + "</option >\n");
                else
                    advncdFilterFieldsWriter.write ("\t\t\t\t\t\t<option  value=\"" + beanName + "." + attributeName + "\" id=\"" + simpleAttributeType + "\">" + attribute.getLabel() + "</option >\n");

            //************************ List Middle *************************
            if (attribute.isListable())
            {
                //*********   Filter   *********
                if (attribute.isForeignKey())
                {
                    listFilterWriter.write("\t\t\t<td class=\"filterFieldCell\">\n");
                    listFilterWriter.write("\t\t\t\t<html:select property=\"" + attributeName + "\" size=\"1\">\n");
                    //listFilterWriter.write("\t\t\t\t\t<html:options collection=\"" + refEntityName + "List\" property=\"id\" labelProperty=\"" + displayAttrName + "\" />\n");
                    listFilterWriter.write("\t\t\t\t\t<html:options collection=\"" + refEntityName + "List\" property=\"eid\" labelProperty=\"name\"/>\n");
                    listFilterWriter.write("\t\t\t\t</html:select>\n");
                    listFilterWriter.write("\t\t\t</td>\n");
                }
                else
                {
                    int showSize = (int) (0.7 * Integer.parseInt(attribute.getSize()));
                    if (showSize > 20)
                        showSize = 20;
                    if (attribute.isFarsi())
                        listFilterWriter.write("\t\t\t<td class=\"filterFieldCell\"><html:text property=\"" + attributeName + "\" size=\"" + showSize + "\" maxlength=\"" + attribute.getSize() + "\" onkeypress=\"return submitenter(this,event)\" styleClass=\"field\"/></td>\n");
                    else
                        listFilterWriter.write("\t\t\t<td class=\"filterFieldCell\"><html:text property=\"" + attributeName + "\" size=\"" + showSize + "\" maxlength=\"" + attribute.getSize() + "\" styleClass=\"field\"/></td>\n");
                }

                //*********   Row 1   *********
                String desc = "";
                if (!attribute.getDescription().equals(""))
                    desc = "&nbsp;(" + description + ")";

                if (attribute.isSortable())
                    listRow1Writer.write ("\n\t\t\t<td class = \"listRow0Col\">" + "\n" +
                                          "\t\t\t\tsortable_Column_Name \"" + attributeName + "\"" + "\n" +
                                          "\t\t\t\tsortable_Column_Title \"" + attribute.getLabel() + desc + "\"" + "\n" +
                                          "\t\t\t\tsortable_Column_String" + "\n" +
                                          "\t\t\t</td>" + "\n");
                else
                    listRow1Writer.write ("\n\t\t\t<td class = \"listRow0Col\"> " + attribute.getLabel() + desc + " </td>" + "\n");

                //*********   Row 2   *********
                if (specProcessor.getDetailsIndex() == specProcessor.getNextAttributeIndex() - 1)
                {
                    //listRow2Writer.write("\n\t\t\t\t\t\t\t<td class = \"listRow1Col\"><a  href='javascript:read(\"entity_id\");'>" + placeHolder + "</a ></td>\n");

                    listRow2Writer.write("\n\t\t\t\t<td class = \"listRow1Col\">\n");
                    listRow2Writer.write("\t\t\t\t\t<logic:equal name=\"entity_access\" property=\"readAccess\" value=\"true\" >\n");
                    listRow2Writer.write("\t\t\t\t\t\t<a  href='javascript:read(\"<bean:write name=\"value_object\" property=\"id\"  />\");'>\n");
                    listRow2Writer.write("\t\t\t\t\t</logic:equal>\n");
                    listRow2Writer.write("\t\t\t\t\t" + placeHolder + "\n");
                    listRow2Writer.write("\t\t\t\t\t<logic:equal name=\"entity_access\" property=\"readAccess\" value=\"true\" >\n");
                    listRow2Writer.write("\t\t\t\t\t\t</a >\n");
                    listRow2Writer.write("\t\t\t\t\t</logic:equal>\n");
                    listRow2Writer.write("\t\t\t\t</td>\n");
                }
                else
                    listRow2Writer.write("\n\t\t\t\t<td class = \"listRow1Col\">" + placeHolder + "</td>\n");
            }


            //************************ Report Middle *************************
            if (attribute.isListable())
            {
                //*********   Row 1   *********
                reportRow1Writer.write("\"" + attribute.getLabel() + "\"");
                if (specProcessor.hasNextAttribute())
                    reportRow1Writer.write(", ");

                //*********   Row 2   *********
                if (!attribute.isForeignKey())
                    reportRow2Writer.write("\"" + attribute.getName() + "\"");
                else
                    reportRow2Writer.write("\"" + attribute.getDisplayAttrName() + "\"");

                if (specProcessor.hasNextAttribute())
                    reportRow2Writer.write(", ");
            }

        }

        //******************** Advance Filter Middle (Continued) *******************
        advncdFilterFieldsWriter.close ();
        FileUtil.copyFile(advncdFilterFieldsFileName, htmlAdvncdFilterFileName, true);

        //************************ List Middle (Continued) *************************
        listFilterWriter.close();
        listRow1Writer.close();
        listRow2Writer.close();

        FileUtil.copyFile(listFilterFileName, htmlListFileName, true);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/list_middle_1.xtml", htmlListFileName, true);
        FileUtil.copyFile(listRow1FileName, htmlListFileName, true);
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/list_middle_2.xtml", htmlListFileName, true);
        FileUtil.copyFile(listRow2FileName, htmlListFileName, true);
        //***************************************************************************

        //************************ Report Middle (Continued) *************************
        reportRow1Writer.write("});\n");
        reportRow1Writer.close();
        reportRow2Writer.write("});\n");
        reportRow2Writer.close();

        FileUtil.copyFile(reportRow1FileName, htmlReportFileName, true);
        FileUtil.copyFile(reportRow2FileName, htmlReportFileName, true);
        //***************************************************************************

        //************************************ Writing Tails ************************************
        //************************ Edit Tail *************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/edit_tail.xtml", htmlEditFileName, true);
        FileUtil.replaceFromProperties(htmlEditFileName, getLookupProperties());

        //************************ Advanced Filter Tail *************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/filter_tail.xtml", htmlAdvncdFilterFileName, true);
        FileUtil.replaceFromProperties(htmlAdvncdFilterFileName, getLookupProperties());

        //************************ Read Tail *************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/read_tail.xtml", htmlReadFileName, true);
        FileUtil.replaceFromProperties(htmlReadFileName, getLookupProperties());

        //************************ List Tail *************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/list_tail.xtml", htmlListFileName, true);
        FileUtil.replaceFromProperties(htmlListFileName, getLookupProperties());
        //***************************************************************************************

        //************************ Report Tail *************************
        FileUtil.copyUtf8File(srcDir + "/" + templatePackage + "/report_tail.xtml", htmlReportFileName, true);
        FileUtil.replaceFromProperties(htmlReportFileName, getLookupProperties());
        //***************************************************************************************

        //******************************* Appending Key Properties ******************************
        keyProps.append("&id\\=" + beanName + "Id" + "\"=\" paramId=\"id\" paramName=\"value_object\"  paramProperty=\"id\"\n");
        new File(parent + "/properties/").mkdirs();
        String htmlProp = parent + "/properties/keys.properties";
        log.debug("Writin to " + htmlProp);
        File htmlPropFile = new File(htmlProp);

        BufferedWriter htmlPropFileWriter = new BufferedWriter(new FileWriter(htmlPropFile, true));
        htmlPropFileWriter.write(keyProps.append("\n").toString());
        htmlPropFileWriter.close();
        //***************************************************************************************


        //***********************************   Cleanup   ***************************************
        (new File(editFieldFileName)).delete();
        (new File(advncdFilterFieldsFileName)).delete();
        (new File(readFieldFileName)).delete();
        (new File(listFilterFileName)).delete();
        (new File(listRow1FileName)).delete();
        (new File(listRow2FileName)).delete();
        (new File(reportRow1FileName)).delete();
        (new File(reportRow2FileName)).delete();
        //***************************************************************************************
    }

    //*******************************************************************
}
