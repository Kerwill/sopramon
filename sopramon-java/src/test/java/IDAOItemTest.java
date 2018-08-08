import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.config.AppConfig;
import fr.sopra.idao.IDAOItem;
import fr.sopra.model.game.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class IDAOItemTest {
	@Autowired(required = false)
	private IDAOItem daoitem;


	private Item item = new Item();


	@Test
	@Transactional
	@Rollback(true)
	public void testSave2() {
		try {
			item.setNom("TRUC");
			item.setPrix(55f);
			daoitem.save(item);

		} catch (Exception e) {
			fail();

		}

	}
	
	@Test
	public void testFind() {
		assertNotNull(daoitem.findAll());
		
		}
}