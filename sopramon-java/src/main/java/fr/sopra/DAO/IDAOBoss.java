package fr.sopra.DAO;

import fr.sopra.model.game.Boss;

public interface IDAOBoss extends IDAO<Boss> {
	public Boss findByNom(String nom);

}
