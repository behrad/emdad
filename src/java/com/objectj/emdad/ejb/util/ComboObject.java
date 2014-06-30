
package com.objectj.emdad.ejb.util;

public class ComboObject {
    public ComboObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

	public ComboObject(String eid, String name) {
		this.eid = eid;
		this.name = name;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    private String eid;


	public String getEid() {
		return eid;
	}


	public void setEid(String string) {
		this.eid = string;
	}

}
