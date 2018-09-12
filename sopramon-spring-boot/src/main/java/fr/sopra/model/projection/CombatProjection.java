package fr.sopra.model.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.sopra.model.game.Combat;

@Projection(name="combat", types={ Combat.class })
public interface CombatProjection {
	
//il faut recuperer attaquant1.nom et attaquant2.nom
	public SopramonProjection getSopramon1();
	public SopramonProjection getSopramon2();
}