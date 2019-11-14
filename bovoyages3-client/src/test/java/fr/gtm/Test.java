package fr.gtm;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.gtm.bo.Destination;
import fr.gtm.bo.Voyage;
import fr.gtm.bo.Voyageur;
import fr.gtm.bo.ClientDTO;


public class Test {

	private static final String WEB_APPLI = "http://localhost:9080/bovoyages3/rest";
	
	@org.junit.Test
	public void test_all() {
		String uri = WEB_APPLI+"/destinations/all";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Destination[] destinations = target.request("application/json;charset=utf-8").get(Destination[].class);
		assertTrue("test 1", destinations.length > 0);
		assertEquals("test 2", "Birmanie", destinations[0].getRegion());
	}
	
	@org.junit.Test
	public void test_allRegions() {
		String uri = WEB_APPLI+"/destinations/allRegions";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		String[] regions = target.request("application/json;charset=utf-8").get(String[].class);
		assertTrue("test 1", regions.length > 0);
		assertEquals("test 2", "Birmanie", regions[0]);
		assertEquals("test 3", "Canada", regions[1]);
	}
	
	@org.junit.Test
	public void test_allDestinationsValides() {
		String uri = WEB_APPLI+"/destinations/allDestinationsValides";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Destination[] destinations = target.request("application/json;charset=utf-8").get(Destination[].class);
		boolean estAbsent = true;
		for(Destination d : destinations) {
			if(d.getRegion().equals("Haïti")) {
				estAbsent = false;
			}
		}
		assertTrue(estAbsent);
	}

//	@org.junit.Test
//	public void test_Creation_Client() {
//		String uri = WEB_APPLI+"/destinations/addClient";
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(uri);
//		ClientDTO clientDTO = new ClientDTO();
//		clientDTO.setNom("Perrin");
//		ClientDTO clientReponse = target.request("application/json;charset=utf-8").post(Entity.entity(clientDTO, MediaType.APPLICATION_JSON), ClientDTO.class);
//		assertEquals("test 1", "Perrin", clientReponse.getNom());
//	}
	
//	@org.junit.Test
//	public void test_Creation_Voyage() {
//		String uri = WEB_APPLI+"/destinations/addVoyage";
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(uri);
//		Voyage voyage = new Voyage();
//		voyage.setRegion("France");
//		voyage.setDescriptif("Le plus beau pays du monde");
//		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), Voyage.class);
//		assertEquals("test 1", "France", voyageReponse.getRegion());
//	}

//	@org.junit.Test
//	public void test_MAJ_Voyage() {
//		String uri = WEB_APPLI+"/destinations/updateVoyage";
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(uri);
//		Voyage voyage = new Voyage();
//		voyage.setId(1);
//		voyage.setRegion("France");
//		voyage.setDescriptif("Le pays du fromage");
//		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), Voyage.class);
//		assertEquals("test 1", "Le pays du fromage", voyageReponse.getDescriptif());
//	}
	
	@org.junit.Test
	public void test_Ajout_Client_Voyage() {
		String uri = WEB_APPLI+"/destinations/addClientVoyage/1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(1);
		clientDTO.setNom("Perrin");
		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(clientDTO, MediaType.APPLICATION_JSON), Voyage.class);
		assertEquals("test 1", 1, voyageReponse.getFkClient());
	}
	
	@org.junit.Test
	public void test_Ajout_Voyageur() {
		String uri = WEB_APPLI+"/destinations/addVoyageurAVoyage/1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Voyageur[] voyageurs = new Voyageur[1];
		Voyageur voyageur = new Voyageur();
		voyageur.setCivilite("M");
		voyageur.setNom("Dupond");
		voyageur.setPrenom("Charles");
		voyageurs[0] = voyageur; 
		Voyageur[] voyageursReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageurs, MediaType.APPLICATION_JSON), Voyageur[].class);
		assertEquals("test 1", "Dupond", voyageursReponse[0].getNom());
	}
	
//	@org.junit.Test
//	public void test_Ajout_commande_Voyage() {
//		String uri = WEB_APPLI+"/destinations/commandeVoyage/1";
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(uri);
//		ClientDTO clientDTO = new ClientDTO();
//		clientDTO.setId(1);
//		clientDTO.setNom("Perrin");
//		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(clientDTO, MediaType.APPLICATION_JSON), Voyage.class);
//		assertEquals("test 1", 1, voyageReponse.getFkClient());
//	}

}
