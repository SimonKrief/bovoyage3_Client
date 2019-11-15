package fr.gtm;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.gtm.bo.Destination;
import fr.gtm.bo.Voyage;
import fr.gtm.bo.Voyageur;
import fr.gtm.bo.ClientDTO;
import fr.gtm.bo.DatesVoyages;


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
	
//	@org.junit.Test
//	public void test_Ajout_Voyageur_A_Voyage() {
//		String uri = WEB_APPLI+"/destinations/addVoyageurAVoyage/1";
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(uri);
//		Voyageur[] voyageurs = new Voyageur[1];
//		Voyageur voyageur = new Voyageur();
//		voyageur.setCivilite("M");
//		voyageur.setNom("Dupuit");
//		voyageur.setPrenom("Robert");
//		voyageurs[0] = voyageur; 
//		Voyageur[] voyageursReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageurs, MediaType.APPLICATION_JSON), Voyageur[].class);
//		assertEquals("test 1", "Dupuit", voyageursReponse[1].getNom());
//	}
	
	@org.junit.Test
	public void test_allDatesVoyagesValidesDeDestination() {
		String uri = WEB_APPLI+"/destinations/allDestinationsValides";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Destination[] destinations = target.request("application/json;charset=utf-8").get(Destination[].class);
		uri = WEB_APPLI+"/destinations/allDatesVoyagesValidesDeDestination/1";
		target = client.target(uri);
//		DatesVoyages[] datesVoyages = new DatesVoyages[3] ;
		DatesVoyages[] datesVoyages = target.request(MediaType.APPLICATION_JSON).get(DatesVoyages[].class);
		assertTrue("test 1", datesVoyages.length > 0);
		assertTrue("test 2", datesVoyages.length == 3);
	}	
	
	@org.junit.Test
	public void test_commande_Voyage_en_base() {
		String uri = WEB_APPLI+"/destinations/commandeVoyageEnregistre/1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Voyage voyage = new Voyage();
		voyage.setRegion("France");
		voyage.setDescriptif("Ze pays");
		voyage.setFkClient(1);
		Voyageur voyageur = new Voyageur();
		voyageur.setCivilite("M");
		voyageur.setNom("Durand");
		voyageur.setPrenom("Michel");
		List<Voyageur> voyageurs = new ArrayList<Voyageur>();
		voyageurs.add(voyageur);
		voyage.setParticipants(voyageurs);
		voyage.setFk_dates_voyages(3);
		boolean bool = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), boolean.class);
		assertTrue("test 1", bool);
	}
	
	@org.junit.Test
	public void test_commande_Voyage_creer_par_client() {
		String uri = WEB_APPLI+"/destinations/commandeVoyage";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Voyage voyage = new Voyage();
		voyage.setRegion("France");
		voyage.setDescriptif("Ze pays");
		voyage.setFkClient(1);
		Voyageur voyageur = new Voyageur();
		voyageur.setCivilite("M");
		voyageur.setNom("Durand");
		voyageur.setPrenom("Michel");
		List<Voyageur> voyageurs = new ArrayList<Voyageur>();
		voyageurs.add(voyageur);
		voyage.setParticipants(voyageurs);
		voyage.setFk_dates_voyages(3);
		voyage.setFkClient(1);
		boolean bool = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), boolean.class);
		assertTrue("test 1", bool);
	}
	
	@org.junit.Test
	public void test_MAJ_Voyageur_De_Voyage() {
		String uri = WEB_APPLI+"/destinations/updateVoyageurDeVoyage/1";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Voyageur voyageur = new Voyageur();
		voyageur.setId(4);
		voyageur.setCivilite("M");
		voyageur.setNom("Dupuit");
		voyageur.setPrenom("Robert");
//		LocalDate date = LocalDate.of(2000, Month.DECEMBER, 12);
//		voyageur.setDateNaissance(date);
		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);
		voyageur.setNom("Dupond");
		voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);
		assertEquals("test 1", "Dupond", voyageReponse.getParticipants().get(1).getNom());
		voyageur.setNom("Dupuit");
		target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);
	}

}
