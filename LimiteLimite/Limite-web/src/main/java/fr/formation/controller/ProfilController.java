package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.joueur.Joueur;

@Controller
@RequestMapping("/profil")
public class ProfilController {

	@GetMapping
	public String profil(HttpSession session, Model model) {
		
		Joueur joueurActif = (Joueur) session.getAttribute("joueur");
		model.addAttribute("joueur", joueurActif);
		
		return "profil-joueur";
	}
}
