package fr.gtm;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import fr.gtm.bo.Destination;
import fr.gtm.bovoyages.service.BoVoyagesService;
import fr.gtm.bovoyages.service.BoVoyagesServiceServiceLocator;
import fr.gtm.bovoyages.service.DestinationDTO;

public class TestSOAP {
	
	

	@Test
	public void test() throws ServiceException, RemoteException {
		BoVoyagesService service = new BoVoyagesServiceServiceLocator().getBoVoyagesServicePort();
		DestinationDTO[] d = service.getAllDestinations();
		assertFalse(d.length==0);
		assertFalse(d.length==0);

	}

}
