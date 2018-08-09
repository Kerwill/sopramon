package fr.sopra.model.game;

public enum Type {
	FEU(Arene.AFEU),
	EAU(Arene.AEAU),
	TERRE(Arene.ATERRE),
	AIR(Arene.AAIR),
	UNKNOWN(Arene.AUNKNOWN);
	
	private Arene arene = Arene.AUNKNOWN;
	
	Type( Arene arene) {
		this.arene = arene;
	}
	
	public Arene getArene() {
		return this.arene;
	
	}
}

