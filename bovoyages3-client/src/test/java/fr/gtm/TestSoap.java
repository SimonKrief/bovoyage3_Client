package fr.gtm;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import fr.gtm.bo.DatesVoyages;
import fr.gtm.bo.Destination;
import fr.gtm.bo.Voyage;
import fr.gtm.bo.Voyageur;
import fr.gtm.bovoyages.service.BoVoyagesService;
import fr.gtm.bovoyages.service.BoVoyagesServiceServiceLocator;
import fr.gtm.bovoyages.service.DestinationDTO;
import fr.gtm.bovoyages.service.VoyageDTO;

public class TestSoap {
	
	

	@Test
	public void testGetDestinations() throws ServiceException, RemoteException {
		BoVoyagesService service = new BoVoyagesServiceServiceLocator().getBoVoyagesServicePort();
		DestinationDTO[] d = service.getAllDestinations();
		assertFalse(d.length==0);
	}

	@Test
	public void testGetDatesVoyages() throws ServiceException, RemoteException {
		BoVoyagesService service = new BoVoyagesServiceServiceLocator().getBoVoyagesServicePort();
		fr.gtm.bovoyages.service.DatesVoyages[] d = service.getAllDatesVoyages();
		assertFalse(d.length==0);
	}
	
	@Test
	public void testGetDatesVoyagesPromotion() throws ServiceException, RemoteException {
		BoVoyagesService service = new BoVoyagesServiceServiceLocator().getBoVoyagesServicePort();
		fr.gtm.bovoyages.service.DestinationDTO[] d = service.getAllDestinationsDatesPromotion();
		assertFalse(d.length==0);
		assertTrue(d.length==1);
	}
	
	@Test
	public void testCreationVoyage() throws ServiceException, RemoteException {
		BoVoyagesService service = new BoVoyagesServiceServiceLocator().getBoVoyagesServicePort();
		fr.gtm.bovoyages.service.VoyageDTO voyage = new fr.gtm.bovoyages.service.VoyageDTO();
		voyage.setRegion("France");
		voyage.setDescriptif("Meilleur Pays");
		voyage.setFkClient(1);
		fr.gtm.bovoyages.service.Voyageur voyageur = new fr.gtm.bovoyages.service.Voyageur();
		voyageur.setCivilite("M");
		voyageur.setNom("Dupont");
		voyageur.setPrenom("Jean");
		List<fr.gtm.bovoyages.service.Voyageur> voyageurs = new ArrayList<fr.gtm.bovoyages.service.Voyageur>();
		voyageurs.add(voyageur);
		fr.gtm.bovoyages.service.Voyageur[] voyageursTab = new fr.gtm.bovoyages.service.Voyageur[voyageurs.size()];
		voyageursTab[0] = voyageur;
		voyage.setParticipants(voyageursTab);
		fr.gtm.bovoyages.service.VoyageDTO v = service.creationVoyage(voyage);
		assertEquals("test 1", "France", v.getRegion());
	}
	

}