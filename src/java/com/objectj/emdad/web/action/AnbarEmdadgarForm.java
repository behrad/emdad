package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.AnbarEmdadgarSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.AnbarEmdadgarList;
import com.objectj.emdad.ejb.EmdadUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;


public final class AnbarEmdadgarForm extends BaseForm {

	protected EntityProxy getProxy() throws ProxyException {
		try {
			return AnbarEmdadgarSessionUtil.getLocalHome().create();
		} catch (Exception e) {
			throw new ProxyException(e);
		}
	}

	protected String getEntityIdName() {
		return "";
	}

	protected String getValueObjectClassName() {
		return "com.objectj.emdad.ejb.AnbarEmdadgarModel";
	}


	protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {

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
            AnbarEmdadgarList vo = new AnbarEmdadgarList();
            Exchanger.exhangeFormToValueObject(this, vo);
            String result = Validators.anbarEmdadgarValidator(c, vo, errors);
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }
	}
}
