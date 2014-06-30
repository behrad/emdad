package com.objectj.emdad.web.action;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.ComboPool;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.DarkhastTagheerProxy;

import com.objectj.emdad.proxy.DarkhastTagheerSessionLocal;
import com.objectj.emdad.proxy.DarkhastTagheerSessionLocalHome;
import com.objectj.emdad.proxy.DarkhastTagheerSessionUtil;
import com.objectj.emdad.proxy.MoshtarakProxy;
import com.objectj.emdad.proxy.MoshtarakSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.RangeKhodroSessionUtil;
import com.objectj.emdad.proxy.ShahrSessionUtil;
import com.objectj.emdad.web.util.Util;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.action.BaseActionContext;
/**
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/c/darkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastTagheer.edit.jsp"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/r/darkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastTagheer.read.jsp"
 *      inputPrime="emdad.darkhastTagheer.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/u/darkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastTagheer.edit.jsp"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/d/darkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastTagheer.read.jsp"
 *      inputPrime="emdad.darkhastTagheer.read"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/l/darkhastTagheer"
 *      pathPrime="/darkhastTagheerList"
 *      scope="request"
 *      input="/com/objectj/emdad/jsp/darkhastTagheer.list.jsp"
 *      inputPrime="emdad.darkhastTagheer.list"
 *      validate="false"
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/c/validatedarkhastTagheer"
 *      pathPrime="/validatedarkhastTagheer"
 *      scope="request"
 *      input="/c/darkhastTagheer.run"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      input4tiles="emdad.darkhastTagheer.edit"
 *      validate="true"
 *
 *    @struts.action
 *      name="darkhastTagheerForm"
 *      path="/s/validatedarkhastTagheer"
 *      pathPrime="/validatedarkhastTagheer"
 *      scope="request"
 *      input="/s/darkhastTagheer.run"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      input4tiles="emdad.darkhastTagheer.edit"
 *      validate="false"
 *
 *    @struts.action
 *      name="darkhastTagheerForm"
 *      path="/s/darkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/s/darkhastTagheer.run"
 *      inputPrime="emdad.darkhastTagheer.request"
 *      input4tiles="emdad.darkhastTagheer.request"
 *      validate="false"
 *
 *
 * @struts.action
 *      name="darkhastTagheerForm"
 *      path="/u/validatedarkhastTagheer"
 *      pathPrime="/validatedarkhastTagheer"
 *      scope="request"
 *      input="/u/darkhastTagheer.run"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      input4tiles="emdad.darkhastTagheer.edit"
 *      validate="true"
 *
 *    @struts.action
 *      name="darkhastTagheerForm"
 *      path="/s/moshtariDarkhastTagheer"
 *      pathPrime="/darkhastTagheer"
 *      scope="request"
 *      input="/s/moshtariDarkhastTagheer.run"
 *      inputPrime="emdad.darkhastTagheer.edit"
 *      input4tiles="emdad.darkhastTagheer.edit"
 *      validate="false"
 *
 * @struts.action-forward
 *      name="request"
 *      path="emdad.darkhastTagheer.request"
 *      pathPrime="emdad.darkhastTagheer.request"
 *
 * @struts.action-forward
 *      name="list"
 *      path="emdad.darkhastTagheer.list"
 *      pathPrime="emdad.darkhastTagheer.list"
 *
 * @struts.action-forward
 *      name="create"
 *      path="emdad.darkhastTagheer.create"
 *      pathPrime="emdad.darkhastTagheer.create"
 *
 * @struts.action-forward
 *      name="moshtariCreate"
 *      path="emdad.darkhastTagheer.moshtari.create"
 *      pathPrime="emdad.darkhastTagheer.moshtari.create"
 *
 * @struts.action-forward
 *      name="edit"
 *      path="emdad.darkhastTagheer.edit"
 *      pathPrime="emdad.darkhastTagheer.edit"
 *
 * @struts.action-forward
 *      name="read"
 *      path="emdad.darkhastTagheer.read"
 *      pathPrime="emdad.darkhastTagheer.read"
 * @struts.action-forward
 *      name="thanks"
 *      path="emdad.darkhastTagheer.thanks"
 *      pathPrime="emdad.darkhastTagheer.thanks"
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
 * @struts.action-forward
 *      name="rokhdadCreate"
 *      path="/com/objectj/emdad/jsp/darkhastTagheer.rokhdad.create.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/darkhastTagheer.rokhdad.create.jsp"
 *
 * @struts.action-forward
 *      name="darkhastTagheerConfirm"
 *      path="/com/objectj/emdad/jsp/darkhastTagheer.confirm.jsp"
 *      pathPrime="/com/objectj/emdad/jsp/darkhastTagheer.confirm.jsp"
 *
 */

