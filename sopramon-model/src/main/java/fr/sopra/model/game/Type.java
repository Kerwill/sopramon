package fr.sopra.model.game;

public enum Type {
	feu (1),
	eau (2),
	terre (3),
	air (4);
			
	private int valeur = 0;
	Type (int valeur) {
	this.valeur = valeur;
	}
	public int getValeur() {
	return this.valeur;
	}
}