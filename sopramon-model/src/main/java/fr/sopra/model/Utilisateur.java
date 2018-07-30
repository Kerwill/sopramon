package fr.sopra.model;

public abstract class Utilisateur {
	private String nomUtilisateur;
	private String prenom;
	private String username;
	private String password;
	private int idUtilisateur;
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
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
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int id) {
		this.idUtilisateur = id;
	}
	public Utilisateur(String nomUtilisateur, String prenom, String username, String password) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.idUtilisateur = 0;
	}
	

	
}	
