
package com.objectj.jsa.tool;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 *
 * @author Hossein Akhlaghpour
 */
public class FormXMLMaker {

    protected static Logger log = Logger.getLogger(FormXMLMaker.class.getName());

    public static final String LIGHT_EXTENSION = " - light";
    public static final String PK_EXTENSION = " - primaryKey";
    public static final String IDENTIFIER = ".entitybean.properties";
    public static final String ENTITY_SPEC = ".entity.spec";

    private Properties lookupPropertie;

    public static void main(String[] args) throws Exception, EntitySpecException  {
        FileUtil.checkForRightNumberOfArgs(args, "FormBeanMaker propertiesFileName", log);
        (new FormXMLMaker()).makeFormXML(args[0]);
        log.debug("done");
    }

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }
    public void makeFormXML(String topPropFolderName) throws Exception, EntitySpecException  {
        String[] files;
        File topPropFolder = new File(topPropFolderName);
        if(!topPropFolder.exists() || !topPropFolder.isDirectory() || (files = topPropFolder.list()).length == 0) {
            log.warn(topPropFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        for(int index =0; index != files.length; index++) {
            File file = new File(topPropFolder, files[index]);
            log.debug("file " + file + " isDir " + file.isDirectory());
            if(file.isDirectory()) {
                log.debug("Checking folder " + files[index]);
                makeFormXML(file.toString());
            }
           else {
                String fileName = file.toString();
                if(fileName.endsWith(IDENTIFIER)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), fileName, IDENTIFIER);
                    makeFormXMLNow(file);
                }
            }
         }
    }

    public void makeFormXMLNow(File propsFile) throws IOException, EntitySpecException {

        if(!propsFile.exists()) {
            log.warn(propsFile + " doesn't exist");
            return;
        }
        log.debug("loading properties file " + propsFile);
        Properties propsFromFile = new Properties();
        propsFromFile.load(new FileInputStream(propsFile));

        String topPath = (String)getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        String beanName = (String)getLookupProperties().get("Xxx");
        beanName = beanName.toLowerCase().substring(0, 1) + beanName.substring(1);
        getLookupProperties().put("xxx", beanName);

        String parent = srcDir + "/" + topPath + "/web/action";
        String templatePackage = "com/objectj/jsa/web/action";
        (new File(parent)).mkdirs();

        String specFileName = srcDir + "/" + topPath + "/spec/" + beanName + ENTITY_SPEC;
        EntitySpecProcessor specProcessor = new EntitySpecProcessor (specFileName);

        //*************************************** Creating Validation *************************************************
        String validation = parent + "/" + beanName + ".form.validation.xml";
        File validationFile = new File(validation);
        if(validationFile.exists()) {
            log.debug("Validation file exists, ignoring Validation generation");
        } else {
            log.info("Generating " + validationFile);

            /*
            //=-= //=-= //=-= System.out.println ("srcDir = " + srcDir);
            //=-= //=-= //=-= System.out.println ("topPath = " + topPath);
            */

            specProcessor.generateFormValidationXML(parent); //srcDir + "/" + topPath + "/web/action"
        }
        //********** End of Creating Validation *************


        //**************************************** Creating xxx.form.xml *******************************************
        String formXmlFileName = parent + "/" + beanName + ".form.xml";
        //log.debug("Writing to "+ formXmlFileName);
        File formXmlFile = new File(formXmlFileName);
        if(formXmlFile.exists()) {
            log.debug("Form Bean file " + formXmlFile + " is newer than properties file " + propsFile + " ignoring the Form bean generation");
            return;
        } else {
            log.info("Generating " + formXmlFile + " from " + propsFile);
        }

        String formXmlEditAttrFileName = parent + "/formXmlEditAttr.xtml";
        BufferedWriter formXmlEditAttrWriter = new BufferedWriter(new FileWriter(formXmlEditAttrFileName));

        String formXmlFilterAttrFileName = parent + "/formXmlFilterAttr.xtml";
        BufferedWriter formXmlFilterAttrWriter = new BufferedWriter(new FileWriter(formXmlFilterAttrFileName));


        //******************************  Writing xxx.form.xml Head  ********************************
        FileUtil.copyFile(srcDir + "/" + templatePackage + "/xxxHead.form.xml", formXmlFileName, false);

        Attribute attribute;
        specProcessor.initIterator();

        //******************************  Creating xxx.form.xml Attributes  ********************************
        while ((attribute = specProcessor.getNextAttribute()) != null){
            //String key = (String)iter.next();
            //String value = (String)propsFromFile.get(key);
            String attributeName = attribute.getName();
            String AttributeName = attribute.getName().toUpperCase().substring(0, 1) + attribute.getName().substring(1);
            String attributeType = attribute.getType();
            if (attributeType.equals("java.sql.Date"))
                attributeType = "java.lang.String";

            if (attributeType.indexOf(EntityBeanMaker.STRING_LENGTH_EXTENSION)!= -1){
                StringBuffer sb = new StringBuffer(attributeType);
                attributeType = sb.replace(attributeType.indexOf(EntityBeanMaker.STRING_LENGTH_EXTENSION), attributeType.indexOf("$") + 1, "").toString();
            }

            if(attributeType.endsWith(LIGHT_EXTENSION)) {
                attributeType = attributeType.substring(0, attributeType.length() - LIGHT_EXTENSION.length());
            }
            if(attributeType != null && attributeType.length() != 0) {
                if(attributeType.endsWith(PK_EXTENSION)) {
                    attributeType = attributeType.substring(0, attributeType.length() - PK_EXTENSION.length());
                }
            }
            formXmlEditAttrWriter.write("\t<form-property name=\"" + attributeName + "\" type=\"" + attributeType + "\"/>\n");
            formXmlFilterAttrWriter.write("\t<form-property name=\"fr_" + attributeName + "\" type=\"" + attributeType + "\"/>\n");
            formXmlFilterAttrWriter.write("\t<form-property name=\"to_" + attributeName + "\" type=\"" + attributeType + "\"/>\n");
        }

        formXmlEditAttrWriter.close();
        formXmlFilterAttrWriter.close();

        //******************************  Writing xxx.form.xml Middle  ********************************
        FileUtil.copyFile(formXmlEditAttrFileName, formXmlFileName, true);



/*********************** Dear Hamid pleas un-comment the following two lines: ***************************/
/*                                                                                                      */
//        FileUtil.copyFile(srcDir + "/" + templatePackage + "/xxxMiddle.form.xml", formXmlFileName, true);
//        FileUtil.copyFile(formXmlFilterAttrFileName, formXmlFileName, true);
/*                                                                                                      */
/********************************************************************************************************/


        //******************************  Writing xxx.form.xml Tail  ********************************
        FileUtil.copyFile(srcDir + "/" + templatePackage + "/xxxTail.form.xml", formXmlFileName, true);
        FileUtil.replaceFromProperties(formXmlFileName, getLookupProperties());

        //***********************************   Cleanup   ***************************************
        (new File(formXmlEditAttrFileName)).delete();
        (new File(formXmlFilterAttrFileName)).delete();
    }
 }
