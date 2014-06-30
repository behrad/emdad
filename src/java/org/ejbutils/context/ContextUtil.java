package org.ejbutils.context;

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
 * Abstract Class to be used within the ejb container: provides initial context and helps retrieving homes classes . <p>
 * The initial context is initialised during the first call to the
 * <code>getInitContext</code> method. A straight new InitialContext()
 * is used as the container should take care of using the correct environment variables describing the jndi service.
 * @author Emmanuel Sciara
 */
public abstract class ContextUtil implements Serializable {
    transient static private InitialContext initContext = null;
    public static final String java_comp_env = "java:comp/env/";

    /**
     * Gets Home from JNDI name and norrows.
     */
    public static synchronized Object findHome(String aJNDIName, Class narrowedClass) throws NamingException {
        return PortableRemoteObject.narrow(getInitContext().lookup(aJNDIName), narrowedClass);
    }

    /** Gets initial naming context from default name service URL and default name service type. */
    public static synchronized InitialContext getInitContext() throws NamingException {
        if (initContext == null) {
            initContext = new InitialContext();
//            Hashtable environment = new Hashtable(3);
  //          environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
    //        environment.put(Context.PROVIDER_URL, "127.0.0.1:1099");
      //      environment.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
        //    initContext = new InitialContext(environment);
        }
        return initContext;
    }

}
