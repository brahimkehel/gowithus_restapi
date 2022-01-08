package com.emsi.gowithus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Utilisateurs")
public class UtilisateurController {
	
	@GetMapping("/Hello")
	public String Hello(){
		return "Hello World";
	}
}
