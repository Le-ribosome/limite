package fr.formation.cartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Paquet {

	
	int nombreCartes;
	//Sert a rien on peut le virer
    private List<Carte> paquet = new ArrayList<Carte>();
    private List<CartePhrase> paquetCartesPhrases = new ArrayList<CartePhrase>();
    private List<CarteMotDefini> paquetCartesMotsDefinis = new ArrayList<CarteMotDefini>();
	
	public Paquet() {
		
	}
	
	public void creerCarte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez vous créer (Carte Phrase, tapez 1 \nCarte mot, tapez 2 \n ");
        int choix = sc.nextInt();
        sc.nextLine();
        String mot;
        if (choix == 1) {
            System.out.println("Entrez la phrase avec un underscore _ à la place des trous: ");
            mot = sc.nextLine();
            System.out.println("Combien de points font gagner cette carte ? ");
            int points = sc.nextInt();
            CartePhrase cartePhrase = new CartePhrase(mot, points);
            this.ajouterCarteAuPaquet(cartePhrase);
            this.paquetCartesPhrases.add(cartePhrase);
        }

        if (choix == 2) {
            System.out.println("Entrez le mot: ");
            mot = sc.nextLine();
            CarteMotDefini carteMot = new CarteMotDefini(mot);
            this.paquetCartesMotsDefinis.add(carteMot);
        }

    }
	
	public void creerCartePhrase(String phrase, int points) {
        CartePhrase cartePhrase = new CartePhrase(phrase, points);
        this.paquet.add(cartePhrase);
        this.paquetCartesPhrases.add(cartePhrase);
    }

    public void creerCarteMot(String mot) {
        CarteMotDefini carteMot = new CarteMotDefini(mot);
        this.paquet.add(carteMot);
        this.paquetCartesMotsDefinis.add(carteMot);
    }
	
	public void ajouterCarteAuPaquet(CartePhrase... c) {
		this.paquet.addAll(Arrays.asList(c));
		this.paquetCartesPhrases.addAll(Arrays.asList(c));
	}
	public void ajouterCarteAuPaquet(CarteMotDefini... c) {
		this.paquet.addAll(Arrays.asList(c));
		this.paquetCartesMotsDefinis.addAll(Arrays.asList(c));
	}
	 
	public void listerCartesDuPaquet() { 
		for (Carte c: this.paquet) {
			
			if (c instanceof CartePhrase) {
				System.out.println("Carte phrase - son num�ro est"+c.getId()+
						" - La phrase a trou est // "+((CartePhrase)c).getPhrase()+" // et elle rapporte "+((CartePhrase)c).getPoints()+ " points.");
			}
			else if (c instanceof CarteMotDefini) {
				System.out.println("Carte mot - son num�ro est " +c.getId()+
						" et le mot est " +((CarteMotDefini)c).getMot());
			}
			
		} 
	}
	
	public int getNombreCartes() {
		return nombreCartes;
	}
	public void setNombreCartes(int nombreCartes) {
		this.nombreCartes = nombreCartes;
	}

	public List<Carte> getPaquet() {
		return paquet;
	}

	public void setPaquet(List<Carte> paquet) {
		this.paquet = paquet;
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
