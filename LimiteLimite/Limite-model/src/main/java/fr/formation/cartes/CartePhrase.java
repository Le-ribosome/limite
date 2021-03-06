package fr.formation.cartes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="cartephrase")
@AttributeOverrides({
@AttributeOverride(name="id", column=@Column(name="CPH_ID")),
@AttributeOverride(name="temps", column=@Column(name="CPH_TEMPS")),
@AttributeOverride(name="categorie", column=@Column(name="CPH_CATEGORIE")),
@AttributeOverride(name="points", column=@Column(name="CPH_POINTS", nullable = false))

})

public class CartePhrase extends CarteATrou {
	
	//int id defini dans Carte
	//int temps defini dans CarteATrou
	//String categorie defini dans Carte
	//int points defini dans CarteATrou
	
	@Column(name="CPH_PHRASE", nullable = false)
	@NotEmpty
	private String phrase;
	@Column(name="CPH_NB_TROU", nullable = false)
	private int nbTrous;
	

	public CartePhrase() {
		
	}
	
	public CartePhrase(String phrase, int points) {
		int count = 0;
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == '_'){
				count++;
			}
		}
		this.nbTrous=count;
		this.phrase=phrase;
		this.points=points;
	}

	
	
	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public int getNbTrous() {
		return nbTrous;
	}

	public void setNbTrous(int nbTrous) {
		this.nbTrous = nbTrous;
	}

	
	
	


	
}