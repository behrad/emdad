package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.ServletException;
import javax.ejb.RemoveException;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.Date;
import java.io.File;

/**
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/c/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.edit.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/r/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.read.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/u/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.edit.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/d/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.read.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/l/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdadList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.list.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.list"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/c/validatemostanadatRokhdad"
 *      pathPrime="/validatemostanadatRokhdad"
 *      scope="request"
 *      input="/c/mostanadatRokhdad.run"
 *      inputPrime="emdad.mostanadatRokhdad.edit"
 *      input4tiles="emdad.mostanadatRokhdad.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/u/validatemostanadatRokhdad"
 *      pathPrime="/validatemostanadatRokhdad"
 *      scope="request"
 *      input="/u/mostanadatRokhdad.run"
 *      inputPrime="emdad.mostanadatRokhdad.edit"
 *      input4tiles="emdad.mostanadatRokhdad.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/s/mostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.doupload.jsp"
 *      inputPrime="emdad.mostanadatRokhdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mostanadatRokhdadForm"
 *      path="/s/validatemostanadatRokhdad"
 *      pathPrime="/mostanadatRokhdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.edit.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.edit.jsp"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.mostanadatRokhdad.list"
 *      pathPrime="emdad.mostanadatRokhdad.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.mostanadatRokhdad.edit"
 *      pathPrime="emdad.mostanadatRokhdad.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.mostanadatRokhdad.read"
 *      pathPrime="emdad.mostanadatRokhdad.read"
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
 *      name="requpload"
 *      path="emdad.mostanadatRokhdad.requpload"
 *      pathPrime="emdad.mostanadatRokhdad.requpload"
 *
 * @struts.action-forward
 *      name="tasvieHesabList"
 *      path="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.list.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.list.jsp"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 *
 * @struts.action-forward
 *      name="mostanadatRokhdadShow"
 *      path="/com/objectj/emdad/jsp/mostanadatRokhdad.show.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/mostanadatRokhdad.show.jsp"
 *
 * @struts.action-forward
 *      name="tasvieHesabEdit"
 *      path="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.edit.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.edit.jsp"
 *
 * @struts.action-forward
 *      name="tasvieHesabReqUpload"
 *      path="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.requpload.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/mostanadatRokhdad.tasvieHesab.requpload.jsp"
 *
 * @struts.action-forward
 *      name="refresh"
 *      path="/com/objectj/emdad/jsp/refresh.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/refresh.jsp"
 *
 */

public class MostanadatRokhdadAction extends BaseAction {
    static final int HAS_ACCESS = 1;
    static final int DONT_HAS_ACCESS = 1;

