package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.Date;

public class Inscrit {
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private Date naissance;

    public Inscrit(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }



    public String getNom() {
        return nom;
    }
}
