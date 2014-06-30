package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.DalileToolKeshidaneEmdadSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class DalileToolKeshidaneEmdadForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DalileToolKeshidaneEmdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "dalileToolKeshidaneEmdadId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.DalileToolKeshidaneEmdadModel";
    }

}