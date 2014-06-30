package org.ejbutils.client;

import java.io.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;

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

/**
 * Abstract Class that provides initial context and helps
 * retrieving homes.
 * <p>
 * The initial context is initialised during the first call to the
 * <code>getInitContext</code> method.
 * <p>
 * To make this work with your EJB server, put the relevant information
 * in the public static attributes of the class.
 * <p>
 * You could also decide to use your own context util or context factory
 * by modifying the <code>getInitContext(String, String)</code> method.
 *
 * @author Emmanuel Sciara
 */

public class ContextUtil implements Serializable {

    public static final String DEFAULT_NAMESERVICE_TYPE =
    "org.jnp.interfaces.NamingContextFactory";
    public static final String DEFAULT_NAMESERVICE_PROVIDER_URL =
    "127.0.0.1:1099";
    public static final String DEFAULT_URL_PKG_PREFIXES =
    "org.jnp.interfaces";
    private static final String NAMESERVICE_TYPE_PROPERTY =
    "java.naming.factory.initial";
    private static final String NAMESERVICE_PROVIDER_URL_PROPERTY =
    "java.naming.provider.url";

    transient static private InitialContext initContext = null;

    /**
     * Gets Home from JNDI name and norrows.
     */
    public static synchronized Object findHome(String aJNDIName, Class narrowedClass) throws NamingException {
        return PortableRemoteObject.narrow(getInitContext().lookup(aJNDIName), narrowedClass);
    }

    /**
     * Gets initial naming context from default name service URL and
     * default name service type.
     */

    public static synchronized InitialContext getInitContext() throws NamingException {

        return getInitContext(DEFAULT_NAMESERVICE_PROVIDER_URL, DEFAULT_NAMESERVICE_TYPE, DEFAULT_URL_PKG_PREFIXES);

    }

    /**
     * Gets initial naming context from URL and name service type
     */

    public static synchronized InitialContext getInitContext(String nameServiceURL,
    String nameServiceType,
    String nameServiceURLPrefixes)
    throws NamingException {

        if (initContext == null) {

            Hashtable environment = new Hashtable(3);
            environment.put(Context.INITIAL_CONTEXT_FACTORY, nameServiceType);
            environment.put(Context.PROVIDER_URL, nameServiceURL);
            if (nameServiceURLPrefixes != null) {
                environment.put(Context.URL_PKG_PREFIXES, nameServiceURLPrefixes);
            }

            initContext = new InitialContext(environment);

        }

        return initContext;

    }
}
