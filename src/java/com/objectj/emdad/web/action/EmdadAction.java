package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.*;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @struts.action name="emdadForm"
 * path="/c/emdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.edit.jsp"
 * inputPrime="emdad.emdad.edit"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/r/emdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.read.jsp"
 * inputPrime="emdad.emdad.read"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/u/emdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.edit.jsp"
 * inputPrime="emdad.emdad.edit"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/d/emdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.read.jsp"
 * inputPrime="emdad.emdad.read"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/l/emdad"
 * pathPrime="/emdadList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.list.jsp"
 * inputPrime="emdad.emdad.list"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/c/validateemdad"
 * pathPrime="/validateemdad"
 * scope="request"
 * input="/c/emdad.run"
 * inputPrime="emdad.emdad.edit"
 * input4tiles="emdad.emdad.edit"
 * validate="true"
 * @struts.action name="emdadForm"
 * path="/u/validateemdad"
 * pathPrime="/validateemdad"
 * scope="request"
 * input="/u/emdad.run"
 * inputPrime="emdad.emdad.edit"
 * input4tiles="emdad.emdad.edit"
 * validate="true"
 * @struts.action name="emdadForm"
 * path="/s/emdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/emdad.edit.jsp"
 * inputPrime="emdad.emdad.read"
 * validate="false"
 * @struts.action name="emdadForm"
 * path="/s/validateEmdad"
 * pathPrime="/emdad"
 * scope="request"
 * input="/s/emdad.run"
 * inputPrime="/s/emdad.run"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.emdad.list"
 * pathPrime="emdad.emdad.list"
 * @struts.action-forward name="list1"
 * path="emdad.emdad.list1"
 * pathPrime="emdad.emdad.list1"
 * @struts.action-forward name="list2"
 * path="emdad.emdad.list2"
 * pathPrime="emdad.emdad.list2"
 * @struts.action-forward name="list3"
 * path="emdad.emdad.list3"
 * pathPrime="emdad.emdad.list3"
 * @struts.action-forward name="confirmEnd"
 * path="/com/objectj/emdad/jsp/emdad.confirmEnd.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.confirmEnd.jsp"
 * @struts.action-forward name="confirm"
 * path="/com/objectj/emdad/jsp/emdad.confirm.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.confirm.jsp"
 * @struts.action-forward name="edit"
 * path="/com/objectj/emdad/jsp/emdad.edit.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.edit.jsp"
 * @struts.action-forward name="enseraf"
 * path="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 * pathPrime="/com/objectj/emdad/jsp/general.closeAndRefresh.jsp"
 * @struts.action-forward name="refresh"
 * path="/com/objectj/emdad/jsp/emdad.confirm.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.confirm.jsp"
 * @struts.action-forward name="shoro"
 * path="/com/objectj/emdad/jsp/emdad.shoro.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.shoro.jsp"
 * @struts.action-forward name="payan"
 * path="/com/objectj/emdad/jsp/emdad.payan.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.payan.jsp"
 * @struts.action-forward name="read"
 * path="emdad.emdad.read"
 * pathPrime="emdad.emdad.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="emdadShow"
 * path="/com/objectj/emdad/jsp/emdad.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.show.jsp"
 * @struts.action-forward name="find"
 * path="/com/objectj/emdad/jsp/emdad.find.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.find.jsp"
 * @struts.action-forward name="tasvieHesabEmdadgarList"
 * path="/com/objectj/emdad/jsp/emdad.tasviehEmdadgar.list.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.tasviehEmdadgar.list.jsp"
 * @struts.action-forward name="tasvieHesabNamayandegiList"
 * path="/com/objectj/emdad/jsp/emdad.tasviehNamayandegi.list.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.tasviehNamayandegi.list.jsp"
 * @struts.action-forward name="tasvieHesabJarsaghilList"
 * path="/com/objectj/emdad/jsp/emdad.tasviehJarsaghil.list.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.tasviehJarsaghil.list.jsp"
 * @struts.action-forward name="ipaqXls"
 * path="/com/objectj/emdad/jsp/emdad.ipaq.xls.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.ipaq.xls.jsp"
 * @struts.action-forward name="ipaqXlsImported"
 * path="/com/objectj/emdad/jsp/emdad.ipaq.xls.imported.jsp"
 * pathPrime="/com/objectj/emdad/jsp/emdad.ipaq.xls.imported.jsp"
 */

public class EmdadAction extends BaseAction {

    private final static int NOESERVICE_ADI = 2;

    private final static int NOE_EMDAD_BALINI = 1;

    private final static int NOE_EMDAD_TAMIR = 2;

    private final static int MALI_DONE = 1;

    private final static int MALI_NOT_DONE = 2;

    //private static Integer noeEmdad;
    //public  boolean isNew = false;
    //public boolean showMessage = false;
    //public Integer newEmdadId = new Integer(0);

    //String forceFilter, forceForwardTo;

    protected Class getValueObjectClass() {
        return EmdadModel.class;
    }

    protected Class getValueObjectClass2() {
        return EmdadList.class;
    }

    protected String[] getSortableColumns() {
        //return new String[]{"emdadId", "rokhdadId", "zamanEzam", "vazeatKhedmatId", "ezamgarId", "emdadgarId"};
        //return new String[]{"emdadId", "rokhdadId", "address", "zamanEzam", "onvan", "nameShakhs", "nameEmdadgar", "nameNamayandegi", "shomarePelak"};
        return new String[]{"emdadId", "rokhdadId", "address", "zamanEzam", "onvan", "nameShakhs", "nameEmdadgar",
                            "nameNamayandegi", "shomarePelak", "namayandegiId", "ezamgarId", "emdadgarId", "eshterakId", "daftarOstaniId"};
    }

    protected String[] getRelatedEntities() {
        return new String[]{"rokhdad", "vazeatKhedmat", "shakhs", "emdadgar"};
    }


