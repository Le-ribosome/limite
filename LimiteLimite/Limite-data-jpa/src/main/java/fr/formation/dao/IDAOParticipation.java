package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.jeu.Participation;

public interface IDAOParticipation  extends JpaRepository<Participation, Integer> {

}
