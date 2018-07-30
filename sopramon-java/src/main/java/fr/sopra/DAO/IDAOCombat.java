package fr.sopra.DAO;

import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

public interface IDAOCombat extends IDAO<Combat> {

	public Combat saveBoss (Combat combat);
	public Combat saveSopramon (Combat combat);
}
