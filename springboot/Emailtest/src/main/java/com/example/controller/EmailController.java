package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmailDTO;
import com.example.service.EmailSenderService;

@RestController
public class EmailController {
	
	@Autowired
	EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}
	
	@PostMapping("/send-email")
	public ResponseEntity sendEmail(@RequestBody EmailDTO emailDTO)
	{
		this.emailSenderService.sendEmail(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getMessage());
		return ResponseEntity.ok("sucess");
	}

}
