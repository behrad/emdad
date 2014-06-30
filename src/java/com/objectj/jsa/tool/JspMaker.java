/*
 * JspMaker.java
 *
 * Created on Feb 05, 2003, 1:42 AM
 */

package com.objectj.jsa.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class JspMaker {

    protected static Logger log = Logger.getLogger(JspMaker.class.getName());

    public static final String ROW_SET_NAME_KEY = "rowset.name";
    public static final String BEAN_WRITE_NAME_KEY = "bean.write.name";
    public static final String BEAN_MESSAGE_PREFIX_KEY = "bean.message.prefix";
    public static final String BEAN_MESSAGE_POSTFIX_KEY = "bean.message.postfix";
    public static final String START_REMOVE_FROM_JSP = "<% // start removing from jsp %>";
    public static final String END_REMOVE_FROM_JSP = "<% // end removing from jsp %>";
    public static final String DEFAULT_BEAN_NAME = "";
    public static final String KEYS_PROPERTIES_FILE_NAME = "keys.properties";
    public static final String KEYS_PROPERTIES_EXTENSION = ".keys.properties";
    public static final String MESSAGES_PROPERTIES_EXTENSION = ".messages.properties";
    public static final String NOT_EXIST_OR_NOT_FOLDER = " doesn't exist or is not a folder";
    public static final String NOT_EXIST = " doesn't exist ";

    private Properties lookupPropertie;
    private Properties appResourcePropertie;
    private File appResourcePropertieFile;
    private HashSet immuneList;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "JspMaker htmlFolder, immuneNames", log);
        JspMaker jspMaker = new JspMaker();
        jspMaker.setImmuneNames(args[1]);
        jspMaker.makeLoginJsp();
        jspMaker.makeThanksJsp();
        jspMaker.makeErrorJsp();
        jspMaker.makeJsp(args[0]);
        jspMaker.getAppResourcesProperties().store(new FileOutputStream(jspMaker.getAppResourcesPropertiesFile()), null);
        log.debug("done");
    }

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }

    public void makeLoginJsp()throws IOException{

	    //making login.jsp
        String topPath = (String) getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");

		String templateFile2 = srcDir + "/com/objectj/jsa/model/jsp/login.xsp";
		String destFileName2 = srcDir + "/" + topPath + "/jsp/login.jsp";

		FileUtil.makeFromTemplate(templateFile2, destFileName2);
	}

    public void makeThanksJsp()throws IOException{

	    //making login.jsp
        String topPath = (String) getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");

		String templateFile2 = srcDir + "/com/objectj/jsa/model/jsp/thanks.xsp";
		String destFileName2 = srcDir + "/" + topPath + "/jsp/thanks.jsp";

		FileUtil.makeFromTemplate(templateFile2, destFileName2);
	}

    public void makeErrorJsp()throws IOException{

	    //making login.jsp
        String topPath = (String) getLookupProperties().get("@top.path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");

		String templateFile2 = srcDir + "/com/objectj/jsa/model/jsp/error.xsp";
		String destFileName2 = srcDir + "/" + topPath + "/jsp/error.jsp";

		FileUtil.makeFromTemplate(templateFile2, destFileName2);
	}
    public void makeJsp(
    String htmlFolderName
    ) throws Exception {
        File htmlFolder = new File(htmlFolderName);
        //log.info(htmlFolder);
        if(!htmlFolder.exists() || !htmlFolder.isDirectory()) {
            log.warn(htmlFolder + NOT_EXIST_OR_NOT_FOLDER);
            return;
        }
        String jspFolderName = htmlFolderName.replaceAll("html", "jsp");
        File jspFolder = new File(jspFolderName);
        //log.info(jspFolder);
        if(!jspFolder.exists() || !jspFolder.isDirectory()) {
            String create_jsp_folder = System.getProperty("create_jsp_folder");
            //log.info(create_jsp_folder);
            if(create_jsp_folder != null && create_jsp_folder.equalsIgnoreCase("flase")) {
                log.warn(jspFolder + NOT_EXIST_OR_NOT_FOLDER);
                return;
            } else {
                (new File(jspFolderName)).mkdirs();
            }
        }
        String packageName = (String)getLookupProperties().get("@top.package@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");

        String templateFolder = srcDir + "/com/objectj/jsa/web/jsp";
        //String parent = srcDir + "/" + packageName + "/web/jsp";

        String headerJspFileName = htmlFolderName + "/head.jsp";
        if( !(new File(headerJspFileName)).exists() ) headerJspFileName = templateFolder + "/head.jsp";
        String excelHeaderJspFileName =  templateFolder + "/excel_head.jsp";
        String footerJspFileName = htmlFolderName + "/foot.jsp";
        if( !(new File(footerJspFileName)).exists() ) footerJspFileName = templateFolder + "/foot.jsp";
        String[] files = htmlFolder.list();
        log.debug("Found " + files.length + " files");
        for(int index =0; index != files.length; index++) {
            File file = new File(htmlFolder, files[index]);
            //if(file.toString().indexOf("html") != -1) {
                log.debug("file " + file + " isDir " + file.isDirectory());
                if(file.isDirectory()) {
                    log.debug("Checking folder " + files[index]);
                    makeJsp(file.toString());
                }
                else {
                    int end = files[index].lastIndexOf(".htm");
                    if(end != -1) {
                        String app = files[index].substring(0, end);
                        if (!files[index].endsWith(".report.htm"))
                            makeJspNow(app, htmlFolderName + "/" + files[index], jspFolderName + "/" + app + ".jsp", headerJspFileName, footerJspFileName, htmlFolderName + "/properties");
                        else
                        {
                            //log.info ("making report jsp file for:" + files[index]);
                            makeJspNow(app, htmlFolderName + "/" + files[index], jspFolderName + "/" + app + ".jsp", excelHeaderJspFileName, footerJspFileName, htmlFolderName + "/properties");
                        }
                    }
                    else { // for now do nothing but lter you can copy that to jsp folder
                        log.debug(files[index] + " is not html or html: ignoring it");
                        //log.info(files[index] + " is not html: copy it to jsp folder");
                        //String fileName = files[index].toString().replaceAll(htmlFolderName, jspFolderName)
                        //FileUtil.copyFile(files[index], jspFolderName + "/" +
                    }
                }
            //}
        }
    }

    public void makeJspNow(
        String pageName,
        String htmlPage,
        String jspPage,
        String headerPage,
        String footerPage,
        String propFolder
        ) throws Exception
    {

        File htmlFile = new File(htmlPage);
        if(isImmune(htmlFile)) {
            log.warn(htmlFile + " is immune to generation ");
            return;
        }
        File jspFile = new File(jspPage);
        if(jspFile.exists()) {
            //log.info("Jsp file " + jspFile + " is newer than html file " + htmlFile + " ignoring the conversion");
            return;
        }
        else {
            log.info("Converting " + htmlFile + " to " + jspFile);
        }
        createInitialJsp(htmlPage, jspPage, headerPage, footerPage);
        createStrutsMessage(jspPage, propFolder + "/" + pageName + MESSAGES_PROPERTIES_EXTENSION);

        String srcDir = (String)getLookupProperties().get("@src.dir@");
        FileUtil.replaceFromPropertiesFile(jspPage, srcDir + "/com/objectj/jsa/web/jsp/" + KEYS_PROPERTIES_FILE_NAME);
        FileUtil.replaceFromPropertiesFile(jspPage, propFolder + "/" + KEYS_PROPERTIES_FILE_NAME);
        FileUtil.replaceFromPropertiesFile(jspPage, propFolder + "/" + pageName + KEYS_PROPERTIES_EXTENSION);
        //JspMaker.createStrutsRowSetCustomeTag(jspPage, propFolder + "/" + pageName + ".custom.rowset.properties");
        File propDir = new File(propFolder);
        File[] list;
        String beanPropStartName = pageName + ".bean.";
        //log.info("propDir " + propDir);
        //log.info("beanPropStartName " + beanPropStartName);
        if(propDir.exists() && propDir.isDirectory() && (list = propDir.listFiles()).length != 0) {
            for(int index=0, start=0, end=0; index != list.length; index++) {
                String fileName = list[index].toString();

                if( (start = fileName.lastIndexOf(beanPropStartName)) != -1 && (end = fileName.lastIndexOf(".properties")) != -1) {
                    start += beanPropStartName.length();
                    String beanName = (end > start) ? fileName.substring(start, end) : DEFAULT_BEAN_NAME;
                    //log.info("------- found " + fileName + " with bean " + beanName + " " + start + " " + end);
                    createStrutsBeanWrite(jspPage, fileName, beanName);
                }
            }
        }
    }
    /*
    public void createStrutsRowSetCustomeTag(String jspFileName, String propsFileName) throws IOException {
        File file = new File(jspFileName);
        if(!file.exists() || !(new File(propsFileName)).exists()) {
            log.info("Ignoring properties file " + propsFileName + ". it doesnt exist.");
            return;
        }
        Properties props = new Properties();
        props.load(new FileInputStream(propsFileName));
        createStrutsRowSetCustomeTag(file, props);
    }


   public void createStrutsRowSetCustomeTag(File file, Properties props) throws IOException {
        String tag_start = "<rs:rowset rsName=\"";
        String tag_middle = "";
        String tag_end = "\" styleBase=\"rs_basic\" sortImage=\"../images/gen_images/sort_arrow\"/>";
        String name = "";
        createStrutsTag(file, props, name, tag_start, tag_middle, tag_end);
    }
     */
    public void createStrutsMessage(
    File file,
    Properties props
    ) throws IOException {

        String prefix = (String)props.remove(BEAN_MESSAGE_PREFIX_KEY);
        prefix = prefix == null ? "" : prefix + ".";
        String postfix =  (String)props.remove(BEAN_MESSAGE_POSTFIX_KEY);
        postfix = postfix == null ? "" : "." + postfix;

        String tag_start = "<bean:message key=\"";
        //String tag_start = "<i18n:message key=\"";
        String tag_end = "\"/>";

        for(Iterator iter = props.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            String token = (String)props.get(key);
            String value = key;
            if (value.indexOf(EntityBeanMaker.STRING_LENGTH_EXTENSION)!= -1) {
                StringBuffer sb = new StringBuffer(value);
                value = sb.replace(value.indexOf(EntityBeanMaker.STRING_LENGTH_EXTENSION), value.indexOf("$") + 1, "").toString();
            }
            try {
                Integer.parseInt(key);
                // if it is a number we create the following value
                value = prefix + token.replace(' ', '_') + postfix;
            } catch(Exception exception) {}
            FileUtil.replaceToken(FileUtil.unicode2native(token), file, tag_start + value + tag_end);
            if(getAppResourcesProperties().get(value) == null) getAppResourcesProperties().put(value, token);
        }
    }
    public void createStrutsMessage(
    String jspFileName,
    String propsFileName
    )  throws IOException {
        /*
       if( !(new File(propsFileName)).exists()) {
            log.info(propsFileName + NOT_EXIST );
            return;
        }*/
        File file = new File(jspFileName);
        Properties props = new Properties();
        if( (new File(propsFileName)).exists()) props.load(new FileInputStream(propsFileName));
        createStrutsMessage(file, props);
    }
    public void createStrutsBeanWrite(String jspFileName, String propsFileName, String beanName)  throws IOException {
        File file = new File(jspFileName);
        if(!file.exists() || !(new File(propsFileName)).exists()) return;
        Properties props = new Properties();
        props.load(new FileInputStream(propsFileName));
        createStrutsBeanWrite(file, props, beanName);
    }
    public void createStrutsBeanWrite(File file, Properties props, String beanName) throws IOException {
        String tag_start = "<bean:write name=\"";
        String tag_middle = "\" property=\"";
        String tag_end = "\"/>";
        //String beanName = (String)props.remove(BEAN_WRITE_NAME_KEY);
        //beanName = beanName == null ? "valueObject" : beanName;

        createStrutsTag(file, props, beanName, tag_start, tag_middle, tag_end);

    }

    public void createStrutsTag(File file, Properties props, String name, String tag_start, String tag_middle, String tag_end) throws IOException {
        for(Iterator iter = props.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            String token = (String)props.get(key);
            token = (token == null || token.trim().length() == 0) ? key : token;
            String value = key;
            if(token != null && token.length() != 0) FileUtil.replaceToken(token, file, tag_start + name + tag_middle +  value + tag_end);
        }
    }
    public File getAppResourcesPropertiesFile() throws IOException {
        if(appResourcePropertieFile == null) {
            String rscFolder = (String)System.getProperty("application-resources.dir");
            appResourcePropertieFile = new File(rscFolder + "/ApplicationResources.properties");
            if(!appResourcePropertieFile.exists()) {
                log.warn(appResourcePropertieFile + " didn't exist so we create a new folder");
                appResourcePropertieFile.getParentFile().mkdirs();
                new FileOutputStream(appResourcePropertieFile).close();
            }
        }
        return appResourcePropertieFile;
    }
    public Properties getAppResourcesProperties() throws IOException {
        if(appResourcePropertie == null) {
            appResourcePropertie = new Properties();
            appResourcePropertie.load(new FileInputStream(getAppResourcesPropertiesFile()));

            String srcDir = (String)getLookupProperties().get("@src.dir@");
            File propFile = new File(srcDir + "/com/objectj/jsa/web/jsp/ApplicationResources.properties");
            Properties tmpProp = new Properties();
            if(propFile.exists()) {
                tmpProp.load(new FileInputStream(propFile));
            }



            for(Iterator iter = tmpProp.keySet().iterator(); iter.hasNext(); ) {
                Object key = iter.next();
                Object value = tmpProp.get(key);
                appResourcePropertie.put(key, value);
                //log.info("Adding " + key + " " + value + " from common to App Resouces");
            }
            //htmlFolderName + "/properties", appResourceFolderName + "/ApplicationResources.properties"
        }
        return appResourcePropertie;
    }


    public static String getEncoding() {
        String encoding = System.getProperty("file.encoding");
        if(encoding == null) encoding = "UTF-8";
        return encoding;
    }

    public void createInitialJsp(String htmlFileName, String jspFileName, String headerFileName, String footerFileName) throws IOException {
        if(headerFileName != null && (new File(headerFileName)).exists()) {
            String tmpFile = jspFileName + ".tmp";
            if(htmlFileName.toLowerCase().endsWith(".htm")) FileUtil.copyFile(headerFileName, tmpFile, false);
            FileUtil.copyFile(htmlFileName, tmpFile, true);
            if(htmlFileName.toLowerCase().endsWith(".htm")) FileUtil.copyFile(footerFileName, tmpFile, true);

            BufferedReader in = FileUtil.getBufferedReader(tmpFile, getEncoding());
            PrintWriter out = FileUtil.getPrintWriter(jspFileName, getEncoding());
            // removing the lines between START_REMOVE_FROM_JSP & END_REMOVE_FROM_JSP
            String line;
            while( (line = in.readLine()) != null) {
                if(line.indexOf(START_REMOVE_FROM_JSP) != -1) {
                    while( (line = in.readLine()) != null && line.indexOf(END_REMOVE_FROM_JSP) != -1); // ignore the line
                }
                else {
                    out.println(line);
                }
            }
            out.close();
            in.close();
            (new File(tmpFile)).delete();

        } else {
            log.warn("headerFileName = " + headerFileName + " doesnt exist");
            FileUtil.copyFile(htmlFileName, jspFileName, false);
        }
    }


    public HashSet getImmuneList() {
        if(immuneList == null) {
            immuneList = new HashSet();
        }
        return immuneList;
    }
    public boolean isImmune(File file) {
        for(Iterator iter = immuneList.iterator(); iter.hasNext(); ) {
            if(file.toString().indexOf(iter.next().toString()) != -1) return true;
        }
        return false;
    }
    public void setImmuneNames(String immuneNames) {
        if(immuneNames != null && immuneNames.length() != 0){
            StringTokenizer stk = new StringTokenizer(immuneNames, ", ");
            while(stk.hasMoreTokens()) getImmuneList().add(stk.nextToken());
        }
    }

}
