package fr.sopra.model.game;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

public class Sopramon extends Utilisateur implements ICombattant<Sopramon, Boss, Combat> {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOP_ID")
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "SOP_DATE")
	@NotEmpty
	private Date dateNaissance;
	
	
	@Column(name = "SOP_EXPERIENCE")
	@PositiveOrZero
	@NotEmpty
	private int experience;
	
	@Column(name = "SOP_NIVEAU", nullable = false)
	@Positive
	@NotEmpty
	private int niveau;
	
	@Column(name = "SOP_ARGENT")
	@NotEmpty
	@PositiveOrZero
	private double argent;
	
	@Column(name = "SOP_NOM", length=30, nullable = false)
	@NotEmpty
	@Size(max = 30)
	private String nom;
	
	@OneToOne
	@JoinColumn(name = "SOP_CAPACITE_ID")
	private Capacite capacite;
	
	@OneToOne
	@JoinColumn(name = "SOP_UTILISATEUR_ID")
	private Utilisateur utilisateur;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SOP_SIGNE")
	@NotEmpty
	private Signe signe;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SOP_TYPE")
	@NotEmpty
	private Type type;

		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNaissance() {
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Signe getSigne() {
		return signe;
	}

	public void setSigne(Signe signe) {
		this.signe = signe;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Sopramon [id=" + id + ", dateNaissance=" + dateNaissance + ", experience=" + experience + ", niveau="
				+ niveau + ", argent=" + argent + ", capacite=" + capacite.toString() + ", utilisateur=" + utilisateur + ", signe="
				+ signe + ", nom=" + nom + ", type=" + type + "]";
	}

	public Sopramon() 
	{
		super("UNKNOWN", "UNKNOWN", "UNKNOWN", "UNKNOWN");
		this.nom = "unknown";
		this.dateNaissance = new Date();
		this.experience = 0;
		this.niveau = 0;
		this.argent = 0d;
		this.capacite = new Capacite();
		this.type = type.UNKNOWN;
	}
	
	
	public Sopramon(String nomUtilisateur, String prenom, String username, String password, Date dateNaissance){
		super(nomUtilisateur, prenom, username, password);
		this.dateNaissance = dateNaissance;
		this.nom = "unknown";
		this.experience = 0;
		this.niveau = 0;
		this.argent = 0d;
		this.capacite = new Capacite();
		this.signe = signe.UNKNOWN;
	}


//	@Override
//	public void attaquerBoss(Sopramon sop, Boss boss, Combat combat) {
//		
//		DAOCoupSQL daoCoup = new DAOCoupSQL();
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

//	@Override
//	public void attaquerSopramon(Sopramon sop, Sopramon sop2, Combat combat) {
//		// TODO Auto-generated method stub
//		
//	}
//
//@Override
//public void attaquerBoss(Sopramon entity, Boss entity2, Combat combat) {
//	// TODO Auto-generated method stub
	
//}


}



