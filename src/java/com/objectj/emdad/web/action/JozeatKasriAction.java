package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.JozeatKasriModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.JozeatKasriList;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.model.ValueObject;
import org.apache.struts.action.ActionForward;

import java.rmi.RemoteException;


/**
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/c/jozeatKasri"
 *      pathPrime="/jozeatKasri"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/jozeatKasri.edit.jsp"
 *      inputPrime="emdad.jozeatKasri.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/r/jozeatKasri"
 *      pathPrime="/jozeatKasri"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/jozeatKasri.read.jsp"
 *      inputPrime="emdad.jozeatKasri.read"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/u/jozeatKasri"
 *      pathPrime="/jozeatKasri"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/jozeatKasri.edit.jsp"
 *      inputPrime="emdad.jozeatKasri.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/d/jozeatKasri"
 *      pathPrime="/jozeatKasri"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/jozeatKasri.read.jsp"
 *      inputPrime="emdad.jozeatKasri.read"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/l/jozeatKasri"
 *      pathPrime="/jozeatKasriList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/jozeatKasri.list.jsp"
 *      inputPrime="emdad.jozeatKasri.list"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/c/validatejozeatKasri"
 *      pathPrime="/validatejozeatKasri"
 *      scope="request"
 *      input="/c/jozeatKasri.run"
 *      inputPrime="emdad.jozeatKasri.edit"
 *      input4tiles="emdad.jozeatKasri.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterJozeatKasriForm"
 *      path="/l/filterjozeatKasri"
 *      pathPrime="/filterjozeatKasri"
 *      scope="request"
 *      input="/l/jozeatKasri.run"
 *      inputPrime="emdad.jozeatKasri.edit"
 *      input4tiles="emdad.jozeatKasri.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="jozeatKasriForm"
 *      path="/u/validatejozeatKasri"
 *      pathPrime="/validatejozeatKasri"
 *      scope="request"
 *      input="/u/jozeatKasri.run"
 *      inputPrime="emdad.jozeatKasri.edit"
 *      input4tiles="emdad.jozeatKasri.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.jozeatKasri.list"
 *      pathPrime="emdad.jozeatKasri.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.jozeatKasri.edit"
 *      pathPrime="emdad.jozeatKasri.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.jozeatKasri.read"
 *      pathPrime="emdad.jozeatKasri.read"
 *
 * @struts.action-forward
 *      name="thanks"
 *      path="/com/objectj/emdad/jsp/thanks.jsp"
 *      pathPrime="emdad.thanks"
 *
 * @struts.action-forward
 *      name="default"
 *      path="/util/genericPage.jsp"
 *      pathPrime="/util/genericPage.jsp"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 */

public class JozeatKasriAction extends BaseAction {
    protected Class getValueObjectClass() {
        return JozeatKasriModel.class;
    }

    protected Class getValueObjectClass2() {
        return JozeatKasriList.class;
    }

    protected String[] getSortableColumns()
    {
        return (new String[] {
            "kasriId", "emdadgarName", "shomareFanni", "qateName", "tedadKasri", "tedadAnbar", "tedadEmdadgar"
        });
    }

    protected String[] getRelatedEntities() {
        return new String[] {"kasriEmdad"};
    }

    protected ActionForward doCreate(BaseActionContext ctx)
        throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException
    {
        if(!isCancelled(ctx.getRequest()))
            try
            {
                JozeatKasriModel vo = new JozeatKasriModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                String id = UserAccessEntity.stringQuery("select id from Qate where shomareFanni='" + ctx.getForm().get("shomareFanni").toString() + "'", "id");
                ((JozeatKasriProxy)getProxy()).create((ValueObject)vo, (String)ctx.getForm().get("kasriId"), id);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        ctx.getForm().set("qateId", "");
        ctx.getForm().set("kasriId", "");
        return listAll(ctx);
    }

    protected ActionForward doUpdate(BaseActionContext ctx)
        throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException
    {
        if(!isCancelled(ctx.getRequest()))
            try
            {
                JozeatKasriModel vo = new JozeatKasriModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                String id = UserAccessEntity.stringQuery("select id from Qate where shomareFanni='" + ctx.getForm().get("shomareFanni").toString() + "'", "id");
                ((JozeatKasriProxy)getProxy()).update((ValueObject)vo, (String)ctx.getForm().get("kasriId"), id);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        return listAll(ctx);
    }

    protected void doSpecificAction(BaseActionContext ctx)
        throws ProxyException
    {
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return JozeatKasriSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
