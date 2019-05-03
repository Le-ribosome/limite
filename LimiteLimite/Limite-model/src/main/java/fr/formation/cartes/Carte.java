package fr.formation.cartes;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//fghjkl
@MappedSuperclass
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String categorie = "basic";

	
	public Carte() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
	
