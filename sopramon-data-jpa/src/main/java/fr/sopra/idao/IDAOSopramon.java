package fr.sopra.idao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.sopra.model.game.Sopramon;

public interface IDAOSopramon extends JpaRepository<Sopramon, Integer> {

	public Sopramon findByNom(String nom);

	@Query("SELECT *" + 
		   "from utilisateur u" + 
		   "where (u.username = :nomDUtilicateur AND u.password = :motDePasse)")
	public Sopramon findByUsernameQuery(@Param("nomDUtilisateur") String username, @Param("motDePasse") String password);

}