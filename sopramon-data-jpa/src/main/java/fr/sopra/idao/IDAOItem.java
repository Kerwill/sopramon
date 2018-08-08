package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Item;

public interface IDAOItem extends JpaRepository<Item, Integer>{

	void deleteByNom(String nom);

	Item findByNom(String nom);

}
