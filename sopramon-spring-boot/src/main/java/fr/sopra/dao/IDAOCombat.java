package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;
import fr.sopra.model.projection.CombatProjection;

@CrossOrigin("*")
@RepositoryRestResource(excerptProjection=CombatProjection.class) 
public interface IDAOCombat extends JpaRepository<Combat, Integer> {

	List <Combat> findTop10BySopramon1OrSopramon2OrderByIdDesc(Sopramon sopramon, Sopramon sopramon2);
	
	@RestResource(path="by-sopramon-nom")
	List <Combat> findAllBySopramon1NomOrSopramon2NomOrderByIdDesc(String sopramon, String sopramon2);
	
}
