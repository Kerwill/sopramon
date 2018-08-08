package fr.sopra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.Utilisateur;
import fr.sopra.model.game.Sopramon;

public class MenuConnection {
	@Autowired
	private IDAOSopramon daoSopramon;

	@Autowired
	private IDAOUtilisateur daoUser;

	@Transactional
	public Sopramon connexion(String[] args) throws ParseException {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("---------------------------MENU DE CONNECTION ---------------------------------\n"
				+ "1 : Creer un compte\n" + "2 : Se connecter\n" + "Quel est votre choix ?");

		String username;
		String motDePasse;
		int choix = keyboard.nextInt();

		if (choix == 1) {

			Sopramon mySopramon = new Sopramon();

			System.out.println("-----Creation du compte----");
			System.out.println("Saisir votre prenom");
			String prenomUtil = keyboard.next();

			System.out.println("Saisir votre nom :");
			String nomUtil = keyboard.next();

			System.out.println("Saisir votre mot de passe :");
			String motDePasse1 = keyboard.next();

			System.out.println("Entrez votre nom d'utilisateur");
			String username1 = keyboard.next();

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
			mySopramon.setUsername(username1);
			mySopramon.setPassword(motDePasse1);
			mySopramon.setDateNaissance(formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance));
			mySopramon.setExperience(0);
			mySopramon.setNiveau(1);
			mySopramon.setArgent(100.00d);
			mySopramon.setNom(nomSopra);
			mySopramon.setSigne(SigneGeneratorNew
					.getAstrologicalSign(formatter.parse(jourNaissance + "/" + moisNaissance + "/" + anneeNaissance)));
			keyboard.close();
			return daoSopramon.save(mySopramon);
		}

		else if (choix == 2) {

			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();
			Sopramon user = (Sopramon) daoUser.findByUsernameAndPassword(username, motDePasse);

			if (user != null) {
				System.out.println("Connection avec votre Sopramon :");
				System.out.println(user.toString());
				keyboard.close();
				return user;
			} else {
				System.out.println("Echec de connection - veuillez saisir un mot de passe valide");
				keyboard.close();
				return null;
			}

		}

		else {
			System.out.println("Commande invalide, merci de relancer le programme");
			keyboard.close();
			return null;
		}

	}
}
