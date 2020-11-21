package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Creneau;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.ReservationTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class DAOCreneau implements DAOCrud{

	private static final String JPQL_SELECT_PAR_IDCRENEAU = "SELECT cr FROM Creneau cr WHERE cr.creneauID=:creneauID";
	private static final String PARAM_IDCRENEAU = "creneauID";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "pu-sportify" )
	private EntityManagerFactory factory
	;


	public DAOCreneau(EntityManagerFactory factory) {
		this.factory = factory;
	}
	@Override
	public boolean creer(Object object) throws DAOException {
		EntityManager entitymanager = this.factory.createEntityManager();
		Creneau creneau = null;
		if (object instanceof Creneau)
			creneau	= (Creneau) object;

		try {
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );

        	// Modification de la table
            entitymanager.persist( creneau );

            // Mise à jours de la table
            entitymanager.getTransaction( ).commit( );
            

        } catch(Exception e) {
        	e.printStackTrace();
        	return false;
        } finally {
            //Femeture de l'objet ntityManager
            entitymanager.close( );
        }
        return true;
		
	}
	@Override
	public Object afficher(Object object) throws DAOException {
		EntityManager entitymanager = this.factory.createEntityManager();
		Creneau creneau ;
		Long creneauID = null;
		if (object instanceof Creneau) {
			creneau = (Creneau) object;
		}
		else if(object instanceof Long){
			creneauID = (Long) object;
		}
		Query requete = entitymanager.createQuery( JPQL_SELECT_PAR_IDCRENEAU );
		requete.setParameter( PARAM_IDCRENEAU, creneauID );
		try {
			creneau = (Creneau) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return creneau;
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
	
	public List<Creneau> afficherAll() {
		EntityManager entitymanager = this.factory.createEntityManager();
		List<Creneau> creneauList = null;
		String request = "SELECT c FROM Creneau c";
		try {
			creneauList = (List<Creneau>) entitymanager.createQuery(request).getResultList();	
			for(Creneau creneau : creneauList) {
				System.out.println(creneau.getDateCreneau());
			}
		} catch(DAOException e) {
			e.printStackTrace();
		}
		return creneauList;
	}
	/**
	 * Recherche l'id d'un creneau par son heure et date
	 * @param heure
	 * @param date
	 * @return
	 */
	public Creneau trouverCrenauId(String heure, String date) {
		EntityManager entitymanager = this.factory.createEntityManager();
		List<Creneau> creneau = null;
		try {
			Date heureCreneau = (Date) new SimpleDateFormat("hh:mm:ss").parse(heure);
			Date dateCreneau = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			// trouver l'id d'un terrain par son heure et date
			creneau = entitymanager.createQuery(
			        "SELECT c FROM Creneau c WHERE c.datecreneau  =:datecreneau AND c.heurecreneau  =:heurecreneau")
			        .setParameter("datecreneau", dateCreneau)
			        .setParameter("heurecreneau", heureCreneau)
			        .getResultList();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return creneau.get(0);
	}
	/**
	 * Verifier si un creneau est reserver ou pas
	 * @param heure
	 * @param date
	 * @return
	 */
	public boolean creneauDispo(String heure, String date) {
		EntityManager entitymanager = this.factory.createEntityManager();
		List<ReservationTerrain> reservation;
		try {
			Date heureCreneau = (Date) new SimpleDateFormat("hh:mm:ss").parse(heure);
			Date dateCreneau = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			String request = "SELECT r FROM ReservationTerrain r JOIN r.creneau c "
					+ "WHERE c.datecreneau = :datecreneau AND c.heurecreneau =:heurecreneau";
			reservation =  entitymanager.createQuery(request)
			        .setParameter("datecreneau", dateCreneau)
			        .setParameter("heurecreneau", heureCreneau)
			        .getResultList();
			if(reservation.isEmpty()) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// verifier si cet ID existe dans la table de réservation
		return false;
		
	}

}
