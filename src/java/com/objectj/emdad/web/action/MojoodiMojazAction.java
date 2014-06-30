package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.proxy.*;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.web.util.Util;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/c/mojoodiMojaz"
 *      pathPrime="/mojoodiMojaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiMojaz.edit.jsp"
 *      inputPrime="emdad.mojoodiMojaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/r/mojoodiMojaz"
 *      pathPrime="/mojoodiMojaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiMojaz.read.jsp"
 *      inputPrime="emdad.mojoodiMojaz.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/u/mojoodiMojaz"
 *      pathPrime="/mojoodiMojaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiMojaz.edit.jsp"
 *      inputPrime="emdad.mojoodiMojaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/d/mojoodiMojaz"
 *      pathPrime="/mojoodiMojaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiMojaz.read.jsp"
 *      inputPrime="emdad.mojoodiMojaz.read"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/l/mojoodiMojaz"
 *      pathPrime="/mojoodiMojazList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/mojoodiMojaz.list.jsp"
 *      inputPrime="emdad.mojoodiMojaz.list"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/c/validatemojoodiMojaz"
 *      pathPrime="/validatemojoodiMojaz"
 *      scope="request"
 *      input="/c/mojoodiMojaz.run"
 *      inputPrime="emdad.mojoodiMojaz.edit"
 *      input4tiles="emdad.mojoodiMojaz.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterMojoodiMojazForm"
 *      path="/l/filtermojoodiMojaz"
 *      pathPrime="/filtermojoodiMojaz"
 *      scope="request"
 *      input="/l/mojoodiMojaz.run"
 *      inputPrime="emdad.mojoodiMojaz.edit"
 *      input4tiles="emdad.mojoodiMojaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="mojoodiMojazForm"
 *      path="/u/validatemojoodiMojaz"
 *      pathPrime="/validatemojoodiMojaz"
 *      scope="request"
 *      input="/u/mojoodiMojaz.run"
 *      inputPrime="emdad.mojoodiMojaz.edit"
 *      input4tiles="emdad.mojoodiMojaz.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.mojoodiMojaz.list"
 *      pathPrime="emdad.mojoodiMojaz.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.mojoodiMojaz.edit"
 *      pathPrime="emdad.mojoodiMojaz.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.mojoodiMojaz.read"
 *      pathPrime="emdad.mojoodiMojaz.read"
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

public class MojoodiMojazAction extends BaseAction {
    protected Class getValueObjectClass() {
        return MojoodiMojazModel.class;
    }

    protected Class getValueObjectClass2() {
        return MojoodiMojazList.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"noeEmdadgarId", "shomarehFanni", "qateName", "tedad"};
    }

    protected String[] getRelatedEntities() {
        return new String[] { "noeemdadgar", "qate" };
    }

    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                MojoodiMojazModel vo = new MojoodiMojazModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                String id = UserAccessEntity.stringQuery("select id from Qate where shomareFanni='"+ctx.getForm().get("shomarehFanni").toString()+"'", "id");
                ((MojoodiMojazProxy) getProxy()).create((ValueObject)vo, (String)ctx.getForm().get("noeEmdadgarId"), id);
//                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        ctx.getForm().set("qateId", "");
        ctx.getForm().set("noeEmdadgarId", "");
        return listAll(ctx);
    }

    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ArrayList noeEmdadgarList = null;
        ArrayList qateList = null;
        try {
            noeEmdadgarList = ComboPool.getCombo("noeEmdadgar");
            qateList = ComboPool.getCombo("qate");
        } catch (Exception e) {
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute("noeEmdadgarList", noeEmdadgarList);
        ctx.getRequest().setAttribute("qateList", qateList);
    }

    protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                MojoodiMojazModel vo = new MojoodiMojazModel();
                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                ((MojoodiMojazProxy) getProxy()).update(vo, ctx.getForm().get("noeEmdadgarId").toString(), ctx.getForm().get("qateId").toString());
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return MojoodiMojazSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
