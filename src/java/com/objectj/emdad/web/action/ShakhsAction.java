package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.DaftarOstaniModel;
import com.objectj.emdad.ejb.ShakhsLocal;
import com.objectj.emdad.ejb.ShakhsModel;
import com.objectj.emdad.ejb.ShakhsUtil;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @struts.action name="shakhsForm"
 * path="/c/shakhs"
 * pathPrime="/shakhs"
 * scope="request"
 * input="/com/objectj/emdad/jsp/shakhs.edit.jsp"
 * inputPrime="emdad.shakhs.edit"
 * validate="false"
 * @struts.action name="shakhsForm"
 * path="/r/shakhs"
 * pathPrime="/shakhs"
 * scope="request"
 * input="/com/objectj/emdad/jsp/shakhs.read.jsp"
 * inputPrime="emdad.shakhs.read"
 * validate="false"
 * @struts.action name="shakhsForm"
 * path="/u/shakhs"
 * pathPrime="/shakhs"
 * scope="request"
 * input="/com/objectj/emdad/jsp/shakhs.edit.jsp"
 * inputPrime="emdad.shakhs.edit"
 * validate="false"
 * @struts.action name="shakhsForm"
 * path="/d/shakhs"
 * pathPrime="/shakhs"
 * scope="request"
 * input="/com/objectj/emdad/jsp/shakhs.read.jsp"
 * inputPrime="emdad.shakhs.read"
 * validate="false"
 * @struts.action name="shakhsForm"
 * path="/l/shakhs"
 * pathPrime="/shakhsList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/shakhs.list.jsp"
 * inputPrime="emdad.shakhs.list"
 * validate="false"
 * @struts.action name="shakhsForm"
 * path="/c/validateshakhs"
 * pathPrime="/validateshakhs"
 * scope="request"
 * input="/c/shakhs.run"
 * inputPrime="emdad.shakhs.edit"
 * input4tiles="emdad.shakhs.edit"
 * validate="true"
 * @struts.action name="shakhsForm"
 * path="/u/validateshakhs"
 * pathPrime="/validateshakhs"
 * scope="request"
 * input="/u/shakhs.run"
 * inputPrime="emdad.shakhs.edit"
 * input4tiles="emdad.shakhs.edit"
 * validate="true"
 * @struts.action name="shakhsForm"
 * path="/s/shakhs"
 * pathPrime="/shakhs"
 * scope="request"
 * input="emdad.shakhs.changePassword"
 * inputPrime="emdad.shakhs.changePassword"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.shakhs.list"
 * pathPrime="emdad.shakhs.list"
 * @struts.action-forward name="edit"
 * path="emdad.shakhs.edit"
 * pathPrime="emdad.shakhs.edit"
 * @struts.action-forward name="changePassword"
 * path="emdad.shakhs.changePassword"
 * pathPrime="emdad.shakhs.changePassword"
 * @struts.action-forward name="read"
 * path="emdad.shakhs.read"
 * pathPrime="emdad.shakhs.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 */

public class ShakhsAction extends BaseAction {

    ArrayList naghshList = new ArrayList();

    protected Class getValueObjectClass() {
        return ShakhsModel.class;
    }

    protected boolean needList() {
        return true;
    }

