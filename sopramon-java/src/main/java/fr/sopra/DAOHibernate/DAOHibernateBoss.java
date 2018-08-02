package fr.sopra.DAOHibernate;

import java.util.List;

import javax.persistence.Query;

import fr.sopra.DAO.IDAOBoss;
import fr.sopra.model.game.Boss;

public class DAOHibernateBoss extends DAOHibernate implements IDAOBoss {

	@Override
	public List<Boss> findAll() {
		return em.createQuery("select b from Boss b", Boss.class).getResultList();
	}

	@Override
	public Boss findById(int id) {
		return em.find(Boss.class, id);
	}

	@Override
	public Boss save(Boss entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Boss entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Boss myBoss = new Boss();
		myBoss.setId(id);
		delete(myBoss);
	}

	@Override
	public Boss findByNom(String nom) {
		Query myQuery = em.createQuery("select b from Boss b where b.nom = :nom", Boss.class);
		myQuery.setParameter("nom", nom);
		
		return (Boss) myQuery.getSingleResult();
	}
}
