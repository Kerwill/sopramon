package fr.sopra.model.game;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Combat {
	private int id;
	// private Arene arene;
	// private Type type;
	private int tour;
	private Sopramon sopramon1;
	private Sopramon sopramon2;
	private Boss boss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public Sopramon getSopramon1() {
		return sopramon1;
	}

	public void setSopramon1(Sopramon sopramon1) {
		this.sopramon1 = sopramon1;
	}

	public Sopramon getSopramon2() {
		return sopramon2;
	}

	public void setSopramon2(Sopramon sopramon2) {
		this.sopramon2 = sopramon2;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Combat(Sopramon sopramon1, Boss boss) {
		super();
		this.sopramon1 = sopramon1;
		this.sopramon2 = new Sopramon();
		this.boss = boss;
	}

	public Combat() {
	}

	@Override
	public String toString() {
		return "Combat [id=" + id + ", tour=" + tour + ", sopramon1=" + sopramon1 + ", sopramon2=" + sopramon2
				+ ", boss=" + boss + "]";
	}

}
