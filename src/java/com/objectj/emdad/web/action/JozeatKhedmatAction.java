package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.EmdadXls;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import org.apache.struts.action.ActionForward;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @struts.action name="jozeatKhedmatForm"
 * path="/c/jozeatKhedmat"
 * pathPrime="/jozeatKhedmat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.edit.jsp"
 * inputPrime="emdad.jozeatKhedmat.edit"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/r/jozeatKhedmat"
 * pathPrime="/jozeatKhedmat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.read.jsp"
 * inputPrime="emdad.jozeatKhedmat.read"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/u/jozeatKhedmat"
 * pathPrime="/jozeatKhedmat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.edit.jsp"
 * inputPrime="emdad.jozeatKhedmat.edit"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/d/jozeatKhedmat"
 * pathPrime="/jozeatKhedmat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.read.jsp"
 * inputPrime="emdad.jozeatKhedmat.read"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/l/jozeatKhedmat"
 * pathPrime="/jozeatKhedmatList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.list.jsp"
 * inputPrime="emdad.jozeatKhedmat.list"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/c/validatejozeatKhedmat"
 * pathPrime="/validatejozeatKhedmat"
 * scope="request"
 * input="/c/jozeatKhedmat.run"
 * inputPrime="emdad.jozeatKhedmat.edit"
 * input4tiles="emdad.jozeatKhedmat.edit"
 * validate="true"
 * @struts.action name="jozeatKhedmatForm"
 * path="/s/validatejozeatKhedmat"
 * pathPrime="/jozeatKhedmat"
 * scope="request"
 * input="/s/jozeatKhedmat.run"
 * inputPrime="/s/jozeatKhedmat.run"
 * validate="true"
 * @struts.action name="jozeatKhedmatForm"
 * path="/u/validatejozeatKhedmat"
 * pathPrime="/validatejozeatKhedmat"
 * scope="request"
 * input="/u/jozeatKhedmat.run"
 * inputPrime="emdad.jozeatKhedmat.edit"
 * input4tiles="emdad.jozeatKhedmat.edit"
 * validate="true"
 * @struts.action name="jozeatKhedmatForm"
 * path="/s/jozeatKhedmat"
 * pathPrime="/computeHazineh"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.hazineh.jsp"
 * inputPrime="/com/objectj/emdad/jsp/jozeatKhedmat.hazineh.jsp"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/s/validateTasvieHesabNamayandegi"
 * pathPrime="/validateTasvieHesabNamayandegi"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * inputPrime="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/s/validateTasvieHesabEmdadgar"
 * pathPrime="/validateTasvieHesabEmdadgar"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * inputPrime="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * validate="false"
 * @struts.action name="jozeatKhedmatForm"
 * path="/s/validateTasvieHesabJarsaghil"
 * pathPrime="/validateTasvieHesabJarsaghil"
 * scope="request"
 * input="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * inputPrime="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.jozeatKhedmat.list"
 * pathPrime="emdad.jozeatKhedmat.list"
 * @struts.action-forward name="edit"
 * path="emdad.jozeatKhedmat.edit"
 * pathPrime="emdad.jozeatKhedmat.edit"
 * @struts.action-forward name="read"
 * path="emdad.jozeatKhedmat.read"
 * pathPrime="emdad.jozeatKhedmat.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="popupRead"
 * path="/com/objectj/emdad/jsp/jozeatKhedmat.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/jozeatKhedmat.show.jsp"
 * @struts.action-forward name="popupEdit"
 * path="/com/objectj/emdad/jsp/jozeatKhedmat.popup.edit.jsp"
 * pathPrime="/com/objectj/emdad/jsp/jozeatKhedmat.popup.edit.jsp"
 * @struts.action-forward name="refresh"
 * path="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 * pathPrime="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 * @struts.action-forward name="tasvieHesabList"
 * path="/com/objectj/emdad/jsp/jozeatKhedmat.tasvieHesab.list.jsp"
 * pathPrime="/com/objectj/emdad/jsp/jozeatKhedmat.tasvieHesab.list.jsp"
 * @struts.action-forward name="tasvieHesab"
 * path="emdad.jozeatKhedmat.tasvieHesab"
 * pathPrime="emdad.jozeatKhedmat.tasvieHesab"
 * @struts.action-forward name="computeHazineh"
 * path="/com/objectj/emdad/jsp/jozeatKhedmat.hazineh.jsp"
 * pathPrime="/com/objectj/emdad/jsp/jozeatKhedmat.hazineh.jsp"
 * @struts.action-forward name="tasvieHesabListEdit"
 * path="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * pathPrime="/com/objectj/emdad/jsp/jozeatKhedmat.emdad.list.edit.jsp"
 * @struts.action-forward name="emdadImported"
 * path="/com/objectj/emdad/jsp/emdadImported.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdadImported.jsp"
 */

public class JozeatKhedmatAction extends BaseAction {

    final static Integer noeKhedmat = new Integer( 1 );

    final static int POSSIBLE = 1;

    final static int IMPOSSIBLE = 2;

    final static int APPROVED = 1;

    final static int NOEEMDAD_TAMIR = 2;

    final static int NOEKHEDMAT_KHODROJAGOZIN = 4;

    ArrayList noeKhedmatList = new ArrayList();

    ArrayList guaranteeList = new ArrayList();

    protected Class getValueObjectClass() {
        return JozeatKhedmatModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"emdadId", "rokhdadId", "zamanEzam", "eshterakId", "noeEmdad", "namayandegiId"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"ojrat", "qate", "irad", "emdad"};
        //return new String[] { "jozeatKhedmat LEFT OUTER JOIN ojrat ON jozeatKhedmat.ojratId = ojrat.Id LEFT OUTER JOIN qate ON jozeatKhedmat.qateId = qate.Id LEFT OUTER JOIN irad ON jozeatKhedmat.iradId = irad.Id "};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return JozeatKhedmatSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {
        ArrayList ojratList1 = new ArrayList();
//		try {
//			iradList = IradSessionUtil.getLocalHome().create().readCombo("irad", "onvan").getResult();
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//			throw new ProxyException(e);
//		}

        guaranteeList = Util.getArrayList( "yesNo" );
        noeKhedmatList = Util.getArrayList( "noeKhedmat" );
//		ctx.getRequest().setAttribute("iradList", iradList);
        ctx.getRequest().setAttribute( "ojratList1", ojratList1 );
        ctx.getRequest().setAttribute( "guaranteeList", guaranteeList );
        ctx.getRequest().setAttribute( "noeKhedmatList", noeKhedmatList );

        ctx.getRequest().setAttribute( "taeedHesabdarList", guaranteeList );
        ctx.getRequest().setAttribute( "taeedGuaranteeList", guaranteeList );
        ctx.getRequest().setAttribute( "taeedNamayandegiList", guaranteeList );

        ctx.getRequest().setAttribute( "taeedNamayandegiName", "" );
        ctx.getRequest().setAttribute( "taeedGuaranteeName", "" );
        ctx.getRequest().setAttribute( "taeedHesabdarName", "" );

//		String role = new String("other");
//
//        role = ctx.getUserSession().getRole();
//		if (ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI))
//			role = "emdadgar";
//		else
//        if (ctx.isUserInRole(Constants.ROLE_GUARANTEE))
//            role = "guarantee";
//        else
//        if (ctx.isUserInRole(Constants.ROLE_NAMAYANDEMODIRIAT))
//            role = "namayandeh";
//        else
//        if (ctx.isUserInRole(Constants.ROLE_MALIOP))
//            role = "hesabdar";
//        else
//        if (ctx.isUserInRole(Constants.ROLE_NAMAYANDEGI))
//            role = "namayandegi";

        ctx.getRequest().setAttribute( "role", ctx.getUserSession().getRole() );
        ctx.getRequest().setAttribute( "isIjadKonandeh", new Integer( 1 ) );
    }

    protected ActionForward doCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
//=-= System.out.println("Create new Instance");
                JozeatKhedmatModel vo = new JozeatKhedmatModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                vo.setNoeKhedmat( noeKhedmat );

                vo.setIjadKonandeh( getUserId( ctx ) );

                updateEmdad( ctx.getForm().get( "khedmatId" ).toString() );

                ( (JozeatKhedmatProxy) getProxy() ).create( vo, ctx.getForm().get( "khedmatId" ).toString(), ctx.getForm().get( "ojratId" ).toString(), ctx.getForm().get( "qateId" ).toString(), ctx.getForm().get( "iradId" ).toString() );

            } catch ( Exception e ) {
                e.printStackTrace();
                throw new ProxyException( e );
            }
        }
        if ( ctx.getForm().get( "popup" ) != null && ctx.getForm().get( "popup" ).equals( new Boolean( true ) ) ) {
            ctx.getForm().set( "popup", new Boolean( false ) );
            return ctx.getActionMapping().findForward( "refresh" );
        } else {
            return listAll( ctx );
        }
    }

    protected ActionForward doUpdate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                JozeatKhedmatModel vo = new JozeatKhedmatModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                vo.setNoeKhedmat( noeKhedmat );
