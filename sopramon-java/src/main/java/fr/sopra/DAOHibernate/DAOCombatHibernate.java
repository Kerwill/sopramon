package fr.sopra.DAOHibernate;

import java.util.List;

import fr.sopra.DAO.IDAOCombat;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;

public class DAOCombatHibernate  extends DAOHibernate implements IDAOCombat {

	@Override
	public List<Combat> findAll() {
		return em.createQuery("select c from Combat c", Combat.class).getResultList();
	}

	@Override
	public Combat findById(int id) {
		return em.find(Combat.class, id);
	}

	@Override
	public Combat save(Combat entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Combat entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Combat myCombat = new Combat();
		myCombat.setId(id);
		delete(myCombat);
	}

	@Override
	public Combat saveBoss(Combat combat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Combat saveSopramon(Combat combat) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
