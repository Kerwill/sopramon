package fr.sopra.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.sopra.DAO.DAOSQL;
import fr.sopra.model.game.Capacite;
import fr.sopra.model.game.Sopramon;

public class DAOSopramonSQL extends DAOSQL implements IDAOSopramon {

	@Override
	public List<Sopramon> findAll() {

		try {
			List<Sopramon> listSopramon = new ArrayList<>();
			Statement myStatement;
			myStatement = this.getConnection().createStatement();

			ResultSet myResultSopramon = myStatement.executeQuery(
					"SELECT SOP_NOM, SOP_ID, SOP_DATE, SOP_EXPERIENCE, SOP_NIVEAU, SOP_ARGENT FROM sopramon");

			while (myResultSopramon.next()) {

				Sopramon mySopramon = new Sopramon();
				mySopramon.setNom(myResultSopramon.getString("SOP_NOM"));
				mySopramon.setId(myResultSopramon.getInt("SOP_ID"));
				mySopramon.setDateNaissance(myResultSopramon.getDate("SOP_DATE"));
				mySopramon.setExperience(myResultSopramon.getInt("SOP_EXPERIENCE"));
				mySopramon.setNiveau(myResultSopramon.getInt("SOP_NIVEAU"));
				mySopramon.setArgent(myResultSopramon.getDouble("SOP_ARGENT"));
				listSopramon.add(mySopramon);
			}

			return listSopramon;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public Sopramon findById(int id) {
		try {
			Statement myStatement;
			myStatement = this.getConnection().createStatement();
			ResultSet myResultSopramon = myStatement.executeQuery(
					"SELECT SOP_NOM, SOP_ID, SOP_DATE, SOP_EXPERIENCE, SOP_NIVEAU, SOP_ARGENT, CAP_PV, CAP_ATTAQUE, CAP_DEFENSE, CAP_ESQUIVE FROM sopramon LEFT JOIN capacite ON CAP_ID = SOP_CAPACITE_ID WHERE SOP_ID ="
							+ id);
			Capacite myCapacite = new Capacite();
			Sopramon mySopramon = new Sopramon();

			if (myResultSopramon.next()) {

				myCapacite.setPointsDeVie(myResultSopramon.getInt("CAP_PV"));
				myCapacite.setAttaque(myResultSopramon.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResultSopramon.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResultSopramon.getInt("CAP_ESQUIVE"));

				mySopramon.setNom(myResultSopramon.getString("SOP_NOM"));
				mySopramon.setId(myResultSopramon.getInt("SOP_ID"));
				mySopramon.setDateNaissance(myResultSopramon.getDate("SOP_DATE"));
				mySopramon.setExperience(myResultSopramon.getInt("SOP_EXPERIENCE"));
				mySopramon.setNiveau(myResultSopramon.getInt("SOP_NIVEAU"));
				mySopramon.setArgent(myResultSopramon.getDouble("SOP_ARGENT"));
				mySopramon.setCapacite(myCapacite);
			}

			return mySopramon;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Sopramon save(Sopramon tosave) {

		try {
			PreparedStatement myStatementPrepare;

			if (tosave.getIdUtilisateur() == 0) {

				myStatementPrepare = this.getConnection().prepareStatement(
						"INSERT INTO utilisateur (UTI_NOM, UTI_PRENOM, UTI_PASSWORD, UTI_USERNAME) VALUES (?,?,?,?)");

				myStatementPrepare.setString(1, tosave.getNomUtilisateur());
				myStatementPrepare.setString(2, tosave.getPrenom());
				myStatementPrepare.setString(3, tosave.getPassword());
				myStatementPrepare.setString(4, tosave.getUsername());
				myStatementPrepare.execute();

				Statement myStatement;
				myStatement = this.getConnection().createStatement();

				ResultSet myResultProduit = myStatement
						.executeQuery("SELECT UTI_ID FROM utilisateur ORDER BY UTI_ID DESC LIMIT 0,1 ");

				while (myResultProduit.next()) {

					tosave.setIdUtilisateur(myResultProduit.getInt("UTI_ID"));
				}

				myStatementPrepare = this.getConnection().prepareStatement(
						"INSERT INTO sopramon (SOP_NOM, SOP_DATE, SOP_EXPERIENCE, SOP_NIVEAU, SOP_ARGENT, SOP_CAPACITE_ID, SOP_UTILISATEUR_ID) VALUES (?,?,?,?,?,?,?)");

				DAOCapaciteSQL daoCapa = new DAOCapaciteSQL();
				daoCapa.save(tosave.getCapacite());

			}

			else {

				myStatementPrepare = this.getConnection().prepareStatement(
						"UPDATE sopramon SET SOP_NOM = ?, SOP_DATE = ?, SOP_EXPERIENCE = ?, SOP_NIVEAU = ?, SOP_ARGENT = ?, SOP_CAPACITE_ID = ? , SOP_UTILISATEUR_ID = ? WHERE SOP_ID ="
								+ tosave.getId());
			}

			myStatementPrepare.setString(1, tosave.getNom());
			myStatementPrepare.setDate(2, tosave.getDateNaissance());
			myStatementPrepare.setInt(3, tosave.getExperience());
			myStatementPrepare.setInt(4, tosave.getNiveau());
			myStatementPrepare.setDouble(5, tosave.getArgent());
			myStatementPrepare.setInt(6, tosave.getCapacite().getId());
			myStatementPrepare.setInt(7, tosave.getIdUtilisateur());

			myStatementPrepare.execute();

			if (tosave.getId() == 0) {
				Statement myStatement;
				myStatement = this.getConnection().createStatement();

				ResultSet myResultProduit = myStatement
						.executeQuery("SELECT SOP_ID FROM sopramon ORDER BY SOP_ID DESC LIMIT 0,1 ");

				while (myResultProduit.next()) {

					tosave.setId(myResultProduit.getInt("SOP_ID"));
				}
			}

			System.out.println("Le Sopramon " + tosave.getNom() + " a été ajouté à la base de données");
			return tosave;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(
					"Le Sopramon " + tosave.getNom() + " n'a été ajouté à la base de données, recommencer SVP");
		}

		return null;
	}

	@Override
	public void delete(Sopramon todelete) {
		if (todelete.getId() != 0) {
			deleteById(todelete.getId());
		}

	}

	@Override
	public void deleteById(int id) {

		try {
			Statement myStatementPrepare;
			myStatementPrepare = this.getConnection().createStatement();
			myStatementPrepare.execute("DELETE FROM sopramon WHERE SOP_ID = " + id);
			System.out.println("L'élément " + id + " a été supprimé");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Erreur de suppression");
		}

	}

	@Override
	public Sopramon findByNom(String nom) {
		// TODO Auto-generated method stub

		try {
			Sopramon mySopramon = new Sopramon();

			Statement myStatement;
			myStatement = this.getConnection().createStatement();

			ResultSet myResultSopramon = myStatement
					.executeQuery("SELECT * FROM sopramon WHERE SOP_NOM = '" +nom+"'");

			while (myResultSopramon.next()) {

				mySopramon.setNom(myResultSopramon.getString("SOP_NOM"));
				mySopramon.setId(myResultSopramon.getInt("SOP_ID"));
				mySopramon.setDateNaissance(myResultSopramon.getDate("SOP_DATE"));
				mySopramon.setExperience(myResultSopramon.getInt("SOP_EXPERIENCE"));
				mySopramon.setNiveau(myResultSopramon.getInt("SOP_NIVEAU"));
				mySopramon.setArgent(myResultSopramon.getDouble("SOP_ARGENT"));
			}
			return mySopramon;
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	@Override
	public List<Sopramon> findAllWithCapacity() {
		try {
			List<Sopramon> listSopramon = new ArrayList<>();
			Statement myStatement;
			myStatement = this.getConnection().createStatement();

			ResultSet myResultSopramon = myStatement.executeQuery(
					("SELECT SOP_NOM, SOP_ID, SOP_DATE, SOP_EXPERIENCE, SOP_NIVEAU, SOP_ARGENT, CAP_ID, CAP_PV, CAP_ATTAQUE, CAP_DEFENSE, CAP_ESQUIVE, CAP_VITESSE FROM sopramon \r\n"
							+ "INNER JOIN capacite ON CAP_ID = SOP_CAPACITE_ID"));

			while (myResultSopramon.next()) {

				Capacite myCapacite = new Capacite();
				myCapacite.setId(myResultSopramon.getInt("CAP_ID"));
				myCapacite.setPointsDeVie(myResultSopramon.getInt("CAP_PV"));
				myCapacite.setAttaque(myResultSopramon.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResultSopramon.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResultSopramon.getInt("CAP_ESQUIVE"));
				myCapacite.setVitesse(myResultSopramon.getInt("CAP_ESQUIVE"));

				Sopramon mySopramon = new Sopramon();
				mySopramon.setNom(myResultSopramon.getString("SOP_NOM"));
				mySopramon.setId(myResultSopramon.getInt("SOP_ID"));
				mySopramon.setDateNaissance(myResultSopramon.getDate("SOP_DATE"));
				mySopramon.setExperience(myResultSopramon.getInt("SOP_EXPERIENCE"));
				mySopramon.setNiveau(myResultSopramon.getInt("SOP_NIVEAU"));
				mySopramon.setArgent(myResultSopramon.getDouble("SOP_ARGENT"));
				mySopramon.setCapacite(myCapacite);
				listSopramon.add(mySopramon);
			}

			return listSopramon;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	public Sopramon seConnecter(String nom, String password) {

		try {
			PreparedStatement myStatement;
			myStatement = this.getConnection().prepareStatement(
					"SELECT UTI_ID, SOP_ID, SOP_NOM, SOP_DATE, SOP_EXPERIENCE, SOP_NIVEAU, SOP_ARGENT, CAP_PV, CAP_ATTAQUE, CAP_DEFENSE, CAP_ESQUIVE, CAP_VITESSE from utilisateur\r\n"
							+ "INNER JOIN sopramon ON SOP_UTILISATEUR_ID = UTI_ID\r\n"
							+ "INNER JOIN capacite ON SOP_CAPACITE_ID = CAP_ID"

							+ " WHERE UTI_USERNAME = ? AND UTI_PASSWORD = ?");

			myStatement.setString(1, nom);
			myStatement.setString(2, password);
			ResultSet myResultSopramon = myStatement.executeQuery();

			if (myResultSopramon.next()) {

				Sopramon mySopramon = new Sopramon();
				Capacite myCapacite = new Capacite();

				myCapacite.setPointsDeVie(myResultSopramon.getInt("CAP_PV"));
				myCapacite.setAttaque(myResultSopramon.getInt("CAP_ATTAQUE"));
				myCapacite.setDefense(myResultSopramon.getInt("CAP_DEFENSE"));
				myCapacite.setEsquive(myResultSopramon.getInt("CAP_ESQUIVE"));
				myCapacite.setVitesse(myResultSopramon.getInt("CAP_ESQUIVE"));

				mySopramon.setNom(myResultSopramon.getString("SOP_NOM"));
				mySopramon.setId(myResultSopramon.getInt("SOP_ID"));
				mySopramon.setDateNaissance(myResultSopramon.getDate("SOP_DATE"));
				mySopramon.setExperience(myResultSopramon.getInt("SOP_EXPERIENCE"));
				mySopramon.setNiveau(myResultSopramon.getInt("SOP_NIVEAU"));
				mySopramon.setArgent(myResultSopramon.getDouble("SOP_ARGENT"));
				mySopramon.setCapacite(myCapacite);

				return mySopramon;

			}

		} catch (SQLException e) {
			System.out.println("Echec dans la connection avec la base de données, merci de recommencer !");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}