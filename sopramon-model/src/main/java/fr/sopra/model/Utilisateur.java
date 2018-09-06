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
	@Size(max = 30, message="Le nom doit comporter moins de 30 caracteres.")
	@NotEmpty
	private String nomUtil = "Unknown";
	
	@Column(name = "UTI_PRENOM", length = 30, nullable = false)
	@Size(max = 30, message="Le prenom doit comporter moins de 30 caracteres.")
	@NotEmpty
	private String prenomUtil = "Unknown";
	
	@Column(name = "UTI_USERNAME", length = 30,  nullable = false)
	@Size(max = 30, message="Le username doit comporter moins de 30 caracteres.")
	@NotEmpty
	private String username = "Unknown";
	
	@Column(name = "UTI_PASSWORD", length = 500, nullable = false)
	@Size(min= 6, max=500, message="Le mot de passe doit etre compris entre 6 et 500 caracteres.")
	@NotEmpty
	private String password = "Unknown"; 
	
	@Column(name = "UTI_IS_ADMIN")
	private boolean admin;
	
	@Column(name = "UTI_IS_BANNED")
	private boolean banned;
	
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
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
