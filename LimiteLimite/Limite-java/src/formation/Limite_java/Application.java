package formation.Limite_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.cartes.CarteMotDefini;
import fr.formation.cartes.CartePhrase;
import fr.formation.cartes.Paquet;
import fr.formation.dao.IDAOCarteMotDefini;
import fr.formation.dao.IDAOCartePhrase;
import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOParticipation;
import fr.formation.dao.IDAOPartie;
import fr.formation.jeu.Participation;
import fr.formation.jeu.Partie;
import fr.formation.jeu.Tour;
import fr.formation.joueur.Equipe;
import fr.formation.joueur.Joueur;

public class Application {

	//COUCOU
	
	@Autowired
	private IDAOCartePhrase daoCartePhrase;
	@Autowired
	private IDAOParticipation daoParticipation;
	@Autowired
	private IDAOJoueur daoJoueur;
	@Autowired
	private IDAOPartie daoPartie;
	@Autowired
	private IDAOCarteMotDefini daoCarteMotDefini;
	
	@SuppressWarnings("unused")
	public void run(String[] args) {
		
//		IDAOJoueur daoJoueur = new DAOJoueurHibernate(em);
//		IDAOParticipation daoParticipation = new DAOParticipationHibernate(em);
//		IDAOPartie daoPartie = new DAOPartieHibernate(em);
//		IDAOCartePhrase daoCartePhrase = new DAOCartePhraseHibernate(em);
//    	IDAOCarteMotDefini daoCarteMotDefini = new DAOCarteMotDefiniHibernate(em);
		
    	
		//Cr�ation des joueurs et on les mets dans une liste de joueurs:
		ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();


//		Joueur joueur1 = new Joueur();
//		daoJoueur.inscrireJoueur("DROUIN","Alexis","dindonneau", 24, "dindonneau", "dindonneau","dindonneau@wanadoo.org");
//		Joueur joueur2 = new Joueur();
//		daoJoueur.inscrireJoueur("CHEA","Sylvain","poussin", 30, "poussin", "poussin", "poussin@wanadoo.org" );
//		Joueur joueur3 = new Joueur();
//		daoJoueur.inscrireJoueur("YU", "Helene", "lapereau", 25, "lapereau", "lapereau","lapereau@wanadoo.org");
//		Joueur joueur4 = new Joueur();
//		daoJoueur.inscrireJoueur("DURAND", "Marie", "gerbillou", 26, "gerbillou", "gerbillou","gerbillou@wanadoo.org");
//		Joueur joueur5 = new Joueur();
//		daoJoueur.inscrireJoueur("CLOTILDE", "Karen", "brocard", 26, "brocard", "brocard", "brocard@wanadoo.org");
//		Joueur joueur6 = new Joueur();
//		daoJoueur.inscrireJoueur("PAGNON", "Gr�goire", "dromelon", 28, "dromelon", "dromelon", "dromelon@wanadoo.org");
//		Joueur joueur7 = new Joueur();
//		daoJoueur.inscrireJoueur("CORRE", "Benjamin", "autruchon", 29, "autruchon", "autruchon", "autruchon@wanadoo.org");
//		Joueur joueur8 = new Joueur();
//		daoJoueur.inscrireJoueur("TEK", "Emmanuelle", "anon", 29, "anon", "anon", "anon@wanadoo.org");
//		Joueur joueur9 = new Joueur();
//		daoJoueur.inscrireJoueur("PERROUAULT", "Jérémy", "carpillon", 12 ,"carpillon", "carpillon", "carpillon@wanadoo.org");
//		Joueur joueur10 = new Joueur();
//		daoJoueur.inscrireJoueur("ROYAL", "Constance", "loutron", 24, "loutron", "loutron", "loutron@wanadoo.org");
//		
//		//Cr�ation cartes phrases:
//		CartePhrase cp1 = new CartePhrase("Bonjour je m'appelle _ ",1);
//		CartePhrase cp2 = new CartePhrase("Ce qui distingue l'homme de l'animal � mon sens c'est _ ",1);
//		CartePhrase cp3 = new CartePhrase(" _ c'est bien, _ c'est mieux ",3);
//		CartePhrase cp4 = new CartePhrase("Chez nous, _ se transmet de père en fils depuis des générations",1);
//		//Cr�ation de cartes mots:
//		CarteMotDefini cm1 = new CarteMotDefini("Mon 7e CDD");
//		CarteMotDefini cm2 = new CarteMotDefini("Rater l'apéro");
//		CarteMotDefini cm3 = new CarteMotDefini("Faire le café et les reliures");
//		CarteMotDefini cm4 = new CarteMotDefini("Marcher pieds nu sur un légo");
//		CarteMotDefini cm5 = new CarteMotDefini("Les énarques");
//		CarteMotDefini cm6 = new CarteMotDefini("Croire au père nöel");
//		CarteMotDefini cm7 = new CarteMotDefini("Le droit de cuissage");
//		CarteMotDefini cm8 = new CarteMotDefini("Le voir machouiller un légo");
//		CarteMotDefini cm9 = new CarteMotDefini("Une blague bien mysogine comme on les aime");
//		CarteMotDefini cm10 = new CarteMotDefini("Une bouteille de pastis et un Justin Bridou à partager");
//		paquet.ajouterCarteAuPaquet(cp1,cp2, cp3, cp4, cm1, cm2, cm3, cm4, cm5, cm6, cm7, cm8, cm9, cm10);
//		/*
//		 * ajouterCarteAuPaquet(paquet, cartePhrase, carteMot);
//		 * listerCartesDuPaquet(paquet);
//		 */

		
	
		
	int menu;
	Scanner sc = new Scanner(System.in);
	
	do {
	menu();
	menu = sc.nextInt();
		switch (menu) {
		            case 1:
		        		Joueur joueur = new Joueur();
		        		//daoJoueur.inscrireJoueur();
		                break;
		            case 2:
		                //daoJoueur.connection();
		                break;
		            case 3:
		            	listerJoueurs();
		                break;
		            case 4:
		            	int choixcreer;
		        
		        	do {
		        		System.out.println("\n Que voulez-vous créer comme carte ? \n"
			        			+ "1 - Une carte phrase \n"
			        			+ "2 - Une carte mot");
			        		choixcreer = sc.nextInt();
		        	
		        		try {
		        	
							if (choixcreer==1){
								//daoCartePhrase.creerCartePhrase();
							}
							else if (choixcreer ==2) {
					           // daoCarteMotDefini.creerCarteMotDefini();
							}
						} catch (Exception e) {
		        		System.out.println("Ce choix ne vous est pas proposé.");
		           		    
						}
		        	} while(choixcreer!=1 && choixcreer!=2); 
						break;

		            case 5:
		                //modifierCarte();
		                break;
		            case 6:
		                //supprimerCarte();
		                break;
		            case 7:
//		            	IDAOCarteMotDefini daoCarteMot = new DAOCarteMotDefiniHibernate(em);
		        		System.out.println("\n Voici la liste des cartes mots \n");
		        		for (CarteMotDefini c : daoCarteMotDefini.findAll()) {
		        			System.out.println(" La carte d'id numéro "+c.getId()+" contient le mot : "+c.getMot());
		        		}
		        		System.out.println("--------------------------------------------------------------------------------------------------");
		        		System.out.println("\n Voici la liste des cartes phrases \n ");
		        		for (CartePhrase c: daoCartePhrase.findAll()) {
		        			System.out.println("La carte d'id numéro : "+c.getId()+" contient la phrase "+c.getPhrase()+" qui rapporte "+c.getPoints());
		        		}
		        		break;
		            case 8:
		            	menu = 0;
		            	//Création partie et récupération des cartes pour constituer un paquet de la partie
		                Partie nouvellePartie = creerPartie();
		                Scanner scan = new Scanner(System.in);
		                int choix;
		                
		            do {
		                System.out.println("Voici les joueurs inscrits, qui participe ? (tapez 0 une fois que vous avez sélectionné les participants) \n Vous pouvez jouer seul mais c'est un peu triste...");
		                listerJoueurs();
		                choix = scan.nextInt();
		                if (choix > 0) {
		                	Optional<Joueur> joueurAAjouter = daoJoueur.findById(choix);
//		                	//CORRIER �A, ON A DES LISTES DEPUIS SPRING
//		                	System.out.println(joueurAAjouter.getId() +" nom "+joueurAAjouter.getNom());
//		                	//Crée une participation pour la partie et le joueur sélectionné et l'enregistre dans la BDD
//		                	creerParticipation(joueurAAjouter, nouvellePartie, daoParticipation);
//		                	
//		                	//On ajoute le joueur dans la liste de joueur de la partie (supprimer ça ?)
//		                    nouvellePartie.ajouterJoueurs(joueurAAjouter);
		                }
		            } while(choix != 0);

		            //Enregistrer la partie dans la bdd:
		            daoPartie.save(nouvellePartie);
		            
		            System.out.println("C'est parti voici vos cartes: ");
		            nouvellePartie.distribuer(5);

		            Tour tour = nouvellePartie.tour();
		            tour.demandeDeJouer();
		            
		            	break;
		            	
		            case 0:
		            	sc.close();
		            	break;
		}
	} while (menu != 0);
			
	}
	
