package com.iss.demo;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //定义一个SAXReader对象;
            SAXReader saxReader = new SAXReader();
            //加载XML文档'
            Document document = saxReader.read("src/book.xml");
            //查找文档根元素(树形结构);
            Element root = document.getRootElement();
            System.out.println(root.getName());
            //将根元素下所有子元素转换为List集合;
            List list = root.elements();
            //遍历list集合,遍历子元素;
            for (Object Object:list) {
                //强制将Object转为Element类型;
                Element e = (Element)Object;
                System.out.println(e.element("bname").getText());
                System.out.println(e.element("bid").getText());
                //获取1级子目录的属性
                System.out.println(e.attributeValue("ISDN"));
                //获取2级子目录的属性
                System.out.println(e.element("bname").attributeValue("id"));
                //获取3级子元素(假设有的话)
                e.element("bname").elements("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
