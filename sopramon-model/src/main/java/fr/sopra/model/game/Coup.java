package fr.sopra.model.game;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "coup")
public class Coup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COU_ID")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="COU_DATE")
	private Date date;
	
	@Column(name="COU_DEGATS", nullable=false)
	@Positive 
	@NotEmpty
	private int degats;
	
	@Column(name="COU_PERSISTANCE", nullable=false)
	@Positive 
	@NotEmpty
	private int persistance;
	
	@ManyToOne 
	@JoinColumn(name="COU_SOPRAMON_ID")
	private Sopramon sopramon;
	
	@ManyToOne 
	@JoinColumn(name="COU_BOSS_ID")
	private Boss boss;
	
	@ManyToOne 
	@JoinColumn(name="COU_COMBAT_ID")
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
