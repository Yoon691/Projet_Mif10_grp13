package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Club {
    private Long clubId;
    private String nomClub;
    private String emailClub;
    private String passwordClub;
    private String nomResponsable;
    private int nbMaxAdherent;

    public Long getClubId() {
        return clubId;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getEmailClub() {
        return emailClub;
    }

    public String getPasswordClub() {
        return passwordClub;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public int getNbMaxAdherent() {
        return nbMaxAdherent;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public void setEmailClub(String emailClub) {
        this.emailClub = emailClub;
    }

    public void setPasswordClub(String passwordClub) {
        this.passwordClub = passwordClub;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public void setNbMaxAdherent(int nbMaxAdherent) {
        this.nbMaxAdherent = nbMaxAdherent;
    }
}
