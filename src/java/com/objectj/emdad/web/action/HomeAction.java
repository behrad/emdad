/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: May 21, 2003
 * Time: 7:06:53 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.ApplicationPool;
import com.objectj.emdad.ejb.util.Constants;

/**
 *
 * @struts.action
 *      path="/usr/home"
 *      pathPrime="/home"
 *      scope="request"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="failure"
 *      path="/utl/errors.jsp"
 *      pathPrime="emdad.security.error"
 *
 */



public class HomeAction extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        try {
//            //=-= System.out.println("application.cponnection.url="+System.getProperty("application.connection.url"));
//
//            com.objectj.emdad.ejb.util.Util.add("application.connection.url",System.getProperty("application.connection.url"));
            if (com.objectj.emdad.ejb.util.Util.get("application.constants.path")==null)
                com.objectj.emdad.ejb.util.Util.add("application.constants.path", com.objectj.emdad.web.util.Util.getProperty("application.constants.path"));
            String role = UserAccessEntity.getUserRole(request.getUserPrincipal().getName());
            com.objectj.emdad.web.util.Util.getUserSession(request);

            if (1==1) {
                ApplicationPool ap = (ApplicationPool) getServlet().getServletContext().getAttribute(Constants.APPLICATION_POOL);
                System.out.println("ap="+ap);
                if (ap==null) {
                    ap = new ApplicationPool();
                    getServlet().getServletContext().setAttribute(Constants.APPLICATION_POOL , ap);
                } 
                System.out.println("---="+ap.get(role));
//                ap.add(role, " 11111 22222 33333 "+role);
    //            System.out.println("+++="+ap.get(role));
//                ap.writeAll();
            }

            if (request.isUserInRole(role)) {
//                session.setAttribute("USERNAME", request.getUserPrincipal().getName());
//                session.setAttribute("USERROLE", role);
//                //=-= System.out.println("HomeAction 111--");
                return actionMapping.findForward(role + "Home");
            }
            return actionMapping.findForward("defaultHome");
        } catch (Exception exception) {
            Logger.getLogger(this.getClass()).error(exception.toString());
            exception.printStackTrace();
            session.setAttribute("EXCEPTION", exception);
            return actionMapping.findForward("defaultHome");
        }
    }

}
