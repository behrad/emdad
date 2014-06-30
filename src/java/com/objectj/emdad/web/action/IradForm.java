package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.IradSessionUtil;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import java.sql.Connection;

public final class IradForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return IradSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.IradModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) {
        java.lang.String entityId = (String)get("iradId");
        java.lang.String id = (String)get("id");
        //=-= System.out.println("entityId = " + entityId);
        String count = null;
        if (entityId != null && entityId.length() != 0) {
           count = UserAccessEntity.stringQuery("SELECT COUNT(iradId) AS count FROM irad WHERE iradId = '" + entityId + "' AND id <> '" + id + "'", "count");
           if (!count.equals("0")){
               errors.add("entityId",new ActionError("errors.entityid.already.exists"));
           }
        }

        if (get(com.objectj.jsa.web.action.BaseAction.ACTION_TYPE).equals("update")) {
            String newIradId = (String) get("iradId");
            String oldIradId = UserAccessEntity.stringQuery("SELECT iradId from irad WHERE id = '" + (String) get("id") + "'", "iradId");
            if (relatedEntityExists ((String) get("id")) && !oldIradId.substring(0,2).equals(newIradId.substring(0,2)))
                errors.add("iradId",new ActionError("irad.iradId.unchangeable"));
        }
    }

    boolean relatedEntityExists (String id) {
        String iradId, ojratId, otherIradId;
        iradId = UserAccessEntity.stringQuery("SELECT iradId from irad WHERE id = '" + id + "'", "iradId");
        ojratId = UserAccessEntity.stringQuery("SELECT ojratId from ojrat WHERE ojratId LIKE '" + iradId.substring(0,2) + "%'", "ojratId");
        if (ojratId != null && ojratId.length() != 0) {
            otherIradId = UserAccessEntity.stringQuery("SELECT iradId from irad WHERE iradId LIKE '" + iradId.substring(0,2) + "%' AND iradId <> '" + iradId + "'", "iradId");
            if (otherIradId != null && otherIradId.length() != 0)
                return false;

            return true;
        }
        else
            return false;
    }

}
