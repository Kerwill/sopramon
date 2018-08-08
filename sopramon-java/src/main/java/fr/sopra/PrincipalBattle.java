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
	private static IDAOCombat daoCombat;
	@Autowired
	private static IDAOCoup daoCoup;
	@Autowired
	private IDAOCapacite daoCapacite;
	@Autowired
	private IDAOBoss daoBoss;
	@Autowired
	private IDAOSopramon daoSopramon;

	@Transactional
	public void attaquer (String[] args) {
	
		ICombattant attaquant1 = daoSopramon.findByNom("Briac");
		ICombattant attaquant2 = daoBoss.findById(1).get();

		Combat myCombat = new Combat(attaquant1, attaquant2);
	
		daoCombat.save(myCombat);
		int compteur = 0;
		boolean qui = (Math.random() < 0.5);
		System.out.println(qui);

		Capacite cap1 = attaquant1.getCapacite();
		Capacite cap2 = attaquant2.getCapacite();

		int pv1 = cap1.getPointsDeVie();
		int def1 = cap1.getDefense();
		int degats1 = cap1.getAttaque();

		int pv2 = cap2.getPointsDeVie();
		int def2 = cap2.getDefense();
		int degats2 = cap2.getAttaque();

		do {
			compteur++;
			Coup coup = new Coup();
			System.out.println("point de vie avant attaque :" + cap2.getPointsDeVie());

			if (qui == true) {

				coup.setDegats(degats1);
				coup.setAttaquant(attaquant1);
				coup.setPersistance(0);
				coup.setCombat(myCombat);
				coup.setDate(new Date());

				System.out.println("degats : " + degats1);

				if (degats1 > def2) {
					pv2 = pv2 - (degats1 - def2);
				} else {
					pv2 = pv2 - 1;
				}
				daoCoup.save(coup);
				System.out.println("point de vie apr�s attaque :" + cap2.getPointsDeVie());

				qui = false;
				
			} else {
				
				System.out.println(cap1.getPointsDeVie());

				coup.setDegats(degats2);
				coup.setAttaquant(attaquant2);
				coup.setPersistance(0);
				coup.setCombat(myCombat);
				coup.setDate(new Date());
				
				System.out.println(degats2);
				System.out.println(attaquant2.toString());

				if (degats2 > def1) {
					pv1 = pv1 - (degats2 - def1);
				} else {
					pv1 = pv1 - 1;
				}
				
				daoCoup.save(coup);
				
				System.out.println(cap1.getPointsDeVie());
				
				qui = true;

			}
			
		} while (cap1.getPointsDeVie() >= 0 && cap2.getPointsDeVie() >= 0);

		myCombat.getAttaquant1().setCapacite(cap1);
		myCombat.getAttaquant2().setCapacite(cap2);
		myCombat.setTour(compteur);
		
		
		daoCombat.save(myCombat);
	}

}
