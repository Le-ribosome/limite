package fr.formation.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.cartes.CarteMotDefini;
import fr.formation.cartes.CartePhrase;
import fr.formation.dao.IDAOCarteMotDefini;
import fr.formation.dao.IDAOCartePhrase;

@Controller
@RequestMapping("/cartes")
public class CartesController {

	@Autowired
	private IDAOCartePhrase daoCartePhrase;
	private IDAOCarteMotDefini daoCarteMotDefini;


	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("cartephrase", daoCartePhrase.findAll());
		model.addAttribute("cartemotdefini", daoCarteMotDefini.findAll());
		return "cartes";
	}

	@GetMapping // pour afficher le formulaire de création
	public String add() {
		return "cartes";
	}

	@PostMapping
	public String add(@Valid @ModelAttribute CartePhrase cartephrase, @ModelAttribute CarteMotDefini cartemotdefini, BindingResult result) {
		if(result.hasErrors()) { //si n'a pas été validé
			
return "cartes";
	}
		System.out.println("ETAPE 2");
		daoCartePhrase.save(cartephrase);
		daoCarteMotDefini.save(cartemotdefini);
		return "cartes";
	}
		

	@GetMapping("/supprimer")
	public String remove(@RequestParam int id) {
		daoCartePhrase.deleteById(id);
		daoCarteMotDefini.deleteById(id);
		return "redirect:./";
	}

	@GetMapping("/modifier")
	public String update(Model model, @RequestParam int id) {
		
		model.addAttribute("cartephrase", daoCartePhrase.findById(id).get());
		model.addAttribute("cartemotdefini", daoCarteMotDefini.findById(id).get());
		return "redirect:./";
	}
	

	@PostMapping("/modifier")
	public String update(@ModelAttribute CartePhrase cartephrase, @ModelAttribute CarteMotDefini cartemotdefini) {
		daoCartePhrase.save(cartephrase);
		daoCarteMotDefini.save(cartemotdefini);
		return "redirect:./";
	}


}
