package fr.gtm.bo;

import java.util.ArrayList;
import java.util.List;


public class Destination {

	private long id;
	private String region;
	private String description;
	private int deleted;
	private List<DatesVoyages> dates =new ArrayList<DatesVoyages>();
	private List<Image> images=new ArrayList<Image>();

	public Destination() {
	}

	public Destination(String region, String description) {
		this.region = region;
		this.description = description;
	}
	
	

	public Destination(Destination destination) {
		this.region = destination.getRegion();
		this.description = destination.getDescription();
		this.deleted = destination.getDeleted();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public List<DatesVoyages> getDates() {
		return dates;
	}

	public void setDates(List<DatesVoyages> dates) {
		this.dates = dates;
	}
	
	public List<Image> getImage() {
		return images;
	}

	public void setImage(List<Image> image) {
		this.images = image;
	}
	
}
