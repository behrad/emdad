package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.IradModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.IradSessionUtil;
import com.objectj.emdad.proxy.OjratSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.util.ImportDBF;
import com.objectj.emdad.proxy.util.IranSysDecoder;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
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
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @struts.action name="iradForm"
 * path="/c/irad"
 * pathPrime="/irad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.edit.jsp"
 * inputPrime="emdad.irad.edit"
 * validate="false"
 * @struts.action name="iradForm"
 * path="/r/irad"
 * pathPrime="/irad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.read.jsp"
 * inputPrime="emdad.irad.read"
 * validate="false"
 * @struts.action name="iradForm"
 * path="/u/irad"
 * pathPrime="/irad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.edit.jsp"
 * inputPrime="emdad.irad.edit"
 * validate="false"
 * @struts.action name="iradForm"
 * path="/d/irad"
 * pathPrime="/irad"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.read.jsp"
 * inputPrime="emdad.irad.read"
 * validate="false"
 * @struts.action name="iradForm"
 * path="/l/irad"
 * pathPrime="/iradList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.list.jsp"
 * inputPrime="emdad.irad.list"
 * validate="false"
 * @struts.action name="iradForm"
 * path="/c/validateirad"
 * pathPrime="/validateirad"
 * scope="request"
 * input="/c/irad.run"
 * inputPrime="emdad.irad.edit"
 * input4tiles="emdad.irad.edit"
 * validate="true"
 * @struts.action name="iradForm"
 * path="/u/validateirad"
 * pathPrime="/validateirad"
 * scope="request"
 * input="/u/irad.run"
 * inputPrime="emdad.irad.edit"
 * input4tiles="emdad.irad.edit"
 * validate="true"
 * @struts.action name="iradForm"
 * path="/s/irad"
 * pathPrime="/iradShow"
 * scope="request"
 * input="/com/objectj/emdad/jsp/irad.show.jsp"
 * inputPrime="/com/objectj/emdad/jsp/irad.show.jsp"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.irad.list"
 * pathPrime="emdad.irad.list"
 * @struts.action-forward name="edit"
 * path="emdad.irad.edit"
 * pathPrime="emdad.irad.edit"
 * @struts.action-forward name="read"
 * path="emdad.irad.read"
 * pathPrime="emdad.irad.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="iradShow"
 * path="/com/objectj/emdad/jsp/irad.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.show.jsp"
 * @struts.action-forward name="iradSelect"
 * path="/com/objectj/emdad/jsp/irad.select.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.select.jsp"
 * @struts.action-forward name="uploaded"
 * path="/com/objectj/emdad/jsp/irad.uploaded.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.uploaded.jsp"
 * @struts.action-forward name="importinfo"
 * path="/com/objectj/emdad/jsp/irad.importinfo.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.importinfo.jsp"
 * @struts.action-forward name="requpload"
 * path="/com/objectj/emdad/jsp/irad.requpload.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.requpload.jsp"
 * @struts.action-forward name="find"
 * path="/com/objectj/emdad/jsp/irad.find.jsp"
 * pathPrime="/com/objectj/emdad/jsp/irad.find.jsp"
 */

public class IradAction extends BaseAction {

    protected Class getValueObjectClass() {
        return IradModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"iradId", "onvan"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return IradSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected ActionForward doCreate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                IradModel vo = new IradModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                getProxy().create( vo );
                ComboPool.setDirty( ctx.getEntity() );
            } catch ( Exception e ) {
                e.printStackTrace( System.out );
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }

