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
 *      name="indexForm"
 *      path="/index"
 *      pathPrime="/index"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/index.jsp"
 *      inputPrime="emdad.index"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="doIndex"
 *      path="emdad.index"
 *      pathPrime="emdad.index"
 *
 */

public class IndexAction extends Action {

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        try {
            return actionMapping.findForward("doIndex");
        } catch (Exception exception) {
            Logger.getLogger(this.getClass()).error(exception.toString());
            return actionMapping.findForward("ERROR");
        }
    }

}
