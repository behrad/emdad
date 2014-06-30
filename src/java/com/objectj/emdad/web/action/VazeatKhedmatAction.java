package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.VazeatKhedmatModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/c/vazeatKhedmat"
 *      pathPrime="/vazeatKhedmat"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/vazeatKhedmat.edit.jsp"
 *      inputPrime="emdad.vazeatKhedmat.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/r/vazeatKhedmat"
 *      pathPrime="/vazeatKhedmat"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/vazeatKhedmat.read.jsp"
 *      inputPrime="emdad.vazeatKhedmat.read"
 *      validate="false"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/u/vazeatKhedmat"
 *      pathPrime="/vazeatKhedmat"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/vazeatKhedmat.edit.jsp"
 *      inputPrime="emdad.vazeatKhedmat.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/d/vazeatKhedmat"
 *      pathPrime="/vazeatKhedmat"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/vazeatKhedmat.read.jsp"
 *      inputPrime="emdad.vazeatKhedmat.read"
 *      validate="false"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/l/vazeatKhedmat"
 *      pathPrime="/vazeatKhedmatList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/vazeatKhedmat.list.jsp"
 *      inputPrime="emdad.vazeatKhedmat.list"
 *      validate="false"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/c/validatevazeatKhedmat"
 *      pathPrime="/validatevazeatKhedmat"
 *      scope="request"
 *      input="/c/vazeatKhedmat.run"
 *      inputPrime="emdad.vazeatKhedmat.edit"
 *      input4tiles="emdad.vazeatKhedmat.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="vazeatKhedmatForm"
 *      path="/u/validatevazeatKhedmat"
 *      pathPrime="/validatevazeatKhedmat"
 *      scope="request"
 *      input="/u/vazeatKhedmat.run"
 *      inputPrime="emdad.vazeatKhedmat.edit"
 *      input4tiles="emdad.vazeatKhedmat.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.vazeatKhedmat.list"
 *      pathPrime="emdad.vazeatKhedmat.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.vazeatKhedmat.edit"
 *      pathPrime="emdad.vazeatKhedmat.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.vazeatKhedmat.read"
 *      pathPrime="emdad.vazeatKhedmat.read"
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

public class VazeatKhedmatAction extends BaseAction {
    protected Class getValueObjectClass() {
        return VazeatKhedmatModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"vazeatKhedmatId", "onvan"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return VazeatKhedmatSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
