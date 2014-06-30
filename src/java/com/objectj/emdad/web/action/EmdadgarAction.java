package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/c/emdadgar"
 *      pathPrime="/emdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.edit.jsp"
 *      inputPrime="emdad.emdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/r/emdadgar"
 *      pathPrime="/emdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.read.jsp"
 *      inputPrime="emdad.emdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/u/emdadgar"
 *      pathPrime="/emdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.edit.jsp"
 *      inputPrime="emdad.emdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/d/emdadgar"
 *      pathPrime="/emdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.read.jsp"
 *      inputPrime="emdad.emdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/l/emdadgar"
 *      pathPrime="/emdadgarList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.list.jsp"
 *      inputPrime="emdad.emdadgar.list"
 *      validate="false"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/c/validateemdadgar"
 *      pathPrime="/validateemdadgar"
 *      scope="request"
 *      input="/c/emdadgar.run"
 *      inputPrime="emdad.emdadgar.edit"
 *      input4tiles="emdad.emdadgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/u/validateemdadgar"
 *      pathPrime="/validateemdadgar"
 *      scope="request"
 *      input="/u/emdadgar.run"
 *      inputPrime="emdad.emdadgar.edit"
 *      input4tiles="emdad.emdadgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="emdadgarForm"
 *      path="/s/emdadgar"
 *      pathPrime="/emdadgarShow"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdadgar.show.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/emdadgar.show.jsp"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.emdadgar.list"
 *      pathPrime="emdad.emdadgar.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.emdadgar.edit"
 *      pathPrime="emdad.emdadgar.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.emdadgar.read"
 *      pathPrime="emdad.emdadgar.read"
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
 *      name="emdadgarShow"
 *      path="/com/objectj/emdad/jsp/emdadgar.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/emdadgar.show.jsp"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 *
 */

public class EmdadgarAction extends BaseAction {
//    ArrayList vazeatList = new ArrayList();

    protected Class getValueObjectClass() {
        return EmdadgarModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"emdadgarId", "name", "noeEmdadgarId"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return EmdadgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String[] getRelatedEntities() {
        return new String[] {"noeEmdadgar", "daftarOstani", "namayandegi"};
    }

    protected String getForceFilter(BaseActionContext ctx) {
        if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess())
            return "emdadgar.daftarOstaniId = 'S" + getDaftarOstani(ctx) + "'";
        return "";
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
                EmdadgarModel vo = new EmdadgarModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                vo.setKarDarDast(new Integer(0));
                vo.setVazeat(new Integer(2));
                ((EmdadgarProxy) getProxy()).create(vo, (String)ctx.getForm().get("noeEmdadgarId"), getDaftarOstani(ctx), (String)ctx.getForm().get("namayandegiId"));
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				EmdadgarModel vo = new EmdadgarModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((EmdadgarProxy) getProxy()).update(vo, ctx.getForm().get("noeEmdadgarId").toString(), (String)ctx.getForm().get("daftarOstaniId"), (String)ctx.getForm().get("namayandegiId"));
                ComboPool.setDirty(ctx.getEntity());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		return listAll(ctx);
	}


    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.EmdadgarSessionLocalHome lhProxy = com.objectj.emdad.proxy.EmdadgarSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.EmdadgarSessionLocal lProxy = lhProxy.create();
            ValueObject voEmdadgarList = lProxy.read(id);

            if (((EmdadgarModel)voEmdadgarList).getVazeat()!=null)
                ctx.getRequest().setAttribute("vazeat", ((ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList("emdadgar.vazeat", ((EmdadgarModel)voEmdadgarList).getVazeat())).getName() ); //((ComboObject)vazeatList.get(((EmdadgarModel)voEmdadgarList).getVazeat().intValue())).getName());
            else
                ctx.getRequest().setAttribute("vazeat", "");

            ctx.getForm().set("azArze",((EmdadgarList)voEmdadgarList).getAzArze());

            ctx.getForm().set("taArze",((EmdadgarList)voEmdadgarList).getTaArze());

            ctx.getForm().set("azToole",((EmdadgarList)voEmdadgarList).getAzToole());

            ctx.getForm().set("taToole",((EmdadgarList)voEmdadgarList).getTaToole());

            ctx.getRequest().setAttribute(VALUE_OBJECT, voEmdadgarList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());

        DaftarOstaniModel daftarOstaniModel = null;
        try {
            com.objectj.emdad.proxy.EmdadgarSessionLocalHome lhProxy = com.objectj.emdad.proxy.EmdadgarSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.EmdadgarSessionLocal lProxy = lhProxy.create();
            ValueObject voEmdadgarList = lProxy.read(id);

            ctx.getForm().set("azArze",((EmdadgarList)voEmdadgarList).getAzArze());

            ctx.getForm().set("taArze",((EmdadgarList)voEmdadgarList).getTaArze());

            ctx.getForm().set("azToole",((EmdadgarList)voEmdadgarList).getAzToole());

            ctx.getForm().set("taToole",((EmdadgarList)voEmdadgarList).getTaToole());

//            ctx.getRequest().setAttribute(VALUE_OBJECT, voEmdadgarList);

            daftarOstaniModel = (DaftarOstaniModel)DaftarOstaniSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("daftarOstaniId"));
        }
        catch (Exception e) {
        }
        ctx.getRequest().setAttribute("daftarOstaniName", daftarOstaniModel.getName());

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.getRequest().setAttribute("noeEmdadgarList", ComboPool.getCombo("noeEmdadgar"));
        ctx.getRequest().setAttribute("daftarOstaniList", ComboPool.getCombo("daftarOstani"));
        ctx.getRequest().setAttribute("namayandegiList", ComboPool.getCombo("namayandegi"));
        ctx.getRequest().setAttribute("vazeatList", Util.getArrayList("emdadgar.vazeat"));
    }


    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if (ctx.getSubAction().equals("emdadgarShow")) {
            return doShow(ctx, "emdadgarId", "emdadgarShow");
        }
        return listAll(ctx);
    }

}
