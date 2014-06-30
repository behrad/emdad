
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
 * @author Salar Mesdaghinia
 */
public class SessionEJBMaker {

    protected static Logger log = Logger.getLogger(SessionEJBMaker.class.getName());
    private Properties lookupPropertie;

    public static final String NOT_EXIST = " doesn't exist ";
    public static final String ENTITY_SPEC = ".entity.spec";


    //*******************************************************************


    public static void main(String[] args) throws Exception, EntitySpecException {
        log.debug ("Generating XxxSessionEJB files");
        //FileUtil.checkForRightNumberOfArgs(args, "SessionEJBMaker destFolder, specFolder", log);
        if (args.length < 1){
            log.error ("Too few parameters in calling SessionEJBMaker.main");
        }

        (new SessionEJBMaker()).makeSessionEJBFiles(args[0]);
        log.debug("done");
    }


    //*******************************************************************


    public void makeSessionEJBFiles(String specFolderName) throws Exception, EntitySpecException
    {
        log.info("Generating SessionEJB files");
        File specFolder = new File(specFolderName);
        String[] specFiles;
        if(!specFolder.exists() || !specFolder.isDirectory() || (specFiles = specFolder.list()).length == 0) {
            log.warn(specFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        log.debug("Found " + specFiles.length + " files");
        for(int index =0; index != specFiles.length; index++) {
            File specFile = new File(specFolder, specFiles[index]);
            log.debug("file " + specFile + " isDir " + specFile.isDirectory());
            if(specFile.isDirectory()) {
                log.debug("Checking folder " + specFiles[index]);
                makeSessionEJBFiles(specFile.toString());
            }
            else {
                String specFileName = specFile.toString();
                if(specFileName.endsWith(ENTITY_SPEC)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), specFileName, ENTITY_SPEC);
                    makeSessionEJBFileNow();
                }
            }
        }
    }


    //*******************************************************************

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }

    //*******************************************************************

    private void makeSessionEJBFileNow() throws IOException {
        String topPath = (String)getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        String beanName = (String)getLookupProperties().get("Xxx");


        //*********************************************************************************
        //************************ Creating XxxSessionEJB.java ****************************
        //*********************************************************************************

        String sessionEJBFileName = srcDir + "/" + topPath + "/proxy/" + beanName + "SessionEJB.java";
        File sessionEJBFile = new File(sessionEJBFileName);

        if(sessionEJBFile.exists()) {
            //log.info(sessionEJBFileName + " exists, ignoring form generation.");
        } else {
            log.info("Generating " + sessionEJBFile + " ...");
            FileUtil.copyFile(srcDir + "/"+ "com/objectj/jsa/proxy" + "/XxxSessionEJB.xava", sessionEJBFileName, false);
            FileUtil.replaceFromProperties(sessionEJBFileName, getLookupProperties());
        }

        //************************ End Creating XxxSessionEJB.java ******************************

    }

}
