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

<script>

function selectER() {
    roleName = document.all.roleSelect.options[document.all.roleSelect.selectedIndex].value;
    entityName = document.all.entitySelect.options[document.all.entitySelect.selectedIndex].value;
	if ((roleName != "") && (entityName != ""))
	    parent.frames["mainFrame"].location.href="ACL.jsp#" + entityName + "," + roleName;
}

</script>

<body dir="rtl">

<html:base/>

<%
    ArrayList roles = SysAdminDAO.getRoles();
    ArrayList entities = SysAdminDAO.getEntities();
%>
	<select name="entitySelect">
		<option value="" selected="selected">Entity:</option>
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
	<select name="roleSelect">
		<option value="" selected="selected">Role:</option>
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
	<img src="images/go.gif" onClick="selectER()">

</body>