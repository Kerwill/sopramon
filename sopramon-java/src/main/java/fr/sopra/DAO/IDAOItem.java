package fr.sopra.DAO;

import fr.sopra.model.game.Item;

public interface IDAOItem extends IDAO<Item>{

	void deleteByNom(String nom);

	Item findByNom(String nom);

}
