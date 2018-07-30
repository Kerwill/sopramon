package fr.sopra.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Combat;
import fr.sopra.model.game.Sopramon;


public class DAOCombatSQL extends DAOSQL implements IDAOCombat {

	@Override
	public List<Combat> findAll() {

		try {
			
			Statement myStatement = this.getConnection().createStatement();
			ResultSet myResult = myStatement
					.executeQuery("SELECT BOS_ID, b.SOP_ID, a.SOP_ID, a.SOP_NOM, b.SOP_NOM, COM_ID, COM_TOUR, BOS_NOM, a.SOP_NOM as SOP1, b.SOP_NOM as SOP2\r\n" + 
							"From Combat\r\n" + 
							"LEFT JOIN Sopramon a ON a.SOP_ID = COM_SOPRAMON_ID\r\n" + 
							"LEFT JOIN Sopramon b ON b.SOP_ID = COM_SOPRAMON2_ID\r\n" + 
							"LEFT JOIN Boss ON BOS_ID = COM_BOSS_ID;");
			

			List<Combat> mesCombats = new ArrayList<Combat>();
			
			while (myResult.next()) {
				
					Sopramon mySopramon1 = new Sopramon();
					
					mySopramon1.setId(myResult.getInt("a.SOP_ID"));
					mySopramon1.setNom(myResult.getString("a.SOP_NOM"));
					//mySopramon1.setUtilisateurId(myResult.getFloat("SOP_UTILISATEUR_ID"));
					
					Sopramon mySopramon2 = new Sopramon();
					
					mySopramon2.setId(myResult.getInt("b.SOP_ID"));
					mySopramon2.setNom(myResult.getString("b.SOP_NOM"));
		
					Boss myBoss = new Boss();
					
					myBoss.setId(myResult.getInt("BOS_ID"));
					myBoss.setNom(myResult.getString("BOS_NOM"));
					
					
					Combat myCombat = new Combat();

					myCombat.setId(myResult.getInt("COM_ID"));
					myCombat.setTour(myResult.getInt("COM_TOUR"));
					myCombat.setBoss(myBoss);
					
					mesCombats.add(myCombat);
			}
			return mesCombats;
	} 
	
	catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Combat findById(int id) {
		try {
			Statement myStatement = this.getConnection().createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT BOS_ID, b.SOP_ID, a.SOP_ID, a.SOP_NOM, b.SOP_NOM, COM_ID, COM_TOUR, BOS_NOM, a.SOP_NOM as SOP1, b.SOP_NOM as SOP2 \r\n" + 
					"From Combat\r\n" + 
					"LEFT JOIN Sopramon a ON a.SOP_ID = COM_SOPRAMON_ID\r\n" + 
					"LEFT JOIN Sopramon b ON b.SOP_ID = COM_SOPRAMON2_ID\r\n" + 
					"LEFT JOIN Boss ON BOS_ID = COM_BOSS_ID WHERE COM_ID = " + id);
			
			
			//SI J'AI UN ENREGISTREMENT
			if (myResult.next()) {
				
				Sopramon mySopramon1 = new Sopramon();
				
				mySopramon1.setId(myResult.getInt("a.SOP_ID"));
				mySopramon1.setNom(myResult.getString("a.SOP_NOM"));
				//mySopramon1.setUtilisateurId(myResult.getFloat("SOP_UTILISATEUR_ID"));
				
				Sopramon mySopramon2 = new Sopramon();
				
				mySopramon2.setId(myResult.getInt("b.SOP_ID"));
				mySopramon2.setNom(myResult.getString("b.SOP_NOM"));
	
				Boss myBoss = new Boss();
				
				myBoss.setId(myResult.getInt("BOS_ID"));
				myBoss.setNom(myResult.getString("BOS_NOM"));
				
				
				Combat myCombat = new Combat();

				myCombat.setId(myResult.getInt("COM_ID"));
				myCombat.setTour(myResult.getInt("COM_TOUR"));
				myCombat.setBoss(myBoss);
				
				return myCombat;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	
	public Combat save(Combat entity) {
		try {
		
			PreparedStatement myStatement;
			
				myStatement = this.getConnection().prepareStatement("INSERT INTO Combat "
						+ "(COM_SOPRAMON_ID, COM_SOPRAMON2_ID, COM_BOSS_ID, COM_TOUR) " + "VALUES (?, ?, ?, ?)");
			

//			else {
//				myStatement = this.getConnection().prepareStatement("UPDATE Combat " + "COM_SOPRAMON_ID = ?, "
//						+ "COM_SOPRAMON2_ID = ?, " + "COM_BOSS_ID = ?, " +" COM_TOUR = ? " + "WHERE COM_ID = ?");
//
//				myStatement.setInt(4, entity.getId());
//			}
			myStatement.setInt(1, entity.getSopramon1().getId());
			myStatement.setInt(2, entity.getSopramon2().getId());
			myStatement.setInt(3, entity.getBoss().getId());
			myStatement.setInt(4, entity.getTour());

			myStatement.execute();

		
				
			Statement myStatement2;
			
			myStatement2 = this.getConnection().createStatement();

			ResultSet myResultProduit = myStatement2
					.executeQuery("SELECT COM_ID FROM combat ORDER BY COM_ID DESC LIMIT 0,1 ");


			while (myResultProduit.next()) {

				entity.setId(myResultProduit.getInt("COM_ID"));

			}
		
			System.out.println(entity.getId());
			return entity;
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void delete(Combat entity) {
		deleteById(entity.getId());
	}

	@Override
	public void deleteById(int id) {
		try {
			PreparedStatement myStatement = this.getConnection()
					.prepareStatement("DELETE FROM Combat WHERE COM_ID = ?");

			myStatement.setInt(1, id);

			myStatement.execute();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public Combat saveBoss(Combat combat) {
		try {
			PreparedStatement myStatement = null;

			if (combat.getId() == 0) {
				myStatement = this.getConnection().prepareStatement("INSERT INTO Combat "
						+ "(COM_SOPRAMON_ID, COM_BOSS_ID, COM_TOUR) " + "VALUES (?, ?, ?)");
			}

//			else {
//				myStatement = this.getConnection().prepareStatement("UPDATE Combat " + "COM_SOPRAMON_ID = ?, "
//						+ "COM_SOPRAMON2_ID = ?, " + "COM_BOSS_ID = ?, " +" COM_TOUR = ? " + "WHERE COM_ID = ?");
//
//				myStatement.setInt(4, entity.getId());
//			}
			myStatement.setInt(1, combat.getSopramon1().getId());
			myStatement.setInt(2, combat.getBoss().getId());
			myStatement.setInt(3, combat.getTour());

			myStatement.execute();

		
				
			Statement myStatement2;
			
			myStatement2 = this.getConnection().createStatement();

			ResultSet myResultProduit = myStatement2
					.executeQuery("SELECT COM_ID FROM combat ORDER BY COM_ID DESC LIMIT 0,1 ");


			while (myResultProduit.next()) {

				combat.setId(myResultProduit.getInt("COM_ID"));

			}
		
			System.out.println(combat.getId());
			
			return combat;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Combat saveSopramon(Combat combat) {
		try {
			PreparedStatement myStatement = null;

			if (combat.getId() == 0) {
				myStatement = this.getConnection().prepareStatement("INSERT INTO Combat "
						+ "(COM_SOPRAMON_ID, COM_SOPRAMON2_ID, COM_TOUR) " + "VALUES (?, ?, ?)");
			}

//			else {
//				myStatement = this.getConnection().prepareStatement("UPDATE Combat " + "COM_SOPRAMON_ID = ?, "
//						+ "COM_SOPRAMON2_ID = ?, " + "COM_BOSS_ID = ?, " +" COM_TOUR = ? " + "WHERE COM_ID = ?");
//
//				myStatement.setInt(4, entity.getId());
//			}
			myStatement.setInt(1, combat.getSopramon1().getId());
			myStatement.setInt(2, combat.getSopramon2().getId());
			myStatement.setInt(3, combat.getTour());

			myStatement.execute();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}