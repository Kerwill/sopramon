package fr.sopra.model.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.game.Capacite;

@Projection(name="capacite", types={ Capacite.class })
public interface CapaciteProjection {
	public int getPointsDeVie();
	public int getAttaque();
	public int getDefense();
	public int getVitesse();
	public int getEsquive();
}