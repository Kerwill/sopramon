package fr.sopra.DAOHibernate;

import fr.sopra.DAO.IDAO;
import fr.sopra.model.game.Sopramon;

public interface IDAOSopramon extends IDAO<Sopramon> {

	public Sopramon findByNom(String nom);


}
