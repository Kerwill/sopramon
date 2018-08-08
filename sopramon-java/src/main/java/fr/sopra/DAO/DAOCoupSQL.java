package fr.sopra.DAO;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.sopra.idao.IDAOCoup;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Coup;
import fr.sopra.model.game.Sopramon;

public class DAOCoupSQL extends DAOSQL implements IDAOCoup {

	@Override
	public List<Coup> findAll() {
		List<Coup> list = new ArrayList<Coup>();

		try {
			Statement myStatement = getConnection().createStatement();

			ResultSet myResult = myStatement.executeQuery("SELECT COU_ID, COU_PERSISTANCE, COU_DATE, COU_DEGATS, SOP_NOM, SOP_NIVEAU, BOS_NOM, BOS_NIVEAU, COM_ID\r\n" + 
					"FROM coup \r\n" + 
					" LEFT JOIN sopramon ON SOP_ID = COU_SOPRAMON_ID\r\n" + 
					" LEFT JOIN boss ON BOS_ID = COU_BOSS_ID\r\n" + 
					" LEFT JOIN combat ON COM_ID = COU_COMBAT_ID ORDER BY COU_ID;");

			List<Coup> mesCoups = new ArrayList<Coup>();

			while (myResult.next()) {
				
				Sopramon mySopramon = new Sopramon();
				
				mySopramon.setNom(myResult.getString("SOP_NOM"));
				mySopramon.setNiveau(myResult.getInt("SOP_NIVEAU"));
				
				Boss myBoss = new Boss();
				
				myBoss.setNom(myResult.getString("SOP_NOM"));
				myBoss.setNiveau(myResult.getInt("SOP_NIVEAU"));
				
				Combat myCombat = new Combat();
				
				myCombat.setId(myResult.getInt("COM_ID"));

				Coup myCoup = new Coup();
				
				myCoup.setId(myResult.getInt("COU_ID"));
				myCoup.setDate(myResult.getDate("COU_DATE"));
				myCoup.setDegats(myResult.getInt("COU_DEGATS"));
				myCoup.setPersistance(myResult.getInt("COU_PERSISTANCE"));
				myCoup.setSopramon(mySopramon);
				myCoup.setBoss(myBoss);
				myCoup.setCombat(myCombat);

				mesCoups.add(myCoup);
			}

			list = mesCoups;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Coup findById(int id) {

		try {
			Coup myCoup = new Coup();

			PreparedStatement myStatement = this.getConnection()
					.prepareStatement("SELECT COU_ID, COU_PERSISTANCE, COU_DATE, COU_DEGATS, SOP_NOM, SOP_NIVEAU, BOS_NOM, BOS_NIVEAU, COM_ID FROM coup LEFT JOIN sopramon ON SOP_ID = COU_SOPRAMON_ID LEFT JOIN boss ON BOS_ID = COU_BOSS_ID LEFT JOIN combat ON COM_ID = COU_COMBAT_ID WHERE COU_ID = ?");

			myStatement.setInt(1, id);

			myStatement.execute();

			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {

				Sopramon mySopramon = new Sopramon();
				
				mySopramon.setNom(myResult.getString("SOP_NOM"));
				mySopramon.setNiveau(myResult.getInt("SOP_NIVEAU"));
				
				Boss myBoss = new Boss();
				
				myBoss.setNom(myResult.getString("SOP_NOM"));
				myBoss.setNiveau(myResult.getInt("SOP_NIVEAU"));
				
				Combat myCombat = new Combat();
				
				myCombat.setId(myResult.getInt("COM_ID"));
				
				myCoup.setId(myResult.getInt("COU_ID"));
				myCoup.setDate(myResult.getDate("COU_DATE"));
				myCoup.setDegats(myResult.getInt("COU_DEGATS"));
				myCoup.setPersistance(myResult.getInt("COU_PERSISTANCE"));
				myCoup.setSopramon(mySopramon);
				myCoup.setBoss(myBoss);
				myCoup.setCombat(myCombat);

			}
			return myCoup;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Coup save(Coup entity) {
		try {
			PreparedStatement myStatement = null;
//			if (entity.getId() == 0) {
				myStatement = this.getConnection().prepareStatement(
						"INSERT INTO Coup (COU_DEGATS, COU_PERSISTANCE, COU_SOPRAMON_ID, COU_BOSS_ID, COU_COMBAT_ID) VALUES (?, ?, ?, ?, ?)");
//			}

//			else {
//				myStatement = this.getConnection().prepareStatement(
//						"UPDATE Coup SET (COU_DEGATS = ?, COU_PERSISTANCE = ?, COU_SOPRAMON_ID = ?, COU_BOSS_ID = ?, COU_COMBAT_ID = ? WHERE COU_ID = ?");
//
//				myStatement.setInt(7, entity.getId());
//
//			}

			myStatement.setInt(1, entity.getDegats());
			myStatement.setInt(2, entity.getPersistance());
			myStatement.setInt(3, entity.getSopramon().getId());
			myStatement.setInt(4, entity.getBoss().getId());
			myStatement.setInt(5, entity.getCombat().getId());

			myStatement.execute();

			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Coup entity) {
		deleteById(entity.getId());
	}

	@Override
	public void deleteById(int id) {
		try {
			Statement myStatement = this.getConnection().createStatement();

			myStatement.execute("DELETE FROM Coup WHERE COU_ID = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Coup save2(Coup entity, Sopramon sop, Boss boss, Combat combat) {
		try {
			PreparedStatement myStatement = null;
			if (entity.getId() == 0) {
				myStatement = this.getConnection().prepareStatement(
						"INSERT INTO Coup (COU_DATE, COU_DEGATS, COU_PERSISTANCE) VALUES (?, ?, ?)");
			}

			else {
				myStatement = this.getConnection().prepareStatement(
						"UPDATE Coup SET (COU_DATE = ?, COU_DEGATS = ?, COU_PERSISTANCE = ? WHERE COU_ID = ?");

				myStatement.setInt(7, entity.getId());

			}
			myStatement.setDate(1, entity.getDate());
			myStatement.setInt(2, entity.getDegats());
			myStatement.setInt(3, entity.getPersistance());


			myStatement.execute();

			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
}

	@Override
	public Coup save3(Coup entity, Sopramon sop1, Sopramon sop2, Combat combat) {
		try {
			PreparedStatement myStatement = null;
			if (entity.getId() == 0) {
				myStatement = this.getConnection().prepareStatement(
						"INSERT INTO Coup (COU_DATE, COU_DEGATS, COU_PERSISTANCE) VALUES (?, ?, ?)");
			}

			else {
				myStatement = this.getConnection().prepareStatement(
						"UPDATE Coup SET (COU_DATE = ?, COU_DEGATS = ?, COU_PERSISTANCE = ? WHERE COU_ID = ?");

				myStatement.setInt(7, entity.getId());

			}
			myStatement.setDate(1, entity.getDate());
			myStatement.setInt(2, entity.getDegats());
			myStatement.setInt(3, entity.getPersistance());

			myStatement.execute();

			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
