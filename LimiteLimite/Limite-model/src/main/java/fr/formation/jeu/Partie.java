package fr.formation.jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import fr.formation.cartes.CarteMotDefini;
import fr.formation.cartes.CartePhrase;
import fr.formation.cartes.Paquet;
import fr.formation.joueur.Joueur;

@Entity
@Table(name="partie")

public class Partie {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAR_ID", nullable=false, unique=true)
	private int id;
	
	@Column (name="PAR_MODE")
	@NotEmpty
	@NotNull
	private int mode=1;
	//a_voir_plus_tard, ca sera un objet modeJeu
	
	@Column (name="PAR_TYPE")
	@NotEmpty
	@NotNull
	private int type=1;
	//a_voir_plus_tard, ca sera un objet modeJeu

	@Column(name="PAR_NB_JOUEUR")
	@NotEmpty
	@NotNull
	protected int nombreJoueur;
	
	@Column(name="PAR_NB_TOUR")
	@NotEmpty
	@NotNull
    private int nombreToursJoues;
    
	@OneToMany (mappedBy="partie")
	private List<Participation> participation;
	
	//Les paquets utilisés dans la partie: 
	@ManyToMany
	protected List<CartePhrase> paquetCartesPhrases;
	@ManyToMany
	protected List<CarteMotDefini> paquetCartesMotsDefinis;
	
	//On peut peu être s'en passer
	@Transient
    protected Paquet paquet;
    
	@Transient
    protected List<Joueur> joueursDansLaPartie = new ArrayList<Joueur>();
    
    
    public Partie() {
    	
    }

    public Partie(Paquet p, Joueur... j) {
        this.paquet = p;
        this.joueursDansLaPartie.addAll(Arrays.asList(j));
        this.nombreJoueur = this.joueursDansLaPartie.size();
        
        //Melange des cartes
        Collections.shuffle(this.paquet.getPaquetCartesMotsDefinis());
        Collections.shuffle(this.paquet.getPaquetCartesPhrases());

        //Distribuer trois cartes à tous les joueurs dans la partie: 
        this.distribuer(3);
        
        System.out.println("La partie est bien lancée, il y a "+this.nombreJoueur+" joueurs : \n");
        for (Joueur jou: joueursDansLaPartie) {
			System.out.println(jou.getPseudo()+"\n");
		}

       
    }
   
    //Pour faire un nouveau tour, lancer le tour depuis la partie 
    public Tour tour() {
    	Tour tour = new Tour(this);
    	return tour;
    }

	//Si la partie n'a pas commencé, possible de rajouter des joueurs dans une partie créée
    //Le recalcul du nombre de joueur se fait alors
    public void ajouterJoueurs(Joueur... j) {
    	if (nombreToursJoues>0) {
			System.out.println("Personne ne rejoins une partie commencée !");
			return;
		}
    	else {
    	       this.joueursDansLaPartie.addAll(Arrays.asList(j));
    	       this.nombreJoueur = this.joueursDansLaPartie.size();
		}

    }

    public void distribuer(int combienDeCartesDistribuer) {
        for(Joueur j : this.joueursDansLaPartie) {
        	for (int i = 0; i < combienDeCartesDistribuer; i++) {
        		//Ajoute une carte dans la main du joueur
        		j.getMain().add(this.paquet.getPaquetCartesMotsDefinis().get(0));
        		//Enlève cette carte du paquet
                this.paquet.getPaquetCartesMotsDefinis().remove(0);
			}
        }

    }

    public void ajouterPaquet(Paquet p) {
        this.paquet = p;
    }

    public void melangerPaquets() {
        Collections.shuffle(this.paquet.getPaquetCartesMotsDefinis());
        Collections.shuffle(this.paquet.getPaquetCartesPhrases());
    }

    
    
    public Paquet getPaquet() {
		return paquet;
	}

	public void setPaquet(Paquet paquet) {
		this.paquet = paquet;
	}

	public int getNombreToursJoues() {
		return nombreToursJoues;
	}

	public void setNombreToursJoues(int nombreToursJoues) {
		this.nombreToursJoues = nombreToursJoues;
	}

	public int getNombreJoueur() {
        return this.nombreJoueur;
    }

    public void setNombreJoueur(int nombreJoueur) {
        this.nombreJoueur = nombreJoueur;
    }

    public List<Joueur> getJoueursDansLaPartie() {
        return this.joueursDansLaPartie;
    }

    public void setJoueursDansLaPartie(List<Joueur> joueursDansLaPartie) {
        this.joueursDansLaPartie = joueursDansLaPartie;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Participation> getParticipation() {
		return participation;
	}

	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}

	public List<CartePhrase> getPaquetCartesPhrases() {
		return paquetCartesPhrases;
	}

	public void setPaquetCartesPhrases(List<CartePhrase> paquetCartesPhrases) {
		this.paquetCartesPhrases = paquetCartesPhrases;
	}

	public List<CarteMotDefini> getPaquetCartesMotsDefinis() {
		return paquetCartesMotsDefinis;
	}

	public void setPaquetCartesMotsDefinis(List<CarteMotDefini> paquetCartesMotsDefinis) {
		this.paquetCartesMotsDefinis = paquetCartesMotsDefinis;
	}
	
	
}