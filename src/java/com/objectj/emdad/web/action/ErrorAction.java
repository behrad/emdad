package com.objectj.emdad.web.action;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 *
 * @struts.action
 *      name="errorForm"
 *      path="/error"
 *      pathPrime="/error"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/error.jsp"
 *      inputPrime="emdad.error"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="doError"
 *      path="emdad.security.error"
 *      pathPrime="emdad.error"
 *
 */

public class ErrorAction extends Action {

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //=-= System.out.println("error is here...");
        try {
            return actionMapping.findForward("doError");
        } catch (Exception exception) {
            Logger.getLogger(this.getClass()).error(exception.toString());
            exception.printStackTrace();
            session.setAttribute("EXCEPTION", exception);
            return actionMapping.findForward("ERROR");
        }
    }

}
