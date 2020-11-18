package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.postgresql.util.PSQLException;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

@Stateless
public class DAOInscrit implements DAOCrud{
    @PersistenceContext( unitName = "pu-sportify" )
    private EntityManagerFactory factory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    public DAOInscrit(EntityManagerFactory factory) {
    	this.factory = factory;
    }
    
    

	@Override
	public boolean creer(Object objet) throws DAOException {
		// créer une instance de EntityManager pour lancer une transaction
		EntityManager entitymanager = factory.createEntityManager();
		Inscrit inscrit = null;
		if (objet instanceof Inscrit) {
			inscrit = (Inscrit) objet;
		}
        try {
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );

        	// Modification de la table
            entitymanager.persist( inscrit );

            // Mise à jours de la table
            entitymanager.getTransaction( ).commit( );

            //Femeture de l'objet ntityManager
            entitymanager.close( );
            
            return true;
        } catch(Exception e) {
        	return false;
        }
	}

	@Override
	public Object afficher(Object object) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
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
        	System.out.println("User not found");
        } finally {
        	entitymanager.close();
        }
		return inscrit;
	}

	@Override
	public void update(Object object) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Object object) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
		String email = null;
		if (object instanceof String) {
			email = (String) object;
		}
		try {
			  // Lancement d'une transaction
		      entitymanager.getTransaction( ).begin( );
		      
		      // Chercher un utilisateur par son email
		      Inscrit inscrit = entitymanager.find( Inscrit.class, email );
		      
		      if (inscrit != null) {
		    	  // suppression de l'inscrit et mise à jours de la table
			      entitymanager.remove( inscrit );
			      entitymanager.getTransaction( ).commit( );  
		      }
		      entitymanager.close( );
		}catch (Exception e) {
			System.out.println("Canno't delete user");
			return -1;
		}
		return 0;
	}

}
