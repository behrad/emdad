package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/c/darkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.edit.jsp"
 *      inputPrime="emdad.darkhastEshterak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/r/darkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.read.jsp"
 *      inputPrime="emdad.darkhastEshterak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/u/darkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.edit.jsp"
 *      inputPrime="emdad.darkhastEshterak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/d/darkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.read.jsp"
 *      inputPrime="emdad.darkhastEshterak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/l/darkhastEshterak"
 *      pathPrime="/darkhastEshterakList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.list.jsp"
 *      inputPrime="emdad.darkhastEshterak.list"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/c/validatedarkhastEshterak"
 *      pathPrime="/validatedarkhastEshterak"
 *      scope="request"
 *      input="/c/darkhastEshterak.run"
 *      inputPrime="emdad.darkhastEshterak.edit"
 *      input4tiles="emdad.darkhastEshterak.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/u/validatedarkhastEshterak"
 *      pathPrime="/validatedarkhastEshterak"
 *      scope="request"
 *      input="/u/darkhastEshterak.run"
 *      inputPrime="emdad.darkhastEshterak.edit"
 *      input4tiles="emdad.darkhastEshterak.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/s/validatedarkhastEshterak"
 *      pathPrime="/validatedarkhastEshterak"
 *      scope="request"
 *      input="/s/darkhastEshterak.run"
 *      inputPrime="emdad.darkhastEshterak.create"
 *      input4tiles="emdad.darkhastEshterak.create"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastEshterakForm"
 *      path="/s/darkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastEshterak.read.jsp"
 *      inputPrime="emdad.darkhastEshterak.read"
 *      validate="false"
 *
 *    @struts.action
 *      name="darkhastEshterakForm"
 *      path="/s/moshtariDarkhastEshterak"
 *      pathPrime="/darkhastEshterak"
 *      scope="request"
 *      input="/s/moshtariDarkhastEshterak.run"
 *      inputPrime="emdad.darkhastEshterak.create"
 *      input4tiles="emdad.darkhastEshterak.create"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="thanksPage"
 *      path="emdad.darkhastEshterak.thanks"
 *      pathPrime="emdad.darkhastEshterak.thanks"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.darkhastEshterak.list"
 *      pathPrime="emdad.darkhastEshterak.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.darkhastEshterak.edit"
 *      pathPrime="emdad.darkhastEshterak.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.darkhastEshterak.read"
 *      pathPrime="emdad.darkhastEshterak.read"
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
 *      name="request"
 *      path="emdad.darkhastEshterak.create"
 *      pathPrime="emdad.darkhastEshterak.create"
 *
 */

public class DarkhastEshterakAction extends BaseAction {

