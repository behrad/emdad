/*
 * Main Proxy Session EJB file of Emdad Project
 * Copyright 2003 ObjectJ
 * @author  Mehdi Amoui
 * last Modified on 05 May 2003
 */

package com.objectj.emdad.proxy.util;

import java.util.*;

public class FarsiComparator implements Comparator {

	private String field;
	private int order;

	public FarsiComparator(java.lang.String field, java.lang.String order) {
		this.field = field;
		if ((order.equals("ASC")) || (order.equals("asc")))
			this.order = 1;
		else if ((order.equals("DESC")) || (order.equals("desc")))
			this.order = (-1);

	}

	public int compare(Object o1, Object o2) {

		try {

			Object f1 = o1.getClass().getMethod("get" + field, new Class[] {}).invoke(o1, new Object[] {});
			Object f2 = o2.getClass().getMethod("get" + field, new Class[] {}).invoke(o2, new Object[] {});

            if (f1==null || f2==null)
                return 0;

			String s1 = f1.toString();
			String s2 = f2.toString();

			if (s1.toString().length() == 0 && s2.toString().length() == 0) {
				return 0;
			}

			int i1_h = s1.indexOf(0x0647);
			int i1_v = s1.indexOf(0x0648);

			int i2_h = s2.indexOf(0x0647);
			int i2_v = s2.indexOf(0x0648);

			int i1 = -1;
			int i2 = -1;

			if (i1_h <= i1_v) {
				if (i1_h < 0)
					i1 = i1_v;
				else
					i1 = i1_h;
			} else {
				if (i1_v < 0)
					i1 = i1_h;
				else
					i1 = i1_v;
			}

			if (i2_h <= i2_v) {
				if (i2_h < 0)
					i2 = i2_v;
				else
					i2 = i2_h;
			} else {
				if (i2_v < 0)
					i2 = i2_h;
				else
					i2 = i2_v;
			}

			if ((i1 >= 0) && (i2 >= 0) && (s1.substring(0, i1).equalsIgnoreCase(s2.substring(0, i2)))) {

				if (s1.compareTo(s2) > 0)
					return (-1 * order);
				else if (s1.compareTo(s2) < 0)
					return (1 * order);

			} else {

				if (s1.compareTo(s2) > 0)
					return (1 * order);
				else if (s1.compareTo(s2) < 0)
					return (-1 * order);
				else
					return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}	

}