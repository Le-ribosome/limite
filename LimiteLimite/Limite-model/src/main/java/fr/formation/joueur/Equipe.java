package fr.formation.joueur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import fr.formation.jeu.Participation;

@Entity
@Table(name="equipe")

public class Equipe {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="EQP_ID", nullable=false, unique=true)
	@NotEmpty
	@NotNull
	private int id;
	
	
	@Column (name="EQP_NOM")
	@NotEmpty
	@NotNull
	private String nom;
	
	@Column (name="EQP_POINTS")
	@NotEmpty
	@NotNull
	private int score =0;
	
	@OneToMany(mappedBy="equipe")
	private List<Participation> participations;
	
	@Transient
	private List<Joueur> joueursDansEquipe = new ArrayList<Joueur>();
	
	
	public Equipe (String nom, Joueur... j) {
		this.nom=nom;
		joueursDansEquipe.addAll(Arrays.asList(j));
	}
	
	
	public void Score() {
		for (Joueur j: joueursDansEquipe) {
			this.score +=  j.getScore();
		}
	}
	
	public void addJoueur(Joueur... j) {
		joueursDansEquipe.addAll(Arrays.asList(j));
	}
	
	
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public void setJoueursDansEquipe(List<Joueur> joueursDansEquipe) {
		this.joueursDansEquipe = joueursDansEquipe;
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Joueur> getJoueursDansEquipe() {
		return joueursDansEquipe;
	}
	public void setJoueursDansEquipe(ArrayList<Joueur> joueursDansEquipe) {
		this.joueursDansEquipe = joueursDansEquipe;
	}

	
	
}