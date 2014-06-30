package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/c/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.edit.jsp"
 *      inputPrime="emdad.anbarEmdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/r/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.read.jsp"
 *      inputPrime="emdad.anbarEmdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/u/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.edit.jsp"
 *      inputPrime="emdad.anbarEmdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/d/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.read.jsp"
 *      inputPrime="emdad.anbarEmdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/l/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgarList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.list.jsp"
 *      inputPrime="emdad.anbarEmdadgar.list"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/c/validateanbarEmdadgar"
 *      pathPrime="/validateanbarEmdadgar"
 *      scope="request"
 *      input="/c/anbarEmdadgar.run"
 *      inputPrime="emdad.anbarEmdadgar.edit"
 *      input4tiles="emdad.anbarEmdadgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterAnbarEmdadgarForm"
 *      path="/l/filteranbarEmdadgar"
 *      pathPrime="/filteranbarEmdadgar"
 *      scope="request"
 *      input="/l/anbarEmdadgar.run"
 *      inputPrime="emdad.anbarEmdadgar.edit"
 *      input4tiles="emdad.anbarEmdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/u/validateanbarEmdadgar"
 *      pathPrime="/validateanbarEmdadgar"
 *      scope="request"
 *      input="/u/anbarEmdadgar.run"
 *      inputPrime="emdad.anbarEmdadgar.edit"
 *      input4tiles="emdad.anbarEmdadgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="anbarEmdadgarForm"
 *      path="/s/anbarEmdadgar"
 *      pathPrime="/anbarEmdadgarShow"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/anbarEmdadgar.show.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/anbarEmdadgar.show.jsp"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.anbarEmdadgar.list"
 *      pathPrime="emdad.anbarEmdadgar.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.anbarEmdadgar.edit"
 *      pathPrime="emdad.anbarEmdadgar.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.anbarEmdadgar.read"
 *      pathPrime="emdad.anbarEmdadgar.read"
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
 *
 * @struts.action-forward
 *      name="anbarEmdadgarShow"
 *      path="/com/objectj/emdad/jsp/anbarEmdadgar.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/anbarEmdadgar.show.jsp"
 *
 * @struts.action-forward
 *      name="mojoodiShow"
 *      path="/com/objectj/emdad/jsp/anbarEmdadgar.mojoodi.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/anbarEmdadgar.mojoodi.show.jsp"
 *
 * @struts.action-forward
 *      name="valueAnbarShow"
 *      path="/com/objectj/emdad/jsp/anbarEmdadgar.valueAnbar.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/anbarEmdadgar.valueAnbar.show.jsp"
 */

public class AnbarEmdadgarAction extends BaseAction {
//	public static boolean isEmdadgar = false;
//	public static boolean showAllDaftarOstani = true;

	protected Class getValueObjectClass() {
		return AnbarEmdadgarModel.class;
	}

    protected Class getValueObjectClass2() {
        return AnbarEmdadgarList.class;
    }

	protected String[] getSortableColumns() {
		return new String[] { "emdadgarId", "qateName", "shomareFanni" , "mojoodi" , "daftarOstaniId"};
	}

	protected EntityProxy getProxy() throws ProxyException {
		try {
			return AnbarEmdadgarSessionUtil.getLocalHome().create();
		} catch (Exception e) {
			throw new ProxyException(e);
		}
	}

	protected String[] getRelatedEntities() {
		return new String[] { "emdadgar", "qate" };
	}

