import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.sopra.config.AppConfig;
import fr.sopra.idao.IDAOCombat;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class IDAOCombatTest {
	@Autowired(required = false)
	private IDAOCombat daocombat;

	Boss boss = new Boss();
	Sopramon sopramon = new Sopramon();

	private Combat combat = new Combat(boss, sopramon);

	@Test
	@Transactional
	@Rollback(true)
	public void testSave2() {
		try {
			daocombat.save(combat);

		} catch (Exception e) {
			fail();

		}

	}
}