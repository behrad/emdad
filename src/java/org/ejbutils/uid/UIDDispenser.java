package org.ejbutils.uid;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import java.util.*;
import java.io.*;
import org.ejbutils.context.*;

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
 * Singleton providing the usable OUID.
 */

public class UIDDispenser {

    /**
     * Length of a HIGH key in number of bytes.
     */
    public static final int HIGH_KEY_BYTES = 7; // equals 112 bits

    /**
     * Length of a LOW key in number of bytes.
     */
    public static final int LOW_KEY_BYTES = 2; // equals 16 bits

    /**
     * Singleton value of the UID dispenser.
     */
    private static UIDDispenser dispenser = null;

    /**
     * Current HIGH key.
     */
    private Key highKey = null;

    /**
     * Current LOW key.
     */
    private Key lowKey = null;

    /**
     * Unique Id loaded at runtime from the UIDDispenser.properties resource file.
     */
    private String uniqueId = null;

    private UIDDispenser() {
    }



    /**
     * Returns the UIDispenser singleton.
     */
    public static synchronized UIDDispenser getDispenser() {
        if (dispenser == null)
            dispenser = new UIDDispenser();
        return dispenser;
    }

    /**
     * Returns the next universal ID.
     */
    public synchronized String getNextId() throws UIDDispenserException {
        String theIdString = null;

        if (highKey == null) {
            highKey = findNewHighKey(
                new Key(HIGH_KEY_BYTES));
            lowKey = new Key(LOW_KEY_BYTES);
        } else {
            try {
                lowKey.increment();
            } catch (MaxForKeyReachedException e) {
                // get high from session bean
                highKey = findNewHighKey(highKey);
                lowKey.reinitialise();
            }
        }

        theIdString = highKey.toString() +
        lowKey.toString() +
        provideUniqueIdentifier();
//        //=-= //=-= //=-= System.out.println("the new generated Id String="+theIdString);
        return theIdString;
    }

    /**
     * Returns a unique identifier to differenciate keys between companies.
     * As per Scott Ambler's article, I use "www.my-company.com" as example.
     * The unique identifier is store in the <code>UIDDispenser.properties</code>
     * resource file placed in the same directory structure as this class' class file.
     */
    public String provideUniqueIdentifier() {
        if (this.uniqueId == null){
	        String name = "UIDDispenser.properties";
	        InputStream resourceStream = new BufferedInputStream(getClass().getResourceAsStream(name));
	        if (resourceStream == null) {
	            throw new RuntimeException("Could not find resource '" + name + "'");
	        }
	        Properties p = new Properties();
            try{
	        	p.load(new BufferedInputStream(resourceStream));
            } catch (IOException e){
	            throw new RuntimeException("Could not load resource '" + name + "' :" + e.toString());
            }
            this.uniqueId = p.getProperty("uniqueid");
        }
        return this.uniqueId;
    }

    /**
     * Returns a new high key value.
     */
    // should not need to be synchronized since call from already synchronized methods
    private Key findNewHighKey(Key aHighKey) throws UIDDispenserException {
        // get high from session bean by calling getNextKey(Key theHighKey)
        try {
            //=-= //=-= //=-= System.out.println(UIDHighKeyGeneratorHome.JNDI_NAME);
            UIDHighKeyGeneratorHome aGeneratorHome =
            (UIDHighKeyGeneratorHome)ContextUtil.findHome(UIDHighKeyGeneratorHome.JNDI_NAME, UIDHighKeyGeneratorHome.class);
            UIDHighKeyGenerator aGenerator = aGeneratorHome.create();
            return aGenerator.getNextHighKey(aHighKey,provideUniqueIdentifier());
        } catch (NamingException e) {
            throw new UIDDispenserException("NamingException occured while trying to get new UID.", e);
        } catch (RemoteException e) {
            throw new UIDDispenserException("RemoteException occured while trying to get new UID.", e);
        } catch (CreateException e) {
            throw new UIDDispenserException("Could not create UID generator Session bean occured while trying to get new UID.", e);
        } catch (FinderException e) {
            throw new UIDDispenserException("FinderException occured while trying to get new UID.", e);
        }
    }
}
