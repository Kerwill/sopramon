package fr.sopra.DAOHibernate;

import fr.sopra.DAO.IDAOBoss;
import fr.sopra.DAO.IDAOCombat;
import fr.sopra.DAO.IDAOCoup;
import fr.sopra.DAO.IDAOItem;
import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Sopramon;

public class PrincipalHibernate {

	public static void main(String[] args) {

		// printSopramons();
		// printBoss();
		// printCoup();
		// printCombat();
//			printItem();
		deleteItem("Truc");
		
//		IDAOSopramon daoSopramon = new DAOSopramonHibernate();		
//		System.out.println(daoSopramon.findByNom("Briac").toString());
		
//		IDAOItem daoItem = new DAOItemHibernate();
//		System.out.println(daoItem.findByNom("Truc").getNom());
	}

	public static void printSopramons() {
		IDAOSopramon daoSopramon = new DAOSopramonHibernate();

		for (Sopramon s : daoSopramon.findAll()) {
			System.out.println(s.getNom());
		}
	}

	public static void printBoss() {
		IDAOBoss daoBoss = new DAOBossHibernate();

		for (Boss b : daoBoss.findAll()) {
			System.out.println(b.getNom());
		}
	}

	public static void printCoup() {
		IDAOCoup daoCoup = new DAOCoupHibernate();

		for (Coup c : daoCoup.findAll()) {
			System.out.println(c.getDegats());
		}
	}

	public static void printCombat() {
		IDAOCombat daoCombat = new DAOCombatHibernate();

		for (Combat c : daoCombat.findAll()) {
			System.out.println(c.getSopramon1());
		}
	}

	public static void printItem() {
		IDAOItem daoItem = new DAOItemHibernate();
		System.out.println("Liste des items de la boutique :");
		for (Item i : daoItem.findAll()) {
			System.out.println("");
			System.out.println("Nom : " + i.getNom());
			System.out.println("Prix : " + i.getPrix());
			System.out.println("-------------------------------");
			System.out.println("Cet item varie les PdV de : " + i.getCapacite().getPointsDeVie());
			System.out.println("l'attaque de : " + i.getCapacite().getAttaque());
			System.out.println("la défense de : " + i.getCapacite().getDefense());
			System.out.println("l'esquive de : " + i.getCapacite().getEsquive());
			System.out.println("la vitesse de : " + i.getCapacite().getVitesse());
		}
	}
	
	public static void deleteItem(String nom) {
		IDAOItem daoItem = new DAOItemHibernate();
		daoItem.deleteByNom(nom);
	}
}
