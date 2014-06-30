/*
 * entityMaker.java
 *
 * Created on February 8, 2003, 11:34 PM
 */

package com.objectj.jsa.tool;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Hossein Akhlaghpour
 */
public class ProxyMaker {

    protected static Logger log = Logger.getLogger(ProxyMaker.class.getName());

    private Properties lookupPropertie;



    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "ProxyMaker", log);
        (new ProxyMaker()).makeProxies();
        log.debug("done");
    }


    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }

    public void makeProxies(
    ) throws IOException {

        String path = (String)getLookupProperties().get("@path@");
        String srcDir = (String)getLookupProperties().get("@src.dir@");

        String templateFile = srcDir + "/com/objectj/jsa/proxy/ProxyBean.xava";
        String destFileName = srcDir + "/" + path + "/proxy/ProxyBean.java";
        FileUtil.makeFromTemplate(templateFile, destFileName);

        //making login.jsp
		String templateFile2 = srcDir + "/com/objectj/jsa/model/jsp/login.xsp";
		//=-= //=-= //=-= System.out.println("templateFile2" + templateFile2);
		String destFileName2 = srcDir + "/" + path + "/jsp/login.jsp";
		//=-= //=-= //=-= System.out.println("destFileName2" + destFileName2);

		FileUtil.makeFromTemplate(templateFile2, destFileName2);
		//=-= //=-= //=-= System.out.println("Done");


    }

}
