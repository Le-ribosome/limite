package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOJoueur;
import fr.formation.joueur.Joueur;

//@Controller
public class ConnexionController {

	@Autowired
	private IDAOJoueur daoJoueur;

	@GetMapping("/connexion")
	public String connexion() {
		return "connexion-joueur";
	}

	@PostMapping
	public String connexion(@RequestParam String mail, @RequestParam String password) {
		Joueur joueur = daoJoueur.findByMail(mail);
		// verification de l'existence du joueur
		if (joueur != null) {
			if (password == joueur.getPassword()) {
				return "profil-joueur";
			}
			return "connexion";
		}

		return "connexion";

	}

}