public class DarkhastTagheerAction extends BaseAction {

	// this variables are nessary to access moshtarak entity ( resultSetToList() )
    //String forceFilter, forceForwardTo;
	ArrayList noeEshterakList = new ArrayList();
	ArrayList vazeatList = new ArrayList();
	ArrayList guaranteeList = new ArrayList();

	protected Class getValueObjectClass() {
		return DarkhastTagheerModel.class;
	}

	protected String[] getSortableColumns() {
		return new String[] { "eshterakId", "ijadKonandeh", "noeService", "nameKhanevadegi", "name", "shomarePelak" };
	}

	ArrayList noeServiceList = new ArrayList();

	protected String[] getRelatedEntities() {
		//return new String[] { "rangeKhodro", "moshtarak", "shahr" };
		return new String[] { "moshtarak" };
	}

	protected EntityProxy getProxy() throws ProxyException {
		try {
			return DarkhastTagheerSessionUtil.getLocalHome().create();
		} catch (Exception e) {
			throw new ProxyException(e);
		}
	}

	protected void doSpecificAction(BaseActionContext ctx) throws ProxyException {

		ArrayList shahrList = new ArrayList();
		ArrayList rangeKhodroList = new ArrayList();


		try {
            ctx.getRequest().setAttribute("shomarePelak.title1", Util.getProperty("shomarePelak.title1"));
            ctx.getRequest().setAttribute("shomarePelak.title2", Util.getProperty("shomarePelak.title2"));
            ctx.getRequest().setAttribute("samplePelak1.1", Util.getProperty("shomarePelak.sample.1.1"));
            ctx.getRequest().setAttribute("samplePelak1.2", Util.getProperty("shomarePelak.sample.1.2"));
            ctx.getRequest().setAttribute("samplePelak2.1", Util.getProperty("shomarePelak.sample.2.1"));
            ctx.getRequest().setAttribute("samplePelak2.2", Util.getProperty("shomarePelak.sample.2.2"));
			shahrList = ComboPool.getCombo("shahr");
			rangeKhodroList = ComboPool.getCombo("rangeKhodro");
		} catch (Exception e) {
			e.printStackTrace(System.out);
			throw new ProxyException(e);
		}

		noeServiceList = Util.getArrayList("noeService");

		noeServiceList = Util.getArrayList("noeService");
		noeEshterakList = Util.getArrayList("noeEshterak");
		guaranteeList = Util.getArrayList("yesNo");
		vazeatList = Util.getArrayList("vazeat");

		ctx.getRequest().setAttribute("shahrList", shahrList);
		ctx.getRequest().setAttribute("rangeKhodroList", rangeKhodroList);

		ctx.getRequest().setAttribute("noeServiceList", noeServiceList);
	}

