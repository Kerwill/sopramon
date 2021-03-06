package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Sopramon;

public interface IDAOCoup extends JpaRepository<Coup, Integer> {

	List <Coup> findTop10BySopramonOrderByIdDesc(Sopramon sopramon);
	List <Coup> findByCombat(Combat combat);
}
