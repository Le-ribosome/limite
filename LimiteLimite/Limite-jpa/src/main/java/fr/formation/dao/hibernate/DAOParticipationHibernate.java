package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.dao.IDAOParticipation;
import fr.formation.jeu.Participation;


public class DAOParticipationHibernate implements IDAOParticipation {

	private EntityManager em;
	
	
	public DAOParticipationHibernate(EntityManager em) {
	this.em=em;
	
	}
	
	
	public List<Participation> findAll() {
		// TODO Auto-generated method stub
		List<Participation> mesParticipations = em.createQuery("select c from Participation c", Participation.class).getResultList();

		return mesParticipations;
	}

	public Participation findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Participation.class, id  );
	}

	public Participation save(Participation entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); // ou pour remplacer ces deux lignes : em.getTransaction().begin();
		em.persist(entity);
		tx.commit(); 
		return null;
	}

	public void delete(Participation entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); // ou pour remplacer ces deux lignes : em.getTransaction().begin();
		em.remove(em.merge(entity)); // bien utiliser merge pour que l'entity manager le reconnaisse
		tx.commit();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Participation laParticipationASupprimer = new Participation();
		laParticipationASupprimer.setId(id);
		this.delete(laParticipationASupprimer);
	}	
}