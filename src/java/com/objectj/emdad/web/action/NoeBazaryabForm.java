package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NoeBazaryabSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class NoeBazaryabForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeBazaryabSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected String getEntityIdName() {
        return "noeBazaryabId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.NoeBazaryabModel";
    }

}
