package fr.sopra.DAOHibernate;

import java.util.List;

import fr.sopra.DAO.IDAOAchat;
import fr.sopra.model.game.Achat;

public class DAOAchatHibernate extends DAOHibernate implements IDAOAchat {

	@Override
	public List<Achat> findAll() {
		return em.createQuery("select a from Achat a", Achat.class).getResultList();
	}

	@Override
	public Achat findById(int id) {
		return em.find(Achat.class, id);
	}

	@Override
	public Achat save(Achat entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Achat entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Achat myAchat = new Achat();
		myAchat.setId(id);
		delete(myAchat);
	}
}
