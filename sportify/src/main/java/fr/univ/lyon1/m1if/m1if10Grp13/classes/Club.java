package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Club {
    private int clubId;
    private String nom;
    private String mail;
    private List<Inscrit> listeMembre = new ArrayList<>();
    private Inscrit coach;
    private int nbMaxAdherent;

    public Club(int clubId, String nom, Inscrit coach, int nbMaxAdherent) {
        this.clubId = clubId;
        this.nom = nom;
        this.coach = coach;
        this.nbMaxAdherent = nbMaxAdherent;
    }
    public int getClubId() {
        return clubId;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public List<Inscrit> getListeMembre() {
        return listeMembre;
    }

    public Inscrit getCoach() {
        return coach;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setListeMembre(List<Inscrit> listeMembre) {
        this.listeMembre = listeMembre;
    }

    public void setCoach(Inscrit coach) {
        this.coach = coach;
    }

    public void setNbMaxAdherent(int nbMaxAdherent) {
        this.nbMaxAdherent = nbMaxAdherent;
    }

    public int getNbMaxAdherent() {
        return nbMaxAdherent;
    }

    public void reserver (Date date, int duree) {
        //TODO
    }

    public boolean accepterAdherent() {
        //TODO
        return true;
    }

    public void ajouterAdherent(Inscrit inscrit) {
        //TODO
    }

    public void supprimerAdhérent(Inscrit inscrit) {
        //TODO
    }



}
