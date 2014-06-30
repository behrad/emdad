package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NaghsheSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.QueryResult;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.sql.*;


/**
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/c/naghshe"
 *      pathPrime="/naghshe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.edit.jsp"
 *      inputPrime="emdad.naghshe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/r/naghshe"
 *      pathPrime="/naghshe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.read.jsp"
 *      inputPrime="emdad.naghshe.read"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/u/naghshe"
 *      pathPrime="/naghshe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.edit.jsp"
 *      inputPrime="emdad.naghshe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/d/naghshe"
 *      pathPrime="/naghshe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.read.jsp"
 *      inputPrime="emdad.naghshe.read"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/l/naghshe"
 *      pathPrime="/naghsheList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.list.jsp"
 *      inputPrime="emdad.naghshe.list"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/c/validatenaghshe"
 *      pathPrime="/validatenaghshe"
 *      scope="request"
 *      input="/c/naghshe.run"
 *      inputPrime="emdad.naghshe.edit"
 *      input4tiles="emdad.naghshe.edit"
 *      validate="true"
 * 
 * @struts.action
 *      name="filterNaghsheForm"
 *      path="/l/filternaghshe"
 *      pathPrime="/filternaghshe"
 *      scope="request"
 *      input="/l/naghshe.run"
 *      inputPrime="emdad.naghshe.edit"
 *      input4tiles="emdad.naghshe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="naghsheForm"
 *      path="/u/validatenaghshe"
 *      pathPrime="/validatenaghshe"
 *      scope="request"
 *      input="/u/naghshe.run"
 *      inputPrime="emdad.naghshe.edit"
 *      input4tiles="emdad.naghshe.edit"
 *      validate="true"
 *
 *  @struts.action
 *      name="naghsheForm"
 *      path="/s/naghshe"
 *      pathPrime="/naghshe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/naghshe.edit.jsp"
 *      inputPrime="/com/objectj/emdad/jsp/naghshe.edit.jsp"
 *      validate="false"
 *
 *  @struts.action-forward
 *      name="naghsheInfoShow"
 *      path="/com/objectj/emdad/jsp/naghshe.info.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/naghshe.info.jsp"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.naghshe.list"
 *      pathPrime="emdad.naghshe.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.naghshe.edit"
 *      pathPrime="emdad.naghshe.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.naghshe.read"
 *      pathPrime="emdad.naghshe.read"
 *
 * @struts.action-forward
 *      name="display"
 *      path="emdad.naghshe.display"
 *      pathPrime="emdad.naghshe.display"
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
 *
 * @struts.action-forward
 *      name="map"
 *      path="/com/objectj/emdad/jsp/map.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/map.jsp"
 *
 * @struts.action-forward
 *      name="mapXML"
 *      path="/com/objectj/emdad/jsp/xml.map.generator.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/xml.map.generator.jsp"
 */

