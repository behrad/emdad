/*
 * Adapter.java
 *
 * Created on March 9, 2003, 2:49 PM
 */

package com.objectj.jsa.web;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.validator.DynaValidatorForm;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.QueryResult;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.ejb.UserAccessEntity;

import java.sql.*;


/**
 *
 * @author  hossein
 */
public class Exchanger {

    protected static Logger log = Logger.getLogger(Exchanger.class.getName());

    public static String exhangeFilterFormToFilter(DynaValidatorForm form, ValueObject valueObject) {
        if (valueObject==null || form==null)
            return "";
        Class voClass = valueObject.getClass();
        Map map = form.getMap();
        StringBuffer filter = new StringBuffer();
        int i = 0;

        for(Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
            // all keys start with fr_ or to_
            String key = (String)iter.next();
            Object value = map.get(key);
            if(value != null) {
                try {
                    String key2 = key.substring(3); // skip the fr_ or to_ prefix
                    Field f = voClass.getDeclaredField(key2);
                    String c;
                    String op;
                    if (f.getType().getName().equals("java.lang.String"))
                        c="\"";
                    else
                        c="";
                    if (value.toString().length()>0) {
                        if (filter.length()>0)
                            filter.append(" AND ");
                        op = (String)map.get("op_"+key2);
                        filter.append("o.").append(key2).append(op).append(c).append(value).append(c);
                    }
                } catch(Exception exception) {
                    log.warn("Ignoring the following excepiton" + exception);
                }
            }
        }
        return filter.toString();
    }

    public static String exhangeFormToFilter(DynaValidatorForm form, Class voClass, BaseAction action, String entity) {
        if (form==null)
            return "";
        String safeEntity = entity;
        Map map = form.getMap();
        StringBuffer filter = new StringBuffer();
        int i = 0;
//        log.info("Exchanger map= "+map);

        for(Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            Object value = map.get(key);
            String type = "";
            entity = safeEntity;
            if(value != null) {
                try {
                    try {
                        Field f = voClass.getDeclaredField(key);
                        type = f.getType().getName();
                        if (type.startsWith("java.lang"))
                            type = type.substring(10);
                        else
                            type = type.substring(9);
//                        log.info("type = " + type);
                    } catch (Exception e) {
                        if (key.endsWith("Id") ){
                            if (action.isInRelatedEntities(key.substring(0, key.length()-2))) {
                                type = "String";
                            } else
                                if (key.indexOf(".")>0 ) {
                                    type = "String";
                                    entity = "";
                                } else
                                    value = null;
                        }else {
                            if (key.indexOf(".")>0 ) {
                                type = "String";
                                entity = "";
                            } else
                                value = null;
                        }

                    }
//                    log.info("key="+key +" ,value="+value+", type="+type);
                    if (value!=null && value.toString().length()>0) {
                        String vs = value.toString();
                        if (vs.length()>0) {
                            switch (type.charAt(0)) {
                                case 's' :
                                case 'S' :
                                    if (filter.length()>0)
                                        filter.append(" AND ");
                                    if (vs.indexOf('%')==-1)
                                        filter.append(entity).append((entity.length() > 0 ? "." : "")).append(key).append(" LIKE '").append(type.substring(0, 1)).append("%").append(value).append("%'"); //append(vs.endsWith("%") ? "" : "%").
                                    else
                                       filter.append(entity).append((entity.length() > 0 ? "." : "")).append(key).append(" LIKE '").append(type.substring(0, 1)).append(value).append("'"); //append(vs.endsWith("%") ? "" : "%").
                                    //filter.append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" LIKE '").append(type.substring(0,1)).append("%").append(value).append("%'"); //append(vs.endsWith("%") ? "" : "%").
                                    break;
/*                                case 'd' :
                                case 'D' :
                                    if (filter.length()>0)
                                        filter.append(" AND ");
                                    filter.append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" LIKE '").append(type.substring(0,1)).append("%").append(value).append("%'");
                                    break;*/
                                case 'd' :
                                case 'D' :
                                    if (filter.length()>0)
                                        filter.append(" AND ");
                                    filter.append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" = '").append(type.substring(0,1)).append(value).append("'");
                                    break;
                                case 't' :
                                case 'T' :
                                    if (filter.length()>0)
                                        filter.append(" AND ");
                                    filter.append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" >= 'T").append(value).append("' AND ").append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" < 'T").append(com.objectj.emdad.ejb.util.HejriUtil.incDayInHejriDate((String)value)).append("' ");
                                    break;
                                case 'i' :
                                case 'I' :
                                    if (!vs.equals("0")) {
                                        if (filter.length()>0)
                                            filter.append(" AND ");
                                        filter.append(entity).append((entity.length()>0 ? "." : "")).append(key).append(" = '").append(type.substring(0,1)).append(value).append("'");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } catch(Exception exception) {
                    log.warn("Ignoring the following excepiton key="+key +" ,value="+value+" , " + exception);
                }
            }
        }
//        log.info("********filter.toString() = " + filter.toString());
        return filter.toString();
    }

    public static void exhangeFormToValueObject(DynaValidatorForm form, ValueObject valueObject) {
        if (valueObject==null || form==null)
            return;
        Class voClass = valueObject.getClass();
        Map map = form.getMap();
        for(Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
            String key = (String)iter.next();
            Object value = map.get(key);
            String methodName = "set" + key.toUpperCase().substring(0, 1) + key.substring(1);
            if(value != null) {
                try {
                    Method method = voClass.getMethod(methodName, (new Class[] { value.getClass() }) );
                    //log.info("Running method " + method);
                    method.invoke(valueObject, (new Object[] { value }));
                } catch(Exception exception) {
//                    log.warn("Ignoring the following excepiton" + exception);
                }
            }
        }
    }

    public static void exhangeValueObjectToForm(ValueObject valueObject, DynaValidatorForm form)  {
        if (valueObject==null || form==null)
            return ;
//        log.info("start of exhangeValueObjectToForm");
        Class voClass = valueObject.getClass();
        Method[] methods = voClass.getMethods();
        for(int index = 0; index != methods.length; index++) {
            Method method = methods[index];
            if(method.getName().startsWith("get")) {
                String key = method.getName().substring(3);
                key = key.toLowerCase().substring(0, 1) + key.substring(1);
                try {
                    Object value = method.invoke(valueObject, (new Object[] { }));
                    ////=-= //=-= //=-= System.out.println("-------> " + key + " " + value);
                    //if(value != null) {
                        form.set(key, value);
                    //} else
                    //    form.set(key, "");
                } catch(Exception exception) {
//                    log.warn("Ignoring the following exception " + exception);
                }
            }

        }
//        log.info("end of exhangeValueObjectToForm");
    }

    public static void exhangeResultSetToValueObject(String selectStatement, ValueObject[] valueObjects) {
        if (valueObjects==null || valueObjects.length==0 || selectStatement==null)
            return;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        Connection c = null;
        try {
            c = com.objectj.emdad.ejb.util.Util.getConnection();
            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            log.info("exhangeResultSetToValueObject, Query : "+ selectStatement);
            rs = prepStmt.executeQuery();
            if (rs!=null)
                rs.next();
            for (int j=0; j<valueObjects.length; j++) {
                com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, valueObjects[j]);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (rs!=null)
                    rs.close();
                c.close();
            } catch (Exception e) {}
        }
    }

