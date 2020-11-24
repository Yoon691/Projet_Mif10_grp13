package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOClub;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOCreneau;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;
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

@WebServlet(name = "Adherer", urlPatterns = "/Adherer")
public class Adherer extends HttpServlet {
    private DAOInscrit daoInscrit;
    private DAOClub daoClub;
    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
        this.daoClub = (DAOClub) servletContext.getAttribute("daoClub");
        this.daoInscrit = (DAOInscrit) servletContext.getAttribute("daoInscrit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("club");
        System.out.println("mail club recuperer" + email);
        HttpSession session = request.getSession();
        Inscrit inscrit = (Inscrit) session.getAttribute("user");
        System.out.println("le non de l'user" + inscrit.getNomInscrit());
        Club club = (Club) daoClub.afficher(email);
        System.out.println("le mail de club adherrer" + club.getEmailClub());

        inscrit.setclub(club);
        System.out.println("le mail de club ou l'inscrit est adhérer" + inscrit.getClub());
        System.out.println("daoInscrit : " + daoInscrit);
        try {
                daoInscrit.update(inscrit,club.getEmailClub());
                System.out.println("Vous venez de d'adhérer un club");
                System.out.println("le id de ce club est " + inscrit.getClub());

        }catch ( DAOException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/interface.jsp").forward(request, response);
    }
}
