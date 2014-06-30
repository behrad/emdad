package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;

/**
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/c/bazaryab"
 *      pathPrime="/bazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryab.edit.jsp"
 *      inputPrime="emdad.bazaryab.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/r/bazaryab"
 *      pathPrime="/bazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryab.read.jsp"
 *      inputPrime="emdad.bazaryab.read"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/u/bazaryab"
 *      pathPrime="/bazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryab.edit.jsp"
 *      inputPrime="emdad.bazaryab.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/d/bazaryab"
 *      pathPrime="/bazaryab"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryab.read.jsp"
 *      inputPrime="emdad.bazaryab.read"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/l/bazaryab"
 *      pathPrime="/bazaryabList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryab.list.jsp"
 *      inputPrime="emdad.bazaryab.list"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/c/validatebazaryab"
 *      pathPrime="/validatebazaryab"
 *      scope="request"
 *      input="/c/bazaryab.run"
 *      inputPrime="emdad.bazaryab.edit"
 *      input4tiles="emdad.bazaryab.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="bazaryabForm"
 *      path="/u/validatebazaryab"
 *      pathPrime="/validatebazaryab"
 *      scope="request"
 *      input="/u/bazaryab.run"
 *      inputPrime="emdad.bazaryab.edit"
 *      input4tiles="emdad.bazaryab.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.bazaryab.list"
 *      pathPrime="emdad.bazaryab.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.bazaryab.edit"
 *      pathPrime="emdad.bazaryab.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.bazaryab.read"
 *      pathPrime="emdad.bazaryab.read"
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
 *
 */

public class BazaryabAction extends BaseAction {
    public static final int emdadgar = 1;
    public static final int post = 2;
    public static final int khodrosaz = 3;
    public static final int daftarOstani = 4;
    public static final int namayandegi = 5;
    public static final int motefareghe = 6;
    public static final int karmand = 7;

    protected Class getValueObjectClass() {
        return BazaryabModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"bazaryabId", "noeBazaryabId", "bazaryabKey"};
    }

    protected String[] getRelatedEntities() {
        return new String[] {"noeBazaryab"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return BazaryabSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }


    protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        if (!isCancelled(ctx.getRequest())) {
            try {
                BazaryabModel vo = new BazaryabModel();

                Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
                vo.setBazaryabKey(null);
                ((BazaryabProxy) getProxy()).create(vo, ctx.getForm().get("noeBazaryabId").toString());
                ComboPool.setDirty(ctx.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                throw new ProxyException(e);
            }
        }
        return listAll(ctx);
    }


	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
		if (!isCancelled(ctx.getRequest())) {
			try {
				BazaryabModel vo = new BazaryabModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);
				((BazaryabProxy) getProxy()).update(vo, ctx.getForm().get("noeBazaryabId").toString());
                ComboPool.setDirty(ctx.getEntity());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		return listAll(ctx);
	}


    protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String) ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);
        try {
            com.objectj.emdad.proxy.BazaryabSessionLocalHome lhProxy = com.objectj.emdad.proxy.BazaryabSessionUtil.getLocalHome();
            com.objectj.emdad.proxy.BazaryabSessionLocal lProxy = lhProxy.create();
            ValueObject voBazaryabList = lProxy.read(id);
            ctx.getRequest().setAttribute(VALUE_OBJECT, voBazaryabList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProxyException(e);
        }
        return ctx.getActionMapping().findForward("read");
    }

    protected ActionForward doEditById(BaseActionContext ctx) throws ProxyException, ServletException {
        String id = (String)ctx.getForm().get(ValueObject.ID);
        if (id == null)
            throw new ServletException(NULL_ID_MESSAGE);

        ValueObject valueObject = getProxy().read(id);
        Exchanger.exhangeValueObjectToForm(valueObject, ctx.getForm());
        NoeBazaryabModel nbm = null;
        try {
            nbm = (NoeBazaryabModel)NoeBazaryabSessionUtil.getLocalHome().create().read((String)ctx.getForm().get("noeBazaryabId"));
        }
        catch (Exception e) {

        }
        ctx.getRequest().setAttribute("noeBazaryabOnvan", nbm.getOnvan());
        ctx.getRequest().setAttribute(FORM, ctx.getForm());
        ctx.getRequest().setAttribute("bazaryabNameList", getBazaryabNameList(nbm.getEntity().intValue()));
        ctx.getForm().set(ACTION_TYPE, "update");
        return ctx.getActionMapping().findForward("edit");
    }


    protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {
        ctx.getRequest().setAttribute("entityList", com.objectj.emdad.web.util.Util.getArrayList("entityList"));
        ArrayList noeBazaryabList = null;
        try {
            noeBazaryabList = ComboPool.getCombo("noeBazaryab"); //NoeBazaryabSessionUtil.getLocalHome().create().readCombo("noeBazaryab","onvan").getResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }
        ctx.getRequest().setAttribute("noeBazaryabList", noeBazaryabList);
    }


    public ArrayList getBazaryabNameList(int noeBazaryabEntity) {
        ArrayList bazaryabNameList = new ArrayList();
        try {
            switch (noeBazaryabEntity)
            {
                case BazaryabAction.emdadgar:
                    bazaryabNameList = ComboPool.getCombo("emdadgar"); // EmdadgarSessionUtil.getLocalHome().create().readCombo("emdadgar", "name").getResult();
                    break;

//                case BazaryabAction.post:
//                    break;

                case BazaryabAction.khodrosaz:
                    bazaryabNameList = ComboPool.getCombo("khodrosaz"); //KhodrosazSessionUtil.getLocalHome().create().readCombo("khodrosaz", "name").getResult();
                    break;

                case BazaryabAction.daftarOstani:
                    bazaryabNameList = ComboPool.getCombo("daftarOstani"); //DaftarOstaniSessionUtil.getLocalHome().create().readCombo("daftarOstani","name").getResult();
                    break;

                case BazaryabAction.namayandegi:
                    bazaryabNameList = ComboPool.getCombo("namayandegi"); //NamayandegiSessionUtil.getLocalHome().create().readCombo("namayandegi","name+ ' , ' + LTRIM(namayandegiId)").getResult();
                    break;

                case BazaryabAction.post:
                case BazaryabAction.karmand:
                case BazaryabAction.motefareghe:
                    bazaryabNameList = ComboPool.getCombo("bazaryabMotefareghe"); //NamayandegiSessionUtil.getLocalHome().create().readCombo("namayandegi","name+ ' , ' + LTRIM(namayandegiId)").getResult();
                    break;

                default:
                    log.info ("Unknown noeBazaryab");
            }
        }
        catch (Exception e) {
        }
        //bazaryabNameList.add(0,new ComboObject("", ADD_TO_COMBO_LIST));
        return bazaryabNameList;
    }

}
