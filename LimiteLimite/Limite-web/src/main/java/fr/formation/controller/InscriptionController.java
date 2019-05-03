package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InscriptionController {

	@GetMapping("/inscription")
	public String inscription() {
		
		return "inscription-joueur";
	}
	
	@PostMapping("/inscription")
	public String inscription(
			@RequestParam String email,
			@RequestParam String username, 
			@RequestParam String password ) {
		
		return "connexion-joueur";
	}
}
