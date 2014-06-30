package com.objectj.jsa.web.action;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.UserSession;
import com.objectj.emdad.ejb.EntityAccess;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.emdad.ejb.util.*;

public abstract class BaseAction extends Action {

    public static final String SUCCESS     = "success";
    public static final String ERROR       = "error";
    public static final String UNATHORIZED = "unauthorized";
    public static final String LOCALE     = "locale";

    public static final String ACTION_TYPE = "action_type";
    public static final String ID = "id";
    public static final String FORM = "form";
    public static final String VALUE_OBJECT = "value_object";
    public static final String VALUE_OBJECT_LIST = "value_object_list";
    public static final String SELECTED_ITEMS = "selectedItems";
    public static final String EXCEPTION = "exception";

    public static final String CUR_RECORDS = "cur_records";
    public static final String ENTITY_ACCESS = "entity_access";

    public static final String NULL_ID_MESSAGE = "NULL ID";
    public static final String  INVALID_ACTION_MESSAGE = "Invalid Action";

    public static final String DISPLAY_MESSAGE = "org.apache.struts.action.ERROR";

    public static String isNull = " is null";
    public static String isNotNull = " is not null";

    public static final int NULL_ACTION = 0;
    public static final int CREATE = 1;
    public static final int READ = 2;
    public static final int UPDATE = 3;
    public static final int DELETE = 4;
    public static final int READ_ALL = 5;
    public static final int READ_BY_ID = 6;
    public static final int EDIT_BY_ID = 7;
    public static final int DELETE_BY_ID = 8;
    public static final int READ_BY_ID_LIST = 9;
    public static final int DELETE_BY_ID_LIST = 10;
    public static final int EDIT = 11;
    public static final int EDIT_FROM_ERROR = 12;
    public static final int CREATE_FROM_ERROR = 13;
    public static final int FILTER = 14;
    public static final int ADVANCED_FILTER = 15;
    public static final int CLEAR_FILTER = 16;
    public static final int REPORT = 17;
    public static final int SPECIFIC = 18;
    public static final int SPECIFIC_FROM_ERROR = 19;

    public static final String ADD_TO_COMBO_LIST = "------";

    public static HashMap actionMap = new HashMap();
//    protected static ActionMapping actionMapping;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    protected Logger accesssLog = Logger.getLogger("EmdadUserAccess");



    static {
        actionMap.put("", new Integer(NULL_ACTION));
        actionMap.put("create", new Integer(CREATE));
        actionMap.put("read", new Integer(READ));
        actionMap.put("update", new Integer(UPDATE));
        actionMap.put("delete", new Integer(DELETE));
        actionMap.put("read_all", new Integer(READ_ALL));
        actionMap.put("read_by_id", new Integer(READ_BY_ID));
        actionMap.put("edit_by_id", new Integer(EDIT_BY_ID));
        actionMap.put("delete_by_id", new Integer(DELETE_BY_ID));
        actionMap.put("read_by_id_list", new Integer(READ_BY_ID_LIST));
        actionMap.put("delete_by_id_list", new Integer(DELETE_BY_ID_LIST));
        actionMap.put("edit", new Integer(EDIT));
        actionMap.put("Remove", new Integer(DELETE_BY_ID_LIST));
        actionMap.put("edit_from_error", new Integer(EDIT_FROM_ERROR));
        actionMap.put("create_from_error", new Integer(CREATE_FROM_ERROR));
        actionMap.put("filter", new Integer(FILTER));
        actionMap.put("advanced_filter", new Integer(ADVANCED_FILTER));
        actionMap.put("clear_filter", new Integer(CLEAR_FILTER));
        actionMap.put("report", new Integer(REPORT));
        actionMap.put("specific", new Integer(SPECIFIC));
        actionMap.put("specific_from_error", new Integer(SPECIFIC_FROM_ERROR));
    }

