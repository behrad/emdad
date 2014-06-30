/**
 * Created by IntelliJ IDEA.
 * User: HamidAbbasi
 * Date: May 10, 2003
 * Time: 8:42:07 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

import java.util.ArrayList;
import java.util.Hashtable;
import java.security.Principal;

import com.objectj.emdad.proxy.QueryObject;
import com.objectj.emdad.ejb.util.ForceFilterObject;
import com.objectj.emdad.ejb.util.Constants;

import javax.servlet.http.HttpServletRequest;

public class UserSession {
    public UserSession(HttpServletRequest request) throws Exception {
        String userName = null;
        Principal principal = request.getUserPrincipal();
        if (principal == null)
            userName = "anonymous";
        else {
            userName = principal.getName();
        }
        String ip = request.getRemoteAddr();
//                System.out.println("ip0="+ip);
        ip = ip.substring(0, ip.lastIndexOf('.'));
//                System.out.println("ip1="+ip);
//                System.out.println("10201="+java.net.InetAddress.getLocalHost().getHostAddress());

        this.setLocal(java.net.InetAddress.getLocalHost().getHostAddress().startsWith(ip));
        this.name = userName;
        id = UserAccessEntity.getUserId(name);
        entityFilters = new Hashtable();
        entitySfecificFilters = new Hashtable();
        role = UserAccessEntity.getUserRole(name);
        roleFarsi = UserAccessEntity.getUserRoleFarsi(name);
        accesses = UserAccessEntity.getAllAccesses(role);
        naghshId = UserAccessEntity.getNaghshId(name);
        setDaftarOstani(UserAccessEntity.getDaftarOstaniId(name));
        setIsDatabaseSQL(com.objectj.emdad.ejb.util.Constants.getIsSQLServer());
    }

    private String getAccessToEntity(String entity) {
        if (entity.startsWith(Constants.ENTITY_ALTERNATE))
            entity = entity.substring(Constants.ENTITY_ALTERNATE.length());

        for (int i=0; i<accesses.size(); i++) {
            AccessToEntity ae = (AccessToEntity) accesses.get(i);
            if (entity.equals(ae.getEntity()) || ae.getEntity().equals("*"))
                return ae.getAccess();
        }
        return null;
    }

    public boolean hasAccessToReport(int reportId) throws Exception {
        return UserAccessEntity.hasAccessToReport(role, reportId);
    }

    public EntityAccess getEntityAccess(String entity) {
        return new EntityAccess(getAccessToEntity(entity));
    }

    public QueryObject getQueryObjectFilter(String entity) throws Exception {
        return (QueryObject) entityFilters.get(entity);
    }

    public void setFilter(String entity, QueryObject qoFilter) {
        clearFilter(entity);
        if (qoFilter!=null)
            entityFilters.put(entity, qoFilter);
    }

    public void clearFilter(String entity) {
        if (entityFilters.get(entity)!=null)
            entityFilters.remove(entity);
    }

    public void setSpecific(String forceFilter, String destinationForward, String entity) {
        ForceFilterObject fo = new ForceFilterObject(forceFilter, destinationForward);
        setSpecific(entity, fo);
    }

    public void setSpecific(String entity, ForceFilterObject forceFilterObject) {
        clearSpecific(entity);
        entitySfecificFilters.put(entity, forceFilterObject);
    }


    public ForceFilterObject getSpecific(String entity) {
        return (ForceFilterObject)entitySfecificFilters.get(entity);
    }

    public void clearSpecific(String entity) {
        if (entitySfecificFilters.get(entity)!=null)
            entitySfecificFilters.remove(entity);
    }

    public void clearAllFilters(String entity) {
        clearSpecific(entity);
        clearFilter(entity);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getRoleFarsi() {
        return roleFarsi;
    }

    public String getForceFilter(String entity) {
        if (entitySfecificFilters.get(entity)!=null)
            return ((ForceFilterObject)entitySfecificFilters.get(entity)).getForceFilter();
        return null;
    }

    public String getDestinationForward(String entity) {
        if (entitySfecificFilters.get(entity)!=null)
            return ((ForceFilterObject)entitySfecificFilters.get(entity)).getDestinationForward();
        return null;
    }

    public String getDaftarOstani() {
        return daftarOstani;
    }

    public void setDaftarOstani(String daftarOstani) throws Exception {
        this.daftarOstani = daftarOstani;
        this.daftarOstaniName = UserAccessEntity.getDaftarOstaniName(name);
    }

    public String getDaftarOstaniName() {
        return daftarOstaniName;
    }

    public int getNaghshId() {
        return naghshId;
    }

    public void setNaghshId(int naghshId) {
        this.naghshId = naghshId;
    }

    public boolean isUserInRole(String roleName) {
        return role.equals(roleName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static boolean isISDatabaseSQL() {
        return isDatabaseSQL;
    }

    public void setIsDatabaseSQL(boolean isDatabaseSQL) {
        this.isDatabaseSQL = isDatabaseSQL;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    private Hashtable entityFilters;
    private Hashtable entitySfecificFilters;
    private int naghshId;
    private String name;
    private String role;
    private String roleFarsi;
    private String daftarOstani;
    private ArrayList accesses;
    private String id;
    protected String daftarOstaniName;
    private boolean isLocal;
    protected static boolean isDatabaseSQL;
}
