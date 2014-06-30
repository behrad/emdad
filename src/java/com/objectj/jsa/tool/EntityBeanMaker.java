/*
 * entityMaker.java
 *
 * Created on February 8, 2003, 11:34 PM
 */

package com.objectj.jsa.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 *
 * @author Hossein Akhlaghpour
 */
public class EntityBeanMaker {

    protected static Logger log = Logger.getLogger(EntityBeanMaker.class.getName());

    public static final String LIGHT_EXTENSION = " - light";
    public static final String PK_EXTENSION = " - primaryKey";
    public static final String IDENTIFIER = ".entitybean.properties";
    public static final String STRING_LENGTH_EXTENSION = " - stringLength";

    private Properties lookupPropertie;

    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "EntityBeanMaker propertiesFileName", log);
        (new EntityBeanMaker()).makeEntityBean(args[0]);
        log.debug("done");
    }

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }


    public void makeEntityBean(String topPropFolderName) throws Exception {
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
                makeEntityBean(file.toString());
            }
           else {
                String fileName = file.toString();
                if(fileName.endsWith(IDENTIFIER)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), fileName, IDENTIFIER);
                    makeEntityBeanNow(file);
                }
            }
         }
    }

    public void makeEntityBeanNow(File propsFile) throws IOException {

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

        String parent = srcDir + "/" + topPath + "/ejb";
        String src = parent + "/" + beanName + "EJB.java";
        log.debug("Writin to "+ src);
        File entityFile = new File(src);

        if(entityFile.exists()) {
            log.debug("Entity Bean file " + entityFile + " is newer than properties file " + propsFile + " ignoring the entity bean generation");
            return;
        } else {
            log.info("Generating " + entityFile + " from " + propsFile);
        }

        String overwrite = System.getProperty("overwrite");
        if( (overwrite == null || overwrite.equalsIgnoreCase("false")) && entityFile.exists()) src += ".generated";

        String templatePackage = "com/objectj/jsa/model/entity";
        FileUtil.copyFile(srcDir + "/"+ templatePackage + "/head.xava", src, false);
        String newFieldFile = parent + "/tmp.xava";
        for(Iterator iter = propsFromFile.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            String value = (String)propsFromFile.get(key);
            if(value != null && value.length() != 0) {
                getLookupProperties().put("@type@", value);
                getLookupProperties().put("@field@", key);
                getLookupProperties().put("@Field@", key.toUpperCase().substring(0, 1) + key.substring(1));
                FileUtil.copyFile(srcDir + "/"+ templatePackage + "/set_field.xava", newFieldFile, false);
                FileUtil.replaceFromProperties(newFieldFile, getLookupProperties());
                FileUtil.copyFile(newFieldFile, src, true);
            }
        }
        FileUtil.copyFile(srcDir + "/"+ templatePackage + "/create.end.xava", src, true);
        FileUtil.copyFile(srcDir + "/"+ templatePackage + "/pk.xava", src, true);
        FileUtil.replaceFromProperties(src, getLookupProperties());

        for(Iterator iter = propsFromFile.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            String value = (String)propsFromFile.get(key);
            boolean isLight = false;
            if(value.endsWith(LIGHT_EXTENSION)) {
                value = value.substring(0, value.length() - LIGHT_EXTENSION.length());
                isLight = true;
            }
            boolean isString = false;
            if (value.indexOf(STRING_LENGTH_EXTENSION)!= -1) {
                String length = value.substring(value.indexOf(STRING_LENGTH_EXTENSION)+STRING_LENGTH_EXTENSION.length(),value.indexOf("$"));
                StringBuffer sb = new StringBuffer(value);
                value = sb.replace(value.indexOf(STRING_LENGTH_EXTENSION), value.indexOf("$") + 1, "").toString();
                getLookupProperties().put("@stringLength@", length);
                isString = true;
            }
            if(value != null && value.length() != 0) {
                if(value.endsWith(PK_EXTENSION)) {
                    value = value.substring(0, value.length() - PK_EXTENSION.length());
                    String pk = key;
                    getLookupProperties().put("@primaryKey@", pk);
                    getLookupProperties().put("@primaryKeyType@", value);
                    getLookupProperties().put("@PrimaryKey@", pk.toUpperCase().substring(0, 1) + pk.substring(1));
                } else {

                    getLookupProperties().put("@type@", value);
                    getLookupProperties().put("@field@", key);
                    getLookupProperties().put("@Field@", key.toUpperCase().substring(0, 1) + key.substring(1));

                    if (isLight){
                        if (isString) FileUtil.copyFile(srcDir + "/"+ templatePackage + "/field.light.string.xava", newFieldFile, false);
                        else FileUtil.copyFile(srcDir + "/"+ templatePackage + "/field.light.xava", newFieldFile, false);
                    }else{
                        if (isString) FileUtil.copyFile(srcDir + "/"+ templatePackage + "/field.string.xava", newFieldFile, false);
                        else FileUtil.copyFile(srcDir + "/"+ templatePackage + "/field.xava", newFieldFile, false);
                    }


                    FileUtil.replaceFromProperties(newFieldFile, getLookupProperties());
                    FileUtil.copyFile(newFieldFile, src, true);
                }
            }
            if(getLookupProperties().get("@primaryKey@") == null) {
                getLookupProperties().put("@primaryKey@", "id");
                getLookupProperties().put("@PrimaryKey@", "Id");
            }
            if(getLookupProperties().get("@primaryKeyType@") == null) getLookupProperties().put("@primaryKeyType@", "String");
        }
        (new File(newFieldFile)).delete();
        FileUtil.copyFile(srcDir + "/"+ templatePackage + "/tail.xava", src, true);
        FileUtil.replaceFromProperties(src, getLookupProperties());
    }
 }
