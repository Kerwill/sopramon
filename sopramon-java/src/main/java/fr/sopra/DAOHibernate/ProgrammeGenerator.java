package fr.sopra.DAOHibernate;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Sopramon;
import fr.sopra.model.game.Type;

public class ProgrammeGenerator {
			
			public static void main(String[] args) {
				
				
//		
				
				DAOHibernate.close();
			}
			
			
			
			public static void addSopramon( @Size(max = 30) @NotEmpty String nomUtil, @Size(max = 30) @NotEmpty String prenomUtil,
					@Size(max = 30) @NotEmpty String username, @Size(max = 30) @NotEmpty String password,  @NotEmpty Date dateNaissance, @PositiveOrZero @NotEmpty int experience,
					@Positive @NotEmpty int niveau, @NotEmpty @PositiveOrZero double argent,
					@NotEmpty @Size(max = 30) String nom, Capacite capacite, @NotEmpty Signe signe, @NotEmpty Type type) {
				
				DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
				Sopramon mySopramon = new Sopramon();
				
				mySopramon.setUsername(username);
				mySopramon.setPrenomUtil(prenomUtil);
				mySopramon.setUsername(username);
				mySopramon.setPassword(password);
				mySopramon.setDateNaissance(dateNaissance);
				mySopramon.setExperience(experience);
				mySopramon.setNiveau(niveau);
				mySopramon.setArgent(argent);
				mySopramon.setNom(nom);
				mySopramon.setCapacite(capacite);
				mySopramon.setSigne(signe);
				mySopramon.setType(type);
		
			}
			
<<<<<<< Updated upstream
=======
			
			
			public static void addFournisseur(String nom, String prenom, String societe) {
				IDAOFournisseur daoFournisseur = new DAOFournisseurHibernate();
				Fournisseur myFournisseur = new Fournisseur();
				
				myFournisseur.setNom(nom);
				myFournisseur.setPrenom(prenom);
				myFournisseur.setSociete(societe);
				
				daoFournisseur.save(myFournisseur);
			}
			
			
			
			public static void addProduit(String nom, float prix, int gammeId) {
				IDAOProduit daoProduit = new DAOProduitHibernate();
				Produit myProduit = new Produit();
				Gamme myGamme = new Gamme();
				
				myGamme.setId(gammeId);
				
				myProduit.setNom(nom);
				myProduit.setPrix(prix);
				myProduit.setGamme(myGamme);
				
				daoProduit.save(myProduit);
			}
			
			
			
			public static void addAchat(int clientId, int produitId) {
				IDAOClient daoClient = new DAOClientHibernate();
				IDAOProduit daoProduit = new DAOProduitHibernate();
				IDAOAchat daoAchat = new DAOAchatHibernate();

				Client myClient = daoClient.findById(clientId);
				Produit myProduit = daoProduit.findById(produitId);
				Achat myAchat = new Achat();
				
				myAchat.setDate(new Date());
				myAchat.setClient(myClient);
				myAchat.setProduit(myProduit);
				myAchat.setQuantite(1);
				myAchat.setPrix(myProduit.getPrix());
				
				daoAchat.save(myAchat);
			}
		}

}

=======
public class ProgrammeGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

>>>>>>> parent of e4f2293... addBoss
>>>>>>> Stashed changes
}
