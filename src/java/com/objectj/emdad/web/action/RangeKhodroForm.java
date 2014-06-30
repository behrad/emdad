package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.RangeKhodroSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class RangeKhodroForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RangeKhodroSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected String getEntityIdName() {
        return "rangeKhodroId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.RangeKhodroModel";
    }

}
