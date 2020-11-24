package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "creneau")
@IdClass(CreneauCompositeKey.class)
public class Creneau {
	@Id
	private Date datecreneau;
	@Id
	@Type(type = "timestamp")
	private Timestamp heurecreneau;
	@Type(type = "timestamp")
	private Timestamp duree;

	public Creneau() {

	}

	public Creneau(Date dateCreneau, Timestamp heureCreneau, Timestamp duree) {
		this.datecreneau = dateCreneau;
		this.heurecreneau = heureCreneau;
		this.duree = duree;
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

	public void setHeureCreneau(Timestamp heureCreneau) {
		this.heurecreneau = heureCreneau;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Timestamp duree) {
		this.duree = duree;
	}

}
