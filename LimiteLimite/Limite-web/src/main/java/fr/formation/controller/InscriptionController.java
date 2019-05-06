package fr.formation.controller;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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

	private IDAOJoueur daoJoueur;
	
	@GetMapping
	public String inscription() {
		
		return "inscription-joueur";
	}
	
	@PostMapping
	public String inscription(@ModelAttribute Joueur joueur) {
		
		//Encryptage du mot de passe:
		String key ="soprasteria";
		String passwordClear=joueur.getPassword();
		
		try
		{
			Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE,clef);
			joueur.setPassword(new String(cipher.doFinal(passwordClear.getBytes())));
		}
		catch (Exception e)
		{
			
		}
			
		
		//Enregistrement en base: 
		daoJoueur.save(joueur);
		
		return "connexion-joueur";
	}
}