    protected ActionForward doUpdate( BaseActionContext ctx ) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if ( !isCancelled( ctx.getRequest() ) ) {
            try {
                IradModel vo = new IradModel();
                Exchanger.exhangeFormToValueObject( ctx.getForm(), vo );
                getProxy().update( vo );
                ComboPool.setDirty( ctx.getEntity() );
            } catch ( Exception e ) {
                e.printStackTrace();
                throw new ProxyException( e );
            }
        }
        return listAll( ctx );
    }

    /*
        protected ActionForward doReadById() throws ProxyException, ServletException {
            String id = (String) ctx.getForm().get(ValueObject.ID);
            if (id == null)
                throw new ServletException(NULL_ID_MESSAGE);
            try {
                com.objectj.emdad.proxy.IradSessionLocalHome lhProxy = com.objectj.emdad.proxy.IradSessionUtil.getLocalHome();
                com.objectj.emdad.proxy.IradSessionLocal lProxy = lhProxy.create();
                ValueObject voIradList = lProxy.read(id);
                ctx.getRequest().setAttribute(VALUE_OBJECT, voIradList);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
            return ctx.getActionMapping().findForward("read");
        }
    */

    protected void doSpecificAction( BaseActionContext ctx ) throws ProxyException {
        //        ArrayList ojratList = null;
        //        try {
        //            ojratList = OjratSessionUtil.getLocalHome().create().readCombo("ojrat","onvan").getResult();
        //            ojratList.add(0,new ComboObject("", ADD_TO_COMBO_LIST));
        //        } catch (Exception e) {
        //            throw new ProxyException(e);
        //        }
        //        ctx.getRequest().setAttribute("ojratList", ojratList);
    }

    protected ActionForward doDeleteByIdList( BaseActionContext ctx ) throws ServletException, ProxyException, ProxyReferenceException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
        log.info( "========== oomad too removeByIdList" );
        // when you selected a list of VALUE_OBJECT_LIST
        String[] ids = (String[]) ctx.getForm().get( SELECTED_ITEMS );
        if ( ids == null ) {
            throw new ServletException( NULL_ID_MESSAGE );
        }

        String[] deletableId;
        boolean hasRelatedEntity = false;
        ComboPool.setDirty( ctx.getEntity() );
        //        boolean error = false;
        for ( int i = 0; i < ids.length; i++ ) {
            if ( !( (IradForm) ctx.getForm() ).relatedEntityExists( ids[ i ] ) ) {
                deletableId = new String[ 1 ];
                deletableId[ 0 ] = ids[ i ];
                log.info( "========== deletableId[0] = " + deletableId[ 0 ] );
                try {
                    getProxy().remove( deletableId );
                } catch ( ProxyReferenceException e ) {
                    throw e;
                }
                log.info( "========== iradId " + ids[ i ] + " deleted." );
            } else {
                throw new ProxyReferenceException();
            }
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

                PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( Util.getTempraryPath() + "importIrad.log" ) ) );

                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF( fileName );

                while ( resultSet.next() ) {
                    recordCount++;

                    int row = resultSet.getRow();
                    boolean isUpdate = false;

                    IradModel irad = new IradModel();

                    //String f_code = resultSet.getString("F_code");
/*					String f_code_uni = new String();
					byte[] f_code = resultSet.getBytes("F_code");
					if (f_code != null) {
						f_code_uni = iranSysDecoder.decodeNoReverse(f_code);
						f_code_uni.trim();
						irad.setIradId(f_code_uni);
					} else {
						out.println("f_code on row  " + row + " is NULL. ");
						continue;
					}*/

                    String iradId = resultSet.getString( "Trbl_cd" );
                    if ( iradId != null && iradId.length() != 0 ) {
                        iradId.trim();
                        irad.setIradId( iradId );
                    } else {
                        out.println( "iradId on row  " + row + " is NULL. " );
                    }

                    QueryObject qo = new QueryObject();
                    qo.setTables( "irad" );
                    qo.setWhere( "iradId = '" + iradId + "'" );
                    qo.setJoined( false );
                    ArrayList iradArray = IradSessionUtil.getLocalHome().create().readModel( qo ).getResult();
                    if ( !iradArray.isEmpty() ) {
                        isUpdate = true;
                        irad.setId( ( (IradModel) iradArray.get( 0 ) ).getId() );
                    } else {
                        irad.setId( "" ); //char
                    }

                    ///////////////////////////
                    // Setting valueObject starts here

                    byte[] onvan = resultSet.getBytes( "Trbl_dsc" );
                    if ( onvan != null ) {
                        String onvan_uni = iranSysDecoder.decodeNoReverse( onvan );
                        irad.setOnvan( onvan_uni.substring( 0, onvan_uni.length() < 60 ? onvan_uni.length() : 60 ) );
                        //nchar
                    } else {
                        irad.setOnvan( "-" );
                    }

                    // End of setting
                    ///////////////////////

                    ActionErrors actionErrors = new ActionErrors();
                    if ( actionErrors.isEmpty() ) {
                        if ( isUpdate ) {
                            try {
                                //((IradProxy)getProxy()).update(irad, null);
                                getProxy().update( irad );
                                updateCount++;
                            } catch ( Exception e ) {
                                out.println( "Error Updating Entity. (iradId = " + iradId + ")" );
                                errorCount++;
                            }
                        } else {
                            try {
                                //((IradProxy)getProxy()).create(irad, null);
                                getProxy().create( irad );
                                createCount++;
                            } catch ( Exception e ) {
                                out.println( "Error Creating Entity. (iradId = " + iradId + ")" );
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

        ComboPool.setDirty( ctx.getEntity() );
        ctx.getRequest().setAttribute( "errorList", errorList );
        log.info( "========== iiiiiinnnnnneeeeehhhhhh..................." );
        return ctx.getActionMapping().findForward( "importinfo" );
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

        if ( ctx.getSubAction().equals( "iradShow" ) ) {
            return doShow( ctx, "iradId", "iradShow" );
        } else if ( ctx.getSubAction().equals( "iradSelect" ) ) {
            log.info( "oomad too iradSelect" );
            String ojratId = (String) ctx.getForm().get( "id" );
            if ( ojratId.endsWith( "o" ) ) {
                log.info( "ends with o." );
                ojratId = UserAccessEntity.stringQuery( "SELECT ojratId from ojrat WHERE id = '" + ojratId + "'", "ojratId" );
            }

            ArrayList iradList = null;
            try {
                log.info( "========== ojratId.substring(0,2) = " + ojratId.substring( 0, 2 ) );
                iradList = OjratSessionUtil.getLocalHome().create().readCombo( "irad", "onvan", "iradId LIKE '" + ojratId.substring( 0, 2 ) + "%'" ).getResult();
                iradList.add( 0, new ComboObject( "", ADD_TO_COMBO_LIST ) );
            } catch ( Exception e ) {
                throw e;
            }

            ctx.getRequest().setAttribute( "iradList1", iradList );
            return ctx.getActionMapping().findForward( "iradSelect" );
        } else if ( ctx.getSubAction().equals( "find" ) ) {
            ctx.getUserSession().clearAllFilters( ctx.getEntity() );
            ctx.setForceForwardTo( "find" );
            ctx.setForceFilter( "" );
            ctx.getUserSession().setSpecific( "", "find", ctx.getEntity() );
            log.info( ctx.getUserSession().getDestinationForward( ctx.getEntity() ) );
        } else if ( ctx.getSubAction().equals( "ent" ) ) {
            clearAllFilters( ctx );
        }
        return listAll( ctx );
    }
}
