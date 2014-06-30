package com.objectj.emdad.web.action;

import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.proxy.KhodrojagozinMasrafSessionUtil;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.EmdadUtil;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.KhodrojagozinMasrafUtil;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.Connection;

public final class KhodrojagozinMasrafForm extends BaseForm {

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return KhodrojagozinMasrafSessionUtil.getLocalHome().create();
        } catch (Exception e) {
            throw new ProxyException(e);
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.KhodrojagozinMasrafModel";
    }

    protected void  prefixSpecificValidations(ActionMapping mapping, HttpServletRequest request){

        if (HejriUtil.isValidDate((String)(get("tarikhTahvilBeMoshtari"))))
            set("tarikhTahvilBeMoshtari", HejriUtil.hejriToChrisStr((String)get("tarikhTahvilBeMoshtari")));

        if (HejriUtil.isValidDate((String)(get("tarikhTahvilAzMoshtari"))))
            set("tarikhTahvilAzMoshtari", HejriUtil.hejriToChrisStr((String)get("tarikhTahvilAzMoshtari")));
    }

    protected void checkForSpecificValidations(Connection c, ActionErrors errors) throws Exception  {
        if (!Validators.chackValidateZaman((String)get("tarikhTahvilBeMoshtari2")))
             errors.add("a", new ActionError("emdad.zamanTahvilBeMoshtari.invalid"));

        if (!Validators.chackValidateZaman((String)get("tarikhTahvilAzMoshtari2")))
             errors.add("", new ActionError("emdad.zamanTahvilAzMoshtari.invalid"));

//        if (((String)get("action_type")).indexOf("create") < 0) {
            if ((String)get("tarikhTahvilAzMoshtari")!=null && ((String)get("tarikhTahvilAzMoshtari")).length()!=0 )
                if ((String)get("tarikhTahvilAzMoshtari2")!=null && ((String)get("tarikhTahvilAzMoshtari2")).length()!=0 )
                    if (HejriUtil.convertToTimesatmp((String)get("tarikhTahvilBeMoshtari"), (String)get("tarikhTahvilBeMoshtari2")).compareTo(HejriUtil.convertToTimesatmp((String)get("tarikhTahvilAzMoshtari"), (String)get("tarikhTahvilAzMoshtari2"))) > 0 )
                        errors.add("a", new ActionError("emdad.tahvilAzMoshtari.before.tehvilBeMoshtari"));
//        }

//        try{
            if (get("emdadEmdadId") != null && ((String) get("emdadEmdadId")).length() != 0){
                // emdad vojood dashte bashad
                QueryObject qo = new QueryObject();
                qo.setFromIndex(0);
                qo.setToIndex(2);
                qo.setTables("emdad");
                qo.setJoined(false);
                qo.setWhere("emdadId=" + get("emdadEmdadId") +" AND noeEmdad=4");
                ResultSet rs = EmdadUtil.getLocalHome().advanceRead(c, qo);
                if (rs.next()) {
                     set("emdadId", rs.getString("id"));
                } else
                    errors.add("emdadId", new ActionError("errors.emdad.doesnot.exist", get("emdadEmdadId")));

                rs.close();
                // emdad tekrari nabashad
                qo.setFromIndex(0);
                qo.setToIndex(2);
                qo.setTables("KhodrojagozinMasraf");
                qo.setJoined(false);
                qo.setWhere("emdadId='" + get("emdadId") + "'");
                rs = KhodrojagozinMasrafUtil.getLocalHome().advanceRead(c, qo);

//                String id = KhodrojagozinMasrafUtil.getLocalHome().advanceRead(c, qo); // UserAccessEntity.stringQuery("SELECT id FROM khodrojagozinMasraf WHERE emdadId = '" + get("emdadId") + "'", "id", c);
                if (rs.next()) {
                   String id = rs.getString("id");
                    if (rs.next() || !id.equals(get("id")))
//                    //=-= System.out.println("============== ghabli id = " + id);
//                    if (id != null && id.length() != 0)
                        errors.add("tekrari", new ActionError("khodrojagozinMasraf.dastorkar.tekrari"));
                }
                rs.close();
            }
//        }catch(Exception e){
//             e.printStackTrace();
//            throw new Exception(e);
//        }


/*
        KhodrojagozinMasrafModel vo = new KhodrojagozinMasrafModel();
        Exchanger.exhangeFormToValueObject(this, vo);

    if ((String)(get("tarikhTahvilAzMoshtari")) != null && ((String)(get("tarikhTahvilAzMoshtari"))).length() != 0)
            vo.setTarikhTahvilAzMoshtari(HejriUtil.toTimestamp((String)(get("tarikhTahvilAzMoshtari"))));

        if ((String)(get("tarikhTahvilBeMoshtari")) != null && ((String)(get("tarikhTahvilBeMoshtari"))).length() != 0)
            vo.setTarikhTahvilBeMoshtari(HejriUtil.toTimestamp(((String)(get("tarikhTahvilBeMoshtari")))));
  */
//        Validators.khodrojagozinMasrafValidator(vo, errors);

    }

}
