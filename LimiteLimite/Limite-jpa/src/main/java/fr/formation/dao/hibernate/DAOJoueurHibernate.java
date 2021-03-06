package fr.formation.dao.hibernate;

import java.security.Key;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.dao.IDAOJoueur;
import fr.formation.joueur.Joueur;
import fr.formation.joueur.PseudoDejaPrisException;

public class DAOJoueurHibernate implements IDAOJoueur {

	private EntityManager em;

	public DAOJoueurHibernate(EntityManager em) {
		this.em = em;
	}

	public List<Joueur> findAll() {

		List<Joueur> myJoueurs = this.em.createQuery("select p from Joueur p", Joueur.class).getResultList();

		return myJoueurs;
	}

	public Joueur findById(int id) {
		return this.em.find(Joueur.class, id);
	}

	public Joueur save(Joueur entity) {

		// récupérer transaction
		EntityTransaction tx = em.getTransaction();
		try {
			// la démarer
			tx.begin();
			// persister
			em.persist(entity);
			// commiter la transaction
			tx.commit();
		} catch (Exception e) {
			// catch rollback
			tx.rollback();
		}

		return null;
	}

	public void delete(Joueur entity) {
		// récupérer transaction
		EntityTransaction tx = em.getTransaction();
		try {
			// la démarer
			tx.begin();
			// persister
			em.remove(em.merge(entity));
			// commiter la transaction
			tx.commit();
		} catch (Exception e) {
			// catch rollback
			tx.rollback();
		}

	}

	public void deleteById(int id) {
		Joueur leJoueurAsupprimer = new Joueur();
		leJoueurAsupprimer.setId(id);
		this.delete(leJoueurAsupprimer);

	}

	// Si le pseudo qu'on cherche est déja lié à un Joueur, cette méthode renvoie
	// null, sinon elle renvoie le Joueur en question.
	public Joueur findJoueurByPseudo(String pseudo) {
		try {
			return this.em.createQuery("select j from Joueur j" + " where j.pseudo = :pseudo", Joueur.class)
					.setParameter("pseudo", pseudo).getResultList().get(0);
		} catch (Exception e) {
			return null;

		}
	}

	 public void connection() {

			Scanner sc = new Scanner(System.in);
			String pseudo;
			String passwordConnexion;
//			Joueur joueur = new Joueur();
			boolean retaper=false;
			boolean retaper2=false;
			//demande pseudo
			
			

			// Vérifier si le pseudo est bien dans la base
			do {
				retaper=false;
					System.out.println("Entrez votre pseudo: ");
					pseudo = sc.nextLine();
					if (findJoueurByPseudo(pseudo)!=null) {
						Joueur j = this.findJoueurByPseudo(pseudo);
			
						//verifie si mdp entr� correct
							do {
								
								if (retaper2) {
									System.out.println("Erreur dans le mot de passe");
									
								}
									System.out.println("Entrez votre mot de passe : \n");
									passwordConnexion = sc.next();
									passwordConnexion = encrypt(passwordConnexion, "soprasteria");
									retaper2 = true;
							} while ((!passwordConnexion.equals(j.getPassword())) );
						
						System.out.println(" - Vous êtes connecté - ");
						
						retaper2= false;
					}
					else {
					System.out.println("Ce pseudo n'existe pas, retapez votre pseudo ou inscrivez-vous !");
					retaper=true;
					}

			} while (retaper);
			
	 }

