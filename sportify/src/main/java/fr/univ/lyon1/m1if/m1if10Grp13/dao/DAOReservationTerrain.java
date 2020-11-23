package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
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
		System.out.println("Inside");
		EntityManager entitymanager = this.factory.createEntityManager();
		ReservationTerrain reservation = null;
		if (objet instanceof ReservationTerrain) {
			reservation = (ReservationTerrain) objet;
			System.out.println(reservation);
		}
		
		try {
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );
        	System.out.println("Before reservation");
        	// Modification de la table
            entitymanager.merge( reservation );
            System.out.println("After reservation");

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
	public void update(Object object, Object id) throws DAOException {
		// TODO Auto-generated method
		
	}

	@Override
	public int delete(Object object) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * retourn la liste de toutes les reservation dans la table reservation
	 * @return Liste d'objet ReservationTerrain
	 */
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
	
	/**
	 * Verifier si un creneau donné est reservé ou pas.
	 * @param heure chaine de caractère qui représente l'heure de debut
	 * @param nJour le numéro du jour de la semaine actuelle pour lequel on veut les dispos.
	 * @param user instance de la classe inscrit si l'utilisateur connecté est un adherent, club sinon.
	 * @return "reserve" si le creneau est reservé par la personne donnée en parametre, "disponible" si le creneau est disponible
	 *  "occupe" si le creneau est reservé par une autre personne
	 */
	public String creneauDispo(String heure, int nJour, Object user) {
		EntityManager entitymanager = this.factory.createEntityManager();
		ReservationTerrain reservation;
		final Calendar date = new GregorianCalendar();
		
		try {
			while (date.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
		         date.add(Calendar.DAY_OF_WEEK,-1);
		    }
			date.add(Calendar.DAY_OF_WEEK, nJour);
			SimpleDateFormat fmtDate = new SimpleDateFormat ("yyyy-MM-dd");
			//System.out.println(fmtDate.format(date.getTime()));
			Time heureCreneau = (Time) Time.valueOf(heure);
			Date dateCreneau = (Date) Date.valueOf(fmtDate.format(date.getTime()));
			String request = "SELECT r FROM ReservationTerrain r JOIN r.creneau c "
					+ "WHERE c.datecreneau = :datecreneau AND c.heurecreneau =:heurecreneau";
			reservation =  (ReservationTerrain) entitymanager.createQuery(request)
			        .setParameter("datecreneau", dateCreneau)
			        .setParameter("heurecreneau", heureCreneau)
			        .getSingleResult();
			if( user instanceof Inscrit) {
				Inscrit utilisateur = (Inscrit) user;
				if (reservation.getInscrit() != null && reservation.getInscrit().getEmailInscrit().equals(utilisateur.getEmailInscrit()))
						return "reserve";
			} else if ( user instanceof Club) {
				Club utilisateur = (Club) user;
				if (reservation.getClub() != null && reservation.getClub().getEmailClub().equals(utilisateur.getEmailClub()))
					return "reserve";
			}
			
		} catch (NoResultException e) {
			//System.out.println("No result found, creneau est dispo");
			return "disponible";
		}
		return "occupe";
		
	}

}
