package com.iss.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {
    private static String  myEmailAccount="tj_lilin1@126.com";
    private static String myEamilPassword="123456";
    private static String myEmailSMTP="smtp.126.com";
    private static String smptPort="465";


    public static void  sendEmail(String receiveMail){
        try {
            //参数配置
            Properties prop=new Properties();

            //发送协议
            prop.setProperty("mail.transport.protocal","smtp");

            //配置发送邮件的主机
            prop.setProperty("mail.smtp.host",myEmailSMTP);

            //发送邮件是否需要验证
            prop.setProperty("mail.smtp.auth","true");

            //发送邮件服务器的端口
            prop.setProperty("mail.smtp.port",smptPort);

            //定义是否使用ssl连接发送
            prop.setProperty("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");

            //发送邮件以后，不需要已读回执
            prop.setProperty("mail.smtp.socketFactory.fallback","false");

            //发送邮件服务通讯端口
            prop.setProperty("mail.smtp.socketFactory.port",smptPort);

            //创建发送邮件的会话
            Session session=Session.getDefaultInstance(prop);

            //开启发送邮件的调试信息
            session.setDebug(true);

            //创建一封电子邮件
            MimeMessage message=new MimeMessage(session);

            //发件人，from
            message.setFrom(new InternetAddress(myEmailAccount,"亚马逊","UTF-8"));

            //收件人，to
            message.setRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(receiveMail,"亲爱的用户","UTF-8"));

            //邮件主题
            message.setSubject("惊蛰打折计划","UTF-8");

            //邮件的正文
            message.setContent("全场9.8，王海明送到家","text/html;charset=UTF-8");

            //设置邮件发送时间
            message.setSentDate(new Date());

            //在smtp服务器上验证
            Transport transport=session.getTransport();
            transport.connect(myEmailAccount,myEamilPassword);

            //发送
            transport.sendMessage(message,message.getAllRecipients());


            transport.close();




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
