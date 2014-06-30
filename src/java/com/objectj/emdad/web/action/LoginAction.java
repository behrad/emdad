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
 *      name="loginForm"
 *      path="/login"
 *      pathPrime="/login"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/login.jsp"
 *      inputPrime="emdad.login"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="doLogin"
 *      path="emdad.security.login"
 *      pathPrime="emdad.login"
 *
 */

public class LoginAction extends Action {
    protected Logger log = Logger.getLogger(this.getClass());

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //=-= System.out.println("login is here...");
        try {
            return actionMapping.findForward("doLogin");
        } catch (Exception exception) {
            Logger.getLogger(this.getClass()).error(exception.toString());
            exception.printStackTrace();
            session.setAttribute("EXCEPTION", exception);
            return actionMapping.findForward("ERROR");
        }
    }

}
