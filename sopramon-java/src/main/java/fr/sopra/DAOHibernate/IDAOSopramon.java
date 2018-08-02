package fr.sopra.DAO;

import java.util.List;

import fr.sopra.model.game.Sopramon;

public interface IDAOSopramon extends IDAO<Sopramon> {

	public Sopramon findByNom(String nom);

	List<Sopramon> findAllWithCapacity();
	
	public Sopramon seConnecter(String nom, String password);

}
