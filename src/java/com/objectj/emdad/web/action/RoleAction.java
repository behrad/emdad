package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.RoleModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="roleForm"
 *      path="/c/role"
 *      pathPrime="/role"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/role.edit.jsp"
 *      inputPrime="emdad.role.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/r/role"
 *      pathPrime="/role"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/role.read.jsp"
 *      inputPrime="emdad.role.read"
 *      validate="false"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/u/role"
 *      pathPrime="/role"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/role.edit.jsp"
 *      inputPrime="emdad.role.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/d/role"
 *      pathPrime="/role"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/role.read.jsp"
 *      inputPrime="emdad.role.read"
 *      validate="false"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/l/role"
 *      pathPrime="/roleList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/role.list.jsp"
 *      inputPrime="emdad.role.list"
 *      validate="false"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/c/validaterole"
 *      pathPrime="/validaterole"
 *      scope="request"
 *      input="/c/role.run"
 *      inputPrime="emdad.role.edit"
 *      input4tiles="emdad.role.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="roleForm"
 *      path="/u/validaterole"
 *      pathPrime="/validaterole"
 *      scope="request"
 *      input="/u/role.run"
 *      inputPrime="emdad.role.edit"
 *      input4tiles="emdad.role.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.role.list"
 *      pathPrime="emdad.role.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.role.edit"
 *      pathPrime="emdad.role.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.role.read"
 *      pathPrime="emdad.role.read"
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

public class RoleAction extends BaseAction {
    protected Class getValueObjectClass() {
        return RoleModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"role", "entity", "access"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return RoleSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }

    }
}
