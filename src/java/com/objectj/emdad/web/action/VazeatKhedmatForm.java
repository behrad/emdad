package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.VazeatKhedmatSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class VazeatKhedmatForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return VazeatKhedmatSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "vazeatKhedmatId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.VazeatKhedmatModel";
    }

}
