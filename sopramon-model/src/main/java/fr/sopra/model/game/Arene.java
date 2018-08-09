package fr.sopra.model.game;

import java.util.Random;

public enum Arene {
	
	ABELIER, ATAUREAU, AGEMEAUX, ACANCER, ALION, AVIERGE,
	ABALANCE, ASCORPION, ASAGITTAIRE, ACAPRICORNE, AVERSEAU,
	APOISSON, AFEU, AEAU, ATERRE, AAIR, AUNKNOWN;


	
	 public static Arene getRandomArene() {
	        Random random = new Random();
	        return (values()[random.nextInt(values().length)]);
	    }
	
}
	
