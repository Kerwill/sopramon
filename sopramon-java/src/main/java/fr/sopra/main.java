package fr.sopra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import fr.sopra.DAO.DAOBossSQL;
import fr.sopra.DAO.DAOCombatSQL;
import fr.sopra.DAO.DAOCoupSQL;
import fr.sopra.DAO.DAOSQL;
import fr.sopra.DAO.DAOSopramonSQL;
import fr.sopra.DAO.IDAOBoss;
import fr.sopra.DAO.IDAOCombat;
import fr.sopra.DAO.IDAOCoup;
import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.DAOHibernate.ProgrammeGenerator;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

public class main {

	public static void main(String[] args) throws ParseException {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "1 : CrÃ©er un compte\n" + "2 : Se connecter\n" + "3 : Obtenir la liste de tous les Sopramon \n"
				+ "4 : DÃ©marrer un duel avec un Boss\n\n" + "Quel est votre choix ?\n");
		int choix = 4;

		DAOSopramonSQL daoSopra = new DAOSopramonSQL();

		
		

		int jourNaissance;
		int moisNaissance;
		int anneeNaissance;
do {
		choix = keyboard.nextInt();
		
		String nomUtil;
		String prenomUtil;
		String nom;
		String motDePasse;
		String username;
		String nomSopra;
		
		switch (choix) {
		

		case 3:
			List<Sopramon> list = daoSopra.findAllWithCapacity();
			for (Sopramon p : list)
				System.out.println(p.toString());

			break;

		case 2:
			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();

			Sopramon mySopramon = daoSopra.seConnecter(username, motDePasse);
			System.out.println("Connection avec votre Sopramon :");
			System.out.println(mySopramon.toString());

			break;

		case 1:

			System.out.println("-----Création du compte----");
			System.out.println("Saisir votre prénom");
			prenomUtil = keyboard.next();

			System.out.println("Saisir votre nom :");
			nomUtil = keyboard.next();

			System.out.println("Saisir votre mot de passe :");
			motDePasse = keyboard.next();

			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			
			System.out.println("Entrez le nom de votre Sopramon");
			nomSopra = keyboard.next();

			 System.out.println("Veuillez saisir votre mois de naissance");
			 moisNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre annee de naissance");
			 anneeNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre jour de naissance");
			 jourNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre mois de naissance");
			 moisNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre annee de naissance");
			 anneeNaissance = keyboard.nextInt();

			 ProgrammeGenerator.addSopramon(nomUtil, prenomUtil, username, motDePasse, new Date(anneeNaissance,moisNaissance,jourNaissance), nomSopra);

			break;

		case 4:

			System.out.println("Entrer le nom du Sopramon.");
			String sop1 = keyboard.next();
			
			Sopramon sopra = daoSopra.findByNom(sop1);
			sopra=daoSopra.findById(sopra.getId());
			DAOBossSQL daoBoss = new DAOBossSQL();
			DAOCombatSQL daoCombat = new DAOCombatSQL();
			Boss nouveauBoss = daoBoss.findById(1);
			System.out.println(sopra.toString());
			System.out.println(nouveauBoss.toString());

			if (sopra != null) {
				Combat nouveauCombat = new Combat(sopra, nouveauBoss);
				
			
				daoCombat.saveBoss(nouveauCombat);
				
				System.out.println(nouveauCombat.toString());
				
//				sopra.attaquerBoss(sopra, nouveauBoss, nouveauCombat);

//
//			} else {
//				System.out.println("Le Sopramon n'exsite pas.");
			}
			break;

		default:

			System.out.println("Veuillez saisir une commande valide SVP.");
			break;
		}
} 
while (choix != 0 || choix != 1 || choix != 2 || choix != 3);
	
	}
}
