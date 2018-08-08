package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Sopramon;

public interface IDAOSopramon extends JpaRepository<Sopramon, Integer> {

	public Sopramon findByNom(String nom);


}
