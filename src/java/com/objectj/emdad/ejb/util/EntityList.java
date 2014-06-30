/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: Apr 27, 2003
 * Time: 10:30:25 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

public class EntityList  {

    public EntityList(String[] sortableColumns, int curPage, String order, String sortType) {
        setSortableColumns(sortableColumns);
        setCurPage(curPage);
        setOrder(order);
        if (sortType == null || sortType.trim().length() == 0)
            setSortType(sortableColumns[0]);
        else
            setSortType(sortType);
    }

    public boolean hasPrevPage() {
        return curPage>1 ;
    }

    public int getPrevPage() {
        return curPage>1 ? curPage - 1 : curPage;
    }

    public int getNextPage() {
        return curPage<totalPages ? curPage+1 : curPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        int tp = totalRecords / recordsPerPage;
        if (tp * recordsPerPage != totalRecords) tp++;
     	setTotalPages(tp);
    	this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    private void setTotalPages(int totalPages) {
        setHasNextPage(curPage<totalPages);
        this.totalPages = totalPages;
        if (getCurPage()>totalPages)
            setCurPage(totalPages-1);
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        curPage = curPage<1 ? 1 : curPage;
        setHasNextPage(curPage<totalPages);
        this.curPage = curPage;
    }

	public int inList(String name){
		int i = -1;
		while (++i < sortableColumns.length)
			if (sortableColumns[i].equals(name))
				return i;
		return -1;
	}

    public void setSortableColumns(String[] sortableColumns) {
        this.sortableColumns = sortableColumns;
    }

    public String[] getSortableColumns() {
        return this.sortableColumns;
    }

	public String getSortableColumnString(String columnName, String columnTitle){
		int i = inList(columnName);
		if (i != -1){
			String retValue = "<a href=\"javascript:sort('"+sortableColumns[i]+"');\"><span class=\"textW\">"+columnTitle;
			if (sortType.equals(columnName)){
                retValue = retValue + "&nbsp;<img border=\"0\" src=\"/emdad/com/objectj/resources/jsp/tiles/emdad/images/";
				if (order.equals("ASC"))
					retValue = retValue + "asc";
				else
					retValue = retValue + "desc";
                retValue = retValue + "ending.gif\" name=\"sort\"></span></a>";
			}
			else
				retValue = retValue +  "</span></a>";
			return retValue;
		}
		return "<span class=\"textW\">" + columnTitle + "</span>";
	}

    public String getSortableColumnString(){
        return getSortableColumnString(getColumnName(), getColumnTitle());
    }

    public String getSortType(){
        if (this.sortType == null || this.sortType.length() == 0)
            return sortableColumns[0];
		return  this.sortType;
	}

    public void setSortType(String sortType){
		if (sortType == null || sortType.length() == 0)
			sortType = sortableColumns[0];
		this.sortType = sortType;
	}

    public boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getOrder(){
		return  this.order;
	}

    public void setOrder(String order){
		if (order == null || order.length() == 0)
			this.order = "ASC";
		this.order = order;
	}

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public boolean getIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean filter) {
        isFilter = filter;
    }


	private String sortType;
	private String order;
	private String[] sortableColumns;
    private String SortableColumnString;
    private int totalRecords;
    private int totalPages;
    private int curPage;
    private boolean hasNextPage;
    private String columnName;
    private String columnTitle;
    public final int recordsPerPage = 20;
    private boolean isFilter;
}
