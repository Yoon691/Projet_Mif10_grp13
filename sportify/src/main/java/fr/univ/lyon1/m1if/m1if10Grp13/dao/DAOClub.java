package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class DAOClub implements DAOCrud{
	private static final String JPQL_SELECT_PAR_NOMCLUB = "SELECT c FROM Club c WHERE c.nomclub=:nomclub";
	private static final String PARAM_NOMCLUB           = "nomclub";

	@PersistenceContext(unitName = "pu-sportify")
	private EntityManager em;
	@Override
	public void creer(Object object) throws DAOException {
		Club club = null;
		if (object instanceof Club)
			club	= (Club) object;

		try {

			em.persist( club );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
	}


	@Override
	public Object afficher(Object object) throws DAOException {
		Club club ;
		String nomclub = null;
		if (object instanceof Club) {
			club = (Club) object;
		}
		else if(object instanceof String){
			nomclub = (String) object;
		}
		Query requete = em.createQuery( JPQL_SELECT_PAR_NOMCLUB );
		requete.setParameter( PARAM_NOMCLUB, nomclub );
		try {
			club = (Club) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
