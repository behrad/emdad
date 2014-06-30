package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import javax.servlet.ServletException;


/**
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/c/darkhastQate"
 *      pathPrime="/darkhastQate"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastQate.edit.jsp"
 *      inputPrime="emdad.darkhastQate.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/r/darkhastQate"
 *      pathPrime="/darkhastQate"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastQate.read.jsp"
 *      inputPrime="emdad.darkhastQate.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/u/darkhastQate"
 *      pathPrime="/darkhastQate"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastQate.edit.jsp"
 *      inputPrime="emdad.darkhastQate.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/d/darkhastQate"
 *      pathPrime="/darkhastQate"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastQate.read.jsp"
 *      inputPrime="emdad.darkhastQate.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/l/darkhastQate"
 *      pathPrime="/darkhastQateList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastQate.list.jsp"
 *      inputPrime="emdad.darkhastQate.list"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/c/validatedarkhastQate"
 *      pathPrime="/validatedarkhastQate"
 *      scope="request"
 *      input="/c/darkhastQate.run"
 *      inputPrime="emdad.darkhastQate.edit"
 *      input4tiles="emdad.darkhastQate.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterDarkhastQateForm"
 *      path="/l/filterdarkhastQate"
 *      pathPrime="/filterdarkhastQate"
 *      scope="request"
 *      input="/l/darkhastQate.run"
 *      inputPrime="emdad.darkhastQate.edit"
 *      input4tiles="emdad.darkhastQate.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastQateForm"
 *      path="/u/validatedarkhastQate"
 *      pathPrime="/validatedarkhastQate"
 *      scope="request"
 *      input="/u/darkhastQate.run"
 *      inputPrime="emdad.darkhastQate.edit"
 *      input4tiles="emdad.darkhastQate.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.darkhastQate.list"
 *      pathPrime="emdad.darkhastQate.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.darkhastQate.edit"
 *      pathPrime="emdad.darkhastQate.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.darkhastQate.read"
 *      pathPrime="emdad.darkhastQate.read"
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

public class DarkhastQateAction extends BaseAction {
    boolean isAnbar, isSarparast;
   // String forceFilter, forceForwardTo;

    protected Class getValueObjectClass() {
        return DarkhastQateModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"darkhastQateId", "emdadgarId", "tarikhDarkhast", "qateId", "tedadDarkhasti"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"qate", "emdadgar"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DarkhastQateSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ArrayList emdadgarList = new ArrayList();
        ArrayList yesNo = new ArrayList();
        ArrayList bazarAnbarList = new ArrayList();

        try {

            if (ctx.getForm().get("order") == null || ((String)ctx.getForm().get("order")).length() == 0)
                ctx.getForm().set("order", "DESC");
            emdadgarList = EmdadgarSessionUtil.getLocalHome().create().readCombo("emdadgar", "name",  "daftarOstaniId = '" + ctx.getUserSession().getDaftarOstani() + "'").getResult();
            yesNo = Util.getArrayList("yesNo");
            bazarAnbarList = Util.getArrayList("bazarAnbar");

            if (ctx.isUserInRole(com.objectj.emdad.ejb.util.Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(com.objectj.emdad.ejb.util.Constants.ROLE_EMDADGARPEYMANI)){
                String emdadgarId =  UserAccessEntity.getEntityId(ctx.getUserSession().getName());
                ctx.getRequest().setAttribute("role", "emdadgar");
                ctx.getForm().set("emdadgarId", emdadgarId);
                ctx.getRequest().setAttribute("emdadgarName", UserAccessEntity.getUserFullName(ctx.getUserSession().getName()));
                ctx.setForceFilter("darkhastQate.emdadgarId = 'S"+ emdadgarId +"' ");
                ctx.getForm().set("emdadgarId", emdadgarId);
            }

            isSarparast = false;
            if (ctx.isUserInRole(com.objectj.emdad.ejb.util.Constants.ROLE_SARPARASTEMDADGAR) || ctx.isUserInRole(com.objectj.emdad.ejb.util.Constants.ROLE_SUPERUSER)) {
                isSarparast = true;
                //=-= System.out.println("isSarparast = " + isSarparast);
                ctx.getRequest().setAttribute("role","sarparast");
                ctx.setForceFilter(" emdadgar.daftarOstaniId = 'S"+ ctx.getUserSession().getDaftarOstani()+"' ");
            }

            isAnbar = false;
            if (ctx.isUserInRole(com.objectj.emdad.ejb.util.Constants.ROLE_ANBAR)) {
                isAnbar = true;
                //=-= System.out.println("isAnbar = " + isAnbar);
                ctx.getRequest().setAttribute("role", "anbar");
				ctx.setForceFilter("darkhastQate.taeedShodehSarparast = 'I1' AND darkhastQate.manba = 'I1' ");
            }

			if (ctx.getForm().get(ACTION_TYPE) == null || ((String)ctx.getForm().get(ACTION_TYPE)).length() == 0 || ((String)ctx.getForm().get(ACTION_TYPE)).equals("create"))
            	ctx.getRequest().setAttribute("canChange", new Boolean(true));
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute("yesNoList", yesNo);
        ctx.getRequest().setAttribute("bazarAnbarList", bazarAnbarList);
        ctx.getRequest().setAttribute("emdadgarList", emdadgarList);
    }


    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                DarkhastQateModel vo = new DarkhastQateModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                vo.setSabtkonandeh(getUserId(ctx));

                if ((String) (ctx.getForm().get("tarikhDarkhast")) != null && ((String) (ctx.getForm().get("tarikhDarkhast"))).length() != 0)
                    vo.setTarikhDarkhast(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhDarkhast")))));

                ((DarkhastQateProxy) getProxy()).create(vo, (String) ctx.getForm().get("qateId"), (String) ctx.getForm().get("emdadgarId"));
            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("emdadgarId","");
        return listAll(ctx);
    }



    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullTarikhDarkhast = false;

        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);

        if (((DarkhastQateModel) (vo)).getTarikhDarkhast() == null) {
            ((DarkhastQateModel) (vo)).setTarikhDarkhast(new Date(0));
            isNullTarikhDarkhast = true;
        }
        ctx.getRequest().setAttribute("emdadgarName", ((DarkhastQateList)vo).getEmdadgarName());
        ctx.getRequest().setAttribute("manbaName", ((DarkhastQateList)vo).getManbaName());
        ctx.getRequest().setAttribute("taeedShodehSarparastName", ((DarkhastQateList)vo).getTaeedShodehSarparastName());

        ctx.getRequest().setAttribute("sabtkonandehName", ((DarkhastQateList)vo).getSabtkonandehName());
        //=-= System.out.println("((DarkhastQateList)vo).getSabtkonandehName() = " + ((DarkhastQateList) vo).getSabtkonandehName());
        try{
            if (((DarkhastQateModel)vo).getSabtkonandeh().equals(getUserId(ctx)))
                ctx.getRequest().setAttribute("canChange", new Boolean(true));
            else
                ctx.getRequest().setAttribute("canChange", new Boolean(false));
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());


        if (!isNullTarikhDarkhast)
            ctx.getForm().set("tarikhDarkhast", HejriUtil.chrisToHejri(((DarkhastQateModel) (vo)).getTarikhDarkhast()));
        else
            ctx.getForm().set("tarikhDarkhast", "");

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                DarkhastQateModel vo = new DarkhastQateModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhDarkhast")) != null && ((String) (ctx.getForm().get("tarikhDarkhast"))).length() != 0)
                    vo.setTarikhDarkhast(HejriUtil.toDate((String) (ctx.getForm().get("tarikhDarkhast"))));
                String qateId = (String)ctx.getForm().get("qateId");
                String emdadgarId = (String)ctx.getForm().get("emdadgarId");

                QueryObject qo = new QueryObject();
                qo.setTables("anbarEmdadgar");
                qo.setJoined(false);
                qo.setWhere(" emdadgarId = '" + emdadgarId + "' AND qateId = '" + qateId + "' ");

                ResultSet rs =  AnbarEmdadgarUtil.getLocalHome().advanceRead(ctx.getConnection(), qo);
                AnbarEmdadgarModel valueObject;

                if ((isAnbar && ((Integer)ctx.getForm().get("taeedShodeAnbar")).intValue() == 1) || (isSarparast && ((Integer)ctx.getForm().get("manba")).intValue() == 2 && ((Integer)ctx.getForm().get("taeedShodehSarparast")).intValue() == 1))  {
                    if (!rs.next()) {
                        AnbarEmdadgarList aml = new AnbarEmdadgarList();
                        aml.setMojoodi((Integer)ctx.getForm().get("tedadAnbar"));
                        aml.setEmdadgarId(emdadgarId);
                        aml.setQateId(qateId);
                        rs.close();
                        try{
                            String result = Validators.anbarEmdadgarValidator(ctx.getConnection(), aml, null);
                        }catch(Exception e){
                            //=-= System.out.println("after validation in action99999999999999999999");
                            ActionErrors errors = new ActionErrors();
                            errors.clear();
                            //=-= System.out.println("e.getMessage = " + e.getMessage());
                            //=-= System.out.println("e.toString() = " + e.toString());
                            errors.add("aa", new ActionError(e.getMessage()));
                            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, errors);
                            ctx.getForm().set("emdadgarId","");
                            return listAll(ctx);
                        }
                        AnbarEmdadgarSessionUtil.getLocalHome().create().create(aml, emdadgarId, qateId);
                    } else {
                        valueObject = (AnbarEmdadgarList)AnbarEmdadgarSessionUtil.getLocalHome().create().read(rs.getString("id"));
                        valueObject.setMojoodi(new Integer(((Integer)ctx.getForm().get("tedadAnbar")).intValue() + valueObject.getMojoodi().intValue()));
                        rs.close();
                        //=-= System.out.println("befor validation in actionnnnnnnnnnnnnnnnnnnnnnnn");
                        try{
                            String result = Validators.anbarEmdadgarValidator(ctx.getConnection(), (AnbarEmdadgarList)valueObject, null);
                        }catch(Exception e){
                            //=-= System.out.println("after validation in actionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
                            ActionErrors errors = new ActionErrors();
                            errors.clear();
                            //=-= System.out.println("e.getMessage = " + e.getMessage());
                            //=-= System.out.println("e.toString() = " + e.toString());
                            errors.add("aa", new ActionError(e.getMessage()));
                            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, errors);
                            ctx.getForm().set("emdadgarId","");
                            return listAll(ctx);
                        }
                    }
                }

                ((DarkhastQateProxy)getProxy()).update(vo, qateId, emdadgarId);

                if (isAnbar)
                    if (((Integer)ctx.getForm().get("taeedShodeAnbar")).intValue() == 1)
                        AnbarEmdadgarSessionUtil.getLocalHome().create().update(ctx.getForm().get("emdadgarId").toString(), ctx.getForm().get("qateId").toString(), new Integer(0 - ((Integer)ctx.getForm().get("tedadAnbar")).intValue()));

                if (isSarparast)
                    if (((Integer)ctx.getForm().get("manba")).intValue() == 2 && ((Integer)ctx.getForm().get("taeedShodehSarparast")).intValue() == 1)
                        AnbarEmdadgarSessionUtil.getLocalHome().create().update(ctx.getForm().get("emdadgarId").toString(), ctx.getForm().get("qateId").toString(), new Integer(((Integer)ctx.getForm().get("tedadSarparast")).intValue()));

            } catch (Exception e) {
                //=-= System.out.println("e.getMessage() = " + e.getMessage());
                ActionErrors errors = new ActionErrors();
                errors.clear();
                errors.add("aa", new ActionError(e.getMessage()));
                ctx.getRequest().setAttribute(DISPLAY_MESSAGE, errors);
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("emdadgarId","");
        return listAll(ctx);
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            DarkhastQateSessionLocal lProxy = DarkhastQateSessionUtil.getLocalHome().create();
            ValueObject voDarkhastQateList = lProxy.read(id);

            ctx.getRequest().setAttribute("sabtkonandehName", ((DarkhastQateList)voDarkhastQateList).getSabtkonandehName());
            ctx.getRequest().setAttribute(VALUE_OBJECT, voDarkhastQateList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }



    protected String getForceFilter(BaseActionContext ctx){
        return ctx.getForceFilter();
    }

    protected String getForceForwardTo(BaseActionContext ctx) {
        return ctx.getForceForwardTo();
    }

    protected void doFilterPreProcessor(BaseActionContext ctx) {
        if (ctx.getForm().get("qateName") != null && ((String)ctx.getForm().get("qateName")).length() != 0)
            ctx.getForm().set("qate.name", ctx.getForm().get("qateName"));
        else
            ctx.getForm().set("qate.name", null);

        ctx.getForm().set("qateName", null);
    }
}

