/*
 * ProxyException.java
 *
 * Created on February 7, 2003, 9:56 AM
 */

package com.objectj.jsa.proxy;

import java.io.Serializable;

/**
 *
 * @author  hossein
 */
public class ProxyReferenceException extends Exception implements Serializable {

    /** Holds value of property exception. */
    private Exception exception;

    /** Creates a new instance of ProxyException */
    public ProxyReferenceException() {
    }

    /** Creates a new instance of ProxyException
     * @param exception
     */
    public ProxyReferenceException(Exception exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    /** Getter for property exception.
     * @return Value of property exception.
     *
     */
    public Exception getException() {
        return this.exception;
    }

    /** Setter for property exception.
     * @param exception New value of property exception.
     *
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

}
