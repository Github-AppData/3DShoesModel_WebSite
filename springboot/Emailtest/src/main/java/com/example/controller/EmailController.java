package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.EmailDTO;
import com.example.service.MailService;

import lombok.AllArgsConstructor;

@Controller
public class EmailController {
	
	MailService mailService;
	
	@Autowired
    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/mail")
    public String dispMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void execMail(EmailDTO mailDto) {
    	System.out.println("mailDto : "+ mailDto);
        mailService.mailSend(mailDto);
    }

}
