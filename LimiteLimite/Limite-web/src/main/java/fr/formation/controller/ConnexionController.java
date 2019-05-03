package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOJoueur;

@Controller
public class ConnexionController {

@Autowired
private IDAOJoueur daoJoueur;


@GetMapping ("/connexion")
public String connexion() {
	return"connexion-joueur";
}
	

@PostMapping
public String connection(Model model, @RequestParam int id) {
		model.addAttribute("joueur", daoJoueur.findById(id).getPassword());
	return"joueur";
}
	

}
