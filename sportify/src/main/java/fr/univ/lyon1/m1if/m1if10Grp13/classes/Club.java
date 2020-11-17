package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "club")
public class Club {
    @Id
    @Column(name = "clubid")
    private Long clubId;
    private String nomclub;
    private String emailclub;
    private String passwordclub;
    private String nomresponsable;
    private int nbmaxadherent;

    public Club(String nomclub, String emailclub, String passwordclub, String nomresponsable, int nbmaxadherent) {
        this.nomclub = nomclub;
        this.emailclub = emailclub;
        this.passwordclub = passwordclub;
        this.nomresponsable = nomresponsable;
        this.nbmaxadherent = nbmaxadherent;
    }

    public Long getClubId() {
        return clubId;
    }

    public String getNomClub() {
        return nomclub;
    }

    public String getEmailClub() {
        return emailclub;
    }

    public String getPasswordClub() {
        return passwordclub;
    }

    public String getNomResponsable() {
        return nomresponsable;
    }

    public int getNbMaxAdherent() {
        return nbmaxadherent;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setNomClub(String nomClub) {
        this.nomclub = nomClub;
    }

    public void setEmailClub(String emailClub) {
        this.emailclub = emailClub;
    }

    public void setPasswordClub(String passwordClub) {
        this.passwordclub = passwordClub;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomresponsable = nomResponsable;
    }

    public void setNbMaxAdherent(int nbMaxAdherent) {
        this.nbmaxadherent = nbMaxAdherent;
    }
}
