/**
 * BoVoyagesService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.gtm.bovoyages.service;

public interface BoVoyagesService extends java.rmi.Remote {
    public fr.gtm.bovoyages.service.Voyageur getVoyageur() throws java.rmi.RemoteException;
    public fr.gtm.bovoyages.service.DatesVoyages[] getAllDatesVoyages() throws java.rmi.RemoteException;
    public fr.gtm.bovoyages.service.DestinationDTO[] getAllDestinations() throws java.rmi.RemoteException;
    public fr.gtm.bovoyages.service.DestinationDTO[] getAllDestinationsDatesPromotion() throws java.rmi.RemoteException;
    public fr.gtm.bovoyages.service.VoyageDTO creationVoyage(fr.gtm.bovoyages.service.VoyageDTO arg0) throws java.rmi.RemoteException;
}
