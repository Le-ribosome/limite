package fr.formation.joueur;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import fr.formation.cartes.CarteMotDefini;
import fr.formation.jeu.Participation;



@Entity
@Table(name="joueur")
@AttributeOverrides({ 
	@AttributeOverride(name="id", column=@Column(name="JOU_ID")),
	@AttributeOverride(name="nom", column=@Column(name="JOU_NOM")),
	@AttributeOverride(name="prenom", column=@Column(name="JOU_PRENOM")),
	@AttributeOverride(name="pseudo", column=@Column(name="JOU_PSEUDO")),
	@AttributeOverride(name="password", column=@Column(name="JOU_PASSWORD")),
	@AttributeOverride(name="mail", column=@Column(name="JOU_MAIL")),
	@AttributeOverride(name="age", column=@Column(name="JOU_AGE"))
})


public class Joueur extends Utilisateur {
	// int id definit dans utilisateur
	/*
	 * string nom, prenom, pseudo, password , mail et age egalement
	 * propre au joueur : équipe, score, main, cartes jouées d'un tour
	 */

   

   @Column (name="JOU_SCORE")
   @NotNull
   @NotEmpty
   private int score;
    
    
  // Attention la main est reliée à participation, là pas relié à la bdd
    @Transient
    private List<CarteMotDefini> main = new ArrayList<CarteMotDefini>(); // ajoute une collection priv�e : la main du joueur
  
    @Transient
    private List<CarteMotDefini> jouerCarte = new ArrayList<CarteMotDefini>();
    
    @OneToMany (mappedBy="joueur")
    private List<Participation> participation;
    
    public List<CarteMotDefini> getJouerCarte() {
		return jouerCarte;
	}
	public void setJouerCarte(List<CarteMotDefini> jouerCarte) {
		this.jouerCarte = jouerCarte;
	}
	public Joueur(String pseudo, int age) {
        this.pseudo = pseudo;
        this.age = age;
        this.score = 0;
            }
    public Joueur() {
    	
    }
	
    
	
	public void regarderSaMain() {
        int i = 1;

        for(CarteMotDefini c : this.main) {
            System.out.println(i + " - " + c.getMot());
        }

    }
	
	//Cette methode fait mettre une ou plusieurs cartes mots dans l'arraylist
	//jouerCarte eet correspond aux cartes que le joueur choisi de jouer à un tour.
	public void jouer(int nbMots) {
        Scanner sc = new Scanner(System.in);

        for(int j = 0; j < nbMots; ++j) {
            int choix;
            do {
                System.out.println("Entre ton choix pour le trou " + (j + 1) + "et appuie sur la touche entrée ");
                choix = sc.nextInt();
            } while(choix < 0 || choix > this.main.size());

            --choix;
            this.jouerCarte.add(this.main.get(choix));
            this.main.remove(choix);
        }

    }
	
  

	

	public void setMain(List<CarteMotDefini> main) {
		this.main = main;
	}

	public List<CarteMotDefini> getMain() {
        return main;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
	
  }