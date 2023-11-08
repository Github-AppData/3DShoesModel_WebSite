package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.dto.EmailDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	
	private final JavaMailSender mailSender;
	
	@Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
    private static final String FROM_ADDRESS = "xodnr2019@naver.com";

    public void mailSend(EmailDTO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        System.out.println("mailDto.getAddress() : "+mailDto.getAddress());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
    }

}
