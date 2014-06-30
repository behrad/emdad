/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 25, 2003
 * Time: 6:48:11 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.util.Constants;

import java.sql.*;
import java.util.*;

public class SysAdminDAO {

//    private static String connURL = (String)System.getProperty("application.connection.url"); //com.objectj.emdad.web.util.Util.getProperty("application.connection.url");
//    static {
//        try {
//            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Unable to load JDBC driver");
//        }
//    }

    public static Set getACL() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        Set result = null;
        try {
            c = Util.getConnection(); // DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT ucId, roleId FROM admin_ACL");
            result = new TreeSet();
            while (rs.next()) {
                result.add(rs.getString("ucId") + "," + rs.getString("roleId"));
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
            return result;
        }
    }


    public static ArrayList getUCs() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT admin_UC.*, entityName, entityTitle " +
                    "FROM admin_UC INNER JOIN admin_Entity ON admin_UC.entityId = admin_Entity.id " +
                    "ORDER BY admin_Entity.entityName, admin_UC.ucOperation");
            al = new ArrayList();
            while (rs.next()) {
                UseCaseModel ucm = new UseCaseModel();
                ucm.setId(rs.getInt("id"));
                ucm.setUcName(rs.getString("ucName"));
                ucm.setUcTitle(rs.getString("ucTitle"));
                ucm.setUcDescr(rs.getString("ucDescr"));
                ucm.setUcURL(rs.getString("ucURL"));
                ucm.setUcOperation(rs.getString("ucOperation"));
                al.add(ucm);
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

    public static ArrayList getEntities() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT admin_UC.*, admin_Entity.* " +
                    "FROM admin_UC INNER JOIN admin_Entity ON admin_UC.entityId = admin_Entity.id " +
                    "ORDER BY admin_Entity.entityName, admin_UC.ucOperation");
            al = new ArrayList();

            int lastEntityId = -1;
            EntityModel em = null;
            while (rs.next()) {
                int entityId = rs.getInt("entityId");
                if (entityId != lastEntityId) { // new entity
                    em = new EntityModel();
                    em.setId(entityId);
                    em.setEntityName(rs.getString("entityName"));
                    em.setEntityTitle(rs.getString("entityTitle"));
                    lastEntityId = entityId;
                    al.add(em);
                }
                UseCaseModel ucm = new UseCaseModel();
                ucm.setId(rs.getInt("id"));
                ucm.setUcName(rs.getString("ucName"));
                ucm.setUcTitle(rs.getString("ucTitle"));
                ucm.setUcDescr(rs.getString("ucDescr"));
                ucm.setUcURL(rs.getString("ucURL"));
                ucm.setUcOperation(rs.getString("ucOperation"));
                em.addUC(ucm);
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

    public static ArrayList getRoles() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT * " +
                    "FROM admin_Roles " +
                    "ORDER BY role");
            al = new ArrayList();
            while (rs.next()) {
                RoleModel rolem = new RoleModel();
                rolem.setId(rs.getInt("id"));
                rolem.setRoleName(rs.getString("role"));
                rolem.setRoleTitle(rs.getString("roleTitle"));
                al.add(rolem);
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

    public static int getRoleId(String roleName) {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        int rId = 0;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT * " +
                    "FROM admin_Roles " +
                    "WHERE role='" + roleName + "'");
            if (rs.next()) {
                rId = rs.getInt("id");
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
            return rId;
        }

    }

    public static ArrayList getMenus(String role) {
        if (role == null || role.equals(""))
            return new ArrayList();
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("select * from view_adminMenu where role= '" + role + "' ");
//            rs = sqlSt.executeQuery(
//                    "SELECT admin_BP.bpTitle, admin_BP.bpDescr, admin_BP.bpName, admin_UC.ucName, admin_UC.ucTitle, admin_UC.ucDescr, admin_UC.ucURL " +
//                    "FROM admin_ACL INNER JOIN " +
//                    "    admin_UC ON admin_ACL.ucId = admin_UC.id INNER JOIN " +
//                    "    admin_Roles ON admin_ACL.roleId = admin_Roles.id INNER JOIN " +
//                    "    admin_BP ON admin_UC.ucBP = admin_BP.id " +
//                    "WHERE admin_Roles.role = '" + role + "' " +
//                    "AND admin_UC.showInMenu = 1 " +
//                    "ORDER BY admin_BP.bpCode, admin_UC.entityId"
//            );
            al = new ArrayList();

            String lastBPName = "";
            MenuModel mm = null;
            while (rs.next()) {
                String bpName = rs.getString("bpName");
                if (!bpName.equals(lastBPName)) {
                    mm = new MenuModel();
                    mm.setBpName(bpName);
                    mm.setBpTitle(rs.getString("bpTitle"));
                    mm.setBpDescr(rs.getString("bpDescr"));
                    lastBPName = bpName;
                    al.add(mm);
                }
                UseCaseModel ucm = new UseCaseModel();
                ucm.setUcName(rs.getString("ucName"));
                ucm.setUcTitle(rs.getString("ucTitle"));
                ucm.setUcDescr(rs.getString("ucDescr"));
                ucm.setUcURL(rs.getString("ucURL"));
                mm.addUseCase(ucm);
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

    public static boolean hasMenuOfKind(ArrayList menus, String kind) {
        for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
            MenuModel mm = (MenuModel) menuIt.next();
            if (mm.getBpName().equals(kind))
                if (mm.getUsecases().size() > 0)
                    return true;
        }
        return false;
    }
/*
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
        }
*/

    public static void backupACL() {
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            sqlSt.executeUpdate("delete from [admin_ACL_bak]");
            sqlSt.executeUpdate("insert into [admin_ACL_bak] select * from admin_ACL");
            sqlSt.executeUpdate("delete from admin_ACL");
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
        }
    }

    public static int getSuperuserId() {
        int superuserId = -1;
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            ResultSet rs = sqlSt.executeQuery("select * from admin_Roles where role = '" + Constants.ROLE_SUPERUSER + "'");
            if (rs.next())
                superuserId = rs.getInt("id");
            else
                System.err.println("Could not find superuser record");
        } catch (Exception se) {
            System.err.println("Could not find superuser record");
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return superuserId;
        }
    }

    public static void insertSuperuserACL() {
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            sqlSt.executeUpdate("insert into admin_ACL select " + getSuperuserId() + ", id from admin_UC");
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
        }
    }

    public static void insertACL(int roleId, int ucId) {
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            sqlSt.executeUpdate("insert into admin_ACL (roleId, ucId) values (" + roleId + ", " + ucId + ")");
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
        }
    }

    public static boolean insertEntity(EntityModel em, int bpId) {
        boolean result = true;
        Connection c = null;
        Statement sqlSt = null;
        PreparedStatement ps = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            sqlSt.executeUpdate("insert into admin_Entity (entityName, entityTitle, entityDescr) values ('" +
                    em.getEntityName() + "', '" +
                    em.getEntityTitle() + "', '" +
                    em.getEntityDescr() + "')");

            ResultSet rs = sqlSt.executeQuery("select id from admin_Entity where entityName = '" + em.getEntityName() + "'");
            if (rs.next())
                em.setId(rs.getInt("id"));

            ps = c.prepareStatement("insert into admin_UC (entityId, ucName, ucTitle, ucDescr, " +
                    "ucURL, ucOperation, ucBP, ucExec, showInMenu) values (" +
                    em.getId() + ", ?, ?, NULL, ?, ?, " + bpId + ", NULL, ?)"
            );
            for (Iterator ucIterator = em.getUseCases().iterator(); ucIterator.hasNext();) {
                UseCaseModel ucm = (UseCaseModel) ucIterator.next();
                ps.setString(1, ucm.getUcName());
                ps.setString(2, ucm.getUcTitle());
                ps.setString(3, ucm.getUcURL());
                ps.setString(4, ucm.getUcOperation());
                ps.setInt(5, ucm.showInMenu());
//                //=-= System.out.println("************************ ps = " + ps);
                ps.executeUpdate();
            }
        } catch (SQLException se) {
            se.printStackTrace();
            result = false;
        } finally {
            try {
                ps.close();
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return result;
        }
    }

    public static ArrayList getBPs() {
        Connection c = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        ArrayList al = null;
        try {
            c = Util.getConnection(); //DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery("SELECT * " +
                    "FROM admin_BP " +
                    "ORDER BY bpCode");
            al = new ArrayList();
            while (rs.next()) {
                BPModel bpm = new BPModel();
                bpm.setId(rs.getInt("id"));
                bpm.setBpName(rs.getString("bpName"));
                bpm.setBpTitle(rs.getString("bpTitle"));
                bpm.setBpDescr(rs.getString("bpDescr"));
                bpm.setBpCode(rs.getInt("bpCode"));
                al.add(bpm);
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
}
