/**
 * BoVoyagesServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.gtm.bovoyages.service;

public class BoVoyagesServiceServiceLocator extends org.apache.axis.client.Service implements fr.gtm.bovoyages.service.BoVoyagesServiceService {

    public BoVoyagesServiceServiceLocator() {
    }


    public BoVoyagesServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BoVoyagesServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BoVoyagesServicePort
    private java.lang.String BoVoyagesServicePort_address = "http://localhost:9080/bovoyages3/BoVoyagesService";

    public java.lang.String getBoVoyagesServicePortAddress() {
        return BoVoyagesServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BoVoyagesServicePortWSDDServiceName = "BoVoyagesServicePort";

    public java.lang.String getBoVoyagesServicePortWSDDServiceName() {
        return BoVoyagesServicePortWSDDServiceName;
    }

    public void setBoVoyagesServicePortWSDDServiceName(java.lang.String name) {
        BoVoyagesServicePortWSDDServiceName = name;
    }

    public fr.gtm.bovoyages.service.BoVoyagesService getBoVoyagesServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BoVoyagesServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBoVoyagesServicePort(endpoint);
    }

    public fr.gtm.bovoyages.service.BoVoyagesService getBoVoyagesServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.gtm.bovoyages.service.BoVoyagesServiceServiceSoapBindingStub _stub = new fr.gtm.bovoyages.service.BoVoyagesServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBoVoyagesServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBoVoyagesServicePortEndpointAddress(java.lang.String address) {
        BoVoyagesServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.gtm.bovoyages.service.BoVoyagesService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.gtm.bovoyages.service.BoVoyagesServiceServiceSoapBindingStub _stub = new fr.gtm.bovoyages.service.BoVoyagesServiceServiceSoapBindingStub(new java.net.URL(BoVoyagesServicePort_address), this);
                _stub.setPortName(getBoVoyagesServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BoVoyagesServicePort".equals(inputPortName)) {
            return getBoVoyagesServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "BoVoyagesServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "BoVoyagesServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BoVoyagesServicePort".equals(portName)) {
            setBoVoyagesServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
