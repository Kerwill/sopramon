package fr.sopra.model.game;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


//import fr.sopra.DAOCapaciteSQL;
//import fr.sopra.DAO.DAOCoupSQL;
//import fr.sopra.DAO.DAOSopramonSQL;
import fr.sopra.model.Utilisateur;

@Entity
@Table(name = "sopramon")
@PrimaryKeyJoinColumn(name="SOP_ID", referencedColumnName="UTI_ID")

public class Sopramon extends Utilisateur implements ICombattant<Sopramon, Boss, Combat> {
	
	@Column(name = "SOP_NOM", length=30, nullable = false)
	@NotEmpty(message="Le nom est obligatoire.")
	@Size(max = 30, message="Le nom doit comporter moins de 30 caractères.")
	private String nom = "Unknown";
	
	@Temporal(TemporalType.DATE)
	@Column(name = "SOP_DATE")
	private Date dateNaissance = new Date();
	
	
	@Column(name = "SOP_EXPERIENCE")
	@PositiveOrZero(message="La valeur d'expérience est supérieure ou égale à 0.")
	private int experience = 0;
	
	@Column(name = "SOP_NIVEAU", nullable = false)
	@Positive(message="Le niveau doit être strictement supérieur à 0.")
	private int niveau = 1;
	
	@Column(name = "SOP_ARGENT")
	@PositiveOrZero (message="La maison ne fait pas crédit !!")
	private double argent = 0.00d;
	
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "SOP_CAPACITE_ID")
	private Capacite capacite = new Capacite();
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SOP_SIGNE")
	private Signe signe = Signe.UNKNOWN;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SOP_TYPE")
	private Type type = Type.UNKNOWN;
	
	
	@OneToMany(mappedBy="sopramon")
	private List<Achat> achats;

	@OneToMany(mappedBy="sopramon")
	private List<Coup> coups;


	public Date getDateNaissance(){
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public double getArgent() {
		return argent;
	}

	public void setArgent(double argent) {
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		this.type = signe.getType();
	}

	public Type getType() {
		return type;
	}



	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public List<Coup> getCoups() {
		return coups;
	}

	public void setCoups(List<Coup> coups) {
		this.coups = coups;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Sopramon [nom=" + nom + ", dateNaissance=" + dateNaissance + ", experience=" + experience + ", niveau="
				+ niveau + ", argent=" + argent + ", capacite=" + capacite + ", signe=" + signe + ", type=" + type;
	}






//
//	@Override
//	public void attaquerBoss(Sopramon sop, Boss boss, Combat combat) {
//		
//		DAOCoupHibernate daoCoup = new DAOCoupHibernate();
//		Coup coup = new Coup();
//		int degats = sop.getCapacite().getAttaque();
//		coup.setDegats(degats);
//		coup.setSopramon(sop);
//		coup.setBoss(boss);
//		coup.setPersistance(0);
//		coup.setCombat(combat);
//	
//	int pv = boss.getCapacite().getPointsDeVie();
//	int defBoss = boss.getCapacite().getDefense();
//	boss.getCapacite().setPointsDeVie(pv + defBoss - coup.getDegats());
//	
//	daoCoup.save(coup);
//	}
//
//	@Override
//	public void attaquerSopramon(Sopramon sop, Sopramon sop2, Combat combat) {
//		// TODO Auto-generated method stub
//		
//	}
//
//@Override
//public void attaquerBoss(Sopramon entity, Boss entity2, Combat combat) {
//	// TODO Auto-generated method stub
//	
//}


}



