/*
 * entityMaker.java
 *
 * Created on February 8, 2003, 11:34 PM
 */

package com.objectj.jsa.tool;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoginMaker {

    protected static Logger log = Logger.getLogger(LoginMaker.class.getName());

    private Properties lookupPropertie;

    public static void main(String[] args) throws Exception {
        FileUtil.checkForRightNumberOfArgs(args, "LoginMaker", log);
        (new LoginMaker()).makeJspFile();
        log.debug("done");
    }

    public Properties getLookupProperties() {
        if(lookupPropertie == null) lookupPropertie = FileUtil.createLookupProperties();
        return lookupPropertie;
    }


    public void makeJspFile(
	) throws IOException {

   		String srcDir = (String)getLookupProperties().get("@src.dir@");

		String templateFile = srcDir + "/com/objectj/jsa/model/jsp/login.xsp";
		String destFileName = srcDir + "/com/objectj/emdad/jsp/login.jsp";
		FileUtil.makeFromTemplate(templateFile, destFileName);

	}

}

