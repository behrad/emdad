package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.PeigiriEzamgarSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.PeigiriEzamgarModel;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class PeigiriEzamgarForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return PeigiriEzamgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.PeigiriEzamgarModel";
    }

      protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){

        if (HejriUtil.isValidDate((String)(get("zamanPeigiri"))))
            set("zamanPeigiri", HejriUtil.hejriToChrisStr((String)get("zamanPeigiri")));
       //=-= System.out.println("mapping = " +HejriUtil.hejriToChrisStr((String)get("zamanPeigiri")));


      }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors)  throws Exception {

        PeigiriEzamgarModel vo = new PeigiriEzamgarModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        if (!Validators.chackValidateZaman((String)get("zamanPeigiri2")))
            errors.add("", new ActionError("emdad.zamanEzam.invalid"));//zamanPeigiri.invalid

        vo.setEmdadEmdadId((Integer)get("emdadEmdadId"));

        String emdadId = Validators.peigiriEzamgarValidator(c, vo, errors);
        set("emdadId", emdadId);
    }

}
