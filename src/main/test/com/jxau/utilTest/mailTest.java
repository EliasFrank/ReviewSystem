package com.jxau.utilTest;

import org.junit.Test;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailTest {
    @Test
    public void test() {
//        MailThread mailTest = new MailThread("1972341610@qq.com");
//        mailTest.run();
        new Thread(){
            public void run() {
                Properties props = new Properties();

                props.setProperty("mail.host", "smtp.qq.com");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.transport.protocol", "smtp");

                Authenticator auth = new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("2721584867", "vzbblyjcabildehi");
                    }
                };
                System.out.println("这里运行了");
                try {
                    Session session = Session.getInstance(props, auth);
                    System.out.println(session);
                    MimeMessage message = new MimeMessage(session);
                    //设置发件人
                    message.setFrom(new InternetAddress("2721584867@qq.com"));
                    //设置收件人
                    message.setRecipients(MimeMessage.RecipientType.TO, "791116427@qq.com");

                    //设置邮件标题
                    message.setSubject("学习了吗，还打游戏？？？");
                    //设置邮件内容
                    message.setContent("lpx快学习啊！！！", "text/html;charset=utf-8");

                    //发送邮件
                    Transport transport = session.getTransport();
                    transport.connect();

                    transport.sendMessage(message, message.getAllRecipients());

                    transport.close();
                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
//class MailThread{
//    private String email;
//    private Session session = null;
//    public MailThread(String email) {
//        this.email = email;
//    }
//    public void run() {
//        Properties props = new Properties();
//
//        props.setProperty("mail.host", "smtp.qq.com");
//        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.transport.protocol", "smtp");
//
//        Authenticator auth = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("2721584867", "vzbblyjcabildehi");
//            }
//        };
//        System.out.println("这里运行了");
//        try {
//            session = Session.getInstance(props, auth);
//            System.out.println(session);
//            MimeMessage message = new MimeMessage(session);
//            //设置发件人
//            message.setFrom(new InternetAddress("2721584867@qq.com"));
//            //设置收件人
//            message.setRecipients(MimeMessage.RecipientType.TO, email);
//
//            //设置邮件标题
//            message.setSubject("学习了吗，还打游戏？？？");
//            //设置邮件内容
//            message.setContent("学习了吗，还打游戏？？？", "text/html;charset=utf-8");
//
//            //发送邮件
//            Transport transport = session.getTransport();
//            transport.connect();
//
//            transport.sendMessage(message, message.getAllRecipients());
//
//            transport.close();
//        } catch (AddressException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println("addressexception");
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println("messageinngexception");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//
