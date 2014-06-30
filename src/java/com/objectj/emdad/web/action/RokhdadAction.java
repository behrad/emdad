package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @struts.action name="rokhdadForm"
 * path="/c/rokhdad"
 * pathPrime="/rokhdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.edit.jsp"
 * inputPrime="emdad.rokhdad.edit"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/r/rokhdad"
 * pathPrime="/rokhdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.read.jsp"
 * inputPrime="emdad.rokhdad.read"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/u/rokhdad"
 * pathPrime="/rokhdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.edit.jsp"
 * inputPrime="emdad.rokhdad.edit"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/d/rokhdad"
 * pathPrime="/rokhdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.read.jsp"
 * inputPrime="emdad.rokhdad.read"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/l/rokhdad"
 * pathPrime="/rokhdadList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.list.jsp"
 * inputPrime="emdad.rokhdad.list"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/s/rokhdad"
 * pathPrime="/rokhdademdadList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/rokhdad.emdad.list.jsp"
 * inputPrime="/com/objectj/emdad/jsp/rokhdad.emdad.list.jsp"
 * validate="false"
 * @struts.action name="rokhdadForm"
 * path="/c/validaterokhdad"
 * pathPrime="/validaterokhdad"
 * scope="request"
 * input="/c/rokhdad.run"
 * inputPrime="emdad.rokhdad.edit"
 * input4tiles="emdad.rokhdad.edit"
 * validate="true"
 * @struts.action name="rokhdadForm"
 * path="/u/validaterokhdad"
 * pathPrime="/validaterokhdad"
 * scope="request"
 * input="/u/rokhdad.run"
 * inputPrime="emdad.rokhdad.edit"
 * input4tiles="emdad.rokhdad.edit"
 * validate="true"
 * @struts.action-forward name="find"
 * path="/com/objectj/emdad/jsp/rokhdad.find.jsp"
 * pathPrime="/com/objectj/emdad/jsp/rokhdad.find.jsp"
 * @struts.action-forward name="list"
 * path="emdad.rokhdad.list"
 * pathPrime="emdad.rokhdad.list"
 * @struts.action-forward name="edit"
 * path="/com/objectj/emdad/jsp/rokhdad.edit.jsp"
 * pathPrime="/com/objectj/emdad/jsp/rokhdad.edit.jsp"
 * @struts.action-forward name="refresh"
 * path="/com/objectj/emdad/jsp/general.create.refresh.jsp"
 * pathPrime="/com/objectj/emdad/jsp/general.create.refresh.jsp"
 * @struts.action-forward name="read"
 * path="emdad.rokhdad.read"
 * pathPrime="emdad.rokhdad.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="rokhdademdadlist"
 * path="/com/objectj/emdad/jsp/rokhdad.emdad.list.jsp"
 * pathPrime="/com/objectj/emdad/jsp/rokhdad.emdad.list.jsp"
 * @struts.action-forward name="rokhdadShow"
 * path="/com/objectj/emdad/jsp/rokhdad.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/rokhdad.show.jsp"
 * @struts.action-forward name="emdadStatic"
 * path="/com/objectj/emdad/jsp/emdad.static.edit.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.static.edit.jsp"
 * @struts.action-forward name="getXLS"
 * path="/com/objectj/emdad/jsp/emdad.xls.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.xls.jsp"
 */

public class RokhdadAction extends BaseAction {

    //String forceFilter, forceForwardTo;
    ArrayList sabetSayarList = new ArrayList();

    ArrayList khadamateVijehList = new ArrayList();

    ArrayList eghdamShodehList = new ArrayList();

    ArrayList noeDarkhastKonandehList = new ArrayList();

    private final static int EGHDAM_SHODEH_BALI = 1;

    private final static int MAX_NAMAYANDEGI_LENGTH = 10;

    protected Class getValueObjectClass() {
        return RokhdadModel.class;
    }

    protected Class getValueObjectClass2() {
        return RokhdadList.class;
    }

    protected String[] getSortableColumns() {
        //return new String[]{"rokhdadId", "address", "sabetSayar", "moshtarakId", "shahrId", "daftarOstaniId"};
        //return new String[]{"rokhdadId","zamaneVaghei", "address","irad","sabtKonandeh", "sabetSayar", "eshterakId", "shahrName", "nameDaftarOstani", "zamaneVaghei"};
        return new String[]{"rokhdadId", "zamaneVaghei", "address", "irad", "sabtKonandeh", "sabetSayar", "moshtarakEshterakId",
                            "shahrName", "nameDaftarOstani", "zamaneVaghei", "shomarePelak", "shahrId", "nameDaftarOstani",
                            "tel", "tarikhTahvil", "moshtarakYaNa", "noeKhodroName", "rangOnvan", "daftarOstaniId", "eshterakId"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RokhdadSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }


    protected String[] getRelatedEntities() {
        return new String[]{"moshtarak", "daftarOstani", "shahr"};
    }

    protected String getForceFilter( BaseActionContext ctx ) {
        String filter = super.getForceFilter( ctx );
        if ( !ctx.getUserSession().getEntityAccess( ctx.getEntity() ).getAllAccess() ) {
            if ( filter != null ) {
                filter += " AND ";
            } else {
                filter = "";
            }
            filter += " rokhdad.daftarOstaniId = 'S" + getDaftarOstani( ctx ) + "'";
        }
        return filter;
    }

    protected ActionForward doNullAction( BaseActionContext ctx ) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm( vo, ctx.getForm() );

        ctx.getForm().set( ID, "" );
        ctx.getForm().set( ACTION_TYPE, "create" );
        ctx.getForm().set( "hasrepl", new Integer( 0 ) );
        ctx.getForm().set( "tarikhFaalShodan", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "daftarOstaniId", getDaftarOstani( ctx ) );
        ctx.getForm().set( "noeDarkhastKonandeh", new Integer( 1 ) );
        return ctx.getActionMapping().findForward( "edit" );
    }

    protected ActionForward doCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                RokhdadModel vo = new RokhdadModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );

                //--------------- Setting tarikhFaalShodan ---------------------------
                ctx.getForm().set( "tarikhFaalShodan", ( (String) ctx.getForm().get( "tarikhFaalShodan" ) ).replace( '/', '-' ) );
//                log.info("tarikhFaalShodan="+(String)ctx.getForm().get("tarikhFaalShodan"));
                vo.setTarikhFaalShodan( java.sql.Date.valueOf( (String) ctx.getForm().get( "tarikhFaalShodan" ) ) ); // HejriUtil.hejriToChris((String)ctx.getForm().get("tarikhFaalShodan")));

                //--------------- Setting sabtKonandeh ---------------------------
                vo.setSabtKonandeh( ctx.getUserSession().getId() );

                //--------------- Setting akharinTaghyirDahandeh ---------------------------
                vo.setAkharinTaghyirDahandeh( ctx.getUserSession().getId() );

                //--------------- Setting zamaneVaghei ---------------------------
                vo.setZamaneVaghei( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );

                //--------------- Setting eghdamShodeh ---------------------------
                vo.setEghdamShodeh( new Integer( Constants.getEghdamshodeh_Kheir() ) );

                vo.setKilometerKarkardGhabli( new Integer( 0 ) );

                //--------------- Setting moshtarakId ----------------------------
