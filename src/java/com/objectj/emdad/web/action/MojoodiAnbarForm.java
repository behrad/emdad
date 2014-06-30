package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.MojoodiAnbarSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.ejb.EmdadUtil;
import com.objectj.emdad.ejb.MojoodiAnbarList;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import java.sql.Connection;
import java.sql.ResultSet;

public final class MojoodiAnbarForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MojoodiAnbarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.MojoodiAnbarModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {
//        try{
//            if (get("shomareFanni") != null) {
                String qId = UserAccessEntity.stringQuery("select id from qate where shomareFanni='"+get("shomareFanni")+"'","id",c);
//                System.out.println("shomareFanni="+get("shomareFanni")+",qId="+qId);
                if (Util.isEmpty(qId))
                    errors.add("qateId", new ActionError("errors.qate.doesnot.exist", get("shomareFanni")));
                else
                    set("qateId", qId);
//            }

//            String qateId = (String)get("qateId");
//            java.lang.String id = (String)get("id");
//            String count;
//            if (qateId != null && qateId.length() != 0) {
//               count = UserAccessEntity.stringQuery("SELECT COUNT(qateId) AS count FROM mojoodiAnbar WHERE qateId = '" + qateId + "' AND id <> '" + id + "'", "count");
//               if (!count.equals("0")){
//                   errors.add("qateIdExists",new ActionError("mojoodiAnbar.qateid.already.exists"));
//               }
//            }

            MojoodiAnbarList vo = new MojoodiAnbarList();
            Exchanger.exhangeFormToValueObject(this, vo);
            vo.setAnbarId(new Integer(1));
            Validators.mojoodiAnbarValidator(c, vo, errors);
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }
    }

}
