import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.Utilisateur;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class IDAOUtilisateurTest {

	@Autowired(required = false)
	private IDAOUtilisateur daoUser;

	@PersistenceContext
	private EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Hi ! DaoUtilisateur en Test !");
	}

	@Test
	public void testConnect
	{
		assertTrue(daoUser.findByUsernameAndPassword("frofro44", "hubert"));
		assertTrue(daoUser.findByUsernameAndPassword("frofro4", "hubert"));
		assertTrue(daoUser.findByUsernameAndPassword("frofro44", ""));
	}

}