    protected Class getValueObjectClass() {
        return MostanadatRokhdadModel.class;
    }
    protected String[] getRelatedEntities() {
        return new String[]{"rokhdad"};
    }
    protected String[] getSortableColumns() {
        return new String[]{"mostanadatRokhdadId", "rokhdadId", "shomarehSanad", "daftarOstaniId"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MostanadatRokhdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getForceFilter(BaseActionContext ctx) {
        String filter = "";
//        log.info("~~~~~~~~~~~~~~~~~~~~~all access: " + ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess());
        if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess()) {
//            log.info("~~~~~~~~~~~ oomad to !all access");
            filter = " mostanadatRokhdad.daftarOstaniId = 'S" + ctx.getUserSession().getDaftarOstani() + "' ";
        }
        if ( ctx.getUserSession().getForceFilter(ctx.getEntity()) != null) {
            if (filter.length()>0)
                filter += " AND ";
            filter += ctx.getUserSession().getForceFilter(ctx.getEntity());
        }
        return filter;
    }

    protected void doFilterPreProcessor(BaseActionContext ctx) {
        ctx.getForm().set("rokhdad.daftarOstaniId", ctx.getForm().get("daftarOstaniId"));
        ctx.getForm().set("rokhdad.rokhdadId", ctx.getForm().get("rokhdadRokhdadId"));
        ctx.getForm().set("rokhdadRokhdadId", "");


       /* QueryObject qo =  new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(100);
        qo.setTables("rokhdad");
        qo.setJoined(false);
        ctx.getForm().set("rokhdadRokhdadId", ctx.getForm().get("rokhdadId"));
        try{
            if (ctx.getForm().get("rokhdadId") != null){
                qo.setWhere(" rokhdadId='" + ctx.getForm().get("rokhdadId").toString().trim()+"' ");
                ResultSet rs = RokhdadUtil.getLocalHome().advanceRead(qo);
                if (rs.next()){
                    String s = rs.getString("id");
                    //=-= System.out.println("rs.getString" + s);
                    ctx.getForm().set("rokhdadId", rs.getString("id"));
                }
            }
            } catch (Exception e){

            }
         */
    }


    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
          String id = (String) ctx.getForm().get(ValueObject.ID);
          if (id == null)
              throw new ServletException(NULL_ID_MESSAGE);
          try {

              com.objectj.emdad.proxy.MostanadatRokhdadSessionLocalHome lhProxy = com.objectj.emdad.proxy.MostanadatRokhdadSessionUtil.getLocalHome();
              com.objectj.emdad.proxy.MostanadatRokhdadSessionLocal lProxy = lhProxy.create();
              ValueObject voMostanadatRokhdadList = lProxy.read(id);

              if (((MostanadatRokhdadModel) (voMostanadatRokhdadList)).getTarikhSanad() != null)
                 ctx.getRequest().setAttribute("tarikhSanad", HejriUtil.chrisToHejri(((MostanadatRokhdadModel) (voMostanadatRokhdadList)).getTarikhSanad()));
             else
                 ctx.getRequest().setAttribute("tarikhSanad", "");

              if (((MostanadatRokhdadModel) (voMostanadatRokhdadList)).getTarikhSabt() != null)
                 ctx.getRequest().setAttribute("tarikhSabt", HejriUtil.chrisToHejri(((MostanadatRokhdadModel) (voMostanadatRokhdadList)).getTarikhSabt()));
             else
                 ctx.getRequest().setAttribute("tarikhSabt", "");

              ctx.getRequest().setAttribute(VALUE_OBJECT, voMostanadatRokhdadList);

          } catch (Exception e) {
              e.printStackTrace();
              throw new ProxyException(e);
          }

          return ctx.getActionMapping().findForward("read");
      }



   protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
//       ArrayList rokhdadList = new ArrayList();
       ArrayList daftarOstaniList = new ArrayList();
       try {

//           rokhdadList = DaftarOstaniSessionUtil.getLocalHome().create().readCombo("rokhdad", "rokhdadId").getResult();

           daftarOstaniList = ComboPool.getCombo("daftarOstani");

       } catch (Exception e) {
           e.printStackTrace(System.out);
           throw new ProxyException(e);
       }


//       ctx.getRequest().setAttribute("rokhdadList", rokhdadList);
       ctx.getRequest().setAttribute("daftarOstaniList", daftarOstaniList);

   }


   protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
       if (!isCancelled(ctx.getRequest())) {
           try {
               MostanadatRokhdadModel vo = new MostanadatRokhdadModel();
               Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
               if ((String) (ctx.getForm().get("tarikhSanad")) != null && ((String) (ctx.getForm().get("tarikhSanad"))).length() != 0)
                   vo.setTarikhSanad(HejriUtil.toDate((String) (ctx.getForm().get("tarikhSanad"))));
               if ((String) (ctx.getForm().get("tarikhSanad")) != null && ((String) (ctx.getForm().get("tarikhSanad"))).length() != 0)
                   vo.setTarikhSanad(HejriUtil.toDate((String) (ctx.getForm().get("tarikhSanad"))));
               java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
               vo.setTarikhSabt(date);
               log.info("~~~~~~~~~~ rokhdadId: " + ctx.getForm().get("rokhdadId"));
               vo = (MostanadatRokhdadModel) ((MostanadatRokhdadProxy)getProxy()).create(vo, (String)ctx.getForm().get("rokhdadId"));
               ctx.getRequest().setAttribute("mostanadatRokhdadId", vo.getId());
               ActionErrors error = new ActionErrors();
               error.clear();
               error.add("mostanadatRokhdadId", new ActionError("mostanadat.new.mostanadat", vo.getMostanadatRokhdadId()));
               ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                return ctx.getActionMapping().findForward("requpload");
           } catch (Exception e) {
               e.printStackTrace(System.out);
               throw new ProxyException(e);
           }
       }
       return listAll(ctx);
   }

   protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
       String id = (String)ctx.getForm().get(ValueObject.ID);
       if (id == null)
           throw new ServletException(NULL_ID_MESSAGE);

       ValueObject valueObject = getProxy().read(id);

       boolean isNullSanad = false;
       boolean isNullSabt = false;
       if (((MostanadatRokhdadModel) (valueObject)).getTarikhSanad() == null) {
            ((MostanadatRokhdadModel) (valueObject)).setTarikhSanad(new Date(0));
            isNullSanad = true;
        }
       if (((MostanadatRokhdadModel) (valueObject)).getTarikhSabt() == null) {
            ((MostanadatRokhdadModel) (valueObject)).setTarikhSabt(new Date(0));
            isNullSabt = true;
        }

       Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
       try{
           MostanadatRokhdadLocal mostanadatRokhdadLocal = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(id);
           ctx.getForm().set("rokhdadRokhdadId", mostanadatRokhdadLocal.getRokhdad().getRokhdadModel().getRokhdadId().toString());
       } catch(Exception e){

       }
        DaftarOstaniModel daftarOstaniModel = null;
        try {
            daftarOstaniModel = (DaftarOstaniModel)DaftarOstaniSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("daftarOstaniId"));
        }
        catch (Exception e) {
        }
        ctx.getRequest().setAttribute("daftarOstaniName", daftarOstaniModel.getName());
       if (!isNullSanad)
           ctx.getForm().set("tarikhSanad", HejriUtil.chrisToHejri(((MostanadatRokhdadModel) (valueObject)).getTarikhSanad()));
       else
          ctx.getForm().set("tarikhSanad", "");

       if (!isNullSabt){
           ctx.getForm().set("tarikhSabt", HejriUtil.chrisToHejri(((MostanadatRokhdadModel) (valueObject)).getTarikhSabt()));
           ctx.getRequest().setAttribute("tarikhSabt",HejriUtil.chrisToHejri(((MostanadatRokhdadModel) (valueObject)).getTarikhSabt()));
       }
       else
         ctx.getForm().set("tarikhSabt", "");



       ctx.getRequest().setAttribute(FORM, ctx.getForm());
       ctx.getForm().set(ACTION_TYPE, "update");

       return ctx.getActionMapping().findForward("edit");
   }

   protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
       if (!isCancelled(ctx.getRequest())) {
           try {
               MostanadatRokhdadModel vo = new MostanadatRokhdadModel();

               Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
               ctx.getForm().set("nameParvande", vo.getNameParvande());
               if ((String) (ctx.getForm().get("tarikhSanad")) != null && ((String) (ctx.getForm().get("tarikhSanad"))).length() != 0)
                    vo.setTarikhSanad(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhSanad")))));

                    vo.setTarikhSabt(HejriUtil.toDate(((String) (ctx.getForm().get("tarikhSabt")))));

               ((MostanadatRokhdadProxy) getProxy()).update(vo, (String)ctx.getForm().get("rokhdadId"));
               ctx.getRequest().setAttribute("mostanadatRokhdadId", vo.getId());
           } catch (Exception e) {
               e.printStackTrace();
               throw new ProxyException(e);
           }
       }
       return listAll(ctx);
   }

   protected ActionForward doDeleteByIdList(BaseActionContext ctx) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        // when you selected a list of VALUE_OBJECT_LIST
        String[] ids = (String[]) ctx.getForm().get(SELECTED_ITEMS);
        if (ids == null) {
            throw new ServletException(NULL_ID_MESSAGE);
        }
        for(int index = 0; index != ids.length; index++) {
            try {
                String nameParvande = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(ids[index]).getMostanadatRokhdadModel().getNameParvande();
                if (nameParvande != null){
                    int indexSlash = nameParvande.lastIndexOf('/');
                    nameParvande = nameParvande.substring(indexSlash, nameParvande.length());
                    File file = new File(com.objectj.emdad.web.util.Util.getUrl() +   "\\" + nameParvande);
                    file.delete();
                }
            }
            catch(Exception e){
            }
            try {
                MostanadatRokhdadUtil.getHome().findByPrimaryKey(ids[index]).remove();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listAll(ctx);
    }

   protected ActionForward doSpecificFromError(BaseActionContext ctx) {
       if (ctx.getForm().get(ACTION_TYPE).equals("tasvieHesabCreate") || ctx.getForm().get(ACTION_TYPE).equals("tasvieHesabUpdate"))
           return ctx.getActionMapping().findForward("tasvieHesabEdit");
       return listAll(ctx);
   }

   protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
      if (ctx.getSubAction().equals("uploaded")) {
          if (! isCancelled(ctx.getRequest())){
              String mostanadatRokhdadId = (String)ctx.getForm().get("id");
              boolean fromPopUp = false;
              if ((ctx.getForm().get("fromPopUp").equals("true")))
                  fromPopUp = true;

              String nameParvande = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(mostanadatRokhdadId).getMostanadatRokhdadModel().getNameParvande();
              if (nameParvande != null && nameParvande.length()!= 0){
                  int indexSlash = nameParvande.lastIndexOf('/');
                  nameParvande = nameParvande.substring(indexSlash, nameParvande.length());
                  File file = new File(com.objectj.emdad.web.util.Util.getUrl() +   "\\" + nameParvande);
                  file.delete();
              }
              nameParvande = (String)ctx.getForm().get("nameParvande");
              MostanadatRokhdadLocal mr = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(mostanadatRokhdadId);
              MostanadatRokhdadModel mm = mr.getMostanadatRokhdadModel();
              mm.setNameParvande(nameParvande);
              mr.setMostanadatRokhdadModel1(mm);
              if (fromPopUp)
                  return ctx.getActionMapping().findForward("closeAndRefresh");
              else
                  return listAll(ctx);
          }
      }

      else if (ctx.getSubAction().equals("upload")){
          String id = ctx.getRequest().getParameter("mostanadatRokhdadId");
          boolean fromPopUp = false;
          if ((ctx.getRequest().getParameter("fromPopUp").equals("true")))
              fromPopUp = true;

          ctx.getRequest().setAttribute("mostanadatRokhdadId", id);
          MostanadatRokhdadModel mostanadatRokhdadModel = MostanadatRokhdadUtil.getLocalHome().findByPrimaryKey(id).getMostanadatRokhdadModel();
          String nameParvande = mostanadatRokhdadModel .getNameParvande();
          String nameSanad = mostanadatRokhdadModel .getNameSanad();
          ctx.getRequest().setAttribute("nameParvande", nameParvande);
          ctx.getRequest().setAttribute("nameSanad", nameSanad);
          ctx.getRequest().setAttribute("showCancel", new String("showCancel"));
          if (fromPopUp)
              return ctx.getActionMapping().findForward("tasvieHesabReqUpload");
          else
              return ctx.getActionMapping().findForward("requpload");
      }

      else if (ctx.getSubAction().equals("tasvieHesabList")){
          String emdadId = (String)ctx.getForm().get(ValueObject.ID);
          int id = 0;
          try {
              id = Integer.parseInt(emdadId);
          } catch (NumberFormatException e) {
              return ctx.getActionMapping().findForward("showNotFound");
          }

          emdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId");
          if (emdadId  == null)
              return ctx.getActionMapping().findForward("showNotFound");
          String rokhdadId = UserAccessEntity.stringQuery ("SELECT rokhdadId FROM emdad WHERE id = '" + emdadId + "'", "rokhdadId");

          if (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI)) {
              String emdadgarId = UserAccessEntity.stringQuery("SELECT emdadgarId  FROM emdad WHERE id = '" + emdadId + "'", "emdadgarId");
              if ( com.objectj.emdad.ejb.util.Util.isEmpty(emdadgarId) || !emdadgarId.equals(UserAccessEntity.getEntityId(ctx.getUserSession().getName())))
                  return ctx.getActionMapping().findForward("accessDenied");
          }
          else if (!ctx.getUserSession().getEntityAccess(ctx.getEntity()).getAllAccess()){
              String daftarOstaniId = UserAccessEntity.stringQuery("SELECT daftarOstaniId FROM rokhdad WHERE id = '" + rokhdadId + "'", "daftarOstaniId");
              if(!daftarOstaniId.equals(ctx.getUserSession().getDaftarOstani()))
                  return ctx.getActionMapping().findForward("accessDenied");
          }

          if (rokhdadId == null)
              return ctx.getActionMapping().findForward("showNotFound");
          String rokhdadRokhdadId = UserAccessEntity.stringQuery ("SELECT rokhdadId FROM rokhdad WHERE id = '" + rokhdadId + "'", "rokhdadId");
          ctx.getRequest().setAttribute("rokhdadRokhdadId", rokhdadRokhdadId);
//          ctx.getRequest().setAttribute("canEdit", new Boolean(ctx.isUserInRole(Constants.ROLE_MALIOP)));
          return doTemporarySpecific(ctx, " mostanadatRokhdad.rokhdadIdO = 'S" + rokhdadId + "' ", "tasvieHesabList");
      }

      else if (ctx.getSubAction().equals("mostanadatRokhdadShow")) {
              String mostanadatRokhdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.MostanadatRokhdadModel", (String)ctx.getForm().get(ValueObject.ID), "mostanadatRokhdad", "mostanadatRokhdadId");
              if (mostanadatRokhdadId != null) {
                  ctx.getForm().set(ValueObject.ID , mostanadatRokhdadId);
              } else {
                  return ctx.getActionMapping().findForward("showNotFound");
              }
          doReadById(ctx);
          return ctx.getActionMapping().findForward("mostanadatRokhdadShow");
      }

      else if (ctx.getSubAction().equals("tasvieHesabCreate")) {
          String rokhdadId = Util.getIdWithO(ctx.getConnection(), "com.objectj.emdad.ejb.RokhdadModel", (String)ctx.getForm().get(ValueObject.ID), "rokhdad", "rokhdadId");
          String rokhdadRokhdadId = UserAccessEntity.stringQuery ("SELECT rokhdadId FROM rokhdad WHERE id = '" + rokhdadId + "'", "rokhdadId");
          //String rokhdadId = UserAccessEntity.stringQuery ("SELECT rokhdad.rokhdadId as rokhdadRokhdadId FROM emdad JOIN rokhdad ON emdad.rokhdadId = rokhdad.id WHERE emdad.id = '" + emdadId + "'", "rokhdadRokhdadId");
          ctx.getForm().set(ACTION_TYPE, "create");
          ctx.getForm().set("rokhdadRokhdadId", rokhdadRokhdadId);
          ctx.getForm().set(ID, null);
          return ctx.getActionMapping().findForward("tasvieHesabEdit");
      }

      else if (ctx.getSubAction().equals("tasvieHesabUpdate")) {
          //ctx.getForm().set(ACTION_TYPE, "update");
          doEditById(ctx);
          return ctx.getActionMapping().findForward("tasvieHesabEdit");
      }

      else if (ctx.getSubAction().equals("doTasvieHesabCreate")) {
          doCreate(ctx);
          return ctx.getActionMapping().findForward("closeAndRefresh");
      }

      else if (ctx.getSubAction().equals("doTasvieHesabUpdate")) {
          doUpdate(ctx);
          return ctx.getActionMapping().findForward("closeAndRefresh");
      }

      else if (ctx.getSubAction().equals("doTasvieHesabDelete")) {
          log.info("~~~~~~~~~~ oomad too delete.");
          doDeleteByIdList(ctx);
          return ctx.getActionMapping().findForward("refresh");
      }

      return listAll(ctx);
    }
}
