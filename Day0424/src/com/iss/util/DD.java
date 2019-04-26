package com.iss.util;

import org.junit.Test;

import java.util.zip.ZipEntry;

public class DD {

    @Test
    public void show(){
//        ZipUtil.saveToZip("D:/0425.zip");
        ZipUtil.readFromZip("D:/0425.zip");
    }
}

