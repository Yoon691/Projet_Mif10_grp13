package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.Date;

public class Coach extends Inscrit {
     private CoachPost coachPost;

    public Coach(String emailInscrit, Long clubId, String nomInscrit, String telInscrit, String password, Date naissanceInscrit, Date dateInscription, CoachPost coachPost) {
        super(emailInscrit, clubId, nomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
        this.coachPost = coachPost;
    }

    public CoachPost getCoachPost() {
        return coachPost;
    }

    public void setCoachPost(CoachPost coachPost) {
        this.coachPost = coachPost;
    }
}
