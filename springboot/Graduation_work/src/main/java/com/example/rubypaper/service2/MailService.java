package com.example.rubypaper.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.rubypaper.dto.MailDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;
	
	  private static int number;

	    public static void createNumber(){
	       number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
	    }
	
	@Autowired
	public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	 private static final String FROM_ADDRESS = "xodnr2019@naver.com";

	 public MimeMessage CreateMail(String mail) {
	   	createNumber();
	   	System.out.println("mail : "+mail);
	   	MimeMessage message = mailSender.createMimeMessage();
	   	
	   	try {
            message.setFrom(FROM_ADDRESS);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	   	return message;
    }
	 
	 public int sendMail(String mail){

	    MimeMessage message = CreateMail(mail);

	     mailSender.send(message);

	    return number;
	 }
}
