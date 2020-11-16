package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

public interface DAOCrud {
	void creer(Object object) throws DAOException;
	Object afficher(Object object) throws DAOException;
	void update(Object object) throws DAOException;
	int delete(Object object) throws DAOException;

}
