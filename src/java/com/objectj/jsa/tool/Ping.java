/*
 * Version: Sonata 2.6
 * Created by: Hossein
 * Creation Date: 6 Dec, 2002
 * Modified by: Hossein
 * Modified Date: 12/19/2002 10:51 AM
 */

package com.objectj.jsa.tool;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 *
 * @author  hossein
 */
public class Ping {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        String sonataHome = null;
        boolean checkForStart = false;
        if(args.length > 0) {
            int sleepTime = Integer.parseInt(args[0]);
            
            String serverHost = System.getProperty("server.host");
            if(serverHost == null) serverHost = "localhost";
            String serverPort = System.getProperty("server.port");
            if(serverPort == null) serverPort = "80";
            String context = System.getProperty("web.context");
            if(context == null) context = "";
            String pingURL = "http://" + serverHost + ":" + serverPort;
            String appURL = pingURL + "/" + context;
            //=-= //=-= //=-= System.out.println("--->" + appURL + " " + serverPort);
            URL url = new URL(appURL);
            
            if(args.length > 1 && "start".equalsIgnoreCase(args[1])) checkForStart = true;
            while(true) {
                try {
                    URLConnection urlConnection = url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    if(in.read() != -1) {
                        if(checkForStart) break;
                        else {
                            //=-= //=-= //=-= System.out.print("Server is still up\n");
                            //=-= //=-= //=-= System.out.print("Sleeping for " + sleepTime + "\n");
                            Thread.sleep(sleepTime);
                        }
                    }
                } catch(Exception e) {
                    if(checkForStart) {
                        //e.printStackTrace();
                        //=-= //=-= //=-= System.out.print("Server is not up yet\n");
                        //=-= //=-= //=-= System.out.print("Sleeping for " + sleepTime + "\n");
                        Thread.sleep(sleepTime);
                    }
                    else break;
                } 
            }
            /*
            try {
                Process process = Runtime.getRuntime().exec("EXPLORER.EXE " + appURL);
            } catch(Exception exception) {
            }*/
        }
        if(checkForStart) { //=-= //=-= //=-= System.out.print("Server is started ....");
        } else { //=-= //=-= //=-= System.out.print("Server is stopped ...");
        }
        //=-= //=-= //=-= System.out.println("");
    }
}
