package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.web.action.BazaryabAction;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import javax.naming.NamingException;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="BazaryabSession"
 *    jndi-name="ejb/emdad/BazaryabSession"
 *    local-jndi-name="ejb/emdad/BazaryabSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.BazaryabProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */
public abstract class BazaryabSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

	protected static Logger log = Logger.getLogger(BazaryabSessionEJB.class.getName());

	protected Class getValueObjectClass() {
		return BazaryabModel.class;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String noeBazaryabId) throws ProxyException {
		try {
			NoeBazaryabLocal noeBazaryabObject = NoeBazaryabUtil.getLocalHome().findByPrimaryKey(noeBazaryabId);

			BazaryabLocalHome bazaryabLocalHome = BazaryabUtil.getLocalHome();
			BazaryabLocal bazaryabLocal = bazaryabLocalHome.create((BazaryabModel)valueObject);
			bazaryabLocal.setNoeBazaryab(noeBazaryabObject);
			BazaryabModel bazaryabModel = bazaryabLocal.getBazaryabModel();

			return bazaryabModel;

		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject, String noeBazaryabId) throws ProxyException {
		try {

			NoeBazaryabLocal noeBazaryabObject = NoeBazaryabUtil.getLocalHome().findByPrimaryKey(noeBazaryabId);

			BazaryabLocalHome bazaryabLocalHome = BazaryabUtil.getLocalHome();
			BazaryabLocal bazaryabLocal = bazaryabLocalHome.findByPrimaryKey(valueObject.getId());
			bazaryabLocal.setNoeBazaryab(noeBazaryabObject);
			bazaryabLocal.setBazaryabModel((BazaryabModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	public ValueObject modelToList(Object o) {
		BazaryabLocal bazaryabLocal = (BazaryabLocal)o;

		BazaryabList bazaryabList = new BazaryabList();
		BazaryabModel bazaryabModel = bazaryabLocal.getBazaryabModel();

		bazaryabList.setId(bazaryabModel.getId());
		bazaryabList.setBazaryabId(bazaryabModel.getBazaryabId());
		bazaryabList.setBazaryabKey(bazaryabModel.getBazaryabKey());

		NoeBazaryabLocal noeBazaryabLocal = bazaryabLocal.getNoeBazaryab();
		// check for a valid relationship reference
		int bazaryabEntity = -1;
		if (noeBazaryabLocal != null) {
			NoeBazaryabModel noeBazaryabModel = noeBazaryabLocal.getNoeBazaryabModel();
			bazaryabList.setNoeBazaryabId(noeBazaryabModel.getId());
			bazaryabList.setNoeBazaryabOnvan(noeBazaryabModel.getOnvan());
			bazaryabEntity = noeBazaryabModel.getEntity().intValue();
			bazaryabList.setBazaryabName(getBazaryabName(bazaryabModel.getId())); //bazaryabEntity, bazaryabModel.getBazaryabKey()));
		}

		return bazaryabList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {

			BazaryabList bazaryabList = new BazaryabList();

			bazaryabList.setId(resultSet.getString("id"));
			bazaryabList.setBazaryabId(new Integer(resultSet.getInt("bazaryabId")));
			bazaryabList.setBazaryabKey(resultSet.getString("bazaryabKey"));
			bazaryabList.setNoeBazaryabOnvan(resultSet.getString("onvan"));
			bazaryabList.setBazaryabName(resultSet.getString("bazaryabName")); //getBazaryabName(resultSet.getInt("entity"), resultSet.getString("bazaryabKey")));

			return bazaryabList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

    public String getBazaryabName(String id) {
         return UserAccessEntity.stringQuery("select bazaryabName from view_bazaryab where id='"+id+"'" , "bazaryabName");
    }

	public String getBazaryabName(int noeBazaryabEntity, String bazaryabKey) {
		String bazaryabName = "Unknown";
        //log.info("noeBazaryabEntity="+noeBazaryabEntity+", bazaryabKey="+bazaryabKey);
		try {
			switch (noeBazaryabEntity) {
				case BazaryabAction.emdadgar :
                    EmdadgarLocal emdadgarObject = null;
                    emdadgarObject = EmdadgarUtil.getLocalHome().findByPrimaryKey(bazaryabKey);
                    bazaryabName = emdadgarObject.getEmdadgarModel().getName();
					break;

//				case BazaryabAction.post :
//					break;

				case BazaryabAction.khodrosaz :
					KhodrosazLocal khodrosazObject = null;
					khodrosazObject = KhodrosazUtil.getLocalHome().findByPrimaryKey(bazaryabKey);
					bazaryabName = khodrosazObject.getKhodrosazModel().getName();
					break;

				case BazaryabAction.daftarOstani :
					DaftarOstaniLocal daftarOstaniObject = null;
					daftarOstaniObject = DaftarOstaniUtil.getLocalHome().findByPrimaryKey(bazaryabKey);
					bazaryabName = daftarOstaniObject.getDaftarOstaniModel().getName();
					break;

				case BazaryabAction.namayandegi :
					NamayandegiLocal namayandegiObject = null;
					namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(bazaryabKey);
					bazaryabName = namayandegiObject.getNamayandegiModel().getName();
					break;

                case BazaryabAction.post:
                case BazaryabAction.karmand:
				case BazaryabAction.motefareghe :
                    BazaryabMotefaregheLocal bazaryabMotefaregheObject = null;
                    bazaryabMotefaregheObject = BazaryabMotefaregheUtil.getLocalHome().findByPrimaryKey(bazaryabKey);
                    bazaryabName = bazaryabMotefaregheObject.getBazaryabMotefaregheModel().getName();
					break;

				default :
					log.info("Unknown noeBazaryab");
			}

		} catch (javax.ejb.FinderException e) {
			e.printStackTrace(); //To change body of catch statement use Options | File Templates.
		} catch (NamingException e) {
			e.printStackTrace(); //To change body of catch statement use Options | File Templates.
		}

		return bazaryabName;
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create() throws ProxyException {
		return super.create();
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject) throws ProxyException {
		return super.create(valueObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public ValueObject read(String id) throws ProxyException {
		return super.read(id);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult read(String[] ids) throws ProxyException {
		return super.read(ids);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult read(ValueObject valueObject) throws ProxyException {
		return super.read(valueObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readByEntityId(Integer entityId) throws ProxyException {
		return super.readByEntityId(entityId);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readCombo(String table, String field, String filter) throws ProxyException {
		return super.readCombo(table, field, filter);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readCombo(String table, String field) throws ProxyException {
		return super.readCombo(table, field);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
        setAsView(queryObject, "bazaryab", "view_bazaryab");
		return super.readList(queryObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readModel(QueryObject queryObject) throws ProxyException {
		return super.readModel(queryObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void remove(String id) throws ProxyException, ProxyReferenceException {
		super.remove(id);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void remove(String[] ids) throws ProxyException, ProxyReferenceException {
		super.remove(ids);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void remove(ValueObject valueObject) throws ProxyException, ProxyReferenceException {
		super.remove(valueObject);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
        setAsView(queryObject, "bazaryab", "view_bazaryab");
		return super.report(queryObject, connection);
	}

	/**
	 * @ejb.interface-method 
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject) throws ProxyException {
		super.update(valueObject);
	}

}
