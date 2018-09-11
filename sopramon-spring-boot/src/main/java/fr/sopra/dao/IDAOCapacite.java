package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.game.Capacite;

@CrossOrigin("*")
public interface IDAOCapacite extends JpaRepository<Capacite, Integer>{

}
