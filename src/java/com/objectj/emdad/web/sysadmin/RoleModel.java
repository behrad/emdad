/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 26, 2003
 * Time: 1:06:15 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

public class RoleModel {
    private int id;
    private String roleName;
    private String roleTitle;

    public RoleModel() {
        roleName = "";
        roleTitle = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
