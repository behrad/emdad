package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.QateModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.QateProxy;
import com.objectj.emdad.proxy.QateSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.util.ImportDBF;
import com.objectj.emdad.proxy.util.IranSysDecoder;
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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @struts.action name="qateForm"
 * path="/c/qate"
 * pathPrime="/qate"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.edit.jsp"
 * inputPrime="emdad.qate.edit"
 * validate="false"
 * @struts.action name="qateForm"
 * path="/r/qate"
 * pathPrime="/qate"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.read.jsp"
 * inputPrime="emdad.qate.read"
 * validate="false"
 * @struts.action name="qateForm"
 * path="/u/qate"
 * pathPrime="/qate"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.edit.jsp"
 * inputPrime="emdad.qate.edit"
 * validate="false"
 * @struts.action name="qateForm"
 * path="/d/qate"
 * pathPrime="/qate"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.read.jsp"
 * inputPrime="emdad.qate.read"
 * validate="false"
 * @struts.action name="qateForm"
 * path="/l/qate"
 * pathPrime="/qateList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.list.jsp"
 * inputPrime="emdad.qate.list"
 * validate="false"
 * @struts.action name="qateForm"
 * path="/c/validateqate"
 * pathPrime="/validateqate"
 * scope="request"
 * input="/c/qate.run"
 * inputPrime="emdad.qate.edit"
 * input4tiles="emdad.qate.edit"
 * validate="true"
 * @struts.action name="qateForm"
 * path="/u/validateqate"
 * pathPrime="/validateqate"
 * scope="request"
 * input="/u/qate.run"
 * inputPrime="emdad.qate.edit"
 * input4tiles="emdad.qate.edit"
 * validate="true"
 * @struts.action name="qateForm"
 * path="/s/qate"
 * pathPrime="/qateShow"
 * scope="request"
 * input="/com/objectj/emdad/jsp/qate.show.jsp"
 * inputPrime="/com/objectj/emdad/jsp/qate.show.jsp"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.qate.list"
 * pathPrime="emdad.qate.list"
 * @struts.action-forward name="edit"
 * path="emdad.qate.edit"
 * pathPrime="emdad.qate.edit"
 * @struts.action-forward name="read"
 * path="emdad.qate.read"
 * pathPrime="emdad.qate.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="qateShow"
 * path="/com/objectj/emdad/jsp/qate.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/qate.show.jsp"
 * @struts.action-forward name="find"
 * path="/com/objectj/emdad/jsp/qate.find.jsp"
 * pathPrime="/com/objectj/emdad/jsp/qate.find.jsp"
 * @struts.action-forward name="uploaded"
 * path="/com/objectj/emdad/jsp/qate.uploaded.jsp"
 * pathPrime="/com/objectj/emdad/jsp/qate.uploaded.jsp"
 * @struts.action-forward name="importinfo"
 * path="/com/objectj/emdad/jsp/qate.importinfo.jsp"
 * pathPrime="/com/objectj/emdad/jsp/qate.importinfo.jsp"
 * @struts.action-forward name="requpload"
 * path="/com/objectj/emdad/jsp/qate.requpload.jsp"
 * pathPrime="/com/objectj/emdad/jsp/qate.requpload.jsp"
 */

public class QateAction extends BaseAction {

    ArrayList vahedShomareshList = new ArrayList();

    ArrayList noeKhodroList = new ArrayList();
    //String forceFilter, forceForwardTo;

