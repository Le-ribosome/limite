package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOJoueur;
import fr.formation.joueur.Joueur;

@Controller
public class ConnexionController {

	@Autowired
	private IDAOJoueur daoJoueur;

	@GetMapping("/connexion")
	public String connexion() {
		return "connexion-joueur";
	}

	@PostMapping("/connexion")
	public String connexion(HttpSession session, @RequestParam String mail, @RequestParam String password) {
		
		Joueur joueur = daoJoueur.findByMail(mail);
		System.out.println("submit ok");
		
		// verification de l'existence du joueur
		if (joueur != null) {
			
			System.out.println("joueur pas null");
			
			//Cryptage du mdp entr� par l'user et comparer les 2 mdp crypt�s: 
			
			//Crypte la variable password entr�e par l'user
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			System.out.println("mdp encrypt�: " +password);
			
			System.out.println(passwordEncoder.matches(password, joueur.getPassword()));
			System.out.println("mdp entr�: " +passwordEncoder.encode(password)+ " et mdp en base: " +joueur.getPassword());

			//Compare le password crypt� et le password en base: 
			if (passwordEncoder.matches(password, joueur.getPassword())) {
				System.out.println("les mdp sont �gaux");
				session.setAttribute("joueur", joueur);
				return "profil-joueur";
			}
			System.out.println("mdp pas �gaux");
			return "connexion-joueur";
		}
		System.out.println("joueur null");
		return "connexion-joueur";

	}

	
	




	
	
	
	
	
	
	
}
