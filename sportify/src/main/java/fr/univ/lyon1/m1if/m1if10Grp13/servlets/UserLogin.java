package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOClub;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "UserLogin", urlPatterns="/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private DAOInscrit daoInscrit;
	private DAOClub daoClub;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		this.daoInscrit = (DAOInscrit) servletContext.getAttribute("daoInscrit"); 
		this.daoClub = (DAOClub) servletContext.getAttribute("daoClub"); 
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
		System.out.println("A get request triggered");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String isclub = request.getParameter("adminbox");
		HttpSession session  = request.getSession(true);
		Inscrit inscrit = null;
		Club club = null;
		
		// verifier que le mot de passe et l'email sont dans les parametres du form
		if(email != null && password != null) {
			try {
				
				if (isclub == null) {
					// Rercher un inscrit par son email
					inscrit = (Inscrit) daoInscrit.afficher(email);
					
					// verifier si l'utilisateur existe ou pas
					if (inscrit != null) {
						if (inscrit.getPassword().equals(password)) {
							
							// ajouter l'utilisateur à la session
							session.setAttribute("user", inscrit);
							session.setAttribute("clubList", daoClub.afficherAll());
							
							// Redirection vers la page personnelle
							this.servletContext.getRequestDispatcher("/interface.jsp").forward(request, response);
						} else {
							System.out.println("Wrong email or password");
							this.servletContext.getRequestDispatcher("/connexion.jsp").forward(request, response);	
						}
					} else {
						System.out.println("Wrong email or password");
						this.servletContext.getRequestDispatcher("/connexion.jsp").forward(request, response);	
					}

				// L'utilisateur veut se connecter autant que club
				} else {
					
					// chercher un club par son email
					club = (Club) daoClub.afficher(email);

					System.out.println("Club password is " + club.getPasswordClub());
					
					
					// Authentication
					if (club != null && club.getPasswordClub().equals(password)) {
						
						// Ajouter le club à la session
						session.setAttribute("club", club);
						session.setAttribute("isclub", true);
						
						// Redirection vers la page personnelle du club
						this.servletContext.getRequestDispatcher("/interface.jsp").forward(request, response);
					} else {
						System.out.println("Wrong email or password");
						this.servletContext.getRequestDispatcher("/connexion.jsp").forward(request, response);					
					}
				}
			} catch (Exception e ) {
				e.printStackTrace();
				System.out.println("Wrong email or password");
				this.servletContext.getRequestDispatcher("/connexion.jsp").forward(request, response);

			}	
		}
	}

}
