/**
 * PfService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public interface PfService extends java.rmi.Remote {
    public void processRepaymentFinalization() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void processDefaultPayment() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public com.leadway.pf.service.ws.PfScheduleData[] calculateAmortization(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void initiateDDRequest() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void processRepayments() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void initiateRepaymentScheduleRequest() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void registerDepositOnPolicy(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public com.leadway.pf.service.ws.PfData registerNewPolicy(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public void registerDirectDebitPayment(com.leadway.pf.service.ws.PaymentData arg0) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
    public com.leadway.pf.service.ws.PfData quotePremiumFinancing(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException;
}
