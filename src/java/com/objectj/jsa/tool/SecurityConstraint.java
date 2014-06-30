/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 30, 2003
 * Time: 4:41:37 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.tool;

import java.util.ArrayList;
import java.util.Iterator;

public class SecurityConstraint {
    private String ucName;
    private String ucUrl;
    private String ucOperation;
    private ArrayList roles;

    public static String slashToDash(String s) {
        return s.replace('/', '-').replace('.', '-');
    }

    public SecurityConstraint(String ucName, String ucUrl, String ucOperation) {
        this.ucName = ucName;
        this.ucUrl = ucUrl;
        this.ucOperation = ucOperation;
        roles = new ArrayList();
    }

    public SecurityConstraint(String ucUrl, String ucOperation) {
        this.ucName = slashToDash(ucUrl);
        this.ucUrl = ucUrl;
        this.ucOperation = ucOperation;
        roles = new ArrayList();
    }

    public boolean isPublic() {
        return roles.contains("user");
    }

    public String getUcName() {
        return ucName;
    }

    public String getOperation() {
        return ucOperation;
    }

    public void setUcName(String ucName) {
        this.ucName = ucName;
    }

    public String getUcUrl() {
        return ucUrl;
    }

    public void setUcUrl(String ucUrl) {
        this.ucUrl = ucUrl;
    }

    public void addRole(String roleName) {
        roles.add(roleName);
    }

    private String encodeAmp(String s) {
        return s.replaceAll("&", "&amp;");
    }

    public String toXML() {
        StringBuffer result = new StringBuffer();
        result.append("\n<security-constraint>\n");
        result.append("\t<web-resource-collection>\n");
        result.append("\t\t<web-resource-name>" + ucName + "</web-resource-name>\n");
        result.append("\t\t<url-pattern>" + encodeAmp(ucUrl) + "</url-pattern>\n");
        result.append("\t</web-resource-collection>\n");
        if (ucOperation.equals("c") || ucOperation.equals("u")) {
            result.append("\t<web-resource-collection>\n");
            result.append("\t\t<web-resource-name>" + ucName + "-validation</web-resource-name>\n");
            result.append("\t\t<url-pattern>/" + ucOperation + "/validate" + ucUrl.substring(3) + "</url-pattern>\n");
            result.append("\t</web-resource-collection>\n");
        }
        result.append("\t<auth-constraint>\n");

        for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
            String roleName = (String) roleIterator.next();
            result.append("\t\t<role-name>" + roleName + "</role-name>\n");
        }
        result.append("\t</auth-constraint>\n");
        result.append("</security-constraint>\n");
        return result.toString();
    }
}
