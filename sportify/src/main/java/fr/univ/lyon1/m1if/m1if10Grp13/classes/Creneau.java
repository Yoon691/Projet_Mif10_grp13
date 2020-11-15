package fr.univ.lyon1.m1if.m1if10Grp13.classes;
import java.util.Date;


public class Creneau {
	private int creneauID;
	private Date dateCreneau;
	private Date heureCreneau;
	private Date duree;
	
	
	
	public Creneau(int creneauID, Date dateCreneau, Date heureCreneau, Date duree) {
		this.creneauID = creneauID;
		this.dateCreneau = dateCreneau;
		this.heureCreneau = heureCreneau;
		this.duree = duree;
	}
	
	public int getCreneauID() {
		return creneauID;
	}
	public void setCreneauID(int creneauID) {
		this.creneauID = creneauID;
	}
	public Date getDateCreneau() {
		return dateCreneau;
	}
	public void setDateCreneau(Date dateCreneau) {
		this.dateCreneau = dateCreneau;
	}
	public Date getHeureCreneau() {
		return heureCreneau;
	}
	public void setHeureCreneau(Date heureCreneau) {
		this.heureCreneau = heureCreneau;
	}
	public Date getDuree() {
		return duree;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}
	

}
