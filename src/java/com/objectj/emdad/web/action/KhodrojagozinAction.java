package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.KhodrojagozinModel;
import com.objectj.emdad.ejb.KhodrojagozinUtil;
import com.objectj.emdad.ejb.DaftarOstaniModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
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
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/c/khodrojagozin"
 *      pathPrime="/khodrojagozin"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.edit.jsp"
 *      inputPrime="emdad.khodrojagozin.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/r/khodrojagozin"
 *      pathPrime="/khodrojagozin"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.read.jsp"
 *      inputPrime="emdad.khodrojagozin.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/u/khodrojagozin"
 *      pathPrime="/khodrojagozin"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.edit.jsp"
 *      inputPrime="emdad.khodrojagozin.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/d/khodrojagozin"
 *      pathPrime="/khodrojagozin"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.read.jsp"
 *      inputPrime="emdad.khodrojagozin.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/l/khodrojagozin"
 *      pathPrime="/khodrojagozinList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.list.jsp"
 *      inputPrime="emdad.khodrojagozin.list"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/c/validatekhodrojagozin"
 *      pathPrime="/validatekhodrojagozin"
 *      scope="request"
 *      input="/c/khodrojagozin.run"
 *      inputPrime="emdad.khodrojagozin.edit"
 *      input4tiles="emdad.khodrojagozin.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/u/validatekhodrojagozin"
 *      pathPrime="/validatekhodrojagozin"
 *      scope="request"
 *      input="/u/khodrojagozin.run"
 *      inputPrime="emdad.khodrojagozin.edit"
 *      input4tiles="emdad.khodrojagozin.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="khodrojagozinForm"
 *      path="/s/khodrojagozin"
 *      pathPrime="/khodrojagozinShow"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozin.show.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/khodrojagozin.show.jsp"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.khodrojagozin.list"
 *      pathPrime="emdad.khodrojagozin.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.khodrojagozin.edit"
 *      pathPrime="emdad.khodrojagozin.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.khodrojagozin.read"
 *      pathPrime="emdad.khodrojagozin.read"
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
 *      name="khodrojagozinShow"
 *      path="/com/objectj/emdad/jsp/khodrojagozin.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/khodrojagozin.show.jsp"
 *
 * @struts.action-forward
 *      name="khodrojagozinVazeat"
 *      path="/com/objectj/emdad/jsp/khodrojagozin.vazeat.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/khodrojagozin.vazeat.jsp"
 *
 */

public class KhodrojagozinAction extends BaseAction {
    private final static int FAAL = 1;
    private final static int GHEIRE_FAAL = 2;
    ArrayList faalList = new ArrayList();

