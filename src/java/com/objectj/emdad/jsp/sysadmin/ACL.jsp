<%@ page import="com.objectj.emdad.web.sysadmin.SysAdminDAO,
                 java.sql.ResultSet,
                 java.util.ArrayList,
                 java.util.Iterator,
                 com.objectj.emdad.web.sysadmin.UseCaseModel,
                 com.objectj.emdad.web.sysadmin.RoleModel,
                 java.util.Set,
                 com.objectj.emdad.web.sysadmin.EntityModel"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<body dir="rtl">
<html:base/>

<%
    ArrayList roles = SysAdminDAO.getRoles();
    Set ACL = SysAdminDAO.getACL();
    ArrayList entities = SysAdminDAO.getEntities();
%>
<form name="aclForm" method="post" action="/emdad/admin/acl-action">
    <input type="hidden" name="action" value="store"/>
    <input type="submit" value="Store in DB"/>
    <table cellspacing="0" cellpadding="5">
<%
    String bkColor = "#E9EBEB";
    for (Iterator enIterator = entities.iterator(); enIterator.hasNext();) {
        EntityModel em = (EntityModel) enIterator.next();
        if (bkColor.equals("#E9EBEB"))
            bkColor = "#DADEDC";
        else
            bkColor = "#E9EBEB";
%>
                <tr><td><%= em.getEntityTitle()%></td><td>&nbsp;</td>
<%
        for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
            RoleModel roleModel = (RoleModel) roleIterator.next();
            if (roleModel.getRoleName().equals("superuser"))
                continue;
%>
                <td><a name='<%= em.getEntityName() + "," + roleModel.getRoleName()%>'><%= roleModel.getRoleTitle() %></a></td>
<%
        }
%>
            </tr>
<%
        for (Iterator ucIterator = em.getUseCases().iterator(); ucIterator.hasNext();) {
            UseCaseModel ucm = (UseCaseModel) ucIterator.next();
%>
                <tr>
                    <td bgcolor="<%= bkColor %>"><%= ucm.getUcTitle() %></td>
                    <td bgcolor="<%= bkColor %>"><img src="images/<%= ucm.getUcOperation()%>-op.gif" alt="<%= ucm.getUcURL() %>"></td>
<%
                for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
                    RoleModel roleModel = (RoleModel) roleIterator.next();
                    if (roleModel.getRoleName().equals("superuser"))
                        continue;
%>
                    <td align="center" bgcolor="<%= bkColor %>" ><input name='cb-<%= ucm.getId() + "," + roleModel.getId() %>' type="checkbox" value="" <%= ACL.contains(ucm.getId() + "," + roleModel.getId()) ? "checked" : "" %>></td>
<%
                }
%>
                </tr>
<%
        }
    }
%>
    </table>
</form>
</body>
