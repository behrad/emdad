package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.BazaryabMotefaregheModel;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.BazaryabMotefaregheSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;


/**
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/c/bazaryabMotefareghe"
 *      pathPrime="/bazaryabMotefareghe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryabMotefareghe.edit.jsp"
 *      inputPrime="emdad.bazaryabMotefareghe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/r/bazaryabMotefareghe"
 *      pathPrime="/bazaryabMotefareghe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryabMotefareghe.read.jsp"
 *      inputPrime="emdad.bazaryabMotefareghe.read"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/u/bazaryabMotefareghe"
 *      pathPrime="/bazaryabMotefareghe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryabMotefareghe.edit.jsp"
 *      inputPrime="emdad.bazaryabMotefareghe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/d/bazaryabMotefareghe"
 *      pathPrime="/bazaryabMotefareghe"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryabMotefareghe.read.jsp"
 *      inputPrime="emdad.bazaryabMotefareghe.read"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/l/bazaryabMotefareghe"
 *      pathPrime="/bazaryabMotefaregheList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/bazaryabMotefareghe.list.jsp"
 *      inputPrime="emdad.bazaryabMotefareghe.list"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/c/validatebazaryabMotefareghe"
 *      pathPrime="/validatebazaryabMotefareghe"
 *      scope="request"
 *      input="/c/bazaryabMotefareghe.run"
 *      inputPrime="emdad.bazaryabMotefareghe.edit"
 *      input4tiles="emdad.bazaryabMotefareghe.edit"
 *      validate="true"
 * 
 * @struts.action
 *      name="filterBazaryabMotefaregheForm"
 *      path="/l/filterbazaryabMotefareghe"
 *      pathPrime="/filterbazaryabMotefareghe"
 *      scope="request"
 *      input="/l/bazaryabMotefareghe.run"
 *      inputPrime="emdad.bazaryabMotefareghe.edit"
 *      input4tiles="emdad.bazaryabMotefareghe.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="bazaryabMotefaregheForm"
 *      path="/u/validatebazaryabMotefareghe"
 *      pathPrime="/validatebazaryabMotefareghe"
 *      scope="request"
 *      input="/u/bazaryabMotefareghe.run"
 *      inputPrime="emdad.bazaryabMotefareghe.edit"
 *      input4tiles="emdad.bazaryabMotefareghe.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.bazaryabMotefareghe.list"
 *      pathPrime="emdad.bazaryabMotefareghe.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.bazaryabMotefareghe.edit"
 *      pathPrime="emdad.bazaryabMotefareghe.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.bazaryabMotefareghe.read"
 *      pathPrime="emdad.bazaryabMotefareghe.read"
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

public class BazaryabMotefaregheAction extends BaseAction {
    protected Class getValueObjectClass() {
        return BazaryabMotefaregheModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"tel", "mobile", "address", "name"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return BazaryabMotefaregheSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
