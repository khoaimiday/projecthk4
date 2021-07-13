package com.fpt.main.advice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.util.Separators;
import com.fpt.main.model.User;

@Component
public class SendEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	//send mail with text basic
	public void sendEmail(User userInfo) throws MalformedURLException {
		
		URL baseUrl = new URL("http://localhost:8080/api/auth/active/" + userInfo.getUsername() + "/" + userInfo.getVerifycationCode());
		
		String strHello = String.format("Hello, %s \n", userInfo.getUsername());		
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(userInfo.getEmail());
		msg.setSubject("Activation email" );
		msg.setText(strHello + "Mã kích hoạt bạn là: " +  baseUrl );
		
		javaMailSender.send(msg);
	}
	
	//send mail with HTML and attach file
	void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        helper.setTo("to_@email");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}