public class NaghsheAction extends BaseAction {
    protected Class getValueObjectClass() {
        return NaghsheModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"mapLevel", "azTooleGoegraphy", "taTooleGoegraphy", "azArzeGoegraphy", "taArzeGoegraphy", "mantagheId"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NaghsheSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected boolean needList() { return true; }

    protected ActionForward doNullAction(BaseActionContext ctx) {
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        ctx.getForm().set("azArz", "   :  :  ");
        ctx.getForm().set("azTool", "   :  :  ");
        ctx.getForm().set("taArz", "   :  :  ");
        ctx.getForm().set("taTool", "   :  :  ");
        return ctx.getActionMapping().findForward("edit");
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

    }

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        if(ctx.getSubAction().equals("changeLevel")){
			int mapLevel = Integer.parseInt(ctx.getRequest().getParameter("mapLevel"));
            QueryObject mapQuery = new QueryObject();
			mapQuery.setTables("naghshe");
		    int arz=Integer.parseInt(ctx.getRequest().getParameter("arz"));
			int tool=Integer.parseInt(ctx.getRequest().getParameter("tool"));
			int cols=Integer.parseInt(ctx.getRequest().getParameter("cols"));
            int topBot=Integer.parseInt(ctx.getRequest().getParameter("topBot"));
            log.info("---arz,tool,cols,level,topBot: "+arz+","+tool+","+cols+","+mapLevel+","+topBot);
	        mapQuery.setWhere("mapLevel = " + mapLevel+" and azArzeGoegraphy<="+arz+" and taArzeGoegraphy>="+arz+" and azTooleGoegraphy>="+tool+" Order By azTooleGoegraphy ASC");
			mapQuery.setToIndex(cols);
			ArrayList naghsheArray = NaghsheSessionUtil.getLocalHome().create().readModel(mapQuery).getResult();
		  	int minTool=0, maxTool=0, minArz=0, maxArz=0, cellArz=0, cellTool=0, rowCount=0;
			NaghsheModel naghsheModel = null;
			if (!naghsheArray.isEmpty()) {
				naghsheModel = (NaghsheModel) naghsheArray.get(0);
			    minTool = naghsheModel.getAzTooleGoegraphy().intValue();
			    maxTool = naghsheModel.getTaTooleGoegraphy().intValue();
			    minArz = naghsheModel.getAzArzeGoegraphy().intValue();
			    maxArz = naghsheModel.getTaArzeGoegraphy().intValue();
			    cellTool = maxTool - minTool;
			    cellArz = maxArz - minArz;
			    for (int i = 1; i < naghsheArray.size(); i++) {
					naghsheModel = (NaghsheModel) naghsheArray.get(i);
					if(minTool > naghsheModel.getAzTooleGoegraphy().intValue())
						minTool = naghsheModel.getAzTooleGoegraphy().intValue();
					if(maxTool < naghsheModel.getTaTooleGoegraphy().intValue())
						maxTool = naghsheModel.getTaTooleGoegraphy().intValue();
				}
			    String[][] imgList = new String[1][cols];
			    log.info("---minTool,maxTool,minArz,maxArz,rowCount: "+minTool+":"+maxTool+":"+minArz+":"+maxArz+":"+rowCount);
			    log.info("---imgList: "+imgList.length);
			    for (int i = 0; i < naghsheArray.size(); i++) {
					naghsheModel = (NaghsheModel) naghsheArray.get(i);
					imgList[0][(naghsheModel.getAzTooleGoegraphy().intValue()-minTool)/cellTool] = naghsheModel.getId().trim()+".gif";
				//                    log.info("---for loop ");
				}
				ctx.getRequest().setAttribute("imageList", imgList);
				ctx.getRequest().setAttribute("mapLevel", new Integer(mapLevel));
				ctx.getRequest().setAttribute("arzeShoro", new Integer(maxArz-cellArz));
				ctx.getRequest().setAttribute("tooleShoro", new Integer(minTool));
				ctx.getRequest().setAttribute("cellArz", new Integer(cellArz));
				ctx.getRequest().setAttribute("cellTool", new Integer(cellTool));
				return ctx.getActionMapping().findForward("map");
			}
		}
        else if (ctx.getSubAction().equals("mapInfo")){
            int mapLevel = Integer.parseInt(ctx.getRequest().getParameter("mapLevel"));
            int arzLeftRow = Integer.parseInt(ctx.getRequest().getParameter("arz"));
            int toolLeftRow = Integer.parseInt(ctx.getRequest().getParameter("tool"));
            QueryObject mapQuery = new QueryObject();
            mapQuery.setTables("view_joghraphy");
            mapQuery.setToIndex(10);
            if(mapLevel < 3)
                mapQuery.setWhere("shahrAzArz<="+arzLeftRow+" AND shahrTaArz>="+arzLeftRow+
                    " AND shahrAzTool<="+toolLeftRow+" AND shahrTaTool>="+toolLeftRow);
            else
                mapQuery.setWhere("azArz<="+arzLeftRow+" AND taArz>="+arzLeftRow+
                    " AND azTool<="+toolLeftRow+" AND taTool>="+toolLeftRow);
            QueryResult emdadgarQuery = Exchanger.exhangeResultSetToValueObjectArray(ctx.getConnection(), mapQuery, null, new NaghsheInfoBean(), false);
            ArrayList naghsheInfoList = emdadgarQuery.getResult();
            ctx.getRequest().setAttribute("naghsheList", naghsheInfoList);
            return ctx.getActionMapping().findForward("naghsheInfoShow");
        }
        else if (ctx.getSubAction().equals("levelPics")){
            log.info("---naghshe SubAction: " + ctx.getSubAction());
            int mapLevel = Integer.parseInt(ctx.getRequest().getParameter("mapLevel"));
            QueryObject mapQuery = new QueryObject();
            mapQuery.setTables("naghshe");
            mapQuery.setWhere("mapLevel = " + mapLevel);
            mapQuery.setToIndex(9999);
            ArrayList naghsheArray = NaghsheSessionUtil.getLocalHome().create().readModel(mapQuery).getResult();
            log.info("---naghsheArray size: "+naghsheArray.size());

            int minTool=0, maxTool=0, minArz=0, maxArz=0, cellArz=0, cellTool=0, rowCount=0;
            NaghsheModel naghsheModel = null;
            if (!naghsheArray.isEmpty()) {
                naghsheModel = (NaghsheModel) naghsheArray.get(0);
                minTool = naghsheModel.getAzTooleGoegraphy().intValue();
                maxTool = naghsheModel.getTaTooleGoegraphy().intValue();
                minArz = naghsheModel.getAzArzeGoegraphy().intValue();
                maxArz = naghsheModel.getTaArzeGoegraphy().intValue();
                cellTool = maxTool - minTool;
                cellArz = maxArz - minArz;
                for (int i = 1; i < naghsheArray.size(); i++) {
                    naghsheModel = (NaghsheModel) naghsheArray.get(i);
/*                    log.info("---azTool: "+naghsheModel.getAzTooleGoegraphy().intValue());
                    log.info("---taTool: "+naghsheModel.getTaTooleGoegraphy().intValue());
                    log.info("---azArz: "+naghsheModel.getAzArzeGoegraphy().intValue());
                    log.info("---taArz: "+naghsheModel.getTaArzeGoegraphy().intValue());*/
                    if(minTool > naghsheModel.getAzTooleGoegraphy().intValue())
                        minTool = naghsheModel.getAzTooleGoegraphy().intValue();
                    if(maxTool < naghsheModel.getTaTooleGoegraphy().intValue())
                        maxTool = naghsheModel.getTaTooleGoegraphy().intValue();
                    if(minArz > naghsheModel.getAzArzeGoegraphy().intValue())
                        minArz = naghsheModel.getAzArzeGoegraphy().intValue();
                    if(maxArz < naghsheModel.getTaArzeGoegraphy().intValue())
                        maxArz = naghsheModel.getTaArzeGoegraphy().intValue();
                }
                String[][] imgList = new String[(maxArz-minArz)/cellArz][(maxTool-minTool)/cellTool];
                rowCount=(maxArz-minArz)/cellArz;
                log.info("---minTool,maxTool,minArz,maxArz,rowCount: "+minTool+":"+maxTool+":"+minArz+":"+maxArz+":"+rowCount);
                log.info("---imgList: "+imgList.length);
                for (int i = 0; i < naghsheArray.size(); i++) {
                    naghsheModel = (NaghsheModel) naghsheArray.get(i);
                    imgList[rowCount-((naghsheModel.getAzArzeGoegraphy().intValue()-minArz)/cellArz)-1][(naghsheModel.getAzTooleGoegraphy().intValue()-minTool)/cellTool] = naghsheModel.getId().trim()+".gif";
//                    log.info("---for loop ");
                }
                ctx.getRequest().setAttribute("imageList", imgList);
                ctx.getRequest().setAttribute("mapLevel", new Integer(mapLevel));
                ctx.getRequest().setAttribute("arzeShoro", new Integer(maxArz-cellArz));
                ctx.getRequest().setAttribute("tooleShoro", new Integer(minTool));
                ctx.getRequest().setAttribute("cellArz", new Integer(cellArz));
                ctx.getRequest().setAttribute("cellTool", new Integer(cellTool));
                return ctx.getActionMapping().findForward("map");
            }
        }
        return ctx.getActionMapping().findForward("map");
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        try {
            if (!isCancelled(ctx.getRequest())) {
                NaghsheModel vo = new NaghsheModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                getProxy().create(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        try {
            if (!isCancelled(ctx.getRequest())) {
    //            String id = (String) ctx.getForm().get(ValueObject.ID);
                NaghsheModel vo = new NaghsheModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                getProxy().update(vo);
            }
        } catch (ProxyException e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return listAll(ctx);
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {

        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
        try{
        com.objectj.emdad.proxy.NaghsheSessionLocalHome lhProxy = com.objectj.emdad.proxy.NaghsheSessionUtil.getLocalHome();
        com.objectj.emdad.proxy.NaghsheSessionLocal lProxy = lhProxy.create();
        ValueObject voNaghsheList = lProxy.read(id);
        ctx.getForm().set("azArz",((NaghsheList)voNaghsheList).getAzArz());

        ctx.getForm().set("taArz",((NaghsheList)voNaghsheList).getTaArz());

        ctx.getForm().set("azTool",((NaghsheList)voNaghsheList).getAzTool());

        ctx.getForm().set("taTool",((NaghsheList)voNaghsheList).getTaTool());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }

        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }

    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
          throw new ServletException(NULL_ID_MESSAGE);

        try {
            com.objectj.emdad.proxy.NaghsheSessionLocalHome lhProxy = com.objectj.emdad.proxy.NaghsheSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.NaghsheSessionLocal lProxy = lhProxy.create();
            ValueObject voNaghsheList = lProxy.read(id);

            ctx.getForm().set("azArz",((NaghsheList)voNaghsheList).getAzArz());

            ctx.getForm().set("taArz",((NaghsheList)voNaghsheList).getTaArz());

            ctx.getForm().set("azTool",((NaghsheList)voNaghsheList).getAzTool());

            ctx.getForm().set("taTool",((NaghsheList)voNaghsheList).getTaTool());

            ctx.getRequest().setAttribute(VALUE_OBJECT, voNaghsheList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }

        return ctx.getActionMapping().findForward("read");
    }
}
