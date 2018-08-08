import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import fr.sopra.idao.IDAOSopramon;
import fr.sopra.model.game.Sopramon;

public class IDAOSopramonTest {

	@Autowired(required = false)
	private IDAOSopramon daosopramon;

	private Sopramon mySopramon = new Sopramon();

	@PersistenceContext
	EntityManager em;

	@BeforeClass
	public static void init2() {
		System.out.println("Début du texte");
	}

	@Test
	public void test() {
		assertNotNull(daosopramon);
		assertNotNull(mySopramon);
	}

	@Test
		public void testFind() {
			assertNotNull(daosopramon.findAll());
			assertNotNull(daosopramon.findById(2).get());
			assertTrue(daosopramon.findById(2).isPresent());
			assertNull(daosopramon.findByNom("ggfg"));
		}

	@Test
		@Transactional
		@Rollback(true)

		public void testSave() {
			try {
				daosopramon.save(mySopramon);
		
			} catch (Exception e) {
				fail();
}
	}
}