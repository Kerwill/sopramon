package fr.sopra.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOSQL {
	private static Connection db;
	
	
	protected Connection getConnection() {
		try {
			if (db == null) {

				db = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramon?useSSL=false", "root", "");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("erreur connexion");
		}
		
		return db;
	}
	
	
	protected void close() {
		try {
			db.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}