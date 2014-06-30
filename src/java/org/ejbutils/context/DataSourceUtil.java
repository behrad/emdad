package org.ejbutils.context;

import java.util.*;
import javax.naming.*;
import javax.sql.*;

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
 * Abstract Class that provides datasource.
 * <p>
 * To use this utility class in your environment, modify the <code>provideDataSourceName</code>
 * method to return the relevant information. Or you might want to modify the
 * <code> findDataSource</code> method to use your own utility class.
 * <p>
 * In its current state it is only good for use with the UID Generator
 * and should not be aimed at general use. A multipurpose Datasource
 * util would need to be more available, thread safe and include caching
 * (is this appropriate???).
 * <p>
 * If you want to help building such utility class, be our guest!
 *
 * @author Emmanuel Sciara
 */

public class DataSourceUtil {
    /**
     * Returns the datasource given a jndi reference.
     */

    public static DataSource findDataSource(String dataSource_ref) throws NamingException {

        return (DataSource)ContextUtil.getInitContext().lookup(dataSource_ref);
    }
}
