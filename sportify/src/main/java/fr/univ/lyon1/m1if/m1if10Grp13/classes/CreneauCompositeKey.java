package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.io.Serializable;
import java.util.Date;

public class CreneauCompositeKey implements Serializable{
	private Date datecreneau;
	private Date heurecreneau;
	public CreneauCompositeKey(Date dateCreneau, Date heureCreneau) {
		this.datecreneau = dateCreneau;
		this.heurecreneau = heureCreneau;
	}
	private CreneauCompositeKey() {
		
	}

}
