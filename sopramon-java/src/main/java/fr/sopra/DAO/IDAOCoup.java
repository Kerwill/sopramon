package fr.sopra.DAO;

import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Sopramon;

public interface IDAOCoup extends IDAO<Coup> {
	
	public Coup save2(Coup entity, Sopramon sop, Boss boss, Combat combat);
	public Coup save3(Coup entity, Sopramon sop1, Sopramon sop2, Combat combat);
}
