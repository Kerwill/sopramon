package fr.sopra.DAOHibernate;
import java.util.List;

import javax.persistence.Query;

import fr.sopra.DAO.IDAOSopramon;
import fr.sopra.model.game.Sopramon;

public class DAOSopramonHibernate extends DAOHibernate implements IDAOSopramon{

	@Override
	public List<Sopramon> findAll() {
		List<Sopramon> mySopramon = em.createQuery("select s from Sopramon s", Sopramon.class).getResultList();
		return mySopramon;
	}

	@Override
	public Sopramon findById(int id) {
		return em.find(Sopramon.class, id);
	}

	@Override
	public Sopramon save(Sopramon entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit(); 
		return entity;
	}

	@Override
	public void delete(Sopramon entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.remove(entity);
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteById(int id) {
		Sopramon mySopramon = new Sopramon();
		mySopramon.setId(id);
		em.getTransaction().begin();
		em.remove(em.merge(mySopramon));
		em.getTransaction().commit();
		
	}

	@Override
	public Sopramon findByNom(String nom) {
		Query myQuery = em.createQuery("select s from Sopramon s where g.nom = :nom", Sopramon.class);
		myQuery.setParameter("nom", nom);
		return (Sopramon) myQuery.getSingleResult();
	}
}