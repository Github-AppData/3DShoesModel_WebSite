package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {
	
	@GetMapping("/address") 
	public String address() {
		System.out.println("카카오 API 테스트");
		
		return "address";
	}
}