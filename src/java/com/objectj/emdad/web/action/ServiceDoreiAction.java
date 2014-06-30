package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.web.util.ServiceDoreiXls;
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
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/c/serviceDorei"
 *      pathPrime="/serviceDorei"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/serviceDorei.edit.jsp"
 *      inputPrime="emdad.serviceDorei.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/r/serviceDorei"
 *      pathPrime="/serviceDorei"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/serviceDorei.read.jsp"
 *      inputPrime="emdad.serviceDorei.read"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/u/serviceDorei"
 *      pathPrime="/serviceDorei"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/serviceDorei.edit.jsp"
 *      inputPrime="emdad.serviceDorei.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/d/serviceDorei"
 *      pathPrime="/serviceDorei"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/serviceDorei.read.jsp"
 *      inputPrime="emdad.serviceDorei.read"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/l/serviceDorei"
 *      pathPrime="/serviceDoreiList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/serviceDorei.list.jsp"
 *      inputPrime="emdad.serviceDorei.list"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/c/validateserviceDorei"
 *      pathPrime="/validateserviceDorei"
 *      scope="request"
 *      input="/c/serviceDorei.run"
 *      inputPrime="emdad.serviceDorei.edit"
 *      input4tiles="emdad.serviceDorei.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterServiceDoreiForm"
 *      path="/l/filterserviceDorei"
 *      pathPrime="/filterserviceDorei"
 *      scope="request"
 *      input="/l/serviceDorei.run"
 *      inputPrime="emdad.serviceDorei.edit"
 *      input4tiles="emdad.serviceDorei.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/u/validateserviceDorei"
 *      pathPrime="/validateserviceDorei"
 *      scope="request"
 *      input="/u/serviceDorei.run"
 *      inputPrime="emdad.serviceDorei.edit"
 *      input4tiles="emdad.serviceDorei.edit"
 *      validate="true"
 * @struts.action
 *      name="serviceDoreiForm"
 *      path="/s/serviceDorei"
 *      pathPrime="/serviceDorei"
 *      scope="request"
 *      input="/s/serviceDorei.run"
 *      inputPrime="/s/serviceDorei.run"
 *      validate="false"
 *
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.serviceDorei.list"
 *      pathPrime="emdad.serviceDorei.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.serviceDorei.edit"
 *      pathPrime="emdad.serviceDorei.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.serviceDorei.read"
 *      pathPrime="emdad.serviceDorei.read"
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
 * @struts.action-forward
 *      name="serviceDoreiListEdit"
 *      path="/com/objectj/emdad/jsp/serviceDorei.list.edit.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/serviceDorei.list.edit.jsp"
 * @struts.action-forward
 *      name="serviceImported"
 *      path="/com/objectj/emdad/jsp/serviceImported.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/serviceImported.jsp"
 */

