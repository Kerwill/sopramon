package fr.sopra.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.sopra.idao.IDAOBoss;
import fr.sopra.model.game.Boss;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Signe;

public class DAOBossSQL extends DAOSQL implements IDAOBoss {

	@Override
	public List<Boss> findAll() {
		List<Boss> list = new ArrayList<Boss>();

		try {
			Statement myStatement = getConnection().createStatement();

			ResultSet myResult = myStatement.executeQuery("BOS_ID, BOS_NOM, BOS_NIVEAU");

			List<Boss> mesBosss = new ArrayList<Boss>();

			while (myResult.next()) {
				
				Boss myBoss = new Boss();
				
				myBoss.setId(myResult.getInt("BOS_ID"));
				myBoss.setNom(myResult.getString("BOS_NOM"));
				myBoss.setNiveau(myResult.getInt("BOS_NIVEAU"));

				mesBosss.add(myBoss);

			}

			list = mesBosss;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Boss findById(int id) {

		try {
			Boss myBoss = new Boss();

			PreparedStatement myStatement = this.getConnection()
					.prepareStatement("BOS_ID, BOS_NOM, BOS_NIVEAU");

			myStatement.setInt(1, id);

			myStatement.execute();

			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {
				
				Capacite myCapacity = new Capacite();
				
;
				myBoss.setId(myResult.getInt("BOS_ID"));
				myBoss.setNom(myResult.getString("BOS_NOM"));
				myBoss.setNiveau(myResult.getInt("BOS_NIVEAU"));
				myBoss.setCapacite(myCapacity);

			}
			return myBoss;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Boss save(Boss entity) {
		try {
			PreparedStatement myStatement = null;
			if (entity.getId() == 0) {
				myStatement = this.getConnection()
						.prepareStatement("INSERT INTO Boss (BOS_NOM, BOS_NIVEAU) VALUES (?, ?)");
			}

			else {
				myStatement = this.getConnection().prepareStatement(
						"UPDATE Boss SET (BOS_NOM = ?, BOS_NIVEAU = ? WHERE BOS_ID = ?");

				myStatement.setInt(4, entity.getId());

			}
			myStatement.setString(1, entity.getNom());
			myStatement.setInt(2, entity.getNiveau());

			myStatement.execute();

			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Boss entity) {
		deleteById(entity.getId());
	}

	@Override
	public void deleteById(int id) {
		try {
			Statement myStatement = this.getConnection().createStatement();

			myStatement.execute("DELETE FROM Boss WHERE BOS_ID = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Boss findByNom(String nom) {
		try {
			Boss myBoss = new Boss();

			PreparedStatement myStatement = this.getConnection()
					.prepareStatement("BOS_ID, BOS_NOM, BOS_NIVEAU WHERE BOS_NOM = ? LIMIT 0,1");

			myStatement.setString(1, nom);

			myStatement.execute();

			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {
				
				myBoss.setId(myResult.getInt("BOS_ID"));
				myBoss.setNom(myResult.getString("BOS_NOM"));
				myBoss.setNiveau(myResult.getInt("BOS_NIVEAU"));

			}
			return myBoss;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
