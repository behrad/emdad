package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.OstanSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class OstanForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return OstanSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected String getEntityIdName() {
        return "ostanId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.OstanModel";
    }

}
