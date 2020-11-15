package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


public class Inscrit {

    private String emailInscrit;
    private Long clubId;
    private String nomInscrit;
    private String telInscrit;
    private String password;
    private Date naissanceInscrit;
    private Date dateInscription;

    public Inscrit(String emailInscrit, Long clubId, String nomInscrit, String telInscrit, String password, Date naissanceInscrit, Date dateInscription) {
        this.emailInscrit = emailInscrit;
        this.clubId = clubId;
        this.nomInscrit = nomInscrit;
        this.telInscrit = telInscrit;
        this.password = password;
        this.naissanceInscrit = naissanceInscrit;
        this.dateInscription = dateInscription;
    }

    public String getEmailInscrit() {
        return emailInscrit;
    }

    public Long getClubId() {
        return clubId;
    }

    public String getNomInscrit() {
        return nomInscrit;
    }

    public String getTelInscrit() {
        return telInscrit;
    }

    public String getPassword() {
        return password;
    }

    public Date getNaissanceInscrit() {
        return naissanceInscrit;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setEmailInscrit(String emailInscrit) {
        this.emailInscrit = emailInscrit;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setNomInscrit(String nomInscrit) {
        this.nomInscrit = nomInscrit;
    }

    public void setTelInscrit(String telInscrit) {
        this.telInscrit = telInscrit;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNaissanceInscrit(Date naissanceInscrit) {
        this.naissanceInscrit = naissanceInscrit;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
