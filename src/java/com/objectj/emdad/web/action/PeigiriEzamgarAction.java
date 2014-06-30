package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionErrors;

import javax.servlet.ServletException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/c/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/peigiriEzamgar.edit.jsp"
 *      inputPrime="emdad.peigiriEzamgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/r/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/peigiriEzamgar.read.jsp"
 *      inputPrime="emdad.peigiriEzamgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/u/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/peigiriEzamgar.edit.jsp"
 *      inputPrime="emdad.peigiriEzamgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/d/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/peigiriEzamgar.read.jsp"
 *      inputPrime="emdad.peigiriEzamgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/l/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgarList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/peigiriEzamgar.list.jsp"
 *      inputPrime="emdad.peigiriEzamgar.list"
 *      validate="false"
 *
 *  @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/s/peigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/emdad.list.jsp"
 *      inputPrime="emdad.emdad.list"
 *      validate="false"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/c/validatepeigiriEzamgar"
 *      pathPrime="/validatepeigiriEzamgar"
 *      scope="request"
 *      input="/c/peigiriEzamgar.run"
 *      inputPrime="emdad.peigiriEzamgar.edit"
 *      input4tiles="emdad.peigiriEzamgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/u/validatepeigiriEzamgar"
 *      pathPrime="/validatepeigiriEzamgar"
 *      scope="request"
 *      input="/u/peigiriEzamgar.run"
 *      inputPrime="emdad.peigiriEzamgar.edit"
 *      input4tiles="emdad.peigiriEzamgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="peigiriEzamgarForm"
 *      path="/s/validatepeigiriEzamgar"
 *      pathPrime="/peigiriEzamgar"
 *      scope="request"
 *      input="/s/peigiriEzamgar.run"
 *      inputPrime="s/peigiriEzamgar.run"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.peigiriEzamgar.list"
 *      pathPrime="emdad.peigiriEzamgar.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.peigiriEzamgar.edit"
 *      pathPrime="emdad.peigiriEzamgar.edit"
 *
 *  @struts.action-forward
 *      name="emdadPeygiriShow"
 *      path="/com/objectj/emdad/jsp/peigiriEzamgar.emdad.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/peigiriEzamgar.emdad.show.jsp"
 *  @struts.action-forward
 *      name="edit2"
 *      path="/com/objectj/emdad/jsp/peigiriEzamgar.edit2.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/peigiriEzamgar.edit2.jsp"
 *  @struts.action-forward
 *      name="confirm"
 *      path="/com/objectj/emdad/jsp/peigiriEzamgar.confirm.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/peigiriEzamgar.confirm.jsp"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.peigiriEzamgar.read"
 *      pathPrime="emdad.peigiriEzamgar.read"
 * @struts.action-forward
 *      name="thanks"
 *      path="/com/objectj/emdad/jsp/thanks.jsp"
 *      pathPrime="emdad.thanks"
 *
 * @struts.action-forward
 *      name="default"
 *      path="/util/genericPage.jsp"
 *      pathPrime="/util/genericPage.jsp"
 * @struts.action-forward
 *      name="peigiriShow"
 *      path="/com/objectj/emdad/jsp/peigiriEzamgar.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/peigiriEzamgar.show.jsp"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 *
 */

public class PeigiriEzamgarAction extends BaseAction {
    protected Class getValueObjectClass() {
        return PeigiriEzamgarModel.class;
    }

    protected Class getValueObjectClass2() {
        return PeigiriEzamgarList.class;
    }