    public static void exhangeResultSetToValueObject(Connection c, String selectStatement, ValueObject[] valueObjects) {
        if (valueObjects==null || valueObjects.length==0 || selectStatement==null)
            return;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            log.info("exhangeResultSetToValueObject, Query : "+ selectStatement);
            rs = prepStmt.executeQuery();
            if (rs!=null)
                rs.next();
            for (int j=0; j<valueObjects.length; j++) {
                com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, valueObjects[j]);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {}
        }
    }

    public static void exhangeResultSetToValueObject(Connection c, QueryObject queryObject, ValueObject[] valueObjects) {
        if (valueObjects==null || valueObjects.length==0 || queryObject==null)
            return;
        exhangeResultSetToValueObject(c, Util.getStatement(queryObject), valueObjects) ;
    }

    public static QueryResult exhangeResultSetToValueObjectArray(Connection c, QueryObject queryObject, EntityProxy proxy, ValueObject vo, boolean isList) {
        ArrayList al = new  ArrayList();
        if (queryObject==null)
            return new QueryResult(al);
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        Connection c2 = c;
        int i = 0;
        try {
            String selectStatement = Util.getStatement(queryObject) ;
            if (c2==null)
                c2 = com.objectj.emdad.ejb.util.Util.getConnection();
            prepStmt = c2.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            long t1 = (new java.util.Date()).getTime();
            rs = prepStmt.executeQuery();
            log.info("exhangeResultSetToValueObjectArray,"+"Time="+((new java.util.Date()).getTime()-t1)+", Query : "+ selectStatement);

            int fromIndex = queryObject.getFromIndex();
            int toIndex = queryObject.getToIndex();
            toIndex = fromIndex > toIndex ? fromIndex : toIndex;
            if (fromIndex > 1 || toIndex > 1) {

                if (fromIndex > 1) {
                    rs.absolute(fromIndex - 1);
                }
                if (fromIndex <= toIndex) {
                    i = fromIndex - 1;
                    while (rs.next()) {
                        i++;
                        if ((i >= fromIndex) && (i <= toIndex)) {
                            ValueObject vo2 = null;
                            if (isList)
                                vo2 = proxy.resultSetToList(rs);
                            else {
                                vo2 =  (ValueObject) vo.getClass().newInstance();
                                com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, vo2);
                            }
                            al.add(vo2);
                        } else
                            if (i > toIndex) {
                                rs.last();
                                i = rs.getRow();
                            }
                    }
                }
            } else {
				while (rs.next()) {
                    i++;
                    ValueObject vo2 = null;
                    if (isList)
                        vo2 = proxy.resultSetToList(rs);
                    else {
                        vo2 =  (ValueObject) vo.getClass().newInstance();
                        com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, vo2);
                    }
                    al.add(vo2);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
//                log.info("prepStmt!=null");
                if (rs!=null)
                    rs.close();
//                log.info("rs!=null");
                if (c==null)
                    c2.close();
            } catch (Exception e) {}
        }
        if (queryObject.getSelectFields().trim().toLowerCase().indexOf("top ")==0) {
            String cs = "select count(*) as tedad from "+queryObject.getTables()+" ";
            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(queryObject.getWhere()))
                cs += " "+queryObject.getWhere()+" ";
            cs = UserAccessEntity.stringQuery(cs, "tedad", c);
            i = Integer.parseInt(cs);
        }
//        log.info("al.size()="+al.size());
        return new QueryResult(al, i);
    }

}
