package fr.sopra;

import fr.sopra.model.game.Arene;
import fr.sopra.model.game.Type;

public class AreneGenerator {

	public static void main(String[] args) {


		Type currentAreneType = Arene.ASAGITTAIRE.getASigne().getType();//Instruction ([sopramon1.getType()] == currentAreneType) pour comparer les elements et attribuer les bonus
		System.out.println(currentAreneType);

	}
}
