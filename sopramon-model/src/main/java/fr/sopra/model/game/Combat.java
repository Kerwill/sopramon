package fr.sopra.model.game;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "combat")
public class Combat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COM_ID")
	private int id;
	
	@Column(name="COM_TOUR", nullable=false)
	@PositiveOrZero
	private int tour;
	
	@ManyToOne 
	@JoinColumn(name="COM_SOPRAMON_ID")
	private Sopramon sopramon1;
	
	@ManyToOne
	@JoinColumn(name="COM_SOPRAMON2_ID")
	private Sopramon sopramon2;
	
	@ManyToOne 
	@JoinColumn(name="COM_BOSS_ID")
	private Boss boss;
	
	@OneToMany(mappedBy="combat")
	private List<Coup> coups;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "COM_ARENE")
	@NotEmpty
	private Arene arene = Arene.UNKNOWN;

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
	public List<Coup> getCoups() {
		return coups;
	}

	public void setCoups(List<Coup> coups) {
		this.coups = coups;
	}
	
	public void setAttaquant1(ICombattant attaquant) {
		if (attaquant instanceof Boss)
		{
			this.boss = (Boss) attaquant;
		}
		else  {
				this.sopramon1 = (Sopramon) attaquant;
		}
	}

	public ICombattant getAttaquant1() {
		if (this.getBoss() == null) {
		
			return this.sopramon1;
		}
		else  {
				return this.boss;
		}
	}

	public void setAttaquant2(ICombattant attaquant) {
		this.sopramon2 = (Sopramon) attaquant;
		}

	public ICombattant getAttaquant2() {	
			return this.sopramon2;
	}		
					
	public Combat(ICombattant attaquant1, ICombattant attaquant2) {
		this.setAttaquant1(attaquant1);
		this.setAttaquant2(attaquant2);
	}


	public Combat() {
	}

	@Override
	public String toString() {
		return "Combat [id=" + id + ", tour=" + tour + ", sopramon1=" + sopramon1 + ", sopramon2=" + sopramon2
				+ ", boss=" + boss + "]";
	}

}
