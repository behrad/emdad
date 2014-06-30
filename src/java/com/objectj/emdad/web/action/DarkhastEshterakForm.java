package com.objectj.emdad.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.objectj.emdad.ejb.DarkhastEshterakModel;
import com.objectj.emdad.proxy.DarkhastEshterakSessionUtil;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;

import java.sql.Connection;

public final class DarkhastEshterakForm extends BaseForm {


    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DarkhastEshterakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.DarkhastEshterakModel";
    }



    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        if (HejriUtil.isValidDate((String)(get("tarikhEnghezaGarantee"))))
            set("tarikhEnghezaGarantee", HejriUtil.hejriToChrisStr((String)get("tarikhEnghezaGarantee")));
        if (HejriUtil.isValidDate((String)(get("tarikhFish"))))
            set("tarikhFish", HejriUtil.hejriToChrisStr((String)get("tarikhFish")));
        if (HejriUtil.isValidDate((String)(get("tarikhTavalod"))))
            set("tarikhTavalod", HejriUtil.hejriToChrisStr((String)get("tarikhTavalod")));

        set("shomarePelak", ((String)get("shomarePelak")).trim() + " "+ ((String)get("shomarePelak2")).trim());
    }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {
        DarkhastEshterakModel vo = new DarkhastEshterakModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        if ((String)(get("tarikhTavalod")) != null && ((String)(get("tarikhTavalod"))).length() != 0)
            vo.setTarikhTavalod(HejriUtil.toDate((String)(get("tarikhTavalod"))));
        if ((String)(get("tarikhFish")) != null && ((String)(get("tarikhFish"))).length() != 0)
            vo.setTarikhFish(HejriUtil.toDate(((String)(get("tarikhFish")))));
        if ((String)(get("tarikhEnghezaGarantee")) != null && ((String)(get("tarikhEnghezaGarantee"))).length() != 0)
            vo.setTarikhEnghezaGarantee(HejriUtil.toDate(((String)(get("tarikhEnghezaGarantee")))));
        Validators.darkhastEshterakValidator(vo, errors);
    }
}
