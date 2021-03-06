package fr.formation.jeu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fr.formation.cartes.CarteMot;
import fr.formation.cartes.CarteMotDefini;
import fr.formation.joueur.Equipe;
import fr.formation.joueur.Joueur;

@Entity
@Table(name="participation")


public class Participation {

	
//	    PTN_ID INT NOT NULL AUTO_INCREMENT,
//	    PTN_PARTIE_ID INT NOT NULL,
//	    PTN_JOUEUR_ID INT NOT NULL,
//		PTN_EQUIPE_ID INT NOT NULL,
//	    PTN_MAIN_ID INT NOT NULL,
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PTN_ID", nullable=false, unique=true)
	@NotEmpty
	@NotNull
	private int id;
	
	//Enregistre la partie dès qu'on enregistre une participation
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="PTN_PARTIE_ID")
	@NotNull
	private Partie partie;
	
	@ManyToOne
	@JoinColumn(name="PTN_JOUEUR_ID")
	@NotNull
	private Joueur joueur;
	
	@OneToOne
	@JoinColumn(name="PTN_EQUIPE_ID")
	private Equipe equipe;
	
	@ManyToMany
	@JoinTable(
		name="main",
		joinColumns=@JoinColumn(name="MAIN_PARTICIPATION_ID", referencedColumnName="PTN_ID"),
		inverseJoinColumns=@JoinColumn(name="MAIN_CARTE_MOTDEF_ID", referencedColumnName="CMO_ID")
	)
	private List<CarteMotDefini> mainMotDefini;
	
	
	@Transient
	private List<CarteMot> main;

	public Participation() {
		
	}
	
	public Participation(Joueur j, Partie p) {
		this.joueur=j;
		this.partie=p;
	}
	
	public Participation(Joueur j, Partie p, Equipe e) {
		this.joueur=j;
		this.partie=p;
		this.equipe=e;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Partie getPartie() {
		return partie;
	}


	public void setPartie(Partie partie) {
		this.partie = partie;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public List<CarteMotDefini> getMainMotDefini() {
		return mainMotDefini;
	}


	public void setMainMotDefini(List<CarteMotDefini> mainMotDefini) {
		this.mainMotDefini = mainMotDefini;
	}


	public List<CarteMot> getMain() {
		return main;
	}


	public void setMain(List<CarteMot> main) {
		this.main = main;
	}
	
	
	
}
