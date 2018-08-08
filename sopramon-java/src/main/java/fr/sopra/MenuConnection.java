package fr.sopra;

import java.text.ParseException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Sopramon;

public class MenuConnection {
	@Autowired
	private static IDAOSopramon daoSopramon;

	@Transactional
	public void runMenuConnecter(String[] args) throws ParseException {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("---------------------------MENU DE CONNECTION ---------------------------------\n"
				+ "1 : Creer un compte\n" + "2 : Se connecter\n" + "Quel est votre choix ?");

		String username;
		String motDePasse;
		int choix = keyboard.nextInt();

		switch (choix) {

		case 1:
			Sopramon mySopramon = ProgrammeGeneratorNew.addSopramon(); // modifier : pointer la methode CRUD sopramon !
			System.out.println(mySopramon.toString());
			break;

		case 2:
			System.out.println("Entrez votre nom d'utilisateur");
			username = keyboard.next();
			System.out.println("Entrez votre mot de passe");
			motDePasse = keyboard.next();
			Sopramon mySopramon1 = daoSopramon.findByUsernameQuery(username, motDePasse); //

			if (mySopramon1 != null) {
				System.out.println("Connection avec votre Sopramon :");
				System.out.println(mySopramon1.toString());
			} else
				System.out.println("Echec de connection - veuillez saisir un mot de passe valide");

			break;
		}
		keyboard.close();
	}

}
