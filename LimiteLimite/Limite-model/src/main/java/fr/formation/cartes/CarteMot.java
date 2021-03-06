package fr.formation.cartes;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import fr.formation.joueur.Joueur;

@MappedSuperclass
public class CarteMot extends Carte {

	//int id defini dans Carte
	//String categorie defini dans Carte
	protected String mot;
	
	@Transient
	protected Joueur possesseurDeLaCarte;
	
	
	public CarteMot() {
		
	}
	
	

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public Joueur getPossesseurDeLaCarte() {
		return possesseurDeLaCarte;
	}

	public void setPossesseurDeLaCarte(Joueur possesseurDeLaCarte) {
		this.possesseurDeLaCarte = possesseurDeLaCarte;
	}
	
	
	
}
