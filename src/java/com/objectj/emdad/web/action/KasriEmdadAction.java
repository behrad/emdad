package com.objectj.emdad.web.action;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;

import java.util.ArrayList;
import java.rmi.RemoteException;

/**
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/c/kasriEmdad"
 *      pathPrime="/kasriEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.edit.jsp"
 *      inputPrime="emdad.kasriEmdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/r/kasriEmdad"
 *      pathPrime="/kasriEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.read.jsp"
 *      inputPrime="emdad.kasriEmdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/u/kasriEmdad"
 *      pathPrime="/kasriEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.edit.jsp"
 *      inputPrime="emdad.kasriEmdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/d/kasriEmdad"
 *      pathPrime="/kasriEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.read.jsp"
 *      inputPrime="emdad.kasriEmdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/l/kasriEmdad"
 *      pathPrime="/kasriEmdadList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.list.jsp"
 *      inputPrime="emdad.kasriEmdad.list"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/c/validatekasriEmdad"
 *      pathPrime="/validatekasriEmdad"
 *      scope="request"
 *      input="/c/kasriEmdad.run"
 *      inputPrime="emdad.kasriEmdad.edit"
 *      input4tiles="emdad.kasriEmdad.edit"
 *      validate="true"
 * 
 * @struts.action
 *      name="filterKasriEmdadForm"
 *      path="/l/filterkasriEmdad"
 *      pathPrime="/filterkasriEmdad"
 *      scope="request"
 *      input="/l/kasriEmdad.run"
 *      inputPrime="emdad.kasriEmdad.edit"
 *      input4tiles="emdad.kasriEmdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/u/validatekasriEmdad"
 *      pathPrime="/validatekasriEmdad"
 *      scope="request"
 *      input="/u/kasriEmdad.run"
 *      inputPrime="emdad.kasriEmdad.edit"
 *      input4tiles="emdad.kasriEmdad.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="kasriEmdadForm"
 *      path="/s/kasriEmdad"
 *      pathPrime="/kasriEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/kasriEmdad.edit.jsp"
 *      inputPrime="emdad.emdad.read"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.kasriEmdad.list"
 *      pathPrime="emdad.kasriEmdad.list"
 *
 * @struts.action-forward
 *      name="kasriAuto"
 *      path="/com/objectj/emdad/jsp/kasriEmdad.auto.jsp"
 *      pathPrime="emdad.kasriEmdadAuto.jsp"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.kasriEmdad.edit"
 *      pathPrime="emdad.kasriEmdad.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.kasriEmdad.read"
 *      pathPrime="emdad.kasriEmdad.read"
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
 *      name="refresh"
 *      path="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 */

