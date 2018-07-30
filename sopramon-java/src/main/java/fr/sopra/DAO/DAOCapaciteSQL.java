package fr.sopra.DAO;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.sopra.model.game.Capacite;

public class DAOCapaciteSQL extends DAOSQL implements IDAOCapacite {

	@Override
	public List<Capacite> findAll() {

		List<Capacite> listCapacite = new ArrayList<>();

		Statement myStatement;
		try {
			myStatement = this.getConnection().createStatement();

			ResultSet myResultCapacite = myStatement.executeQuery("SELECT * FROM capacite");

			while (myResultCapacite.next()) {

				Capacite myCapacite = new Capacite();
				myCapacite.setPointsDeVie(myResultCapacite.getInt("CAP_PV"));
				myCapacite.setAttaque(myResultCapacite.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResultCapacite.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResultCapacite.getInt("CAP_ESQUIVE"));
				myCapacite.setVitesse(myResultCapacite.getInt("CAP_ESQUIVE"));

				listCapacite.add(myCapacite);
			}
			return listCapacite;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Capacite findById(int id) {
		try {
			Statement myStatement;
			myStatement = this.getConnection().createStatement();

			ResultSet myResultCapacite = myStatement.executeQuery("SELECT * FROM capacite WHERE PRO_ID =" + id);

			Capacite myCapacite = new Capacite();

			if (myResultCapacite.next()) {

				myCapacite.setPointsDeVie(myResultCapacite.getInt("CAP_PV"));
				myCapacite.setAttaque(myResultCapacite.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResultCapacite.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResultCapacite.getInt("CAP_ESQUIVE"));
				myCapacite.setVitesse(myResultCapacite.getInt("CAP_ESQUIVE"));
			}

			return myCapacite;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Capacite save(Capacite tosave) {

		try {
			PreparedStatement myStatementPrepare;

			if (tosave.getId() == 0) {
				myStatementPrepare = this.getConnection().prepareStatement(
						"INSERT INTO capacite (CAP_PV, CAP_ATTAQUE, CAP_DEFENSE, CAP_ESQUIVE, CAP_VITESSE) VALUES (?,?,?,?,?)");

			}

			else {

				myStatementPrepare = this.getConnection().prepareStatement(
						"UPDATE capacite SET CAP_PV = ?, CAP_ATTAQUE = ?, CAP_DEFENSE = ?, CAP_ESQUIVE = ?, CAP_VITESSE = ? WHERE CAP_ID ="
								+ tosave.getId());
			}

			myStatementPrepare.setInt(1, tosave.getPointsDeVie());
			myStatementPrepare.setInt(2, tosave.getAttaque());
			myStatementPrepare.setInt(3, tosave.getDefense());
			myStatementPrepare.setInt(4, tosave.getEsquive());
			myStatementPrepare.setInt(5, tosave.getVitesse());
			myStatementPrepare.execute();

			if (tosave.getId() == 0) {
				Statement myStatement;
				myStatement = this.getConnection().createStatement();

				ResultSet myResultProduit = myStatement
						.executeQuery("SELECT CAP_ID FROM capacite ORDER BY CAP_ID DESC LIMIT 0,1 ");

				while (myResultProduit.next()) {

					tosave.setId(myResultProduit.getInt("CAP_ID"));
				}

				return tosave;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(Capacite todelete) {

		deleteById(todelete.getId());

	}

	@Override
	public void deleteById(int id) {

		try {
			Statement myStatement;
			myStatement = this.getConnection().createStatement();

			myStatement.execute("DELETE FROM capacite WHERE CAP_ID =" + id);

			System.out.println("L'élément " + id + " a été supprimé");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Erreur de suppression");
		}

	}

}