//                String moshtarakId = UserAccessEntity.stringQuery("SELECT id FROM moshtarak WHERE eshterakId = '" + (String) ctx.getForm().get("eshterakId") + "'", "id");
                String[] lst = UserAccessEntity.stringQuerys( "SELECT id,guarantee,noeService,moshtarakYaNa FROM moshtarak WHERE eshterakId = '" + (String) ctx.getForm().get( "eshterakId" ) + "'", "id,guarantee,noeService,moshtarakYaNa" );
                System.out.println( "select max(kilometerKarkard) as maxKilometer  from emdadlist where moshtarakId='" + lst[ 0 ] + "'" );
                String rs = UserAccessEntity.stringQuery( "select max(kilometerKarkard) as maxKilometer  from emdadlist where moshtarakId='" + lst[ 0 ] + "'", "maxKilometer" );
                System.out.println( "in rokhdadActiion.doCreate: kilometerKarekardGhabli = " + rs );
                if ( com.objectj.emdad.ejb.util.Util.isEmpty( rs ) || rs == null ) {
                    rs = 0 + "";
                }
                vo.setKilometerKarkardGhabli( new Integer( rs ) );
                //log.info("============================ moshtarakId = " + moshtarakId);
                /*
                if (moshtarakId == null || moshtarakId.length() == 0)
                {
                    log.info ("...............null value or zero length for moshtarakId..............");
                    error.add("error.unknown", new ActionError("error.unknown"));
                    return listAll();
                }
                */
                //----------------------------------------------------------------
                ActionErrors error = new ActionErrors();                                                       // getDaftarOstani(ctx)
                checkForIncomplete( ctx, lst[ 0 ], vo, error );
                vo.setDastorkarGhabli( new Integer( 0 ) );
                vo.setGuarantee( new Integer( Integer.parseInt( lst[ 1 ] ) ) );
                vo.setNoeService( new Integer( Integer.parseInt( lst[ 2 ] ) ) );
                vo.setMoshtarakYaNa( new Integer( Integer.parseInt( lst[ 3 ] ) ) );

                vo = (RokhdadModel) ( (RokhdadProxy) getProxy() ).create( vo, lst[ 0 ], (String) ctx.getForm().get( "namayandegiId" ), (String) ctx.getForm().get( "daftarOstaniId" ), (String) ctx.getForm().get( "shahrId" ) );
                //vo = (RokhdadModel) (getProxy()).read(vo.getId());
                error.add( "rokhdadId", new ActionError( "rokhdad.new.rokhdadId", vo.getRokhdadId() ) );
                ctx.getRequest().setAttribute( DISPLAY_MESSAGE, error );
                ctx.getForm().set( "moshtarakId", null );
                ctx.getForm().set( "shahrId", null );
                ctx.getForm().set( "daftarOstaniId", null );
                ctx.getRequest().setAttribute( "hdnPage", vo.getRokhdadId() );
                return ctx.getActionMapping().findForward( "refresh" );
            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }

    protected void checkForIncomplete( BaseActionContext ctx, String moshtarakId, RokhdadModel vo, ActionErrors errors ) {
//        QueryObject qo = new QueryObject();
//        qo = new QueryObject();
//        qo.setFromIndex(0);
//        qo.setToIndex(2);
//        qo.setTables("rokhdad");
//        qo.setJoined(false);
//        qo.setSelectFields("id");
//        qo.setWhere("moshtarakId='" + moshtarakId + "' AND eghdamShodeh=2");

//        Connection c = null;
        try {
            String rs = UserAccessEntity.stringQuery( "SELECT rokhdadId  FROM rokhdad where moshtarakId='" + moshtarakId + "' AND eghdamShodeh=2 and id<>'" + vo.getId() + "'", "rokhdadId" );
            if ( rs == null ) {
                errors.add( "repl", new ActionError( "rokhdad.notcompleted.exist", rs ) );
            }
            rs = UserAccessEntity.stringQuery( "SELECT emdadId  FROM emdadList where emdadList.moshtarakId='" + moshtarakId + "' AND emdadList.vazeatKonuni <> 2 ", "emdadId" );
            if ( rs == null ) {
                errors.add( "repl", new ActionError( "emdad.notcompleted.exist", rs ) );
            }
        } catch ( Exception e ) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }

    }

    protected ActionForward doUpdate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                //RokhdadModel vo = new RokhdadModel();
                String id = (String) ctx.getForm().get( ValueObject.ID );
                RokhdadModel vo = (RokhdadModel) getProxy().read( id );
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                vo.setKilometerKarkard( (Integer) ( ctx.getForm().get( "kilometerKarkard" ) ) );
                if ( (String) ( ctx.getForm().get( "zamaneVaghei" ) ) != null && ( (String) ( ctx.getForm().get( "zamaneVaghei" ) ) ).length() != 0 ) {
                    vo.setZamaneVaghei( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamaneVaghei" ), (String) ctx.getForm().get( "zamaneVaghei2" ) ) );
                }
//--------------- Setting tarikhFaalShodan ---------------------------
//vo.setTarikhFaalShodan(HejriUtil.hejriToChris((String)ctx.getForm().get("tarikhFaalShodan")));
//log.info ("====================  tarikhFaalShodan: " + (String)ctx.getForm().get("tarikhFaalShodan"));
//log.info ("====================  tarikhFaalShodan Chris: " + HejriUtil.hejriToChris((String)ctx.getForm().get("tarikhFaalShodan")));

//--------------- Setting akharinTaghyirDahandeh ---------------------------
                vo.setAkharinTaghyirDahandeh( ctx.getUserSession().getId() );
//vo.setSabtKonandeh(ctx.getUserSession().getId());

//vo.setZamaneVaghei(HejriUtil.toDate((String) (ctx.getForm().get("zamaneVaghei"))));
//log.info ("======== mogheye Update; Value Object: " + vo);
                ActionErrors error = new ActionErrors();                                                       // getDaftarOstani(ctx)
                checkForIncomplete( ctx, (String) ctx.getForm().get( "moshtarakId" ), vo, error );
                ctx.getRequest().setAttribute( DISPLAY_MESSAGE, error );

                ( (RokhdadProxy) getProxy() ).update( vo, (String) ctx.getForm().get( "moshtarakId" ), (String) ctx.getForm().get( "namayandegiId" ), (String) ctx.getForm().get( "daftarOstaniId" ), (String) ctx.getForm().get( "shahrId" ) );
                ctx.getForm().set( "moshtarakId", null );
                ctx.getForm().set( "shahrId", null );
                ctx.getForm().set( "daftarOstaniId", null );

                return ctx.getActionMapping().findForward( "refresh" );
            } catch ( Exception e ) {
                e.printStackTrace();
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }


    protected ActionForward doReadById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }
        try {
            com.objectj.emdad.proxy.RokhdadSessionLocalHome lhProxy = com.objectj.emdad.proxy.RokhdadSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.RokhdadSessionLocal lProxy = lhProxy.create();
            RokhdadList voRokhdadList = (RokhdadList) lProxy.read( id );
            ctx.getRequest().setAttribute( VALUE_OBJECT, voRokhdadList );
            ctx.getRequest().setAttribute( "namayandegiName", voRokhdadList.getNamayandegiName() );

            ctx.getRequest().setAttribute( "sabetSayar", ( (ComboObject) sabetSayarList.get( voRokhdadList.getSabetSayar().intValue() ) ).getName() );
            ctx.getRequest().setAttribute( "khadamateVijeh", ( (ComboObject) khadamateVijehList.get( voRokhdadList.getKhadamateVijeh().intValue() ) ).getName() );
            ctx.getRequest().setAttribute( "eghdamShodeh", ( (ComboObject) eghdamShodehList.get( voRokhdadList.getEghdamShodeh().intValue() ) ).getName() );

            ctx.getRequest().setAttribute( VALUE_OBJECT, voRokhdadList );

            if ( voRokhdadList.getNamayandegiName() != null ) {
                ctx.getRequest().setAttribute( "namayandegiName", voRokhdadList.getNamayandegiName() );
            } else {
                ctx.getRequest().setAttribute( "namayandegiName", " " );
            }

//            ctx.getRequest().setAttribute("tarikhFaalShodan", HejriUtil.chrisToHejri(voRokhdadList.getTarikhFaalShodan()));
//            ctx.getRequest().setAttribute("zamaneVaghei", HejriUtil.chrisToHejri(voRokhdadList.getZamaneVaghei()));
            //ctx.getRequest().setAttribute("eshterakId", voRokhdadList.getMoshtarakEshterakId());

        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }
        return ctx.getActionMapping().findForward( "read" );
    }

    protected ActionForward doEditById( BaseActionContext ctx ) throws ProxyException, ServletException {
        boolean isNullZamaneVaghei = false;

        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }

        ValueObject valueObject = getProxy().read( id );
        if ( ctx.getForm().get( "hasrepl" ) == null ) {
            ctx.getForm().set( "hasrepl", new Integer( 0 ) );
        }

        if ( ( (RokhdadModel) ( valueObject ) ).getZamaneVaghei() == null ) {
            ( (RokhdadModel) ( valueObject ) ).setZamaneVaghei( new Timestamp( 0 ) );
            isNullZamaneVaghei = true;
        }

        Exchanger.exhangeValueObjectToForm( valueObject, ctx.getForm() );

        if ( !isNullZamaneVaghei ) {
            ctx.getForm().set( "zamaneVaghei", HejriUtil.chrisToHejri( ( (RokhdadModel) ( valueObject ) ).getZamaneVaghei() ) );
            ctx.getForm().set( "zamaneVaghei2", HejriUtil.getTimeFromDate( ( (RokhdadModel) valueObject ).getZamaneVaghei() ) );
        } else {
            ctx.getForm().set( "zamaneVaghei", "" );
            ctx.getForm().set( "zamaneVaghei2", "" );
        }
        if ( ( (RokhdadModel) valueObject ).getTarikhFaalShodan() == null ) {
            ctx.getForm().set( "tarikhFaalShodan", "" );
        } else {
            ctx.getForm().set( "tarikhFaalShodan", HejriUtil.chrisToHejri( ( (RokhdadModel) ( valueObject ) ).getTarikhFaalShodan() ) );
        }

        if ( ( (RokhdadModel) valueObject ).getKilometerKarkard() == null ) {
            ctx.getForm().set( "kilometerKarkard", new Integer( 0 ) );
        } else {
            ctx.getForm().set( "kilometerKarkard", ( (RokhdadModel) ( valueObject ) ).getKilometerKarkard() );
        }

        ctx.getRequest().setAttribute( "rokhdadId", ctx.getForm().get( "rokhdadId" ) );
        ctx.getRequest().setAttribute( "sabtKonandeh", ctx.getForm().get( "sabtKonandeh" ) );
        ctx.getRequest().setAttribute( "akharinTaghyirDahandeh", ctx.getForm().get( "akharinTaghyirDahandeh" ) );

        //-------------------------------------------------------
        ctx.getForm().set( "tarikhFaalShodan", HejriUtil.chrisToHejri( ( (RokhdadModel) ( valueObject ) ).getTarikhFaalShodan() ) );

        //-------------------------------------------------------

//        MoshtarakSessionLocal moshtarakProxy = null;
//        try {
//            moshtarakProxy = MoshtarakSessionUtil.getLocalHome().create();
//        } catch (CreateException e) {
//            e.printStackTrace();
//        } catch (NamingException e) {
//            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
//        }
//        MoshtarakList moshtarakList = (MoshtarakList) moshtarakProxy.read((String) ctx.getForm().get("moshtarakId"));
        String ls[] = UserAccessEntity.stringQuerys( "SELECT eshterakId,moshtarakYaNa FROM moshtarak WHERE id = '" + (String) ctx.getForm().get( "moshtarakId" ) + "'", "eshterakId,moshtarakYaNa", ctx.getConnection() );

        ctx.getForm().set( "eshterakId", ls[ 0 ] );

        if ( ls[ 0 ] != null ) {
            ctx.getRequest().setAttribute( "moshtarakEshterakId", ls[ 0 ] );
        } else {
            ctx.getRequest().setAttribute( "moshtarakEshterakId", " " );
        }

