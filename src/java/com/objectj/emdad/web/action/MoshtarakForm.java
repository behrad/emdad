
package com.objectj.emdad.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.MoshtarakSessionUtil;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;

import java.sql.Connection;

public final class MoshtarakForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MoshtarakSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.MoshtarakModel";
    }


    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){

        if (HejriUtil.isValidDate((String)(get("tarikhEnghezaGuarantee"))))
            set("tarikhEnghezaGuarantee", HejriUtil.hejriToChrisStr((String)get("tarikhEnghezaGuarantee")));
        request.setAttribute("tarikhEnghezaGuarantee", get("tarikhEnghezaGuarantee"));

        if (HejriUtil.isValidDate((String)(get("tarikhTavalod"))))
            set("tarikhTavalod", HejriUtil.hejriToChrisStr((String)get("tarikhTavalod")));
        request.setAttribute("tarikhTavalod", get("tarikhTavalod"));

        if (HejriUtil.isValidDate((String)(get("tarikhShoro"))))
            set("tarikhShoro", HejriUtil.hejriToChrisStr((String)get("tarikhShoro")));
        request.setAttribute("tarikhShoro", get("tarikhShoro"));

        if (HejriUtil.isValidDate((String)(get("tarikhAkharinTamdid"))))
            set("tarikhAkharinTamdid", HejriUtil.hejriToChrisStr((String)get("tarikhAkharinTamdid")));
        request.setAttribute("tarikhAkharinTamdid", get("tarikhAkharinTamdid"));

        if (HejriUtil.isValidDate((String)(get("tarikhEngheza"))))
            set("tarikhEngheza", HejriUtil.hejriToChrisStr((String)get("tarikhEngheza")));
        request.setAttribute("tarikhEngheza", get("tarikhEngheza"));

        if (HejriUtil.isValidDate((String)(get("tarikhTahvil"))))
            set("tarikhTahvil", HejriUtil.hejriToChrisStr((String)get("tarikhTahvil")));
        request.setAttribute("tarikhTahvil", get("tarikhTahvil"));

        if (HejriUtil.isValidDate((String)(get("tarikhServiceAvalieh"))))
            set("tarikhServiceAvalieh", HejriUtil.hejriToChrisStr((String)get("tarikhServiceAvalieh")));
        request.setAttribute("tarikhServiceAvalieh", get("tarikhServiceAvalieh"));

        set("shomarePelak", ((String)get("shomarePelak")).trim() + " "+ ((String)get("shomarePelak2")).trim());

    }


    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception {
        MoshtarakModel vo = new MoshtarakModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        if ((String)(get("tarikhTavalod")) != null && ((String)(get("tarikhTavalod"))).length() != 0)
            vo.setTarikhTavalod(HejriUtil.toDate((String)(get("tarikhTavalod"))));

        if ((String)(get("tarikhShoro")) != null && ((String)(get("tarikhShoro"))).length() != 0)
            vo.setTarikhShoro(HejriUtil.toDate(((String)(get("tarikhShoro")))));

        if ((String)(get("tarikhAkharinTamdid")) != null && ((String)(get("tarikhAkharinTamdid"))).length() != 0)
            vo.setTarikhAkharinTamdid(HejriUtil.toDate(((String)(get("tarikhAkharinTamdid")))));

        if ((String)(get("tarikhEngheza")) != null && ((String)(get("tarikhEngheza"))).length() != 0)
            vo.setTarikhEngheza(HejriUtil.toDate(((String)(get("tarikhEngheza")))));

        if ((String)(get("tarikhEnghezaGuarantee")) != null && ((String)(get("tarikhEnghezaGuarantee"))).length() != 0)
            vo.setTarikhEnghezaGuarantee(HejriUtil.toDate(((String)(get("tarikhEnghezaGuarantee")))));

        if ((String)(get("tarikhServiceAvalieh")) != null && ((String)(get("tarikhServiceAvalieh"))).length() != 0)
            vo.setTarikhServiceAvalieh(HejriUtil.toDate(((String)(get("tarikhServiceAvalieh")))));

        if ((String)(get("tarikhTahvil")) != null && ((String)(get("tarikhTahvil"))).length() != 0)
            vo.setTarikhTahvil(HejriUtil.toDate(((String)(get("tarikhTahvil")))));

        if (vo.getNoeService().intValue() == 1){
            int vj = UserAccessEntity.intQuery("SELECT vijeh FROM noeKhodro where id='" + (String) get("noeKhodroId") + "' " , "vijeh" , c);
            if (vj != 1)
                errors.add("aa", new ActionError("service.vijeh.invalid"));
//            NoeKhodroLocal nl = null;
//                nl = NoeKhodroUtil.getLocalHome().findByPrimaryKey((String) get("noeKhodroId"));
//            NoeKhodroModel nm = nl.getNoeKhodroModel();
//            if (nm.getVijeh().intValue() == 2)
//                errors.add("aa", new ActionError("service.vijeh.invalid"));
        }

        Validators.moshtarakValidator(c, vo, errors);
    }
}
