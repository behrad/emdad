package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.OstanSessionUtil;
import com.objectj.emdad.proxy.ShahrProxy;
import com.objectj.emdad.proxy.ShahrSessionUtil;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 * @struts.action
 *      name="shahrForm"
 *      path="/c/shahr"
 *      pathPrime="/shahr"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/shahr.edit.jsp"
 *      inputPrime="emdad.shahr.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/r/shahr"
 *      pathPrime="/shahr"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/shahr.read.jsp"
 *      inputPrime="emdad.shahr.read"
 *      validate="false"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/u/shahr"
 *      pathPrime="/shahr"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/shahr.edit.jsp"
 *      inputPrime="emdad.shahr.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/d/shahr"
 *      pathPrime="/shahr"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/shahr.read.jsp"
 *      inputPrime="emdad.shahr.read"
 *      validate="false"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/l/shahr"
 *      pathPrime="/shahrList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/shahr.list.jsp"
 *      inputPrime="emdad.shahr.list"
 *      validate="false"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/c/validateshahr"
 *      pathPrime="/validateshahr"
 *      scope="request"
 *      input="/c/shahr.run"
 *      inputPrime="emdad.shahr.edit"
 *      input4tiles="emdad.shahr.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="shahrForm"
 *      path="/u/validateshahr"
 *      pathPrime="/validateshahr"
 *      scope="request"
 *      input="/u/shahr.run"
 *      inputPrime="emdad.shahr.edit"
 *      input4tiles="emdad.shahr.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.shahr.list"
 *      pathPrime="emdad.shahr.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.shahr.edit"
 *      pathPrime="emdad.shahr.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.shahr.read"
 *      pathPrime="emdad.shahr.read"
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
 */


public class ShahrAction extends BaseAction {
    protected Class getValueObjectClass() {
        return ShahrModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"shahrId", "shahrName", "ostanId", "codeShahrKhodrosaz"};
    }

    protected String[] getRelatedEntities() {
        return new String[] {"ostan"};
    }

    protected ActionForward doNullAction(BaseActionContext ctx) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        ctx.getForm().set("azArze", "   :  :  ");
        ctx.getForm().set("azToole", "   :  :  ");
        ctx.getForm().set("taArze", "   :  :  ");
        ctx.getForm().set("taToole", "   :  :  ");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                ShahrModel vo = new ShahrModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                ((ShahrProxy) getProxy()).create(vo, ctx.getForm().get("ostanId").toString());
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				ShahrModel vo = new ShahrModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((ShahrProxy) getProxy()).update(vo, ctx.getForm().get("ostanId").toString());
                ComboPool.setDirty(ctx.getEntity());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		return listAll(ctx);
	}

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {

        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
        try{
            com.objectj.emdad.proxy.ShahrSessionLocalHome lhProxy = com.objectj.emdad.proxy.ShahrSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.ShahrSessionLocal lProxy = lhProxy.create();
            ValueObject voShahrList = lProxy.read(id);
            ctx.getForm().set("azArze",((ShahrList)voShahrList).getAzArze());

            ctx.getForm().set("taArze",((ShahrList)voShahrList).getTaArze());

            ctx.getForm().set("azToole",((ShahrList)voShahrList).getAzToole());

            ctx.getForm().set("taToole",((ShahrList)voShahrList).getTaToole());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        try {
            com.objectj.emdad.proxy.ShahrSessionLocalHome lhProxy = com.objectj.emdad.proxy.ShahrSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.ShahrSessionLocal lProxy = lhProxy.create();
            ValueObject voShahrList = lProxy.read(id);

            ctx.getForm().set("azArze",((ShahrList)voShahrList).getAzArze());

            ctx.getForm().set("taArze",((ShahrList)voShahrList).getTaArze());

            ctx.getForm().set("azToole",((ShahrList)voShahrList).getAzToole());

            ctx.getForm().set("taToole",((ShahrList)voShahrList).getTaToole());

            ctx.getRequest().setAttribute(VALUE_OBJECT, voShahrList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return ShahrSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

        ArrayList ostanList = null;
        try {
            ostanList = ComboPool.getCombo("ostan");
        } catch (Exception e) {
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute("ostanList", ostanList);
    }
}