	public void inscrireJoueur() {
		Joueur nouveauJoueur = new Joueur();
		String nom = "";
		String prenom = "";
		String pseudo = "";
		String mail = "";
		int age = 0;
		String password = "";
		String passwordVerif = "";
		boolean retaper = false;
		Scanner sc = new Scanner(System.in);

		do {
			if (retaper) {
				System.out.println("Entrez un nom correct !!! ");
			}
			System.out.println("Nom: \n");
			nom = sc.nextLine();
			if (verifNomPrenom(nom)) {
				retaper = false;
			} else {
				retaper = true;
			}
		} while (retaper);

		do {
			if (retaper) {
				System.out.println("Entrez un prénom correct !!! ");
			}
			System.out.println("Prénom: \n");
			prenom = sc.nextLine();
			if (verifNomPrenom(prenom)) {
				retaper = false;
			} else {
				retaper = true;
			}
		} while (retaper);

		do {
			try {
				if (retaper) {
					System.out.println("Entrez un age correct !!!");
					sc.next();
				}
				System.out.println("Age: \n");
				age = sc.nextInt();
				retaper = false;
			} catch (Exception e) {
				retaper = true;
			}
		} while (retaper);

		do {
			retaper = false;
			System.out.println("Pseudo: \n");
			pseudo = sc.next();
			if (findJoueurByPseudo(pseudo) == null) {
				// ok
			} else {
				retaper = true;
				System.out.println("Pseudo déja pris ! \n Choisissez autre chose:");
			}

		} while (retaper);

		do {
			if (retaper) {
				System.out.println("Erreur dans le mot de passe");
			}
			System.out.println("Password de 6 caractères mini : \n");
			password = sc.next();
			System.out.println("Vérifier le mot de passe: \n");
			passwordVerif = sc.next();
			retaper = true;
			System.out.println(password);
			System.out.println(passwordVerif);
		} while ((!password.equals(passwordVerif)) || (password.length() < 6));

		do {
			System.out.println("Mail: \n");
			mail = sc.next();
			if (verifMail(mail)) {
				retaper = false;
			} else {
				retaper = true;
				System.out.println("Erreur dans le mail");
			}
		} while (retaper);

		nouveauJoueur.setNom(nom);
		nouveauJoueur.setPrenom(prenom);
		nouveauJoueur.setAge(age);
		nouveauJoueur.setPseudo(pseudo);
		nouveauJoueur.setMail(mail);
		// Cryptage mdp avant envoi en DB:
		password = encrypt(password, "soprasteria");
		nouveauJoueur.setPassword(password);

		// Verification:
		System.out
				.println("Joueur créée \n" + "Nom: " + nom + "Prénom: " + prenom + "Age: " + age + "Pseudo: " + pseudo);
		// Envoi en DB:

		save(nouveauJoueur);
		System.out.println("Joueur inscit ,BRAVO !");
	}

	public void inscrireJoueur(String nom, String prenom, String pseudo, int age, String password,
			String passwordVerif, String mail) {

		if (findJoueurByPseudo(pseudo)==null) {
			Joueur nouveauJoueur = new Joueur();
			nouveauJoueur.setNom(nom);
			nouveauJoueur.setPrenom(prenom);
			nouveauJoueur.setAge(age);
			nouveauJoueur.setPseudo(pseudo);
			nouveauJoueur.setMail(mail);
			// Cryptage mdp avant envoi en DB:
			password = encrypt(password, "soprasteria");
			nouveauJoueur.setPassword(password);
	
			// Verification:
			System.out.println("Joueur cr��e \n" + "Nom: " + nom + "Pr�nom: " + prenom + "Age: " + age
					+ "Pseudo: " + pseudo + "Mot de passe: :" + password);
			// Envoi en DB:
	
			save(nouveauJoueur);
			System.out.println("Joueur inscit ,BRAVO ! \n");
		
		}
		else {
			System.out.println("Pseudo déja pris ! \n Joueur non créé:");
		}
	}

	public String encrypt(String password, String key) {
		try {
			Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, clef);
			return new String(cipher.doFinal(password.getBytes()));
		} catch (Exception e) {
			return null;
		}
	}

	public String decrypt(String password, String key) {
		try {
			Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, clef);
			return new String(cipher.doFinal(password.getBytes()));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// Prend un string et retourne vrai si plus de 0 char et A-Z a-z - éè...
	public boolean verifNomPrenom(String nomPrenom) {
		if (!nomPrenom.isEmpty() && nomPrenom.matches("^[a-zA-ZéèÉÈàÀùÙôÔêÊ]+([\\-\\' ][a-zA-ZéèÉÈàÀùÙôÔêÊ]+)*$")) {
			return true;
		} else
			return false;
	}

	// Prend un string et retourne vrai si mail correctement entré
	public boolean verifMail(String nomPrenom) {
		if (!nomPrenom.isEmpty() && nomPrenom.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			return true;
		} else
			return false;
	}


}
