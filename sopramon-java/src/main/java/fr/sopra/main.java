package fr.sopra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import fr.sopra.DAO.DAOBossSQL;
import fr.sopra.DAO.DAOCombatSQL;
import fr.sopra.DAO.DAOSopramonSQL;
import fr.sopra.DAOHibernate.DAOSopramonHibernate;
import fr.sopra.DAOHibernate.ProgrammeGenerator;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

public class main {

	public static void main(String[] args) throws ParseException {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "1 : Créer un compte\n" + "2 : Se connecter\n" + "3 : Obtenir la liste de tous les Sopramon \n"
				+ "4 : Démarrer un duel avec un Boss\n\n" + "Quel est votre choix ?\n");



		int choix = keyboard.nextInt();
		String nomUtil;
		String prenomUtil;
		String nom;
		String motDePasse;
		String username;
		String nomSopra;
		int jourNaissance;
		int moisNaissance;
		int anneeNaissance;
		
		DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
		
		
		switch (choix) {
		
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

			 System.out.println("Veuillez saisir votre jour de naissance");
			 jourNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre mois de naissance");
			 moisNaissance = keyboard.nextInt();
			 System.out.println("Veuillez saisir votre annee de naissance");
			 anneeNaissance = keyboard.nextInt();

			 System.out.println(jourNaissance+" "+moisNaissance+" "+anneeNaissance);
			 
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 
			 
			Sopramon nouveauSopra = ProgrammeGenerator.addSopramon(nomUtil, prenomUtil, username, motDePasse, formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance), nomSopra);
	
			System.out.println(nouveauSopra.toString());
			
			
			break;
			
		case 2:
			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();

			Sopramon mySopramon = daoSopramon.seConnecter(username, motDePasse);
			
			if (mySopramon.getId() !=0 ) {
			System.out.println("Connection avec votre Sopramon :");
			System.out.println(mySopramon.toString());
			}
			else
				System.out.println("Echec de connection - veuillez saisir un mot de passe valide");

			break;
			
			
			

//		case 3:
//			List<Sopramon> list = daoSopramon.findAllWithCapacity();
//			for (Sopramon p : list)
//				System.out.println(p.toString());
//
//			break;



		

//		case 4:
//
//			System.out.println("Entrer le nom du Sopramon.");
//			String sop1 = keyboard.next();
//			
//			Sopramon sopra = daoSopra.findByNom(sop1);
//			sopra=daoSopra.findById(sopra.getId());
//			DAOBossSQL daoBoss = new DAOBossSQL();
//			DAOCombatSQL daoCombat = new DAOCombatSQL();
//			Boss nouveauBoss = daoBoss.findById(1);
//			System.out.println(sopra.toString());
//			System.out.println(nouveauBoss.toString());
//
//			if (sopra != null) {
//				Combat nouveauCombat = new Combat(sopra, nouveauBoss);
//				
//			
//				daoCombat.saveBoss(nouveauCombat);
//				
//				System.out.println(nouveauCombat.toString());
				
//				sopra.attaquerBoss(sopra, nouveauBoss, nouveauCombat);

//
//			} else {
//				System.out.println("Le Sopramon n'exsite pas.");
//			}
//			break;
//
//		default:
//
//			System.out.println("Veuillez saisir une commande valide SVP.");
//			break;
//		}

		}

}
}
