package fr.sopra.model.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "capacite")
public class Capacite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAP_ID")
	private int id;
	
	@Column(name = "CAP_PV", nullable = true)
	@PositiveOrZero
	@NotEmpty
	private int pointsDeVie = 0;
	
	@Column(name = "CAP_ATTAQUE", nullable = true)
	@PositiveOrZero
	@NotEmpty
	private int attaque = 0;
	
	@Column(name = "CAP_DEFENSE", nullable = true)
	@PositiveOrZero
	@NotEmpty
	private int defense = 0;
	
	@Column(name = "CAP_ESQUIVE", nullable = true)
	@PositiveOrZero
	@NotEmpty
	private int esquive = 0;
	
	@Column(name = "CAP_VITESSE", nullable = true)
	@PositiveOrZero
	@NotEmpty
	private int vitesse = 0;

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


}
