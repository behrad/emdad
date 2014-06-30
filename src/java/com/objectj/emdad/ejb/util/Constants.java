/**
 * Created by IntelliJ IDEA.
 * User: Faraz
 * Date: Jul 14, 2003
 * Time: 1:40:58 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import org.apache.log4j.Logger;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;
import com.objectj.emdad.ejb.UserAccessEntity;

public class Constants
{
    protected static Logger log = Logger.getLogger(Constants.class.getName());
    protected static File inputFile = null;

    public static final String ENTITY_ALTERNATE = "2";

    public static final String ROLE_SUPERUSER          = "superuser";
    public static final String ROLE_ADMIN              = "admin";
    public static final String ROLE_ESHTERAK           = "eshterak";
    public static final String ROLE_FOROUSH            = "foroush";
    public static final String ROLE_DOADMIN            = "doAdmin";
    public static final String ROLE_EMDADGARESTEKHDAMI = "emdadgar";
    public static final String ROLE_EMDADGARPEYMANI    = "emdadgarPeymani";
    public static final String ROLE_OMOORNAMAYANDEGI   = "omoorNamayandegi";
    public static final String ROLE_OPERATOR           = "operator";
    public static final String ROLE_NAMAYANDEGI        = "namayandegi";
    public static final String ROLE_SARPARASTEMDADGAR  = "sarparastEmdadgar";
    public static final String ROLE_MALIOP             = "maliOp";
    public static final String ROLE_ANBAR              = "anbar";
    public static final String ROLE_MOHANDESI          = "mohandesi";
    public static final String ROLE_NAMAYANDEMODIRIAT  = "amaliyatOp";
    public static final String ROLE_AMALIYATMODIR      = "amaliyatMgr";
    public static final String ROLE_KHADAMATVIJE       = "khadamatVije";
    public static final String ROLE_DAFTAROSTANI       = "daftarOstani";
    public static final String ROLE_EZAMGAR_ADI        = "ezamgarAdi";
    public static final String ROLE_EZAMGAR_VIJE       = "ezamgarVije";
    public static final String ROLE_TARHOBARNAME       = "tarhoBarname";
    public static final String ROLE_BARNAMERIZOP       = "barnamerizOP";
    public static final String ROLE_GUARANTEE          = "guarantee";
    public static final String ROLE_BARNAMERIZSEFARESHAT = "barnamerizSefareshat";
    public static final String ROLE_GOZARESHGAR        = "gozareshgar";

    public static final String USER_SESSION = "user_session";

    public static final String APPLICATION_POOL = "application_pool" ;
    public static final String APPLICATION_POOL_PREFIX = "application_pool_";

    public static final String EMPTY_CODE = "000000000000000000o";

    public static String getConstant(String key) {
        try {
            String path = (String) com.objectj.emdad.ejb.util.Util.get("application.constants.path");
            inputFile = new File(path+"Constants.properties");

            Properties props = new Properties();
            props.load(new FileInputStream(inputFile));

            if (!props.containsKey(key)) throw new Exception ("No such a Key");
            return props.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }
    public static int getNaghshIdFromRole(String naghshName) throws Exception {
        return UserAccessEntity.getNaghshIdFromRole(naghshName);
    }

    public static int getBarnamerizSefareshatShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_BARNAMERIZSEFARESHAT);
    }

    public static int getBarnamerizOpShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_BARNAMERIZOP);
    }

    public static int getTarhoBarnamehShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_TARHOBARNAME);
    }

    public static int getSuperuserShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_SUPERUSER);
    }

    public static int getAdminShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_ADMIN);
    }

    public static int getEshterakShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_ESHTERAK);
    }

    public static int getForoushShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_FOROUSH);
    }

    public static int getDoAdminShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_DOADMIN);
    }

    public static int getEmdadgarEstekhdamiShoghlId() throws Exception {
        return getNaghshIdFromRole(ROLE_EMDADGARESTEKHDAMI);
    }

    public static int getEmdadgarPeymaniShoghlId() throws Exception {
        return getNaghshIdFromRole(ROLE_EMDADGARPEYMANI);
    }

    public static int getOmoorNamayandegiShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_OMOORNAMAYANDEGI);
    }

    public static int getOperatorShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_OPERATOR);
    }

    public static int getNamayandegiShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_NAMAYANDEGI);
    }

    public static int getSarparastEmdadgarShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_SARPARASTEMDADGAR);
    }

    public static int getMaliOpShoghlId()throws Exception{
        return getNaghshIdFromRole(ROLE_MALIOP);
    }

    public static int getAnbarShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_ANBAR);
    }

    public static int getMohandesiShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_MOHANDESI);
    }

    public static int getAmaliyatOpShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_NAMAYANDEMODIRIAT);
    }

    public static int getAmaliyatMgrShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_AMALIYATMODIR);
    }

    public static int getKhadamatVijeShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_KHADAMATVIJE);
    }

    public static int getDaftarOstaniShoghlId() throws Exception{
        return getNaghshIdFromRole(ROLE_DAFTAROSTANI);
    }

    public static int getEzamgarAdiShoghlId() throws Exception {
        return getNaghshIdFromRole(ROLE_EZAMGAR_ADI);
    }

    public static int getEzamgarVijeShoghlId() throws Exception {
	        return getNaghshIdFromRole(ROLE_EZAMGAR_VIJE);
    }

    public static int getEghdamshodeh_Kheir() throws Exception{
        return Integer.parseInt(getConstant("EghdamShodeh.Kheir"));
    }

    public static String getShahr_Tehran() {
        return getConstant("shahr.tehran");
    }

    public static String getShahr_Unknown() {
        return getConstant("shahr.namoshakhas");
    }

    public static String getMoshtari_Unknown() {
        return getConstant("moshtari.namoshakhas");
    }

    public static String getNoeEmdadgar_InactiveId() {
        return getConstant( "noeEmdadgar.inactive" );
    }

    public static String getNoekhodro_Unknown() {
        return getConstant("NoeKhodro.Namoshakhas");
    }

    public static String getRangekhodro_Unknown() {
        return getConstant("RangeKhodro.Namoshakhas");
    }

    public static String getBazaryab_Irankhodro() {
        return getConstant("Bazaryab.IranKhodro");
    }

    public static String getBazaryab_Unknown() {
        return getConstant("Bazaryab.Namoshakhas");
    }

    public static String getNoeEmdadgar_Jarsaghil() {
        return getConstant("NoeEmdadgar.Jarsaghil");
    }

    public static boolean getIsSQLServer() {
        return getConstant("system.DatabaseServer.SQL").equalsIgnoreCase("sql");
    }

    public static String getReportsURL() {
        return getConstant("report.server.url");
    }
}