    protected ActionForward doNullAction(BaseActionContext ctx) {
        log.info("oomad to NullAction");
        ValueObject vo = newValueObject();
        Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());
        ctx.getForm().set(ID, "");
        ctx.getForm().set(ACTION_TYPE, "create");
        return ctx.getActionMapping().findForward("create");
    }

	protected ActionForward doCreate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, RemoteException {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ oomad to doCreate");
        if (isCancelled(ctx.getRequest()))
            return ctx.getActionMapping().findForward(ctx.getHomeForward());

        try {
            ActionErrors error = new ActionErrors();
            DarkhastTagheerModel vo = new DarkhastTagheerModel();
            Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

            String eshterakId = (String)ctx.getForm().get("eshterakId");
            vo.setIjadKonandeh(ctx.getUserSession().getRoleFarsi());

            QueryObject moshtarakQuery = new QueryObject();
            moshtarakQuery.setTables("moshtarak ");
            moshtarakQuery.setToIndex(2);
            moshtarakQuery.setWhere("eshterakId = '" + eshterakId + "'");
            moshtarakQuery.setJoined(false);            
            ArrayList moshtarakArray = (MoshtarakSessionUtil.getLocalHome().create().readModel(moshtarakQuery).getResult());
            MoshtarakModel moshtarakModel = new MoshtarakModel();
            if (!moshtarakArray.isEmpty()) {
                moshtarakModel = (MoshtarakModel)moshtarakArray.get(0);
            } else {
                error.add("a", new ActionError("errors.eshterakId.doesnt.exists"));
                ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
                return ctx.getActionMapping().findForward(ctx.getHomeForward());
            }

            String shahrId = new String((String)ctx.getForm().get("shahrId"));
            String rangeKhodroId = new String((String)ctx.getForm().get("rangeKhodroId"));

            DarkhastTagheerModel darkhastTagheerModel = (DarkhastTagheerModel)((DarkhastTagheerProxy)getProxy()).create(vo, moshtarakModel.getId(), shahrId, rangeKhodroId);

            //----------  Seeting ctx.getRequest() parameters for darkhastTagheer.confirm.jsp ------------------
            //DarkhastTagheerModel darkhastTagheerModel = (DarkhastTagheerModel) ((DarkhastTagheerProxy) getProxy()).create(vo, (String) (ctx.getForm().get("moshtarakId")), (String) (ctx.getForm().get("shahrId")), (String) (ctx.getForm().get("rangeKhodroId")));
            DarkhastTagheerSessionLocal darkhastTagheerProxy = null;
            try {
                darkhastTagheerProxy = DarkhastTagheerSessionUtil.getLocalHome().create();
            } catch (CreateException e) {
                e.printStackTrace();
            } catch (NamingException e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            DarkhastTagheerList darkhastTagheerList = (DarkhastTagheerList)darkhastTagheerProxy.read(darkhastTagheerModel.getId());
            ctx.getRequest().setAttribute(VALUE_OBJECT+"1", darkhastTagheerList);
            //--------------------------------------------------------------------------------------------

        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new ProxyException(e);
        }
		return ctx.getActionMapping().findForward("thanks");
	}

	protected ActionForward doReadById(BaseActionContext ctx) throws ProxyException, ServletException {
		String id = (String)ctx.getForm().get(ValueObject.ID);
		if (id == null)
			throw new ServletException(NULL_ID_MESSAGE);
		try {
			DarkhastTagheerSessionLocalHome lhProxy = DarkhastTagheerSessionUtil.getLocalHome();
			DarkhastTagheerSessionLocal lProxy = lhProxy.create();
			ValueObject voDarkhastTagheerList = lProxy.read(id);

			ctx.getRequest().setAttribute(VALUE_OBJECT, voDarkhastTagheerList);
			ctx.getRequest().setAttribute("noeService", ((ComboObject)noeServiceList.get(((DarkhastTagheerModel)voDarkhastTagheerList).getNoeService().intValue())).getName());

			DarkhastTagheerList darkhastTagheerList = new DarkhastTagheerList();

			String eshterakId = ((DarkhastTagheerModel)voDarkhastTagheerList).getEshterakId();

			QueryObject moshtarakQuery = new QueryObject();
			moshtarakQuery.setTables("moshtarak ");
			moshtarakQuery.setToIndex(2);
			moshtarakQuery.setWhere("eshterakId = '" + eshterakId + "'");
			moshtarakQuery.setJoined(false);
			ArrayList moshtarakArray = (MoshtarakSessionUtil.getLocalHome().create().readModel(moshtarakQuery).getResult());
			MoshtarakModel moshtarakModel = new MoshtarakModel();

			if (!moshtarakArray.isEmpty()) {
				moshtarakModel = (MoshtarakModel)moshtarakArray.get(0);
			} else {
				throw new ProxyException();
			}

 			MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakModel.getId());
  			MoshtarakModel moshtarak = moshtarakLocal.getMoshtarakModel();
  
			darkhastTagheerList.setAddress_old(moshtarak.getAddress());
			darkhastTagheerList.setNoeService_old(moshtarak.getNoeService());
			darkhastTagheerList.setNameKhanevadegi_old(moshtarak.getNameKhanevadegi());
			darkhastTagheerList.setName_old(moshtarak.getName());
			darkhastTagheerList.setTarikhTavalod_old(moshtarak.getTarikhTavalod());
			darkhastTagheerList.setAddress_old(moshtarak.getAddress());
			darkhastTagheerList.setPostCode_old(moshtarak.getPostCode());
			darkhastTagheerList.setEmail_old(moshtarak.getEmail());
			darkhastTagheerList.setTel_old(moshtarak.getTel());
			darkhastTagheerList.setMobile_old(moshtarak.getMobile());
			darkhastTagheerList.setShomarePelak_old(moshtarak.getShomarePelak());

			ShahrLocal shahrLocal = moshtarakLocal.getShahr();
			// check for a valid relationship reference
			if (shahrLocal != null) {
				ShahrModel shahrModel = shahrLocal.getShahrModel();
				darkhastTagheerList.setShahrId_old(shahrModel.getId());
				darkhastTagheerList.setShahrName_old(shahrModel.getShahrName());
			}

			RangeKhodroLocal rangeKhodroLocal = moshtarakLocal.getRangeKhodro();
			// check for a valid relationship reference
			if (rangeKhodroLocal != null) {
				RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
				darkhastTagheerList.setRangeKhodroId_old(rangeKhodroModel.getId());
				darkhastTagheerList.setRangeKhodroOnvan_old(rangeKhodroModel.getOnvan());
			}

//			int noeService = resultSet.getInt("noeService");
			darkhastTagheerList.setNoeServiceName_old(((ComboObject)com.objectj.emdad.ejb.util.Util.getFromArrayList("noeService", moshtarak.getNoeService())).getName());


//			darkhastTagheerList.setNoeServiceName_old(moshtarak.getNoeServiceName());
			
//			darkhastTagheerList.setRangeKhodroId_old(moshtarak.getRangeKhodroId());
//			darkhastTagheerList.setRangeKhodroOnvan_old(moshtarak.getRangeKhodroOnvan());
//			darkhastTagheerList.setShahrId_old(moshtarak.getShahrId());
//			darkhastTagheerList.setShahrName_old(moshtarak.getShahrName());

			ctx.getRequest().setAttribute(VALUE_OBJECT + "_old", darkhastTagheerList);
			log.info("darkhastTagheerList=" + darkhastTagheerList);

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
		ValueObject vo = getProxy().read(id);

		Exchanger.exhangeValueObjectToForm(vo, ctx.getForm());

        String s = (String)ctx.getForm().get("shomarePelak");
        if (s != null && s.length() != 0) {
            if (s.indexOf(" ") > 0) {
                ctx.getForm().set("shomarePelak", s.substring(0, s.indexOf(" ")));
                ctx.getForm().set("shomarePelak2", s.substring(s.indexOf(" ")));
            } else
                ctx.getForm().set("shomarePelak", s);
        }

		ctx.getRequest().setAttribute(FORM, ctx.getForm());
		ctx.getForm().set(ACTION_TYPE, "update");
		return ctx.getActionMapping().findForward("edit");
	}

	protected ActionForward doUpdate(BaseActionContext ctx) throws ProxyException, IllegalAccessException, InstantiationException, ClassNotFoundException, java.rmi.RemoteException {
		try {
			if (!isCancelled(ctx.getRequest())) {
				DarkhastTagheerModel vo = new DarkhastTagheerModel();
				Exchanger.exhangeFormToValueObject(ctx.getForm(), vo);

				((DarkhastTagheerProxy)getProxy()).update(vo, ctx.getForm().get("moshtarakId").toString(), ctx.getForm().get("shahrId").toString(), ctx.getForm().get("rangeKhodroId").toString());
			}
		} catch (ProxyException e) {
			e.printStackTrace();
			throw new ProxyException(e);
		}
		return listAll(ctx);
	}



    protected String getForceForwardTo(BaseActionContext ctx) {
        return ctx.getForceForwardTo();
    }

	private ActionForward doChange(BaseActionContext ctx) throws ProxyException {

		if (!isCancelled(ctx.getRequest())) {
			try {
				ActionErrors error = new ActionErrors();

				DarkhastTagheerLocal darkhastTagheerLocal = DarkhastTagheerUtil.getLocalHome().findByPrimaryKey((String)ctx.getForm().get(ID));
				DarkhastTagheerModel vo = darkhastTagheerLocal.getDarkhastTagheerModel();

				ShahrLocal shahrObject = darkhastTagheerLocal.getShahr();
				String shahrId = new String();
				if (shahrObject != null)
					shahrId = shahrObject.getId();
				else
					shahrId = null;

				RangeKhodroLocal rangeKhodroObject = darkhastTagheerLocal.getRangeKhodro();
				String rangeKhodroId = new String();
				if (rangeKhodroObject != null)
					rangeKhodroId = rangeKhodroObject.getId();
				else
					rangeKhodroId = null;

				//String eshterakId = (String)ctx.getForm().get("eshterakId");
				String eshterakId = (vo).getEshterakId();

				QueryObject moshtarakQuery = new QueryObject();
				moshtarakQuery.setTables("moshtarak ");
				moshtarakQuery.setToIndex(2);
				moshtarakQuery.setWhere("eshterakId = '" + eshterakId + "'");
				moshtarakQuery.setJoined(false);
				ArrayList moshtarakArray = (MoshtarakSessionUtil.getLocalHome().create().readModel(moshtarakQuery).getResult());
				MoshtarakModel moshtarakModel = new MoshtarakModel();
				if (!moshtarakArray.isEmpty()) {
					moshtarakModel = (MoshtarakModel)moshtarakArray.get(0);
				} else {
					error.add("a", new ActionError("errors.eshterakId.doesnt.exists"));
				}
				MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakModel.getId());

				MoshtarakModel moshtarak = moshtarakLocal.getMoshtarakModel();

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getAddress()) ){
                    if (vo.getAddress().equals("-"))
                        moshtarak.setAddress("");
                    else
                        moshtarak.setAddress(vo.getAddress());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getTel()) ){
                    if (vo.getTel().equals("-"))
                        moshtarak.setTel("");
                    else
                        moshtarak.setTel(vo.getTel());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getEmail()) ){
                    if (vo.getEmail().equals("-"))
                        moshtarak.setEmail("");
                    else
                        moshtarak.setEmail(vo.getEmail());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getMobile()) ){
                    if (vo.getMobile().equals("-"))
                        moshtarak.setMobile("");
                    else
                        moshtarak.setMobile(vo.getMobile());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getName()) ){
                     if (vo.getName().equals("-"))
                        moshtarak.setName("");
                     else
                        moshtarak.setName(vo.getName());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getNameKhanevadegi()) ){
                    if (vo.getNameKhanevadegi().equals("-"))
                        moshtarak.setNameKhanevadegi("");
                    else
                        moshtarak.setNameKhanevadegi(vo.getNameKhanevadegi());
                }

                if ( vo.getNoeService() != null ){
                    if (vo.getNoeService().intValue() != 0)
                        moshtarak.setNoeService(vo.getNoeService());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getPostCode()) ){
                    if (vo.getPostCode().equals("-"))
                        moshtarak.setPostCode("");
                    else
                        moshtarak.setPostCode(vo.getPostCode());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getShomarePelak()) ){
                    if (vo.getShomarePelak().equals("-"))
                        moshtarak.setShomarePelak("");
                    else
                        moshtarak.setShomarePelak(vo.getShomarePelak());
                }

                if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getTarikhTavalod()) ){
                    if (vo.getTarikhTavalod().equals("-"))
                        moshtarak.setTarikhTavalod(null);
                    else
                        moshtarak.setTarikhTavalod(HejriUtil.hejriToChris(vo.getTarikhTavalod()));
                }

				Validators.moshtarakValidator(ctx.getConnection(), moshtarak, error);
				if (!error.isEmpty()) {
					ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
				} else {
					MoshtarakModel model = (MoshtarakModel) (MoshtarakSessionUtil.getLocalHome().create()).update(moshtarak, shahrId, null, rangeKhodroId, null);
					getProxy().remove(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new ProxyException(e);
			}
		}
		return listAll(ctx);
	}

	protected ActionForward doCheckRequest(BaseActionContext ctx) {
		String eshterakId = (String) (ctx.getForm().get("eshterakId"));
		String shomareMotor = (String) (ctx.getForm().get("tel"));
		ctx.getForm().set("tel", "");
		String shomareShasi = (String) (ctx.getForm().get("postCode"));
		ctx.getForm().set("postCode", "");
		String shomarePelak = (String) (ctx.getForm().get("shomarePelak"));

		QueryObject requestQuery = new QueryObject();
		requestQuery.setTables("moshtarak");
		requestQuery.setToIndex(2);
		requestQuery.setWhere("eshterakId = '" + eshterakId + "'" + " AND " + "shomareShasi = '" + shomareShasi + "'" + " AND " + "shomareMotor = '" + shomareMotor + "'");
		requestQuery.setJoined(false);
		try {
			ArrayList moshtarakArray = MoshtarakSessionUtil.getLocalHome().create().readModel(requestQuery).getResult();

			//			MoshtarakList moshtarakList = (MoshtarakList)moshtarakArray.get(0);
			if ((!moshtarakArray.isEmpty())
				&& ((((MoshtarakModel)moshtarakArray.get(0)).getShomarePelak() == null) || (((MoshtarakModel)moshtarakArray.get(0)).getShomarePelak().length() == 0) || (((MoshtarakModel)moshtarakArray.get(0)).getShomarePelak().equals(shomarePelak)))) {
				ctx.getForm().set("shomarePelak", "");
                ctx.getForm().set(ACTION_TYPE, "moshtariCreate");
				return ctx.getActionMapping().findForward("edit");
			} else {
				ActionErrors error = new ActionErrors();
				error.add("aaa", new ActionError("errors.DarkhastTagheer.report"));
				ctx.getRequest().setAttribute(DISPLAY_MESSAGE, error);
				return ctx.getActionMapping().findForward("request");
			}
		} catch (ProxyException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return null;

	}

    protected ActionForward doSpecific(BaseActionContext ctx) throws Exception {
        //--------------- forwarding to request form for creating darkhastEshterak (by moshtari) -------------------
        if (ctx.getSubAction().equals("request")) {
            ctx.getForm().set(ACTION_TYPE, "specific,validreq");
            return ctx.getActionMapping().findForward("request");
        }
        //--------------- validating request for creating darkhastEshterak  -------------------
        else if (ctx.getSubAction().equals("validreq")) {
            if (!isCancelled(ctx.getRequest()))
                return doCheckRequest(ctx);
            else
                return ctx.getActionMapping().findForward("defaultHome");
        }
        else if (ctx.getSubAction().equals("goHome")) {
            return ctx.getActionMapping().findForward("defaultHome");
        }

        //--------------- validating and creating darkhastEshterak (by moshtari) -------------------
        if (ctx.getSubAction().equals("moshtariCreate")) {
            if (isCancelled(ctx.getRequest()))
                return ctx.getActionMapping().findForward("defaultHome");

            ActionErrors errors = new ActionErrors ();
            ((DarkhastTagheerForm)ctx.getForm()).checkForSpecificValidations(ctx.getConnection(), errors);
            if (!errors.isEmpty()) {
                showMessage(ctx, errors);
                ctx.getForm().set(ACTION_TYPE, "moshtariCreate");
                return ctx.getActionMapping().findForward("edit");
            }
            else {
                doCreate(ctx);
                return ctx.getActionMapping().findForward("thanks");
            }
        }

        if (ctx.getRequest().getRequestURI().toLowerCase().indexOf("/moshtari") >= 0)
            return null;

        else if (ctx.getSubAction().equals("change")) {
                return doChange(ctx);
        }
        else if (ctx.getSubAction().equals("rokhdadCreate")) {
            ctx.getForm().set(ACTION_TYPE, "specific,validaterokhdadCreate");
            ctx.getForm().set(ID,"");
            return ctx.getActionMapping().findForward("rokhdadCreate");
        }
        else if (ctx.getSubAction().equals("validaterokhdadCreate")) {
            doCreate(ctx);
            ctx.getForm().set(ACTION_TYPE, "create");
            ctx.setForceForwardTo("darkhastTagheerConfirm");
            ctx.getUserSession().setSpecific("", ctx.getForceForwardTo(), ctx.getEntity());
            return ctx.getActionMapping().findForward("darkhastTagheerConfirm");
        }
        else if (ctx.getSubAction().equals("validateCreate")) {
            doCreate(ctx);
            ctx.getForm().set(ACTION_TYPE, "create");
            return listAll(ctx);
        }


        return null;
    }
}