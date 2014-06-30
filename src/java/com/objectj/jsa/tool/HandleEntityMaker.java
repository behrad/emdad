/**
 * Created by IntelliJ IDEA.
 * User: Hannaneh
 * Date: Jul 14, 2003
 * Time: 5:00:58 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.jsa.tool;

import com.objectj.emdad.web.sysadmin.UseCaseModel;
import com.objectj.emdad.web.sysadmin.EntityModel;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;



    public class HandleEntityMaker {
        public static final String ENTITY_SPEC_EXTENSION = ".entity.spec";
        public static void main(String[] args) throws Exception {
            Class.forName(System.getProperty("database.driver"));
            String specPath = args[0];
            File specDir = new File (specPath);
            String [] specFile = specDir.list();
             for (int i = 0; i < specFile.length; i++)
            {
                if(specFile[i].endsWith(ENTITY_SPEC_EXTENSION))

                { if (specFile[i].equals("khodrosaz.entity.spec")) {
                    try{
                        EntitySpecProcessor esp = new EntitySpecProcessor (specPath + "/" + specFile[i]);
                        FileWriter out = new FileWriter (new File ("c:/" + esp.getEntityNameCapital() + ".txt"));
                        PrintWriter output = new PrintWriter (out);

                        output.println(esp.getEntityName() + "\t\t" + esp.getFarsiTitle() + "\t\t" + esp.getDescription());
                        output.close();
                        //=-= //=-= //=-= System.out.println("esp.getBusinessProcessCode() = " + esp.getBusinessProcessCode());
                        new HandleEntityMaker().handleEntity(esp.getEntityName(), esp.getFarsiTitle(), esp.getDescription(), esp.getBusinessProcessCode());

                    } catch (EntitySpecException e){

                    }
                }
                }
             }
        }
     public String getConnURL() {
        return System.getProperty("database.url") +
                ";User=" + System.getProperty("database.user") +
                ";Password=" + System.getProperty("database.password") +
                ";DatabaseName=" + System.getProperty("database.name");
    }
     protected  void handleEntity(String entityName, String entityTitle, String entityDescr, int businessProcessCode) {
        EntityModel em = new EntityModel();
        //=-= //=-= //=-= System.out.println("entityTitle = " + entityTitle);
        em.setEntityName(entityName);
        em.setEntityTitle(entityTitle);
        em.setEntityDescr(entityDescr);

        char[] op = {'c', 'r', 'u', 'd', 'l', 'p'};
        for (int i = 0; i < op.length; i++) {
            UseCaseModel ucm = new UseCaseModel();
            ucm.setUcName(op[i] + "-" + em.getEntityName());
            ucm.setUcURL("/" + op[i] + "/" + em.getEntityName() + ".run");
            ucm.setUcOperation(Character.toString(op[i]));
            em.getUseCases().add(ucm);
        }

       if (shouldInsert(getConnURL(), em)) {
            insertEntity(getConnURL(), em, businessProcessCode);
       }

//        try {
//            if (SysAdminDAO.insertEntity(em, Integer.parseInt(request.getParameter("bpId")))) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/com/objectj/emdad/jsp/sysadmin/ACL-frames.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                return actionMapping.findForward("failure");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
//        }
        //return actionMapping.findForward("acl");
    }
  public boolean shouldInsert(String connURL, EntityModel em){
      Connection c = null;
      Statement sqlSt = null;
      try{
          c = DriverManager.getConnection(connURL);
          sqlSt = c.createStatement();
          ResultSet rs = sqlSt.executeQuery("select id from admin_Entity where entityName = '" + em.getEntityName() + "'");
          if (rs.next())
               return false;
      } catch (SQLException se) {
           se.printStackTrace();
      }
      return true;
  }

  public  boolean insertEntity(String connURL,EntityModel em, int bpId) {
        boolean result = true;
        Connection c = null;
        Statement sqlSt = null;
        PreparedStatement ps = null;

        try {
            c = DriverManager.getConnection(connURL);
            sqlSt = c.createStatement();


           // char[] mapChar = new char[] {0x0627, 0x0628, 0x067e, 0x062a, 0x062b, 0x062c, 0x0686, 0x062d, 0x062e, 0x062f, 0x0630, 0x0631, 0x0632, 0x0698, 0x0633, 0x0634, 0x0635, 0x0636, 0x0637, 0x0638, 0x0639, 0x063a, 0x0641, 0x0642, 0x06a9, 0x06af, 0x0644, 0x0645, 0x0646, 0x0648, 0x0647, 0x064a};
           // int[] mapInt = new int[] {167,168,190,1726,171,172,8224,173,174,175,176,177,178,1705,179,180,181,182,183,184,185,1563,1662,8218,169,175,8222,8230,8224,710,8225,1657};

            String title = new String(em.getEntityTitle().getBytes(), "UTF-8");
            String dscr =  new String(em.getEntityDescr().getBytes(), "UTF-8");


            ps=c.prepareStatement("insert into admin_Entity (entityName, entityTitle, entityDescr) values (?,?,?)");
            ps.setString(1, em.getEntityName());
            ps.setString(2, title);
            ps.setString(3, dscr);
            ps.executeUpdate();


            ResultSet rs = sqlSt.executeQuery("select id from admin_Entity where entityName = '" + em.getEntityName() + "'");
            if (rs.next())
                em.setId(rs.getInt("id"));

            ps = c.prepareStatement("insert into admin_UC (entityId, ucName, ucTitle, ucDescr, " +
                    "ucURL, ucOperation, ucBP, ucExec, showInMenu) values (" +
                    em.getId() + ", ?, ?, NULL, ?, ?, " + bpId + ", NULL, ?)"
            );
            int count = 0;
            for (Iterator ucIterator = em.getUseCases().iterator(); ucIterator.hasNext();) {
                UseCaseModel ucm = (UseCaseModel) ucIterator.next();
                ps.setString(1, ucm.getUcName());
                count++;
                rs = sqlSt.executeQuery("select caption from admin_Captions where captionId = '" +count+ "'");

                if (rs.next()) {
                    ps.setString(2, rs.getString("caption")+ ' ' + title);
                }  else ps.setString(2,"");
                ps.setString(3, ucm.getUcURL());
                ps.setString(4, ucm.getUcOperation());
                ps.setInt(5, ucm.showInMenu());
                ps.executeUpdate();
            }
        } catch (SQLException se) {
            se.printStackTrace();
            result = false;
        } finally {
            try {
                ps.close();
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return result;
        }
    }

}
