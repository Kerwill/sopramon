package fr.sopra.model.game;

public enum Signe {

	BELIER(Type.FEU, Arene.ABELIER), TAUREAU(Type.TERRE, Arene.ATAUREAU), GEMEAUX(Type.AIR, Arene.AGEMEAUX), CANCER(
			Type.EAU, Arene.ACANCER), LION(Type.FEU, Arene.ALION), VIERGE(Type.TERRE, Arene.AVIERGE), BALANCE(Type.AIR,
					Arene.ABALANCE), SCORPION(Type.EAU, Arene.ASCORPION), SAGITTAIRE(Type.FEU,
							Arene.ASAGITTAIRE), CAPRICORNE(Type.TERRE, Arene.ACAPRICORNE), VERSEAU(Type.AIR,
									Arene.AVERSEAU), POISSON(Type.EAU,
											Arene.APOISSON), UNKNOWN(Type.UNKNOWN, Arene.AUNKNOWN);

	private Type type = Type.UNKNOWN;
	private Arene arene = Arene.AUNKNOWN;
	
	Signe(Type type, Arene arene) {
		this.type = type;
		this.arene = arene;
	}

	public Type getType() {
		return this.type;
	}

	public Arene getArene() {
		return this.arene;
		}
}