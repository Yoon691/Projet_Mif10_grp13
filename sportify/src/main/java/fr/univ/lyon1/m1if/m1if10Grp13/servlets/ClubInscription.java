package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOClub;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClubInscription
 */

@WebServlet(name = "ClubInscription", urlPatterns="/ClubInscription")
public class ClubInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOClub daoClub;
	private ServletContext servletContext;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		this.daoClub = (DAOClub) servletContext.getAttribute("daoClub");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubInscription() {
        super();
        // TODO Auto-generated constructor stub
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
		String nomclub = request.getParameter("nomClub");
		String emaiclub = request.getParameter("emailClub");
		String passwordclub = request.getParameter("passClub");
		String nomresponsable = request.getParameter("nomResponsable");
		int nbmaxadherent = Integer.parseInt(request.getParameter("nbMax"));
		Club club = new Club(nomclub,emaiclub,passwordclub,nomresponsable,nbmaxadherent);
		try {
			if(daoClub.creer( club )) {
				System.out.println("Club created");
			} else {
				System.out.println("Cannot create club");
			}
		} catch ( DAOException e) {
			e.printStackTrace();
		}
		
		// recupération de la session
		HttpSession session = request.getSession();
		
		// Ajout de club à la session
		session.setAttribute( "club",club );

		request.getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
	}

}
