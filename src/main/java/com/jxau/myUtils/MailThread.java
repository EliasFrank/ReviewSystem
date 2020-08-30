package com.jxau.myUtils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailThread extends Thread{
	private String email;
	private String random;
	private static String textChar = "1234567890";
	private Session session = null;
	public MailThread(String email) {
		this.email = email;
		random = getRandomString();
	}
	@Override
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
		try {
			session = Session.getInstance(props, auth);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("2721584867@qq.com"));
			message.setRecipients(RecipientType.TO, email);

			message.setSubject("修改密码的验证码");
			message.setContent(random, "text/html;charset=utf-8");

			Transport transport = session.getTransport();
			transport.connect();


			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	private String getRandomString() {
		StringBuilder sBuilder = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int j = rand.nextInt(10);
			sBuilder.append(textChar.charAt(j));
		}
		return sBuilder.toString();
	}
}
