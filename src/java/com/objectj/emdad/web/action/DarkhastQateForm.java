package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.DarkhastQateSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.EmdadUtil;
import com.objectj.emdad.ejb.DarkhastQateModel;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;

public final class DarkhastQateForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DarkhastQateSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "darkhastQateId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.DarkhastQateModel";
    }


    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        if (HejriUtil.isValidDate((String)(get("tarikhDarkhast"))))
            set("tarikhDarkhast", HejriUtil.hejriToChrisStr((String)get("tarikhDarkhast")));

    }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors)  throws Exception {
//        try{
            if (get("qateIdCode") != null){
                QueryObject qo = new QueryObject();
                qo.setFromIndex(0);
                qo.setToIndex(2);
                qo.setTables("qate");
                qo.setJoined(false);
                qo.setWhere(" qateId = " + get("qateIdCode"));
                ResultSet rs = EmdadUtil.getLocalHome().advanceRead(c, qo);
                if (!rs.next())
                    errors.add("qateId", new ActionError("errors.qate.doesnot.exist", get("qateIdCode")));
                else
                    set("qateId", rs.getString("id"));

                rs.close();
            }
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }


        DarkhastQateModel vo = new DarkhastQateModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        if ((String)(get("tarikhDarkhast")) != null && ((String)(get("tarikhDarkhast"))).length() != 0)
            vo.setTarikhDarkhast(HejriUtil.toDate((String)(get("tarikhDarkhast"))));
        Validators.darkhastQateValidator(vo, errors);

    }
}
