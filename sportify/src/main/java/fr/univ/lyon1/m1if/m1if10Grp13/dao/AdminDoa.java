package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Admin;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AdminDoa {

    private static final String JPQL_SELECT_PAR_NOMADMIN = "SELECT a FROM Admin a WHERE a.nomAdmin=:nomAdmin";
    private static final String PARAM_NOMADMIN           = "nomAdmin";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "pu-sportify" )
    private EntityManager       em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Admin admin ) throws DAOException {
        try {
            em.persist( admin );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Admin trouver( String nomAdmin ) throws DAOException {
        Admin admin = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_NOMADMIN );
        requete.setParameter( PARAM_NOMADMIN, nomAdmin );
        try {
            admin = (Admin) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return admin;
    }
}
