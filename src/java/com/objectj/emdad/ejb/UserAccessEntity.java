package com.objectj.emdad.ejb;

import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.proxy.QueryObject;

import java.sql.* ;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserAccessEntity {

//	static String getConnURL() {
//        return (String)Util.get("application.connection.url");
//    }

//	static {
//        try {
//            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
//        }
//	}

    /*
    * returns :     null :  has replicate
    *               ""   :  anything not found
    *        field value :  found and unique
    */
    public static String stringQueryRepl(String query, String field, Connection c) {
        String result = "";
        Statement sqlSt = null;
        ResultSet rs = null;
        try {
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery(query);
            if (rs.next()) {
                result = rs.getString(field);
                if (rs.next())
                    result = null;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (sqlSt!=null)
                    sqlSt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static String[] stringQuerys(QueryObject qo, Connection c) {
        String[] result = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            String selectStatement = Util.getStatement(qo) ;
            prepStmt = c.prepareStatement(selectStatement); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Util.setParameters(qo, prepStmt);
            //System.out.println("stringQuerys, Query : "+ selectStatement);
            rs = prepStmt.executeQuery();
            String field = qo.getSelectFields();
            int sz = Util.getCharCount(field,',');
            int i = 0;
            result = new String[sz+1];
            if (rs.next()) {
                StringTokenizer t=new StringTokenizer(field,",");
                String s="";
                try {
				while (Util.isNotEmpty(s=t.nextToken())) {
//                    System.out.println("s=["+s+"]");
                    s = s.trim();
                    result[i++] = rs.getString(s);
                }
                } catch (Exception e) {}
			}
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static String[] stringQuerys(QueryObject qo) {
        String result[] = null;
        Connection c = null;
        try {
            c = Util.getConnection();
            result = stringQuerys (qo, c);
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (c!=null)
                    c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String[] stringQuerys(String query, String field, Connection c) {
        String[] result = null;
        Statement sqlSt = null;
        ResultSet rs = null;
        try {
            sqlSt = c.createStatement();
//            System.out.println("stringQuerys, Query : "+ query);
            rs = sqlSt.executeQuery(query);
            int sz = Util.getCharCount(field,',');
            int i = 0;
            result = new String[sz+1];
            if (rs.next()){
                StringTokenizer t=new StringTokenizer(field,",");
                String s="";
                try {
				while (Util.isNotEmpty(s=t.nextToken())) {
//                    System.out.println("s=["+s+"]");
                    s = s.trim();
                    result[i++] = rs.getString(s);
                    //System.out.println("s=["+s+"]="+result[i-1]);
                }
                } catch (Exception e) {}
//                result=result.substring(0,result.length()-1);
			}
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (sqlSt!=null)
                    sqlSt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static String[] stringQuerys(String query, String field) {
        String result[] = null;
        Connection c = null;
        try {
            c = Util.getConnection();
            result = stringQuerys (query, field, c);
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (c!=null)
                    c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String stringQuery(String query, String field, Connection c) {
//        return (String) objectQuery(query, field, c);
        String result = "";
        Statement sqlSt = null;
        ResultSet rs = null;

//        System.out.println("query="+query+" ,field="+field);

        try {
            sqlSt = c.createStatement();
            rs = sqlSt.executeQuery(query);
            if (rs.next())
                result = rs.getString(field);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (sqlSt!=null)
                    sqlSt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String stringQuery(String query, String field) {
//        return (java.lang.String) objectQuery(query, field);
        String result = "";
        Connection c = null;
        try {
            c = Util.getConnection();
            result = stringQuery (query, field, c);
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (c!=null)
                    c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static Date dateQuery(String query, String field, Connection c ) {
//        return (Date) objectQuery(query, field, c);
	        Date result = null;
	        Statement sqlSt = null;
	        ResultSet rs = null;
	        try {
	            sqlSt = c.createStatement();
	            rs = sqlSt.executeQuery(query);
	            if (rs.next())
	                result = rs.getDate(field);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } finally {
	            try {
	                if (sqlSt!=null)
	                    sqlSt.close();
	                if (rs!=null)
	                    rs.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
    }

    public static Object objectQuery(String query, String field, Connection c ) {
	        Object result = null;
	        Statement sqlSt = null;
	        ResultSet rs = null;
	        try {
	            sqlSt = c.createStatement();
	            rs = sqlSt.executeQuery(query);
	            if (rs.next())
	                result = rs.getObject(field);
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } finally {
	            try {
	                if (sqlSt!=null)
	                    sqlSt.close();
	                if (rs!=null)
	                    rs.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
    }

    public static Object objectQuery(String query, String field) {
	        Object result = null;
	        Connection c = null;
	        try {
	            c = Util.getConnection();
	            result = objectQuery (query, field, c);
	        } catch (Exception se) {
	            se.printStackTrace();
	        } finally {
	            try {
	                if (c!=null)
	                    c.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
	}

    public static Date dateQuery(String query, String field) {
//        return (Date) objectQuery(query, field);
	        Date result = null;
	        Connection c = null;
	        try {
	            c = Util.getConnection();
	            result = dateQuery (query, field, c);
	        } catch (Exception se) {
	            se.printStackTrace();
	        } finally {
	            try {
	                if (c!=null)
	                    c.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
	}

	public static int intQuery(String query, String field) {
        int result = 0;
        String resultS = stringQuery(query, field);
        if (Util.isNotEmpty(resultS) )
            result = Integer.parseInt(resultS);
    	return result;
	}

    public static int intQuery(String query, String field, Connection c) {
        int result = 0;
        String resultS = stringQuery(query, field, c);
        if (Util.isNotEmpty(resultS) )
            result = Integer.parseInt(resultS);
        return result;
    }

	public static String getUserRole(String username) {
        if (username == null || username.equals(""))
            return "";
        return stringQuery("select role from userRoles where username='"+username+"'", "role");
	}

    public static String getUserRoleFarsi(String username) throws Exception
    {
        return stringQuery("select roleTitle from userRoles INNER JOIN admin_Roles ON userRoles.role = admin_Roles.role  where username='"+  username + "'", "roleTitle");
    }

	public static String getAccessToEntity(String role, String entity) throws Exception
	{
        Connection c = null;
        Statement sqlSt = null;
        StringBuffer result = new StringBuffer();
        try {
            c = Util.getConnection(); // DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            ResultSet rs = sqlSt.executeQuery(
                    "SELECT     admin_Roles.role, admin_Entity.entityName, admin_UC.ucOperation " +
                    "FROM       admin_UC INNER JOIN " +
                    "           admin_ACL ON admin_UC.id = admin_ACL.ucId INNER JOIN " +
                    "           admin_Roles ON admin_ACL.roleId = admin_Roles.id INNER JOIN " +
                    "           admin_Entity ON admin_UC.entityId = admin_Entity.id " +
                    "WHERE      admin_Roles.role = '" + role + "' AND " +
                    "           admin_Entity.entityName = '" + entity + "'"
            );
            while (rs.next()) {
                result.append(rs.getString("ucOperation").toUpperCase());
            }
            rs = sqlSt.executeQuery("select faraOstani from admin_Roles where role ='" + role + "'");
            if (rs.next()) {
                if (rs.getInt("faraOstani") == 1)
                    result.append("A");
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
        }
        return result.toString();

      }

      public static boolean roleURLAccess(Connection c, String username, String url) {
        url = Util.replaceAll(url, "validate", "");
        String roleName = UserAccessEntity.getUserRole(username);
        if (roleName == null || roleName.length() == 0)
            return true;
        return roleURLAccess(c, username, roleName, url);
    }

    public static boolean roleURLAccess(Connection c, String username, String roleName, String url) {
      Statement sqlSt = null;
      ResultSet rs = null;
      url = Util.replaceAll(url, "validate", "");
      boolean hasAccess = false;
      try {
          sqlSt = c.createStatement();
          String sql =
              "SELECT admin_UC.ucURL, admin_Roles.role " +
              "FROM   admin_UC INNER JOIN " +
              "       admin_ACL ON admin_UC.id = admin_ACL.ucId INNER JOIN " +
              "       admin_Roles ON admin_ACL.roleId = admin_Roles.id " +
              "WHERE  admin_Roles.role = '" + roleName + "' " +
              "AND    '" + url + "' LIKE admin_UC.ucURL + '%'";
//            //=-= System.out.println("sql = " + sql);
          rs = sqlSt.executeQuery(sql);
          hasAccess = rs.next();
      } catch (Exception se) {
          se.printStackTrace();
      } finally {
          try {
              if (sqlSt!=null)
                  sqlSt.close();
              if (rs!=null)
                  rs.close();
          } catch (Exception e) {
              e.printStackTrace();  //To change body of catch statement use Options | File Templates.
          }
      }
      return hasAccess;
  }

	public static String getAccess(String username, String entity) throws Exception
	{
		return getAccessToEntity(getUserRole(username), entity);
	}

    public static boolean hasAccessToReport(String role, int reportId) throws Exception
    {
        String s = stringQuery("select ucName from view_adminMenu where role='"+role+"' and bpName='report' and ucURL like '"+reportId+"%' ", "ucName");
        return s!=null && s.length()>0;
    }

    public static ArrayList getAllAccesses(String role) throws Exception
    {
        Connection c = null;
        Statement sqlSt = null;
        ArrayList al = new ArrayList();
        boolean isFaraOstani = false;
        try {
            c = Util.getConnection(); // DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            ResultSet rs = sqlSt.executeQuery("select faraOstani from admin_Roles where role ='" + role + "'");
            if (rs.next()) {
                isFaraOstani = rs.getInt("faraOstani") == 1;
            }
            rs = sqlSt.executeQuery(
                    "SELECT     admin_Roles.role, admin_Entity.entityName, admin_UC.ucOperation " +
                    "FROM       admin_UC INNER JOIN " +
                    "           admin_ACL ON admin_UC.id = admin_ACL.ucId INNER JOIN " +
                    "           admin_Roles ON admin_ACL.roleId = admin_Roles.id INNER JOIN " +
                    "           admin_Entity ON admin_UC.entityId = admin_Entity.id " +
                    "WHERE      admin_Roles.role = '" + role + "' " +
                    "ORDER BY admin_Roles.role, admin_Entity.entityName"
            );
            String lastEntity = "";
            AccessToEntity ate = null;
            while (rs.next()) {
                String entity = rs.getString("entityName");
                if (!lastEntity.equals(entity)) {
                    ate = new AccessToEntity(entity, "");
                    if (isFaraOstani)
                        ate.appendAccess("A");
                    al.add(ate);
                    lastEntity = entity;
                }
                ate.appendAccess(rs.getString("ucOperation").toUpperCase());
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
        }
        return al;
    }

    public static String getUserFullName(String username) throws Exception {
        return stringQuery("select name from Shakhs where username='" + username + "'", "name");
    }

    public static String getDaftarOstaniName(String username) throws Exception {
        return stringQuery("SELECT DaftarOstani.name as doname FROM Shakhs INNER JOIN DaftarOstani ON Shakhs.daftarOstaniId = DaftarOstani.id WHERE Shakhs.username = '" + username + "'", "doname");
    }

    public static String getDaftarOstaniId(String username) throws Exception {
        return stringQuery("SELECT DaftarOstani.id as doid FROM Shakhs INNER JOIN DaftarOstani ON Shakhs.daftarOstaniId = DaftarOstani.id WHERE Shakhs.username = '" + username + "'", "doid");
    }

    public static String getUserId(String username) throws Exception {
        return stringQuery("SELECT id FROM Shakhs WHERE Shakhs.username = '" + username + "'", "id");
    }

	public static int getNaghshId(String username) throws Exception {
			return intQuery("SELECT naghshId FROM Shakhs WHERE Shakhs.username = '" + username + "'", "naghshId");
	}

	public static String getEntityId(String username) throws Exception {
			return stringQuery("SELECT entityId FROM Shakhs WHERE Shakhs.username = '" + username + "'", "entityId");
	}

    public static int getNaghshIdFromRole(String roleName) throws Exception {
        return intQuery("SELECT id FROM admin_Roles WHERE admin_Roles.role = '" + roleName + "'", "id");
    }

}