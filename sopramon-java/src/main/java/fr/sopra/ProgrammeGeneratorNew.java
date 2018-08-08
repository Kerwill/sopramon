package fr.sopra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import fr.sopra.idao.IDAOBoss;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Sopramon;

public class ProgrammeGeneratorNew {
	@Autowired
	private static IDAOSopramon daoSopramon;
	@Autowired
	private static IDAOBoss daoBoss;
	
	public static void main(String[] args) throws ParseException {

	}

	public static Sopramon addSopramon() throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		Sopramon mySopramon = new Sopramon();

		System.out.println("-----Creation du compte----");
		System.out.println("Saisir votre prenom");
		String prenomUtil = keyboard.next();

		System.out.println("Saisir votre nom :");
		String nomUtil = keyboard.next();

		System.out.println("Saisir votre mot de passe :");
		String motDePasse = keyboard.next();

		System.out.println("Entrez votre nom d'utilisateur");
		String username = keyboard.next();

		System.out.println("Entrez le nom de votre Sopramon");
		String nomSopra = keyboard.next();

		System.out.println("Veuillez saisir votre jour de naissance");
		int jourNaissance = keyboard.nextInt();
		System.out.println("Veuillez saisir votre mois de naissance");
		int moisNaissance = keyboard.nextInt();
		System.out.println("Veuillez saisir votre annee de naissance");
		int anneeNaissance = keyboard.nextInt();

		System.out.println(jourNaissance + " " + moisNaissance + " " + anneeNaissance);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		mySopramon.setNomUtil(nomUtil);
		mySopramon.setPrenomUtil(prenomUtil);
		mySopramon.setUsername(username);
		mySopramon.setPassword(motDePasse);
		mySopramon.setDateNaissance(formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance));
		mySopramon.setExperience(0);
		mySopramon.setNiveau(1);
		mySopramon.setArgent(100.00d);
		mySopramon.setNom(nomSopra);
		mySopramon.setSigne(SigneGeneratorNew
				.getAstrologicalSign(formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance)));
		daoSopramon.save(mySopramon);
		keyboard.close();
		return mySopramon;
	}

	public static void addBoss() throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("-----Creation d'un boss----");
		System.out.println("Entrez le nom du boss : ");
		String nomBoss = keyboard.next();
		System.out.println("Entrez le niveau du boss : ");
		int niveauBoss = keyboard.nextInt();
		System.out.println("Entrez l'attaque du boss : ");
		int attaqueBoss = keyboard.nextInt();
		System.out.println("Entrez la defense du boss : ");
		int defenseBoss = keyboard.nextInt();
		System.out.println("Entrez les points de vie du boss : ");
		int pdvBoss = keyboard.nextInt();
		System.out.println("Entrez l'esquive du boss : ");
		int esquiveBoss = keyboard.nextInt();
		System.out.println("Entrez la vitesse du boss : ");
		int vitesseBoss = keyboard.nextInt();

		System.out.println("Veuillez saisir le jour de naissance");
		int jourNaissance = keyboard.nextInt();
		System.out.println("Veuillez saisir le mois de naissance");
		int moisNaissance = keyboard.nextInt();
		System.out.println("Veuillez saisir l'annee de naissance");
		int anneeNaissance = keyboard.nextInt();

		System.out.println(jourNaissance + " " + moisNaissance + " " + anneeNaissance);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		keyboard.close();

		Boss myBoss = new Boss();

		myBoss.setNom(nomBoss);
		myBoss.setNiveau(niveauBoss);
		myBoss.setSigne(SigneGeneratorNew.getAstrologicalSign(formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance)));
		myBoss.getCapacite().setAttaque(attaqueBoss);
		myBoss.getCapacite().setDefense(defenseBoss);
		myBoss.getCapacite().setPointsDeVie(pdvBoss);
		myBoss.getCapacite().setEsquive(esquiveBoss);
		myBoss.getCapacite().setVitesse(vitesseBoss);

		daoBoss.save(myBoss);
	}

}
