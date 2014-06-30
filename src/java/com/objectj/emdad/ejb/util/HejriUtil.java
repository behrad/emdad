package com.objectj.emdad.ejb.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.StringTokenizer;
import java.util.Calendar;

public class HejriUtil {

    private int theYear;
    private int theMonth;
    private int theDay;

    private static String[] hDayNames = {"?åÇÑÔäÈå", "?äÌÔäÈå", "ÌãÚå", "ÔäÈå", "íßÔäÈå", "ÏæÔäÈå", "Óå?ÔäÈå"};
    private static int[][] hMonthDays = {
        {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29},
        {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30}};
    private static final int baseHYear = 1278;
    private static final int safeDays = 33 * 365 + 8;
    private final static char DATESEPARATOR = '/';

    public int getYear() {
        return this.theYear;
    }

    public int getMonth() {
        return this.theMonth;
    }

    public int getDay() {
        return this.theDay;
    }

    public void decodeHejriDate(Date date) { //chris to hejri

        int days;
        int y, m;
        int c1, c2;

        long dayMilliSec = date.getTime();
        days = (int) (dayMilliSec / (1000 * 3600 * 24));
        days = days - 80 + 365 + ((70 * 365) + 19);

        y = baseHYear + (days / safeDays) * 33;
        days = days % safeDays;
        if (days == 0) {
            days = safeDays;
            y -= 33;
        }
        c1 = 2;
        c2 = 7;
        days++;
        while (days > 366) {
            days -= 365;
            if (c1 == 0) {
                days--;
            }
            y++;
            c1--;
            if (c1 < 0) {
                c2--;
                if (c2 == 0) {
                    c2 = 8;
                    c1 = 4;
                } else {
                    c1 = 3;
                }
            }
        }

        if ((days == 366) && (c1 != 0)) {
            y++;
            days = 1;
        }

        m = 0;
        while (days > hMonthDays[1][m]) {
            days -= hMonthDays[1][m];
            m++;
        }

        theYear = y;
        theMonth = m + 1;
        theDay = days;

    }

    public static Date encodeHejriDate(int year, int month, int day) { //hejri to chris

        int days;
        int y, m, n;
        int c1, c2;

        /*//=-= System.out.println("In hejriUtil:year = " + year);
        //=-= System.out.println("In hejriUtil:month = " + month);
        //=-= System.out.println("In hejriUtil:day = " + day);*/

        if (year < 1300)
            year += 1300;

        if ((year >= baseHYear) && (year <= 9999 + baseHYear) &&
                (month >= 1) && (month <= 12) &&
                (day >= 1) && (day <= hMonthDays[isLeapYear(year) ? 1 : 0][month - 1])) {

            days = day + 80 - 365;
            for (m = 0; m < month - 1; m++) {
                days += hMonthDays[1][m];
            }
            y = baseHYear;

            n = (year - baseHYear) / 33;
            y += 33 * n;
            days += safeDays * n;

            c1 = 2;
            c2 = 7;
            while (y < year) {

                days += 365;
                if (c1 == 0) {
                    days++;
                }
                y++;
                c1--;
                if (c1 < 0) {
                    c2--;
                    if (c2 == 0) {
                        c2 = 8;
                        c1 = 4;
                    } else {
                        c1 = 3;
                    }
                }
            }
            days -= (70 * 365) + 19;
            long longDay = (long) days * (24 * 3600 * 1000);
            ////=-= System.out.println("longDay = "+ new Date(longDay));
            return new Date(longDay);

        } else {

            //=-= System.out.println("Invalid argument to hejri date encode");
            return null;
        }
    }

    public static Date toDate(String strDate) {
        return Date.valueOf(strDate.replace(DATESEPARATOR, '-'));
    }

    public static Timestamp toTimestamp(String strDate) {
        return Timestamp.valueOf(strDate.replace(DATESEPARATOR, '-'));
    }

    public static boolean isLeapYear(int year) {

        return (((year - (year + 45) / 33) % 4) == 0);

    }

    public static String getCurDate() {
        HejriUtil hejriUtil = new HejriUtil();
        hejriUtil.decodeHejriDate(new java.sql.Date(HejriUtil.getCurrentDate().getTime()));
        return ((hejriUtil.getDay()) + "/" + hejriUtil.getMonth() + "/" + hejriUtil.getYear());
    }

    public static String getCurTime() {

        Calendar c = Calendar.getInstance();
        return "" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
    }

    public String getDayOfWeek(Date date) {
        long noOfDays = date.getTime() / (24 * 3600 * 1000) + 1;
        return hDayNames[(int) (noOfDays % 7)];
    }

