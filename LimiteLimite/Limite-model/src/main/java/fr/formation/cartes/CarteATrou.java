package fr.formation.cartes;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;


@MappedSuperclass
public class CarteATrou extends Carte {
	
	//int id defini dans Carte
	//String categorie defini dans Carte

	protected int temps =30;

	protected int points;
	
	
	public CarteATrou() {
		this.setTemps(30);
	}



	
	
	
	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}



	public int getTemps() {
		return temps;
	}



	public void setTemps(int temps) {
		this.temps = temps;
	}

	
	
	
	
}