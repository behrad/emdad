/**
 * Created by IntelliJ IDEA.
 * User: xxx
 * Date: Jul 7, 2003
 * Time: 7:28:36 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

public class ForceFilterObject {
    public ForceFilterObject(String forceFilter, String destinationForward) {
        this.forceFilter = forceFilter;
        this.destinationForward = destinationForward;
    }

    public ForceFilterObject() {
    }

    public String getForceFilter() {
        return forceFilter;
    }

    public void setForceFilter(String forceFilter) {
        this.forceFilter = forceFilter;
    }

    public String getDestinationForward() {
        return destinationForward;
    }

    public void setDestinationForward(String destinationForward) {
        this.destinationForward = destinationForward;
    }

    protected String forceFilter;
    protected String destinationForward;
}
