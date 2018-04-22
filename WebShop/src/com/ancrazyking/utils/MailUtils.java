package com.ancrazyking.utils;
import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Ancrazyking
 * @date 2018/4/22 19:17
 **/
public class MailUtils
{

    public static void sendMail(String email,String emailMsg) throws GeneralSecurityException {
        /**
         * 1.获得一个Session对象
         * 2.创建一个代表邮件的对象Message
         * 3.发送邮件Transport
         */
        //获取连接对象
        Properties props=new Properties();
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.transport.protocol","smtp" );


        MailSSLSocketFactory sf=new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable","true" );
        props.put("mail.smtp.ssl.socketFacotory",sf );


        Session session=Session.getInstance(props,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1515745236","kycmzjdigltfjecd");
            }});
        //创建邮件对象;
        Message message=new MimeMessage(session);

        //设置发件人
        try {
            message.setFrom(new InternetAddress("wangafengwork@qq.com"));
            //设置收件人
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
            //抄送 CC 密送BCC
            //设置标题
            message.setSubject("来自网上商城的官方邮件");
            //设置邮件正文
            message.setContent(emailMsg,"text/html;charset=utf-8");
            //发送邮件
            Transport.send(message);
        }catch(AddressException e) {
            e.printStackTrace();

        }catch(MessagingException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        sendMail("ancrazyking@gmail.com","阿峰哥");
    }


}
