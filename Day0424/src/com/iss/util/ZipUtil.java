package com.iss.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static void readFromZip(String filename) {
        try {
            File f=new File(filename);

            ZipInputStream zipin=new ZipInputStream(new FileInputStream(f));

            ZipEntry entry=null;

            ZipFile zfil=new ZipFile(filename);
            while((entry=zipin.getNextEntry())!=null){

                if (!entry.isDirectory()){
                    BufferedReader br=new BufferedReader(
                            new InputStreamReader(zfil.getInputStream(entry)));

                    String str="";
                    while ((str=br.readLine())!=null){
                        System.out.printf(str);
                    }
                    br.close();
                }
            }

            zipin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToZip(String filename) {
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(filename));
            ZipEntry entry = null;

            for (int i = 0; i < 10; i++) {
                entry = new ZipEntry(i + ".txt");

                zipOut.putNextEntry(entry);

                String str = i + "我是一个测试的语句";
                zipOut.write(str.getBytes());
            }

            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
