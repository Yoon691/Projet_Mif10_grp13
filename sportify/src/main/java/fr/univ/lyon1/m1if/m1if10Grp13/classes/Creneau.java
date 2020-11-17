package fr.univ.lyon1.m1if.m1if10Grp13.classes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Entity
@Table(name = "creneau")
public class Creneau {
	@Id
	@Column(name = "creneauid")
	private Long creneauID;
	private Date datecreneau;
	private Date heurecreneau;
	private Date duree;





	public Creneau(Long creneauID, Date dateCreneau, Date heureCreneau, Date duree) {
		this.creneauID = creneauID;
		this.datecreneau = dateCreneau;
		this.heurecreneau = heureCreneau;
		this.duree = duree;
	}

	public Creneau() {

	}


	public Long getCreneauID() {
		return creneauID;
	}
	public void setCreneauID(Long creneauID) {
		this.creneauID = creneauID;
	}
	public Date getDateCreneau() {
		return datecreneau;
	}
	public void setDateCreneau(Date dateCreneau) {
		this.datecreneau = dateCreneau;
	}
	public Date getHeureCreneau() {
		return heurecreneau;
	}
	public void setHeureCreneau(Date heureCreneau) {
		this.heurecreneau = heureCreneau;
	}
	public Date getDuree() {
		return duree;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}


}
