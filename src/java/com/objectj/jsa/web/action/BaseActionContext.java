
package com.objectj.jsa.web.action;

import org.apache.struts.validator.DynaValidatorForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.objectj.emdad.ejb.UserSession;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.Util;

import java.security.Principal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseActionContext {
    public static final String USER_SESSION = "user_session";

    private DynaValidatorForm form;
    private HttpServletRequest request;
    private String action;
    private String subAction;
    private String homeForward;
    private UserSession userSession;
    private String entity;
	private String entityList;
    private ActionMapping actionMapping;
    private String valueObjectClassName;
	private String forceFilter;
	private String forceForwardTo;
    private Connection connection ;
    private boolean remainConnectionOpen = false;

    public boolean isLocal() {
        return getUserSession().isLocal();
    }

    public String getValueObjectClassName() {
        return valueObjectClassName;
    }

    public void setValueObjectClassName(String valueObjectClassName) {
        this.valueObjectClassName = valueObjectClassName;
    }

    public ActionMapping getActionMapping() {
        return actionMapping;
    }

    public void setActionMapping(ActionMapping actionMapping) {
        this.actionMapping = actionMapping;
    }

    public DynaValidatorForm getForm() {
        return form;
    }

    public void setForm(DynaValidatorForm form) {
        this.form = form;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getSubAction() {
        return subAction;
    }

    public void setSubAction(String subAction) {
        this.subAction = subAction;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getHomeForward() {
        if (homeForward==null)
            homeForward = UserAccessEntity.getUserRole(getUserSession().getName())+"Home";
        return homeForward;
    }

    public void setHomeForward(String homeForward) {
        this.homeForward = homeForward;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public static void showIsInRole(HttpServletRequest request) {
        Connection c = null;
        Statement sqlSt = null;
        StringBuffer result = new StringBuffer();
        try {
            c = Util.getConnection(); // DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            ResultSet rs = sqlSt.executeQuery(
                    "SELECT     admin_Roles.role from admin_Roles "
            );
            while (rs.next()) {
                String s = rs.getString("role");
                //=-= //=-= //=-= System.out.println("role="+s+", Principal="+request.getUserPrincipal()+", isUserInRole = " + request.isUserInRole(s));
            }
            sqlSt.close();
            c.close();
        } catch (Exception se) {
            se.printStackTrace();
        }

    }


    public BaseActionContext(DynaValidatorForm form, HttpServletRequest request, ActionMapping actMap, Class aClass) {
        this.form = form;
        this.request = request;
        this.actionMapping = actMap;
        this.valueObjectClassName = aClass.getName();
        this.forceFilter = new String("");
        this.forceForwardTo = new String("");
        this.action = (String)form.get("action_type");
        this.remainConnectionOpen = false;
        connection = null;

        entity = request.getServletPath().substring(request.getServletPath().lastIndexOf('/')+1);
        entity = entity.substring(0, entity.lastIndexOf('.'));
        if (entity.startsWith("validate"))
            entity = entity.substring(8);

		// for entities without List View in DB
		entityList = entity ;

        //showIsInRole(request);
        HttpSession session  = request.getSession();
        try {
            userSession = (UserSession) session.getAttribute(USER_SESSION);
        } catch (Exception e) {
            userSession = null;
        }
        String userName;
        if (userSession==null) {
            Principal principal = request.getUserPrincipal();
            if (principal == null)
                userName = "anonymous";
            else {
                userName = principal.getName();
            }
            try {
                userSession = new UserSession(userName);
                String ip = request.getRemoteAddr();
//                System.out.println("ip0="+ip);
                ip = ip.substring(0, ip.lastIndexOf('.'));
//                System.out.println("ip1="+ip);
//                System.out.println("10201="+java.net.InetAddress.getLocalHost().getHostAddress());
                userSession.setLocal(java.net.InetAddress.getLocalHost().getHostAddress().startsWith(ip));
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            if (principal != null)
                session.setAttribute(USER_SESSION, userSession);
        }

    }

    public boolean isRemainConnectionOpen() {
        return remainConnectionOpen;
    }

    public void setRemainConnectionOpen(boolean remainConnectionOpen) {
        this.remainConnectionOpen = remainConnectionOpen;
    }

    public Connection getConnection() {
        if (connection==null)
            try {
                connection = Util.getConnection();
            } catch (Exception e) {
                connection = null;
                e.printStackTrace();
            }
        return connection;
    }

    public Connection getConnectedConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (getConnectedConnection()!=null)
                getConnectedConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isUserInRole(String roleName) {
        return userSession.isUserInRole(roleName);
    }

	public String getForceFilter() {
		return forceFilter;
	}


	public String getForceForwardTo() {
		return forceForwardTo;
	}


	public void setForceFilter(String string) {
		forceFilter = string;
	}


	public void setForceForwardTo(String string) {
		forceForwardTo = string;
	}


	public String getEntityList() {
		return entityList;
	}

	public void setEntityList(String string) {
		entityList = string;
	}

    public boolean isDatabaseSQL() {
        return getUserSession().isISDatabaseSQL();
    }

}