    protected EntityProxy getProxy() throws ProxyException {
        try {
            return EmdadSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected void otherEmdads( BaseActionContext ctx, String id, String rokhdadId ) {
        ctx.getRequest().setAttribute( "emdadList", new ArrayList() );
        if ( 1 == 1 ) {
            return;
        }
        QueryObject emdadQuery = new QueryObject();
        emdadQuery.setTables( "emdad" );
        log.info( "otherEmdads," + id + "r=" + rokhdadId );
        ArrayList emdadArray = new ArrayList();
        ctx.getRequest().setAttribute( "emdadList", emdadArray );
        try {
//            rokhdadId = Util.getIdWithO("com.objectj.emdad.ejb.RokhdadModel", id, "rokhdad", "rokdadId");
            if ( id == null || id.length() == 0 )  // Create Mode
            {
                emdadQuery.setWhere( "emdad.rokhdadIdO = '" + rokhdadId + "'" );
            } else  // Update Mode
            {
                emdadQuery.setWhere( "emdad.rokhdadIdO = '" + rokhdadId + "' AND emdad.id <> '" + id + "'" );
            }
            emdadArray = EmdadSessionUtil.getLocalHome().create().readList( emdadQuery ).getResult();
        } catch ( ProxyException e ) {
            e.printStackTrace();
        } catch ( CreateException e ) {
            e.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        ctx.getRequest().setAttribute( "emdadList", emdadArray );
    }

    protected ActionForward doNullAction( BaseActionContext ctx ) {
//        log.info("-----doNullAction  start");
        ActionErrors errors = new ActionErrors();
        //todo
        //todo
        if ( Validators.rokhdadAlreadyServiced( ctx.getConnection(), (String) ctx.getForm().get( "rokhdadId" ), errors ) != null ) {
            showMessage( ctx, errors );
            return ctx.getActionMapping().findForward( "alertInfo" ); //todo
        }
        //todo
        //todo

        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm( vo, ctx.getForm() );
//        log.info("-----doNullAction  00000");

        ctx.getForm().set( ID, "" );
        ctx.getForm().set( ACTION_TYPE, "create" );
        ctx.getForm().set( "zamanEzam", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanEzam2", HejriUtil.getCurrentTime() );
        ctx.getForm().set( "noeEmdad", ctx.getRequest().getAttribute( "noeEmdad" ) );
        ctx.getForm().set( "vazeatKonuni", new Integer( 0 ) );
        ctx.getForm().set( "emdadgarIdGhabli", "" );
        ctx.getForm().set( "namayandegiIdGhabli", "" );
        ctx.getForm().set( "modatTamir", new Integer( 1 ) );

        return ctx.getActionMapping().findForward( "edit" );

    }

    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {
        Integer noeEmdad = (Integer) ctx.getForm().get( "noeEmdad" );
        //System.out.println( "NOE TASVIE: " + ctx.getRequest().getParameter( "noeTasvieh" ) );
        if ( ctx.getRequest().getParameter( "noeTasvieh" ) != null ) {
            ctx.getRequest().setAttribute( "noeTasvieh", ctx.getRequest().getParameter( "noeTasvieh" ) );
        }
        ctx.getRequest().setAttribute( "noeEmdad", noeEmdad );
        if ( noeEmdad != null ) {
            ctx.getRequest().setAttribute( "forceNoeEmdad", noeEmdad );
            if ( noeEmdad.intValue() == 1 ) {
                ctx.getForm().set( "forceNoeService", "adi" );
            } else {
                ctx.getForm().set( "forceNoeService", "vijeh" );
            }
        } else {
            ctx.getForm().set( "forceNoeService", "adi" );
            ctx.getRequest().setAttribute( "forceNoeEmdad", new Integer( 0 ) );
        }

        ArrayList ezamgarList = new ArrayList();

        boolean Log = ctx.getUserSession().getName().equals( "abc" );
        try {
            int ezamgarNaghshId = 0;
            if ( ( (String) ( ctx.getForm().get( "forceNoeService" ) ) ).equals( "adi" ) ) {
                ezamgarNaghshId = Constants.getEzamgarAdiShoghlId();
            } else {
                ezamgarNaghshId = Constants.getEzamgarVijeShoghlId();
            }

            ezamgarList = Util.readCombo( ctx, "shakhs", "name", "naghshId=" + ezamgarNaghshId + " AND daftarOstaniId='" + ctx.getUserSession().getDaftarOstani() + "'", null ).getResult();

            Util.getArrayList( "noeService" ); // required for loading
            Util.getArrayList( "noeNamayandegi" ); // required for loading
            ctx.getRequest().setAttribute( "noeEmdadList", Util.getArrayList( "noeEmdad" ) );

            ctx.getRequest().setAttribute( "koliyehMadarekList", Util.getArrayList( "yesNo" ) );
            ctx.getRequest().setAttribute( "noeKhedmateVijeList", Util.getArrayList( "emdad" ) );

            if ( Log ) {
                log.info( "-----doSpecificAction  00000" );
            }

        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            throw new ProxyException( e );
        }

        ctx.getRequest().setAttribute( "namayandegiList", ComboPool.getCombo( "namayandegi" ) );
        ctx.getRequest().setAttribute( "namayandegiOrAmelyatList", ComboPool.getCombo( "namayandegi_amelyat" ) );
        ctx.getRequest().setAttribute( "amelyatMojazList", ComboPool.getCombo( "amelyat" ) );
        ctx.getRequest().setAttribute( "ezamgarList", ezamgarList );
        ctx.getRequest().setAttribute( "vazeatKhedmatList", ComboPool.getCombo( "vazeatKhedmat" ) );
        ctx.getRequest().setAttribute( "dalileToolKeshidaneEmdadList", ComboPool.getCombo( "dalileToolKeshidaneEmdad" ) );
        ctx.getRequest().setAttribute( "daftarOstaniList", ComboPool.getCombo( "daftarOstani" ) );
        ArrayList namayandegiList = ComboPool.getCombo( "namayandegi_amelyat" );
        if ( ctx.getRequest().getParameter( "noeTasvieh" ) != null ) {
            ctx.getRequest().setAttribute( "noeTasvieh", ctx.getRequest().getParameter( "noeTasvieh" ) );
        }
        //------------------------------------------------------------------------------------------------------//
        if ( ctx.getAction().indexOf( "edit" ) >= 0 || ctx.getAction().indexOf( "error" ) >= 0 || ctx.getAction().length() == 0 ) {
//-------------Namayandegi comboBox------------------------------------------------------------------------------>>>>
//               log.info("oomadam too namayandegi combo object");
//               String zarfiats="";
            QueryObject qo2 = new QueryObject();
            if ( isDatabaseSQL() ) {
                qo2.setSelectFields( "cast(n.id as nvarchar)+','+cast(n.hadaksarkar -n.kardardast as nvarchar)+','+cast(n.hadaksarkar2 -n.kardardast2 as nvarchar) as id" );
            } else {
                qo2.setSelectFields( "n.id || ',' || (n.hadaksarkar -n.kardardast) || ',' || (n.hadaksarkar2 -n.kardardast2) as id" );
            }
            qo2.setTables( "Namayandegi n" );
            // qo2.setWhere(" n.vazGharardad = 2 AND n.noeKhodroId is not null ");
            QueryResult namayandegiHa = Exchanger.exhangeResultSetToValueObjectArray( ctx.getConnection(), qo2, null, new NamayandegiBean(), false );
            ArrayList namayandegiAL = namayandegiHa.getResult();
            String idd = null;
            NamayandegiBean nb = null;
            ComboObject namayandegiCO = null;
//               log.info("namayandegiList size = "+namayandegiList.size());
//               log.info("namayandegiArrayList size = "+namayandegiAL.size());
            ArrayList namayandegiOrAmelyatListHdn = new ArrayList();
            outer:
                    for ( Iterator iter = namayandegiList.iterator(); iter.hasNext(); ) {
                        namayandegiCO = (ComboObject) iter.next();
                        idd = namayandegiCO.getEid();
                        for ( int i = 0; i < namayandegiAL.size(); i++ ) {
                            nb = (NamayandegiBean) namayandegiAL.get( i );
                            //System.out.println("namid = "+nb.getId());
                            try {
                                if ( ( nb.getId().substring( 0, nb.getId().indexOf( "," ) ) ).equals( idd ) ) {
                                    namayandegiOrAmelyatListHdn.add( new ComboObject( nb.getId(), namayandegiCO.getName() ) );
//                           log.info(idd+"<- set to ->"+nb.getId());
//                           namayandegiCO.setEid(nb.getId());
                                    continue outer;
                                }
                            } catch ( Exception e ) {
                                e.printStackTrace();
                            }
                        }

                        // qo2.setWhere("n.id='"+id+"'");
                        // zarfiats = UserAccessEntity.stringQuery("select cast(n.namayandegiId as nvarchar)+','+cast(n.hadaksarkar -n.kardardast as nvarchar)+','+cast(n.hadaksarkar2 -n.kardardast2 as nvarchar) as myId from Namayandegi n where id='"+id+"'","myId");

                    }
            ctx.getRequest().setAttribute( "namayandegiIdHdn", new String( "" ) );
            ctx.getRequest().setAttribute( "namayandegiOrAmelyatListHdn", namayandegiOrAmelyatListHdn );
//------------------------------namayandegi---------------------------------------------------------------------->>>
            ArrayList noeEmdadgarList = ComboPool.getCombo( "noeEmdadgar" );
            ctx.getRequest().setAttribute( "noeEmdadgarList", noeEmdadgarList );
            QueryObject qo = new QueryObject();
            if ( isDatabaseSQL() ) {
                qo.setSelectFields( "id, name+' '+mobile as name, noeEmdadgarId" );
            } else {
                qo.setSelectFields( "id, name || ' ' || mobile as name, noeEmdadgarId" );
            }
            qo.setTables( "emdadgar" );
            qo.setOrderType( "noeEmdadgarId" );
            qo.setFromIndex( 1 );
            qo.setToIndex( 999999 );
            qo.setWhere( "noeEmdadgarId<>'" + Constants.getNoeEmdadgar_InactiveId() + "' AND daftarOstaniId='" + ctx.getUserSession().getDaftarOstani() + "' AND (hadaksarKar=-1 OR karDarDast<hadaksarKar)" ); //
            QueryResult emdadgarQuery = Exchanger.exhangeResultSetToValueObjectArray( ctx.getConnection(), qo, null, new EmdadgarBean(), false );
            ArrayList emdadgarList = emdadgarQuery.getResult();
            for ( Iterator iter = noeEmdadgarList.iterator(); iter.hasNext(); ) {
                ComboObject noeEmdadgar = (ComboObject) iter.next();
                String id = noeEmdadgar.getEid();
                ArrayList emdadgars = new ArrayList();
                for ( int i = 0; i < emdadgarList.size(); i++ ) {
                    EmdadgarBean emdad = (EmdadgarBean) emdadgarList.get( i );
                    if ( emdad.getNoeEmdadgarId().equals( id ) ) {

                        emdadgars.add( emdad );
                    }
                    ctx.getRequest().setAttribute( id, emdadgars );
                }
            }
        } else {
            ctx.getRequest().setAttribute( "emdadgarList", ComboPool.getCombo( "emdadgar" ) );
        }
        //------------------------------------------------------------------------------------------------------//
        if ( Log ) {
            log.info( "-----doSpecificAction  11111" );
        }


        setOrderToXifIsEmpty( ctx, "DESC" );

        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null || id.length() == 0 ) {
            id = ctx.getRequest().getParameter( "emdadId" );
            ctx.getForm().set( "id", id );
        }

        //RokhdadLocal rl = null;
        String rokhdadId = null;

        if ( Log ) {
            log.info( "-----doSpecificAction  22222" );
        }
        String action_type = (String) ctx.getForm().get( ACTION_TYPE );
        if ( action_type.indexOf( "from_error" ) >= 0 ) {
            ctx.getForm().set( "taeedCreate", "true" );
        }
        if ( com.objectj.emdad.ejb.util.Util.isEmpty( action_type ) ||
                action_type.indexOf( "specific" ) >= 0 ||
                action_type.indexOf( "create" ) >= 0 ||
                action_type.indexOf( "edit_by_id" ) >= 0 ||
                action_type.indexOf( "read_by_id" ) >= 0 ||
                action_type.indexOf( "update" ) >= 0 ||
                action_type.indexOf( "from_error" ) >= 0 ) {
            try {
//                log.info("id=" + id + ",rId=" + ctx.getRequest().getParameter("rokhdadId"));
                if ( id != null && id.length() != 0 ) {
                    try {
                        rokhdadId = UserAccessEntity.stringQuery( "Select rokhdadId from emdad where id='" + id + "'", "rokhdadId" );
//                        log.info("00000");
                        //rl = RokhdadUtil.getLocalHome().findByPrimaryKey(rokhdadId);
                        //otherEmdads (ctx, id, rokhdadId);
                    } catch ( Exception e ) {
                    }
                } else if ( ctx.getRequest().getParameter( "rokhdadId" ) != null && ctx.getRequest().getParameter( "rokhdadId" ).length() != 0 ) {
                    rokhdadId = ctx.getRequest().getParameter( "rokhdadId" ); //rl = RokhdadUtil.getLocalHome().findByPrimaryKey(ctx.getRequest().getParameter("rokhdadId"));
//                    log.info("11111");
                    //otherEmdads (ctx, null, ctx.getRequest().getParameter("rokhdadId"));
                }

//                log.info("rokhdadId=" + rokhdadId);
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( rokhdadId ) ) {
                    if ( com.objectj.emdad.ejb.util.Util.isEmpty( action_type ) || action_type.indexOf( "edit" ) != -1 || action_type.indexOf( "create" ) != -1 ) {
                        otherEmdads( ctx, id, rokhdadId );
                    }
                    QueryObject qo = new QueryObject( "view_rokhdadMoshtarak", "", "", false );
                    qo.setWhere( "id='" + rokhdadId + "'" );
                    MoshtarakModel mm = new MoshtarakModel();
                    RokhdadModel rm = new RokhdadModel();
                    Exchanger.exhangeResultSetToValueObject( ctx.getConnection(), qo, new ValueObject[]{mm, rm} );

                    if ( rokhdadId != null ) {
                        if ( Log ) {
                            log.info( "-----doSpecificAction  33333" );
                        }
                        ctx.getRequest().setAttribute( "rokhdadRokhdadId", rm.getRokhdadId() );
                        ctx.getRequest().setAttribute( "rokhdadId", rokhdadId );
                        if ( Log ) {
                            log.info( "-----doSpecificAction  44444" );
                        }
                        ctx.getRequest().setAttribute( "moshtarakId", mm.getEshterakId() );
                        if ( ctx.getForm().get( ACTION_TYPE ) == null || ( (String) ctx.getForm().get( ACTION_TYPE ) ).length() == 0 ) {
                            if ( mm.getNoeService().intValue() == NOESERVICE_ADI ) {
                                ctx.getForm().set( "noeService", "adi" );
                                //                            ctx.getForm().set("modatTamir", new Integer(1));
                            } else {
                                ctx.getForm().set( "noeService", "vijeh" );
                                //                            ctx.getForm().set("modatTamir", new Integer(1));
                            }
                        } else if ( !( ctx.getForm().get( ACTION_TYPE ) ).equals( "update" ) &&
                                ( (String) ctx.getForm().get( ACTION_TYPE ) ).indexOf( "createEmdad4" ) < 0 ) {
                            if ( mm.getNoeService().intValue() == NOESERVICE_ADI ) {
                                ctx.getForm().set( "noeService", "adi" );
                                ctx.getForm().set( "modatTamir", new Integer( 1 ) );
                            } else {
                                ctx.getForm().set( "noeService", "vijeh" );
//                                    if (emdadLocal != null &&  emdahjdLocal.getEmdadModel().getModatTamir() != null){
//                                        ctx.getForm().set("modatTamir", emdadLocal.getEmdadModel().getModatTamir());
//                                    }
//                                    else
//                                        ctx.getForm().set("modatTamir", new Integer(1));
                            }
                        }
                        com.objectj.emdad.web.util.Util.getArrayList( "vazeat" );
                        com.objectj.emdad.web.util.Util.getArrayList( "noeEshterak" );
                        com.objectj.emdad.web.util.Util.getArrayList( "noeService" );
                        com.objectj.emdad.web.util.Util.getArrayList( "yesNo" );


                        int moshtarakYaNa = rm.getMoshtarakYaNa().intValue();
                        moshtarakYaNa = moshtarakYaNa == 2 ? moshtarakYaNa : ( mm.getTarikhEngheza().before( HejriUtil.getCurrentDate() ) ? 2 : moshtarakYaNa );
                        ctx.getRequest().setAttribute( "moshtarak_yaNa", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "yesNo", moshtarakYaNa ) ).getName() );
                        ctx.getRequest().setAttribute( "moshtarak_noeEshterak", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "noeEshterak", mm.getNoeEshterak() ) ).getName() );
                        ctx.getRequest().setAttribute( "moshtarak_noeService", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "noeService", rm.getNoeService() ) ).getName() );
                        ctx.getRequest().setAttribute( "moshtarak_vazeat", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "vazeat", mm.getVazeat() ) ).getName() );
                        int guarantee = rm.getGuarantee().intValue();
                        Date tarikhEnghezaG = mm.getTarikhEnghezaGuarantee();
                        guarantee = guarantee == 2 ? guarantee : ( tarikhEnghezaG.before( HejriUtil.getCurrentDate() ) ? 2 : guarantee );
                        ctx.getForm().set( "guarantee", new Integer( guarantee ) );
                        ctx.getRequest().setAttribute( "moshtarak_guarantee", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "yesNo", guarantee ) ).getName() );
                        if ( Log ) {
                            log.info( "-----doSpecificAction  55555" );
                        }
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }

        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( ctx.getForm().get( "hdnPage" ).toString() ) ) {
            ActionErrors error = new ActionErrors();
            error.add( "emdadId", new ActionError( "emdad.new.emdadId", ctx.getForm().get( "hdnPage" ) ) );
            showMessage( ctx, error );
        }
        if ( Log ) {
            log.info( "-----doSpecificAction  end" );
        }
        log.info( "ACTION IS : " + action_type );
    }

    protected void doPostSpecificAction( BaseActionContext ctx ) throws ProxyException {
        if ( ctx.getAction().equals( "filter" ) ) {
            ctx.getForm().set( "noeEmdad", ctx.getRequest().getAttribute( "noeEmdad" ) );
        }
    }

    protected void saveChangesFromCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        try {

            EmdadModel vo = new EmdadModel();
            Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );

            vo.setZamanEzam( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanEzam" ), (String) ctx.getForm().get( "zamanEzam2" ) ) );
            vo.setZamanVagheiEzam( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ), HejriUtil.getCurrentTime() ) );
//            log.info("aaaa="+vo.getZamanVagheiEzam()+",...="+vo.getZamanEzam());
            String ezamgarId = getUserId( ctx );