    protected String[] getSortableColumns() {
        return new String[]{"shakhsId", "name", "naghshId", "daftarOstaniId", "username"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"daftarOstani", "admin_roles"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return ShakhsSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected String getForceFilter( BaseActionContext ctx ) {
        if ( !ctx.getUserSession().getEntityAccess( ctx.getEntity() ).getAllAccess() ) {
            return "shakhs.daftarOstaniId = 'S" + getDaftarOstani( ctx ) + "'";
        }
        return "";
    }


    protected ActionForward doReadById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }
        try {

            com.objectj.emdad.proxy.ShakhsSessionLocalHome lhProxy = com.objectj.emdad.proxy.ShakhsSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.ShakhsSessionLocal lProxy = lhProxy.create();
            ValueObject voShakhsList = lProxy.read( id );

            ctx.getRequest().setAttribute( VALUE_OBJECT, voShakhsList );
            //ctx.getRequest().setAttribute("naghshName", ((ComboObject)shoghlList.get(((ShakhsModel)voShakhsList).getShoghl().intValue())).getName());

        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }

        return ctx.getActionMapping().findForward( "read" );
    }


    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {
        ctx.getRequest().setAttribute( "daftarOstaniList", ComboPool.getCombo( "daftarOstani" ) );
        ctx.getRequest().setAttribute( "emdadgarList", ComboPool.getCombo( "emdadgar_faal" ) );
        ctx.getRequest().setAttribute( "namayandegiList", ComboPool.getCombo( "namayandegi" ) );
        ctx.getRequest().setAttribute( "naghshList", ComboPool.getCombo( "admin_roles" ) );
    }

    protected ActionForward doSpecific( BaseActionContext ctx ) throws Exception {
        if ( ctx.getSubAction().equals( "editPass" ) ) {
            ctx.getRequest().setAttribute( "id", ctx.getUserSession().getId() );
            return ctx.getActionMapping().findForward( "changePassword" );
        } else if ( ctx.getSubAction().equals( "cancel" ) ) {
            return ctx.getActionMapping().findForward( ctx.getHomeForward() );
        } else if ( ctx.getSubAction().equals( "changePass" ) ) {
            ActionErrors errors = new ActionErrors();
            String id = ctx.getRequest().getParameter( "id" );
            if ( com.objectj.emdad.ejb.util.Util.isEmpty( id ) || !id.equals( ctx.getUserSession().getId() ) ) {
                errors.add( "soId", new ActionError( "requested.action.not.done" ) );
                showMessage( ctx, errors );
                return ctx.getActionMapping().findForward( ctx.getHomeForward() );
            }
            QueryObject qo = new QueryObject( "shakhs", "", "", false );
            qo.setWhere( "id='" + id + "'" );
            ShakhsModel valueObject = (ShakhsModel) getProxy().readModel( qo ).getResult().get( 0 );
            if ( !valueObject.getPassword().equals( ctx.getRequest().getParameter( "newPassword" ) ) ) {
                errors.add( "soId", new ActionError( "requested.action.not.done" ) );
                showMessage( ctx, errors );
                return ctx.getActionMapping().findForward( ctx.getHomeForward() );
            }

            valueObject.setPassword( ctx.getRequest().getParameter( "newPassword" ) );
            ShakhsSessionUtil.getLocalHome().create().update( valueObject );

            return ctx.getActionMapping().findForward( ctx.getHomeForward() );
        }
        if ( ctx.getSubAction().equals( "disable" ) ) {
            String id = ctx.getRequest().getParameter( "id" );
            ShakhsLocal shakhsLocal = ShakhsUtil.getLocalHome().findByPrimaryKey( id );
            ShakhsModel shakhsModel = shakhsLocal.getShakhsModel();
            shakhsModel.setEnable( "0" );
            shakhsLocal.setShakhsModel( shakhsModel );
//            ((ShakhsProxy) getProxy()).update(shakhsLocal.getShakhsModel());
            System.out.println( "!!" + shakhsLocal.getShakhsModel().getEnable() + "!!" + shakhsLocal.getShakhsModel().getUsername() );
        } else if ( ctx.getSubAction().equals( "enable" ) ) {
            String id = ctx.getRequest().getParameter( "id" );
            ShakhsLocal shakhsLocal = ShakhsUtil.getLocalHome().findByPrimaryKey( id );
            ShakhsModel shakhsModel = shakhsLocal.getShakhsModel();
            shakhsModel.setEnable( "1" );
            shakhsLocal.setShakhsModel( shakhsModel );
//            ((ShakhsProxy) getProxy()).update(shakhsLocal.getShakhsModel());
            System.out.println( "!!" + shakhsLocal.getShakhsModel().getEnable() + "!!" + shakhsLocal.getShakhsModel().getUsername() );
        }
        return listAll( ctx );
    }

