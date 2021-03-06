package fr.formation.jeu;


import fr.formation.cartes.CarteMotDefini;
import fr.formation.cartes.CartePhrase;
import fr.formation.joueur.Joueur;

public class Tour extends Partie {
	
	private CartePhrase carteDuTour;
	
	
	//Lancer un nouveau tour reviens a devoiler une nouvelle carte phrase-A faire depuis la partie
	public Tour(Partie p) {
		this.carteDuTour=p.getPaquetCartesPhrases().get(0);
		//verif: 
		System.out.println("Voici la carte du tour: "+carteDuTour);
	}
	
	
	
	//On demande de jouer � tous les joueurs dans la partie, et on met en argument dans jouer 
		//le nombre de mots � demander au joueur. Si tout se passe bien après ça les joueurs ont 
	//le bon nombre de cartes mots dans leur arraylist jouerCarte.
		public void demandeDeJouer() {
			for (Joueur j: super.joueursDansLaPartie) {
				j.jouer(this.carteDuTour.getNbTrous());
			}
		}
		
		
		//comment faire, crééer une nouvelle classe réponse qui aurait trois attributs 
		//(carte phrase, liste de carte mots, nombre de vote) pour lier réponse aux joueurs ? Et associer() crée 
		//autant d'objets réponses que de joueurs
		public void associer() {
			for (Joueur j: this.joueursDansLaPartie) {
				//pour chaque joueur, mets dans l'ordre ses cartes mots dans le/les trous de la carte phrase du tour
			}
		}
		
		public void vote() {
			//Montre les différentes combinaisons
			//demande a tous les joueurs de voter pour la meilleure combinaison
			//donne le point au joueur qui a le plus de votes
		}
	
	public static String associer2Cartes(CartePhrase phrase, CarteMotDefini reponse) {
		String proposition;
				
		proposition = phrase.getPhrase().replace("_", reponse.getMot());
		
		return proposition;
	}

	public CartePhrase getCarteDuTour() {
		return carteDuTour;
	}

	public void setCarteDuTour(CartePhrase carteDuTour) {
		this.carteDuTour = carteDuTour;
	}

	

}