    private int getActionCode(BaseActionContext ctx) {
        int actionCode = NULL_ACTION;
        String action = (String)ctx.getForm().get(ACTION_TYPE);

        accesssLog.info("["+ctx.getUserSession().getName()+"], ["+ctx.getUserSession().getRole()+"], ["+ctx.getEntity()+"], ["+ctx.getRequest().getServletPath()+"], [" + action+"], ["+(String)ctx.getForm().get(ValueObject.ID)+"]");
        if (action == null || action.length()==0)
            actionCode = NULL_ACTION;
        else {
            if (action.indexOf(",")>0) {
                ctx.setSubAction(action.substring(action.indexOf(",")+1));
                action = action.substring(0, action.indexOf(","));
                ctx.setAction(action);
            }
            actionCode = ((Integer)actionMap.get(action)).intValue();
        }

        switch (ctx.getRequest().getServletPath().charAt(1)) {
            case 'c' :
                break;
            case 'r' :
                if (!action.startsWith("read"))
                    actionCode = READ_BY_ID;
                break;
            case 'u' :
                if (!action.startsWith("update"))
                    actionCode = EDIT_BY_ID;
                break;
            case 's' :
                if (!action.startsWith("specific"))
                    actionCode = READ_ALL;
                break;
            case 'd' :
                if (!action.startsWith("Remove"))
                    actionCode = DELETE_BY_ID_LIST;
                break;
            case 'l' :
                if (!(action.startsWith("read") || action.indexOf("report")>=0 || action.indexOf("filter")>=0 ))
                    actionCode = READ_ALL;
                break;
            default:
                actionCode = READ_ALL;
        }
        return actionCode;
    }

    public void computeList(BaseActionContext ctx, boolean fromTo, boolean isFiltered, QueryObject qo) {
//        log.info("---aa=");
        com.objectj.jsa.web.action.PageInfo pageInfo = new com.objectj.jsa.web.action.PageInfo(ctx.getForm());
        EntityList curRecords = new EntityList(getSortableColumns(),
                pageInfo.getCurPage(), pageInfo.getOrder(), pageInfo.getSortType());

        QueryResult queryResult = null;
        try{
            if (qo==null)
                qo = new QueryObject();
            if (ctx.getEntity().startsWith(Constants.ENTITY_ALTERNATE))
                qo.setOrderTable(ctx.getEntity().substring(Constants.ENTITY_ALTERNATE.length()));
            else
                qo.setOrderTable(ctx.getEntity());

            beforComputeList(ctx, qo);

//            log.info("curRecords.getCurPage()="+curRecords.getCurPage());
//            log.info("qo.getFromIndex()="+qo.getFromIndex());
//            log.info("qo.getToIndex()="+qo.getToIndex());

//            if (qo.getOrderField()==null || qo.getOrderField().length()==0)
                qo.setOrderField(curRecords.getSortType());
//            if (qo.getOrderType()==null || qo.getOrderType().length()==0)
                qo.setOrderType(curRecords.getOrder());
            if ( com.objectj.emdad.ejb.util.Util.isEmpty((String)ctx.getForm().get("sorttype")) )
                ctx.getForm().set("sorttype", qo.getOrderField());
            if ( com.objectj.emdad.ejb.util.Util.isEmpty((String)ctx.getForm().get("order")) )
                ctx.getForm().set("order", qo.getOrderType());

            if (qo.getFromIndex()<=1)
                qo.setFromIndex(fromTo ? (curRecords.getCurPage() - 1) * curRecords.recordsPerPage : 0);
            if (qo.getToIndex()<=1)
                qo.setToIndex(fromTo ? curRecords.getCurPage() * curRecords.recordsPerPage : 999999);
            if (qo.getTables()==null || qo.getTables().length()==0)
                qo.setTables(getRelatedTables(ctx));
            curRecords.setIsFilter(isFiltered);
//            log.info("---aa="+qo.getWhere());
            if (fromTo) {
                //Exchanger.exhangeResultSetToValueObjectArray(ctx.getConnection(), qo, getProxy(), (ValueObject)getValueObjectClass().newInstance() ,(getRelatedEntities().length > 0) || needList());
                if ((getRelatedEntities().length > 0) || needList())
                    queryResult = getProxy().readList(qo);
                else
                    queryResult = getProxy().readModel(qo);

//                log.info("curRecords.getCurPage()="+curRecords.getCurPage());
//                log.info("qo.getFromIndex()="+qo.getFromIndex());
//                log.info("qo.getToIndex()="+qo.getToIndex());

                //log.info("queryResult.getTotalCount()="+queryResult.getTotalCount());
                curRecords.setTotalRecords(queryResult.getTotalCount());
                if (queryResult.isHasError()) {
                    log.info(ctx.getUserSession().getName()+","+ctx.getEntity()+",action_type="+ctx.getAction());
                }
//                log.info("curRecords.getTotalRecords()="+curRecords.getTotalRecords());
            } else {
                Connection connection = com.objectj.emdad.ejb.util.Util.getConnection();
                ctx.getRequest().setAttribute("report",getProxy().report(qo, connection));
                ctx.getRequest().setAttribute("connection",connection);
            }

            if ((ctx.getUserSession().getDestinationForward(ctx.getEntity())==null) || !ctx.getUserSession().getDestinationForward(ctx.getEntity()).equals("find")){
                Exchanger.exhangeValueObjectToForm(newValueObject(),ctx.getForm());
                ctx.getRequest().setAttribute(FORM, ctx.getForm());
            }
            qo.setFromIndex(1);
            qo.setToIndex(1);
        }
        catch(Exception e){
             log.error(e);
             e.printStackTrace();
        }
       ctx.getRequest().setAttribute(VALUE_OBJECT, newValueObject());
       ctx.getRequest().setAttribute(CUR_RECORDS, curRecords);
       //ctx.getRequest().setAttribute(ENTITY_ACCESS, entityAccess);
//        log.info("queryResult.getResult().size()="+queryResult.getResult().size());
       if (queryResult!=null)
           ctx.getRequest().setAttribute(VALUE_OBJECT_LIST, queryResult.getResult());
//       log.info("VALUE_OBJECT_LIST="+ctx.getRequest().getAttribute(VALUE_OBJECT_LIST));
    }

