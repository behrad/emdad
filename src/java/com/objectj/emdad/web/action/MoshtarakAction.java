package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.EntityList;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;

import com.objectj.emdad.proxy.util.ImportDBF;
import com.objectj.emdad.proxy.util.IranSysDecoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.rmi.RemoteException;
import java.sql.*;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionError;

import javax.servlet.ServletException;
import javax.ejb.CreateException;
import javax.naming.NamingException;

/**
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/c/moshtarak"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.edit.jsp"
 *      inputPrime="emdad.moshtarak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/r/moshtarak"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.read.jsp"
 *      inputPrime="emdad.moshtarak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/u/moshtarak"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.edit.jsp"
 *      inputPrime="emdad.moshtarak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/d/moshtarak"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.read.jsp"
 *      inputPrime="emdad.moshtarak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/l/moshtarak"
 *      pathPrime="/moshtarakList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.list.jsp"
 *      inputPrime="emdad.moshtarak.list"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/c/validatemoshtarak"
 *      pathPrime="/validatemoshtarak"
 *      scope="request"
 *      input="/c/moshtarak.run"
 *      inputPrime="emdad.moshtarak.edit"
 *      input4tiles="emdad.moshtarak.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/s/validatemoshtarak"
 *      pathPrime="/validatemoshtarak"
 *      scope="request"
 *      input="/c/moshtarak.run"
 *      inputPrime="emdad.moshtarak.edit"
 *      input4tiles="emdad.moshtarak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/u/validatemoshtarak"
 *      pathPrime="/validatemoshtarak"
 *      scope="request"
 *      input="/u/moshtarak.run"
 *      inputPrime="emdad.moshtarak.edit"
 *      input4tiles="emdad.moshtarak.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/s/moshtarak"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.importinfo.jsp"
 *      inputPrime="emdad.moshtarak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="moshtarakForm"
 *      path="/s/moshtari"
 *      pathPrime="/moshtarak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/moshtarak.importinfo.jsp"
 *      inputPrime="emdad.moshtarak.read"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="find"
 *      path="/com/objectj/emdad/jsp/moshtari.find.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/moshtari.find.jsp"
 *
 * @struts.action-forward
 *      name="moshtarakShow"
 *      path="/com/objectj/emdad/jsp/moshtarak.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/moshtarak.show.jsp"
 *
 * @struts.action-forward
 *      name="savabegh"
 *      path="/com/objectj/emdad/jsp/moshtari.savabegh.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/moshtari.savabegh.jsp"
 *
 * @struts.action-forward
 *      name="gheirMoshtarakShow"
 *      path="/com/objectj/emdad/jsp/gheirMoshtarak.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/gheirMoshtarak.show.jsp"
 *
 * @struts.action-forward
 *      name="gheirMoshtarakConfirm"
 *      path="/com/objectj/emdad/jsp/gheirMoshtarak.confirm.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/gheirMoshtarak.confirm.jsp"
 *
 * @struts.action-forward
 *      name="expired"
 *      path="emdad.moshtarak.expired"
 *      pathPrime="emdad.moshtarak.expired"
 *
 * @struts.action-forward
 *      name="gheirMoshtarakCreate"
 *      path="/com/objectj/emdad/jsp/gheirMoshtarak.edit.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/gheirMoshtarak.edit.jsp"
 *
 * @struts.action-forward
 *      name="gheirMoshtarakRead"
 *      path="emdad.gheirMoshtarak.read"
 *      pathPrime="emdad.gheirMoshtarak.read"
 *
 * @struts.action-forward
 *      name="gheirMoshtarakList"
 *      path="emdad.gheirMoshtarak.list"
 *      pathPrime="emdad.gheirMoshtarak.list"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.moshtarak.list"
 *      pathPrime="emdad.moshtarak.list"
 *
 * @struts.action-forward
 *      name="requpload"
 *      path="emdad.moshtarak.requpload"
 *      pathPrime="emdad.moshtarak.requpload"
 *
 * @struts.action-forward
 *      name="uploaded"
 *      path="emdad.moshtarak.uploaded"
 *      pathPrime="emdad.moshtarak.uploaded"
 *
 * @struts.action-forward
 *      name="importinfo"
 *      path="emdad.moshtarak.importinfo"
 *      pathPrime="emdad.moshtarak.importinfo"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="/com/objectj/emdad/jsp/moshtarak.edit.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/moshtarak.edit.jsp"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.moshtarak.read"
 *      pathPrime="emdad.moshtarak.read"
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
 *      name="reqPeygiri"
 *      path="emdad.moshtarak.reqPeygiri"
 *      pathPrime="emdad.moshtarak.reqPeygiri"
 *
 *  @struts.action-forward
 *      name="infoPeygiri"
 *      path="emdad.moshtarak.infoPeygiri"
 *      pathPrime="emdad.moshtarak.infoPeygiri"
 *
 * @struts.action-forward
 *      name="close"
 *      path="/com/objectj/emdad/jsp/close.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/close.jsp"
 *
 * @struts.action-forward
 *      name="refresh"
 *      path="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 *
 * @struts.action-forward
 *		name="updatePelak"
 *		path="/com/objectj/emdad/jsp/shomarePelak.edit.jsp"
 *		pathPrime="/com/objectj/emdad/jsp/shomarePelak.edit.jsp"
 */

public class MoshtarakAction extends BaseAction {

    protected Class getValueObjectClass() {
        return MoshtarakModel.class;
    }

