package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.UserSession;
import com.objectj.emdad.proxy.util.FarsiComparator;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.Exchanger;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ProxySessionEJB implements EntityProxy {

	protected abstract Class getValueObjectClass();

	protected static Logger log = Logger.getLogger(ProxySessionEJB.class.getName());
    protected String getUpdateRelaStatement() { return null; };

	public ValueObject create() throws ProxyException {
		try {
			Class aClass = getValueObjectClass();
			log.info("Creating new " + aClass + " in database and generate and id for it");
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("create", new Class[] {}).invoke(o, new Object[] {});
			o = o.getClass().getMethod("get" + prefix.substring(prefix.lastIndexOf('.') + 1) + "Model", new Class[] {}).invoke(o, new Object[] {});
			return (ValueObject)o;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject create(ValueObject valueObject) throws ProxyException {
		try {
			Class aClass = valueObject.getClass();
			log.info("Creating new " + aClass + " in database from ...");
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("create", new Class[] { aClass }).invoke(o, new Object[] { valueObject });
			o = o.getClass().getMethod("get" + prefix.substring(prefix.lastIndexOf('.') + 1) + "Model", new Class[] {}).invoke(o, new Object[] {});
			return (ValueObject)o;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public void update(ValueObject valueObject) throws ProxyException {
		try {
			Class aClass = valueObject.getClass();
			Object pkO = aClass.getMethod("getId", new Class[] {}).invoke(valueObject, new Object[] {});
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("findByPrimaryKey", new Class[] { String.class }).invoke(o, new Object[] { pkO });
			o = o.getClass().getMethod("set" + prefix.substring(prefix.lastIndexOf('.') + 1) + "Model", new Class[] { aClass }).invoke(o, new Object[] { valueObject });
			return;
		} catch (Exception exception) {
            exception.printStackTrace();
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

    public void updateRela(String id, String[] relaIds) throws ProxyException {
        try {
            //log.info("getUpdateRelaStatement()="+getUpdateRelaStatement());
            if (com.objectj.emdad.ejb.util.Util.isEmpty(getUpdateRelaStatement()))
                return;
            PreparedStatement prepStmt = null;
            Connection c = null;
            try {
            String selectStatement = getUpdateRelaStatement();
            c = Util.getConnection();
            prepStmt = c.prepareStatement(selectStatement); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int i = 1;
            prepStmt.setString(i++, id);
            for (int j=0; j<relaIds.length; j++)
                prepStmt.setString(i++, relaIds[j]); //shahrId
            prepStmt.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (c!=null)
                    c.close();
                } catch (Exception e) {}
            }
            return;
        } catch (Exception exception) {
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

	public void remove(ValueObject valueObject) throws ProxyException, ProxyReferenceException {
		Object pkO;
		try {
			Class aClass = valueObject.getClass();
			pkO = aClass.getMethod("getId", new Class[] {}).invoke(valueObject, new Object[] {});
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
		remove((String)pkO);
	}

	public void remove(String id) throws ProxyException, ProxyReferenceException {
		try {
			//Connection connection = Util.getConnection();
			Class aClass = getValueObjectClass();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("findByPrimaryKey", new Class[] { String.class }).invoke(o, new Object[] { id });
			// use myRemove to solve a bug on Referential Integrity of CMP
			o = o.getClass().getMethod("myRemove", new Class[] {}).invoke(o, new Object[] {});
			try {
				o = o.getClass().getMethod("remove", new Class[] {}).invoke(o, new Object[] {});
			} catch (Exception exception) {}
			//connection.close();
			return;
		} catch (Exception exception) {
			log.error(exception);
			if (exception.getCause().getClass().getName().equals("com.objectj.jsa.proxy.ProxyReferenceException")) {
				throw new ProxyReferenceException(exception);
			}
            exception.printStackTrace();
			throw new ProxyException(exception);
		}
	}

	public void remove(String[] ids) throws ProxyException, ProxyReferenceException {
		try {
			Connection connection = Util.getConnection();
			Class aClass = getValueObjectClass();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object oHome = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			for (int j = 0; j < ids.length; j++) {
				String id = ids[j];
				Object o = oHome.getClass().getMethod("findByPrimaryKey", new Class[] { String.class }).invoke(oHome, new Object[] { id });
				// use myRemove to solve a bug on Referential Integrity of CMP
				o = o.getClass().getMethod("myRemove", new Class[] {}).invoke(o, new Object[] {});
				try {
					o = o.getClass().getMethod("remove", new Class[] {}).invoke(o, new Object[] {});
				} catch (Exception exception) {}
			}
			connection.close();
			return;

		} catch (Exception exception) {
			log.error(exception);
			if (exception.getCause().getClass().getName().equals("com.objectj.jsa.proxy.ProxyReferenceException")) {
				throw new ProxyReferenceException(exception);
			}
			throw new ProxyException(exception);
		}
	}

	public ValueObject read(String id) throws ProxyException {
		try {
			Class aClass = getValueObjectClass();
            long t1 = (new java.util.Date()).getTime();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("findByPrimaryKey", new Class[] { String.class }).invoke(o, new Object[] { id });
            long t2 = (new java.util.Date()).getTime();
            ValueObject vo = modelToList(o);
            long now = (new java.util.Date()).getTime();
            log.info("-- read time("+aClass.getName()+")="+(now-t1)+","+(now-t2));
			return vo;
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ProxyException(exception);
		}
	}

	public QueryResult read(ValueObject valueObject) throws ProxyException {
		return null;
	}

	public QueryResult read(String[] ids) throws ProxyException {
		return null;
	}

	public QueryResult readByEntityId(java.lang.Integer entityId) throws ProxyException {
		try {
			Class aClass = getValueObjectClass();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
			o = o.getClass().getMethod("findByEntityId", new Class[] { java.lang.Integer.class }).invoke(o, new Object[] { entityId });
			Collection collection = (Collection)o;
			ArrayList list = new ArrayList();
			for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
				Object oo = iterator.next();
				oo = oo.getClass().getMethod("get" + prefix.substring(prefix.lastIndexOf('.') + 1) + "Model", new Class[] {}).invoke(oo, new Object[] {});
				list.add(oo);
			}
			return new QueryResult(list);

		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public QueryResult readModel(QueryObject queryObject) throws ProxyException {
        return readListAndModel(queryObject, false);
//		try {
//			Connection connection = Util.getConnection();
//			Class aClass = getValueObjectClass();
//
//			queryObject.setJoined(false);
//
//			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
//			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
////			log.info("readModel , before query");
//			ResultSet rs = (ResultSet)o.getClass().getMethod("advanceRead", new Class[] { java.sql.Connection.class, QueryObject.class }).invoke(o, new Object[] { connection, queryObject });
////			log.info("readModel , after query");
//
//			ArrayList list = new ArrayList();
//			int fromIndex = queryObject.getFromIndex();
//			int toIndex = queryObject.getToIndex();
//			toIndex = fromIndex > toIndex ? fromIndex : toIndex;
//			int i = 0;
//			//            log.info("fromIndex="+fromIndex+",toIndex="+toIndex);
//
//			// if we shall read LIMIT
//			if (fromIndex != 0 || toIndex != 0) {
//				//                log.info("readModel , 11111111111");
//				if (fromIndex > 1)
//					rs.absolute(fromIndex - 1);
//				//                log.info("readModel , 2222222222");
//
//				// validation of Index bound
//				if (fromIndex > toIndex) {
//					connection.close();
//					return new QueryResult(list, 0);
//				}
//				i = fromIndex - 1;
//				//                log.info("readModel , 3333333333");
//				while (rs.next()) {
//					i++;
//					if ((i >= fromIndex) && (i <= toIndex)) {
//						if (queryObject.getSelectFields().equals("*")) {
//							list.add(resultSetToBean(rs));
//						} else {
//							list.add(resultSetToArrayList(rs));
//						}
//					} else
//						if (i > toIndex) {
//							rs.last();
//							i = rs.getRow();
//						}
//				}
//			} else {
//				//                log.info("readModel , 555555555555");
//				while (rs.next()) {
//					//                    log.info("readModel , 66666666666666666");
//					if (queryObject.getSelectFields().equals("*")) {
//						list.add(resultSetToBean(rs));
//					} else {
//						list.add(resultSetToArrayList(rs));
//					}
//					i++;
//				}
//			}
//
//			//            log.info("readModel , 7777777777777");
//			// if we shall sort
//			//			if (queryObject.getOrderField() != null && !queryObject.getOrderField().equals("") && queryObject.getSelectFields().equals("*")) {
//			//				if (queryObject.getOrderType().equals("") || queryObject.getOrderType() == null)
//			//					queryObject.setOrderType("ASC");
//			//				fixFarsiSort(list, queryObject.getOrderField(), queryObject.getOrderType());
//			//			}
//			//            log.info("readModel , aakharash");
//			if (rs.getStatement()!=null)
//                rs.getStatement().close();
//            rs.close();
//			connection.close();
//            rs = null;
//            connection = null;
//			//            log.info("readModel , tamoom shod");
//			//rs.getStatement().getConnection().close();
//			//rs.close();
//			//            log.info(list.size()+","+i);
//			return new QueryResult(list, i);
//
//		} catch (Exception exception) {
//			log.error(exception);
//			exception.printStackTrace(System.out);
//			throw new ProxyException(exception);
//		}
	}

    private QueryResult readListAndModel(QueryObject qObject, boolean isList) throws ProxyException {
        ArrayList al = new  ArrayList();
        if (qObject==null)
            return new QueryResult(al);
        boolean isSQL = isDatabaseSQL();
        QueryObject queryObject = qObject.getClone();

        if (queryObject.getTables().equals("emdadList") &&
                com.objectj.emdad.ejb.util.Util.isEmpty(queryObject.getWhere())) {
            Exception e = new Exception("ERROR in emdadList");
            log.info("ERROR in emdadList",e);
            QueryResult qr = new QueryResult(al);
            qr.setHasError(true);
            return qr;
        }

        int fromIndex = queryObject.getFromIndex();
        int toIndex = queryObject.getToIndex();
        toIndex = fromIndex > toIndex ? fromIndex : toIndex;
        if (toIndex==0 || toIndex>9999)
            toIndex = 9999;
        if (isSQL) {
            if (queryObject.getSelectFields().trim().toLowerCase().indexOf("top ")!=0)
                queryObject.setSelectFields("TOP " + toIndex + " "+queryObject.getSelectFields());
        } else {
            String w = queryObject.getWhere();
            if (w!=null && w.trim().toLowerCase().indexOf(" rownum < ")==-1) {
                if ( Util.isNotEmpty(w))
                    w += " and ";
                queryObject.setWhere(w+" rownum < " + toIndex+" ");
            }
        }

        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        Connection c = null;
        Class aClass = getValueObjectClass();
        int i = 0;
        try {
            c = com.objectj.emdad.ejb.util.Util.getConnection();
            String selectStatement = Util.getStatement(queryObject) ;
            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Util.setParameters(queryObject, prepStmt);
            long t1 = (new java.util.Date()).getTime();
            rs = prepStmt.executeQuery();
            log.info("readListAndModel, Time="+((new java.util.Date()).getTime()-t1)+",Query : "+ selectStatement);

//            if (fromIndex != 0 || toIndex != 0) {

                if (fromIndex > 1) {
                    rs.absolute(fromIndex - 1);
                }
                if (fromIndex <= toIndex) {
                    i = fromIndex - 1;
                    while (rs.next() && i < toIndex) {
                        i++;
                        if ((i >= fromIndex) && (i <= toIndex)) {
                            ValueObject vo2 = null;
                            if (isList)
                                vo2 = resultSetToList(rs);
                            else {
                                vo2 =  (ValueObject) aClass.newInstance();
                                com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, vo2);
                            }
                            al.add(vo2);
                        }
                    }
                }
//            } else {
//				while (rs.next()) {
//                    ValueObject vo2 = (ValueObject) aClass.newInstance();
//                    com.objectj.emdad.ejb.util.Util.resultSetToValueObject(rs, vo2);
//                    al.add(vo2);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        if (i >= toIndex)
        if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0){
            if(queryObject.getWhere().indexOf(" Order By ")==-1)
                i = count(c, qObject.getClone());
        }
        else
            i = count(c, qObject.getClone());
//		if (isDatabaseSQL()) {
//			if (queryObject.getSelectFields().trim().toLowerCase().indexOf("top ")==0)
//				i = count(c, queryObject.getClone());
//		} else {
//            i = count(c, queryObject.getClone());
//		}

        try {
            c.close();
        } catch (Exception e) {
        }
        return new QueryResult(al, i);
    }

    public QueryResult readList(QueryObject queryObject) throws ProxyException {
        return readListAndModel(queryObject, true);
//        ArrayList al = new  ArrayList();
//        if (queryObject==null)
//            return new QueryResult(al);
//        ResultSet rs = null;
//        PreparedStatement prepStmt = null;
//        Connection c = null;
//        Class aClass = getValueObjectClass();
//        int i = 0;
//        try {
//            c = com.objectj.emdad.ejb.util.Util.getConnection();
//            String selectStatement = com.objectj.emdad.web.util.Util.getStatement(queryObject) ;
//            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            log.info("exhangeResultSetToValueObjectArray, Query : "+ selectStatement);
//            rs = prepStmt.executeQuery();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            int fromIndex = queryObject.getFromIndex();
//            int toIndex = queryObject.getToIndex();
//            toIndex = fromIndex > toIndex ? fromIndex : toIndex;
//            if (fromIndex != 0 || toIndex != 0) {
//
//                if (fromIndex > 1) {
//                    rs.absolute(fromIndex - 1);
//                }
//                if (fromIndex <= toIndex) {
//                    i = fromIndex - 1;
//                    while (rs.next()) {
//                        i++;
//                        if ((i >= fromIndex) && (i <= toIndex)) {
//                            ValueObject vo2 = null;
//                            if (isList)
//                                vo2 = resultSetToList(rs);
//                            else {
//                                vo2 =  (ValueObject) aClass.newInstance();
//                                Exchanger.ResultSetToValueObject(rs, vo2);
//                            }
//                            al.add(vo2);
//                        } else
//                            if (i > toIndex) {
//                                rs.last();
//                                i = rs.getRow();
//                            }
//                    }
//                }
//            } else {
//				while (rs.next()) {
//                    ValueObject vo2 = (ValueObject) aClass.newInstance();
//                    Exchanger.ResultSetToValueObject(rs, vo2);
//                    al.add(vo2);
//                }
//            }
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                if (prepStmt!=null)
//                    prepStmt.close();
//                if (rs!=null)
//                    rs.close();
//            } catch (Exception e) {}
//        }
//        if (queryObject.getSelectFields().trim().toLowerCase().indexOf("top ")==0) {
//            String cs = "select count(*) as tedad from "+queryObject.getTables();
//            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(queryObject.getWhere()))
//                cs += queryObject.getWhere();
//            cs = UserAccessEntity.stringQuery(cs, "tedad", c);
//            i = Integer.parseInt(cs);
//        }
//        log.info("al.size()="+al.size());
//        return new QueryResult(al, i);
    }

	public QueryResult readList2(QueryObject queryObject) throws ProxyException {
		try {
			Connection connection = Util.getConnection();
			Class aClass = getValueObjectClass();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
//			log.info("readList , before query");
			ResultSet rs = (ResultSet)o.getClass().getMethod("advanceRead", new Class[] { java.sql.Connection.class, QueryObject.class }).invoke(o, new Object[] { connection, queryObject });
//			log.info("readList , after query");

			ArrayList list = new ArrayList();
			int fromIndex = queryObject.getFromIndex();
			int toIndex = queryObject.getToIndex();
			toIndex = fromIndex > toIndex ? fromIndex : toIndex;
			int i = 0;
//            int[] cols = findColumns();

			// if we shall read LIMIT
			if (fromIndex != 0 || toIndex != 0) {

				if (fromIndex > 1) {
					rs.absolute(fromIndex - 1);
                }

				// validation of Index bound
				if (fromIndex > toIndex) {
					connection.close();
					return new QueryResult(list, 0);
				}
				i = fromIndex - 1;

				while (rs.next()) {
					i++;
					if ((i >= fromIndex) && (i <= toIndex)) {
						if (queryObject.getSelectFields().equals("*") || queryObject.isView()) {
							list.add(resultSetToList(rs));
						} else {
							list.add(resultSetToArrayList(rs));
						}

					} else
						if (i > toIndex) {
							rs.last();
							i = rs.getRow();
						}
				}

			} else {
				while (rs.next()) {
					if (queryObject.getSelectFields().equals("*") || queryObject.isView()) {
						list.add(resultSetToList(rs));
					} else {
						list.add(resultSetToArrayList(rs));
					}
				}
			}

//			log.info("isView : " + queryObject.isView());
			if (queryObject.getSelectFields().trim().toLowerCase().indexOf("top ")==0){
                //i = count( , queryObject.getClone()); //todo
            }

						log.info(" ProxySession, readList , after resultSetToList");

			// if we shall sort
			//			if (queryObject.getOrderField() != null && !queryObject.getOrderField().equals("") && queryObject.getSelectFields().equals("*")) {
			//				if (queryObject.getOrderType().equals("") || queryObject.getOrderType() == null)
			//					queryObject.setOrderType("ASC");
			//				fixFarsiSort(list, queryObject.getOrderField(), queryObject.getOrderType());
			//
			//			}
            rs.getStatement().close();
            log.info(" ProxySession, readList , after 000000000");
            rs.close();
            log.info(" ProxySession, readList , after 111111111");
			connection.close();
						log.info(" ProxySession, readList , after 2222222222");

			return new QueryResult(list, i);

		} catch (Exception exception) {
			log.error(exception);
			exception.printStackTrace(System.out);
			throw new ProxyException(exception);
		}
	}

	public QueryResult readCombo(String table, String field) throws ProxyException {
		return readCombo(table, field, null, null);
	}

    public QueryResult readCombo(String table, String field, String filter) throws ProxyException {
        return readCombo(table, field, filter, null);
    }

	public QueryResult readCombo(String table, String field, String filter, String order) throws ProxyException {
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

//            ArrayList al = new  ArrayList();
            ResultSet rs = null;
            PreparedStatement prepStmt = null;
            ArrayList list = new ArrayList();
            Connection c = null;

//            Class aClass = getValueObjectClass();
//            int i = 0;
            try {
                c = com.objectj.emdad.ejb.util.Util.getConnection();
                String selectStatement = Util.getStatement(queryObject) ;
                log.info("readCombo:"+selectStatement);
                prepStmt = c.prepareStatement(selectStatement); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                Util.setParameters(queryObject, prepStmt);
//                log.info("readCombo, Query : "+ selectStatement);
                rs = prepStmt.executeQuery();
//
//			Connection connection = Util.getConnection();
//
//			Class aClass = getValueObjectClass();
//			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
//			//log.info("--000000---");
//			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
//			//log.info("--111111---");
//			ResultSet rs = (ResultSet)o.getClass().getMethod("advanceRead", new Class[] { java.sql.Connection.class, QueryObject.class }).invoke(o, new Object[] { connection, queryObject });
//			//log.info("--222222---");

                list.add(new ComboObject("", BaseAction.ADD_TO_COMBO_LIST));

                while (rs.next()) {
                    ComboObject comboObject = new ComboObject(rs.getString(1), rs.getString(2));
                    list.add(comboObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            } finally {
                try {
                    if (prepStmt!=null)
                        prepStmt.close();
                    if (rs!=null)
                        rs.close();
                    c.close();
                } catch (Exception e) {
                    log.error(e);
                    throw new ProxyException(e);
                }
            }
			//rs.getStatement().getConnection().close();
			//rs.close();
			return new QueryResult(list, list.size());
	}

	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
		try {
			//Connection connection = Util.getConnection();
			int fromIndex = queryObject.getFromIndex();
			int toIndex = queryObject.getToIndex();

			Class aClass = getValueObjectClass();

			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});

			ResultSet rs = (ResultSet)o.getClass().getMethod("advanceRead", new Class[] { java.sql.Connection.class, QueryObject.class }).invoke(o, new Object[] { connection, queryObject });
			//rs.close();
			return rs;

		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public void fixFarsiSort(ArrayList list, java.lang.String field, java.lang.String order) throws NoSuchFieldException {
		// to Uppercase first char of field
		if ((field == null) || (field.length() == 0) || (list.size() == 0))
			return;
		String fieldEntity = new String();
		fieldEntity = field.substring(0, 1).toUpperCase().concat(field.substring(1));

		// Correct UNICODE Farsi Sort
		Field f = null;
		try {
			f = (list.get(0).getClass().getDeclaredField(field));
		} catch (NoSuchFieldException e) {
			Class c = list.get(0).getClass().getSuperclass();
			if (c != null)
				f = c.getDeclaredField(field);
		}
		if (f.getType().getName().equals("java.lang.String")) {
			FarsiComparator comp = new FarsiComparator(fieldEntity, order);
			Object[] so = new Object[list.size()];
			for (int j = 0; j < list.size(); j++)
				so[j] = list.get(j);
			Arrays.sort(so, comp);
			for (int j = 0; j < list.size(); j++)
				list.set(j, so[j]);
		}
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		return null;
	}

    protected int[] findColumns() {
        return null;
    }

	public ValueObject modelToList(Object o) {
		try {
			Class aClass = getValueObjectClass();
			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
			ValueObject vo = (ValueObject)o.getClass().getMethod("get" + prefix.substring(prefix.lastIndexOf('.') + 1) + "Model", new Class[] {}).invoke(o, new Object[] {});
			return vo;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;
	}

	protected Object resultSetToArrayList(ResultSet rs) {
		try {
			ArrayList row = new ArrayList();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				row.add(rs.getObject(i));

			}
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValueObject resultSetToBean(ResultSet resultSet) {
		try {
			Class voClass = getValueObjectClass();
			ValueObject vo = (ValueObject)voClass.newInstance();
			ResultSetMetaData resultsMetaData = resultSet.getMetaData();
			int columnCount = resultsMetaData.getColumnCount();
			// Column index starts at 1 (a la SQL) not 0 (a la Java).
			for (int i = 1; i < columnCount + 1; i++) {
				String columnName = resultsMetaData.getColumnName(i);

				// to Uppercase first char of field
				String bColumnName = new String();
				bColumnName = columnName.substring(0, 1).toUpperCase().concat(columnName.substring(1));

				Method setter = voClass.getMethod("set" + bColumnName, new Class[] { Class.forName(resultsMetaData.getColumnClassName(i))});
				if (setter != null)
					setter.invoke(vo, new Object[] { resultSet.getObject(i)});

			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int count(Connection c,QueryObject queryObject) throws ProxyException {
//        Connection c = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        int i = 0;
        try {
//			c = Util.getConnection();
//			Class aClass = getValueObjectClass();
//			String prefix = aClass.getName().substring(0, aClass.getName().lastIndexOf("Model"));
//			Object o = Class.forName(prefix + "Util").getMethod("getLocalHome", new Class[] {}).invoke(null, new Object[] {});
            if (!isDatabaseSQL()) {
                if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0){
                    if (queryObject.getWhere().indexOf(" and rownum<")>=0)
                        queryObject.setWhere(queryObject.getWhere().substring(0, queryObject.getWhere().indexOf(" and rownum<")));
                    else if (queryObject.getWhere().indexOf("rownum<")>=0)
                        queryObject.setWhere(queryObject.getWhere().substring(0, queryObject.getWhere().indexOf("where")));
                }
            }
            queryObject.setSelectFields(" COUNT(*) ");
            queryObject.setOrderField("");
            queryObject.setOrderTable("");
            queryObject.setOrderType("");

            String selectStatement = Util.getStatement(queryObject) ;
            prepStmt = c.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Util.setParameters(queryObject, prepStmt);
            long t1 = (new java.util.Date()).getTime();
            rs = prepStmt.executeQuery();
            rs.next();
            i = rs.getInt(1);
            log.info("count="+i+", Time="+((new java.util.Date()).getTime()-t1)+",Query : "+ selectStatement);
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        } finally {
            try {
                if (prepStmt!=null)
                    prepStmt.close();
                if (rs!=null)
                    rs.close();
//                if (c!=null)
//                    c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;

	}

    public void setAsView(QueryObject queryObject, String entity, String view) {
        queryObject.setTables(view);
        queryObject.setJoined(false);
        queryObject.setOrderTable("");
        queryObject.setView(true);
        if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0)
            queryObject.setWhere(Util.replaceAll(" "+queryObject.getWhere()," "+entity+"."," "+view+".") );
    }

    public boolean isDatabaseSQL() {
        return UserSession.isISDatabaseSQL();
    }

}

