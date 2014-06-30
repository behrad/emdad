package com.objectj.jsa.tool;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 *
 * @author Hossein Akhlaghpour
 */
public class ProxyMaker2 {

    protected static Logger log = Logger.getLogger(ProxyMaker2.class.getName());

    public static final String LIGHT_EXTENSION = " - light";
    public static final String PK_EXTENSION = " - primaryKey";
    public static final String IDENTIFIER = ".entitybean.properties";

    private Properties lookupPropertie;

    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "FormBeanMaker propertiesFileName", log);
//        (new ProxyMaker2()).makeProxyNow(args[0]);

        log.debug("done");
    }

    public Properties getLookupProperties() {
        if (lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }

    public String getEntityNames(String topPropFolderName) throws IOException {
        String s = getEntityNames2(topPropFolderName);
        if (s.length() > 0) return s.substring(1); else return s;

    }

    public String getEntityNames2(String topPropFolderName) throws IOException {
        String[] files;
        File topPropFolder = new File(topPropFolderName);
        if (!topPropFolder.exists() || !topPropFolder.isDirectory() || (files = topPropFolder.list()).length == 0) {
            log.warn(topPropFolder + " doesn't exist or is not a directory or is empty");
            return "";
        }
        String modelNames = "";
        for (int index = 0; index != files.length; index++) {
            File file = new File(topPropFolder, files[index]);
            log.debug("file " + file + " isDir " + file.isDirectory());
            if (file.isDirectory()) {
                log.debug("Checking folder " + files[index]);
                modelNames += getEntityNames2(file.toString());
            } else {
                String fileName = file.toString();
                if (fileName.endsWith(IDENTIFIER)) {
                    FileUtil.updateLookupProperties(getLookupProperties(), fileName, IDENTIFIER);
                    String beanName = (String) getLookupProperties().get("Xxx");
                    log.info(beanName);
                    modelNames += ", " +beanName + "Model.class";
//                    makeProxyNow(file);
                }
            }
        }
        return modelNames;
    }

    public void makeProxyNow(String arg) throws IOException {
        String s = getEntityNames(arg);

        getLookupProperties().put("@ModelClasses@", s);
        String topPath = (String) getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");
        getLookupProperties().put("@Xxx@", "Xxx");

        String templateFile = srcDir + "/com/objectj/jsa/proxy/ProxyBean.xava";
        String destFileName = srcDir + "/" + topPath + "/proxy/ProxyBean.java";
        if (new File(destFileName).exists()) {
            log.info("ProxyBean exists, no touch!");
            return;
        }
        //=-= //=-= //=-= System.out.println("destFileName = " + destFileName);
        FileUtil.copyFile(templateFile, destFileName, false);
        //=-= //=-= //=-= System.out.println("--------" + new File(destFileName).getAbsolutePath());
        FileUtil.replaceFromProperties(destFileName, getLookupProperties());

	   //making login.jsp
//		String templateFile2 = srcDir + "/com/objectj/jsa/model/jsp/login.xsp";
//		String destFileName2 = srcDir + "/" + topPath + "/jsp/login.jsp";
//
//		FileUtil.makeFromTemplate(templateFile2, destFileName2);

//        FileUtil.makeFromTemplate(templateFile, destFileName);

    }
//
//        if (!propsFile.exists()) {
//            log.warn(propsFile + " doesn't exist");
//            return;
//        }
//        log.debug("loading properties file " + propsFile);
//        Properties propsFromFile = new Properties();
//        propsFromFile.load(new FileInputStream(propsFile));
//
//        StringBuffer keyProps = new StringBuffer("#---------------\n");
//
//        String topPath = (String) getLookupProperties().get("@top.path@");
//        String srcDir = (String) getLookupProperties().get("@src.dir@");
//        String beanName = (String) getLookupProperties().get("Xxx");
//        beanName = beanName.toLowerCase().substring(0, 1) + beanName.substring(1);
//        getLookupProperties().put("xxx", beanName);
//        String parent = srcDir + "/" + topPath + "/html";
//        String overwrite = System.getProperty("overwrite");
//
//        String htmlEdit = parent + "/" + beanName + ".edit.htm";
//        log.debug("Writin to " + htmlEdit);
//        File htmlEditFile = new File(htmlEdit);
//        if (htmlEditFile.exists() && htmlEditFile.lastModified() > propsFile.lastModified()) {
//            log.debug("Form Bean file " + htmlEditFile + " is newer than properties file " + propsFile + " ignoring the Form bean generation");
//            return;
//        } else {
//            log.info("Generating " + htmlEditFile + " from " + propsFile);
//        }
//
//
//        String htmlRead = parent + "/" + beanName + ".read.htm";
//        File htmlReadFile = new File(htmlRead);
//        String htmlList = parent + "/" + beanName + ".list.htm";
//        File htmlListFile = new File(htmlList);
//
//
//        if ((overwrite == null || overwrite.equalsIgnoreCase("false")) && htmlEditFile.exists()) htmlEdit += ".generated";
//        if ((overwrite == null || overwrite.equalsIgnoreCase("false")) && htmlReadFile.exists()) htmlRead += ".generated";
//        if ((overwrite == null || overwrite.equalsIgnoreCase("false")) && htmlListFile.exists()) htmlList += ".generated";
//
//
//        String templatePackage = "com/objectj/jsa/model/html";
//        FileUtil.copyFile(srcDir + "/" + templatePackage + "/edit_head.xtml", htmlEdit, false);
//        FileUtil.copyFile(srcDir + "/" + templatePackage + "/read_head.xtml", htmlRead, false);
//
//        String newFieldFileEdit = parent + "/tmp-edit.xtml";
//        String newFieldFileRead = parent + "/tmp-read.xtml";
//
//        BufferedWriter listBufferedWriter = new BufferedWriter(new FileWriter(htmlListFile));
//        listBufferedWriter.write("<form method=\"post\" action=\"/" + beanName + "\">\n" +
//                "  <table width=\"100%\">\n" +
//                "    <tbody>\n" +
//                "    <tr>\n" +
//                "      <td align=left>\n" +
//                "		<table width=\"100%\" border=\"0\">\n" +
//                "          <tr>\n" +
//                "            <td>remove</td>");
//        StringBuffer listValues = new StringBuffer();
//
//        String pkKey = null, pkReadKey = null;
//        for (Iterator iter = propsFromFile.keySet().iterator(); iter.hasNext();) {
//            String key = (String) iter.next();
//            String value = (String) propsFromFile.get(key);
//            if (value != null && value.length() != 0) {
//                getLookupProperties().put("@type@", value);
//                getLookupProperties().put("@field@", key);
//                getLookupProperties().put("@Field@", key.toUpperCase().substring(0, 1) + key.substring(1));
//                String readKey = beanName + key + (int) (Math.random() * 100);
//                keyProps.append(readKey + "=<bean:write property=\"" + key + "\" name=\"value_object\"/>\n");
//                getLookupProperties().put("@Key@", readKey);
////                if (value.endsWith(PK_EXTENSION)) {
////                    keyProps.append("&id\\=" + readKey + "\"=\" paramId=\"id\" paramName=\"value_object\"  paramProperty=\"id\"\n");
////                    pkKey = key;
////                    pkReadKey = readKey;
////                }
//                FileUtil.copyFile(srcDir + "/" + templatePackage + "/edit_field.xtml", newFieldFileEdit, false);
//                FileUtil.copyFile(srcDir + "/" + templatePackage + "/read_field.xtml", newFieldFileRead, false);
//                FileUtil.replaceFromProperties(newFieldFileEdit, getLookupProperties());
//                FileUtil.replaceFromProperties(newFieldFileRead, getLookupProperties());
//                FileUtil.copyFile(newFieldFileEdit, htmlEdit, true);
//                FileUtil.copyFile(newFieldFileRead, htmlRead, true);
//
//                listBufferedWriter.write("            <td>" + key + "</td>\n");
//                listValues.append("            <td>" + readKey + "</td>\n");
//
//            }
//        }
//        keyProps.append("&id\\=" + beanName + "Id" + "\"=\" paramId=\"id\" paramName=\"value_object\"  paramProperty=\"id\"\n");
//
//        FileUtil.copyFile(srcDir + "/" + templatePackage + "/edit_tail.xtml", htmlEdit, true);
//        FileUtil.copyFile(srcDir + "/" + templatePackage + "/read_tail.xtml", htmlRead, true);
//        FileUtil.replaceFromProperties(htmlEdit, getLookupProperties());
//        FileUtil.replaceFromProperties(htmlRead, getLookupProperties());
//        (new File(newFieldFileEdit)).delete();
//        (new File(newFieldFileRead)).delete();
//
//        listBufferedWriter.write("            <td>&nbsp;</td>\n" +
//                "          </tr>\n" +
//                "          <logic:iterate id=\"value_object\" name=\"value_object_list\" >\n" +
//                "          <tr>\n" +
//                "            <td> \n" +
//                "              <input type=\"checkbox\" name=\"id\" value=\"checkbox\">\n" +
//                "            </td>\n");
//            listValues.append("            <td> <a href=\"/" + beanName + ".run?action_type=read_by_id&id=" + beanName + "Id" + "\">Details&nbsp;</a>");
//        listValues.append("            <a href=\"/" + beanName + ".run?action_type=edit_by_id&id=" + beanName + "Id" + "\">Edit</a></td>\n" +
//                "          </tr>\n" +
//                "          </logic:iterate>\n" +
//                "        </table>\n" +
//                "        <p>\n" +
//                "          <input type=\"submit\" name=\"action_type\" value=\"Remove\">\n" +
//                "          <input type=\"submit\" name=\"submit\" value=\"Add New one\">\n" +
//                "        </p>\n" +
//                "      </td>\n" +
//                "    </tr>\n" +
//                "    </tbody>\n" +
//                "  </table>\n" +
//                "</form>\n");
//        listBufferedWriter.write(listValues.toString());
//        listBufferedWriter.close();
//
//        new File(parent + "/properties/").mkdirs();
//        String htmlProp = parent + "/properties/keys.properties";
//        log.debug("Writin to " + htmlProp);
//        File htmlPropFile = new File(htmlProp);
//
//        BufferedWriter htmlPropFileWriter = new BufferedWriter(new FileWriter(htmlPropFile, true));
//        htmlPropFileWriter.write(keyProps.append("\n").toString());
//        htmlPropFileWriter.close();
//
//    }


}
