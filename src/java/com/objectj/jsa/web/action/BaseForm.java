/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: May 12, 2003
 * Time: 2:16:26 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.web.action;

import java.util.ArrayList;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.jsa.proxy.ProxyException;

public abstract class BaseForm  extends DynaValidatorForm {

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Perform validator framework validations
        prefixSpecificValidations(mapping, request);
        ActionErrors errors = super.validate(mapping, request);

//        if (!errors.isEmpty())
//            log("0000---error.size()="+errors.size());

        java.lang.Integer entityId = new java.lang.Integer(-1);
        if (getEntityIdName()!=null && getEntityIdName().length()!=0)
            entityId = (java.lang.Integer)get(getEntityIdName());
        //=-= //=-= //=-= System.out.println("entityId = " + entityId);
        ArrayList c = null;
        try {
            if (entityId!=null && entityId.intValue()!=0 && entityId.intValue() != -1) {
               c = getProxy().readByEntityId(entityId).getResult();
               if (c != null && c.size()>0 ){
                   String id = (String) Class.forName(getValueObjectClassName()).getMethod("getId", new Class[] {}).invoke(c.get(0), new Object[] {});
                   if (c.size()>1 || !id.equals(get("id")))
                       errors.add("entityId",
                              new ActionError("errors.entityid.already.exists"));
               }
           }

            Connection connection = Util.getConnection();
            checkForSpecificValidations(connection, errors);
            if (connection!=null)
                connection.close();

            if (errors.size()!=0) {
                String act;
                if (request.getServletPath().charAt(1)=='c')
                    act="create";
                else
                    if (request.getServletPath().charAt(1)=='s')
                        act="specific";
                    else
                        act="edit";
                request.setAttribute(com.objectj.jsa.web.action.BaseAction.ACTION_TYPE, act+"_from_error");
            }
        } catch (Exception e) {
            errors.add("error", new ActionError("errors.Validator"));
            e.printStackTrace(System.out);
        }

        postfixSpecificValidations(errors, request);

        return errors;

    }

    protected abstract EntityProxy getProxy() throws ProxyException ;
    protected abstract String getEntityIdName() ;
    protected abstract String getValueObjectClassName();
    protected void prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request) {}
    protected void checkForSpecificValidations(Connection connection, ActionErrors errors) throws Exception {}
    protected void postfixSpecificValidations(ActionErrors errors, HttpServletRequest request) {}
}
