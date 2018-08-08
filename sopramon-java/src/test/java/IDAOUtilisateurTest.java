import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.config.AppConfig;
import fr.sopra.idao.IDAOUtilisateur;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class IDAOUtilisateurTest {

	@Autowired(required = false)
	private IDAOUtilisateur daoUser;

	@PersistenceContext
	private EntityManager em;

	@BeforeClass
	public static void setUp(){
		System.out.println("Hi ! DaoUtilisateur en Test !");
	}

	@Test
	public void testConnect()
	{
		assertNotNull(daoUser.findByUsernameAndPassword("frofro44", "hubert"));
		assertNull(daoUser.findByUsernameAndPassword("frofro4", "hubert"));
		assertNull(daoUser.findByUsernameAndPassword("frofro44", ""));
	}

}
