package fr.sopra.model.game;

public class Capacite {
	private int id;
	private int pointsDeVie;
	private int attaque;
	private int defense;
	private int esquive;
	private int vitesse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getEsquive() {
		return esquive;
	}

	public void setEsquive(int esquive) {
		this.esquive = esquive;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	@Override
	public String toString() {
		return "Capacite [id=" + id + ", pointsDeVie=" + pointsDeVie + ", attaque=" + attaque + ", defense=" + defense
				+ ", esquive=" + esquive + ", vitesse=" + vitesse + "]";
	}

	public Capacite() {
		super();
		this.id = 0;
		this.pointsDeVie = 0;
		this.attaque = 0;
		this.defense = 0;
		this.esquive = 0;
		this.vitesse = 0;
	}

}
