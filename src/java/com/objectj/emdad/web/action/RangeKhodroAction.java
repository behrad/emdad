package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.RangeKhodroModel;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.model.ValueObject;

import java.util.ArrayList;

import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;

/**
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/c/rangeKhodro"
 *      pathPrime="/rangeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/rangeKhodro.edit.jsp"
 *      inputPrime="emdad.rangeKhodro.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/r/rangeKhodro"
 *      pathPrime="/rangeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/rangeKhodro.read.jsp"
 *      inputPrime="emdad.rangeKhodro.read"
 *      validate="false"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/u/rangeKhodro"
 *      pathPrime="/rangeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/rangeKhodro.edit.jsp"
 *      inputPrime="emdad.rangeKhodro.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/d/rangeKhodro"
 *      pathPrime="/rangeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/rangeKhodro.read.jsp"
 *      inputPrime="emdad.rangeKhodro.read"
 *      validate="false"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/l/rangeKhodro"
 *      pathPrime="/rangeKhodroList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/rangeKhodro.list.jsp"
 *      inputPrime="emdad.rangeKhodro.list"
 *      validate="false"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/c/validaterangeKhodro"
 *      pathPrime="/validaterangeKhodro"
 *      scope="request"
 *      input="/c/rangeKhodro.run"
 *      inputPrime="emdad.rangeKhodro.edit"
 *      input4tiles="emdad.rangeKhodro.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="rangeKhodroForm"
 *      path="/u/validaterangeKhodro"
 *      pathPrime="/validaterangeKhodro"
 *      scope="request"
 *      input="/u/rangeKhodro.run"
 *      inputPrime="emdad.rangeKhodro.edit"
 *      input4tiles="emdad.rangeKhodro.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.rangeKhodro.list"
 *      pathPrime="emdad.rangeKhodro.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.rangeKhodro.edit"
 *      pathPrime="emdad.rangeKhodro.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.rangeKhodro.read"
 *      pathPrime="emdad.rangeKhodro.read"
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

public class RangeKhodroAction extends BaseAction {
    ArrayList  baseRangeList = new ArrayList();

    protected Class getValueObjectClass() {
        return RangeKhodroModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"rangeKhodroId", "onvan", "codeRangeKhodrosaz"};
    }

	protected String[] getRelatedEntities() {
		return new String[] {};
	}

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RangeKhodroSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

	  
    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException{
        baseRangeList = Util.getArrayList("yesNo");
        ctx.getRequest().setAttribute("baseRangeList", baseRangeList);
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException{
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.RangeKhodroSessionLocalHome lhProxy = com.objectj.emdad.proxy.RangeKhodroSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.RangeKhodroSessionLocal lProxy = lhProxy.create();
            ValueObject vo = lProxy.read(id);
            ctx.getRequest().setAttribute(VALUE_OBJECT, vo);
            if (((RangeKhodroModel)vo).getBaseRange() != null && ((RangeKhodroModel)vo).getBaseRange().intValue() != 0)
                ctx.getRequest().setAttribute("baseRangeName", ((ComboObject)com.objectj.emdad.ejb.util.Util.getFromArrayList("yesNo", ((RangeKhodroModel)vo).getBaseRange().intValue())).getName());
            else
                ctx.getRequest().setAttribute("baseRangeName", "");


        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }
    
	protected boolean needList() {
		return true;
	}

}
