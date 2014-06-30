/**
 * Created by IntelliJ IDEA.
 * User: kambeez
 * Date: Mar 24, 2003
 * Time: 3:14:52 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.util;

import com.objectj.jsa.tool.FileUtil;
import org.apache.log4j.Logger;

import java.io.*;

public class DirtyTorqueSchemaImporter {
    public static final String IDENTIFIER = ".entitybean.properties";

    protected static Logger log = Logger.getLogger(DirtyTorqueSchemaImporter.class.getName());

    public static void main(String[] args) {
        FileUtil.checkForRightNumberOfArgs(args, "DirtyTorqueSchemaImporter <torque-schema.xml> <output-path>", log);
        try {
            importSchema(new File(args[0]), args[1]);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }

    }

    public static void importSchema(File schema, String outputPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(schema));
        String s = "";
        BufferedWriter writer = null;
        while ((s=reader.readLine()) != null) {
            //=-= //=-= //=-= System.out.println(s);
            if (s.indexOf("<database name=\"") != -1) {
                continue;
            } else if (s.indexOf("<table name=\"") != -1) {
                String tableName = getValue(s, "<table name=\"");
                writer =  new BufferedWriter(new FileWriter(outputPath + "/" + tableName + IDENTIFIER));
            } else if (s.indexOf("</table>")!= -1) {
                if (writer != null) {
                    writer.close();
                }
            } else if (s.indexOf("name=") != -1) {
                String name = getValue(s, "name=\"");
                writer.write(name + "=");
            } else if (s.indexOf("type=\"") != -1) {
                String type = getValue(s, "type=\"");
                if (type.equalsIgnoreCase("VARCHAR")) {
                        writer.write("java.lang.String");
                        //added By Faraz
                        String size = reader.readLine();
                        if ((size!=null) && (size.indexOf("size=\"")!=-1)) {
							writer.write(" - stringLength"+getValue(size,"size=\"")+"$");
						} else {
							log.error (" String must have size");
						}
						// till here
                } else if (type.equalsIgnoreCase("INTEGER")) {
                        writer.write("java.lang.Integer");
                } else if (type.equalsIgnoreCase("DATE")) {
                        writer.write("java.sql.Date");
                } else if (type.equalsIgnoreCase("FLOAT")) {
                        writer.write("java.lang.Double");
                } else {
                    throw new RuntimeException("Can't find proper type for " + type);
                }
                writer.newLine();
            }
        }


    }
    public static String getValue(String s, String key) {
        String value = s.substring(s.indexOf(key) + key.length());
        value = value.substring(0, value.indexOf("\""));
        return value;
    }
}
