package fr.sopra.model.game;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "boss")
public class Boss implements ICombattant<Sopramon,Boss, Combat> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOS_ID")
	private int id;
	
	@Column(name = "BOS_NOM", length = 50, nullable = false)
	@NotEmpty
	@Size(max = 50)
	private String nom = "Unknown";
	
	@Column(name = "BOS_NIVEAU", nullable = false)
	@Positive
	@NotEmpty
	private int niveau = 1;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "BOS_CAPACITE_ID")
	@NotEmpty
	private Capacite capacite = new Capacite();
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "BOS_SIGNE_ID")
	@NotEmpty
	private Signe signe = Signe.UNKNOWN;
	
	@OneToMany(mappedBy="boss")
	private List<Coup> coups;

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

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Capacite getCapacite() {
		return capacite;
	}

	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	public Signe getSigne() {
		return signe;
	}

	public void setSigne(Signe signe) {
		this.signe = signe;
	}



	@Override
	public String toString() {
		return "Boss [id=" + id + ", nom=" + nom + ", niveau=" + niveau + ", capacite=" + capacite + ", signe=" + signe
				+ "]";
	}

//	@Override
//	public void attaquerBoss(Sopramon entity, Boss entity2, Combat combat) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void attaquerSopramon(Sopramon entity, Sopramon entity2, Combat combat) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
