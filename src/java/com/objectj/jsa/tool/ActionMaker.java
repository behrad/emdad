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


public class ActionMaker {

    protected static Logger log = Logger.getLogger(ActionMaker.class.getName());

    private Properties lookupPropertie;

    public static final String IDENTIFIER = ".action.properties";
    public static final String IDENT = ".security.properties";
    public static final String VALIDATION_FILE = "validation.xml";
    public static final String TILES_DEFS_FILE = "tiles-defs.xml";
    public static final String NOT_EXIST = " doesn't exist ";
    public static final String ENTITY_SPEC = ".entity.spec";
    private static HashSet immuneList = null;


    //*******************************************************************



    public static void main(String[] args) throws Exception, EntitySpecException {
        FileUtil.checkForRightNumberOfArgs(args, "ActionMaker destFolder, srcFolderName, immuneNames", log);
        (new ActionMaker()).makeWebFiles(args[0], args[1], args[2]);
        log.debug("done");
    }


    //*******************************************************************



    public void makeWebFiles(String destFolder, String specFolderName, String immuneNames) throws Exception, EntitySpecException {
        log.debug("kambeezam man");


        File specFolder = new File(specFolderName);
        String[] specFiles;
        if(!specFolder.exists() || !specFolder.isDirectory() || (specFiles = specFolder.list()).length == 0) {
            log.warn(specFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        if(immuneNames != null && immuneNames.length() != 0) {
            StringTokenizer stk = new StringTokenizer(immuneNames, ", ");
            while(stk.hasMoreTokens()) getImmuneList().add(stk.nextToken());
        }

        log.debug("Found " + specFiles.length + " files");
        for(int index =0; index != specFiles.length; index++) {
            File file = new File(specFolder, specFiles[index]);
            log.debug("file " + file + " isDir " + file.isDirectory());
            if(file.isDirectory()) {
                log.debug("Checking folder " + specFiles[index]);
                makeWebFiles(destFolder, file.toString(), immuneNames);
            }
            else {
                String fileName = file.toString();
                if(fileName.endsWith(ENTITY_SPEC)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), fileName, ENTITY_SPEC);
                    makeWebFilesNow(fileName, file.lastModified());
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


    private void makeWebFilesNow(String specFileName, long modifiedDate) throws IOException, EntitySpecException {
        String topPath = (String)getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        String BeanName = (String)getLookupProperties().get("Xxx");
        String beanName = (String)getLookupProperties().get("xxx");
        String sortableAttributes = "";

        //String parent = srcDir + "/" + topPath + "/ejb";
        String templatePackage = "com/objectj/jsa/web/action";

        String actionFileName = srcDir + "/" + topPath + "/web/action/" + BeanName + "Action.java";
        File actionFile = new File(actionFileName);

        if(actionFile.exists()) {
            //log.info("action file: " + actionFileName + " exists, ignoring generation.");
        }

        else {
            //**********************************  Sortables   ***************************************
            File specFile = new File (specFileName);
            Attribute attribute;
            EntitySpecProcessor specProcessor = new EntitySpecProcessor (specFileName);

            if (specFile.exists())
            {
                specProcessor.initIterator();
                while ((attribute = specProcessor.getNextAttribute()) != null)
                {
                    if (attribute.isSortable())
                        sortableAttributes += "\"" + attribute.getName() + "\", ";
                }

                sortableAttributes = sortableAttributes.substring(0,sortableAttributes.lastIndexOf(','));
                ////=-= //=-= //=-= System.out.println ("--------------------------------------" + sortableAttributes + "-------------------------------------------");
            }

            else
            {
                log.info ("non-existent spec file:" + specFileName);
            }

            getLookupProperties().put("xsortableAttributesx", sortableAttributes);
            //***************************************************************************************


            //************************ Creating XxxAction.java **********************************
            log.info("Generating " + actionFile);
            FileUtil.copyFile(srcDir + "/"+ templatePackage + "/XxxActionHead.xava", actionFileName, false);
            FileUtil.copyFile(srcDir + "/"+ templatePackage + "/XxxActionTail.xava", actionFileName, true);
            FileUtil.replaceFromProperties(actionFileName, getLookupProperties());
        }



        //************************ Creating XxxForm.java **********************************
        String formFileName = srcDir + "/" + topPath + "/web/action/" + BeanName + "Form.java";

        File formFile = new File(formFileName);
        if(formFile.exists()) {
            //log.info("Form file: " + formFileName + " exists, ignoring generation.");
        }

        else {
            log.info("Generating " + formFile);
            FileUtil.copyFile(srcDir + "/"+ templatePackage + "/XxxForm.xava", formFileName, false);
            FileUtil.replaceFromProperties(formFileName, getLookupProperties());
        }
        //*********************** End of Creating XxxForm.java ****************************

        //************************ Creating xxx.tiles-defs.xml ****************************
        String templateFile = srcDir + "/com/objectj/jsa/web/action/xxx.tiles-defs.xml";
        String destFileName = srcDir + "/" + topPath + "/web/action/" + beanName + ".tiles-defs.xml";
        if (!(new File(destFileName).exists())) {
            FileUtil.makeFromTemplate(templateFile, destFileName, getLookupProperties(), modifiedDate);
        }
        //******************* End of Creating xxx.tiles-defs.xml **************************
     }


    //*******************************************************************


    public static HashSet getImmuneList() {
        if(immuneList == null) {
            immuneList = new HashSet();
        }
        return immuneList;
    }
    public static boolean isImmune(File file) {
        for(Iterator iter = immuneList.iterator(); iter.hasNext(); ) {
            if(file.toString().indexOf(iter.next().toString()) != -1) return true;
        }
        return false;
    }

}
