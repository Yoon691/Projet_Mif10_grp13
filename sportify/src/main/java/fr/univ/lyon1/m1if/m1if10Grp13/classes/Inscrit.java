package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@ Table(name = "inscrit")
public class Inscrit {
    @Id
    @Column(name = "emailinscrit")
    private String emailInscrit;
    @Column(name = "clubid")
    private Long clubId;
    private String nominscrit;
    private String telinscrit;
    private String password;
    private Date naissanceinscrit;
    private Date dateinscription;

    public Inscrit(String emailInscrit, Long clubId, String nomInscrit, String telInscrit, String password, Date naissanceInscrit, Date dateInscription) {
        this.emailInscrit = emailInscrit;
        this.clubId = clubId;
        this.nominscrit = nomInscrit;
        this.telinscrit = telInscrit;
        this.password = password;
        this.naissanceinscrit = naissanceInscrit;
        this.dateinscription = dateInscription;
    }

    public Inscrit() {

    }

    public String getEmailInscrit() {
        return emailInscrit;
    }

    public Long getClubId() {
        return clubId;
    }

    public String getNomInscrit() {
        return nominscrit;
    }

    public String getTelInscrit() {
        return telinscrit;
    }

    public String getPassword() {
        return password;
    }

    public Date getNaissanceInscrit() {
        return naissanceinscrit;
    }

    public Date getDateInscription() {
        return dateinscription;
    }

    public void setEmailInscrit(String emailInscrit) {
        this.emailInscrit = emailInscrit;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setNomInscrit(String nomInscrit) {
        this.nominscrit = nomInscrit;
    }

    public void setTelInscrit(String telInscrit) {
        this.telinscrit = telInscrit;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNaissanceInscrit(Date naissanceInscrit) {
        this.naissanceinscrit = naissanceInscrit;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateinscription = dateInscription;
    }
}
