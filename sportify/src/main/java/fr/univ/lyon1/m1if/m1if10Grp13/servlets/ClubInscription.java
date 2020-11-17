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
		DAOClub daoClub = new DAOClub();
		String nomclub = request.getParameter("nomClub");
		String emaiclub = request.getParameter("emailClub");
		String passwordclub = request.getParameter("passClub");
		String nomresponsable = request.getParameter("nomResponsable");
		int nbmaxadherent = Integer.parseInt(request.getParameter("nbMax"));
		Club club = new Club(nomclub,emaiclub,passwordclub,nomresponsable,nbmaxadherent);
		try {
			daoClub.creer( club );
		} catch ( DAOException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		/* Et enfin (ré)enregistrement de la map en session */
		session.setAttribute( "clubss",club );

		request.getRequestDispatcher( "/irnterface.jsp" ).forward( request, response );
	}

}
