package fr.sopra.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	private int id;
	
	
	@Column(name = "UTI_NOM", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String nom = "Unknown";
	
	@Column(name = "UTI_PRENOM", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String prenom = "Unknown";
	
	@Column(name = "UTI_USERNAME", length = 30,  nullable = false)
	@Size(max=30)
	@NotEmpty
	private String username = "Unknown";
	
	@Column(name = "UTI_PASSWORD", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String password = "Unknown"; 
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	public Utilisateur() {
//		
//	}
//	
//	public Utilisateur(String nomUtilisateur, String prenom, String username, String password) {
//		super();
//		this.nomUtilisateur = nomUtilisateur;
//		this.prenom = prenom;
//		this.username = username;
//		this.password = password;
//		this.idUtilisateur = 0;
//	}
	

	
}	
