<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="text/xml;charset=UTF-8" import="com.objectj.emdad.ejb.*,
                                                     com.objectj.emdad.proxy.QueryObject,
                                                     java.util.ArrayList,
                                                     com.objectj.emdad.proxy.NaghsheSessionUtil"%>
<%
    int mapLevel = request.getParameter("mapLevel")!=null ? Integer.parseInt(request.getParameter("mapLevel")) : 0;
    int arzLeftRow =  request.getParameter("arz")!=null ? Integer.parseInt(request.getParameter("arz")) : 0;
    int toolLeftRow =  request.getParameter("tool")!=null ? Integer.parseInt(request.getParameter("tool")) : 0;
    int topBot =  request.getParameter("topBot")!=null ? Integer.parseInt(request.getParameter("topBot")) : 0;
    int cols =  request.getParameter("cols")!=null ? Integer.parseInt(request.getParameter("cols")) : 0;
    int rows =  request.getParameter("rows")!=null ? Integer.parseInt(request.getParameter("rows")) : 0;
    int minTool=0, minArz=0, cellArz=0, cellTool=0;
    String[] imgList = null;

    QueryObject mapQuery = new QueryObject();
    mapQuery.setTables("naghshe");
    if(cols>0){
/*        if(topBot==0){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy<="+arzLeftRow+" and taArzeGoegraphy>="+
                arzLeftRow+" and azTooleGoegraphy<="+toolLeftRow+" and taTooleGoegraphy>="+toolLeftRow);
            ArrayList naghsheArray = NaghsheSessionUtil.getLocalHome().create().readModel(mapQuery).getResult();
            NaghsheModel naghsheModel = null;
            if (!naghsheArray.isEmpty()) {
                naghsheModel = (NaghsheModel) naghsheArray.get(0);
                toolLeftRow = naghsheModel.getAzTooleGoegraphy().intValue();
                arzLeftRow = naghsheModel.getAzArzeGoegraphy().intValue();
                topBot=-1;
            }
        }*/
        if(topBot==1){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy<="+arzLeftRow+
                " and azTooleGoegraphy>="+toolLeftRow+" Order By azArzeGoegraphy DESC,azTooleGoegraphy ASC");
        }
        else if(topBot==-1){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy>="+arzLeftRow+
                " and azTooleGoegraphy>="+toolLeftRow+" Order By azArzeGoegraphy ASC,azTooleGoegraphy ASC");
        }
        else if(topBot==0){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy="+arzLeftRow+
                " and azTooleGoegraphy>="+toolLeftRow+" Order By azArzeGoegraphy ASC,azTooleGoegraphy ASC");
        }
        mapQuery.setToIndex(cols);
        ArrayList naghsheArray = NaghsheSessionUtil.getLocalHome().create().readModel(mapQuery).getResult();
        NaghsheModel naghsheModel = null;
        if (!naghsheArray.isEmpty()) {
            imgList = new String[naghsheArray.size()];
            naghsheModel = (NaghsheModel) naghsheArray.get(0);
            minTool = naghsheModel.getAzTooleGoegraphy().intValue();
            minArz = naghsheModel.getAzArzeGoegraphy().intValue();
            cellTool = naghsheModel.getTaTooleGoegraphy().intValue() - minTool;
            cellArz = naghsheModel.getTaArzeGoegraphy().intValue() - minArz;
            for (int i = 0; i < naghsheArray.size(); i++) {
                naghsheModel = (NaghsheModel) naghsheArray.get(i);
                imgList[i] = naghsheModel.getId().trim()+".gif";
            }
        }
    }
    else if(rows>0){
        if(topBot==1){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy<="+arzLeftRow+
                " and azTooleGoegraphy>="+toolLeftRow+" Order By azTooleGoegraphy ASC,azArzeGoegraphy DESC");
        }
        else if(topBot<=0){
            mapQuery.setWhere("mapLevel = "+mapLevel+" and azArzeGoegraphy<="+arzLeftRow+
                " and azTooleGoegraphy="+toolLeftRow+" Order By azTooleGoegraphy DESC,azArzeGoegraphy DESC");
        }
        mapQuery.setToIndex(rows);
        ArrayList naghsheArray = NaghsheSessionUtil.getLocalHome().create().readModel(mapQuery).getResult();
        NaghsheModel naghsheModel = null;
        if (!naghsheArray.isEmpty()) {
            imgList = new String[naghsheArray.size()];
            naghsheModel = (NaghsheModel) naghsheArray.get(0);
            minTool = naghsheModel.getAzTooleGoegraphy().intValue();
            minArz = naghsheModel.getAzArzeGoegraphy().intValue();
            cellTool = naghsheModel.getTaTooleGoegraphy().intValue() - minTool;
            cellArz = naghsheModel.getTaArzeGoegraphy().intValue() - minArz;
            for (int i = 0; i < naghsheArray.size(); i++) {
                naghsheModel = (NaghsheModel) naghsheArray.get(i);
                imgList[i] = naghsheModel.getId().trim()+".gif";
            }
        }
    }
/*        ctx.getRequest().setAttribute("imageList", imgList);
        ctx.getRequest().setAttribute("mapLevel", new Integer(mapLevel));
        ctx.getRequest().setAttribute("arzeShoro", new Integer(minArz));
        ctx.getRequest().setAttribute("tooleShoro", new Integer(minTool));
        ctx.getRequest().setAttribute("cellArz", new Integer(cellArz));
        ctx.getRequest().setAttribute("cellTool", new Integer(cellTool));*/
%>
<map mapLevel="<%=mapLevel%>" Arz="<%=minArz%>" Tool="<%=minTool%>" cellArz="<%=cellArz%>" cellTool="<%=cellTool%>">
<% for(int i=0;imgList!=null && i<imgList.length;i++){ %>
    <cell imgSrc="<%=imgList[i]%>"></cell>
<%}%>
</map>