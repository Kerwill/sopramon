package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.sopra.model.game.Sopramon;
import fr.sopra.model.projection.SopramonProjection;

@RepositoryRestResource(excerptProjection=SopramonProjection.class) 
public interface IDAOSopramon extends JpaRepository<Sopramon, Integer> {

	public Sopramon findByNom(String nom);

}