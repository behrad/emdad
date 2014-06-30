/*
 * entityMaker.java
 *
 * Created on February 8, 2003, 11:34 PM
 */

package com.objectj.jsa.tool;

import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;

/**
 *
 * @author Hossein Akhlaghpour
 */
public class Integrator {

    protected static Logger log = Logger.getLogger(Integrator.class.getName());

    private Properties lookupPropertie;

    public static final String VALIDATION_FILE = "validation.xml";
    public static final String TILES_DEFS_FILE = "tiles-defs.xml";
    public static final String NOT_EXIST = " doesn't exist ";

    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "Integrator destFolder, webActionFolder", log);
        (new Integrator()).Browse (args[0], args[1]);
        log.debug("done");
    }

    //*******************************************************************

    public void Browse (String destFolder, String srcFolderName) throws Exception {
        File srcFolder = new File(srcFolderName);
        String[] files;
        if(!srcFolder.exists() || !srcFolder.isDirectory() || (files = srcFolder.list()).length == 0) {
            log.warn(srcFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        for(int index =0; index != files.length; index++) {
            File file = new File(srcFolder, files[index]);
            String fileName = file.toString();

            if(fileName.endsWith(VALIDATION_FILE)) {
                FileUtil.updateLookupProperties(getLookupProperties(), fileName, VALIDATION_FILE);
                appendValidation(fileName, destFolder);
            }

            else if (fileName.endsWith(TILES_DEFS_FILE)) {
                FileUtil.updateLookupProperties(getLookupProperties(), fileName, TILES_DEFS_FILE);
                appendTilesDefs(fileName, destFolder);
            }
        }
    }

    //*******************************************************************

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }

    //*******************************************************************

    private void appendValidation (String fileName, String destFolder) throws IOException {
        //String topPath = (String)getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        //String beanName = (String)getLookupProperties().get("Xxx");
        //String name = (String)getLookupProperties().get("xxx");

        String securPropFileName = fileName;
        File securPropFile = new File(securPropFileName);
        if(!securPropFile.exists()) {
             log.warn(securPropFile + " doesn't exist");
             return;
        }
        //log.info("loading properties file " + securPropFile);
        Properties propsFromFile = new Properties();
        propsFromFile.load(new FileInputStream(securPropFile));
        String templateFolder = srcDir + "/com/objectj/jsa/web/action/";

        ////=-= //=-= //=-= System.out.println ("---------------->  INCLUDNG VALIDATION FILE: " + fileName);
        FileUtil.includeFileContent(templateFolder + VALIDATION_FILE, fileName, destFolder + "/" + VALIDATION_FILE);

    }

    //*******************************************************************

    private void appendTilesDefs (String fileName, String destFolder) throws IOException {
        //String topPath = (String)getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        //String beanName = (String)getLookupProperties().get("Xxx");
        //String name = (String)getLookupProperties().get("xxx");

        String securPropFileName = fileName;
        File securPropFile = new File(securPropFileName);
        if(!securPropFile.exists()) {
             log.warn(securPropFile + " doesn't exist");
             return;
        }
        //log.info("loading properties file " + securPropFile);
        Properties propsFromFile = new Properties();
        propsFromFile.load(new FileInputStream(securPropFile));
        String templateFolder = srcDir + "/com/objectj/jsa/web/action/";

        FileUtil.includeFileContent(templateFolder + TILES_DEFS_FILE, fileName, destFolder + "/" + TILES_DEFS_FILE);

    }
}
