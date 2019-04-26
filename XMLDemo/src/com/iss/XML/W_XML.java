package com.iss.XML;

import org.dom4j.*;
import org.dom4j.io.*;
import java.io.*;


public class W_XML {
    public static void main(String[] args) throws Exception{

        try {
            //创建一个document对象,这个对象就是未来要保存的XML文件;
            Document document = DocumentHelper.createDocument();
            //创建一个根元素;
            Element root = document.addElement("Persons");
            //创建一个子元素;
            Element person = null;
            //将person元素添加到Persons;
            person = root.addElement("Person");
            //创建一个名叫name的子元素,并添加到Person元素;
            Element name = person.addElement("Name");
            Element age = person.addElement("Age");
            name.setText("唐僧");
            age.setText("18");

            //保存XML文件
                //设定输出格式对象;
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
                //设定解码格式;
            outputFormat.setEncoding("UTF-8");
            //创建输出流对象,并设定输出类型与解码格式;
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File("F:/person.xml")),outputFormat);

            xmlWriter.write(document);
            xmlWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
