package fr.gtm.bo;

import java.util.ArrayList;
import java.util.List;

public class Voyage {

	private long id;
	private String region;
	private String descriptif;
	private long fkClient;
	private List<Voyageur> participants=new ArrayList<Voyageur>();
	
	public Voyage() {}
	
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


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	public long getFkClient() {
		return fkClient;
	}


	public void setFkClient(long fkClient) {
		this.fkClient = fkClient;
	}


	public List<Voyageur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Voyageur> participants) {
		this.participants = participants;
	}

}
