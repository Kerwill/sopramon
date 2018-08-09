package fr.sopra.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

public interface IDAOCombat extends JpaRepository<Combat, Integer> {

	List <Combat> findTop10BySopramon1OrSopramon2OrderByIdDesc(Sopramon sopramon, Sopramon sopramon2);
	
}
