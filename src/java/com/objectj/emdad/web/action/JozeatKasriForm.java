package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

public final class JozeatKasriForm extends BaseForm
{

    public JozeatKasriForm()
    {
    }

    protected EntityProxy getProxy()
        throws ProxyException
    {
        try
        {
            return JozeatKasriSessionUtil.getLocalHome().create();
        }
        catch(Exception e)
        {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName()
    {
        return "";
    }

    protected String getValueObjectClassName()
    {
        return "com.objectj.emdad.ejb.JozeatKasriModel";
    }
}
