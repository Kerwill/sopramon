package fr.sopra.DAOHibernate;

import java.util.Date;

import fr.sopra.DAO.DAOSopramonSQL;
import fr.sopra.DAO.IDAOCombat;
import fr.sopra.DAO.IDAOCoup;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.ICombattant;
import fr.sopra.model.game.Sopramon;

public class Battle {

	public static void main(String[] args) {
		
		DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
		DAOBossHibernate daoBoss = new DAOBossHibernate();
		Boss myBoss = daoBoss.findById(1);
		Sopramon mySopramon = daoSopramon.findById(2);

		attaquer(myBoss, mySopramon);

	}

	public static Combat attaquer(ICombattant attaquant1, ICombattant attaquant2) {
			IDAOCombat daoCombat = new DAOCombatHibernate();
			IDAOCoup daoCoup = new DAOCoupHibernate();
			Combat myCombat = new Combat(attaquant1,attaquant2);
			daoCombat.save(myCombat);
			
			int compteur = 0;
			boolean qui = (Math.random() < 0.5);
			System.out.println(qui);
			do {compteur++;
				Coup coup = new Coup();
				System.out.println("point de vie avant attaque :"+attaquant2.getCapacite().getPointsDeVie());
				
				if(qui == true) {
					int degats = attaquant1.getCapacite().getAttaque();
					coup.setDegats(degats);
					coup.setAttaquant(attaquant1);
					coup.setPersistance(0);
					coup.setCombat(myCombat);
					coup.setDate(new Date());
		
				System.out.println("degats : "+degats);
				int pv = attaquant2.getCapacite().getPointsDeVie();
				int def = attaquant2.getCapacite().getDefense();
				attaquant2.getCapacite().setPointsDeVie(pv - degats);
				daoCoup.save(coup);
				System.out.println("point de vie après attaque :"+attaquant2.getCapacite().getPointsDeVie());
				
				qui = false;
				}
				else {
					System.out.println(attaquant1.getCapacite().getPointsDeVie());
					int degats = attaquant2.getCapacite().getAttaque();
					
					coup.setDegats(degats);
					coup.setAttaquant(attaquant2);
					coup.setPersistance(0);
					coup.setCombat(myCombat);
					System.out.println(degats);
					System.out.println(attaquant2.toString());
				
				int pv = attaquant1.getCapacite().getPointsDeVie();
				int def = attaquant1.getCapacite().getDefense();
				attaquant2.getCapacite().setPointsDeVie(pv - degats);
				daoCoup.save(coup);
				System.out.println(attaquant1.getCapacite().getPointsDeVie());
				qui = true;
				
				}
			}
			while (attaquant1.getCapacite().getPointsDeVie() > 0 && attaquant2.getCapacite().getPointsDeVie() > 0);

			
			daoCombat.save(myCombat);
			return myCombat;
		}
}
