package org.ejbutils.uid;

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
 * Represents an n*8-bits key.
 * <p>
 * It encapsulates a key in form of a byte array. It allows to:
 * <li> increment the value of the key by one.
 * <li> transform back and forth a key to a String.
 * <li> reinitialise a key to the minimale value or to a another 
 * value using a String representation.
 * <li> give a String representation of the next increment of the 
 * key without changing its internal value.
 * <p>
 * <b>WORK TO BE DONE:</b>
 * <p>
 * <li>An Exception should probably be thrown when trying to create 
 * or initialise a key from a String.
 * <li>The string representation used here for a byte is a two character
 * String derivated from the hex representation of a byte. For negative values,
 * the 'ffff' is removed from the hex equivalent. This makes the key's string 
 * representation's length twice the length of the key's bits representation.
 * I have receive complains from database guys saying that this takes quiet
 * a lot of space and fills up a page too quickly. Anybody knows how to make 
 * the string representation smaller?
 *
 * @author Emmanuel Sciara
 */
 
public class Key implements java.io.Serializable{

/**
 * Contructs a key of length*8 bits.
 */
 
public Key(int length) {
	this.value = new byte[length];
	this.reinitialise();
}
/**
 * Contructs a key of from a string representation of a key.
 */
 
public Key(String str) {
	this.reinitialise(str);
}
/** 
 * Returns a String as a byte array (see doc on the class 
 * itself for information on how a key is representated in a String).
 */
 
private byte[] asBytes(String str) { 
	int size = str.length()/2; 
	byte[] b = new byte[size];
	
	for (int i = 0; i<size; i++) { 
		String chunk = str.substring(i*2,i*2+2); 
		b[i] = (byte)Integer.parseInt(chunk, 16); 
	}
	
	return b; 
}

/** 
 * Increments the key value by one.
 */ 
public void increment() throws MaxForKeyReachedException{
	value = this.increment(value);
}

/** 
 * Increments a byte array by 1 in reverse order.
 */ 
private byte[] increment(byte[] array) throws MaxForKeyReachedException{
	return this.incrementElement(array, 0);
}

/** 
 * Recursive method to increment a byte array by 1 in reverse order. (This to avoid the database 
 * "hotspot" problem [see (@link UIDispenser)].
 */ 
private byte[] incrementElement(byte[] array, int index) throws MaxForKeyReachedException{
	if (array[index] == Byte.MAX_VALUE) {
		if (index == array.length -1) {
			throw new MaxForKeyReachedException();
		}
		incrementElement(array, index + 1);
		array[index] = Byte.MIN_VALUE;
	} else {
		array[index]++;
	}
	return array;
}



/** 
 * Reinitialises the key to the minimale value.
 */ 
public void reinitialise() {
	for (int i = 0; i < this.value.length; i++){
		this.value[i] = Byte.MIN_VALUE;
	}
}

/** 
 * Reinitialises the key to the value represented by a String.
 */ 
public void reinitialise(String str) {
	this.value = this.asBytes(str);
}

/** 
 * Returns the String representation of the key. 
 */ 
public String toString() { 
	return toString(this.value);
}

/** 
 * Returns the String representation of a byte array.
 */ 
private String toString(byte[] array) { 
	StringBuffer sb = new StringBuffer();
	
	for (int i=0; i< array.length; i++) { 
		String hex = "0"+Integer.toHexString(array[i]); 
		String end = hex.substring(hex.length()-2); 
		sb.append(end.toUpperCase()); 
	}
	
	return sb.toString(); 
}
	/**
	 * Key value in byte array.
	 */
	private byte[] value = null;/** 
 * Returns the string representation of the next increment of the key 
 * without changing its internal value.
 */ 
public String nextKeyAsString() throws MaxForKeyReachedException{
	// create new array
	byte[] tempArray = new byte[value.length];
	// copy array
	for (int i = 0; i < value.length; i++){
		tempArray[i] = value[i];
	}
	// increment
	tempArray = increment(tempArray);
	// return as string
	
	return toString(tempArray); 
}}