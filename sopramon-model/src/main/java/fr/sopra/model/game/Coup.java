package fr.sopra.model.game;

import java.sql.Date;

public class Coup {
	private int id;
	private Date date;
	private int degats;
	private int persistance;
	private Sopramon sopramon;
	private Boss boss;
	private Combat combat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getPersistance() {
		return persistance;
	}

	public void setPersistance(int persistance) {
		this.persistance = persistance;
	}

	public Sopramon getSopramon() {
		return sopramon;
	}

	public void setSopramon(Sopramon sopramon) {
		this.sopramon = sopramon;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Combat getCombat() {
		return combat;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}

}
