package fr.gtm;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import fr.gtm.bo.DatesVoyages;
import fr.gtm.bo.Destination;
import fr.gtm.bovoyages.service.BoVoyagesService;
import fr.gtm.bovoyages.service.BoVoyagesServiceServiceLocator;
import fr.gtm.bovoyages.service.DestinationDTO;

public class TestSOAP {
	
	

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
	

}
