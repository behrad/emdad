package com.objectj.emdad.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @struts.action
 *      name="logoutForm"
 *      path="/logout"
 *      pathPrime="/logout"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/logout.jsp"
 *      inputPrime="emdad.logout"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="doLogout"
 *      path="emdad.security.logout"
 *      pathPrime="emdad.logout"
 *
 */

public class LogoutAction extends Action {

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //=-= System.out.println("logout is here...");
        try {
            session.setAttribute(com.objectj.emdad.ejb.util.Constants.USER_SESSION, null);
            session.invalidate();
            return actionMapping.findForward("doLogout");
        } catch (Exception exception) {
            Logger.getLogger(this.getClass()).error(exception.toString());
            exception.printStackTrace();
            session.setAttribute("EXCEPTION", exception);
            return actionMapping.findForward("ERROR");
        }
    }

}
