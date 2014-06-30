package com.objectj.emdad.web.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.KasriEmdadSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class KasriEmdadForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KasriEmdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.KasriEmdadModel";
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        if (HejriUtil.isValidDate((String)(get("tarikh"))))
            this.set("tarikh", HejriUtil.hejriToChrisStr((String)get("tarikh")));
        request.setAttribute("tarikh", get("tarikh"));
    }
}
