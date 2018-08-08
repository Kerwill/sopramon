package fr.sopra;

import java.text.ParseException;

import java.util.List;
import java.util.Scanner;
import fr.sopra.DAOHibernate.DAOBossHibernate;
import fr.sopra.DAOHibernate.DAOCombatHibernate;
import fr.sopra.DAOHibernate.DAOItemHibernate;
import fr.sopra.DAOHibernate.DAOSopramonHibernate;
import fr.sopra.DAOHibernate.ProgrammeGenerator;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Sopramon;

public class main {

	public static void main(String[] args) throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		int choix;

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "1 : Creer un compte\n" + "2 : Se connecter\n" + "3 : Obtenir la liste de tous les Sopramon \n"
				+ "4 : Ajouter un item \n" +"5: Lister les items \n"+ "Quel est votre choix ?");

		String username;
		String motDePasse;
		int choix1 = keyboard.nextInt();
		
	
		
		switch (choix1) {
		
		
		case 1:

			Sopramon mySopramon = ProgrammeGenerator.addSopramon();
			System.out.println(mySopramon.toString());
			break;

		case 2:
			DAOSopramonHibernate daoSopramon = new DAOSopramonHibernate();
			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();
			Sopramon mySopramon1 = daoSopramon.seConnecter(username, motDePasse);

			if (mySopramon1 != null) {
				System.out.println("Connection avec votre Sopramon :");
				System.out.println(mySopramon1.toString());
			} else
				System.out.println("Echec de connection - veuillez saisir un mot de passe valide");
			
			break;

		case 3:
			
			DAOSopramonHibernate daoSopramon1 = new DAOSopramonHibernate();
			List<Sopramon> list = daoSopramon1.findAll();
			for (Sopramon s : list)
				System.out.println(s.toString());
			
			break;

		case 4:
			
			ItemMenu.updateItem();
			break;
			
		case 5:
			DAOItemHibernate daoItem = new DAOItemHibernate();
			List<Item> listItem = daoItem.findAll();
			for (Item i : listItem)
				System.out.println(i.toString());
			
			break;
//			System.out.println("Entrer le nom du Sopramon.");
//			String sop1 = keyboard.next();
//
//			Sopramon sopra = daoSopramon.findByNom(sop1);
//			sopra = daoSopramon.findById(sopra.getId());
//			DAOBossHibernate daoBoss = new DAOBossHibernate();
//			DAOCombatHibernate daoCombat = new DAOCombatHibernate();
//			Boss nouveauBoss = daoBoss.findById(1);
//			System.out.println(sopra.toString());
//			System.out.println(nouveauBoss.toString());
//
//			if (sopra != null) {
//				Combat nouveauCombat = new Combat(sopra, nouveauBoss);
//
//				daoCombat.saveBoss(nouveauCombat);
//
//				System.out.println(nouveauCombat.toString());

//				sopra.attaquerBoss(sopra, nouveauBoss, nouveauCombat);

//			} else {
//				System.out.println("Le Sopramon n'exsite pas.");
//			}
//			break;
//
//		default:
//
//			System.out.println("Veuillez saisir une commande valide SVP.");
//			break;
		}
//		DAOSopramonHibernate.close();
//		DAOItemHibernate.close();
//		keyboard.close();
	}

}
