/*
 * FileUtil.java
 *
 * Created on Feb 05, 2003, 1:42 AM
 */

package com.objectj.jsa.tool;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Replace;

public class FileUtil {

    protected static Logger log = Logger.getLogger(FileUtil.class.getName());

    public static final String PLACE_HOLDER = "<!-- place_holder -->";


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        if(args.length != 3) {
            log.error("\n"
            + " Wrong number of arguments: Aborting the operation ...\n"
            + " EntityBeanMaker Usage:\n"
            + "     FileUtil inputFile outPutFile doAppend"
            );
            return;
        }
        copyFile(args[0], args[1], !args[2].equals("false"));
        log.debug("done");
    }

    public static BufferedReader getBufferedReader(String fileName, String encoding) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader in = new InputStreamReader(fis, encoding);
        return new BufferedReader(in);
    }

    public static PrintWriter getPrintWriter(String fileName, String encoding) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter out = new OutputStreamWriter(fos, encoding);
        return new PrintWriter(out);
    }

    public static void convertEncoding(String inputFileName, String inputEncoding, String outputFileName, String outputEncoding) throws IOException {
        BufferedReader in = FileUtil.getBufferedReader(inputFileName, inputEncoding);
        PrintWriter out = FileUtil.getPrintWriter(outputFileName, outputEncoding);
        String line;
        while( (line = in.readLine()) != null) {
            out.println(line);
        }
        out.close();
        in.close();
    }

    public static String unicode2native(String uniString) {
        StringBuffer result = new StringBuffer();
        for(int indx=0 ; indx != uniString.length(); indx++) {
            char c = uniString.charAt(indx);
            if(c < 128) {
                result.append(c);
            } else {
                String hexString = Integer.toHexString(c);
                while(hexString.length() < 4) hexString = '0' + hexString;
                result.append("\\u" + hexString);
            }
        }
        return result.toString();
    }

    public static void replaceToken(String token, File file, String value) {
        Project  project = new Project();
        project.init();
        Replace replace = new Replace();
        //replace.setEncoding("UTF-8");
        replace.setFile(file);
        replace.setToken(token);
        replace.setValue(value);
        replace.setProject(project);
        replace.execute();
    }
 /*
    public static void native2ascii(String token) {
        Project  project = new Project();
        project.init();
        Native2Ascii native2Ascii = new Native2Ascii();
        //native2Ascii.setEncoding("UTF-8");
        native2Ascii.setSrc(file);
        native2Ascii.setToken(token);
        native2Ascii.setValue(value);
        native2Ascii.setProject(project);
        native2Ascii.execute();
    }*/

    public static void replaceFromPropertiesFile(String fileName, String PropFileName) throws IOException {
        if(!(new File(PropFileName)).exists()) return;
        Properties props = new Properties();
        props.load(new FileInputStream(PropFileName));
        log.debug(" reading from pro file " + PropFileName);
        replaceFromProperties(fileName, props);
    }

    public static void replaceFromProperties(String fileName, Properties props) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) return;
        if(props == null) props = FileUtil.createLookupProperties();
        for(Iterator iter = props.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            String value = (String)props.get(key);
            log.debug(" replacing " + key + " with " + value);
            if(value != null && value.length() != 0) replaceToken(key, file, value);
        }
    }

    public static void copyFile(File src, File destination, boolean append)
    throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        destination.getParentFile().mkdirs();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination, append));
        copy(in, out);
        in.close();
        out.close();
    }

    public static void copyUtf8File(String src, String destination, boolean append)
    throws IOException {
        File srcFile = new File(src);
        File destinationFile = new File(destination);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
        destinationFile.getParentFile().mkdirs();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationFile, append));
        in.skip(3);
        copy(in, out);
        in.close();
        out.close();
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        while( (len=in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
    }

    public static void copy(Reader in, Writer out) throws IOException {
        char[] chars = new char[1024];
        int len = -1;
        while( (len=in.read(chars)) != -1) {
            out.write(chars, 0, len);
        }
    }
    /** It is being tested abd keep the unicode & characters
     * @param src
     * @param destination
     * @param append
     * @throws IOException
     */
    public static void copyFile(String src, String destination, boolean append)
    throws IOException {
        copyFile(new File(src), new File(destination), append);
    }

    public static String getFileAsString(File src) throws IOException {
        StringWriter out = new StringWriter();
        BufferedReader in = new BufferedReader(new FileReader(src));
        copy(in, out);
        return out.getBuffer().toString();
    }


    public static void makeFromTemplate(String templateFileName, String destFileName) throws IOException {
        makeFromTemplate(templateFileName, destFileName, null);
    }

    public static void makeFromTemplate(String templateFileName, String destFileName, Properties props) throws IOException {
        makeFromTemplate(templateFileName, destFileName, props, 0);
    }

    public static void checkForRightNumberOfArgs(String[] args, String usage, Logger logger) {
        StringTokenizer stk = new StringTokenizer(usage);
        if(args.length == stk.countTokens() - 1) return;
        logger.error(
        "************************************************\n"
        + " Wrong number of arguments: Aborting the operation ...\n"
        );
        if(stk.hasMoreTokens()) {
            String program = stk.nextToken();
            logger.error( "\t" + program + " Usage:\n\t\t" + program);
        }
        while(stk.hasMoreTokens())  log.error(" " + stk.nextToken());
        logger.error("\n**********************************************************\n");
    }


    public static void makeFromTemplate(String templateFileName, String destFileName, Properties props, long modifiedDate) throws IOException {
        File destFile = new File(destFileName);
        //log.info("Generating class " + destFile + " from template " + templateFileName);

        if(destFile.exists() /*&& destFile.lastModified() > modifiedDate */) {
            //log.info(destFile + " exists, ignoring generation. ");
            return;
        }

        //String overwrite = System.getProperty("overwrite");
        //if( (overwrite == null || overwrite.equalsIgnoreCase("false")) && destFile.exists()) destFileName += ".generated";

        FileUtil.copyFile(templateFileName, destFileName, false);
        FileUtil.replaceFromProperties(destFileName, props);
    }


    public static void includeFileContent(String templateFileName, String srcFileName, String destFileName) throws IOException {
        File srcFile = new File(srcFileName);
        File destFile = new File(destFileName);
        //log.error("Source File: " + srcFileName);
        //log.error("Destination File: " + destFile);
        if(!srcFile.exists()) {
            log.error("src file doesnt exist:" + srcFile);
            return;
        }
        Properties touchProp = getTouchProperties(destFileName);
        String touchDate = touchProp.getProperty(srcFileName);
        if(destFile.exists() && touchDate != null && Long.parseLong(touchDate) > srcFile.lastModified()) {
            //log.info(destFile + " is newer than " + srcFileName + ". Abort the creation process. ");
            return;
        }
        //log.info(templateFileName);
        //log.info(destFile);
        //log.info(">>>>" + destFile.exists());
        if(!destFile.exists()) {
            FileUtil.copyFile(templateFileName, destFileName, false);
        }
        String content = FileUtil.getFileAsString(srcFile);
        content += "\n\n" + PLACE_HOLDER;
        Properties prop = new Properties();
        prop.put( PLACE_HOLDER, content);
        FileUtil.replaceFromProperties(destFileName, prop);
        touchProp.put(srcFileName, "" + (new java.util.Date()).getTime());
        FileOutputStream out = new FileOutputStream(getTouchPropertiesFileName(destFileName));
        touchProp.store(out, null);
        out.close();
        //log.info("replaced");

    }

    private static String getTouchPropertiesFileName(String objectFile) {
        return objectFile + ".toucMap";
    }

    public static Properties getTouchProperties(String objectFile) throws IOException {
        File file = new File(getTouchPropertiesFileName(objectFile));
        if(!file.exists()) (new FileOutputStream(file)).close();
        Properties prop = new Properties();
        prop.load(new FileInputStream(file));
        return prop;
    }


    public static void updateLookupProperties(Properties props, String file, String identifer) throws IOException {
        log.debug("our file " + file);
        String srcDir = (String)props.get("@src.dir@");
        int start = file.replace('\\', '/').indexOf(srcDir);
        if(start != -1) {
            String parent = (new File(file)).getParent();
            String path = parent.substring(srcDir.length());
            if(path.replace('\\', '/').startsWith("/")) path =  path.substring(1);
            log.debug("Find path "+ path);

			/*
			//=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Note for Salar  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + file + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + parent + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + path + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("");
			//=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Note for Salar  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			*/

            String name = FileUtil.extractName(file.toString(), identifer);
            name = name.toLowerCase().substring(0, 1) + name.substring(1);
            String Name = name.toUpperCase().substring(0, 1) + name.substring(1);
            log.debug("Find Name "+ Name);
			////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + name + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			////=-= //=-= //=-= System.out.println ("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + Name + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            props.put("Xxx", Name); // name should start with Capital letter
            props.put("xxx", name);
            if(path != null && path.length() > 1) {
                props.put("@path@", path.replace('\\', '/'));
                props.put("@package@", path.replace('\\', '.'));
            }
        }
    }

    public static String extractName(String fileName) {
        return extractName(fileName, null);
    }
    public static String extractName(String fileName, String extension) {
        int start = fileName.replace('\\', '/').lastIndexOf('/');
        int end = extension == null ? fileName.length() : fileName.lastIndexOf(extension);
        if(start != -1 && end > start) {
            return fileName.substring(start+1, end);
        } else return null;
    }

    public static Properties createLookupProperties() {
        Properties lookupProperties = new Properties();

        String srcDir = System.getProperty("src.dir");
        if(srcDir == null) {
            throw new RuntimeException("src.dir should be defined in the properties");
        }
        //log.info(srcDir);

        lookupProperties.put("@author@", System.getProperty("author"));
        lookupProperties.put("@application@", System.getProperty("application"));
        lookupProperties.put("@src.dir@", System.getProperty("src.dir"));
        String topPath = System.getProperty("top.path");
        if(topPath != null && topPath.length() > 1) {
            lookupProperties.put("@top.package@", topPath.replace('/', '.'));
            lookupProperties.put("@package@", topPath.replace('/', '.'));
            lookupProperties.put("@top.path@", topPath);
            lookupProperties.put("@path@", topPath);
        }
        return lookupProperties;
    }
}
