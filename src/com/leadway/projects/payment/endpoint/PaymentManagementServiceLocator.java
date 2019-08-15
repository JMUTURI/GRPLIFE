/**
 * PaymentManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PaymentManagementServiceLocator extends org.apache.axis.client.Service implements com.leadway.projects.payment.endpoint.PaymentManagementService {

    public PaymentManagementServiceLocator() {
    }


    public PaymentManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PaymentManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PaymentManagementPort
    private java.lang.String PaymentManagementPort_address = "http://10.176.18.56:8085/PaymentManagementService/PaymentManagement";

    public java.lang.String getPaymentManagementPortAddress() {
        return PaymentManagementPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PaymentManagementPortWSDDServiceName = "PaymentManagementPort";

    public java.lang.String getPaymentManagementPortWSDDServiceName() {
        return PaymentManagementPortWSDDServiceName;
    }

    public void setPaymentManagementPortWSDDServiceName(java.lang.String name) {
        PaymentManagementPortWSDDServiceName = name;
    }

    public com.leadway.projects.payment.endpoint.PaymentManagement getPaymentManagementPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaymentManagementPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaymentManagementPort(endpoint);
    }

    public com.leadway.projects.payment.endpoint.PaymentManagement getPaymentManagementPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.leadway.projects.payment.endpoint.PaymentManagementPortBindingStub _stub = new com.leadway.projects.payment.endpoint.PaymentManagementPortBindingStub(portAddress, this);
            _stub.setPortName(getPaymentManagementPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaymentManagementPortEndpointAddress(java.lang.String address) {
        PaymentManagementPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.leadway.projects.payment.endpoint.PaymentManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                com.leadway.projects.payment.endpoint.PaymentManagementPortBindingStub _stub = new com.leadway.projects.payment.endpoint.PaymentManagementPortBindingStub(new java.net.URL(PaymentManagementPort_address), this);
                _stub.setPortName(getPaymentManagementPortWSDDServiceName());
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
        if ("PaymentManagementPort".equals(inputPortName)) {
            return getPaymentManagementPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "PaymentManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "PaymentManagementPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PaymentManagementPort".equals(portName)) {
            setPaymentManagementPortEndpointAddress(address);
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
