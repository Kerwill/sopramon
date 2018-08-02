package fr.sopra.DAOHibernate;

import fr.sopra.DAO.IDAOBoss;
import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Sopramon;

public class PrincipalHibernate {

	public static void main(String[] args) {
		
		printSopramons();
//		printBoss();
	}
	public static void printSopramons() {
		IDAOSopramon daoSopramon = new DAOSopramonHibernate();
		
		for (Sopramon s : daoSopramon.findAll()) {
			System.out.println(s.getNom());
		}
	}
	
	public static void printBoss() {
		IDAOBoss daoBoss  = new DAOBossHibernate();
		
		for (Boss  b : daoBoss .findAll()) {
			System.out.println(b.getNom());
		}
	}
}
