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
//import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date;


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
        if(heureCreneauParam.length() == 1) {
            heureCreneauParam = "0" + heureCreneauParam + ":00:00";
        } else {
            heureCreneauParam = heureCreneauParam + ":00:00";
        }

        if(dureeParam.length() == 1) {
            dureeParam = "0" + dureeParam + ":00:00";
        } else {
            dureeParam = dureeParam + ":00:00";
        }


           try {
            // Conversion des string récupéré des parametres en objet Date

                dateCreneau =  new SimpleDateFormat("yyyy-MM-dd").parse(dateCreneauParam);
               System.out.println("la date"+ dateCreneau );
                heureCreneau =  new SimpleDateFormat("hh:mm:ss").parse(heureCreneauParam);
                System.out.println("l'heure"+ heureCreneau );
                duree =  new SimpleDateFormat("hh:mm:ss").parse(dureeParam);
               System.out.println("durre"+ heureCreneau );
        } catch (DAOException | ParseException e) {
            e.printStackTrace();
        }
//        Date dateReservation = new Date();
//            Date dateCreneau = null;
//            Timestamp heureCreneau = null;
//            Timestamp duree = null;
//
//        try {
////            // Conversion des string récupéré des parametres en objet Date
//             dateCreneau =  new SimpleDateFormat("yyyy-MM-dd").parse(dateCreneauParam);
//            System.out.println("la date"+ dateCreneau );
//             heureCreneau = (Timestamp) new SimpleDateFormat("hh:mm:ss").parse(heureCreneauParam);
//            System.out.println("l'heure"+ heureCreneau );
//             duree = (Timestamp) new SimpleDateFormat("hh:mm:ss").parse(dureeParam);
//            System.out.println("durre"+ heureCreneau );
//             } catch (DAOException | ParseException e) {
//            e.printStackTrace();
//        }

        Creneau creneau = new Creneau(dateCreneau, heureCreneau, duree);
        try {
            if (daoCreneau.creer(creneau)){
                System.out.println("Vous venez de reserver un creneau");
                System.out.println("la date de ce cerneau est " + creneau.getDateCreneau());
            } else{
                System.out.println("le créneau n'est pas reserver");
            }

        }catch ( DAOException e){
            e.printStackTrace();
        }
        Club club = (Club) session.getAttribute("club");
        Inscrit inscrit = (Inscrit) session.getAttribute("user");
        Terrain terrain = new Terrain();
        terrain.setDispo(true);
        try {
            if (daoTerrain.creer(terrain)){
                System.out.println("Vous venez de reserver un terrain");
                System.out.println("le id de ce terrain est " + terrain.getTerrainId());
            } else{
                System.out.println("le Terrrain n'est pas reserver");
            }

        }catch ( DAOException e){
            e.printStackTrace();
        }


        ReservationTerrain reservationTerrain ;
//        reservationTerrain.setTerrainId(terrain);
//        if (inscrit != null) {
             reservationTerrain = new ReservationTerrain(terrain,creneau, null, inscrit);
//        }else {
//             reservationTerrain = new ReservationTerrain(terrain ,creneau, club, null);
//        }
//        reservationTerrain.setTerrainId(terrain);
//        reservationTerrain.setCreneauId(creneau);
//        reservationTerrain.setEmailInscrit(inscrit);
        try {
            if (daoReservationTerrain.creer(reservationTerrain)){
                System.out.println("Vous venez de reserver un creneauxTerrain");
            } else{
                System.out.println("le créneauTerrain n'est pas reserver");
            }

        }catch ( DAOException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/interface.jsp").forward(request,response);
    }

            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
