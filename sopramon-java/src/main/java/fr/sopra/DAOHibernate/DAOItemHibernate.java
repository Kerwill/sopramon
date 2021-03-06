package fr.sopra.DAOHibernate;

import java.util.List;

import javax.persistence.Query;

import fr.sopra.idao.IDAOItem;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Item;
import fr.sopra.model.game.Sopramon;

public class DAOItemHibernate extends DAOHibernate implements IDAOItem {

	@Override
	public List<Item> findAll() {
		return em.createQuery("select i from Item i", Item.class).getResultList();
	}

	@Override
	public Item findById(int id) {
		return em.find(Item.class, id);
	}

	@Override
	public Item save(Item entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Item entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Item myItem = new Item();
		myItem.setId(id);
		delete(myItem);
	}
	
	@Override
	public Item findByNom(String nom) {
		Query myQuery = em.createQuery("select i from Item i where i.nom = :nom", Item.class);
		myQuery.setParameter("nom", nom);
		return (Item) myQuery.getSingleResult();
	}
	
	public void deleteByNom(String nom) {
		Item myItem = new Item();
		myItem.setNom(nom);
		myItem = findByNom(nom);
		em.getTransaction().begin();
		em.remove(em.merge(myItem));
		em.getTransaction().commit();
	}

}
