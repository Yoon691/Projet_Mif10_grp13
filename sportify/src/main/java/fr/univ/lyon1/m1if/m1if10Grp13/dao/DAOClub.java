package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless
public class DAOClub implements DAOCrud {
	@PersistenceContext( unitName = "pu-sportify" )
	private static EntityManagerFactory factory;
	private EntityManager entitymanager;

	public DAOClub() {
		this.factory = Persistence.createEntityManagerFactory("pu-sportify");
		this.entitymanager = factory.createEntityManager();
	}


	@Override
	public void creer(Object objet) throws DAOException {
		System.out.println("Factory is " + factory );
		Club club = null;
		if (objet instanceof Club) {
			club = (Club) objet;
		}
		try {
			System.out.println("Entity manager is " + entitymanager);
			entitymanager.persist(club);
//        	System.out.println("EM is" + entitymanager);
//        	// Lancement d'une transaction
//        	entitymanager.getTransaction( ).begin( );
//
//        	// Modification de la table
//            entitymanager.persist( inscrit );
//
//            // Mise à jours de la table
//            entitymanager.getTransaction( ).commit( );
//
//            // Femeture de l'objet ntityManager
//            entitymanager.close( );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}

	}

	@Override
	public Object afficher(Object object) throws DAOException {
		String emailClub = null;
		Club club = null;
		if (object instanceof String) {
			emailClub = (String) object;
		}
		try {
			club = (Club) entitymanager.find( Club.class, emailClub );
		} catch ( NoResultException e ) {
			System.out.println("User not found");
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return club;
	}

	@Override
	public void update(Object object) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int delete(Object object) throws DAOException {
		String emailClub = null;
		if (object instanceof String) {
			emailClub = (String) object;
		}
		try {
			entitymanager.getTransaction( ).begin( );
			Club club = entitymanager.find( Club.class, emailClub );
			entitymanager.remove( club );
			entitymanager.getTransaction( ).commit( );
			entitymanager.close( );
		}catch (Exception e) {
			System.out.println("Canno't delete user");
			return -1;
		}
		return 0;
	}


}
