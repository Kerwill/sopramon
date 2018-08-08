package fr.sopra;

import java.util.Date;
import java.util.Optional;

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
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.ICombattant;
import fr.sopra.model.game.Sopramon;

@Component
public class PrincipalBattle {
	@Autowired
	private IDAOCombat daoCombat;
	@Autowired
	private IDAOCoup daoCoup;
	@Autowired
	private IDAOCapacite daoCapacite;
	@Autowired
	private IDAOBoss daoBoss;
	@Autowired
	private IDAOSopramon daoSopramon;

	@Transactional
	public void attaquer(String[] args) {

		ICombattant attaquant2 = daoSopramon.findByNom("Briac");
		ICombattant attaquant1 = daoSopramon.findById(3).get();

		Combat myCombat = new Combat(attaquant1, attaquant2);

		daoCombat.save(myCombat);
		int compteur = 0;
		boolean qui = (Math.random() < 0.5);
		System.out.println(qui);

		Capacite cap1 = attaquant1.getCapacite();
		Capacite cap2 = attaquant2.getCapacite();

		int pv1 = cap1.getPointsDeVie();
		int def1 = cap1.getDefense();
		int attaque1 = cap1.getAttaque();

		int pv2 = cap2.getPointsDeVie();
		int def2 = cap2.getDefense();
		int attaque2 = cap2.getAttaque();

		System.out.println(pv1 + ": " + def1 + " : " + def2 + " ");

		do {
			compteur++;
			Coup coup = new Coup();
			int degat;

			coup.setDate(new Date());
			coup.setCombat(myCombat);
			coup.setPersistance(0);

			if (qui == true) {
				coup.setAttaquant(attaquant1);
				if (attaque1 > def2) {
					degat = attaque1 - def2;

				} else {
					degat = 1;
				}
				pv2 -= degat;
				qui = false;
			}

			else {
				coup.setAttaquant(attaquant2);
				if (attaque2 > def1) {
					degat = attaque2 - def1;

				} else {
					degat = 1;
				}
				pv1 -= degat;
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

}
