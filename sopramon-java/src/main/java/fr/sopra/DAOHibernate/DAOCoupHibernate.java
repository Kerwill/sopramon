package fr.sopra.DAOHibernate;

import java.util.List;

import fr.sopra.idao.IDAOCoup;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Sopramon;

public class DAOCoupHibernate extends DAOHibernate implements IDAOCoup {

	@Override
	public List<Coup> findAll() {

		return em.createQuery("select c from Coup c", Coup.class).getResultList();
	}

	@Override
	public Coup findById(int id) {
		return em.find(Coup.class, id);
	}

	@Override
	public Coup save(Coup entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void delete(Coup entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Coup myCoup = new Coup();
		myCoup.setId(id);
		delete(myCoup);
	}

	@Override
	public Coup save2(Coup entity, Sopramon sop, Boss boss, Combat combat) {

		return null;
	}

	@Override
	public Coup save3(Coup entity, Sopramon sop1, Sopramon sop2, Combat combat) {

		return null;
	}

}