//        ArrayList moshtarakYaNaList = Util.getArrayList("yesNo");
        ctx.getRequest().setAttribute( "moshtarakMoshtarakYaNa", com.objectj.emdad.ejb.util.Util.getNameFromArrayList( "yesNo", Integer.parseInt( ls[ 1 ] ) ) );

        //---------------------------------------------------

//        DaftarOstaniModel daftarOstaniModel = null;
//        try {
//            daftarOstaniModel = (DaftarOstaniModel) DaftarOstaniSessionUtil.getLocalHome().create().read((String) ctx.getForm().get("daftarOstaniId"));
//        } catch (Exception e) {
//        }
        ctx.getRequest().setAttribute( "daftarOstaniName", ComboPool.findInCombo( "daftarOstani", (String) ctx.getForm().get( "daftarOstaniId" ) ) );

        //---------------------------------------------------

        ctx.getRequest().setAttribute( FORM, ctx.getForm() );
        ctx.getForm().set( ACTION_TYPE, "update" );
        return ctx.getActionMapping().findForward( "edit" );
    }


    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {
        //ArrayList moshtarakList = null;
        ArrayList daftarOstaniList = new ArrayList();
        ArrayList namayandegiList = new ArrayList();
        ArrayList shahrList = new ArrayList();
        if ( ctx.getRequest().getAttribute( "hasrepl" ) != null ) {
            ctx.getForm().set( "hasrepl", ctx.getRequest().getAttribute( "hasrepl" ) );
        }
//        log.info("-------- hasrepl="+ctx.getForm().get("hasrepl"));

        try {
            daftarOstaniList = ComboPool.getCombo( "daftarOstani" );
            namayandegiList = ComboPool.getCombo( "namayandegi" );
            shahrList = ComboPool.getCombo( "shahr" );
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            throw new ProxyException( e );
        }

        //ctx.getRequest().setAttribute("moshtarakList", moshtarakList);
        ctx.getRequest().setAttribute( "daftarOstaniList", daftarOstaniList );
        ctx.getRequest().setAttribute( "namayandegiList", namayandegiList );
        ctx.getRequest().setAttribute( "shahrList", shahrList );

        sabetSayarList = Util.getArrayList( "rokhdad.sabetSayar" );
        noeDarkhastKonandehList = Util.getArrayList( "noeDarkhastKonandeh" );
        khadamateVijehList = Util.getArrayList( "yesNo" );
        eghdamShodehList = Util.getArrayList( "yesNo" );
        Util.getArrayList( "noeService" );

        String currentDate = com.objectj.emdad.ejb.util.HejriUtil.chrisToHejri( com.objectj.emdad.ejb.util.HejriUtil.getCurrentDate() );
        //String currentDate = HejriUtil.getCurDate();
//        log.info("==============~~~~~~~~~~~~~~~~~~~~~~~~ current date:" + currentDate);
        //log.info ("AND rokhdad.tarikhFaalShodan >= 'D" + currentDate + "'");
        setOrderToXifIsEmpty( ctx, "DESC" );
        if ( ctx.getUserSession().getSpecific( ctx.getEntity() ) == null ) {
            ctx.getUserSession().setSpecific( "rokhdad.eghdamShodeh = 'I2' AND rokhdad.tarikhFaalShodan <= 'D" + currentDate + "'", "", ctx.getEntity() );
        }
        //    ctx.getUserSession().setSpecific("rokhdad.eghdamShodeh = 'I2'", "", ctx.getEntity());

        ctx.getRequest().setAttribute( "moshtarakYaNaList", Util.getArrayList( "yesNo" ) );
        ctx.getRequest().setAttribute( "sabetSayarList", sabetSayarList );
        ctx.getRequest().setAttribute( "noeDarkhastKonandehList", noeDarkhastKonandehList );
        ctx.getRequest().setAttribute( "khadamateVijehList", khadamateVijehList );
        ctx.getRequest().setAttribute( "eghdamShodehList", eghdamShodehList );

        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( ctx.getForm().get( "hdnPage" ).toString() ) ) {
            ActionErrors error = new ActionErrors();
            error.add( "rokhdadId", new ActionError( "rokhdad.new.rokhdadId", ctx.getForm().get( "hdnPage" ) ) );
            ctx.getRequest().setAttribute( DISPLAY_MESSAGE, error );
        }
    }

    protected ActionForward doSpecific( BaseActionContext ctx ) throws Exception {

        if ( ctx.getSubAction().equals( "rokhdademdadlistAdi" ) ) {
            String tarikh = com.objectj.emdad.ejb.util.HejriUtil.chrisToHejri( com.objectj.emdad.ejb.util.HejriUtil.getCurrentDate() );
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.getUserSession().setSpecific( "(rokhdad.eghdamShodeh = 'I2' OR rokhdad.dastorkarGhabli <> 'I0' ) AND rokhdad.tarikhFaalShodan <= 'D" + tarikh + "' AND rokhdad.khadamateVijeh = 'I2' ", "rokhdademdadlist", ctx.getEntity() );
            ctx.getRequest().setAttribute( "noeRokhdad", "adi" );
        } else if ( ctx.getSubAction().equals( "rokhdademdadlistVijeh" ) ) {
            String tarikh = com.objectj.emdad.ejb.util.HejriUtil.chrisToHejri( com.objectj.emdad.ejb.util.HejriUtil.getCurrentDate() );
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.getUserSession().setSpecific( "(rokhdad.eghdamShodeh = 'I2' OR rokhdad.dastorkarGhabli <> 'I0' ) AND moshtarak.noeService = 'I1' AND rokhdad.tarikhFaalShodan <= 'D" + tarikh + "' AND rokhdad.khadamateVijeh = 'I1' ", "rokhdademdadlist", ctx.getEntity() );
            ctx.getRequest().setAttribute( "noeRokhdad", "vije" );
        } else if ( ctx.getSubAction().equals( "rokhdadList" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.getUserSession().setSpecific( "(rokhdad.eghdamShodeh = 'I2' OR rokhdad.dastorkarGhabli <> 'I0' )", "", ctx.getEntity() );
        } else if ( ctx.getSubAction().equals( "rokhdadShow" ) ) {
            return doShow( ctx, "rokhdadId", "rokhdadShow" );
        } else if ( ctx.getSubAction().equals( "filter" ) ) {
            return doFilter( ctx );
        } else if ( ctx.getSubAction().equals( "clear_filter" ) ) {
            return doClearFilter( ctx );
        } else if ( ctx.getSubAction().equals( "find" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            String filter = "";
            if ( ctx.getRequest().getParameter( "eghdam" ).equals( "1" ) ) {
                filter = "rokhdad.eghdamShodeh = 'I1'";
            } else if ( ctx.getRequest().getParameter( "eghdam" ).equals( "2" ) ) {
                filter = "rokhdad.eghdamShodeh = 'I2'";
            }
            ctx.getUserSession().setSpecific( filter, "find", ctx.getEntity() );
//            log.info(ctx.getUserSession().getDestinationForward(ctx.getEntity()));
        } else if ( ctx.getSubAction().equals( "import" ) ) {
            return doImport( ctx );
        } else if ( ctx.getSubAction().equals( "test" ) ) {
            return ctx.getActionMapping().findForward( "emdadStatic" );
        } else if ( ctx.getSubAction().equals( "importXls" ) ) {
            return doImportXls( ctx );
        }

        return listAll( ctx );
    }

    protected void doFilterPreProcessor( BaseActionContext ctx ) {
        ctx.getForm().set( "moshtarak.eshterakId", ctx.getForm().get( "moshtarakId" ) );
        ctx.getForm().set( "moshtarakId", "" );

//        ctx.getForm().set("rokhdadList.tarikhTahvil", ctx.getForm().get("tarikhTahvil"));
//        ctx.getForm().set("tarikhTahvil", "");

        ctx.getForm().set( "rokhdadList.shomarePelak", ctx.getForm().get( "shomarePelak" ) );
        ctx.getForm().set( "shomarePelak", "" );

        Integer rId = (Integer) ctx.getForm().get( "moshtarakYaNa" );
        if ( rId != null && rId.intValue() != 0 ) {
            ctx.getForm().set( "rokhdadList.moshtarakYaNa", ctx.getForm().get( "moshtarakYaNa" ) );
            ctx.getForm().set( "moshtarakYaNa", new Integer( 0 ) );
        }
        ctx.getForm().set( "rokhdadList.irad", ctx.getForm().get( "irad" ) );
        ctx.getForm().set( "irad", "" );

        ctx.getForm().set( "rokhdadList.daftarOstaniId", ctx.getForm().get( "daftarOstaniId" ) );
        ctx.getForm().set( "daftarOstaniId", "" );

        ctx.getForm().set( "rokhdadList.shahrId", ctx.getForm().get( "shahrId" ) );
        ctx.getForm().set( "shahrId", "" );

        ctx.getForm().set( "rokhdadList.tel", ctx.getForm().get( "tel" ) );
        ctx.getForm().set( "tel", "" );

        ctx.getForm().set( "rokhdadList.sabtKonandeh", ctx.getForm().get( "sabtKonandeh" ) );
        ctx.getForm().set( "sabtKonandeh", "" );

        ctx.getForm().set( "rokhdadList.address", ctx.getForm().get( "address" ) );
        ctx.getForm().set( "address", "" );

        rId = (Integer) ctx.getForm().get( "rokhdadId" );
        if ( rId != null && rId.intValue() != 0 ) {
            ctx.getForm().set( "rokhdadList.rokhdadId", ctx.getForm().get( "rokhdadId" ) );
            ctx.getForm().set( "rokhdadId", new Integer( 0 ) );
        }

        rId = (Integer) ctx.getForm().get( "sabetSayar" );
        if ( rId != null && rId.intValue() != 0 ) {
            ctx.getForm().set( "rokhdadList.sabetSayar", ctx.getForm().get( "sabetSayar" ) );
            ctx.getForm().set( "sabetSayar", new Integer( 0 ) );
        }
    }

    protected ActionForward doImport( BaseActionContext ctx ) throws ProxyException {
/*
    1.
    update rokhdad
    set rokhdad.moshtarakId=m.id
    from ev_su e
	    inner join rokhdad r on e.eventId=r.rokhdadId
	    inner join moshtarak m on e.subscriptionId=m.eshterakId
    where r.rokhdadId < 346833 and r.moshtarakId='978280808080808080o'

    2.
    update rokhdad
    set rokhdad.moshtarakId=m.id
    from ev_su e
	    inner join rokhdad r on e.eventId=r.rokhdadId
	    inner join moshtarak m on e.chassisno=m.shomareShasi
    where r.rokhdadId < 346833 and r.moshtarakId='978280808080808080o'
*/

        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;


        if ( !isCancelled( ctx.getRequest() ) ) {
            ResultSet rs2 = null;
            com.objectj.emdad.ejb.util.Util.add( "unk_Shahr", Constants.getShahr_Unknown() );
            com.objectj.emdad.ejb.util.Util.add( "unk_Moshtarak", Constants.getMoshtari_Unknown() );
            String daftarOstaniTehran = ctx.getUserSession().getDaftarOstani();

            try {
                ArrayList shahrList = ShahrSessionUtil.getLocalHome().create().readCombo( "shahr", "shahrId", "", "shahrId" ).getResult();

                PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( Util.getTempraryPath() + "importRokhdad.log" ) ) );
                String curl = null;
                if ( UserSession.isISDatabaseSQL() ) {
                    Class.forName( "com.ddtek.jdbc.sqlserver.SQLServerDriver" );
                    curl = "jdbc:datadirect:sqlserver://222.192.55.220:1433;DatabaseName=aid;User=sa;Password=anahita";
                } else {
                    Class.forName( "oracle.jdbc.driver.OracleDriver" );
                    curl = "jdbc:oracle:thin:emdad2/123@222.192.55.224:1521:emdaddb";
                }
                Connection connection = DriverManager.getConnection( curl );
                //Connection connection = com.objectj.emdad.ejb.util.Util.getConnection(); // DriverManager.getConnection(com.objectj.emdad.web.util.Util.getProperty("application.connection.aid.url"));

                Statement statement = connection.createStatement();
                String query = "SELECT * FROM view_import_rokhdad";
                Integer rId = (Integer) ctx.getForm().get( "rokhdadId" );
                if ( rId != null && rId.intValue() != 0 ) {
                    query += " where eventId>=" + rId.intValue();
                }
//                query += " order by ChassisNo";

//                query = "SELECT * FROM view_import_subscriptions where ChassisNo>='0080716200' and ChassisNo<='0080716205'";
//                out = new PrintWriter(new BufferedWriter(new FileWriter(Util.getTempraryPath() + "importMoshtarak2.log")));

                log.info( "query=" + query );
                ResultSet resultSet = statement.executeQuery( query );
                log.info( "query Done." );

                // another connection to log import Status into AID DB
                Connection connectionQry = DriverManager.getConnection( curl );
                Connection connectionStatus = DriverManager.getConnection( curl );
                //Connection connectionStatus = com.objectj.emdad.ejb.util.Util.getConnection();
                Statement statementStatus = connectionStatus.createStatement();

                ////////////////////////////////////////////////////////////////
                // query and put result in memory objects to improve performance

                //for (int counter = 0; counter < 100000; counter++) {
                //    resultSet.next();
                String lastRokhdadIdS = UserAccessEntity.stringQuery( "SELECT max(rokhdadId) as last FROM rokhdad ", "last", ctx.getConnection() );
                int lastRokhdadId = Integer.parseInt( lastRokhdadIdS );
                int eventId = 0;

                while ( resultSet.next() && eventId < 346833 ) { //lastRokhdadId<360000) {

                    recordCount++;

                    if ( recordCount % 100 == 0 ) {
                        log.info( "imported:" + recordCount + ",updateCount:" + updateCount + ",createCount:" + createCount + ",errorCount:" + errorCount );
                    }

                    boolean isUpdate = false;
                    RokhdadModel rokhdad = null;
                    rokhdad = new RokhdadModel();

                    eventId = resultSet.getInt( "EventId" );
                    log.info( "rokhdadId=" + eventId );
                    String id = UserAccessEntity.stringQuery( "SELECT id FROM rokhdad WHERE rokhdadId = " + eventId, "id", ctx.getConnection() );
                    if ( id != null && id.length() > 0 ) {
                        //continue;
                        isUpdate = true;
                        rokhdad.setId( id );
                    } else {
                        rokhdad.setNoeDarkhastKonandeh( new Integer( 1 ) );
                        rokhdad.setDastorkarGhabli( new Integer( 0 ) );
                        rokhdad.setIrad( "" );
                        rokhdad.setTel( "" );
                        rokhdad.setZamaneVaghei( new Timestamp( 0 ) );
                        rokhdad.setAddress( "" );
                        rokhdad.setMantagheh( new Integer( 0 ) );
                        rokhdad.setSabetSayar( new Integer( 0 ) );
                        rokhdad.setKhadamateVijeh( new Integer( 0 ) );
                        rokhdad.setTarikhFaalShodan( new Date( 0 ) );
                        rokhdad.setSabtKonandeh( "918280808080805FA5o" );
                        rokhdad.setAkharinTaghyirDahandeh( "918280808080805FA5o" );
                        rokhdad.setEghdamShodeh( new Integer( 1 ) );
//                        eventId = 360000;
//                        while (lastRokhdadId < eventId-1 ) {
//                            try {
//                                rokhdad.setId("");
//                                rokhdad = (RokhdadModel) ((RokhdadProxy)getProxy()).create(rokhdad, (String)com.objectj.emdad.ejb.util.Util.get("unk_Moshtarak"), null, daftarOstaniTehran, (String)com.objectj.emdad.ejb.util.Util.get("unk_Shahr"));
//                                createCount++;
//                            } catch (Exception e) {
//                                out.println("Error Creating Blank rokhdad Entity. (rokhdadId = " + lastRokhdadId);
//                                errorCount++;
//                            }
//                            lastRokhdadId = rokhdad.getRokhdadId().intValue();
//                            log.info("lastRokhdadId=" + lastRokhdadId);
//                        }
//                        lastRokhdadId = 360001;
//                        if (1==1) continue;
                        rokhdad.setId( "" );
                    }
                    String moshtarakId = resultSet.getString( "SubscriptionID" );
                    if ( moshtarakId != null ) {
                        moshtarakId = moshtarakId.trim();
                    }

                    moshtarakId = UserAccessEntity.stringQuery( "SELECT id FROM moshtarak WHERE eshterakId = '" + moshtarakId + "'", "id", ctx.getConnection() );
                    if ( ( moshtarakId == null ) || ( moshtarakId.length() == 0 ) ) {
                        moshtarakId = (String) com.objectj.emdad.ejb.util.Util.get( "unk_Moshtarak" );
//                        out.println("moshtarak not exists. (rokhdadId = " + eventId+",moshtarakId="+moshtarakId);
//                        errorCount++;
//                        statementStatus.executeUpdate("UPDATE events SET importStatus = 10 where eventId = " + eventId );
//                        continue;
                    }

                    rokhdad.setNoeDarkhastKonandeh( new Integer( 1 ) );
                    rokhdad.setDastorkarGhabli( new Integer( 0 ) );
                    String irad = resultSet.getString( "Fault" );
                    irad = irad != null ? irad.trim() : "";
                    rokhdad.setIrad( irad.substring( 0, irad.length() < 60 ? irad.length() : 60 ) );
                    rokhdad.setTel( resultSet.getString( "Phone" ) != null ? resultSet.getString( "Phone" ).trim() : "" );
                    rokhdad.setZamaneVaghei( resultSet.getTimestamp( "RealTime" ) );
                    String address = resultSet.getString( "Location" );
                    address = address != null ? address.trim() : "";
                    rokhdad.setAddress( address.substring( 0, address.length() < 80 ? address.length() : 80 ) );
                    rokhdad.setMantagheh( new Integer( 0 ) );
                    rokhdad.setSabetSayar( new Integer( resultSet.getBoolean( "Mobile" ) ? 1 : 2 ) );
                    rokhdad.setKhadamateVijeh( new Integer( resultSet.getBoolean( "Special" ) ? 1 : 2 ) );
                    rokhdad.setTarikhFaalShodan( resultSet.getDate( "Time" ) );
                    rokhdad.setSabtKonandeh( "918280808080805FA5o" );
                    rokhdad.setAkharinTaghyirDahandeh( "918280808080805FA5o" );
//                    rokhdad.setRokhdadId(1);

                    String serviceId = UserAccessEntity.stringQuery( "SELECT serviceId FROM services WHERE eventId = " + eventId, "serviceId", connectionQry );
                    if ( serviceId != null && serviceId.length() > 0 ) {
                        rokhdad.setEghdamShodeh( new Integer( 1 ) );
                    } else {
                        rokhdad.setEghdamShodeh( new Integer( 2 ) );
                    }

                    //	chech if this enity already exsists
                    QueryObject rokhdadQuery = new QueryObject();
                    rokhdadQuery.setSelectFields( "id" );
                    rokhdadQuery.setTables( "rokhdad" );
                    rokhdadQuery.setWhere( "rokhdadId = " + eventId );
                    rokhdadQuery.setJoined( false );

                    String city = resultSet.getString( "citySyncId" );
                    String shahrId = null;

                    if ( city != null && city.length() != 0 ) {
                        shahrId = Util.getIdFromList( shahrList, city );

                        if ( shahrId == null ) {
                            out.println( "city=" + city + " does not exist. (eventId = " + eventId );
                            shahrId = Constants.getShahr_Unknown(); // unknown
                        }

                    } else {
                        out.println( "shahr not set. (eventId = " + eventId );
                        shahrId = Constants.getShahr_Unknown(); // unknown
                    }

                    if ( !isUpdate ) {
                        rokhdad.setId( "" ); //char
                    }

                    boolean success = false;
                    if ( isUpdate ) {
                        try {
                            ( (RokhdadProxy) getProxy() ).update( rokhdad, moshtarakId, null, daftarOstaniTehran, shahrId );
                            success = true;
                            updateCount++;
                        } catch ( Exception e ) {
                            out.println( "Error Updating Entity. (rokhdadId = " + eventId );
                            errorCount++;
                            statementStatus.executeUpdate( "UPDATE events SET importStatus = 10 where eventId = " + eventId );
                        }
                    } else {
                        try {
                            rokhdad = (RokhdadModel) ( (RokhdadProxy) getProxy() ).create( rokhdad, moshtarakId, null, daftarOstaniTehran, shahrId );
                            success = true;
                            createCount++;
                        } catch ( Exception e ) {
                            out.println( "Error Creating Entity. (rokhdadId = " + eventId );
                            errorCount++;
                            statementStatus.executeUpdate( "UPDATE events SET importStatus = 10 where eventId = " + eventId );
                        }
                        lastRokhdadId = rokhdad.getRokhdadId().intValue();
                    }
                    if ( success ) {
                        String is = resultSet.getString( "importStatus" );
                        if ( is != null && !is.equals( "0" ) ) {
                            statementStatus.executeUpdate( "UPDATE events SET importStatus = 0 where eventId = " + eventId );
                        }
                    }
                }

                out.println( "Error Count: " + errorCount );
                out.println( "Unchange Count: " + unchangeCount );
                out.println( "Update Count: " + updateCount );
                out.println( "Create Count: " + createCount );
                out.println( "Total record Count: " + recordCount );
                out.close();
            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            } finally {
                try {
                    if ( rs2 != null ) {
                        rs2.close();
                    }
                } catch ( Exception e2 ) {
                }

            }

        }

        errorList.add( 0, new String( "Error Count: " + errorCount ) );
        errorList.add( 0, new String( "Unchange Count: " + unchangeCount ) );
        errorList.add( 0, new String( "Update Count: " + updateCount ) );
        errorList.add( 0, new String( "Create Count: " + createCount ) );
        errorList.add( 0, new String( "Total record Count: " + recordCount ) );

        ctx.getRequest().setAttribute( "errorList", errorList );
        log.info( "========== iiiiiinnnnnneeeeehhhhhh..................." );
        return ctx.getActionMapping().findForward( "importinfo" );
    }

    protected ActionForward doImportXls( BaseActionContext ctx ) throws ProxyException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            log.info( "oomadam to do importXls" );
            Connection con = null;
            Statement stmt = null;
            String query = "";
            ResultSet rs = null;
            try {
                Class.forName( "org.aarboard.jdbc.xls.XlsDriver" ).newInstance();
                /*    String dir="d:/home/emdad/uploads/application";
                    String fileName = "1064"; */
                String path = ctx.getRequest().getParameter( "xlsFile" );
                log.info( "File.separator=" + File.separator );
                log.info( "path=" + path );
                log.info( "path.lastIndexOf(File.separator)=" + path.lastIndexOf( File.separator ) );
                String dir = path.substring( 0, path.lastIndexOf( File.separator ) );
                String fileName = path.substring( path.lastIndexOf( File.separator ) + 1, path.lastIndexOf( "." ) );

                con = DriverManager.getConnection( "jdbc:aarboard:xls:" + dir );
                stmt = con.createStatement();
                query = "SELECT * FROM " + fileName;
                rs = stmt.executeQuery( query );
                //fileName=fileName.substring(0,4);
                int cols = rs.getMetaData().getColumnCount();
                int radif = 0;
                String eshterakId = "";
                String shomareShasi = "";
                String shomarePelak = "";
                String telefon = "";
                String irad = "";
                String kiloometr = "";
                String modatAnjam = "";
                String gheimat = "";
                String doit = "";
                String namayandegiId = "";
                String rokhdadId = "";
                String username = ctx.getUserSession().getId();
                String userId = ctx.getUserSession().getId();
                String shahrId = "";
                String daftarOstaniId = "";
                String moshtarakId = "";
                String s = "";
                String dastoorKar = "";
                String tarikhTahvil = "";
                String shomareCard = "";
                String address = "";

                String payanKar = "";
                int tedadRoz = 0;

                String moshtarak_Id = "";
                String dalil = "";
                Date shoroDate = null;
                boolean valid = true;
                int errorCode = 0;
                ArrayList al = new ArrayList();
//                NamayandegiLocal namayandegiObject = null;
                ShahrLocal shahrObject = null;
//                DaftarOstaniLocal dolObject = null;
//                ShakhsLocal userObject = ShakhsUtil.getLocalHome().findByPrimaryKey(username);
//                MoshtarakLocal moshtarakObject = null;
//                VazeatKhedmatLocal vklObject = null;
                String vazeatKhedmatId = null;
                String emdadgarId = null;
//                String moshtarakId = null;
                EmdadLocal emdadObject = null;
//                EmdadgarLocal emdadgarObject = null;
                //  DaftarOstaniLocal dosObject = null;
                Integer namayandegiOrEmdadgar = null;
                String idOrCode = "-1";
                Integer adiOrVije = new Integer( -1 );
                Integer baliniOrTamiri = new Integer( -1 );
                Integer sabetOrSayar = new Integer( -1 );
                Integer darkhastKonandeh = new Integer( -1 );
                Integer noeKhedmat = new Integer( -1 );
                String noeKhedmatSt = "";
                Integer vazeatKhedmat = new Integer( -1 );
                String errorString = "";
                String hadaksarKar = "";
                if ( rs.next() ) {
                    for ( int i = 0; i < 7; i++ ) {
                        s = rs.getString( i );
                        switch ( i ) {
                            case 0://0 namayandegi 1 emdadgar
                                {
                                    try {
                                        namayandegiOrEmdadgar = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                    } catch ( Exception e ) {
                                        log.info( "namayandegiOr emdadgar format error" );
                                        errorCode = 14;
                                    }//invalid file format
                                    finally {
                                        break;
                                    }
                                }
                            case 1:
                                {
                                    if ( s.length() < 10 ) {
                                        idOrCode = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                        //    namayandegiId = idOrCode;


                                    } else {
                                        idOrCode = s.trim();
                                    }
                                    break;

                                }
                            case 2:
                                {
                                    try {
                                        adiOrVije = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                        if ( adiOrVije.intValue() != 1 && adiOrVije.intValue() != 2 ) {
                                            errorCode = 26;
                                            errorString += "invalid noeService" + "\n";//invalid noeservice
                                        }
                                        break;
                                    } catch ( Exception e ) {
                                        errorCode = 15;//invalid file format
                                    } finally {
                                        break;
                                    }
                                }
                            case 3:
                                {
                                    try {
                                        baliniOrTamiri = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                        if ( baliniOrTamiri.intValue() != 1 && baliniOrTamiri.intValue() != 2 ) {
                                            errorCode = 17;
                                            errorString += "invalid noeEmdad" + "\n";//invalid NoeEmdad
                                        }
                                        break;
                                    } catch ( Exception e ) {
                                        errorCode = 15;//invalid file format
                                    } finally {
                                        break;
                                    }
                                }
                            case 4:
                                {
                                    try {
                                        sabetOrSayar = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                        if ( sabetOrSayar.intValue() != 1 && sabetOrSayar.intValue() != 2 ) {
                                            errorCode = 18;
                                            errorString += "invalid sabetSayyar" + "\n";//invalid SabetSyar
                                        }
                                        break;
                                    } catch ( Exception e ) {
                                        errorCode = 15;//invalid file format
                                    } finally {
                                        break;
                                    }
                                }
                            case 5:
                                {
                                    try {
                                        darkhastKonandeh = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                        if ( darkhastKonandeh.intValue() != 1 && darkhastKonandeh.intValue() != 2 ) {
                                            errorCode = 19;
                                            errorString += "invalid darkhastKonandeh" + "\n";//invalid darkhast Konandeh
                                        }
                                        break;
                                    } catch ( Exception e ) {
                                        errorCode = 15;//invalid filre format
                                    } finally {
                                        break;
                                    }
                                }
                            case 6:
                                {
                                    try {
                                        vazeatKhedmat = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                        String ayaValid = "";
                                        ayaValid = UserAccessEntity.stringQuery( "select id from VazeatKhedmat where vazeatKhedmatId =" + vazeatKhedmat.toString(), "id", ctx.getConnection() );

                                        if ( ayaValid.equalsIgnoreCase( "" ) ) {
                                            errorCode = 20;
                                            errorString += "invalid VazeatKhedmat" + "\n";
                                        } else
//                                             vklObject = VazeatKhedmatUtil.getLocalHome().findByPrimaryKey(ayaValid);
                                        {
                                            vazeatKhedmatId = ayaValid;
                                        }
                                        break;
                                    } catch ( Exception e ) {
                                        errorCode = 15;//invalid filre format
                                    } finally {
                                        break;
                                    }
                                }
                        }

                    }
                    String ezName = UserAccessEntity.stringQuery( "select name from shakhs where id ='" + username + "'", "name", ctx.getConnection() );
                    QueryObject qo = new QueryObject( "shakhs", "shakhs", "", false );
                    qo.setSelectFields( "id" );
                    qo.setWhere( "name=?" );
                    qo.addElement( new QueryElement( "String", ezName ) );
                    String[] opId = UserAccessEntity.stringQuerys( qo, ctx.getConnection() );
                    if ( opId.length == 0 || com.objectj.emdad.ejb.util.Util.isEmpty( opId[ 0 ] ) ) {
                        errorCode = 24;//shakhs id operator nadarad
                        errorString += "no Operator Username exists for current user" + "\n";
                    }
                }
                log.info( "errorString=" + errorString );
                if ( errorCode != 0 ) {
                    RokhdadList dummy = new RokhdadList();
                    dummy.setMoshtarakYaNa( new Integer( errorCode ) );
                    dummy.setDaftarOstaniId( errorString );
                    al.add( dummy );
                    ctx.getRequest().setAttribute( "value_object_list", al );
                    return ctx.getActionMapping().findForward( "getXLS" );


                }

                if ( idOrCode.length() < MAX_NAMAYANDEGI_LENGTH ) {
//----------------------Ettelaate Namayandegi------------------------------------------>
//                    log.info("jam kardane ettelaate Namayandegi");
                    namayandegiId = UserAccessEntity.stringQuery( "select id from Namayandegi where namayandegiId='" + idOrCode + "'", "id", ctx.getConnection() );
                    if ( baliniOrTamiri.intValue() == 1 ) {
                        hadaksarKar = UserAccessEntity.stringQuery( "select hadaksarKar from Namayandegi where namayandegiId='" + idOrCode + "'", "hadaksarKar", ctx.getConnection() );
                    } else {
                        hadaksarKar = UserAccessEntity.stringQuery( "select hadaksarKar2 from Namayandegi where namayandegiId='" + idOrCode + "'", "hadaksarKar2", ctx.getConnection() );
                    }
                    shahrId = UserAccessEntity.stringQuery( "select shahrId from Namayandegi where namayandegiId='" + idOrCode + "'", "shahrId", ctx.getConnection() );
                    daftarOstaniId = UserAccessEntity.stringQuery( "select daftarOstaniId from Namayandegi where namayandegiId='" + idOrCode + "'", "daftarOstaniId", ctx.getConnection() );
//                    log.info("geraeftam NamayandegiId ro va hast  " + namayandegiId);
                    if ( namayandegiId != null && namayandegiId.length() != 0 ) {
                        //namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(namayandegiId);
////--------------------------------------set kardardast----------------------------------------------------------------->
//                        if(baliniOrTamiri.intValue()==1){
//                         NamayandegiModel nm = namayandegiObject.getNamayandegiModel();
//                            nm.setKarDarDast(new Integer(nm.getKarDarDast().intValue()-1));
//                            namayandegiObject.setNamayandegiModel(nm);
//                        }else{
//                            NamayandegiModel nm = namayandegiObject.getNamayandegiModel();
//                               nm.setKarDarDast2(new Integer(nm.getKarDarDast2().intValue()-1));
//                               namayandegiObject.setNamayandegiModel(nm);
//
//                        }
////--------------------------------------set kardardast----------------------------------------------------------------->
//                        shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
//                        dolObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);
                        // dosObject =

                    } else {
                        errorCode = 14;//invalid code namayandegi
                    }

//---------------------End Ettelaate Namayandegi---------------------------------------->
                } else {
//----------------------Ettelaate Emdadgar------------------------------------------>
//                    log.info("jam kardane ettelaate Emdadgar");
                    //namayandegiId = UserAccessEntity.stringQuery("select id from Emdadgar where id='" + idOrCode + "'", "id");
                    shahrId = UserAccessEntity.stringQuery( "select shahrId from Namayandegi,Emdadgar where Emdadgar.namayandegiId=Namayandegi.id and Emdadgar.id='" + idOrCode + "'", "shahrId", ctx.getConnection() );
                    daftarOstaniId = UserAccessEntity.stringQuery( "select daftarOstaniId from Emdadgar where id='" + idOrCode + "'", "daftarOstaniId", ctx.getConnection() );
//                    log.info("geraeftam Emdadgar ro va hast  " + idOrCode);
                    if ( daftarOstaniId != null && daftarOstaniId.length() != 0 ) {
                        hadaksarKar = UserAccessEntity.stringQuery( "select hadaksarKar from Emdadgar where id='" + idOrCode + "'", "hadaksarKar", ctx.getConnection() );
//                        emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(idOrCode);
                        emdadgarId = idOrCode;
//                        shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
//                        dolObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(daftarOstaniId);
                        // dosObject =
////----------------------------kardar dast emdadgar------------------------------------------------------------>
//                        EmdadgarModel emm = emdadgarObject.getEmdadgarModel();
//                        emm.setKarDarDast(new Integer(emm.getKarDarDast().intValue()-1));
//                        emdadgarObject.setEmdadgarModel(emm);
////----------------------------kardar dast emdadgar------------------------------------------------------------>

                    } else {
                        errorCode = 16;//invalid EmdadgarId
                    }

//---------------------End Ettelaate Emdadgar---------------------------------------->

                }
                if ( errorCode == 0 ) {
                    RokhdadList rl = new RokhdadList();
                    int j = 0;
                    int limit = 10;
                    boolean doUpdate = false;
                    while ( rs.next() && limit > 0 ) {
                        dastoorKar = "";
                        noeKhedmatSt = "";
                        j++;
                        valid = true;
                        errorCode = 0;
                        for ( int i = 0; i < cols; i++ ) {
                            s = rs.getString( i );
                            switch ( i ) {
                                case 0:
                                    {
                                        radif = j;//s.trim();
                                        break;
                                    }
                                case 1:
                                    {
                                        eshterakId = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                        break;
                                    }
                                case 2:
                                    {
                                        shomareShasi = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                        break;
                                    }
                                case 3:
                                    {
                                        shomarePelak = s.trim();
                                        break;
                                    }
                                case 4:
                                    {
                                        telefon = s.trim();
                                        break;
                                    }
                                case 5:
                                    {
                                        irad = s.trim();
                                        break;
                                    }
                                case 6:
                                    {
                                        kiloometr = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
//                                        log.info("kilometere karkard = '" + kiloometr + "'");
                                        try {
                                            Integer t = new Integer( kiloometr );
                                        } catch ( Exception e ) {
                                            log.info( "problem with kiloometr," + kiloometr );
                                            errorCode = 7;
                                        } finally {
                                            break;
                                        }
                                    }
                                case 7:
                                    {
                                        address = s.trim();
                                        break;
                                    }
                                case 8:
                                    {
//                                        log.info("dastoorKar = '" + dastoorKar + "'");
                                        dastoorKar = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                        if ( dastoorKar != null && dastoorKar.length() != 0 ) {
                                            try {
                                                Integer t = new Integer( dastoorKar );
                                            } catch ( Exception e ) {
//                                                log.info("problem with dastoorkar");
                                                errorCode = 27;
                                            } finally {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                case 9:
                                    {
                                        modatAnjam = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
//                                        log.info("modat = '" + modatAnjam + "'");
                                        try {
                                            Integer t = new Integer( modatAnjam );
//                                            log.info("modat = " + modatAnjam);
                                        } catch ( Exception e ) {
//                                            log.info("problem with modat");
                                            errorCode = 28;
                                        } finally {
                                            break;
                                        }

                                    }
                                case 10:
                                    {
                                        noeKhedmatSt = s.trim();
                                        try {
                                            noeKhedmat = new Integer( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                            int sz = Util.getArrayList( "emdad" ).size();
//                                        PropsFile pro = new PropsFile("/home/emdad/constants/","emdad");
                                            if ( noeKhedmat.intValue() < 1 || noeKhedmat.intValue() > sz ) {
                                                errorCode = 20;//invalid noeKhedmat
                                            }
                                        } catch ( Exception e ) {
                                            errorCode = 20;//invalid noeKhedmat
                                        } finally {
                                            break;
                                        }


                                    }
                                case 11:
                                    {
                                        gheimat = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
//                                        log.info("gheimat = '" + gheimat + "'");
                                        try {
                                            Integer t = new Integer( gheimat );
                                        } catch ( Exception e ) {
//                                            log.info("problem with gheimat");
                                            errorCode = 7;
                                        } finally {
                                            break;
                                        }
                                    }
                                case 12:
                                    {
                                        tarikhTahvil = s.trim();
                                        break;

                                    }
                                case 13:
                                    {
                                        shomareCard = s.trim();
                                        break;
                                    }
                                case 14:
                                    {
                                        if ( dastoorKar.length() == 0 ) {
                                            payanKar = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                            break;
                                        } else {
                                            try {
                                                tedadRoz = Integer.parseInt( com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() ) );
                                            } catch ( Exception e ) {
//                                                log.info("s=["+s+"]",e);
                                                errorCode = 8;//adad tedad roz na motabar asat.
                                            }
                                            /* if (HejriUtil.isValidDate(com.objectj.emdad.ejb.util.Util.digitsOnly(s.trim())))
                                                  payanKar = com.objectj.emdad.ejb.util.Util.digitsOnly(s.trim());
                                              else
                                                  errorCode = 8;//tarikh na motabar ast
                                           //*/
                                            break;
                                        }
                                    }
                                case 15:
                                    {
                                        doit = com.objectj.emdad.ejb.util.Util.digitsOnly( s.trim() );
                                        break;
                                    }
                                case 16:
                                    {
                                        dalil = s.trim();
                                        break;
                                    }
                            }
                        }

//-------------------------------------------------Just Update Emdad so validate------------------------------------------------>
                        doUpdate = false;
                        EmdadModel em = null;
                        if ( dastoorKar.length() != 0 && errorCode == 0 ) {
                            doUpdate = true;
                            String chkUpdate = "";
                            query = "select eshterakId from Emdad,Rokhdad,Moshtarak " +
                                    "where Emdad.rokhdadId=Rokhdad.id and Rokhdad.moshtarakId = Moshtarak.id and Emdad.emdadId=" + dastoorKar;
                            chkUpdate = UserAccessEntity.stringQuery( query, "eshterakId", ctx.getConnection() );
                            if ( chkUpdate == null || chkUpdate.length() == 0 ) {
                                errorCode = 9;//emdad not found
                            } else if ( !chkUpdate.equalsIgnoreCase( eshterakId ) ) {
                                errorCode = 10;//emdad not related with moshtarak
                            } else {
                                emdadObject = (EmdadLocal) EmdadUtil.getLocalHome().findByEntityId( new Integer( dastoorKar ) ).toArray()[ 0 ];
                                em = emdadObject.getEmdadModel();
                                if ( !em.getVazeatKonuni().equals( new Integer( 1 ) ) ) {
                                    errorCode = 11;//emdadShoroNashode
                                } else {
                                    shoroDate = new Date( em.getZamanShoro().getTime() );
                                    payanKar = HejriUtil.incDayInHejriDate( HejriUtil.chrisToHejri( shoroDate ), tedadRoz );
                                    if ( HejriUtil.hejriToChris( payanKar ).after( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ) {
                                        payanKar = HejriUtil.chrisToHejri( HejriUtil.getCurrentDate() );
                                    }
                                    if ( HejriUtil.hejriToChris( payanKar ).before( shoroDate ) ) {
                                        errorCode = 12;//tarikh payan ghabl az tarikh shoro
                                    }
                                }
//                                log.info("is before=" + HejriUtil.hejriToChris(payanKar).before(shoroDate));
//                                log.info("payanKar=" + HejriUtil.hejriToChris(payanKar) + ",shoroDate=" + shoroDate);

                            }
                        }
//--------------------------------------------------Validate-------------------------------------------------------->
                        String chkEshterakId = "";
                        String chkShomareShasi = "";
                        String chkMoshtarakYaNa = "";
                        //  errorCode = 0;
                        if ( eshterakId.trim().length() == 0 || shomareShasi.trim().length() == 0 || errorCode == 14 ) {
                            limit--;
                            continue;
                        } else {
                            if ( doit.equalsIgnoreCase( "0" ) ) {
                                errorCode = 5; //cancelled by opetrator
                            } else if ( errorCode == 0 ) {
                                moshtarak_Id = UserAccessEntity.stringQuery( "select id from Moshtarak where eshterakId='" + eshterakId + "'", "id", ctx.getConnection() );
                                chkShomareShasi = UserAccessEntity.stringQuery( "select eshterakId from Moshtarak where shomareShasi='00" + shomareShasi + "'", "eshterakId", ctx.getConnection() );
                                if ( com.objectj.emdad.ejb.util.Util.isEmpty( chkShomareShasi ) ) {
                                    chkShomareShasi = UserAccessEntity.stringQuery( "select eshterakId from Moshtarak where shomareShasi='" + shomareShasi + "'", "eshterakId", ctx.getConnection() );
                                }
                                if ( com.objectj.emdad.ejb.util.Util.isEmpty( chkShomareShasi ) ) {
                                    errorCode = 1;//shomare shasi motabar nist;
                                } else if ( com.objectj.emdad.ejb.util.Util.isEmpty( moshtarak_Id ) ) {
                                    errorCode = 4;//invalid Eshterak
                                } else if ( !chkShomareShasi.trim().equalsIgnoreCase( eshterakId.trim() ) ) {
                                    errorCode = 2;//adame entebaghe shasi va eshterak
                                } else {
                                    chkMoshtarakYaNa = UserAccessEntity.stringQuery( "select moshtarakYaNa from Moshtarak where eshterakId='" + eshterakId + "'", "moshtarakYaNa", ctx.getConnection() );
                                    if ( !( chkMoshtarakYaNa.equalsIgnoreCase( "1" ) ) ) {
                                        errorCode = 3;//gheire moshtarak
                                    }
                                }
                            }
                        }
                        if ( !doUpdate && !payanKar.trim().equalsIgnoreCase( "1" ) ) {
                            String kdd = null;
//                            if (hadaksarKar.length() == 0)
//                                hadaksarKar = "0";
                            if ( idOrCode.length() < MAX_NAMAYANDEGI_LENGTH ) {
                                //todo check zarfiat namayandegi for each row?
                                if ( hadaksarKar.length() == 0 ) {
                                    errorCode = 22;//zarfiat emdad namayandegi takmil ast
                                    hadaksarKar = "0";
                                } else {
                                    if ( baliniOrTamiri.intValue() == 1 ) {
                                        kdd = UserAccessEntity.stringQuery( "select kardardast from Namayandegi where namayandegiId='" + idOrCode + "'", "kardardast", ctx.getConnection() );
                                    } else {
                                        kdd = UserAccessEntity.stringQuery( "select kardardast2 from Namayandegi where namayandegiId='" + idOrCode + "'", "kardardast2", ctx.getConnection() );
                                    }
                                    if ( kdd == null || kdd.equalsIgnoreCase( "" ) ) {
                                        kdd = "0";
                                    }
                                    if ( !( Integer.parseInt( hadaksarKar ) - Integer.parseInt( kdd ) > 0 ) && Integer.parseInt( hadaksarKar ) != -1 ) {
                                        errorCode = 22;//zarfiat emdad namayandegi takmil ast
                                    }
                                }
                            } else {
                                //todo check zarfiat emdadgar for each row?
                                if ( hadaksarKar.length() == 0 ) {
                                    errorCode = 23;//zarfiat emdad Emdadgar takmil ast
                                    hadaksarKar = "0";
                                } else {
                                    kdd = UserAccessEntity.stringQuery( "select kardardast from Emdadgar where id='" + idOrCode + "'", "kardardast", ctx.getConnection() );
                                    if ( kdd == null || kdd.equalsIgnoreCase( "" ) ) {
                                        kdd = "0";
                                    }
                                    if ( !( Integer.parseInt( hadaksarKar ) - Integer.parseInt( kdd ) > 0 ) && Integer.parseInt( hadaksarKar ) != -1 ) {
                                        errorCode = 23;//zarfiat emdad Emdadgar takmil ast
                                    }
                                }
                            }
                        }
                        if ( errorCode == 0 && !doUpdate ) {
//---------------------------------------if(doUpdate) udateEmdad-------------------------------------------------------------->

//----------------------------------CREATE ROKHDAD------------------------------------------------------------------>
//                            System.out.println("Strating Creating Rokhdad");
                            log.info( "Strating Creating Rokhdad ,moshtarak_id is " + moshtarak_Id );
//                            moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarak_Id);
                            moshtarakId = moshtarak_Id;
                            RokhdadModel vo = new RokhdadModel();
                            Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );

                            //--------------- Setting tarikhFaalShodan ---------------------------
                            // ctx.getForm().set("tarikhFaalShodan", ((String)ctx.getForm().get("tarikhFaalShodan")).replace('/','-'));
                            vo.setTarikhFaalShodan( HejriUtil.getCurrentDate() );

                            //--------------- Setting sabtKonandeh ---------------------------
                            vo.setSabtKonandeh( username );

                            //--------------- Setting akharinTaghyirDahandeh ---------------------------
                            vo.setAkharinTaghyirDahandeh( ctx.getUserSession().getId() );

                            //--------------- Setting zamaneVaghei ---------------------------
                            vo.setZamaneVaghei( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );

                            //--------------- Setting eghdamShodeh ---------------------------
                            vo.setEghdamShodeh( new Integer( EGHDAM_SHODEH_BALI ) );

                            //--------------- Setting moshtarakId ----------------------------
                            //moshtarakId = UserAccessEntity.stringQuery("SELECT id FROM moshtarak WHERE eshterakId = '" + eshterakId+"'","id");
                            //----------------------------------------------------------------
                            ActionErrors error = new ActionErrors();                                                       // getDaftarOstani(ctx)
                            checkForIncomplete( ctx, moshtarakId, vo, error );
                            vo.setKilometerKarkard( new Integer( kiloometr ) );
                            vo.setDastorkarGhabli( new Integer( 0 ) );
//                            vo.setEghdamShodeh(new Integer(1));
                            vo.setIrad( irad );
                            /*****vo.setKhadamateVijeh(new Integer(1));***/
                            vo.setKhadamateVijeh( adiOrVije );
                            vo.setMobile( telefon );
                            /*********vo.setNoeDarkhastKonandeh(new Integer(2));**********/
                            vo.setNoeDarkhastKonandeh( darkhastKonandeh );
                            /************vo.setSabetSayar(new Integer(2));*************/
                            vo.setSabetSayar( sabetOrSayar );
                            vo.setAddress( address );
                            //     vo = (RokhdadModel) ((RokhdadProxy) getProxy()).create(vo, moshtarakObject, namayandegiObject, dolObject, shahrObject);
//------------------------------------------------END Create Rokhdad----------------------------------------------->
                            //      rokhdadId = vo.getId();
                            //     log.info("Rokhdad Created with Id = " + vo.getId());
//-----------------------------------------------Start Create Emdad------------------------------------------------->
//                            log.info("start Creating Emdad");

                            em = new EmdadModel();
                            Exchanger.exhangeFormToValueObject( ctx.getForm(), em );

                            /*********************  em.setNoeEmdad(new Integer(2)); *******************************/
                            em.setNoeEmdad( baliniOrTamiri );
                            em.setNoeKhedmateVije( noeKhedmat );
                            em.setFaseleAzNamayandegi( new Integer( 0 ) );
                            if ( payanKar.trim().equalsIgnoreCase( "1" ) ) {
                                em.setZamanVagheiPayan( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
                                em.setZamanPayan( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
                                em.setVazeatKonuni( new Integer( 2 ) );
                                em.setRahAndazi( irad );
//            em.setVazeatDakheli(new Integer(1));
                            } else {
                                em.setZamanVagheiPayan( null );
                                em.setZamanPayan( null );
                                em.setVazeatKonuni( new Integer( 1 ) );
                                em.setRahAndazi( null );

//            em.setVazeatDakheli(new Integer(0));

                            }
                            em.setModatTamir( new Integer( Integer.parseInt( modatAnjam ) ) );
                            em.setZamanEzam( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
                            em.setZamanShoro( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
                            em.setZamanVagheiEzam( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
                            em.setZamanVagheiShoro( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
//                            log.info("kiloometer karkard is " + kiloometr);
//                            log.info("gheimat is " + gheimat);
                            em.setKilometerKarkard( new Integer( Integer.parseInt( kiloometr ) ) );
                            em.setHododeHazinehKol( new Integer( Integer.parseInt( gheimat ) ) );
                            em.setMablaghPardakhtShodeh( new Integer( 0 ) );
                            em.setAkharinTagheerDahandeh( ctx.getUserSession().getId() );
                            //rokhdadObject = RokhdadUtil.getLocalHome().findByPrimaryKey(rokhdadId);
                            try {
                                if ( idOrCode.length() < MAX_NAMAYANDEGI_LENGTH ) {
                                    em = (EmdadModel) ( EmdadSessionUtil.getLocalHome().create() ).create( vo, em, vazeatKhedmatId, null, userId, null, namayandegiId, moshtarakId, daftarOstaniId, shahrId );
                                } else {
                                    em = (EmdadModel) ( EmdadSessionUtil.getLocalHome().create() ).create( vo, em, vazeatKhedmatId, emdadgarId, userId, null, null, moshtarakId, daftarOstaniId, shahrId );
                                }

//------------------------------------------------------------------------------------------------------------------>
                                dastoorKar = String.valueOf( em.getEmdadId() );
                                log.info( "emdad Created with Id = " + String.valueOf( em.getEmdadId() ) );
                            } catch ( Exception e ) {
                                errorCode = 6;
                                log.error( e );
//                                if(idOrCode.length()<5){
////----------------------------kardar dast emdadgar------------------------------------------------------------>
//                                    EmdadgarModel emm = emdadgarObject.getEmdadgarModel();
//                                    emm.setKarDarDast(new Integer(emm.getKarDarDast().intValue()+1));
//                                    emdadgarObject.setEmdadgarModel(emm);
////----------------------------kardar dast emdadgar------------------------------------------------------------>
//
//                                }else{
////--------------------------------------set kardardast namayandegi----------------------------------------------------------------->
//                                    if(baliniOrTamiri.intValue()==1){
//                                     NamayandegiModel nm = namayandegiObject.getNamayandegiModel();
//                                        nm.setKarDarDast(new Integer(nm.getKarDarDast().intValue()+1));
//                                        namayandegiObject.setNamayandegiModel(nm);
//                                    }else{
//                                        NamayandegiModel nm = namayandegiObject.getNamayandegiModel();
//                                           nm.setKarDarDast2(new Integer(nm.getKarDarDast2().intValue()+1));
//                                           namayandegiObject.setNamayandegiModel(nm);
//
//                                    }
////--------------------------------------set kardardast----------------------------------------------------------------->
//
//                                }
                            }
//------------------------------------------------------------------------------------------------------------------->
                        } else if ( errorCode == 0 && doUpdate ) {
//                            log.info("start updating emdad with id = " + dastoorKar);
//                        String idOfEmdad = UserAccessEntity.stringQuery("select id from emdad where emdadId = "+dastoorKar,"id");
                            //TODO exception on converting dastoorKar to timeStamp
                            try {
                                em.setVazeatKonuni( new Integer( 2 ) );
                                em.setHododeHazinehKol( new Integer( gheimat ) );
                                em.setZamanPayan( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( payanKar ), HejriUtil.getCurrentTime() ) );
                                em.setZamanVagheiPayan( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( payanKar ), HejriUtil.getCurrentTime() ) );
//update ghadimi                                (EmdadSessionUtil.getLocalHome().create()).update(em);
//----------------------------------------------- do payan ------------------------------------------------------------>
                                log.info( "000  doPayan" );

                                String eId, nId;
                                if ( idOrCode.length() > MAX_NAMAYANDEGI_LENGTH ) {
                                    eId = idOrCode;
                                    nId = "";
                                } else {
                                    eId = "";
                                    nId = namayandegiId;
                                }


                                EmdadSessionUtil.getLocalHome().create().payan( em, ctx.getUserSession().getId(), "", eId, nId );

//                                    Strin.g selectStatement = "execute dbo.PayanEmdad2 ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?" ;
//                                    PreparedStatement prepStmt = ctx.getConnection().prepareStatement(selectStatement); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                                    int i = 1;
//
//                                    prepStmt.setString(i++, em.getId());
//                                    prepStmt.setObject(i++, ctx.getUserSession().getId());
//                                    prepStmt.setInt(i++, em.getFaseleAzNamayandegi().intValue());
//                                    prepStmt.setTimestamp(i++, em.getZamanPayan());
//                                    prepStmt.setTimestamp(i++, em.getZamanVagheiPayan());
//                                    prepStmt.setInt(i++, em.getKilometerKarkard().intValue());
//                                    prepStmt.setInt(i++, em.getMablaghPardakhtShodeh()!=null ? em.getMablaghPardakhtShodeh().intValue() : 0);
//                                    prepStmt.setString(i++, em.getRahAndazi());
//                                    prepStmt.setString(i++, em.getTozihat());
//                                    prepStmt.setString(i++, em.getElateService());
//                                    prepStmt.setString(i++, "");
//
//                                    if(idOrCode.length()>5){
//                                    prepStmt.setString(i++, idOrCode);
//                                    prepStmt.setString(i++, "");
//                                    }else{
//                                    prepStmt.setString(i++, "");
//                                    prepStmt.setString(i++, namayandegiId);
//
//                                    }
//                                    EmdadSessionUtil.getLocalHome().create().payan(prepStmt);
//                                    prepStmt.close();
//                                    log.info("doPayan Done.");

//----------------------------------------------- end do payan -------------------------------------------------------->
                            } catch ( Exception e ) {
                                errorCode = 13;
                                e.printStackTrace();
                            }
                        }
//----------------------------------------Add a value object to arrayList--------------------------------------------->

                        rl = new RokhdadList();
                        rl.setSabetSayar( new Integer( radif ) );
                        rl.setMoshtarakEshterakId( eshterakId );
                        rl.setShahrShahrName( shomareShasi );
                        rl.setShomarePelak( shomarePelak );
                        rl.setTel( telefon );
                        rl.setIrad( irad );
                        rl.setAkharinTaghyirDahandehName( noeKhedmatSt );
                        rl.setNoeDarkhastKonandehName( kiloometr );
//                        log.info("dastoorKar="+dastoorKar);
                        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( dastoorKar ) && !dastoorKar.equals( "null" ) ) {
                            rl.setDastorkarGhabli( new Integer( dastoorKar ) );
                        } else {
                            rl.setDastorkarGhabli( new Integer( "0" ) );
                        }
                        rl.setAddress( address );
                        try {
                            rl.setEghdamShodeh( new Integer( modatAnjam ) );
                        } catch ( Exception e ) {
                            rl.setEghdamShodeh( new Integer( 1 ) );
                        }
                        try {
                            rl.setMantagheh( new Integer( gheimat ) );
                        } catch ( Exception e ) {
                            rl.setMantagheh( new Integer( 0 ) );
                        }
                        rl.setSabtKonandeh( tarikhTahvil );
                        rl.setMoshtarakName( shomareCard );
                        rl.setMoshtarakYaNa( new Integer( errorCode ) );
//                        log.info("errorCode = " + errorCode);
                        rl.setMobile( payanKar );
                        //if(doit.equalsIgnoreCase("0"))
                        rl.setId( doit );
                        rl.setDaftarOstaniId( dalil );
                        al.add( rl );
//-------------------------------------------------------------------------------------------------------------------->
                        ctx.getRequest().setAttribute( "value_object_list", al );
                    }
                } else {
                    RokhdadList rl = new RokhdadList();
                    rl.setMoshtarakYaNa( new Integer( errorCode ) );
                    ctx.getRequest().setAttribute( "value_object_list", al );
                }
            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            } finally {
                try {
                    if ( stmt != null ) {
                        stmt.close();
                    }
                    if ( rs != null ) {
                        rs.close();
                    }
                    if ( con != null ) {
                        con.close();
                    }
                } catch ( Exception e2 ) {
                }

            }

        }

        return ctx.getActionMapping().findForward( "getXLS" );
    }

}
