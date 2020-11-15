package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.Date;

public class GestionAdminClub {
    private int clubId;
    private int adminId;
    private Date dateGestion;
    private AdminOperation operation;

    public GestionAdminClub(int clubId, int adminId, Date dateGestion, AdminOperation operation) {
        this.clubId = clubId;
        this.adminId = adminId;
        this.dateGestion = dateGestion;
        this.operation = operation;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Date getDateGestion() {
        return dateGestion;
    }

    public void setDateGestion(Date dateGestion) {
        this.dateGestion = dateGestion;
    }

    public AdminOperation getOperation() {
        return operation;
    }

    public void setOperation(AdminOperation operation) {
        this.operation = operation;
    }
}
