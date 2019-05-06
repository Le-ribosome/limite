package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("Je suis passé par la");
		// verification de l'existence du joueur
		if (joueur != null) {
			System.out.println("Par là aussi");
			if (password.equals( joueur.getPassword())) {
				session.setAttribute("joueur", joueur);
				return "profil-joueur";
			}
			System.out.println("Le mdp est faux");
			return "connexion";
		}
		System.out.println("Le joueur est nul");
		return "connexion";

	}

	
	




	
	
	
	
	
	
	
}
