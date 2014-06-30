package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.OstanModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/c/ostan"
 *      pathPrime="/ostan"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/ostan.edit.jsp"
 *      inputPrime="emdad.ostan.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/r/ostan"
 *      pathPrime="/ostan"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/ostan.read.jsp"
 *      inputPrime="emdad.ostan.read"
 *      validate="false"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/u/ostan"
 *      pathPrime="/ostan"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/ostan.edit.jsp"
 *      inputPrime="emdad.ostan.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/d/ostan"
 *      pathPrime="/ostan"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/ostan.read.jsp"
 *      inputPrime="emdad.ostan.read"
 *      validate="false"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/l/ostan"
 *      pathPrime="/ostanList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/ostan.list.jsp"
 *      inputPrime="emdad.ostan.list"
 *      validate="false"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/c/validateostan"
 *      pathPrime="/validateostan"
 *      scope="request"
 *      input="/c/ostan.run"
 *      inputPrime="emdad.ostan.edit"
 *      input4tiles="emdad.ostan.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="ostanForm"
 *      path="/u/validateostan"
 *      pathPrime="/validateostan"
 *      scope="request"
 *      input="/u/ostan.run"
 *      inputPrime="emdad.ostan.edit"
 *      input4tiles="emdad.ostan.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.ostan.list"
 *      pathPrime="emdad.ostan.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.ostan.edit"
 *      pathPrime="emdad.ostan.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.ostan.read"
 *      pathPrime="emdad.ostan.read"
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

public class OstanAction extends BaseAction {
    protected Class getValueObjectClass() {
        return OstanModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"ostanId", "name"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return OstanSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }
}