	public void ajouterJoueurs(ArrayList<Joueur> listeJoueurs, Joueur... c) {
		listeJoueurs.addAll(Arrays.asList(c));
	}
	
	public void listerJoueurs(ArrayList<Joueur> listeJoueurs) { 
		for (Joueur j: listeJoueurs) {
				System.out.println("Joueur - son pseudo est"+j.getPseudo() + 
						" il a "+j.getAge()+" ans et "+j.getScore() +" points");
			}
			
		}
	
	
	

	
    
    
    
    public void menu() {
    	
                    System.out.println("-------------------------------");
                    System.out.println("\r");
                    System.out.println("   Les options sont : ");
                    System.out.println("\r");
                    System.out.println("1- Inscription");
                    System.out.println("\r");
                    System.out.println("2- Connexion");
                    System.out.println("\r");
                    System.out.println( "3- Liste des joueurs");
                    System.out.println("\r");
                    System.out.println( "4- Ajouter une carte");
                    System.out.println("\r");
                    System.out.println("5- Modifier une carte");
                    System.out.println("\r");
                    System.out.println("6- Supprimer une carte");
                    System.out.println("\r");
                    System.out.println("7- Lister les cartes");
                    System.out.println("\r");
                    System.out.println("8 - Lancer une partie ");
                    System.out.println("\r");
                    System.out.println("0- Quitter");
                    System.out.println("\r");
                    System.out.println("-------------------------------");
                    System.out.println("Saisissez le numéro d'une option:");
                    
                }
    
