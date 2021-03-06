package fr.sopra.model.game;

import java.util.Date;

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
import javax.validation.constraints.PositiveOrZero;

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
	
	@Column(name="COU_DEGATS")
	@PositiveOrZero
	private int degats;
	
	@Column(name="COU_PERSISTANCE")
	@PositiveOrZero
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

	public void setSopramon(ICombattant sopramon) {
		this.sopramon = (Sopramon) sopramon;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(ICombattant  boss) {
		this.boss = (Boss) boss;
	}

	public Combat getCombat() {
		return combat;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}
	
	public void setAttaquant(ICombattant attaquant) {
		if (attaquant instanceof Boss)
		{
			this.boss = (Boss)attaquant;
		}
		else  {
				this.sopramon = (Sopramon) attaquant;
		}
	}

	public ICombattant getAttaquant() {
		if (this.getBoss() == null) {
		
			return this.sopramon;
		}
		else  {
				return this.boss;
		}
	}
}
