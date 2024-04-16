package com.tadigital.bytebrain.student.service;

import com.tadigital.bytebrain.student.entity.Student;
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

import com.tadigital.bytebrain.student.dao.StudentDao;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	public boolean signUpStudent(String fName, String lName, String email, String password) {
		return studentDao.signUpByFillingDetails(fName, lName, email, password);
	}

	public Student logInWithEmailAndPassword(String email, String password) {
		return studentDao.logInWithEmailAndPassword(email, password);
	}
	
	public Student loginWithStudentId (int id) {
		return studentDao.loginWithStudentId(id);
	}
	
	public boolean sendEmail(String mailMessage, String email) {
        try {
            String from = "saiganeshkandula93@gmail.com";
            String to = email;
            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "cmvpzpcdkhfketza");
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setText(mailMessage);
            Transport.send(message);

            return true;
        } catch (AddressException addressException) {
            addressException.printStackTrace();
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }

        return false;
    }
}