//                if (vo.getGuarantee().intValue() != 1 && vo.getTaeedHesabdar().intValue() == 1)
//                    vo.setTaeedGuarantee(new Integer(1));
                updateEmdad( ctx.getForm().get( "khedmatId" ).toString() );
                ( (JozeatKhedmatProxy) getProxy() ).update( vo, ctx.getForm().get( "khedmatId" ).toString(), ctx.getForm().get( "ojratId" ).toString(), ctx.getForm().get( "qateId" ).toString(), ctx.getForm().get( "iradId" ).toString() );
            } catch ( Exception e ) {
                e.printStackTrace();
                throw new ProxyException( e );
            }
        }
        if ( ctx.getForm().get( "popup" ) != null && ctx.getForm().get( "popup" ).equals( new Boolean( true ) ) ) {
            ctx.getForm().set( "popup", new Boolean( false ) );
            return ctx.getActionMapping().findForward( "refresh" );
        } else {
            return listAll( ctx );
        }
    }

    protected ActionForward doReadById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }
        try {
            JozeatKhedmatSessionLocalHome lhProxy = JozeatKhedmatSessionUtil.getLocalHome();
            JozeatKhedmatSessionLocal lProxy = lhProxy.create();
            JozeatKhedmatList voJozeatKhedmatList = (JozeatKhedmatList) lProxy.read( id );

            // set ijadKonandeh Name
            String ijadKonandeh = voJozeatKhedmatList.getIjadKonandeh();
            ShakhsSessionLocalHome shakhsSessionLocalHome = ShakhsSessionUtil.getLocalHome();
            ShakhsSessionLocal shakhsSessionLocal = shakhsSessionLocalHome.create();
            ValueObject voShakhsList = shakhsSessionLocal.read( ijadKonandeh );
            voJozeatKhedmatList.setIjadKonandeh( ( (ShakhsModel) voShakhsList ).getName() );

            ctx.getRequest().setAttribute( VALUE_OBJECT, voJozeatKhedmatList );
            if ( voJozeatKhedmatList.getNoeKhedmat().intValue() == NOEKHEDMAT_KHODROJAGOZIN ) {
                String emdadId = ( voJozeatKhedmatList ).getEmdadId();
                int modatKhab = getModatKhab( ctx, emdadId );
                if ( modatKhab >= 0 ) {
                    ctx.getRequest().setAttribute( "modatKhab", new Integer( modatKhab ) );
                } else {
                    ctx.getRequest().setAttribute( "modatKhab", Util.getProperty( "emdad.dates.invalid" ) );
                }

                int modatKhodroJagozin = getModatKhodroJagozin( ctx, emdadId );
                if ( modatKhodroJagozin >= 0 ) {
                    ctx.getRequest().setAttribute( "modatKhodrojagozin", new Integer( modatKhodroJagozin ) );
                } else {
                    ctx.getRequest().setAttribute( "modatKhodrojagozin", Util.getProperty( "khodrojagozin.dates.invalid" ) );
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }
        return ctx.getActionMapping().findForward( "read" );
    }

    protected ActionForward doEditById( BaseActionContext ctx ) throws ProxyException, ServletException {
        try {
            String id = (String) ctx.getForm().get( ValueObject.ID );

            if ( id == null ) {
                throw new ServletException( NULL_ID_MESSAGE );
            }

            ValueObject valueObject = getProxy().read( id );
            Exchanger.exhangeValueObjectToForm( valueObject, ctx.getForm() );

//            log.info("========== ((JozeatKhedmatList)valueObject).getIradId() = " + ((JozeatKhedmatList) valueObject).getIradId());
            String iradId = ( (JozeatKhedmatList) valueObject ).getIradIdCode();//UserAccessEntity.stringQuery("SELECT iradId FROM irad WHERE id = '" + ((JozeatKhedmatList)valueObject).getIradId() + "'", "iradId");
//            log.info("========== iradId = " + iradId);
//            ctx.getForm().set("iradIdCode", iradId);
//
//            String ojratId = ((JozeatKhedmatList)valueObject).getOjratIdCode();//UserAccessEntity.stringQuery("SELECT iradId FROM irad WHERE id = '" + ((JozeatKhedmatList)valueObject).getIradId() + "'", "iradId");
//            log.info("========== ojratId = " + ojratId);
//            ctx.getForm().set("ojratIdCode", ojratId);

            ctx.getRequest().setAttribute( "canChange", "true" );
//            int taeedHesabdar = ((JozeatKhedmatList)valueObject).getTaeedHesabdar().intValue();
//            int taeedGuarantee = ((JozeatKhedmatList)valueObject).getTaeedGuarantee().intValue();
//            int taeedNamayandegi = ((JozeatKhedmatList)valueObject).getTaeedNamayandegi().intValue();
//            if (((ctx.isUserInRole(Constants.ROLE_EMDADGARESTEKHDAMI) || ctx.isUserInRole(Constants.ROLE_EMDADGARPEYMANI))&& taeedHesabdar == 1) ||
//                (ctx.isUserInRole(Constants.ROLE_MALIOP) && taeedGuarantee == 1) ||
//                (ctx.isUserInRole(Constants.ROLE_GUARANTEE) && taeedNamayandegi == 1))
//                    ctx.getRequest().setAttribute("canChange", "false");


            if ( ( (JozeatKhedmatList) valueObject ).getQateName() != null ) {
                ctx.getRequest().setAttribute( "qateName", ( (JozeatKhedmatList) valueObject ).getQateName() );
            } else {
                ctx.getRequest().setAttribute( "qateName", "" );
            }

            if ( ( (JozeatKhedmatList) valueObject ).getGuaranteeName() != null ) {
                ctx.getRequest().setAttribute( "guaranteeName", ( (JozeatKhedmatList) valueObject ).getGuaranteeName() );
            } else {
                ctx.getRequest().setAttribute( "guaranteeName", "" );
            }
//            if (((JozeatKhedmatList)valueObject).getTaeedHesabdarName() != null)
//                ctx.getRequest().setAttribute("taeedHesabdarName", ((JozeatKhedmatList)valueObject).getTaeedHesabdarName());
//            else
//                ctx.getRequest().setAttribute("taeedHesabdarName", "");
//
//            if (((JozeatKhedmatList)valueObject).getTaeedGuaranteeName() != null)
//                ctx.getRequest().setAttribute("taeedGuaranteeName", ((JozeatKhedmatList)valueObject).getTaeedGuaranteeName());
//            else
//                ctx.getRequest().setAttribute("taeedGuaranteeName", "");
//
//            if (((JozeatKhedmatList)valueObject).getTaeedNamayandegiName() != null)
//                ctx.getRequest().setAttribute("taeedNamayandegiName", ((JozeatKhedmatList)valueObject).getTaeedNamayandegiName());
//            else
//                ctx.getRequest().setAttribute("taeedNamayandegiName","");
            ctx.getForm().set( ACTION_TYPE, "update" );

            if ( ( (JozeatKhedmatList) valueObject ).getIjadKonandeh().equals( getUserId( ctx ) ) ) {
                ctx.getRequest().setAttribute( "isIjadKonandeh", new Integer( 1 ) );
            } else {
                ctx.getRequest().setAttribute( "isIjadKonandeh", new Integer( 2 ) );
            }

            //String iradId = (String)ctx.getForm().get("iradId");
            ArrayList ojratList = null;

//            log.info("========== iradId  = " + iradId);
            ojratList = IradSessionUtil.getLocalHome().create().readCombo( "ojrat", "onvan", "ojratId LIKE '" + iradId.substring( 0, 2 ) + "%'" ).getResult();

            ctx.getRequest().setAttribute( "ojratList1", ojratList );

        } catch ( Exception e ) {
        }

        return ctx.getActionMapping().findForward( "edit" );
    }


    protected String getForceFilter( BaseActionContext ctx ) {
        return ctx.getUserSession().getForceFilter( ctx.getEntity() );
    }

    private ActionForward doTaeed( BaseActionContext ctx ) {
        try {
            QueryObject qo = new QueryObject();
            qo.setTables( "jozeatKhedmat" );
            qo.setWhere( "jozeatKhedmat.taeedNamayandegi = 2" );
            qo.setSelectFields( "id, taeedNamayandegi" );
            qo.setJoined( false );
            ResultSet rs = JozeatKhedmatUtil.getLocalHome().advanceRead( ctx.getConnection(), qo );

            JozeatKhedmatSessionLocalHome lhProxy = JozeatKhedmatSessionUtil.getLocalHome();
            JozeatKhedmatSessionLocal lProxy = lhProxy.create();

            while ( rs.next() ) {
                JozeatKhedmatList voJozeatKhedmatList = (JozeatKhedmatList) lProxy.read( rs.getString( "id" ) );
                voJozeatKhedmatList.setTaeedNamayandegi( new Integer( 1 ) );
                ( (JozeatKhedmatProxy) getProxy() ).update( voJozeatKhedmatList, voJozeatKhedmatList.getEmdadId(), voJozeatKhedmatList.getOjratId(), voJozeatKhedmatList.getQateId(), voJozeatKhedmatList.getIradId() );
            }
            rs.close();
            EmdadSessionLocal emdadSessionLocal = EmdadSessionUtil.getLocalHome().create();
//            log.info("============ (String)ctx.getForm().get(ID) = " + (String) ctx.getForm().get(ID));
            EmdadList voEmdadList = (EmdadList) emdadSessionLocal.read( (String) ctx.getForm().get( ID ) );
//            log.info("========== voEmdadList.getEmdadId() = " + voEmdadList.getEmdadId());
//            log.info("========== voEmdadList.getMaliDone() = " + voEmdadList.getMaliDone());
            voEmdadList.setMaliDone( new Integer( 1 ) );
            emdadSessionLocal.update( voEmdadList, voEmdadList.getRokhdadId(), voEmdadList.getVazeatKhedmatId(), voEmdadList.getEmdadgarId(), voEmdadList.getEzamgarId(), voEmdadList.getDalileToolKeshidaneEmdadId(), voEmdadList.getNamayandegiId() );
//            log.info("========== voEmdadList.getMaliDone() = " + voEmdadList.getMaliDone());
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

    private ActionForward validateTasvieHesab( BaseActionContext ctx ) {
        /** This method manages editable jozeatkhedmat list and also validates them and so too much.
         *  it should be broken into two actions. */
        try {
            //String emdadId = (String)ctx.getForm().get(ValueObject.ID);
            String emdadId = ctx.getRequest().getParameter( "emdadId" );
            emdadId = UserAccessEntity.stringQuery( "SELECT id FROM emdad WHERE emdadId = '" + emdadId + "'", "id", ctx.getConnection() );
            log.info( "Oomadim Bara Validate TasvieHesab Bara EmdadId=" + emdadId );
            String noeKhodroId = ctx.getRequest().getParameter( "noeKhodroId" );
            String noeTasvieh = ctx.getRequest().getParameter( "noeTasvieh" );
            log.info( "NoeTasviehHesab=" + noeTasvieh );
            ctx.getRequest().setAttribute( "noeTasvieh", noeTasvieh );
            String taeed = ctx.getRequest().getParameter( "taeed" );
            String emdadgarId = null;
            boolean hasGuarantee = false;
            boolean hasError = false;
            char role = 'x';
            if ( taeed.length() == 1 ) {
                role = taeed.charAt( 0 );
            } else if ( taeed.length() == 2 ) {
                role = taeed.charAt( 1 );
            } else if ( taeed.length() == 3 ) {
                role = taeed.charAt( 2 );
            }
            log.info( "Role shakhs=" + role );
            ctx.getRequest().setAttribute( "role", role + "" );
            //ctx.getRequest().setAttribute( "user", getUserId(ctx) );
            int taeeded = Integer.parseInt( ( ctx.getRequest().getParameter( "taeedHesabdar" ) == null ) ? "2" : ctx.getRequest().getParameter( "taeedHesabdar" ) );
            log.info( "TaeedHesabdar=" + taeeded );
            if ( taeeded != 1 && role == 'h' || role == 'e' || role == 'm' ) {
                log.info( "Oomadim Bara check-e Har Satr" );
                JozeatKhedmatModel vo = null;
                int i = 0;
                String id = ctx.getRequest().getParameter( "id" + i );
                ArrayList valueObjectList = (ArrayList) ctx.getRequest().getAttribute( VALUE_OBJECT_LIST );
                int size = valueObjectList.size();
                log.info( "Size-e Jozeatkhedmatha( valueObjectList )=" + size );
                JozeatKhedmatList jozeatKhedmatList;
                int[] removes = new int[ size ];
                int rows = Integer.parseInt( ctx.getRequest().getParameter( "rows" ) );
                log.info( "Tedad Satrha( rows )=" + rows );
                boolean[] errorIn = new boolean[ rows ];
                String[] ojratha = new String[ rows ];
                String[] qateha = new String[ rows ];
                String[] iradha = new String[ rows ];
                int total = 0;
                while ( id != null ) {
                    log.info( "=====Proccessing id" + i + " parameter=" + id );
                    if ( ctx.getRequest().getParameter( "delete" + i ) == null ) {
                        String irad = ctx.getRequest().getParameter( "iradId" + i );
                        irad = ( irad == null ) ? "" : irad;
                        log.info( " ****** Irad" + " " + i + irad );
                        iradha[ i ] = ( irad == null || irad.length() == 0 ) ? "null" + i : irad;
                        log.info( " ****** Iradha" + i + " " + iradha[ i ] );
                        String o = ctx.getRequest().getParameter( "ojratId" + i );
                        o = ( o == null ) ? "" : o;
                        log.info( " ******** Ojrat" + i + " " + o );
                        ojratha[ i ] = ( o == null || o.length() == 0 ) ? "null" + i : o;
                        log.info( " ********************************** Ojratha" + i + " " + ojratha[ i ] );
                        String sf = ctx.getRequest().getParameter( "shomarehFanni" + i );
                        sf = ( sf == null ) ? "" : sf;
                        log.info( " ********************************** ShomareFanni" + i + " " + sf );
                        qateha[ i ] = ( sf == null || sf.length() == 0 ) ? "null" + i : sf;
                        log.info( " ********************************** qateha" + i + " " + qateha[ i ] );

                        String t = ctx.getRequest().getParameter( "tedadQate" + i );
                        Integer tedadQate = Integer.valueOf( com.objectj.emdad.ejb.util.Util.isEmpty( t ) ? "0" : t );
                        if ( sf.length() == 0 ) {
                            tedadQate = new Integer( 0 );
                        }

                        String g = ctx.getRequest().getParameter( "guarantee" + i );
                        log.info( " ============================= Guarantee0: " + g );
                        Integer guarantee = Integer.valueOf( com.objectj.emdad.ejb.util.Util.isEmpty( g ) ? "2" : g );
                        if ( guarantee.intValue() == 1 ) {
                            hasGuarantee = true;
                        }

                        String h = ctx.getRequest().getParameter( "hazineh" + i );
                        Integer hazineh = Integer.valueOf( com.objectj.emdad.ejb.util.Util.isEmpty( h ) ? "0" : h );
                        log.info( " ============================= hazineh: " + hazineh );

                        String m = ctx.getRequest().getParameter( "manbaeTahiyeh" + i );
                        log.info( " ============================= manbaeTahiye0: " + m );
                        Integer manbae = Integer.valueOf( com.objectj.emdad.ejb.util.Util.isEmpty( m ) ? "2" : m );
                        log.info( " ============================= manbaeTahiye: " + manbae );

                        String p = ctx.getRequest().getParameter( "nahveyePardakht" + i );
                        log.info( " ============================= NahvePardakht0: " + p );
                        Integer pardakht = Integer.valueOf( com.objectj.emdad.ejb.util.Util.isEmpty( p ) ? "2" : p );
                        log.info( " ============================= NahvePardakht: " + pardakht );

                        String iradId = "";
                        String qateId = "";
                        String ojratId = "";

                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( irad ) ) {
                            iradId = UserAccessEntity.stringQuery( "SELECT id FROM irad WHERE iradId = '" + irad + "'", "id", ctx.getConnection() );
                        }
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( sf ) ) {
                            qateId = UserAccessEntity.stringQuery( "SELECT id FROM qate WHERE shomareFanni = '" + sf + "'", "id", ctx.getConnection() );
                        }
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( o ) ) {
                            ojratId = UserAccessEntity.stringQuery( "SELECT id FROM ojrat WHERE ojratId = '" + o + "'", "id", ctx.getConnection() );
                        }

                        int hazinehDefault = computeHazineh( ctx, ojratId, qateId, noeKhodroId, tedadQate.intValue(), i );
                        log.info( " =======Hazineh Default Hesab Shode Ast: " + hazinehDefault );

                        if ( i < size ) {
                            log.info( "Mored Vojood dashte dar dafeye=" + i + "om dar arraye list" );
                            jozeatKhedmatList = (JozeatKhedmatList) valueObjectList.get( i );
                            log.info( "modele vojood dashte dar dafeye " + i + "om dar khode jozeatKhedmatModel" );
                            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( id ) ) {
                                JozeatKhedmatLocalHome jKhLocalHome = JozeatKhedmatUtil.getLocalHome();
                                JozeatKhedmatLocal jKhLocal = jKhLocalHome.findByPrimaryKey( id );
                                vo = jKhLocal.getJozeatKhedmatModel();
                            }
                        } else {
                            log.info( "========================== Morede Jadid Shode dar dafeye=" + i + "om dar arraye list" );
                            jozeatKhedmatList = new JozeatKhedmatList();
                            log.info( "modele jadid ba id-ye khali dar dafeye " + i + "om dar khode jozeatKhedmatModel" );
                            vo = new JozeatKhedmatModel();
                            vo.setIjadKonandeh( getUserId( ctx ) );
                            vo.setNoeKhedmat( new Integer( NOEKHEDMAT_KHODROJAGOZIN ) );
                        }

                        /////////////////////////// Form Validation!
                        log.info( "Hala Validatione Satre=" + i );
                        for ( int ghabli = i - 1; ghabli >= 0; ghabli-- ) {
                            if ( ojratha[ i ].length() != 0 && ojratha[ i ].equalsIgnoreCase( ojratha[ ghabli ] ) ) {
                                ctx.getRequest().setAttribute( "ojratIdError" + i, "true" );
                                log.info( "=====================ojratIdError" + i + " " + ojratha[ i ] );
                                errorIn[ i ] = true;
                                ctx.getRequest().setAttribute( "ojratIdError" + ghabli, "true" );
                                errorIn[ ghabli ] = true;
                                log.info( "=====================ojratIdError" + ghabli + "  " + ojratha[ ghabli ] );
                                hasError = true;
                            }
                            if ( qateha[ i ].length() != 0 && qateha[ i ].equalsIgnoreCase( qateha[ ghabli ] ) ) {
                                ctx.getRequest().setAttribute( "shomarehFanniError" + i, "true" );
                                log.info( "=====================shomarehFanniError" + i + " " + qateha[ i ] );
                                errorIn[ i ] = true;
                                ctx.getRequest().setAttribute( "shomarehFanniError" + ghabli, "true" );
                                errorIn[ ghabli ] = true;
                                log.info( "=====================shomarehFanniError" + ghabli + " " + qateha[ ghabli ] );
                                hasError = true;
                            }
                        }
                        if ( ( o.length() == 0 && irad.length() != 0 ) || ( o.length() != 0 && irad.length() == 0 ) ) {
                            ctx.getRequest().setAttribute( "iradIdError" + i, "true" );
                            ctx.getRequest().setAttribute( "ojratIdError" + i, "true" );
                            errorIn[ i ] = true;
                            hasError = true;
                            log.info( " ********************* Irad Bedoone Ojrat" );
                        }
                        //validate through the input: code o & sf
                        if ( o.length() == 0 ) {
                            if ( sf == null || sf.length() == 0 ) {
                                ctx.getRequest().setAttribute( "ojratIdError" + i, "true" );
                                log.info( "=====================ojratIdError" + i + " OJRAT AND QATE." );
                                ctx.getRequest().setAttribute( "shomarehFanniError" + i, "true" );
                                log.info( "=====================shomarehFanniError" + i + " OJRAT AND QATE." );
                                errorIn[ i ] = true;
                                hasError = true;
                            } else if ( o.length() != 0 ) {
                                ctx.getRequest().setAttribute( "ojratIdError" + i, "true" );
                                log.info( "=====================ojratIdError" + i + " Ojrat NOT FOUND" );
                                errorIn[ i ] = true;
                                hasError = true;
                            }
                        }
                        if ( ( iradId.length() == 0 ) && irad.length() != 0 ) {
                            ctx.getRequest().setAttribute( "iradIdError" + i, "true" );
                            log.info( "=====================iradIdError" + i + " IRAD NOT FOUND" );
                            errorIn[ i ] = true;
                            hasError = true;
                        }

                        if ( !com.objectj.emdad.ejb.util.Util.isEmpty( qateId ) ) {
                            String thisNoeKhodroId = UserAccessEntity.stringQuery( "SELECT noeKhodroId FROM qate WHERE id = '" + qateId + "'", "noeKhodroId", ctx.getConnection() );
                            if ( !noeKhodroId.equals( thisNoeKhodroId ) ) {
                                ctx.getRequest().setAttribute( "shomarehFanniError" + i, "true" );
                                errorIn[ i ] = true;
                                hasError = true;
                            }
                        }

                        if ( ( qateId.length() == 0 ) && sf.length() != 0 ) {
                            ctx.getRequest().setAttribute( "shomarehFanniError" + i, "true" );
                            log.info( "=====================qateIdError" + i + " QATE NOT FOUND" );
                            errorIn[ i ] = true;
                            hasError = true;
                        }
                        if ( ( sf.length() != 0 ) && tedadQate.intValue() <= 0 ) {
                            ctx.getRequest().setAttribute( "tedadQateError" + i, "true" );
                            errorIn[ i ] = true;
                            hasError = true;
                        }
                        if ( noeTasvieh.equals( "emdadgar" ) && tedadQate.intValue() != 0 ) {
                            if ( com.objectj.emdad.ejb.util.Util.isEmpty( emdadgarId ) ) {
                                emdadgarId = UserAccessEntity.stringQuery( "SELECT emdadgarId FROM emdad WHERE id = '" + emdadId + "'", "emdadgarId", ctx.getConnection() );
                            }
                            if ( !Validators.updateMojoodiAllowed( emdadgarId, qateId, tedadQate ) ) {
                                ctx.getRequest().setAttribute( "mojoodiManfiError" + i, "true" );
                                hasError = true;
                            }
                        }
                        // Updating' listview
                        jozeatKhedmatList.setGuarantee( guarantee );
                        jozeatKhedmatList.setHazinehDefault( new Integer( hazinehDefault ) );
                        jozeatKhedmatList.setHazineh( hazineh.intValue() == 0 ? jozeatKhedmatList.getHazinehDefault() : hazineh );
                        jozeatKhedmatList.setIradId( irad );
                        jozeatKhedmatList.setOjratId( o );
                        jozeatKhedmatList.setShomarehFanni( sf );
                        jozeatKhedmatList.setTedadQate( tedadQate );
                        jozeatKhedmatList.setNahveyePardakht( pardakht );
                        jozeatKhedmatList.setManbaeTahiyeh( manbae );
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( irad ) ) {
                            jozeatKhedmatList.setIradOnvan( UserAccessEntity.stringQuery( "SELECT onvan FROM irad WHERE iradId = '" + irad + "'", "onvan", ctx.getConnection() ) );
                        }
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( o ) ) {
                            jozeatKhedmatList.setOjratOnvan( UserAccessEntity.stringQuery( "SELECT onvan FROM ojrat WHERE ojratId = '" + o + "'", "onvan", ctx.getConnection() ) );
                        }
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( sf ) ) {
                            jozeatKhedmatList.setQateName( UserAccessEntity.stringQuery( "SELECT name FROM qate WHERE shomareFanni = '" + sf + "'", "name", ctx.getConnection() ) );
                        }
                        // Updain' JozeatKhedmat Model
                        vo.setTedadQate( tedadQate );
                        vo.setGuarantee( guarantee );
                        vo.setHazinehDefault( new Integer( hazinehDefault ) );
                        vo.setHazineh( ( hazineh.intValue() == 0 ) ? vo.getHazinehDefault() : hazineh );
                        vo.setNahveyePardakht( pardakht );
                        vo.setManbaeTahiyeh( manbae );
                        if ( !errorIn[ i ] ) {
                            // Item without any error
                            if ( i >= size ) {
                                // New added row
                                log.info( "======================creating id" + i + " parameter. " );
                                ( (JozeatKhedmatProxy) getProxy() ).create( vo, emdadId, ojratId, qateId, iradId );
                                jozeatKhedmatList.setId( vo.getId() );
                                valueObjectList.add( jozeatKhedmatList );
                            } else {
                                if ( com.objectj.emdad.ejb.util.Util.isEmpty( id ) ) {
                                    // Already added row but just in listview
                                    log.info( "======================creating id" + i + " parameter. " );
                                    ( (JozeatKhedmatProxy) getProxy() ).create( vo, emdadId, ojratId, qateId, iradId );
                                    jozeatKhedmatList.setId( vo.getId() );
                                    valueObjectList.add( jozeatKhedmatList );
                                }
                                log.info( "======================updating id" + i + " parameter." );
                                ( (JozeatKhedmatProxy) getProxy() ).update( vo, emdadId, ojratId, qateId, iradId );
                                // No update to listview!
                            }
                        } else {
                            // Item with error ( just for newly added rows )
                            if ( i >= size ) {
                                valueObjectList.add( jozeatKhedmatList );
                            }
                        }
                    } else {
                        if ( id.length() != 0 ) {
                            log.info( "======================removing id" + i + " parameter." );
                            removes[ total++ ] = i;
                            log.info( "removes[ " + ( total - 1 ) + " ] = " + i );
                            getProxy().remove( id );
                        }
                    }
                    i++;
                    id = ctx.getRequest().getParameter( "id" + i );
                }
                for ( int j = total - 1; j >= 0; j-- ) {
                    log.info( "Remove az arraye list bara=" + removes[ j ] );
                    valueObjectList.remove( removes[ j ] );
                }
                ctx.getRequest().setAttribute( VALUE_OBJECT_LIST, valueObjectList );
            }
            // Update shodan
            if ( taeed.length() < 3 || ctx.getRequest().getParameter( "updateable" ).equals( "true" ) ) {
                log.info( "///////////////////////////////// TAEED: " + taeed + "//////////////////////" );
                updateEmdad( ctx, emdadId, hasError ? "xxh" : taeed, hasGuarantee );
            }
            if ( !hasError ) {
                // Adame taeed jozeatKhedmat Taeed = nh, nn, nm
                if ( taeed.length() == 2 ) {
                    ctx.getRequest().setAttribute( "emdadAdamTaeed", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                }
                // Taeede jozeatKhedmat  Taeed = h, n, m
                if ( taeed.length() == 1 ) {
                    ctx.getRequest().setAttribute( "emdadTaeed", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
    }


    private ActionForward tasvieHesabList( BaseActionContext ctx ) {
        try {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.getRequest().setAttribute( "user", getUserId( ctx ) );
            String emdadId = (String) ctx.getForm().get( ValueObject.ID );
            log.info( "000 emdadId=" + emdadId );
            String noeTasvieh = ctx.getRequest().getParameter( "noeTasvieh" );
            if ( noeTasvieh == null ) {
                noeTasvieh = (String) ctx.getForm().get( "noeTasvieh" );
            }
            ctx.getRequest().setAttribute( "noeTasvieh", noeTasvieh );
            log.info( "NoeTasvie In tasviehHesab: " + noeTasvieh );
//            if( ctx.getSubAction().equals("validateTasvieHesabNamayandegi") ) {
//                emdadId = ctx.getRequest().getParameter( "emdadId" );
//            }
            if ( ctx.getSubAction().endsWith( "ListEdit" ) ) {
                String id = ctx.getRequest().getParameter( "dastoorKar" );
                log.info( "EH! EMDAD ID= " + id );
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( id ) ) {
                    emdadId = id;
                }
                log.info( "111 emdadId=" + emdadId );
                emdadId = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId" );
                if ( com.objectj.emdad.ejb.util.Util.isEmpty( emdadId ) || emdadId.equals( "0" ) ) {
                    String shomarehFactor = ctx.getRequest().getParameter( "shomarehFactor" );
                    String namayandegiId = ctx.getRequest().getParameter( "namayandegiId" );
                    if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( shomarehFactor ) && namayandegiId.length() != 0 && emdadId == null ) {
                        namayandegiId = UserAccessEntity.stringQuery( "select id from namayandegi where namayandegiId='" + namayandegiId + "'", "id" );
                        emdadId = UserAccessEntity.stringQuery( "select id from emdad where namayandegiId='" + namayandegiId + "' AND shomarehFactor='" + shomarehFactor + "'", "id" );
                    }
                }
            } else {
                emdadId = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId" );
            }
            log.info( "222 emdadId=" + emdadId );
            if ( com.objectj.emdad.ejb.util.Util.isEmpty( emdadId ) ) {
                log.info( "======= emdadId invalid." );
                ctx.getRequest().setAttribute( "invalidEmdadId", "true" );
                return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
            }
            log.info( "====== emdadId: " + emdadId );
            EmdadList emdad = null;
            try {
                Util.getArrayList( "noeEmdadName" );
                Util.getArrayList( "noeService" );
                emdad = (EmdadList) EmdadSessionUtil.getLocalHome().create().read( emdadId );
                ctx.getRequest().setAttribute( "emdad", emdad );
                int emdadPayan = ( emdad.getVazeatKonuni() == null ) ? 0 : emdad.getVazeatKonuni().intValue();
                if ( emdadPayan != 2 ) {
                    ctx.getRequest().setAttribute( "emdadKhatemeNaYafteh", "true" );
                    log.info( "emdadKhatemeh NaYafte" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                }
//                log.info ( " DIDI !!!: " + ctx.getSubAction() );
                int taeedHesabdar = emdad.getTaeedHesabdar() == null ? 2 : emdad.getTaeedHesabdar().intValue();
                int taeedGuarantee = emdad.getTaeedGuarantee() == null ? 2 : emdad.getTaeedGuarantee().intValue();
                //if ( ctx.getSubAction().equals("tasvieHesabNamayandegiListEdit") ) {
                if ( ( ctx.getUserSession().isUserInRole( Constants.ROLE_GUARANTEE ) && taeedHesabdar != 1 ) ||
                        ( ctx.getUserSession().isUserInRole( Constants.ROLE_NAMAYANDEMODIRIAT ) && taeedGuarantee != 1 ) ) {
                    ctx.getRequest().setAttribute( "emdadNoAccess", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                }
                //}
            } catch ( Exception e ) {
                e.printStackTrace();
            }


            log.info( " action type: " + ctx.getSubAction() );
            log.info( " Emdad : " + emdad );

            String[] rls = UserAccessEntity.stringQuerys( "Select idNoeKhodro,onvan, moshtarakYaNa, noeService from moshtarakList where eshterakId='" + emdad.getMoshtarakId() + "'", "idNoeKhodro,onvan,moshtarakYaNa,noeService", ctx.getConnection() );
            ctx.getRequest().setAttribute( "noeKhodroId", rls[ 0 ] );
            ctx.getRequest().setAttribute( "noeKhodroOnvan", rls[ 1 ] );
            ctx.getRequest().setAttribute( "moshtarakYaNa", rls[ 2 ] );
            ctx.getRequest().setAttribute( "noeService", com.objectj.emdad.ejb.util.Util.getNameFromArrayList( "noeService", Integer.parseInt( rls[ 3 ] ) ) );

            char role = 'o'; //other
            if ( noeTasvieh == null ) {
                log.info( "======= error noeTasvieh = " + noeTasvieh );
                return ctx.getActionMapping().findForward( "showNotFound" );
            }
            //---------------------------------- Checking user access ----------------------------
            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
                if ( noeTasvieh.equals( "namayandegi" ) ) {
                    log.info( "======== Access is Denied 1." );
                    ctx.getRequest().setAttribute( "emdadNoAccess", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                    //return ctx.getActionMapping().findForward("accessDenied");
                }
                String emdadgarId = emdad.getEmdadgarId(); //UserAccessEntity.stringQuery("SELECT emdadgarId  FROM emdad WHERE id = '" + emdadId + "'", "emdadgarId");
                log.info( "==== emdadgarId = " + emdadgarId );
                log.info( UserAccessEntity.getEntityId( ctx.getUserSession().getName() ) );
                if ( emdadgarId == null || !emdadgarId.equals( UserAccessEntity.getEntityId( ctx.getUserSession().getName() ) ) ) {
                    log.info( "========= Access is Denied 2." );
                    ctx.getRequest().setAttribute( "emdadNoAccess", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                    //return ctx.getActionMapping().findForward("accessDenied");
                }
            } else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEGI ) ) {
                String namayandegiId = emdad.getNamayandegiId(); // UserAccessEntity.stringQuery("SELECT namayandegiId  FROM emdad WHERE id = '" + emdadId + "'", "namayandegiId");
                log.info( "======== namayandegiId = " + namayandegiId );
                if ( namayandegiId == null || !namayandegiId.equals( UserAccessEntity.getEntityId( ctx.getUserSession().getName() ) ) ) {
                    log.info( "=========== Access is Denied 3." );
                    ctx.getRequest().setAttribute( "emdadNoAccess", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                    //return ctx.getActionMapping().findForward("accessDenied");
                }
            } else if ( !ctx.getUserSession().getEntityAccess( ctx.getEntity() ).getAllAccess() ) {
                log.info( "========  daftarOstani false! " );
                String daftarOstaniId = emdad.getDaftarOstaniId(); // UserAccessEntity.stringQuery("SELECT daftarOstaniId FROM rokhdad WHERE id = '" + rokhdadId + "'", "daftarOstaniId");
                if ( !daftarOstaniId.equals( ctx.getUserSession().getDaftarOstani() ) ) {
                    log.info( "======== Access is Denied 4." );
                    ctx.getRequest().setAttribute( "emdadNoAccess", "true" );
                    return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
                    //return ctx.getActionMapping().findForward("accessDenied");
                }
            }

            //------------------------------------------------------------------------------------
            String dastorkar = emdad.getEmdadId().toString();
            ctx.getForm().set( "dastorkar", Integer.valueOf( dastorkar ) );

            //------------------------------------------------------------------------------------
            if ( noeTasvieh.equals( "namayandegi" ) && ctx.isUserInRole( Constants.ROLE_MALIOP ) && ( emdad.getNoeEmdad().intValue() == NOEEMDAD_TAMIR ) ) {
                String count = UserAccessEntity.stringQuery( "SELECT COUNT (id) as count FROM jozeatKhedmat WHERE jozeatKhedmat.khedmatId = '" + emdadId + "' AND noeKhedmat = " + NOEKHEDMAT_KHODROJAGOZIN, "count", ctx.getConnection() );
                log.info( "====== count Khodro Jagozin = " + count );
                if ( count.equals( "0" ) ) {
                    int modatKhodroJagozin = getModatKhodroJagozin( ctx, emdadId );
                    int modatKhab = getModatKhab( ctx, emdadId );
                    int diff = modatKhab - modatKhodroJagozin;
                    log.info( "========== rooz diff = " + diff );
                    if ( ( modatKhodroJagozin >= 0 ) && ( modatKhab >= 0 ) && ( diff >= 0 ) ) {
                        try {
                            int hazineh = diff * 100000;
                            JozeatKhedmatModel vo = new JozeatKhedmatModel();
                            vo.setGuarantee( new Integer( 1 ) );
                            vo.setHazineh( new Integer( hazineh ) );
                            vo.setHazinehDefault( new Integer( hazineh ) );
                            vo.setIjadKonandeh( getUserId( ctx ) );
                            vo.setNoeKhedmat( new Integer( NOEKHEDMAT_KHODROJAGOZIN ) );
                            vo.setTaeedGuarantee( new Integer( 1 ) );
                            vo.setTaeedHesabdar( new Integer( 1 ) );
                            vo.setTaeedNamayandegi( new Integer( 2 ) );
                            vo.setTedadQate( new Integer( 0 ) );
                            ( (JozeatKhedmatProxy) getProxy() ).create( vo, emdadId, null, null, null );
                        } catch ( Exception e ) {
                            e.printStackTrace();
                            throw new ProxyException( e );
                        }
                    }
                }
            }

            //------------------------------------------------------------------------------------
            String filter = "jozeatKhedmat.khedmatId = 'S" + emdadId + "' ";

            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
                role = 'e'; // emdadgar
            } else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEGI ) ) {
                role = 'm'; // namayandegi
            } else if ( ctx.isUserInRole( Constants.ROLE_GUARANTEE ) ) {
                role = 'g'; // guarantee
                filter += " AND jozeatKhedmat.guarantee = 'I1' AND jozeatKhedmat.taeedHesabdar = 'I1'";
            } else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEMODIRIAT ) ) {
                role = 'n'; // namayandeh
                filter += " AND jozeatKhedmat.taeedGuarantee = 'I1'";
//                if (noeTasvieh.equals("emdadgar"))
//                    filter += " AND jozeatKhedmat.taeedGuarantee = 'I1'";
//                else if (noeTasvieh.equals("namayandegi"))
//                    filter += " AND jozeatKhedmat.taeedHesabdar = 'I1'";
            }

            if ( ctx.isUserInRole( Constants.ROLE_MALIOP ) ) {
                role = 'h'; // hesabdar
            }
            ctx.getRequest().setAttribute( "role", role + "" );
            log.info( "===== role: " + ctx.getRequest().getAttribute( "role" ) );
            doTemporarySpecific( ctx, filter, null );

            ArrayList valueObjectList = (ArrayList) ctx.getRequest().getAttribute( VALUE_OBJECT_LIST );

            boolean taeedModiriatPossible = false,
                    canEdit = false;
            if ( role == 'e' || role == 'm' || role == 'h' || role == 'n' || role == 'g' ) {
                canEdit = true;
            }

            boolean deletePossible = false,
                    createPossible = ctx.getUserSession().getEntityAccess( ctx.getEntity() ).getCreateAccess();
            JozeatKhedmatList jozeatKhedmatList;

            for ( int i = 0; i < valueObjectList.size(); i++ ) {
                jozeatKhedmatList = (JozeatKhedmatList) valueObjectList.get( i );
                jozeatKhedmatList.setFieldDeleteAccess( new Integer( IMPOSSIBLE ) );
                jozeatKhedmatList.setFieldUpdateAccess( new Integer( IMPOSSIBLE ) );

                if ( ( role == 'e' && noeTasvieh.equals( "jarsaghil" ) ) || ( role == 'n' ) ) {
                    canEdit = false;
                }

                switch ( role ) {
                    case 'e':
                        if ( noeTasvieh.equals( "emdadgar" ) )
//                            (jozeatKhedmatList.getTaeedHesabdar().intValue() != APPROVED) &&
                        {
                            if ( jozeatKhedmatList.getIjadKonandeh().equals( getUserId( ctx ) ) ) {
                                jozeatKhedmatList.setFieldUpdateAccess( new Integer( POSSIBLE ) );
                                jozeatKhedmatList.setFieldDeleteAccess( new Integer( POSSIBLE ) );
                                deletePossible = true;
                            }
                        }
                        break;

                    case 'm':  //namayandegi
                        if ( noeTasvieh.equals( "namayandegi" ) )
//                            (jozeatKhedmatList.getTaeedHesabdar().intValue() != APPROVED) &&
                        {
                            if ( jozeatKhedmatList.getIjadKonandeh().equals( getUserId( ctx ) ) ) {
                                jozeatKhedmatList.setFieldUpdateAccess( new Integer( POSSIBLE ) );
                                jozeatKhedmatList.setFieldDeleteAccess( new Integer( POSSIBLE ) );
                                deletePossible = true;
                            }
                        }
                        break;

                    case 'h':
                        if ( noeTasvieh.equals( "emdadgar" ) ) {
                            log.info( "==========  emdadgar " );
                            if ( jozeatKhedmatList.getIjadKonandeh().equals( getUserId( ctx ) ) ) {
                                log.info( "========== h, emdadgar, hazineh = " + jozeatKhedmatList.getHazineh() );
                                jozeatKhedmatList.setFieldUpdateAccess( new Integer( POSSIBLE ) );
                                jozeatKhedmatList.setFieldDeleteAccess( new Integer( POSSIBLE ) );
                                deletePossible = true;
                            }
                        } else if ( ( noeTasvieh.equals( "jarsaghil" ) || ( noeTasvieh.equals( "namayandegi" ) ) ) && jozeatKhedmatList.getIjadKonandeh().equals( getUserId( ctx ) ) ) {
//                            if ((jozeatKhedmatList.getTaeedNamayandegi().intValue() != APPROVED)){
                            jozeatKhedmatList.setFieldUpdateAccess( new Integer( POSSIBLE ) );
                            jozeatKhedmatList.setFieldDeleteAccess( new Integer( POSSIBLE ) );
                            deletePossible = true;
//                            }
                        }
                        break;

                    case 'g':
                        int taeed = jozeatKhedmatList.getTaeedNamayandegi() == null ? 2 : jozeatKhedmatList.getTaeedNamayandegi().intValue();
                        if ( taeed != APPROVED ) {
                            jozeatKhedmatList.setFieldUpdateAccess( new Integer( POSSIBLE ) );
                        }
                        break;

                    case 'n':
                        break;

                    default:
                }

                int taeed2 = jozeatKhedmatList.getTaeedNamayandegi() == null ? 2 : jozeatKhedmatList.getTaeedNamayandegi().intValue();
                if ( ( role != 'n' && taeed2 == APPROVED ) ||
                        ( role == 'n' && taeed2 != APPROVED ) ) {
                    taeedModiriatPossible = true;
                    canEdit = false;
                    break;
                }
            }


            if ( taeedModiriatPossible || !canEdit ) {
                deletePossible = false;
                createPossible = false;

                for ( int j = 0; j < valueObjectList.size(); j++ ) {
                    jozeatKhedmatList = (JozeatKhedmatList) valueObjectList.get( j );
                    jozeatKhedmatList.setFieldUpdateAccess( new Integer( IMPOSSIBLE ) );
                    jozeatKhedmatList.setFieldDeleteAccess( new Integer( IMPOSSIBLE ) );
                }
            }
            ctx.getRequest().setAttribute( VALUE_OBJECT_LIST, valueObjectList );
            ctx.getRequest().setAttribute( "createPossible", new Boolean( createPossible ) );
            ctx.getRequest().setAttribute( "deletePossible", new Boolean( deletePossible ) );
            ctx.getRequest().setAttribute( "taeedModiriatPossible", new Boolean( taeedModiriatPossible ) );

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        if ( ctx.getSubAction().startsWith( "validateTasvieHesab" ) ) {
            log.info( "/////////////// VALIDATE TASVIEHESAB" );
            return validateTasvieHesab( ctx );
        }
        if ( ctx.getSubAction().endsWith( "ListEdit" ) ||
                ctx.getSubAction().endsWith( "List" ) ) {
            log.info( "/////////////// TASVIEHESAB LISTEDIT" );
//            ArrayList noeEmdadList = Util.getArrayList( "noeEmdadName" );
//            ctx.getRequest().setAttribute( "noeEmdad", noeEmdadList[ noe ] );

            return ctx.getActionMapping().findForward( "tasvieHesabListEdit" );
        }
        log.info( "hanooz return nakardim az tasvieHesabList() " );
        return ctx.getActionMapping().findForward( "tasvieHesabList" );
    }

    private int getNoekhodroOjrat( BaseActionContext ctx ) {
        NoeKhodroModel nk = null;
        try {
            String id = getNoekhodro( ctx, (String) ctx.getForm().get( "emdadId" ) );
            nk = NoeKhodroUtil.getLocalHome().findByPrimaryKey( id ).getNoeKhodroModel();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return nk == null ? -1 : nk.getHazinehSaat().intValue();
    }

    private String getNoekhodro( BaseActionContext ctx, String emdadId ) {
        String id = null;
        try {
            id = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId" );
            id = UserAccessEntity.stringQuery( "Select rokhdadId from emdad where id='" + id + "'", "rokhdadId", ctx.getConnection() );
            id = UserAccessEntity.stringQuery( "Select moshtarakId from rokhdad where id='" + id + "'", "moshtarakId", ctx.getConnection() );
            id = UserAccessEntity.stringQuery( "Select noeKhodroId from moshtarak where id='" + id + "'", "noeKhodroId", ctx.getConnection() );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return id;
    }

    private ActionForward doOjratHazineh( BaseActionContext ctx ) {
        try {
            Integer hazinehDefault = new Integer( 0 );
            String ojratId = (String) ctx.getForm().get( "ojratId" );
            OjratSessionLocalHome lhProxy = OjratSessionUtil.getLocalHome();
            OjratSessionLocal lProxy = lhProxy.create();
            OjratModel ojratModel = (OjratModel) lProxy.read( ojratId );
            int ojrat1hr = getNoekhodroOjrat( ctx );
            hazinehDefault = new Integer( ( ojratModel.getModat().intValue() * ojrat1hr ) / 60 );
            ctx.getRequest().setAttribute( "hazinehDefault", hazinehDefault );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    protected ActionForward doQateHazineh( BaseActionContext ctx ) {
        try {
            Integer hazinehDefault = new Integer( 0 );
            String qateId = (String) ctx.getForm().get( "qateId" );
            QateSessionLocalHome lhProxy = QateSessionUtil.getLocalHome();
            QateSessionLocal lProxy = lhProxy.create();
            QateList qateList = (QateList) lProxy.read( qateId );
            hazinehDefault = qateList.getGheimat();
            ctx.getRequest().setAttribute( "hazinehDefault", hazinehDefault );
        } catch ( NamingException e ) {
            e.printStackTrace();
        } catch ( CreateException e ) {
            e.printStackTrace();
        } catch ( ProxyException e ) {
            e.printStackTrace();
        }
        return null;
    }

    protected void updateEmdad( BaseActionContext ctx, String emdadId, String taeed, boolean hasGuarantee ) {
        try {

            EmdadSessionLocalHome emdadSessionLocalHome = EmdadSessionUtil.getLocalHome();
            EmdadSessionLocal emdadSessionLocal = emdadSessionLocalHome.create();

            EmdadLocalHome emdadLocalHome = EmdadUtil.getLocalHome();
            EmdadLocal emdadLocal = emdadLocalHome.findByPrimaryKey( emdadId );
            EmdadModel emdadModel = emdadLocal.getEmdadModel();
            Integer sumHazineh = ( (JozeatKhedmatProxy) getProxy() ).sumHazineh( emdadId );
            String rokhdadId = new String();
            String vazeatKhedmatId = new String();
            String emdadgarId = new String();
            String ezamgarId = new String();
            String dalileToolKeshidaneEmdadId = new String();
            if ( emdadLocal.getRokhdad() != null ) {
                rokhdadId = emdadLocal.getRokhdad().getId();
            }

            if ( emdadLocal.getVazeatKhedmat() != null ) {
                vazeatKhedmatId = emdadLocal.getVazeatKhedmat().getId();
            }

            if ( emdadLocal.getEmdadgar() != null ) {
                emdadgarId = emdadLocal.getEmdadgar().getId();
            }

            if ( emdadLocal.getEzamgar() != null ) {
                ezamgarId = emdadLocal.getEzamgar().getId();
            }

            if ( emdadLocal.getDalileToolKeshidaneEmdad() != null ) {
                dalileToolKeshidaneEmdadId = emdadLocal.getDalileToolKeshidaneEmdad().getId();
            }

            emdadModel.setShomarehFactor( ctx.getRequest().getParameter( "shomarehFactor" ) );
            String s1 = ( ctx.getRequest().getParameter( "hazinehAyyabZahab" ).length() == 0 ) ? "0" : ctx.getRequest().getParameter( "hazinehAyyabZahab" );
            emdadModel.setHazinehAyyabZahab( new Integer( s1 ) );
            String s2 = ( ctx.getRequest().getParameter( "hazinehBoxel" ).length() == 0 ) ? "0" : ctx.getRequest().getParameter( "hazinehBoxel" );
            emdadModel.setHazinehBoxel( new Integer( s2 ) );
            emdadModel.setEllateBargashteGuarantee( ctx.getRequest().getParameter( "ellateBargashteGuarantee" ) );
            String m = ctx.getRequest().getParameter( "koliyehMadarek" );
            int madarek = ( m == null ) ? 2 : Integer.parseInt( m );
            emdadModel.setKoliyehMadarek( new Integer( madarek ) );
            String f = ctx.getRequest().getParameter( "faseleAzNamayandegi" );
            int fasele = com.objectj.emdad.ejb.util.Util.isEmpty( f ) ? 0 : Integer.parseInt( f );
            emdadModel.setFaseleAzNamayandegi( new Integer( fasele ) );
            String k = ctx.getRequest().getParameter( "kilometerKarkard" );
            int karkard = com.objectj.emdad.ejb.util.Util.isEmpty( k ) ? 0 : Integer.parseInt( k );
            emdadModel.setKilometerKarkard( new Integer( karkard ) );

            if ( taeed.equals( "n" ) ) {
                emdadModel.setTaeedNamayandegi( new Integer( 1 ) );
            } else if ( taeed.equals( "nn" ) ) {
                emdadModel.setTaeedHesabdar( new Integer( 2 ) );
                emdadModel.setTaeedGuarantee( new Integer( 2 ) );
                emdadModel.setTaeedNamayandegi( new Integer( 2 ) );
            } else if ( taeed.equals( "g" ) ) {
                emdadModel.setTaeedGuarantee( new Integer( 1 ) );
            } else if ( taeed.equals( "ng" ) ) {
                emdadModel.setTaeedHesabdar( new Integer( 2 ) );
                emdadModel.setTaeedGuarantee( new Integer( 2 ) );
            } else if ( taeed.equals( "h" ) ) {
                emdadModel.setTaeedHesabdar( new Integer( 1 ) );
                if ( !hasGuarantee ) {
                    emdadModel.setTaeedGuarantee( new Integer( 1 ) );
                }
            } else if ( taeed.equals( "nh" ) ) {
                emdadModel.setTaeedHesabdar( new Integer( 2 ) );
            }

            //emdadModel.setHododeHazinehKol(sumHazineh);
            emdadSessionLocal.update( emdadModel );
            ctx.getRequest().setAttribute( "emdad", emdadSessionLocal.read( emdadId ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    protected void updateEmdad( String emdadId ) {
        try {

            EmdadSessionLocalHome emdadSessionLocalHome = EmdadSessionUtil.getLocalHome();
            EmdadSessionLocal emdadSessionLocal = emdadSessionLocalHome.create();
            EmdadLocalHome emdadLocalHome = EmdadUtil.getLocalHome();
            EmdadLocal emdadLocal = emdadLocalHome.findByPrimaryKey( emdadId );
            EmdadModel emdadModel = emdadLocal.getEmdadModel();

            Integer sumHazineh = ( (JozeatKhedmatProxy) getProxy() ).sumHazineh( emdadId );

            String rokhdadId = new String();
            String vazeatKhedmatId = new String();
            String emdadgarId = new String();
            String ezamgarId = new String();
            String dalileToolKeshidaneEmdadId = new String();

            if ( emdadLocal.getRokhdad() != null ) {
                rokhdadId = emdadLocal.getRokhdad().getId();
            }

            if ( emdadLocal.getVazeatKhedmat() != null ) {
                vazeatKhedmatId = emdadLocal.getVazeatKhedmat().getId();
            }

            if ( emdadLocal.getEmdadgar() != null ) {
                emdadgarId = emdadLocal.getEmdadgar().getId();
            }

            if ( emdadLocal.getEzamgar() != null ) {
                ezamgarId = emdadLocal.getEzamgar().getId();
            }

            if ( emdadLocal.getDalileToolKeshidaneEmdad() != null ) {
                dalileToolKeshidaneEmdadId = emdadLocal.getDalileToolKeshidaneEmdad().getId();
            }

            emdadModel.setHododeHazinehKol( sumHazineh );
            emdadSessionLocal.update( emdadModel, rokhdadId, vazeatKhedmatId, emdadgarId, ezamgarId, dalileToolKeshidaneEmdadId, "" );

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    protected void doFilterPreProcessor( BaseActionContext ctx ) {
        QueryObject emdadQuery = new QueryObject();
        emdadQuery.setTables( "emdad" );
        emdadQuery.setWhere( "emdadId = " + ctx.getForm().get( "dastorkar" ) );
        emdadQuery.setJoined( false );
        try {
            ArrayList emdadArray = EmdadSessionUtil.getLocalHome().create().readModel( emdadQuery ).getResult();
            if ( !emdadArray.isEmpty() ) {
                EmdadModel emdadModel = (EmdadModel) emdadArray.get( 0 );
                ctx.getForm().set( "khedmatId", emdadModel.getId() );
                ctx.getForm().set( "dastorkar", "" );
            }
        } catch ( Exception e ) {
        }
    }

    protected ActionForward doSpecificFromError( BaseActionContext ctx ) {
        ctx.getForm().set( ACTION_TYPE, "specific," + ctx.getForm().get( "actionName" ) );
        ctx.getForm().set( "actionName", ctx.getForm().get( "actionName" ) );
        return ctx.getActionMapping().findForward( "popupEdit" );
    }


    protected ActionForward doDeleteJarsaghil( BaseActionContext ctx ) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        String[] ids = (String[]) ctx.getForm().get( SELECTED_ITEMS );
        if ( ids != null ) {
            getProxy().remove( ids );
        }
        ctx.getForm().set( ValueObject.ID, ctx.getForm().get( "dastorkar" ).toString() );
        return tasvieHesabList( ctx );
    }


    public int getModatKhodroJagozin( BaseActionContext ctx, String emdadId ) {
        int days = 0;
        try {
            emdadId = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId" );
            if ( emdadId == null ) {
                return -1;
            }

            String dastoorKarGhabli = UserAccessEntity.stringQuery( "SELECT dastoorKarGhabli FROM emdad WHERE id = '" + emdadId + "'", "dastoorKarGhabli", ctx.getConnection() );
            String emdadIdGhabli = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", dastoorKarGhabli, "emdad", "emdadId" );
            if ( dastoorKarGhabli != null && dastoorKarGhabli.length() != 0 ) {
                String diff = UserAccessEntity.stringQuery( "SELECT tarikhTahvilAzMoshtari - tarikhTahvilBeMoshtari AS diff FROM khodrojagozinMasraf WHERE emdadId = '" + emdadIdGhabli + "'", "diff", ctx.getConnection() );
                if ( diff == null || diff.length() == 0 ) {
//                    log.warn("============== incorrect tarikhTahvilAzMoshtari or tarikhTahvilBeMoshtari.");
                    return -1;
                }

                int year = 70 + Integer.parseInt( diff.substring( 0, 4 ) );
                Date diffDate = HejriUtil.toDate( year + diff.substring( 4, diff.indexOf( ' ' ) ) );
                days = (int) ( diffDate.getTime() / ( 24 * 60 * 60 * 1000 ) );
            } else {
//                log.warn("=============  dastoorKarGhabli is incorrect for emdad.id = " + emdadId);
                return -1;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return days;
    }


    public int getModatKhab( BaseActionContext ctx, String emdadId ) {
        int days = 0;
        try {
            emdadId = Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", emdadId, "emdad", "emdadId" );
            if ( emdadId == null ) {
//                log.warn("============== emdadId is null.");
                return -1;
            }

            String diff = UserAccessEntity.stringQuery( "SELECT zamanPayan - zamanShoro as diff FROM emdad WHERE id = '" + emdadId + "'", "diff", ctx.getConnection() );
            if ( diff == null || diff.length() == 0 ) {
//                log.warn("============== incorrect tarikhTahvilAzMoshtari or tarikhTahvilBeMoshtari.");
                return -1;
            }

            int year = 70 + Integer.parseInt( diff.substring( 0, 4 ) );
//            log.info("========== year = " + year);
            Date diffDate = HejriUtil.toDate( year + diff.substring( 4, diff.indexOf( ' ' ) ) );
            days = (int) ( diffDate.getTime() / ( 24 * 60 * 60 * 1000 ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return days;
    }


    protected ActionForward doSpecific( BaseActionContext ctx ) throws Exception {
        log.info( "Oomadim too specific, action: " + ctx.getSubAction() );
        log.info( ctx.getRequest().getParameter( "action_type" ) );
        String errorMessage = "errors.hazenehDefault.invalid";
        if ( ctx.getSubAction().equals( "importEmdad" ) ) {
            return doImport( ctx );
        }
        if ( ctx.getSubAction().equals( "ojratHazineh" ) ) {
            return doOjratHazineh( ctx );
        } else if ( ctx.getSubAction().indexOf( "delete" ) >= 0 ) {
            String[] ids = (String[]) ctx.getForm().get( SELECTED_ITEMS );
            if ( ids != null ) {
                getProxy().remove( ids );
            }
            ctx.getForm().set( ValueObject.ID, ctx.getForm().get( "dastorkar" ).toString() );
            return tasvieHesabList( ctx );
        } else if ( ctx.getSubAction().indexOf( "popupCreate" ) >= 0 ) {
            //=-= System.out.println("ctx.getRequest().getParameter(dastorkar) = " + ctx.getRequest().getParameter("id"));
            if ( ctx.getRequest().getParameter( "id" ) != null ) {
                ctx.getForm().set( "dastorkar", Integer.valueOf( ctx.getRequest().getParameter( "id" ) ) );
            }
            ctx.getForm().set( "id", null );
            ctx.getForm().set( "actionName", "create" );
            ctx.getForm().set( ACTION_TYPE, "specific,create" );
            ctx.getForm().set( "popup", new Boolean( true ) );
            if ( ctx.getSubAction().indexOf( "Jarsaghil" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "jarsaghil" );
            } else if ( ctx.getSubAction().indexOf( "Emdadgar" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "emdadgar" );
            } else {
                ctx.getForm().set( "noeTasvieh", "namayandegi" );
            }

            return ctx.getActionMapping().findForward( "popupEdit" );
        } else if ( ctx.getSubAction().equals( "create" ) ) {
            ctx.getForm().set( ACTION_TYPE, "create" );
            return doCreate( ctx );
        } else if ( ctx.getSubAction().indexOf( "popupRead" ) >= 0 ) {
            if ( ctx.getRequest().getParameter( "id" ) != null ) {
                ctx.getForm().set( "id", ctx.getRequest().getParameter( "id" ) );
            }
            doReadById( ctx );
            ctx.getForm().set( "popup", new Boolean( true ) );
            if ( ctx.getSubAction().indexOf( "Jarsaghil" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "jarsaghil" );
            } else if ( ctx.getSubAction().indexOf( "Emdadgar" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "emdadgar" );
            } else {
                ctx.getForm().set( "noeTasvieh", "namayandegi" );
            }
            return ctx.getActionMapping().findForward( "popupRead" );
        } else if ( ctx.getSubAction().indexOf( "popupEdit" ) >= 0 ) {
            if ( ctx.getRequest().getParameter( "id" ) != null ) {
                ctx.getForm().set( "id", ctx.getRequest().getParameter( "id" ) );
            }
            doEditById( ctx );
            ctx.getForm().set( "actionName", "edit" );
            ctx.getForm().set( ACTION_TYPE, "specific,edit" );
            ctx.getForm().set( "popup", new Boolean( true ) );
            if ( ctx.getSubAction().indexOf( "Jarsaghil" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "jarsaghil" );
            } else if ( ctx.getSubAction().indexOf( "Emdadgar" ) >= 0 ) {
                ctx.getForm().set( "noeTasvieh", "emdadgar" );
            } else {
                ctx.getForm().set( "noeTasvieh", "namayandegi" );
            }

            return ctx.getActionMapping().findForward( "popupEdit" );
        } else if ( ctx.getSubAction().equals( "edit" ) ) {
            ctx.getForm().set( ACTION_TYPE, "edit_by_id" );
            return doUpdate( ctx );
        } else if ( ctx.getSubAction().equals( "computeHazineh" ) ) {
            Integer qateIdCode = null;
            Integer tedadQate = null;

            String ojratId = ctx.getRequest().getParameter( "ojratId" );

            String qateIdCodeStr = ctx.getRequest().getParameter( "qateIdCode" );
            if ( qateIdCodeStr != null && qateIdCodeStr.trim().length() != 0 ) {
                qateIdCode = new Integer( Integer.parseInt( qateIdCodeStr ) );
            } else {
                qateIdCode = new Integer( 0 );
            }

            String tedadQateStr = ctx.getRequest().getParameter( "tedadQate" );
            if ( tedadQateStr != null && tedadQateStr.trim().length() != 0 ) {
                tedadQate = new Integer( Integer.parseInt( tedadQateStr ) );
            }

            int hazinehDefault = 0;
            boolean isValid = false;
            String error = "";

            if ( ( qateIdCode != null ) && ( qateIdCode.intValue() != 0 ) && ( qateIdCode.intValue() != -1 ) ) {
                QueryObject qateQuery = new QueryObject();
                qateQuery.setTables( "qate " );
                qateQuery.setWhere( "qateId = " + qateIdCode );
                qateQuery.setJoined( false );
                ArrayList qateArray = ( QateSessionUtil.getLocalHome().create().readModel( qateQuery ).getResult() );
                QateModel qateModel = new QateModel();
                if ( !qateArray.isEmpty() ) {
                    qateModel = (QateModel) qateArray.get( 0 );
                    hazinehDefault = qateModel.getGheimat().intValue() * tedadQate.intValue();
                    isValid = true;
                } else {
                    error = Util.getProperty( "errors.qateId.invalid" );
                }
            }

            if ( ctx.getForm().get( "noeTasvieh" ) != null && ctx.getForm().get( "noeTasvieh" ).equals( "jarsaghil" ) ) {
                errorMessage = "errors.required.ojratId";
            }

            int ojrat1hr = getNoekhodroOjrat( ctx );

            if ( ( ojratId != null ) && ( ojratId.length() != 0 ) ) {
                QueryObject ojratQuery = new QueryObject();
                ojratQuery.setTables( "ojrat " );
                ojratQuery.setWhere( "id = '" + ojratId + "'" );
                ojratQuery.setJoined( false );
                ArrayList ojratArray = ( OjratSessionUtil.getLocalHome().create().readModel( ojratQuery ).getResult() );
                OjratModel ojratModel = new OjratModel();
                if ( !ojratArray.isEmpty() ) {
                    ojratModel = (OjratModel) ojratArray.get( 0 );
                    hazinehDefault += ( ( ojratModel.getModat().intValue() * ojrat1hr ) / 100 );
                    isValid = true;
                } else {
                    if ( error.equals( "" ) ) {
                        error = Util.getProperty( "errors.ojratId.invalid" );
                    }
                }
            }

//            log.info("========== hazinehDefault = " + hazinehDefault);
            if ( isValid ) {
                ctx.getRequest().setAttribute( "hazinehDefault", Integer.toString( hazinehDefault ) );
            } else {
                if ( error.equals( "" ) ) {
                    error = Util.getProperty( errorMessage );
                }
                ctx.getRequest().setAttribute( "hazinehDefault", error );
            }

            return ctx.getActionMapping().findForward( "computeHazineh" );

        } else if ( ctx.getSubAction().equals( "qateHazineh" ) ) {
            return doQateHazineh( ctx );
        }
        //=================================
        else if ( ctx.getSubAction().equals( "tasvieHesabEmdadgar" ) ) {
            ctx.getForm().set( "noeTasvieh", "emdadgar" );
            return ctx.getActionMapping().findForward( "tasvieHesab" );
        } else if ( ctx.getSubAction().equals( "tasvieHesabJarsaghil" ) ) {
            ctx.getForm().set( "noeTasvieh", "jarsaghil" );
            return ctx.getActionMapping().findForward( "tasvieHesab" );
        } else if ( ctx.getSubAction().equals( "tasvieHesabNamayandegi" ) ) {
            ctx.getForm().set( "noeTasvieh", "namayandegi" );
            return ctx.getActionMapping().findForward( "tasvieHesab" );
        }

        //=================================
        else if ( ctx.getSubAction().equals( "tasvieHesabEmdadgarList" ) ||
                ctx.getSubAction().equals( "tasvieHesabEmdadgarListEdit" ) ||
                ctx.getSubAction().equals( "validateTasvieHesabEmdadgar" ) ) {
            ctx.getForm().set( "noeTasvieh", "emdadgar" );
            log.info( " NOE Tasvie in specific: " + ctx.getForm().get( "noeTasvieh" ) );
            return tasvieHesabList( ctx );
        } else if ( ctx.getSubAction().equals( "tasvieHesabJarsaghilList" ) ||
                ctx.getSubAction().equals( "tasvieHesabJarsaghilListEdit" ) ||
                ctx.getSubAction().equals( "validateTasvieHesabJarsaghil" ) ) {
            ctx.getForm().set( "noeTasvieh", "jarsaghil" );
            return tasvieHesabList( ctx );
        } else if ( ctx.getSubAction().equals( "tasvieHesabNamayandegiList" ) ||
                ctx.getSubAction().equals( "tasvieHesabNamayandegiListEdit" ) ||
                ctx.getSubAction().equals( "validateTasvieHesabNamayandegi" ) ) {
            ctx.getForm().set( "noeTasvieh", "namayandegi" );
            return tasvieHesabList( ctx );
        }

        //=================================
        else if ( ctx.getSubAction().equals( "doTaeed" ) ) {
            return doTaeed( ctx );
        } else if ( ctx.getSubAction().equals( "testrooz" ) ) {
            getModatKhodroJagozin( ctx, "9C8180808080808080o" );
            getModatKhab( ctx, "1C8180808080808280o" );
        }

        return null;
    }

    protected int computeHazineh( BaseActionContext ctx, String ojratId, String qateId, String noeKhodroId, int tedadQate, int row ) {
        int hazineh = 0;
        if ( ( qateId != null ) && ( qateId.length() != 0 ) ) {
//            QueryObject qateQuery = new QueryObject();
//            qateQuery.setTables("qate ");
//            qateQuery.setWhere("id = " + qateId);
//            qateQuery.setJoined(false);
            String g = UserAccessEntity.stringQuery( "SELECT gheimat FROM qate WHERE id = '" + qateId + "'", "gheimat", ctx.getConnection() );
            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( g ) ) {
                hazineh = tedadQate * Integer.parseInt( g );
            }
        }

        if ( ( ojratId != null ) && ( ojratId.length() != 0 ) ) {
            String hss = UserAccessEntity.stringQuery( "Select hazinehSaat from noeKhodro where id='" + noeKhodroId + "'", "hazinehSaat", ctx.getConnection() );
            int hs = 0;
            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( hss ) ) {
                hs = Integer.parseInt( hss );
                hss = UserAccessEntity.stringQuery( "Select Modat from ojrat where id='" + ojratId + "'", "Modat", ctx.getConnection() );
                int hm = 0;
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( hss ) ) {
                    hm = Integer.parseInt( hss );
                    int ojratHazineh = ( ( hm * hs ) / 100 );
                    if ( ojratHazineh == 0 ) {
                        if ( row >= 0 ) {
                            ctx.getRequest().setAttribute( "ojratHazinehAlert" + row, "true" );
                        }
                    }
                    hazineh += ojratHazineh;
                }
            }
        }
        return hazineh;
    }

    private ActionForward doImport( BaseActionContext ctx ) {
        EmdadXls xls = new EmdadXls( ctx.getRequest().getParameter( "xlsFile" ) );
        try {
            for ( int i = 0; i < xls.rowSize(); i++ ) {
                JozeatKhedmatModel vo = new JozeatKhedmatModel();
                String iradId = xls.getIrad( i ).getString();
                iradId = UserAccessEntity.stringQuery( "select id from irad where iradId='" + iradId + "'", "id" );
                String ojratId = xls.getOjrat( i ).getString();
                ojratId = UserAccessEntity.stringQuery( "select id from ojrat where ojratId='" + ojratId + "'", "id" );
                String qateId = xls.getQate( i ).getString();
                String defTedad = ( qateId.length() == 0 ) ? "0" : "1";
                qateId = UserAccessEntity.stringQuery( "select id from qate where shomareFanni='" + qateId + "'", "id" );
                String tedadQate = xls.getTedadQate( i ).getString();
                tedadQate = ( tedadQate.length() == 0 ) ? defTedad : tedadQate;
                vo.setTedadQate( new Integer( tedadQate ) );
                int guarantee = ( xls.getGuarantee( i ).getString().length() == 0 ) ? 2 : 1;
                vo.setGuarantee( new Integer( guarantee ) );
                int bazar = ( xls.getBazar( i ).getString().length() == 0 ) ? 2 : 1;
                vo.setManbaeTahiyeh( new Integer( bazar ) );
                int naghdi = ( xls.getNaghdi( i ).getString().length() == 0 ) ? 2 : 1;
                vo.setNahveyePardakht( new Integer( naghdi ) );
                String hazineh = xls.getHazineh( i ).getString();
                hazineh = ( hazineh.length() == 0 ) ? "0" : hazineh;
                vo.setHazineh( new Integer( hazineh ) );
                vo.setIjadKonandeh( getUserId( ctx ) );
                String emdadId = xls.getEmdad( i ).getString();
                String shomareFactor = xls.getFactor( i ).getString();
                shomareFactor = ( shomareFactor.length() == 0 ) ? "0" : shomareFactor;
                emdadId = UserAccessEntity.stringQuery( "select id from emdad where emdadId='" + emdadId + "'", "id" );
                if ( emdadId.length() != 0 ) {
                    EmdadModel emdad = EmdadUtil.getLocalHome().findByPrimaryKey( emdadId ).getEmdadModel();
                    emdad.setShomarehFactor( shomareFactor );
                    EmdadSessionUtil.getLocalHome().create().update( emdad );
                    vo.setNoeKhedmat( emdad.getNoeEmdad() );
                    String noeKhodroId = getNoekhodro( ctx, emdadId );
                    vo.setHazinehDefault( new Integer( computeHazineh( ctx, ojratId, qateId, noeKhodroId, vo.getTedadQate().intValue(), i ) ) );
                    vo.setHazineh( ( Integer.parseInt( hazineh ) == 0 ) ? vo.getHazinehDefault() : new Integer( hazineh ) );
                }
                ( (JozeatKhedmatProxy) getProxy() ).create( vo, emdadId, ojratId, qateId, iradId );
                log.info( "//////////////////// Jozeatkhedmat Generated with Id: " + vo.getId() );
            }
            ctx.getRequest().setAttribute( "uploadPage", ctx.getRequest().getParameter( "page" ) );
            return ctx.getActionMapping().findForward( "emdadImported" );
        } catch ( Exception e ) {
            e.printStackTrace();
            return ctx.getActionMapping().findForward( "error" );
        }
    }

}

