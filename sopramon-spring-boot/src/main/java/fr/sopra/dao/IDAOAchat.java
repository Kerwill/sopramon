package fr.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Achat;

public interface IDAOAchat extends JpaRepository<Achat, Integer> {

}
