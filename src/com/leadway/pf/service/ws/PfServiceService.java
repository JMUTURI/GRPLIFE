/**
 * PfServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public interface PfServiceService extends javax.xml.rpc.Service {
    public java.lang.String getPfServicePortAddress();

    public com.leadway.pf.service.ws.PfService getPfServicePort() throws javax.xml.rpc.ServiceException;

    public com.leadway.pf.service.ws.PfService getPfServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