    public void computeList(BaseActionContext ctx, boolean fromTo) {
        try{
            QueryObject filter = getFilter(ctx);
            if (filter!=null)
                filter.setTables("");
//            log.info("filter="+filter);
            computeList(ctx, fromTo, filter!=null, filter);
        }
        catch(Exception e){
             log.error(e);
             e.printStackTrace();
        }
    }

    public ActionForward listAll(BaseActionContext ctx) {
//        log.info("listAll,"+ctx.getForm().get(ACTION_TYPE));
        computeList(ctx, true);
        if (ctx.getUserSession().getDestinationForward(ctx.getEntity())!=null && ctx.getUserSession().getDestinationForward(ctx.getEntity()).length()!=0){
//            log.info("getDestinationForward()="+ctx.getUserSession().getDestinationForward(ctx.getEntity()));
            //String temp = getUserSession().getDestinationForward();
            //getUserSession().setDestinationForward("");
            return ctx.getActionMapping().findForward(ctx.getUserSession().getDestinationForward(ctx.getEntity()));
        }
        return ctx.getActionMapping().findForward("list");
    }

    public final ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (com.objectj.emdad.ejb.util.Util.get("noeEmdadgar_InactiveId")==null) {
            com.objectj.emdad.ejb.util.Util.add("application.constants.path", com.objectj.emdad.web.util.Util.getProperty("application.constants.path"));
            com.objectj.emdad.ejb.util.Util.add("noeEmdadgar_InactiveId",Constants.getNoeEmdadgar_InactiveId());
        }

        DynaValidatorForm form = (DynaValidatorForm)actionForm;
//        log.info("form="+form);
        if (request.getAttribute(ACTION_TYPE)!=null) {
                form.set(ACTION_TYPE, request.getAttribute(ACTION_TYPE));
        }
        BaseActionContext ctx = new BaseActionContext(form, request, actionMapping, getValueObjectClass());

