package com.objectj.emdad.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NamayandegiSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class NamayandegiForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NamayandegiSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

//        return ProxyFactory.getNamayandegiSessionProxy();
    }

    protected String getEntityIdName() {
        return "namayandegiId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.NamayandegiModel";
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        if (HejriUtil.isValidDate((String)(get("tarikhTahvil"))))
            this.set("tarikhTahvil", HejriUtil.hejriToChrisStr((String)get("tarikhTahvil")));
        request.setAttribute("tarikhTahvil", get("tarikhTahvil"));

        if (HejriUtil.isValidDate((String)(get("tarikhAkharinEstelam"))))
            this.set("tarikhAkharinEstelam", HejriUtil.hejriToChrisStr((String)get("tarikhAkharinEstelam")));
        request.setAttribute("tarikhAkharinEstelam", get("tarikhAkharinEstelam"));

        if (HejriUtil.isValidDate((String)(get("tarikhGharardad"))))
            this.set("tarikhGharardad", HejriUtil.hejriToChrisStr((String)get("tarikhGharardad")));
        request.setAttribute("tarikhGharardad", get("tarikhGharardad"));
    }


}

