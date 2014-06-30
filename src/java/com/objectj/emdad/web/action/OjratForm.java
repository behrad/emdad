package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.OjratSessionUtil;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.sql.Connection;

public final class OjratForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return OjratSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.OjratModel";
    }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors) {
        java.lang.String entityId = (String)get("ojratId");
        java.lang.String id = (String)get("id");
        //=-= System.out.println("entityId = " + entityId);
        String count = null;
        if (entityId != null && entityId.length() != 0) {
            count = UserAccessEntity.stringQuery("SELECT COUNT(ojratId) AS count FROM ojrat WHERE ojratId = '" + entityId + "' AND id <> '" + id + "'", "count");
            if (!count.equals("0")){
                errors.add("entityId",new ActionError("errors.entityid.already.exists"));
            }
        }

        if (entityId != null && entityId.length() != 0) {
            count = UserAccessEntity.stringQuery("SELECT COUNT(iradId) AS count FROM irad WHERE iradId LIKE '" + entityId.substring(0, 2) + "%'", "count");
            if (count.equals("0")){
                errors.add("entityId",new ActionError("ojrat.no.iradId.matches"));
            }
        }
    }
}