    public void listerJoueurs() {
//    	IDAOJoueur daoJoueur = new DAOJoueurHibernate(em);
		//Liste des joueurs:
		System.out.println("Voici la liste des joueurs: \n");
		for (Joueur j : daoJoueur.findAll()) {
			System.out.println("Joueur ID numéro: "+j.getId()+
					" - Il s'appelle "+j.getPrenom()+" "+j.getNom()+
					" et son pseudo est: "+j.getPseudo());
		}
    }
    
    //Créée une participation pour un joueur et l'enregistre
    public void creerParticipation(Joueur j, Partie p,IDAOParticipation daoParticipation) {
    	Participation participation = new Participation(j,p);
    	daoParticipation.save(participation);
    }
    
    public void creerParticipationAvecEquipes(Joueur j, Partie p, Equipe e) {
    	
    }
         
    //Construction d'un paquet avec toutes les cartes de la BD et attribution de ce paquet
    //a une partie.
    public Paquet creationPaquet() {
//		IDAOCartePhrase daoCartePhrase = new DAOCartePhraseHibernate(em);
//		IDAOCarteMotDefini daoCarteMotDefini = new DAOCarteMotDefiniHibernate(em);
		Paquet paquet = new Paquet();
		paquet.setPaquetCartesPhrases(daoCartePhrase.findAll());
		paquet.setPaquetCartesMotsDefinis(daoCarteMotDefini.findAll());
		
		return paquet;
    }
    //Crée une partie.
    public Partie creerPartie() {
    	Partie nouvellepartie = new Partie();
    	Paquet paquet = creationPaquet();
        nouvellepartie.ajouterPaquet(paquet);
        nouvellepartie.melangerPaquets();
        
        
        return nouvellepartie;
    }
}

