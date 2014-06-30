/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 30, 2003
 * Time: 3:50:35 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.tool;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.sql.*;

public class WebSecurityMaker {

    public static void main(String[] args) throws Exception {
        Class.forName(System.getProperty("database.driver"));
        new WebSecurityMaker().exportXML(args[0]);
    }

    public String getConnURL() {
        // db.url=jdbc:microsoft:sqlserver://sequel:1433;User=sa;Password=;DatabaseName=emdad
        return System.getProperty("database.url") +
                ";User=" + System.getProperty("database.user") +
                ";Password=" + System.getProperty("database.password") +
                ";DatabaseName=" + System.getProperty("database.name");
    }

    public ArrayList getACLModel() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = new ArrayList();
        try {
            c = DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery(
                "SELECT admin_UC.id, admin_UC.ucName, admin_UC.ucOperation, admin_UC.ucURL, admin_Roles.role " +
                "FROM admin_ACL INNER JOIN " +
                "   admin_Roles ON admin_ACL.roleId = admin_Roles.id INNER JOIN " +
                "   admin_UC ON admin_ACL.ucId = admin_UC.id " +
                "WHERE (admin_UC.ucOperation <> 's') and (admin_UC.isSecure=1) " +
                "ORDER BY admin_UC.id"
            );
            SecurityConstraint sc = null;
            int lastUCId = -1;
            while (rs.next()) {
                int ucId = rs.getInt("id");
                if (ucId != lastUCId) {
                    sc = new SecurityConstraint(rs.getString("ucName"), rs.getString("ucURL"), rs.getString("ucOperation"));
                    lastUCId = ucId;
                    al.add(sc);
                }
                sc.addRole(rs.getString("role"));
            }

            // handle specific actions
            rs = sqlSt.executeQuery(
                    "SELECT DISTINCT SUBSTRING(admin_UC.ucURL, 1, CHARINDEX('.run', admin_UC.ucURL) + 3) AS url, admin_Roles.role "+
                    "FROM  admin_UC INNER JOIN "+
                    "      admin_ACL ON admin_UC.id = admin_ACL.ucId INNER JOIN "+
                    "      admin_Roles ON admin_ACL.roleId = admin_Roles.id "+
                    "WHERE (admin_UC.ucOperation = 's') and (admin_UC.isSecure=1)  "+
                    "ORDER BY url");

            String lastUrl = "";
            while (rs.next()) {
                String url = rs.getString("url");
                if (!url.equals(lastUrl)) {
                    sc = new SecurityConstraint(rs.getString("url"), "s");
                    lastUrl = url;
                    al.add(sc);
                }
                sc.addRole(rs.getString("role"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return al;
        }
    }

    public ArrayList getRoles() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = new ArrayList();
        try {
            c = DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT * from admin_Roles");
            while (rs.next()) {
                al.add(rs.getString("role"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return al;
        }
    }

    public void exportXML(String destDir) {
        try {
            ArrayList aclModel = getACLModel();
            ArrayList roles = getRoles();
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destDir + "/web-security.xml")));
            PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(destDir + "/rep-security.xml")));

            for (Iterator aclIterator = aclModel.iterator(); aclIterator.hasNext();) {
                SecurityConstraint sc = (SecurityConstraint) aclIterator.next();
                if (sc.isPublic())
                    continue;
                out.println(sc.toXML());
                if(sc.getOperation().equals("g"))
                    out1.println(sc.toXML());
            }

            out.println("\n\n<!-- Constraints for roles resources -->\n");
            out1.println("\n\n<!-- Constraints for roles resources -->\n");
            for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
                String roleName = (String) iterator.next();
                printRoleResXML(out, roleName);
                printRoleResXML(out1, roleName);
            }

            // write constraint for home action
            out.println("\n\n<!-- Home Action constraints -->\n");
            out.println("\n<security-constraint>");
            out.println("\t<web-resource-collection>");
            out.println("\t\t<web-resource-name>home-action</web-resource-name>");
            out.println("\t\t<url-pattern>/usr/home.run</url-pattern>");
            out.println("\t</web-resource-collection>");
            out.println("\t<auth-constraint>");
            for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
                String roleName = (String) iterator.next();
                if (roleName.equals("user"))
                    continue;
                out.println("\t\t<role-name>" + roleName + "</role-name>");
            }
            out.println("\t</auth-constraint>");
            out.println("</security-constraint>");

            printSysAdminXML(out);
            printSysAdminXML(out1);

            printLoginConfig(out);
            printLoginConfig(out1);

            out.println("\n\n<!-- Security Roles -->\n");
            out1.println("\n\n<!-- Security Roles -->\n");
            for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
                String roleName = (String) iterator.next();
                if (roleName.equals("user"))
                    continue;
                printSecurityRole(out, roleName);
                printSecurityRole(out1, roleName);
            }
            out.close();
            out1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLoginConfig(PrintWriter out) {
        out.println("\n\n<!-- Login config -->\n");
        out.println("<login-config>");
        out.println("\t<auth-method>FORM</auth-method>");
        out.println("\t<realm-name>emdad</realm-name>");
        out.println("\t<form-login-config>");
        out.println("\t\t<form-login-page>/com/objectj/resources/jsp/tiles/emdad/login.jsp</form-login-page>");
        out.println("\t\t<form-error-page>/com/objectj/resources/jsp/tiles/emdad/error.jsp</form-error-page>");
        out.println("\t</form-login-config>");
        out.println("</login-config>");
    }

    private void printSecurityRole(PrintWriter out, String roleName) {
        out.println("<security-role>");
        out.println("\t<role-name>" + roleName + "</role-name>");
        out.println("</security-role>");
    }

    private void printRoleResXML(PrintWriter out, String roleName) {
        out.println("\n<security-constraint>");
        out.println("\t<web-resource-collection>");
        out.println("\t\t<web-resource-name>" + roleName + "-resources</web-resource-name>");
        out.println("\t\t<url-pattern>/usr/" + roleName + "/*</url-pattern>");
        out.println("\t</web-resource-collection>");
        out.println("\t<auth-constraint>");
        out.println("\t\t<role-name>" + roleName + "</role-name>");
        out.println("\t</auth-constraint>");
        out.println("</security-constraint>");
    }

    private void printSysAdminXML(PrintWriter out) {
        out.println("\n<security-constraint>");
        out.println("\t<web-resource-collection>");
        out.println("\t\t<web-resource-name>sysadmin</web-resource-name>");
        out.println("\t\t<url-pattern>/sysadmin.run</url-pattern>");
        out.println("\t</web-resource-collection>");
        out.println("\t<auth-constraint>");
        out.println("\t\t<role-name>superuser</role-name>");
        out.println("\t</auth-constraint>");
        out.println("</security-constraint>");
    }

}
