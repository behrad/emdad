package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.TamdidEshterakSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class TamdidEshterakForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return TamdidEshterakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.TamdidEshterakModel";
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request) {
        if (HejriUtil.isValidDate((String)(get("tarikhAkharinTamdid"))))
            set("tarikhAkharinTamdid", HejriUtil.hejriToChrisStr((String)get("tarikhAkharinTamdid")));
        request.setAttribute("tarikhAkharinTamdid", get("tarikhAkharinTamdid"));
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception {
    if ((Integer)get("noeService")==null || ((Integer)get("noeService")).intValue()<1 )
        errors.add("aa",new ActionError("errors.required"));
    if (((Integer)get("hazinehPardakhtShodeh")).intValue()!=((Integer)get("naghd")).intValue()+((Integer)get("taahodi")).intValue()+((Integer)get("takhfif")).intValue()+((Integer)get("aghsat")).intValue())
        errors.add("aa",new ActionError("errors.sumnotequal"));
	}
}
