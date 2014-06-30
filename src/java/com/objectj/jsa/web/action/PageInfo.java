/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: May 10, 2003
 * Time: 6:07:41 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.web.action;

import org.apache.struts.validator.DynaValidatorForm;

public class PageInfo {
    public static final String SORT_TYPE = "sorttype";
    public static final String ORDER = "order";
    public static final String CURPAGE = "curpage";

    private String order;
    private String sortType;
    private int curPage;

    public PageInfo(DynaValidatorForm form) {
        order = (String) form.get(ORDER);
        if (order == null || order.trim().length() == 0){
            order = "ASC";
            form.set(ORDER, order);
        }
        sortType = (String)form.get(SORT_TYPE);
        String curPageStr = (String)form.get(CURPAGE);
        if (curPageStr == null ||  curPageStr.length() == 0)
             curPage = 1;
        else
            curPage = Integer.parseInt(curPageStr);

    }

    public String getOrder() {
        return order;
    }

    public String getSortType() {
        return sortType;
    }

    public int getCurPage() {
        return curPage;
    }
}
