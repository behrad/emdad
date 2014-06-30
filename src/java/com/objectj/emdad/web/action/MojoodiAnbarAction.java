package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.MojoodiAnbarModel;
import com.objectj.emdad.ejb.MojoodiAnbarList;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.MojoodiAnbarProxy;
import com.objectj.emdad.proxy.MojoodiAnbarSessionLocal;
import com.objectj.emdad.proxy.MojoodiAnbarSessionLocalHome;
import com.objectj.emdad.proxy.MojoodiAnbarSessionUtil;
import com.objectj.emdad.proxy.QateSessionUtil;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;


/**
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/c/mojoodiAnbar"
 *      pathPrime="/mojoodiAnbar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiAnbar.edit.jsp"
 *      inputPrime="emdad.mojoodiAnbar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/r/mojoodiAnbar"
 *      pathPrime="/mojoodiAnbar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiAnbar.read.jsp"
 *      inputPrime="emdad.mojoodiAnbar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/u/mojoodiAnbar"
 *      pathPrime="/mojoodiAnbar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiAnbar.edit.jsp"
 *      inputPrime="emdad.mojoodiAnbar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/d/mojoodiAnbar"
 *      pathPrime="/mojoodiAnbar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiAnbar.read.jsp"
 *      inputPrime="emdad.mojoodiAnbar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/l/mojoodiAnbar"
 *      pathPrime="/mojoodiAnbarList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiAnbar.list.jsp"
 *      inputPrime="emdad.mojoodiAnbar.list"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/c/validatemojoodiAnbar"
 *      pathPrime="/validatemojoodiAnbar"
 *      scope="request"
 *      input="/c/mojoodiAnbar.run"
 *      inputPrime="emdad.mojoodiAnbar.edit"
 *      input4tiles="emdad.mojoodiAnbar.edit"
 *      validate="true"
 * 
 * @struts.action
 *      name="filterMojoodiAnbarForm"
 *      path="/l/filtermojoodiAnbar"
 *      pathPrime="/filtermojoodiAnbar"
 *      scope="request"
 *      input="/l/mojoodiAnbar.run"
 *      inputPrime="emdad.mojoodiAnbar.edit"
 *      input4tiles="emdad.mojoodiAnbar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiAnbarForm"
 *      path="/u/validatemojoodiAnbar"
 *      pathPrime="/validatemojoodiAnbar"
 *      scope="request"
 *      input="/u/mojoodiAnbar.run"
 *      inputPrime="emdad.mojoodiAnbar.edit"
 *      input4tiles="emdad.mojoodiAnbar.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.mojoodiAnbar.list"
 *      pathPrime="emdad.mojoodiAnbar.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.mojoodiAnbar.edit"
 *      pathPrime="emdad.mojoodiAnbar.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.mojoodiAnbar.read"
 *      pathPrime="emdad.mojoodiAnbar.read"
 *
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

public class MojoodiAnbarAction extends BaseAction {
    protected Class getValueObjectClass() {
        return MojoodiAnbarModel.class;
    }

    protected Class getValueObjectClass2() {
        return MojoodiAnbarList.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"shomareFanni", "qateName" , "mojoodi"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MojoodiAnbarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

	protected String[] getRelatedEntities() {
		return new String[] { "qate" };
	}


	protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				MojoodiAnbarModel vo = new MojoodiAnbarModel();
                ctx.getForm().set("anbarId", new Integer(1));
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((MojoodiAnbarProxy)getProxy()).create(vo, ctx.getForm().get("qateId").toString());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		ctx.getForm().set("qateId", "");
		return listAll(ctx);
	}

	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				MojoodiAnbarModel vo = new MojoodiAnbarModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((MojoodiAnbarProxy)getProxy()).update(vo, ctx.getForm().get("qateId").toString());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		ctx.getForm().set("qateId", "");
		return listAll(ctx);
	}

	protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
		String id = (String)ctx.getForm().get(ValueObject.ID);
		if (id == null)
			throw new ServletException(NULL_ID_MESSAGE);
		try {
			MojoodiAnbarSessionLocalHome lhProxy = MojoodiAnbarSessionUtil.getLocalHome();
			MojoodiAnbarSessionLocal lProxy = lhProxy.create();
			ValueObject voMojoodiAnbarList = lProxy.read(id);

			ctx.getRequest().setAttribute(VALUE_OBJECT, voMojoodiAnbarList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProxyException(e);
		}
		return ctx.getActionMapping().findForward("read");
	}


	protected ActionForward doReadAll(BaseActionContext ctx) throws IllegalAccessException, ProxyException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
		ctx.getForm().set("qateId", "");
		return super.listAll(ctx);
	}

	protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
//		ArrayList qateList = null;
//
//		try {
//			qateList = QateSessionUtil.getLocalHome().create().readCombo("qate", "name").getResult();
//
//			// set anbar id to default 1
//			ctx.getForm().set("anbarId", new Integer(1));
//		} catch (Exception e) {
//			throw new ProxyException(e);
//		}
//		ctx.getRequest().setAttribute("qateList", qateList);
	}

	protected void doFilterPreProcessor(BaseActionContext ctx) {
//		log.info("begin of fileter preprocessor");
//
//		if (ctx.getForm().get("qateIdCode") != null && ((Integer)ctx.getForm().get("qateIdCode")).intValue() != 0)
//			ctx.getForm().set("qate.qateId", ctx.getForm().get("qateIdCode"));
//		else
//			ctx.getForm().set("qate.qateId", null);
//
//		ctx.getForm().set("qateIdCode", null);
//
//        if (ctx.getForm().get("qateName") != null && ((String)ctx.getForm().get("qateName")).length() != 0)
//            ctx.getForm().set("qate.name", ctx.getForm().get("qateName"));
//        else
//            ctx.getForm().set("qate.name", null);
//
//        if (ctx.getForm().get("anbarId") != null && ((Integer)ctx.getForm().get("anbarId")).intValue() != 0)
//            ctx.getForm().set("mojoodiAnbar.anbarId", ctx.getForm().get("anbarId"));
//        else
//            ctx.getForm().set("mojoodiAnbar.anbarId", null);
//
//        ctx.getForm().set("anbarId", null);
//
//        ctx.getForm().set("qateIdCode", null);
//        ctx.getForm().set("qateName", null);
//
//		log.info("end of specific action");
	}


}
