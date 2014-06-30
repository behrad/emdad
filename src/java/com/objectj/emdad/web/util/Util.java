/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: May 28, 2003
 * Time: 7:14:37 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.util;

import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.UserSession;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.QueryElement;
import com.objectj.emdad.proxy.QueryResult;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.proxy.ProxyException;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.sql.*;
import java.security.Principal;

import org.apache.log4j.Logger;

public class Util {

    public static final String AND = "AND";
    public static final String OR = "OR";
    public static final String NOT = "NOT";

    private static Properties appResourcePropertie = null;
    private static File appResourcePropertieFile;
    private static ResourceBundle resources = null;
    protected static Logger log = Logger.getLogger(Util.class.getName());

    public static ResourceBundle getResources() {
        if (resources==null)
            resources = ResourceBundle.getBundle("ApplicationResources");
        return resources;
    }

    public static String getProperty(String key) {
        String p = null;
        try {
            p = (String)getResources().getString(key);
        } catch (Exception e) {}
        if (p==null)
            p = (String)System.getProperty(key);
//        System.out.println(key+":"+p);
        return p;
    }

    public static String getUploadPath() {
        return getProperty("application.upload.dir");
    }

    public static String getTempraryPath() {
        return getProperty("application.temp.dir");
    }

    public static String getTemporaryLogPath() {
        return getProperty("application.templog.dir");
    }

    public static String getUrl(){
        return getProperty("mostanadat.upload.dir");
    }
    public static String getUrl2(){
        return getProperty("mostanadat.upload.url");
    }

    public static ArrayList getArrayList(String keyName){
        ArrayList al = new ArrayList();
        //getAppResourcesProperties();

        al.add(new ComboObject(0, "------"));
        try {
            for (int i=0; ; i++) {
                String v = getProperty(keyName+"."+i);
                if (v!=null)
                    al.add(new ComboObject(i+1,v));
                else {
                    if (al.size()!=0)
                        com.objectj.emdad.ejb.util.Util.addList(keyName, al);
                    break;
                }
            }
        } catch (Exception e) {
            if (al.size()!=0)
                com.objectj.emdad.ejb.util.Util.addList(keyName, al);
            return al;
        }

        return al;
    }


    public static Properties getAppResourcesProperties() {
        if(appResourcePropertie == null) {
            appResourcePropertie = new Properties();
            try {
            appResourcePropertie.load(new FileInputStream(getAppResourcesPropertiesFile()));
            } catch (Exception e) {
                //=-= System.out.println(e);
            }
        }
        //=-= System.out.println("appResourcePropertie = " + appResourcePropertie);
        return appResourcePropertie;
    }


    public static File getAppResourcesPropertiesFile() throws IOException {
        if(appResourcePropertieFile == null) {
            String rscFolder = (String)System.getProperty("application-resources.dir");
            //String rscFolder = "C:/app/jsa-emdad/src/java/com/objectj/resources";
            //=-= System.out.println("rscFolder = " + rscFolder);
            appResourcePropertieFile = new File(rscFolder + "/ApplicationResources.properties");
            if(!appResourcePropertieFile.exists()) {
                //=-= System.out.println(appResourcePropertieFile + " didn't exist so we create a new folder");
            }
        }
        //=-= System.out.println(" appResourcePropertieFile = " + appResourcePropertieFile);
        return appResourcePropertieFile;
    }


