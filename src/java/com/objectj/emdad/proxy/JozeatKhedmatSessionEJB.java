package com.objectj.emdad.proxy;

import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.ComboObject;
import com.objectj.emdad.ejb.util.Util;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="JozeatKhedmatSession"
 *    jndi-name="ejb/emdad/JozeatKhedmatSession"
 *    local-jndi-name="ejb/emdad/JozeatKhedmatSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.JozeatKhedmatProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class JozeatKhedmatSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {

	protected static Logger log = Logger.getLogger(NoeKhodroSessionEJB.class.getName());

	protected Class getValueObjectClass() {
		return JozeatKhedmatModel.class;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public ValueObject create(ValueObject valueObject, String emdadId, String ojratId, String qateId, String iradId) throws ProxyException {
		try {
            long t1 = (new java.util.Date()).getTime();
            ValueObject vo  =  create(valueObject, (com.objectj.emdad.ejb.EmdadLocal)null, null, null, null);
            updateRela(vo.getId(), new String[] {emdadId, ojratId, qateId, iradId});
            log.info("-- create time JozeatKhedmat 000="+((new java.util.Date()).getTime()-t1));

            if(1==1)
                return vo; //create(valueObject, moshtarakObject, namayandegiObject, daftarOstaniObject, shahrObject);

            JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();
			JozeatKhedmatLocal jozeatKhedmatLocal = jozeatKhedmatLocalHome.create((JozeatKhedmatModel)valueObject);

            if (emdadId != null && emdadId.length() != 0) {
				EmdadLocal emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
				jozeatKhedmatLocal.setEmdad( emdadObject );
			}
            OjratLocal ojratObject = null;
            IradLocal iradObject = null;
            QateLocal qateObject = null;
/*            if(!isDatabaseSQL()){
                if (Util.isNotEmptyId(ojratId))
			        ojratObject = OjratUtil.getLocalHome().findByPrimaryKey(ojratId);
                else
                    ojratObject = OjratUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setOjrat(ojratObject);

                if (Util.isNotEmptyId(iradId))
			        iradObject = IradUtil.getLocalHome().findByPrimaryKey(iradId);
                else
                    iradObject = IradUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setIrad(iradObject);

                if (Util.isNotEmptyId(qateId))
			        qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                else
                    qateObject = QateUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setQate(qateObject);
            }
            else{*/
                if (ojratId != null && ojratId.length() != 0){
                    ojratObject = OjratUtil.getLocalHome().findByPrimaryKey(ojratId);
                    jozeatKhedmatLocal.setOjrat(ojratObject);
                }
                if (iradId != null && iradId.length() != 0) {
                    iradObject = IradUtil.getLocalHome().findByPrimaryKey(iradId);
                    jozeatKhedmatLocal.setIrad(iradObject);
                }
                if (qateId != null && qateId.length() != 0) {
                    qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                    jozeatKhedmatLocal.setQate(qateObject);
                }
//			}

			JozeatKhedmatModel jozeatKhedmatModel = jozeatKhedmatLocal.getJozeatKhedmatModel();

			return jozeatKhedmatModel;

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
    public ValueObject create(ValueObject valueObject, com.objectj.emdad.ejb.EmdadLocal emdadObject, com.objectj.emdad.ejb.OjratLocal ojratObject, com.objectj.emdad.ejb.QateLocal qateObject, com.objectj.emdad.ejb.IradLocal iradObject) throws ProxyException {
		try {
            JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();
            JozeatKhedmatLocal jozeatKhedmatLocal = jozeatKhedmatLocalHome.create((JozeatKhedmatModel)valueObject);

            return jozeatKhedmatLocal.getJozeatKhedmatModel();
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
            throw new ProxyException(exception);
        }
    }

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject, String emdadId, String ojratId, String qateId, String iradId) throws ProxyException {
		try {
			JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();
			JozeatKhedmatLocal jozeatKhedmatLocal = jozeatKhedmatLocalHome.findByPrimaryKey(valueObject.getId());
            jozeatKhedmatLocal.setJozeatKhedmatModel((JozeatKhedmatModel)valueObject);
            updateRela(valueObject.getId(), new String[] {emdadId, ojratId, qateId, iradId});
            if (true)
                return;

            if (emdadId != null && emdadId.length() != 0) {
				EmdadLocal emdadObject = EmdadUtil.getLocalHome().findByPrimaryKey(emdadId);
				jozeatKhedmatLocal.setEmdad( emdadObject );
			}

            OjratLocal ojratObject = null;
            IradLocal iradObject = null;
            QateLocal qateObject = null;
/*            if(!isDatabaseSQL()){
                if (Util.isNotEmptyId(ojratId))
			        ojratObject = OjratUtil.getLocalHome().findByPrimaryKey(ojratId);
                else
                    ojratObject = OjratUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setOjrat(ojratObject);

                if (Util.isNotEmptyId(iradId))
			        iradObject = IradUtil.getLocalHome().findByPrimaryKey(iradId);
                else
                    iradObject = IradUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setIrad(iradObject);

                if (Util.isNotEmptyId(qateId))
			        qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                else
                    qateObject = QateUtil.getLocalHome().findByPrimaryKey((String) com.objectj.emdad.ejb.util.Util.get("nullKey"));
                jozeatKhedmatLocal.setQate(qateObject);
            }
            else{*/
                if (ojratId != null && ojratId.length() != 0){
                    ojratObject = OjratUtil.getLocalHome().findByPrimaryKey(ojratId);
                    jozeatKhedmatLocal.setOjrat(ojratObject);
                }
                else
                    jozeatKhedmatLocal.setOjrat(null);
                if (iradId != null && iradId.length() != 0) {
                    iradObject = IradUtil.getLocalHome().findByPrimaryKey(iradId);
                    jozeatKhedmatLocal.setIrad(iradObject);
                }
                else
                    jozeatKhedmatLocal.setIrad(null);
                if (qateId != null && qateId.length() != 0) {
                    qateObject = QateUtil.getLocalHome().findByPrimaryKey(qateId);
                    jozeatKhedmatLocal.setQate(qateObject);
                }
                else
                    jozeatKhedmatLocal.setQate(null);
//			}

			jozeatKhedmatLocal.setJozeatKhedmatModel((JozeatKhedmatModel)valueObject);
			return;
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
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.EmdadLocal emdadObject, com.objectj.emdad.ejb.OjratLocal ojratObject, com.objectj.emdad.ejb.QateLocal qateObject, com.objectj.emdad.ejb.IradLocal iradObject) throws ProxyException {
		try {
			JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();
			JozeatKhedmatLocal jozeatKhedmatLocal = jozeatKhedmatLocalHome.findByPrimaryKey(valueObject.getId());
            if (emdadObject != null ) {
				jozeatKhedmatLocal.setEmdad( emdadObject );
			}
		    jozeatKhedmatLocal.setOjrat(ojratObject);
			jozeatKhedmatLocal.setQate(qateObject);
			jozeatKhedmatLocal.setIrad(iradObject);
			jozeatKhedmatLocal.setJozeatKhedmatModel((JozeatKhedmatModel)valueObject);
			return;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

    protected String getUpdateRelaStatement() {
        if(isDatabaseSQL())
            return "execute dbo.UpdateRelationJozeatKhedmat ?, ?,?, ?,? " ;
        else
            return "execute UpdateRelationJozeatKhedmat(?, ?,?, ?,?) " ;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void updateRela(String id, String[] relaIds) throws ProxyException {
        super.updateRela(id, relaIds);
    }

	public ValueObject modelToList(Object o) {
		JozeatKhedmatLocal jozeatKhedmatLocal = (JozeatKhedmatLocal)o;

		JozeatKhedmatList jozeatKhedmatList = new JozeatKhedmatList();
		JozeatKhedmatModel jozeatKhedmatModel = jozeatKhedmatLocal.getJozeatKhedmatModel();

		//	dastorkar;

		jozeatKhedmatList.setId(jozeatKhedmatModel.getId());
		jozeatKhedmatList.setNoeKhedmat(jozeatKhedmatModel.getNoeKhedmat());
		jozeatKhedmatList.setHazineh(jozeatKhedmatModel.getHazineh());
		jozeatKhedmatList.setHazinehDefault(jozeatKhedmatModel.getHazinehDefault());
		jozeatKhedmatList.setTedadQate(jozeatKhedmatModel.getTedadQate());
		jozeatKhedmatList.setGuarantee(jozeatKhedmatModel.getGuarantee());

		jozeatKhedmatList.setTaeedHesabdar(jozeatKhedmatModel.getTaeedHesabdar());
		jozeatKhedmatList.setTaeedGuarantee(jozeatKhedmatModel.getTaeedGuarantee());
		jozeatKhedmatList.setTaeedNamayandegi(jozeatKhedmatModel.getTaeedNamayandegi());
		jozeatKhedmatList.setIjadKonandeh(jozeatKhedmatModel.getIjadKonandeh());
        jozeatKhedmatList.setManbaeTahiyeh( jozeatKhedmatModel.getManbaeTahiyeh() );
        jozeatKhedmatList.setNahveyePardakht( jozeatKhedmatModel.getNahveyePardakht() );

		int guarantee = jozeatKhedmatModel.getGuarantee().intValue();
		jozeatKhedmatList.setGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", guarantee)).getName());

		int taeedHesabdar = jozeatKhedmatModel.getTaeedHesabdar().intValue();
		jozeatKhedmatList.setTaeedHesabdarName(((ComboObject)Util.getFromArrayList("yesNo", taeedHesabdar)).getName());


        if (jozeatKhedmatModel.getTaeedGuarantee() != null){
		    int taeedGuarantee = jozeatKhedmatModel.getTaeedGuarantee().intValue();
		    jozeatKhedmatList.setTaeedGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", taeedGuarantee)).getName());
        }

		int taeedNamayandegi = jozeatKhedmatModel.getTaeedNamayandegi().intValue();
		jozeatKhedmatList.setTaeedNamayandegiName(((ComboObject)Util.getFromArrayList("yesNo", taeedNamayandegi)).getName());

        EmdadLocal emdadLocal = jozeatKhedmatLocal.getEmdad();
		if (emdadLocal != null) {
			EmdadModel emdadModel = emdadLocal.getEmdadModel();
			jozeatKhedmatList.setEmdadId( emdadModel.getId() );
		}

		OjratLocal ojratLocal = jozeatKhedmatLocal.getOjrat();
		if (ojratLocal != null) {
			OjratModel ojratModel = ojratLocal.getOjratModel();
			jozeatKhedmatList.setOjratId(ojratModel.getId());
			jozeatKhedmatList.setOjratIdCode(ojratModel.getOjratId());
			jozeatKhedmatList.setOjratOnvan(ojratModel.getOnvan());
		}

		QateLocal qateLocal = jozeatKhedmatLocal.getQate();
		if (qateLocal != null) {
			QateModel qateModel = qateLocal.getQateModel();
			jozeatKhedmatList.setQateId(qateModel.getId());
			jozeatKhedmatList.setQateIdCode(qateModel.getQateId());
			jozeatKhedmatList.setQateName(qateModel.getName());
		}

		IradLocal iradLocal = jozeatKhedmatLocal.getIrad();
		if (iradLocal != null) {
			IradModel iradModel = iradLocal.getIradModel();
			jozeatKhedmatList.setIradId(iradModel.getId());
            jozeatKhedmatList.setIradIdCode(iradModel.getIradId());
			jozeatKhedmatList.setIradOnvan(iradModel.getOnvan());
		}

		jozeatKhedmatList.setDastorkar(getDastorkar((jozeatKhedmatModel.getNoeKhedmat()).intValue(), jozeatKhedmatList.getEmdadId() ));

		return jozeatKhedmatList;
	}

	public ValueObject resultSetToList(ResultSet resultSet) {
		try {
			JozeatKhedmatList jozeatKhedmatList = new JozeatKhedmatList();
			jozeatKhedmatList.setId(resultSet.getString("id"));
			jozeatKhedmatList.setNoeKhedmat(new Integer(resultSet.getInt("noeKhedmat")));
			jozeatKhedmatList.setEmdadId(resultSet.getString("khedmatId"));
			jozeatKhedmatList.setDastorkar(getDastorkar(resultSet.getInt("noeKhedmat"), resultSet.getString("khedmatId")));
			jozeatKhedmatList.setHazineh(new Integer(resultSet.getInt("hazineh")));
			jozeatKhedmatList.setHazinehDefault(new Integer(resultSet.getInt("hazinehDefault")));
			jozeatKhedmatList.setTedadQate(new Integer(resultSet.getInt("tedadQate")));
			jozeatKhedmatList.setGuarantee(new Integer(resultSet.getInt("guarantee")));
            jozeatKhedmatList.setOjratId( resultSet.getString("ojratId") );
            jozeatKhedmatList.setShomarehFanni( resultSet.getString("shomareFanni") );
            jozeatKhedmatList.setIradId( resultSet.getString("iradId"));
            jozeatKhedmatList.setIradOnvan( resultSet.getString("iradName"));
            jozeatKhedmatList.setQateName( resultSet.getString("qateName") );
            jozeatKhedmatList.setOjratOnvan( resultSet.getString("ojratName") );

			jozeatKhedmatList.setTaeedHesabdar(new Integer(resultSet.getInt("taeedHesabdar")));
			jozeatKhedmatList.setTaeedGuarantee(new Integer(resultSet.getInt("taeedGuarantee")));
			jozeatKhedmatList.setTaeedNamayandegi(new Integer(resultSet.getInt("taeedNamayandegi")));

			jozeatKhedmatList.setIjadKonandeh(resultSet.getString("ijadKonandeh"));

            jozeatKhedmatList.setManbaeTahiyeh(new Integer(resultSet.getInt("manbaeTahiyeh")) );
            jozeatKhedmatList.setNahveyePardakht(new Integer(resultSet.getInt("nahveyePardakht")) );


			int guarantee = resultSet.getInt("guarantee");
			jozeatKhedmatList.setGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", guarantee)).getName());

			int taeedHesabdar = resultSet.getInt("taeedHesabdar");
			jozeatKhedmatList.setTaeedHesabdarName(((ComboObject)Util.getFromArrayList("yesNo", taeedHesabdar)).getName());

			int taeedGuarantee = resultSet.getInt("taeedGuarantee");
			jozeatKhedmatList.setTaeedGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", taeedGuarantee)).getName());

			int taeedNamayandegi = resultSet.getInt("taeedNamayandegi");
			jozeatKhedmatList.setTaeedNamayandegiName(((ComboObject)Util.getFromArrayList("yesNo", taeedNamayandegi)).getName());

			//	jozeatKhedmatList.setOjratOnvan(resultSet.getString("onvan"));
			//    jozeatKhedmatList.setOjratIdCode(new Integer(resultSet.getInt("ojratId")));
			//	jozeatKhedmatList.setQateName(resultSet.getString("name"));
			//    jozeatKhedmatList.setQateIdCode(new Integer(resultSet.getInt("qateId")));
			// TODO : fix get rs by column name
            //    jozeatKhedmatList.setIradIdCode(new Integer(resultSet.getInt("iradId")));
			//	jozeatKhedmatList.setIradOnvan(resultSet.getString("onvan"));

			return jozeatKhedmatList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private Integer getDastorkar(int noeKhedmat, String khedmatId) {
		Integer dastorkar;
		switch (noeKhedmat) {
			case 0 :
			default :
				try {
					EmdadLocal emdadLocal = EmdadUtil.getLocalHome().findByPrimaryKey(khedmatId);
					dastorkar = emdadLocal.getEmdadModel().getEmdadId();
					return dastorkar;
				} catch (Exception e) {
					e.printStackTrace();
				}

		}
		return null;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public QueryResult readList(QueryObject queryObject) throws ProxyException {
//		queryObject.setTables(
//			"jozeatKhedmat LEFT OUTER JOIN ojrat ON jozeatKhedmat.ojratId = ojrat.Id " +
//		 	"LEFT OUTER JOIN qate ON jozeatKhedmat.qateId = qate.Id " +
//			"LEFT OUTER JOIN irad ON jozeatKhedmat.iradId = irad.Id " +
//			"LEFT OUTER JOIN emdad ON jozeatKhedmat.khedmatId = emdad.Id " );
        setAsView(queryObject, "jozeatKhedmat", "view_jozeatKhedmat");

        //queryObject.setJoined(true);
		return super.readList(queryObject);
	}

	public Integer sumHazineh(String khedmatId) throws ProxyException {
		try {
			QueryObject queryObject = new QueryObject();
			queryObject.setJoined(false);
			queryObject.setTables("jozeatKhedmat");
			queryObject.setSelectFields("SUM(hazineh)");
			queryObject.setWhere("khedmatId = '" + khedmatId + "'");

			JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();
            Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
			ResultSet rs = jozeatKhedmatLocalHome.advanceRead(c, queryObject);

			rs.next();
            Integer i = new Integer(rs.getInt(1));
            c.close();
			return i;
		} catch (Exception exception) {
			log.error(exception);
			throw new ProxyException(exception);
		}
	}

	/**
	 * @ejb.interface-method
	 * @ejb.transaction
	 * 	 type = "Supports"
	 */
	public ResultSet report(QueryObject queryObject) throws ProxyException {
		try {
            setAsView(queryObject, "jozeatKhedmat", "view_jozeatKhedmat");
            //queryObject.setJoined(true);
			JozeatKhedmatLocalHome jozeatKhedmatLocalHome = JozeatKhedmatUtil.getLocalHome();

//			queryObject.setTables(
//				"jozeatKhedmat LEFT OUTER JOIN ojrat ON jozeatKhedmat.ojratId = ojrat.Id " +
//			 	"LEFT OUTER JOIN qate ON jozeatKhedmat.qateId = qate.Id " +
//				"LEFT OUTER JOIN irad ON jozeatKhedmat.iradId = irad.Id " +
//				"LEFT OUTER JOIN emdad ON jozeatKhedmat.khedmatId = emdad.Id " );

			//			String where = queryObject.getWhere();
			//
			//			if (where != null && where.length() != 0)
			//				where += " AND jozeatKhedmat.ojratId = ojrat.Id AND jozeatKhedmat.qateId = qate.Id AND jozeatKhedmat.iradId = irad.Id";
			//			else
			//				where += " jozeatKhedmat.ojratId = ojrat.Id AND jozeatKhedmat.qateId = qate.Id AND jozeatKhedmat.iradId = irad.Id";
			//
			//			queryObject.setWhere(where);

            Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
			ResultSet rs = jozeatKhedmatLocalHome.advanceRead(c, queryObject);
			return rs;
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
	 * 	 type = "Required"
	 */
	public void update(ValueObject valueObject) throws ProxyException {
		super.update(valueObject);
	}

}
