package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Achat;

public interface IDAOAchat extends JpaRepository<Achat, Integer> {

}