public class KasriEmdadAction extends BaseAction {
    protected Class getValueObjectClass() {
        return KasriEmdadModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"kasriId", "emdadgarId", "name" , "tarikh"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KasriEmdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String[] getRelatedEntities() {
        return new String[] {"emdadgar"};
    }


    protected ActionForward doDeleteById(BaseActionContext ctx) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        getProxy().remove(id);
        ComboPool.setDirty(ctx.getEntity());
        try {
            Util.updateQuery("delete from jozeatKasri where kasriId='"+id+"'",ctx.getConnection());
        } catch (Exception e) {
            log.error("error",e);
        }
        return listAll(ctx);
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                KasriEmdadModel vo = new KasriEmdadModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                if ((String) (ctx.getForm().get("tarikh")) != null && ((String) (ctx.getForm().get("tarikh"))).length() != 0)
                    vo.setTarikh(HejriUtil.toDate(((String) (ctx.getForm().get("tarikh")))));
                ((KasriEmdadProxy) getProxy()).create(vo, (String)ctx.getForm().get("emdadgarId"));
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("emdadgarId", "");
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest()) && (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI) || ctx.isUserInRole(Constants.ROLE_ANBAR))) {
            try {
                KasriEmdadModel vo = new KasriEmdadModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty((String) (ctx.getForm().get("tarikh"))) )
                    vo.setTarikh(HejriUtil.toDate(((String) (ctx.getForm().get("tarikh")))));
                ((KasriEmdadProxy) getProxy()).update(vo, (String)ctx.getForm().get("emdadgarId"));
                ComboPool.setDirty(ctx.getEntity());
                boolean isEmdadgar = ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI) ;
                int i = 0;
                String id = ctx.getRequest().getParameter( "id" + i );
                while( com.objectj.emdad.ejb.util.Util.isNotEmpty(id)) {
                    String t = ctx.getRequest().getParameter( "tedad" + i );
                    Integer tedad = Integer.valueOf( ( t==null || t.length() == 0 ) ? "0" : t );
                    QueryObject qo = new QueryObject("jozeatKasri", "","",false);
                    qo.setWhere("id='"+id+"'");
                    JozeatKasriModel jm = (JozeatKasriModel) ((JozeatKasriSessionUtil.getLocalHome().create()).readModel(qo).getResult()).get(0);
                    jm.setTedadEmdadgar(tedad);
                    if (!isEmdadgar) {
//                        jm.setTedadEmdadgar(tedad);
//                  }  else {
                        jm.setTedadAnbar(tedad);
//                        jm.setTedadEmdadgar();
                    }
                    (JozeatKasriSessionUtil.getLocalHome().create()).update(jm);

                    // Update Anbar Emdadgar
                    if (isEmdadgar && vo.getTaeedEmdadgar().intValue()==1) {
                        String qId = UserAccessEntity.stringQuery("select qateId from jozeatKasri where id='"+id+"'","qateId",ctx.getConnection());
                        (AnbarEmdadgarSessionUtil.getLocalHome().create()).update((String)ctx.getForm().get("emdadgarId"), qId, tedad);
                    }
                    i++;
                    id = ctx.getRequest().getParameter( "id" + i );
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

    protected ArrayList getJozeatKasriList(BaseActionContext ctx, String id) {
        QueryObject qo2 = new QueryObject("view_jozeatKasri", "view_jozeatKasri", "shomareFanni", false);
        qo2.setSelectFields("id,shomareFanni,qateName,tedadKasri,tedadAnbar,tedadEmdadgar");
        qo2.setTables("view_jozeatKasri");
        qo2.setWhere("kasriEmdadId='"+id+"'");
        return Exchanger.exhangeResultSetToValueObjectArray(ctx.getConnection(), qo2, null, new JozeatKasriList(), false).getResult();
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        ValueObject vo = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        if (((KasriEmdadModel)(vo)).getTarikh() != null)
            ctx.getForm().set("tarikh",HejriUtil.chrisToHejri(((KasriEmdadModel)(vo)).getTarikh()));
        else
            ctx.getForm().set("tarikh", "");
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");

        ctx.getRequest().setAttribute(VALUE_OBJECT, vo);

        return ctx.getActionMapping().findForward("edit");
    }


    protected String getForceFilter(BaseActionContext ctx) {
//		log.info("beginning getForceFilter");
        String filter = ctx.getUserSession().getForceFilter(ctx.getEntity());
        try {
            if (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI)) {
                String emdadgarId = UserAccessEntity.getEntityId(ctx.getUserSession().getName());
                String s = " kasriEmdad.emdadgarId = 'S" + emdadgarId + "'";
                if (filter != null && filter.length() != 0) {
                    return filter += " AND "+s;
                } else {
                    return filter = s;
                }
            } else
                if (ctx.isUserInRole(Constants.ROLE_ANBAR))
                    return " kasriEmdad.daftarostaniId = 'S" + getDaftarOstani(ctx) + "' AND kasriEmdad.taeedEmdadgar <> 'I1' ";


        } catch (Exception e) {
            e.printStackTrace();
        }

        //=-= System.out.println("filter = " + filter);
//		log.info("end of 3 getForceFilter");

        return filter;
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        setOrderToXifIsEmpty(ctx, "DESC");
        ctx.getRequest().setAttribute("emdadgarList", ComboPool.getCombo("emdadgar"));
        ctx.getRequest().setAttribute("tahvilshodList", Util.getArrayList("yesNo"));
        ctx.getRequest().setAttribute("taeedAnbardarList", Util.getArrayList("yesNo"));
        ctx.getRequest().setAttribute("taeedEmdadgarList", Util.getArrayList("yesNo"));
        try {
//            if (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) ||
//                ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI)) {
//                String emdadgarId = UserAccessEntity.getEntityId(ctx.getUserSession().getName());
//    //                ctx.setForceFilter(" kasriEmdad.emdadgarId = 'S" + emdadgarId + "'");
//                log.info("aaaaaaaaa");
//                ctx.getUserSession()..setSpecific(" kasriEmdad.emdadgarId = 'S" + emdadgarId + "'", "", "");
//            }
            if (ctx.getAction().indexOf("edit")!=-1 || ctx.getAction().indexOf("read")!=-1)
                ctx.getRequest().setAttribute(VALUE_OBJECT_LIST, getJozeatKasriList(ctx, (String)ctx.getForm().get(ValueObject.ID)));
            log.info("getFilter="+getFilter(ctx));
        } catch (Exception e) {
        }

    }

    private void doMakeKasri(BaseActionContext ctx, String emdadgarId, String noeEmdadgarId) throws Exception {
        if (com.objectj.emdad.ejb.util.Util.isEmpty(noeEmdadgarId) )
            noeEmdadgarId = UserAccessEntity.stringQuery("select noeEmdadgarId from emdadgar where id='"+emdadgarId+"'","noeEmdadgarId");
        QueryObject qo = new QueryObject("mojoodiMojaz", "", "", false);
        qo.setWhere("noeEmdadgarId='"+noeEmdadgarId+"'");
        qo.setSelectFields("qateId,tedad");
        qo.setToIndex(999999);
        ArrayList al = com.objectj.emdad.web.util.Util.advanceRead(qo);
        String kasriEmdadId = null;
        for (int i=0; i<al.size(); i++) {
            ArrayList al2 = (ArrayList) al.get(i);
//            log.info("al2.get(0)="+al2.get(0)+",al2.get(1)="+al2.get(1));
            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty((String) al2.get(0)) && al2.get(1)!=null ) {
                int qty = UserAccessEntity.intQuery("select mojoodi from anbarEmdadgar where emdadgarId='"+emdadgarId+"' AND qateId='"+al2.get(0)+"'", "mojoodi", ctx.getConnection());
//                log.info("qty="+qty);
//                if (qty!=0) {
                int tedad = ((Integer)al2.get(1)).intValue() ;
//                log.info("tedad="+tedad+",kasriEmdadId="+kasriEmdadId);
                if (qty<tedad) {
                    if (com.objectj.emdad.ejb.util.Util.isEmpty(kasriEmdadId)) {
                        KasriEmdadModel vo = new KasriEmdadModel();
                        vo.setTarikh(HejriUtil.getCurrentDate());
                        vo.setTahvilshod(new Integer(2));
                        vo.setTaeedAnbardar(new Integer(2));
                        vo.setTaeedEmdadgar(new Integer(2));
                        vo = (KasriEmdadModel) ((KasriEmdadProxy) getProxy()).create(vo, emdadgarId);
                        kasriEmdadId = vo.getId();
                    }
                    JozeatKasriModel jm = new JozeatKasriModel();
                    jm.setTedadKasri(new Integer(tedad-qty));
                    jm.setTedadAnbar(new Integer(tedad-qty));
                    jm.setTedadEmdadgar(new Integer(0));
                    (JozeatKasriSessionUtil.getLocalHome().create()).create(jm, kasriEmdadId, (String)al2.get(0));
                }
//                }
            }
        }
    }

    private void doMakeKasriGroup(BaseActionContext ctx, String emdadgarId, String noeEmdadgarId) throws Exception {
        QueryObject qo = new QueryObject("emdadgar", "", "", false);
        qo.setSelectFields("id");
        qo.setToIndex(999999);
        String w = "daftarOstaniId = '"+getDaftarOstani(ctx)+"' ";
        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(noeEmdadgarId)) {
            qo.setWhere(w+" AND noeEmdadgarId='"+noeEmdadgarId+"'");
        }
        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(emdadgarId)) {
            qo.setWhere(w+" AND id='"+emdadgarId+"'");
        }
        ArrayList emdadgarList = com.objectj.emdad.web.util.Util.advanceRead(qo);
        for (int i=0; i<emdadgarList.size(); i++) {
            ArrayList al = (ArrayList) emdadgarList.get(i);
            doMakeKasri(ctx, (String) al.get(0), noeEmdadgarId);
        }
    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if (ctx.getSubAction().equals("kasriAuto")) {
            ctx.getRequest().setAttribute("noeEmdadgarList", ComboPool.getCombo("noeEmdadgar"));
            ctx.getRequest().setAttribute("emdadgarList", ComboPool.getCombo("emdadgar", "daftarostaniId='"+getDaftarOstani(ctx)+"'"));
            return ctx.getActionMapping().findForward("kasriAuto");
        }
        else if (ctx.getSubAction().equals("kasriNoeEmdadgar")) {
            String noeEmdadgarId = (String) ctx.getForm().get("noeEmdadgarId");
//            log.info("noeEmdadgarId="+noeEmdadgarId);
            doMakeKasriGroup(ctx, null, noeEmdadgarId) ;
            return ctx.getActionMapping().findForward("refresh");
        }
        else if (ctx.getSubAction().equals("kasriEmdadgar")) {
            String emdadgarId = (String) ctx.getForm().get("emdadgarId");
//            log.info("emdadgarId="+emdadgarId);
            doMakeKasriGroup(ctx, emdadgarId, null) ;
            return ctx.getActionMapping().findForward("refresh");
        }
        return listAll(ctx);
    }
}