    protected Class getValueObjectClass() {
        return KhodrojagozinModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"khodrojagozinId", "noeKhodroId", "shomarehPelak", "salesakht", "faal", "daftarOstaniId"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KhodrojagozinSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String[] getRelatedEntities() {
        return new String[] {"noeKhodro",  "rangekhodro", "daftarOstani"};
    }

    protected String getForceFilter(BaseActionContext ctx) {
        String filter = ctx.getUserSession().getForceFilter(ctx.getEntity());
        if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess()) {
            if(filter != null)
                filter += " AND ";
            else
                filter = "";
            filter += " khodrojagozin.daftarOstaniId = 'S" + getDaftarOstani(ctx) + "'";
        }
        return filter;
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                KhodrojagozinModel vo = new KhodrojagozinModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                ((KhodrojagozinProxy) getProxy()).create(vo,(String)ctx.getForm().get("rangeKhodroId"),(String)ctx.getForm().get("noeKhodroId"), getDaftarOstani(ctx));
                ctx.getForm().set("daftarOstaniId", null);
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        try {
            if (!isCancelled(ctx.getRequest())) {
                KhodrojagozinModel vo = new KhodrojagozinModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                ((KhodrojagozinProxy) getProxy()).update(vo,(String)ctx.getForm().get("rangeKhodroId"),(String)ctx.getForm().get("noeKhodroId"), (String)ctx.getForm().get("daftarOstaniId"));
            }
            ctx.getForm().set("daftarOstaniId", null);
            ComboPool.setDirty(ctx.getEntity());
        } catch (ProxyException e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return listAll(ctx);
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {

        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        //---------------------------------------------------
        DaftarOstaniModel daftarOstaniModel = null;
        try {
            daftarOstaniModel = (DaftarOstaniModel)DaftarOstaniSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("daftarOstaniId"));
        }
        catch (Exception e) {
        }
        ctx.getRequest().setAttribute("daftarOstaniName", daftarOstaniModel.getName());
        //---------------------------------------------------

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

        ArrayList noeKhodroList = new ArrayList();
        ArrayList rangeKhodroList = new ArrayList();
        ArrayList daftarOstaniList = new ArrayList();

        try {
            noeKhodroList = ComboPool.getCombo("noeKhodro");
            rangeKhodroList = ComboPool.getCombo("rangeKhodro");
            daftarOstaniList = ComboPool.getCombo("daftarOstani");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }

        faalList = Util.getArrayList("yesNo");

        ctx.getRequest().setAttribute("noeKhodroList", noeKhodroList);
        ctx.getRequest().setAttribute("rangeKhodroList", rangeKhodroList);
        ctx.getRequest().setAttribute("daftarOstaniList", daftarOstaniList);
        ctx.getRequest().setAttribute("faalList",faalList);
    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if (ctx.getSubAction().equals("khodrojagozinShow")) {
            return doShow(ctx, "khodrojagozinId", "khodrojagozinShow");
        }
        else if (ctx.getSubAction().equals("khodrojagozinVazeat")) {
            String tedadFaal = UserAccessEntity.stringQuery("select count(*) as count from khodrojagozin where faal = '" + FAAL + "'", "count");
            String minTarikh = UserAccessEntity.stringQuery("SELECT min(KhodrojagozinMasraf.tarikhTahvilBeMoshtari + emdad.modatTamir) as min FROM  KhodrojagozinMasraf, Emdad, Khodrojagozin WHERE KhodrojagozinMasraf.emdadId = Emdad.id AND KhodrojagozinMasraf.khodrojagozinId = Khodrojagozin.id AND KhodrojagozinMasraf.tarikhTahvilAzMoshtari is null AND Khodrojagozin.daftarOstaniId = '" + ctx.getUserSession().getDaftarOstani() + "'","min");
            String akharinTarikh = UserAccessEntity.stringQuery("SELECT max(KhodrojagozinMasraf.tarikhTahvilAzMoshtari) as max FROM  KhodrojagozinMasraf, Emdad, Khodrojagozin WHERE KhodrojagozinMasraf.emdadId = Emdad.id AND KhodrojagozinMasraf.khodrojagozinId = Khodrojagozin.id AND Khodrojagozin.daftarOstaniId = '" + ctx.getUserSession().getDaftarOstani() + "'","max");

            ctx.getRequest().setAttribute("tedadFaal", tedadFaal);
            if (minTarikh != null && minTarikh.length() != 0)
                ctx.getRequest().setAttribute("minTarikh", com.objectj.emdad.ejb.util.HejriUtil.chrisToHejri(Timestamp.valueOf(minTarikh)));
            else
                ctx.getRequest().setAttribute("minTarikh", "");
            if (akharinTarikh != null && akharinTarikh.length() != 0)
                ctx.getRequest().setAttribute("akharinTarikh", com.objectj.emdad.ejb.util.HejriUtil.chrisToHejri(Timestamp.valueOf(akharinTarikh)));
            else
                ctx.getRequest().setAttribute("akharinTarikh", "");
            //todo
            return ctx.getActionMapping().findForward("khodrojagozinVazeat");
        }

        return listAll(ctx);
    }
}

