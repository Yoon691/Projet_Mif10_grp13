package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;

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
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "UserLogin", urlPatterns="/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private DAOInscrit daoInscrit;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		this.daoInscrit = (DAOInscrit) servletContext.getAttribute("daoInscrit"); 
	}

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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session  = request.getSession(true);
		Inscrit inscrit = null;
		if(email != null && password != null) {
			try {
				inscrit = (Inscrit) daoInscrit.afficher(email);
				if(inscrit.getPassword().equals(password)) {
					session.setAttribute("user", inscrit);
					this.servletContext.getRequestDispatcher("/interface.jsp").forward(request, response);
				}
			} catch (Exception e ) {
				System.out.println("Wrong email or password");
				this.servletContext.getRequestDispatcher("/connexion.jsp").forward(request, response);

			}	
		}
	}

}
