package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.DaftarOstaniModel;
import com.objectj.emdad.proxy.*;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;

/**
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/c/daftarOstani"
 *      pathPrime="/daftarOstani"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/daftarOstani.edit.jsp"
 *      inputPrime="emdad.daftarOstani.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/r/daftarOstani"
 *      pathPrime="/daftarOstani"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/daftarOstani.read.jsp"
 *      inputPrime="emdad.daftarOstani.read"
 *      validate="false"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/u/daftarOstani"
 *      pathPrime="/daftarOstani"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/daftarOstani.edit.jsp"
 *      inputPrime="emdad.daftarOstani.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/d/daftarOstani"
 *      pathPrime="/daftarOstani"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/daftarOstani.read.jsp"
 *      inputPrime="emdad.daftarOstani.read"
 *      validate="false"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/l/daftarOstani"
 *      pathPrime="/daftarOstaniList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/daftarOstani.list.jsp"
 *      inputPrime="emdad.daftarOstani.list"
 *      validate="false"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/c/validatedaftarOstani"
 *      pathPrime="/validatedaftarOstani"
 *      scope="request"
 *      input="/c/daftarOstani.run"
 *      inputPrime="emdad.daftarOstani.edit"
 *      input4tiles="emdad.daftarOstani.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="daftarOstaniForm"
 *      path="/u/validatedaftarOstani"
 *      pathPrime="/validatedaftarOstani"
 *      scope="request"
 *      input="/u/daftarOstani.run"
 *      inputPrime="emdad.daftarOstani.edit"
 *      input4tiles="emdad.daftarOstani.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.daftarOstani.list"
 *      pathPrime="emdad.daftarOstani.list"
 *      redirect="true"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.daftarOstani.edit"
 *      pathPrime="emdad.daftarOstani.edit"
 *      redirect="true"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.daftarOstani.read"
 *      pathPrime="emdad.daftarOstani.read"
 *      redirect="true"
 *
 * @struts.action-forward
 *      name="thanks"
 *      path="/com/objectj/emdad/jsp/thanks.jsp"
 *      pathPrime="emdad.thanks"
 *      redirect="true"
 *
 * @struts.action-forward
 *      name="default"
 *      path="/util/genericPage.jsp"
 *      pathPrime="/util/genericPage.jsp"
 *      redirect="true"
 *
 * @struts.action-forward
 *      name="error"
 *      path="/util/errors.jsp"
 *      pathPrime="/util/errors.jsp"
 *      redirect="true"
 *
 */

public class DaftarOstaniAction extends BaseAction {
    protected Class getValueObjectClass() {
        return DaftarOstaniModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"daftarOstaniId", "name", "masool", "tel", "mobile", "address"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return DaftarOstaniSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}
