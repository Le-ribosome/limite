package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cartes.CartePhrase;

public interface IDAOCartePhrase extends JpaRepository<CartePhrase, Integer> {

}
