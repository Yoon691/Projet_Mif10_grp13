package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.*;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOReservationTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOTerrain;
import fr.univ.lyon1.m1if.m1if10Grp13.daoException.DAOException;

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
    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
        this.daoReservationTerrain = (DAOReservationTerrain) servletContext.getAttribute("daoReservationTerrain");
        this.daoTerrain = (DAOTerrain) servletContext.getAttribute("daoTerrain");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Recupération des parametres de Creneau
        String dateCreneauParam = request.getParameter("day");
        String heureCreneauParam = request.getParameter("horaire");
        String dureeParam = request.getParameter("duree");
        Date dateCreneau = null;
        Date heureCreneau = null;
        Date duree = null;
//           try {
////            // Conversion des string récupéré des parametres en objet Date
//               //  dateCreneau =  new SimpleDateFormat("yyyy-MM-dd").parse(dateCreneauParam);
////             //heureCreneau = (Date) new SimpleDateFormat("hh:mm").parse(heureCreneauParam);
////             //duree = (Date) new SimpleDateFormat("hh:mm").parse(dureeParam);
//        } catch (DAOException | ParseException e) {
//            e.printStackTrace();
//        }
        Date dateReservation = new Date();
        Creneau creneau = new Creneau(dateReservation, dateReservation, dateReservation);
        Club club = (Club) session.getAttribute("club");
        Inscrit inscrit = (Inscrit) session.getAttribute("user");
        Terrain terrain = new Terrain();
        ReservationTerrain reservationTerrain ;
        if (inscrit != null) {
             reservationTerrain = new ReservationTerrain(terrain,creneau, null, inscrit);
        }else {
             reservationTerrain = new ReservationTerrain(terrain ,creneau, club, null);
        }

        try {
            if (daoReservationTerrain.creer(reservationTerrain)){
                System.out.println("Vous venez de reserver un creneaux");
            } else{
                System.out.println("le créneau n'est pas reserver");
            }

        }catch ( DAOException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/interface.jsp").forward(request,response);
    }

            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
