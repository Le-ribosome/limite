package fr.formation.dao.hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.cartes.CartePhrase;
import fr.formation.dao.IDAOCartePhrase;

public class DAOCartePhraseHibernate implements IDAOCartePhrase {

	private EntityManager em;

	public DAOCartePhraseHibernate(EntityManager em) {
		this.em=em;
	}
	
	public List<CartePhrase> findAll() {

		List<CartePhrase> myCartePhrases = this.em.createQuery("select p from CartePhrase p", CartePhrase.class).getResultList();

		return myCartePhrases;
	}

	public CartePhrase findById(int id) {
		return this.em.find(CartePhrase.class, id);
	}

	public void creerCartePhrase() {
		   Scanner sc = new Scanner(System.in);
	        String phrase;   
		System.out.println("Entrez la phrase avec un underscore _ à la place des trous: ");
            phrase = sc.nextLine();
            System.out.println("Combien de points fait gagner cette carte ? ");
            int points = sc.nextInt();
            CartePhrase cartePhrase = new CartePhrase(phrase, points);
            this.save(cartePhrase);
        }
	
	
	public CartePhrase save(CartePhrase entity) {
		
		//récupérer transaction
		EntityTransaction tx = em.getTransaction();
		try {
			//la démarrer
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

	public void delete(CartePhrase entity) {
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

	public void deleteById(int id) {
		CartePhrase leCartePhraseAsupprimer = new CartePhrase();
		leCartePhraseAsupprimer.setId(id);
		this.delete(leCartePhraseAsupprimer);
		
	}

}