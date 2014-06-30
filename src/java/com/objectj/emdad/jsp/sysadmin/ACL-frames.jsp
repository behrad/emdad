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

<html:base/>

<script>

function selectER() {
    roleName = document.all.roleSelect.options[document.all.roleSelect.selectedIndex].value;
    entityName = document.all.entitySelect.options[document.all.entitySelect.selectedIndex].value;
	if ((roleName != "") && (entityName != ""))
	    document.location.href="#" + entityName + "," + roleName;
}

function gotoTop() {
	document.location.href="#";
}

</script>

<%
    ArrayList roles = SysAdminDAO.getRoles();
    ArrayList entities = SysAdminDAO.getEntities();
    Set ACL = SysAdminDAO.getACL();
%>
<form name="aclForm" method="post" action="/emdad/sysadmin.run">
<table width="100%" border="0" cellpadding="10" class="listTable" cellspacing="0" background="images/filter-bk.jpg">
	<tr>
		<td>
		<select name="entitySelect" class="text8">
			<option value="" selected="selected">موجوديت ها:</option>
<%
		for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			EntityModel em = (EntityModel)iterator.next();
			String entityName = em.getEntityName();
			String entityTitle = em.getEntityTitle();
%>
			<option value="<%= entityName %>"><%= entityTitle %></option>
<%
	    }
%>
		</select>
		&nbsp;
		<select name="roleSelect" class="text8">
			<option value="" selected="selected">نقش ها:</option>
<%
		for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
			RoleModel rm = (RoleModel) roleIterator.next();
			String roleName = rm.getRoleName();
			String roleTitle = rm.getRoleTitle();
%>
			<option value="<%= roleName %>"><%= roleTitle %></option>
<%
    	}
%>
		</select>
		&nbsp;&nbsp;
		<img src="images/go.gif" onClick="selectER()" style="cursor:hand;">
		</td>
		<td align="left"><input type="hidden" name="action" value="store"/>
			<input type="reset" value="حالت اول" class="EmdadButton"/>
			<input type="submit" value="ثبت اطلاعات" class="EmdadButton"/>
		</td>
	</tr>
	</table>
    <table cellspacing="0" cellpadding="2">
<%
	int i = 1;
    for (Iterator enIterator = entities.iterator(); enIterator.hasNext();) {
        EntityModel em = (EntityModel) enIterator.next();
		i++;
%>
                <tr class="listTableHeader">
					<td class = "listRow0Col">
						<img src="images/ascending.gif" onClick="javascript:gotoTop()" style="cursor:hand;">&nbsp;
						<span class="textW"><%= em.getEntityTitle()%></span>
					</td>
					<td>&nbsp;</td>
<%
        for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
            RoleModel roleModel = (RoleModel) roleIterator.next();
            if (roleModel.getRoleName().equals("superuser"))
                continue;
%>
                <td class = "listRow0Col">
					<a name='<%= em.getEntityName() + "," + roleModel.getRoleName()%>' class="textW"><%= roleModel.getRoleTitle() %></a>
				</td>
<%
        }
%>
            </tr>
<%
        for (Iterator ucIterator = em.getUseCases().iterator(); ucIterator.hasNext();) {
            UseCaseModel ucm = (UseCaseModel) ucIterator.next();
%>
                <tr class="listRow<%= i % 2 %>" >
                    <td class = "adminRow1Col"><%= ucm.getUcTitle() %></td>
                    <td class = "adminRow1Col"><img src="images/<%= ucm.getUcOperation()%>-op.gif" alt="<%= ucm.getUcURL() %>"></td>
<%
                for (Iterator roleIterator = roles.iterator(); roleIterator.hasNext();) {
                    RoleModel roleModel = (RoleModel) roleIterator.next();
                    if (roleModel.getRoleName().equals("superuser"))
                        continue;
%>
                    <td align="center"  class = "adminRow1Col"><input name='cb-<%= ucm.getId() + "," + roleModel.getId() %>' type="checkbox" value="" <%= ACL.contains(ucm.getId() + "," + roleModel.getId()) ? "checked" : "" %>></td>
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
