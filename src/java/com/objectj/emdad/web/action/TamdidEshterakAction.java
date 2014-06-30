package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.ServletException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/c/tamdidEshterak"
 *      pathPrime="/tamdidEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/tamdidEshterak.edit.jsp"
 *      inputPrime="emdad.tamdidEshterak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/r/tamdidEshterak"
 *      pathPrime="/tamdidEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/tamdidEshterak.read.jsp"
 *      inputPrime="emdad.tamdidEshterak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/u/tamdidEshterak"
 *      pathPrime="/tamdidEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/tamdidEshterak.edit.jsp"
 *      inputPrime="emdad.tamdidEshterak.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/d/tamdidEshterak"
 *      pathPrime="/tamdidEshterak"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/tamdidEshterak.read.jsp"
 *      inputPrime="emdad.tamdidEshterak.read"
 *      validate="false"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/l/tamdidEshterak"
 *      pathPrime="/tamdidEshterakList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/tamdidEshterak.list.jsp"
 *      inputPrime="emdad.tamdidEshterak.list"
 *      validate="false"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/c/validatetamdidEshterak"
 *      pathPrime="/validatetamdidEshterak"
 *      scope="request"
 *      input="/c/tamdidEshterak.run"
 *      inputPrime="emdad.tamdidEshterak.edit"
 *      input4tiles="emdad.tamdidEshterak.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="tamdidEshterakForm"
 *      path="/u/validatetamdidEshterak"
 *      pathPrime="/validatetamdidEshterak"
 *      scope="request"
 *      input="/u/tamdidEshterak.run"
 *      inputPrime="emdad.tamdidEshterak.edit"
 *      input4tiles="emdad.tamdidEshterak.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.tamdidEshterak.list"
 *      pathPrime="emdad.tamdidEshterak.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.tamdidEshterak.edit"
 *      pathPrime="emdad.tamdidEshterak.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.tamdidEshterak.read"
 *      pathPrime="emdad.tamdidEshterak.read"
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

public class TamdidEshterakAction extends BaseAction {

    protected Class getValueObjectClass() {
        return TamdidEshterakModel.class;
    }

