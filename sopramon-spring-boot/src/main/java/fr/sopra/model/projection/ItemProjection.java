package fr.sopra.model.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.game.Item;

@Projection(name="item", types={ Item.class })
public interface ItemProjection {
	public String getNom();
	public Double getPrix();
	public CapaciteProjection getCapacite();
}
