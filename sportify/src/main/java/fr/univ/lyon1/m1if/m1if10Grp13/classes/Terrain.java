package fr.univ.lyon1.m1if.m1if10Grp13.classes;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.LazyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "terrain")
public class Terrain {
	@Id
	@Column(name = "terrainid")
	private Long terrainId;
	private boolean dispo;

	public Terrain(Long terrainId, boolean dispo) {
		this.terrainId = terrainId;
		this.dispo = dispo;
	}

	public Terrain() {

	}

	public Long getTerrainId() {
		return terrainId;
	}
	public void setTerrainId(Long terrainId) {
		this.terrainId = terrainId;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

}