    protected Class getValueObjectClass2() {
        return MoshtarakList.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"eshterakId", "shomareShasi", "noeEshterak", "noeService", "vazeat", "nameKhanevadegi", "name", "noeKhodroId", "shomarePelak", "tarikhEngheza", "namayandegi", "tarikhEngheza"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"rangeKhodro", "noeKhodro", "shahr", "bazaryab"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MoshtarakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected ActionForward doEditFromError(BaseActionContext ctx) {
        String action = ctx.getRequest().getParameter("isList");
        log.info("moshtarak EditFromError: "+action);
        if(action.equals("close"))
            return ctx.getActionMapping().findForward("close");
        else
            return listAll(ctx);
    }

    protected ActionForward doNullAction(BaseActionContext ctx) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        ctx.getForm().set("guarantee", new Integer(2));
        ctx.getForm().set("majaziYaNa", new Integer(2));
        return ctx.getActionMapping().findForward("edit");
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.setEntityList("moshtarakList");

        ctx.getRequest().setAttribute("isList", "listAll");
        ctx.getRequest().setAttribute("shahrList", ComboPool.getCombo("shahr"));
        ctx.getRequest().setAttribute("noeKhodroList", ComboPool.getCombo("noeKhodro"));
        ctx.getRequest().setAttribute("rangeKhodroList", ComboPool.getCombo("rangeKhodro"));
        ctx.getRequest().setAttribute("bazaryabList", ComboPool.getCombo("bazaryab"));

        ctx.getRequest().setAttribute("guaranteeList", Util.getArrayList("yesNo"));
        ctx.getRequest().setAttribute("noeEshterakList", Util.getArrayList("noeEshterak"));
        ctx.getRequest().setAttribute("noeServiceList", Util.getArrayList("noeService"));
        ctx.getRequest().setAttribute("vazeatList", Util.getArrayList("vazeat"));
        ctx.getRequest().setAttribute("moshtarakYaNaList", Util.getArrayList("yesNo"));
        ctx.getRequest().setAttribute("majaziYaNaList", Util.getArrayList("yesNo"));
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        MoshtarakModel gheirMoshtarakModel = null;
        if (!isCancelled(ctx.getRequest())) {
            try {
                MoshtarakModel vo = new MoshtarakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhTavalod")) != null && ((String) (ctx.getForm().get("tarikhTavalod"))).length() != 0)
                    vo.setTarikhTavalod(HejriUtil.toDate((String) (ctx.getForm().get("tarikhTavalod"))));

                if ((String) (ctx.getForm().get("tarikhShoro")) != null && ((String) (ctx.getForm().get("tarikhShoro"))).length() != 0) {
                    String tarikhShoro = (String) (ctx.getForm().get("tarikhShoro"));
                    vo.setTarikhShoro(HejriUtil.toDate(tarikhShoro));
//                    log.info("========== vo.getTarikhShoro() = " + vo.getTarikhShoro());
                    vo.setTarikhEngheza(HejriUtil.incYear(HejriUtil.toDate(tarikhShoro)));
//                    log.info("========== vo.getTarikhEngheza() = " + vo.getTarikhEngheza());
                }

                if ((String) (ctx.getForm().get("tarikhAkharinTamdid")) != null && ((String) (ctx.getForm().get("tarikhAkharinTamdid"))).length() != 0)
                    vo.setTarikhAkharinTamdid(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhAkharinTamdid")))));

//if ((String) (ctx.getForm().get("tarikhEngheza")) != null && ((String) (ctx.getForm().get("tarikhEngheza"))).length() != 0)
//vo.setTarikhEngheza(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhEngheza")))));

                if ((String) (ctx.getForm().get("tarikhEnghezaGuarantee")) != null && ((String) (ctx.getForm().get("tarikhEnghezaGuarantee"))).length() != 0)
                    vo.setTarikhEnghezaGuarantee(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhEnghezaGuarantee")))));

                if ((String) (ctx.getForm().get("tarikhServiceAvalieh")) != null && ((String) (ctx.getForm().get("tarikhServiceAvalieh"))).length() != 0)
                    vo.setTarikhServiceAvalieh(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhServiceAvalieh")))));

                if ((String) (ctx.getForm().get("tarikhTahvil")) != null && ((String) (ctx.getForm().get("tarikhTahvil"))).length() != 0)
                    vo.setTarikhTahvil(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhTahvil")))));

                com.objectj.emdad.ejb.util.Util.add("unk_Bazaryab", Constants.getBazaryab_Unknown());
                com.objectj.emdad.ejb.util.Util.add("unk_Shahr", Constants.getShahr_Unknown());

                //----------  Seeting ctx.getRequest() parameters for gheirMoshtarak.confirm.jsp ------------------
                gheirMoshtarakModel =
                        (MoshtarakModel) ((MoshtarakProxy) getProxy()).create(vo, (String) (ctx.getForm().get("shahrId")), (String) (ctx.getForm().get("noeKhodroId")), (String) (ctx.getForm().get("rangeKhodroId")), (String) (ctx.getForm().get("bazaryabId")));
                //--------------------------------------------------------------------------------------------
                ActionErrors error = new ActionErrors();
                error.clear();
                String newEshterakId = vo.getEshterakId();
                error.add("eshterakId", new ActionError("moshtarak.new.eshterakId", newEshterakId));
                showMessage(ctx, error); //; ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);

            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        if (((Integer) ctx.getForm().get("moshtarakYaNa")).intValue() == 2) {
            if (gheirMoshtarakModel!=null) {
                try {
                    MoshtarakSessionLocal moshtarakProxy = null;
                    moshtarakProxy = MoshtarakSessionUtil.getLocalHome().create();
                    MoshtarakList moshtarakList = (MoshtarakList) moshtarakProxy.read(gheirMoshtarakModel.getId());
                    ctx.getRequest().setAttribute(VALUE_OBJECT + "1", moshtarakList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return ctx.getActionMapping().findForward("gheirMoshtarakConfirm");
        }
        return listAll(ctx);
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.MoshtarakSessionLocalHome lhProxy = com.objectj.emdad.proxy.MoshtarakSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.MoshtarakSessionLocal lProxy = lhProxy.create();
            ValueObject voMoshtarakList = lProxy.read(id);

            ctx.getRequest().setAttribute(VALUE_OBJECT, voMoshtarakList);
            if (((MoshtarakModel) (voMoshtarakList)).getTarikhEngheza() != null)
                ctx.getRequest().setAttribute("tarikhEngheza", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhEngheza()));
            else
                ctx.getRequest().setAttribute("tarikhEngheza", "");

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhShoro() != null)
                ctx.getRequest().setAttribute("tarikhShoro", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhShoro()));
            else
                ctx.getRequest().setAttribute("tarikhShoro", "");

            ctx.getRequest().setAttribute("majaziYaNa", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("yesNo",((MoshtarakModel) voMoshtarakList).getMajaziYaNa()));
            if (((MoshtarakModel) voMoshtarakList).getMajaziYaNa().intValue() == 1) {
                return ctx.getActionMapping().findForward("gheirMoshtarakRead");
            }

            ctx.getRequest().setAttribute("noeEshterak", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("noeEshterak",((MoshtarakModel) voMoshtarakList).getNoeEshterak()));
            ctx.getRequest().setAttribute("noeService", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("noeService",((MoshtarakModel) voMoshtarakList).getNoeService()));
            ctx.getRequest().setAttribute("vazeat", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("vazeat",((MoshtarakModel) voMoshtarakList).getVazeat()));

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhEnghezaGuarantee() != null)
                ctx.getRequest().setAttribute("tarikhEnghezaGuarantee", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhEnghezaGuarantee()));
            else
                ctx.getRequest().setAttribute("tarikhEnghezaGuarantee", "");

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhAkharinTamdid() != null)
                ctx.getRequest().setAttribute("tarikhAkharinTamdid", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhAkharinTamdid()));
            else
                ctx.getRequest().setAttribute("tarikhAkharinTamdid", "");

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhTavalod() != null)
                ctx.getRequest().setAttribute("tarikhTavalod", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhTavalod()));
            else
                ctx.getRequest().setAttribute("tarikhTavalod", "");

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhServiceAvalieh() != null)
                ctx.getRequest().setAttribute("tarikhServiceAvalieh", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhServiceAvalieh()));
            else
                ctx.getRequest().setAttribute("tarikhServiceAvalieh", "");

            if (((MoshtarakModel) (voMoshtarakList)).getTarikhTahvil() != null)
                ctx.getRequest().setAttribute("tarikhTahvil", HejriUtil.chrisToHejri(((MoshtarakModel) (voMoshtarakList)).getTarikhTahvil()));
            else
                ctx.getRequest().setAttribute("tarikhTahvil", "");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullTavalod = false;
        boolean isNullShoroEshterak = false;
        boolean isNullEnghezaEshterak = false;
        boolean isNullAkharinTamdid = false;
        boolean isNullEnghezaGuarantee = false;
        boolean isNullServiceAvalieh = false;
        boolean isNullTahvil = false;

        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);

        ctx.getRequest().setAttribute("noeKhodroOnvan", ((MoshtarakList) vo).getNoeKhodroOnvan());

        if (((MoshtarakModel) (vo)).getTarikhTavalod() == null) {
            ((MoshtarakModel) (vo)).setTarikhTavalod(new Date(0));
            isNullTavalod = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhShoro() == null) {
            ((MoshtarakModel) (vo)).setTarikhShoro(new Date(0));
            isNullShoroEshterak = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhEngheza() == null) {
            ((MoshtarakModel) (vo)).setTarikhEngheza(new Date(0));
            isNullEnghezaEshterak = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhAkharinTamdid() == null) {
            ((MoshtarakModel) (vo)).setTarikhAkharinTamdid(new Date(0));
            isNullAkharinTamdid = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhEnghezaGuarantee() == null) {
            ((MoshtarakModel) (vo)).setTarikhEnghezaGuarantee(new Date(0));
            isNullEnghezaGuarantee = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhServiceAvalieh() == null) {
            ((MoshtarakModel) (vo)).setTarikhServiceAvalieh(new Date(0));
            isNullServiceAvalieh = true;
        }

        if (((MoshtarakModel) (vo)).getTarikhTahvil() == null) {
            ((MoshtarakModel) (vo)).setTarikhTahvil(new Date(0));
            isNullTahvil = true;
        }

        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        String s = (String) ctx.getForm().get("shomarePelak");
        if (s != null && s.length() != 0) {
            if (s.indexOf(" ") > 0) {
                ctx.getForm().set("shomarePelak", s.substring(0, s.indexOf(" ")));
                ctx.getForm().set("shomarePelak2", s.substring(s.indexOf(" ")));
            } else
                ctx.getForm().set("shomarePelak", s);
        }

        ctx.getForm().set(ACTION_TYPE, "update");

        //		//=-= System.out.println("vo = " + vo);

        if (((MoshtarakModel) vo).getMoshtarakYaNa().intValue() == 2) {
            ctx.getRequest().setAttribute(FORM, ctx.getForm());
            return ctx.getActionMapping().findForward("gheirMoshtarakCreate");
        }

        if (!isNullTavalod)
            ctx.getForm().set("tarikhTavalod", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhTavalod()));
        else
            ctx.getForm().set("tarikhTavalod", "");

        if (!isNullShoroEshterak)
            ctx.getForm().set("tarikhShoro", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhShoro()));
        else
            ctx.getForm().set("tarikhShoro", "");

        if (!isNullAkharinTamdid)
            ctx.getForm().set("tarikhAkharinTamdid", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhAkharinTamdid()));
        else
            ctx.getForm().set("tarikhAkharinTamdid", "");

        if (!isNullEnghezaEshterak)
            ctx.getForm().set("tarikhEngheza", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhEngheza()));
        else
            ctx.getForm().set("tarikhEngheza", "");

        if (!isNullEnghezaGuarantee)
            ctx.getForm().set("tarikhEnghezaGuarantee", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhEnghezaGuarantee()));
        else
            ctx.getForm().set("tarikhEnghezaGuarantee", "");

        if (!isNullServiceAvalieh)
            ctx.getForm().set("tarikhServiceAvalieh", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhServiceAvalieh()));
        else
            ctx.getForm().set("tarikhServiceAvalieh", "");

        if (!isNullTahvil)
            ctx.getForm().set("tarikhTahvil", HejriUtil.chrisToHejri(((MoshtarakModel) (vo)).getTarikhTahvil()));
        else
            ctx.getForm().set("tarikhTahvil", "");

        String action = ctx.getRequest().getParameter("isList");
        if(action !=null )
            ctx.getRequest().setAttribute("isList", action);

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try{
                MoshtarakModel vo = new MoshtarakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhTavalod")) != null && ((String) (ctx.getForm().get("tarikhTavalod"))).length() != 0)
                    vo.setTarikhTavalod(HejriUtil.toDate((String) (ctx.getForm().get("tarikhTavalod"))));

                if ((String) (ctx.getForm().get("tarikhShoro")) != null && ((String) (ctx.getForm().get("tarikhShoro"))).length() != 0)
                    vo.setTarikhShoro(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhShoro")))));

                if ((String) (ctx.getForm().get("tarikhAkharinTamdid")) != null && ((String) (ctx.getForm().get("tarikhAkharinTamdid"))).length() != 0)
                    vo.setTarikhAkharinTamdid(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhAkharinTamdid")))));

                if ((String) (ctx.getForm().get("tarikhEngheza")) != null && ((String) (ctx.getForm().get("tarikhEngheza"))).length() != 0)
                    vo.setTarikhEngheza(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhEngheza")))));

                if ((String) (ctx.getForm().get("tarikhEnghezaGuarantee")) != null && ((String) (ctx.getForm().get("tarikhEnghezaGuarantee"))).length() != 0)
                    vo.setTarikhEnghezaGuarantee(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhEnghezaGuarantee")))));

                if ((String) (ctx.getForm().get("tarikhServiceAvalieh")) != null && ((String) (ctx.getForm().get("tarikhServiceAvalieh"))).length() != 0)
                    vo.setTarikhServiceAvalieh(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhServiceAvalieh")))));

                if ((String) (ctx.getForm().get("tarikhTahvil")) != null && ((String) (ctx.getForm().get("tarikhTahvil"))).length() != 0)
                    vo.setTarikhTahvil(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhTahvil")))));

                ((MoshtarakProxy) getProxy()).update(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("rangeKhodroId").toString(), ctx.getForm().get("bazaryabId").toString());
            } catch (ProxyException e) {
                    e.printStackTrace();
                    throw new ProxyException(e);
            }
        }
        String action = ctx.getRequest().getParameter("isList");
        log.info("moshtarak doUpdate: "+action);
        if(action.equals("close"))
            return ctx.getActionMapping().findForward("close");
        else
            return listAll(ctx);
    }

    //	protected String getForceFilter(BaseActionContext ctx) {
    //        return ctx.getUserSession().getForceFilter(ctx.getEntity());
    //	}

    protected String doFilterPostProcessor(BaseActionContext ctx , String filter) {
        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(filter))
            return com.objectj.emdad.ejb.util.Util.replaceAll(filter, "shomarePelak2" , "shomarePelak");
        return filter;
    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        log.info("moshtarak Specific: "+ctx.getSubAction());
        if (ctx.getSubAction().equals("reqPeygiri")) {
            ctx.getForm().set(ACTION_TYPE, "specific,validreq");
            return ctx.getActionMapping().findForward("reqPeygiri");
        }
        else if (ctx.getSubAction().equals("validreq")){
            if (!isCancelled(ctx.getRequest()))
                return doCheckRequest(ctx);
            else
                return ctx.getActionMapping().findForward("defaultHome");
        }
        else if (ctx.getSubAction().equals("edit_by_eshterak_id")) {
            ctx.getForm().set("id", Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", (String) ctx.getForm().get(ValueObject.ID), "moshtarak", "eshterakId"));
            ctx.getRequest().setAttribute("isList", "close");
            return doEditById(ctx);
        }

        if (ctx.getSubAction().equals("goHome")) {
            return ctx.getActionMapping().findForward("defaultHome");
        }

        if (ctx.getRequest().getRequestURI().toLowerCase().indexOf("/moshtari.run") > 0)
            return null;

        if (ctx.getSubAction().equals("requpload")) {
            return ctx.getActionMapping().findForward("requpload");
        } else if (ctx.getSubAction().equals("uploaded")) {
            return ctx.getActionMapping().findForward("uploaded");
        } else if (ctx.getSubAction().equals("doimport")) {
            //return doImport((String) ctx.getForm().get(ValueObject.ID), (Integer) ctx.getForm().get("noeService"));
            return doImport4(ctx, (String) ctx.getForm().get(ValueObject.ID));
        } else if (ctx.getSubAction().equals("importaid")) {
            return doImport3(ctx);
        } else if (ctx.getSubAction().equals("engheza")) {
            ctx.getUserSession().clearAllFilters(ctx.getEntity());
            java.util.Date now = new java.util.Date();
            ctx.setForceFilter("moshtarak.moshtarakYaNa = 'I1' AND moshtarak.tarikhEngheza <= 'D" + HejriUtil.chrisToHejri(com.objectj.emdad.ejb.util.HejriUtil.incMonth(now, 1)) +
                    "' AND moshtarak.tarikhEngheza >= 'D" + HejriUtil.chrisToHejri(com.objectj.emdad.ejb.util.HejriUtil.incMonth(now, -1)) + "' ");
            ctx.setForceForwardTo("expired");
            ctx.getUserSession().setSpecific(ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity());
        } else if (ctx.getSubAction().equals("clear")) {
            ctx.getUserSession().clearSpecific(ctx.getEntity());
            return doAdvancedFilter(ctx);
        } else if (ctx.getSubAction().equals("gheirMoshtarak")) {
            ctx.getUserSession().clearAllFilters(ctx.getEntity());
            ctx.setForceFilter("moshtarakList.moshtarakYaNa = 'I2'");
            ctx.setForceForwardTo("gheirMoshtarakList");
            ctx.getUserSession().setSpecific(ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity());
        } else if (ctx.getSubAction().equals("moshtarak")) {
            ctx.getUserSession().clearAllFilters(ctx.getEntity());
            ctx.setForceFilter("moshtarakList.moshtarakYaNa = 'I1'");
            ctx.setForceForwardTo("list");
            ctx.getUserSession().setSpecific(ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity());
        } else if (ctx.getSubAction().equals("gheirMoshtarakCreate")) {
            //ctx.getForm().set(ACTION_TYPE, "creategh");
            ctx.getForm().set(ACTION_TYPE, "specific,taeedghCreate");
            ctx.setForceForwardTo("gheirMoshtarakConfirm");
            ctx.getUserSession().setSpecific("", ctx.getForceForwardTo(), ctx.getEntity());
            return ctx.getActionMapping().findForward("gheirMoshtarakCreate");
        } else if (ctx.getSubAction().equals("taeedghCreate")) {
            MoshtarakForm form = (MoshtarakForm) ctx.getForm();
            ActionErrors aerr = form.validate(ctx.getActionMapping(), ctx.getRequest());
            ctx.getForm().set("majaziYaNa", new Integer(1));
            if (!aerr.isEmpty()) {
                ctx.getRequest().setAttribute(DISPLAY_MESSAGE, aerr);
                return ctx.getActionMapping().findForward("gheirMoshtarakCreate");
            }
            return doCreate(ctx);						//ctx.setForceForwardTo("gheirMoshtarakConfirm");
            //ctx.getUserSession().setSpecific("", ctx.getForceForwardTo(), ctx.getEntity());
            //return ctx.getActionMapping().findForward("gheirMoshtarakConfirm");
        } else if (ctx.getSubAction().equals("find")) {
            ctx.getUserSession().clearAllFilters(ctx.getEntity());
            ctx.setForceForwardTo("find");
            ctx.setForceFilter("");
            ctx.getUserSession().setSpecific("", "find", ctx.getEntity());

            ctx.getRequest().setAttribute(VALUE_OBJECT, newValueObject());

            com.objectj.jsa.web.action.PageInfo pageInfo = new com.objectj.jsa.web.action.PageInfo(ctx.getForm());
            EntityList curRecords = new EntityList(getSortableColumns(),
                    pageInfo.getCurPage(), pageInfo.getOrder(), pageInfo.getSortType());
            ctx.getRequest().setAttribute(CUR_RECORDS, curRecords);

            ArrayList emptyArrayList = new ArrayList();
//            log.info("========== emptyArrayList.size() = " + emptyArrayList.size());
            ctx.getRequest().setAttribute(VALUE_OBJECT_LIST, emptyArrayList);

//log.info(ctx.getUserSession().getDestinationForward(ctx.getEntity()));
            return ctx.getActionMapping().findForward("find");
        } else if (ctx.getSubAction().equals("filter")) {
            return doFilter(ctx);
        } else if (ctx.getSubAction().equals("moshtarakShow")) {
            //boolean found = true;
            ctx.getForm().set(ValueObject.ID, Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", (String) ctx.getForm().get(ValueObject.ID), "moshtarak", "eshterakId"));
            if (((String) ctx.getForm().get(ValueObject.ID)) == null)
                return ctx.getActionMapping().findForward("showNotFound");

            doReadById(ctx);
            MoshtarakModel mm = (MoshtarakModel) ctx.getRequest().getAttribute(VALUE_OBJECT);
            if (mm.getMajaziYaNa().intValue() != 1)
                return ctx.getActionMapping().findForward("moshtarakShow");
            return ctx.getActionMapping().findForward("gheirMoshtarakShow");

        } else if (ctx.getSubAction().equals("savabegh")) {
//													log.info("~~~~~~~~~~~~~~~~~~~~~~~~~ oomad too savabegh ~~~~~~~~~~~~~~~~~~~~~~~~");
            String id = (String) ctx.getForm().get(ValueObject.ID);

            try {
//                log.info("000 id="+id);
                id = id.trim();
                id = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", id, "moshtarak", "eshterakId");
                if (com.objectj.emdad.ejb.util.Util.isEmpty(id))
                    id = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", (String) ctx.getForm().get(ValueObject.ID), "moshtarak", "shomareShasi");
//                                                        log.info("111 id="+id);
                if (id != null && id.length() != 0 && !id.equals(Constants.getMoshtari_Unknown())) {
                    QueryObject qo = new QueryObject("view_savabegh", "", "", false);
                    qo.setWhere("moshtarakId = '" + id + "'");

                    Savabegh sv = new Savabegh();
                    ArrayList al = Exchanger.exhangeResultSetToValueObjectArray(ctx.getConnection(), qo, null, sv, false).getResult();
                    for (int i = 0; i < al.size(); i++) {
                        sv = (Savabegh) al.get(i);
                        if (sv.getZamanEzam() == null)
                            sv.setZamanEzamHejri("");
                        else
                            sv.setZamanEzamHejri(HejriUtil.getTimeFromDate(sv.getZamanEzam()) + " - " + HejriUtil.chrisToHejri(sv.getZamanEzam()));
                        if (sv.getZamanPayan() == null)
                            sv.setZamanPayanHejri("");
                        else
                            sv.setZamanPayanHejri(HejriUtil.getTimeFromDate(sv.getZamanPayan()) + " - " + HejriUtil.chrisToHejri(sv.getZamanPayan()));
                        if (sv.getZamanShoro() == null)
                            sv.setZamanShoroHejri("");
                        else
                            sv.setZamanShoroHejri(HejriUtil.getTimeFromDate(sv.getZamanShoro()) + " - " + HejriUtil.chrisToHejri(sv.getZamanShoro()));
                        if (sv.getZamanTamas() == null)
                            sv.setZamanTamasHejri("");
                        else
                            sv.setZamanTamasHejri(HejriUtil.getTimeFromDate(sv.getZamanTamas()) + " - " + HejriUtil.chrisToHejri(sv.getZamanTamas()));
                    }
                    ctx.getRequest().setAttribute("savabegh", al);
                    return ctx.getActionMapping().findForward("savabegh");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return ctx.getActionMapping().findForward("showNotFound");
        } else if (ctx.getSubAction().equals("updatePelak")) {
            String id1 = ctx.getRequest().getParameter("eshterakId");
            id1 = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", id1, "moshtarak", "eshterakId");
//            ctx.getForm().set(ValueObject.ID , Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", (String) ctx.getForm().get(ValueObject.ID), "moshtarak", "eshterakId"));
//            if ( ((String) ctx.getForm().get(ValueObject.ID))==null )
            if (id1 == null)
                return ctx.getActionMapping().findForward("showNotFound");

/*            MoshtarakList mm = (MoshtarakList) MoshtarakSessionUtil.getLocalHome().create().read(id1);
            MoshtarakModel moshtarakModel = new MoshtarakModel(mm);
            log.info("MoshtarakModel="+moshtarakModel);
            moshtarakModel.setId(id1);*/

            String pelak1 = ctx.getRequest().getParameter("shomarePelak");
            String pelak2 = ctx.getRequest().getParameter("shomarePelak2");
            String pelak = pelak1 + " " + pelak2;
            System.out.println( "ShomarePelak Jadid: " + pelak );
            QueryObject qo = new QueryObject();
            qo.setFromIndex(0);
            qo.setToIndex(2);
            qo.setTables("moshtarak");
            qo.setJoined(false);
            qo.setSelectFields("id,eshterakId");
//                ResultSet rs = null;

//qo.setWhere("shomarePelak='" + vo.getShomarePelak().trim() + "'");
            qo.emptyElements();
            qo.setWhere("shomarePelak = ? ");
            qo.addElement(new QueryElement("String", pelak));
            ArrayList al = Util.advanceRead(qo);
//                if (Util.hasReplicate(al, vo.getId()))
//                    errors.add("soId", new ActionError("errors.shomarePelak.already.exists" , ((ArrayList)al.get(0)).get(0)));
//                rs = MoshtarakUtil.getLocalHome().advanceRead(ctx.getConnection(), qo);
            ActionErrors errors = new ActionErrors();
            if (!al.isEmpty()) {
                errors.add("soId", new ActionError("errors.shomarePelak.already.exists", ((ArrayList) al.get(0)).get(0)));
                System.out.println( "errors.shomarePelak.already.exists" );
			}

            MoshtarakModel moshtarakModel = new MoshtarakModel();
            qo = new QueryObject("moshtarak", "", "", false);
            qo.setWhere("id = '" + id1 + "'");
            Exchanger.exhangeResultSetToValueObject(ctx.getConnection(), qo, new ValueObject[]{moshtarakModel});
//                log.info("moshtarakModel 000="+moshtarakModel);
            /*if (com.objectj.emdad.ejb.util.Util.isNotEmpty(moshtarakModel.getShomarePelak())) {
                errors.add("soId", new ActionError("errors.shomarePelak.hasBeenSet.before", moshtarakModel.getEshterakId()));
                System.out.println( "errors.shomarePelak.hasBeenSet.before" );
            }*/
            if (errors.isEmpty()) {
                moshtarakModel.setShomarePelak(pelak);//9909000001
//                log.info("moshtarakModel 111="+moshtarakModel);
//                (MoshtarakSessionUtil.getLocalHome().create()).update(moshtarakModel, moshtarakLocal.getShahr().getId(), moshtarakLocal.getNoeKhodro().getId(), moshtarakLocal.getRangeKhodro().getId(), moshtarakLocal.getBazaryab().getId());
                MoshtarakSessionUtil.getLocalHome().create().update(moshtarakModel); //, voRokhdad.getMoshtarakId(), voRokhdad.getNamayandegiId(), voRokhdad.getDaftarOstaniId(), voRokhdad.getShahrId());
                System.out.println( " finished Updating shomarePalak " );
                return ctx.getActionMapping().findForward("refresh");
            }
//                (getProxy()).update(moshtarakModel);
				return ctx.getActionMapping().findForward( "showNotFound" );

        } else if (ctx.getSubAction().equals("batel")) {
            String id1 = ctx.getRequest().getParameter("eshterakId");
            id1 = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MoshtarakModel", id1, "moshtarak", "eshterakId");
            if (id1 == null)
                return ctx.getActionMapping().findForward("showNotFound");
            MoshtarakModel moshtarakModel = new MoshtarakModel();
            QueryObject qo = new QueryObject("moshtarak", "", "", false);
            qo.setWhere("id = '" + id1 + "'");
            Exchanger.exhangeResultSetToValueObject(ctx.getConnection(), qo, new ValueObject[]{moshtarakModel});
            moshtarakModel.setMoshtarakYaNa(new Integer(2));
            moshtarakModel.setTarikhEngheza(HejriUtil.getCurrentDate());
            moshtarakModel.setVazeat(new Integer(2));
            MoshtarakSessionUtil.getLocalHome().create().update(moshtarakModel); //, voRokhdad.getMoshtarakId(), voRokhdad.getNamayandegiId(), voRokhdad.getDaftarOstaniId(), voRokhdad.getShahrId());
            return ctx.getActionMapping().findForward("refresh");
        }


        return listAll(ctx);
    }

    /**
     *
     * 	doImport methods are used to import moshtarak infromation from older Databases
     * 	to this system. There are several import functions for moshtarak each of them
     * 	are created due to a specific older DB formats as bellow:
     *
     * 	doImport() 	:  To import data from IranKhodro DBF ( old format )
     *  doImport2() :  To import data from IranKhodro DBF ( old format )
     *  doImport3() :  To import data from 'aid' DB, 'subscription' table , ( SQL Server)
     * 	doImport4()	:  To import data from IranKhodro DBF ( current format )
     *
     */

    protected ActionForward doImport(BaseActionContext ctx, String fileName, Integer noeService) throws ProxyException {
        log.info(" IMPORT : file name = " + fileName + "   noeService = " + noeService);
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;

        if (!isCancelled(ctx.getRequest())) {
            try {
                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF(fileName);

                while (resultSet.next()) {
                    recordCount++;
                    boolean isUpdate = false;
                    //					MoshtarakModel moshtarakModel = new MoshtarakModel();

                    //ResultSetMetaData resultsMetaData = resultSet.getMetaData();
                    //columnCount = resultsMetaData.getColumnCount();

                    // chech if this enity already exsists
                    String em_body = resultSet.getString("EM_BODY");
                    if (em_body != null) {
                        em_body.trim();
                    }
                    QueryObject moshtarakQuery = new QueryObject();
                    moshtarakQuery.setTables("moshtarak");
                    moshtarakQuery.setWhere("shomareShasi = '" + em_body + "'");
                    moshtarakQuery.setJoined(false);
                    if (!(MoshtarakSessionUtil.getLocalHome().create().readList(moshtarakQuery).getResult()).isEmpty()) {
                        if (!(Integer.valueOf(resultSet.getString("EM_DEL").trim())).equals(new Integer(4))) {
                            //errorList.add(new String("Moshtarak on row " + resultSet.getRow() + " already exist and can't be updated."));
                            unchangeCount++;
                            continue;
                        } else {
                            isUpdate = true;
                        }
                    }

                    ///////////////////////////////////////////////////
                    // getting requeird data by query on other entities

                    QueryObject shahrQuery = new QueryObject();
                    shahrQuery.setTables("shahr");
                    shahrQuery.setWhere("LTRIM(RTRIM(shahrName)) = ?");
                    shahrQuery.addElement(new QueryElement("String", iranSysDecoder.decode(resultSet.getBytes("EM_SHAHR"))));
                    shahrQuery.setJoined(false);
                    ArrayList shahrArray = (ShahrSessionUtil.getLocalHome().create().readModel(shahrQuery).getResult());
                    ShahrModel shahrModel = new ShahrModel();
                    if (!shahrArray.isEmpty()) {
                        shahrModel = (ShahrModel) shahrArray.get(0);
                    } else {
                        errorList.add(new String("Refrenced shahr on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    QueryObject noeKhodroQuery = new QueryObject();
                    noeKhodroQuery.setTables("noeKhodro");
                    //noeKhodroQuery.setWhere("khodroCode = '" + (resultSet.getString("Carcod")) + "'");
                    noeKhodroQuery.setWhere("khodroCode = ?");
                    noeKhodroQuery.addElement(new QueryElement("String", resultSet.getString("EM_CARCOD")));
                    noeKhodroQuery.setJoined(false);
                    ArrayList noeKhodroArray = NoeKhodroSessionUtil.getLocalHome().create().readModel(noeKhodroQuery).getResult();
                    NoeKhodroModel noeKhodroModel = null; // = new NoeKhodroList();
                    if (!noeKhodroArray.isEmpty()) {
                        noeKhodroModel = (NoeKhodroModel) noeKhodroArray.get(0);
                    } else {
                        errorList.add(new String("Refrenced NoeKhodro on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    QueryObject rangeKhodroQuery = new QueryObject();
                    rangeKhodroQuery.setTables("rangeKhodro");
                    //rangeKhodroQuery.setWhere("codeRangeKhodrosaz = '" + (resultSet.getString("Rangcod")) + "'");
                    rangeKhodroQuery.setWhere("codeRangeKhodrosaz = ?");
                    rangeKhodroQuery.addElement(new QueryElement("String", resultSet.getString("EM_COLOR")));
                    rangeKhodroQuery.setJoined(false);
                    ArrayList rangeKhodroArray = RangeKhodroSessionUtil.getLocalHome().create().readModel(rangeKhodroQuery).getResult();
                    RangeKhodroModel rangeKhodroModel = new RangeKhodroModel();
                    if (!rangeKhodroArray.isEmpty()) {
                        rangeKhodroModel = (RangeKhodroModel) rangeKhodroArray.get(0);
                    } else {
                        errorList.add(new String("Refrenced NoeKhodro on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    ///////////////////////////
                    // Setting valueObject starts here
                    MoshtarakModel moshtarak = new MoshtarakModel();

                    byte[] em_adres = resultSet.getBytes("EM_ADRES");
                    if (em_adres != null) {
                        String em_adres_uni = iranSysDecoder.decode(em_adres);
                        moshtarak.setAddress((em_adres_uni.substring(0, em_adres_uni.length() < 80 ? em_adres_uni.length() : 80))); //nchar
                    }
                    //	moshtarak.setBazaryabId( ""); //char
                    //	moshtarak.setEmail( resultSet.getString().trim()); //nchar
                    //	moshtarak.setEshterakId( resultSet.getString().trim()); //nchar
                    moshtarak.setGuarantee((new Integer(1))); //int
                    moshtarak.setId(""); //char
                    //	moshtarak.setMahaleServiceAvalieh( (iranSysDecoder.decode(resultSet.getBytes()))); //nchar
                    //  moshtarak.setMobile( ""); //nchar
                    byte[] em_nam = resultSet.getBytes("EM_NAM");
                    if (em_nam != null) {
                        String em_nam_uni = iranSysDecoder.decode(em_nam);
                        moshtarak.setName(em_nam_uni.substring(0, em_nam_uni.length() < 20 ? em_nam_uni.length() : 20));
                        //nchar
                    } else {
                        moshtarak.setName("-");
                    }
                    byte[] em_fam = resultSet.getBytes("EM_FAM");
                    if (em_fam != null) {
                        String em_fam_uni = iranSysDecoder.decode(em_fam);
                        moshtarak.setNameKhanevadegi(em_fam_uni.substring(0, em_fam_uni.length() < 20 ? em_fam_uni.length() : 20));
                        //nchar
                    } else {
                        moshtarak.setNameKhanevadegi("-");
                    }

                    moshtarak.setNoeEshterak((new Integer(4))); //int
                    //	moshtarak.setNoeKhodroId( noeKhodroList.getId()); //char
                    moshtarak.setNoeService(noeService); //int
                    //	moshtarak.setPostCode( resultSet.getString().trim()); //nchar
                    //	moshtarak.setRangeKhodroId( rangeKhodroList.getId()); //char
                    if (em_body != null) {
                        moshtarak.setSaleSakht((Integer.valueOf("13" + em_body.substring(2, 4).trim()))); //int // 2nd 2digit of "EM_BODY"
                        moshtarak.setShomareShasi(em_body.trim()); //nchar
                        moshtarak.setEshterakId(em_body.trim()); //nchar

                    }
                    //	moshtarak.setShahrId( shahrList.getId()); //char
                    String em_motor = resultSet.getString("EM_MOTOR");
                    if (em_motor != null) {
                        moshtarak.setShomareMotor(em_motor.trim());
                    } //char
                    //	moshtarak.setShomarePelak( resultSet.getString(4).trim()); //nchar

                    //	moshtarak.setShomareVIN( resultSet.getString().trim()); //nchar
                    String em_date = resultSet.getString("EM_DATE");
                    if (em_date != null) {

                        // 	moshtarakm.se"tarikhAkharinEmail( (resultSet.getString().trim())); //datetime
                        //  moshtarak.setTarikhAkharinTamdid( (resultSet.getString().trim())); //datetime

                        moshtarak.setTarikhEngheza(HejriUtil.incYear(HejriUtil.hejriToChris(resultSet.getString("EM_DATE").trim()))); //datetime
                        if (noeKhodroModel != null) {
                            moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(resultSet.getString("EM_DATE").trim()), noeKhodroModel.getGuarantee().intValue()));
                        } //datetime
                        else {
                            moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(resultSet.getString("EM_DATE").trim()), 12));
                        } //datetime
                        //	moshtarak.setTarikhServiceAvalieh( (resultSet.getString().trim())); //datetime

                        moshtarak.setTarikhShoro(HejriUtil.hejriToChris(em_date.trim())); //datetime
                        moshtarak.setTarikhTahvil(HejriUtil.hejriToChris(em_date.trim())); //datetime
                    }
                    String em_bdate = resultSet.getString("EM_BDATE");
                    if (em_bdate != null) {
                        moshtarak.setTarikhTavalod(HejriUtil.hejriToChris(em_bdate.trim()));
                    } //datetime
                    byte[] em_tel = resultSet.getBytes("EM_TEL");
                    if (em_tel != null) {
                        moshtarak.setTel((iranSysDecoder.decode(em_tel)));
                    } //nchar
                    moshtarak.setVazeat((new Integer(1))); //int
                    moshtarak.setMoshtarakYaNa(new Integer(1));

                    // End of setting ctx.getForm()
                    ///////////////////////

                    //	MoshtarakForm moshtarakForm = (MoshtarakForm)ctx.getForm();
                    ActionErrors actionErrors = new ActionErrors();
                    //ActionErrors actionErrors = moshtarakForm.validate(actionMapping, ctx.getRequest());
                    Validators.moshtarakValidator(ctx.getConnection(), moshtarak, actionErrors);

                    if (actionErrors.isEmpty()) {
                        if (isUpdate) {
                            try {
                                doUpdate(ctx);
                                updateCount++;
                            } catch (Exception e) {
                                errorList.add("Error Updating Entity.");
                                errorCount++;
                            }
                        } else {
                            try {
                                //((MoshtarakProxy)getProxy()).create(moshtarak, shahrList.getId(), noeKhodroList.getId(), rangeKhodroList.getId(), (String) (ctx.getForm().get("bazaryabId")));
                                ((MoshtarakProxy) getProxy()).create(moshtarak, shahrModel.getId(), noeKhodroModel.getId(), rangeKhodroModel.getId(), "818080808080808180o");
                                createCount++;
                            } catch (Exception e) {
                                errorList.add("Error Creating Entity due to refrential integrity failure.");
                                errorCount++;
                            }
                        }
                    } else {
                        Iterator iter = actionErrors.get();
                        String errorTmp = new String();
                        while (iter.hasNext()) {
                            ActionError actionError = (ActionError) iter.next();
                            String ts = Util.getProperty(actionError.getKey());
                            if (ts != null)
                                errorTmp += ts;
                            else
                                errorTmp += actionError.getKey();
                            errorTmp += ", ";
                            //errorTmp += "\n";
                        }
                        errorList.add(errorTmp);
                        errorCount++;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }

        errorList.add(0, new String("Error Count: " + errorCount));
        errorList.add(0, new String("Unchange Count: " + unchangeCount));
        errorList.add(0, new String("Update Count: " + updateCount));
        errorList.add(0, new String("Create Count: " + createCount));
        errorList.add(0, new String("Total record Count: " + recordCount));

        ctx.getRequest().setAttribute("errorList", errorList);
//		log.info("========== iiiiiinnnnnneeeeehhhhhh...................");
        return ctx.getActionMapping().findForward("importinfo");
    }

    protected ActionForward doImport2(BaseActionContext ctx, String fileName, Integer noeService) throws ProxyException {
        log.info(" IMPORT : file name = " + fileName + "   noeService = " + noeService);
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;

        if (!isCancelled(ctx.getRequest())) {
            try {
                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF(fileName);

                while (resultSet.next()) {
                    recordCount++;
                    boolean isUpdate = false;
                    //					MoshtarakModel moshtarakModel = new MoshtarakModel();

                    // chech if this enity already exsists
                    String body = resultSet.getString("Body");
                    if (body != null) {
                        body.trim();
                    }
                    QueryObject moshtarakQuery = new QueryObject();
                    moshtarakQuery.setTables("moshtarak");
                    moshtarakQuery.setWhere("shomareShasi = '" + body + "'");
                    moshtarakQuery.setJoined(false);
                    if (!(MoshtarakSessionUtil.getLocalHome().create().readList(moshtarakQuery).getResult()).isEmpty()) {
                        unchangeCount++;
                        continue;
                    }

                    ///////////////////////////////////////////////////
                    // getting requeird data by query on other entities

                    QueryObject shahrQuery = new QueryObject();
                    shahrQuery.setTables("shahr");
                    //shahrQuery.setWhere("LTRIM(RTRIM(shahrName)) = '" + (iranSysDecoder.decode(resultSet.getBytes("Shahr"))) + "'");
                    shahrQuery.setWhere("LTRIM(RTRIM(shahrName)) = ?");
                    shahrQuery.addElement(new QueryElement("String", iranSysDecoder.decode(resultSet.getBytes("Shahr"))));
                    shahrQuery.setJoined(false);
                    ArrayList shahrArray = (ShahrSessionUtil.getLocalHome().create().readModel(shahrQuery).getResult());
                    ShahrModel shahrModel = new ShahrModel();
                    if (!shahrArray.isEmpty()) {
                        shahrModel = (ShahrModel) shahrArray.get(0);
                        //ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrList.getId());
                    } else {
                        errorList.add(new String("Refrenced shahr on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    QueryObject noeKhodroQuery = new QueryObject();
                    noeKhodroQuery.setTables("noeKhodro");
                    //noeKhodroQuery.setWhere("khodroCode = '" + (resultSet.getString("Carcod")) + "'");
                    noeKhodroQuery.setWhere("khodroCode = ?");
                    noeKhodroQuery.addElement(new QueryElement("String", resultSet.getString("Carcod")));
                    noeKhodroQuery.setJoined(false);
                    ArrayList noeKhodroArray = NoeKhodroSessionUtil.getLocalHome().create().readModel(noeKhodroQuery).getResult();
                    NoeKhodroModel noeKhodroModel = null; // = new NoeKhodroList();
                    if (!noeKhodroArray.isEmpty()) {
                        noeKhodroModel = (NoeKhodroModel) noeKhodroArray.get(0);
                    } else {
                        errorList.add(new String("Refrenced NoeKhodro on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    QueryObject rangeKhodroQuery = new QueryObject();
                    rangeKhodroQuery.setTables("rangeKhodro");
                    //rangeKhodroQuery.setWhere("codeRangeKhodrosaz = '" + (resultSet.getString("Rangcod")) + "'");
                    rangeKhodroQuery.setWhere("codeRangeKhodrosaz = ?");
                    rangeKhodroQuery.addElement(new QueryElement("String", resultSet.getString("Rangcod")));
                    rangeKhodroQuery.setJoined(false);
                    ArrayList rangeKhodroArray = RangeKhodroSessionUtil.getLocalHome().create().readModel(rangeKhodroQuery).getResult();
                    RangeKhodroModel rangeKhodroModel = new RangeKhodroModel();
                    if (!rangeKhodroArray.isEmpty()) {
                        rangeKhodroModel = (RangeKhodroModel) rangeKhodroArray.get(0);
                    } else {
                        errorList.add(new String("Refrenced NoeKhodro on row " + resultSet.getRow() + " does not exist"));
                        continue;
                    }

                    /////////////////////////////////
                    // Setting valueObject starts here

                    MoshtarakModel moshtarak = new MoshtarakModel();

                    moshtarak.setGuarantee((new Integer(1)));
                    moshtarak.setId("");
                    moshtarak.setNoeEshterak((new Integer(4)));
                    moshtarak.setNoeService(noeService);
                    moshtarak.setVazeat((new Integer(1)));
                    moshtarak.setMoshtarakYaNa(new Integer(1));

                    byte[] em_nam = resultSet.getBytes("Nam");
                    if (em_nam != null) {
                        String em_nam_uni = iranSysDecoder.decode(em_nam);
                        moshtarak.setName(em_nam_uni.substring(0, em_nam_uni.length() < 20 ? em_nam_uni.length() : 20));
                    } else {
                        moshtarak.setName("-");
                    }
                    byte[] em_fam = resultSet.getBytes("Fam");
                    if (em_fam != null) {
                        String em_fam_uni = iranSysDecoder.decode(em_fam);
                        moshtarak.setNameKhanevadegi(em_fam_uni.substring(0, em_fam_uni.length() < 20 ? em_fam_uni.length() : 20));
                    } else {
                        moshtarak.setNameKhanevadegi("-");
                    }

                    byte[] em_adres = resultSet.getBytes("Adr");
                    if (em_adres != null) {
                        String em_adres_uni = iranSysDecoder.decode(em_adres);
                        moshtarak.setAddress((em_adres_uni.substring(0, em_adres_uni.length() < 80 ? em_adres_uni.length() : 80))); //nchar
                    }

                    if (body != null) {
                        moshtarak.setSaleSakht((Integer.valueOf("13" + body.substring(2, 4).trim())));
                        moshtarak.setShomareShasi(body.trim());
                        moshtarak.setEshterakId(body.trim());
                    }

                    String em_motor = resultSet.getString("Mot");
                    if (em_motor != null) {
                        moshtarak.setShomareMotor(em_motor.trim());
                    }

                    String date = resultSet.getString("Date");
                    if (date != null) {
                        moshtarak.setTarikhEngheza(HejriUtil.incYear(HejriUtil.hejriToChris(resultSet.getString("Date").trim())));
                        if (noeKhodroModel != null) {
                            moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(resultSet.getString("Date").trim()), noeKhodroModel.getGuarantee().intValue()));
                        } else {
                            moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(resultSet.getString("Date").trim()), 12));
                        }
                        moshtarak.setTarikhShoro(HejriUtil.hejriToChris(date.trim()));
                        moshtarak.setTarikhTahvil(HejriUtil.hejriToChris(date.trim()));
                    }

                    byte[] em_tel = resultSet.getBytes("Tel");
                    if (em_tel != null) {
                        byte[] em_telcod = resultSet.getBytes("Codtel");
                        if (em_telcod != null) {
                            moshtarak.setTel(iranSysDecoder.decode(em_telcod) + " " + iranSysDecoder.decode(em_tel));
                        } else {
                            moshtarak.setTel((iranSysDecoder.decode(em_tel)));
                        }
                    }

                    // End of setting moshtarak valueObject
                    ///////////////////////

                    ActionErrors actionErrors = new ActionErrors();
                    Validators.moshtarakValidator(ctx.getConnection(), moshtarak, actionErrors);

                    if (actionErrors.isEmpty()) {
                        if (isUpdate) {
                            try {
                                doUpdate(ctx);
                                updateCount++;
                            } catch (Exception e) {
                                errorList.add("Error Updating Entity.");
                                errorCount++;
                            }
                        } else {
                            try {
                                ((MoshtarakProxy) getProxy()).create(moshtarak, shahrModel.getId(), noeKhodroModel.getId(), rangeKhodroModel.getId(), "818080808080808180o");
                                //((MoshtarakProxy) getProxy()).create(moshtarak, "808080808080808480 ", noeKhodroList.getId(), "AD8080808080808780o", "818080808080808180o");
                                createCount++;
                            } catch (Exception e) {
                                errorList.add("Error Creating Entity due to refrential integrity failure.");
                                errorCount++;
                            }
                        }
                    } else {
                        Iterator iter = actionErrors.get();
                        String errorTmp = new String();
                        while (iter.hasNext()) {
                            ActionError actionError = (ActionError) iter.next();
                            String ts = Util.getProperty(actionError.getKey());
                            if (ts != null)
                                errorTmp += ts;
                            else
                                errorTmp += actionError.getKey();
                            errorTmp += ", ";
                            //errorTmp += "\n";
                        }
                        errorList.add(errorTmp);
                        errorCount++;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }

        errorList.add(0, new String("Error Count: " + errorCount));
        errorList.add(0, new String("Unchange Count: " + unchangeCount));
        errorList.add(0, new String("Update Count: " + updateCount));
        errorList.add(0, new String("Create Count: " + createCount));
        errorList.add(0, new String("Total record Count: " + recordCount));

        ctx.getRequest().setAttribute("errorList", errorList);
        log.info("========== iiiiiinnnnnneeeeehhhhhh...................");
        return ctx.getActionMapping().findForward("importinfo");
    }

    protected ActionForward doImport3(BaseActionContext ctx) throws ProxyException {
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;


        if (!isCancelled(ctx.getRequest())) {
            ResultSet rs2 = null;
            com.objectj.emdad.ejb.util.Util.add("unk_Bazaryab", Constants.getBazaryab_Unknown());
            com.objectj.emdad.ejb.util.Util.add("unk_Shahr", Constants.getShahr_Unknown());

            try {
                ArrayList noeKhodroList = NoeKhodroSessionUtil.getLocalHome().create().readCombo("noeKhodro", "noeKhodroId", "", "noeKhodroId").getResult();
                ArrayList rangList = RangeKhodroSessionUtil.getLocalHome().create().readCombo("rangeKhodro", "rangeKhodroId", "", "rangeKhodroId").getResult();
                ArrayList shahrList = ShahrSessionUtil.getLocalHome().create().readCombo("shahr", "shahrId", "", "shahrId").getResult();

                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Util.getTempraryPath() + "importMoshtarak.log")));

                Class.forName("com.ddtek.jdbc.sqlserver.SQLServerDriver");
                Connection connection = null;
                //Connection connection = DriverManager.getConnection(com.objectj.emdad.web.util.Util.getProperty("application.connection.aid.url"));
                String curl = "jdbc:datadirect:sqlserver://222.192.55.220:1433;DatabaseName=aid;User=sa;Password=anahita";
                connection = DriverManager.getConnection(curl);
                //Connection connection = com.objectj.emdad.ejb.util.Util.getConnection(); // DriverManager.getConnection(com.objectj.emdad.web.util.Util.getProperty("application.connection.aid.url"));

                Statement statement = connection.createStatement();
                String query = "SELECT * FROM view_import_subscriptions";
                if (com.objectj.emdad.ejb.util.Util.isNotEmpty((String) ctx.getForm().get("shomareShasi")))
                    query += " where ChassisNo>='" + (String) ctx.getForm().get("shomareShasi") + "' ";
//                query += " order by ChassisNo";

//                query = "SELECT * FROM view_import_subscriptions where ChassisNo>='0080716200' and ChassisNo<='0080716205'";
//                out = new PrintWriter(new BufferedWriter(new FileWriter(Util.getTempraryPath() + "importMoshtarak2.log")));

                log.info("query=" + query);
                ResultSet resultSet = statement.executeQuery(query);
                log.info("query Done.");

                // another connection to log import Status into AID DB
                Connection connectionStatus = DriverManager.getConnection(curl);
                //Connection connectionStatus = com.objectj.emdad.ejb.util.Util.getConnection();
                Statement statementStatus = connectionStatus.createStatement();
                String bazaryabId = Constants.getBazaryab_Irankhodro();
//                QueryObject noeKhodroQuery = new QueryObject();
//                noeKhodroQuery.setSelectFields("guarantee");
//                noeKhodroQuery.setTables("noeKhodro");
//                noeKhodroQuery.setJoined(false);

                ////////////////////////////////////////////////////////////////
                // query and put result in memory objects to improve performance

                //for (int counter = 0; counter < 100000; counter++) {
                //    resultSet.next();

                while (resultSet.next()) {

                    recordCount++;

                    if (recordCount % 100 == 0)
                        log.info("imported:" + recordCount + ",updateCount:" + updateCount + ",createCount:" + createCount + ",errorCount:" + errorCount);

                    boolean isUpdate = false;

                    String eshterakId = resultSet.getString("subscriptionId");
                    if (eshterakId != null) {
                        eshterakId = eshterakId.trim();
                    }


                    // chech if AID DB has a valid chassisNo
                    String em_body = resultSet.getString("ChassisNo");
                    int row = resultSet.getRow();
                    if (em_body != null) {
                        em_body = em_body.trim();
                    } else {
                        if (eshterakId == null) {
                            out.println("chassisNo and subscriptionId on row  " + row + " is NULL. ");
//                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 5 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                            errorCount++;
                            continue;
                        }
                    }

                    //	chech if this enity already exsists
                    MoshtarakModel moshtarak = null;
                    moshtarak = new MoshtarakModel();
                    moshtarak.setEshterakId(eshterakId);

                    log.info("shasi='" + em_body + "' , eshterakId=" + eshterakId);
                    String id = null;
                    if (em_body != null)
                        id = UserAccessEntity.stringQueryRepl("SELECT id FROM moshtarak WHERE shomareShasi = '" + em_body + "'", "id", ctx.getConnection());
                    else
                        id = UserAccessEntity.stringQueryRepl("SELECT id FROM moshtarak WHERE eshterakId = '" + eshterakId + "'", "id", ctx.getConnection());

                    if (id == null) {
                        out.println("shasi or subscriptionId already exists. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body);
                        errorCount++;
                        statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 10 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                        continue;
                    } else if (id.length() != 0) {
                        continue;
//                            isUpdate = true;
//                            moshtarak.setId(id);
                    }

                    QueryObject moshtarakQuery = new QueryObject();
//                    moshtarakQuery.setSelectFields("id");
                    moshtarakQuery.setTables("moshtarak");
//                    moshtarakQuery.setWhere("shomareShasi = '" + em_body + "'");
                    moshtarakQuery.setJoined(false);

                    ///////////////////////////////////////////////////
                    // getting requeird data by query on other entities

                    String city = resultSet.getString("citySyncId");
                    String shahrId = null;

                    if (city != null && city.length() != 0) {
                        shahrId = Util.getIdFromList(shahrList, city);

                        if (shahrId == null) {
                            out.println("city=" + city + " does not exist. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                            shahrId = Constants.getShahr_Unknown(); // unknown
//                            errorCount++;
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 6 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
//                            continue;
                        }

                    } else {
                        out.println("Refrenced shahr on row " + row + " is not set. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                        shahrId = Constants.getShahr_Unknown(); // unknown
                    }

                    String carKindId = resultSet.getString("syncId");
                    String noeKhodroId = null;

                    if (carKindId != null && carKindId.length() != 0) {
                        noeKhodroId = Util.getIdFromList(noeKhodroList, carKindId); //UserAccessEntity.stringQuery("SELECT id FROM noeKhodro WHERE noeKhodroId = " + carKindId + "", "id", ctx.getConnection());

                        if (noeKhodroId == null) {
                            out.println("carKindId=" + carKindId + " does not exist. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                            errorCount++;
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 7 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                            continue;
                        } else {
//                            noeKhodroQuery.setWhere("id = '"+noeKhodroId+"'");
                            String g = UserAccessEntity.stringQuery("SELECT guarantee FROM noeKhodro WHERE id = '" + noeKhodroId + "'", "guarantee", ctx.getConnection());
                            //rs =  com.objectj.emdad.web.util.Util.advanceRead(ctx, noeKhodroQuery);
                            //rs.next();
                            moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(resultSet.getDate("SubscriptionDate"), Integer.parseInt(g)));
                            //com.objectj.emdad.web.util.Util.closeResources(rs);
                        }

                    } else {
                        out.println("Refrenced NoeKhodro on row " + row + " is not set. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                        noeKhodroId = Constants.getNoekhodro_Unknown();
                        moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(resultSet.getDate("SubscriptionDate"), 12));
                    }

                    String colorId = resultSet.getString("colorSyncID");
                    String rangId = null;

                    if (colorId != null && colorId.length() != 0) {
                        rangId = Util.getIdFromList(rangList, colorId); //UserAccessEntity.stringQuery("SELECT id FROM rangeKhodro WHERE rangeKhodroId = " + colorId + "", "id", ctx.getConnection());

                        if (rangId == null) {
                            out.println("colorId=" + colorId + " does not exist. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
//                            errorCount++;
                            rangId = Constants.getRangekhodro_Unknown(); // unknown
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 8 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
//                            continue;
                        }
                    } else {
                        out.println("Refrenced RangeKhodro on row " + row + " is not set. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                        rangId = Constants.getRangekhodro_Unknown(); // unknown
                    }

                    ///////////////////////////
                    // Setting valueObject starts here

                    moshtarak.setAddress(resultSet.getString("Addr")); //nchar
                    moshtarak.setEmail(resultSet.getString("Email")); //nchar
                    moshtarak.setPostCode(resultSet.getString("PostalCode")); //nchar

                    moshtarak.setSaleSakht(new Integer(resultSet.getInt("ProdYear")));
                    moshtarak.setShomareShasi(em_body); //nchar
                    String carId = resultSet.getString("MotorNo");
                    if (carId != null)
                        carId = carId.trim();
                    moshtarak.setShomarePelak(carId); //nchar

                    String em_nam = resultSet.getString("FirstName");
                    if (em_nam != null) {
                        moshtarak.setName(resultSet.getString("FirstName"));
                    } else {
                        moshtarak.setName("-");
                    }

                    String em_fam = resultSet.getString("LastName");
                    if (em_fam != null) {
                        moshtarak.setNameKhanevadegi(resultSet.getString("LastName"));
                    } else {
                        moshtarak.setNameKhanevadegi("-");
                    }

                    moshtarak.setTarikhShoro(resultSet.getDate("SubscriptionDate"));
                    moshtarak.setTarikhEngheza(resultSet.getDate("ExpireDate")); //datetime
                    moshtarak.setTarikhTavalod(resultSet.getDate("BirthDate"));

                    String em_tel = resultSet.getString("Phone1");
                    String em_telcod = resultSet.getString("TelCode");
                    if (em_telcod != null)
                        em_tel = em_telcod + " " + em_tel;
                    String em_tel2 = resultSet.getString("Phone2");
                    if (em_tel2 != null) {
                        em_tel += " ";
                        em_tel += em_tel2;
                    }
                    moshtarak.setTel(em_tel);

                    if (!isUpdate)
                        moshtarak.setId(""); //char
                    moshtarak.setVazeat((new Integer(1))); //int
                    moshtarak.setNoeEshterak((new Integer(4))); //int

                    if (moshtarak.getTarikhEnghezaGuarantee() != null && moshtarak.getTarikhEnghezaGuarantee().after(moshtarak.getTarikhShoro())) {
                        moshtarak.setGuarantee((new Integer(1)));
                    } else {
                        moshtarak.setGuarantee((new Integer(2)));
                    }

                    int subKind = resultSet.getInt("SubKind");
                    if (subKind == 1)
                        moshtarak.setNoeService(new Integer(1)); //int
                    else
                        moshtarak.setNoeService(new Integer(2));

                    if (resultSet.getInt("Virtual") == 1) {
                        moshtarak.setMoshtarakYaNa(new Integer(2));
                        moshtarak.setNoeService(new Integer(2));
                    } else
                        moshtarak.setMoshtarakYaNa(new Integer(1));


                    String motorNo = resultSet.getString("MotorNo");
                    if (motorNo != null) {
                        moshtarak.setShomareMotor(motorNo.trim());
                    } else {
                        if (moshtarak.getMoshtarakYaNa().intValue() == 1) {
                            out.println("shomare motor not set. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                            errorCount++;
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 9 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                            continue;
                        }
                    }
                    // End of setting ctx.getForm()
                    ///////////////////////

                    moshtarakQuery.emptyElements();
                    moshtarakQuery.setSelectFields("id");
//                        String f = "shomareShasi='" + moshtarak.getShomareShasi().trim() + "' ";

                    boolean repl = false; //hasReplicate(MoshtarakUtil.getLocalHome().advanceRead(ctx.getConnection(), moshtarakQuery) , moshtarak.getId());
                    if (!repl) {
                        if (moshtarak.getShomareMotor() != null) {
//                                moshtarakQuery.emptyElements();
//                                moshtarakQuery.addElement(new QueryElement("String", moshtarak.getShomareMotor().trim()));
//                                moshtarakQuery.setWhere("shomareMotor=?");
//                                repl = com.objectj.emdad.web.util.Util.hasReplicate(com.objectj.emdad.web.util.Util.advanceRead(ctx, moshtarakQuery) , moshtarak.getId());
                            repl = UserAccessEntity.stringQueryRepl("SELECT id FROM moshtarak WHERE shomareMotor = '" + moshtarak.getShomareMotor().trim() + "'", "id", ctx.getConnection()) == null;
                        }
                    }
                    if (!repl) {
                        if (moshtarak.getShomarePelak() != null && moshtarak.getShomarePelak().length() > 0) {
                            moshtarakQuery.emptyElements();
                            moshtarakQuery.addElement(new QueryElement("String", moshtarak.getShomarePelak().trim()));
                            moshtarakQuery.setWhere("shomarePelak=? ");
                            repl = com.objectj.emdad.web.util.Util.hasReplicate(com.objectj.emdad.web.util.Util.advanceRead(ctx.getConnection(), moshtarakQuery), moshtarak.getId());
                        }
                    }
                    if (repl) {
                        out.println("shasi or motor or pelak already exists. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                        errorCount++;
                        statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 11 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                        continue;
                    }

                    boolean success = false;
                    if (isUpdate) {
                        try {
                            ((MoshtarakProxy) getProxy()).update(moshtarak, shahrId, noeKhodroId, rangId, bazaryabId);
                            success = true;
                            updateCount++;
                        } catch (Exception e) {
                            out.println("Error Updating Entity. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                            errorCount++;
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 10 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                        }
                    } else {
                        try {
                            ((MoshtarakProxy) getProxy()).create(moshtarak, shahrId, noeKhodroId, rangId, bazaryabId);
                            success = true;
                            createCount++;
                        } catch (Exception e) {
                            out.println("Error Creating Entity. (EshterakID = " + eshterakId + ", ShomareShassi = " + em_body + ")");
                            errorCount++;
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 15 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                        }
                    }
                    if (success) {
                        String is = resultSet.getString("importStatus");
                        if (is != null && !is.equals("0"))
                            statementStatus.executeUpdate("UPDATE subscriptions SET importStatus = 0 where subscriptionID = '" + resultSet.getString("SubscriptionID") + "'");
                    }
                }


                out.println("===========================");
                out.println("Error Count: " + errorCount);
                out.println("Unchange Count: " + unchangeCount);
                out.println("Update Count: " + updateCount);
                out.println("Create Count: " + createCount);
                out.println("Total record Count: " + recordCount);
                out.close();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            } finally {
                try {
                    if (rs2 != null)
                        rs2.close();
                } catch (Exception e2) {
                }

            }

        }

        errorList.add(0, new String("Error Count: " + errorCount));
        errorList.add(0, new String("Unchange Count: " + unchangeCount));
        errorList.add(0, new String("Update Count: " + updateCount));
        errorList.add(0, new String("Create Count: " + createCount));
        errorList.add(0, new String("Total record Count: " + recordCount));

        ctx.getRequest().setAttribute("errorList", errorList);
        log.info("========== iiiiiinnnnnneeeeehhhhhh...................");
        return ctx.getActionMapping().findForward("importinfo");
    }

    protected void writeError(String msg, DataOutputStream out) {
        try {
            out.writeUTF("<font color='red'>" + msg + "</font><br>");
        } catch (Exception e) {
        }
    }

    protected ActionForward doImport4(BaseActionContext ctx, String fileName) throws ProxyException {
        log.info(" IMPORT : file name = " + fileName);
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;
        int ignoreCount = 0;
        DataOutputStream out = null;

        if (!isCancelled(ctx.getRequest())) {
            try {

                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF(fileName);

//				out = new PrintWriter(new FileWriter(Util.getTemporaryLogPath() + "importMoshtarak.html"));
                String apx = HejriUtil.getCurDateTime(); // Long.toString(System.currentTimeMillis());
                String apx2 = apx.replace('/', '-');
                apx2 = apx2.replace(':', '-');
                try {
                    com.objectj.emdad.web.util.Util.copyUtf8File(
                            Util.getTemporaryLogPath() + "importMoshtarak.html",
                            Util.getTemporaryLogPath() + "importMoshtarak_" + apx2 + ".html", false);
                } catch (Exception e) {
                }

                out = new DataOutputStream(new FileOutputStream(Util.getTemporaryLogPath() + "importMoshtarak.html"));
                out.writeUTF("<TITLE></TITLE><META http-equiv=Content-Type content=\"text/html; charset=UTF-8\"><body>");
                writeError("fileName="+fileName+",Start Time:" + apx, out);

                //				for (int counter = 0; counter < 200; counter++) {
                //					resultSet.next();

                //				ArrayList shahrList = new ArrayList();
                //				ArrayList noeKhodroList = new ArrayList();
                //				ArrayList rangeKhodroList = new ArrayList();

                //				shahrList = ComboPool.getCombo("shahr");
                //				noeKhodroList = ComboPool.getCombo("noeKhodro");
                //				rangeKhodroList = ComboPool.getCombo("rangeKhodro");

                ////////////////////////////////////////////////////////////////
                // query and put result in memory objects to improve performance

                while (resultSet != null && resultSet.next()) {

                    recordCount++;

                    if (recordCount % 100 == 0) {
                        //=-= System.out.writeUTF(recordCount);
                    }

                    boolean isUpdate = false;
                    //	MoshtarakModel moshtarakModel = new MoshtarakModel();

                    try {
                        String agn = resultSet.getString("agn");
                        String carKindId = iranSysDecoder.decode(resultSet.getBytes("cacod"));
                        if (com.objectj.emdad.ejb.util.Util.isEmpty(agn) ||
                                com.objectj.emdad.ejb.util.Util.isEmpty(carKindId)) {
                            writeError("agn or cacod is NULL.", out);
                            errorCount++;
                            continue;
                        }
                        agn = agn.trim();
                        Integer namayandegi = new Integer(Integer.parseInt(agn));
                        if (namayandegi.intValue() == 1199 || namayandegi.intValue() == 1102 ) { // KARSHENASI
                            ignoreCount++;
                            continue;
                        }
                        int row = resultSet.getRow();
                        if (row % 2 == 0)
                            log.info("row=" + row);
                        carKindId = carKindId.trim();
                        if (carKindId.equals("258") || carKindId.equals("142") || carKindId.equals("235") || carKindId.equals("291") || carKindId.equals("292") ) {  // TAXI
                            ignoreCount++;
                            continue;
                        }
                        // chech if this enity already exsists
                        String body = resultSet.getString("cabody");
                        out.writeUTF("----- chassisNo=[" + body + "],row=" + row + "<br>");
                        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(body)) {
                            body = body.trim();
                        } else {
                            writeError("chassisNo is empty.", out);
                            errorCount++;
                            continue;
                        }

                        MoshtarakModel moshtarak = new MoshtarakModel();
                        moshtarak.setId("");

                        QueryObject moshtarakQuery = new QueryObject();
                        moshtarakQuery.setTables("moshtarak");
                        moshtarakQuery.setWhere("shomareShasi = '" + body + "'");
                        moshtarakQuery.setJoined(false);
                        ArrayList result = MoshtarakSessionUtil.getLocalHome().create().readModel(moshtarakQuery).getResult();
                        if (!result.isEmpty()) {
                            isUpdate = true;
                            //moshtarak.setId(((MoshtarakModel)result.get(0)).getId());
                            moshtarak = (MoshtarakModel) result.get(0);
                        }
                        moshtarak.setNamayandegi(namayandegi);

                        ///////////////////////////////////////////////////
                        // getting requeird data by query on other entities

                        //ShahrModel shahrModel = null;
                        String city = iranSysDecoder.decode(resultSet.getBytes("Shahr")).trim();
                        String shahrCode = resultSet.getString("cmcty");
                        shahrCode = shahrCode.trim();
                        String shahrId = "";
                        String shahrName = "";

                        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(shahrCode)) {
                            String[] sa = UserAccessEntity.stringQuerys("select id , shahrName from shahr where codeShahrKhodrosaz = '" + shahrCode + "'", "id , shahrName", ctx.getConnection());
                            //ArrayList shahrArray = (ShahrSessionUtil.getLocalHome().create().readModel(shahrQuery).getResult());

                            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(sa[0])) {
                                shahrId = sa[0];
                                shahrName = sa[1];
//						} else {
//							writeError("shahr name does not exist ",out);
//							errorCount++;
//							continue;
                            }
                        }
                        if (com.objectj.emdad.ejb.util.Util.isEmpty(shahrId)) {
                            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(city)) {
//                        QueryObject shahrQuery = new QueryObject();
//                        shahrQuery.setTables("shahr");
//                        shahrQuery.setWhere("codeShahrKhodrosaz = '"+shahrCode+"'");
//                        shahrQuery.setJoined(false);
//                        ArrayList shahrArray = (ShahrSessionUtil.getLocalHome().create().readModel(shahrQuery).getResult());
                                QueryObject shahrQuery = new QueryObject();
                                shahrQuery.setTables("shahr");
                                shahrQuery.setWhere("LTRIM(RTRIM(shahrName)) = ?");
                                shahrQuery.addElement(new QueryElement("String", city));
                                shahrQuery.setJoined(false);
                                shahrQuery.setSelectFields("id , shahrName");
                                String[] sa = UserAccessEntity.stringQuerys(shahrQuery, ctx.getConnection());

                                if (com.objectj.emdad.ejb.util.Util.isNotEmpty(sa[0])) {
                                    shahrId = sa[0];
                                    shahrName = sa[1];
                                } else {
                                    writeError("shahr name & code not exist ." + shahrCode + city, out);
                                    errorCount++;
                                    continue;
                                }
                            } else {
                                writeError("shahr name & code not exist ." + shahrCode, out);
                                errorCount++;
                                continue;
                            }
                        }

                        String noeKhodroId = "";
                        int noeKhodroVije = 0;
                        int noeKhodroG = 0;
                        //NoeKhodroModel noeKhodroModel = new NoeKhodroModel();
                        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(carKindId)) {

//						QueryObject noeKhodroQuery = new QueryObject();
//						noeKhodroQuery.setTables("noeKhodro");
//						noeKhodroQuery.setWhere("khodroCode = ?");
//						noeKhodroQuery.addElement(new QueryElement("String", carKindId));
//						noeKhodroQuery.setJoined(false);
//						ArrayList noeKhodroArray = NoeKhodroSessionUtil.getLocalHome().create().readModel(noeKhodroQuery).getResult();
                            String[] sa = UserAccessEntity.stringQuerys("select id , noeService , guarantee from noeKhodro where khodroCode = '" + carKindId + "'", "id , noeService , guarantee", ctx.getConnection());

                            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(sa[0])) {
                                noeKhodroId = sa[0];
//							noeKhodroModel = (NoeKhodroModel)noeKhodroArray.get(0);
                                moshtarak.setNoeService(new Integer(Integer.parseInt(sa[1]))); //noeKhodroModel.getVijeh());
                                noeKhodroG = Integer.parseInt(sa[2]);
                            } else {
                                writeError("Noekhodro does not exist. " + carKindId, out);
                                errorCount++;
                                continue;
                            }
                        } else {
                            writeError("NoeKhodro not set. ", out);
                            errorCount++;
                            continue;
                        }

                        //RangeKhodroModel rangeKhodroModel = new RangeKhodroModel();
                        String colorId = resultSet.getString("color"); //iranSysDecoder.decode(resultSet.getBytes("color"));
                        String rangeKhodroId = "";
                        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(colorId)) {
                            colorId = colorId.trim();
//						QueryObject rangeKhodroQuery = new QueryObject();
//						rangeKhodroQuery.setTables("rangeKhodro");
//						rangeKhodroQuery.setWhere("codeRangeKhodrosaz = ?");
//						rangeKhodroQuery.addElement(new QueryElement("String", colorId));
//						rangeKhodroQuery.setJoined(false);
//						ArrayList rangeKhodroArray = RangeKhodroSessionUtil.getLocalHome().create().readModel(rangeKhodroQuery).getResult();
                            String[] sa = UserAccessEntity.stringQuerys("select id from rangeKhodro where codeRangeKhodrosaz = '" + colorId + "'", "id", ctx.getConnection());

                            if (com.objectj.emdad.ejb.util.Util.isNotEmpty(sa[0])) {
                                rangeKhodroId = sa[0];
//
//						if (!rangeKhodroArray.isEmpty()) {
//							rangeKhodroModel = (RangeKhodroModel)rangeKhodroArray.get(0);
                            } else {
                                writeError("RangeKhodro does not exist. " + colorId, out);
                                errorCount++;
                                continue;
                            }
                        } else {
                            writeError("RangeKhodro not set. ", out);
                            errorCount++;
                            continue;
                        }

                        /*
                                            QueryObject bazaryabQuery = new QueryObject();
                                            bazaryabQuery.setTables("bazaryab");
                                            bazaryabQuery.setWhere("bazaryabId = ?");
                                            bazaryabQuery.addElement(new QueryElement("Integer", resultSet.getString("Reseller")));
                                            bazaryabQuery.setJoined(false);
                                            ArrayList bazaryabArray = BazaryabSessionUtil.getLocalHome().create().readModel(bazaryabQuery).getResult();
                                            BazaryabModel bazaryabModel = new BazaryabModel();
                                            if (!bazaryabArray.isEmpty()) {
                                                bazaryabModel = (BazaryabModel)bazaryabArray.get(0);
                                            } else {
                                                errorList.add(new String("Refrenced Bazaryab on row " + resultSet.getRow() + " does not exist"));
                                                continue;
                                            }
                        */

                        ///////////////////////////
                        // Setting valueObject starts here

                        moshtarak.setGuarantee((new Integer(1)));
                        moshtarak.setNoeEshterak((new Integer(2)));  //gharardadi
                        moshtarak.setVazeat((new Integer(1)));
                        moshtarak.setMoshtarakYaNa(new Integer(1));
                        moshtarak.setMajaziYaNa((new Integer(2)));

                        byte[] em_nam = resultSet.getBytes("Cmnam");
                        if (em_nam != null) {
                            String em_nam_uni = iranSysDecoder.decode(em_nam);
                            moshtarak.setName(em_nam_uni.substring(0, em_nam_uni.length() < 20 ? em_nam_uni.length() : 20));
                        } else {
                            moshtarak.setName("-");
                        }

                        byte[] em_fam = resultSet.getBytes("Cmfam");
                        if (em_fam != null) {
                            String em_fam_uni = iranSysDecoder.decode(em_fam);
                            moshtarak.setNameKhanevadegi(em_fam_uni.substring(0, em_fam_uni.length() < 20 ? em_fam_uni.length() : 20));
                        } else {
                            moshtarak.setNameKhanevadegi("-");
                        }

                        byte[] em_adres = resultSet.getBytes("Cmadr");
                        if (em_adres != null) {
                            String em_adres_uni = iranSysDecoder.decode(em_adres);
                            moshtarak.setAddress((em_adres_uni.substring(0, em_adres_uni.length() < 80 ? em_adres_uni.length() : 80))); //nchar
                        }

                        if (body != null) {
                            moshtarak.setSaleSakht((Integer.valueOf("13" + body.substring(2, 4).trim())));
                            moshtarak.setShomareShasi(body.trim());
                            //moshtarak.setEshterakId(body.trim());
                        }

                        String em_motor = resultSet.getString("Camot");
                        if (em_motor != null) {
                            moshtarak.setShomareMotor(em_motor.trim());
                        } else {
                            writeError("ShomareMotor not set. ", out);
                            errorCount++;
                            continue;
                        }

                        String date = resultSet.getString("vaz_dat").trim();
                        if (HejriUtil.isValidDate(date)) {
                            moshtarak.setTarikhEngheza(HejriUtil.incYear(HejriUtil.hejriToChris(date)));
                            if (noeKhodroG != 0) { //noeKhodroModel != null) {
                                moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(date), noeKhodroG)); //noeKhodroModel.getGuarantee().intValue()));
                            } else {
                                moshtarak.setTarikhEnghezaGuarantee(HejriUtil.incMonth(HejriUtil.hejriToChris(date), 12));
                            }
                            moshtarak.setTarikhShoro(HejriUtil.hejriToChris(date));
                            moshtarak.setTarikhTahvil(HejriUtil.hejriToChris(date));
                        } else {
                            writeError("Wrong date " + date, out);
                            errorCount++;
                            continue;
                        }

                        byte[] em_tel = resultSet.getBytes("Cmtel");
                        if (em_tel != null) {
                            byte[] em_telcod = resultSet.getBytes("Cmtelcd");
                            if (em_telcod != null) {
                                moshtarak.setTel(iranSysDecoder.decode(em_telcod) + " " + iranSysDecoder.decode(em_tel));
                            } else {
                                moshtarak.setTel((iranSysDecoder.decode(em_tel)));
                            }
                        }

                        ///////////////////////////
                        ////////////////////////////

                        String dou1 = resultSet.getString("dou1");
                        String seh1 = resultSet.getString("seh1");
                        String harf1 = iranSysDecoder.decode(resultSet.getBytes("harf1"));
                        String s_er1 = resultSet.getString("s_er1");

                        String pelak = "";
                        try {
                            pelak = dou1.concat(harf1.concat(seh1));
                            pelak = pelak.concat(" ".concat(shahrName + "-").concat(s_er1));
                        } catch (Exception e) {
                            pelak = "";
                        }
                        moshtarak.setShomarePelak(pelak.trim());
                        moshtarak.setNaghd(new Integer(0));
                        moshtarak.setTaahodi(new Integer(0));
                        moshtarak.setAghsat(new Integer(0));
                        moshtarak.setTakhfif(new Integer(0));
                        moshtarak.setHazinehPardakhtShodeh(new Integer(0));

                        //moshtarak.setEmail(resultSet.getString("Email")); //nchar
                        //moshtarak.setPostCode(resultSet.getString("PostalCode")); //nchar
                        //moshtarak.setTarikhTavalod(resultSet.getDate("BirthDate"));
                        //moshtarak.setEshterakId(resultSet.getString("SubscriptionID")); //nchar

                        // End of setting ctx.getForm()
                        ///////////////////////

                        ActionErrors actionErrors = new ActionErrors();
                        try {
                            Validators.moshtarakValidator(ctx.getConnection(), moshtarak, actionErrors);
                        } catch (Exception e) {
                            writeError("Error Validating Moshtarak. " + e, out);
                            errorCount++;
                            continue;
                        }
                        if (actionErrors.isEmpty()) {
                            if (isUpdate) {
                                try {
                                    //doUpdate(ctx);
//((MoshtarakProxy)getProxy()).update(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("rangeKhodroId").toString(), ctx.getForm().get("bazaryabId").toString());
                                    ((MoshtarakProxy) getProxy()).update(moshtarak, shahrId, noeKhodroId, rangeKhodroId, Constants.getBazaryab_Irankhodro());
                                    out.writeUTF("----------Updated.<br>");
                                    updateCount++;
                                } catch (Exception e) {
                                    writeError("Error Updating Moshtarak. " + e, out);
                                    log.error("Error Updating Moshtarak. ", e);
                                    errorCount++;
                                }
                            } else {
                                try {
                                    MoshtarakModel mm = (MoshtarakModel) ((MoshtarakProxy) getProxy()).create(moshtarak, shahrId, noeKhodroId, rangeKhodroId, Constants.getBazaryab_Irankhodro());
                                    out.writeUTF("----------code Moshtarak=" + mm.getEshterakId() + "<br>");
                                    createCount++;
                                } catch (Exception e) {
                                    writeError("Error Creating Moshtarak." + e, out);
                                    log.error("Error Creating Moshtarak.", e);
                                    errorCount++;
                                }
                            }
                        } else {
                            Iterator iter = actionErrors.get();
                            String errorTmp = new String();
                            while (iter.hasNext()) {
                                ActionError actionError = (ActionError) iter.next();
                                String ts = Util.getProperty(actionError.getKey());
                                if (ts != null)
                                    errorTmp += ts;
                                else
                                    errorTmp += actionError.getKey();
                                errorTmp += ", ";
                            }
                            writeError(errorTmp, out);
                            errorCount++;
                        }
                    } catch (Exception e) {
                        writeError("Error occured." + e, out);
                    }
                }
                if (resultSet == null) {
                    writeError("Error Reading or parsing : " + fileName, out);
                }

                writeError("===========================", out);
                writeError("Error Count: " + errorCount, out);
                writeError("Unchange Count: " + unchangeCount, out);
                writeError("IgnoreCount Count: " + ignoreCount, out);
                writeError("Update Count: " + updateCount, out);
                writeError("Create Count: " + createCount, out);
                writeError("Total record Count: " + recordCount, out);

                out.close();
                out = null;
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }

        try {
            if (out != null)
                out.close();
        } catch (Exception e) {
        }

        errorList.add(0, new String("Error Count: " + errorCount));
        errorList.add(0, new String("Unchange Count: " + unchangeCount));
        errorList.add(0, new String("IgnoreCount Count: " + ignoreCount));
        errorList.add(0, new String("Update Count: " + updateCount));
        errorList.add(0, new String("Create Count: " + createCount));
        errorList.add(0, new String("Total record Count: " + recordCount));

        ctx.getRequest().setAttribute("errorList", errorList);
        ctx.getRequest().setAttribute("errorCount", new Integer(errorCount));
        log.info("========== iiiiiinnnnnneeeeehhhhhh...................");
        return ctx.getActionMapping().findForward("importinfo");
    }

    protected ActionForward doCheckRequest(BaseActionContext ctx) {
        try {
            String eshterakId = (String) (ctx.getForm().get("eshterakId"));
            Integer rokhdadId = (Integer) (ctx.getForm().get("rokhdadId"));

            ArrayList moshtarakArray = new ArrayList();

            if (eshterakId != null && eshterakId.length() != 0 && rokhdadId != null) {
                QueryObject qo = new QueryObject();
                qo.setTables("moshtarak, rokhdad");
                qo.setJoined(false);
                qo.setWhere("eshterakId = '" + eshterakId.trim() + "'" + " AND " + "rokhdadId = " + rokhdadId + " AND moshtarak.Id = rokhdad.moshtarakId");
                moshtarakArray = MoshtarakSessionUtil.getLocalHome().create().readModel(qo).getResult();
                com.objectj.emdad.web.util.Util.getArrayList("noeEmdad");
            }

            if (!(moshtarakArray).isEmpty()) {
                ctx.getRequest().setAttribute("eshterakId", eshterakId);
                ctx.getRequest().setAttribute("rokhdadId", rokhdadId);
                QueryObject rokhdadQuery = new QueryObject();
                rokhdadQuery.setTables("rokhdad");
                rokhdadQuery.setJoined(false);
                rokhdadQuery.setWhere("rokhdadId =" + rokhdadId);
                ArrayList rokhdadArray = RokhdadSessionUtil.getLocalHome().create().readModel(rokhdadQuery).getResult();
                if (!rokhdadArray.isEmpty()) {
                    RokhdadModel rokhdadModel = (RokhdadModel) rokhdadArray.get(0);
                    //ctx.getRequest().setAttribute("eghdamShodeh", rokhdadModel.getEghdamShodeh());
                    ctx.getRequest().setAttribute("eghdamShodeh", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("yesNo",(rokhdadModel.getEghdamShodeh().intValue())));

                    QueryObject emdadQuery = new QueryObject();
					emdadQuery.setTables("emdadlist");
                    //emdadQuery.setJoined(false)
					emdadQuery.setWhere("emdadlist.rokhdadIdO = '" + rokhdadModel.getId() + "'");
                    ArrayList emdadArray = EmdadSessionUtil.getLocalHome().create().readList(emdadQuery).getResult();

                    ctx.getRequest().setAttribute("emdadList", emdadArray);

                    //					PeigiriEzamgarList peigiriList = new PeigiriEzamgarList();
                    ArrayList peigiriTmp = new ArrayList();
                    if (emdadArray != null && emdadArray.size() != 0) {
                        EmdadList emdadList = (EmdadList) emdadArray.get(emdadArray.size() - 1);
                        QueryObject peigiriQuery = new QueryObject();
                        peigiriQuery.setTables("view_PeigiriEzamgar");
                        peigiriQuery.setWhere("emdadIdO = '" + emdadList.getId()+"'");
                        ArrayList PeygiriArray = PeigiriEzamgarSessionUtil.getLocalHome().create().readList(peigiriQuery).getResult();

                        if (PeygiriArray != null && PeygiriArray.size() != 0) {
                            peigiriTmp.add(PeygiriArray.get(PeygiriArray.size() - 1));
                        }
                    }

                    ctx.getRequest().setAttribute("peigiriList", peigiriTmp);
                    return ctx.getActionMapping().findForward("infoPeygiri");
                }
            } else {
                ActionErrors error = new ActionErrors();
                error.add("aaa", new ActionError("errors.moshtarak.reqPeygiri"));
                showMessage(ctx, error);
                return ctx.getActionMapping().findForward("reqPeygiri");
            }
        } catch (ProxyException e) {
            e.printStackTrace();
        } catch (CreateException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

}