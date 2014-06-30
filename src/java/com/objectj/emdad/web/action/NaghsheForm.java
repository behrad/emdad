package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.NaghsheSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionError;
import com.objectj.jsa.web.Exchanger;
import com.objectj.emdad.ejb.*;

import java.sql.Connection;

import org.apache.struts.action.ActionErrors;

public final class NaghsheForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NaghsheSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.NaghsheModel";
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception {
        NaghsheModel vo = new NaghsheModel();
        Exchanger.exhangeFormToValueObject(this, vo);
        String azArz = ((String) get("azArz")).trim();
        String azTool = ((String) get("azTool")).trim();
        String taArz = ((String) get("taArz")).trim();
        String taTool = ((String) get("taTool")).trim();
        if(azArz.indexOf(":")==-1 || azTool.indexOf(":")==-1 || taArz.indexOf(":")==-1 || taTool.indexOf(":")==-1){
            errors.add("soId", new ActionError("naghshe.ToolArz.error"));
        }
        else if(azArz.indexOf(":") == azArz.lastIndexOf(":") ||
                azTool.indexOf(":") == azTool.lastIndexOf(":") ||
                taArz.indexOf(":") == taArz.lastIndexOf(":") ||
                taTool.indexOf(":") == taTool.lastIndexOf(":")){
            errors.add("soId", new ActionError("naghshe.ToolArz.error"));
        }
        try{
            int hr = Integer.parseInt(azArz.substring(0,azArz.indexOf(":")));
            int min = Integer.parseInt(azArz.substring(azArz.indexOf(":")+1,azArz.lastIndexOf(":")));
            int sec = Integer.parseInt(azArz.substring(azArz.lastIndexOf(":")+1));
            if(hr>89 || min>59 || sec>59)
                errors.add("soId", new ActionError("naghshe.ToolArz.error"));
            else
                set("azArzeGoegraphy",new Integer(((hr*60) + min) * 60 + sec));

            hr = Integer.parseInt(taArz.substring(0,taArz.indexOf(":")));
            min = Integer.parseInt(taArz.substring(taArz.indexOf(":")+1,taArz.lastIndexOf(":")));
            sec = Integer.parseInt(taArz.substring(taArz.lastIndexOf(":")+1));
            if(hr>89 || min>59 || sec>59)
                errors.add("soId", new ActionError("naghshe.ToolArz.error"));
            else
                set("taArzeGoegraphy",new Integer(((hr*60) + min) * 60 + sec));

            hr = Integer.parseInt(taTool.substring(0,taTool.indexOf(":")));
            min = Integer.parseInt(taTool.substring(taTool.indexOf(":")+1,taTool.lastIndexOf(":")));
            sec = Integer.parseInt(taTool.substring(taTool.lastIndexOf(":")+1));
            if(hr>179 || min>59 || sec>59)
                errors.add("soId", new ActionError("naghshe.ToolArz.error"));
            else
                set("taTooleGoegraphy",new Integer(((hr*60) + min) * 60 + sec));

            hr = Integer.parseInt(azTool.substring(0,azTool.indexOf(":")));
            min = Integer.parseInt(azTool.substring(azTool.indexOf(":")+1,azTool.lastIndexOf(":")));
            sec = Integer.parseInt(azTool.substring(azTool.lastIndexOf(":")+1));
            if(hr>179 || min>59 || sec>59)
                errors.add("soId", new ActionError("naghshe.ToolArz.error"));
            else
                set("azTooleGoegraphy",new Integer(((hr*60) + min) * 60 + sec));
        }catch (Exception e){
            errors.add("soId", new ActionError("naghshe.ToolArz.error"));
        }
    }
}
