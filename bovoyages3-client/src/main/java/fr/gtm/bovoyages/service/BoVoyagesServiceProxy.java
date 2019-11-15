package fr.gtm.bovoyages.service;

public class BoVoyagesServiceProxy implements fr.gtm.bovoyages.service.BoVoyagesService {
  private String _endpoint = null;
  private fr.gtm.bovoyages.service.BoVoyagesService boVoyagesService = null;
  
  public BoVoyagesServiceProxy() {
    _initBoVoyagesServiceProxy();
  }
  
  public BoVoyagesServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBoVoyagesServiceProxy();
  }
  
  private void _initBoVoyagesServiceProxy() {
    try {
      boVoyagesService = (new fr.gtm.bovoyages.service.BoVoyagesServiceServiceLocator()).getBoVoyagesServicePort();
      if (boVoyagesService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)boVoyagesService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)boVoyagesService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (boVoyagesService != null)
      ((javax.xml.rpc.Stub)boVoyagesService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.gtm.bovoyages.service.BoVoyagesService getBoVoyagesService() {
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService;
  }
  
  public fr.gtm.bovoyages.service.DatesVoyages[] getAllDatesVoyages() throws java.rmi.RemoteException{
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService.getAllDatesVoyages();
  }
  
  public fr.gtm.bovoyages.service.DestinationDTO[] getAllDestinations() throws java.rmi.RemoteException{
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService.getAllDestinations();
  }
  
  public fr.gtm.bovoyages.service.DestinationDTO[] getAllDestinationsDatesPromotion() throws java.rmi.RemoteException{
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService.getAllDestinationsDatesPromotion();
  }
  
  public fr.gtm.bovoyages.service.VoyageDTO creationVoyage(fr.gtm.bovoyages.service.VoyageDTO arg0) throws java.rmi.RemoteException{
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService.creationVoyage(arg0);
  }
  
  public fr.gtm.bovoyages.service.Voyageur getVoyageur() throws java.rmi.RemoteException{
    if (boVoyagesService == null)
      _initBoVoyagesServiceProxy();
    return boVoyagesService.getVoyageur();
  }
  
  
}