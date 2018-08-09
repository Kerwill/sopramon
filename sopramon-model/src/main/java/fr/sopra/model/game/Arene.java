package fr.sopra.model.game;

import java.util.Random;

public enum Arene {
	
	ABELIER(Signe.BELIER), ATAUREAU(Signe.TAUREAU), AGEMEAUX(Signe.GEMEAUX), ACANCER(Signe.CANCER), ALION(Signe.LION), AVIERGE(Signe. VIERGE),
	 ABALANCE(Signe.BALANCE), ASCORPION(Signe.SCORPION), ASAGITTAIRE(Signe.SAGITTAIRE), ACAPRICORNE(Signe.CAPRICORNE), AVERSEAU(Signe.VERSEAU),
	 APOISSON(Signe.POISSON), AUNKNOWN(Signe.UNKNOWN);
	
	
	private Signe signe = Signe.UNKNOWN;
	
	
	private Arene(Signe signe) {
		this.signe = signe;
	}

	public Signe getSigne() {
		return this.signe;
	}


	 public static Arene getRandomArene() {
	        Random random = new Random();
	        return (values()[random.nextInt(values().length)]);
	    }
	
}
	
