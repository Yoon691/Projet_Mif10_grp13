package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOReservationTerrain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ClubInscription
 */

@WebServlet(name = "Reservation", urlPatterns = "/Reservation")
public class Reservation extends HttpServlet {
    private DAOReservationTerrain daoReservationTerrain;
    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
        this.daoReservationTerrain = (DAOReservationTerrain) servletContext.getAttribute("daoReservationTerrain");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
