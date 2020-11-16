package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Creneau;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class DAOCreneau implements DAOCrud{

	private static final String JPQL_SELECT_PAR_IDCRENEAU = "SELECT cr FROM Creneau cr WHERE cr.creneauID=:creneauID";
	private static final String PARAM_IDCRENEAU = "creneauID";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "pu-sportify" )
	private EntityManager em;


	@Override
	public void creer(Object object) throws DAOException {
		Creneau creneau = null;
		if (object instanceof Creneau)
			creneau	= (Creneau) object;

		try {

			em.persist(creneau);
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		
	}

	@Override
	public Object afficher(Object object) throws DAOException {
		Creneau creneau ;
		Long creneauID = null;
		if (object instanceof Creneau) {
			creneau = (Creneau) object;
		}
		else if(object instanceof Long){
			creneauID = (Long) object;
		}
		Query requete = em.createQuery( JPQL_SELECT_PAR_IDCRENEAU );
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

}
