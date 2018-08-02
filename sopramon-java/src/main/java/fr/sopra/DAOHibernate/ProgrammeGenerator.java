package fr.sopra.DAOHibernate;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import fr.sopra.DAO.IDAOBoss;
import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Sopramon;
import fr.sopra.model.game.Type;

public class ProgrammeGenerator {

	public static void main(String[] args) {

		addBoss("Jeremy", 10, Signe.LION);
		//

		DAOHibernate.close();
	}

	public static Sopramon addSopramon(@Size(max = 30) @NotEmpty String nomUtil,
			@Size(max = 30) @NotEmpty String prenomUtil, @Size(max = 30) @NotEmpty String username,
			@Size(max = 30) @NotEmpty String password, @NotEmpty Date dateNaissance,
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

		return mySopramon;
	}

	public static void addBoss(String nom, int niveau, Signe signe) {

		IDAOBoss daoBoss = new DAOBossHibernate();
		Boss myBoss = new Boss();

		myBoss.setNom(nom);
		myBoss.setNiveau(niveau);
		myBoss.setSigne(signe);
		myBoss.getCapacite().setAttaque(20);
		myBoss.getCapacite().setDefense(5);
		myBoss.getCapacite().setPointsDeVie(100);
		myBoss.getCapacite().setEsquive(10);
		myBoss.getCapacite().setVitesse(5);

		daoBoss.save(myBoss);
	}
}
