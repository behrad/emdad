/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jul 8, 2003
 * Time: 7:05:42 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.Enumeration;

import com.objectj.emdad.web.sysadmin.EntityModel;
import com.objectj.emdad.web.sysadmin.UseCaseModel;
import com.objectj.emdad.web.sysadmin.SysAdminDAO;

/**
 *
 * @struts.action
 *      name="sysadminForm"
 *      scope="request"
 *      path="/sysadmin"
 *      pathPrime="/sysadmin"
 *      scope="request"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="failure"
 *      path="entity-error.jsp"
 *      pathPrime="emdad.security.error"
 *
 * @struts.action-forward
 *      name="acl"
 *      path="emdad.sysadmin"
 *      pathPrime="emdad.sysadmin"
 *
 * @struts.action-forward
 *      name="success"
 *      path="emdad.sysadmin"
 *      pathPrime="emdad.sysadmin"
 *
 */

public class SysAdminAction extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        com.objectj.emdad.ejb.util.Util.add("application.connection.url", System.getProperty("application.connection.url"));

        String action = request.getParameter("action");
        //=-= System.out.println("action = " + action);
        if (action == null) {
            //=-= System.out.println(actionMapping.findForward("acl"));
            return actionMapping.findForward("acl");
        } else if (action.equals("store")) {
            return handleStore(actionMapping, request, response);
        } else if (action.equals("entity")) {
            return handleEntity(actionMapping, request, response);
        } else {
//            System.err.println("aakhe chi kaar mikhaay bokoni?");
            return actionMapping.findForward("failure");
        }
    }

    protected ActionForward handleEntity(ActionMapping actionMapping, HttpServletRequest request, HttpServletResponse response) {
        EntityModel em = new EntityModel();
        em.setEntityName(request.getParameter("entityName"));
        em.setEntityTitle(request.getParameter("entityTitle"));
        em.setEntityDescr(request.getParameter("entityDescr"));

        char[] op = {'c', 'r', 'u', 'd', 'l', 'p'};
        for (int i = 0; i < op.length; i++) {
            UseCaseModel ucm = new UseCaseModel();
            ucm.setUcName(op[i] + "-" + em.getEntityName());
            ucm.setUcTitle(request.getParameter(op[i] + "Caption"));
            ucm.setUcURL("/" + op[i] + "/" + em.getEntityName() + ".run");
            ucm.setUcOperation(Character.toString(op[i]));
        }

        try {
            if (SysAdminDAO.insertEntity(em, Integer.parseInt(request.getParameter("bpId")))) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/com/objectj/emdad/jsp/sysadmin/ACL-frames.jsp");
                dispatcher.forward(request, response);
            } else {
                return actionMapping.findForward("failure");
            }
        } catch (ServletException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
        return actionMapping.findForward("acl");
    }

    protected ActionForward handleStore(ActionMapping actionMapping, HttpServletRequest request, HttpServletResponse response) {
        Enumeration en = request.getParameterNames();
        SysAdminDAO.backupACL();
        SysAdminDAO.insertSuperuserACL();
        int superuserId = SysAdminDAO.getSuperuserId();

        while (en.hasMoreElements()) {
            String paramName = (String)en.nextElement();
            if (!paramName.startsWith("cb-"))
                continue;
            paramName = paramName.substring(3);     // drop cb- prefix
            int ucId = Integer.parseInt(paramName.substring(0, paramName.indexOf(',')));
            int roleId = Integer.parseInt(paramName.substring(paramName.indexOf(',') + 1));
            if (roleId == superuserId)
                continue;
            SysAdminDAO.insertACL(roleId, ucId);
        }
        return actionMapping.findForward("success");
    }

}