        return doExecute(ctx, actionMapping, response);
    }

    private String getRelatedTables(BaseActionContext ctx) {
        String tables = ctx.getEntity();
        if (tables.startsWith(Constants.ENTITY_ALTERNATE))
            tables = tables.substring(Constants.ENTITY_ALTERNATE.length());

        String[] rel = getRelatedEntities();
        for (int j=0; j<rel.length; j++)
            tables += ","+rel[j];
        return tables;
    }

    private boolean isSSecure(BaseActionContext ctx) {
        String url = ctx.getRequest().getRequestURI();
        if (ctx.getRequest().getQueryString()!=null)
            url += "?" + ctx.getRequest().getQueryString();
        url = url.substring(url.indexOf("/", 1));
        if (url.indexOf(ACTION_TYPE) == -1)
            url += "?" + ACTION_TYPE + "="+ctx.getAction()+ (((ctx.getSubAction()!=null) && (ctx.getSubAction().length()>0)) ? "," + ctx.getSubAction() : "");
//        else
//            if (url.indexOf("&")!=-1)
//                url = url.substring(0, url.indexOf("&"));
//        log.info("url="+url);
        //return UserAccessEntity.roleURLAccess(ctx.getRequest().getUserPrincipal().getName(), url);
        return UserAccessEntity.roleURLAccess(ctx.getConnection(), ctx.getUserSession().getName(), url);
    }

    public ActionForward doExecute(BaseActionContext ctx, ActionMapping actionMapping, HttpServletResponse response) throws IOException, ServletException {
        ActionForward af;
/*        com.objectj.emdad.ejb.util.Util.add("nullKey", Constants.EMPTY_CODE);
        if(UserSession.isISDatabaseSQL()){
            isNull = " is null";
            isNotNull = " is not null";
        }else{
            isNull = " = 'F\"" + (String) com.objectj.emdad.ejb.util.Util.get("nullKey") + "\"'";
            isNotNull = " <> 'F\"" + (String) com.objectj.emdad.ejb.util.Util.get("nullKey") + "\"'";
        }*/
        boolean Log = ctx.getUserSession().getName().equals("abc");
        try {
            int actionCode = getActionCode(ctx);            // fills subaction field of ctx
            //=-= //=-= //=-= System.out.println("************ ghablesh");
            if (false) { //!isSSecure(ctx)) {
                //=-= //=-= //=-= System.out.println("************ error");
                af = actionMapping.findForward("subactionSecurityError");
                ctx.closeConnection();
                return af;
            }

            ctx.getRequest().setAttribute("sampleDate", Util.getProperty("date.sample"));
            ctx.getRequest().setAttribute("daftarOstaniName", ctx.getUserSession().getDaftarOstaniName());
            ctx.getRequest().setAttribute("userName", ctx.getUserSession().getName());

//            if (ctx.getUserSession().getDestinationForward(ctx.getEntity())!=null && ctx.getUserSession().getDestinationForward(ctx.getEntity()).length()!=0)
//                log.info("----getDestinationForward()---="+ctx.getUserSession().getDestinationForward(ctx.getEntity()));

            if (Log)
                log.info("--- start of doExecute");
            doSpecificAction(ctx);
            if (Log)
                log.info("--- after doSpecificAction");
            ctx.getRequest().setAttribute(ENTITY_ACCESS, ctx.getUserSession().getEntityAccess(ctx.getEntity()));

            switch(actionCode) {
            case NULL_ACTION:
                af = doNullAction(ctx);
                    break;
            case CREATE:
                af = doCreate(ctx);
                    break;
            case EDIT:
                af = doEdit(ctx);
                    break;
            case READ_ALL:
                af = doReadAll(ctx);
                    break;
            case DELETE_BY_ID:
                af = doDeleteById(ctx);
                    break;
            case READ_BY_ID:
                af = doReadById(ctx);
                    break;
            case EDIT_BY_ID:
                af = doEditById(ctx);
                    break;
            case READ_BY_ID_LIST:
                af = doReadByIdList(ctx);
                    break;
            case DELETE_BY_ID_LIST:
                af = doDeleteByIdList(ctx);
                    break;
            case SPECIFIC:
                af = doSpecific(ctx);
                    break;
            case READ:
                af = doRead(ctx);
                    break;
            case UPDATE:
                af = doUpdate(ctx);
                    break;
            case DELETE:
                af = doDelete(ctx);
                    break;
            case EDIT_FROM_ERROR:
                af = doEditFromError(ctx);
                    break;
            case CREATE_FROM_ERROR:
                af = doCreateFromError(ctx);
                    break;
            case SPECIFIC_FROM_ERROR:
                    af = doSpecificFromError(ctx);
                    break;
            case FILTER:
                af = doFilter(ctx);
                    break;
            case ADVANCED_FILTER:
                af = doAdvancedFilter(ctx);
                    break;
            case CLEAR_FILTER:
                af = doClearFilter(ctx);
                    break;
            case REPORT:
                af = doReport(ctx);
                    break;
            default:
                throw new ServletException(INVALID_ACTION_MESSAGE + ": " + actionCode);
            }
            if (Log)
                log.info("--- after doXxx(ctx)");
            doPostSpecificAction(ctx);
        } catch (ProxyReferenceException exception) {
            ctx.getRequest().setAttribute("err_ref", "errors.entity.delete.reference");
            try {
                af = listAll(ctx);
            } catch (Exception e) {
                af = actionMapping.findForward(ERROR);
            }
        } catch (Exception exception) {
            log.error(exception.toString());
            exception.printStackTrace();
            ctx.getRequest().getSession().setAttribute(EXCEPTION, exception);
            af =  actionMapping.findForward(ERROR);
        }

        if( ctx.getRequest().getAttribute("role") == null )
            ctx.getRequest().setAttribute("role", ctx.getUserSession().getRole());

        if (!ctx.isRemainConnectionOpen())
            ctx.closeConnection();
        if (Log)
            log.info("--- end of execute");

        return af;
    }

    protected EntityAccess getAccess(BaseActionContext ctx) {
        return ctx.getUserSession().getEntityAccess(ctx.getEntity());
    }

    protected ActionForward doRedirect(BaseActionContext ctx, String toURL)  throws Exception  {
        ctx.getRequest().setAttribute("toURL", toURL);
        return new  ActionForward("redirectJsp");
    }

    protected ActionForward doReport(BaseActionContext ctx) throws IllegalAccessException, ProxyException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        computeList(ctx, false);
        return new ActionForward("/com/objectj/emdad/jsp/"+ctx.getEntity()+".report.jsp");
    }

    protected ActionForward doFilter(BaseActionContext ctx)  throws Exception {
        doFilterPreProcessor(ctx);
        //String filter = Exchanger.exhangeFormToFilter(ctx.getForm(), getValueObjectClass(), this, ctx.getEntity());
		String filter = Exchanger.exhangeFormToFilter(ctx.getForm(), getValueObjectClass2(), this, ctx.getEntityList());
        filter = doFilterPostProcessor(ctx , filter);
        if (filter!=null && filter.length()>0)
            return doAdvancedFilter(ctx, filter);
        return doClearFilter(ctx);
    }

    protected ActionForward doTemporarySpecific(BaseActionContext ctx, String filter, String forward)  throws Exception {
        ctx.setEntity(Constants.ENTITY_ALTERNATE + ctx.getEntity());
        ctx.getUserSession().setSpecific(filter , forward, ctx.getEntity());
//        log.info("---filter="+filter);
        computeList(ctx, true);
        ctx.getUserSession().clearAllFilters(ctx.getEntity());
        if (forward!=null)
            return  ctx.getActionMapping().findForward(forward);
        return null;
    }

    protected ActionForward doShow(BaseActionContext ctx, String entityIdName, String forwardName)  throws Exception {
        String entityId = Util.getIdWithO(ctx,  (String)ctx.getForm().get("id"), entityIdName);
        if (entityId==null) {
            return ctx.getActionMapping().findForward("showNotFound");
        }
        ctx.getForm().set("id",entityId);
        doReadById(ctx);
        return ctx.getActionMapping().findForward(forwardName==null ? "show" : forwardName);
    }

    protected void setFilterToSession(BaseActionContext ctx, String filter) throws Exception {
        QueryObject qo = getAdvancedFilter(ctx, filter);
        ctx.getUserSession().setFilter(ctx.getEntity(),qo);
    }

    protected ActionForward doAdvancedFilter(BaseActionContext ctx)  throws Exception {
        // for advanced filtering, ID has used for transport the filter expression
        return doAdvancedFilter(ctx, (String)ctx.getForm().get(ValueObject.ID));
    }

    public ActionForward doAdvancedFilter(BaseActionContext ctx, String filter)  throws Exception {
        ctx.getForm().set(PageInfo.CURPAGE, "1");
        if (filter == null || filter.length() == 0)
            filter = getForceFilter(ctx);
        else
            if (getForceFilter(ctx)!=null && getForceFilter(ctx).length()>0)
                filter = filter + " AND " + getForceFilter(ctx);
//        log.info("doAdvancedFilter-->filter="+filter);
        setFilterToSession(ctx, filter);
        ctx.getForm().set(ID, "");
        //ctx.getForm().set(ACTION_TYPE, "read_all");
        return listAll(ctx);
    }

    protected ActionForward doClearFilter(BaseActionContext ctx) throws Exception {
        ctx.getForm().set(PageInfo.CURPAGE, "1");
//        log.info("000000  getForceFilter(ctx)="+getForceFilter(ctx));
        ctx.getUserSession().clearFilter(ctx.getEntity());
//        log.info("111111  getForceFilter(ctx)="+getForceFilter(ctx));
        if (getForceFilter(ctx)!=null && getForceFilter(ctx).length()>0)
            return doAdvancedFilter(ctx);
        //ctx.getForm().set(ACTION_TYPE, "read_all");
        return listAll(ctx);
    }

    protected ActionForward doNullAction(BaseActionContext ctx) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doEdit(BaseActionContext ctx) {
        ctx.getForm().set(ACTION_TYPE, "create");
        return ctx.getActionMapping().findForward("edit");
    }


    protected ActionForward doEditFromError(BaseActionContext ctx) {
        ctx.getForm().set(ACTION_TYPE, "edit");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doCreateFromError(BaseActionContext ctx) {
        ctx.getForm().set(ACTION_TYPE, "create");
        return ctx.getActionMapping().findForward("edit");
    }


    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception  {
        return null;
    }

    protected ActionForward doReadAll(BaseActionContext ctx) throws IllegalAccessException, ProxyException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        return listAll(ctx);
    }

    protected ActionForward doDeleteById(BaseActionContext ctx) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        getProxy().remove(id);
        ComboPool.setDirty(ctx.getEntity());
        return listAll(ctx);
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

