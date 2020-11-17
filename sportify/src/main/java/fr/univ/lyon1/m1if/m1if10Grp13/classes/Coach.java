package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Entity
@IdClass(CoachPost.class)
@Table(name = "coach")
public class Coach extends Inscrit {
    @Id
    private String id;
    private CoachPost coachPost;

    public Coach(String emailInscrit, Club clubId, String nomInscrit, String telInscrit, String password, Date naissanceInscrit, Date dateInscription, CoachPost coachPost) {
        super(emailInscrit, clubId, nomInscrit, telInscrit, password, naissanceInscrit, dateInscription);
        this.coachPost = coachPost;
    }

    public Coach() {

    }

    public CoachPost getCoachPost() {
        return coachPost;
    }

    public void setCoachPost(CoachPost coachPost) {
        this.coachPost = coachPost;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