    public static boolean isValidDate(String hejriDate) {
        Integer year = new Integer(0);
        Integer month = new Integer(0);
        Integer day = new Integer(0);
        boolean hasDate = false;

        if (hejriDate == null)
            return false;

        try {
            StringTokenizer date = new StringTokenizer(hejriDate, "" + DATESEPARATOR);
            if (date.hasMoreTokens()) {
                year = Integer.valueOf(date.nextToken());
                if (date.hasMoreTokens()) {
                    month = Integer.valueOf(date.nextToken());
                    if (date.hasMoreTokens()) {
                        day = Integer.valueOf(date.nextToken());
                        hasDate = true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }

        if ((month.intValue() > 12) || (day.intValue() > 31) || (month.intValue() < 1) || (day.intValue() < 1))
            return false;
        if ((month.intValue() > 6) && (day.intValue() > 30))
            return false;
        if ((day.intValue() == 30) && (month.intValue() == 12) && ((year.intValue() - (year.intValue() + 45) / 33) % 4 != 0))
            return false;
        return true;
    }


    public static Date hejriToChris(String hejriDate) {
        Integer year = new Integer(0);
        Integer month = new Integer(0);
        Integer day = new Integer(0);
        boolean hasDate = false;

        StringTokenizer date = new StringTokenizer(hejriDate, "" + DATESEPARATOR);

        if (date.hasMoreTokens()) {
            year = Integer.valueOf(date.nextToken());
            if (date.hasMoreTokens()) {
                month = Integer.valueOf(date.nextToken());
                if (date.hasMoreTokens()) {
                    day = Integer.valueOf(date.nextToken());
                    hasDate = true;
                }
            }
        }

        if (hasDate) {
            Date c = new Date(0);
            c = encodeHejriDate(year.intValue(), month.intValue(), day.intValue());
            return c;
        }
        return null;
    }


    public static String hejriToChrisStr(String hejriDate) {
        Date d = hejriToChris(hejriDate);
        if (d == null)
            return "";
        return d.toString().replace('-', DATESEPARATOR);
    }


    public static String chrisToHejri(String chrisDate) {
        if (chrisDate == null)
            return "";
        chrisDate = chrisDate.replace(DATESEPARATOR, '-');
        return chrisToHejri(Date.valueOf(chrisDate));
    }

    public static java.sql.Date incYear(java.util.Date current) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(current);
        rightNow.add(Calendar.YEAR, 1);
        return new java.sql.Date(rightNow.getTime().getTime());
    }

    public static java.sql.Date incYear(java.sql.Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, 1);
        return new java.sql.Date(rightNow.getTime().getTime());
    }


    public static java.sql.Date incMonth(java.util.Date current, int month) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(current);
        rightNow.add(Calendar.MONTH, month);
        return new java.sql.Date(rightNow.getTime().getTime());
    }

    public static java.sql.Date incMonth(java.sql.Date date, int month) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, month);
        return new java.sql.Date(rightNow.getTime().getTime());
    }


    public static String chrisToHejri(Date chrisDate) {
        if (chrisDate == null)
            return "";
        HejriUtil hejriUtil = new HejriUtil();
        hejriUtil.decodeHejriDate(chrisDate);
        return ((hejriUtil.getYear()) + "/" + hejriUtil.getMonth() + "/" + hejriUtil.getDay());
    }

    public static String chrisToHejri(Timestamp chrisDate) {
        HejriUtil hejriUtil = new HejriUtil();
        Calendar date = Calendar.getInstance();
        date.setTime(new Date(chrisDate.getTime()));
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        hejriUtil.decodeHejriDate(new Date(date.getTimeInMillis()));
        return ((hejriUtil.getYear()) + "/" + hejriUtil.getMonth() + "/" + hejriUtil.getDay());
    }

    public static java.sql.Date getCurrentDate() {
        Calendar currentTime = Calendar.getInstance();
        currentTime.set(Calendar.HOUR_OF_DAY, 0);
        currentTime.set(Calendar.MINUTE, 0);
        currentTime.set(Calendar.SECOND, 0);
        return new java.sql.Date(currentTime.getTimeInMillis());
    }


    public static java.sql.Timestamp getCurrentDateTimestamp() {
        Calendar currentTime = Calendar.getInstance();
        currentTime.set(Calendar.HOUR_OF_DAY, 0);
        currentTime.set(Calendar.MINUTE, 0);
        currentTime.set(Calendar.SECOND, 0);
        return new java.sql.Timestamp(currentTime.getTimeInMillis());
    }


    public static java.sql.Timestamp getNowTimestamp() {
        return new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    public static java.lang.String getCurrentTime() {
        Calendar currentTime = Calendar.getInstance();
        return currentTime.get(Calendar.HOUR_OF_DAY) + ":" + currentTime.get(Calendar.MINUTE);
    }

    public static java.lang.String getCurrentTimeSec() {
        Calendar currentTime = Calendar.getInstance();
        return currentTime.get(Calendar.HOUR_OF_DAY) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND);
    }

    public static java.lang.String getTimeFromDate(java.sql.Timestamp date) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        return c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE);
    }

    public static java.lang.String getDateTimeFromDate(java.sql.Timestamp date) {
        return chrisToHejri(date) + "-" + getTimeFromDate(date);
    }

    public static java.lang.String getCurDateTime() {
        return getDateTimeFromDate(new java.sql.Timestamp(System.currentTimeMillis()));
    }

    public static java.sql.Timestamp convertToTimesatmp(String date, String time) {
        Calendar c = Calendar.getInstance();
        c.setTime(HejriUtil.toDate(date));
        if (time.indexOf(':') > 0) {
            int hour = Integer.valueOf(time.substring(0, time.indexOf(':'))).intValue();
            c.set(Calendar.HOUR_OF_DAY, hour);
            int minute = Integer.valueOf(time.substring(time.indexOf(':') + 1, time.length())).intValue();
            c.set(Calendar.MINUTE, minute);
            c.set(Calendar.SECOND, 0);
        }
        return new java.sql.Timestamp(c.getTimeInMillis());

    }

    public static java.lang.String incDayInHejriDate(String hejriDateStr) {
        return incDayInHejriDate(hejriDateStr, 1);

    }

    public static java.lang.String incDayInHejriDate(String hejriDateStr, int days) {
        java.util.Calendar date = Calendar.getInstance();
        date.setTime(hejriToChris(hejriDateStr));
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.add(Calendar.DATE, days);
        return chrisToHejri(new java.sql.Date(date.getTimeInMillis()));
    }
}