    protected Class getValueObjectClass() {
        return QateModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"qateId", "shomareFanni", "name", "vahedShomaresh", "gheimat", "saghfeTedadi"};
    }

    protected boolean needList() {
        return true;
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return QateSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {

        vahedShomareshList = Util.getArrayList( "vahedShomaresh" );

        noeKhodroList = ComboPool.getCombo( "noeKhodro" );

        ctx.getRequest().setAttribute( "vahedShomareshList", vahedShomareshList );

        ctx.getRequest().setAttribute( "noeKhodroList", noeKhodroList );
    }

    protected ActionForward doReadById( BaseActionContext ctx ) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get( ValueObject.ID );
        if ( id == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }
        try {
            com.objectj.emdad.proxy.QateSessionLocalHome lhProxy = com.objectj.emdad.proxy.QateSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.QateSessionLocal lProxy = lhProxy.create();
            ValueObject voQateList = lProxy.read( id );

            ctx.getRequest().setAttribute( VALUE_OBJECT, voQateList );
            ctx.getRequest().setAttribute( "vahedShomaresh", ( (ComboObject) vahedShomareshList.get( ( (QateModel) voQateList ).getVahedShomaresh().intValue() ) ).getName() );

            ctx.getRequest().setAttribute( "noeKhodroName", com.objectj.emdad.ejb.QateUtil.getLocalHome().findByPrimaryKey( id ).getNoeKhodro().getNoeKhodroModel().getOnvan() );


        } catch ( Exception e ) {
            e.printStackTrace();
            throw new ProxyException( e );
        }

        return ctx.getActionMapping().findForward( "read" );
    }

    protected String getForceFilter( BaseActionContext ctx ) {
        return ctx.getForceFilter();
    }

    protected String getForceForwardTo( BaseActionContext ctx ) {
        return ctx.getForceForwardTo();
    }

    protected ActionForward doSpecific( BaseActionContext ctx ) throws Exception {

        if ( ctx.getSubAction().equals( "requpload" ) ) {
            return ctx.getActionMapping().findForward( "requpload" );
        } else if ( ctx.getSubAction().equals( "uploaded" ) ) {
            int farsi = Integer.parseInt( ctx.getRequest().getParameter( "farsi" ) );
            ctx.getRequest().setAttribute( "farsi", new Integer( farsi ) );
            return ctx.getActionMapping().findForward( "uploaded" );
        } else if ( ctx.getSubAction().equals( "doimport" ) ) {
            return doImport( ctx, (String) ctx.getForm().get( ValueObject.ID ) );
        }

        if ( ctx.getSubAction().equals( "qateShow" ) ) {
            return doShow( ctx, "shomareFanni", "qateShow" );
        } else if ( ctx.getSubAction().equals( "find" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.setForceForwardTo( "find" );
//ctx.setForceFilter("");

            //ctx.getUserSession().clearAllFilters(ctx.getEntity());
            //ctx.setForceForwardTo("find");
//			ctx.setForceFilter("");
            String filter = ctx.getForceFilter();
            if ( ctx.getUserSession().getRole().equals( Constants.ROLE_EMDADGARESTEKHDAMI ) || ( ctx.getUserSession().getRole().equals( Constants.ROLE_EMDADGARPEYMANI ) ) ) {
                String emdadgarId = UserAccessEntity.getEntityId( ctx.getUserSession().getName() );
                int satheMaharat = Integer.parseInt( UserAccessEntity.stringQuery( "SELECT satheMaharat FROM emdadgar WHERE id = '" + emdadgarId + "'", "satheMaharat" ) );
//                log.info("~~~~~~~~~~~~~~ satheMaharat: " + satheMaharat);
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( filter ) ) {
                    filter += " AND ";
                }
                filter += " qate.satheMaharat <= 'I" + satheMaharat + "'";
            }
            String noeKhodroId = ctx.getRequest().getParameter( "noeKhodroId" );
            if ( noeKhodroId != null ) {
                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty( filter ) ) {
                    filter += " AND ";
                }
                filter += " qate.noeKhodroId = 'S" + noeKhodroId + "'";
            }
            ctx.setForceFilter( filter );
            ctx.getUserSession().setSpecific( filter, "find", ctx.getEntity() );
//            return doTemporarySpecific(ctx, filter, "find");
        } else if ( ctx.getSubAction().equals( "ent" ) ) {
            clearAllFilters( ctx );
        }


        return listAll( ctx );
    }

    protected ActionForward doUpdate( BaseActionContext ctx ) {
        ValueObject valueObject = newValueObject();
        Exchanger.exhangeFormToValueObject( ctx.getForm(), valueObject );
        try {
            com.objectj.emdad.proxy.QateSessionUtil.getLocalHome().create().update( valueObject, (String) ctx.getForm().get( "noeKhodroId" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return listAll( ctx );
    }

    protected ActionForward doImport( BaseActionContext ctx, String fileName ) throws ProxyException {
        log.info( " IMPORT : file name = " + fileName );
        ArrayList errorList = new ArrayList();
        int errorCount = 0;
        int recordCount = 0;
        int createCount = 0;
        int updateCount = 0;
        int unchangeCount = 0;

        if ( !isCancelled( ctx.getRequest() ) ) {
            try {

                PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( Util.getTempraryPath() + "importQate.log" ) ) );
                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF( fileName );

                int maxQateId = UserAccessEntity.intQuery( "SELECT max(qateId) as qateId  FROM qate", "qateId" );
                int i = 0;
                while ( i < 100 && resultSet.next() ) {
                    i++;
                    recordCount++;

                    int row = resultSet.getRow();
                    boolean isUpdate = false;

                    QateModel qateModel = new QateModel();

                    String shomareFanni = resultSet.getString( "Part_no" );
                    if ( shomareFanni != null && shomareFanni.length() != 0 ) {
                        shomareFanni.trim();
                        qateModel.setShomareFanni( shomareFanni );
                    } else {
                        out.println( "shomarehFanni on row  " + row + " is NULL. " );
                    }

                    QueryObject qo = new QueryObject();
                    qo.setTables( "qate" );
                    qo.setWhere( "shomareFanni = '" + shomareFanni + "'" );
                    qo.setJoined( false );
                    ArrayList qateArray = QateSessionUtil.getLocalHome().create().readModel( qo ).getResult();
                    if ( !qateArray.isEmpty() ) {
                        isUpdate = true;
                        qateModel.setId( ( (QateModel) qateArray.get( 0 ) ).getId() );
                    } else {
                        qateModel.setId( "" ); //char
                    }

                    ///////////////////////////
                    // Setting valueObject starts here
                    int qateId = 12400;
                    qateModel.setQateId( new Integer( qateId++ ) );
                    qateModel.setGheimat( new Integer( resultSet.getString( "Price" ) ) );
                    if ( Integer.parseInt( ctx.getRequest().getParameter( "farsi" ) ) == 1 ) {
                        qateModel.setName( iranSysDecoder.decodeNoReverse( resultSet.getBytes( "Part_dsc" ) ) );
                    } else {
                        qateModel.setName( resultSet.getString( "Part_dsc" ) );
                    }
                    //   qateModel.setShomareFanni(resultSet.getString("fanni"));
                    qateModel.setSaghfeTedadi( new Integer( 0 ) );
//                    qateModel.setVahedShomaresh(new Integer(resultSet.getInt("vahed")));
                    qateModel.setVahedShomaresh( new Integer( 1 ) );
                    qateModel.setSatheMaharat( new Integer( 1 ) );
                    ++maxQateId;
                    qateModel.setQateId( new Integer( maxQateId ) );
                    // End of setting
                    ///////////////////////
                    String noeKhodroId = UserAccessEntity.stringQuery( "SELECT id FROM NoeKhodro where noeKhodroCode='" + resultSet.getString( "Part_cd" ) + "'", "id" );
                    ActionErrors actionErrors = new ActionErrors();
                    if ( actionErrors.isEmpty() ) {
                        if ( noeKhodroId.equals( "" ) ) {
                            out.println( "Error Entity.(shomareFanni = " + shomareFanni + "): not exist noeKhodroCode " + resultSet.getString( "Part_cd" ) );
                            System.out.println( "Error Entity.(shomareFanni = " + shomareFanni + "): not exist noeKhodroCode " + resultSet.getString( "Part_cd" ) );
                            errorCount++;
                        } else if ( isUpdate ) {
                            try {
                                ( (QateProxy) getProxy() ).update( qateModel, noeKhodroId );
                                System.out.println( "update" );
                                //getProxy().update(qateModel);

//                                NoeKhodroLocal noeKhodroLocal = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
//                                QateLocal qateLocal = QateUtil.getLocalHome().findByPrimaryKey(qateModel.getId());
//                                System.out.println("!!!"+noeKhodroLocal.getId());
//                                qateLocal.setNoeKhodro(noeKhodroLocal);
                                updateCount++;
                            } catch ( Exception e ) {
                                e.printStackTrace();
                                out.println( "Error Updating Entity.(shomareFanni = " + shomareFanni + ")" );
                                errorCount++;
                            }
                        } else {
                            try {
                                ( (QateProxy) getProxy() ).create( qateModel, noeKhodroId );
                                System.out.println( "create" );
//                                System.out.println("------------");
//                                System.out.println(qateModel.getGheimat());
//                                System.out.println(qateModel.getId());
//                                System.out.println(qateModel.getName());
//                                System.out.println(qateModel.getPrimaryKey());
//                                System.out.println(qateModel.getQateId());
//                                System.out.println(qateModel.getShomareFanni());
//                                getProxy().create(qateModel);
//                                QateLocal qateLocal = QateUtil.getLocalHome().findByPrimaryKey(qateModel.getId());
//                                qateLocal.setNoeKhodro(NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId));
                                createCount++;
                            } catch ( Exception e ) {
                                e.printStackTrace();
                                out.println( "Error Creating Entity.(shomareFanni = " + shomareFanni + ")" );
                                errorCount++;
                            }
                        }
                    } else {
                        Iterator iter = actionErrors.get();
                        String errorTmp = new String();
                        while ( iter.hasNext() ) {
                            ActionError actionError = (ActionError) iter.next();
                            String ts = com.objectj.emdad.web.util.Util.getProperty( actionError.getKey() );
                            if ( ts != null ) {
                                errorTmp += ts;
                            } else {
                                errorTmp += actionError.getKey();
                            }
                            errorTmp += ", ";
                        }
                        out.println( errorTmp );
                        errorCount++;
                    }
                }
                resultSet.close();

                out.println( "Error Count: " + errorCount );
                out.println( "Unchange Count: " + unchangeCount );
                out.println( "Update Count: " + updateCount );
                out.println( "Create Count: " + createCount );
                out.println( "Total record Count: " + recordCount );
                out.close();
            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            }
        }

        errorList.add( 0, new String( "Error Count: " + errorCount ) );
        errorList.add( 0, new String( "Unchange Count: " + unchangeCount ) );
        errorList.add( 0, new String( "Update Count: " + updateCount ) );
        errorList.add( 0, new String( "Create Count: " + createCount ) );
        errorList.add( 0, new String( "Total record Count: " + recordCount ) );

        ctx.getRequest().setAttribute( "errorList", errorList );
        log.info( "==========iiiiiinnnnnneeeeehhhhhh..................." );
        return ctx.getActionMapping().findForward( "importinfo" );
    }

    protected String doFilterPostProcessor( BaseActionContext ctx, String filter ) {
        if ( !com.objectj.emdad.ejb.util.Util.isEmpty( filter ) ) {
            return filter += " AND qate.noeKhodroId = 'S" + ctx.getRequest().getParameter( "noeKhodroId" ) + "'";
        }
        return filter;
    }


}
