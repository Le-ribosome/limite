package fr.formation.dao.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import fr.formation.dao.IDAOPartie;
import fr.formation.jeu.Partie;

public class DAOPartieHibernate implements IDAOPartie{

	private EntityManager em;
	
	
	public DAOPartieHibernate(EntityManager em) {
	this.em=em;
	
	}
	
	
	public List<Partie> findAll() {
		// TODO Auto-generated method stub
		List<Partie> mesParties = em.createQuery("select c from Partie c", Partie.class).getResultList();

		return mesParties;
	}

	public Partie findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Partie.class, id  );
	}

	public Partie save(Partie entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); // ou pour remplacer ces deux lignes : em.getTransaction().begin();
		em.persist(entity);
		tx.commit(); 
		return null;
	}

	public void delete(Partie entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); // ou pour remplacer ces deux lignes : em.getTransaction().begin();
		em.remove(em.merge(entity)); // bien utiliser merge pour que l'entity manager le reconnaisse
		tx.commit();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Partie laPartieASupprimer = new Partie();
		laPartieASupprimer.setId(id);
		this.delete(laPartieASupprimer);
	}
}