package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.MojoodiMojazSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.ejb.EmdadUtil;
import com.objectj.emdad.ejb.MojoodiMojazList;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import java.sql.Connection;
import java.sql.ResultSet;

public final class MojoodiMojazForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MojoodiMojazSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.MojoodiMojazModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {

//        try{
            if (get("shomarehFanni") != null){
//                QueryObject qo = new QueryObject();
//                qo.setFromIndex(0);
//                qo.setToIndex(2);
//                qo.setTables("qate");
//                qo.setJoined(false);
//                qo.setWhere(" shomareFanni = '" + get("shomarehFanni") + "'");
                String[] az = UserAccessEntity.stringQuerys("select id,shomareFanni from qate where shomareFanni='" + get("shomarehFanni") + "'", "id,shomareFanni", c);
//                ResultSet rs = EmdadUtil.getLocalHome().advanceRead(c, qo);
                if (az!=null && az.length==0 || com.objectj.emdad.ejb.util.Util.isEmpty(az[0]))
                    errors.add("qateId", new ActionError("errors.qate.doesnot.exist", get("shomarehFanni")));
                else {
                    set("qateId", az[0]);
//                    qo.setTables("MojoodiMojaz");
//                    qo.setJoined(false);
//                    qo.setWhere(" qateId = '" + rs.getString("id") + "' And noeEmdadgarId = '" + get("noeEmdadgarId") + "'");
                    String s = UserAccessEntity.stringQueryRepl("select id from MojoodiMojaz where qateId = '" + az[0] + "' And noeEmdadgarId = '" + get("noeEmdadgarId") + "'", "id", c);
//                    rs = EmdadUtil.getLocalHome().advanceRead(c, qo);
                    if (s==null)
                        errors.add("qateId", new ActionError("errors.mojoodiMojaz.duplicated", get("shomarehFanni")));
                    else
                        if (s.length()>0 && get(com.objectj.jsa.web.action.BaseAction.ACTION_TYPE).equals("create"))
                            errors.add("qateId", new ActionError("errors.mojoodiMojaz.duplicated", get("shomarehFanni")));
//                        String id = rs.getString("id");
//                        if(rs.next())
//                            errors.add("qateId", new ActionError("errors.mojoodiMojaz.duplicated", get("shomarehFanni")));
//                        else if(!( get("id").equals(id) ))
//                        else if (get(com.objectj.jsa.web.action.BaseAction.ACTION_TYPE).equals("create"))
//                            errors.add("qateId", new ActionError("errors.mojoodiMojaz.duplicated", get("shomarehFanni")));
//                    }
                }
//                rs.close();
            }
//            MojoodiMojazList vo = new MojoodiMojazList();
//            Exchanger.exhangeFormToValueObject(this, vo);
//            String result = Validators.anbarEmdadgarValidator(c, vo, errors);
//        }catch(Exception e){
//            e.printStackTrace(System.out);
//        }
    }
}
