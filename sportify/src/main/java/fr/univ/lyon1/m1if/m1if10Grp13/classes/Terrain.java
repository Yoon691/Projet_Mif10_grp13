package fr.univ.lyon1.m1if.m1if10Grp13.classes;

//import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "terrain")
public class Terrain {
	@Id
	@Column(name = "terrainid")
	private int terrainId;
	private boolean dispo;
	public Terrain(int terrainId, boolean dispo) {
		this.terrainId = terrainId;
		this.dispo = dispo;
	}

	public Terrain() {

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