    protected ActionForward doCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                ShakhsModel vo = new ShakhsModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                log.info( "~~~~~~~~~~~~~~~~~~~~ daftarOstaniId: " + ctx.getForm().get( "daftarOstaniId" ) );

                int naghshId = vo.getNaghshId().intValue();
                if ( naghshId == Constants.getNamayandegiShoghlId() ) {
                    vo.setEntityId( (String) ctx.getForm().get( "namayandegiId" ) );
                } else if ( naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId() ) {
                    vo.setEntityId( (String) ctx.getForm().get( "emdadgarId" ) );
                }

                if ( !ctx.getUserSession().getEntityAccess( ctx.getEntity() ).getAllAccess() ) {
                    ( (ShakhsProxy) getProxy() ).create( vo, (String) ( getDaftarOstani( ctx ) ) );
                } else {
                    ( (ShakhsProxy) getProxy() ).create( vo, (String) ctx.getForm().get( "daftarOstaniId" ) );
                }
                ComboPool.setDirty( ctx.getEntity() );

            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }

    protected ActionForward doEditById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }

        ValueObject valueObject = getProxy().read( id );
        Exchanger.exhangeValueObjectToForm( valueObject, ctx.getForm() );

        DaftarOstaniModel daftarOstaniModel = null;
        try {
            daftarOstaniModel = (DaftarOstaniModel) DaftarOstaniSessionUtil.getLocalHome().create().read( (String) ctx.getForm().get( "daftarOstaniId" ) );
        } catch ( Exception e ) {
        }
        ctx.getRequest().setAttribute( "daftarOstaniName", daftarOstaniModel.getName() );

        /*
        NamayandegiModel namayandegiModel = null;
        EmdadgarModel emdadgarModel = null;
        log.info("~~~~~~~~~~~~~~~~~~~~ naghshId: " + (((ShakhsModel)valueObject).getNaghshId().toString()));
        int naghshId = ((ShakhsModel)valueObject).getNaghshId().intValue();
        try {
            if (naghshId == Constants.getNamayandegiShoghlId()) {
                namayandegiModel = (NamayandegiModel)NamayandegiSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("entityId"));
                ctx.getRequest().setAttribute("entityName", namayandegiModel.getName());
            }
            else if (naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId()) {
                emdadgarModel = (EmdadgarModel)EmdadgarSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("entityId"));
                ctx.getRequest().setAttribute("entityName", emdadgarModel.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
        */
        // we'll not sent real password to client
        ctx.getForm().set( "namayandegiId", ctx.getForm().get( "entityId" ) );
        ctx.getForm().set( "emdadgarId", ctx.getForm().get( "entityId" ) );
        ctx.getForm().set( "password", "========" );
        ctx.getForm().set( "repassword", "========" );

        ctx.getRequest().setAttribute( FORM, ctx.getForm() );
        ctx.getForm().set( ACTION_TYPE, "update" );
        return ctx.getActionMapping().findForward( "edit" );
    }

    protected ActionForward doUpdate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                ShakhsModel vo = new ShakhsModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );

                int naghshId = vo.getNaghshId().intValue();
                if ( naghshId == Constants.getNamayandegiShoghlId() ) {
                    vo.setEntityId( (String) ctx.getForm().get( "namayandegiId" ) );
                } else if ( naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId() ) {
                    vo.setEntityId( (String) ctx.getForm().get( "emdadgarId" ) );
                }

                ( (ShakhsProxy) getProxy() ).update( vo, (String) ctx.getForm().get( "daftarOstaniId" ) );
                ComboPool.setDirty( ctx.getEntity() );
            } catch ( Exception e ) {
                e.printStackTrace();
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }

}
