package fr.sopra.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.sopra.PrincipalBattle;

public class SpringApplication {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBeanFactory().createBean(PrincipalBattle.class).run(args);
		myContext.close();
	}
}