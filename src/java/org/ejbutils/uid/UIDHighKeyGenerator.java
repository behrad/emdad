package org.ejbutils.uid;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import java.sql.SQLException;
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
 * Remote interface of the Session Bean.
 * 
 * @author Emmanuel Sciara
 */

public interface UIDHighKeyGenerator extends javax.ejb.EJBObject {


/**
 */
Key getNextHighKey(Key theHighKey, String theName) throws java.rmi.RemoteException, javax.ejb.FinderException;
}