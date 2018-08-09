package fr.sopra.model.game;

import java.util.Random;

public enum Arene {
	
	ABELIER(Signe.BELIER), ATAUREAU(Signe.TAUREAU), AGEMEAUX(Signe.GEMEAUX), ACANCER(Signe.CANCER), ALION(Signe.LION), AVIERGE(Signe. VIERGE),
	ABALANCE(Signe.BALANCE), ASCORPION(Signe. SCORPION), ASAGITTAIRE(Signe.SAGITTAIRE), ACAPRICORNE(Signe.CAPRICORNE), AVERSEAU(Signe.VERSEAU),
	APOISSON(Signe.POISSON), AUNKNOWN(Signe.UNKNOWN);

	private Signe ASigne = Signe.UNKNOWN;
	private Arene (Signe ASigne) {
		this.ASigne = ASigne;
	}
	
	public Signe getASigne() {
		return ASigne;
	}
	
	 public static Arene getRandomAreneType() {
	        Random random = new Random();
	        return (values()[random.nextInt(values().length)]);
	    }
	
}
	
