/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: May 11, 2003
 * Time: 5:14:31 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;
import org.apache.log4j.Logger;

import com.objectj.emdad.proxy.QueryElement;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.*;

import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;

public abstract class BaseEJB {

	protected static Logger log = Logger.getLogger(BaseEJB.class.getName());

//	protected Connection initConnection() throws ClassNotFoundException, SQLException {
//        //log.info("--initConnection  000000---");
//		//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//        log.info("--initConnection 111111---");
//        DataSource ds;
//        Connection connection = null;
//        try {
//            InitialContext c = new InitialContext();
//            ds = (DataSource)c.lookup("java:/emdadDS");
//            connection = ds.getConnection();
//            //ds = null;
//       } catch(NamingException ne) {
//                   //=-= System.out.println("Datasource not found " + ne);
//       } catch (SQLException sqle) {
//                   //=-= System.out.println("SQL EXCEPTION OCCURED" + sqle);
//       }
//       log.info("--initConnection 222222---");
//	//	Class.forName("com.ddtek.jdbc.sqlserver.SQLServerDriver");
//	//	Connection connection = DriverManager.getConnection("jdbc:datadirect:sqlserver://sequel:1433;User=sa;Password=;DatabaseName=emdad");
//
//		return connection;
//	}

	public String ejbCreate() throws CreateException {
		try {
			// JSA recommend you to have attribute String id as the primary key for code reuse
            if ((getId() == null) || (getId().length() == 0) || getId().equals("0"))
			    this.setId(UIDDispenser.getDispenser().getNextId());
		} catch (UIDDispenserException exception) {
			log.error(exception);
			throw new EJBException(exception.toString());
		}
		// EJB 2.0 spec says return null for CMP ejbCreate methods
		return null;
	}

	public void myRemove(String id) throws SQLException, ProxyReferenceException {
		try {
			Connection connection = Util.getConnection();
			Statement statement = connection.createStatement();
			String query = "DELETE FROM " + getTable() + " WHERE Id = '" + id + "'";
			statement.executeUpdate(query);
            //statement.close();
            connection.close();
		} catch (SQLException e) {
			log.error(e);
			if (e.getErrorCode() == 547) {
				throw new ProxyReferenceException();
			}
			throw new SQLException(e.toString());
        } catch (Exception ex) {
            throw new SQLException(ex.toString());
		}
	}

	public ResultSet ejbHomeAdvanceRead(Connection connection, QueryObject queryObject) throws FinderException {
		try {
			//String selectStatement = "SELECT * " + "FROM " + queryObject.getTables() + " ";
			String selectStatement = "SELECT " + queryObject.getSelectFields() ;
            if (queryObject.isJoined() && (getJoinTables()!=null) && (getJoinTables().length()>0))
                selectStatement += " FROM " + getJoinTables();
            else
                selectStatement += " FROM " + queryObject.getTables();

			if (queryObject.isJoined() && getJoinStatement() != null && getJoinStatement().length() != 0) {
				selectStatement += " WHERE " + getJoinStatement();
				if ((queryObject.getWhere() != null) && (queryObject.getWhere().length() != 0)) {
					selectStatement += " AND ";
					selectStatement += queryObject.getWhere();
					selectStatement += " ";
				}
			} else {
				if ((queryObject.getWhere() != null) && (queryObject.getWhere().length() != 0)) {
					selectStatement += " WHERE ";
					selectStatement += queryObject.getWhere();
					selectStatement += " ";
				}
			}

			if ((queryObject.getOrderField() != null) && (queryObject.getOrderField().length() != 0)) {
				selectStatement += " ORDER BY ";
				if (queryObject.getOrderTable() != null && queryObject.getOrderTable().length() != 0)
					selectStatement += queryObject.getOrderTable() + ".";
				selectStatement += queryObject.getOrderField();
				selectStatement += " ";
				selectStatement += queryObject.getOrderType();
			}
			PreparedStatement prepStmt = connection.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			setParameters(queryObject, prepStmt);
            log.info("BAseEJB, advancedread, Query : "+ selectStatement);
			ResultSet resultSet = prepStmt.executeQuery();
			log.info(" BASEEJB, advancedread , after query exec");

			return resultSet;

		} catch (SQLException sqle) {
			System.err.println("Error connecting: " + sqle);
		}
		return null;
	}

	protected void setParameters(QueryObject queryObject, PreparedStatement prepStmt) throws SQLException, NumberFormatException {
		try {
			if (queryObject.getQueryElements().size() != 0) {
				for (int i = 0; i < queryObject.getQueryElements().size(); i++) {
					if (((QueryElement)queryObject.getQueryElements().get(i)).getType().equals("String"))
						prepStmt.setString(i + 1, ((QueryElement)queryObject.getQueryElements().get(i)).getValue());
					else
						if (((QueryElement)queryObject.getQueryElements().get(i)).getType().equals("Integer"))
							prepStmt.setInt(i + 1, Integer.parseInt(((QueryElement)queryObject.getQueryElements().get(i)).getValue()));
						else
							if (((QueryElement)queryObject.getQueryElements().get(i)).getType().equals("Date"))
								prepStmt.setDate(i + 1, Date.valueOf(((QueryElement)queryObject.getQueryElements().get(i)).getValue()));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected String getJoinStatement() {
		return "";
	}

    protected String getJoinTables() {
        return "";
    }

	protected abstract EntityContext getEntityContext();
	protected abstract String getTable();
	protected abstract java.util.Collection dynaQuery(String query);
	public abstract void setId(String id);
    public abstract String getId();

}
