package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

import javax.ejb.EJB;
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
//	private static final long serialVersionUID = 1L;

	@EJB
	private DAOInscrit daoInscrit ;



	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserInscription() {
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
		daoInscrit = new DAOInscrit();
		String nomInscrit = request.getParameter("nomInscrit");
		String prenomInscrit = request.getParameter("prenomInscrit");
		String password = request.getParameter("password");
		String emailInscrit = request.getParameter("emailInscrit");
		String telInscrit = request.getParameter("telInscrit");
		Date naissanceInscrit = null;
		try {
			naissanceInscrit= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("naissanceInscrit"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Date dateInscription = new Date();
		Inscrit inscrit = new Inscrit(emailInscrit, null, nomInscrit + prenomInscrit, telInscrit, password, naissanceInscrit, dateInscription);

		try {
				daoInscrit.creer( inscrit );
		} catch ( DAOException e) {
				e.printStackTrace();
		}
		request.setAttribute( "inscrit", inscrit );

		HttpSession session = request.getSession();
		Map<Long, Inscrit> inscrits = (HashMap<Long, Inscrit>) session.getAttribute( "inscreits" );

		if ( inscrits == null ) {
			inscrits = new HashMap<Long, Inscrit>();
		}

		inscrits.put( inscrit.getClubId(), inscrit);
		/* Et enfin (ré)enregistrement de la map en session */
		session.setAttribute( "inscrits", inscrits );

		this.getServletContext().getRequestDispatcher( "/interface.jsp" ).forward( request, response );

		// check if email and password are not null
//		if(emailInscrit != null && password != null){
//			inscrit = new Inscrit(emailInscrit, null, nomInscrit + prenomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
//			System.out.println(inscrit);
//			daoInscrit.creer(inscrit);
//		}
		
		
		
	}

}
