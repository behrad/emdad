package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.DalileToolKeshidaneEmdadModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/c/dalileToolKeshidaneEmdad"
 *      pathPrime="/dalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/dalileToolKeshidaneEmdad.edit.jsp"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/r/dalileToolKeshidaneEmdad"
 *      pathPrime="/dalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/dalileToolKeshidaneEmdad.read.jsp"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/u/dalileToolKeshidaneEmdad"
 *      pathPrime="/dalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/dalileToolKeshidaneEmdad.edit.jsp"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/d/dalileToolKeshidaneEmdad"
 *      pathPrime="/dalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/dalileToolKeshidaneEmdad.read.jsp"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.read"
 *      validate="false"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/l/dalileToolKeshidaneEmdad"
 *      pathPrime="/dalileToolKeshidaneEmdadList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/dalileToolKeshidaneEmdad.list.jsp"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.list"
 *      validate="false"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/c/validatedalileToolKeshidaneEmdad"
 *      pathPrime="/validatedalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/c/dalileToolKeshidaneEmdad.run"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.edit"
 *      input4tiles="emdad.dalileToolKeshidaneEmdad.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="dalileToolKeshidaneEmdadForm"
 *      path="/u/validatedalileToolKeshidaneEmdad"
 *      pathPrime="/validatedalileToolKeshidaneEmdad"
 *      scope="request"
 *      input="/u/dalileToolKeshidaneEmdad.run"
 *      inputPrime="emdad.dalileToolKeshidaneEmdad.edit"
 *      input4tiles="emdad.dalileToolKeshidaneEmdad.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.dalileToolKeshidaneEmdad.list"
 *      pathPrime="emdad.dalileToolKeshidaneEmdad.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.dalileToolKeshidaneEmdad.edit"
 *      pathPrime="emdad.dalileToolKeshidaneEmdad.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.dalileToolKeshidaneEmdad.read"
 *      pathPrime="emdad.dalileToolKeshidaneEmdad.read"
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

public class DalileToolKeshidaneEmdadAction extends BaseAction {
    protected Class getValueObjectClass() {
        return DalileToolKeshidaneEmdadModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"dalileToolKeshidaneEmdadId", "onvan"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DalileToolKeshidaneEmdadSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
