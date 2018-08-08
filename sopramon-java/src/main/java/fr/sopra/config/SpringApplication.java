package fr.sopra.config;

import java.text.ParseException;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.sopra.Boutique;
import fr.sopra.ItemMenu;
import fr.sopra.MenuConnection;
import fr.sopra.PrincipalBattle;
import fr.sopra.model.game.Sopramon;

public class SpringApplication {

	public static void main(String[] args) throws BeansException, ParseException {

		Sopramon mySopramon = null;
		Scanner keyboard = new Scanner (System.in);

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		try {

			mySopramon = myContext.getBeanFactory().createBean(MenuConnection.class).connexion(keyboard);
			myContext.getBeanFactory().createBean(Boutique.class).shopping(mySopramon, keyboard);

		} catch (BeansException | ParseException e) {
			e.printStackTrace();
		}

		if (mySopramon == null) {
			System.out.println("Echec !");
			System.exit(0);
		}
		
		myContext.close();
		
		
	}
}
