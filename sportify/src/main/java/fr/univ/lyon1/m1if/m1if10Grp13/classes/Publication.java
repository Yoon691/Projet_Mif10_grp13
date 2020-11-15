package fr.univ.lyon1.m1if.m1if10Grp13.classes;

public class Publication {
	private String contenu;
	private String publisher;
	
	public Publication(String contenu, String publisher) {
		this.contenu = contenu;
		this.publisher = publisher;
	}
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
