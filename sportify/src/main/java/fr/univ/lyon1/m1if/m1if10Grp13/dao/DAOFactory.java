package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOConfigException;

public class DAOFactory {
	// TODO this data should be loaded from a file that should be placed inside web-app
	private static String driver = "org.postgresql.Driver";
	private static String	url = "jdbc:postgresql://localhost/sportify_db";
	private static String	username = "grp13";
	private static String password = "p2020623";
	
	public DAOFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Chargement du driver de la base de donner et créer une instance de DAOFactory.
	 * @return Une instance de DAOFactory
	 */
	public static DAOFactory getInstance() throws DAOConfigException {
		// Chargement du driver de postgrsql
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigException("Le driver est introuvable", e);
		}
		
		DAOFactory instance = new DAOFactory(url, username, password);
		return instance;
	}
	
	/**
	 * Créer une connection à la BD.
	 * @return Un objet de type Connection (connection à la BD)
	 */
	Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * Récupération de l'implémentation des différents DAO
	 * @return une instance de chaque classe DAO
	 */
	public DAOAdmin getAdminDao() {
		return new DAOAdmin(this);
	}
	
	// TODO Implémentation des getter des DAO restants 
	
		
}
