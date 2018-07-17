package com.clinicmanagement.Utility;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPSaslAuthenticator;

public class EmailConfirmation 
{
	final static String senderEmailID = "healthcaresolutions25@gmail.com";
	final String senderPassword = "sourav12";
	final static String emailSMTPserver = "smtp.gmail.com";
	final static String emailServerPort = "465";

	String receiverEmailID = null;
	static String emailSubject = "Confirmation Email from healthcare";
	public String MailSender(String receiverEmailID)
			{
				this.receiverEmailID=receiverEmailID;
			//	this.emailSubject=emailSubject;
			//	this.emailBody=emailBody;

				int rand1;
				String rand="";
				for(int j=0;j<4;j++)
				{
					rand1=new Random().nextInt(9);
					rand=String.valueOf(rand1)+rand;
					
				}
				String emailBody = "Welcom to our health care portal this to confirm your account with us."
				+rand+" is your confirmation code to confirm your account ";
				Properties props = new Properties();
				props.put("mail.smtp.user",senderEmailID);
				props.put("mail.smtp.host", emailSMTPserver);
				props.put("mail.smtp.port", emailServerPort);
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				// props.put("mail.smtp.debug", "true");
				props.put("mail.smtp.socketFactory.port", emailServerPort);
				props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");

				SecurityManager security = System.getSecurityManager();

				try
				{
					Authenticator auth = new SMTPAuthenticator();
					Session session = Session.getInstance(props, auth);
					// session.setDebug(true);

						MimeMessage msg = new MimeMessage(session);
						
						msg.setText(emailBody);
						msg.setSubject(emailSubject);
						msg.setFrom(new InternetAddress(senderEmailID));
						msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress(receiverEmailID));
						Transport.send(msg);
					}
					catch (Exception mex)
					{
					mex.printStackTrace();
					}
					System.out.println(rand);
					return rand;
			}
	public class SMTPAuthenticator extends javax.mail.Authenticator
	{
		public PasswordAuthentication getPasswordAuthentication()
			{
					return new PasswordAuthentication(senderEmailID, senderPassword);
				}
	}
					
					
					
	}	
					
