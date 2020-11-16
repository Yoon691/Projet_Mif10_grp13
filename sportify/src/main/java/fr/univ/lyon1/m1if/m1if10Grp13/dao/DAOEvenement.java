package fr.univ.lyon1.m1if.m1if10Grp13.dao;

import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

public class DAOEvenement implements DAOCrud{
	private DAOFactory daoFactory;
	
	DAOEvenement(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void creer(Object objet) throws DAOException {
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

}
