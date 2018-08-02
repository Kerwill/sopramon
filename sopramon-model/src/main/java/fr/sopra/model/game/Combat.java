package fr.sopra.model.game;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "combat")
public class Combat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COM_ID")
	private int id;
	
	// private Arene arene;
	// private Type type;
	
	@Column(name="COM_TOUR", nullable=false)
	@Positive 
	@NotEmpty
	private int tour;
	
	@ManyToOne 
	@JoinColumn(name="COM_SOPRAMON_ID")
	private Sopramon sopramon1;
	
	@ManyToOne 
	@JoinColumn(name="COM_SOPRAMON_ID")
	private Sopramon sopramon2;
	
	@ManyToOne 
	@JoinColumn(name="COM_BOSS_ID")
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
