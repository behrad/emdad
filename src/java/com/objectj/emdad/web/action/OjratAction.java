package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.OjratModel;
import com.objectj.emdad.ejb.UserAccessEntity;
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
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @struts.action name="ojratForm"
 * path="/c/ojrat"
 * pathPrime="/ojrat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.edit.jsp"
 * inputPrime="emdad.ojrat.edit"
 * validate="false"
 * @struts.action name="ojratForm"
 * path="/r/ojrat"
 * pathPrime="/ojrat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.read.jsp"
 * inputPrime="emdad.ojrat.read"
 * validate="false"
 * @struts.action name="ojratForm"
 * path="/u/ojrat"
 * pathPrime="/ojrat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.edit.jsp"
 * inputPrime="emdad.ojrat.edit"
 * validate="false"
 * @struts.action name="ojratForm"
 * path="/d/ojrat"
 * pathPrime="/ojrat"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.read.jsp"
 * inputPrime="emdad.ojrat.read"
 * validate="false"
 * @struts.action name="ojratForm"
 * path="/l/ojrat"
 * pathPrime="/ojratList"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.list.jsp"
 * inputPrime="emdad.ojrat.list"
 * validate="false"
 * @struts.action name="ojratForm"
 * path="/c/validateojrat"
 * pathPrime="/validateojrat"
 * scope="request"
 * input="/c/ojrat.run"
 * inputPrime="emdad.ojrat.edit"
 * input4tiles="emdad.ojrat.edit"
 * validate="true"
 * @struts.action name="ojratForm"
 * path="/u/validateojrat"
 * pathPrime="/validateojrat"
 * scope="request"
 * input="/u/ojrat.run"
 * inputPrime="emdad.ojrat.edit"
 * input4tiles="emdad.ojrat.edit"
 * validate="true"
 * @struts.action name="ojratForm"
 * path="/s/ojrat"
 * pathPrime="/ojratShow"
 * scope="request"
 * input="/com/objectj/emdad/jsp/ojrat.show.jsp"
 * inputPrime="/com/objectj/emdad/jsp/ojrat.show.jsp"
 * validate="false"
 * @struts.action-forward name="list"
 * path="emdad.ojrat.list"
 * pathPrime="emdad.ojrat.list"
 * @struts.action-forward name="edit"
 * path="emdad.ojrat.edit"
 * pathPrime="emdad.ojrat.edit"
 * @struts.action-forward name="read"
 * path="emdad.ojrat.read"
 * pathPrime="emdad.ojrat.read"
 * @struts.action-forward name="thanks"
 * path="/com/objectj/emdad/jsp/thanks.jsp"
 * pathPrime="emdad.thanks"
 * @struts.action-forward name="default"
 * path="/util/genericPage.jsp"
 * pathPrime="/util/genericPage.jsp"
 * @struts.action-forward name="error"
 * path="/util/errors.jsp"
 * pathPrime="/util/errors.jsp"
 * @struts.action-forward name="ojratShow"
 * path="/com/objectj/emdad/jsp/ojrat.show.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.show.jsp"
 * @struts.action-forward name="find"
 * path="/com/objectj/emdad/jsp/ojrat.find.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.find.jsp"
 * @struts.action-forward name="uploaded"
 * path="/com/objectj/emdad/jsp/ojrat.uploaded.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.uploaded.jsp"
 * @struts.action-forward name="importinfo"
 * path="/com/objectj/emdad/jsp/ojrat.importinfo.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.importinfo.jsp"
 * @struts.action-forward name="requpload"
 * path="/com/objectj/emdad/jsp/ojrat.requpload.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.requpload.jsp"
 * @struts.action-forward name="ojratSelect"
 * path="/com/objectj/emdad/jsp/ojrat.select.jsp"
 * pathPrime="/com/objectj/emdad/jsp/ojrat.select.jsp"
 */

public class OjratAction extends BaseAction {

    //String forceFilter, forceForwardTo;

