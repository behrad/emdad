package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.BazaryabSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class BazaryabForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return BazaryabSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "bazaryabId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.BazaryabModel";
    }

}