//            String tagheerDahandehName = ctx.getUserSession().getName();
            //=-= System.out.println("tagheerDahandehName = " + tagheerDahandehName);
            vo.setAkharinTagheerDahandeh( ctx.getUserSession().getId() );
            vo.setVazeatKonuni( new Integer( 0 ) );
            vo.setZamanShoro( null );
            vo.setZamanVagheiShoro( null );
            vo.setZamanPayan( null );
            vo.setZamanVagheiPayan( null );
            vo.setRahAndazi( "" );

            if ( ctx.getSubAction() != null && ctx.getSubAction().equals( "addNew" ) ) {
                vo.setId( "" );
            }
            vo.setMaliDone( new Integer( MALI_NOT_DONE ) );
            incrementKar( ctx.getConnection(), (String) ctx.getForm().get( "emdadgarId" ), (String) ctx.getForm().get( "namayandegiId" ), ( (Integer) ctx.getForm().get( "noeEmdad" ) ).intValue() );
            vo = (EmdadModel) ( (EmdadProxy) getProxy() ).create( vo, (String) ctx.getForm().get( "rokhdadId" ), (String) ctx.getForm().get( "vazeatKhedmatId" ), (String) ctx.getForm().get( "emdadgarId" ), ezamgarId, (String) ctx.getForm().get( "dalileToolKeshidaneEmdadId" ), (String) ctx.getForm().get( "namayandegiId" ) );
            //setDastorkarGhabli(ctx.getConnection(), (String) ctx.getForm().get("rokhdadId"), new Integer(0));

            //vo = (EmdadModel) getProxy().read(vo.getId());
            ActionErrors error = new ActionErrors();
            error.clear();
            ctx.getRequest().setAttribute( "newEmdadId", vo.getEmdadId() ); // = vo.getEmdadId();
            error.add( "emdadId", new ActionError( "emdad.new.emdadId", vo.getEmdadId() ) );
            showMessage( ctx, error );
            ctx.getRequest().setAttribute( VALUE_OBJECT, vo );
            ctx.getRequest().setAttribute( "hdnPage", vo.getEmdadId() );
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }
    }

    protected ActionForward doCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        log.info( "DO CREATE " );
        if ( !isCancelled( ctx.getRequest() ) ) {
            log.info( "DO CREATE " );
            saveChangesFromCreate( ctx );
        } else {
            return ctx.getActionMapping().findForward( "enseraf" );
        }

        //if (isNew)
        //isNew = false;
        return ctx.getActionMapping().findForward( "refresh" );
    }


    protected ActionForward doReadById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }
        try {
            com.objectj.emdad.proxy.EmdadSessionLocalHome lhProxy = com.objectj.emdad.proxy.EmdadSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.EmdadSessionLocal lProxy = lhProxy.create();
            EmdadList voEmdadList = (EmdadList) lProxy.read( id );


            ctx.getRequest().setAttribute( VALUE_OBJECT, voEmdadList );
            ctx.getRequest().setAttribute( "moshtarakId", ( (EmdadList) voEmdadList ).getMoshtarakId() );

            ctx.getForm().set( "rokhdadId", ( (EmdadList) voEmdadList ).getRokhdadId() );
            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( ( ( (EmdadList) voEmdadList ).getRokhdadId() ) ) ) {
//                RokhdadModel rm = RokhdadUtil.getLocalHome().findByPrimaryKey(((EmdadList) voEmdadList).getRokhdadId()).getRokhdadModel();
                ctx.getForm().set( "rokhdadRokhdadId", voEmdadList.getRokhdadRokhdadId() );
            } else {
                ctx.getForm().set( "rokhdadRokhdadId", new Integer( 0 ) );
            }
            //otherEmdads (ctx, id, rm.getId());

/*            if (((EmdadModel) (voEmdadList)).getZamanVagheiEzam() != null)
                ctx.getRequest().setAttribute("zamanVagheiEzam", HejriUtil.chrisToHejri(((EmdadModel) (voEmdadList)).getZamanVagheiEzam()));
            else
                ctx.getRequest().setAttribute("zamanVagheiEzam", "");

            if (((EmdadModel) (voEmdadList)).getZamanVagheiPayan() != null)
                ctx.getRequest().setAttribute("zamanVagheiPayan", HejriUtil.chrisToHejri(((EmdadModel) (voEmdadList)).getZamanVagheiPayan()));
            else
                ctx.getRequest().setAttribute("zamanVagheiPayan", "");

            if (((EmdadModel) (voEmdadList)).getZamanVagheiShoro() != null)
                ctx.getRequest().setAttribute("zamanVagheiShoro", HejriUtil.chrisToHejri(((EmdadModel) (voEmdadList)).getZamanVagheiShoro()));
            else
                ctx.getRequest().setAttribute("zamanVagheiShoro", "");*/


        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }
        return ctx.getActionMapping().findForward( "read" );
    }

    protected ActionForward doEditById( BaseActionContext ctx ) throws ProxyException, ServletException {
        EmdadList voEmdadList = prepareEdit( ctx );

        String emdadgarId = (String) ctx.getForm().get( "emdadgarId" );
        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( emdadgarId ) ) {
//            log.info("====================================emdadGarId: " + emdadgarId);
            String noeEmdadgarId = UserAccessEntity.stringQuery( "select noeEmdadgarId from emdadgar where id='" + emdadgarId + "'", "noeEmdadgarId", ctx.getConnection() );
            ctx.getForm().set( "noeEmdadgarId", noeEmdadgarId );
//            log.info("====================================noeEmdadGarId: " + noeEmdadgarId);
        }
        ctx.getRequest().setAttribute( "editAction", "true" );

        ctx.getForm().set( "noeEmdad", ctx.getRequest().getAttribute( "noeEmdad" ) );
        ctx.getForm().set( ACTION_TYPE, "update" );
        String id = (String) ctx.getForm().get( ValueObject.ID );
        try {
//            log.info("---------------000000000000");
            //==com.objectj.emdad.proxy.EmdadSessionLocalHome lhProxy = com.objectj.emdad.proxy.EmdadSessionUtil.getLocalHome();
            //==com.objectj.emdad.proxy.EmdadSessionLocal lProxy = lhProxy.create();
//            log.info("-----------1111111111111");
            //==ValueObject voEmdadList = lProxy.read(id);
//            log.info("----------------222222222");
            //EmdadList em = new EmdadList();
            //Exchanger.exhangeResultSetToValueObject("select noeEmdad, moshtarakId from emdadList where id='"+id+"'", new ValueObject[] {em});
            ctx.getForm().set( "noeEmdad", ( (EmdadList) voEmdadList ).getNoeEmdad() );
            ctx.getRequest().setAttribute( "moshtarakId", ( (EmdadList) voEmdadList ).getMoshtarakId() );

        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }

        //otherEmdads (ctx,(String)ctx.getForm().get(ID), (String)ctx.getForm().get("rokhdadId"));
        return ctx.getActionMapping().findForward( "edit" );
    }

    protected EmdadList prepareEdit( BaseActionContext ctx ) throws ProxyException, ServletException {
        boolean isNullEzam = false;
        boolean isNullShoro = false;
        boolean isNullPayan = false;
        boolean isNullVagheiEzam = false;
        boolean isNullVagheiPayan = false;
        boolean isNullVagheiShoro = false;
        ArrayList noeEmdadList = new ArrayList();
        long t1 = ( new java.util.Date() ).getTime();

        noeEmdadList = Util.getArrayList( "noeEmdad" );
        ctx.getRequest().setAttribute( "noeEmdadList", noeEmdadList );

        boolean Log = ctx.getUserSession().getName().equals( "abc" );


        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            id = ctx.getRequest().getParameter( "id" );
        }

        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }

//        log.info("time0="+System.currentTimeMillis());
        EmdadList vo = (EmdadList) getProxy().read( id );
