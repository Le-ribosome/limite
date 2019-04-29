package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.joueur.Joueur;

public interface IDAOJoueur  extends JpaRepository<Joueur, Integer> {

}
