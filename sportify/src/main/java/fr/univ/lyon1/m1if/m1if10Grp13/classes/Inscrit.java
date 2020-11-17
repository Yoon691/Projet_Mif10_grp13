package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@ Table(name = "inscrit")
public class Inscrit {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "emailinscrit")
    private String emailInscrit;
    @JoinColumn( name = "clubid" )
    private Club club;
    private String nominscrit;
    private String telinscrit;
    private String password;
    private Date naissanceinscrit;
    private Date dateinscription;
    
 

	public Inscrit(String emailInscrit, Club club, String nomInscrit, String telInscrit, String password, Date naissanceInscrit, Date dateInscription) {
        this.emailInscrit = emailInscrit;
        this.club = club;
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

    public void setClubId(Club club) {
        this.club = club;
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
