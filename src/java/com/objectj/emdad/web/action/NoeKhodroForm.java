package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NoeKhodroSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class NoeKhodroForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeKhodroSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "noeKhodroId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.NoeKhodroModel";
    }

}
