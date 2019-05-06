package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.dao.IDAOJoueur;
import fr.formation.joueur.Joueur;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping
	public String inscription() {
		
		return "inscription-joueur";
	}
	
	@PostMapping
	public String inscription(@ModelAttribute Joueur joueur) {
		
		//Mot de passe en clair entré par l'user, à encrypter: 
		String passwordClear=joueur.getPassword();
		
		//Crypte le password entrée par l'user lors de l'inscription
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		joueur.setPassword(passwordEncoder.encode(passwordClear));
			
		//Enregistrement en base: 
		daoJoueur.save(joueur);
		
		return "redirect: ./connexion";
	}
}
