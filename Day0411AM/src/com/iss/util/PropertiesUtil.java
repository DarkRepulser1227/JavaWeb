package com.iss.util;
import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    public static String getValue(String key){
        String val="";
        try {
            Properties prop=new Properties();
            InputStream in=new PropertiesUtil().getClass().
                    getResourceAsStream("Appcon.Properties");
            prop.load(in);
            val=prop.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
