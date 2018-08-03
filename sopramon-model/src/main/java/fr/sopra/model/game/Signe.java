package fr.sopra.model.game;

public enum Signe {

	BELIER(Type.FEU), TAUREAU(Type.TERRE), GEMEAUX(Type.AIR), CANCER(Type.EAU), LION(Type.FEU), VIERGE(Type.TERRE),
	BALANCE(Type.AIR), SCORPION(Type.EAU), SAGITTAIRE(Type.FEU), CAPRICORNE(Type.TERRE), VERSEAU(Type.AIR),
	POISSON(Type.EAU), UNKNOWN(Type.UNKNOWN);

	private Type type = Type.UNKNOWN;

	// Constructeur

	Signe(Type type) {
		this.type = type;
	}

	public Type getType() {
		return this.type;
		
	}

}