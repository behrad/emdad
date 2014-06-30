// The EJBUtils library provides a set of utilities that solves general
// problems commonly found while developing in a EJB(tm)/J2EE(tm) environment.
// Copyright (C) 2000 Emmanuel Sciara
// email: ehsforward@yahoo.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package org.ejbutils.exception;

import java.io.*;
import javax.ejb.EJBException;

public class EJBNestingException extends EJBException {

    public Throwable detail;

    /**
     * String representation of stack trace - not transient!
     */
    private String stackTraceString;

    /**
     * Constructs a <code>EJBNestingException </code> with no specified
     * detail message.
     */
    public EJBNestingException() {
        stackTraceString = generateStackTraceString(this);
    }

    /**
     * Constructs a <code>EJBNestingException </code> with the specified
     * detail message.
     *
     * @param s the detail message
     */
    public EJBNestingException (String s) {
        super(s);
        stackTraceString = generateStackTraceString(this);
    }

    /**
     * Constructs a <code>EJBNestingException </code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     */
    public EJBNestingException (String s, Throwable ex) {
        super(s);
        detail = ex;
        stackTraceString = generateStackTraceString(ex);
    }

    /**
     * Constructs a <code>EJBNestingException </code> with the specified
     * nested exception.
     *
     * @param ex the nested exception
     */
    public EJBNestingException (Throwable ex) {
        super();
        detail = ex;
        stackTraceString = generateStackTraceString(ex);
    }

    /**
     * Converts a stack trace to a String so it can be serialized
     *
     * @param ex the nested exception
     */
    static public String generateStackTraceString(Throwable ex) {
        StringWriter s = new StringWriter();
        ex.printStackTrace(
            new PrintWriter(s));
        return s.toString();
    }

    /**
     * Returns the detail message, including the message from the nested
     * exception if there is one.
     */
    public String getMessage() {
        if (detail == null)
            return super.getMessage(); else
            return super.getMessage() + "; nested exception is: \n\t" +
            detail.toString();
    }

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified stream <code>ps</code>.
     *
     * @param ps the print stream
     */
    public void printStackTrace(PrintStream ps) {
        if (detail == null) {
            synchronized(ps) {
                ps.println(this.stackTraceString);
            }
        } else {
            synchronized(ps) {
                ps.println(this);
                ps.println(this.stackTraceString);
            }
        }
    }

    /**
     * Prints the composite message to <code>System.err</code>.
     */
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified print writer <code>pw</code>.
     *
     * @param pw the print writer
     */
    public void printStackTrace(PrintWriter pw) {
        if (detail == null) {
            synchronized(pw) {
                pw.println(this.stackTraceString);
            }
        } else {
            synchronized(pw) {
                pw.println(this);
                pw.println(this.stackTraceString);
            }
        }
    }
}




