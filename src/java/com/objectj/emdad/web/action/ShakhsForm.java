package com.objectj.emdad.web.action;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.ShakhsSessionLocal;
import com.objectj.emdad.proxy.ShakhsSessionLocalHome;
import com.objectj.emdad.proxy.ShakhsSessionUtil;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;

import java.sql.Connection;

public final class ShakhsForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return ShakhsSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "shakhsId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.ShakhsModel";
    }

	protected void checkForSpecificValidations(Connection c, ActionErrors errors)  throws Exception {
//        try {
            ShakhsModel vo = new ShakhsModel();
            Exchanger.exhangeFormToValueObject(this, vo);

            String username = (String)this.get("username");
            String password = (String)this.get("password");
            String repassword = (String)this.get("repassword");

            if (!password.equals(repassword)){
                errors.add("aa", new ActionError("errors.password.nomatch"));
            }else{
                if (password.equals("========")){
                    // password is not set
                    ShakhsSessionLocalHome shakhsSessionLocalHome = ShakhsSessionUtil.getLocalHome();
                    ShakhsSessionLocal shakhsSessionLocal = shakhsSessionLocalHome.create();
                    ValueObject voShakhsList = shakhsSessionLocal.read((String)this.get("id"));
                    password = ((ShakhsModel)voShakhsList).getPassword();
                    this.set("password",password);
                }

                if ((username != null && !username.equals("")) && (password == null || password.equals(""))){
                    errors.add("aa", new ActionError("errors.password.empty"));
                }
            }

            int naghshId = vo.getNaghshId().intValue();
            try {
                if(naghshId == Constants.getNamayandegiShoghlId()) {
                    NamayandegiLocal namayandegiLocal = NamayandegiUtil.getLocalHome().findByPrimaryKey((String)this.get("namayandegiId"));
                }
                else if (naghshId == Constants.getEmdadgarEstekhdamiShoghlId() || naghshId == Constants.getEmdadgarPeymaniShoghlId()) {
                    EmdadgarLocal emdadgarLocal = EmdadgarUtil.getLocalHome().findByPrimaryKey((String)this.get("emdadgarId"));
                }
            } catch (Exception e) {
                errors.add("entityId", new ActionError("shakhs.entityId.required"));
            }

            if (get("action_type") == null  || ((String)get("action_type")).length() == 0 || ((String)get("action_type")).equals("create"))
                Validators.shakhsValidator(c, vo, errors);

//        } catch (NamingException e) {
//            e.printStackTrace();
//        } catch (CreateException e) {
//            e.printStackTrace();
//        } catch (ProxyException e) {
//            e.printStackTrace();
//        }
	}

}