	protected String getForceFilter(BaseActionContext ctx) {
		String filter = ctx.getUserSession().getForceFilter(ctx.getEntity());
		try {


			if (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI)) {
				ctx.getRequest().setAttribute("emdadgarName", ctx.getUserSession().getName());
				if (filter != null && filter.length() != 0) {
					return filter += " AND anbarEmdadgar.emdadgarId = 'S" + UserAccessEntity.getEntityId(ctx.getUserSession().getName()) + "'";
				} else {
					return filter = " anbarEmdadgar.emdadgarId = 'S" + UserAccessEntity.getEntityId(ctx.getUserSession().getName()) + "'";
				}
			}
			if (!getAccess(ctx).getAllAccess()) {
				if (filter != null && filter.length() != 0)
					filter += " AND ";
				else
					filter = "";
				filter += " anbarEmdadgar.daftarOstaniId = 'S" + getDaftarOstani(ctx) + "'";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return filter;
	}

	protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				AnbarEmdadgarModel vo = new AnbarEmdadgarModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((AnbarEmdadgarProxy)getProxy()).create(vo, ctx.getForm().get("emdadgarId").toString(), ctx.getForm().get("qateId").toString());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		ctx.getForm().set("qateId", "");
		ctx.getForm().set("emdadgarId", "");
		return listAll(ctx);
	}

	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				AnbarEmdadgarModel vo = new AnbarEmdadgarModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((AnbarEmdadgarProxy)getProxy()).update(vo, ctx.getForm().get("emdadgarId").toString(), ctx.getForm().get("qateId").toString());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		ctx.getForm().set("qateId", "");
		ctx.getForm().set("emdadgarId", "");
		return listAll(ctx);
	}

	protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
		String id = (String)ctx.getForm().get(ValueObject.ID);
		if (id == null)
			throw new ServletException(NULL_ID_MESSAGE);
		try {
			AnbarEmdadgarSessionLocalHome lhProxy = AnbarEmdadgarSessionUtil.getLocalHome();
			AnbarEmdadgarSessionLocal lProxy = lhProxy.create();
			ValueObject voAnbarEmdadgarList = lProxy.read(id);
            log.info("voAnbarEmdadgarList="+voAnbarEmdadgarList);

			// set value Qate and value Anbar
			ctx.getForm().set("valueAnbar", new Integer(getValueAnbar(ctx, ((AnbarEmdadgarList)voAnbarEmdadgarList).getEmdadgarId())));
            int vq = UserAccessEntity.intQuery("select (mojoodi * gheimat) as vq from view_anbarEmdadgar where id='"+id+"'" , "vq" , ctx.getConnection());
    		ctx.getForm().set("valueQate", new Integer(vq));

			ctx.getRequest().setAttribute(VALUE_OBJECT, voAnbarEmdadgarList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProxyException(e);
		}
		return ctx.getActionMapping().findForward("read");
	}


	protected ActionForward doReadAll(BaseActionContext ctx) throws IllegalAccessException, ProxyException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
		ctx.getForm().set("qateId", "");
		ctx.getForm().set("emdadgarId", "");
		return super.listAll(ctx);
	}

	protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
		ArrayList qateList = null;

        String filter = getAccess(ctx).getAllAccess() ? "" :  " daftarOstaniId='" + ctx.getUserSession().getDaftarOstani() + "'";
		ctx.getRequest().setAttribute("emdadgarList", ComboPool.getCombo("emdadgar_faal" , filter));
		ctx.getRequest().setAttribute("qateList", qateList);
        boolean isEmdadgar = ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI) ;
//		ctx.getRequest().setAttribute("emdadgarColumnShow", new Boolean(!isEmdadgar));
		ctx.getRequest().setAttribute("daftarOstaniList", ComboPool.getCombo("daftarOstani"));
//		ctx.getRequest().setAttribute("daftarOstaniColumnShow", new Boolean(showAllDaftarOstani));

	}


	public int getValueAnbar(BaseActionContext ctx, String emdadgarId) {
         return UserAccessEntity.intQuery("select SUM(mojoodi * gheimat) as va from view_anbarEmdadgar where emdadgarId='"+emdadgarId+"'" , "va" , ctx.getConnection());
	}

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if (ctx.getSubAction().equals("anbarEmdadgarShow")) {
            return doShow(ctx, "anbarEmdadgarId", "anbarEmdadgarShow" );
        }
        else if (ctx.getSubAction().equals("mojoodiShow")) {
            //----------------------------- emdadgarId -------------------------------
            String emdadgarId = (String) ctx.getForm().get(ValueObject.ID);
            emdadgarId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadgarModel", emdadgarId, "emdadgar", "emdadgarId");
            if (emdadgarId == null || emdadgarId.length()==0)
                return ctx.getActionMapping().findForward("showNotFound");
//            log.info("~~~~~~~~~ emdadgarId: " + emdadgarId);

            //----------------------------- qateId -------------------------------
            String qateId = ctx.getRequest().getParameter("qateId");
            qateId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.QateModel", qateId, "qate", "qateId");
            if (qateId == null || qateId.length()==0)
                return ctx.getActionMapping().findForward("showNotFound");
//            log.info("~~~~~~~~~ qateId: " + qateId);

            //----------------------------- anbarEmdadgarId -------------------------------
            String id = UserAccessEntity.stringQuery("SELECT id FROM anbarEmdadgar WHERE anbarEmdadgar.emdadgarId = '" + emdadgarId + "' AND anbarEmdadgar.qateId = '" + qateId + "'", "id");
//            log.info("~~~~~~~~~ anbarEmdadgarId: " + id);
            if (id != null && !id.equals(""))
                ctx.getForm().set(ValueObject.ID, id);
            else
                return ctx.getActionMapping().findForward("showNotFound");

            doReadById(ctx);
            return ctx.getActionMapping().findForward("mojoodiShow");
        }

        else if (ctx.getSubAction().equals("valueAnbarShow")) {
            //----------------------------- emdadgarId -------------------------------
            String emdadgarId = (String) ctx.getForm().get(ValueObject.ID);
            emdadgarId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadgarModel", emdadgarId, "emdadgar", "emdadgarId");

            if (emdadgarId == null || emdadgarId.length()==0)
                return ctx.getActionMapping().findForward("showNotFound");
//            log.info("~~~~~~~~~ emdadgarId: " + emdadgarId);

            String valueAnbar = (new Integer (getValueAnbar (ctx, emdadgarId))).toString();
//            log.info("~~~~~~~~~~~ valueAnbar: " + valueAnbar);
            ctx.getRequest().setAttribute("valueAnbar", valueAnbar);
            return ctx.getActionMapping().findForward("valueAnbarShow");
        }
        return listAll(ctx);
    }
}
