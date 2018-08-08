package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

public interface IDAOCombat extends JpaRepository<Combat, Integer> {
	
	public Combat saveBoss (Combat combat);
	public Combat saveSopramon (Combat combat);
}
