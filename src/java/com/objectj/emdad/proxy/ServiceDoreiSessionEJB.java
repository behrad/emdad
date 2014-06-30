
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.HejriUtil;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="ServiceDoreiSession"
 *    jndi-name="ejb/emdad/ServiceDoreiSession"
 *    local-jndi-name="ejb/emdad/ServiceDoreiSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.ServiceDoreiProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class ServiceDoreiSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return ServiceDoreiModel.class;
    }


    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "NotSupported"
     */
    public ValueObject create(ValueObject valueObject, String moshtarakId, String namayandegiId) throws ProxyException {
        try {
            long now = System.currentTimeMillis();
            MoshtarakLocal moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
            long after = System.currentTimeMillis() - now;
            log.info( "FIND MOSHTARAK IN SESSION EJB: IN " + after );
            NamayandegiLocal namayandegiObject = null;
            if (namayandegiId != null && namayandegiId.length() > 0) {
                namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(namayandegiId);
            }

            return create(valueObject, moshtarakObject, namayandegiObject);
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public ValueObject create(ValueObject valueObject, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException {
        try {
            ServiceDoreiLocalHome serviceDoreiLocalHome = ServiceDoreiUtil.getLocalHome();
            ServiceDoreiLocal serviceDoreiLocal = serviceDoreiLocalHome.create((ServiceDoreiModel) valueObject);
            update(serviceDoreiLocal,moshtarakObject,namayandegiObject);
            return serviceDoreiLocal.getServiceDoreiModel();
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "NotSupported"
     */
    public void update(ValueObject valueObject, String moshtarakId, String namayandegiId) throws ProxyException {
        try {

            MoshtarakLocal moshtarakObject = null;
            if (moshtarakId != null) {
                moshtarakObject = MoshtarakUtil.getLocalHome().findByPrimaryKey(moshtarakId);
            }

            NamayandegiLocal namayandegiObject = null;
            if (namayandegiId != null && namayandegiId.length() > 0) {
                namayandegiObject = NamayandegiUtil.getLocalHome().findByPrimaryKey(namayandegiId);
            }

            update(valueObject, moshtarakObject, namayandegiObject);
            return;
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }
    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException {
        try {

            ServiceDoreiLocal serviceDoreiLocal = ServiceDoreiUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            serviceDoreiLocal.setServiceDoreiModel((ServiceDoreiModel) valueObject);
            update(serviceDoreiLocal, moshtarakObject, namayandegiObject);
            return;
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }
    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(com.objectj.emdad.ejb.ServiceDoreiLocal serviceDoreiLocal, com.objectj.emdad.ejb.MoshtarakLocal moshtarakObject, com.objectj.emdad.ejb.NamayandegiLocal namayandegiObject) throws ProxyException {
        try {

            if (moshtarakObject != null) {
                serviceDoreiLocal.setMoshtarak(moshtarakObject);
            }
            if (namayandegiObject != null) {
                serviceDoreiLocal.setNamayandegi(namayandegiObject);
            }
            return;
        } catch (Exception exception) {
            log.error(exception);
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

    public ValueObject modelToList(Object o) {
        log.info( "ModelToList serviceDorei");
        ServiceDoreiLocal serviceDoreiLocal = (ServiceDoreiLocal) o;

        ServiceDoreiList serviceList = new ServiceDoreiList();
        ServiceDoreiModel serviceModel = serviceDoreiLocal.getServiceDoreiModel();

        serviceList.setId(serviceModel.getId());
        serviceList.setHazineh(serviceModel.getHazineh());
        serviceList.setKilometerKarkard(serviceModel.getKilometerKarkard());
        serviceList.setNoeServiceDorei(serviceModel.getNoeServiceDorei());
        serviceList.setTarikh(serviceModel.getTarikh());
        serviceList.setTaeedHesabdar( serviceModel.getTaeedHesabdar() );
        serviceList.setTaeedNamayandeh( serviceModel.getTaeedNamayandeh() );
        if (serviceModel.getTarikh() != null)
            serviceList.setTarikhHejri(HejriUtil.chrisToHejri(serviceModel.getTarikh()));
        else
            serviceList.setTarikhHejri("");

        MoshtarakLocal moshtarakLocal = serviceDoreiLocal.getMoshtarak();
        if (moshtarakLocal != null) {
            MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();
            serviceList.setMoshtarakName(moshtarakModel.getNameKhanevadegi());
            serviceList.setEshterakId(moshtarakModel.getEshterakId());
            serviceList.setMoshtarakId( moshtarakModel.getId() );
            serviceList.setShomarehShasi( moshtarakModel.getShomareShasi());
        }

        NamayandegiLocal namayandegiLocal = serviceDoreiLocal.getNamayandegi();
        if (namayandegiLocal != null) {
            NamayandegiModel namayandegiModel = namayandegiLocal.getNamayandegiModel();
            serviceList.setNamayandegiId(namayandegiModel.getNamayandegiId());
            serviceList.setNamayandegiName(namayandegiModel.getName());
        }

        String noeService = serviceModel.getNoeServiceDorei();
        noeService = UserAccessEntity.stringQuery( "select name from noeServiceDorei where id='" + noeService + "'", "name" );
        serviceList.setNoeServiceDoreiName( noeService );
        return serviceList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {
            log.info( "ResultSetToList serviceDorei");
            ServiceDoreiList seviceList = new ServiceDoreiList();
            seviceList.setId(resultSet.getString("id"));
            seviceList.setHazineh(new Integer(resultSet.getInt("hazineh")));
            seviceList.setKilometerKarkard(new Integer(resultSet.getInt("KilometerKarkard")));
            seviceList.setNoeServiceDorei( resultSet.getString("NoeServiceDorei") );
            seviceList.setNamayandegiId(new Integer(resultSet.getInt("namayandegiId")));
            seviceList.setEshterakId(resultSet.getString("eshterakId"));
            seviceList.setNamayandegiName(resultSet.getString("namayandegiName"));
            seviceList.setTarikhHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikh")));
            seviceList.setNoeServiceDoreiId( new Integer( resultSet.getInt( "noeServiceDoreiId" ) ) );
            seviceList.setNoeServiceDoreiName( resultSet.getString( "name" ) );
            seviceList.setTaeedHesabdar( new Integer( resultSet.getInt( "taeedHesabdar" )));
            seviceList.setTaeedNamayandeh( new Integer( resultSet.getInt( "taeedNamayandeh" )));
            seviceList.setShomarehShasi( resultSet.getString( "shomareShasi" ));
            return seviceList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ValueObject resultSetToBean(ResultSet resultSet) {
        try {
            ServiceDoreiModel serviceModel = new ServiceDoreiModel();
            serviceModel.setId(resultSet.getString("id"));
            serviceModel.setHazineh(new Integer(resultSet.getInt("hazineh")));
            serviceModel.setKilometerKarkard(new Integer(resultSet.getInt("KilometerKarkard")));
            serviceModel.setNoeServiceDorei( resultSet.getString("NoeServiceDorei") );
            serviceModel.setTarikh(resultSet.getDate("tarikh"));
            serviceModel.setTaeedHesabdar( new Integer(resultSet.getInt( "taeedHesabdar")));
            serviceModel.setTaeedNamayandeh( new Integer(resultSet.getInt( "taeedNamayandeh")));
            return serviceModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
	 * 	 type = "NotSupported"
	 */
	public ValueObject read(String id) throws ProxyException {
		return super.read(id);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult read(String[] ids) throws ProxyException {
		return super.read(ids);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult read(ValueObject valueObject) throws ProxyException {
		return super.read(valueObject);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readByEntityId(Integer entityId) throws ProxyException {
		return super.readByEntityId(entityId);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readCombo(String table, String field, String filter) throws ProxyException {
		return super.readCombo(table, field, filter);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readCombo(String table, String field) throws ProxyException {
		return super.readCombo(table, field);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
	 */
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
        setAsView(queryObject, "serviceDorei", "view_serviceDorei");
		return super.readList(queryObject);
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "NotSupported"
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
	 * 	 type = "NotSupported"
	 */
	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
        setAsView(queryObject, "serviceDorei", "view_serviceDorei");
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
