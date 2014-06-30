package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.NoeEmdadgarModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/c/noeEmdadgar"
 *      pathPrime="/noeEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeEmdadgar.edit.jsp"
 *      inputPrime="emdad.noeEmdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/r/noeEmdadgar"
 *      pathPrime="/noeEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeEmdadgar.read.jsp"
 *      inputPrime="emdad.noeEmdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/u/noeEmdadgar"
 *      pathPrime="/noeEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeEmdadgar.edit.jsp"
 *      inputPrime="emdad.noeEmdadgar.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/d/noeEmdadgar"
 *      pathPrime="/noeEmdadgar"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeEmdadgar.read.jsp"
 *      inputPrime="emdad.noeEmdadgar.read"
 *      validate="false"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/l/noeEmdadgar"
 *      pathPrime="/noeEmdadgarList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/noeEmdadgar.list.jsp"
 *      inputPrime="emdad.noeEmdadgar.list"
 *      validate="false"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/c/validatenoeEmdadgar"
 *      pathPrime="/validatenoeEmdadgar"
 *      scope="request"
 *      input="/c/noeEmdadgar.run"
 *      inputPrime="emdad.noeEmdadgar.edit"
 *      input4tiles="emdad.noeEmdadgar.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="noeEmdadgarForm"
 *      path="/u/validatenoeEmdadgar"
 *      pathPrime="/validatenoeEmdadgar"
 *      scope="request"
 *      input="/u/noeEmdadgar.run"
 *      inputPrime="emdad.noeEmdadgar.edit"
 *      input4tiles="emdad.noeEmdadgar.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.noeEmdadgar.list"
 *      pathPrime="emdad.noeEmdadgar.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.noeEmdadgar.edit"
 *      pathPrime="emdad.noeEmdadgar.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.noeEmdadgar.read"
 *      pathPrime="emdad.noeEmdadgar.read"
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

public class NoeEmdadgarAction extends BaseAction {
    protected Class getValueObjectClass() {
        return NoeEmdadgarModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"noeEmdadgarId", "onvan"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return NoeEmdadgarSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
