package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.DarkhastTagheerSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class DarkhastTagheerForm extends BaseForm {

	protected EntityProxy getProxy() throws ProxyException {
		try {
			return DarkhastTagheerSessionUtil.getLocalHome().create();
		} catch (Exception e) {
			throw new ProxyException(e);
		}
	}

	protected String getEntityIdName() {
		return "";
	}

	protected String getValueObjectClassName() {
		return "com.objectj.emdad.ejb.DarkhastTagheerModel";
	}

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){
        set("shomarePelak", ((String)get("shomarePelak")).trim() + " "+ ((String)get("shomarePelak2")).trim());
    }

	protected void checkForSpecificValidations(Connection c, ActionErrors errors) {
		String tt = (String) (get("tarikhTavalod"));
		if ((tt != null) && (tt.length() > 0) && (tt.charAt(0) != '-')) {
			if (!HejriUtil.isValidDate((String) (get("tarikhTavalod"))))
				errors.add("aa", new ActionError("errors.date.tavalod.invalid"));
		}
	}
}
