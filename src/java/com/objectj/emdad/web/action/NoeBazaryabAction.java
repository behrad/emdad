package com.objectj.emdad.web.action;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.NoeBazaryabModel;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NoeBazaryabSessionUtil;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/c/noeBazaryab"
 *      pathPrime="/noeBazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeBazaryab.edit.jsp"
 *      inputPrime="emdad.noeBazaryab.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/r/noeBazaryab"
 *      pathPrime="/noeBazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeBazaryab.read.jsp"
 *      inputPrime="emdad.noeBazaryab.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/u/noeBazaryab"
 *      pathPrime="/noeBazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeBazaryab.edit.jsp"
 *      inputPrime="emdad.noeBazaryab.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/d/noeBazaryab"
 *      pathPrime="/noeBazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeBazaryab.read.jsp"
 *      inputPrime="emdad.noeBazaryab.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/l/noeBazaryab"
 *      pathPrime="/noeBazaryabList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeBazaryab.list.jsp"
 *      inputPrime="emdad.noeBazaryab.list"
 *      validate="false"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/c/validatenoeBazaryab"
 *      pathPrime="/validatenoeBazaryab"
 *      scope="request"
 *      input="/c/noeBazaryab.run"
 *      inputPrime="emdad.noeBazaryab.edit"
 *      input4tiles="emdad.noeBazaryab.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="noeBazaryabForm"
 *      path="/u/validatenoeBazaryab"
 *      pathPrime="/validatenoeBazaryab"
 *      scope="request"
 *      input="/u/noeBazaryab.run"
 *      inputPrime="emdad.noeBazaryab.edit"
 *      input4tiles="emdad.noeBazaryab.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.noeBazaryab.list"
 *      pathPrime="emdad.noeBazaryab.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.noeBazaryab.edit"
 *      pathPrime="emdad.noeBazaryab.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.noeBazaryab.read"
 *      pathPrime="emdad.noeBazaryab.read"
 * @struts.action-forward
 *      name="thanks"
 *      path="/com/objectj/emdad/jsp/thanks.jsp"
 *      pathPrime="emdad.thanks"
 *
 * @struts.action-forward
 *      name="default"
 *      path="/util/genericPage.jsp"
 *      pathPrime="/util/genericPage.jsp"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 *
 */

public class NoeBazaryabAction extends BaseAction {

    protected Class getValueObjectClass() {
        return NoeBazaryabModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"noeBazaryabId", "onvan", "entity"};
    }


    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeBazaryabSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }


    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
        String entityName = ((ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList("entityList",((NoeBazaryabModel) valueObject).getEntity().intValue())).getName();
        //log.info ("=======================================  entityName=" + entityName);
        ctx.getRequest().setAttribute("entityName", entityName);
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.getRequest().setAttribute("entityList", Util.getArrayList("entityList"));
     }

    protected boolean needList() { return true; }

}
