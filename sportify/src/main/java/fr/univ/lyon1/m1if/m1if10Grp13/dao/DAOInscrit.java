package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

public class DAOInscrit implements DAOCrud{
    @PersistenceContext( unitName = "pu-sportify" )
    private EntityManager       entitymanager;
    

	@Override
	public void creer(Object objet) throws DAOException {
	    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	    entitymanager = emfactory.createEntityManager( );
		Inscrit inscrit = null;
		if (objet instanceof Inscrit) {
			inscrit = (Inscrit) objet;
		}
        try {
        	System.out.println("EM is" + entitymanager);
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );     
        	
        	// Modification de la table
            entitymanager.persist( inscrit );
            
            // Mise à jours de la table
            entitymanager.getTransaction( ).commit( );
            
            // Femeture de l'objet ntityManager
            entitymanager.close( );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		
	}

	@Override
	public Object afficher(Object object) throws DAOException {
		String email = null;
		Inscrit inscrit = null;
		if (object instanceof String) {
			email = (String) object;
		}
        try {
            inscrit = (Inscrit) entitymanager.find( Inscrit.class, email );
        } catch ( NoResultException e ) {
            System.out.println("User not found");
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		return inscrit;
	}

	@Override
	public void update(Object object) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Object object) throws DAOException {
		String email = null;
		if (object instanceof String) {
			email = (String) object;
		}
		try {
		      entitymanager.getTransaction( ).begin( );
		      Inscrit inscrit = entitymanager.find( Inscrit.class, email );
		      entitymanager.remove( inscrit );
		      entitymanager.getTransaction( ).commit( );
		      entitymanager.close( );
		}catch (Exception e) {
			System.out.println("Canno't delete user");
			return -1;
		}
		return 0;
	}

}
