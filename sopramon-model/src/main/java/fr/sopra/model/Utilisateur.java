package fr.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)

public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	private int id;
	
	
	@Column(name = "UTI_NOM", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String nomUtil = "Unknown";
	
	@Column(name = "UTI_PRENOM", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String prenomUtil = "Unknown";
	
	@Column(name = "UTI_USERNAME", length = 30,  nullable = false)
	@Size(max=30)
	@NotEmpty
	private String username = "Unknown";
	
	@Column(name = "UTI_PASSWORD", length = 30, nullable = false)
	@Size(max=30)
	@NotEmpty
	private String password = "Unknown"; 
	
	@Column(name = "UTI_ACCESS")
	private int access = 0;
	
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUtil() {
		return nomUtil;
	}
	public void setNomUtil(String nom) {
		this.nomUtil = nom;
	}
	public String getPrenomUtil() {
		return prenomUtil;
	}
	public void setPrenomUtil(String prenom) {
		this.prenomUtil = prenom;
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