    protected Class getValueObjectClass2() {
        return TamdidEshterakList.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"tarikhAkharinTamdid", "eshterakId", "nameKhanevadegi", "name"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"moshtarak"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return TamdidEshterakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                TamdidEshterakModel vo = new TamdidEshterakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhAkharinTamdid")) != null && ((String) (ctx.getForm().get("tarikhAkharinTamdid"))).length() != 0)
                    vo.setTarikhAkharinTamdid(HejriUtil.toDate((String) (ctx.getForm().get("tarikhAkharinTamdid"))));

                QueryObject qo = new QueryObject();
                qo.setTables("moshtarak");
                qo.setFromIndex(0);
                qo.setToIndex(2);
                qo.setJoined(false);
                qo.setWhere("eshterakId='" + ctx.getForm().get("eshterakId") + "'");
                ArrayList moshtarakArray = MoshtarakSessionUtil.getLocalHome().create().readModel(qo).getResult();
                MoshtarakModel moshtarakModel = new MoshtarakModel();
                if (!moshtarakArray.isEmpty()) {

                    moshtarakModel = (MoshtarakModel) (moshtarakArray.get(0));
                    String moId = moshtarakModel.getId();
//                    MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(((MoshtarakModel) moshtarakArray.get(0)).getId());
//                    moshtarakModel = moshtarakLocal.getMoshtarakModel();

                    if (!vo.getTarikhAkharinTamdid().after(HejriUtil.getCurrentDate())) {
                        if (moshtarakModel.getTarikhEngheza().before(HejriUtil.incMonth(HejriUtil.getCurrentDate(),3))) {

                        moshtarakModel.setTarikhAkharinTamdid(vo.getTarikhAkharinTamdid());
                        if (vo.getTarikhAkharinTamdid().before(moshtarakModel.getTarikhEngheza()))
                            moshtarakModel.setTarikhEngheza(HejriUtil.incYear(moshtarakModel.getTarikhEngheza()));
                        else {
                            moshtarakModel.setVazeat(new Integer(2));
                            moshtarakModel.setTarikhEngheza(HejriUtil.incYear(vo.getTarikhAkharinTamdid()));
                        }


                        moshtarakModel.setMoshtarakYaNa(new Integer(1));
                        moshtarakModel.setHazinehPardakhtShodeh((Integer) (ctx.getForm().get("hazinehPardakhtShodeh")));
                        moshtarakModel.setTakhfif((Integer) (ctx.getForm().get("takhfif")));
                        moshtarakModel.setNaghd((Integer) (ctx.getForm().get("naghd")));
                        moshtarakModel.setTaahodi((Integer) (ctx.getForm().get("taahodi")));
                        moshtarakModel.setAghsat((Integer) (ctx.getForm().get("aghsat")));
                        moshtarakModel.setCheque((String) (ctx.getForm().get("cheque")));
                        moshtarakModel.setNoeService((Integer) (ctx.getForm().get("noeService")));
                        moshtarakModel.setMajaziYaNa(new Integer(2));                            

//                    String noeKhodroId = moshtarakLocal.getNoeKhodro().getId();
                        String ids[] = UserAccessEntity.stringQuerys("select shahrId, noeKhodroId, rangeKhodroId FROM Moshtarak WHERE id = '" + moId + "'", "shahrId, noeKhodroId, rangeKhodroId", ctx.getConnection());
                        String oldEshterakId = moshtarakModel.getEshterakId();
                        if (((Integer) (ctx.getForm().get("noeService"))).intValue() != 1 && oldEshterakId.length() < 10) {
                            Integer year = moshtarakModel.getSaleSakht();
                            String newEshterakId = UserAccessEntity.stringQuery("select dbo.NewEshterakId('" + ids[1] + "'," + year + ") as newEshterakId FROM DaftarOstani WHERE id = 'E08180808080808080o'", "newEshterakId");
                            if (newEshterakId != null)
                                moshtarakModel.setEshterakId(newEshterakId);
                            ActionErrors error = new ActionErrors();
                            error.clear();
                            error.add("eshterakId", new ActionError((newEshterakId == null) ? "tamdidEshterak.change.eshterakId.error" : "tamdidEshterak.change.newEshterakId", oldEshterakId, newEshterakId));
                            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                        }

                        (MoshtarakSessionUtil.getLocalHome().create()).update(moshtarakModel, ids[0], ids[1], ids[2], (String) (ctx.getForm().get("bazaryabId"))); //,
//                            (moshtarakLocal.getShahr() == null) ? null : moshtarakLocal.getShahr().getId(),
//                            noeKhodroId,
//                            (moshtarakLocal.getRangeKhodro() == null) ? null : moshtarakLocal.getRangeKhodro().getId(),
//                            (moshtarakLocal.getBazaryab() == null) ? null : moshtarakLocal.getBazaryab().getId());

                        // unset isLast for older requests
                        QueryObject qo0 = new QueryObject();
                        qo0.setTables("tamdidEshterak");
                        qo0.setFromIndex(0);
                        qo0.setToIndex(2);
                        qo0.setJoined(false);
                        qo0.setWhere("moshtarakId = '" + moshtarakModel.getId() + "' AND isLast = 1 ");
                        ArrayList tamdidEshterakArray = TamdidEshterakSessionUtil.getLocalHome().create().readModel(qo0).getResult();
                        TamdidEshterakModel tamdidEshterakModel = new TamdidEshterakModel();
                        if (!tamdidEshterakArray.isEmpty()) {
                            TamdidEshterakLocal tamdidEshterakLocal = TamdidEshterakUtil.getLocalHome().findByPrimaryKey(((TamdidEshterakModel) tamdidEshterakArray.get(0)).getId());
                            tamdidEshterakModel = tamdidEshterakLocal.getTamdidEshterakModel();
                            tamdidEshterakModel.setIsLast(new Integer(0));
                            ((TamdidEshterakProxy) getProxy()).update(tamdidEshterakModel, tamdidEshterakLocal.getMoshtarak().getId());
                        }
                        vo.setIsLast(new Integer(1));
                        /////////////////////////////////////

                        ((TamdidEshterakProxy) getProxy()).create(vo, moshtarakModel.getId());
                        } else {
                            ActionErrors error = new ActionErrors();
                            error.add("aaa", new ActionError("tamdidEshterak.date.afterXmonth.today", new Integer(3)));
                            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                            return ctx.getActionMapping().findForward("edit");
                        }
                    } else {
                        ActionErrors error = new ActionErrors();
                        error.add("aaa", new ActionError("tamdidEshterak.date.after.today", ctx.getForm().get("tarikhAkharinTamdid")));
                        ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                        return ctx.getActionMapping().findForward("edit");
                    }
                } else {
                    ActionErrors error = new ActionErrors();
                    error.add("aaa", new ActionError("notFound.EshterakId.report", ctx.getForm().get("eshterakId")));
                    ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                TamdidEshterakModel vo = new TamdidEshterakModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

                if ((String) (ctx.getForm().get("tarikhAkharinTamdid")) != null && ((String) (ctx.getForm().get("tarikhAkharinTamdid"))).length() != 0)
                    vo.setTarikhAkharinTamdid(HejriUtil.toDate((String) (ctx.getForm().get("tarikhAkharinTamdid"))));


                QueryObject qo = new QueryObject();
                qo.setTables("moshtarak");
                qo.setFromIndex(0);
                qo.setToIndex(2);
                qo.setJoined(false);
                qo.setWhere("eshterakId='" + ctx.getForm().get("eshterakId") + "'");
                ArrayList moshtarakArray = MoshtarakSessionUtil.getLocalHome().create().readModel(qo).getResult();
//                MoshtarakModel moshtarakModel = new MoshtarakModel();
                if (!moshtarakArray.isEmpty()) {
                    MoshtarakModel moshtarakModel = (MoshtarakModel) (moshtarakArray.get(0));
                    String moId = moshtarakModel.getId();

                    String ids[] = UserAccessEntity.stringQuerys("select shahrId, noeKhodroId, rangeKhodroId FROM Moshtarak WHERE id = '" + moId + "'", "shahrId, noeKhodroId, rangeKhodroId", ctx.getConnection());

//                    MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(moId);
//                    moshtarakModel = moshtarakLocal.getMoshtarakModel();

                    if (!vo.getTarikhAkharinTamdid().after(HejriUtil.getCurrentDate())) {

                        moshtarakModel.setTarikhAkharinTamdid(vo.getTarikhAkharinTamdid());
                        moshtarakModel.setTarikhEngheza(HejriUtil.incYear(vo.getTarikhAkharinTamdid()));

                        moshtarakModel.setHazinehPardakhtShodeh((Integer) (ctx.getForm().get("hazinehPardakhtShodeh")));
                        moshtarakModel.setTakhfif((Integer) (ctx.getForm().get("takhfif")));
                        moshtarakModel.setNaghd((Integer) (ctx.getForm().get("naghd")));
                        moshtarakModel.setTaahodi((Integer) (ctx.getForm().get("taahodi")));
                        moshtarakModel.setAghsat((Integer) (ctx.getForm().get("aghsat")));
                        moshtarakModel.setCheque((String) (ctx.getForm().get("cheque")));
                        moshtarakModel.setNoeService((Integer) (ctx.getForm().get("noeService")));
//                    String noeKhodroId = moshtarakLocal.getNoeKhodro().getId();
                        String oldEshterakId = moshtarakModel.getEshterakId();
                        if (moshtarakModel.getNoeService().intValue() != 1 && oldEshterakId.length() < 10) {
                            Integer year = moshtarakModel.getSaleSakht();
                            //   System.out.println(noeKhodroId+"*************"+year);
                            String newEshterakId = UserAccessEntity.stringQuery("select dbo.NewEshterakId('" + ids[1] + "'," + year + ") as newEshterakId FROM DaftarOstani WHERE id = 'E08180808080808080o'", "newEshterakId");
                            if (newEshterakId != null)
                                moshtarakModel.setEshterakId(newEshterakId);
                            ActionErrors error = new ActionErrors();
                            error.clear();
                            error.add("eshterakId", new ActionError((newEshterakId == null) ? "error.moshtarakId.createNew.error" : "tamdidEshterak.change.newEshterakId", oldEshterakId, newEshterakId));
                            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);

                        }

                        (MoshtarakSessionUtil.getLocalHome().create()).update(moshtarakModel, ids[0], ids[1], ids[2], (String) (ctx.getForm().get("bazaryabId"))); //,
//                    (MoshtarakSessionUtil.getLocalHome().create()).update(moshtarakModel); //,
//                            (moshtarakLocal.getShahr() == null) ? null : moshtarakLocal.getShahr().getId(),
//                            noeKhodroId,
//                            (moshtarakLocal.getRangeKhodro() == null) ? null : moshtarakLocal.getRangeKhodro().getId(),
//                            (moshtarakLocal.getBazaryab() == null) ? null : moshtarakLocal.getBazaryab().getId());


                        // unset isLast for older requests
                        QueryObject qo0 = new QueryObject();
                        qo0.setTables("tamdidEshterak");
                        qo0.setFromIndex(0);
                        qo0.setToIndex(2);
                        qo0.setJoined(false);
                        qo0.setWhere("moshtarakId = '" + moshtarakModel.getId() + "' AND isLast = 1 ");
                        ArrayList tamdidEshterakArray = TamdidEshterakSessionUtil.getLocalHome().create().readModel(qo0).getResult();
                        TamdidEshterakModel tamdidEshterakModel = new TamdidEshterakModel();
                        if (!tamdidEshterakArray.isEmpty()) {
                            TamdidEshterakLocal tamdidEshterakLocal = TamdidEshterakUtil.getLocalHome().findByPrimaryKey(((TamdidEshterakModel) tamdidEshterakArray.get(0)).getId());
                            tamdidEshterakModel = tamdidEshterakLocal.getTamdidEshterakModel();
                            tamdidEshterakModel.setIsLast(new Integer(0));
                            ((TamdidEshterakProxy) getProxy()).update(tamdidEshterakModel, tamdidEshterakLocal.getMoshtarak().getId());
                        }
                        vo.setIsLast(new Integer(1));
                        /////////////////////////////////////

                        ((TamdidEshterakProxy) getProxy()).update(vo, moshtarakModel.getId());

                    } else {
                        ActionErrors error = new ActionErrors();
                        error.add("aaa", new ActionError("tamdidEshterak.date.after.today", ctx.getForm().get("tarikhAkharinTamdid")));
                        ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                        return ctx.getActionMapping().findForward("edit");
                    }
                } else {
                    ActionErrors error = new ActionErrors();
                    error.add("aaa", new ActionError("notFound.EshterakId.report", ctx.getForm().get("eshterakId")));
                    ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                }
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
            TamdidEshterakSessionLocal lProxy = TamdidEshterakSessionUtil.getLocalHome().create();
            ValueObject vo = lProxy.read(id);

            ctx.getRequest().setAttribute(VALUE_OBJECT, vo);
            if (((TamdidEshterakModel) (vo)).getTarikhAkharinTamdid() != null)
                ctx.getRequest().setAttribute("tarikhAkharinTamdid", HejriUtil.chrisToHejri(((TamdidEshterakModel) (vo)).getTarikhAkharinTamdid()));
            else
                ctx.getRequest().setAttribute("tarikhAkharinTamdid", "");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        boolean isNullAkharinTamdid = false;

        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject vo = getProxy().read(id);

        if (((TamdidEshterakModel) (vo)).getTarikhAkharinTamdid() == null) {
            ((TamdidEshterakModel) (vo)).setTarikhAkharinTamdid(new Date(0));
            isNullAkharinTamdid = true;
        }

        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        if (!isNullAkharinTamdid)
            ctx.getForm().set("tarikhAkharinTamdid", HejriUtil.chrisToHejri(((TamdidEshterakModel) (vo)).getTarikhAkharinTamdid()));
        else
            ctx.getForm().set("tarikhAkharinTamdid", "");
        try {

            log.info("****" + ctx.getForm().get("eshterakId"));
            String moshtarakId = UserAccessEntity.stringQuery("select id from moshtarak where eshterakId='" + (String) ctx.getForm().get("eshterakId") + "';", "id", ctx.getConnection());
            log.info("****" + moshtarakId);
            MoshtarakModel moshtarakModel = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId).getMoshtarakModel();
            ctx.getForm().set("hazinehPardakhtShodeh", moshtarakModel.getHazinehPardakhtShodeh());
            ctx.getForm().set("takhfif", moshtarakModel.getTakhfif());
            ctx.getForm().set("naghd", moshtarakModel.getNaghd());
            ctx.getForm().set("taahodi", moshtarakModel.getTaahodi());
            ctx.getForm().set("aghsat", moshtarakModel.getAghsat());
            ctx.getForm().set("cheque", moshtarakModel.getCheque());
            ctx.getForm().set("noeService", moshtarakModel.getNoeService());

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.getRequest().setAttribute("noeServiceList", Util.getArrayList("noeService"));
        ctx.getRequest().setAttribute("bazaryabList", ComboPool.getCombo("bazaryab"));
    }

}
