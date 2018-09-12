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

@Entity
@Table(name = "achat")
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACH_ID")
	private int id;

	@Column(name = "ACH_PRIX", nullable = false)
	@Positive
	private double prix;

	@Column(name = "ACH_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "ACH_ITEM_ID")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "ACH_SOPRAMON_ID")
	private Sopramon sopramon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Sopramon getSopramon() {
		return sopramon;
	}

	public void setSopramon(Sopramon sopramon) {
		this.sopramon = sopramon;
	}

}
