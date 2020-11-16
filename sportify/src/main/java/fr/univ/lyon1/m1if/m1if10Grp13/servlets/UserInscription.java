package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

/**
 * Servlet implementation class UserInscription
 */
@WebServlet(name = "UserInscription", urlPatterns="/UserInscription")
public class UserInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		DAOInscrit daoInscrit = new DAOInscrit();
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
		Inscrit inscrit = null;
		
		// check if email and password are not null
		if(emailInscrit != null && password != null){
			inscrit = new Inscrit(emailInscrit, null, nomInscrit + prenomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
			daoInscrit.creer(inscrit);
		}
		
		
		
	}

}
