package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NoeEmdadgarSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class NoeEmdadgarForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeEmdadgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "noeEmdadgarId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.NoeEmdadgarModel";
    }

}
