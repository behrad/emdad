
package com.objectj.emdad.proxy;

import java.util.ArrayList;

public class QueryObject {

	private String selectFields;
	private ArrayList queryElements;
	private String tables;
	private String orderTable;
	private String orderField;
	private String orderType;
	private int fromIndex;
	private int toIndex;
    private String where;
    private boolean isJoined;
    private boolean isView;


    public QueryObject(String tables, String orderTable, String orderField, String orderType) {
		queryElements = new ArrayList();
        this.tables = tables;
        this.orderTable = orderTable;
        this.orderField = orderField;
        this.orderType = orderType;
        this.selectFields = "*";
		fromIndex = 0;
		toIndex = 0;
		isJoined = true;

    }

	public QueryObject(String tables, String orderTable, String orderField) {
		this(tables, orderTable, orderField, "ASC");
	}

	public QueryObject(String tables, String orderTable, String orderField, boolean join) {
        this(tables, orderTable, orderField);
		this.isJoined = join;
	}

    public QueryObject getClone() {
        QueryObject qo = new QueryObject();
        qo.queryElements.addAll(getQueryElements());
        qo.tables = getTables();
        qo.orderTable = getOrderTable();
        qo.orderField = getOrderField();
        qo.orderType = getOrderType();
        qo.selectFields = getSelectFields();
        qo.where = getWhere();
        qo.fromIndex = getFromIndex();
        qo.toIndex = getToIndex();
        qo.isJoined = isJoined();
        qo.isView = isView();
        return qo;
    }

	public QueryObject() {
        queryElements = new ArrayList();
		this.selectFields = "*";
        //this.orderField = "";
        isJoined =true;
	}

    public void addElement(Object elem) {
        queryElements.add(elem);
    }

    public void removeElement(int index) {
        queryElements.remove(index);
    }

    public void emptyElements() {
        queryElements.clear();
    }

	public int getFromIndex() {
        if (fromIndex==0)
            return 1;
		return fromIndex;
	}

	public String getOrderField() {
		return orderField;
	}

	public String getOrderType() {
//        if (orderType==null || orderType.length()<1)
//            return "ASC";
		return orderType;
	}

	public ArrayList getQueryElements() {
		return queryElements;
	}

	public String getTables() {
		return tables;
	}

	public int getToIndex() {
        //if (toIndex==0)
        //    return 999999;
		return toIndex;
	}

	public void setFromIndex(int string) {
		fromIndex = string;
	}

	public void setOrderField(String string) {
        if (string.indexOf("(")!=-1)
            orderField = string.substring(0, string.indexOf("(")-1);
        else
		    orderField = string;
	}

	public void setOrderType(String string) {
		orderType = string;
	}

	public void setQueryElements(ArrayList list) {
		queryElements = list;
	}

	public void setTables(String string) {
		tables = string;
	}

	public void setToIndex(int string) {
		toIndex = string;
	}

	public String getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(String string) {
		orderTable = string;
	}

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

	public String getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(String string) {
		selectFields = string;
	}

    public boolean isJoined() {
         return isJoined;
     }

     public void setJoined(boolean joined) {
         isJoined = joined;
     }

	public boolean isView() {
		return isView;
	}

	public void setView(boolean b) {
		isView = b;
	}

    public String toString() {
        String s =  "tables=["+tables+"],where=["+where+"],selectFields=["+selectFields+"],orderTable=["+orderTable+"]";
        for (int i=0; i<queryElements.size(); i++)
            s += ","+i+"=["+queryElements.get(i)+"]";
        return s;
    }

}
