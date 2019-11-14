package fr.gtm.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class DatesVoyages implements Serializable{

	private long id;
//	@JsonFormat(pattern="yyyy-MM-ddTHH:mm:ss.SSSZ")	
	private Date dateDepart;
//	@JsonFormat(pattern="yyyy-MM-ddTHH:mm:ss.SSSZ")
	private Date dateRetour;
	private float prixHT;
	private int deleted;
	private int nbPlaces;
	private long fkDestination;
	
	public DatesVoyages() {}

	public DatesVoyages(Date dateDepart, Date dateRetour, float prixHT, int deleted, int nbPlaces,
			long fkDestination) {
		super();
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prixHT = prixHT;
		this.deleted = deleted;
		this.nbPlaces = nbPlaces;
		this.fkDestination = fkDestination;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public long getFkDestination() {
		return fkDestination;
	}

	public void setFkDestination(long fkDestination) {
		this.fkDestination = fkDestination;
	}

}
