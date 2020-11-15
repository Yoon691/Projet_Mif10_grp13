package fr.univ.lyon1.m1if.m1if10Grp13.classes;

public class ReservationTerrain {
	private int terrainId;
	private int creneauId;
	private int clubId;
	private String emailInscrit;
	
	public ReservationTerrain(int terrainId, int creneauId, int clubId, String emailInscrit) {
		this.terrainId = terrainId;
		this.creneauId = creneauId;
		this.clubId = clubId;
		this.emailInscrit = emailInscrit;
	}

	public int getTerrainId() {
		return terrainId;
	}

	public void setTerrainId(int terrainId) {
		this.terrainId = terrainId;
	}

	public int getCreneauId() {
		return creneauId;
	}

	public void setCreneauId(int creneauId) {
		this.creneauId = creneauId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getEmailInscrit() {
		return emailInscrit;
	}

	public void setEmailInscrit(String emailInscrit) {
		this.emailInscrit = emailInscrit;
	}
	
	
	
	
	
}