    public static QueryObject parseFilter(String filterExp) throws Exception {
        String  table = "",
                field = "",
                type = "",
                operator = "",
                value = "";

        char typeChar;
        StringBuffer where = new StringBuffer ("");
        ArrayList tables = new ArrayList ();

//        log.info("Filter Expresion=" + filterExp);

        if (filterExp == null || filterExp.length() == 0)
        {
            //=-= System.out.println ("null or empty filter expresion.");
            return null;
        }

        StreamTokenizer searchExpTokenizer = new StreamTokenizer (new StringReader (filterExp)); //, ".' ()");

        searchExpTokenizer.quoteChar('\'');
        searchExpTokenizer.whitespaceChars('.', '.');
        searchExpTokenizer.whitespaceChars(' ', ' ');
        searchExpTokenizer.whitespaceChars('(', ')');
        searchExpTokenizer.wordChars('0', '9');
        searchExpTokenizer.wordChars('<', '<');
        searchExpTokenizer.wordChars('>', '>');
        searchExpTokenizer.wordChars('=', '=');
        searchExpTokenizer.slashStarComments(true);
        QueryObject qo = new QueryObject();

        String next;
        int retVal = searchExpTokenizer.nextToken();
        while (retVal != StreamTokenizer.TT_EOF)
        {
            //**** ignoring 'and's, 'or's and 'not's ********
            if (retVal != StreamTokenizer.TT_WORD)
            {
                throw new Exception ("Error: bad search expression (1):" + filterExp);
            }
            next = searchExpTokenizer.sval;

            while (com.objectj.emdad.ejb.util.Util.isNotEmpty(next) && (retVal != StreamTokenizer.TT_WORD || next.toUpperCase().equals(AND) || next.toUpperCase().equals(OR) || next.toUpperCase().equals(NOT)))
            {
                retVal = searchExpTokenizer.nextToken();
                next = searchExpTokenizer.sval;
//                log.info("next=["+next+"],retVal="+retVal);
            }
            if (com.objectj.emdad.ejb.util.Util.isEmpty(next))
                continue;

                //*************  table  *****************
            if (retVal != StreamTokenizer.TT_WORD)
            {
                throw new Exception ("Error: bad search expression (2):" + filterExp);
            }
            table = searchExpTokenizer.sval;
//            log.info("table="+table);


            //*************  field  *****************
            retVal = searchExpTokenizer.nextToken();
            if (retVal != StreamTokenizer.TT_WORD)
            {
                throw new Exception ("Error: bad search expression (3):" + filterExp);
            }
            field = searchExpTokenizer.sval;
//            log.info("field="+field);


            //*************  operator  ****************
            retVal = searchExpTokenizer.nextToken();
//            log.info("retVal="+retVal+","+searchExpTokenizer.sval);
            if (retVal != StreamTokenizer.TT_WORD)
            {
                throw new Exception ("Error: bad search expression (4):" + filterExp);
            }
            operator = searchExpTokenizer.sval;
//            log.info("operator="+operator);

            //*************  value  ****************
            retVal = searchExpTokenizer.nextToken();
            if (retVal != '\'')
            {
                throw new Exception ("Error: bad search expression (5):" + filterExp);
            }
            value = searchExpTokenizer.sval;
            typeChar = value.charAt(0);
            value = value.substring(1).trim();
//            log.info(value);

			if (operator.equals("LIKE"))
			{
				typeChar = 'S';
			}

            //**************  type  ****************
            switch (typeChar)
            {
                case 'I':
                case 'i':
                    type = "Integer";
                    break;

                case 'S':
                case 's':
                    type = "String";
                    break;

                case 'D':
                case 'd':
                    type = "Date";
                    if (HejriUtil.hejriToChris(value) != null)
                        value = HejriUtil.hejriToChris(value).toString();
                    else
                        value = "1990-01-01";
                    break;

                case 'T':
                case 't':
                    type = "Date";
                    if (HejriUtil.hejriToChris(value) != null)
                        value = HejriUtil.hejriToChris(value).toString();
                    else
                        value = "1990-01-01";
                    break;

                case 'F':
                case 'f':
                    type = "Field";
                    break;

                default:
                    throw new Exception ("Error: value type unknown: '" + typeChar + "' in " + filterExp);
            }

//            log.info("type="+type);
//            log.info(" value = " + value);
            ////=-= System.out.println("------------------------------");
            if (!type.equals("Field"))
            {
                qo.addElement(new QueryElement(type, value));
                if (!tables.contains(table))
                    tables.add (table);
            }
            retVal = searchExpTokenizer.nextToken();
//            log.info("retVal="+retVal);
        }

        //**************** generating where clause *******************
        int index1 = 0,
            index2;

        while ((index2 = filterExp.indexOf("'", index1)) != -1)
        {
            where.append (filterExp.substring(index1, index2));
            index1 = filterExp.indexOf("'", index2 + 1) + 1;
            if (filterExp.toUpperCase().charAt(index2 + 1) != 'F')
                where.append ("?");
            else
                where.append (filterExp.substring(index2 + 2, index1 - 1));
        }

        where.append (filterExp.substring(index1));

        index1 = 0;
        while ((index1 = where.indexOf("/*")) != -1) {
            where.replace(index1, index1 + 2, " ");
        }

        index1 = 0;
        while ((index1 = where.indexOf("*/")) != -1) {
            where.replace(index1, index1 + 2, " ");
        }

        //=-= System.out.println("~~~~~~ where = " + where);
        //************************************************************

        ////=-= System.out.println (tables.toString().substring(1,tables.toString().length()-1));
        qo.setTables(tables.toString().substring(1,tables.toString().length()-1));
        String s = where.toString();
        qo.setWhere(s.replace('"' , '\''));

        return qo;
        }

