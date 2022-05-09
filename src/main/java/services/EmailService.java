package services;

import java.util.Date;
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


public class EmailService {

	public static void sendMail(String host, String port, String user, String password, String address,
			String topic, String content) throws AddressException, MessagingException {
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", host);
		
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		};
		
		Session session = Session.getInstance(properties, auth);
		Message message = new MimeMessage(session);		
		message.setFrom(new InternetAddress(user));
		InternetAddress[] addresses = { new InternetAddress(address) };
		
		message.setRecipients(Message.RecipientType.TO, addresses);
		message.setSubject(topic);
		message.setSentDate(new Date());
		message.setContent(content, "text/html; charset=utf-8");
		
		Transport.send(message);
	}
	
}
