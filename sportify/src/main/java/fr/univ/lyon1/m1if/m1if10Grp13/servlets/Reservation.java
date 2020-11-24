package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.*;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOCreneau;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOReservationTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;
//import jdk.jfr.Timestamp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ClubInscription
 */

@WebServlet(name = "Reservation", urlPatterns = "/Reservation")
public class Reservation extends HttpServlet {
	private DAOReservationTerrain daoReservationTerrain;
	private DAOTerrain daoTerrain;
	private DAOCreneau daoCreneau;
	private ServletContext servletContext;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
		this.daoReservationTerrain = (DAOReservationTerrain) servletContext.getAttribute("daoReservationTerrain");
		this.daoTerrain = (DAOTerrain) servletContext.getAttribute("daoTerrain");
		this.daoCreneau = (DAOCreneau) servletContext.getAttribute("daoCreneau");
		this.daoReservationTerrain = (DAOReservationTerrain) servletContext.getAttribute("daoReservation");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// Recupération des parametres de Creneau
		String dateCreneauParam = request.getParameter("day");
		String heureCreneauParam = request.getParameter("horaire");
		String dureeParam = request.getParameter("duree");
		Inscrit user = (Inscrit) session.getAttribute("user");
		Club club = (Club) session.getAttribute("club");
		
		// format de la date 
		SimpleDateFormat formatDuree = new SimpleDateFormat("hh:mm:ss");

		if (heureCreneauParam.length() == 1) {
			heureCreneauParam = "0" + heureCreneauParam + ":00:00";
		} else {
			heureCreneauParam = heureCreneauParam + ":00:00";
		}

		if (dureeParam.length() == 1) {
			dureeParam = "0" + dureeParam + ":00:00";
		} else {
			dureeParam = dureeParam + ":00:00";
		}
		
		// chercher un cereneau 
		Creneau creneau = null;
		creneau  = (Creneau) daoCreneau.trouverCrenauId(heureCreneauParam, dateCreneauParam);

		if(formatDuree.format(creneau.getDuree()).equals(dureeParam)) {
			try {
				Terrain terrain = (Terrain)new Terrain(Long.valueOf(3));
				if (user != null) {
					this.daoReservationTerrain.creer(new ReservationTerrain(terrain, creneau, null, user));
				} else {
					this.daoReservationTerrain.creer(new ReservationTerrain(terrain, creneau, club, null));
				}
			} catch (DAOException e) {
				e.printStackTrace();
				System.out.println("ne peut pas reserver le terrain");
			}
		}
		request.getRequestDispatcher("/interface.jsp").forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
