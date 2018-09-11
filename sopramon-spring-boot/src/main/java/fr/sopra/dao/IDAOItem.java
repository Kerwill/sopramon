package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.game.Item;
import fr.sopra.model.projection.ItemProjection;

@CrossOrigin("*")
@RepositoryRestResource(excerptProjection=ItemProjection.class)
public interface IDAOItem extends JpaRepository<Item, Integer>{

	void deleteByNom(String nom);

	Item findByNom(String nom);

}
