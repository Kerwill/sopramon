package fr.sopra.config;

import java.text.ParseException;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.sopra.AreneGenerator;
import fr.sopra.Boutique;
import fr.sopra.ItemMenu;
import fr.sopra.MenuConnection;
import fr.sopra.MenuSopramon;
import fr.sopra.PrincipalBattle;
import fr.sopra.model.game.Arene;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.ICombattant;
import fr.sopra.model.game.Sopramon;

public class SpringApplication {

	public static void main(String[] args) throws BeansException, ParseException {

		Sopramon mySopramon = null;
		Sopramon myOpponent = null;

		Scanner keyboard = new Scanner(System.in);

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		try {

			mySopramon = myContext.getBeanFactory().createBean(MenuConnection.class).connexion(keyboard);
			myContext.getBeanFactory().createBean(MenuSopramon.class).listeCoupsEtCombat(mySopramon);
		} catch (BeansException | ParseException e) {
			e.printStackTrace();
		}

		if (mySopramon == null) {
			System.out.println("Echec !");
			System.exit(0);
		}

		int choix;

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "1 : Visiter la boutique\n" + "2 : Partir en arène contre un autre Sopramon\n"
				+ "3 : Partir en donjon contre le Boss\n" + "Quel est votre choix ?");

		int choix1 = keyboard.nextInt();
		switch (choix1) {

		case 1:

			myContext.getBeanFactory().createBean(Boutique.class).shopping(mySopramon, keyboard);

			break;

		case 2:
			Arene myArene = Arene.AUNKNOWN;
			myOpponent = myContext.getBeanFactory().createBean(PrincipalBattle.class).chooseOpponent(keyboard);
			myContext.getBeanFactory().createBean(PrincipalBattle.class).attaquer(myArene, myOpponent, mySopramon, keyboard);
			break;

		case 3:
			Boss myOpponentBoss = new Boss();
			Arene myAreneBoss = myContext.getBeanFactory().createBean(PrincipalBattle.class)
					.chooseArene(myOpponentBoss);
			myContext.getBeanFactory().createBean(PrincipalBattle.class).attaquer(myAreneBoss, myOpponentBoss, mySopramon, keyboard);
			break;

		}
		myContext.close();
	}
}
