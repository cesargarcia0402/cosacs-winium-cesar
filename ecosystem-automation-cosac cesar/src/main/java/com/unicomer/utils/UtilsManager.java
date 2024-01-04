package com.unicomer.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UtilsManager {

    public static String getHostname(){
        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return hostname;
    }


}
