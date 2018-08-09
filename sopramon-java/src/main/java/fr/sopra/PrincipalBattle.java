package fr.sopra;

import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.DAOHibernate.DAOCombatHibernate;
import fr.sopra.DAOHibernate.DAOCoupHibernate;
import fr.sopra.idao.IDAOBoss;
import fr.sopra.idao.IDAOCapacite;
import fr.sopra.idao.IDAOCombat;
import fr.sopra.idao.IDAOCoup;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Arene;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.ICombattant;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Sopramon;

@Component
public class PrincipalBattle {
	@Autowired
	private IDAOCombat daoCombat;
	@Autowired
	private IDAOCoup daoCoup;
	@Autowired
	private IDAOSopramon daoSopramon;

	@Transactional
	public void attaquer(Arene myArene, ICombattant myOpponent, ICombattant mySopramon, Scanner keyboard) {

		Combat myCombat = new Combat(myOpponent, mySopramon);


		daoCombat.save(myCombat);
		int compteur = 0;
		boolean qui = (Math.random() < 0.5);
		System.out.println(qui);

		Capacite cap1 = myOpponent.getCapacite();
		Capacite cap2 = mySopramon.getCapacite();

		int pv1 = cap1.getPointsDeVie();
		int def1 = cap1.getDefense();
		int attaque1 = cap1.getAttaque();

		int pv2 = cap2.getPointsDeVie();
		int def2 = cap2.getDefense();
		int attaque2 = cap2.getAttaque();

		System.out.println("Le duel commence : " + mySopramon.getNom() + " vs " + myOpponent.getNom() + " !");

		do {

			compteur++;
			Coup coup = new Coup();
			int degat = 0;

			coup.setDate(new Date());
			coup.setCombat(myCombat);
			coup.setPersistance(0);
			String C = "C";
			String F = "F";

			if (qui == true) {

				System.out.println("C'est votre tour " + myOpponent.getNom()
						+ ", voulez-vous porter un coup (C) ou fuir le combat (F) ?");

				String choix = keyboard.next();

				if (choix.equals(C)) {
					coup.setAttaquant(myOpponent);
					if (attaque1 > def2) {
						degat = attaque1 - def2;

					} else {
						degat = 1;
					}
					pv2 -= degat;
					
					System.out.println("La puissance de votre coup a été de " + degat + ".");
					System.out.println("Vous avez " + pv2 + " PV.");

				} else if (choix.equals(F)) {
					System.out
							.println("Lâche, pleutre, froussard, pied plat, veule, vous avez osé quitter le combat !");
					System.exit(0);
				}
				else
					System.out.println("raté attaquant 1");
				
				qui = false;
			}

			else {

				System.out.println("C'est votre tour " + mySopramon.getNom()
						+ ", voulez-vous porter un coup (C) ou fuir le combat (F) ?");

				String choix = keyboard.next().toUpperCase();
				
				

				if (choix.equals(C)) {
					coup.setAttaquant(mySopramon);
					if (attaque2 > def1) {
						degat = attaque2 - def1;

					} else {
						degat = 1;
					}
					pv1 -= degat;
				
					System.out.println("La puissance de votre coup a été de " + degat + ".");
					System.out.println("Vous avez " + pv1 + " PV.");
				} else if (choix.equals(F)) {
					System.out
							.println("Lâche, pleutre, froussard, pied plat, veule, vous avez osé quitter le combat !");
					System.exit(0);
					
				}
				else
					System.out.println("raté attaquant2");
				
				
				qui = true;
			}

			coup.setDegats(degat);
			daoCoup.save(coup);

		} while (pv1 > 0 && pv2 > 0);

		System.out.println(cap1.toString());
		System.out.println(cap2.toString());
		myCombat.getAttaquant1().setCapacite(cap1);
		myCombat.getAttaquant2().setCapacite(cap2);
		myCombat.setTour(compteur);

		daoCombat.save(myCombat);
	}

	@Transactional

	public Sopramon chooseOpponent(Scanner keyboard) {

		System.out.println("Qui souhaitez-vous provoquer en duel ?");

		String myOpponentNom = keyboard.next();

		Sopramon myOpponent = daoSopramon.findByNom(myOpponentNom);

		return myOpponent;

	}
	
	public Arene chooseArene(ICombattant myOpponent ) {
		if (myOpponent instanceof Boss) {
			Signe signeBoss = ((Boss) myOpponent).getSigne();
			return ((Boss) myOpponent).getSigne().getType().getArene();
		}
		else
		return null;
	}

}
