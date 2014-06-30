/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: May 28, 2003
 * Time: 7:14:37 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;
import java.sql.*;
import java.lang.reflect.Method;

import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.QueryElement;
import com.objectj.jsa.model.ValueObject;

public class Util {
    private static Hashtable lists = new Hashtable();
    protected static Logger log = Logger.getLogger(Util.class.getName());
    private static DataSource dataSource = null;

    private static DataSource getDs() {
        if (dataSource==null) {
            try {
                InitialContext c = new InitialContext();
                dataSource = (DataSource)c.lookup("java:/emdadDS");
            } catch (Exception sqle) {
                 sqle.printStackTrace();
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws Exception {
//        DataSource ds;
        Connection connection = null;
        try {
//            InitialContext c = new InitialContext();
//            ds = (DataSource)c.lookup("java:/emdadDS");
            long t = (new java.util.Date()).getTime();
            connection = getDs().getConnection();
//            log.info("getConnection "+((new java.util.Date()).getTime()-t));
            //ds = null;
       } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
                   //=-= System.out.println("SQL EXCEPTION OCCURED" + sqle);
       }

        return connection;
    }


    public static void addList(String key, ArrayList al) {
        if (al!=null && lists.get(key)==null) {
            lists.put(key, al);
        }
    }

    public static void add(String key, Object al) {
        if (al!=null && lists.get(key)==null) {
            lists.put(key, al);
        }
    }

    public static Enumeration getKeys() {
        return lists.keys();
    }

    public static Object get(String key) {
        if (lists.get(key)!=null) {
            return lists.get(key);
        }
        return null;
    }

    public static void remove(String key) {
        if (lists.get(key)!=null) {
            lists.remove(key);
        }
    }

    public static ArrayList getArrayList(String key) {
        if (lists.get(key)!=null) {
            return (ArrayList)lists.get(key);
        }
        return null;
    }

    public static Object getFromArrayList(String key, int idx) {
        ArrayList al = (ArrayList) lists.get(key);
        if (idx>=0 && al!=null && idx<al.size()) {
            return ((ArrayList)lists.get(key)).get(idx);
        }
        return null;
    }

    public static String getNameFromArrayList(String key, int idx) {
        ComboObject co = (ComboObject) getFromArrayList(key, idx);
        if (co==null) {
            return "";
        }
        return co.getName();
    }

    public static String getNameFromArrayList(String key, Integer idx) {
        if (idx==null)
            return "";
        return getNameFromArrayList(key, idx.intValue());
    }

    public static Object getFromArrayList(String key, Integer idx) {
        if (idx==null)
            return new ComboObject("","");
        return getFromArrayList(key, idx.intValue());
    }

    public static String replaceAll(String source, String toBeReplaced, String replacement) {
        StringBuffer results = new StringBuffer();
        int len = toBeReplaced.length();
        for (int i = 0; i < source.length(); ++i) {
            if (source.regionMatches(false, i, toBeReplaced, 0, len)) {
                results.append(replacement);
                i += len - 1; // minus one, since we will increment
            } else {
                results.append(source.charAt(i));
            }
        }
        return results.toString();
    }

    public static boolean isEmpty(String s) {
        return (s==null) || (s.trim().length()==0);
    }
    public static boolean isEmptyId(String s) {
        return (s==null) || (s.trim().length()==0) || (s.equals((String) com.objectj.emdad.ejb.util.Util.get("nullKey")));
    }

    public static boolean isNotEmpty(String s) {
        return (s!=null) && (s.trim().length()!=0);
    }
    public static boolean isNotEmptyId(String s) {
        return (s!=null) && (s.trim().length()!=0) && (!s.equals((String) com.objectj.emdad.ejb.util.Util.get("nullKey"))) ;
    }

    public static String digitsOnly(String s) {
        char c;
        int findex = 0;
        int lindex = s.length() - 1;
        if (s.length() == 0) return "";
        while (findex < s.length()) {

            c = s.charAt(findex);
            try {
                Integer ii = new Integer(c + "");
                break;

            } catch (Exception e) {
                findex++;
            }
        }
        while (lindex > -1) {
            c = s.charAt(lindex);
            try {
                Integer ii = new Integer(c + "");
                break;
            } catch (Exception e) {
                lindex--;
            }
        }

        return ((findex < s.length() && lindex > -1 && findex <= lindex) ? s.substring(findex, lindex + 1) : "");
    }


    public static void setParameters(QueryObject queryObject, PreparedStatement prepStmt) throws SQLException, NumberFormatException {
        try {
            if (queryObject.getQueryElements().size() != 0) {
                for (int i = 0; i < queryObject.getQueryElements().size(); i++) {
                    String type = ((QueryElement)queryObject.getQueryElements().get(i)).getType();
                    String value = ((QueryElement)queryObject.getQueryElements().get(i)).getValue();
                    if (type.equals("String"))
                        prepStmt.setString(i + 1, value);
                    else
                        if (type.equals("Integer"))
                            prepStmt.setInt(i + 1, Integer.parseInt(value));
                        else
                            if (type.equals("Date"))
                                prepStmt.setDate(i + 1, Date.valueOf(value));
                            else
                                if (type.equals("Timestamp"))
                                    prepStmt.setTimestamp(i + 1, java.sql.Timestamp.valueOf(value));
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getStatement(QueryObject queryObject) {
        String selectStatement = "SELECT " + queryObject.getSelectFields() ;
        selectStatement += " FROM " + queryObject.getTables();
        if ((queryObject.getWhere() != null) && (queryObject.getWhere().length() != 0)) {
            selectStatement += " WHERE ";
            selectStatement += queryObject.getWhere();
            selectStatement += " ";
        }

        if ((queryObject.getOrderField() != null) && (queryObject.getOrderField().length() != 0)) {
            selectStatement += " ORDER BY ";
            if (queryObject.getOrderTable() != null && queryObject.getOrderTable().length() != 0)
                selectStatement += queryObject.getOrderTable() + ".";
            selectStatement += queryObject.getOrderField();
            selectStatement += " ";
            selectStatement += queryObject.getOrderType();
        }
        return selectStatement;
    }

    public static void resultSetToValueObject(ResultSet rs , ValueObject valueObject) {
        Class voClass = valueObject.getClass();
        Method[] methods = voClass.getMethods();
        for(int index = 0; index != methods.length; index++) {
            Method method = methods[index];
            if(method.getName().startsWith("get")) {
                String key = method.getName().substring(3);
                key = key.toUpperCase().substring(0, 1) + key.substring(1);
                try {
                    Object o = rs.getObject(key);
                    String methodName = "set" + key;
                    if (o != null) {
                        try {
                            if (o.getClass().getName().indexOf("Decimal")!=-1)
                                o = new Integer(rs.getInt(key));
                           Method smethod = voClass.getMethod(methodName, (new Class[] { o.getClass() }) );
                           if (smethod!=null)
                                smethod.invoke(valueObject, (new Object[] { o }));
                        } catch (Exception e) {
                            //log.info("o.getClass().getName()="+o.getClass().getName());
                            if ( o.getClass().getName().indexOf("Timestamp")!=-1 || o.getClass().getName().indexOf("Date")!=-1) {
                                Method smethod = voClass.getMethod(methodName, (new Class[] { java.sql.Date.class }) );
                                Object o2 = rs.getDate(key);
                                if (smethod!=null) {
                                     smethod.invoke(valueObject, (new Object[] { o2 }));
                                }
                            }
                        }
                    }
                } catch(Exception exception) {
                    //log.info(exception.getMessage());
                }
            }
        }

    }


    private static int getInt(byte bytes[]) {
        int i = 0;
        int j = 24;
        for (int k = 0; j >= 0; k++) {
            int l = bytes[k] & 0xff;
            i += l << j;
            j -= 8;
        }
        return i;
    }

    private static String hexFormat(int i, int j) {
        String s = Integer.toHexString(i);
        if (s.length() < j)
            return padHex(s, j) + s;
        return s.substring(s.length()-j);
    }

    private static String padHex(String s, int i) {
        StringBuffer tmpBuffer = new StringBuffer();
        if (s.length() < i) {
            for (int j = 0; j < i - s.length(); j++) {
                tmpBuffer.append('0');
            }
        }
        return tmpBuffer.toString();
    }

    /** Cached per JVM server IP. */
    private static String hexServerIP = null;

    // initialise the secure random instance
    private static final java.security.SecureRandom seeder = new java.security.SecureRandom();


    public static String generateGUID(Object o) {
        if (hexServerIP == null) {
            java.net.InetAddress localInetAddress = null;
            try {
                // get the inet address
                localInetAddress = java.net.InetAddress.getLocalHost();
            }
            catch (java.net.UnknownHostException uhe) {
                System.err.println("Could not get the local IP address using InetAddress.getLocalHost()!");
                uhe.printStackTrace();
                return null;
            }
            byte serverIP[] = localInetAddress.getAddress();
            hexServerIP = hexFormat(getInt(serverIP), 4);
        }

        long timeNow      = System.currentTimeMillis();
        int timeLow       = (int)timeNow & 0xFFFFFFFF;
        int node          = seeder.nextInt();

        StringBuffer guid = new StringBuffer(19);
        guid.append(hexServerIP);            // 4
        guid.append(hexFormat(System.identityHashCode(o), 6));  // 6
        guid.append(hexFormat(timeLow, 4));  // 4
        guid.append(hexFormat(node, 4));     // 4
        guid.append('o');                    // 1
        return guid.toString();
    }

    public static int getCharCount(String s, char c) {
        int i = 0;
        int j = -1;
//        log.info("getCharCount("+s+","+c+")");
        while ( (j=s.indexOf(c, j+1))!=-1 ) i++;
//        log.info("getCharCount="+i);
        return i;
    }
}
