package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.KhodrojagozinSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.KhodrojagozinModel;
import org.apache.struts.action.ActionErrors;

import java.sql.Connection;

public final class KhodrojagozinForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KhodrojagozinSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "khodrojagozinId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.KhodrojagozinModel";
    }
    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {
        KhodrojagozinModel vo = new KhodrojagozinModel();
        Exchanger.exhangeFormToValueObject(this, vo);

        Validators.khodroJagozinValidator(c, vo, errors);
    }

}