public class ServiceDoreiAction extends BaseAction {
    protected Class getValueObjectClass() {
        return ServiceDoreiModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"namayandegiId", "tarikh", "eshterakId", "shomareShasi", "kilometerKarkard", "noeServiceDorei", "hazineh", "taeedHesabdar" };
    }

    protected boolean needList() { return true; }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return ServiceDoreiSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                ServiceDoreiModel vo = new ServiceDoreiModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                vo.setTarikh(HejriUtil.hejriToChris((String) ctx.getForm().get("tarikh")));
                vo.setTaeedHesabdar( new Integer(2) );
                vo.setTaeedNamayandeh( new Integer(2) );
                String moshtarakId = UserAccessEntity.stringQuery("SELECT id FROM moshtarak WHERE eshterakId = '" + (String) ctx.getForm().get("eshterakId") + "'", "id");
                vo = (ServiceDoreiModel) ((ServiceDoreiProxy) getProxy()).create(vo, moshtarakId, (String) ctx.getForm().get("namayandegiId"));
                ctx.getForm().set("moshtarakId", null);
                validate( ctx, vo );
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
                String id = (String) ctx.getForm().get(ValueObject.ID);
                ServiceDoreiList vo = (ServiceDoreiList)getProxy().read(id);
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                vo.setTarikh(HejriUtil.hejriToChris( (String)ctx.getForm().get("tarikh")));
                String moshtarakId = UserAccessEntity.stringQuery("SELECT id FROM moshtarak WHERE eshterakId = '" + (String) ctx.getForm().get("eshterakId") + "'", "id");
                ((ServiceDoreiProxy) getProxy()).update(vo, moshtarakId, (String) ctx.getForm().get("namayandegiId"));
                ctx.getForm().set("moshtarakId", null);
                validate( ctx, vo );
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ServiceDoreiList vo = (ServiceDoreiList)getProxy().read(id);
        Exchanger.exhangeValueObjectToForm( vo, ctx.getForm() );
        ctx.getForm().set("tarikh", HejriUtil.chrisToHejri(vo.getTarikh()));
        ctx.getForm().set( "noeServiceDorei", vo.getNoeServiceDorei() );
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.ServiceDoreiSessionLocalHome lhProxy = com.objectj.emdad.proxy.ServiceDoreiSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.ServiceDoreiSessionLocal lProxy = lhProxy.create();
            ServiceDoreiList vo = (ServiceDoreiList) lProxy.read(id);
            ctx.getForm().set("tarikh", HejriUtil.chrisToHejri(vo.getTarikh()));

            ctx.getRequest().setAttribute(VALUE_OBJECT, vo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception  {
        if( ctx.getSubAction().equals( "importServiceDorei" ) ){
            return doImport( ctx );
        }
        if( ctx.getSubAction().equals( "taeed" ) ) {
            return doTaeed( ctx );
        }
        if( ctx.getSubAction().equals( "test" ) ) {
            return test( ctx );
        }
        return listAll( ctx );
    }

    private ActionForward doImport( BaseActionContext ctx ){
        try {
            String file = ctx.getRequest().getParameter( "xlsFile" );
            String taeed = ctx.getRequest().getParameter( "taeed" );
            ServiceDoreiXls xls = new ServiceDoreiXls( file );
            for( int i = 0; i < xls.rowSize(); i++ ){
                ServiceDoreiModel vo = new ServiceDoreiModel();
                vo.setTarikh( HejriUtil.hejriToChris( xls.getTarikh(i).getString() ) );
                vo.setHazineh( new Integer( xls.getHazineh(i).getString() ) );
                vo.setKilometerKarkard( new Integer( xls.getKarkard(i).getString() ) );
                vo.setTaeedNamayandeh( new Integer(2) );
                if ( taeed.equals( "true" ) ) {
                    vo.setTaeedHesabdar( new Integer(1) );
                } else {
					vo.setTaeedHesabdar( new Integer(2) );
				}
                String noeService = xls.getNoeService(i).getString();
                if ( noeService.indexOf( "000" ) > 0 ) {
                    noeService = noeService.substring( 0, noeService.lastIndexOf("000")  );
                }
                noeService = UserAccessEntity.stringQuery( "select id from noeServiceDorei where noeServiceDorei='" + noeService + "'", "id" );
                vo.setNoeServiceDorei( noeService );
                String namayandegiId = UserAccessEntity.stringQuery( "select id from namayandegi where namayandegiId='" + xls.getNamayandegi(i).getString() + "'", "id" );
                String eshterakId = UserAccessEntity.stringQuery( "select id from moshtarak where eshterakId='" + xls.getMoshtarak(i).getString() + "'", "id" );
                ((ServiceDoreiProxy)getProxy()).create(vo, eshterakId, namayandegiId );
            }
        } catch( Exception e ) {
            e.printStackTrace();
            return  ctx.getActionMapping().findForward( "error" );
        }
        ActionErrors error = new ActionErrors();
        error.add("impoerted", new ActionError( "import.xls.service.added" ) );
        ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
        return listAll( ctx );
        //return ctx.getActionMapping().findForward( "serviceImported" );
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        if ( ctx.getAction().length()==0 ||
            ctx.getAction().indexOf("edit")!=-1 ||
            ctx.getAction().indexOf("error")!=-1 ) {
				ctx.getRequest().setAttribute("namayandegiList", ComboPool.getCombo("namayandegi"));
		}
        List noeServiceDoreiList = com.objectj.emdad.web.util.Util.readCombo(null, "noeServiceDorei", "name","","").getResult();
        ctx.getRequest().setAttribute( "noeServiceDoreiList", noeServiceDoreiList );
     }

    private void validate( BaseActionContext ctx, ServiceDoreiModel vo ) {
        String noeService = vo.getNoeServiceDorei();
        ActionErrors error = new ActionErrors();
        error.clear();
        String hazinehDef = UserAccessEntity.stringQuery( "select hazineh from noeServiceDorei where id='" + noeService + "'", "hazineh" );
        if ( !hazinehDef.equals( vo.getKilometerKarkard() ) )
            error.add("hazinehInvalid", new ActionError( "import.xls.service.hazineh.invalid" ) );
        ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
    }

    private ActionForward doTaeed( BaseActionContext ctx ) {
        String[] ids = (String[]) ctx.getForm().get(SELECTED_ITEMS);
        java.sql.PreparedStatement st = null;
        try {
            st = ctx.getConnection().prepareStatement( "update serviceDorei set taeedHesabdar=1 where id=?" );
            for( int i = 0; i < ids.length; i++ ) {
                st.setString( 1, ids[ i ] );
                st.executeUpdate();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        } finally {
            try{
            st.close();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return listAll( ctx );
    }

    private ActionForward test( BaseActionContext ctx ) {
        try {
           ServiceDoreiModel vo = new ServiceDoreiModel();
            vo.setKilometerKarkard( new Integer( 2468 ) );
            long now = System.currentTimeMillis();
           ((ServiceDoreiProxy)getProxy()).create( vo );
            long after = System.currentTimeMillis() - now;
            log.info( " CREATED 1: " + vo.getId() + " IN " + after );
            vo = new ServiceDoreiModel();
            vo.setKilometerKarkard( new Integer( 2468 ) );
            now = System.currentTimeMillis();
            MoshtarakLocal mo = MoshtarakUtil.getLocalHome().findByPrimaryKey("268080808080808280o");
            after = System.currentTimeMillis() - now;
            log.info( "FindByPrimaryTime: " + after );
            now = System.currentTimeMillis();
           ((ServiceDoreiProxy)getProxy()).create( vo, "268080808080808280o", null );
            after = System.currentTimeMillis() - now;
            log.info( "Created 2: " + vo.getId() + " IN " + after );
            vo = new ServiceDoreiModel();
            vo.setKilometerKarkard( new Integer( 2468 ) );
            now = System.currentTimeMillis();
			((ServiceDoreiProxy)getProxy()).create( vo, mo, null );
			after = System.currentTimeMillis() - now;
            log.info( "Created 3: " + vo.getId() + " IN " + after );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return ctx.getActionMapping().findForward( "error" );
    }
}