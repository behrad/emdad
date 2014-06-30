package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.NoeKhodroModel;
import com.objectj.emdad.ejb.NoeKhodroUtil;
import com.objectj.emdad.ejb.DarkhastEshterakModel;
import com.objectj.emdad.ejb.MoshtarakModel;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/c/noeKhodro"
 *      pathPrime="/noeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.edit.jsp"
 *      inputPrime="emdad.noeKhodro.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/r/noeKhodro"
 *      pathPrime="/noeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.read.jsp"
 *      inputPrime="emdad.noeKhodro.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/u/noeKhodro"
 *      pathPrime="/noeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.edit.jsp"
 *      inputPrime="emdad.noeKhodro.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/d/noeKhodro"
 *      pathPrime="/noeKhodro"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.read.jsp"
 *      inputPrime="emdad.noeKhodro.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/l/noeKhodro"
 *      pathPrime="/noeKhodroList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.list.jsp"
 *      inputPrime="emdad.noeKhodro.list"
 *      validate="false"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/c/validatenoeKhodro"
 *      pathPrime="/validatenoeKhodro"
 *      scope="request"
 *      input="/c/noeKhodro.run"
 *      inputPrime="emdad.noeKhodro.edit"
 *      input4tiles="emdad.noeKhodro.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/u/validatenoeKhodro"
 *      pathPrime="/validatenoeKhodro"
 *      scope="request"
 *      input="/u/noeKhodro.run"
 *      inputPrime="emdad.noeKhodro.edit"
 *      input4tiles="emdad.noeKhodro.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="noeKhodroForm"
 *      path="/s/noeKhodro"
 *      pathPrime="/noeKhodroShow"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeKhodro.show.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/noeKhodro.show.jsp"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.noeKhodro.list"
 *      pathPrime="emdad.noeKhodro.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.noeKhodro.edit"
 *      pathPrime="emdad.noeKhodro.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.noeKhodro.read"
 *      pathPrime="emdad.noeKhodro.read"
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
 * @struts.action-forward
 *      name="noeKhodroShow"
 *      path="/com/objectj/emdad/jsp/noeKhodro.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/noeKhodro.show.jsp"
 *
 */


public class NoeKhodroAction extends BaseAction {
    ArrayList noeServiceList = new ArrayList();
    protected Class getValueObjectClass() {
        return NoeKhodroModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"noeKhodroId", "onvan", "guarantee", "guaranteeDistance", "khodroCode", "noeKhodroCode","vijeh"};
    }

    protected String[] getRelatedEntities() {
        return new String[] {"khodrosaz"};
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                NoeKhodroModel vo = new NoeKhodroModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                ((NoeKhodroProxy) getProxy()).create(vo, ctx.getForm().get("khodrosazId").toString());
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
				NoeKhodroModel vo = new NoeKhodroModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((NoeKhodroProxy) getProxy()).update(vo, ctx.getForm().get("khodrosazId").toString());
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
            com.objectj.emdad.proxy.NoeKhodroSessionLocalHome lhProxy = com.objectj.emdad.proxy.NoeKhodroSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.NoeKhodroSessionLocal lProxy = lhProxy.create();
            ValueObject voNoeKhodroList = lProxy.read(id);
            ctx.getRequest().setAttribute(VALUE_OBJECT, voNoeKhodroList);
            if (((NoeKhodroModel) (voNoeKhodroList)).getNoeService() != null)
                ctx.getRequest().setAttribute("noeService", ((ComboObject)noeServiceList.get(((NoeKhodroModel)voNoeKhodroList).getNoeService().intValue())).getName());
            else
                ctx.getRequest().setAttribute("noeService","");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeKhodroSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ArrayList khodrosazList = null;
        ArrayList isVijehList = null;
        try {
            isVijehList = Util.getArrayList("yesNo");
            noeServiceList = Util.getArrayList("noeService");
            khodrosazList = ComboPool.getCombo("khodrosaz");
        } catch (Exception e) {
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute("khodrosazList", khodrosazList);
        ctx.getRequest().setAttribute("isVijehList", isVijehList);
        ctx.getRequest().setAttribute("noeServiceList",noeServiceList);
    }


    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if (ctx.getSubAction().equals("noeKhodroShow")) {
            return doShow(ctx, "noeKhodroId", "noeKhodroShow");
        }
        return listAll(ctx);
    }

}