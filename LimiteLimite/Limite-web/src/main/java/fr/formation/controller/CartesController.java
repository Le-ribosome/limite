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
	@Autowired
	private IDAOCarteMotDefini daoCarteMotDefini;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("cartesphrases", daoCartePhrase.findAll());
		model.addAttribute("cartesmotsdefinis", daoCarteMotDefini.findAll());
		return "cartes";
	}

	@PostMapping("/ajouter-cartephrase")
	public String add(@Valid @ModelAttribute CartePhrase cartephrase, BindingResult result) {
		if (result.hasErrors()) { // si n'a pas été validé

			return "cartes";
		}
		System.out.println("ETAPE 2");
		daoCartePhrase.save(cartephrase);
		return "cartes";
	}

	@PostMapping("/ajouter-cartemot")
	public String add(@Valid @ModelAttribute CarteMotDefini cartemotdefini, BindingResult result) {
		if (result.hasErrors()) { // si n'a pas été validé

			return "cartes";
		}
		System.out.println("ETAPE 2");
		daoCarteMotDefini.save(cartemotdefini);
		return "cartes";
	}

	@GetMapping("/supprimer-cartephrase")
	public String removePhrase(@RequestParam int id) {
		daoCartePhrase.deleteById(id);
		return "redirect:./";
	}
	@GetMapping("/supprimer-cartemot")
	public String removeMot(@RequestParam int id) {
		daoCarteMotDefini.deleteById(id);
		return "redirect:./";
	}

	@GetMapping("/modifier-cartephrase")
	public String update( @RequestParam int id, Model model) {
	model.addAttribute("cartephrase", daoCartePhrase.findById(id).get());
		return "redirect:./";
	}

	@PostMapping("/modifier-cartephrase")
	public String update(@ModelAttribute CartePhrase cartephrase) {
		daoCartePhrase.save(cartephrase);
		return "redirect:./";
	}
	@GetMapping("/modifier-cartemot")
	public String update(Model model, @RequestParam int id) {
		model.addAttribute("cartemotdefini", daoCarteMotDefini.findById(id).get());
		return "redirect:./";
	}

	@PostMapping("/modifier-cartemot")
	public String update(@ModelAttribute CarteMotDefini cartemotdefini) {
		daoCarteMotDefini.save(cartemotdefini);
		return "redirect:./";
	}
}
