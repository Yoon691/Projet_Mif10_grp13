package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

import java.io.IOException;

@WebServlet(name = "Init", urlPatterns="/",loadOnStartup= 1)
public class Init extends HttpServlet {
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	ServletContext servletContext = config.getServletContext();
    	DAOInscrit daoInscrit = new DAOInscrit();
    	System.out.println(daoInscrit);
    	servletContext.setAttribute("daoInscrit", daoInscrit);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}
