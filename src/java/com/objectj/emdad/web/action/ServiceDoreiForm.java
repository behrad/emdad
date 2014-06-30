package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.ServiceDoreiSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class ServiceDoreiForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return ServiceDoreiSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.ServiceDoreiModel";
    }

    protected void checkForSpecificValidations(Connection connection, ActionErrors errors) throws Exception {
        String moshtarakId = (String)get( "eshterakId" );
        String eshterakId = UserAccessEntity.stringQuery( "SELECT id FROM moshtarak WHERE eshterakId = '" + moshtarakId + "'", "id" );
        if( eshterakId.length() == 0 ) {
            errors.add( "moshtarakInvalid", new ActionError( "errors.eshterakId.doesnt.exists" ) );
        }
        //Integer kilometer = vo.getKilometerKarkard();
        //String id = UserAccessEntity.stringQuery( "select id from serviceDorei where eshterakId='" + eshterakId + "' AND noeServiceDorei='" +  vo.getNoeServiceDorei() + "'", "id" );
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        set("tarikh", HejriUtil.hejriToChrisStr((String)get("tarikh")));
    }

    protected void postfixSpecificValidations(ActionErrors errors,  HttpServletRequest request){
        set("tarikh", HejriUtil.chrisToHejri(((String)get("tarikh"))));
    }
}
