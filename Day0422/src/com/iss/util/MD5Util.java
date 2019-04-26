package com.iss.util;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class MD5Util {
    public  static  String getMD5String(String str){
        String res="";

        try {
            //指明需要使用md5进行加密
            MessageDigest md5=MessageDigest.getInstance("MD5");

            //Base64的对象
            BASE64Encoder base64Encoder=new BASE64Encoder();

            //加密字符串,注意加密不可逆
            res=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
