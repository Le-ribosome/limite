package fr.formation.dao;

import fr.formation.joueur.Joueur;

public interface IDAOJoueur extends IDAO<Joueur> {
	public Joueur findJoueurByPseudo(String pseudo);
	public void inscrireJoueur();
	public void connection();
	public void inscrireJoueur(String nom, String prenom, String pseudo, int age, String password,
			String passwordVerif, String mail);
	public boolean verifMail(String nomPrenom);
} 