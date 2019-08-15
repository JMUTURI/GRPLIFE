/**
 * PfServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class PfServiceServiceLocator extends org.apache.axis.client.Service implements com.leadway.pf.service.ws.PfServiceService {

    public PfServiceServiceLocator() {
    }


    public PfServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PfServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PfServicePort
    private java.lang.String PfServicePort_address = "http://10.176.18.56:8086/PfServiceService/PfService";

    public java.lang.String getPfServicePortAddress() {
        return PfServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PfServicePortWSDDServiceName = "PfServicePort";

    public java.lang.String getPfServicePortWSDDServiceName() {
        return PfServicePortWSDDServiceName;
    }

    public void setPfServicePortWSDDServiceName(java.lang.String name) {
        PfServicePortWSDDServiceName = name;
    }

    public com.leadway.pf.service.ws.PfService getPfServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PfServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPfServicePort(endpoint);
    }

    public com.leadway.pf.service.ws.PfService getPfServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.leadway.pf.service.ws.PfServicePortBindingStub _stub = new com.leadway.pf.service.ws.PfServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPfServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPfServicePortEndpointAddress(java.lang.String address) {
        PfServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.leadway.pf.service.ws.PfService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.leadway.pf.service.ws.PfServicePortBindingStub _stub = new com.leadway.pf.service.ws.PfServicePortBindingStub(new java.net.URL(PfServicePort_address), this);
                _stub.setPortName(getPfServicePortWSDDServiceName());
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
        if ("PfServicePort".equals(inputPortName)) {
            return getPfServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "PfServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "PfServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PfServicePort".equals(portName)) {
            setPfServicePortEndpointAddress(address);
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
