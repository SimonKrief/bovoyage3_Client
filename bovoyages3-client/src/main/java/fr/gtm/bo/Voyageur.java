package fr.gtm.bo;

import java.util.Date;

public class Voyageur {
	
	private long id;
	private String civilite;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	
	public Voyageur() {}

	public Voyageur(String civilite, String prenom, String nom, Date dateNaissance) {
		super();
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