//        log.info("time1="+System.currentTimeMillis());
        //EmdadList vo = (EmdadList)EmdadSessionUtil.getLocalHome().create().read((String) ctx.getForm().get(ID));
        ctx.getForm().set( "modatTamir", vo.getModatTamir() );
        ctx.getRequest().setAttribute( "noeEmdadName", ( (EmdadList) vo ).getNoeEmdadName() );

        if ( vo.getZamanEzam() == null ) {
            vo.setZamanEzam( new Timestamp( 0 ) );
            isNullEzam = true;
        }

        if ( vo.getZamanShoro() == null ) {
            vo.setZamanShoro( new Timestamp( 0 ) );
            isNullShoro = true;
        }

        if ( vo.getZamanPayan() == null ) {
            vo.setZamanPayan( new Timestamp( 0 ) );
            isNullPayan = true;
        }

        if ( vo.getZamanVagheiEzam() == null ) {
            vo.setZamanVagheiEzam( new Timestamp( 0 ) );
            isNullVagheiEzam = true;
        }

        if ( vo.getZamanVagheiPayan() == null ) {
            vo.setZamanVagheiPayan( new Timestamp( 0 ) );
            isNullVagheiPayan = true;
        }

        if ( vo.getZamanVagheiShoro() == null ) {
            vo.setZamanVagheiShoro( new Timestamp( 0 ) );
            isNullVagheiShoro = true;
        }

        Exchanger.exhangeValueObjectToForm( vo, ctx.getForm() );

        ctx.getRequest().setAttribute( "emdadId", ctx.getForm().get( "emdadId" ) );
        //ctx.getForm().set("ameliyatMojaz", ctx.getForm().get("emdadgarId"));

        if ( !isNullShoro ) {
            ctx.getForm().set( "zamanShoro", HejriUtil.chrisToHejri( vo.getZamanShoro() ) );
            ctx.getForm().set( "zamanShoro2", HejriUtil.getTimeFromDate( vo.getZamanShoro() ) );
        } else {
            ctx.getForm().set( "zamanShoro", "" );
            ctx.getForm().set( "zamanShoro2", "" );
        }

        if ( !isNullEzam ) {
            ctx.getForm().set( "zamanEzam", HejriUtil.chrisToHejri( vo.getZamanEzam() ) );
            ctx.getForm().set( "zamanEzam2", HejriUtil.getTimeFromDate( vo.getZamanEzam() ) );
        } else {
            ctx.getForm().set( "zamanEzam", "" );
            ctx.getForm().set( "zamanEzam2", "" );
        }

        if ( !isNullPayan ) {
            ctx.getForm().set( "zamanPayan", HejriUtil.chrisToHejri( vo.getZamanPayan() ) );
            ctx.getForm().set( "zamanPayan2", HejriUtil.getTimeFromDate( vo.getZamanPayan() ) );
        } else {
            ctx.getForm().set( "zamanPayan", "" );
            ctx.getForm().set( "zamanPayan2", "" );
        }

        if ( !isNullVagheiEzam ) {
            ctx.getForm().set( "zamanVagheiEzam", HejriUtil.chrisToHejri( vo.getZamanVagheiEzam() ) );
            ctx.getForm().set( "zamanVagheiEzam2", HejriUtil.getTimeFromDate( vo.getZamanVagheiEzam() ) );
        } else {
            ctx.getForm().set( "zamanVagheiEzam", "" );
            ctx.getForm().set( "zamanVagheiEzam2", "" );
        }

        if ( !isNullVagheiPayan ) {
            ctx.getForm().set( "zamanVagheiPayan", HejriUtil.chrisToHejri( vo.getZamanVagheiPayan() ) );
            ctx.getForm().set( "zamanVagheiPayan2", HejriUtil.getTimeFromDate( vo.getZamanVagheiPayan() ) );
        } else {
            ctx.getForm().set( "zamanVagheiPayan", "" );
            ctx.getForm().set( "zamanVagheiPayan2", "" );
        }

        if ( !isNullVagheiShoro ) {
            ctx.getForm().set( "zamanVagheiShoro", HejriUtil.chrisToHejri( vo.getZamanVagheiShoro() ) );
            ctx.getForm().set( "zamanVagheiShoro2", HejriUtil.getTimeFromDate( vo.getZamanVagheiShoro() ) );
        } else {
            ctx.getForm().set( "zamanVagheiShoro", "" );
            ctx.getForm().set( "zamanVagheiShoro2", "" );
        }

        try {
            if ( Log ) {
                log.info( "000000000000" );
            }
//            EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey(vo.getId());
//            if (Log)
//                log.info("111111111111");
//            RokhdadLocal ro = emdadLocal.getRokhdad();
//            if (Log)
//                log.info("~~~~~~~~~~`111111111111");
//            MoshtarakLocal ml = ro.getMoshtarak();
//            if (Log)
//                log.info("!!!!!!!!!    111111111111");
//            MoshtarakModel moshtarakModel = ml.getMoshtarakModel();
            String eid = UserAccessEntity.stringQuery( "select eshterakId from emdadlist where id='" + vo.getId() + "'", "eshterakId", ctx.getConnection() );
            ctx.getRequest().setAttribute( "moshtarakId", eid );
            if ( Log ) {
                log.info( "2222222222222222" );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        String namayandegiName = ( (EmdadList) vo ).getNamayandegiName();
        if ( namayandegiName != null ) {
//            log.info("========== namayandegiName = " + namayandegiName);
            ctx.getRequest().setAttribute( "namayandegiName", namayandegiName );
        } else {
            ctx.getRequest().setAttribute( "namayandegiName", " " );
        }

        String emdadgarName = ( (EmdadList) vo ).getEmdadgar();
        if ( emdadgarName != null ) {
//            log.info("========== emdadgarName = " + emdadgarName);
            ctx.getRequest().setAttribute( "emdadgarName", emdadgarName );
        } else {
            ctx.getRequest().setAttribute( "emdadgarName", " " );
        }

        ctx.getForm().set( "emdadgarIdGhabli", ctx.getForm().get( "emdadgarId" ) );
        ctx.getForm().set( "namayandegiIdGhabli", ctx.getForm().get( "namayandegiId" ) );

        ctx.getRequest().setAttribute( FORM, ctx.getForm() );
        if ( Log ) {
            log.info( "-- prepareEdit time=" + ( ( new java.util.Date() ).getTime() - t1 ) );
        }

        return vo;
    }

    protected ActionForward doUpdate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            saveChangesFromEdit( ctx );
//            if (isNew){
//                ctx.getForm().set("zamanEzam", HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
//                ctx.getForm().set("zamanEzam2", HejriUtil.getCurrentTime());
//                ctx.getForm().set("noeEmdad", noeEmdad);
//                ctx.getForm().set(ACTION_TYPE, "create");
//                return ctx.getActionMapping().findForward("edit");
//            }
            if ( ctx.getForm().get( ACTION_TYPE ) != null && ( (String) ctx.getForm().get( ACTION_TYPE ) ).length() != 0 && ( (String) ctx.getForm().get( ACTION_TYPE ) ).indexOf( "filter" ) < 0 ) {
                ctx.getForm().set( "vazeatKhedmatId", "" );
                ctx.getForm().set( "emdadgarId", "" );
                ctx.getForm().set( "ezamgarId", "" );
            }

            ctx.getUserSession().clearAllFilters( ctx.getEntity() );

            Integer noeEmdad = (Integer) ctx.getRequest().getAttribute( "noeEmdad" );
            if ( noeEmdad == null || noeEmdad.intValue() == 0 ) {
                ctx.setForceForwardTo( "list" );
                ctx.setForceFilter( "emdad.vazeatKonuni <> 'I2' AND emdad.noeEmdad <> 'I4' " );
            } else {
                ctx.setForceForwardTo( "list" + noeEmdad );
                ctx.setForceFilter( "emdad.vazeatKonuni <> 'I2' AND emdad.noeEmdad = 'I" + noeEmdad + "' " );
            }
            ctx.getUserSession().setSpecific( ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity() );
            if ( ctx.getForm().get( "noeEmdad" ) != null ) {
                ctx.getRequest().setAttribute( "noeEmdad", ctx.getForm().get( "noeEmdad" ) );
            }
            return ctx.getActionMapping().findForward( "refresh" );
        } else {
            return ctx.getActionMapping().findForward( "enseraf" );
        }
    }


    protected void saveChangesFromEdit( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        try {
            //=-= System.out.println("update");
            if ( !isCancelled( ctx.getRequest() ) ) {
                EmdadModel vo = new EmdadModel();
//                    EmdadList vo = (EmdadList)EmdadSessionUtil.getLocalHome().create().read((String) ctx.getForm().get(ID));

                int noeEmdad = ( (Integer) ctx.getForm().get( "noeEmdad" ) ).intValue();
//                    log.info("========== noeEmdad = " + noeEmdad);

                String oldEmdadgarId = (String) ctx.getForm().get( "emdadgarIdGhabli" );
//                    log.info("========== oldEmdadgarId = " + oldEmdadgarId);
                String newEmdadgarId = (String) ctx.getForm().get( "emdadgarId" );
//                    log.info("========== newEmdadgarId = " + newEmdadgarId);

                String oldNamayandegiId = (String) ctx.getForm().get( "namayandegiIdGhabli" );
//                    log.info("========== oldNamayandegiId = " + oldNamayandegiId);
                String newNamayandegiId = (String) ctx.getForm().get( "namayandegiId" );
//                    log.info("========== newNamayandegiId = " + newNamayandegiId);

//                    if (noeEmdad == NOE_EMDAD_BALINI) {
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( newEmdadgarId ) ) {
                    if ( !newEmdadgarId.equals( oldEmdadgarId ) ) {
                        decrementKar( ctx.getConnection(), oldEmdadgarId, oldNamayandegiId, noeEmdad );
                        incrementKar( ctx.getConnection(), newEmdadgarId, null, noeEmdad );
                    }
                } else if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( newNamayandegiId ) ) {
                    if ( !newNamayandegiId.equals( oldNamayandegiId ) ) {
                        decrementKar( ctx.getConnection(), oldEmdadgarId, oldNamayandegiId, noeEmdad );
                        incrementKar( ctx.getConnection(), null, newNamayandegiId, noeEmdad );
                    }
                }
//                    } else {
//                        if (!oldNamayandegiId.equals(newNamayandegiId )) {
//                            decrementKar(null, oldNamayandegiId);
//                            incrementKar(null, newNamayandegiId);
//                        }
//                    }

//                    log.info("ctx.getForm()="+ctx.getForm());
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );

                vo.setAkharinTagheerDahandeh( ctx.getUserSession().getId() );
                //=-= System.out.println("ctx.getUserSession().getName() = " + ctx.getUserSession().getName());
                if ( (String) ( ctx.getForm().get( "zamanEzam" ) ) != null && ( (String) ( ctx.getForm().get( "zamanEzam" ) ) ).length() != 0 ) {
                    vo.setZamanEzam( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanEzam" ), (String) ctx.getForm().get( "zamanEzam2" ) ) );
                }


                if ( (String) ( ctx.getForm().get( "zamanShoro" ) ) != null && ( (String) ( ctx.getForm().get( "zamanShoro" ) ) ).length() != 0 ) {
                    vo.setZamanShoro( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanShoro" ), (String) ctx.getForm().get( "zamanShoro2" ) ) );
                }

                if ( (String) ( ctx.getForm().get( "zamanVagheiEzam" ) ) != null && ( (String) ( ctx.getForm().get( "zamanVagheiEzam" ) ) ).length() != 0 ) {
                    vo.setZamanVagheiEzam( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanVagheiEzam" ), (String) ctx.getForm().get( "zamanVagheiEzam2" ) ) );
                }

                if ( (String) ( ctx.getForm().get( "zamanVagheiPayan" ) ) != null && ( (String) ( ctx.getForm().get( "zamanVagheiPayan" ) ) ).length() != 0 ) {
                    vo.setZamanVagheiPayan( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanVagheiPayan" ), (String) ctx.getForm().get( "zamanVagheiPayan2" ) ) );
                }

                if ( (String) ( ctx.getForm().get( "zamanVagheiShoro" ) ) != null && ( (String) ( ctx.getForm().get( "zamanVagheiShoro" ) ) ).length() != 0 ) {
                    vo.setZamanVagheiShoro( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanVagheiShoro" ), (String) ctx.getForm().get( "zamanVagheiShoro2" ) ) );
                }

                if ( (String) ( ctx.getForm().get( "zamanPayan" ) ) != null && ( (String) ( ctx.getForm().get( "zamanPayan" ) ) ).length() != 0 ) {
                    vo.setZamanPayan( HejriUtil.convertToTimesatmp( (String) ctx.getForm().get( "zamanPayan" ), (String) ctx.getForm().get( "zamanPayan2" ) ) );
                }

                ( (EmdadProxy) getProxy() ).update( vo, (String) ctx.getForm().get( "rokhdadId" ), (String) ctx.getForm().get( "vazeatKhedmatId" ), (String) ctx.getForm().get( "emdadgarId" ), (String) ctx.getForm().get( "ezamgarId" ), (String) ctx.getForm().get( "dalileToolKeshidaneEmdadId" ), (String) ctx.getForm().get( "namayandegiId" ) );
            }
        } catch ( ProxyException e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        } catch ( Exception e ) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }


    protected ActionForward doCreateFromError( BaseActionContext ctx ) {
        ctx.getForm().set( ID, null );
        ctx.getForm().set( ACTION_TYPE, "create" );
        ctx.getForm().set( "zamanEzam", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanEzam2", HejriUtil.getCurrentTime() );
        ctx.getForm().set( "noeEmdad", ctx.getRequest().getAttribute( "noeEmdad" ) );
        ctx.getForm().set( "vazeatKonuni", new Integer( 0 ) );
        //ctx.getForm().set("ameliyatMojaz",null);
        ctx.getForm().set( "namayandegiId", null );
        ctx.getForm().set( "emdadgarId", null );
        //otherEmdads (ctx, null, (String)ctx.getForm().get("rokhdadId"));


        try {

//            RokhdadLocal rl = RokhdadUtil.getLocalHome().findByPrimaryKey((String) ctx.getForm().get("rokhdadId"));
            QueryObject qo = new QueryObject( "view_rokhdadMoshtarak", "", "", false );
            qo.setWhere( "id='" + ctx.getForm().get( "rokhdadId" ) + "'" );
            MoshtarakModel mm = new MoshtarakModel();
            RokhdadModel rm = new RokhdadModel();
            Exchanger.exhangeResultSetToValueObject( ctx.getConnection(), qo, new ValueObject[]{mm, rm} );

//            if (rl != null) {
            ctx.getRequest().setAttribute( "rokhdadRokhdadId", rm.getRokhdadId() );
//                MoshtarakLocal mLocal = rl.getMoshtarak();
//                MoshtarakModel mModel = mLocal.getMoshtarakModel();

            ctx.getRequest().setAttribute( "moshtarakId", mm.getEshterakId() );
            ctx.getRequest().setAttribute( "moshtarak_noeEshterak", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "noeEshterak", mm.getNoeEshterak() ) ).getName() );
            ctx.getRequest().setAttribute( "moshtarak_noeService", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "noeService", mm.getNoeService() ) ).getName() );
            ctx.getRequest().setAttribute( "moshtarak_vazeat", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "vazeat", mm.getVazeat() ) ).getName() );
            ctx.getRequest().setAttribute( "moshtarak_guarantee", ( (ComboObject) com.objectj.emdad.ejb.util.Util.getFromArrayList( "yesNo", mm.getGuarantee() ) ).getName() );
//                NoeKhodroModel nModel = mLocal.getNoeKhodro().getNoeKhodroModel();
//                ctx.getRequest().setAttribute("moshtarak_noeKhodro", nModel.getOnvan());
//                ctx.getRequest().setAttribute("moshtarak_guaranteeDistance", nModel.getGuaranteeDistance());
//            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return ctx.getActionMapping().findForward( "edit" );
    }


    protected String getForceFilter( BaseActionContext ctx ) {
        String filter = super.getForceFilter( ctx );
        if ( !getAccess( ctx ).getAllAccess() ) {
            if ( filter != null ) {
                filter += " AND ";
            } else {
                filter = "";
            }
            filter += " rokhdad.daftarOstaniId = 'S" + getDaftarOstani( ctx ) + "'";
        }
        return filter;
    }

    protected String getForceForwardTo( BaseActionContext ctx ) {
        return ctx.getForceForwardTo();
    }

    protected void doFilterPreProcessor( BaseActionContext ctx ) {
        if ( ctx.getForm().get( "rokhdadRokhdadId" ) != null && ( (Integer) ctx.getForm().get( "rokhdadRokhdadId" ) ).intValue() != 0 ) {
            ctx.getForm().set( "rokhdad.rokhdadId", ctx.getForm().get( "rokhdadRokhdadId" ) );
            //=-= System.out.println("FORM.get = " + ctx.getForm().get("rokhdadRokhdadId"));
        } else {
            ctx.getForm().set( "rokhdad.rokhdadId", null );
        }

        ctx.getForm().set( "rokhdadRokhdadId", null );
        ctx.getForm().set( "noeEmdad", null );

        ctx.getForm().set( "emdadList.address", ctx.getForm().get( "address" ) );
        ctx.getForm().set( "address", "" );

        ctx.getForm().set( "emdadList.shomarePelak", ctx.getForm().get( "shomarePelak" ) );
        ctx.getForm().set( "shomarePelak", "" );

        ctx.getForm().set( "emdadList.nameEmdadgar", ctx.getForm().get( "nameEmdadgar" ) );
        ctx.getForm().set( "nameEmdadgar", "" );

        ctx.getForm().set( "emdadList.namayandegiId", ctx.getForm().get( "namayandegiId" ) );
        ctx.getForm().set( "namayandegiId", "" );

        /*Integer nId = (Integer)ctx.getForm().get("namayandegiId");
        if ( nId != null && nId.intValue()!=0 ){
            ctx.getForm().set("emdadList.namayandegiId", ctx.getForm().get("namayandegiId"));
            ctx.getForm().set("namayandegiId", "");
        }*/

        ctx.getForm().set( "emdadList.ezamgarId", ctx.getForm().get( "ezamgarId" ) );
        ctx.getForm().set( "ezamgarId", "" );

        ctx.getForm().set( "emdadList.irad", ctx.getForm().get( "irad" ) );
        ctx.getForm().set( "irad", "" );

        ctx.getForm().set( "emdadList.zamanEzam", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanEzamHejri" ) ) );
//        ctx.getForm().set("zamanEzam", "");
        ctx.getForm().set( "id", "" );
    }

    protected void changeDateToChris( BaseActionContext ctx ) {
        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanShoro" ) ) ) ) {
            ctx.getForm().set( "zamanShoro", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanShoro" ) ) );
        }

        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanEzam" ) ) ) ) {
            ctx.getForm().set( "zamanEzam", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanEzam" ) ) );
        }

        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanPayan" ) ) ) ) {
            ctx.getForm().set( "zamanPayan", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanPayan" ) ) );
        }

        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanVagheiShoro" ) ) ) ) {
            ctx.getForm().set( "zamanVagheiShoro", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanVagheiShoro" ) ) );
        }

        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanVagheiEzam" ) ) ) ) {
            ctx.getForm().set( "zamanVagheiEzam", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanVagheiEzam" ) ) );
        }

        if ( HejriUtil.isValidDate( (String) ( ctx.getForm().get( "zamanVagheiPayan" ) ) ) ) {
            ctx.getForm().set( "zamanVagheiPayan", HejriUtil.hejriToChrisStr( (String) ctx.getForm().get( "zamanVagheiPayan" ) ) );
        }
    }

/*    protected ActionForward doSpecificFromError(BaseActionContext ctx) {
         String subAction = (String)ctx.getForm().get("subAction");
        //=-= System.out.println("11111111111111111111111subAction = " + subAction);
        ctx.getForm().set(ACTION_TYPE, "specific,taeedShoro");//+ subAction);
        return ctx.getActionMapping().findForward("shoro");
    }
  */

    protected ActionForward tasvieHesabEmdadgar( BaseActionContext ctx ) {
//        ctx.getUserSession().clearAllFilters(ctx.getEntity());
        ctx.getRequest().setAttribute( "noeTasvieh", "emdadgar" );
        com.objectj.emdad.web.util.Util.getArrayList( "noeEmdadName" );
        ctx.getRequest().setAttribute( "noeEmdadList", Util.getArrayList( "noeEmdadName" ) );
        // vazeatKonuni=2  === Khateme yafteh
        //ctx.setForceFilter(" emdad.noeEmdad = 'I" + NOE_EMDAD_BALINI +"' AND emdad.vazeatKonuni = 'I2' ");
        ctx.setForceFilter( " /* emdadList.emdadgarId is not null */ AND emdad.vazeatKonuni = 'I2'  AND emdad.maliDone <> 'I" + MALI_DONE + "'" );

        try {

            //---------------------------  emdadgar  -------------------------------
            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
//                log.info("~~~~~~~~~~~~~~ emdadgar");
                String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.emdadgarId = 'S" + emdadgarId + "'" );
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  hesabdarAmaliat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_MALIOP ) ) {
//                log.info("~~~~~~~~~~~~~~ hesabdarAmaliat");
                if ( !getAccess( ctx ).getAllAccess() ) {
                    String daftarOstaniId = ctx.getUserSession().getDaftarOstani();
                    ctx.setForceFilter( ctx.getForceFilter() + " AND rokhdad.daftarOstaniId = 'S" + daftarOstaniId + "'" );
                }
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  guarantee  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_GUARANTEE ) ) {
//                log.info("~~~~~~~~~~~~~~ guarantee");
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedHesabdar = 1 AND guarantee = 1 AND taeedNamayandegi <> 1)) */");
            }

            //---------------------------  namayande modiriat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEMODIRIAT ) ) {
