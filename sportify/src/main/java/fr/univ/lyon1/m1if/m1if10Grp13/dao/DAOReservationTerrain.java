package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.ReservationTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

public class DAOReservationTerrain implements DAOCrud{
	
	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "pu-sportify" )
	private EntityManagerFactory factory
	;


	public DAOReservationTerrain(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean creer(Object objet) throws DAOException {
		EntityManager entitymanager = this.factory.createEntityManager();
		ReservationTerrain reservation = null;
		if (objet instanceof ReservationTerrain) {
			reservation = (ReservationTerrain) objet;
		}
		
		try {
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );

        	// Modification de la table
            entitymanager.persist( reservation );

            // Mise à jours de la table
            entitymanager.getTransaction( ).commit( );
            

        } catch(Exception e) {
        	e.printStackTrace();
        	return false;
        } finally {
            //Femeture de l'objet ntityManager
            entitymanager.close( );
        }
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object afficher(Object object) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object object) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Object object) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReservationTerrain> afficherAll() {
		EntityManager entitymanager = this.factory.createEntityManager();
		List<ReservationTerrain> listReservation = null;
		String query = "SELECT r FROM ReservationTerrain r";
		try {
			listReservation = entitymanager.createQuery(query).getResultList();
			for(ReservationTerrain reservation : listReservation) {
				System.out.println(reservation.getClub().getNomClub());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return listReservation;
		
	}

}
