package fr.sopra;

import java.util.Random;

import fr.sopra.model.game.Arene;
import fr.sopra.model.game.Signe;
import fr.sopra.model.game.Type;

public class AreneGenerator {

	public static void main(String[] args) {

//Pas random
//		Type currentAreneType = Arene.ASAGITTAIRE.getASigne().getType();//Instruction ([sopramon1.getType()] == currentAreneType) pour comparer les elements et attribuer les bonus
//		System.out.println(currentAreneType);

//Avec random en 1 ligne
//		Type randomAreneType = Arene.getRandomAreneType().getASigne().getType();
//		System.out.println(randomAreneType);
		
//Avec random, avec var intermediaire
		Signe randomAreneSigne = Arene.getRandomAreneType().getASigne();
		Type randomAreneType = randomAreneSigne.getType();
		System.out.println(randomAreneSigne);
		System.out.println(randomAreneType);
		
	}
	
	
}
