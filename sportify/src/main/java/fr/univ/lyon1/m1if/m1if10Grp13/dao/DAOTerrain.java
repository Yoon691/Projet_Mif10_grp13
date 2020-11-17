package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Admin;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Publication;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Terrain;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;
import org.hibernate.dialect.function.TemplateRenderer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class DAOTerrain implements DAOCrud{

	private static final String JPQL_SELECT_PAR_IDTERRAIN = "SELECT t FROM Terrain t WHERE t.terrainId=:terrrainId";
	private static final String PARAM_IDTERRAIN = "terrainId";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "pu-sportify" )
	private EntityManager em;

	@Override
	public void creer(Object object) throws DAOException {
		Terrain terrain = null;
		if (object instanceof Terrain)
			terrain	= (Terrain) object;

		try {

			em.persist( terrain );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}


	}

	@Override
	public Object afficher(Object object) throws DAOException {
		Terrain terrain ;
		Long terrainId = null;
		if (object instanceof Terrain) {
			terrain = (Terrain) object;
		}
		else if(object instanceof Long){
			terrainId = (Long) object;
		}
		Query requete = em.createQuery( JPQL_SELECT_PAR_IDTERRAIN );
		requete.setParameter( PARAM_IDTERRAIN, terrainId );
		try {
			terrain = (Terrain) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return terrain;
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