    protected ActionForward doNullAction(BaseActionContext ctx) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        ctx.getForm().set("zamanPeigiri", HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
        ctx.getForm().set("zamanPeigiri2", HejriUtil.getCurrentTime());

        return ctx.getActionMapping().findForward("edit");
    }
    protected String[] getSortableColumns() {
        return new String[]{"zamanPeigiri", "emdadId"};
    }
     protected String[] getRelatedEntities() {
        return new String[]{"emdad"};
    }
    protected EntityProxy getProxy() throws ProxyException {
        try {
            return PeigiriEzamgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getForceFilter(BaseActionContext ctx) {
        if (ctx.isUserInRole("ezamgar"))
            try {
                return "emdad.ezamgarId = 'S" + getUserId(ctx) + "'";
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "";
    }

     protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
//       ArrayList emdadList = new ArrayList();
//       try {
//
//           emdadList = EmdadSessionUtil.getLocalHome().create().readCombo("emdad", "emdadId").getResult();
//       } catch (Exception e) {
//           e.printStackTrace(System.out);
//           throw new ProxyException(e);
//       }
//
//
//       ctx.getRequest().setAttribute("emdadList", emdadList);

   }
    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
       if (!isCancelled(ctx.getRequest())) {
           try {
               PeigiriEzamgarModel vo = new PeigiriEzamgarModel();
               Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
               vo.setZamanPeigiri(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("zamanPeigiri"), (String)ctx.getForm().get("zamanPeigiri2")));

               vo = (PeigiriEzamgarModel) ((PeigiriEzamgarProxy)getProxy()).create(vo, (String)ctx.getForm().get("emdadId"));

/*               ActionErrors error = new ActionErrors();
               error.clear();
               error.add("mostanadatRokhdadId", new ActionError("mostanadat.new.mostanadat", vo.getMostanadatRokhdadId()));
               ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);*/
           } catch (Exception e) {
               e.printStackTrace(System.out);
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


          com.objectj.emdad.proxy.PeigiriEzamgarSessionLocalHome lhProxy = com.objectj.emdad.proxy.PeigiriEzamgarSessionUtil.getLocalHome();
          com.objectj.emdad.proxy.PeigiriEzamgarSessionLocal lProxy = lhProxy.create();
          ValueObject voPeigiriEzamgarList = lProxy.read(id);

          if (((PeigiriEzamgarModel) (voPeigiriEzamgarList)).getZamanPeigiri() != null){
             ctx.getRequest().setAttribute("zamanPeigiri", HejriUtil.chrisToHejri(((PeigiriEzamgarModel) (voPeigiriEzamgarList)).getZamanPeigiri()));

             ctx.getRequest().setAttribute("zamanPeigiri2", HejriUtil.getTimeFromDate(new java.sql.Timestamp((((PeigiriEzamgarModel) (voPeigiriEzamgarList)).getZamanPeigiri()).getTime())));

          }else {
             ctx.getRequest().setAttribute("zamanPeigiri", "");
             ctx.getRequest().setAttribute("zamanPeigiri2", "");
         }

          ctx.getRequest().setAttribute(VALUE_OBJECT, voPeigiriEzamgarList);

      } catch (Exception e) {
          e.printStackTrace();
          throw new ProxyException(e);
      }

      return ctx.getActionMapping().findForward("read");
  }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
           String id = (String)ctx.getForm().get(ValueObject.ID);
           if (id == null)
               throw new ServletException(NULL_ID_MESSAGE);

           ValueObject valueObject = getProxy().read(id);

           boolean isNullSanad = false;
           if (((PeigiriEzamgarModel) (valueObject)).getZamanPeigiri() == null) {
                ((PeigiriEzamgarModel) (valueObject)).setZamanPeigiri(new Timestamp(0));
                isNullSanad = true;
           }

           Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
           try{
               PeigiriEzamgarLocal peigiriEzamgarLocal = PeigiriEzamgarUtil.getLocalHome().findByPrimaryKey(id);
               ctx.getForm().set("emdadEmdadId", peigiriEzamgarLocal.getEmdad().getEmdadModel().getEmdadId().toString());
               ctx.getForm().set("emdadVazeatKonuni",peigiriEzamgarLocal.getEmdad().getEmdadModel().getVazeatKonuni().toString());
           } catch(Exception e){
           }
           if (!isNullSanad){
               ctx.getForm().set("zamanPeigiri", HejriUtil.chrisToHejri(((PeigiriEzamgarModel) (valueObject)).getZamanPeigiri()));
               ctx.getForm().set("zamanPeigiri2", HejriUtil.getTimeFromDate(new java.sql.Timestamp((((PeigiriEzamgarModel) (valueObject)).getZamanPeigiri()).getTime())));
           }else{
              ctx.getForm().set("zamanPeigiri", "");
              ctx.getForm().set("zamanPeigiri2", "");
           }
           ctx.getRequest().setAttribute(FORM, ctx.getForm());
           ctx.getForm().set(ACTION_TYPE, "update");

           return ctx.getActionMapping().findForward("edit");
       }
     protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
       if (!isCancelled(ctx.getRequest())) {
           try {
               PeigiriEzamgarModel vo = new PeigiriEzamgarModel();

               Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

               if ((String) (ctx.getForm().get("zamanPeigiri")) != null && ((String) (ctx.getForm().get("zamanPeigiri"))).length() != 0)
                   vo.setZamanPeigiri(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("zamanPeigiri"), (String)ctx.getForm().get("zamanPeigiri2")));

               ((PeigiriEzamgarProxy) getProxy()).update(vo, (String)ctx.getForm().get("emdadId"));
               ctx.getRequest().setAttribute("peigiriEzamgarId", vo.getId());
           } catch (Exception e) {
               e.printStackTrace();
               throw new ProxyException(e);
           }
       }
       return listAll(ctx);
   }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
       String id = (String) ctx.getForm().get(ValueObject.ID);
       /*if (id == null || id.length() == 0){
           id = ctx.getRequest().getParameter("emdadId");
           ctx.getForm().set("id", id);
       } */
       if (ctx.getSubAction().equals("peigiriEdit")){
            ValueObject vo = newValueObject();
            Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
            String emdadId = ctx.getRequest().getParameter("emdadId");


//            PeigiriEzamgarList peigiriList = new PeigiriEzamgarList();
            ArrayList peigiriTmp = new ArrayList();
            QueryObject peigiriQuery = new QueryObject();
            peigiriQuery.setTables("view_PeigiriEzamgar");
            peigiriQuery.setWhere("emdadIdO = '" + emdadId+"'");
            peigiriQuery.setToIndex(10);
           ArrayList PeygiriArray = PeigiriEzamgarSessionUtil.getLocalHome().create().readList(peigiriQuery).getResult();
           ctx.getRequest().setAttribute("peigiriList", PeygiriArray);

/*           if (PeygiriArray != null && PeygiriArray.size() != 0)
               for (int i=0; i < PeygiriArray.size() ; i++)
                    peigiriTmp.add(PeygiriArray.get(i));

           ctx.getRequest().setAttribute("peigiriList", peigiriTmp);
*/
            ctx.getForm().set(ID, "");
            ctx.getForm().set(ACTION_TYPE, "specific,createPeigiri");
            ctx.getForm().set("zamanPeigiri", HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
            ctx.getForm().set("zamanPeigiri2", HejriUtil.getCurrentTime());

            return ctx.getActionMapping().findForward("edit2");

       }
       else if (ctx.getSubAction().equals("emdadpeigiriShow")){
             String emdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", (String) ctx.getForm().get(ValueObject.ID), "emdad", "emdadId");
//            PeigiriEzamgarList peigiriList = new PeigiriEzamgarList();
//             ArrayList peigiriTmp = new ArrayList();
             QueryObject peigiriQuery = new QueryObject();
             peigiriQuery.setTables("view_PeigiriEzamgar");
             peigiriQuery.setWhere("emdadIdO = '" + emdadId + "'");
             peigiriQuery.setToIndex(10);
             ArrayList PeygiriArray = PeigiriEzamgarSessionUtil.getLocalHome().create().readList(peigiriQuery).getResult();
             ctx.getRequest().setAttribute("peigiriList", PeygiriArray);

/*            if (PeygiriArray != null && PeygiriArray.size() != 0)
                for (int i=0; i < PeygiriArray.size() ; i++)
                     peigiriTmp.add(PeygiriArray.get(i));

            ctx.getRequest().setAttribute("peigiriList", peigiriTmp);

             ctx.getForm().set(ID, "");
             ctx.getForm().set(ACTION_TYPE, "specific,createPeigiri");
             ctx.getForm().set("zamanPeigiri", HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
             ctx.getForm().set("zamanPeigiri2", HejriUtil.getCurrentTime());*/

             return ctx.getActionMapping().findForward("emdadPeygiriShow");

        }
       else if (ctx.getSubAction().equals("createPeigiri")) {
           if (!isCancelled(ctx.getRequest())) {
           try {
//			   System.out.println( "OOmadim Bara CreatePeigiri" );
               PeigiriEzamgarForm form = (PeigiriEzamgarForm)ctx.getForm();
               ActionErrors aerr = form.validate(ctx.getActionMapping(), ctx.getRequest());
               if (!aerr.isEmpty()) {
//				   System.out.println( "Error!!!" );
                   ctx.getRequest().setAttribute(DISPLAY_MESSAGE,aerr);
                   String emdadId = ctx.getRequest().getParameter("emdadId");
//                   System.out.println( "EmdadId= " + emdadId );
                   ArrayList peigiriTmp = new ArrayList();
                   QueryObject peigiriQuery = new QueryObject();
                   peigiriQuery.setTables("view_PeigiriEzamgar");
				   peigiriQuery.setWhere("emdadIdO = '" + emdadId+"'");
				   peigiriQuery.setToIndex(10);
				   ArrayList PeygiriArray = PeigiriEzamgarSessionUtil.getLocalHome().create().readList(peigiriQuery).getResult();
				   ctx.getRequest().setAttribute("peigiriList", PeygiriArray);

                   if (PeygiriArray != null && PeygiriArray.size() != 0)
                       for (int i=0; i < PeygiriArray.size() ; i++) {
                            peigiriTmp.add(PeygiriArray.get(i));
                       }

                   ctx.getRequest().setAttribute("peigiriList", peigiriTmp);

                   ctx.getForm().set(ID, "");
                   return ctx.getActionMapping().findForward("edit2");
               }
               PeigiriEzamgarModel vo = new PeigiriEzamgarModel();
               ctx.getForm().set("emdadId", (String)(ctx.getRequest().getParameter("emdadId")));
               ctx.getForm().set("emdadId", new String(ctx.getRequest().getParameter("emdadId")));
               ctx.getForm().set("emdadEmdadId", new Integer(ctx.getRequest().getParameter("emdadEmdadId")));
               Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
               vo.setZamanPeigiri(HejriUtil.convertToTimesatmp((String)ctx.getForm().get("zamanPeigiri"), (String)ctx.getForm().get("zamanPeigiri2")));
               vo.setEmdadEmdadId((Integer)ctx.getForm().get("emdadEmdadId"));

               vo = (PeigiriEzamgarModel) ((PeigiriEzamgarProxy)getProxy()).create(vo, (String)ctx.getForm().get("emdadId"));

               /*ActionErrors error = new ActionErrors();
               error.clear();
               error.add("peigiriEzamgarId", new ActionError("peigiriEzamgar.new.peigiriEzamgarId", vo.getPeigiriEzamgarId()));
               ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);*/

           } catch (Exception e) {
               log.error("error",e);
               throw new ProxyException(e);
           }
        }
        return ctx.getActionMapping().findForward("confirm");
       }  if (ctx.getSubAction().equals("peigiriShow")) {
           ctx.getForm().set(ValueObject.ID , Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", (String) ctx.getForm().get(ValueObject.ID), "emdad", "emdadId"));
           if ( ((String) ctx.getForm().get(ValueObject.ID))==null )
                   return ctx.getActionMapping().findForward("showNotFound");
           doReadById(ctx);
           return ctx.getActionMapping().findForward("peigiriShow");

       }
       return listAll(ctx);
   }
     protected void doFilterPreProcessor(BaseActionContext ctx) {
        if (ctx.getForm().get("emdadEmdadId") != null && ((Integer)ctx.getForm().get("emdadEmdadId")).intValue() != 0){
             ctx.getForm().set("emdad.emdadId", ctx.getForm().get("emdadEmdadId"));
            //=-= System.out.println("FORM.get = " + ctx.getForm().get("emdadEmdadId"));
        }
        else
            ctx.getForm().set("emdad.emdadId", null);

        ctx.getForm().set("emdadEmdadId", null);

     }

}
