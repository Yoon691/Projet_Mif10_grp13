package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "gestion_admin_club")
public class GestionAdminClub implements Serializable{
    @Id
    @Column(name = "clubid")
    private int clubId;
    @Id
    @Column(name = "adminid")
    private int adminId;
    private Date dategestion;
    private AdminOperation operation;

    public GestionAdminClub(int clubId, int adminId, Date dateGestion, AdminOperation operation) {
        this.clubId = clubId;
        this.adminId = adminId;
        this.dategestion = dateGestion;
        this.operation = operation;
    }

    public GestionAdminClub() {

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
        return dategestion;
    }

    public void setDateGestion(Date dateGestion) {
        this.dategestion = dateGestion;
    }

    public AdminOperation getOperation() {
        return operation;
    }

    public void setOperation(AdminOperation operation) {
        this.operation = operation;
    }
}
