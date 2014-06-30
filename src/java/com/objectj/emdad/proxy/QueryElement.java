
package com.objectj.emdad.proxy;

public class QueryElement {

	private String type;
	private String value;

	public QueryElement() {
	}

    public QueryElement(String type,String value) {
        this.type = type;
        this.value = value;
    }

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}


	public void setType(String string) {
		type = string;
	}

	public void setValue(String string) {
		value = string;
	}

    public String toString() {
        return "type="+type+",value="+value;
    }
}
