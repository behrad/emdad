/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Jun 9, 2003
 * Time: 5:50:57 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.util;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import com.objectj.emdad.ejb.*;
import com.objectj.emdad.proxy.QueryElement;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.proxy.QueryResult;
import com.objectj.emdad.ejb.util.Constants;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class Validators {

    protected static Logger log = Logger.getLogger(Validators.class.getName());

    public static void darkhastEshterakValidator(DarkhastEshterakModel vo, ActionErrors errors) throws Exception {
//		try {
        if (vo.getNahvePardakht().intValue() == 1) {
            if (vo.getShomareFish() == null || vo.getShomareFish().length() == 0)
                errors.add("required", new ActionError("errors.required.shomareFish"));
            if (vo.getTarikhFish() == null)
                errors.add("required", new ActionError("errors.required.tarikhFish"));
            if (vo.getNameShobe() == null || vo.getNameShobe().length() == 0)
                errors.add("required", new ActionError("errors.required.nameShobe"));
        }

        if (vo.getGarantee().intValue() == 1)
            if (vo.getTarikhEnghezaGarantee() == null)
                errors.add("required", new ActionError("errors.required.tarikhEnghezaGarantee"));

        if (vo.getSaleSakht() != null && vo.getSaleSakht().toString().length() != 4)
            errors.add("length", new ActionError("errors.length.saleSakht"));
//		} catch (Exception e) {
//			errors.add(e.toString(), new ActionError("errors.Validator"));
//			e.printStackTrace();
//		}
    }

    public static void rokhdadValidator(RokhdadModel vo, String eshterakId, String shahrId, ActionErrors errors) throws Exception {
//		try {
        if (!errors.isEmpty())
            log.info("error.size()=" + errors.size());

        if (shahrId.trim().equals(Constants.getShahr_Tehran().trim())) {
            if (vo.getMantagheh() == null || vo.getMantagheh().intValue() == 0)
                errors.add("mantaghehRequired", new ActionError("rokhdad.mantagheh.required"));
        }

        if (vo.getKilometerKarkard() == null || vo.getKilometerKarkard().intValue() == 0)
            errors.add("kilometerKarkardRequired", new ActionError("emdad.payan.kilometerKarkard.notZero"));

//        String moshtarakId = UserAccessEntity.stringQuery("SELECT id FROM moshtarak WHERE eshterakId = '" + eshterakId + "'", "id");
//        String rs = UserAccessEntity.stringQuery("SELECT rokhdadId  FROM rokhdad where moshtarakId='" + moshtarakId + "' AND eghdamShodeh=2 and id<>'"+vo.getId()+"'", "rokhdadId");
//        if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(rs)) {
//            errors.add("repl", new ActionError("rokhdad.notcompleted.exist", rs));
//       }
//        rs = UserAccessEntity.stringQuery("SELECT emdadId  FROM emdadList where emdadList.moshtarakId='" + moshtarakId +"' AND emdadList.vazeatKonuni <> 2 ", "emdadId");
//        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(rs)) {
//            errors.add("repl", new ActionError("emdad.notcompleted.exist", rs));
//       }
        String noeService=null;
        if (vo.getNoeService() == null || vo.getNoeService().intValue() == 0)
            noeService = UserAccessEntity.stringQuery("SELECT noeService FROM moshtarak WHERE eshterakId = '" + eshterakId + "'", "noeService");
        else
            noeService = vo.getNoeService().toString();

        if ((noeService == null) || (noeService.length() == 0)) {
            errors.add("rokhdad.nonexistent.moshtarak", new ActionError("rokhdad.nonexistent.moshtarak", eshterakId));
        }else {
            if ((Integer.parseInt(noeService) != 1) && (vo.getKhadamateVijeh().intValue() == 1))
                errors.add("ss", new ActionError("errors.rokhdad.khadamatvije"));
        }

//		} catch (Exception e) {
//			errors.add(e.toString(), new ActionError("errors.Validator"));
//			e.printStackTrace();
//		}

    }

    protected void checkForIncomplete(Connection c, String moshtarakId, String rokhdadIdO, ActionErrors errors) {
        try {
            String rs = UserAccessEntity.stringQuery("SELECT rokhdadId  FROM rokhdad where moshtarakId='" + moshtarakId + "' AND eghdamShodeh=2 and id<>'"+rokhdadIdO+"'", "rokhdadId");
            if (rs==null) {
                    errors.add("repl", new ActionError("rokhdad.notcompleted.exist", rs));
           }
            rs = UserAccessEntity.stringQuery("SELECT emdadId  FROM emdadList where emdadList.moshtarakId='" + moshtarakId +"' AND emdadList.vazeatKonuni <> 2 ", "emdadId");
            if (rs==null) {
                    errors.add("repl", new ActionError("emdad.notcompleted.exist",rs));
           }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }

    }

    public static void moshtarakValidator(Connection c, MoshtarakModel vo, ActionErrors errors) throws Exception {
//		try {
        if (vo.getGuarantee().intValue() == 1)
            if (vo.getTarikhEnghezaGuarantee() == null)
                errors.add("required", new ActionError("errors.required.tarikhEnghezaGuarantee"));
        if (vo.getSaleSakht() != null && vo.getSaleSakht().toString().length() != 4)
            errors.add("length", new ActionError("errors.length.saleSakht"));

        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("moshtarak");
        qo.setJoined(false);
        qo.setSelectFields("id,eshterakId");

        /*            if ( vo.getEshterakId() != null && vo.getEshterakId().trim().length() != 0){
                        qo.setWhere("eshterakId='" + vo.getEshterakId().trim()+"'");
                        ResultSet rs = MoshtarakUtil.getLocalHome().advanceRead(qo);
                        if (rs.next()){
                            String s = rs.getString("id");
                            if (rs.next() || (!s.equals(vo.getId())))
                                errors.add("soId", new ActionError("errors.eshterakId.already.exists"));
                        }
                    }*/
        ArrayList al = null;
        if (vo.getMoshtarakYaNa().intValue()==1)
            if (vo.getNaghd().intValue() + vo.getTaahodi().intValue() + vo.getAghsat().intValue() - vo.getTakhfif().intValue() != vo.getHazinehPardakhtShodeh().intValue()) {
                errors.add("aa", new ActionError("errors.moshtarak.sumnotequal"));
            }

        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getShomarePelak())) {
            //qo.setWhere("shomarePelak='" + vo.getShomarePelak().trim() + "'");
            qo.emptyElements();
            qo.setWhere("shomarePelak = ? ");
            qo.addElement(new QueryElement("String", vo.getShomarePelak().trim()));
            al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.shomarePelak.already.exists" , ((ArrayList)al.get(0)).get(1)));
        }

        if (vo.getShomareShasi() != null && vo.getShomareShasi().trim().length() != 0) {  // && vo.getMoshtarakYaNa().intValue() == 1
//            String eid = UserAccessEntity.stringQuery("select eshterakId from moshtarak where shomareShasi='" + vo.getShomareShasi().trim() + "'", "eshterakId");
            qo.emptyElements();
            qo.setWhere("shomareShasi='" + vo.getShomareShasi().trim() + "'");
            al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.shomareShasi.already.exists" , ((ArrayList)al.get(0)).get(1)));
        } else
            errors.add("soId", new ActionError("errors.shomareShasi.already.exists"));

        if (vo.getShomareMotor() != null && vo.getShomareMotor().trim().length() != 0 && vo.getMoshtarakYaNa().intValue() == 1) {
            qo.emptyElements();
            qo.setWhere("shomareMotor='" + vo.getShomareMotor().trim() + "'");
            al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.shomareMotor.already.exists" , ((ArrayList)al.get(0)).get(1)));
        }

        if (vo.getShomareVIN() != null && vo.getShomareVIN().trim().length() != 0 && vo.getMoshtarakYaNa().intValue() == 1) {
            qo.emptyElements();
            qo.setWhere("shomareVIN='" + vo.getShomareVIN().trim() + "'");
            al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.shomareVIN.already.exists" , ((ArrayList)al.get(0)).get(1)));
        }

        return;
    }

    public static void emdadValidator(Connection c, EmdadModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("emdad");
        qo.setJoined(false);
        qo.setSelectFields("shomarehFactor");
//        ResultSet rs = null;
        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(vo.getShomarehFactor())) {
            qo.emptyElements();
            qo.setWhere("shomarehFactor='" + vo.getShomarehFactor() + "'");
            ArrayList al = Util.advanceRead(qo);
//            if (Util.hasReplicate(al, vo.getId()))
//            rs = EmdadUtil.getLocalHome().advanceRead(c, qo);
            if (al.size()>0) {
                errors.add("sold", new ActionError("errors.shomarehFactor.is.duplicate"));
            }
        }
        /*
        if ( rokhdadDate + 3month < current date ) {
			errors.add( "late", new ActionError( "emdad.rokhdad.after.3month" );
		}
        */
        if (vo.getNoeEmdad().intValue()!=1) //-- Vije
            if (vo.getNoeKhedmateVije().intValue()<1)
                errors.add("sold", new ActionError("emdad.noeKhedmateVije.notSet"));

        return;
    }

    public static String rokhdadAlreadyServiced(Connection c, String rokhdadId, ActionErrors errors) {
        if (com.objectj.emdad.ejb.util.Util.isNotEmpty(rokhdadId)) {
			String moshtarakId = UserAccessEntity.stringQuery("Select moshtarakId from rokhdad where id='"+rokhdadId+"'", "moshtarakId", c);
			String noeService = UserAccessEntity.stringQuery("Select noeService from moshtarak where id='"+moshtarakId+"'", "noeService", c);
			if ( !noeService.equals( "1" ) ) {
				String eid = UserAccessEntity.stringQuery("Select emdadId from emdad where rokhdadId='"+rokhdadId+"' AND vazeatKonuni <> 2 ", "emdadId", c);
				if ( com.objectj.emdad.ejb.util.Util.isNotEmpty(eid)) {
					if (errors!=null)
						errors.add("repl", new ActionError("emdad.notcompleted.exist",eid));
					return eid;
				}
			}
        }
        return null;
    }

    public static void qateValidator(Connection c, QateModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(100);
        qo.setTables("qate");
        qo.setJoined(false);
        qo.setSelectFields("id");

        if (vo.getShomareFanni() != null && vo.getShomareFanni().trim().length() != 0) {
            qo.setWhere(" shomareFanni='" + vo.getShomareFanni().trim() + "' ");
            ArrayList al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.shomareFanni.already.exists"));
        }
        return;
    }

    public static void shakhsValidator(Connection c, ShakhsModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("shakhs");
        qo.setJoined(false);
        qo.setSelectFields("id");

        if (vo.getUsername() != null && vo.getUsername().trim().length() != 0) {
            qo.setWhere(" username='" + vo.getUsername().trim() + "' ");
            ArrayList al = Util.advanceRead(qo);
            if (Util.hasReplicate(al, vo.getId()))
                errors.add("soId", new ActionError("errors.username.already.exists"));
        }
        return;
    }


    public static String mostanadatRokhdadValidator(Connection c, MostanadatRokhdadModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("rokhdad");
        qo.setJoined(false);
        qo.setSelectFields("id");
        String s = null;

        if (vo.getRokhdadRokhdadId() != null & vo.getRokhdadRokhdadId().toString().trim().length() != 0) {
            qo.setWhere(" rokhdadId='" + vo.getRokhdadRokhdadId().toString().trim() + "' ");
            ArrayList al = Util.advanceRead(qo);
            if (al.size()<1) {
                errors.add("soId", new ActionError("errors.rokhdad.doesnot.exist"));
            } else
                s = (String) ((ArrayList)al.get(0)).get(0);
        }
        return s;
    }

    public static boolean chackValidateZaman(String zaman) {
        try {
            if (zaman == null || zaman.length() == 0)
                return true;
            if (zaman.indexOf(':') == -1)
                return false;
            int hour = Integer.valueOf(zaman.substring(0, zaman.indexOf(':'))).intValue();
            if (hour > 23 || hour < 0)
                return false;
            int minute = Integer.valueOf(zaman.substring(zaman.indexOf(':') + 1)).intValue();
            if (minute > 59 || minute < 0)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void khodroJagozinValidator(Connection c, KhodrojagozinModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("khodrojagozin");
        qo.setJoined(false);
        qo.setSelectFields("id");

        if (vo.getShomarehPelak() != null && vo.getShomarehPelak().trim().length() != 0) {
            qo.emptyElements();
            qo.setWhere("shomarePelak = ? ");
            qo.addElement(new QueryElement("String", vo.getShomarehPelak().trim()));
            if (Util.hasReplicate(Util.advanceRead(qo), vo.getId()))
                errors.add("soId", new ActionError("errors.shomarePelak.already.exists"));
        }

        qo.emptyElements();
        if (vo.getShomarehMotor() != null && vo.getShomarehMotor().trim().length() != 0) {
            qo.setWhere(" shomarehMotor='" + vo.getShomarehMotor().trim() + "' ");
            if (Util.hasReplicate(Util.advanceRead(qo), vo.getId()))
                errors.add("soId", new ActionError("errors.shomareMotor.already.exists"));
        }

        if (vo.getShomarehShasi() != null && vo.getShomarehShasi().trim().length() != 0) {
            qo.setWhere(" shomarehShasi='" + vo.getShomarehShasi().trim() + "' ");
            if (Util.hasReplicate(Util.advanceRead(qo), vo.getId()))
                errors.add("soId", new ActionError("errors.shomareShasi.already.exists"));
        }

        if (vo.getShomarehVIN() != null && vo.getShomarehVIN().trim().length() != 0) {
            qo.setWhere(" shomarehVIN='" + vo.getShomarehVIN().trim() + "' ");
            if (Util.hasReplicate(Util.advanceRead(qo), vo.getId()))
                errors.add("soId", new ActionError("errors.shomareVIN.already.exists"));
        }

        if (vo.getFaal() != null && vo.getFaal().intValue() == 0) {
            errors.add("soId", new ActionError("errors.faal.should.be.filled"));
        }

        if (!(vo.getSalesakht().intValue() >= 1000 && vo.getSalesakht().intValue() <= 9999)) {
            errors.add("soId", new ActionError("errors.length.saleSakht"));
        }
        return;
    }

    public static String peigiriEzamgarValidator(Connection c, PeigiriEzamgarModel vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("emdad");
        qo.setJoined(false);
        qo.setSelectFields("id");
        String s = null;

        if (vo.getEmdadEmdadId() != null & vo.getEmdadEmdadId().toString().trim().length() != 0) {
            qo.setWhere(" emdadId='" + vo.getEmdadEmdadId().toString().trim() + "' ");
            ArrayList al = Util.advanceRead(qo);
            if (al.size()>0)
                s =(String) ((ArrayList)al.get(0)).get(0) ;
            else
                errors.add("soId", new ActionError("errors.emdad.doesnot.exist")); //emdad.doesnot.exist
        }
        return s;
    }

    public static String anbarEmdadgarValidator(Connection c, AnbarEmdadgarList vo, ActionErrors errors) throws ProxyException, Exception {

        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setTables("anbarEmdadgar, emdadgar, qate");
        qo.setSelectFields("id,saghfeTedadi,saghfeMojoodi");
//		try {
        qo.setWhere(" anbarEmdadgar.emdadgarId='" + vo.getEmdadgarId().trim() + "'  AND anbarEmdadgar.qateId='" + vo.getQateId().trim() + "'");
        ArrayList al = Util.advanceRead(qo);
        if (Util.hasReplicate(al, vo.getId())) {
            if (errors != null)
                errors.add("soId", new ActionError("errors.emdadgar-qate.already.exists"));
            else
                throw new ProxyException(new Exception("errors.emdadgar-qate.already.exists"));
            return null;
        }

        if (vo.getMojoodi().intValue() < 0) {
            if (errors != null)
                errors.add("soId", new ActionError("errors.anbarEmdadgar.mojoodi"));
            else
                throw new ProxyException(new Exception("errors.anbarEmdadgar.mojoodi"));
            return null;
        }
//        ResultSet rs = AnbarEmdadgarUtil.getLocalHome().advanceRead(c, qo);
        if (al.size()>0) {
            ArrayList al2 = (ArrayList) al.get(0);
            int saghfeTedadi = Integer.parseInt((String) al2.get(1)); //"saghfeTedadi");
            int saghfeMojoodi = Integer.parseInt((String) al2.get(2)); //("saghfeMojoodi");

            if (vo.getMojoodi().intValue() > saghfeTedadi) {
                if (errors != null)
                    errors.add("soId", new ActionError("errors.anbarEmdadgar.saghfeTedadi"));
                else
                    throw new ProxyException(new Exception("errors.anbarEmdadgar.saghfeTedadi"));
            }

            String s = UserAccessEntity.stringQuery("select SUM(mojoodi * gheimat) as arzesh from anbaremdadgar, qate where anbaremdadgar.qateId = qate.id AND anbaremdadgar.emdadgarId = '" + vo.getEmdadgarId() + "'","arzesh");
            int valueAnbar = Integer.parseInt(s);

//            if (valueAnbar + (vo.getMojoodi().intValue() * rs.getInt("gheimat")) > saghfeMojoodi) {
//                if (errors != null) {
//                    errors.add("soId", new ActionError("errors.anbarEmdadgar.saghfeMojoodi"));
//                }
//                else {
//                    throw new ProxyException(new Exception("errors.anbarEmdadgar.saghfeMojoodi"));
//                }
//            }

//            if (rs.getInt(11) < rs.getInt(23)) {
//                if (errors != null) {
//                    errors.add("soId", new ActionError("errors.anbarEmdadgar.satheMaharat"));
//                }
//                else {
//                    throw new ProxyException(new Exception("errors.anbarEmdadgar.satheMaharat"));
//                }
//            }

        }
        else {

            EmdadgarModel emdadgarModel = EmdadgarUtil.getLocalHome().findByPrimaryKey(vo.getEmdadgarId()).getEmdadgarModel();
            QateModel qateModel = QateUtil.getLocalHome().findByPrimaryKey(vo.getQateId()).getQateModel();

            // check for saghfeRiali and saghfeTedadi
            int saghfeTedadi = qateModel.getSaghfeTedadi().intValue();
            int saghfeMojoodi = emdadgarModel.getSaghfeMojoodi().intValue();

            if (vo.getMojoodi().intValue() > saghfeTedadi) {
                if (errors != null) {
                    errors.add("soId", new ActionError("errors.anbarEmdadgar.saghfeTedadi"));
                }
                else {
                    throw new ProxyException(new Exception("errors.anbarEmdadgar.saghfeTedadi"));
                }
            }

            // compute value anbar
            String s = UserAccessEntity.stringQuery("select SUM(mojoodi * gheimat) as arzesh from anbaremdadgar, qate where anbaremdadgar.qateId = qate.id AND anbaremdadgar.emdadgarId = '" + vo.getEmdadgarId() + "'","arzesh");
            int valueAnbar = Integer.parseInt(s);
            ////////////////////////

            if (valueAnbar + (vo.getMojoodi().intValue() * qateModel.getGheimat().intValue()) > saghfeMojoodi) {
                if (errors != null) {
                    errors.add("soId", new ActionError("errors.anbarEmdadgar.saghfeMojoodi"));
                }
                else {
                    throw new ProxyException(new Exception("errors.anbarEmdadgar.saghfeMojoodi"));
                }
            }


            if (emdadgarModel.getSatheMaharat().intValue() < qateModel.getSatheMaharat().intValue()) {
                if (errors != null) {
                    errors.add("soId", new ActionError("errors.anbarEmdadgar.satheMaharat"));
                }
                else {
                    throw new ProxyException(new Exception("errors.anbarEmdadgar.satheMaharat"));
                }
            }

        }

        return null;

    }

    public static void mojoodiAnbarValidator(Connection c, MojoodiAnbarList vo, ActionErrors errors) throws Exception {
        QueryObject qo = new QueryObject();
        qo.setFromIndex(0);
        qo.setToIndex(2);
        qo.setSelectFields("mojoodiAnbar.id as id");
        qo.setTables("mojoodiAnbar, qate");
        qo.setWhere(" mojoodiAnbar.anbarId='" + vo.getAnbarId() + "'  AND mojoodiAnbar.qateId='" + vo.getQateId().trim() + "'");
        ArrayList al = Util.advanceRead(qo);
        if (Util.hasReplicate(al, vo.getId()))
            errors.add("aa", new ActionError("errors.anbar-qate.already.exists"));

    }

    public static void darkhastQateValidator(DarkhastQateModel vo, ActionErrors errors) throws Exception {

        if (vo.getTedadDarkhasti() != null && vo.getTedadSarparast() != null && vo.getTaeedShodehSarparast() != null && vo.getTaeedShodehSarparast().intValue() == 1)
            if (vo.getTedadSarparast().intValue() > vo.getTedadDarkhasti().intValue())
                errors.add("aa", new ActionError("tedadSarparast.more.tedadDarkhasti"));

        if (vo.getTedadSarparast() != null && vo.getTedadAnbar() != null && vo.getTaeedShodeAnbar() != null && vo.getTaeedShodeAnbar().intValue() == 1)
            if (vo.getTedadSarparast().intValue() < vo.getTedadAnbar().intValue())
                errors.add("aa", new ActionError("tedadAnbar.more.tedadSarparast"));

        if (vo.getTaeedShodehSarparast() != null && vo.getTaeedShodehSarparast().intValue() == 1 && vo.getTedadSarparast() != null && vo.getTedadSarparast().intValue() <= 0)
            errors.add("aa", new ActionError("required.tedadeSarparast"));

//        try{
        DarkhastQateLocal dql = DarkhastQateUtil.getLocalHome().findByPrimaryKey(vo.getId());
        QateModel qateModel = dql.getQate().getQateModel();
        EmdadgarModel emdadgarModel = dql.getEmdadgar().getEmdadgarModel();
        if (emdadgarModel.getSatheMaharat().intValue() < qateModel.getSatheMaharat().intValue())
            errors.add("aa", new ActionError("errors.satheMaharatQate.more", qateModel.getQateId()));
//        }catch(Exception e){
//        }
    }

    public static void serviceDoreiValidator(Connection c, BaseForm form, ActionErrors errors) throws Exception {
        String moshtarakId = (String)form.get( "eshterakId" );
        String eshterakId = UserAccessEntity.stringQuery( "SELECT id FROM moshtarak WHERE eshterakId = '" + moshtarakId + "'", "id" );
        String noeServiceDorei = (String)form.get("noeServiceDorei");
        if( eshterakId.length() == 0 ) {
            errors.add( "moshtarakInvalid", new ActionError( "errors.eshterakId.doesnt.exists" ) );
        }
        System.out.println( " NoeService Dorei: " + noeServiceDorei + " Moshtarak: " + eshterakId );
        String service = UserAccessEntity.stringQuery( "select id from serviceDorei where noeServiceDorei='" + noeServiceDorei + "' AND moshtarakId='" + eshterakId + "'", "id" );
        System.out.println( "Service Founded: " + service );
        if( service.length() != 0 ) {
            errors.add( "serviceInvalid", new ActionError( "import.xls.service.moshtarak.invalid" ) );
        }

        String[] az = UserAccessEntity.stringQuerys( "select azKilometer,taKilometer from noeServiceDorei where id='" + noeServiceDorei + "'", "azKilometer,taKilometer" );
        int kilometer = ((Integer)form.get( "kilometerKarkard" )).intValue();
        if ( ! ( Integer.parseInt( az[0] ) <= kilometer && kilometer <= Integer.parseInt( az[1] ) ) ) {
            errors.add( "kilometerInvalid", new ActionError( "import.xls.service.karkard.invalid" ) );
        }
    }

    public static boolean updateMojoodiAllowed(String emdadgarId, String qateId, Integer update) throws ProxyException {
        try {
            String v = UserAccessEntity.stringQuery("select mojoodi + "+update.intValue()+" as rslt from anbarEmdadgar where emdadgarId = '" + emdadgarId + "' AND qateId = '" + qateId + "' ", "rslt");
            if (com.objectj.emdad.ejb.util.Util.isEmpty(v))
                return false;
            return Integer.parseInt(v) >= 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ProxyException(exception);
        }
    }

}
