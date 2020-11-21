package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless
public class DAOClub implements DAOCrud {
	@PersistenceContext( unitName = "pu-sportify" )
	private EntityManagerFactory factory;

	public DAOClub(EntityManagerFactory factory) {
		this.factory = factory;
	}

	/**
	 * Ajouter un club à la table club dans la BD.
	 * @param objet une instance club
	 * @return Un booléen qui est true si le club est créé, false sinon
	 */
	@Override
	public boolean creer(Object objet) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
		Club club = null;
		if (objet instanceof Club) {
			club = (Club) objet;
		}
		try {
			entitymanager.persist(club);
        	// Lancement d'une transaction
        	entitymanager.getTransaction( ).begin( );

        	// Modification de la table
            entitymanager.persist( club );

            // Mise à jours de la table
            entitymanager.getTransaction( ).commit( );


			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		} finally {
            // Femeture de l'objet ntityManager
            entitymanager.close( );
		}

	}
	
	/**
	 * Rechercher un club par son Email, sachant que l'email n'est pas la clé primaire de club,
	 * donc on ne peut pas utiliser EntityManager.find() car elle prend une clé primaire comme param.
	 * @param object (email) sous forme d'une chaine de caractères
	 * @return Une instance de Club s'il existe, null sinon
	 */
	@Override
	public Object afficher(Object object) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
		String emailClub = null;
		Club club = null;
		if (object instanceof String) {
			emailClub = (String) object;
		}
		try {
			// faire une requete sql pour la récupération du club par email
			List clubList = entitymanager.createQuery(
			        "SELECT c FROM Club c WHERE c.emailclub LIKE :email")
			        .setParameter("email", emailClub)
			        .getResultList();
			
			// verifier si la requete retourne une val
			if( !clubList.isEmpty() ) {
				club = (Club) clubList.get(0);
			}
		} catch ( NoResultException e ) {
			System.out.println("User not found");
		} catch ( Exception e ) {
			throw new DAOException( e );
		} finally {
			entitymanager.close();
		}
		return club;
	}

	@Override
	public void update(Object object) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
		// TODO Auto-generated method stub

	}
	
	/**
	 * Suppression d'un club de la table club dans la BD.
	 * @param object email sous forme de chaine de caractère
	 * @return 0 si la suppression est un un succès, -1 sinon
	 */
	@Override
	public int delete(Object object) throws DAOException {
		EntityManager entitymanager = factory.createEntityManager();
		String emailClub = null;
		if (object instanceof String) {
			emailClub = (String) object;
		}
		try {
			// Démarer une transaction
			entitymanager.getTransaction( ).begin( );
			
			// Recherche le club par son email
			Club club = (Club) this.afficher(emailClub);
			
			// Supprimer le club
			entitymanager.remove( club );
			
			// mettre à jours la table club
			entitymanager.getTransaction( ).commit( );
			

		}catch (Exception e) {
			System.out.println("Canno't delete user");
			return -1;
		} finally {
			// fermeture de l'EM
			entitymanager.close( );
		}
		return 0;
	}

	/**
	 * Afficher la liste de tous les adhérents d'un club donné.
	 * @param email du club sous forme d'une chaine de caractères
	 * @return Liste contenant tous les adhérents d'un club
	 */
	
	public List<Inscrit> listerAdherents(String email) {
		EntityManager entitymanager = factory.createEntityManager();
		String query = "SELECT i"
				+ " FROM Inscrit i JOIN i.club c WHERE c.emailclub LIKE :email";
		List<Inscrit> adherents = null;
		git
		try {
			adherents = entitymanager.createQuery(
			        query)
			        .setParameter("email", email)
			        .getResultList();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return adherents;
	}
}
