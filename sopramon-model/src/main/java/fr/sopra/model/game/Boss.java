package fr.sopra.model.game;

public class Boss implements ICombattant<Sopramon,Boss, Combat> {
	private int id;
	private String nom;
	private int niveau;
	private Capacite capacite;
	private Signe signe;

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

	

	public Boss() {
		super();
		this.id = 0;
		this.nom = "UNKNOWN";
		this.niveau = 0;
		this.capacite = new Capacite();
		this.signe = new Signe();
	}

	@Override
	public String toString() {
		return "Boss [id=" + id + ", nom=" + nom + ", niveau=" + niveau + ", capacite=" + capacite + ", signe=" + signe
				+ "]";
	}

	@Override
	public void attaquerBoss(Sopramon entity, Boss entity2, Combat combat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attaquerSopramon(Sopramon entity, Sopramon entity2, Combat combat) {
		// TODO Auto-generated method stub
		
	}
	
	
}
