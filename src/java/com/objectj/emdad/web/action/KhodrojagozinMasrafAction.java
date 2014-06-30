package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
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

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.Timestamp;

import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;

/**
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/c/khodrojagozinMasraf"
 *      pathPrime="/khodrojagozinMasraf"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozinMasraf.edit.jsp"
 *      inputPrime="emdad.khodrojagozinMasraf.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/r/khodrojagozinMasraf"
 *      pathPrime="/khodrojagozinMasraf"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozinMasraf.read.jsp"
 *      inputPrime="emdad.khodrojagozinMasraf.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/u/khodrojagozinMasraf"
 *      pathPrime="/khodrojagozinMasraf"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozinMasraf.edit.jsp"
 *      inputPrime="emdad.khodrojagozinMasraf.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/d/khodrojagozinMasraf"
 *      pathPrime="/khodrojagozinMasraf"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozinMasraf.read.jsp"
 *      inputPrime="emdad.khodrojagozinMasraf.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/l/khodrojagozinMasraf"
 *      pathPrime="/khodrojagozinMasrafList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrojagozinMasraf.list.jsp"
 *      inputPrime="emdad.khodrojagozinMasraf.list"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/c/validatekhodrojagozinMasraf"
 *      pathPrime="/validatekhodrojagozinMasraf"
 *      scope="request"
 *      input="/c/khodrojagozinMasraf.run"
 *      inputPrime="emdad.khodrojagozinMasraf.edit"
 *      input4tiles="emdad.khodrojagozinMasraf.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="khodrojagozinMasrafForm"
 *      path="/u/validatekhodrojagozinMasraf"
 *      pathPrime="/validatekhodrojagozinMasraf"
 *      scope="request"
 *      input="/u/khodrojagozinMasraf.run"
 *      inputPrime="emdad.khodrojagozinMasraf.edit"
 *      input4tiles="emdad.khodrojagozinMasraf.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.khodrojagozinMasraf.list"
 *      pathPrime="emdad.khodrojagozinMasraf.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.khodrojagozinMasraf.edit"
 *      pathPrime="emdad.khodrojagozinMasraf.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.khodrojagozinMasraf.read"
 *      pathPrime="emdad.khodrojagozinMasraf.read"
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

public class KhodrojagozinMasrafAction extends BaseAction {
    private final static int FAAL= 1;
    private final static int GHEIRE_FAAL= 2;

    protected Class getValueObjectClass() {
        return KhodrojagozinMasrafModel.class;
    }
    protected String[] getRelatedEntities() {
        return new String[]{"khodrojagozin", "emdad" , "daftarOstani"};
    }

    protected String[] getSortableColumns() {
        return new String[]{"emdadId", "khodrojagozinId", "tarikhTahvilBeMoshtari", "tarikhTahvilAzMoshtari"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KhodrojagozinMasrafSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getForceFilter(BaseActionContext ctx) {
        String filter = super.getForceFilter(ctx);
        if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess()) {
            if(filter != null)
                filter += " AND ";
            else
                filter = "";
            filter += " khodrojagozinMasraf.daftarOstaniId = 'S" + getDaftarOstani(ctx) + "'";
        }
        return filter;
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.getRequest().setAttribute("khodrojagozinList", ComboPool.getCombo("khodrojagozin" , " khodrojagozin.daftarOstaniId = '" + getDaftarOstani(ctx) + "'"));
        ctx.getRequest().setAttribute("khodrojagozinList_faal", ComboPool.getCombo("khodrojagozin_faal" , " khodrojagozin.daftarOstaniId = '" + getDaftarOstani(ctx) + "'"));
        Util.getArrayList("yesNo"); // required for loading
        if (ctx.getUserSession().getSpecific(ctx.getEntity())==null)
            ctx.getUserSession().setSpecific(" /* khodrojagozinMasraf.tarikhTahvilAzMoshtari is NULL */ " ,"",ctx.getEntity());
      //  ctx.getRequest().setAttribute("daftarOstaniList", daftarOstaniList);
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {

        if (!isCancelled(ctx.getRequest())) {
            try {
                KhodrojagozinMasrafModel vo = new KhodrojagozinMasrafModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhTahvilBeMoshtari")) != null && ((String) (ctx.getForm().get("tarikhTahvilBeMoshtari"))).length() != 0)
                    vo.setTarikhTahvilBeMoshtari(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("tarikhTahvilBeMoshtari"), (String)ctx.getForm().get("tarikhTahvilBeMoshtari2")));
                String khodrojagozinId = (String) ctx.getForm().get("khodrojagozinId");
                log.info("========== khodrojagozinId = " + khodrojagozinId);
                ((KhodrojagozinMasrafProxy) getProxy()).create(vo, (String) ctx.getForm().get("emdadId"), (String) ctx.getForm().get("khodrojagozinId"));

                KhodrojagozinList voKhodrojagozin = (KhodrojagozinList)KhodrojagozinSessionUtil.getLocalHome().create().read(khodrojagozinId);
                voKhodrojagozin.setFaal(new Integer(GHEIRE_FAAL));
                KhodrojagozinSessionUtil.getLocalHome().create().update(voKhodrojagozin, voKhodrojagozin.getRangeKhodroId(), voKhodrojagozin.getNoeKhodroId(), voKhodrojagozin.getDaftarOstaniId());
                log.info("==========  be moshtari dadeh shod ");

            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("emdadEmdadId", "");
        ctx.getForm().set("khodrojagozinId", "");
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                KhodrojagozinMasrafModel vo = new KhodrojagozinMasrafModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

//                log.info("form="+ctx.getForm());

                if ((String) (ctx.getForm().get("tarikhTahvilBeMoshtari")) != null && ((String) (ctx.getForm().get("tarikhTahvilBeMoshtari"))).length() != 0)
                    vo.setTarikhTahvilBeMoshtari(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("tarikhTahvilBeMoshtari"), (String)ctx.getForm().get("tarikhTahvilBeMoshtari2")));

                if ((String) (ctx.getForm().get("tarikhTahvilAzMoshtari")) != null && ((String) (ctx.getForm().get("tarikhTahvilAzMoshtari"))).length() != 0)
                    vo.setTarikhTahvilAzMoshtari(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("tarikhTahvilAzMoshtari"), (String)ctx.getForm().get("tarikhTahvilAzMoshtari2")));

                String khodrojagozinId = (String) ctx.getForm().get("khodrojagozinId");
                log.info("========== khodrojagozinId = " + khodrojagozinId);

                ((KhodrojagozinMasrafProxy) getProxy()).update(vo, (String)ctx.getForm().get("emdadId"), (String) ctx.getForm().get("khodrojagozinId"));
                log.info("==========  oomad ta inja ");
                if ((String) (ctx.getForm().get("tarikhTahvilAzMoshtari")) != null && ((String) (ctx.getForm().get("tarikhTahvilAzMoshtari"))).length() != 0) {
                    log.info("==========  pas dade shod ");
                    KhodrojagozinList voKhodrojagozin = (KhodrojagozinList)KhodrojagozinSessionUtil.getLocalHome().create().read(khodrojagozinId);
                    voKhodrojagozin.setFaal(new Integer(FAAL));
                    KhodrojagozinSessionUtil.getLocalHome().create().update(voKhodrojagozin, voKhodrojagozin.getRangeKhodroId(), voKhodrojagozin.getNoeKhodroId(), voKhodrojagozin.getDaftarOstaniId());

                    String emdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", (String) ctx.getForm().get("emdadEmdadId"), "emdad", "emdadId");
                    EmdadList voEmdad = (EmdadList)EmdadSessionUtil.getLocalHome().create().read(emdadId);
                    String idGhabli = Integer.toString(voEmdad.getDastoorKarGhabli().intValue());
                    emdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", idGhabli, "emdad", "emdadId");
                    voEmdad = (EmdadList)EmdadSessionUtil.getLocalHome().create().read(emdadId);
                    voEmdad.setVazeatDakheli(new Integer(0));
                    EmdadSessionUtil.getLocalHome().create().update(voEmdad, voEmdad.getRokhdadId(), voEmdad.getVazeatKhedmatId(), voEmdad.getEmdadgarId(), voEmdad.getEzamgarId(),voEmdad.getDalileToolKeshidaneEmdadId(), voEmdad.getNamayandegiId() );
                }

            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("emdadEmdadId", "");
        ctx.getForm().set("khodrojagozinId", "");
        return listAll(ctx);
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullAzMoshtari = false;
        boolean isNullBeMoshtari = false;

        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);

        if (((KhodrojagozinMasrafModel) (vo)).getTarikhTahvilAzMoshtari() == null) {
            ((KhodrojagozinMasrafModel) (vo)).setTarikhTahvilAzMoshtari(new Timestamp(0));
            isNullAzMoshtari = true;
        }
        if (((KhodrojagozinMasrafModel) (vo)).getTarikhTahvilBeMoshtari() == null) {
            ((KhodrojagozinMasrafModel) (vo)).setTarikhTahvilBeMoshtari(new Timestamp(0));
            isNullBeMoshtari = true;
        }

        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        ctx.getRequest().setAttribute("shomarehPelak", ((KhodrojagozinMasrafList) (vo)).getKhodrojagozinPelak() );
        if (!isNullBeMoshtari){
            ctx.getForm().set("tarikhTahvilBeMoshtari", HejriUtil.chrisToHejri(((KhodrojagozinMasrafModel) (vo)).getTarikhTahvilBeMoshtari()));
            ctx.getForm().set("tarikhTahvilBeMoshtari2", HejriUtil.getTimeFromDate(((KhodrojagozinMasrafModel)vo).getTarikhTahvilBeMoshtari()));
        }
        else {
            ctx.getForm().set("tarikhTahvilBeMoshtari", "");
            ctx.getForm().set("tarikhTahvilBeMoshtari", "");
        }

        if (!isNullAzMoshtari){
            ctx.getForm().set("tarikhTahvilAzMoshtari", HejriUtil.chrisToHejri(((KhodrojagozinMasrafModel) (vo)).getTarikhTahvilAzMoshtari()));
            ctx.getForm().set("tarikhTahvilAzMoshtari2", HejriUtil.getTimeFromDate(((KhodrojagozinMasrafModel)vo).getTarikhTahvilAzMoshtari()));
        }
        else {
            ctx.getForm().set("tarikhTahvilAzMoshtari", "");
            ctx.getForm().set("tarikhTahvilAzMoshtari", "");
        }

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");

        return ctx.getActionMapping().findForward("edit");
    }


    protected void doFilterPreProcessor(BaseActionContext ctx) {
        if (ctx.getForm().get("emdadEmdadId") != null && ((String)ctx.getForm().get("emdadEmdadId")).length() != 0)
            ctx.getForm().set("emdad.emdadId", Integer.valueOf(ctx.getForm().get("emdadEmdadId").toString()));
        else
            ctx.getForm().set("emdad.emdadId", null);

//        //=-= System.out.println("ctx.getForm() = " + ctx.getForm());
        ctx.getForm().set("emdadEmdadId", null);
    }

/*    protected String getForceFilter(BaseActionContext ctx) {
        if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess())
            return "khodroJagozinMasraf.daftarOstaniId = 'S" + getDaftarOstani(ctx)+ "'";
        return "";
    }*/
}
