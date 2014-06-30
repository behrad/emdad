package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.MostanadatRokhdadSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.MostanadatRokhdadModel;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class MostanadatRokhdadForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MostanadatRokhdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "mostanadatRokhdadId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.MostanadatRokhdadModel";
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){

        if (HejriUtil.isValidDate((String)get("tarikhSanad")))
            set("tarikhSanad", HejriUtil.hejriToChrisStr((String)get("tarikhSanad")));
        request.setAttribute("tarikhSanad", get("tarikhSanad"));
         if (HejriUtil.isValidDate((String)get("tarikhSabt")))
            set("tarikhSabt", HejriUtil.hejriToChrisStr((String)get("tarikhSabt")));
        request.setAttribute("tarikhSabt", get("tarikhSabt"));

    }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {
        MostanadatRokhdadModel vo = new MostanadatRokhdadModel();

        Exchanger.exhangeFormToValueObject(this, vo);
        vo.setRokhdadRokhdadId(new Integer((String)get("rokhdadRokhdadId")));
        if ((String)(get("tarikhSanad")) != null && ((String)(get("tarikhSanad"))).length() != 0)
            vo.setTarikhSanad(HejriUtil.toDate((String)(get("tarikhSanad"))));
         if ((String)(get("tarikhSabt")) != null && ((String)(get("tarikhSabt"))).length() != 0)
            vo.setTarikhSabt(HejriUtil.toDate((String)(get("tarikhSabt"))));
        String rokhdadId = Validators.mostanadatRokhdadValidator(c, vo, errors);
        set("rokhdadId", rokhdadId);
    }

}
