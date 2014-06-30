/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Jun 17, 2003
 * Time: 2:36:49 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;


public class RangeKhodroList extends com.objectj.emdad.ejb.RangeKhodroModel{
    private java.lang.String id;
    private java.lang.String onvan;
    private java.lang.String codeRangeKhodrosaz;
    private java.lang.Integer rangeKhodroId;
    private java.lang.Integer baseRange;
    private java.lang.String baseRangeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOnvan() {
        return onvan;
    }

    public void setOnvan(String onvan) {
        this.onvan = onvan;
    }

    public String getCodeRangeKhodrosaz() {
        return codeRangeKhodrosaz;
    }

    public void setCodeRangeKhodrosaz(String codeRangeKhodrosaz) {
        this.codeRangeKhodrosaz = codeRangeKhodrosaz;
    }

    public Integer getRangeKhodroId() {
        return rangeKhodroId;
    }

    public void setRangeKhodroId(Integer rangeKhodroId) {
        this.rangeKhodroId = rangeKhodroId;
    }

    public Integer getBaseRange() {
        return baseRange;
    }

    public void setBaseRange(Integer baseRange) {
        this.baseRange = baseRange;
    }

    public String getBaseRangeName() {
        return baseRangeName;
    }

    public void setBaseRangeName(String baseRangeName) {
        this.baseRangeName = baseRangeName;
    }
}
