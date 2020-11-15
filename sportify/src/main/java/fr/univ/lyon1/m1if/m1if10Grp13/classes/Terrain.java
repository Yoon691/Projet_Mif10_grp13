package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Terrain {
	@Id
	private int terrainId;
	private boolean dispo;
	public Terrain(int terrainId, boolean dispo) {
		this.terrainId = terrainId;
		this.dispo = dispo;
	}
	public int getTerrainId() {
		return terrainId;
	}
	public void setTerrainId(int terrainId) {
		this.terrainId = terrainId;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
}
