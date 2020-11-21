package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.io.Serializable;

public class ReservationTerrainCompositeKey implements Serializable {
	private Terrain terrain;
	private Creneau creneau;
	public ReservationTerrainCompositeKey(Terrain terrain, Creneau creneau) {
		this.terrain = terrain;
		this.creneau = creneau;
	}
	
}	
