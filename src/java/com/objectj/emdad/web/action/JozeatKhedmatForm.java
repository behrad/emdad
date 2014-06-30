package com.objectj.emdad.web.action;

import java.util.ArrayList;
import java.sql.Connection;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.objectj.emdad.ejb.EmdadModel;
import com.objectj.emdad.ejb.JozeatKhedmatModel;
import com.objectj.emdad.ejb.OjratModel;
import com.objectj.emdad.ejb.QateModel;
import com.objectj.emdad.proxy.EmdadSessionUtil;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.JozeatKhedmatSessionUtil;
import com.objectj.emdad.proxy.OjratSessionUtil;
import com.objectj.emdad.proxy.QateSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;

public final class JozeatKhedmatForm extends BaseForm {

	protected EntityProxy getProxy() throws ProxyException {
		try {
			return JozeatKhedmatSessionUtil.getLocalHome().create();
		} catch (Exception e) {
			throw new ProxyException(e);
		}
	}

	protected String getEntityIdName() {
		return "";
	}

	protected String getValueObjectClassName() {
		return "com.objectj.emdad.ejb.JozeatKhedmatModel";
	}

	protected void checkForSpecificValidations(Connection c, ActionErrors errors) {
        String errorMessage = "errors.hazenehDefault.invalid";
		try {
			JozeatKhedmatModel vo = new JozeatKhedmatModel();
			Exchanger.exhangeFormToValueObject(this, vo);

			int hazinehDefault = 0;
			boolean isValid = false;

            String iradIdCode = (String)this.get("iradIdCode");
            String ojratId = (String) this.get("ojratId");
			Integer qateIdCode = (Integer)this.get("qateIdCode");
			Integer tedadQate = (Integer)this.get("tedadQate");

//			if (tedadQate.intValue() > 20 )
//				errors.add("aa", new ActionError("errors.tedadQate.invalid"));

            String iradId = Util.getIdWithO(c, "com.objectj.emdad.ejb.IradModel", iradIdCode, "irad", "iradId");
            //=-= System.out.println("========== iradId = " + iradId);
            if (iradId != null && iradId.length() != 0)
                this.set("iradId", iradId);
            else
                errors.add("iradId.invalid", new ActionError("jozeatKhedmat.iradId.invalid"));

			String khedmatId = setKhedmatId(new Integer(0), (Integer)this.get("dastorkar"), errors);
			this.set("khedmatId", khedmatId);

			if ((qateIdCode != null) && (qateIdCode.intValue() != 0)) {
				QueryObject qateQuery = new QueryObject();
				qateQuery.setTables("qate ");
				qateQuery.setWhere("qateId = " + qateIdCode);
				qateQuery.setJoined(false);
				ArrayList qateArray = (QateSessionUtil.getLocalHome().create().readModel(qateQuery).getResult());
				QateModel qateModel = new QateModel();
				if (!qateArray.isEmpty()) {
					qateModel = (QateModel)qateArray.get(0);
					this.set("qateId", qateModel.getId());
					hazinehDefault = qateModel.getGheimat().intValue() * tedadQate.intValue();
					isValid = true;
				} else {
					errors.add("aa", new ActionError("errors.qateId.invalid"));
				}
			}
            if (get("noeTasvieh") != null && get("noeTasvieh").equals("jarsaghil"))
                errorMessage = "errors.required.ojratId";

			if ((ojratId != null) && (ojratId.length() != 0)) {
				QueryObject ojratQuery = new QueryObject();
				ojratQuery.setTables("ojrat ");
				ojratQuery.setWhere("id = '" + ojratId + "'");
				ojratQuery.setJoined(false);
				ArrayList ojratArray = (OjratSessionUtil.getLocalHome().create().readModel(ojratQuery).getResult());
				OjratModel ojratModel = new OjratModel();
				if (!ojratArray.isEmpty()) {
					ojratModel = (OjratModel)ojratArray.get(0);
					//this.set("ojratId", ojratModel.getId());
					hazinehDefault += ojratModel.getOjrat().intValue();
					isValid = true;
				} else {
					errors.add("aa", new ActionError("errors.ojratId.invalid"));
				}
			}

			if (isValid) {
				this.set("hazinehDefault",new Integer(hazinehDefault));
			} else {
				errors.add("aa", new ActionError(errorMessage));
			}

		} catch (ProxyException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
	}

	private String setKhedmatId(Integer noeKhedmat, Integer dastorkar,ActionErrors errors) {
		switch (noeKhedmat.intValue()) {
			case 0 :
				// TODO: there is a need to add other relatted entities here
			default :
				QueryObject emdadQuery = new QueryObject();
				emdadQuery.setTables("emdad");
				emdadQuery.setWhere("emdadId = " + dastorkar);
				emdadQuery.setJoined(false);
				try {
					ArrayList emdadArray = EmdadSessionUtil.getLocalHome().create().readModel(emdadQuery).getResult();
					if (!emdadArray.isEmpty()) {
						EmdadModel emdadModel = (EmdadModel)emdadArray.get(0);
						return emdadModel.getId();
					} else {
						errors.add("aa", new ActionError("errors.khedmatId.invalid"));
					}
				} catch (ProxyException e) {
					e.printStackTrace();
				} catch (CreateException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
