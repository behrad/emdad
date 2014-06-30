package com.objectj.emdad.proxy;

import com.objectj.emdad.ejb.*;
import com.objectj.emdad.ejb.util.*;
import com.objectj.emdad.web.action.EmdadForm;
import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;
import com.objectj.jsa.web.Exchanger;

import javax.ejb.EJBException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.rmi.RemoteException;

/**
 * @ejb.bean
 *    type="Stateless"
 *    name="MoshtarakSession"
 *    jndi-name="ejb/emdad/MoshtarakSession"
 *    local-jndi-name="ejb/emdad/MoshtarakSessionLocal"
 *    view-type="both"
 *    cmp-version="2.x"
 *    local-business-interface="com.objectj.emdad.proxy.MoshtarakProxy"
 * 	  transaction-type="Container"
 *
 * @ejb.util
 *    generate="physical"
 *
 */

public abstract class MoshtarakSessionEJB extends ProxySessionEJB implements javax.ejb.SessionBean, EntityProxy {
    protected Class getValueObjectClass() {
        return MoshtarakModel.class;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId, String bazaryabId) throws ProxyException {
        try {
            long t1 = (new java.util.Date()).getTime();
            //NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
            //RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
            String eshterakId = ((MoshtarakModel) valueObject).getEshterakId();
            if (Util.isEmpty(eshterakId)) {
                long t2 = (new java.util.Date()).getTime();
                Integer year = ((MoshtarakModel) valueObject).getSaleSakht();
                if(isDatabaseSQL())
                    eshterakId = UserAccessEntity.stringQuery("select dbo.NewEshterakId('" + noeKhodroId + "'," + year + ") as newEshterakId FROM DaftarOstani WHERE id = 'E08180808080808080o'", "newEshterakId");
                else
                    eshterakId = UserAccessEntity.stringQuery("select NewEshterakId('" + noeKhodroId + "'," + year + ") as newEshterakId FROM DaftarOstani WHERE id = 'E08180808080808080o'", "newEshterakId");
                MoshtarakModel mm = (MoshtarakModel) valueObject;
                int l = mm.getShomareShasi().length();
                if (l > 20)
                    mm.setShomareShasi(mm.getShomareShasi().substring(0, 20));
                l = mm.getNameKhanevadegi().length();
                if (l > 60)
                    mm.setNameKhanevadegi(mm.getNameKhanevadegi().substring(0, 60));
                l = mm.getShomarePelak().length();
                if (l > 20)
                    mm.setShomarePelak(mm.getShomarePelak().substring(0, 20));

//                log.info("222 eshterakId="+eshterakId);
//                QueryObject qo = new QueryObject();
//                qo.setFromIndex(0);
//                qo.setToIndex(5);
//                qo.setTables("moshtarak");
//                qo.setJoined(false);
//                qo.setSelectFields("MAX(eshterakId) AS lastid");
//                int maxSerial = 1;
//                try {
//                    qo.setWhere("eshterakId LIKE '" + year.toString().substring(2) + kids+"%'");
//                    Connection c = com.objectj.emdademdad.ejb.util.Util.getConnection();
//                    ResultSet rs = MoshtarakUtil.getLocalHome().advanceRead(c,qo);
//                    String s;
//                    if (rs.next()) {
//                        s = rs.getString("lastid").trim();
//                        maxSerial = Integer.valueOf(s.substring(4)).intValue();
//                    }
//                    rs.close();
//                    c.close();
//                    maxSerial++;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                eshterakId = (new Integer(maxSerial)).toString();
//
//                for (int i = eshterakId.length(); i < 6; i++)
//                    eshterakId = "0" + eshterakId;
//                eshterakId = year.toString().substring(2) + kids+ eshterakId;

                ((MoshtarakModel) valueObject).setEshterakId(eshterakId);
//                log.info("-- create time 000="+((new java.util.Date()).getTime()-t2));
            }

            if (((MoshtarakModel) valueObject).getMoshtarakYaNa().intValue() == 2) {
                ((MoshtarakModel) valueObject).setShomareMotor(eshterakId);
                if (Util.isEmpty(((MoshtarakModel) valueObject).getShomareShasi()))
                    ((MoshtarakModel) valueObject).setShomareShasi(eshterakId);
                ((MoshtarakModel) valueObject).setShomareVIN(eshterakId);
                bazaryabId = (String) Util.get("unk_Bazaryab");
                shahrId = (String) Util.get("unk_Shahr");
//                log.info("~~~~~~~~~~~~~ Util.get(unk_Shahr)" + Util.get("unk_Shahr"));
            }

            //ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
            //BazaryabLocal bazaryabObject = null;
            //if (bazaryabId != null && bazaryabId.length() != 0) {
            //    bazaryabObject = BazaryabUtil.getLocalHome().findByPrimaryKey(bazaryabId);
            //}
//            log.info("-- create time="+((new java.util.Date()).getTime()-t1));

            //MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().create((MoshtarakModel) valueObject);
            ValueObject vo  =  create((MoshtarakModel)valueObject, (com.objectj.emdad.ejb.ShahrLocal)null, null, null, null);
            updateRela(vo.getId(), new String[] {shahrId, noeKhodroId, rangeKhodroId, bazaryabId});
            log.info("-- create time moshtarak end 000="+((new java.util.Date()).getTime()-t1));

            //return create(valueObject, shahrObject, noeKhodroObject, rangeKhodroObject, bazaryabObject);
            return vo;

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
    public ValueObject create(ValueObject valueObject, com.objectj.emdad.ejb.ShahrLocal shahrObject, com.objectj.emdad.ejb.NoeKhodroLocal noeKhodroObject, com.objectj.emdad.ejb.RangeKhodroLocal rangeKhodroObject, com.objectj.emdad.ejb.BazaryabLocal bazaryabObject) throws ProxyException {
        try {
            long t1 = (new java.util.Date()).getTime();
            MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().create((MoshtarakModel) valueObject);
            log.info("-- create time 111="+((new java.util.Date()).getTime()-t1));
            //update(moshtarakLocal, shahrObject, noeKhodroObject, rangeKhodroObject, bazaryabObject);
            //log.info("-- create time 222="+((new java.util.Date()).getTime()-t1));
            return valueObject; //moshtarakLocal.getMoshtarakModel();

        } catch (Exception exception) {
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

//	public ValueObject create(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId, String bazaryabId) throws ProxyException {
//		try {
//			MoshtarakLocalHome moshtarakLocalHome = MoshtarakUtil.getLocalHome();
//
//			NoeKhodroLocal noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
//			RangeKhodroLocal rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
//
////			String codeKhodro = noeKhodroObject.getNoeKhodroModel().getNoeKhodroCode();
////			if (codeKhodro != null && codeKhodro.length() != 0)
////				if (codeKhodro.length() == 1)
////					codeKhodro = "0" + codeKhodro;
////				else
////					codeKhodro = "00";
//			Integer year = ((MoshtarakModel)valueObject).getSaleSakht();
//
//			QueryObject qo = new QueryObject();
//			qo.setFromIndex(0);
//			qo.setToIndex(5);
//			qo.setTables("moshtarak");
//			qo.setJoined(false);
//            qo.setSelectFields("MAX(eshterakId) AS lastid");
//			int maxSerial = 1;
//			try {
//                //qo.setWhere("eshterakId LIKE '" + year.toString().substring(2) + codeKhodro.toString().substring(0, 2) + "%'");
//				qo.setWhere("eshterakId LIKE '" + year.toString().substring(2) + "%'");
//                Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
//				ResultSet rs = MoshtarakUtil.getLocalHome().advanceRead(c,qo);
//				String s;
//				if (rs.next()) {
//					s = rs.getString("lastid");
////					if (Integer.valueOf(s.substring(4)).intValue() > maxSerial)
//					maxSerial = Integer.valueOf(s.substring(2)).intValue();
//				}
//                rs.close();
//                c.close();
//				maxSerial++;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			String eshterakId = (new Integer(maxSerial)).toString();
//			//  //=-= System.out.println("eshterakId = " + eshterakId);
//			/*            String eshterakId = Serial.getSerialCode(year, codeKhodro);
//			            //=-= System.out.println(" eshterakId = " + eshterakId);
//			            if (eshterakId == null)
//			                eshterakId = "=000001";*/
//
//			for (int i = eshterakId.length(); i < 8; i++)
//				eshterakId = "0" + eshterakId;
//			eshterakId = year.toString().substring(2) + eshterakId;
//			//     //=-= System.out.println("eshterakId = " + eshterakId);
//			 ((MoshtarakModel)valueObject).setEshterakId(eshterakId);
//
//			if (((MoshtarakModel)valueObject).getMoshtarakYaNa().intValue() == 2) {
//				((MoshtarakModel)valueObject).setShomareMotor(eshterakId);
//                //if (Util.isEmpty(((MoshtarakModel)valueObject).getShomareShasi()))
//				    ((MoshtarakModel)valueObject).setShomareShasi(eshterakId);
//				((MoshtarakModel)valueObject).setShomareVIN(eshterakId);
//				bazaryabId = (String)Util.get("unk_Bazaryab");
//				shahrId = (String)Util.get("unk_Shahr");
//                log.info("~~~~~~~~~~~~~ Util.get(unk_Shahr)" + Util.get("unk_Shahr"));
//			}
//
//            ShahrLocal shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
//			MoshtarakLocal moshtarakLocal = moshtarakLocalHome.create((MoshtarakModel)valueObject);
//
//			if (bazaryabId != null && bazaryabId.length() != 0) {
//				BazaryabLocal bazaryabObject = BazaryabUtil.getLocalHome().findByPrimaryKey(bazaryabId);
//				moshtarakLocal.setBazaryab(bazaryabObject);
//			}
//
//			moshtarakLocal.setShahr(shahrObject);
//			moshtarakLocal.setNoeKhodro(noeKhodroObject);
//			moshtarakLocal.setRangeKhodro(rangeKhodroObject);
//			MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();
//			return moshtarakModel;
//
//		} catch (Exception exception) {
//			log.error(exception);
//			throw new ProxyException(exception);
//		}
//	}

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject, String shahrId, String noeKhodroId, String rangeKhodroId, String bazaryabId) throws ProxyException {
        try {
            MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            moshtarakLocal.setMoshtarakModel((MoshtarakModel) valueObject);
            updateRela(valueObject.getId(), new String[] {shahrId, noeKhodroId, rangeKhodroId, bazaryabId});
            if (true)
                return;
            ShahrLocal shahrObject = null;
            if (shahrId != null) {
                shahrObject = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
            }

            NoeKhodroLocal noeKhodroObject = null;
            if (noeKhodroId != null) {
                noeKhodroObject = NoeKhodroUtil.getLocalHome().findByPrimaryKey(noeKhodroId);
            }

            RangeKhodroLocal rangeKhodroObject = null;
            if (rangeKhodroId != null) {
                rangeKhodroObject = RangeKhodroUtil.getLocalHome().findByPrimaryKey(rangeKhodroId);
            }

            BazaryabLocal bazaryabObject = null;
            if (bazaryabId != null) {
                bazaryabObject = BazaryabUtil.getLocalHome().findByPrimaryKey(bazaryabId);
            }

            update(valueObject, shahrObject, noeKhodroObject, rangeKhodroObject, bazaryabObject);
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void update(ValueObject valueObject, com.objectj.emdad.ejb.ShahrLocal shahrObject, com.objectj.emdad.ejb.NoeKhodroLocal noeKhodroObject, com.objectj.emdad.ejb.RangeKhodroLocal rangeKhodroObject, com.objectj.emdad.ejb.BazaryabLocal bazaryabObject) throws ProxyException {
        try {
            MoshtarakLocal moshtarakLocal = MoshtarakUtil.getLocalHome().findByPrimaryKey(valueObject.getId());
            moshtarakLocal.setMoshtarakModel((MoshtarakModel) valueObject);
            update(moshtarakLocal, shahrObject, noeKhodroObject, rangeKhodroObject, bazaryabObject);
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
    public void update(com.objectj.emdad.ejb.MoshtarakLocal moshtarakLocal, com.objectj.emdad.ejb.ShahrLocal shahrObject, com.objectj.emdad.ejb.NoeKhodroLocal noeKhodroObject, com.objectj.emdad.ejb.RangeKhodroLocal rangeKhodroObject, com.objectj.emdad.ejb.BazaryabLocal bazaryabObject) throws ProxyException {
        try {

            long t1 = (new java.util.Date()).getTime();
            if (shahrObject != null) {
                moshtarakLocal.setShahr(shahrObject);
            }
//            log.info("-- update time 000="+((new java.util.Date()).getTime()-t1));
            if (noeKhodroObject != null) {
                moshtarakLocal.setNoeKhodro(noeKhodroObject);
            }
//            log.info("-- update time 111="+((new java.util.Date()).getTime()-t1));
            if (rangeKhodroObject != null) {
                moshtarakLocal.setRangeKhodro(rangeKhodroObject);
            }
//            log.info("-- update time 222="+((new java.util.Date()).getTime()-t1));
            if (bazaryabObject != null) {
                moshtarakLocal.setBazaryab(bazaryabObject);
            }
//            log.info("-- update time 333="+((new java.util.Date()).getTime()-t1));
            return;
        } catch (Exception exception) {
            log.error(exception);
            throw new ProxyException(exception);
        }
    }

    protected String getUpdateRelaStatement() {
        if(isDatabaseSQL())
            return "execute dbo.UpdateRelationMoshtarak ?, ?,?, ?,? " ;
        else
            return "execute UpdateRelationMoshtarak( ?, ?,?, ?,?) " ;
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Required"
     */
    public void updateRela(String id, String[] relaIds) throws ProxyException {
/*        if(!isDatabaseSQL()){
            if(Util.isEmptyId(relaIds[1]))
                relaIds[1] = (String) com.objectj.emdad.ejb.util.Util.get("nullKey");
            if(Util.isEmptyId(relaIds[2]))
                relaIds[2] = (String) com.objectj.emdad.ejb.util.Util.get("nullKey");
        }*/
        super.updateRela(id, relaIds);
    }

    public ValueObject modelToList(Object o) {
        MoshtarakLocal moshtarakLocal = (MoshtarakLocal) o;

        MoshtarakList moshtarakList = new MoshtarakList();
        MoshtarakModel moshtarakModel = moshtarakLocal.getMoshtarakModel();

        moshtarakList.setId(moshtarakModel.getId());
        moshtarakList.setEshterakId(moshtarakModel.getEshterakId());
        moshtarakList.setNoeEshterak(moshtarakModel.getNoeEshterak());
        moshtarakList.setNoeService(moshtarakModel.getNoeService());
        moshtarakList.setVazeat(moshtarakModel.getVazeat());
        moshtarakList.setNameKhanevadegi(moshtarakModel.getNameKhanevadegi());
        moshtarakList.setName(moshtarakModel.getName());
        moshtarakList.setTarikhTavalod(moshtarakModel.getTarikhTavalod());
        moshtarakList.setAddress(moshtarakModel.getAddress());
        moshtarakList.setPostCode(moshtarakModel.getPostCode());
        moshtarakList.setEmail(moshtarakModel.getEmail());
        moshtarakList.setTel(moshtarakModel.getTel());
        moshtarakList.setMobile(moshtarakModel.getMobile());
        moshtarakList.setSaleSakht(moshtarakModel.getSaleSakht());
        moshtarakList.setShomarePelak(moshtarakModel.getShomarePelak());
        moshtarakList.setShomareMotor(moshtarakModel.getShomareMotor());
        moshtarakList.setShomareShasi(moshtarakModel.getShomareShasi());
        moshtarakList.setShomareVIN(moshtarakModel.getShomareVIN());
        moshtarakList.setTarikhShoro(moshtarakModel.getTarikhShoro());
        moshtarakList.setTarikhAkharinTamdid(moshtarakModel.getTarikhAkharinTamdid());
        moshtarakList.setTarikhEngheza(moshtarakModel.getTarikhEngheza());
        moshtarakList.setTarikhTahvil(moshtarakModel.getTarikhTahvil());

        moshtarakList.setNoeServiceName(((ComboObject) Util.getFromArrayList("noeService", moshtarakList.getNoeService())).getName());
        moshtarakList.setVazeatName(((ComboObject) Util.getFromArrayList("vazeat", moshtarakList.getVazeat())).getName());

        int guarantee = moshtarakModel.getGuarantee().intValue();
        Date tarikhEnghezaG = moshtarakModel.getTarikhEnghezaGuarantee();
        guarantee = guarantee == 2 ? guarantee : (tarikhEnghezaG.before(HejriUtil.getCurrentDate()) ? 2 : guarantee);
        moshtarakList.setGuaranteeName(((ComboObject) Util.getFromArrayList("yesNo", guarantee)).getName());
        moshtarakList.setGuarantee(new Integer(guarantee));

        moshtarakList.setTarikhEnghezaGuarantee(moshtarakModel.getTarikhEnghezaGuarantee());
        moshtarakList.setTarikhServiceAvalieh(moshtarakModel.getTarikhServiceAvalieh());
        moshtarakList.setMahaleServiceAvalieh(moshtarakModel.getMahaleServiceAvalieh());
        moshtarakList.setMoshtarakYaNa(moshtarakModel.getMoshtarakYaNa());
        moshtarakList.setMajaziYaNa(moshtarakModel.getMajaziYaNa());

        int moshtarakYaNa = moshtarakList.getMoshtarakYaNa().intValue();
        //moshtarakYaNa = moshtarakYaNa == 2 ? moshtarakYaNa : (moshtarakList.getTarikhEngheza().before(HejriUtil.getCurrentDate()) ? 2 : moshtarakYaNa);
        moshtarakList.setMoshtarakYaNaName(((ComboObject) Util.getFromArrayList("yesNo", moshtarakYaNa)).getName());
        moshtarakList.setMajaziYaNaName(((ComboObject) Util.getFromArrayList("yesNo", moshtarakList.getMajaziYaNa().intValue())).getName());

        moshtarakList.setHazinehPardakhtShodeh(moshtarakModel.getHazinehPardakhtShodeh());
        moshtarakList.setNamayandegi(moshtarakModel.getNamayandegi());
        moshtarakList.setTakhfif(moshtarakModel.getTakhfif());
        moshtarakList.setNaghd(moshtarakModel.getNaghd());
        moshtarakList.setTaahodi(moshtarakModel.getTaahodi());
        moshtarakList.setAghsat(moshtarakModel.getAghsat());
        moshtarakList.setCheque(moshtarakModel.getCheque());

        String[] rls = UserAccessEntity.stringQuerys("select shahrId,noeKhodroId,rangeKhodroId,bazaryabId from moshtarak where id='"+moshtarakModel.getId()+"'","shahrId,noeKhodroId,rangeKhodroId,bazaryabId");
//        ShahrLocal shahrLocal = moshtarakLocal.getShahr();
        // check for a valid relationship reference
        if (Util.isNotEmpty(rls[0])) {
            //ShahrModel shahrModel = shahrLocal.getShahrModel();
            moshtarakList.setShahrId(rls[0]);
            moshtarakList.setShahrName(ComboPool.findInCombo("shahr", rls[0]));
        }

//        NoeKhodroLocal noeKhodroLocal = moshtarakLocal.getNoeKhodro();
        // check for a valid relationship reference
        if (Util.isNotEmpty(rls[1])) {
//            NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
            moshtarakList.setNoeKhodroId(rls[1]);
            moshtarakList.setNoeKhodroOnvan(ComboPool.findInCombo("noeKhodro", rls[1]));
        }

//        RangeKhodroLocal rangeKhodroLocal = moshtarakLocal.getRangeKhodro();
        // check for a valid relationship reference
        if (Util.isNotEmpty(rls[2])) {
//            RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
            moshtarakList.setRangeKhodroId(rls[2]);
            moshtarakList.setRangeKhodroOnvan(UserAccessEntity.stringQuery("select onvan from rangeKhodro where id='"+rls[2]+"'", "onvan"));
        }

        //BazaryabLocal bazaryabLocal = moshtarakLocal.getBazaryab();
        // check for a valid relationship reference
        if (Util.isNotEmpty(rls[3])) {
            try {
//                com.objectj.emdad.proxy.BazaryabSessionLocalHome lhProxy = com.objectj.emdad.proxy.BazaryabSessionUtil.getLocalHome();
//                com.objectj.emdad.proxy.BazaryabSessionLocal lProxy = lhProxy.create();
//                BazaryabList bl = (BazaryabList) (lProxy.read(bazaryabLocal.getId()));
                //BazaryabModel bazaryabModel = bazaryabLocal..getBazaryabModel();
                //BazaryabList bl = bazaryabLocal.getBazaryabList(bazaryabModel.getId());
                //BazaryabModel bazaryabModel = bazaryabLocal.getBazaryabModel();
                moshtarakList.setBazaryabId(rls[3]);
                moshtarakList.setBazaryabName(ComboPool.findInCombo("bazaryab", rls[3]));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        return moshtarakList;
    }

    public ValueObject resultSetToList(ResultSet resultSet) {
        try {

            MoshtarakList moshtarakList = new MoshtarakList();

            moshtarakList.setId(resultSet.getString(1));
            moshtarakList.setEshterakId(resultSet.getString(2));
            moshtarakList.setNameKhanevadegi(resultSet.getString(6));
            moshtarakList.setName(resultSet.getString(7));
            moshtarakList.setShomarePelak(resultSet.getString(8));
            int moshtarakYaNa = resultSet.getInt(12);

            moshtarakList.setNoeKhodroId(resultSet.getString(30));
            moshtarakList.setNoeKhodroOnvan(resultSet.getString(31));

            Date tarikhShoro = resultSet.getDate(9);
            if (tarikhShoro != null)
                moshtarakList.setTarikhShoroHejri(HejriUtil.chrisToHejri(tarikhShoro));
            else
                moshtarakList.setTarikhShoroHejri("");

            Date tarikhEngheza = resultSet.getDate(10);
            if (tarikhEngheza != null)
                moshtarakList.setTarikhEnghezaHejri(HejriUtil.chrisToHejri(tarikhEngheza));
            else
                moshtarakList.setTarikhEnghezaHejri("");

//            moshtarakYaNa = moshtarakYaNa == 2 ? moshtarakYaNa : (tarikhEngheza.before(HejriUtil.getCurrentDate()) ? 2 : moshtarakYaNa);
            moshtarakList.setMoshtarakYaNaName(((ComboObject) Util.getFromArrayList("yesNo", moshtarakYaNa)).getName());

            int noeEshterak = resultSet.getInt(3);
            moshtarakList.setNoeEshterak(new Integer(noeEshterak));
            moshtarakList.setNoeEshterakName(((ComboObject) Util.getFromArrayList("noeEshterak", noeEshterak)).getName());

            int majaziYaNa = resultSet.getInt(37);
            moshtarakList.setMajaziYaNa(new Integer(majaziYaNa));
            moshtarakList.setMajaziYaNaName(((ComboObject) Util.getFromArrayList("yesNo", majaziYaNa)).getName());

            int noeService = resultSet.getInt(4);
            moshtarakList.setNoeService(new Integer(noeService));
            moshtarakList.setNoeServiceName(((ComboObject) Util.getFromArrayList("noeService", noeService)).getName());

            int vazeat = resultSet.getInt(5);
            moshtarakList.setVazeat(new Integer(vazeat));
            moshtarakList.setVazeatName(((ComboObject) Util.getFromArrayList("vazeat", vazeat)).getName());

            int guarantee = resultSet.getInt(11);
            Date tarikhEnghezaG = resultSet.getDate(24);
            guarantee = guarantee == 2 ? guarantee : (tarikhEnghezaG.before(HejriUtil.getCurrentDate()) ? 2 : guarantee);
            moshtarakList.setGuaranteeName(((ComboObject) Util.getFromArrayList("yesNo", guarantee)).getName());

            moshtarakList.setAddress(resultSet.getString(16));
            moshtarakList.setShomareShasi(resultSet.getString(25));
//            moshtarakList.setRangeKhodroId(resultSet.getString(32));
            moshtarakList.setShahrId(resultSet.getString(33));
            int hazinehPardakhtShodeh = resultSet.getInt(35);
            moshtarakList.setHazinehPardakhtShodeh(new Integer(hazinehPardakhtShodeh));
            int namayandegi = resultSet.getInt(36);
            moshtarakList.setNamayandegi(new Integer(namayandegi));
            moshtarakList.setAddress(resultSet.getString("address"));

            moshtarakList.setTel(resultSet.getString(17));

//			moshtarakList.setId(resultSet.getString("id"));
//			moshtarakList.setEshterakId(resultSet.getString("eshterakId"));
//			moshtarakList.setNoeEshterak(new Integer(resultSet.getInt("noeEshterak")));
//			moshtarakList.setNoeService(new Integer(resultSet.getInt("noeService")));
//			moshtarakList.setVazeat(new Integer(resultSet.getInt("vazeat")));
//			moshtarakList.setNameKhanevadegi(resultSet.getString("nameKhanevadegi"));
//			moshtarakList.setName(resultSet.getString("name"));
//			moshtarakList.setShomarePelak(resultSet.getString("shomarePelak"));
//			int moshtarakYaNa = resultSet.getInt("moshtarakYaNa");
//			moshtarakList.setMoshtarakYaNaName(((ComboObject)Util.getFromArrayList("yesNo", moshtarakYaNa)).getName());
//
//			moshtarakList.setNoeKhodroId(resultSet.getString("idNoeKhodro"));
//			moshtarakList.setNoeKhodroOnvan(resultSet.getString("onvan"));
//
//			if (resultSet.getDate("tarikhShoro") != null)
//				moshtarakList.setTarikhShoroHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhShoro")));
//			else
//				moshtarakList.setTarikhShoroHejri("");
//
//			if (resultSet.getDate("tarikhEngheza") != null)
//				moshtarakList.setTarikhEnghezaHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhEngheza")));
//			else
//				moshtarakList.setTarikhEnghezaHejri("");
//
//			int noeEshterak = resultSet.getInt("noeEshterak");
//			moshtarakList.setNoeEshterakName(((ComboObject)Util.getFromArrayList("noeEshterak", noeEshterak)).getName());
//
//			int noeService = resultSet.getInt("noeService");
//			moshtarakList.setNoeServiceName(((ComboObject)Util.getFromArrayList("noeService", noeService)).getName());
//
//			int vazeat = resultSet.getInt("vazeat");
//			moshtarakList.setVazeatName(((ComboObject)Util.getFromArrayList("vazeat", vazeat)).getName());
//
//			int guarantee = resultSet.getInt("guarantee");
//			moshtarakList.setGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", guarantee)).getName());

            return moshtarakList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //	public ValueObject resultSetToList(ResultSet resultSet) {
    //		try {
    //
    //			MoshtarakList moshtarakList = new MoshtarakList();
    //
    //			moshtarakList.setId(resultSet.getString("id"));
    //			moshtarakList.setEshterakId(resultSet.getString("eshterakId"));
    //			moshtarakList.setNoeEshterak(new Integer(resultSet.getInt("noeEshterak")));
    //			moshtarakList.setNoeService(new Integer(resultSet.getInt("noeService")));
    //			moshtarakList.setVazeat(new Integer(resultSet.getInt("vazeat")));
    //			moshtarakList.setNameKhanevadegi(resultSet.getString("nameKhanevadegi"));
    //			moshtarakList.setName(resultSet.getString("name"));
    //			moshtarakList.setEmail(resultSet.getString("email"));
    //			moshtarakList.setShomarePelak(resultSet.getString("shomarePelak"));
    //			moshtarakList.setShomareShasi(resultSet.getString("shomareShasi"));
    //			moshtarakList.setMoshtarakYaNa(new Integer(resultSet.getInt("moshtarakYaNa")));
    //			int moshtarakYaNa = moshtarakList.getMoshtarakYaNa().intValue();
    //			moshtarakList.setMoshtarakYaNaName(((ComboObject)Util.getFromArrayList("yesNo", moshtarakYaNa)).getName());
    //
    //			//////////////////////////////////////
    //			// This section added due to compatibility with 'DARKHAST TAGHEER' entity
    //			// note : shall implment in a different way to improve performance in Moshtarak
    //
    //			moshtarakList.setAddress(resultSet.getString("address"));
    //
    //			if (resultSet.getDate("tarikhTavalod") != null)
    //				moshtarakList.setTarikhTavalodHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhTavalod")));
    //			else
    //				moshtarakList.setTarikhTavalodHejri("");
    //
    //			moshtarakList.setPostCode(resultSet.getString("postCode"));
    //			moshtarakList.setTel(resultSet.getString("tel"));
    //			moshtarakList.setMobile(resultSet.getString("mobile"));
    //
    //			String shahrId = resultSet.getString("shahrId");
    //			moshtarakList.setShahrId(shahrId);
    //			ShahrLocal shahrLocal = ShahrUtil.getLocalHome().findByPrimaryKey(shahrId);
    //			if (shahrLocal != null) {
    //				ShahrModel shahrModel = shahrLocal.getShahrModel();
    //				moshtarakList.setShahrName(shahrModel.getShahrName());
    //			}
    //
    //			String rangeKhodroId = resultSet.getString("rangeKhodroId");
    //			moshtarakList.setRangeKhodroId(rangeKhodroId);
    //			RangeKhodroLocal rangeKhodroLocal = RangeKhodroUtil.getLocalHome().findByPrimaryKey(resultSet.getString("rangeKhodroId"));
    //			if (rangeKhodroLocal != null) {
    //				RangeKhodroModel rangeKhodroModel = rangeKhodroLocal.getRangeKhodroModel();
    //				moshtarakList.setRangeKhodroOnvan(rangeKhodroModel.getOnvan());
    //			}
    //
    //			//////////////////////////////////////
    //
    //			NoeKhodroLocal noeKhodroLocal = NoeKhodroUtil.getLocalHome().findByPrimaryKey(resultSet.getString("noeKhodroId"));
    //			if (noeKhodroLocal != null) {
    //				NoeKhodroModel noeKhodroModel = noeKhodroLocal.getNoeKhodroModel();
    //				moshtarakList.setNoeKhodroId(noeKhodroModel.getId());
    //				moshtarakList.setNoeKhodroOnvan(noeKhodroModel.getOnvan());
    //			}
    //
    //			if (resultSet.getDate("tarikhShoro") != null)
    //				moshtarakList.setTarikhShoroHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhShoro")));
    //			else
    //				moshtarakList.setTarikhShoroHejri("");
    //
    //			if (resultSet.getDate("tarikhEngheza") != null)
    //				moshtarakList.setTarikhEnghezaHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhEngheza")));
    //			else
    //				moshtarakList.setTarikhEnghezaHejri("");
    //
    //			if (resultSet.getDate("tarikhAkharinEmail") != null)
    //				moshtarakList.setTarikhAkharinEmailHejri(HejriUtil.chrisToHejri(resultSet.getDate("tarikhAkharinEmail")));
    //			else
    //				moshtarakList.setTarikhAkharinEmailHejri("");
    //
    //			int noeEshterak = resultSet.getInt("noeEshterak");
    //			moshtarakList.setNoeEshterakName(((ComboObject)Util.getFromArrayList("noeEshterak", noeEshterak)).getName());
    //
    //			int noeService = resultSet.getInt("noeService");
    //			moshtarakList.setNoeServiceName(((ComboObject)Util.getFromArrayList("noeService", noeService)).getName());
    //
    //			int vazeat = resultSet.getInt("vazeat");
    //			moshtarakList.setVazeatName(((ComboObject)Util.getFromArrayList("vazeat", vazeat)).getName());
    //
    //			int guarantee = resultSet.getInt("guarantee");
    //			moshtarakList.setGuaranteeName(((ComboObject)Util.getFromArrayList("yesNo", guarantee)).getName());
    //
    //			return moshtarakList;
    //		} catch (Exception e) {
    //			e.printStackTrace();
    //		}
    //		return null;
    //	}

    public ValueObject resultSetToBean(ResultSet resultSet) {
        try {
            MoshtarakModel moshtarakModel = new MoshtarakModel();
            moshtarakModel.setId(resultSet.getString("id"));
            return moshtarakModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @ejb.interface-method
     * 	 view-type = "local"
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public QueryResult readList(QueryObject queryObject) throws ProxyException {

        setAsView(queryObject, "moshtarak", "MoshtarakList");
//        if(isDatabaseSQL()){
//            if (queryObject.getToIndex() > 0)
//                queryObject.setSelectFields("TOP " + queryObject.getToIndex() + " *");
//        }
//        else{
//			if (queryObject.getToIndex() > 0){
//				if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0){
//					if(queryObject.getWhere().indexOf(" and rownum<")!=-1){
//						String whereStr = queryObject.getWhere();
//						String tmp = whereStr.substring(whereStr.indexOf(" and rownum<"),whereStr.indexOf(" ",whereStr.indexOf("rownum<")+7));
//						queryObject.setWhere(whereStr.replaceFirst(tmp,""));
//					}
//					queryObject.setWhere(queryObject.getWhere()+" and rownum<" + queryObject.getToIndex()+" ");
//				}
//				else
//					queryObject.setWhere("rownum<" + queryObject.getToIndex()+" ");
//			}
//        }

        return super.readList(queryObject);
    }

    /**
     * @ejb.interface-method
     * @ejb.transaction
     * 	 type = "Supports"
     */
    public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException {
        setAsView(queryObject, "moshtarak", "MoshtarakList");
//		queryObject.setTables("MoshtarakReport");
//		queryObject.setJoined(false);
//		queryObject.setOrderTable("");
//
//		if (queryObject.getWhere() != null && queryObject.getWhere().length() != 0)
//			queryObject.setWhere(queryObject.getWhere().replaceAll("moshtarak\\p{Punct}", "moshtarakReport."));

        return super.report(queryObject, connection);
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
