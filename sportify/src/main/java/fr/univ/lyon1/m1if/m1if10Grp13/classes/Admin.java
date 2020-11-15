package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private Long adminId;
    private String nomAdmin;

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public Long getAdminId() {
        return adminId;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }
}
