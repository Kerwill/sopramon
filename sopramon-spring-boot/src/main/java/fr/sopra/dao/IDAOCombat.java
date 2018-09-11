package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

@CrossOrigin("*")
public interface IDAOCombat extends JpaRepository<Combat, Integer> {

	List <Combat> findTop10BySopramon1OrSopramon2OrderByIdDesc(Sopramon sopramon, Sopramon sopramon2);
	
}
