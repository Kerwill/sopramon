package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sopra.model.game.Achat;
import fr.sopra.model.game.Boss;

public interface IDAOBoss extends JpaRepository<Boss, Integer> {
	public Boss findByNom(String nom);

}