    protected Class getValueObjectClass() {
        return OjratModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"ojratId", "onvan", "ojrat"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return OjratSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            e.printStackTrace( System.out );
            throw new ProxyException( e );
        }
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
            //return doImport(ctx, "c:/ojrat.dbf");
        }

        if ( ctx.getSubAction().equals( "ojratShow" ) ) {
            return doShow( ctx, "ojratId", "ojratShow" );
        } else if ( ctx.getSubAction().equals( "ojratSelect" ) ) {
            log.info( "oomad too ojratSelect" );
            String iradId = (String) ctx.getForm().get( "id" );
            if ( iradId.endsWith( "o" ) ) {
                log.info( "ends with o." );
                iradId = UserAccessEntity.stringQuery( "SELECT iradId from irad WHERE id = '" + iradId + "'", "iradId" );
            }

            ArrayList ojratList = null;
            try {
                log.info( "========== iradId.substring(0,2) = " + iradId.substring( 0, 2 ) );
                ojratList = IradSessionUtil.getLocalHome().create().readCombo( "ojrat", "onvan", "ojratId LIKE '" + iradId.substring( 0, 2 ) + "%'" ).getResult();
            } catch ( Exception e ) {
                throw e;
            }

            ctx.getRequest().setAttribute( "ojratList1", ojratList );
            return ctx.getActionMapping().findForward( "ojratSelect" );
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

                PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( Util.getTempraryPath() + "importOjrat.log" ) ) );

                IranSysDecoder iranSysDecoder = new IranSysDecoder();
                ImportDBF importDBF = new ImportDBF();
                ResultSet resultSet = importDBF.fetchDBF( fileName );

                while ( resultSet.next() ) {
                    recordCount++;

                    int row = resultSet.getRow();
                    boolean isUpdate = false;

                    OjratModel ojratModel = new OjratModel();
					
/*					String code_oj_uni = new String();
					byte[] code_oj = resultSet.getBytes("ojratId");
					if (code_oj != null) {
						code_oj_uni = iranSysDecoder.decodeNoReverse(code_oj);
						code_oj_uni.trim();
						String count = null;

						// check for valid irad for this ojrat
						count = UserAccessEntity.stringQuery("SELECT COUNT(iradId) AS count FROM irad WHERE iradId LIKE '" + code_oj_uni.substring(0, 2) + "%'", "count");
						if (count.equals("0")) {
							out.println("Code_oj " + code_oj_uni + " on row  " + row + " has no available irad.");
							errorCount++;
							continue;
						}

						ojratModel.setOjratId(code_oj_uni);
					} else {
						out.println("Code_oj on row  " + row + " is NULL. ");
					}*/

                    String ojratId = resultSet.getString( "Repair_cd" );
                    if ( ojratId == null || ojratId.length() < 2 ) {
                        out.println( "ojratId '" + ojratId + "' on row  " + row + " is not valid id." );
                        errorCount++;
                        continue;
                    }

                    String count = UserAccessEntity.stringQuery( "SELECT COUNT(iradId) AS count FROM irad WHERE iradId LIKE '" + ojratId.substring( 0, 2 ) + "%'", "count" );
                    if ( count.equals( "0" ) ) {
                        out.println( "ojratId " + ojratId + " on row  " + row + " has no available irad." );
                        errorCount++;
                        continue;
                    }
                    ojratModel.setOjratId( ojratId );

                    QueryObject qo = new QueryObject();
                    qo.setTables( "ojrat" );
                    qo.setWhere( "ojratId = '" + ojratId + "'" );
                    qo.setJoined( false );
                    ArrayList ojratArray = OjratSessionUtil.getLocalHome().create().readModel( qo ).getResult();
                    if ( !ojratArray.isEmpty() ) {
                        isUpdate = true;
                        ojratModel.setId( ( (OjratModel) ojratArray.get( 0 ) ).getId() );
                    } else {
                        ojratModel.setId( "" ); //char
                    }


                    ///////////////////////////
                    // Setting valueObject starts here
                    byte[] onvan = resultSet.getBytes( "Repair_dsc" );
                    if ( onvan != null ) {
                        String onvan_uni = iranSysDecoder.decodeNoReverse( onvan );
                        ojratModel.setOnvan( onvan_uni.substring( 0, onvan_uni.length() < 60 ? onvan_uni.length() : 60 ) );
                        //nchar
                    } else {
                        ojratModel.setOnvan( "-" );
                    }

                    ojratModel.setOjrat( new Integer( 0 ) );
                    //ojratModel.setModat(new Integer(resultSet.getInt("time")));

                    byte[] time = resultSet.getBytes( "Repair_tm" );
                    if ( time != null ) {
                        String time_uni = iranSysDecoder.decode( time );
                        ojratModel.setModat( new Integer( Integer.parseInt( time_uni.substring( 0, time_uni.length() < 60 ? time_uni.length() : 60 ) ) ) );
                        //nchar
                    } else {
                        ojratModel.setModat( new Integer( 0 ) );
                    }

                    // End of setting
                    ///////////////////////

                    ActionErrors actionErrors = new ActionErrors();
                    if ( actionErrors.isEmpty() ) {
                        if ( isUpdate ) {
                            try {
                                //((OjratProxy)getProxy()).update(ojratModel, null);
                                getProxy().update( ojratModel );
                                updateCount++;
                            } catch ( Exception e ) {
                                out.println( "Error Updating Entity. (ojratId = " + ojratId + ")" );
                                errorCount++;
                            }
                        } else {
                            try {
                                //((OjratProxy)getProxy()).create(ojratModel, null);
                                getProxy().create( ojratModel );
                                createCount++;
                            } catch ( Exception e ) {
                                out.println( "Error Creating Entity. (ojratId = " + ojratId + ")" );
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
        return ctx.getActionMapping().findForward( "importinfo" );
    }

}
