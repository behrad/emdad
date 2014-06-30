package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
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
import java.util.StringTokenizer;
import java.sql.Date;

/**
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/c/namayandegi"
 *      pathPrime="/namayandegi"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/namayandegi.edit.jsp"
 *      inputPrime="emdad.namayandegi.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/r/namayandegi"
 *      pathPrime="/namayandegi"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/namayandegi.read.jsp"
 *      inputPrime="emdad.namayandegi.read"
 *      validate="false"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/u/namayandegi"
 *      pathPrime="/namayandegi"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/namayandegi.edit.jsp"
 *      inputPrime="emdad.namayandegi.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/d/namayandegi"
 *      pathPrime="/namayandegi"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/namayandegi.read.jsp"
 *      inputPrime="emdad.namayandegi.read"
 *      validate="false"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/l/namayandegi"
 *      pathPrime="/namayandegiList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/namayandegi.list.jsp"
 *      inputPrime="emdad.namayandegi.list"
 *      validate="false"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/c/validatenamayandegi"
 *      pathPrime="/validatenamayandegi"
 *      scope="request"
 *      input="/c/namayandegi.run"
 *      inputPrime="emdad.namayandegi.edit"
 *      input4tiles="emdad.namayandegi.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="namayandegiForm"
 *      path="/u/validatenamayandegi"
 *      pathPrime="/validatenamayandegi"
 *      scope="request"
 *      input="/u/namayandegi.run"
 *      inputPrime="emdad.namayandegi.edit"
 *      input4tiles="emdad.namayandegi.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.namayandegi.list"
 *      pathPrime="emdad.namayandegi.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.namayandegi.edit"
 *      pathPrime="emdad.namayandegi.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.namayandegi.read"
 *      pathPrime="emdad.namayandegi.read"
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

public class NamayandegiAction extends BaseAction {

    static ArrayList nazarIsacoList = new ArrayList();
    static ArrayList vazGharardadList = new ArrayList();
    static ArrayList sabegheFaaliatList = new ArrayList();
    static ArrayList sabegheNorooziList = new ArrayList();

    protected Class getValueObjectClass() {
        return NamayandegiModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"namayandegiId", "name", "shahrId", "shomarehGharardad", "daftarOstaniId" ,"hadaksarKar" , "hadaksarKar2"};
    }

    protected String[] getRelatedEntities() {
        return new String[] {"noeKhodro", "shahr", "daftarOstani"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NamayandegiSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }


    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                NamayandegiModel vo = new NamayandegiModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                if ((String)(ctx.getForm().get("tarikhTahvil")) != null && ((String)(ctx.getForm().get("tarikhTahvil"))).length() != 0)
                    vo.setTarikhTahvil(HejriUtil.toDate((String)(ctx.getForm().get("tarikhTahvil"))));
                if ((String)(ctx.getForm().get("tarikhGharardad")) != null && ((String)(ctx.getForm().get("tarikhGharardad"))).length() != 0)
                    vo.setTarikhGharardad(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhGharardad")))));
                if ((String)(ctx.getForm().get("tarikhAkharinEstelam")) != null && ((String)(ctx.getForm().get("tarikhAkharinEstelam"))).length() != 0)
                    vo.setTarikhAkharinEstelam(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhAkharinEstelam")))));
                vo.setKarDarDast(new Integer(0));
                vo.setKarDarDast2(new Integer(0));
                ((NamayandegiProxy) getProxy()).create(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("daftarOstaniId").toString());
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
            com.objectj.emdad.proxy.NamayandegiSessionLocalHome lhProxy = com.objectj.emdad.proxy.NamayandegiSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.NamayandegiSessionLocal lProxy = lhProxy.create();
            ValueObject voNamayandegiList = lProxy.read(id);

            ctx.getRequest().setAttribute(VALUE_OBJECT, voNamayandegiList);
            ctx.getRequest().setAttribute("nazarIsaco",  ((ComboObject)nazarIsacoList.get(((NamayandegiModel)voNamayandegiList).getNazarIsaco().intValue())).getName());
            ctx.getRequest().setAttribute("vazGharardad", ((ComboObject)vazGharardadList.get(((NamayandegiModel)voNamayandegiList).getVazGharardad().intValue())).getName());
            ctx.getRequest().setAttribute("sabegheFaaliat", ((ComboObject)sabegheFaaliatList.get(((NamayandegiModel)voNamayandegiList).getSabegheFaaliat().intValue())).getName());
            ctx.getRequest().setAttribute("sabegheNoroozi", ((ComboObject)sabegheNorooziList.get(((NamayandegiModel)voNamayandegiList).getSabegheNoroozi().intValue())).getName());
            if (((NamayandegiModel)(voNamayandegiList)).getTarikhTahvil() != null)
                ctx.getRequest().setAttribute("tarikhTahvil",HejriUtil.chrisToHejri(((NamayandegiModel)(voNamayandegiList)).getTarikhTahvil()));
            else
                ctx.getRequest().setAttribute("tarikhTahvil","");
            if (((NamayandegiModel)(voNamayandegiList)).getTarikhGharardad() != null)
                ctx.getRequest().setAttribute("tarikhGharardad",HejriUtil.chrisToHejri(((NamayandegiModel)(voNamayandegiList)).getTarikhGharardad()));
            else
                ctx.getRequest().setAttribute("tarikhGharardad","");

            if (((NamayandegiModel)(voNamayandegiList)).getTarikhAkharinEstelam() != null)
                ctx.getRequest().setAttribute("tarikhAkharinEstelam",HejriUtil.chrisToHejri(((NamayandegiModel)(voNamayandegiList)).getTarikhAkharinEstelam()));
            else
                ctx.getRequest().setAttribute("tarikhAkharinEstelam","");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }


    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullGharardad = false;
        boolean isNullTahvil = false;
        boolean isNullEstelam = false;

        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);
        if (((NamayandegiModel)(vo)).getTarikhGharardad() == null){
            ((NamayandegiModel)(vo)).setTarikhGharardad(new Date(0));
            isNullGharardad = true;
        }
        if (((NamayandegiModel)(vo)).getTarikhTahvil() == null){
            ((NamayandegiModel)(vo)).setTarikhTahvil(new Date(0));
            isNullTahvil = true;
        }
        if (((NamayandegiModel)(vo)).getTarikhAkharinEstelam() == null){
            ((NamayandegiModel)(vo)).setTarikhAkharinEstelam(new Date(0));
            isNullEstelam = true;
        }
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        if (!isNullTahvil)
            ctx.getForm().set("tarikhTahvil",HejriUtil.chrisToHejri(((NamayandegiModel)(vo)).getTarikhTahvil()));
        else
            ctx.getForm().set("tarikhTahvil", "");

        if (!isNullEstelam)
            ctx.getForm().set("tarikhAkharinEstelam",HejriUtil.chrisToHejri(((NamayandegiModel)(vo)).getTarikhAkharinEstelam()));
        else
            ctx.getForm().set("tarikhAkharinEstelam", "");

        if (!isNullGharardad)
            ctx.getForm().set("tarikhGharardad",HejriUtil.chrisToHejri(((NamayandegiModel)(vo)).getTarikhGharardad()));
        else
            ctx.getForm().set("tarikhGharardad","");
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        try {
            if (!isCancelled(ctx.getRequest())) {
                NamayandegiModel vo = new NamayandegiModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String)(ctx.getForm().get("tarikhTahvil")) != null && ((String)(ctx.getForm().get("tarikhTahvil"))).length() != 0)
                    vo.setTarikhTahvil(HejriUtil.toDate((String)(ctx.getForm().get("tarikhTahvil"))));
                if ((String)(ctx.getForm().get("tarikhGharardad")) != null && ((String)(ctx.getForm().get("tarikhGharardad"))).length() != 0)
                    vo.setTarikhGharardad(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhGharardad")))));
                if ((String)(ctx.getForm().get("tarikhAkharinEstelam")) != null && ((String)(ctx.getForm().get("tarikhAkharinEstelam"))).length() != 0)
                    vo.setTarikhAkharinEstelam(HejriUtil.toDate((String)(ctx.getForm().get("tarikhAkharinEstelam")))) ;

                ((NamayandegiProxy)getProxy()).update(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("daftarOstaniId").toString());
                ComboPool.setDirty(ctx.getEntity());
            }
        } catch (ProxyException e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return listAll(ctx);
    }


    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

        ArrayList shahrList = new ArrayList();
        ArrayList noeKhodroList = new ArrayList();
        ArrayList daftarOstaniList = new ArrayList();
        ArrayList noeNamayandegiList = new ArrayList();
        try {
            shahrList = ComboPool.getCombo("shahr"); // ShahrSessionUtil.getLocalHome().create().readCombo("shahr", "shahrName").getResult();
            noeKhodroList = ComboPool.getCombo("noeKhodro");
			daftarOstaniList = ComboPool.getCombo("daftarOstani");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }

        noeNamayandegiList = Util.getArrayList("noeNamayandegi");
        vazGharardadList = Util.getArrayList("vazGharardad");
        nazarIsacoList = Util.getArrayList("nazarIsaco");
        sabegheFaaliatList = Util.getArrayList("daradNadarad");
        sabegheNorooziList = Util.getArrayList("daradNadarad");

        ctx.getRequest().setAttribute("shahrList", shahrList);
        ctx.getRequest().setAttribute("daftarOstaniList", daftarOstaniList);
        ctx.getRequest().setAttribute("noeKhodroList", noeKhodroList);
        ctx.getRequest().setAttribute("vazGharardadList", vazGharardadList);
        ctx.getRequest().setAttribute("nazarIsacoList", nazarIsacoList);
        ctx.getRequest().setAttribute("sabegheFaaliatList",sabegheFaaliatList);
        ctx.getRequest().setAttribute("sabegheNorooziList", sabegheNorooziList);
        ctx.getRequest().setAttribute("noeNamayandegiList", noeNamayandegiList);
    }

    protected Date hejriToChris(String hejriDate){
        Integer year = new Integer(1);
        Integer month = new Integer(1);
        Integer day = new Integer(1);
        boolean hasDate =false;

        StringTokenizer date = new StringTokenizer(hejriDate, "/");

        if (date.hasMoreTokens()) {
            year = Integer.valueOf(date.nextToken());
           if (date.hasMoreTokens()) {
                month = Integer.valueOf(date.nextToken());
                if (date.hasMoreTokens()) {
                    day = Integer.valueOf(date.nextToken());
                    hasDate = true;
                }
            }
        }

        if (hasDate){
            Date c = new Date(0);
            c = HejriUtil.encodeHejriDate(year.intValue(), month.intValue(), day.intValue());
            return c;
        }
        return null;
    }

}
