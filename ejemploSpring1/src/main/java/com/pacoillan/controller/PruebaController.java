package com.pacoillan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PruebaController {
	
	@RequestMapping("/inicio")
	public String inicio() {
		
		System.out.println("INICIO");
		return "inicio";
		
	}

}