    protected Class getValueObjectClass() {
        return DarkhastEshterakModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"nameKhanevadegi", "nameMoshtarak", "shomarePelak", "shomareShasi"};
    }

    protected String[] getRelatedEntities() {
        return new String[] {"noeKhodro", "shahr", "rangekhodro"};
    }


    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DarkhastEshterakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

        ArrayList shahrList = new ArrayList();
        ArrayList noeKhodroList = new ArrayList();
        ArrayList rangeKhodroList = new ArrayList();

        try {
            ctx.getRequest().setAttribute("shomarePelak.title1", Util.getProperty("shomarePelak.title1"));
            ctx.getRequest().setAttribute("shomarePelak.title2", Util.getProperty("shomarePelak.title2"));
            ctx.getRequest().setAttribute("samplePelak1.1", Util.getProperty("shomarePelak.sample.1.1"));
            ctx.getRequest().setAttribute("samplePelak1.2", Util.getProperty("shomarePelak.sample.1.2"));
            ctx.getRequest().setAttribute("samplePelak2.1", Util.getProperty("shomarePelak.sample.2.1"));
            ctx.getRequest().setAttribute("samplePelak2.2", Util.getProperty("shomarePelak.sample.2.2"));
            shahrList = ComboPool.getCombo("shahr");
            noeKhodroList = ComboPool.getCombo("noeKhodro");
            rangeKhodroList = ComboPool.getCombo("rangeKhodro");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }

        ctx.getRequest().setAttribute("shahrList", shahrList);
        ctx.getRequest().setAttribute("noeKhodroList", noeKhodroList);
        ctx.getRequest().setAttribute("rangeKhodroList", rangeKhodroList);
        ctx.getRequest().setAttribute("garanteeList", Util.getArrayList("yesNo"));
        ctx.getRequest().setAttribute("nahvePardakhtList",Util.getArrayList("nahvePardakht"));
        ctx.getRequest().setAttribute("noeServiceList",Util.getArrayList("noeService"));
    }


    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                DarkhastEshterakModel vo = new DarkhastEshterakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                System.out.println("333="+(String)ctx.getForm().get("tarikhTavalod"));

                if ((String)(ctx.getForm().get("tarikhTavalod")) != null && ((String)(ctx.getForm().get("tarikhTavalod"))).length() != 0)
                {   log.info("before Tarikh: "+HejriUtil.toDate((String)(ctx.getForm().get("tarikhTavalod"))).toString());
                    vo.setTarikhTavalod(HejriUtil.toDate((String)(ctx.getForm().get("tarikhTavalod"))));
                    log.info("after Tarikh: "+vo.getTarikhTavalod().toString());
                }
                if ((String)(ctx.getForm().get("tarikhFish")) != null && ((String)(ctx.getForm().get("tarikhFish"))).length() != 0)
                    vo.setTarikhFish(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhFish")))));
                if ((String)(ctx.getForm().get("tarikhEnghezaGarantee")) != null && ((String)(ctx.getForm().get("tarikhEnghezaGarantee"))).length() != 0)
                    vo.setTarikhEnghezaGarantee(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhEnghezaGarantee")))));
                ((DarkhastEshterakProxy) getProxy()).create(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("rangeKhodroId").toString());
                ctx.getForm().set(ACTION_TYPE, "specific,thanks");
                return ctx.getActionMapping().findForward("thanksPage");
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }


    protected ActionForward doAccept(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException,ClassNotFoundException, java.rmi.RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                //=-= System.out.println(" form = " + ctx.getForm());

                java.util.Date now = new java.util.Date();

                /*
                DarkhastEshterakModel vo = new DarkhastEshterakModel();
                if (HejriUtil.isValidDate((String)(form.get("tarikhEnghezaGarantee"))))
                    form.set("tarikhEnghezaGarantee", HejriUtil.hejriToChrisStr((String)form.get("tarikhEnghezaGarantee")));
                if (HejriUtil.isValidDate((String)(form.get("tarikhFish"))))
                    form.set("tarikhFish", HejriUtil.hejriToChrisStr((String)form.get("tarikhFish")));
                if (HejriUtil.isValidDate((String)(form.get("tarikhTavalod"))))
                    form.set("tarikhTavalod", HejriUtil.hejriToChrisStr((String)form.get("tarikhTavalod")));

                Exchanger.exhangeFormToValueObject(form, vo);

                if ((String)(form.get("tarikhTavalod")) != null && ((String)(form.get("tarikhTavalod"))).length() != 0)
                    vo.setTarikhTavalod(HejriUtil.toDate((String)(form.get("tarikhTavalod"))));
                if ((String)(form.get("tarikhFish")) != null && ((String)(form.get("tarikhFish"))).length() != 0)
                    vo.setTarikhFish(HejriUtil.toDate(((String)(form.get("tarikhFish")))));
                if ((String)(form.get("tarikhEnghezaGarantee")) != null && ((String)(form.get("tarikhEnghezaGarantee"))).length() != 0)
                    vo.setTarikhEnghezaGarantee(HejriUtil.toDate(((String)(form.get("tarikhEnghezaGarantee")))));

                log.info("ba'ade exchanger");
                */
                DarkhastEshterakLocal darkhastEshterakLocal = DarkhastEshterakUtil.getLocalHome().findByPrimaryKey((String)ctx.getForm().get(ID));
                DarkhastEshterakModel vo = darkhastEshterakLocal.getDarkhastEshterakModel();

                ShahrLocal shahrObject = darkhastEshterakLocal.getShahr();
                String shahrId = shahrObject.getId();
                NoeKhodroLocal noeKhodroObject = darkhastEshterakLocal.getNoeKhodro();
                String noeKhodroId = noeKhodroObject.getId();
                RangeKhodroLocal rangeKhodroObject = darkhastEshterakLocal.getRangeKhodro();
                String rangeKhodroId = rangeKhodroObject.getId();
                String bazaryabId = Constants.getBazaryab_Unknown(); //"968080808080808080o";
                MoshtarakModel moshtarak = new MoshtarakModel();
                moshtarak.setAddress(vo.getAddressMoshtarak());
                moshtarak.setTel(vo.getTelMoshtarak());
                moshtarak.setEmail(vo.getEmailMoshtarak());
                moshtarak.setGuarantee(vo.getGarantee());
                moshtarak.setMobile(vo.getMobileMoshtarak());
                moshtarak.setName(vo.getNameMoshtarak());
                moshtarak.setNameKhanevadegi(vo.getNameKhanevadegi());
                moshtarak.setNoeService(vo.getNoeService());
                moshtarak.setNoeEshterak(new Integer(1));
                moshtarak.setPostCode(vo.getCodePost());
                moshtarak.setVazeat(new Integer(1));
                moshtarak.setSaleSakht(vo.getSaleSakht());
                moshtarak.setShomareMotor(vo.getShomareMotor());
                moshtarak.setShomarePelak(vo.getShomarePelak());
                moshtarak.setShomareShasi(vo.getShomareShasi());
                moshtarak.setTarikhEnghezaGuarantee(vo.getTarikhEnghezaGarantee()) ;
                moshtarak.setTarikhTavalod(vo.getTarikhTavalod());
                moshtarak.setTarikhShoro(new java.sql.Date(now.getTime()));
                moshtarak.setTarikhEngheza(HejriUtil.incYear(now));
                moshtarak.setMoshtarakYaNa(new Integer(1));
                moshtarak.setNaghd(vo.getHazineh());
                moshtarak.setHazinehPardakhtShodeh(vo.getHazineh());
                moshtarak.setNamayandegi(new Integer(0));
                moshtarak.setTakhfif(new Integer(0));
                moshtarak.setTaahodi(new Integer(0));
                moshtarak.setAghsat(new Integer(0));

//                moshtarak.setEshterakId(vo.getShomarePelak());    ////////////////////////////////
                ActionErrors error = new ActionErrors();
                Validators.moshtarakValidator(ctx.getConnection(), moshtarak, error);
                if (!error.isEmpty()) {
                    showMessage(ctx, error);
                }
                else {
                    MoshtarakModel model = (MoshtarakModel)(MoshtarakSessionUtil.getLocalHome().create()).create(moshtarak, shahrId , noeKhodroId, rangeKhodroId, bazaryabId);
                    getProxy().remove(vo);
                    error.clear();
                    error.add("aaa",new ActionError("new.EshterakId.report", model.getEshterakId()));
                    showMessage(ctx, error);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }


    protected ActionForward doRead(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        ValueObject valueObject = newValueObject();
        Exchanger.exhangeFormToValueObject(ctx.getForm(), valueObject);

        Collection valueObjectList = getProxy().read(valueObject).getResult();
        ctx.getRequest().setAttribute(VALUE_OBJECT_LIST, valueObjectList);
        return listAll(ctx);
    }


    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.DarkhastEshterakSessionLocalHome lhProxy = com.objectj.emdad.proxy.DarkhastEshterakSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.DarkhastEshterakSessionLocal lProxy = lhProxy.create();
            ValueObject voDarkhastEshterakList = lProxy.read(id);

            //=-= System.out.print(((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhTavalod());


            ctx.getRequest().setAttribute(VALUE_OBJECT, voDarkhastEshterakList);
            ctx.getRequest().setAttribute("nahvePardakht",  com.objectj.emdad.ejb.util.Util.getNameFromArrayList("nahvePardakht",((DarkhastEshterakModel)voDarkhastEshterakList).getNahvePardakht()));
            ctx.getRequest().setAttribute("garantee", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("yesNo",((DarkhastEshterakModel)voDarkhastEshterakList).getGarantee()));
            ctx.getRequest().setAttribute("noeService", com.objectj.emdad.ejb.util.Util.getNameFromArrayList("noeService",((DarkhastEshterakModel)voDarkhastEshterakList).getNoeService()));
            if (((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhEnghezaGarantee() != null)
                ctx.getRequest().setAttribute("tarikhEnghezaGarantee",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhEnghezaGarantee()));
            else
                ctx.getRequest().setAttribute("tarikhEnghezaGarantee","");
            if (((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhFish() != null)
                ctx.getRequest().setAttribute("tarikhFish",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhFish()));
            else
                ctx.getRequest().setAttribute("tarikhFish","");
            if (((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhTavalod() != null)
                ctx.getRequest().setAttribute("tarikhTavalod",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(voDarkhastEshterakList)).getTarikhTavalod()));
            else
                ctx.getRequest().setAttribute("tarikhTavalod","");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }

        return ctx.getActionMapping().findForward("read");
    }


    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullTavalod = false;
        boolean isNullFish = false;
        boolean isNullEnghezaGarantee = false;

        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);
        if (((DarkhastEshterakModel)(vo)).getTarikhEnghezaGarantee() == null){
            ((DarkhastEshterakModel)(vo)).setTarikhEnghezaGarantee(new Date(0));
            isNullEnghezaGarantee = true;
        }
        if (((DarkhastEshterakModel)(vo)).getTarikhFish() == null){
            ((DarkhastEshterakModel)(vo)).setTarikhFish(new Date(0));
            isNullFish = true;
        }
        if (((DarkhastEshterakModel)(vo)).getTarikhTavalod() == null){
            ((DarkhastEshterakModel)(vo)).setTarikhTavalod(new Date(0));
            isNullTavalod = true;
        }
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        String s = (String)ctx.getForm().get("shomarePelak");
        if (s != null && s.length() != 0) {
            if (s.indexOf(" ") > 0) {
                ctx.getForm().set("shomarePelak", s.substring(0, s.indexOf(" ")));
                ctx.getForm().set("shomarePelak2", s.substring(s.indexOf(" ")));
            } else
                ctx.getForm().set("shomarePelak", s);
        }

        if (!isNullTavalod)
            ctx.getForm().set("tarikhTavalod",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(vo)).getTarikhTavalod()));
        else
            ctx.getForm().set("tarikhTavalod", "");
        if (!isNullFish)
            ctx.getForm().set("tarikhFish",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(vo)).getTarikhFish()));
        else
            ctx.getForm().set("tarikhFish","");
        if (!isNullEnghezaGarantee)
            ctx.getForm().set("tarikhEnghezaGarantee",HejriUtil.chrisToHejri(((DarkhastEshterakModel)(vo)).getTarikhEnghezaGarantee()));
        else
            ctx.getForm().set("tarikhEnghezaGarantee","");

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        try {
            if (!isCancelled(ctx.getRequest())) {
                DarkhastEshterakModel vo = new DarkhastEshterakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                if ((String)(ctx.getForm().get("tarikhTavalod")) != null && ((String)(ctx.getForm().get("tarikhTavalod"))).length() != 0)
                    vo.setTarikhTavalod(HejriUtil.toDate((String)(ctx.getForm().get("tarikhTavalod"))));
                if ((String)(ctx.getForm().get("tarikhFish")) != null && ((String)(ctx.getForm().get("tarikhFish"))).length() != 0)
                    vo.setTarikhFish(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhFish")))));
                if ((String)(ctx.getForm().get("tarikhEnghezaGarantee")) != null && ((String)(ctx.getForm().get("tarikhEnghezaGarantee"))).length() != 0)
                    vo.setTarikhEnghezaGarantee(HejriUtil.toDate(((String)(ctx.getForm().get("tarikhEnghezaGarantee")))));
                ((DarkhastEshterakProxy)getProxy()).update(vo, ctx.getForm().get("shahrId").toString(), ctx.getForm().get("noeKhodroId").toString(), ctx.getForm().get("rangeKhodroId").toString());
            }
        } catch (ProxyException e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return listAll(ctx);
    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        //ctx.getForm().set(ACTION_TYPE, "read_all");
        if (ctx.getSubAction().equals("request")) {
            ctx.getForm().set(ACTION_TYPE, "specific,createDarkhastEshterak");
            return ctx.getActionMapping().findForward("request");
        }
        else if (ctx.getSubAction().equals("createDarkhastEshterak")) {
            if (!isCancelled(ctx.getRequest())) {
                DarkhastEshterakForm f = (DarkhastEshterakForm) ctx.getForm();
                ActionErrors err = f.validate(ctx.getActionMapping(), ctx.getRequest());
                if (!err.isEmpty()) {
                    showMessage(ctx, err);
                    if (!com.objectj.emdad.ejb.util.Util.isEmpty(ctx.getForm().get("tarikhTavalod").toString()))
                        ctx.getForm().set("tarikhTavalod",HejriUtil.chrisToHejri(ctx.getForm().get("tarikhTavalod").toString()));
                    if (!com.objectj.emdad.ejb.util.Util.isEmpty(ctx.getForm().get("tarikhEnghezaGarantee").toString()))
                        ctx.getForm().set("tarikhEnghezaGarantee",HejriUtil.chrisToHejri(ctx.getForm().get("tarikhEnghezaGarantee").toString()));
                    return ctx.getActionMapping().findForward("request");
                }
    			doCreate(ctx);
                return ctx.getActionMapping().findForward("thanksPage");
            }
            else
                return ctx.getActionMapping().findForward("defaultHome");
		}
        else if (ctx.getSubAction().equals("goHome")){
            return ctx.getActionMapping().findForward("defaultHome");
        }
        if (ctx.getRequest().getRequestURI().toLowerCase().indexOf("/moshtari") >= 0)
            return null;
        if (ctx.getSubAction().equals("accept")) {
            return doAccept(ctx);
        }

        return null;
    }

}
