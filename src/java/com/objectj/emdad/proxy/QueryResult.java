/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: May 11, 2003
 * Time: 5:56:09 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.proxy;

import java.util.ArrayList;

public class QueryResult {
    private ArrayList result;
    private int totalCount;
    private boolean hasError;

    public QueryResult(ArrayList result, int totalCount) {
        this.result = result;
        this.totalCount = totalCount;
    }

    public QueryResult(ArrayList result) {
        this.result = result;
        totalCount = result.size();
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public ArrayList getResult() {
        return result;
    }

    public void setResult(ArrayList result) {
        this.result = result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
