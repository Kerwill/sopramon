package fr.sopra.model.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.game.Sopramon;

@Projection(name="sopramon", types={ Sopramon.class })
public interface SopramonProjection {
	public String getNom();

}