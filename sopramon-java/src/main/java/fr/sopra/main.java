package fr.sopra.model.game;

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

public class main {

	public static void main(String[] args) throws ParseException {

//		IDAOSopramon daoSopramon = new DAOSopramonSQL();
		// for (Sopramon p : daoSopramon.findAll()) {
		// System.out.println(p.getNom());
		// }

		// Sopramon p = daoSopramon.findById(5);
		// System.out.println(p.getNom());

		// Sopramon nouveauSopramon = new Sopramon();
		// nouveauSopramon = daoSopramon.findById(2);
		// nouveauSopramon.sauvegarder();

		// daoSopramon.deleteById(1);

		// Sopramon leSopramon = daoSopramon.findById(8);
		// daoSopramon.delete(leSopramon);

		// Sopramon p = daoSopramon.findByNom("Samuel");
		// System.out.println(p.getNom());

//		IDAOCoup daoCoup = new DAOCoupSQL();

		// for (Coup p : daoCoup.findAll()) {
		// System.out.println(p.getId());
		// }

		// Coup p = daoCoup.findById(18);
		// System.out.println(p.getDate());

//		IDAOBoss daoBoss = new DAOBossSQL();
//		IDAOCombat daoCombat = new DAOCombatSQL();
		// Coup nouveauCoup = new Coup();
//		Sopramon nouveauSopramon = new Sopramon();
//		Sopramon nouveauSopramon2 = new Sopramon();
//		Boss nouveauBoss = new Boss();
		// Combat nouveauCombat = new Combat();
//		nouveauSopramon = daoSopramon.findById(7);
		// nouveauBoss = daoBoss.findById(1);
		// nouveauCombat = daoCombat.findById(1);
		//
		// nouveauCoup.setDate(Date.valueOf(LocalDate.now()));
		// nouveauCoup.setDegats(50);
		// nouveauCoup.setPersistance(0);
		//
		//
		// daoCoup.save2(nouveauCoup, nouveauSopramon, nouveauBoss, nouveauCombat);

		// for (Combat p : daoCombat.findAll()) {
		// System.out.println(p.getId());
		// }

		// Combat p = daoCombat.findById(1);
		// System.out.println(p.getId());
		// nouveauSopramon2 = daoSopramon.findById(4);
		// nouveauBoss = daoBoss.findById(1);
		//
		// Combat nouveauCombat = new Combat();
		// nouveauCombat.setTour(5);
		// nouveauCombat.setBoss(nouveauBoss);
		// nouveauCombat.setSopramon1(nouveauSopramon);
		// nouveauCombat.setSopramon2(nouveauSopramon2);
		//
		// daoCombat.save(nouveauCombat);
		//
		// nouveauCombat.setId(12);
		// daoCombat.delete(nouveauCombat);

		Scanner keyboard = new Scanner(System.in);

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "0. Obtenir la liste de tous les Sopramon \n" + "1 : Se connecter\n" + "2 : Créer un compte\n"
				+ "3 : Démarrer un duel avec un Boss\n\n" + "Quel est votre choix ?\n");

		int choix = keyboard.nextInt();
		DAOSopramonSQL daoSopra = new DAOSopramonSQL();

		String prenom;
		String nom;
		String motDePasse;
		String username;

		String jourNaissance;
		String moisNaissance;
		String anneeNaissance;
		String name;

		switch (choix) {
		case 0:
			List<Sopramon> list = daoSopra.findAllWithCapacity();
			for (Sopramon p : list)
				System.out.println(p.toString());

			break;

		case 1:
			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();

			Sopramon mySopramon = daoSopra.seConnecter(username, motDePasse);
			System.out.println("Connection avec votre Sopramon :");
			System.out.println(mySopramon.toString());

			break;

		case 2:

			System.out.println("-----Création du compte----");

			System.out.println("Saisir le nom de votre Sopramon :");
			name = keyboard.next();

			System.out.println("Saisir votre prénom");
			prenom = keyboard.next();

			System.out.println("Saisir votre nom :");
			nom = keyboard.next();

			System.out.println("Saisir votre mot de passe :");
			motDePasse = keyboard.next();

			System.out.println("Saisir votre nom d'utilisateur");
			username = keyboard.next();
//
			System.out.println("Veuillez saisir votre jour de naissance");
			jourNaissance = keyboard.next();
			System.out.println("Veuillez saisir votre mois de naissance");
			moisNaissance = keyboard.next();
			System.out.println("Veuillez saisir votre annee de naissance");
			anneeNaissance = keyboard.next();

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date parsed = format.parse(anneeNaissance + moisNaissance + jourNaissance);
			
			Date dateNaissance = new Date(parsed.getTime());
			

			Signe signe = new Signe(dateNaissance);
			System.out.println(signe.toString());
			Sopramon mySopramon1 = new Sopramon(nom, prenom, username, motDePasse, dateNaissance);
			System.out.println(mySopramon1.toString());

			daoSopra.save(mySopramon1);

			break;

		case 3:

			System.out.println("Entrer le nom du Sopramon.");
			String sop1 = keyboard.next();

			Sopramon sopra = daoSopra.findByNom(sop1);

			DAOBossSQL daoBoss = new DAOBossSQL();
			DAOCombatSQL daoCombat = new DAOCombatSQL();
			Boss nouveauBoss = daoBoss.findById(1);
			System.out.println(sopra.toString());
			System.out.println(nouveauBoss.toString());

			if (sopra != null) {
				Combat nouveauCombat = new Combat(sopra, nouveauBoss);
				System.out.println(nouveauCombat.toString());

				daoCombat.saveBoss(nouveauCombat);

			} else {
				System.out.println("Le Sopramon n'existe pas.");
			}
			break;

//		default:
//
//			System.out.println("Veuillez saisir une commande valide SVP.");

		}
	}
}
