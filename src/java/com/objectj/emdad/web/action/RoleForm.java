package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.RoleSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class RoleForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RoleSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected String getEntityIdName() {
        return "roleId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.RoleModel";
    }

}