//        log.info("--read 000");
        ValueObject valueObject = getProxy().read(id);
//        log.info("--read 111");

//            log.info("--read 111");
        try {
//            ValueObject vo2 = (ValueObject) getValueObjectClass().newInstance();
//            Exchanger.exhangeResultSetToValueObject(ctx.getConnection(), "Select * from "+ctx.getEntity()+" where id='"+id+"'", new ValueObject[] {vo2});
//
//            log.info("--read 222");
        } catch (Exception e) {

        }

        ctx.getRequest().setAttribute(VALUE_OBJECT, valueObject);
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doReadByIdList(BaseActionContext ctx) throws ServletException, ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        String[] ids = (String[]) ctx.getForm().get(SELECTED_ITEMS);
        if (ids == null) {
            throw new ServletException(NULL_ID_MESSAGE);
        }
        // we implement this later on
        Collection valueObjectList = getProxy().read(ids).getResult();
        ctx.getRequest().setAttribute(VALUE_OBJECT_LIST, valueObjectList);
        return listAll(ctx);
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doDeleteByIdList(BaseActionContext ctx) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        // when you selected a list of VALUE_OBJECT_LIST
        String[] ids = (String[]) ctx.getForm().get(SELECTED_ITEMS);
        if (ids == null) {
            throw new ServletException(NULL_ID_MESSAGE);
        }

        getProxy().remove(ids);
        ComboPool.setDirty(ctx.getEntity());
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        ValueObject valueObject = newValueObject();
        Exchanger.exhangeFormToValueObject(ctx.getForm(), valueObject);

        if (!isCancelled(ctx.getRequest())) {
            getProxy().update(valueObject);
            ComboPool.setDirty(ctx.getEntity());
        }
        return listAll(ctx);
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            ValueObject vo = newValueObject();
            Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
            getProxy().create(vo);
            ComboPool.setDirty(ctx.getEntity());
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

    protected ActionForward doDelete(BaseActionContext ctx) throws ProxyReferenceException, RemoteException, IllegalAccessException, ProxyException, InstantiationException, ClassNotFoundException {
        ValueObject valueObject = newValueObject();
        Exchanger.exhangeFormToValueObject(ctx.getForm(), valueObject);

        getProxy().remove(valueObject);
        ComboPool.setDirty(ctx.getEntity());
        return listAll(ctx);
    }

    protected ValueObject newValueObject() {
        try {
            return (ValueObject)getValueObjectClass().newInstance();
        } catch (Exception e) {
            log.error("Unable to instantiate from " + getValueObjectClass().getName());
            return null;
        }
    }

    /*************************************************************************/

    public boolean isInRelatedEntities(String entityName) {
        String[] rela = getRelatedEntities();
//        log.info("isInRelatedEntities(entityName="+entityName);
        for (int i=0; i<rela.length; i++)
            if (rela[i].equals(entityName))
                return true;
        return false;
    }

    public QueryObject getAdvancedFilter(BaseActionContext ctx, String filterExp) throws Exception {
        QueryObject qo = com.objectj.emdad.web.util.Util.parseFilter(filterExp);
//        log.info("Where: " + qo.getWhere());
        return qo;
    }

    /*************************************************************************/

    public QueryObject getFilter(BaseActionContext ctx) throws Exception {
//        log.info("0000000");
        if (ctx.getUserSession().getQueryObjectFilter(ctx.getEntity())==null)
            if (getForceFilter(ctx)!=null && getForceFilter(ctx).length()!=0) {
//                log.info("111111111");
                setFilterToSession(ctx, getForceFilter(ctx));
            }
//        log.info("22222222222");
        return ctx.getUserSession().getQueryObjectFilter(ctx.getEntity());
    }

    public String getDaftarOstani(BaseActionContext ctx) {
        return ctx.getUserSession().getDaftarOstani();
    }

    public String getUserId(BaseActionContext ctx) throws Exception{
        return UserAccessEntity.getUserId(ctx.getUserSession().getName());
    }

    public int getNaghshId(BaseActionContext ctx) throws Exception{
        return ctx.getUserSession().getNaghshId();
    }
    /*************************************************************************/

    protected abstract Class getValueObjectClass();

    protected Class getValueObjectClass2() { return getValueObjectClass(); };

    protected abstract String[] getSortableColumns();

    protected String[] getRelatedEntities() { return new String[] {};}

    protected abstract EntityProxy getProxy() throws ProxyException;

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {}

    protected void doPostSpecificAction(BaseActionContext ctx)  throws ProxyException {}

    protected String getForceFilter(BaseActionContext ctx) {
        return ctx.getUserSession().getForceFilter(ctx.getEntity());
//        return "";
    }

    public void saveToken(HttpServletRequest request, HttpSession session) {
       String token = generateToken(request);
       if (token != null) {
           session.setAttribute(TRANSACTION_TOKEN_KEY, token);
       }
   }

   public boolean isTokenValid(HttpServletRequest request, HttpSession session) {

       String saved = (String)session.getAttribute(TRANSACTION_TOKEN_KEY);
       if (saved == null) {
           return false;
       }
       //You Should consume this token.
       session.removeAttribute(TRANSACTION_TOKEN_KEY);
       String token = request.getParameter(org.apache.struts.taglib.html.Constants.TOKEN_KEY);
       if (token == null) {
           return false;
       }
       return (saved.equals(token));
   }

    protected void clearAllFilters(BaseActionContext ctx) {
       ctx.getUserSession().clearAllFilters(ctx.getEntity());
    }

    protected boolean needList() { return false; }

    protected ActionForward doSpecificFromError(BaseActionContext ctx) { return null; }

    protected void beforComputeList(BaseActionContext ctx, QueryObject qo) {}

    protected void doFilterPreProcessor(BaseActionContext ctx) {}

    protected String doFilterPostProcessor(BaseActionContext ctx , String filter) { return filter; }

    protected void showMessage(BaseActionContext ctx ,ActionErrors errors) {
        ctx.getRequest().setAttribute(DISPLAY_MESSAGE, errors);
    }

    protected void setOrderToXifIsEmpty(BaseActionContext ctx, String order) {
        if (com.objectj.emdad.ejb.util.Util.isEmpty((String) ctx.getForm().get("order")))
            ctx.getForm().set("order", order);
    }

/*
    public static Object get(String key, HttpServletRequest request, HttpSession session, DynaActionForm form) {
        Object value = request.getParameter(key);
        if(value == null)
            value = session.getAttribute(key);
        if(value == null) {
            try {
                value = form.get(key);
            } catch(Exception exception) {
                return null;
            }
        }
        return value;
    }
*/
}