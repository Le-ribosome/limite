package fr.formation.cartes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cartemotdefini")
@AttributeOverrides({
@AttributeOverride(name="id", column=@Column(name="CMO_ID")),
@AttributeOverride(name="categorie", column=@Column(name="CMO_CATEGORIE")),
@AttributeOverride(name="mot", column=@Column(name="CMO_MOT")),
})

public class CarteMotDefini extends CarteMot {


	//int id defini dans Carte
	//String categorie defini dans Carte
	// String mot; definin dans CarteMot
	
	// Joueur possesseurDeLaCarte; defini dans CarteMot et TRANSIENT

	public CarteMotDefini() {
		
	}
	
	public CarteMotDefini(String mot) {
		this.mot=mot;
	}
	
	
	
}
