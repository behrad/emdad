package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.RokhdadSessionUtil;
import com.objectj.emdad.proxy.DaftarOstaniSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.web.util.Validators;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;

public final class RokhdadForm extends BaseForm {

    HttpServletRequest request = null;

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RokhdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.RokhdadModel";
    }

    protected void prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request) {
        this.request = request;
        UserSession us = (UserSession) request.getSession().getAttribute("user_session");
        String userName = us.getName();
        ////=-= System.out.println ("============================= User Name: " + userName);
        request.setAttribute("userName", userName);

        String daftarOstaniId = us.getDaftarOstani();
//        DaftarOstaniModel daftarOstaniModel = null;

        if (HejriUtil.isValidDate((String) (get("tarikhFaalShodan"))))
            set("tarikhFaalShodan", HejriUtil.hejriToChrisStr((String) get("tarikhFaalShodan")));

        if (HejriUtil.isValidDate((String) (get("zamaneVaghei"))))
            set("zamaneVaghei", HejriUtil.hejriToChrisStr((String) get("zamaneVaghei")));

//        try {
//            daftarOstaniModel = (DaftarOstaniModel) DaftarOstaniSessionUtil.getLocalHome().create().read(daftarOstaniId);
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
        request.setAttribute("daftarOstaniName", ComboPool.findInCombo("daftarOstani", daftarOstaniId));

    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception {
        RokhdadModel vo = new RokhdadModel();
//        System.out.println("---00"+get("khadamateVijeh"));
        Exchanger.exhangeFormToValueObject(this, vo);
//        System.out.println("---11"+vo.getKhadamateVijeh());
        Validators.rokhdadValidator(vo, (String) this.get("eshterakId"), (String) this.get("shahrId"), errors);

        Integer hr = (Integer) get("hasrepl");
        Iterator it = errors.get("repl");
        if (hr != null && hr.intValue() == 1) {
            if (it != null) {
                int i = 0;
                try {
                    while (it != null && it.next() != null) i++;
                } catch (Exception e) {
                }
                if (errors.size() <= i)
                    errors.clear();
            }
        } else {
            if (it != null) {
                set("hasrepl", new Integer(1));
                request.setAttribute("hasrepl", new Integer(1));
            }
        }
//        System.out.println("---it="+it+", hasrepl="+((Integer)get("hasrepl")).intValue());
//        try{
//            String count = UserAccessEntity.stringQuery("SELECT COUNT(eshterakId) as count FROM moshtarak WHERE eshterakId = '" + (String) this.get("eshterakId") + "'", "count");
//            if (Integer.parseInt(count) < 1) {
//                errors.add("soId", new ActionError("rokhdad.nonexistent.moshtarak", get("eshterakId")));
//                return;
//            }
//            QueryObject qo = new QueryObject();
//            String moshtarakId = UserAccessEntity.stringQuery("SELECT id  FROM moshtarak WHERE eshterakId = '" + get("eshterakId") + "'", "id");
//            qo = new QueryObject();
//            qo.setFromIndex(0);
//            qo.setToIndex(2);
//            qo.setTables("rokhdad");
//            qo.setJoined(false);
//            qo.setSelectFields("id");
//            qo.setWhere("moshtarakId='" + moshtarakId + "' AND eghdamShodeh=2");
//
//            Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
//            ResultSet rs = RokhdadUtil.getLocalHome().advanceRead(c, qo);
//            if (rs.next()) {
//                String s = rs.getString("id");
//                if (rs.next() || (!s.equals(vo.getId())))
//                    errors.add("soId", new ActionError("rokhdad.notcompleted.exist"));
//           }
//
//            qo = new QueryObject();
//            qo.setFromIndex(0);
//            qo.setToIndex(2);
//            qo.setTables("emdadList");
//            qo.setJoined(false);
//            qo.setSelectFields("id");
//
//            qo.setWhere("emdadList.moshtarakId='" + moshtarakId +"' AND emdadList.vazeatKonuni <> 2 ");
//            rs = RokhdadUtil.getLocalHome().advanceRead(c, qo);
//            if (rs.next()) {
//                String s = rs.getString("id");
//                if (rs.next() || (!s.equals(vo.getId())))
//                    errors.add("soId", new ActionError("emdad.notcompleted.exist"));
//           }
//           rs.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
