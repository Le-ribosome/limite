package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cartes.CarteMotDefini;

public interface IDAOCarteMotDefini  extends JpaRepository<CarteMotDefini, Integer> {

}
