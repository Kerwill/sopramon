package fr.sopra.config;

import java.text.ParseException;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.sopra.Boutique;
import fr.sopra.ItemMenu;
import fr.sopra.MenuConnection;
import fr.sopra.PrincipalBattle;
import fr.sopra.model.game.ICombattant;
import fr.sopra.model.game.Sopramon;

public class SpringApplication {

	public static void main(String[] args) throws BeansException, ParseException {

		Sopramon mySopramon = null;
		ICombattant myOpponent = null;
		Scanner keyboard = new Scanner (System.in);

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		try {

			mySopramon = myContext.getBeanFactory().createBean(MenuConnection.class).connexion(keyboard);
			

		} catch (BeansException | ParseException e) {
			e.printStackTrace();
		}

		if (mySopramon == null) {
			System.out.println("Echec !");
			System.exit(0);
		}
		
		int choix;

		System.out.println("---------------------------------MENU---------------------------------------\n"
				+ "1 : Visiter la boutique\n" + "2 : Partir en arène\n"+ "Quel est votre choix ?");
		
		int choix1 = keyboard.nextInt();
		switch (choix1) {
		
		case 1:
		
		myContext.getBeanFactory().createBean(Boutique.class).shopping(mySopramon, keyboard);
		
		break;
		
		case 2:
		
		myContext.getBeanFactory().createBean(PrincipalBattle.class).attaquer(myOpponent, mySopramon, keyboard);
			
	}
		myContext.close();
}
}