    public static String getIdWithO(BaseActionContext ctx, String id, String entityIdName) throws Exception {
        return getIdWithO(ctx.getConnection(), ctx.getValueObjectClassName(), id, ctx.getEntity(), entityIdName);
    }

    public static String getIdWithO(Connection c,String valueObjectClassName, String id, String entity, String entityIdName) throws Exception {
//        //=-= System.out.println("getIdWithO---id="+id);
        if (id!=null)
            id = id.trim();
        if ( id!=null && !id.endsWith("o")) {
            if (entityIdName==null)
                entityIdName = entity+"Id";
//            log.info("withO="+"SELECT "+entity+".id as id, "+entityIdName+" FROM  "+entity+" where  "+entityIdName+" = '" + id + "'");
            id = UserAccessEntity.stringQuery("SELECT "+entity+".id as id, "+entityIdName+" FROM  "+entity+" where  "+entityIdName+" = '" + id + "'", "id", c);
            if (id!=null && id.length()==0)
                id = null;
//            QueryObject qo =  new QueryObject(entity, entity, entityIdName, false);
//            qo.setSelectFields(entity+".id as id, "+entityIdName);
//            qo.setWhere(entityIdName+" = '" + id + "'");
//            String prefix = valueObjectClassName.substring(0, valueObjectClassName.lastIndexOf("Model"));
//            Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
//            ResultSet rs = (ResultSet)o.getClass().getMethod("advanceRead", new Class[] {java.sql.Connection.class, QueryObject.class }).invoke(o, new Object[] {c,  qo });
//            if (rs.next()) {
//                id = rs.getString("id");
//            } else {
//                id = null;
//            }
//            if (rs!=null) rs.close();
        }
        return id;
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

    public static ResultSet advanceRead(Connection c, QueryObject queryObject) throws FinderException {
        try {
            String selectStatement = getStatement(queryObject) ;
            PreparedStatement prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            setParameters(queryObject, prepStmt);
            log.info("Util, ResultSet advancedread, Query : "+ selectStatement);
            ResultSet resultSet = prepStmt.executeQuery();
            return  resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList advanceRead(QueryObject queryObject) throws FinderException {
        Connection c = null;
        ArrayList al = new ArrayList();
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        try {
            c = com.objectj.emdad.ejb.util.Util.getConnection();
            //String selectStatement = "SELECT * " + "FROM " + queryObject.getTables() + " ";
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
            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            setParameters(queryObject, prepStmt);
            long t1 = (new java.util.Date()).getTime();
            resultSet = prepStmt.executeQuery();
            log.info("Util, ArrayList advancedread,"+"Time="+((new java.util.Date()).getTime()-t1)+", Query : "+ selectStatement);
            if (resultSet!=null) {
                int columnCount = resultSet.getMetaData().getColumnCount();
//                log.info("Util, ArrayList advancedread, columnCount : "+ columnCount );
                while (resultSet.next()) {
                    ArrayList al2 = new ArrayList();
                    for (int i = 1; i <= columnCount; i++)
                        al2.add(resultSet.getObject(i));
                    al.add(al2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (resultSet!=null)
                    resultSet.close();
                c.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
        return al;
    }

    public static QueryResult readCombo(BaseActionContext ctx, String table, String field, String filter, String order) throws ProxyException {
        try {
            QueryObject queryObject = new QueryObject();
            queryObject.setJoined(false);
            queryObject.setTables(table);
            queryObject.setSelectFields("id, " + field);
            if (table.indexOf("view")==-1)
                queryObject.setOrderTable(table);
            if (order==null || order.length()==0)
                queryObject.setOrderField(field);
            else
                queryObject.setOrderField(order);
            queryObject.setOrderType("ASC");
            if (filter != null && filter.length() > 0)
                queryObject.setWhere(filter);

            ArrayList al = advanceRead(queryObject);

            ArrayList list = new ArrayList();
            list.add(new ComboObject("", BaseAction.ADD_TO_COMBO_LIST));

            for (int i=0; i<al.size(); i++) {
                ArrayList al2 = (ArrayList) al.get(i);
                list.add(new ComboObject((String)al2.get(0), (String)al2.get(1)));
            }
            return new QueryResult(list, list.size());

        } catch (Exception exception) {
            exception.printStackTrace(System.out);
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

    public static void updateQuery(String stmnt, Connection c) throws FinderException {
        PreparedStatement prepStmt = null;
        try {
            log.info("updateQuery :" + stmnt);
            prepStmt = c.prepareStatement(stmnt); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            prepStmt.executeUpdate();
            return  ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            if (prepStmt!=null)
                prepStmt.close();
            } catch (Exception e) {}
        }
        return ;
    }

    public static boolean hasReplicate(ArrayList al, String id) {
        if (al==null || al.size()<1)
            return false;
        if (al.size()>1)
            return true;
        if (id!=null && id.length()!=0) {
            ArrayList al2 = (ArrayList) al.get(0);
            return !((al2.get(0)).equals(id));
        }
        return true;
    }

    public static boolean hasReplicate(ResultSet rs2, String id) {
        try {
            if (rs2==null)
                return false;
            boolean b = rs2.next();
            String s = null;
            if (b)
                s = rs2.getString("id");
            boolean b2 = rs2.next();
            closeResources(rs2);
            if (b2 || (!s.equals(id))) {
                return true;
            }
        } catch (Exception e) {}
        return false;
    }

    public static void closeResources(ResultSet rs2) {
        try {
            if (rs2==null)
                return ;
            if ( rs2.getStatement()!=null)
                rs2.getStatement().close();
            rs2.close();
        } catch (Exception e) {}
    }

    protected static void setParameters(QueryObject queryObject, PreparedStatement prepStmt) throws SQLException, NumberFormatException {
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

    public static String getIdFromList(ArrayList al, String enId) {
        int size = al.size();
        int d = -1;
        for (int i=0; i<size ; i++) {  // && d<0
            if  (((ComboObject)al.get(i)).getName().equals(enId))
                return ((ComboObject)al.get(i)).getEid();
//            log.info("["+((ComboObject)al.get(i)).getName()+"]["+enId+"]"+d);
//            if ( d==0)
//                return ((ComboObject)al.get(i)).getEid();
        }
        return null;
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
        byte[] bytes = new byte[4096];
        int len = -1;
        while( (len=in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
    }

    public static UserSession getUserSession(HttpServletRequest request) {
        HttpSession session  = request.getSession();
        UserSession userSession = null;

        try {
            userSession = (UserSession) session.getAttribute(Constants.USER_SESSION);
        } catch (Exception e) {
            userSession = null;
        }
        if (userSession==null) {
            Principal principal = request.getUserPrincipal();
            try {
                userSession = new UserSession(request);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            if (principal != null)
                session.setAttribute(Constants.USER_SESSION, userSession);
        }
        return userSession;
    }
}
