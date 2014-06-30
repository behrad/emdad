package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.EmdadgarSessionUtil;
import com.objectj.emdad.ejb.EmdadgarModel;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import com.objectj.jsa.web.Exchanger;

import java.sql.Connection;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public final class EmdadgarForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return EmdadgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "emdadgarId";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.EmdadgarModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception {
        EmdadgarModel vo = new EmdadgarModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        String azArz = ((String) get("azArze")).trim();
        String azTool = ((String) get("azToole")).trim();
        String taArz = ((String) get("taArze")).trim();
        String taTool = ((String) get("taToole")).trim();
        try{
            if (!azArz.equals(":  :") && com.objectj.emdad.ejb.util.Util.isNotEmpty(azArz)){
                if(azArz.indexOf(":") == -1 || azArz.indexOf(":") == azArz.lastIndexOf(":"))
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                System.out.println("azArz: "+azArz);
                int hr = Integer.parseInt(azArz.substring(0,azArz.indexOf(":")));
                int min = Integer.parseInt(azArz.substring(azArz.indexOf(":")+1,azArz.lastIndexOf(":")));
                int sec = Integer.parseInt(azArz.substring(azArz.lastIndexOf(":")+1));
                if(hr>89 || min>59 || sec>59)
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                else
                    set("azArz",new Integer(((hr*60) + min) * 60 + sec));
                System.out.println("azArz: hr,min,sec: "+hr+","+min+","+sec);
            }else
                set("azArz",null);

            if (!taArz.equals(":  :") && com.objectj.emdad.ejb.util.Util.isNotEmpty(taArz)){
                if(taArz.indexOf(":") == -1 || taArz.indexOf(":") == taArz.lastIndexOf(":"))
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                int hr = Integer.parseInt(taArz.substring(0,taArz.indexOf(":")));
                int min = Integer.parseInt(taArz.substring(taArz.indexOf(":")+1,taArz.lastIndexOf(":")));
                int sec = Integer.parseInt(taArz.substring(taArz.lastIndexOf(":")+1));
                if(hr>89 || min>59 || sec>59)
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                else
                    set("taArz",new Integer(((hr*60) + min) * 60 + sec));
            }else
                set("taArz",null);

            if (!taTool.equals(":  :") && com.objectj.emdad.ejb.util.Util.isNotEmpty(taTool)){
                if(taTool.indexOf(":") == -1 || taTool.indexOf(":") == taTool.lastIndexOf(":"))
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                int hr = Integer.parseInt(taTool.substring(0,taTool.indexOf(":")));
                int min = Integer.parseInt(taTool.substring(taTool.indexOf(":")+1,taTool.lastIndexOf(":")));
                int sec = Integer.parseInt(taTool.substring(taTool.lastIndexOf(":")+1));
                if(hr>179 || min>59 || sec>59)
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                else
                    set("taTool",new Integer(((hr*60) + min) * 60 + sec));
            }else
                set("taTool",null);

            if (!azTool.equals(":  :") && com.objectj.emdad.ejb.util.Util.isNotEmpty(azTool)){
                if(azTool.indexOf(":") == -1 || azTool.indexOf(":") == azTool.lastIndexOf(":"))
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                int hr = Integer.parseInt(azTool.substring(0,azTool.indexOf(":")));
                int min = Integer.parseInt(azTool.substring(azTool.indexOf(":")+1,azTool.lastIndexOf(":")));
                int sec = Integer.parseInt(azTool.substring(azTool.lastIndexOf(":")+1));
                if(hr>179 || min>59 || sec>59)
                    errors.add("soId", new ActionError("naghshe.ToolArz.error"));
                else
                    set("azTool",new Integer(((hr*60) + min) * 60 + sec));
            }else
                set("azTool",null);

        }catch (Exception e){
            errors.add("soId", new ActionError("naghshe.ToolArz.error"));
        }
    }
}
