package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.Date;

public class Evenement {
    private  int evenenementId;
    private String description;
    private Date dateDebut;
    private Date dateFin;

    public Evenement(int evenenementId, String description, Date dateDebut, Date dateFin) {
        this.evenenementId = evenenementId;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getEvenenementId() {
        return evenenementId;
    }

    public void setEvenenementId(int evenenementId) {
        this.evenenementId = evenenementId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