//                log.info("~~~~~~~~~~~~~~ namayandegi");
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedHesabdar = 1 AND taeedGuarantee = 1 AND taeedNamayandegi <> 1)) */");
            }
            //ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.maliDone <> 'I" + MALI_DONE + "'");
        } catch ( Exception e ) {

        }
        ctx.getUserSession().setSpecific( ctx.getForceFilter(), "tasvieHesabEmdadgarList", ctx.getEntity() );
        return listAll( ctx );
    }

    protected ActionForward tasvieHesabJarsaghil( BaseActionContext ctx ) {
//        ctx.getUserSession().clearAllFilters(ctx.getEntity());
        ctx.getRequest().setAttribute( "noeTasvieh", "jarsaghil" );
        com.objectj.emdad.web.util.Util.getArrayList( "noeEmdadName" );
        ctx.getRequest().setAttribute( "noeEmdadList", Util.getArrayList( "noeEmdadName" ) );
        //=-= System.out.println("Constants.getNoeEmdadgar_Jarsaghil() = " + Constants.getNoeEmdadgar_Jarsaghil());
        ctx.setForceFilter( " emdadgar.noeEmdadgarId = 'S" + Constants.getNoeEmdadgar_Jarsaghil() + "'  AND emdad.vazeatKonuni = 'I2'  AND emdad.maliDone <> 'I" + MALI_DONE + "'" );

        try {
            //---------------------------  emdadgar  -------------------------------
            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
                String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.emdadgarId = 'S" + emdadgarId + "'" );
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  hesabdarAmaliat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_MALIOP ) ) {
                if ( !getAccess( ctx ).getAllAccess() ) {
                    String daftarOstaniId = ctx.getUserSession().getDaftarOstani();
                    ctx.setForceFilter( ctx.getForceFilter() + " AND rokhdad.daftarOstaniId = 'S" + daftarOstaniId + "'" );
                }
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  namayande modiriat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEMODIRIAT ) ) {
//                log.info("~~~~~~~~~~~~~~ namayandegi");
                //ctx.setForceFilter( ctx.getForceFilter() + "/* (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedHesabdar = 1 AND taeedGuarantee = 1 AND taeedNamayandegi <> 1)) */");
            }

            //ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.maliDone <> 'I" + MALI_DONE + "'");

        } catch ( Exception e ) {
        }
        ctx.getUserSession().setSpecific( ctx.getForceFilter(), "tasvieHesabJarsaghilList", ctx.getEntity() );
        return listAll( ctx );

    }


    protected ActionForward tasvieHesabNamayandegi( BaseActionContext ctx ) {
//        ctx.getUserSession().clearAllFilters(ctx.getEntity());
        ctx.getRequest().setAttribute( "noeTasvieh", "namayandegi" );
        com.objectj.emdad.web.util.Util.getArrayList( "noeEmdadName" );
        ctx.getRequest().setAttribute( "noeEmdadList", Util.getArrayList( "noeEmdadName" ) );
//        ctx.setForceFilter(" /* emdadList.namayandegiIdO"+ isNotNull +" */ AND emdad.vazeatKonuni = 'I2'  AND emdad.maliDone <> 'I" + MALI_DONE + "'");
        ctx.setForceFilter( " /* emdadList.namayandegiIdO is not null */ AND emdad.vazeatKonuni = 'I2'  AND emdad.maliDone <> 'I" + MALI_DONE + "'" );

        try {

            //---------------------------  namayandegi  -------------------------------
            if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEGI ) ) {
//                log.info("~~~~~~~~~~~~~~ namayandegi");
                String namayandegiId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.namayandegiIdO = 'S" + namayandegiId + "'" );
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  hesabdarAmaliat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_MALIOP ) ) {
//                log.info("~~~~~~~~~~~~~~ hesabdarAmaliat");
                if ( !getAccess( ctx ).getAllAccess() ) {
                    String daftarOstaniId = ctx.getUserSession().getDaftarOstani();
                    ctx.setForceFilter( ctx.getForceFilter() + " AND rokhdad.daftarOstaniId = 'S" + daftarOstaniId + "'" );
                }
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND ((NOT EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id)) OR (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedNamayandegi <> 1))) */");
            }

            //---------------------------  namayande modiriat  -------------------------------
            else if ( ctx.isUserInRole( Constants.ROLE_NAMAYANDEMODIRIAT ) ) {
//                log.info("~~~~~~~~~~~~~~ namayandeh");
                //ctx.setForceFilter( ctx.getForceFilter() + "/* AND (EXISTS (SELECT * FROM jozeatKhedmat WHERE khedmatId = emdad.id AND taeedHesabdar = 1 AND taeedGuarantee = 1 AND taeedNamayandegi <> 1)) */");
            }
            //ctx.setForceFilter( ctx.getForceFilter() + " AND emdad.maliDone <> 'I" + MALI_DONE + "'");
        } catch ( Exception e ) {

        }
        ctx.getUserSession().setSpecific( ctx.getForceFilter(), "tasvieHesabNamayandegiList", ctx.getEntity() );
        return listAll( ctx );
    }

    boolean incrementKar( Connection c, String emdadgarId, String namayandegiId, int noeService ) throws NamingException, CreateException, ProxyException {
//        log.info("------------------  incrementKar ");
        return changeKar( c, emdadgarId, namayandegiId, noeService, +1 );
    }

    boolean decrementKar( Connection c, String emdadgarId, String namayandegiId, int noeService ) throws NamingException, CreateException, ProxyException {
//        log.info("------------------  decrementKar");
        return changeKar( c, emdadgarId, namayandegiId, noeService, -1 );
    }

    boolean changeKar( Connection c, String emdadgarId, String namayandegiId, int val, int noeService ) throws NamingException, CreateException, ProxyException {
//        log.info("------------------  decrementKar");
        if ( true ) {
            return true;
        }
        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( emdadgarId ) ) {//todo
//            log.info("==========  kar dar dast emdadgar");
            EmdadgarModel voEmdadgar = new EmdadgarModel();
            QueryObject qo = new QueryObject( "emdadgar", "", "", false );
            qo.setWhere( "id='" + emdadgarId + "'" );
            Exchanger.exhangeResultSetToValueObject( c, qo, new ValueObject[]{voEmdadgar} ); //RokhdadSessionUtil.getLocalHome().create().read(rokhdadId);
            //EmdadgarList voEmdadgar = (EmdadgarList)EmdadgarSessionUtil.getLocalHome().create().read(emdadgarId);
            int kd = voEmdadgar.getKarDarDast() != null ? voEmdadgar.getKarDarDast().intValue() : 0;
            if ( voEmdadgar.getHadaksarKar().intValue() != -1 ) {
                if ( ( kd + val >= 0 ) &&
                        ( kd + val <= voEmdadgar.getHadaksarKar().intValue() ) ) {
                    voEmdadgar.setKarDarDast( new Integer( kd + val ) );
                    EmdadgarSessionUtil.getLocalHome().create().update( voEmdadgar ); //, voEmdadgar.getNoeEmdadgarId(), voEmdadgar.getDaftarOstaniId(), voEmdadgar.getNamayandegiId());
                } else {
                    return false;
                }
            }
        } else {
//            log.info("==========  kar dar dast namayandegi");
            if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( namayandegiId ) ) {//todo
                NamayandegiModel voNamayandegi = new NamayandegiModel();
                QueryObject qo = new QueryObject( "namayandegi", "", "", false );
                qo.setWhere( "id='" + namayandegiId + "'" );
                Exchanger.exhangeResultSetToValueObject( c, qo, new ValueObject[]{voNamayandegi} ); //RokhdadSessionUtil.getLocalHome().create().read(rokhdadId);
                //NamayandegiList voNamayandegi = (NamayandegiList)NamayandegiSessionUtil.getLocalHome().create().read(namayandegiId);
                int kd = voNamayandegi.getKarDarDast() != null ? voNamayandegi.getKarDarDast().intValue() : 0;
                int kd2 = voNamayandegi.getKarDarDast() != null ? voNamayandegi.getKarDarDast2().intValue() : 0;
                if ( noeService == NOE_EMDAD_BALINI ) {
                    if ( voNamayandegi.getHadaksarKar().intValue() != -1 ) {
                        if ( ( kd + val >= 0 ) &&
                                ( kd + val <= voNamayandegi.getHadaksarKar().intValue() ) ) {
                            voNamayandegi.setKarDarDast( new Integer( kd + val ) );
                            NamayandegiSessionUtil.getLocalHome().create().update( voNamayandegi ); //, voNamayandegi.getShahrId(), voNamayandegi.getNoeKhodroId(), voNamayandegi.getDaftarOstaniId());
                        } else {
                            return false;
                        }
                    }
                } else if ( noeService == NOE_EMDAD_TAMIR ) {
                    if ( voNamayandegi.getHadaksarKar2().intValue() != -1 ) {
                        if ( ( kd2 + val >= 0 ) &&
                                ( kd2 + val <= voNamayandegi.getHadaksarKar().intValue() ) ) {
                            voNamayandegi.setKarDarDast2( new Integer( kd2 + val ) );
                            NamayandegiSessionUtil.getLocalHome().create().update( voNamayandegi ); //, voNamayandegi.getShahrId(), voNamayandegi.getNoeKhodroId(), voNamayandegi.getDaftarOstaniId());
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean setDastorkarGhabli( Connection c, String rokhdadId, Integer dastorkarGhabli ) throws Exception {
//        log.info("========== rokhdadId = " + rokhdadId+", dastorkarGhabli = " + dastorkarGhabli);
        if ( true ) {
            if ( !isDatabaseSQL() ) {
                CallableStatement cstmt = c.prepareCall( "{CALL UpdateDastoorKarGhabliRokhdad( ?,?)}" );
                cstmt.setString( 1, rokhdadId );
                cstmt.setInt( 2, dastorkarGhabli.intValue() );
                cstmt.executeUpdate();
                cstmt.close();
            } else {
                Util.updateQuery( "execute dbo.UpdateDastoorKarGhabliRokhdad '" + rokhdadId + "' , " + dastorkarGhabli, c );
            }
            return true;
        }

        if ( rokhdadId != null && rokhdadId.length() != 0 ) {//todo
            Util.updateQuery( "execute dbo.UpdateDastoorKarGhabliRokhdad '" + rokhdadId + "' , " + dastorkarGhabli, c );
            RokhdadModel voRokhdad = new RokhdadModel();
            QueryObject qo = new QueryObject( "rokhdad", "", "", false );
            qo.setWhere( "id='" + rokhdadId + "'" );
            Exchanger.exhangeResultSetToValueObject( c, qo, new ValueObject[]{voRokhdad} ); //RokhdadSessionUtil.getLocalHome().create().read(rokhdadId);
            voRokhdad.setDastorkarGhabli( dastorkarGhabli );
//            log.info("========== voRokhdad.getDastorkarGhabli() = " + voRokhdad.getDastorkarGhabli());
            RokhdadSessionUtil.getLocalHome().create().update( voRokhdad ); //, voRokhdad.getMoshtarakId(), voRokhdad.getNamayandegiId(), voRokhdad.getDaftarOstaniId(), voRokhdad.getShahrId());
        } else {
            log.info( "==========  invalid rokhdadId " );
        }
        return true;
    }

    void prepareShoro( BaseActionContext ctx, EmdadLocal emdadLocal ) throws NamingException, FinderException, ServletException, ProxyException {
        prepareEdit( ctx );
        ctx.getForm().set( ACTION_TYPE, "specific,taeedShoro" );
        ctx.getForm().set( "zamanVagheiShoro", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanVagheiShoro2", HejriUtil.getCurrentTime() );
        ctx.getForm().set( "zamanShoro", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanShoro2", HejriUtil.getCurrentTime() );
        //RokhdadLocal rl = RokhdadUtil.getLocalHome().findByPrimaryKey(emdadLocal.getRokhdad().getId());
        //ctx.getRequest().setAttribute("rokhdadRokhdadId", rl.getRokhdadModel().getRokhdadId());
    }

    void preparePayan( BaseActionContext ctx, EmdadLocal emdadLocal ) throws NamingException, FinderException, ServletException, ProxyException {
        prepareEdit( ctx );
        ctx.getForm().set( ACTION_TYPE, "specific,taeedPayan" );
        ctx.getForm().set( "zamanVagheiPayan", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanVagheiPayan2", HejriUtil.getCurrentTime() );
        ctx.getForm().set( "zamanPayan", HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) );
        ctx.getForm().set( "zamanPayan2", HejriUtil.getCurrentTime() );
//        RokhdadLocal rl = RokhdadUtil.getLocalHome().findByPrimaryKey(emdadLocal.getRokhdad().getId());
//        ctx.getRequest().setAttribute("rokhdadRokhdadId", rl.getRokhdadModel().getRokhdadId());
    }

    protected ActionForward doSpecific( BaseActionContext ctx ) throws Exception {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null && ctx.getRequest().getParameter( "id" ) != null && ctx.getRequest().getParameter( "id" ).length() != 0 ) {
            id = ctx.getRequest().getParameter( "id" );
        }
        if ( id == null || id.length() == 0 ) {
            id = ctx.getRequest().getParameter( "emdadId" );
            ctx.getForm().set( "id", id );
        }
        EmdadLocal emdadLocal = null;
        if ( id != null && id.length() > 0 && id.endsWith( "o" ) ) {
            emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey( id );
        }

        Integer noeEmdad = (Integer) ctx.getRequest().getAttribute( "noeEmdad" );
        ctx.getRequest().setAttribute( "forceNoeEmdad", noeEmdad );
        System.out.println( "NOE TASVIE: " + ctx.getRequest().getParameter( "noeTasvieh" ) );
        if ( ctx.getRequest().getParameter( "noeTasvieh" ) != null ) {
            ctx.getRequest().setAttribute( "noeTasvieh", ctx.getRequest().getParameter( "noeTasvieh" ) );
        }
        // Export emdad XLS for emdadgar pocketPcs:
        if ( ctx.getSubAction().equals( "ipaqXlsExport" ) ) {
            return exportIpaqXls( ctx );
        }
        if ( ctx.getSubAction().equals( "ipaqXlsImport" ) ) {
            return importIpaqXls( ctx );
        }
        if ( ctx.getSubAction().equals( "khatemehNayafteh" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.setForceFilter( "emdad.vazeatKonuni <> 'I2' AND emdad.noeEmdad = 'I" + noeEmdad + "' " );
            ctx.getUserSession().setSpecific( ctx.getForceFilter(), "", ctx.getEntity() );

        } else if ( ctx.getSubAction().equals( "khatemehYafteh" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.setForceFilter( "emdad.vazeatKonuni = 'I2' AND emdad.noeEmdad = 'I" + noeEmdad + "' " );
            ctx.getUserSession().setSpecific( ctx.getForceFilter(), "", ctx.getEntity() );

        } else if ( ctx.getSubAction().equals( "shoro" ) ) {
            if ( !isCancelled( ctx.getRequest() ) ) {
                prepareShoro( ctx, emdadLocal );
                return ctx.getActionMapping().findForward( "shoro" );
            } else {
                return ctx.getActionMapping().findForward( "enseraf" );
            }
        } else if ( ctx.getSubAction().equals( "taeedShoro" ) ) {
            if ( !isCancelled( ctx.getRequest() ) ) {
                EmdadForm form = (EmdadForm) ctx.getForm();
                ActionErrors aerr = form.validate( ctx.getActionMapping(), ctx.getRequest() );
                if ( !aerr.isEmpty() ) {
                    prepareShoro( ctx, emdadLocal );
                    showMessage( ctx, aerr );
                    return ctx.getActionMapping().findForward( "shoro" );
                }

//                ctx.getForm().set("vazeatKhedmatId", null);
//                ctx.getForm().set("emdadgarId", null);
//                ctx.getForm().set("ezamgarId", null);
//                ctx.getForm().set("dalileToolKeshidaneEmdadId", null);
//                ctx.getForm().set("namayandegiId", null);

                ctx.getForm().set( "vazeatKonuni", new Integer( 1 ) );
                if ( ctx.getForm().get( "noeEmdad" ) != null ) {
                    ctx.getRequest().setAttribute( "noeEmdad", ctx.getForm().get( "noeEmdad" ) );
                }
                ctx.getForm().set( "zamanPayan", null );
                ctx.getForm().set( "zamanVagheiPayan", null );
                ctx.getForm().set( "rahAndazi", "" );
                doUpdate( ctx );
                return ctx.getActionMapping().findForward( "refresh" );
            } else {
                return ctx.getActionMapping().findForward( "enseraf" );
            }

        } else if ( ctx.getSubAction().equals( "payan" ) ) {
            if ( !isCancelled( ctx.getRequest() ) ) {
                preparePayan( ctx, emdadLocal );
                return ctx.getActionMapping().findForward( "payan" );
            } else {
                return ctx.getActionMapping().findForward( "enseraf" );
            }

        } else if ( ctx.getSubAction().equals( "taeedPayan" ) ) {

            if ( id == null ) {
                throw new ServletException( NULL_ID_MESSAGE );
            }
            if ( !isCancelled( ctx.getRequest() ) ) {
                try {
                    EmdadForm form = (EmdadForm) ctx.getForm();
//                    log.info("000 form="+form);
                    ActionErrors aerr = form.validate( ctx.getActionMapping(), ctx.getRequest() );
//                    log.info("111 form="+form);
                    if ( !aerr.isEmpty() ) {
                        preparePayan( ctx, emdadLocal );
                        showMessage( ctx, aerr );
                        return ctx.getActionMapping().findForward( "payan" );
                    }

//                    ctx.getForm().set("vazeatKhedmatId", null);
//                    ctx.getForm().set("emdadgarId", null);
//                    ctx.getForm().set("ezamgarId", null);
//                    ctx.getForm().set("namayandegiId",null);

                    //RokhdadLocal rl = RokhdadUtil.getLocalHome().findByPrimaryKey(emdadLocal.getRokhdad().getId());
                    EmdadList vo = new EmdadList();
                    vo.setEshterakId( (String) ctx.getRequest().getAttribute( "moshtarakId" ) ); //  rl.getMoshtarak().getMoshtarakModel().getEshterakId());
                    vo.setRokhdadId( (String) ctx.getRequest().getAttribute( "rokhdadId" ) );
                    vo.setRokhdadRokhdadId( (Integer) ctx.getRequest().getAttribute( "rokhdadRokhdadId" ) );//rl.getRokhdadModel().getRokhdadId());
                    vo.setId( id );
                    ctx.getRequest().setAttribute( VALUE_OBJECT, vo );
                    ctx.getForm().set( "zamanVagheiPayan", ctx.getForm().get( "zamanVagheiPayan" ) ); //HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
                    ctx.getForm().set( "zamanVagheiPayan2", ctx.getForm().get( "zamanVagheiPayan2" ) ); //HejriUtil.getCurrentTime());
                    ctx.getForm().set( "zamanPayan", ctx.getForm().get( "zamanPayan" ) );
                    ctx.getForm().set( "zamanPayan2", ctx.getForm().get( "zamanPayan2" ) );
                    ctx.getForm().set( "vazeatKonuni", new Integer( 2 ) );

                    if ( id == null ) {
                        throw new ServletException( NULL_ID_MESSAGE );
                    }
                    if ( 1 == 1 ) {
                        doPayan( ctx );
                    } else {
                        String emdadgarId = (String) ctx.getForm().get( "emdadgarId" );
                        String namayandegiId = (String) ctx.getForm().get( "namayandegiId" );

                        doUpdate( ctx );
                        decrementKar( ctx.getConnection(), emdadgarId, namayandegiId, noeEmdad.intValue() );
                        log.info( "========== oomad too end" );
                        setDastorkarGhabli( ctx.getConnection(), (String) ctx.getForm().get( "rokhdadId" ), new Integer( 0 ) );
                    }

                } catch ( Exception e ) {
                    e.printStackTrace();
                }
                return ctx.getActionMapping().findForward( "refresh" );

            } else {
                return ctx.getActionMapping().findForward( "enseraf" );
            }

        } else if ( ctx.getSubAction().equals( "taeedVaJadid" ) ) {

            if ( id == null ) {
                throw new ServletException( NULL_ID_MESSAGE );
            }
            if ( !isCancelled( ctx.getRequest() ) ) {
                try {
                    EmdadForm form = (EmdadForm) ctx.getForm();
                    ActionErrors aerr = form.validate( ctx.getActionMapping(), ctx.getRequest() );
                    if ( !aerr.isEmpty() ) {
                        preparePayan( ctx, emdadLocal );
                        showMessage( ctx, aerr );
                        return ctx.getActionMapping().findForward( "payan" );
                    }

                    //RokhdadLocal rl = RokhdadUtil.getLocalHome().findByPrimaryKey(emdadLocal.getRokhdad().getId());
                    EmdadList vo = new EmdadList();
                    vo.setEshterakId( (String) ctx.getRequest().getAttribute( "moshtarakId" ) ); //  rl.getMoshtarak().getMoshtarakModel().getEshterakId());
                    vo.setRokhdadId( (String) ctx.getRequest().getAttribute( "rokhdadId" ) );
                    vo.setRokhdadRokhdadId( (Integer) ctx.getRequest().getAttribute( "rokhdadRokhdadId" ) );//rl.getRokhdadModel().getRokhdadId());
                    vo.setId( id );
                    ctx.getRequest().setAttribute( VALUE_OBJECT, vo );
                    ctx.getForm().set( "zamanVagheiPayan", ctx.getForm().get( "zamanVagheiPayan" ) ); //HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
                    ctx.getForm().set( "zamanVagheiPayan2", ctx.getForm().get( "zamanVagheiPayan2" ) ); //HejriUtil.getCurrentTime());
                    ctx.getForm().set( "zamanPayan", ctx.getForm().get( "zamanPayan" ) );
                    ctx.getForm().set( "zamanPayan2", ctx.getForm().get( "zamanPayan2" ) );
                    ctx.getForm().set( "vazeatKonuni", new Integer( 2 ) );

                    if ( id == null ) {
                        throw new ServletException( NULL_ID_MESSAGE );
                    }
//                    int noeEmdad = -1;
//                    if (ctx.getForm().get("noeEmdad") != null) {
//                        log.info("============= noeEmdad not null");
//                        noeEmdad = ((Integer)ctx.getForm().get("noeEmdad")).intValue();
//                        log.info("========== noeEmdad = " + noeEmdad);
//                        ctx.getRequest().setAttribute("noeEmdad", ctx.getForm().get("noeEmdad"));
//                    }

                    if ( 1 == 1 ) {
                        doPayan( ctx );
                    } else {
                        String emdadgarId = (String) ctx.getForm().get( "emdadgarId" );
                        String namayandegiId = (String) ctx.getForm().get( "namayandegiId" );

                        doUpdate( ctx );
                        decrementKar( ctx.getConnection(), emdadgarId, namayandegiId, noeEmdad.intValue() );
                    }

                } catch ( Exception e ) {
                    e.printStackTrace();
                }
                log.info( "=========oomad to jadid" );
                setDastorkarGhabli( ctx.getConnection(), (String) ctx.getForm().get( "rokhdadId" ), (Integer) ctx.getForm().get( "emdadId" ) );
                return ctx.getActionMapping().findForward( "refresh" );

            } else {
                return ctx.getActionMapping().findForward( "enseraf" );
            }

        } else if ( ctx.getSubAction().equals( "end" ) ) {
            log.info( "========== oomad too end" );
            setDastorkarGhabli( ctx.getConnection(), (String) ctx.getForm().get( "rokhdadId" ), new Integer( 0 ) );
            return ctx.getActionMapping().findForward( "refresh" );

        } else if ( ctx.getSubAction().equals( "addNew" ) ) {
            //isNew = true;
//            ctx.getForm().set("zamanEzam", HejriUtil.chrisToHejri(new java.sql.Date(HejriUtil.getCurrentDate().getTime())));
//            ctx.getForm().set("zamanEzam2", HejriUtil.getCurrentTime());
//            ctx.getForm().set("noeEmdad", noeEmdad);
//            ctx.getForm().set("vazeatKonuni", new Integer(0));
//            ctx.getForm().set(ACTION_TYPE, "create");
//            return ctx.getActionMapping().findForward("edit");
            setDastorkarGhabli( ctx.getConnection(), (String) ctx.getForm().get( "rokhdadId" ), (Integer) ctx.getForm().get( "emdadId" ) );
            return ctx.getActionMapping().findForward( "refresh" );

        } else if ( ctx.getSubAction().equals( "emdadShow" ) ) {
            ctx.getForm().set( ValueObject.ID, Util.getIdWithO( ctx.getConnection(), "com.objectj.emdad.ejb.EmdadModel", (String) ctx.getForm().get( ValueObject.ID ), "emdad", "emdadId" ) );
            if ( ( (String) ctx.getForm().get( ValueObject.ID ) ) == null ) {
                return ctx.getActionMapping().findForward( "showNotFound" );
            }

            doReadById( ctx );
            return ctx.getActionMapping().findForward( "emdadShow" );

        } else if ( ctx.getSubAction().equals( "find" ) ) {

            ctx.getUserSession().clearAllFilters( ctx.getEntity() );

            //---------------------------  vazeatKonuni  -------------------------------
            if ( ctx.getRequest().getParameter( "vazeatKonuni" ) != null ) {
                ctx.setForceFilter( "emdad.vazeatKonuni = 'I1'" );
            } else {
                ctx.setForceFilter( "" );
            }

            //---------------------------  noeEmdad  -------------------------------
            if ( ctx.getRequest().getParameter( "noeEmdad4" ) != null ) {
                String f = ctx.getForceFilter();
                if ( f != null && f.length() > 0 ) {
                    f += " AND ";
                } else {
                    f = "";
                }
                ctx.setForceFilter( f + " emdad.noeEmdad = 'I" + ctx.getRequest().getParameter( "noeEmdad4" ) +
                        "' AND /* (id NOT IN (SELECT emdadId FROM khodroJagozinMasraf)) */ " );
            }

            //---------------------------  emdadgar  -------------------------------
            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
                String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                if ( ctx.getForceFilter() != null && ctx.getForceFilter().length() != 0 ) {
                    ctx.setForceFilter( ctx.getForceFilter() + " AND " );
                }
                ctx.setForceFilter( ctx.getForceFilter() + " emdad.emdadgarId = 'S" + emdadgarId + "'" );
            }
            //---------------------------  daftarOstani  -------------------------------
            else if ( !getAccess( ctx ).getAllAccess() ) {
                String daftarOstaniId = ctx.getUserSession().getDaftarOstani();
                if ( ctx.getForceFilter() != null && ctx.getForceFilter().length() != 0 ) {
                    ctx.setForceFilter( ctx.getForceFilter() + " AND " );
                }
                ctx.setForceFilter( ctx.getForceFilter() + " rokhdad.daftarOstaniId = 'S" + daftarOstaniId + "'" );
            }
            log.info( "---find filter=" + ctx.getForceFilter() );
            ctx.getUserSession().setSpecific( ctx.getForceFilter(), "find", ctx.getEntity() );
        } else if ( ctx.getSubAction().equals( "forceNoeEmdad" ) ) {
            if ( ctx.getRequest().getParameter( "noeEmdad" ) != null && ctx.getRequest().getParameter( "noeEmdad" ).length() != 0 ) {
                noeEmdad = Integer.valueOf( ctx.getRequest().getParameter( "noeEmdad" ) );
                ctx.getRequest().setAttribute( "forceNoeEmdad", noeEmdad );
                ctx.getUserSession().clearAllFilters( ctx.getEntity() );
                ctx.setForceFilter( "emdad.vazeatKonuni <> 'I2' AND emdad.noeEmdad = 'I" + noeEmdad + "' " );
                ctx.setForceForwardTo( "list" + noeEmdad );
                ctx.getUserSession().setSpecific( ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity() );
                if ( noeEmdad.intValue() == 1 ) {
                    ctx.getForm().set( "forceNoeService", "adi" );
                    if ( ctx.isUserInRole( Constants.ROLE_EZAMGAR_VIJE ) ) {
                        return ctx.getActionMapping().findForward( "subactionSecurityError" );
                    }
                } else {
                    ctx.getForm().set( "forceNoeService", "vijeh" );
                    if ( ctx.isUserInRole( Constants.ROLE_EZAMGAR_ADI ) ) {
                        return ctx.getActionMapping().findForward( "subactionSecurityError" );
                    }
                }
            } else {
                ctx.getUserSession().clearAllFilters( ctx.getEntity() );
                ctx.setForceFilter( " emdad.vazeatKonuni <> 'I2' AND emdad.noeEmdad <>'I4'" );
                ctx.getForm().set( "forceNoeService", "adi" );
                ctx.setForceForwardTo( "list" );
                noeEmdad = new Integer( 0 );
                ctx.getRequest().setAttribute( "forceNoeEmdad", new Integer( 0 ) );
                ctx.getUserSession().setSpecific( ctx.getForceFilter(), ctx.getForceForwardTo(), ctx.getEntity() );
            }
        } else if ( ctx.getSubAction().indexOf( "createEmdad4" ) >= 0 ) {     //-- Khodro Jagozin
            changeDateToChris( ctx );
            ctx.getForm().set( ACTION_TYPE, "update" );
            ctx.getForm().set( "vazeatDakheli", new Integer( 1 ) );
            saveChangesFromEdit( ctx );
            Integer ii = null;
            if ( ctx.getForm().get( "emdadId" ) != null ) {
                ii = Integer.valueOf( ctx.getForm().get( "emdadId" ).toString() );
            }

            ctx.getForm().set( "dastoorKarGhabli", ii );
            ctx.getForm().set( "maliDone", new Integer( MALI_NOT_DONE ) );
            ctx.getForm().set( "noeEmdad", new Integer( 4 ) );
            ctx.getForm().set( "vazeatKonuni", new Integer( 0 ) );
            ctx.getForm().set( "vazeatDakheli", new Integer( 0 ) );
            ctx.getForm().set( ID, "" );
            ctx.getForm().set( ACTION_TYPE, "create" );
            ctx.getForm().set( "zamanEzam", HejriUtil.hejriToChrisStr( HejriUtil.chrisToHejri( new java.sql.Date( HejriUtil.getCurrentDate().getTime() ) ) ) );
            ctx.getForm().set( "zamanEzam2", HejriUtil.getCurrentTime() );
            ctx.getForm().set( "vazeatKonuni", new Integer( 0 ) );
            saveChangesFromCreate( ctx );
//                showMessage = true;
            ctx.getRequest().setAttribute( "noeEmdad", noeEmdad );
            return ctx.getActionMapping().findForward( "confirm" );
            //return ctx.getActionMapping().findForward("refresh");
        } else if ( ctx.getSubAction().equals( "tasvieHesabEmdadgarList" ) ) {
            log.info( "~~~~~~~~~~~~~~ tasvieHesabList" );
            return tasvieHesabEmdadgar( ctx );
        } else if ( ctx.getSubAction().equals( "tasvieHesabJarsaghilList" ) ) {
            log.info( "~~~~~~~~~~~~~~ jarsaghil" );
            return tasvieHesabJarsaghil( ctx );
        } else if ( ctx.getSubAction().equals( "tasvieHesabNamayandegiList" ) ) {
            log.info( "~~~~~~~~~~~~~~ namayandegi" );
            return tasvieHesabNamayandegi( ctx );
        }
//        if (showMessage){
//            ActionErrors error = new ActionErrors();
//            error.clear();
//            error.add("emdadId", new ActionError("emdad.new.emdadId", ctx.getRequest().getAttribute("newEmdadId")));
//            ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
//            showMessage = false;
//        } else
        else if ( ctx.getSubAction().equals( "import" ) ) {
            return doImport( ctx );
        } else if ( ctx.getSubAction().equals( "filter" ) ) {
            return doFilter( ctx );
            // Added by me( =Behrad ) for KhodroJaygozinMasraf Jostejoo!
        } else if ( ctx.getSubAction().equals( "find4" ) ) {

            ctx.getUserSession().clearAllFilters( ctx.getEntity() );

            //---------------------------  vazeatKonuni  -------------------------------
            if ( ctx.getRequest().getParameter( "vazeatKonuni" ) != null ) {
                ctx.setForceFilter( "emdad.vazeatKonuni = 'I1'" );
            } else {
                ctx.setForceFilter( "" );
            }

            //---------------------------  noeEmdad  -------------------------------
            if ( ctx.getRequest().getParameter( "noeEmdad4" ) != null ) {
                String f = ctx.getForceFilter();
                if ( f != null && f.length() > 0 ) {
                    f += " AND ";
                } else {
                    f = "";
                }
                ctx.setForceFilter( f + " emdad.noeEmdad = 'I" + ctx.getRequest().getParameter( "noeEmdad4" ) +
                        "' AND /* (id NOT IN (SELECT emdadId FROM khodroJagozinMasraf)) */ " );
            }

            //---------------------------  emdadgar  -------------------------------
            if ( ctx.isUserInRole( Constants.ROLE_EMDADGARESTEKHDAMI ) || ctx.isUserInRole( Constants.ROLE_EMDADGARPEYMANI ) ) {
                String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                if ( ctx.getForceFilter() != null && ctx.getForceFilter().length() != 0 ) {
                    ctx.setForceFilter( ctx.getForceFilter() + " AND " );
                }
                ctx.setForceFilter( ctx.getForceFilter() + " emdad.emdadgarId = 'S" + emdadgarId + "'" );
            }
            //---------------------------  daftarOstani  -------------------------------
            else if ( !getAccess( ctx ).getAllAccess() ) {
                String daftarOstaniId = ctx.getUserSession().getDaftarOstani();
                if ( ctx.getForceFilter() != null && ctx.getForceFilter().length() != 0 ) {
                    ctx.setForceFilter( ctx.getForceFilter() + " AND " );
                }
                ctx.setForceFilter( ctx.getForceFilter() + " rokhdad.daftarOstaniId = 'S" + daftarOstaniId + "'" );
            }
            log.info( "---find filter=" + ctx.getForceFilter() );
            ctx.getUserSession().setSpecific( ctx.getForceFilter(), "find", ctx.getEntity() );
        }
        // End Add
        return listAll( ctx );
    }

    protected ActionForward doImport( BaseActionContext ctx ) throws ProxyException {
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;


        if ( !isCancelled( ctx.getRequest() ) ) {
//            ResultSet rs2 = null;
//            com.objectj.emdad.ejb.util.Util.add("unk_Shahr", Constants.getShahr_Unknown());
//            com.objectj.emdad.ejb.util.Util.add("unk_Moshtarak", Constants.getMoshtari_Unknown());
//            String daftarOstaniTehran = ctx.getUserSession().getDaftarOstani();
            String systemId = UserAccessEntity.stringQuery( "SELECT id FROM shakhs WHERE username = 'system'", "id", ctx.getConnection() );

            try {
                ArrayList emdadgarList = EmdadgarSessionUtil.getLocalHome().create().readCombo( "emdadgar", "emdadgarId", "", "emdadgarId" ).getResult();
                ArrayList namayandegiList = NamayandegiSessionUtil.getLocalHome().create().readCombo( "namayandegi", "namayandegiId", "", "namayandegiId" ).getResult();

                PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( Util.getTempraryPath() + "importEmdad.log" ) ) );
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
                String query = "SELECT * FROM view_import_emdad";
                Integer rId = (Integer) ctx.getForm().get( "emdadId" );
                if ( rId != null && rId.intValue() != 0 ) {
                    query += " where serviceId>=" + rId.intValue();
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
                String lastEmdadIdS = UserAccessEntity.stringQuery( "SELECT max(emdadId) as last FROM emdad ", "last", ctx.getConnection() );
                int lastEmdadId = Integer.parseInt( lastEmdadIdS );
                int serviceId = 0;

                while ( resultSet.next() && serviceId < 355072 ) { // && lastEmdadId<360000

                    recordCount++;

                    if ( recordCount % 100 == 0 ) {
                        log.info( "imported:" + recordCount + ",updateCount:" + updateCount + ",createCount:" + createCount + ",errorCount:" + errorCount );
                    }

                    boolean isUpdate = false;
                    EmdadModel emdad = null;
                    emdad = new EmdadModel();

                    serviceId = resultSet.getInt( "ServiceId" );
                    log.info( "serviceId=" + serviceId );
                    String id = UserAccessEntity.stringQuery( "SELECT id FROM emdad WHERE emdadId = " + serviceId, "id", ctx.getConnection() );
                    if ( id != null && id.length() > 0 ) {
                        //continue;
                        isUpdate = true;
                        emdad.setId( id );
                    } else {
                        emdad.setVazeatDakheli( new Integer( 0 ) );
                        emdad.setDastoorKarGhabli( new Integer( 0 ) );
                        emdad.setMaliDone( new Integer( MALI_DONE ) );
                        emdad.setRahAndazi( "" );
                        emdad.setHazinehAyyabZahab( null );
                        emdad.setHazinehBoxel( null );
                        emdad.setHazinehJarsaghil( null );
                        emdad.setVazeatKonuni( new Integer( 2 ) );
                        emdad.setAkharinTagheerDahandeh( "918280808080805FA5o" );
                        emdad.setKilometerKarkard( new Integer( 0 ) );
                        emdad.setFaseleAzNamayandegi( new Integer( 0 ) );
                        emdad.setNoeEmdad( new Integer( 1 ) );
//                        serviceId = 360000;
//                        while (lastEmdadId < serviceId-1 ) {
//                            try {
//                                emdad.setId("");
//                                emdad = (EmdadModel) ((EmdadProxy)getProxy()).create(emdad, null, null, null, null, null, null);
//                                createCount++;
//                            } catch (Exception e) {
//                                out.println("Error Creating Blank emdad Entity. (emdadId = " + lastEmdadId);
//                                errorCount++;
//                            }
//                            lastEmdadId = emdad.getEmdadId().intValue();
//                            log.info("lastEmdadId=" + lastEmdadId);
//                        }
//                        lastEmdadId = 360001;
//                        if (1==1) continue;
                        emdad.setId( "" );
                    }

                    //emdad.setEmdadId(new Integer(Integer.parseInt(resultSet.getString("ServiceId"))));
                    emdad.setNoeEmdad( new Integer( resultSet.getBoolean( "Special" ) ? 2 : 1 ) );
                    emdad.setZamanEzam( resultSet.getTimestamp( "OrderTime" ) );
                    emdad.setZamanVagheiEzam( resultSet.getTimestamp( "RealOrderTime" ) );
                    emdad.setKilometerKarkard( resultSet.getString( "kmWorked" ) != null ? new Integer( resultSet.getInt( "kmWorked" ) ) : new Integer( 0 ) );
                    emdad.setFaseleAzNamayandegi( resultSet.getString( "DistAid" ) != null ? new Integer( resultSet.getInt( "DistAid" ) ) : new Integer( 0 ) );
                    emdad.setZamanShoro( resultSet.getTimestamp( "StartTime" ) );
                    emdad.setZamanVagheiShoro( resultSet.getTimestamp( "RealStartTime" ) );
                    emdad.setZamanPayan( resultSet.getTimestamp( "FinishTime" ) );
                    emdad.setZamanVagheiPayan( resultSet.getTimestamp( "RealFinishTime" ) );
                    emdad.setVazeatKonuni( new Integer( 2 ) );
                    emdad.setHazinehAyyabZahab( null );
                    emdad.setHazinehBoxel( null );
                    emdad.setHazinehJarsaghil( null );
                    emdad.setHododeHazinehKol( resultSet.getString( "Price" ) != null ? new Integer( resultSet.getInt( "Price" ) ) : new Integer( 0 ) );
                    emdad.setMablaghPardakhtShodeh( resultSet.getString( "Payed" ) != null ? new Integer( resultSet.getInt( "Payed" ) ) : new Integer( 0 ) );
                    emdad.setVazeatDakheli( new Integer( 0 ) );
                    emdad.setDastoorKarGhabli( new Integer( 0 ) );
                    emdad.setMaliDone( new Integer( MALI_DONE ) );
                    emdad.setElateService( "" );

                    String rahAndazi = resultSet.getString( "Operation" );
                    rahAndazi = rahAndazi != null ? rahAndazi.trim() : "";
                    emdad.setRahAndazi( rahAndazi.substring( 0, rahAndazi.length() < 64 ? rahAndazi.length() : 64 ) );
                    emdad.setAkharinTagheerDahandeh( "918280808080805FA5o" );

                    String namayandegiId = null;
                    namayandegiId = Util.getIdFromList( namayandegiList, "" + resultSet.getInt( "syncId" ) );
                    String emdadgarId = null;
                    if ( namayandegiId == null || namayandegiId.length() == 0 ) {
                        emdadgarId = Util.getIdFromList( emdadgarList, "" + resultSet.getInt( "syncId" ) );
                    }

                    String rokhdadId = UserAccessEntity.stringQuery( "SELECT id FROM rokhdad WHERE rokhdadId = " + resultSet.getInt( "EventId" ), "id", ctx.getConnection() );

                    if ( !isUpdate ) {
                        emdad.setId( "" ); //char
                    }

                    boolean success = false;
                    if ( isUpdate ) {
                        try {
                            ( (EmdadProxy) getProxy() ).update( emdad, rokhdadId, null, emdadgarId, systemId, null, namayandegiId );
                            success = true;
                            updateCount++;
                        } catch ( Exception e ) {
                            out.println( "Error Updating Entity. (emdadId = " + serviceId );
                            errorCount++;
                            statementStatus.executeUpdate( "UPDATE services SET importStatus = 10 where serviceId = " + serviceId );
                        }
                    } else {
                        try {
                            emdad = (EmdadModel) ( (EmdadProxy) getProxy() ).create( emdad, rokhdadId, null, emdadgarId, systemId, null, namayandegiId );
                            success = true;
                            createCount++;
                        } catch ( Exception e ) {
                            out.println( "Error Creating Entity. (emdadId = " + serviceId );
                            errorCount++;
                            statementStatus.executeUpdate( "UPDATE services SET importStatus = 10 where serviceId = " + serviceId );
                        }
                        lastEmdadId = emdad.getEmdadId().intValue();
                    }
                    if ( success ) {
                        String is = resultSet.getString( "importStatus" );
                        if ( is != null && !is.equals( "0" ) ) {
                            statementStatus.executeUpdate( "UPDATE services SET importStatus = 0 where serviceId = " + serviceId );
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
//                try {
//                    if (rs2!=null)
//                        rs2.close();
//                } catch (Exception e2 ) {}

            }

        }

        ctx.getForm().set( "noeEmdad", ctx.getRequest().getAttribute( "noeEmdad" ) );

        errorList.add( 0, new String( "Error Count: " + errorCount ) );
        errorList.add( 0, new String( "Unchange Count: " + unchangeCount ) );
        errorList.add( 0, new String( "Update Count: " + updateCount ) );
        errorList.add( 0, new String( "Create Count: " + createCount ) );
        errorList.add( 0, new String( "Total record Count: " + recordCount ) );

        ctx.getRequest().setAttribute( "errorList", errorList );
        log.info( "========== iiiiiinnnnnneeeeehhhhhh..................." );
        return ctx.getActionMapping().findForward( "importinfo" );
    }


    protected void doPayan( BaseActionContext ctx ) {
        try {
//                long t1 = (new java.util.Date()).getTime();
//	            String selectStatement = "execute dbo.PayanEmdad2 ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?" ;
//	            PreparedStatement prepStmt = ctx.getConnection().prepareStatement(selectStatement); //, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            EmdadForm form = (EmdadForm) ctx.getForm();
            int i = 1;
            EmdadModel vo = new EmdadModel();
            Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
            if ( (String) ( form.get( "zamanVagheiPayan" ) ) != null && ( (String) ( form.get( "zamanVagheiPayan" ) ) ).length() != 0 ) {
                vo.setZamanVagheiPayan( HejriUtil.convertToTimesatmp( (String) form.get( "zamanVagheiPayan" ), (String) form.get( "zamanVagheiPayan2" ) ) );
            }

            if ( (String) ( form.get( "zamanPayan" ) ) != null && ( (String) ( form.get( "zamanPayan" ) ) ).length() != 0 ) {
                vo.setZamanPayan( HejriUtil.convertToTimesatmp( (String) form.get( "zamanPayan" ), (String) form.get( "zamanPayan2" ) ) );
            }
//	            prepStmt.setString(i++, vo.getId());
//	            prepStmt.setObject(i++, ctx.getUserSession().getId());
//	            prepStmt.setInt(i++, vo.getFaseleAzNamayandegi().intValue());
//	            prepStmt.setTimestamp(i++, vo.getZamanPayan());
//	            prepStmt.setTimestamp(i++, vo.getZamanVagheiPayan());
//	            prepStmt.setInt(i++, vo.getKilometerKarkard().intValue());
//	            prepStmt.setInt(i++, vo.getMablaghPardakhtShodeh().intValue());
//	            prepStmt.setString(i++, vo.getRahAndazi());
//	            prepStmt.setString(i++, vo.getTozihat());
//	            prepStmt.setString(i++, vo.getElateService());
//	            prepStmt.setString(i++, (String)form.get("dalileToolKeshidaneEmdadId"));
//	            prepStmt.setString(i++, (String)form.get("emdadgarId"));
//	            prepStmt.setString(i++, (String)form.get("namayandegiId"));
            ( (EmdadProxy) getProxy() ).payan( vo,
                    ctx.getUserSession().getId(),
                    (String) form.get( "dalileToolKeshidaneEmdadId" ),
                    (String) form.get( "emdadgarId" ),
                    (String) form.get( "namayandegiId" ) );
//	            prepStmt.close();
//                log.info("-- doPayan Done time="+((new java.util.Date()).getTime()-t1));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private ActionForward exportIpaqXls( BaseActionContext ctx ) {
        try {
            String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
            QueryObject q = new QueryObject();
            q.setTables( "emdadList" );
            q.setView( true );
            q.setWhere( "emdadgarId='" + emdadgarId + "' AND vazeatkonuni = 0" ); // Shoroo nashode
            q.setSelectFields( "emdadId, irad, eshterakId, kilometerKarkard, zamanShoro, zamanPayan, rahAndazi, hododeHazinehKol" );
            q.setFromIndex( 0 );
            q.setToIndex( 99999 );
            ArrayList emdadList = Exchanger.exhangeResultSetToValueObjectArray( ctx.getConnection(), q, null, new EmdadList(), false ).getResult();
            ctx.getRequest().setAttribute( "value_object_list", emdadList );
        } catch ( Exception e ) {
            e.printStackTrace();
            return ctx.getActionMapping().findForward( "error" );
        }
        return ctx.getActionMapping().findForward( "ipaqXls" );
    }

    private ActionForward importIpaqXls( BaseActionContext ctx ) {
        /*
        IpaqXls xls = new IpaqXls( ctx.getRequest().getParameter( "xlsFile" ) );
        String emdadId = "", irad = "";
        boolean serviceJadid = false;
        EmdadModel emdad = new EmdadModel();
        try {
            for( int i = 0; i < xls.rowSize(); i++ ) {
                emdadId = UserAccessEntity.stringQuery( "select id from emdad where emdadId='" + xls.getEmdad(i).getString() + "'", "id" );
                QueryObject qo = new QueryObject();
                qo.setTables( "emdad" );
                qo.setWhere( "id='" + emdadId + "'");
                emdad = EmdadSessionUtil.getLocalHome().create().readModel( qo );
                irad = xls.getIrad(i).getString();
                serviceJadid = com.objectj.emdad.ejb.util.Util.isEmpty( xls.getServiceJadid(i).getString() ) ? false : true;
                //emdad.setId( emdadId );
                emdad.setKilometerKarkard( new Integer( xls.getKarkard(i).getString() ) );
                if( !serviceJadid )
                    emdad.setVazeatKonuni( new Integer( 2 ));
                emdad.setRahAndazi( xls.getRahandazi(i).getString() );
                String[] shoroStamp = xls.getZamanShoro(i).getString().split( " " );
                String[] payanStamp = xls.getZamanPayan(i).getString().split( " " );
                emdad.setZamanShoro( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( shoroStamp[0]), shoroStamp[1] ));
                emdad.setZamanPayan( HejriUtil.convertToTimesatmp( HejriUtil.hejriToChrisStr( payanStamp[0]), payanStamp[1] ));
                emdad.setMablaghPardakhtShodeh( new Integer( xls.getMablaghKol(i).getString() ) );
                EmdadSessionUtil.getLocalHome().create().update( emdad );
            }
        } catch( Exception e ) {
            e.printStackTrace();
            return ctx.getActionMapping().findForward( "error" );
        }
        */
        return ctx.getActionMapping().findForward( "ipaqXlsImported" );
    }

    public boolean isDatabaseSQL() {
        return UserSession.isISDatabaseSQL();
    }
}
