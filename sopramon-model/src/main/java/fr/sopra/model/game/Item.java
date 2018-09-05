package fr.sopra.model.game;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITE_ID")
	private int id;
	
	@Column(name="ITE_NOM", length=50, nullable=false)
	@NotEmpty(message="Le nom est obligatoire.")
	@Size(max=50, message= "Le nom ne doit pas dÃ©passer 50 caractères.")
	private String nom;
	
	@Column(name="ITE_PRIX", nullable=false)
	@Positive(message="Le prix doit être positif.")
	@Min(1)
	private double prix;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="ITE_CAPACITE_ID")
	private Capacite capacite = new Capacite();


	@OneToMany(mappedBy="item")
	private List<Achat> achats;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom; 
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Capacite getCapacite() {
		return capacite;
	}

	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nom=" + nom + ", prix=" + prix + ", capacite=" + capacite + ", achats=" + achats
				+ "]";
	}

}
