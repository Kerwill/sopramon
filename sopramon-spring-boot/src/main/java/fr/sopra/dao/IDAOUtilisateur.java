package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.Utilisateur;
import fr.sopra.model.game.Sopramon;

public interface IDAOUtilisateur extends JpaRepository<Sopramon, Integer>{

	public Utilisateur findByUsernameAndPassword(String username, String password);

	public Utilisateur findByUsername(String username);

}
