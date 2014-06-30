package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.KhodrosazModel;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.KhodrosazSessionUtil;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseAction;


/**
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/c/khodrosaz"
 *      pathPrime="/khodrosaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrosaz.edit.jsp"
 *      inputPrime="emdad.khodrosaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/r/khodrosaz"
 *      pathPrime="/khodrosaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrosaz.read.jsp"
 *      inputPrime="emdad.khodrosaz.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/u/khodrosaz"
 *      pathPrime="/khodrosaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrosaz.edit.jsp"
 *      inputPrime="emdad.khodrosaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/d/khodrosaz"
 *      pathPrime="/khodrosaz"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrosaz.read.jsp"
 *      inputPrime="emdad.khodrosaz.read"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/l/khodrosaz"
 *      pathPrime="/khodrosazList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/khodrosaz.list.jsp"
 *      inputPrime="emdad.khodrosaz.list"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/c/validatekhodrosaz"
 *      pathPrime="/validatekhodrosaz"
 *      scope="request"
 *      input="/c/khodrosaz.run"
 *      inputPrime="emdad.khodrosaz.edit"
 *      input4tiles="emdad.khodrosaz.edit"
 *      validate="true"
 *
 * @struts.action
 *      name="filterKhodrosazForm"
 *      path="/l/filterkhodrosaz"
 *      pathPrime="/filterkhodrosaz"
 *      scope="request"
 *      input="/l/khodrosaz.run"
 *      inputPrime="emdad.khodrosaz.edit"
 *      input4tiles="emdad.khodrosaz.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="khodrosazForm"
 *      path="/u/validatekhodrosaz"
 *      pathPrime="/validatekhodrosaz"
 *      scope="request"
 *      input="/u/khodrosaz.run"
 *      inputPrime="emdad.khodrosaz.edit"
 *      input4tiles="emdad.khodrosaz.edit"
 *      validate="true"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.khodrosaz.list"
 *      pathPrime="emdad.khodrosaz.list"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.khodrosaz.edit"
 *      pathPrime="emdad.khodrosaz.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.khodrosaz.read"
 *      pathPrime="emdad.khodrosaz.read"
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

public class KhodrosazAction extends BaseAction {
    protected Class getValueObjectClass() {
        return KhodrosazModel.class;
    }

    protected String[] getSortableColumns() {
        return new String[]{"khodrosazId", "name"};
    }

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KhodrosazSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }
}

