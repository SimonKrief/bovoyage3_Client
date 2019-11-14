package fr.gtm;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.gtm.bo.DatesVoyages;
import fr.gtm.bo.Destination;

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

}
