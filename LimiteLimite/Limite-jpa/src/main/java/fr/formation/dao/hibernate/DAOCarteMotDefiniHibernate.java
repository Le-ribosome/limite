package fr.formation.dao.hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.cartes.CarteMotDefini;
import fr.formation.cartes.CartePhrase;
import fr.formation.dao.IDAOCarteMotDefini;


public class DAOCarteMotDefiniHibernate implements IDAOCarteMotDefini {

	private EntityManager em;

	public DAOCarteMotDefiniHibernate(EntityManager em) {
		this.em=em;
	}
	
	public List<CarteMotDefini> findAll() {

		List<CarteMotDefini> myCarteMotDefinis = this.em.createQuery("select p from CarteMotDefini p", CarteMotDefini.class).getResultList();

		return myCarteMotDefinis;
	}

	public CarteMotDefini findById(int id) {
		return this.em.find(CarteMotDefini.class, id);
	}

	public CarteMotDefini save(CarteMotDefini entity) {
		
		//récupérer transaction
		EntityTransaction tx = em.getTransaction();
		try {
			//la démarer
			tx.begin();
			//persister
			em.persist(entity);
			//commiter la transaction
			tx.commit();
		} catch (Exception e) {
			//catch rollback
			tx.rollback();
		}
		
		
		return null;
	}

	public void delete(CarteMotDefini entity) {
		//récupérer transaction
				EntityTransaction tx = em.getTransaction();
				try {
					//la démarer
					tx.begin();
					//persister
					em.remove(em.merge(entity));
					//commiter la transaction
					tx.commit();
				} catch (Exception e) {
					//catch rollback
					tx.rollback();
				}
		
	}
	
	public void creerCarteMotDefini() {
		   Scanner sc = new Scanner(System.in);
	        String mot;   
		System.out.println("Entrez la phrase de la carte mot : ");
         mot = sc.nextLine();
         CarteMotDefini carteMotDefini = new CarteMotDefini(mot);
         this.save(carteMotDefini);
     }

	public void deleteById(int id) {
		CarteMotDefini leCarteMotDefiniAsupprimer = new CarteMotDefini();
		leCarteMotDefiniAsupprimer.setId(id);
		this.delete(leCarteMotDefiniAsupprimer);
		
	}


}