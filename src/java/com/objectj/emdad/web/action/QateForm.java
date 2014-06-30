package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.QateSessionUtil;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.QateModel;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionErrors;

import java.sql.Connection;

public final class QateForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return QateSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "qateId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.QateModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors)  throws Exception {
        QateModel vo = new QateModel();
        Exchanger.exhangeFormToValueObject(this, vo);

        Validators.qateValidator(c, vo, errors);
    }

}
