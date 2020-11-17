package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "UserLogin", urlPatterns="/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Inscrit inscrit = null;
		if(email != null && password != null) {
			inscrit = (Inscrit) daoInscrit.afficher(email);
			if (inscrit.getPassword().equals(password)) {
				System.out.println("User connected");
				request.getRequestDispatcher("/sportify/src/main/webapp/interface.jsp").include(request, response);
			} else {
				System.out.println("Wrong password");
				request.getRequestDispatcher("/sportify/src/main/webapp/connexion.jsp").include(request, response);
			}
		}
	}

}
