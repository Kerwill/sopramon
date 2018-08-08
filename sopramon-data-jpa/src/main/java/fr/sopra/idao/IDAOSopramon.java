package fr.sopra.idao;

import fr.sopra.model.game.Sopramon;

public interface IDAOSopramon extends IDAO<Sopramon> {

	public Sopramon findByNom(String nom);


}
