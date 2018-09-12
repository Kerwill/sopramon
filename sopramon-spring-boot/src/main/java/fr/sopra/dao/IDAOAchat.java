package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.game.Achat;

@CrossOrigin("*")
public interface IDAOAchat extends JpaRepository<Achat, Integer> {

}
