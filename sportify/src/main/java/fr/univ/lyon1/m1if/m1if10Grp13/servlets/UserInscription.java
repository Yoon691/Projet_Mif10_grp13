package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

/**
 * Servlet implementation class UserInscription
 */
@WebServlet(name = "UserInscription", urlPatterns="/UserInscription")
public class UserInscription extends HttpServlet {
	private DAOInscrit daoInscrit;
	private ServletContext servletContext;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		this.daoInscrit = (DAOInscrit) servletContext.getAttribute("daoInscrit");
		System.out.println(daoInscrit);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserInscription() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomInscrit = request.getParameter("nomInscrit");
		String prenomInscrit = request.getParameter("prenomInscrit");
		String password = request.getParameter("password");
		String emailInscrit = request.getParameter("emailInscrit");
		String telInscrit = request.getParameter("telInscrit");
		Date naissanceInscrit = null;
		try {
			naissanceInscrit= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("naissanceInscrit"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		Date dateInscription = new Date();
		Inscrit inscrit = new Inscrit(emailInscrit, null, nomInscrit + prenomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
		System.out.println("Inscrit Instancier");
		try {
			// check if email and password are not null
			if(emailInscrit != null && password != null){
				inscrit = new Inscrit(emailInscrit, null, nomInscrit + prenomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
				daoInscrit.creer(inscrit);
				Inscrit inscrit1 = (Inscrit) daoInscrit.afficher(emailInscrit);
				System.out.println("Un iscrit créeé dans la BD: " + inscrit1.getNomInscrit() + "  " + inscrit1.getDateInscription()
				+ inscrit1.getPassword() + "  " 
				);
				this.servletContext.getRequestDispatcher( "/connexion.jsp" ).forward( request, response );		
			}
		} catch ( DAOException e) {
			    this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );		
				e.printStackTrace();
		}
	}
		

}
