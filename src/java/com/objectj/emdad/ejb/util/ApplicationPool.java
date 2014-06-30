/**
 * Created by IntelliJ IDEA.
 * User: Hamid Abbasi
 * Date: Sep 6, 2003
 * Time: 9:45:39 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import java.util.Calendar;
import java.util.Enumeration;
import java.sql.Statement;
import java.sql.Connection;

import org.apache.log4j.Logger;

public class ApplicationPool {
    protected Logger log = Logger.getLogger(this.getClass());

    public void add(String key, Object o) {
        key = Constants.APPLICATION_POOL_PREFIX + key;
        Util.add(key, o);
    }


    public Object get(String key) {
        key = Constants.APPLICATION_POOL_PREFIX + key;
        Object o = Util.get(key);
        return o;
    }

    public Object pop(String key) {
        key = Constants.APPLICATION_POOL_PREFIX + key;
        Object o = Util.get(key);
        Util.remove(key);
        return o;
    }

    public void writeAll() {
        String o = null;
        Enumeration keys = Util.getKeys();
        for ( ; keys.hasMoreElements(); o = (String) keys.nextElement()) {
            log.info("o="+o);
            if ( o!=null && o.startsWith(Constants.APPLICATION_POOL_PREFIX) )
                log.info(Util.get(o));
        }
    }

    class ThreadApplicationPool implements Runnable {
        static final int applicationPoolRefreshDelay = 10; //  in minutes
        Thread t = new Thread(this);

        public ThreadApplicationPool() {
            t.start();
        }

        public void run() {
            int i = 0;
            boolean done = false;

            while (true) {
                try {
                    Thread.sleep(applicationPoolRefreshDelay * 60 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
                ComboPool.updateCombo();

                if (i % 5 == 0) {
                    Calendar c = Calendar.getInstance();
                    if (c.get(Calendar.HOUR_OF_DAY) == 1) {
                        if (done)
                            continue;
                        done = true;
                        String mgh = "update moshtarak set moshtarakYaNa=2 where moshtarakYaNa=1 and tarikhEngheza<getdate()-1";
                        Connection conn = null;
                        Statement statement = null;
                        try {
                            conn = Util.getConnection();
                            statement = conn.createStatement();
                            Logger.getLogger("").info("mgh=" + mgh);
                            statement.executeUpdate(mgh);
                        } catch (Exception e) {

                        } finally {
                            try {
                                if (statement != null)
                                    statement.close();
                                if (conn != null)
                                    conn.close();
                            } catch (Exception e) {
                                Logger.getLogger("").error("update moshtarakYaNa Error", e);
                                e.printStackTrace();
                                done = false;
                            }
                        }
                    } else
                        done = false;
                }
            }
        }
    }

}

