/**
 * Created by IntelliJ IDEA.
 * User: Hamid Abbasi
 * Date: Sep 6, 2003
 * Time: 9:45:39 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import com.objectj.emdad.proxy.*;
import com.objectj.emdad.ejb.EmdadgarModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.jsa.web.action.BaseAction;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.proxy.ProxyException;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Statement;
import java.sql.Connection;

import org.apache.log4j.Logger;

public class ComboPool {
    protected Logger log = Logger.getLogger(this.getClass());
    static String dirties = "";
    static boolean updateIsBusy = false;
    static ThreadCombo tc = null;
    static String[] allCombo = {
        "ostan"         , "vazeatKhedmat"           , "noeEmdadgar"       , "noeKhodro"           , "rangeKhodro" ,
        "shahr"         , "dalileToolKeshidaneEmdad", "noeBazaryab"       , "bazaryabMotefareghe" ,
        "namayandegi"   , "daftarOstani"            , "khodrosaz"         , "emdadgar"            , "amelyat" ,
        "khodrojagozin" , "khodrojagozin_faal"      ,"namayandegi_amelyat", "bazaryab"            , "emdadgar_faal" ,
        "admin_roles"
    };

    public static String getComboKey(String entity) {
        return  entity+"-Combo";
    }

    public static ArrayList getCombo(String entity) {
        return getCombo(entity, null);
    }

    public static ArrayList getCombo(String entity, String filter) {
        String comboKey = getComboKey(entity);
        Object o = null;
        if (filter==null || filter.length()==0)
            o = Util.get(comboKey);
        if (o==null) {
            try {
                o = readCombo(entity,filter);
            } catch (Exception e) {
                Logger.getLogger("").error("readCombo Error",e);
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            if (filter==null || filter.length()==0)
                Util.add(comboKey, o);
        }
        return (ArrayList) o;
    }

    public static void setDirty(String entity) {
        int i = getComboIndex(entity);
        if (i==-1)
            return;

        if (tc==null)
            tc = new ThreadCombo();

        if (dirties.indexOf("["+entity+"]")==-1) {
            dirties += "["+entity+"]";
            if (i==9) dirties += "[amelyat][namayandegi_amelyat]";
            else if (i==12) dirties += "[emdadgar_faal]";
            else if (i==14) dirties += "[khodrojagozin_faal]";
        }
    }

    private static ArrayList updateCombo(String entity) {
        String comboKey = getComboKey(entity);
        Object o = null;
        try {
            o = readCombo(entity,null);
            Util.remove(comboKey);
            Util.add(comboKey, o);
        } catch (Exception e) {
            Logger.getLogger("").error("updateCombo Error",e);
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
        return (ArrayList) o;
    }

    private static int getComboIndex(String entity) {
        for (int i=0; i<allCombo.length; i++) {
            if (allCombo[i].equalsIgnoreCase(entity))
                return i;
        }
        return -1;
    }

    private static ArrayList readCombo(String entity, String filter) throws Exception {
        int i = getComboIndex(entity);
        if (i==-1)
            return null;

        ArrayList al = new ArrayList();
        switch (i) {
            case 0 :
                al = OstanSessionUtil.getLocalHome().create().readCombo("ostan","name").getResult();
                break;
            case 1 :
                al = VazeatKhedmatSessionUtil.getLocalHome().create().readCombo("vazeatKhedmat", "onvan").getResult();
                break;
            case 2 :
                al = NoeEmdadgarSessionUtil.getLocalHome().create().readCombo("noeEmdadgar", "onvan").getResult();
                break;
            case 3 :
                al = NoeKhodroSessionUtil.getLocalHome().create().readCombo("noeKhodro", "onvan").getResult();
                break;
            case 4 :
                al = RangeKhodroSessionUtil.getLocalHome().create().readCombo("rangeKhodro", "onvan", "rangeKhodro.baseRange = 1").getResult();
                break;
            case 5 :
                if (Constants.getIsSQLServer())
                    al = ShahrSessionUtil.getLocalHome().create().readCombo("view_shahr", "shahrName+' - '+ ostanName").getResult();
                else
                    al = ShahrSessionUtil.getLocalHome().create().readCombo("view_shahr", "shahrName || ' - ' || ostanName as shahrOstan","", "shahrOstan").getResult();
                break;
            case 6 :
                al = DalileToolKeshidaneEmdadSessionUtil.getLocalHome().create().readCombo("dalileToolKeshidaneEmdad", "onvan").getResult();
                break;
            case 7 :
                al = NoeBazaryabSessionUtil.getLocalHome().create().readCombo("noeBazaryab","onvan").getResult();
                break;
            case 8 :
                al = BazaryabMotefaregheSessionUtil.getLocalHome().create().readCombo("bazaryabMotefareghe","name").getResult();
                break;
            case 9 :
                if (Constants.getIsSQLServer())
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName + ' ' + LTRIM(namayandegiId)+ ' , ' + name","noeNamayandegi = 1","shahrName,namayandegiId").getResult();
                else
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName || ' ' || LTRIM(namayandegiId) || ' , ' || name","noeNamayandegi = 1","shahrName,namayandegiId").getResult();
                break;
            case 10 :
                al = DaftarOstaniSessionUtil.getLocalHome().create().readCombo("daftarOstani","name",filter).getResult();
                break;
            case 11 :
                al = KhodrosazSessionUtil.getLocalHome().create().readCombo("khodrosaz", "name",filter).getResult();
                break;
            case 12 :
                al = EmdadgarSessionUtil.getLocalHome().create().readCombo("emdadgar", "name",filter).getResult();
                break;
            case 13 :
                if (Constants.getIsSQLServer())
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName + ' ' + LTRIM(namayandegiId)+ ' , ' + name","noeNamayandegi = 2","shahrName,namayandegiId").getResult();
                else
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName || ' ' || LTRIM(namayandegiId) || ' , ' || name","noeNamayandegi = 2","shahrName,namayandegiId").getResult();
                break;
            case 14 :
                al = KhodrojagozinSessionUtil.getLocalHome().create().readCombo("khodrojagozin", "shomarehPelak", filter).getResult();
                break;
            case 15 :
                al = KhodrojagozinSessionUtil.getLocalHome().create().readCombo("khodrojagozin", "shomarehPelak",(filter!=null && filter.length()>0 ? filter+" AND " : "") + " faal = 1 ").getResult();
                break;
            case 16 :
                if (Constants.getIsSQLServer())
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName + ' ' +  LTRIM(namayandegiId)+ ' , ' + name","","shahrName,namayandegiId").getResult();
                else
                    al = NamayandegiSessionUtil.getLocalHome().create().readCombo("view_namayandegi"," shahrName || ' ' ||  LTRIM(namayandegiId) || ' , ' || name","","shahrName,namayandegiId").getResult();
                break;
            case 17 :
                if (Constants.getIsSQLServer())
                    al = BazaryabSessionUtil.getLocalHome().create().readCombo("bazaryab","dbo.BazaryabName(bazaryabKey, noeBazaryabId) AS bazaryabName" , "" , "bazaryabName").getResult();
                else
                    al = BazaryabSessionUtil.getLocalHome().create().readCombo("view_bazaryab","bazaryabName" , "" , "bazaryabName").getResult();
                break;
            case 18 :
//                EmdadgarModel em = new EmdadgarModel();
//                QueryObject qo = new QueryObject("emdadgar", "emdadgar", "noeEmdadgarId,name", false);
//                al = Exchanger.exhangeResultSetToValueObjectArray(null, qo, null, em, false).getResult()  ;
                if (Util.isEmpty(filter))
                    filter = "";
                else
                    filter += " AND ";
                filter += " noeEmdadgarId<>'"+Util.get("noeEmdadgar_InactiveId")+"' ";
                al = EmdadgarSessionUtil.getLocalHome().create().readCombo("emdadgar", "name",filter, "noeEmdadgarId,name").getResult();
                break;
            case 19 :
                al = ShakhsSessionUtil.getLocalHome().create().readCombo("admin_roles", "roleTitle").getResult();
                break;
            default :
                break;
        }

        return al;
    }

    public static void updateCombo() {
        if (updateIsBusy==true)
            return;
        updateIsBusy = true;
        Logger.getLogger("").info("000 doing updateCombo,dirties="+dirties);
        while (dirties.length()!=0) {
            int sep = dirties.indexOf("]");
            String entity = dirties.substring(1, sep);
            try {
                updateCombo(entity);
                if (sep<dirties.length())
                    dirties = dirties.substring(sep+1);
                else
                    dirties = "";
            } catch (Exception e) {
                Logger.getLogger("").error("updateCombo Error",e);
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
        }
        updateIsBusy = false;
    }

    public static String findInCombo(String entity, String id) {
        ArrayList al = getCombo(entity);
        for (int i=0; i<al.size(); i++) {
            ComboObject co = (ComboObject) al.get(i);
            if (co.getEid().equals(id))
                return co.getName();
        }
        return null;
    }

}

class ThreadCombo implements Runnable
{
    static final int comboRefreshDelay = 3; //  in minutes
    Thread t = new Thread(this);

    public ThreadCombo()
    {
        t.start();
    }

    public void run()
    {
        int i = 0;
        boolean done = false;

        while(true)
        {
            try{
                Thread.sleep(comboRefreshDelay * 60 * 1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            i++;
            ComboPool.updateCombo();

            if ( i%5==0 ) {
                Calendar c = Calendar.getInstance();
                if (c.get(Calendar.HOUR_OF_DAY)==1) {
                    if (done)
                        continue;
                    done = true;
                    String mgh = "update moshtarak set moshtarakYaNa=2 , noeService=2 where moshtarakYaNa=1 and tarikhEngheza<getdate()-1";
                    Connection conn = null;
                    Statement statement = null;
                    try {
                        conn = Util.getConnection();
                        statement = conn.createStatement();
                        Logger.getLogger("").info("mgh="+mgh);
                        statement.executeUpdate(mgh);
                    } catch (Exception e) {

                    }  finally {
                        try {
                            if (statement!=null)
                                statement.close();
                            if (conn!=null)
                                conn.close();
                        } catch (Exception e) {
                            Logger.getLogger("").error("update moshtarakYaNa Error",e);
                            e.printStackTrace();
                            done = false;
                        }
                    }
                } else
                    done = false;
            }
        }
    }

}

