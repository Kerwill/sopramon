package fr.sopra.model.game;

import java.sql.Date;
import java.time.LocalDate;

//import fr.sopra.DAOCapaciteSQL;
//import fr.sopra.DAO.DAOCoupSQL;
//import fr.sopra.DAO.DAOSopramonSQL;
import fr.sopra.model.Utilisateur;

public class Sopramon extends Utilisateur implements ICombattant<Sopramon, Boss, Combat> {
	private int id;
	private Date dateNaissance;
	private int experience;
	private int niveau;
	private double argent;
	private Capacite capacite;
	private Utilisateur utilisateur;
	private Signe signe;
	private String nom;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		this.dateNaissance = Date.valueOf(LocalDate.now());
		this.experience = 0;
		this.niveau = 0;
		this.argent = 0d;
		this.capacite = new Capacite();
		this.id = 0;
	}

	public Sopramon(String nom, String prenom, String username, String password) {
		super(nom, prenom, username, password);
		this.nom = "unknown";
		this.dateNaissance = Date.valueOf(LocalDate.now());
		this.experience = 0;
		this.niveau = 0;
		this.argent = 0d;
		this.capacite = new Capacite();
		this.id = 0;
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

	@Override
	public void attaquerSopramon(Sopramon sop, Sopramon sop2, Combat combat) {
		// TODO Auto-generated method stub
		
	}

@Override
public void attaquerBoss(Sopramon entity, Boss entity2, Combat combat) {
	// TODO Auto-generated method stub
	
}



}
