package fr.sopra.DAOHibernate;

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
					@Size(max = 30) @NotEmpty String username, @Size(max = 30) @NotEmpty String password,  @NotEmpty Date dateNaissance, 
					@NotEmpty @Size(max = 30) String nom) {
				
				DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
				Sopramon mySopramon = new Sopramon();
				
				mySopramon.setUsername(username);
				mySopramon.setPrenomUtil(prenomUtil);
				mySopramon.setUsername(username);
				mySopramon.setPassword(password);
				mySopramon.setDateNaissance(dateNaissance);
				mySopramon.setExperience(0);
				mySopramon.setNiveau(1);
				mySopramon.setArgent(100.00d);
				mySopramon.setNom(nom);


		
			}
			
}
