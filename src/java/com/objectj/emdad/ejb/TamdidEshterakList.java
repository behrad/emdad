/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Jun 14, 2003
 * Time: 11:55:39 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class TamdidEshterakList extends com.objectj.emdad.ejb.TamdidEshterakModel{
    private java.lang.String id;
    private java.lang.String moshtarakId;
    
    private java.sql.Date tarikhAkharinTamdid;
    private java.lang.String tarikhAkharinTamdidHejri;
 
	private java.lang.String eshterakId;   
    private java.lang.String nameKhanevadegi;
    private java.lang.String name;
    private java.lang.Integer isLast;
    private java.lang.Integer noeService;
    private java.lang.String noeServiceName;
    private java.lang.String bazaryabId;
    private java.lang.String bazaryabName;

    public String getNoeServiceName() {
        return noeServiceName;
    }

    public void setNoeServiceName(String noeServiceName) {
        this.noeServiceName = noeServiceName;
    }

    public String getBazaryabId() {
        return bazaryabId;
    }

    public void setBazaryabId(String bazaryabId) {
        this.bazaryabId = bazaryabId;
    }

    public String getBazaryabName() {
        return bazaryabName;
    }

    public void setBazaryabName(String bazaryabName) {
        this.bazaryabName = bazaryabName;
    }

    public Integer getNoeService() {
        return noeService;
    }

    public void setNoeService(Integer noeService) {
        this.noeService = noeService;
    }

    public String getMoshtarakId() {
        return moshtarakId;
    }

    public void setMoshtarakId(String moshtarakId) {
        this.moshtarakId = moshtarakId;
    }

    public String getNameKhanevadegi() {
        return nameKhanevadegi;
    }

    public void setNameKhanevadegi(String nameKhanevadegi) {
        this.nameKhanevadegi = nameKhanevadegi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEshterakId() {
        return eshterakId;
    }

    public void setEshterakId(String eshterakId) {
        this.eshterakId = eshterakId;
    }

    public java.sql.Date getTarikhAkharinTamdid() {
        return tarikhAkharinTamdid;
    }

    public void setTarikhAkharinTamdid(java.sql.Date tarikhAkharinTamdid) {
        this.tarikhAkharinTamdid = tarikhAkharinTamdid;
    }

    public String getTarikhAkharinTamdidHejri() {
        return tarikhAkharinTamdidHejri;
    }

    public void setTarikhAkharinTamdidHejri(String tarikhAkharinTamdidHejri) {
        this.tarikhAkharinTamdidHejri = tarikhAkharinTamdidHejri;
    }
	/**
	 * @return
	 */
	public java.lang.Integer getIsLast() {
		return isLast;
	}

	/**
	 * @param integer
	 */
	public void setIsLast(java.lang.Integer integer) {
		isLast = integer;
	}

}
