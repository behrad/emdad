package org.ejbutils.uid;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

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
 * Home of the Session Bean. Contains the JNDI name of the Session Bean.
 *
 * @author Emmanuel Sciara
 */

public interface UIDHighKeyGeneratorHome extends EJBHome {
    /**
     */
    UIDHighKeyGenerator create() throws CreateException, RemoteException;

    public static final String JNDI_NAME = "ejb/UIDHighKeyGenerator";
}
